#!/usr/bin/env python3
"""
乐校通 BLE 水阀开阀脚本
基于逆向分析的 A5 协议 (NBDeviceCommand)

协议来源: client.android.yixiaotong.v3.comman.NBDeviceCommand
BLE层: com.lxt.bluetoothsdk.bluetooth.ConnectBLEDevice (UUID自动发现)
"""

import asyncio
import hashlib
import json
import os
import random
import sys
import time
from typing import Optional, Tuple

# --- BLE 配置 ---
DEVICE_MAC = "EC:30:8E:36:91:E5"

# UUID 候选列表 (从 com.lxt.bluetoothsdk.UUIDUtil 逆向)
WRITE_UUID_CANDIDATES = [
    "0000ffe2", "6e400002", "772ae377", "00003af1",
    "0000fe61", "0000fffe", "0000c304",
]
READ_UUID_CANDIDATES = [
    "0000ffe1", "6e400003", "6c290d2e", "00003af2",
    "0000fe62", "00008910", "0000c305",
]

# --- 服务器配置 ---
BASE_URL = "https://v3-prod-beta-app.lxt6.cn"
SIGN_KEY = "1FF75E512"
SCHOOL_ID = "80790"
INVESTOR_ID = "600000000000000047"
STUDENT_HEX = "02195CDE"
MACHINE_ID = "25072118000582AC"
DEVICE_VER = "06,63"
TYPE_ID = 18

# --- 转义控制 ---
NEED_TRANSFERRED_MEANING = True


# ==================== 协议工具函数 ====================

def hex_xor(a: str, b: str) -> str:
    """两位hex字符串异或"""
    return format(int(a, 16) ^ int(b, 16), "02X")


def sum_check_code(data: str) -> str:
    """求和校验: 所有字节之和 mod 256"""
    if len(data) % 2 != 0:
        return "00"
    total = sum(int(data[i:i+2], 16) for i in range(0, len(data), 2))
    r = format(total % 256, "02X")
    return r


def rand_hex(nbytes: int = 1) -> str:
    """生成随机hex字节"""
    return ''.join(random.choices("0123456789ABCDEF", k=nbytes * 2))


def build_command(cmd_code: str, data: str = "",
                  rand1: str = None, rand2: str = None,
                  machine_rand: str = None) -> str:
    """
    构建 A5 协议命令 (对应 NBDeviceCommand.command)

    帧格式:
      A5 + LEN + RAND1 + RAND2 + CHK1 + CHK2 + CHK3 + DATA + CHK_SUM

    LEN = (RAND1 + RAND2 + CHK1 + CHK2 + CHK3 + DATA) 的字节数
    """
    if rand1 is None:
        rand1 = rand_hex(1)
    if rand2 is None:
        rand2 = rand_hex(1)

    # 命令码的掩码值
    if cmd_code == "F0":
        mask1, mask2 = "FF", "FF"
    elif cmd_code == "F2" and machine_rand and len(machine_rand) == 4:
        mask1 = machine_rand[0:2]
        mask2 = machine_rand[2:4]
    else:
        mask1 = rand_hex(1)
        mask2 = rand_hex(1)

    x = XOrHelper()

    # CHK1 = sumCheck(xor(xor(mask1, rand1), rand2) + "AA")
    chk1 = sum_check_code(x.xor_pair(x.xor_pair(mask1, rand1), rand2) + "AA")
    # CHK2 = sumCheck(xor(xor(mask2, rand1), rand2) + "AA")
    chk2 = sum_check_code(x.xor_pair(x.xor_pair(mask2, rand1), rand2) + "AA")
    # CHK3 = sumCheck(xor(xor(cmd_code, rand1), rand2) + "AA")
    chk3 = sum_check_code(x.xor_pair(x.xor_pair(cmd_code, rand1), rand2) + "AA")

    # 组装 payload (不含 A5 和 LEN)
    payload = rand1 + rand2 + chk1 + chk2 + chk3 + data
    length = len(payload) // 2  # 字节数
    length_hex = format(length, "02X")

    # 最终校验
    chk_sum = sum_check_code(payload)

    raw = "A5" + length_hex + payload + chk_sum
    return raw.upper()


