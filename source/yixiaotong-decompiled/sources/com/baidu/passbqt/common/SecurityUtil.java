package com.baidu.passbqt.common;

import android.util.Base64;
import com.baidu.passbqt.NoProguard;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class SecurityUtil implements NoProguard {
    public static String a(byte[] bArr, boolean z) {
        return new Security().a(bArr, z);
    }

    public static String a(byte[] bArr) {
        return new Security().a(bArr);
    }

    public static byte[] b(byte[] bArr) {
        return Base64.decode(bArr, 0);
    }

    public static byte[] a(String str, String str2, String str3) throws Exception {
        return new Security.AES().a(str, str2, str3);
    }

    public static byte[] a(byte[] bArr, String str, String str2) throws Exception {
        return new Security.AES().a(bArr, str, str2);
    }
}
