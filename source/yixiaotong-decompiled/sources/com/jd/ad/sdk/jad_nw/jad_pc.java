package com.jd.ad.sdk.jad_nw;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_pc implements jad_er, jad_mz, jad_jw, com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an, jad_kx {
    public final Matrix jad_an = new Matrix();
    public final Path jad_bo = new Path();
    public final com.jd.ad.sdk.jad_lu.jad_mz jad_cp;
    public final com.jd.ad.sdk.jad_tc.jad_an jad_dq;
    public final String jad_er;
    public final boolean jad_fs;
    public final com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_hu;
    public final com.jd.ad.sdk.jad_ox.jad_pc jad_iv;
    public final com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_jt;
    public jad_dq jad_jw;

    public jad_pc(com.jd.ad.sdk.jad_lu.jad_mz jad_mzVar, com.jd.ad.sdk.jad_tc.jad_an jad_anVar, com.jd.ad.sdk.jad_sb.jad_mz jad_mzVar2) {
        this.jad_cp = jad_mzVar;
        this.jad_dq = jad_anVar;
        this.jad_er = jad_mzVar2.jad_bo();
        this.jad_fs = jad_mzVar2.jad_er();
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVarJad_an = jad_mzVar2.jad_an().jad_an();
        this.jad_jt = jad_anVarJad_an;
        jad_anVar.jad_an(jad_anVarJad_an);
        jad_anVarJad_an.jad_an(this);
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVarJad_an2 = jad_mzVar2.jad_cp().jad_an();
        this.jad_hu = jad_anVarJad_an2;
        jad_anVar.jad_an(jad_anVarJad_an2);
        jad_anVarJad_an2.jad_an(this);
        com.jd.ad.sdk.jad_ox.jad_pc jad_pcVarJad_an = jad_mzVar2.jad_dq().jad_an();
        this.jad_iv = jad_pcVarJad_an;
        jad_pcVarJad_an.jad_an(jad_anVar);
        jad_pcVarJad_an.jad_an(this);
    }

    @Override // com.jd.ad.sdk.jad_ox.jad_an.InterfaceC0570jad_an
    public void jad_an() {
        this.jad_cp.invalidateSelf();
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(RectF rectF, Matrix matrix, boolean z) {
        this.jad_jw.jad_an(rectF, matrix, z);
    }

    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public void jad_an(com.jd.ad.sdk.jad_qz.jad_er jad_erVar, int i, List<com.jd.ad.sdk.jad_qz.jad_er> list, com.jd.ad.sdk.jad_qz.jad_er jad_erVar2) {
        com.jd.ad.sdk.jad_xg.jad_jt.jad_an(jad_erVar, i, list, jad_erVar2, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.jd.ad.sdk.jad_qz.jad_fs
    public <T> void jad_an(T t, com.jd.ad.sdk.jad_yh.jad_cp<T> jad_cpVar) {
        com.jd.ad.sdk.jad_ox.jad_an<Float, Float> jad_anVar;
        if (this.jad_iv.jad_an(t, jad_cpVar)) {
            return;
        }
        if (t == com.jd.ad.sdk.jad_lu.jad_re.jad_uh) {
            jad_anVar = this.jad_jt;
        } else if (t != com.jd.ad.sdk.jad_lu.jad_re.jad_vi) {
            return;
        } else {
            jad_anVar = this.jad_hu;
        }
        jad_anVar.jad_er = jad_cpVar;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public void jad_an(List<jad_cp> list, List<jad_cp> list2) {
        this.jad_jw.jad_an(list, list2);
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_jw
    public void jad_an(ListIterator<jad_cp> listIterator) {
        if (this.jad_jw != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.jad_jw = new jad_dq(this.jad_cp, this.jad_dq, "Repeater", this.jad_fs, arrayList, null);
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_mz
    public Path jad_bo() {
        Path pathJad_bo = this.jad_jw.jad_bo();
        this.jad_bo.reset();
        float fFloatValue = this.jad_jt.jad_fs().floatValue();
        float fFloatValue2 = this.jad_hu.jad_fs().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.jad_an.set(this.jad_iv.jad_an(i + fFloatValue2));
            this.jad_bo.addPath(pathJad_bo, this.jad_an);
        }
        return this.jad_bo;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_cp
    public String jad_cp() {
        return this.jad_er;
    }

    @Override // com.jd.ad.sdk.jad_nw.jad_er
    public void jad_an(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.jad_jt.jad_fs().floatValue();
        float fFloatValue2 = this.jad_hu.jad_fs().floatValue();
        float fFloatValue3 = this.jad_iv.jad_mz.jad_fs().floatValue() / 100.0f;
        float fFloatValue4 = this.jad_iv.jad_na.jad_fs().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.jad_an.set(matrix);
            float f = i2;
            this.jad_an.preConcat(this.jad_iv.jad_an(f + fFloatValue2));
            this.jad_jw.jad_an(canvas, this.jad_an, (int) (com.jd.ad.sdk.jad_xg.jad_jt.jad_an(fFloatValue3, fFloatValue4, f / fFloatValue) * i));
        }
    }
}