def apply_transfer_meaning(data: str) -> str:
    """
    转义处理 (对应 NBDeviceCommand.manageData)
    A5 -> 1BE7, 1BE7 -> 1B00E7
    """
    if not NEED_TRANSFERRED_MEANING:
        return data

    sb = list(data)
    # 先处理 1BE7 -> 1B00E7 (反向，避免重复替换)
    i = 1
    while i < len(sb) // 2:
        pos = i * 2
        if pos + 4 <= len(sb) and ''.join(sb[pos:pos+2]) == "1B":
            if pos + 4 <= len(sb) and ''.join(sb[pos+2:pos+4]) == "E7":
                # 1BE7 -> 1B00E7
                sb_insert = list("00")
                for j, c in enumerate(sb_insert):
                    sb.insert(pos + 4 + j, c)
                i += 2
                continue
        i += 1

    # 再处理 A5 -> 1BE7 (跳过第一个字节 A5 帧头)
    i = 1
    while i < len(sb) // 2:
        pos = i * 2
        if pos + 2 <= len(sb) and ''.join(sb[pos:pos+2]) == "A5":
            sb[pos] = '1'
            sb[pos+1] = 'B'
            # 插入 E7
            for j, c in enumerate("E7"):
                sb.insert(pos + 2 + j, c)
            i += 2
            continue
        i += 1

    return ''.join(sb)


def remove_transfer_meaning(data: str) -> str:
    """
    反转义处理 (对应 NBDeviceCommand.receivedDataManage)
    1BE7 -> A5, 1B00E7 -> 1BE7
    """
    if not NEED_TRANSFERRED_MEANING:
        return data

    sb = list(data)
    idx = 1
    # 1BE7 -> A5
    i = idx
    while i < len(sb) // 2 - 1:
        pos = i * 2
        if pos + 4 <= len(sb) and ''.join(sb[pos:pos+2]) == "1B":
            if ''.join(sb[pos+2:pos+4]) == "E7":
                sb[pos] = 'A'
                sb[pos+1] = '5'
                del sb[pos+2:pos+4]
                idx = i + 1
                i = idx
                continue
        i += 1

    # 1B00E7 -> 1BE7
    i = idx
    while i < len(sb) // 2 - 2:
        pos = i * 2
        if pos + 6 <= len(sb) and ''.join(sb[pos:pos+2]) == "1B":
            if ''.join(sb[pos+2:pos+4]) == "00" and ''.join(sb[pos+4:pos+6]) == "E7":
                sb[pos] = '1'
                sb[pos+1] = 'B'
                del sb[pos+2:pos+4]  # 删除 00
                idx = i + 2
                i = idx
                continue
        i += 1

    return ''.join(sb)


class XOrHelper:
    """对应 XOrUtils"""
    def xor_pair(self, a: str, b: str) -> str:
        return format(int(a, 16) ^ int(b, 16), "02X")


# ==================== 命令构建 ====================

def cmd_select_info() -> str:
    """F0 查询设备信息"""
    raw = build_command("F0")
    return apply_transfer_meaning(raw)


def cmd_get_rand() -> str:
    """F08 获取随机数"""
    raw = build_command("08")
    return apply_transfer_meaning(raw)


def cmd_collect_order(student_hex: str) -> str:
    """F02 采集订单"""
    data = "00" + student_hex + "00000000"  # DEFAULT_DEVICEHEXNO
    raw = build_command("02", data)
    return apply_transfer_meaning(raw)


def cmd_open_online(server_data: str) -> str:
    """F06 开阀指令 (服务器返回的数据)"""
    raw = build_command("06", server_data)
    return apply_transfer_meaning(raw)


# ==================== 脱机开阀 (不走服务器) ====================

def byte_negation(b: int) -> int:
    """按位取反 (对应 ByteUtil.negation / BathUtil.negation)"""
    result = 0
    for i in range(8):
        if not ((b >> i) & 1):
            result += (1 << i)
    return result


