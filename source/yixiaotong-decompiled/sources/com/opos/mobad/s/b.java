package com.opos.mobad.s;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {
    public static void a(final Context context, final String str, final byte[] bArr) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.s.b.1
            @Override // java.lang.Runnable
            public void run() {
                long jCurrentTimeMillis;
                StringBuilder sb;
                if (TextUtils.isEmpty(str) || bArr == null) {
                    com.opos.cmn.an.f.a.d("FileStreamUtils", "path or data is empty");
                    return;
                }
                try {
                    try {
                        FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), str));
                        try {
                            fileOutputStream.write(bArr);
                            com.opos.cmn.an.f.a.a("FileStreamUtils", "write data in " + str + " success");
                            fileOutputStream.close();
                            jCurrentTimeMillis = System.currentTimeMillis();
                            sb = new StringBuilder("update cache time");
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th3) {
                                    th.addSuppressed(th3);
                                }
                                throw th2;
                            }
                        }
                    } catch (IOException e) {
                        c.b(context, "adCacheTime", 0L);
                        com.opos.cmn.an.f.a.d("FileStreamUtils", "write data in " + str + " fail", e);
                        jCurrentTimeMillis = System.currentTimeMillis();
                        sb = new StringBuilder("update cache time");
                    }
                    com.opos.cmn.an.f.a.a("FileStreamUtils", sb.append(jCurrentTimeMillis).toString());
                    c.b(context, "adCacheTime", jCurrentTimeMillis);
                } catch (Throwable th4) {
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    com.opos.cmn.an.f.a.a("FileStreamUtils", "update cache time" + jCurrentTimeMillis2);
                    c.b(context, "adCacheTime", jCurrentTimeMillis2);
                    throw th4;
                }
            }
        });
    }

    public static byte[] a(Context context, String str) {
        StringBuilder sb;
        byte[] bArr = null;
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.d("FileStreamUtils", "path is empty");
            return null;
        }
        File file = new File(context.getFilesDir(), str);
        try {
            if (!file.exists()) {
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    bArr = new byte[(int) file.length()];
                    fileInputStream.read(bArr);
                    com.opos.cmn.an.f.a.a("FileStreamUtils", "getCacheData " + str + " success");
                    fileInputStream.close();
                    sb = new StringBuilder();
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
            } catch (IOException e) {
                com.opos.cmn.an.f.a.d("FileStreamUtils", "getCacheData " + str + " fail:", e);
                sb = new StringBuilder();
            }
            com.opos.cmn.an.f.a.a("FileStreamUtils", sb.append(str).append(" close file success").toString());
            return bArr;
        } catch (Throwable th4) {
            com.opos.cmn.an.f.a.a("FileStreamUtils", str + " close file success");
            throw th4;
        }
    }
}
