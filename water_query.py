#!/usr/bin/env python
"""乐校通预付费水表查询"""

import hashlib
import json
import sys
import io
import os
import base64
import time

sys.stdout = io.TextIOWrapper(sys.stdout.buffer, encoding="utf-8")

import requests

BASE_URL = "https://v3-prod-beta-app.lxt6.cn"
SIGN_KEY = "1FF75E512"
SCHOOL_ID = "80790"
INVESTOR_ID = "600000000000000047"

TOKEN_FILE = os.path.join(os.path.dirname(os.path.abspath(__file__)), ".lexiaotong_token")


def md5(t):
    return hashlib.md5(t.encode()).hexdigest()


def sign(p):
    return md5(SIGN_KEY + p)


def get_len_string(s, l):
    return s if len(s) >= l else "0" * (l - len(s)) + s


def sum_check_code(s):
    if len(s) % 2 != 0:
        return "00"
    total = sum(int(s[i:i + 2], 16) for i in range(0, len(s), 2))
    r = hex(total % 256)[2:].upper()
    return "0" + r if len(r) == 1 else r


def x_or(s):
    parts = [s[i * 2:i * 2 + 2] for i in range(len(s) // 2)]
    result = int(parts[0], 16)
    for i in range(1, len(parts)):
        result ^= int(parts[i], 16)
    return format(result, "02X")


def gen_ghost():
    ts = hex(int(time.time() * 1000))[2:]
    ls = get_len_string(ts, 12)
    return (sum_check_code(ls) + ls + x_or(ls)).lower()


def get_headers():
    return {"X-Sid": "2021011300001", "X-Product-Ver": "4.3.9",
            "X-clientType": "1", "X-Ghost": gen_ghost()}


def login(phone, password):
    headers = get_headers()
    import ddddocr
    ocr = ddddocr.DdddOcr(show_ad=False)

    for i in range(15):
        sig = sign(f"account={phone}")
        resp = requests.get(f"{BASE_URL}/user/authentication/getCode",
                            params={"account": phone},
                            headers={**headers, "X-Sign": sig})
        r = resp.json()
        if r.get("Code") != 0:
            time.sleep(1)
            continue

        img = base64.b64decode(r["Data"].split(",")[1])
        cap = ocr.classification(img)

        ld = json.dumps({"studentMobile": phone, "loginPassword": password, "code": cap},
                        separators=(",", ":"))
        enc = base64.b64encode(ld.encode()).decode()
        ua = json.dumps({"data": enc}, separators=(",", ":"))

        resp2 = requests.post(f"{BASE_URL}/user/login/userLoginV2WithEncrypt",
                              headers={**headers, "Content-Type": "application/json",
                                       "X-Sign": sign(ua)},
                              data=ua)

        token = resp2.headers.get("TokenInfo") or resp2.headers.get("tokenInfo")
        if not token:
            for c in resp2.cookies:
                if c.name == "tokenInfo":
                    token = c.value
                    break

        if token:
            if not token.startswith("tokenInfo="):
                token = "tokenInfo=" + token
            with open(TOKEN_FILE, "w") as f:
                f.write(token)
            print(f"  登录成功 (验证码: {cap})")
            return token

        time.sleep(1)

    print("  登录失败")
    return None


def query(token, device_mac):
    params = f"walletKey={device_mac}&schoolId={SCHOOL_ID}&investorId={INVESTOR_ID}"
    headers = {**get_headers(), "Content-Type": "application/x-www-form-urlencoded",
               "Cookie": token, "X-Sign": sign(params)}
    return requests.get(f"{BASE_URL}/paymentV1/app/wallet/find?{params}", headers=headers).json()


def get_token(phone, password):
    if os.path.exists(TOKEN_FILE):
        with open(TOKEN_FILE) as f:
            token = f.read().strip()
        if token:
            return token
    print("\n  正在登录...")
    return login(phone, password)


def main():
    print("=" * 40)
    print("  乐校通预付费水表查询")
    print("=" * 40)

    phone = input("\n手机号: ").strip()
    password = input("密码: ").strip()

    token = get_token(phone, password)
    if not token:
        return

    while True:
        device_mac = input("\n设备编号 (q退出): ").strip()
        if device_mac.lower() == "q":
            break

        r = query(token, device_mac)
        if r.get("Code") == 0 and r.get("Data"):
            d = r["Data"]
            print(f"  可用余额: {d['canUseMoney'] / 100:.2f} 元")
            print(f"  累计充值: {d['appendMoney'] / 100:.2f} 元")
            print(f"  累计用水: {d['waterVolume'] / 1000:.0f} 升 ({d['waterVolume'] / 1000000:.1f} m³)")
            print(f"  状态: {'正常' if d.get('status') == 1 else '异常'}")
        elif r.get("Code") == -45:
            # token 过期，重新登录
            print("  token 过期，重新登录...")
            token = login(phone, password)
            if not token:
                break
            r = query(token, device_mac)
            if r.get("Code") == 0 and r.get("Data"):
                d = r["Data"]
                print(f"  可用余额: {d['canUseMoney'] / 100:.2f} 元")
                print(f"  累计充值: {d['appendMoney'] / 100:.2f} 元")
                print(f"  累计用水: {d['waterVolume'] / 1000:.0f} 升 ({d['waterVolume'] / 1000000:.1f} m³)")
                print(f"  状态: {'正常' if d.get('status') == 1 else '异常'}")
            else:
                print(f"  查询失败: {r.get('Message', '未知错误')}")
        else:
            print(f"  查询失败: {r.get('Message', '未知错误')}")


if __name__ == "__main__":
    main()
