package com.jd.ad.sdk.jad_ra;

import android.graphics.PointF;
import com.jd.ad.sdk.jad_ox.jad_pc;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_ly implements com.jd.ad.sdk.jad_sb.jad_cp {
    public final jad_er jad_an;
    public final jad_mz<PointF, PointF> jad_bo;
    public final jad_jt jad_cp;
    public final jad_bo jad_dq;
    public final jad_dq jad_er;
    public final jad_bo jad_fs;
    public final jad_bo jad_hu;
    public final jad_bo jad_iv;
    public final jad_bo jad_jt;

    public jad_ly() {
        this(null, null, null, null, null, null, null, null, null);
    }

    public jad_ly(jad_er jad_erVar, jad_mz<PointF, PointF> jad_mzVar, jad_jt jad_jtVar, jad_bo jad_boVar, jad_dq jad_dqVar, jad_bo jad_boVar2, jad_bo jad_boVar3, jad_bo jad_boVar4, jad_bo jad_boVar5) {
        this.jad_an = jad_erVar;
        this.jad_bo = jad_mzVar;
        this.jad_cp = jad_jtVar;
        this.jad_dq = jad_boVar;
        this.jad_er = jad_dqVar;
        this.jad_hu = jad_boVar2;
        this.jad_iv = jad_boVar3;
        this.jad_fs = jad_boVar4;
        this.jad_jt = jad_boVar5;
    }

    @Override // com.jd.ad.sdk.jad_sb.jad_cp
    public com.jd.ad.sdk.jad_nw.jad_cp jad_an(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar) {
        return null;
    }

    public jad_pc jad_an() {
        return new jad_pc(this);
    }

    public jad_er jad_bo() {
        return this.jad_an;
    }

    public jad_bo jad_cp() {
        return this.jad_iv;
    }

    public jad_dq jad_dq() {
        return this.jad_er;
    }

    public jad_mz<PointF, PointF> jad_er() {
        return this.jad_bo;
    }

    public jad_bo jad_fs() {
        return this.jad_dq;
    }

    public jad_bo jad_hu() {
        return this.jad_fs;
    }

    public jad_bo jad_iv() {
        return this.jad_jt;
    }

    public jad_jt jad_jt() {
        return this.jad_cp;
    }

    public jad_bo jad_jw() {
        return this.jad_hu;
    }
}
