package com.jd.ad.sdk.jad_xg;

import android.animation.Animator;
import android.graphics.PointF;
import android.view.Choreographer;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jad_er extends jad_an implements Choreographer.FrameCallback {
    public com.jd.ad.sdk.jad_lu.jad_jt jad_jw;
    public float jad_cp = 1.0f;
    public boolean jad_dq = false;
    public long jad_er = 0;
    public float jad_fs = 0.0f;
    public int jad_jt = 0;
    public float jad_hu = -2.14748365E9f;
    public float jad_iv = 2.14748365E9f;
    public boolean jad_kx = false;

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        Iterator<Animator.AnimatorListener> it = this.jad_bo.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
        jad_hu();
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float fJad_dq;
        float fJad_er;
        if (this.jad_jw == null) {
            return 0.0f;
        }
        if (jad_fs()) {
            fJad_dq = jad_dq();
            fJad_er = this.jad_fs;
        } else {
            fJad_dq = this.jad_fs;
            fJad_er = jad_er();
        }
        return (fJad_dq - fJad_er) / (jad_dq() - jad_er());
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(jad_cp());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_jw;
        if (jad_jtVar == null) {
            return 0L;
        }
        return (long) jad_jtVar.jad_an();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.jad_kx;
    }

    public void jad_an(float f) {
        if (this.jad_fs == f) {
            return;
        }
        float fJad_er = jad_er();
        float fJad_dq = jad_dq();
        PointF pointF = jad_jt.jad_an;
        this.jad_fs = Math.max(fJad_er, Math.min(fJad_dq, f));
        this.jad_er = 0L;
        jad_an();
    }

    public void jad_bo() {
        jad_hu();
        jad_an(jad_fs());
    }

    public float jad_cp() {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_jw;
        if (jad_jtVar == null) {
            return 0.0f;
        }
        float f = this.jad_fs;
        float f2 = jad_jtVar.jad_kx;
        return (f - f2) / (jad_jtVar.jad_ly - f2);
    }

    public float jad_dq() {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_jw;
        if (jad_jtVar == null) {
            return 0.0f;
        }
        float f = this.jad_iv;
        return f == 2.14748365E9f ? jad_jtVar.jad_ly : f;
    }

    public float jad_er() {
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_jw;
        if (jad_jtVar == null) {
            return 0.0f;
        }
        float f = this.jad_hu;
        return f == -2.14748365E9f ? jad_jtVar.jad_kx : f;
    }

    public final boolean jad_fs() {
        return this.jad_cp < 0.0f;
    }

    public void jad_hu() {
        Choreographer.getInstance().removeFrameCallback(this);
        this.jad_kx = false;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.jad_dq) {
            return;
        }
        this.jad_dq = false;
        this.jad_cp = -this.jad_cp;
    }

    public void jad_jt() {
        if (this.jad_kx) {
            Choreographer.getInstance().removeFrameCallback(this);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        jad_jt();
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_jw;
        if (jad_jtVar == null || !this.jad_kx) {
            return;
        }
        long j2 = this.jad_er;
        float fAbs = (j2 != 0 ? j - j2 : 0L) / ((1.0E9f / jad_jtVar.jad_mz) / Math.abs(this.jad_cp));
        float f = this.jad_fs;
        if (jad_fs()) {
            fAbs = -fAbs;
        }
        float f2 = f + fAbs;
        this.jad_fs = f2;
        float fJad_er = jad_er();
        float fJad_dq = jad_dq();
        PointF pointF = jad_jt.jad_an;
        boolean z = !(f2 >= fJad_er && f2 <= fJad_dq);
        this.jad_fs = Math.max(jad_er(), Math.min(jad_dq(), this.jad_fs));
        this.jad_er = j;
        jad_an();
        if (z) {
            if (getRepeatCount() == -1 || this.jad_jt < getRepeatCount()) {
                Iterator<Animator.AnimatorListener> it = this.jad_bo.iterator();
                while (it.hasNext()) {
                    it.next().onAnimationRepeat(this);
                }
                this.jad_jt++;
                if (getRepeatMode() == 2) {
                    this.jad_dq = !this.jad_dq;
                    this.jad_cp = -this.jad_cp;
                } else {
                    this.jad_fs = jad_fs() ? jad_dq() : jad_er();
                }
                this.jad_er = j;
            } else {
                this.jad_fs = this.jad_cp < 0.0f ? jad_er() : jad_dq();
                jad_hu();
                jad_an(jad_fs());
            }
        }
        if (this.jad_jw != null) {
            float f3 = this.jad_fs;
            if (f3 < this.jad_hu || f3 > this.jad_iv) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.jad_hu), Float.valueOf(this.jad_iv), Float.valueOf(this.jad_fs)));
            }
        }
        com.jd.ad.sdk.jad_lu.jad_dq.jad_an("LottieValueAnimator#doFrame");
    }

    public void jad_an(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        com.jd.ad.sdk.jad_lu.jad_jt jad_jtVar = this.jad_jw;
        float f3 = jad_jtVar == null ? -3.4028235E38f : jad_jtVar.jad_kx;
        float f4 = jad_jtVar == null ? Float.MAX_VALUE : jad_jtVar.jad_ly;
        PointF pointF = jad_jt.jad_an;
        float fMax = Math.max(f3, Math.min(f4, f));
        float fMax2 = Math.max(f3, Math.min(f4, f2));
        if (fMax == this.jad_hu && fMax2 == this.jad_iv) {
            return;
        }
        this.jad_hu = fMax;
        this.jad_iv = fMax2;
        jad_an((int) Math.max(fMax, Math.min(fMax2, this.jad_fs)));
    }
}
