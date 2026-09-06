package com.jd.ad.sdk.jad_nw;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_ob implements com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an, jad_kx, jad_mz {
    public final String jad_cp;
    public final boolean jad_dq;
    public final com.jd.ad.sdk.jad_lu.jad_mz jad_er;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, PointF> jad_fs;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_hu;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, PointF> jad_jt;
    public boolean jad_jw;
    public final Path jad_an = new Path();
    public final RectF jad_bo = new RectF();
    public final jad_bo jad_iv = new jad_bo();

    public jad_ob(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, com.jd.ad.sdk.jad_sb.jad_ly jad_lyVar) {
        this.jad_cp = jad_lyVar.jad_bo();
        this.jad_dq = jad_lyVar.jad_er();
        this.jad_er = jad_mzVar;
        com.jd.ad.sdk.jad_ox.jad_an<PointF, PointF> jad_anVarJad_an = jad_lyVar.jad_cp().jad_an();
        this.jad_fs = jad_anVarJad_an;
        com.jd.ad.sdk.jad_ox.jad_an<PointF, PointF> jad_anVarJad_an2 = jad_lyVar.jad_dq().jad_an();
        this.jad_jt = jad_anVarJad_an2;
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVarJad_an3 = jad_lyVar.jad_an().jad_an();
        this.jad_hu = jad_anVarJad_an3;
        jad_anVar.jad_an(jad_anVarJad_an);
        jad_anVar.jad_an(jad_anVarJad_an2);
        jad_anVar.jad_an(jad_anVarJad_an3);
        jad_anVarJad_an.jad_an(this);
        jad_anVarJad_an2.jad_an(this);
        jad_anVarJad_an3.jad_an(this);
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public void jad_an(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, int i, List<com.jd.ad.sdk.jad_qz.jad_er> list, com.jd.ad.sdk.jad_qz.jad_er jad_erVar2) {
        com.jd.ad.sdk.jad_xg.jad_jt.jad_an(jad_erVar, i, list, jad_erVar2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t, com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_ox.jad_an jad_anVar;
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_ly) {
            jad_anVar = this.jad_jt;
        } else if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_na) {
            jad_anVar = this.jad_fs;
        } else if (t != com.jd.ad.sdk.jad_lu.jad_re.jad_mz) {
            return;
        } else {
            jad_anVar = this.jad_hu;
        }
        jad_anVar.jad_er = jad_cpVar;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_mz
    public Path jad_bo() {
        if (this.jad_jw) {
            return this.jad_an;
        }
        this.jad_an.reset();
        if (!this.jad_dq) {
            PointF pointFJad_fs = this.jad_jt.jad_fs();
            float f = pointFJad_fs.x / 2.0f;
            float f2 = pointFJad_fs.y / 2.0f;
            com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_anVar = this.jad_hu;
            float fJad_hu = jad_anVar == null ? 0.0f : ((com.jd.ad.sdk.jad_ox.jad_dq) jad_anVar).jad_hu();
            float fMin = Math.min(f, f2);
            if (fJad_hu > fMin) {
                fJad_hu = fMin;
            }
            PointF pointFJad_fs2 = this.jad_fs.jad_fs();
            this.jad_an.moveTo(pointFJad_fs2.x + f, (pointFJad_fs2.y - f2) + fJad_hu);
            this.jad_an.lineTo(pointFJad_fs2.x + f, (pointFJad_fs2.y + f2) - fJad_hu);
            if (fJad_hu > 0.0f) {
                RectF rectF = this.jad_bo;
                float f3 = pointFJad_fs2.x + f;
                float f4 = fJad_hu * 2.0f;
                float f5 = pointFJad_fs2.y + f2;
                rectF.set(f3 - f4, f5 - f4, f3, f5);
                this.jad_an.arcTo(this.jad_bo, 0.0f, 90.0f, false);
            }
            this.jad_an.lineTo((pointFJad_fs2.x - f) + fJad_hu, pointFJad_fs2.y + f2);
            if (fJad_hu > 0.0f) {
                RectF rectF2 = this.jad_bo;
                float f6 = pointFJad_fs2.x - f;
                float f7 = pointFJad_fs2.y + f2;
                float f8 = fJad_hu * 2.0f;
                rectF2.set(f6, f7 - f8, f8 + f6, f7);
                this.jad_an.arcTo(this.jad_bo, 90.0f, 90.0f, false);
            }
            this.jad_an.lineTo(pointFJad_fs2.x - f, (pointFJad_fs2.y - f2) + fJad_hu);
            if (fJad_hu > 0.0f) {
                RectF rectF3 = this.jad_bo;
                float f9 = pointFJad_fs2.x - f;
                float f10 = pointFJad_fs2.y - f2;
                float f11 = fJad_hu * 2.0f;
                rectF3.set(f9, f10, f9 + f11, f11 + f10);
                this.jad_an.arcTo(this.jad_bo, 180.0f, 90.0f, false);
            }
            this.jad_an.lineTo((pointFJad_fs2.x + f) - fJad_hu, pointFJad_fs2.y - f2);
            if (fJad_hu > 0.0f) {
                RectF rectF4 = this.jad_bo;
                float f12 = pointFJad_fs2.x + f;
                float f13 = fJad_hu * 2.0f;
                float f14 = pointFJad_fs2.y - f2;
                rectF4.set(f12 - f13, f14, f12, f13 + f14);
                this.jad_an.arcTo(this.jad_bo, 270.0f, 90.0f, false);
            }
            this.jad_an.close();
            this.jad_iv.jad_an(this.jad_an);
        }
        this.jad_jw = true;
        return this.jad_an;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public String jad_cp() {
        return this.jad_cp;
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an
    public void jad_an() {
        this.jad_jw = false;
        this.jad_er.invalidateSelf();
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public void jad_an(List<jad_cp> list, List<jad_cp> list2) {
        for (int i = 0; i < list.size(); i++) {
            jad_cp jad_cpVar = list.get(i);
            if (jad_cpVar instanceof jad_sf) {
                jad_sf jad_sfVar = (jad_sf) jad_cpVar;
                if (jad_sfVar.jad_dq == 1) {
                    this.jad_iv.jad_an.add(jad_sfVar);
                    jad_sfVar.jad_cp.add(this);
                }
            }
        }
    }
}