def student_hex_to_key(student_hex: str) -> str:
    """
    studentHex -> 设备存储的用户标识 (对应 BathUtil.getStudentId)
    negation 每个字节，然后 XOR "AA"
    """
    result = ""
    for i in range(0, len(student_hex), 2):
        b = int(student_hex[i:i+2], 16)
        neg = byte_negation(b)
        result += hex_xor(format(neg, "02X"), "AA")
    return result.upper()


def format_datetime_6hex(ts_ms: int) -> str:
    """
    时间戳 -> 6字节hex (对应 TimeUtils.formatDateTime6Hex)
    格式: yyMMddHHmmss -> 每对十进制转hex
    """
    t = time.localtime(ts_ms / 1000)
    parts = [
        t.tm_year % 100,  # yy
        t.tm_mon,          # MM
        t.tm_mday,         # dd
        t.tm_hour,         # HH
        t.tm_min,          # mm
        t.tm_sec,          # ss
    ]
    return "".join(format(p, "02X") for p in parts)


def encrypt_offline_data(key: str, ts_suffix: str, data: str) -> str:
    """
    脱机数据加密 (对应 NBDeviceCommand.getEncrptyOffineData)
    key: studentHex (8 hex chars)
    ts_suffix: formatDateTime6Hex 最后2字符
    data: machineRandom(8) + lastPosSerial(8) + padding(16) = 32 hex chars
    """
    # 生成加密密钥: sumCheck(key[0:2]+ts) + sumCheck(key[2:4]+ts) + ...
    enc_key = ""
    for i in range(0, 8, 2):
        enc_key += sum_check_code(key[i:i+2] + ts_suffix)

    # 按位取反每个字节
    key_bytes = bytearray()
    for i in range(0, len(enc_key), 2):
        key_bytes.append(byte_negation(int(enc_key[i:i+2], 16)))
    key_hex = key_bytes.hex().upper()

    # XOR 加密 data 的每 8 字节块
    x = XOrHelper()
    result = ""
    for i in range(0, len(data), 8):
        block = data[i:i+8]
        result += x.xor_pair(block[:4], key_hex[:4]) + x.xor_pair(block[4:], key_hex[4:])
    return result.upper()


def cmd_open_offline(machine_rand: str, student_hex: str,
                     last_pos_serial: str = "FFFFFFFF") -> str:
    """
    F01 脱机开阀命令 (不走服务器, 直接BLE发送)
    对应 NBDeviceCommand.openOffineCommand

    参数:
      machine_rand: F08 获取的随机数 (8 hex chars)
      student_hex: 学生号hex (如 "02195CDE")
      last_pos_serial: 上次交易流水号 (默认FFFFFFFF)
    """
    if not machine_rand or len(machine_rand) != 8:
        return ""

    # 组装明文: machineRandom + lastPosSerial + 固定padding
    plain = machine_rand + last_pos_serial + "0000FFFFFFFFAAAA"

    # 生成时间戳
    ts_hex = format_datetime_6hex(int(time.time() * 1000))
    ts_suffix = ts_hex[-2:]  # 最后2字符

    # 加密
    encrypted = encrypt_offline_data(student_hex, ts_suffix, plain)

    # 构建命令: F01, data = "00" + encrypted + ts_hex
    data = "00" + encrypted + ts_hex
    raw = build_command("01", data)
    return apply_transfer_meaning(raw)


# ==================== 帧解析 ====================

class FrameParser:
    """A5 协议帧解析器 (对应 NBDeviceCommand.receivedDataNew)"""

    def __init__(self):
        self.buffer = ""
        self.left_count = 0

    def feed(self, chunk: str) -> Optional[str]:
        """喂入数据块，返回完整帧或 None"""
        chunk = chunk.upper()

        if chunk.startswith("A5") and not self.buffer:
            self.buffer = chunk
        elif self.buffer:
            self.buffer += chunk
        else:
            return None

        if len(self.buffer) >= 4:
            # 反转义
            decoded = remove_transfer_meaning(self.buffer)
            self.buffer = decoded
            # LEN 字段 (位置 2-4)
            frame_len = int(self.buffer[2:4], 16)
            expected = frame_len * 2 + 6  # A5 + LEN + payload + CHK
            self.left_count = expected - len(self.buffer)

        if self.left_count <= 0 and self.buffer:
            result = self.buffer
            self.buffer = ""
            self.left_count = 0
            return result
        return None

    def reset(self):
        self.buffer = ""
        self.left_count = 0


