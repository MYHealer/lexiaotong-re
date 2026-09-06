package com.jd.ad.sdk.jad_ve;

import android.graphics.Color;
import android.graphics.PointF;
import com.jd.ad.sdk.a.a;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_sf {
    public static final com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_an = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an("x", "y");

    public static /* synthetic */ class jad_an {
        public static final /* synthetic */ int[] jad_an;

        static {
            int[] iArr = new int[com.jd.ad.sdk.jad_jt.jad_fs.jad_bo(10).length];
            jad_an = iArr;
            try {
                iArr[6] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                jad_an[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                jad_an[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static int jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar) {
        jad_cpVar.jad_bo();
        int iJad_iv = (int) (jad_cpVar.jad_iv() * 255.0d);
        int iJad_iv2 = (int) (jad_cpVar.jad_iv() * 255.0d);
        int iJad_iv3 = (int) (jad_cpVar.jad_iv() * 255.0d);
        while (jad_cpVar.jad_jt()) {
            jad_cpVar.jad_ob();
        }
        jad_cpVar.jad_dq();
        return Color.argb(255, iJad_iv, iJad_iv2, iJad_iv3);
    }

    public static PointF jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, float f) {
        int i = jad_an.jad_an[com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_cpVar.jad_mz())];
        if (i == 1) {
            float fJad_iv = (float) jad_cpVar.jad_iv();
            float fJad_iv2 = (float) jad_cpVar.jad_iv();
            while (jad_cpVar.jad_jt()) {
                jad_cpVar.jad_ob();
            }
            return new PointF(fJad_iv * f, fJad_iv2 * f);
        }
        if (i == 2) {
            jad_cpVar.jad_bo();
            float fJad_iv3 = (float) jad_cpVar.jad_iv();
            float fJad_iv4 = (float) jad_cpVar.jad_iv();
            while (jad_cpVar.jad_mz() != 2) {
                jad_cpVar.jad_ob();
            }
            jad_cpVar.jad_dq();
            return new PointF(fJad_iv3 * f, fJad_iv4 * f);
        }
        if (i != 3) {
            throw new IllegalArgumentException(com.jd.ad.sdk.jad_lu.jad_zm.jad_an("Unknown point starts with ").append(com.jd.ad.sdk.jad_wf.jad_dq.jad_an(jad_cpVar.jad_mz())).toString());
        }
        jad_cpVar.jad_cp();
        float fJad_bo = 0.0f;
        float fJad_bo2 = 0.0f;
        while (jad_cpVar.jad_jt()) {
            int iJad_an = jad_cpVar.jad_an(jad_an);
            if (iJad_an == 0) {
                fJad_bo2 = jad_bo(jad_cpVar);
            } else if (iJad_an != 1) {
                jad_cpVar.jad_na();
                jad_cpVar.jad_ob();
            } else {
                fJad_bo = jad_bo(jad_cpVar);
            }
        }
        jad_cpVar.jad_er();
        return new PointF(fJad_bo2 * f, fJad_bo * f);
    }

    public static float jad_bo(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar) {
        int iJad_mz = jad_cpVar.jad_mz();
        int i = jad_an.jad_an[com.jd.ad.sdk.jad_jt.jad_fs.jad_an(iJad_mz)];
        if (i == 1) {
            return (float) jad_cpVar.jad_iv();
        }
        if (i != 2) {
            throw new IllegalArgumentException(a.a("Unknown value for token of type ").append(com.jd.ad.sdk.jad_wf.jad_dq.jad_an(iJad_mz)).toString());
        }
        jad_cpVar.jad_bo();
        float fJad_iv = (float) jad_cpVar.jad_iv();
        while (jad_cpVar.jad_jt()) {
            jad_cpVar.jad_ob();
        }
        jad_cpVar.jad_dq();
        return fJad_iv;
    }

    public static List<PointF> jad_bo(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, float f) {
        ArrayList arrayList = new ArrayList();
        jad_cpVar.jad_bo();
        while (jad_cpVar.jad_mz() == 1) {
            jad_cpVar.jad_bo();
            arrayList.add(jad_an(jad_cpVar, f));
            jad_cpVar.jad_dq();
        }
        jad_cpVar.jad_dq();
        return arrayList;
    }
}
