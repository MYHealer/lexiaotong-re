package com.jd.ad.sdk.jad_tc;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.jd.ad.sdk.jad_lu.jad_mz;
import com.jd.ad.sdk.jad_sb.jad_pc;
import com.jd.ad.sdk.jad_ve.jad_jw;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_jt extends jad_an {
    public final com.jd.ad.sdk.jad_nw.jad_dq jad_do;
    public final jad_bo jad_ep;

    public jad_jt(jad_mz jad_mzVar, jad_er jad_erVar, jad_bo jad_boVar) {
        super(jad_mzVar, jad_erVar);
        this.jad_ep = jad_boVar;
        com.jd.ad.sdk.jad_nw.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_nw.jad_dq(jad_mzVar, this, new jad_pc("__container", jad_erVar.jad_jt(), false));
        this.jad_do = jad_dqVar;
        jad_dqVar.jad_an(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an, com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(RectF rectF, Matrix matrix, boolean z) {
        super.jad_an(rectF, matrix, z);
        this.jad_do.jad_an(rectF, this.jad_mz, z);
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an
    public void jad_bo(Canvas canvas, Matrix matrix, int i) {
        this.jad_do.jad_an(canvas, matrix, i);
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an
    public void jad_bo(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, int i, List<com.jd.ad.sdk.jad_qz.jad_er> list, com.jd.ad.sdk.jad_qz.jad_er jad_erVar2) {
        this.jad_do.jad_an(jad_erVar, i, list, jad_erVar2);
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an
    public com.jd.ad.sdk.jad_sb.jad_an jad_er() {
        com.jd.ad.sdk.jad_sb.jad_an jad_anVar = this.jad_ob.jad_wj;
        return jad_anVar != null ? jad_anVar : this.jad_ep.jad_ob.jad_wj;
    }

    @Override // com.jd.ad.sdk.jad_tc.jad_an
    public jad_jw jad_fs() {
        jad_jw jad_jwVar = this.jad_ob.jad_xk;
        return jad_jwVar != null ? jad_jwVar : this.jad_ep.jad_ob.jad_xk;
    }
}
