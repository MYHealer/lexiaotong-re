package com.byazt.vc;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.byazt.ga.a;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME, 20})
public class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f2810a;
    public final T c;
    public final a da;
    public PointF i;
    public float m;
    public final Interpolator n;
    public float sl;
    public Float sp;
    public float t;
    public T tt;
    public int u;
    public final Interpolator uj;
    public final Interpolator ve;
    public PointF x;
    public int yp;
    public float z;

    public boolean n() {
        return this.ve == null && this.uj == null && this.n == null;
    }

    public c(a aVar, T t, T t2, Interpolator interpolator, float f, Float f2) {
        this.sl = -3987645.8f;
        this.t = -3987645.8f;
        this.u = 784923401;
        this.yp = 784923401;
        this.z = Float.MIN_VALUE;
        this.m = Float.MIN_VALUE;
        this.x = null;
        this.i = null;
        this.da = aVar;
        this.c = t;
        this.tt = t2;
        this.ve = interpolator;
        this.uj = null;
        this.n = null;
        this.f2810a = f;
        this.sp = f2;
    }

    public c(a aVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, float f, Float f2) {
        this.sl = -3987645.8f;
        this.t = -3987645.8f;
        this.u = 784923401;
        this.yp = 784923401;
        this.z = Float.MIN_VALUE;
        this.m = Float.MIN_VALUE;
        this.x = null;
        this.i = null;
        this.da = aVar;
        this.c = t;
        this.tt = t2;
        this.ve = null;
        this.uj = interpolator;
        this.n = interpolator2;
        this.f2810a = f;
        this.sp = f2;
    }

    public c(a aVar, T t, T t2, Interpolator interpolator, Interpolator interpolator2, Interpolator interpolator3, float f, Float f2) {
        this.sl = -3987645.8f;
        this.t = -3987645.8f;
        this.u = 784923401;
        this.yp = 784923401;
        this.z = Float.MIN_VALUE;
        this.m = Float.MIN_VALUE;
        this.x = null;
        this.i = null;
        this.da = aVar;
        this.c = t;
        this.tt = t2;
        this.ve = interpolator;
        this.uj = interpolator2;
        this.n = interpolator3;
        this.f2810a = f;
        this.sp = f2;
    }

    public c(T t) {
        this.sl = -3987645.8f;
        this.t = -3987645.8f;
        this.u = 784923401;
        this.yp = 784923401;
        this.z = Float.MIN_VALUE;
        this.m = Float.MIN_VALUE;
        this.x = null;
        this.i = null;
        this.da = null;
        this.c = t;
        this.tt = t;
        this.ve = null;
        this.uj = null;
        this.n = null;
        this.f2810a = Float.MIN_VALUE;
        this.sp = Float.valueOf(Float.MAX_VALUE);
    }

    private c(T t, T t2) {
        this.sl = -3987645.8f;
        this.t = -3987645.8f;
        this.u = 784923401;
        this.yp = 784923401;
        this.z = Float.MIN_VALUE;
        this.m = Float.MIN_VALUE;
        this.x = null;
        this.i = null;
        this.da = null;
        this.c = t;
        this.tt = t2;
        this.ve = null;
        this.uj = null;
        this.n = null;
        this.f2810a = Float.MIN_VALUE;
        this.sp = Float.valueOf(Float.MAX_VALUE);
    }

    public c<T> c(T t, T t2) {
        return new c<>(t, t2);
    }

    public float ve() {
        a aVar = this.da;
        if (aVar == null) {
            return 0.0f;
        }
        if (this.z == Float.MIN_VALUE) {
            this.z = (this.f2810a - aVar.a()) / this.da.rh();
        }
        return this.z;
    }

    public float uj() {
        if (this.da == null) {
            return 1.0f;
        }
        if (this.m == Float.MIN_VALUE) {
            if (this.sp == null) {
                this.m = 1.0f;
            } else {
                this.m = ve() + ((this.sp.floatValue() - this.f2810a) / this.da.rh());
            }
        }
        return this.m;
    }

    public boolean c(float f) {
        return f >= ve() && f < uj();
    }

    public float a() {
        if (this.sl == -3987645.8f) {
            this.sl = ((Float) this.c).floatValue();
        }
        return this.sl;
    }

    public float sp() {
        if (this.t == -3987645.8f) {
            this.t = ((Float) this.tt).floatValue();
        }
        return this.t;
    }

    public int x() {
        if (this.u == 784923401) {
            this.u = ((Integer) this.c).intValue();
        }
        return this.u;
    }

    public int i() {
        if (this.yp == 784923401) {
            this.yp = ((Integer) this.tt).intValue();
        }
        return this.yp;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.c + ", endValue=" + this.tt + ", startFrame=" + this.f2810a + ", endFrame=" + this.sp + ", interpolator=" + this.ve + '}';
    }
}
