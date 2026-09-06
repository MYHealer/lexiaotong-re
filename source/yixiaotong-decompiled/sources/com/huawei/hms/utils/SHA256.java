package com.huawei.hms.utils;

import com.huawei.hms.support.log.HMSLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class SHA256 {
    public static byte[] digest(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            HMSLog.e("SHA256", "NoSuchAlgorithmException" + e.getMessage());
            return new byte[0];
        }
    }

    public static byte[] digest(File file) throws Throwable {
        InputStream inputStream = null;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    byte[] bArr = new byte[4096];
                    int i = 0;
                    while (true) {
                        int i2 = bufferedInputStream2.read(bArr);
                        if (i2 == -1) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i2);
                        i += i2;
                    }
                    if (i > 0) {
                        byte[] bArrDigest = messageDigest.digest();
                        IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                        return bArrDigest;
                    }
                    IOUtils.closeQuietly((InputStream) bufferedInputStream2);
                    inputStream = i;
                } catch (IOException | NoSuchAlgorithmException unused) {
                    bufferedInputStream = bufferedInputStream2;
                    HMSLog.e("SHA256", "An exception occurred while computing file 'SHA-256'.");
                    IOUtils.closeQuietly((InputStream) bufferedInputStream);
                    inputStream = bufferedInputStream;
                } catch (Throwable th) {
                    th = th;
                    inputStream = bufferedInputStream2;
                    IOUtils.closeQuietly(inputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException | NoSuchAlgorithmException unused2) {
        }
        return new byte[0];
    }
}
