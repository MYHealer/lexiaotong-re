package com.qq.e.comm.managers.plugin;

import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f8508a = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", t.l, "c", t.t, "e", "f"};

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(a(b));
        }
        return stringBuffer.toString();
    }

    private static String a(byte b) {
        int i = b;
        if (b < 0) {
            i = b + 256;
        }
        int i2 = i / 16;
        StringBuilder sb = new StringBuilder();
        String[] strArr = f8508a;
        return sb.append(strArr[i2]).append(strArr[i % 16]).toString();
    }

    public static String a(File file) throws Throwable {
        if (file != null && file.exists()) {
            FileInputStream fileInputStream = null;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        int i = fileInputStream2.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i);
                    }
                    String strA = a(messageDigest.digest());
                    try {
                        fileInputStream2.close();
                    } catch (Exception unused) {
                    }
                    return strA;
                } catch (Exception unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused3) {
                        }
                    }
                    return "";
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } catch (Exception unused5) {
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return "";
    }

    public static String a(String str) {
        try {
            String str2 = new String(str);
            try {
                return a(MessageDigest.getInstance("MD5").digest(str2.getBytes("UTF-8")));
            } catch (Exception unused) {
                return str2;
            }
        } catch (Exception unused2) {
            return null;
        }
    }
}
