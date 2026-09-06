package com.opos.cmn.an.b;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    public static String a(File file) {
        int i;
        String str = "";
        if (file != null && file.isFile() && file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    while (true) {
                        int i2 = fileInputStream.read(bArr);
                        if (-1 == i2) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i2);
                        com.opos.cmn.an.f.a.c("Md5Tool", "md5File", e);
                    }
                    for (byte b : messageDigest.digest()) {
                        String hexString = Integer.toHexString(b & 255);
                        if (hexString.length() == 1) {
                            hexString = "0" + hexString;
                        }
                        str = str + hexString;
                    }
                    fileInputStream.close();
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                        throw th2;
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("Md5Tool", "md5File", e);
            }
        }
        return str;
    }

    public static String a(String str) {
        return !com.opos.cmn.an.d.a.a(str) ? a(str.getBytes()) : "";
    }

    public static String a(byte[] bArr) {
        String str = "";
        if (bArr != null) {
            try {
                for (byte b : MessageDigest.getInstance("MD5").digest(bArr)) {
                    String hexString = Integer.toHexString(b & 255);
                    if (hexString.length() == 1) {
                        hexString = "0" + hexString;
                    }
                    str = str + hexString;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("Md5Tool", "md5", e);
            }
        }
        return str;
    }

    public static String b(String str) {
        return !com.opos.cmn.an.d.a.a(str) ? a(new File(str)) : "";
    }
}
