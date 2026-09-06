package com.jd.ad.sdk.jad_tc;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.jd.ad.sdk.jad_lu.jad_mz;
import com.jd.ad.sdk.jad_lu.jad_vi;
import com.jd.ad.sdk.jad_lu.jad_zm;
import com.jd.ad.sdk.jad_ox.jad_pc;
import com.jd.ad.sdk.jad_sb.jad_na;
import com.jd.ad.sdk.jad_ve.jad_jw;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class jad_an implements com.jd.ad.sdk.jad_nw.jad_er, com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an, com.jd.ad.sdk.jad_qz.jad_fs {
    public BlurMaskFilter jad_cn;
    public final Paint jad_fs;
    public final RectF jad_hu;
    public final RectF jad_iv;
    public final Paint jad_jt;
    public final RectF jad_jw;
    public final RectF jad_kx;
    public final String jad_ly;
    public final Matrix jad_mz;
    public final jad_mz jad_na;
    public final jad_er jad_ob;
    public com.jd.ad.sdk.jad_ox.jad_hu jad_pc;
    public com.jd.ad.sdk.jad_ox.jad_dq jad_qd;
    public jad_an jad_re;
    public jad_an jad_sf;
    public List<jad_an> jad_tg;
    public final List<com.jd.ad.sdk.jad_ox.jad_an<?, ?>> jad_uh;
    public final jad_pc jad_vi;
    public boolean jad_wj;
    public boolean jad_xk;
    public Paint jad_yl;
    public float jad_zm;
    public final Path jad_an = new Path();
    public final Matrix jad_bo = new Matrix();
    public final Paint jad_cp = new com.jd.ad.sdk.jad_mv.jad_an(1);
    public final Paint jad_dq = new com.jd.ad.sdk.jad_mv.jad_an(1, PorterDuff.Mode.DST_IN);
    public final Paint jad_er = new com.jd.ad.sdk.jad_mv.jad_an(1, PorterDuff.Mode.DST_OUT);

    public jad_an(jad_mz jad_mzVar, jad_er jad_erVar) {
        com.jd.ad.sdk.jad_mv.jad_an jad_anVar = new com.jd.ad.sdk.jad_mv.jad_an(1);
        this.jad_fs = jad_anVar;
        this.jad_jt = new com.jd.ad.sdk.jad_mv.jad_an(PorterDuff.Mode.CLEAR);
        this.jad_hu = new RectF();
        this.jad_iv = new RectF();
        this.jad_jw = new RectF();
        this.jad_kx = new RectF();
        this.jad_mz = new Matrix();
        this.jad_uh = new ArrayList();
        this.jad_wj = true;
        this.jad_zm = 0.0f;
        this.jad_na = jad_mzVar;
        this.jad_ob = jad_erVar;
        this.jad_ly = jad_erVar.jad_er() + "#draw";
        jad_anVar.setXfermode(jad_erVar.jad_dq() == 3 ? new PorterDuffXfermode(PorterDuff.Mode.DST_OUT) : new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        jad_pc jad_pcVarJad_an = jad_erVar.jad_ly().jad_an();
        this.jad_vi = jad_pcVarJad_an;
        jad_pcVarJad_an.jad_an((com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an) this);
        if (jad_erVar.jad_cp() != null && !jad_erVar.jad_cp().isEmpty()) {
            com.jd.ad.sdk.jad_ox.jad_hu jad_huVar = new com.jd.ad.sdk.jad_ox.jad_hu(jad_erVar.jad_cp());
            this.jad_pc = jad_huVar;
            Iterator<com.jd.ad.sdk.jad_ox.jad_an<jad_na, Path>> it = jad_huVar.jad_an().iterator();
            while (it.hasNext()) {
                it.next().jad_an(this);
            }
            for (com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_anVar2 : this.jad_pc.jad_bo()) {
                jad_an(jad_anVar2);
                jad_anVar2.jad_an(this);
            }
        }
        jad_kx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void jad_jw() {
        jad_bo(this.jad_qd.jad_hu() == 1.0f);
    }

    public BlurMaskFilter jad_an(float f) {
        if (this.jad_zm == f) {
            return this.jad_cn;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.jad_cn = blurMaskFilter;
        this.jad_zm = f;
        return blurMaskFilter;
    }

    public final void jad_an(Canvas canvas) {
        RectF rectF = this.jad_hu;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.jad_jt);
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#clearLayer");
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0131  */
    /* JADX WARN: Code duplicated, block: B:49:0x0137  */
    @Override // com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(Canvas canvas, Matrix matrix, int i) {
        float f;
        RectF rectF;
        Paint paint;
        String str = this.jad_ly;
        if (!this.jad_wj || this.jad_ob.jad_vi) {
            com.jd.ad.sdk.jad_lu.jad_dq.jad_an(str);
            return;
        }
        jad_dq();
        this.jad_bo.reset();
        this.jad_bo.set(matrix);
        int i2 = 1;
        for (int size = this.jad_tg.size() - 1; size >= 0; size--) {
            this.jad_bo.preConcat(this.jad_tg.get(size).jad_vi.jad_bo());
        }
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#parentMatrix");
        com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_anVar = this.jad_vi.jad_jw;
        int iIntValue = (int) ((((i / 255.0f) * (jad_anVar == null ? 100 : jad_anVar.jad_fs().intValue())) / 100.0f) * 255.0f);
        if (!jad_iv() && !jad_hu()) {
            this.jad_bo.preConcat(this.jad_vi.jad_bo());
            jad_bo(canvas, this.jad_bo, iIntValue);
            com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#drawLayer");
            jad_bo(com.jd.ad.sdk.jad_lu.jad_dq.jad_an(this.jad_ly));
            return;
        }
        boolean z = false;
        jad_an(this.jad_hu, this.jad_bo, false);
        RectF rectF2 = this.jad_hu;
        int i3 = 3;
        if (jad_iv() && this.jad_ob.jad_uh != 3) {
            this.jad_jw.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.jad_re.jad_an(this.jad_jw, matrix, true);
            if (!rectF2.intersect(this.jad_jw)) {
                rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
        this.jad_bo.preConcat(this.jad_vi.jad_bo());
        RectF rectF3 = this.jad_hu;
        Matrix matrix2 = this.jad_bo;
        this.jad_iv.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i4 = 2;
        if (jad_hu()) {
            int size2 = this.jad_pc.jad_cp.size();
            int i5 = 0;
            while (true) {
                if (i5 < size2) {
                    com.jd.ad.sdk.jad_sb.jad_jt jad_jtVar = this.jad_pc.jad_cp.get(i5);
                    Path pathJad_fs = this.jad_pc.jad_an.get(i5).jad_fs();
                    if (pathJad_fs != null) {
                        this.jad_an.set(pathJad_fs);
                        this.jad_an.transform(matrix2);
                        int iJad_an = com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_jtVar.jad_an);
                        if (iJad_an != 0) {
                            if (iJad_an != 1) {
                                if (iJad_an != i4) {
                                    if (iJad_an == i3) {
                                    }
                                    this.jad_an.computeBounds(this.jad_kx, z);
                                    rectF = this.jad_iv;
                                    if (i5 == 0) {
                                        rectF.set(this.jad_kx);
                                    } else {
                                        rectF.set(Math.min(rectF.left, this.jad_kx.left), Math.min(this.jad_iv.top, this.jad_kx.top), Math.max(this.jad_iv.right, this.jad_kx.right), Math.max(this.jad_iv.bottom, this.jad_kx.bottom));
                                    }
                                }
                            }
                        }
                        if (jad_jtVar.jad_dq) {
                        }
                        this.jad_an.computeBounds(this.jad_kx, z);
                        rectF = this.jad_iv;
                        if (i5 == 0) {
                            rectF.set(this.jad_kx);
                        } else {
                            rectF.set(Math.min(rectF.left, this.jad_kx.left), Math.min(this.jad_iv.top, this.jad_kx.top), Math.max(this.jad_iv.right, this.jad_kx.right), Math.max(this.jad_iv.bottom, this.jad_kx.bottom));
                        }
                    }
                    i5++;
                    z = false;
                    i3 = 3;
                    i4 = 2;
                } else if (!rectF3.intersect(this.jad_iv)) {
                    f = 0.0f;
                    rectF3.set(0.0f, 0.0f, 0.0f, 0.0f);
                    break;
                }
                f = 0.0f;
                break;
            }
        } else {
            f = 0.0f;
        }
        if (!this.jad_hu.intersect(f, f, canvas.getWidth(), canvas.getHeight())) {
            this.jad_hu.set(f, f, f, f);
        }
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#computeBounds");
        if (this.jad_hu.width() >= 1.0f && this.jad_hu.height() >= 1.0f) {
            this.jad_cp.setAlpha(255);
            com.jd.ad.sdk.jad_xg.jad_hu.jad_an(canvas, this.jad_hu, this.jad_cp, 31);
            com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#saveLayer");
            jad_an(canvas);
            jad_bo(canvas, this.jad_bo, iIntValue);
            com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#drawLayer");
            if (jad_hu()) {
                Matrix matrix3 = this.jad_bo;
                com.jd.ad.sdk.jad_xg.jad_hu.jad_an(canvas, this.jad_hu, this.jad_dq, 19);
                if (Build.VERSION.SDK_INT < 28) {
                    jad_an(canvas);
                }
                com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#saveLayer");
                int i6 = 0;
                while (i6 < this.jad_pc.jad_cp.size()) {
                    com.jd.ad.sdk.jad_sb.jad_jt jad_jtVar2 = this.jad_pc.jad_cp.get(i6);
                    com.jd.ad.sdk.jad_ox.jad_an<jad_na, Path> jad_anVar2 = this.jad_pc.jad_an.get(i6);
                    com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_anVar3 = this.jad_pc.jad_bo.get(i6);
                    int iJad_an2 = com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_jtVar2.jad_an);
                    if (iJad_an2 != 0) {
                        if (iJad_an2 == i2) {
                            if (i6 == 0) {
                                this.jad_cp.setColor(-16777216);
                                this.jad_cp.setAlpha(255);
                                canvas.drawRect(this.jad_hu, this.jad_cp);
                            }
                            if (jad_jtVar2.jad_dq) {
                                com.jd.ad.sdk.jad_xg.jad_hu.jad_an(canvas, this.jad_hu, this.jad_er, 31);
                                canvas.drawRect(this.jad_hu, this.jad_cp);
                                this.jad_er.setAlpha((int) (jad_anVar3.jad_fs().intValue() * 2.55f));
                                this.jad_an.set(jad_anVar2.jad_fs());
                                this.jad_an.transform(matrix3);
                                canvas.drawPath(this.jad_an, this.jad_er);
                                canvas.restore();
                            } else {
                                this.jad_an.set(jad_anVar2.jad_fs());
                                this.jad_an.transform(matrix3);
                                canvas.drawPath(this.jad_an, this.jad_er);
                            }
                        } else if (iJad_an2 != 2) {
                            if (iJad_an2 == 3 && !this.jad_pc.jad_an.isEmpty()) {
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= this.jad_pc.jad_cp.size()) {
                                        this.jad_cp.setAlpha(255);
                                        canvas.drawRect(this.jad_hu, this.jad_cp);
                                        break;
                                    } else if (this.jad_pc.jad_cp.get(i7).jad_an != 4) {
                                        break;
                                    } else {
                                        i7++;
                                    }
                                }
                            }
                        } else if (jad_jtVar2.jad_dq) {
                            com.jd.ad.sdk.jad_xg.jad_hu.jad_an(canvas, this.jad_hu, this.jad_dq, 31);
                            canvas.drawRect(this.jad_hu, this.jad_cp);
                            this.jad_er.setAlpha((int) (jad_anVar3.jad_fs().intValue() * 2.55f));
                            this.jad_an.set(jad_anVar2.jad_fs());
                            this.jad_an.transform(matrix3);
                            canvas.drawPath(this.jad_an, this.jad_er);
                            canvas.restore();
                        } else {
                            com.jd.ad.sdk.jad_xg.jad_hu.jad_an(canvas, this.jad_hu, this.jad_dq, 31);
                            this.jad_an.set(jad_anVar2.jad_fs());
                            this.jad_an.transform(matrix3);
                            this.jad_cp.setAlpha((int) (jad_anVar3.jad_fs().intValue() * 2.55f));
                            canvas.drawPath(this.jad_an, this.jad_cp);
                            canvas.restore();
                        }
                    } else if (jad_jtVar2.jad_dq) {
                        com.jd.ad.sdk.jad_xg.jad_hu.jad_an(canvas, this.jad_hu, this.jad_cp, 31);
                        canvas.drawRect(this.jad_hu, this.jad_cp);
                        this.jad_an.set(jad_anVar2.jad_fs());
                        this.jad_an.transform(matrix3);
                        this.jad_cp.setAlpha((int) (jad_anVar3.jad_fs().intValue() * 2.55f));
                        canvas.drawPath(this.jad_an, this.jad_er);
                        canvas.restore();
                    } else {
                        this.jad_an.set(jad_anVar2.jad_fs());
                        this.jad_an.transform(matrix3);
                        this.jad_cp.setAlpha((int) (jad_anVar3.jad_fs().intValue() * 2.55f));
                        canvas.drawPath(this.jad_an, this.jad_cp);
                    }
                    i6++;
                    i2 = 1;
                }
                canvas.restore();
                com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#restoreLayer");
            }
            if (jad_iv()) {
                com.jd.ad.sdk.jad_xg.jad_hu.jad_an(canvas, this.jad_hu, this.jad_fs, 19);
                com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#saveLayer");
                jad_an(canvas);
                this.jad_re.jad_an(canvas, matrix, iIntValue);
                canvas.restore();
                com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#restoreLayer");
                com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#drawMatte");
            }
            canvas.restore();
            com.jd.ad.sdk.jad_lu.jad_dq.jad_an("Layer#restoreLayer");
        }
        if (this.jad_xk && (paint = this.jad_yl) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.jad_yl.setColor(-251901);
            this.jad_yl.setStrokeWidth(4.0f);
            canvas.drawRect(this.jad_hu, this.jad_yl);
            this.jad_yl.setStyle(Paint.Style.FILL);
            this.jad_yl.setColor(1357638635);
            canvas.drawRect(this.jad_hu, this.jad_yl);
        }
        jad_bo(com.jd.ad.sdk.jad_lu.jad_dq.jad_an(this.jad_ly));
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(RectF rectF, Matrix matrix, boolean z) {
        this.jad_hu.set(0.0f, 0.0f, 0.0f, 0.0f);
        jad_dq();
        this.jad_mz.set(matrix);
        if (z) {
            List<jad_an> list = this.jad_tg;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.jad_mz.preConcat(this.jad_tg.get(size).jad_vi.jad_bo());
                }
            } else {
                jad_an jad_anVar = this.jad_sf;
                if (jad_anVar != null) {
                    this.jad_mz.preConcat(jad_anVar.jad_vi.jad_bo());
                }
            }
        }
        this.jad_mz.preConcat(this.jad_vi.jad_bo());
    }

    public void jad_an(com.jd.ad.sdk.jad_ox.jad_an<?, ?> jad_anVar) {
        if (jad_anVar == null) {
            return;
        }
        this.jad_uh.add(jad_anVar);
    }

    public void jad_an(jad_an jad_anVar) {
        this.jad_re = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t, com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        this.jad_vi.jad_an(t, jad_cpVar);
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public void jad_an(List<com.jd.ad.sdk.jad_nw.jad_cp> list, List<com.jd.ad.sdk.jad_nw.jad_cp> list2) {
    }

    public void jad_an(boolean z) {
        if (z && this.jad_yl == null) {
            this.jad_yl = new com.jd.ad.sdk.jad_mv.jad_an();
        }
        this.jad_xk = z;
    }

    public final void jad_bo(float f) {
        jad_vi jad_viVar = this.jad_na.jad_bo.jad_an;
        String str = this.jad_ob.jad_cp;
        if (jad_viVar.jad_an) {
            com.jd.ad.sdk.jad_xg.jad_fs jad_fsVar = jad_viVar.jad_cp.get(str);
            if (jad_fsVar == null) {
                jad_fsVar = new com.jd.ad.sdk.jad_xg.jad_fs();
                jad_viVar.jad_cp.put(str, jad_fsVar);
            }
            float f2 = jad_fsVar.jad_an + f;
            jad_fsVar.jad_an = f2;
            int i = jad_fsVar.jad_bo + 1;
            jad_fsVar.jad_bo = i;
            if (i == Integer.MAX_VALUE) {
                jad_fsVar.jad_an = f2 / 2.0f;
                jad_fsVar.jad_bo = i / 2;
            }
            if (str.equals("__container")) {
                Iterator<jad_vi.jad_an> it = jad_viVar.jad_bo.iterator();
                while (it.hasNext()) {
                    it.next().jad_an(f);
                }
            }
        }
    }

    public abstract void jad_bo(Canvas canvas, Matrix matrix, int i);

    public void jad_bo(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, int i, List<com.jd.ad.sdk.jad_qz.jad_er> list, com.jd.ad.sdk.jad_qz.jad_er jad_erVar2) {
    }

    public void jad_bo(jad_an jad_anVar) {
        this.jad_sf = jad_anVar;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public String jad_cp() {
        return this.jad_ob.jad_cp;
    }

    public final void jad_dq() {
        if (this.jad_tg != null) {
            return;
        }
        if (this.jad_sf == null) {
            this.jad_tg = Collections.emptyList();
            return;
        }
        this.jad_tg = new ArrayList();
        for (jad_an jad_anVar = this.jad_sf; jad_anVar != null; jad_anVar = jad_anVar.jad_sf) {
            this.jad_tg.add(jad_anVar);
        }
    }

    public com.jd.ad.sdk.jad_sb.jad_an jad_er() {
        return this.jad_ob.jad_wj;
    }

    public jad_jw jad_fs() {
        return this.jad_ob.jad_xk;
    }

    public boolean jad_hu() {
        com.jd.ad.sdk.jad_ox.jad_hu jad_huVar = this.jad_pc;
        return (jad_huVar == null || jad_huVar.jad_an.isEmpty()) ? false : true;
    }

    public boolean jad_iv() {
        return this.jad_re != null;
    }

    public jad_er jad_jt() {
        return this.jad_ob;
    }

    public final void jad_kx() {
        if (this.jad_ob.jad_tg.isEmpty()) {
            jad_bo(true);
            return;
        }
        com.jd.ad.sdk.jad_ox.jad_dq jad_dqVar = new com.jd.ad.sdk.jad_ox.jad_dq(this.jad_ob.jad_tg);
        this.jad_qd = jad_dqVar;
        jad_dqVar.jad_bo = true;
        jad_dqVar.jad_an.add(new com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an() { // from class: com.jd.ad.sdk.jad_tc.jad_an$$ExternalSyntheticLambda0
            @Override // com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an
            public final void jad_an() {
                this.f$0.jad_jw();
            }
        });
        jad_bo(this.jad_qd.jad_fs().floatValue() == 1.0f);
        jad_an(this.jad_qd);
    }

    public void jad_cp(float f) {
        jad_pc jad_pcVar = this.jad_vi;
        com.jd.ad.sdk.jad_ox.jad_an<Integer, Integer> jad_anVar = jad_pcVar.jad_jw;
        if (jad_anVar != null) {
            jad_anVar.jad_an(f);
        }
        com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_anVar2 = jad_pcVar.jad_mz;
        if (jad_anVar2 != null) {
            jad_anVar2.jad_an(f);
        }
        com.jd.ad.sdk.jad_ox.jad_an<?, Float> jad_anVar3 = jad_pcVar.jad_na;
        if (jad_anVar3 != null) {
            jad_anVar3.jad_an(f);
        }
        com.jd.ad.sdk.jad_ox.jad_an<PointF, PointF> jad_anVar4 = jad_pcVar.jad_fs;
        if (jad_anVar4 != null) {
            jad_anVar4.jad_an(f);
        }
        com.jd.ad.sdk.jad_ox.jad_an<?, PointF> jad_anVar5 = jad_pcVar.jad_jt;
        if (jad_anVar5 != null) {
            jad_anVar5.jad_an(f);
        }
        com.jd.ad.sdk.jad_ox.jad_an<com.jd.ad.sdk.jad_yh.jad_dq, com.jd.ad.sdk.jad_yh.jad_dq> jad_anVar6 = jad_pcVar.jad_hu;
        if (jad_anVar6 != null) {
            jad_anVar6.jad_an(f);
        }
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVar7 = jad_pcVar.jad_iv;
        if (jad_anVar7 != null) {
            jad_anVar7.jad_an(f);
        }
        com.jd.ad.sdk.jad_ox.jad_dq jad_dqVar = jad_pcVar.jad_kx;
        if (jad_dqVar != null) {
            jad_dqVar.jad_an(f);
        }
        com.jd.ad.sdk.jad_ox.jad_dq jad_dqVar2 = jad_pcVar.jad_ly;
        if (jad_dqVar2 != null) {
            jad_dqVar2.jad_an(f);
        }
        if (this.jad_pc != null) {
            for (int i = 0; i < this.jad_pc.jad_an.size(); i++) {
                this.jad_pc.jad_an.get(i).jad_an(f);
            }
        }
        com.jd.ad.sdk.jad_ox.jad_dq jad_dqVar3 = this.jad_qd;
        if (jad_dqVar3 != null) {
            jad_dqVar3.jad_an(f);
        }
        jad_an jad_anVar8 = this.jad_re;
        if (jad_anVar8 != null) {
            jad_anVar8.jad_cp(f);
        }
        for (int i2 = 0; i2 < this.jad_uh.size(); i2++) {
            this.jad_uh.get(i2).jad_an(f);
        }
    }

    public final void jad_bo(boolean z) {
        if (z != this.jad_wj) {
            this.jad_wj = z;
            this.jad_na.invalidateSelf();
        }
    }

    public static jad_an jad_an(jad_bo jad_boVar, jad_er jad_erVar, jad_mz jad_mzVar, com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar) {
        int iJad_an = com.jd.ad.sdk.jad_jt.jad_fs.jad_an(jad_erVar.jad_er);
        if (iJad_an == 0) {
            return new jad_bo(jad_mzVar, jad_erVar, jad_jtVar.jad_cp.get(jad_erVar.jad_jt), jad_jtVar);
        }
        if (iJad_an == 1) {
            return new jad_hu(jad_mzVar, jad_erVar);
        }
        if (iJad_an == 2) {
            return new jad_cp(jad_mzVar, jad_erVar);
        }
        if (iJad_an == 3) {
            return new jad_fs(jad_mzVar, jad_erVar);
        }
        if (iJad_an == 4) {
            return new jad_jt(jad_mzVar, jad_erVar, jad_boVar);
        }
        if (iJad_an == 5) {
            return new jad_iv(jad_mzVar, jad_erVar);
        }
        com.jd.ad.sdk.jad_xg.jad_dq.jad_an(jad_zm.jad_an("Unknown layer type ").append(jad_dq.jad_an(jad_erVar.jad_er)).toString());
        return null;
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an
    public void jad_an() {
        this.jad_na.invalidateSelf();
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public void jad_an(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, int i, List<com.jd.ad.sdk.jad_qz.jad_er> list, com.jd.ad.sdk.jad_qz.jad_er jad_erVar2) {
        jad_an jad_anVar = this.jad_re;
        if (jad_anVar != null) {
            com.jd.ad.sdk.jad_qz.jad_er jad_erVarJad_an = jad_erVar2.jad_an(jad_anVar.jad_ob.jad_cp);
            if (jad_erVar.jad_an(this.jad_re.jad_ob.jad_cp, i)) {
                list.add(jad_erVarJad_an.jad_an(this.jad_re));
            }
            if (jad_erVar.jad_dq(this.jad_ob.jad_cp, i)) {
                this.jad_re.jad_bo(jad_erVar, jad_erVar.jad_bo(this.jad_re.jad_ob.jad_cp, i) + i, list, jad_erVarJad_an);
            }
        }
        if (jad_erVar.jad_cp(this.jad_ob.jad_cp, i)) {
            if (!"__container".equals(this.jad_ob.jad_cp)) {
                jad_erVar2 = jad_erVar2.jad_an(this.jad_ob.jad_cp);
                if (jad_erVar.jad_an(this.jad_ob.jad_cp, i)) {
                    list.add(jad_erVar2.jad_an(this));
                }
            }
            if (jad_erVar.jad_dq(this.jad_ob.jad_cp, i)) {
                jad_bo(jad_erVar, jad_erVar.jad_bo(this.jad_ob.jad_cp, i) + i, list, jad_erVar2);
            }
        }
    }
}
