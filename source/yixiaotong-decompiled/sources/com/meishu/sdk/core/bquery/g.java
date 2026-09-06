package com.meishu.sdk.core.bquery;

import android.content.Context;
import android.text.TextUtils;
import com.meishu.sdk.core.AdSdk;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: BQUtility.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static File f4773a;
    public static ScheduledExecutorService b;

    public static File a(File file, String str, String str2) {
        if (str == null) {
            return null;
        }
        String strB = b(str);
        if (!TextUtils.isEmpty(str2)) {
            strB = strB + "_" + str2;
        }
        return new File(file, strB);
    }

    public static String b(String str) {
        byte[] bArrDigest;
        byte[] bytes = str.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bytes);
            bArrDigest = messageDigest.digest();
        } catch (Exception unused) {
            bArrDigest = null;
        }
        return new BigInteger(bArrDigest).abs().toString(36);
    }

    public static void a(File file, byte[] bArr) {
        if (file != null) {
            try {
                if (file.exists()) {
                    return;
                }
                try {
                    file.createNewFile();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } catch (Exception e2) {
                try {
                    e2.printStackTrace();
                } catch (Exception unused) {
                }
            }
        }
    }

    public static File b(Context context) {
        if (f4773a == null) {
            File file = new File(context.getCacheDir(), "bquery");
            f4773a = file;
            file.mkdirs();
        }
        return f4773a;
    }

    public static void a(Context context) {
        try {
            File fileB = b(context);
            if (b == null) {
                b = Executors.newSingleThreadScheduledExecutor();
            }
            b.schedule(new f(fileB, 86400000L), 0L, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
        }
    }

    public static File a(String str, String str2) {
        return a(b(AdSdk.getContext()), str, str2);
    }

    public static byte[] a(String str) {
        byte[] byteArray = new byte[0];
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int i = fileInputStream.read(bArr);
                        if (i == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                        try {
                            fileInputStream.close();
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                        throw th;
                    }
                    byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                fileInputStream.close();
                throw th4;
            }
        } catch (Throwable unused) {
        }
        return byteArray;
    }
}
