package com.jd.ad.sdk.jad_ox;

import android.graphics.PointF;
import java.util.Collections;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_na extends jad_an<PointF, PointF> {
    public final PointF jad_iv;
    public final PointF jad_jw;
    public final jad_an<Float, Float> jad_kx;
    public final jad_an<Float, Float> jad_ly;
    public com.jd.ad.sdk.jad_yh.jad_cp<Float> jad_mz;
    public com.jd.ad.sdk.jad_yh.jad_cp<Float> jad_na;

    public jad_na(jad_an<Float, Float> jad_anVar, jad_an<Float, Float> jad_anVar2) {
        super(Collections.emptyList());
        this.jad_iv = new PointF();
        this.jad_jw = new PointF();
        this.jad_kx = jad_anVar;
        this.jad_ly = jad_anVar2;
        jad_an(jad_er());
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an
    public void jad_an(float f) {
        this.jad_kx.jad_an(f);
        this.jad_ly.jad_an(f);
        this.jad_iv.set(this.jad_kx.jad_fs().floatValue(), this.jad_ly.jad_fs().floatValue());
        for (int i = 0; i < this.jad_an.size(); i++) {
            this.jad_an.get(i).jad_an();
        }
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an
    /* JADX INFO: renamed from: jad_bo, reason: merged with bridge method [inline-methods] */
    public PointF jad_an(com.jd.ad.sdk.jad_yh.jad_an<PointF> jad_anVar, float f) {
        Float fJad_an;
        com.jd.ad.sdk.jad_yh.jad_an<Float> jad_anVarJad_an;
        com.jd.ad.sdk.jad_yh.jad_an<Float> jad_anVarJad_an2;
        Float fJad_an2 = null;
        if (this.jad_mz == null || (jad_anVarJad_an2 = this.jad_kx.jad_an()) == null) {
            fJad_an = null;
        } else {
            float fJad_cp = this.jad_kx.jad_cp();
            Float f2 = jad_anVarJad_an2.jad_hu;
            com.jd.ad.sdk.jad_yh.jad_cp<Float> jad_cpVar = this.jad_mz;
            float f3 = jad_anVarJad_an2.jad_jt;
            fJad_an = jad_cpVar.jad_an(f3, f2 == null ? f3 : f2.floatValue(), jad_anVarJad_an2.jad_bo, jad_anVarJad_an2.jad_cp, f, f, fJad_cp);
        }
        if (this.jad_na != null && (jad_anVarJad_an = this.jad_ly.jad_an()) != null) {
            float fJad_cp2 = this.jad_ly.jad_cp();
            Float f4 = jad_anVarJad_an.jad_hu;
            com.jd.ad.sdk.jad_yh.jad_cp<Float> jad_cpVar2 = this.jad_na;
            float f5 = jad_anVarJad_an.jad_jt;
            fJad_an2 = jad_cpVar2.jad_an(f5, f4 == null ? f5 : f4.floatValue(), jad_anVarJad_an.jad_bo, jad_anVarJad_an.jad_cp, f, f, fJad_cp2);
        }
        if (fJad_an == null) {
            this.jad_jw.set(this.jad_iv.x, 0.0f);
        } else {
            this.jad_jw.set(fJad_an.floatValue(), 0.0f);
        }
        PointF pointF = this.jad_jw;
        pointF.set(pointF.x, fJad_an2 == null ? this.jad_iv.y : fJad_an2.floatValue());
        return this.jad_jw;
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an
    public PointF jad_fs() {
        return jad_an(null, 0.0f);
    }
}
