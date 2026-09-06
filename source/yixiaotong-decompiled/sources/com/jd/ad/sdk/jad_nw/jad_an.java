package com.jd.ad.sdk.jad_nw;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class jad_an implements com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an, jad_kx, jad_er {
    public final com.jd.ad.sdk.jad_lu.jad_mz jad_er;
    public final com.jd.ad.sdk.jad_tc.jad_an jad_fs;
    public final float[] jad_hu;
    public final Paint jad_iv;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_jw;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, Integer> jad_kx;
    public final List<com.jd.ad.sdk.jad_ox.jad_an<?, Float>> jad_ly;
    public final com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_mz;
    public com.jd.ad.sdk.jad_ox.jad_an<ColorFilter, ColorFilter> jad_na;
    public com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_ob;
    public float jad_pc;
    public com.jd.ad.sdk.jad_ox.jad_cp jad_qd;
    public final PathMeasure jad_an = new PathMeasure();
    public final Path jad_bo = new Path();
    public final Path jad_cp = new Path();
    public final RectF jad_dq = new RectF();
    public final List<C0569jad_an> jad_jt = new ArrayList();

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_nw.jad_an$jad_an, reason: collision with other inner class name */
    public static final class C0569jad_an {
        public final List<jad_mz> jad_an = new ArrayList();
        public final jad_sf jad_bo;

        public C0569jad_an(jad_sf jad_sfVar) {
            this.jad_bo = jad_sfVar;
        }
    }

    public jad_an(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, Paint.Cap cap, Paint.Join join, float f, com.jd.ad.sdk.jad_ra.jad_dq jad_dqVar, com.jd.ad.sdk.jad_ra.jad_bo jad_boVar, List<com.jd.ad.sdk.jad_ra.jad_bo> list, com.jd.ad.sdk.jad_ra.jad_bo jad_boVar2) {
        com.jd.ad.sdk.jad_mv.jad_an jad_anVar2 = new com.jd.ad.sdk.jad_mv.jad_an(1);
        this.jad_iv = jad_anVar2;
        this.jad_pc = 0.0f;
        this.jad_er = jad_mzVar;
        this.jad_fs = jad_anVar;
        jad_anVar2.setStyle(Paint.Style.STROKE);
        jad_anVar2.setStrokeCap(cap);
        jad_anVar2.setStrokeJoin(join);
        jad_anVar2.setStrokeMiter(f);
        this.jad_kx = jad_dqVar.jad_an();
        this.jad_jw = jad_boVar.jad_an();
        this.jad_mz = jad_boVar2 == null ? null : jad_boVar2.jad_an();
        this.jad_ly = new ArrayList(list.size());
        this.jad_hu = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.jad_ly.add(list.get(i).jad_an());
        }
        jad_anVar.jad_an(this.jad_kx);
        jad_anVar.jad_an(this.jad_jw);
        for (int i2 = 0; i2 < this.jad_ly.size(); i2++) {
            jad_anVar.jad_an(this.jad_ly.get(i2));
        }
        com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_anVar3 = this.jad_mz;
        if (jad_anVar3 != null) {
            jad_anVar.jad_an(jad_anVar3);
        }
        this.jad_kx.jad_an(this);
        this.jad_jw.jad_an(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.jad_ly.get(i3).jad_an(this);
        }
        com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_anVar4 = this.jad_mz;
        if (jad_anVar4 != null) {
            jad_anVar4.jad_an(this);
        }
        if (jad_anVar.jad_er() != null) {
            com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVarJad_an = jad_anVar.jad_er().jad_an().jad_an();
            this.jad_ob = jad_anVarJad_an;
            jad_anVarJad_an.jad_an(this);
            jad_anVar.jad_an(this.jad_ob);
        }
        if (jad_anVar.jad_fs() != null) {
            this.jad_qd = new com.jd.ad.sdk.jad_ox.jad_cp(this, jad_anVar, jad_anVar.jad_fs());
        }
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an
    public void jad_an() {
        this.jad_er.invalidateSelf();
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public void jad_an(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, int i, List<com.jd.ad.sdk.jad_qz.jad_er> list, com.jd.ad.sdk.jad_qz.jad_er jad_erVar2) {
        com.jd.ad.sdk.jad_xg.jad_jt.jad_an(jad_erVar, i, list, jad_erVar2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t, com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar2;
        com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar3;
        com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar4;
        com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar5;
        com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar6;
        com.jd.ad.sdk.jad_ox.jad_an jad_anVar;
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_dq) {
            jad_anVar = this.jad_kx;
        } else {
            if (t != com.jd.ad.sdk.jad_lu.jad_re.jad_sf) {
                if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_mx) {
                    com.jd.ad.sdk.jad_ox.jad_an<ColorFilter, ColorFilter> jad_anVar2 = this.jad_na;
                    if (jad_anVar2 != null) {
                        this.jad_fs.jad_uh.remove(jad_anVar2);
                    }
                    if (jad_cpVar == 0) {
                        this.jad_na = null;
                        return;
                    }
                    com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
                    this.jad_na = jad_qdVar;
                    jad_qdVar.jad_an.add(this);
                    this.jad_fs.jad_an(this.jad_na);
                    return;
                }
                if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_jw) {
                    com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVar3 = this.jad_ob;
                    if (jad_anVar3 != null) {
                        jad_anVar3.jad_er = jad_cpVar;
                        return;
                    }
                    com.jd.ad.sdk.jad_ox.jad_qd jad_qdVar2 = new com.jd.ad.sdk.jad_ox.jad_qd(jad_cpVar, null);
                    this.jad_ob = jad_qdVar2;
                    jad_qdVar2.jad_an.add(this);
                    this.jad_fs.jad_an(this.jad_ob);
                    return;
                }
                if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_er && (jad_cpVar6 = this.jad_qd) != null) {
                    jad_cpVar6.jad_bo.jad_er = jad_cpVar;
                    return;
                }
                if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_it && (jad_cpVar5 = this.jad_qd) != null) {
                    jad_cpVar5.jad_an((com.jd.ad.sdk.jad_yh.jad_cp<Float>) jad_cpVar);
                    return;
                }
                if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_ju && (jad_cpVar4 = this.jad_qd) != null) {
                    jad_cpVar4.jad_dq.jad_er = jad_cpVar;
                    return;
                }
                if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_kv && (jad_cpVar3 = this.jad_qd) != null) {
                    jad_cpVar3.jad_er.jad_er = jad_cpVar;
                    return;
                } else {
                    if (t != com.jd.ad.sdk.jad_lu.jad_re.jad_lw || (jad_cpVar2 = this.jad_qd) == null) {
                        return;
                    }
                    jad_cpVar2.jad_fs.jad_er = jad_cpVar;
                    return;
                }
            }
            jad_anVar = this.jad_jw;
        }
        jad_anVar.jad_er = jad_cpVar;
    }

    /* JADX WARN: Code duplicated, block: B:71:0x021d  */
    @Override // com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(Canvas canvas, Matrix matrix, int i) {
        float f;
        float[] fArr = com.jd.ad.sdk.jad_xg.jad_hu.jad_dq.get();
        boolean z = false;
        fArr[0] = 0.0f;
        int i2 = 1;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        if (fArr[0] == fArr[2] || fArr[1] == fArr[3]) {
            com.jd.ad.sdk.jad_lu.jad_dq.jad_an("StrokeContent#draw");
            return;
        }
        com.jd.ad.sdk.jad_ox.jad_fs jad_fsVar = (com.jd.ad.sdk.jad_ox.jad_fs) this.jad_kx;
        float fJad_bo = (i / 255.0f) * jad_fsVar.jad_bo(jad_fsVar.jad_an(), jad_fsVar.jad_cp());
        float f2 = 100.0f;
        Paint paint = this.jad_iv;
        PointF pointF = com.jd.ad.sdk.jad_xg.jad_jt.jad_an;
        paint.setAlpha(Math.max(0, Math.min(255, (int) ((fJad_bo / 100.0f) * 255.0f))));
        this.jad_iv.setStrokeWidth(com.jd.ad.sdk.jad_xg.jad_hu.jad_an(matrix) * ((com.jd.ad.sdk.jad_ox.jad_dq) this.jad_jw).jad_hu());
        if (this.jad_iv.getStrokeWidth() <= 0.0f) {
            com.jd.ad.sdk.jad_lu.jad_dq.jad_an("StrokeContent#draw");
            return;
        }
        float f3 = 1.0f;
        if (!this.jad_ly.isEmpty()) {
            float fJad_an = com.jd.ad.sdk.jad_xg.jad_hu.jad_an(matrix);
            for (int i3 = 0; i3 < this.jad_ly.size(); i3++) {
                this.jad_hu[i3] = this.jad_ly.get(i3).jad_fs().floatValue();
                if (i3 % 2 == 0) {
                    float[] fArr2 = this.jad_hu;
                    if (fArr2[i3] < 1.0f) {
                        fArr2[i3] = 1.0f;
                    }
                } else {
                    float[] fArr3 = this.jad_hu;
                    if (fArr3[i3] < 0.1f) {
                        fArr3[i3] = 0.1f;
                    }
                }
                float[] fArr4 = this.jad_hu;
                fArr4[i3] = fArr4[i3] * fJad_an;
            }
            com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_anVar = this.jad_mz;
            this.jad_iv.setPathEffect(new DashPathEffect(this.jad_hu, jad_anVar == null ? 0.0f : jad_anVar.jad_fs().floatValue() * fJad_an));
        }
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("StrokeContent#applyDashPattern");
        com.jd.ad.sdk.jad_ox.jad_an<ColorFilter, ColorFilter> jad_anVar2 = this.jad_na;
        if (jad_anVar2 != null) {
            this.jad_iv.setColorFilter(jad_anVar2.jad_fs());
        }
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVar3 = this.jad_ob;
        if (jad_anVar3 != null) {
            float fFloatValue = jad_anVar3.jad_fs().floatValue();
            if (fFloatValue == 0.0f) {
                this.jad_iv.setMaskFilter(null);
            } else if (fFloatValue != this.jad_pc) {
                this.jad_iv.setMaskFilter(this.jad_fs.jad_an(fFloatValue));
            }
            this.jad_pc = fFloatValue;
        }
        com.jd.ad.sdk.jad_ox.jad_cp jad_cpVar = this.jad_qd;
        if (jad_cpVar != null) {
            jad_cpVar.jad_an(this.jad_iv);
        }
        int i4 = 0;
        while (i4 < this.jad_jt.size()) {
            C0569jad_an c0569jad_an = this.jad_jt.get(i4);
            if (c0569jad_an.jad_bo != null) {
                this.jad_bo.reset();
                for (int size = c0569jad_an.jad_an.size() - i2; size >= 0; size--) {
                    this.jad_bo.addPath(c0569jad_an.jad_an.get(size).jad_bo(), matrix);
                }
                this.jad_an.setPath(this.jad_bo, z);
                float length = this.jad_an.getLength();
                while (this.jad_an.nextContour()) {
                    length += this.jad_an.getLength();
                }
                float fFloatValue2 = (c0569jad_an.jad_bo.jad_jt.jad_fs().floatValue() * length) / 360.0f;
                float fFloatValue3 = ((c0569jad_an.jad_bo.jad_er.jad_fs().floatValue() / f2) * length) + fFloatValue2;
                float fFloatValue4 = ((c0569jad_an.jad_bo.jad_fs.jad_fs().floatValue() / f2) * length) + fFloatValue2;
                int size2 = c0569jad_an.jad_an.size() - i2;
                float f4 = 0.0f;
                while (size2 >= 0) {
                    this.jad_cp.set(c0569jad_an.jad_an.get(size2).jad_bo());
                    this.jad_cp.transform(matrix);
                    this.jad_an.setPath(this.jad_cp, z);
                    float length2 = this.jad_an.getLength();
                    if (fFloatValue4 > length) {
                        float f5 = fFloatValue4 - length;
                        if (f5 >= f4 + length2 || f4 >= f5) {
                            f = f4 + length2;
                            if (f < fFloatValue3 && f4 <= fFloatValue4) {
                                if (f > fFloatValue4 || fFloatValue3 >= f4) {
                                    com.jd.ad.sdk.jad_xg.jad_hu.jad_an(this.jad_cp, fFloatValue3 < f4 ? 0.0f : (fFloatValue3 - f4) / length2, fFloatValue4 > f ? 1.0f : (fFloatValue4 - f4) / length2, 0.0f);
                                }
                            }
                        } else {
                            com.jd.ad.sdk.jad_xg.jad_hu.jad_an(this.jad_cp, fFloatValue3 > length ? (fFloatValue3 - length) / length2 : 0.0f, Math.min(f5 / length2, f3), 0.0f);
                        }
                        canvas.drawPath(this.jad_cp, this.jad_iv);
                    } else {
                        f = f4 + length2;
                        if (f < fFloatValue3) {
                        }
                    }
                    f4 += length2;
                    size2--;
                    z = false;
                    f3 = 1.0f;
                }
                com.jd.ad.sdk.jad_lu.jad_dq.jad_an("StrokeContent#applyTrimPath");
                i2 = 1;
            } else {
                this.jad_bo.reset();
                i2 = 1;
                for (int size3 = c0569jad_an.jad_an.size() - 1; size3 >= 0; size3--) {
                    this.jad_bo.addPath(c0569jad_an.jad_an.get(size3).jad_bo(), matrix);
                }
                com.jd.ad.sdk.jad_lu.jad_dq.jad_an("StrokeContent#buildPath");
                canvas.drawPath(this.jad_bo, this.jad_iv);
                com.jd.ad.sdk.jad_lu.jad_dq.jad_an("StrokeContent#drawPath");
            }
            i4++;
            z = false;
            f2 = 100.0f;
            f3 = 1.0f;
        }
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("StrokeContent#draw");
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(RectF rectF, Matrix matrix, boolean z) {
        this.jad_bo.reset();
        for (int i = 0; i < this.jad_jt.size(); i++) {
            C0569jad_an c0569jad_an = this.jad_jt.get(i);
            for (int i2 = 0; i2 < c0569jad_an.jad_an.size(); i2++) {
                this.jad_bo.addPath(c0569jad_an.jad_an.get(i2).jad_bo(), matrix);
            }
        }
        this.jad_bo.computeBounds(this.jad_dq, false);
        float fJad_hu = ((com.jd.ad.sdk.jad_ox.jad_dq) this.jad_jw).jad_hu();
        RectF rectF2 = this.jad_dq;
        float f = fJad_hu / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.jad_dq);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("StrokeContent#getBounds");
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0052  */
    /* JADX WARN: Code duplicated, block: B:24:0x0056 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0058  */
    /* JADX WARN: Code duplicated, block: B:38:0x0064 A[SYNTHETIC] */
    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public void jad_an(List<jad_cp> list, List<jad_cp> list2) {
        C0569jad_an c0569jad_an = null;
        jad_sf jad_sfVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            jad_cp jad_cpVar = list.get(size);
            if (jad_cpVar instanceof jad_sf) {
                jad_sf jad_sfVar2 = (jad_sf) jad_cpVar;
                if (jad_sfVar2.jad_dq == 2) {
                    jad_sfVar = jad_sfVar2;
                }
            }
        }
        if (jad_sfVar != null) {
            jad_sfVar.jad_cp.add(this);
        }
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            jad_cp jad_cpVar2 = list2.get(size2);
            if (jad_cpVar2 instanceof jad_sf) {
                jad_sf jad_sfVar3 = (jad_sf) jad_cpVar2;
                if (jad_sfVar3.jad_dq == 2) {
                    if (c0569jad_an != null) {
                        this.jad_jt.add(c0569jad_an);
                    }
                    C0569jad_an c0569jad_an2 = new C0569jad_an(jad_sfVar3);
                    jad_sfVar3.jad_cp.add(this);
                    c0569jad_an = c0569jad_an2;
                } else if (!(jad_cpVar2 instanceof jad_mz)) {
                    if (c0569jad_an == null) {
                        c0569jad_an = new C0569jad_an(jad_sfVar);
                    }
                    c0569jad_an.jad_an.add((jad_mz) jad_cpVar2);
                }
            } else if (!(jad_cpVar2 instanceof jad_mz)) {
                if (c0569jad_an == null) {
                    c0569jad_an = new C0569jad_an(jad_sfVar);
                }
                c0569jad_an.jad_an.add((jad_mz) jad_cpVar2);
            }
        }
        if (c0569jad_an != null) {
            this.jad_jt.add(c0569jad_an);
        }
    }
}
