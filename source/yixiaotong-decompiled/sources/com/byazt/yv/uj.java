package com.byazt.yv;

import com.huawei.openalliance.ad.constant.ai;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, ai.y, 15})
public class uj {
    /* JADX WARN: Code duplicated, block: B:24:0x0046  */
    /* JADX WARN: Code duplicated, block: B:42:? A[RETURN, SYNTHETIC] */
    public static byte[] c(String str) {
        byte[] byteArray;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8192);
        GZIPOutputStream gZIPOutputStream = null;
        try {
            try {
                if (com.byazt.gj.c.x()) {
                    GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream2.write(str.getBytes("UTF-8"));
                        gZIPOutputStream = gZIPOutputStream2;
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        try {
                            da.tt(th);
                            if (gZIPOutputStream != null) {
                                gZIPOutputStream.close();
                            }
                            byteArray = byteArrayOutputStream.toByteArray();
                            if (com.byazt.gj.c.x()) {
                                return com.byakv.z.TTEncryptUtils.c(byteArray, byteArray.length);
                            }
                            return byteArray;
                        } catch (Throwable th2) {
                            if (gZIPOutputStream != null) {
                                try {
                                    gZIPOutputStream.close();
                                } catch (IOException e) {
                                    da.tt(e);
                                }
                            }
                            throw th2;
                        }
                    }
                } else {
                    byteArrayOutputStream.write(str.getBytes("UTF-8"));
                }
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                }
            } catch (IOException e2) {
                da.tt(e2);
            }
        } catch (Throwable th3) {
            th = th3;
        }
        byteArray = byteArrayOutputStream.toByteArray();
        if (com.byazt.gj.c.x()) {
            return com.byakv.z.TTEncryptUtils.c(byteArray, byteArray.length);
        }
        return byteArray;
    }
}
