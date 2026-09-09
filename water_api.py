#!/usr/bin/env python
"""
乐校通预付费水表 API 模块

功能:
- CNN 验证码自动识别登录（自训练模型，99.39% 准确率）
- 水表余额/用水量查询
- 设备发现（按房间/楼层）
- Token 过期自动续登

用法:
    # 作为模块
    from water_api import LxtWater
    api = LxtWater("192xxxxxxxxx", "password")
    info = api.query_by_site("660000000001452669")
    print(info["balance"], info["volume"])

    # 命令行
    python water_api.py <手机号> <密码> <siteId>
"""

import base64
import hashlib
import io
import json
import os
import time

import numpy as np
import requests
from PIL import Image
from scipy import ndimage

# ============================================================
#  常量
# ============================================================
BASE_URL = "https://v3-prod-beta-app.lxt6.cn"
SIGN_KEY = "1FF75E512"

# ============================================================
#  协议工具
# ============================================================
def _md5(s):
    return hashlib.md5(s.encode()).hexdigest()


def _gen_ghost():
    """X-Ghost 反重放令牌"""
    ts = hex(int(time.time() * 1000))[2:]
    ls = ts.zfill(12) if len(ts) < 12 else ts
    total = sum(int(ls[i:i + 2], 16) for i in range(0, len(ls), 2))
    sc = format(total % 256, "02X")
    parts = [ls[i * 2:i * 2 + 2] for i in range(len(ls) // 2)]
    xr = int(parts[0], 16)
    for i in range(1, len(parts)):
        xr ^= int(parts[i], 16)
    return (sc + ls + format(xr, "02X")).lower()


def _headers():
    return {
        "X-Sid": "2021011300001",
        "X-Product-Ver": "4.3.9",
        "X-clientType": "1",
        "X-Ghost": _gen_ghost(),
        "User-Agent": "okhttp/3.12.1",
    }


# ============================================================
#  CNN 验证码识别
# ============================================================
CHAR_W, CHAR_H = 8, 12
_BLUE_THRESH = 50  # B > R+50 && B > G+50 → 去蓝线


def _remove_blue_line(img_rgb):
    """去除蓝色干扰线"""
    arr = np.array(img_rgb).astype(int)
    r, g, b = arr[:, :, 0], arr[:, :, 1], arr[:, :, 2]
    mask = (b > r + _BLUE_THRESH) & (b > g + _BLUE_THRESH)
    arr[mask] = [255, 255, 255]
    return Image.fromarray(arr.astype(np.uint8))


def _segment(img_bytes):
    """分割验证码为 5 个 12x8 字符图像，返回 list[ndarray] 或 None"""
    img = Image.open(io.BytesIO(img_bytes)).convert("RGB")
    img = _remove_blue_line(img).convert("L")
    arr = np.array(img)
    binary = (arr < 128).astype(np.uint8)

    # 去小噪点
    labeled, num = ndimage.label(binary)
    for i in range(1, num + 1):
        if np.sum(labeled == i) < 5:
            binary[labeled == i] = 0

    # 列投影找字符边界
    col_sum = np.sum(binary, axis=0)
    in_char = False
    char_ranges = []
    start = 0
    for x in range(len(col_sum)):
        if col_sum[x] >= 2 and not in_char:
            start = x
            in_char = True
        elif col_sum[x] < 2 and in_char:
            if x - start > 2:
                char_ranges.append((start, x))
            in_char = False
    if in_char and len(col_sum) - start > 2:
        char_ranges.append((start, len(col_sum)))

    # 合并太近的区域
    merged = []
    for r in char_ranges:
        if merged and r[0] - merged[-1][1] < 3:
            merged[-1] = (merged[-1][0], r[1])
        else:
            merged.append(r)

    if len(merged) != 5:
        return None

    # 提取并归一化
    h, w = binary.shape
    chars = []
    for x0, x1 in merged:
        cs = binary[:, x0:x1]
        rs = np.sum(cs, axis=1)
        rows = np.where(rs > 0)[0]
        if len(rows) == 0:
            return None
        y0, y1 = max(0, rows[0] - 1), min(h, rows[-1] + 2)
        x0, x1 = max(0, x0 - 1), min(w, x1 + 1)
        pil = Image.fromarray((1 - binary[y0:y1, x0:x1]) * 255)
        pil = pil.resize((CHAR_W, CHAR_H), Image.LANCZOS)
        chars.append((np.array(pil) > 128).astype(np.float32))

    return chars


def _load_cnn(model_path=None):
    """加载 CNN 模型，返回 model 或 None"""
    try:
        import torch
        import torch.nn as nn

        class CaptchaCNN(nn.Module):
            def __init__(self):
                super().__init__()
                self.features = nn.Sequential(
                    nn.Conv2d(1, 16, 3, padding=1), nn.BatchNorm2d(16), nn.ReLU(), nn.MaxPool2d(2),
                    nn.Conv2d(16, 32, 3, padding=1), nn.BatchNorm2d(32), nn.ReLU(), nn.MaxPool2d(2),
                )
                self.classifier = nn.Sequential(
                    nn.Flatten(), nn.Linear(32 * 3 * 2, 64), nn.ReLU(), nn.Dropout(0.3),
                    nn.Linear(64, 32), nn.ReLU(), nn.Linear(32, 10),
                )

            def forward(self, x):
                return self.classifier(self.features(x))

        if model_path is None:
            model_path = os.path.join(os.path.dirname(os.path.abspath(__file__)), "captcha_cnn_best.pth")
        model = CaptchaCNN()
        model.load_state_dict(torch.load(model_path, map_location="cpu"))
        model.eval()
        return model
    except Exception:
        return None


def _predict_captcha(model, img_bytes):
    """识别验证码，返回 (str, float) 或 (None, 0)"""
    import torch

    chars = _segment(img_bytes)
    if chars is None:
        return None, 0

    inp = torch.from_numpy(np.array(chars).reshape(5, 1, CHAR_H, CHAR_W))
    with torch.no_grad():
        probs = torch.softmax(model(inp), dim=1)
        preds = probs.argmax(1).numpy()
        conf = float(probs.max(1).values.numpy().mean())

    return "".join(str(d) for d in preds), conf


# ============================================================
#  API 类
# ============================================================
class LxtWater:
    """乐校通预付费水表查询客户端"""

    def __init__(self, phone, password, school_id="80790",
                 investor_id="600000000000000047", model_path=None):
        """
        Args:
            phone: 手机号
            password: 密码（明文）
            school_id: 学校ID
            investor_id: 运营商ID
            model_path: CNN模型路径（默认同目录 captcha_cnn_best.pth）
        """
        self.phone = phone
        self.password = password
        self.school_id = school_id
        self.investor_id = investor_id
        self.token = None
        self._session = requests.Session()
        self._session.trust_env = False
        self._cnn = _load_cnn(model_path)

    def _sign(self, s):
        return _md5(SIGN_KEY + s)

    def _post(self, path, body):
        bs = json.dumps(body, separators=(",", ":"))
        return self._session.post(
            f"{BASE_URL}{path}", data=bs,
            headers={**_headers(), "X-Sign": self._sign(bs),
                     "Cookie": self.token, "Content-Type": "application/json"},
            timeout=15,
        ).json()

    def _get(self, path, params):
        qs = "&".join(f"{k}={v}" for k, v in sorted(params.items()))
        return self._session.get(
            f"{BASE_URL}{path}", params=params,
            headers={**_headers(), "X-Sign": self._sign(qs), "Cookie": self.token},
            timeout=15,
        ).json()

    # ----------------------------------------------------------
    #  登录
    # ----------------------------------------------------------
    def login(self):
        """自动验证码识别登录，返回 True/False"""
        if self._cnn is None:
            raise RuntimeError("CNN 模型加载失败，请检查 captcha_cnn_best.pth")

        for attempt in range(15):
            try:
                sig = self._sign(f"account={self.phone}")
                r = self._session.get(
                    f"{BASE_URL}/user/authentication/getCode",
                    params={"account": self.phone},
                    headers={**_headers(), "X-Sign": sig}, timeout=15,
                ).json()

                if r.get("Code") != 0:
                    time.sleep(1)
                    continue

                img_b64 = r["Data"].split(",")[1] if "," in r["Data"] else r["Data"]
                img_bytes = base64.b64decode(img_b64)
                captcha, conf = _predict_captcha(self._cnn, img_bytes)

                if captcha is None:
                    time.sleep(0.5)
                    continue

                body = json.dumps({
                    "studentMobile": self.phone,
                    "loginPassword": self.password,
                    "code": captcha,
                }, separators=(",", ":"))
                enc = base64.b64encode(body.encode()).decode()
                payload = json.dumps({"data": enc}, separators=(",", ":"))

                resp = self._session.post(
                    f"{BASE_URL}/user/login/userLoginV2WithEncrypt",
                    headers={**_headers(), "Content-Type": "application/json",
                             "X-Sign": self._sign(payload)},
                    data=payload, timeout=15,
                )

                token = resp.headers.get("TokenInfo") or resp.headers.get("tokenInfo")
                if not token:
                    for c in resp.cookies:
                        if c.name == "tokenInfo":
                            token = c.value
                            break

                if token:
                    if not token.startswith("tokenInfo="):
                        token = "tokenInfo=" + token
                    self.token = token
                    return True

            except Exception:
                pass

            time.sleep(1)

        return False

    # ----------------------------------------------------------
    #  查询
    # ----------------------------------------------------------
    def query_by_site(self, site_id, site_flag=0):
        """
        按 siteId 查询水表余额

        Args:
            site_id: 房间/设备 siteId
            site_flag: 站点标记（默认0）

        Returns:
            dict: {balance, gift, volume, mac, mid} 或 None
                  balance: 可用余额（元）
                  gift: 赠送金（元）
                  volume: 累计用水量
                  mac: 设备MAC
                  mid: 设备machineId
        """
        if not self.token:
            if not self.login():
                return None

        # 获取设备
        rd = self._post("/mgapp/machine/getMachineByLocation",
                        {"siteId": site_id, "siteFlag": site_flag, "typeId": 18})
        devs = rd.get("Data") or []
        if not devs:
            if rd.get("Code") == -44:
                # token 过期，续登
                if self.login():
                    rd = self._post("/mgapp/machine/getMachineByLocation",
                                    {"siteId": site_id, "siteFlag": site_flag, "typeId": 18})
                    devs = rd.get("Data") or []
            if not devs:
                return None

        mid = devs[0]["machineId"]
        mac = devs[0].get("deviceMac", "")

        # 查余额
        params = {
            "investorId": self.investor_id,
            "schoolId": self.school_id,
            "walletKey": mid,
        }
        qs = "&".join(f"{k}={v}" for k, v in sorted(params.items()))
        r = self._session.get(
            f"{BASE_URL}/paymentV1/app/wallet/find",
            params=params,
            headers={**_headers(), "X-Sign": self._sign(qs), "Cookie": self.token},
            timeout=10,
        ).json()

        if r.get("Code") == 0 and r.get("Data"):
            wd = r["Data"]
            return {
                "balance": wd.get("canUseMoney", 0) / 100,
                "gift": wd.get("appendMoney", 0) / 100,
                "volume": wd.get("waterVolume", 0),
                "mac": mac,
                "mid": mid,
            }
        return None

    def query_by_machine(self, machine_id):
        """
        按 machineId 直接查余额（跳过设备发现）

        Args:
            machine_id: 设备 machineId

        Returns:
            dict: {balance, gift, volume} 或 None
        """
        if not self.token:
            if not self.login():
                return None

        params = {
            "investorId": self.investor_id,
            "schoolId": self.school_id,
            "walletKey": machine_id,
        }
        qs = "&".join(f"{k}={v}" for k, v in sorted(params.items()))
        r = self._session.get(
            f"{BASE_URL}/paymentV1/app/wallet/find",
            params=params,
            headers={**_headers(), "X-Sign": self._sign(qs), "Cookie": self.token},
            timeout=10,
        ).json()

        if r.get("Code") == 0 and r.get("Data"):
            wd = r["Data"]
            return {
                "balance": wd.get("canUseMoney", 0) / 100,
                "gift": wd.get("appendMoney", 0) / 100,
                "volume": wd.get("waterVolume", 0),
            }
        return None

    def query_rooms(self, rooms):
        """
        批量查询多个房间

        Args:
            rooms: dict {名称: siteId}

        Returns:
            dict {名称: {balance, gift, volume, mac, mid} 或 None}
        """
        results = {}
        for name, site_id in rooms.items():
            results[name] = self.query_by_site(site_id)
        return results

    # ----------------------------------------------------------
    #  自动发现
    # ----------------------------------------------------------
    def discover_water_devices(self, max_buildings=20, max_floors=10, max_rooms=20):
        """
        自动发现学校内所有预付费水表（typeId=18）

        流程: 学校区域树 → 楼栋 → 楼层 → 房间 → 查设备

        Args:
            max_buildings: 最多遍历几个楼栋
            max_floors: 每栋最多几个楼层
            max_rooms: 每层最多几个房间

        Returns:
            list[dict]: [{name, site_id, path, machine_id, mac}, ...]
        """
        if not self.token:
            if not self.login():
                return []

        # 获取学校顶层区域（楼栋列表）
        try:
            tree = self._get("/baseDict/site/getLowerAreas",
                             {"areaId": self.school_id}).get("Data", [])
        except Exception:
            return []

        devices = []

        def _walk(node, path="", depth=0, limit_rooms=max_rooms):
            name = node.get("name", "")
            children = node.get("childList", [])
            cur_path = f"{path}/{name}" if path else name

            if not children:
                # 叶子节点 = 楼层，查房间
                try:
                    rooms = self._get("/baseDict/site/getDormitoryOrPublicRoom",
                                      {"areaId": node["id"]}).get("Data", [])
                except Exception:
                    return

                for rm in rooms[:limit_rooms]:
                    try:
                        rd = self._post("/mgapp/machine/getMachineByLocation",
                                        {"siteId": rm["id"], "siteFlag": rm.get("siteFlag", 0),
                                         "typeId": 18})
                        for d in (rd.get("Data") or []):
                            devices.append({
                                "name": rm.get("name", ""),
                                "site_id": rm["id"],
                                "path": f"{cur_path}/{rm.get('name', '')}",
                                "machine_id": d["machineId"],
                                "mac": d.get("deviceMac", ""),
                            })
                    except Exception:
                        pass
            else:
                for c in children[:max_floors]:
                    _walk(c, cur_path, depth + 1, limit_rooms)

        for bld in tree[:max_buildings]:
            _walk(bld)

        return devices

    def discover_my_room(self, building, room_name,
                         max_buildings=20, max_floors=10):
        """
        自动发现自己宿舍的 siteId 和水表信息

        Args:
            building: 楼栋名关键词（如 "33"、"46"）
            room_name: 房间名关键词（如 "106"、"416"）

        Returns:
            dict: {name, site_id, path, machine_id, mac} 或 None
        """
        if not self.token:
            if not self.login():
                return None

        tree = self._get("/baseDict/site/getLowerAreas",
                         {"areaId": self.school_id}).get("Data", [])

        # 找到目标楼栋（可能在分类节点下）
        target_bld = None
        for cat in tree:
            if building in cat.get("name", ""):
                target_bld = cat
                break
            for bld in cat.get("childList", []):
                if building in bld.get("name", ""):
                    target_bld = bld
                    break
            if target_bld:
                break
        if not target_bld:
            return None

        # 遍历楼层找房间
        def _find(node, path=""):
            name = node.get("name", "")
            children = node.get("childList", [])
            cur_path = f"{path}/{name}" if path else name

            if not children:
                try:
                    rooms = self._get("/baseDict/site/getDormitoryOrPublicRoom",
                                      {"areaId": node["id"]}).get("Data", [])
                except Exception:
                    return None

                for rm in rooms:
                    if room_name in rm.get("name", ""):
                        try:
                            rd = self._post("/mgapp/machine/getMachineByLocation",
                                            {"siteId": rm["id"], "siteFlag": rm.get("siteFlag", 0),
                                             "typeId": 18})
                            devs = rd.get("Data") or []
                            if devs:
                                return {
                                    "name": rm.get("name", ""),
                                    "site_id": rm["id"],
                                    "path": f"{cur_path}/{rm.get('name', '')}",
                                    "machine_id": devs[0]["machineId"],
                                    "mac": devs[0].get("deviceMac", ""),
                                }
                        except Exception:
                            pass
                return None

            for c in children[:max_floors]:
                result = _find(c, cur_path)
                if result:
                    return result
            return None

        return _find(target_bld)


# ============================================================
#  CLI
# ============================================================
if __name__ == "__main__":
    import sys

    if len(sys.argv) < 3:
        print("用法:")
        print("  查询:   python water_api.py <手机号> <密码> [siteId]")
        print("  发现:   python water_api.py <手机号> <密码> discover [楼栋] [房间]")
        print()
        print("示例:")
        print("  python water_api.py 192xxxxxxxxx password 660000000001452669")
        print("  python water_api.py 192xxxxxxxxx password discover 33 106")
        print("  python water_api.py 192xxxxxxxxx password discover 46 416")
        sys.exit(1)

    phone = sys.argv[1]
    password = sys.argv[2]

    api = LxtWater(phone, password)
    print("正在登录...")
    if not api.login():
        print("登录失败")
        sys.exit(1)
    print("登录成功")

    if len(sys.argv) >= 4 and sys.argv[3] == "discover":
        # 自动发现模式
        building = sys.argv[4] if len(sys.argv) >= 5 else None
        room = sys.argv[5] if len(sys.argv) >= 6 else None

        if building and room:
            result = api.discover_my_room(building, room)
            if result:
                print(f"\n  房间: {result['name']}")
                print(f"  路径: {result['path']}")
                print(f"  siteId: {result['site_id']}")
                print(f"  machineId: {result['machine_id']}")
                print(f"  MAC: {result['mac']}")
                # 自动查询余额
                info = api.query_by_site(result['site_id'])
                if info:
                    print(f"  余额: {info['balance']:.2f} 元")
                    print(f"  赠送: {info['gift']:.2f} 元")
                    print(f"  用水: {info['volume']}")
            else:
                print(f"  未找到 {building}栋 {room} 的水表")
        else:
            print("发现所有水表中...")
            devices = api.discover_water_devices()
            print(f"\n找到 {len(devices)} 个水表:")
            for d in devices:
                print(f"  {d['path']}  siteId={d['site_id']}  mid={d['machine_id']}")

    elif len(sys.argv) >= 4:
        # 直接查询模式
        site_id = sys.argv[3]
        info = api.query_by_site(site_id)
        if info:
            print(f"  余额: {info['balance']:.2f} 元")
            print(f"  赠送: {info['gift']:.2f} 元")
            print(f"  用水: {info['volume']}")
        else:
            print("查询失败")
    else:
        # 交互模式
        while True:
            sid = input("\nsiteId (q退出): ").strip()
            if sid.lower() == "q":
                break
            info = api.query_by_site(sid)
            if info:
                print(f"  余额: {info['balance']:.2f} 元")
                print(f"  赠送: {info['gift']:.2f} 元")
                print(f"  用水: {info['volume']}")
            else:
                print("  查询失败")
