package com.jd.ad.sdk.jad_ve;

import android.graphics.PointF;
import com.kuaishou.weapon.p0.t;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an {
    public static final com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_an = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an(t.f4727a, "x", "y");

    public static com.jd.ad.sdk.jad_ra.jad_er jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
        ArrayList arrayList = new ArrayList();
        if (jad_cpVar.jad_mz() == 1) {
            jad_cpVar.jad_bo();
            while (jad_cpVar.jad_jt()) {
                arrayList.add(new com.jd.ad.sdk.jad_ox.jad_iv(jad_jtVar, jad_tg.jad_an(jad_cpVar, jad_jtVar, com.jd.ad.sdk.jad_xg.jad_hu.jad_an(), jad_yl.jad_an, jad_cpVar.jad_mz() == 3, false)));
            }
            jad_cpVar.jad_dq();
            jad_uh.jad_an(arrayList);
        } else {
            arrayList.add(new com.jd.ad.sdk.jad_yh.jad_an(jad_sf.jad_an(jad_cpVar, com.jd.ad.sdk.jad_xg.jad_hu.jad_an())));
        }
        return new com.jd.ad.sdk.jad_ra.jad_er(arrayList);
    }

    public static com.jd.ad.sdk.jad_ra.jad_mz<PointF, PointF> jad_bo(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
        jad_cpVar.jad_cp();
        com.jd.ad.sdk.jad_ra.jad_er jad_erVarJad_an = null;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVarJad_an = null;
        boolean z = false;
        com.jd.ad.sdk.jad_ra.jad_bo jad_boVarJad_an2 = null;
        while (jad_cpVar.jad_mz() != 4) {
            int iJad_an = jad_cpVar.jad_an(jad_an);
            if (iJad_an == 0) {
                jad_erVarJad_an = jad_an(jad_cpVar, jad_jtVar);
            } else if (iJad_an != 1) {
                if (iJad_an != 2) {
                    jad_cpVar.jad_na();
                    jad_cpVar.jad_ob();
                } else if (jad_cpVar.jad_mz() == 6) {
                    jad_cpVar.jad_ob();
                    z = true;
                } else {
                    jad_boVarJad_an = jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
                }
            } else if (jad_cpVar.jad_mz() == 6) {
                jad_cpVar.jad_ob();
                z = true;
            } else {
                jad_boVarJad_an2 = jad_dq.jad_an(jad_cpVar, jad_jtVar, true);
            }
        }
        jad_cpVar.jad_er();
        if (z) {
            jad_jtVar.jad_an("Lottie doesn't support expressions.");
        }
        return jad_erVarJad_an != null ? jad_erVarJad_an : new com.jd.ad.sdk.jad_ra.jad_iv(jad_boVarJad_an2, jad_boVarJad_an);
    }
}
