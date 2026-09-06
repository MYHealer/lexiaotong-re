package com.jd.ad.sdk.jad_sb;

import android.graphics.PointF;
import com.jd.ad.sdk.jad_lu.jad_zm;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_ly implements jad_cp {
    public final String jad_an;
    public final com.jd.ad.sdk.jad_ra.jad_mz<PointF, PointF> jad_bo;
    public final com.jd.ad.sdk.jad_ra.jad_mz<PointF, PointF> jad_cp;
    public final com.jd.ad.sdk.jad_ra.jad_bo jad_dq;
    public final boolean jad_er;

    public jad_ly(String str, com.jd.ad.sdk.jad_ra.jad_mz<PointF, PointF> jad_mzVar, com.jd.ad.sdk.jad_ra.jad_mz<PointF, PointF> jad_mzVar2, com.jd.ad.sdk.jad_ra.jad_bo jad_boVar, boolean z) {
        this.jad_an = str;
        this.jad_bo = jad_mzVar;
        this.jad_cp = jad_mzVar2;
        this.jad_dq = jad_boVar;
        this.jad_er = z;
    }

    @Override // com.jd.ad.sdk.jad_sb.jad_cp
    public com.jd.ad.sdk.jad_nw.jad_cp jad_an(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar) {
        return new com.jd.ad.sdk.jad_nw.jad_ob(jad_mzVar, jad_anVar, this);
    }

    public com.jd.ad.sdk.jad_ra.jad_bo jad_an() {
        return this.jad_dq;
    }

    public String jad_bo() {
        return this.jad_an;
    }

    public com.jd.ad.sdk.jad_ra.jad_mz<PointF, PointF> jad_cp() {
        return this.jad_bo;
    }

    public com.jd.ad.sdk.jad_ra.jad_mz<PointF, PointF> jad_dq() {
        return this.jad_cp;
    }

    public boolean jad_er() {
        return this.jad_er;
    }

    public String toString() {
        return jad_zm.jad_an("RectangleShape{position=").append(this.jad_bo).append(", size=").append(this.jad_cp).append('}').toString();
    }
}
