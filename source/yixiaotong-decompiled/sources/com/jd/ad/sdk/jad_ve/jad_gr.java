package com.jd.ad.sdk.jad_ve;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_gr implements jad_mx<com.jd.ad.sdk.jad_sb.jad_na> {
    public static final jad_gr jad_an = new jad_gr();
    public static final com.jd.ad.sdk.jad_wf.jad_cp.jad_an jad_bo = com.jd.ad.sdk.jad_wf.jad_cp.jad_an.jad_an("c", "v", "i", "o");

    @Override // com.jd.ad.sdk.jad_ve.jad_mx
    public com.jd.ad.sdk.jad_sb.jad_na jad_an(com.jd.ad.sdk.jad_wf.jad_cp jad_cpVar, float f) {
        if (jad_cpVar.jad_mz() == 1) {
            jad_cpVar.jad_bo();
        }
        jad_cpVar.jad_cp();
        List<PointF> listJad_bo = null;
        List<PointF> listJad_bo2 = null;
        List<PointF> listJad_bo3 = null;
        boolean zJad_hu = false;
        while (jad_cpVar.jad_jt()) {
            int iJad_an = jad_cpVar.jad_an(jad_bo);
            if (iJad_an == 0) {
                zJad_hu = jad_cpVar.jad_hu();
            } else if (iJad_an == 1) {
                listJad_bo = jad_sf.jad_bo(jad_cpVar, f);
            } else if (iJad_an == 2) {
                listJad_bo2 = jad_sf.jad_bo(jad_cpVar, f);
            } else if (iJad_an != 3) {
                jad_cpVar.jad_na();
                jad_cpVar.jad_ob();
            } else {
                listJad_bo3 = jad_sf.jad_bo(jad_cpVar, f);
            }
        }
        jad_cpVar.jad_er();
        if (jad_cpVar.jad_mz() == 2) {
            jad_cpVar.jad_dq();
        }
        if (listJad_bo == null || listJad_bo2 == null || listJad_bo3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listJad_bo.isEmpty()) {
            return new com.jd.ad.sdk.jad_sb.jad_na(new PointF(), false, Collections.emptyList());
        }
        int size = listJad_bo.size();
        PointF pointF = listJad_bo.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 1; i < size; i++) {
            PointF pointF2 = listJad_bo.get(i);
            int i2 = i - 1;
            arrayList.add(new com.jd.ad.sdk.jad_qz.jad_an(com.jd.ad.sdk.jad_xg.jad_jt.jad_an(listJad_bo.get(i2), listJad_bo3.get(i2)), com.jd.ad.sdk.jad_xg.jad_jt.jad_an(pointF2, listJad_bo2.get(i)), pointF2));
        }
        if (zJad_hu) {
            PointF pointF3 = listJad_bo.get(0);
            int i3 = size - 1;
            arrayList.add(new com.jd.ad.sdk.jad_qz.jad_an(com.jd.ad.sdk.jad_xg.jad_jt.jad_an(listJad_bo.get(i3), listJad_bo3.get(i3)), com.jd.ad.sdk.jad_xg.jad_jt.jad_an(pointF3, listJad_bo2.get(0)), pointF3));
        }
        return new com.jd.ad.sdk.jad_sb.jad_na(pointF, zJad_hu, arrayList);
    }
}
