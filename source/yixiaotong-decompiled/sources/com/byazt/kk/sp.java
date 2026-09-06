package com.byazt.kk;

import android.view.Choreographer;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp extends c implements Choreographer.FrameCallback {
    public com.byazt.ga.a da;
    public float tt = 1.0f;
    public boolean ve = false;
    public long uj = 0;
    public float n = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2417a = 0.0f;
    public int sp = 0;
    public float x = -2.14748365E9f;
    public float i = 2.14748365E9f;
    public boolean c = false;
    public boolean sl = false;

    public float da() {
        return this.tt;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.c;
    }

    public float sp() {
        return this.f2417a;
    }

    public void ve(float f) {
        this.tt = f;
    }

    public void ve(boolean z) {
        this.sl = z;
    }

    public void x() {
        this.da = null;
        this.x = -2.14748365E9f;
        this.i = 2.14748365E9f;
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(a());
    }

    public float a() {
        com.byazt.ga.a aVar = this.da;
        if (aVar == null) {
            return 0.0f;
        }
        return (this.f2417a - aVar.a()) / (this.da.sp() - this.da.a());
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float fZ;
        float fM;
        float fZ2;
        if (this.da == null) {
            return 0.0f;
        }
        if (gt()) {
            fZ = m() - this.f2417a;
            fM = m();
            fZ2 = z();
        } else {
            fZ = this.f2417a - z();
            fM = m();
            fZ2 = z();
        }
        return fZ / (fM - fZ2);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        com.byazt.ga.a aVar = this.da;
        if (aVar == null) {
            return 0L;
        }
        return (long) aVar.n();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        nu();
        if (this.da == null || !isRunning()) {
            return;
        }
        com.byazt.ga.n.c("LottieValueAnimator#doFrame");
        long j2 = this.uj;
        float fMy = (j2 != 0 ? j - j2 : 0L) / my();
        float f = this.n;
        if (gt()) {
            fMy = -fMy;
        }
        float f2 = f + fMy;
        boolean z = !i.ve(f2, z(), m());
        float f3 = this.n;
        float fTt = i.tt(f2, z(), m());
        this.n = fTt;
        if (this.sl) {
            fTt = (float) Math.floor(fTt);
        }
        this.f2417a = fTt;
        this.uj = j;
        if (!this.sl || this.n != f3) {
            ve();
        }
        if (z) {
            if (getRepeatCount() != -1 && this.sp >= getRepeatCount()) {
                float fZ = this.tt < 0.0f ? z() : m();
                this.n = fZ;
                this.f2417a = fZ;
                rh();
                tt(gt());
            } else {
                c();
                this.sp++;
                if (getRepeatMode() == 2) {
                    this.ve = !this.ve;
                    i();
                } else {
                    float fM = gt() ? m() : z();
                    this.n = fM;
                    this.f2417a = fM;
                }
                this.uj = j;
            }
        }
        rl();
        com.byazt.ga.n.tt("LottieValueAnimator#doFrame");
    }

    private float my() {
        com.byazt.ga.a aVar = this.da;
        if (aVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / aVar.u()) / Math.abs(this.tt);
    }

    public void c(com.byazt.ga.a aVar) {
        boolean z = this.da == null;
        this.da = aVar;
        if (z) {
            c(Math.max(this.x, aVar.a()), Math.min(this.i, aVar.sp()));
        } else {
            c((int) aVar.a(), (int) aVar.sp());
        }
        float f = this.f2417a;
        this.f2417a = 0.0f;
        this.n = 0.0f;
        c((int) f);
        ve();
    }

    public void c(float f) {
        if (this.n == f) {
            return;
        }
        float fTt = i.tt(f, z(), m());
        this.n = fTt;
        if (this.sl) {
            fTt = (float) Math.floor(fTt);
        }
        this.f2417a = fTt;
        this.uj = 0L;
        ve();
    }

    public void c(int i) {
        c(i, (int) this.i);
    }

    public void tt(float f) {
        c(this.x, f);
    }

    public void c(float f, float f2) {
        if (f > f2) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f), Float.valueOf(f2)));
        }
        com.byazt.ga.a aVar = this.da;
        float fA = aVar == null ? -3.4028235E38f : aVar.a();
        com.byazt.ga.a aVar2 = this.da;
        float fSp = aVar2 == null ? Float.MAX_VALUE : aVar2.sp();
        float fTt = i.tt(f, fA, fSp);
        float fTt2 = i.tt(f2, fA, fSp);
        if (fTt == this.x && fTt2 == this.i) {
            return;
        }
        this.x = fTt;
        this.i = fTt2;
        c((int) i.tt(this.f2417a, fTt, fTt2));
    }

    public void i() {
        ve(-da());
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i == 2 || !this.ve) {
            return;
        }
        this.ve = false;
        i();
    }

    public void sl() {
        this.c = true;
        c(gt());
        c((int) (gt() ? m() : z()));
        this.uj = 0L;
        this.sp = 0;
        nu();
    }

    public void t() {
        rh();
        tt(gt());
    }

    public void u() {
        rh();
        uj();
    }

    public void yp() {
        this.c = true;
        nu();
        this.uj = 0L;
        if (gt() && sp() == z()) {
            c(m());
        } else if (!gt() && sp() == m()) {
            c(z());
        }
        n();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        tt();
        rh();
    }

    private boolean gt() {
        return da() < 0.0f;
    }

    public float z() {
        com.byazt.ga.a aVar = this.da;
        if (aVar == null) {
            return 0.0f;
        }
        float f = this.x;
        return f == -2.14748365E9f ? aVar.a() : f;
    }

    public float m() {
        com.byazt.ga.a aVar = this.da;
        if (aVar == null) {
            return 0.0f;
        }
        float f = this.i;
        return f == 2.14748365E9f ? aVar.sp() : f;
    }

    @Override // com.byazt.kk.c
    public void tt() {
        super.tt();
        tt(gt());
    }

    public void nu() {
        if (isRunning()) {
            uj(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void rh() {
        uj(true);
    }

    public void uj(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.c = false;
        }
    }

    private void rl() {
        if (this.da == null) {
            return;
        }
        float f = this.f2417a;
        if (f < this.x || f > this.i) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.x), Float.valueOf(this.i), Float.valueOf(this.f2417a)));
        }
    }
}