def parse_device_type(response: str) -> str:
    """
    解析设备类型 (对应 BluetoothControlUtil.onManageReceivedData)
    返回: "nbdevice", "smalldevice", "batchdevice", "offlinedevice", "offlinedevice1"
    """
    r = response.upper()
    if r.startswith("A5") and len(r) > 2:
        return "nbdevice"
    if r.startswith("55") and len(r) == 40:
        return "smalldevice"
    if r.startswith("550001") and len(r) >= 12 and r[10:12] == "F5":
        frame_len = int(r[6:8], 16)
        if frame_len >= 36 and len(r) > 74:
            ver = r[70:74]
            if ver == "5631":
                return "offlinedevice1"
            return "offlinedevice"
        return "batchdevice"
    return "unknown"


def parse_nb_response(response: str, rand1: str, rand2: str) -> dict:
    """
    解析 NB 设备响应帧
    帧格式: A5 + LEN + R1 + R2 + S1 + S2 + S3 + DATA + CHK

    S1 = sumCheck(xor(xor(r1_out, rand1), rand2) + "AA")
    其中 r1_out 是设备返回的 R1
    """
    result = {"raw": response, "valid": False}

    if not response.startswith("A5") or len(response) < 14:
        return result

    frame_len = int(response[2:4], 16)
    r1 = response[4:6]
    r2 = response[6:8]
    s1 = response[8:10]
    s2 = response[10:12]
    s3 = response[12:14]
    data = response[14:-2]
    chk = response[-2:]

    # 校验
    x = XOrHelper()
    expected_s1 = sum_check_code(x.xor_pair(x.xor_pair(r1, rand1), rand2) + "AA")
    expected_s2 = sum_check_code(x.xor_pair(x.xor_pair(r2, rand1), rand2) + "AA")

    result["r1"] = r1
    result["r2"] = r2
    result["control"] = s3
    result["data"] = data
    result["valid"] = (s1.upper() == expected_s1.upper() and
                       s2.upper() == expected_s2.upper())
    return result


# ==================== 服务器 API ====================

def md5(text: str) -> str:
    return hashlib.md5(text.encode()).hexdigest()


def sign(params: str) -> str:
    return md5(SIGN_KEY + params)


