package com.hihonor.secure.android.common.encrypt.utils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class RootKeyUtil {
    private static final String TAG = "RootKeyUtil";
    private byte[] T = null;

    public static RootKeyUtil newInstance(String str, String str2, String str3, String str4) {
        RootKeyUtil rootKeyUtil = new RootKeyUtil();
        rootKeyUtil.a(str, str2, str3, str4);
        return rootKeyUtil;
    }

    public static RootKeyUtil newInstance(String str, String str2, String str3, byte[] bArr) {
        RootKeyUtil rootKeyUtil = new RootKeyUtil();
        rootKeyUtil.a(str, str2, str3, bArr);
        return rootKeyUtil;
    }

    private void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, HexUtil.hexStr2ByteArray(str4));
    }

    public byte[] getRootKey() {
        return (byte[]) this.T.clone();
    }

    public String getRootKeyHex() {
        return HexUtil.byteArray2HexStr(this.T);
    }

    private void a(String str, String str2, String str3, byte[] bArr) {
        b.d(TAG, "initRootKey: sha256");
        this.T = BaseKeyUtil.exportRootKey(str, str2, str3, bArr, true);
    }
}
