package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
import com.huawei.hms.ml.scan.HmsScan;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: RemoteDecoderWork.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class v5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile v5 f4363a;

    public HmsScan[] b(Bitmap bitmap, int i, boolean z, g3 g3Var) {
        g3.c cVarA;
        if (g3Var != null) {
            g3Var.a("single");
            cVarA = g3Var.a(z, bitmap.getHeight() * bitmap.getWidth());
            if (bitmap.getHeight() < 30 || bitmap.getWidth() < 30) {
                cVarA.a(-1005);
            }
        } else {
            cVarA = null;
        }
        HmsScan[] hmsScanArrA = x5.a(g1.b(bitmap, new b6(i, z)));
        if (g3Var != null) {
            g3Var.a(hmsScanArrA, cVarA);
        }
        return hmsScanArrA;
    }

    public static v5 a() {
        if (f4363a == null) {
            synchronized (v5.class) {
                if (f4363a == null) {
                    f4363a = new v5();
                }
            }
        }
        return f4363a;
    }

    public HmsScan[] a(Bitmap bitmap, int i, boolean z, g3 g3Var) {
        g3.c cVarA;
        if (g3Var != null) {
            g3Var.a("multi");
            cVarA = g3Var.a(z, bitmap.getHeight() * bitmap.getWidth());
            if (bitmap.getHeight() < 30 || bitmap.getWidth() < 30) {
                cVarA.a(-1005);
            }
        } else {
            cVarA = null;
        }
        HmsScan[] hmsScanArrA = x5.a(g1.a(bitmap, new b6(i, z)));
        if (g3Var != null) {
            g3Var.a(hmsScanArrA, cVarA);
        }
        return hmsScanArrA;
    }

    public HmsScan[] a(ByteBuffer byteBuffer, int i, int i2, int i3, boolean z, g3 g3Var) {
        g3.c cVarA;
        if (g3Var != null) {
            g3Var.a("multi");
            int i4 = i2 * i;
            cVarA = g3Var.a(z, i4);
            if (i >= 30 && i2 >= 30) {
                if (byteBuffer.array().length < i4) {
                    cVarA.a(-1008);
                }
            } else {
                cVarA.a(-1007);
            }
        } else {
            cVarA = null;
        }
        HmsScan[] hmsScanArrA = x5.a(g1.a(byteBuffer, new b6(i, i2, i3, true, z)));
        if (g3Var != null) {
            g3Var.a(hmsScanArrA, cVarA);
        }
        return hmsScanArrA;
    }
}
