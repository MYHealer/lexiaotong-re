package com.huawei.secure.android.common.encrypt.utils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class RootKeyUtil {
    private static final String b = "RootKeyUtil";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte[] f4529a = null;

    private RootKeyUtil() {
    }

    private void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, HexUtil.hexStr2ByteArray(str4));
    }

    public static RootKeyUtil newInstance(String str, String str2, String str3, String str4) {
        RootKeyUtil rootKeyUtil = new RootKeyUtil();
        rootKeyUtil.a(str, str2, str3, str4);
        return rootKeyUtil;
    }

    public byte[] getRootKey() {
        return (byte[]) this.f4529a.clone();
    }

    public String getRootKeyHex() {
        return HexUtil.byteArray2HexStr(this.f4529a);
    }

    public static RootKeyUtil newInstance(String str, String str2, String str3, byte[] bArr) {
        RootKeyUtil rootKeyUtil = new RootKeyUtil();
        rootKeyUtil.a(str, str2, str3, bArr);
        return rootKeyUtil;
    }

    private void a(String str, String str2, String str3, byte[] bArr) {
        b.c(b, "initRootKey: sha256");
        this.f4529a = BaseKeyUtil.exportRootKey(str, str2, str3, bArr, true);
    }
}
