package com.jd.ad.sdk.jad_yh;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.jd.ad.sdk.jad_lu.jad_jt;
import com.jd.ad.sdk.jad_lu.jad_zm;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_an<T> {
    public final jad_jt jad_an;
    public final T jad_bo;
    public T jad_cp;
    public final Interpolator jad_dq;
    public final Interpolator jad_er;
    public final Interpolator jad_fs;
    public Float jad_hu;
    public float jad_iv;
    public final float jad_jt;
    public float jad_jw;
    public int jad_kx;
    public int jad_ly;
    public float jad_mz;
    public float jad_na;
    public PointF jad_ob;
    public PointF jad_pc;

    public jad_an(jad_jt jad_jtVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.jad_iv = -3987645.8f;
        this.jad_jw = -3987645.8f;
        this.jad_kx = 784923401;
        this.jad_ly = 784923401;
        this.jad_mz = Float.MIN_VALUE;
        this.jad_na = Float.MIN_VALUE;
        this.jad_ob = null;
        this.jad_pc = null;
        this.jad_an = jad_jtVar;
        this.jad_bo = t;
        this.jad_cp = t2;
        this.jad_dq = interpolator;
        this.jad_er = null;
        this.jad_fs = null;
        this.jad_jt = f;
        this.jad_hu = f2;
    }

    public jad_an(jad_jt jad_jtVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, float f, Float f2) {
        this.jad_iv = -3987645.8f;
        this.jad_jw = -3987645.8f;
        this.jad_kx = 784923401;
        this.jad_ly = 784923401;
        this.jad_mz = Float.MIN_VALUE;
        this.jad_na = Float.MIN_VALUE;
        this.jad_ob = null;
        this.jad_pc = null;
        this.jad_an = jad_jtVar;
        this.jad_bo = t;
        this.jad_cp = t2;
        this.jad_dq = null;
        this.jad_er = interpolator;
        this.jad_fs = interpolator2;
        this.jad_jt = f;
        this.jad_hu = null;
    }

    public jad_an(jad_jt jad_jtVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f2) {
        this.jad_iv = -3987645.8f;
        this.jad_jw = -3987645.8f;
        this.jad_kx = 784923401;
        this.jad_ly = 784923401;
        this.jad_mz = Float.MIN_VALUE;
        this.jad_na = Float.MIN_VALUE;
        this.jad_ob = null;
        this.jad_pc = null;
        this.jad_an = jad_jtVar;
        this.jad_bo = t;
        this.jad_cp = t2;
        this.jad_dq = interpolator;
        this.jad_er = interpolator2;
        this.jad_fs = interpolator3;
        this.jad_jt = f;
        this.jad_hu = f2;
    }

    public jad_an(T t) {
        this.jad_iv = -3987645.8f;
        this.jad_jw = -3987645.8f;
        this.jad_kx = 784923401;
        this.jad_ly = 784923401;
        this.jad_mz = Float.MIN_VALUE;
        this.jad_na = Float.MIN_VALUE;
        this.jad_ob = null;
        this.jad_pc = null;
        this.jad_an = null;
        this.jad_bo = t;
        this.jad_cp = t;
        this.jad_dq = null;
        this.jad_er = null;
        this.jad_fs = null;
        this.jad_jt = Float.MIN_VALUE;
        this.jad_hu = Float.valueOf(Float.MAX_VALUE);
    }

    public float jad_an() {
        float fFloatValue = 1.0f;
        if (this.jad_an == null) {
            return 1.0f;
        }
        if (this.jad_na == Float.MIN_VALUE) {
            if (this.jad_hu != null) {
                fFloatValue = ((this.jad_hu.floatValue() - this.jad_jt) / this.jad_an.jad_bo()) + jad_bo();
            }
            this.jad_na = fFloatValue;
        }
        return this.jad_na;
    }

    public float jad_bo() {
        jad_jt jad_jtVar = this.jad_an;
        if (jad_jtVar == null) {
            return 0.0f;
        }
        if (this.jad_mz == Float.MIN_VALUE) {
            this.jad_mz = (this.jad_jt - jad_jtVar.jad_kx) / jad_jtVar.jad_bo();
        }
        return this.jad_mz;
    }

    public boolean jad_cp() {
        return this.jad_dq == null && this.jad_er == null && this.jad_fs == null;
    }

    public String toString() {
        return jad_zm.jad_an("Keyframe{startValue=").append(this.jad_bo).append(", endValue=").append(this.jad_cp).append(", startFrame=").append(this.jad_jt).append(", endFrame=").append(this.jad_hu).append(", interpolator=").append(this.jad_dq).append('}').toString();
    }
}