def gen_ghost() -> str:
    """X-Ghost 生成 (对应 AppUtils.getGhost)"""
    ts = format(int(time.time() * 1000), 'x')
    ls = ts.zfill(12)

    # sum_check_code
    total = sum(int(ls[i:i+2], 16) for i in range(0, len(ls), 2))
    scc = format(total % 256, '02X').upper().zfill(2)

    # x_or
    parts = [ls[i*2:i*2+2] for i in range(len(ls)//2)]
    xor_val = int(parts[0], 16)
    for p in parts[1:]:
        xor_val ^= int(p, 16)
    xor_hex = format(xor_val, '02X')

    return (scc + ls + xor_hex).lower()


def get_headers(token: str = None) -> dict:
    h = {
        "X-Sid": "2021011300001",
        "X-Product-Ver": "4.3.9",
        "X-clientType": "1",
        "X-Ghost": gen_ghost(),
    }
    if token:
        h["Cookie"] = token
    return h


def api_post_handle_data(token: str, machine_data: str, machine_rand: str,
                         status_info: str = "00", handle_type: int = 0) -> dict:
    """POST /mgapp/app/machine/handleData (采集订单)"""
    import requests

    body = {
        "typeId": TYPE_ID,
        "machineId": MACHINE_ID,
        "deviceVer": DEVICE_VER,
        "machineRandom": machine_rand,
        "machineData": machine_data,
        "posSystemTime": "",
        "statusInfo": status_info,
        "handleType": handle_type,
    }
    body_json = json.dumps(body, separators=(",", ":"))
    sig = sign(body_json)

    headers = {
        **get_headers(token),
        "Content-Type": "application/json",
        "X-Sign": sig,
        "X-Mobile-Info": "Android#?22041211AC#?16",
        "User-Agent": "okhttp/4.9.3",
    }
    s = requests.Session()
    s.trust_env = False
    resp = s.post(f"{BASE_URL}/mgapp/app/machine/handleData",
                  headers=headers, data=body_json, timeout=15)
    return resp.json()


def api_post_open_auth(token: str, machine_rand: str, machine_data: str = "") -> dict:
    """POST /bath/valve/open (开阀认证)"""
    import requests

    body = {
        "channelWay": 1,
        "typeId": TYPE_ID,
        "deviceVer": DEVICE_VER,
        "machineId": MACHINE_ID,
        "firmwareVer": "",
        "machineInfoJson": {
            "handleType": 0,
            "lastPosMoney": "",
            "lastPosSerial": "",
            "machineData": machine_data,
            "machinePwdVer": "",
            "machineRandom": machine_rand,
            "netFlag": "0000",
            "orderId": "",
            "type": 0,
        }
    }
    body_json = json.dumps(body, separators=(",", ":"))
    sig = sign(body_json)

    headers = {
        **get_headers(token),
        "Content-Type": "application/json",
        "X-Sign": sig,
        "X-Mobile-Info": "Android#?22041211AC#?16",
        "User-Agent": "okhttp/4.9.3",
    }
    s = requests.Session()
    s.trust_env = False
    resp = s.post(f"{BASE_URL}/bath/valve/open",
                  headers=headers, data=body_json, timeout=15)
    return resp.json()


# ==================== BLE 主流程 ====================

async def discover_characteristics(client) -> Tuple[Optional[str], Optional[str]]:
    """
    自动发现 write 和 notify characteristic UUID
    对应 ConnectBLEDevice.onServicesDiscovered 中的 UUIDUtil.isWriteUuid/isReadUuid
    """
    write_char = None
    read_char = None

    for service in client.services:
        for char in service.characteristics:
            uuid = char.uuid.lower()
            # 检查是否匹配写 UUID 候选
            for cand in WRITE_UUID_CANDIDATES:
                if uuid.startswith(cand):
                    write_char = char.uuid
                    print(f"  Write characteristic: {char.uuid} (service: {service.uuid})")
                    break
            # 检查是否匹配读 UUID 候选
            for cand in READ_UUID_CANDIDATES:
                if uuid.startswith(cand):
                    read_char = char.uuid
                    print(f"  Read/Notify characteristic: {char.uuid} (service: {service.uuid})")
                    break

    # 如果没找到候选，列出所有特征供调试
    if not write_char or not read_char:
        print("  未匹配到预设UUID，列出所有特征:")
        for service in client.services:
            for char in service.characteristics:
                props = ",".join(char.properties)
                print(f"    {char.uuid} ({props}) [service: {service.uuid}]")

    return write_char, read_char


async def main():
    try:
        from bleak import BleakClient, BleakScanner
    except ImportError:
        print("需要安装 bleak: pip install bleak")
        return

    print("=" * 50)
    print("  乐校通预付费水表 BLE 开阀脚本")
    print("=" * 50)
    print(f"\n目标设备: {DEVICE_MAC}")
    print(f"设备编号: {MACHINE_ID}")
    print(f"设备版本: {DEVICE_VER}")

    mode = input("\n选择模式:\n  1. 脱机开阀 (不走服务器)\n  2. 在线开阀 (需要token)\n  3. 仅BLE探测\n> ").strip()
    offline_mode = (mode == "1")
    probe_only = (mode == "3")

    # 自动加载 token (模式2需要)
    token = None
    token_file = os.path.join(os.path.dirname(os.path.abspath(__file__)), ".lexiaotong_token")
    if not offline_mode and not probe_only:
        if os.path.exists(token_file):
            with open(token_file) as f:
                token = f.read().strip()
            print(f"  已加载缓存 token")
        if not token:
            token = input("  请输入 token (tokenInfo=xxx): ").strip()

    # --- Step 0: 扫描确认设备存在 ---
    print("\n[0] 扫描附近 BLE 设备...")
    target = None
    for attempt in range(3):
        print(f"  第 {attempt+1}/3 次扫描 (10秒)...")
        devices = await BleakScanner.discover(timeout=10.0)
        for d in devices:
            if d.address.upper().replace("-", ":") == DEVICE_MAC.upper().replace("-", ":"):
                target = d
                break
        if target:
            break
        if attempt < 2:
            print(f"  未找到, 等待5秒后重试...")
            await asyncio.sleep(5)

    if target:
        print(f"  找到设备: {target.name} ({target.address})")
    else:
        print(f"\n  3次扫描均未找到 {DEVICE_MAC}")
        print(f"  共发现 {len(devices)} 个设备, 前10个:")
        for d in devices[:10]:
            print(f"    {d.address} - {d.name or '未知'}")
        print("  提示: 水表BLE广播间隔很长(省电), 可能需要等1-2分钟")
        print("  确保: 1) 手机乐校通APP已关闭  2) 水表在蓝牙范围内(10米)")
        try:
            confirm = input("  继续尝试连接? (y/n): ").strip().lower()
        except EOFError:
            confirm = "y"
        if confirm != 'y':
            return

    # --- Step 1: BLE 连接 ---
    print(f"\n[1] 连接 {DEVICE_MAC}...")
    parser = FrameParser()
    received_frames = []
    connected_event = asyncio.Event()

    def on_notify(sender, data: bytearray):
        hex_str = data.hex().upper()
        print(f"  <- 收到: {hex_str}")
        frame = parser.feed(hex_str)
        if frame:
            print(f"  <- 完整帧: {frame}")
            received_frames.append(frame)

    # 尝试配对
    print("  尝试配对...")
    try:
        import bleak.exc
        BleakClient.PAIRING_TIMEOUT = 10.0
    except:
        pass

    client = BleakClient(DEVICE_MAC, timeout=20.0, winrt=dict(use_cached_services=False))
    try:
        await client.connect()
    except Exception as e:
        print(f"  连接失败: {e}")
        print("  提示: 确保手机上乐校通APP已关闭, 水表未被其他设备连接")
        return

    if not client.is_connected:
        print("  连接失败!")
        return
    print("  连接成功!")

    # 自动发现 BLE 特征
    print(f"\n[2] 发现 BLE 特征...")
    write_uuid, read_uuid = await discover_characteristics(client)
    if not write_uuid or not read_uuid:
        print("  无法找到 write/notify 特征，断开")
        await client.disconnect()
        return
    print(f"  使用: write={write_uuid}, notify={read_uuid}")

    try:
        # 订阅 notify
        print(f"\n[3] 订阅 notify...")
        await client.start_notify(read_uuid, on_notify)
        print("  已订阅")

        # --- Step 2: 发送 F0 (查询设备信息) ---
        print("\n[3] 发送 F0 (查询设备信息)...")
        cmd = cmd_select_info()
        print(f"  -> 发送: {cmd}")
        await client.write_gatt_char(write_uuid, bytes.fromhex(cmd))
        await asyncio.sleep(2.0)

        if not received_frames:
            print("  未收到响应，设备可能不支持此协议")
            await client.stop_notify(read_uuid)
            return

        device_response = received_frames[-1]
        device_type = parse_device_type(device_response)
        print(f"  设备类型: {device_type}")

        if device_type != "nbdevice":
            print(f"  该设备使用 {device_type} 协议，需要不同的命令序列")
            print("  本脚本目前支持 nbdevice (A5协议)")

        if probe_only:
            print(f"\n设备类型: {device_type}")
            print("探测完成，退出")
            await client.stop_notify(read_uuid)
            return

        # --- Step 3: 发送 F08 (获取随机数) ---
        print("\n[4] 发送 F08 (获取随机数)...")
        parser.reset()
        received_frames.clear()
        cmd = cmd_get_rand()
        print(f"  -> 发送: {cmd}")
        await client.write_gatt_char(write_uuid, bytes.fromhex(cmd))
        await asyncio.sleep(2.0)

        if not received_frames:
            print("  未收到随机数响应")
            await client.stop_notify(read_uuid)
            return

        rand_response = received_frames[-1]
        if len(rand_response) > 30:
            machine_rand = rand_response[22:30]
            print(f"  machineRandom: {machine_rand}")
        else:
            print(f"  响应太短: {rand_response}")
            await client.stop_notify(read_uuid)
            return

        if offline_mode:
            # ===== 脱机开阀 (不走服务器) =====
            print("\n[5] 发送 F01 (脱机开阀)...")
            parser.reset()
            received_frames.clear()
            cmd = cmd_open_offline(machine_rand, STUDENT_HEX)
            if not cmd:
                print("  构建脱机命令失败")
                await client.stop_notify(read_uuid)
                return
            print(f"  -> 发送: {cmd}")
            await client.write_gatt_char(write_uuid, bytes.fromhex(cmd))
            await asyncio.sleep(3.0)

            if received_frames:
                open_resp = received_frames[-1]
                print(f"  脱机响应: {open_resp}")
                if len(open_resp) > 24:
                    status = open_resp[22:24]
                    status_map = {
                        "00": "脱机开阀成功!",
                        "01": "连接失败",
                        "02": "未绑定,需先在线采集",
                        "0d": "没有绑定,不能脱机消费",
                        "0e": "设备已绑满账号",
                        "0f": "设备正忙",
                    }
                    msg = status_map.get(status.lower(), f"未知状态码: {status}")
                    if status.lower() == "00":
                        print(f"\n  *** {msg} ***")
                    else:
                        print(f"\n  开阀失败: {msg}")
                else:
                    print(f"  响应格式异常")
            else:
                print("  未收到脱机开阀响应")
                print("  可能原因: 设备未绑定你的账号, 或设备不支持脱机模式")

        else:
            # ===== 在线开阀 =====
            print("\n[5] 发送 F02 (采集订单)...")
            parser.reset()
            received_frames.clear()
            cmd = cmd_collect_order(STUDENT_HEX)
            print(f"  -> 发送: {cmd}")
            await client.write_gatt_char(write_uuid, bytes.fromhex(cmd))
            await asyncio.sleep(3.0)

            if not received_frames:
                print("  未收到订单响应")
                await client.stop_notify(read_uuid)
                return

            order_response = received_frames[-1]
            print(f"  订单响应: {order_response}")

            if len(order_response) >= 58:
                order_machine_data = order_response[42:58]
                order_status = order_response[20:22]
                print(f"  machineData: {order_machine_data}")
                print(f"  statusInfo: {order_status}")

                print("\n[6] 上传订单到服务器...")
                if token:
                    if not token.startswith("tokenInfo="):
                        token = "tokenInfo=" + token
                    try:
                        resp = api_post_handle_data(token, order_machine_data,
                                                    machine_rand, order_status)
                        print(f"  服务器响应: {json.dumps(resp, ensure_ascii=False)}")

                        if resp.get("Code") == 0:
                            server_data = resp.get("Data", {})
                            send_data = server_data.get("sendMachineData", "")
                            if send_data:
                                print(f"\n[7] 发送 F06 (开阀指令)...")
                                parser.reset()
                                received_frames.clear()
                                cmd = cmd_open_online(send_data)
                                print(f"  -> 发送: {cmd}")
                                await client.write_gatt_char(write_uuid,
                                                            bytes.fromhex(cmd))
                                await asyncio.sleep(3.0)

                                if received_frames:
                                    open_resp = received_frames[-1]
                                    print(f"  开阀响应: {open_resp}")
                                    if len(open_resp) > 24:
                                        status = open_resp[22:24]
                                        if status == "00":
                                            print("\n  *** 开阀成功! ***")
                                        else:
                                            print(f"\n  开阀失败 (状态码: {status})")
                                else:
                                    print("  未收到开阀响应")
                    except Exception as e:
                        print(f"  服务器请求失败: {e}")
                else:
                    print("  跳过服务器步骤")
                    print(f"  machineRandom = {machine_rand}")
            else:
                print("  订单响应格式异常")

        # 清理
        await client.stop_notify(read_uuid)

    finally:
        # 断开连接
        if client.is_connected:
            await client.disconnect()
        print("\n[完成] BLE 连接已关闭")


if __name__ == "__main__":
    asyncio.run(main())
