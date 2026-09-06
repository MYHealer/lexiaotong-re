package com.byazt.ga;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.byazt.fs.qy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 256, 71})
public class x extends Drawable implements Animatable, Drawable.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2244a;
    public LottieAnimationView aw;
    public Matrix bx;
    public String c;
    public Rect cu;
    public Rect d;
    public final ArrayList<c> da;
    public RectF eo;
    public boolean gr;
    public com.byazt.zk.uj gt;
    public boolean gu;
    public Canvas h;
    public tt i;
    public boolean ic;
    public Map<String, Typeface> m;
    public Bitmap md;
    public boolean my;
    public final com.byazt.kk.sp n;
    public RectF nb;
    public boolean nu;
    public Rect or;
    public final Matrix p;
    public Matrix pf;
    public RectF qp;
    public boolean qy;
    public boolean rh;
    public int rl;
    public final ValueAnimator.AnimatorUpdateListener sl;
    public boolean sp;
    public rl sv;
    public com.byazt.pn.tt t;
    public ve tt;
    public String u;
    public a uj;
    public gt ve;
    public boolean x;
    public uj yp;
    public boolean yv;
    public com.byazt.pn.c z;
    public Paint zb;
    public my zm;

    private interface c {
        void c(a aVar);
    }

    private enum tt {
        NONE,
        PLAY,
        RESUME
    }

    private boolean or() {
        return this.f2244a || this.sp;
    }

    public void a(boolean z) {
        this.x = z;
    }

    public boolean a() {
        return this.rh;
    }

    public rl c() {
        return this.sv;
    }

    public void c(gt gtVar) {
        this.ve = gtVar;
    }

    public void c(rl rlVar) {
        this.sv = rlVar;
    }

    public void c(String str) {
        this.u = str;
    }

    public boolean da() {
        return this.gr;
    }

    public RectF eo() {
        return this.nb;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.rl;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public String n() {
        return this.u;
    }

    public void n(boolean z) {
        this.gr = z;
    }

    public a p() {
        return this.uj;
    }

    public void sp(boolean z) {
        this.sp = z;
    }

    public LottieAnimationView tt() {
        return this.aw;
    }

    public void tt(boolean z) {
        this.rh = z;
    }

    public boolean uj() {
        return this.my;
    }

    public com.byazt.zk.uj ve() {
        return this.gt;
    }

    public boolean x() {
        return this.yv;
    }

    public gt zm() {
        return this.ve;
    }

    public x(LottieAnimationView lottieAnimationView) {
        com.byazt.kk.sp spVar = new com.byazt.kk.sp();
        this.n = spVar;
        this.f2244a = true;
        this.sp = false;
        this.x = false;
        this.i = tt.NONE;
        this.da = new ArrayList<>();
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.ga.x.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (x.this.gt != null) {
                    x.this.gt.c(x.this.n.a());
                }
            }
        };
        this.sl = animatorUpdateListener;
        this.rh = false;
        this.my = true;
        this.rl = 255;
        this.zm = my.AUTOMATIC;
        this.yv = false;
        this.p = new Matrix();
        this.ic = false;
        this.aw = lottieAnimationView;
        spVar.addUpdateListener(animatorUpdateListener);
    }

    public void c(boolean z, Context context) {
        if (this.nu == z) {
            return;
        }
        this.nu = z;
        if (this.uj != null) {
            c(context);
        }
    }

    public void c(boolean z) {
        if (z != this.my) {
            this.my = z;
            com.byazt.zk.uj ujVar = this.gt;
            if (ujVar != null) {
                ujVar.tt(z);
            }
            invalidateSelf();
        }
    }

    public boolean c(a aVar, Context context) {
        if (this.uj == aVar) {
            return false;
        }
        this.ic = true;
        sl();
        this.uj = aVar;
        c(context);
        this.n.c(aVar);
        uj(this.n.getAnimatedFraction());
        Iterator it = new ArrayList(this.da).iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar != null) {
                cVar.c(aVar);
            }
            it.remove();
        }
        this.da.clear();
        aVar.tt(this.qy);
        zb();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }

    public void c(my myVar) {
        this.zm = myVar;
        zb();
    }

    public my sp() {
        return this.yv ? my.SOFTWARE : my.HARDWARE;
    }

    private void zb() {
        a aVar = this.uj;
        if (aVar == null) {
            return;
        }
        this.yv = this.zm.c(Build.VERSION.SDK_INT, aVar.c(), aVar.tt());
    }

    public void ve(boolean z) {
        this.qy = z;
        a aVar = this.uj;
        if (aVar != null) {
            aVar.tt(z);
        }
    }

    public void uj(boolean z) {
        if (this.gu == z) {
            return;
        }
        this.gu = z;
        com.byazt.zk.uj ujVar = this.gt;
        if (ujVar != null) {
            ujVar.c(z);
        }
    }

    public rh i() {
        a aVar = this.uj;
        if (aVar != null) {
            return aVar.ve();
        }
        return null;
    }

    private void c(Context context) {
        a aVar = this.uj;
        if (aVar == null) {
            return;
        }
        com.byazt.zk.uj ujVar = this.gt;
        if (ujVar != null) {
            c(ujVar);
        }
        com.byazt.zk.uj ujVar2 = new com.byazt.zk.uj(this, qy.c(aVar), aVar.yp(), aVar, context);
        this.gt = ujVar2;
        if (this.gu) {
            ujVar2.c(true);
        }
        this.gt.tt(this.my);
    }

    private void c(com.byazt.zk.uj ujVar) {
        if (ujVar != null) {
            ujVar.ve();
            List<com.byazt.zk.ve> listYp = ujVar.yp();
            if (listYp != null) {
                for (com.byazt.zk.ve veVar : listYp) {
                    if (veVar instanceof com.byazt.zk.uj) {
                        c((com.byazt.zk.uj) veVar);
                    } else if (veVar != null) {
                        veVar.ve();
                    }
                }
            }
        }
    }

    public void sl() {
        if (this.n.isRunning()) {
            this.n.cancel();
            if (!isVisible()) {
                this.i = tt.NONE;
            }
        }
        this.uj = null;
        com.byazt.zk.uj ujVar = this.gt;
        if (ujVar != null) {
            c(ujVar);
        }
        this.gt = null;
        this.t = null;
        this.n.x();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.ic) {
            return;
        }
        this.ic = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.rl = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        com.byazt.kk.a.tt("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        n.c("Drawable#draw");
        try {
            if (this.yv) {
                c(canvas, this.gt);
            } else {
                c(canvas);
            }
        } catch (Throwable th) {
            com.byazt.kk.a.tt("Lottie crashed in draw!", th);
        }
        this.ic = false;
        n.tt("Drawable#draw");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        t();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        u();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return gu();
    }

    public void t() {
        if (this.gt == null) {
            this.da.add(new c() { // from class: com.byazt.ga.x.6
                @Override // com.byazt.ga.x.c
                public void c(a aVar) {
                    x.this.t();
                }
            });
            return;
        }
        zb();
        if (or() || qy() == 0) {
            if (isVisible()) {
                this.n.sl();
                this.i = tt.NONE;
            } else {
                this.i = tt.PLAY;
            }
        }
        if (or()) {
            return;
        }
        ve((int) (nu() < 0.0f ? z() : m()));
        this.n.t();
        if (isVisible()) {
            return;
        }
        this.i = tt.NONE;
    }

    public void u() {
        this.da.clear();
        this.n.t();
        if (isVisible()) {
            return;
        }
        this.i = tt.NONE;
    }

    public void yp() {
        if (this.gt == null) {
            this.da.add(new c() { // from class: com.byazt.ga.x.7
                @Override // com.byazt.ga.x.c
                public void c(a aVar) {
                    x.this.yp();
                }
            });
            return;
        }
        zb();
        if (or() || qy() == 0) {
            if (isVisible()) {
                this.n.yp();
                this.i = tt.NONE;
            } else {
                this.i = tt.RESUME;
            }
        }
        if (or()) {
            return;
        }
        ve((int) (nu() < 0.0f ? z() : m()));
        this.n.t();
        if (isVisible()) {
            return;
        }
        this.i = tt.NONE;
    }

    public void c(final int i) {
        if (this.uj == null) {
            this.da.add(new c() { // from class: com.byazt.ga.x.8
                @Override // com.byazt.ga.x.c
                public void c(a aVar) {
                    x.this.c(i);
                }
            });
        } else {
            this.n.c(i);
        }
    }

    public float z() {
        return this.n.z();
    }

    public void c(final float f) {
        a aVar = this.uj;
        if (aVar == null) {
            this.da.add(new c() { // from class: com.byazt.ga.x.9
                @Override // com.byazt.ga.x.c
                public void c(a aVar2) {
                    x.this.c(f);
                }
            });
        } else {
            c((int) com.byazt.kk.i.c(aVar.a(), this.uj.sp(), f));
        }
    }

    public void tt(final int i) {
        if (this.uj == null) {
            this.da.add(new c() { // from class: com.byazt.ga.x.10
                @Override // com.byazt.ga.x.c
                public void c(a aVar) {
                    x.this.tt(i);
                }
            });
        } else {
            this.n.tt(i + 0.99f);
        }
    }

    public float m() {
        return this.n.m();
    }

    public void tt(final float f) {
        a aVar = this.uj;
        if (aVar == null) {
            this.da.add(new c() { // from class: com.byazt.ga.x.11
                @Override // com.byazt.ga.x.c
                public void c(a aVar2) {
                    x.this.tt(f);
                }
            });
        } else {
            this.n.tt(com.byazt.kk.i.c(aVar.a(), this.uj.sp(), f));
        }
    }

    public void tt(final String str) {
        a aVar = this.uj;
        if (aVar == null) {
            this.da.add(new c() { // from class: com.byazt.ga.x.12
                @Override // com.byazt.ga.x.c
                public void c(a aVar2) {
                    x.this.tt(str);
                }
            });
            return;
        }
        com.byazt.nb.sp spVarVe = aVar.ve(str);
        if (spVarVe == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        c((int) spVarVe.c);
    }

    public void ve(final String str) {
        a aVar = this.uj;
        if (aVar == null) {
            this.da.add(new c() { // from class: com.byazt.ga.x.13
                @Override // com.byazt.ga.x.c
                public void c(a aVar2) {
                    x.this.ve(str);
                }
            });
            return;
        }
        com.byazt.nb.sp spVarVe = aVar.ve(str);
        if (spVarVe == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        tt((int) (spVarVe.c + spVarVe.tt));
    }

    public void uj(final String str) {
        a aVar = this.uj;
        if (aVar == null) {
            this.da.add(new c() { // from class: com.byazt.ga.x.2
                @Override // com.byazt.ga.x.c
                public void c(a aVar2) {
                    x.this.uj(str);
                }
            });
            return;
        }
        com.byazt.nb.sp spVarVe = aVar.ve(str);
        if (spVarVe == null) {
            throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
        }
        int i = (int) spVarVe.c;
        c(i, ((int) spVarVe.tt) + i);
    }

    public void c(final int i, final int i2) {
        if (this.uj == null) {
            this.da.add(new c() { // from class: com.byazt.ga.x.3
                @Override // com.byazt.ga.x.c
                public void c(a aVar) {
                    x.this.c(i, i2);
                }
            });
        } else {
            this.n.c(i, i2 + 0.99f);
        }
    }

    public void ve(float f) {
        this.n.ve(f);
    }

    public float nu() {
        return this.n.da();
    }

    public void c(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.n.addUpdateListener(animatorUpdateListener);
    }

    public void tt(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.n.removeUpdateListener(animatorUpdateListener);
    }

    public void rh() {
        this.n.removeAllUpdateListeners();
        this.n.addUpdateListener(this.sl);
    }

    public void c(Animator.AnimatorListener animatorListener) {
        this.n.addListener(animatorListener);
    }

    public void tt(Animator.AnimatorListener animatorListener) {
        this.n.removeListener(animatorListener);
    }

    public void my() {
        this.n.removeAllListeners();
    }

    public void ve(final int i) {
        if (this.uj == null) {
            this.da.add(new c() { // from class: com.byazt.ga.x.4
                @Override // com.byazt.ga.x.c
                public void c(a aVar) {
                    x.this.ve(i);
                }
            });
        } else {
            this.n.c(i);
        }
    }

    public int gt() {
        return (int) this.n.sp();
    }

    public void uj(final float f) {
        if (this.uj == null) {
            this.da.add(new c() { // from class: com.byazt.ga.x.5
                @Override // com.byazt.ga.x.c
                public void c(a aVar) {
                    x.this.uj(f);
                }
            });
            return;
        }
        n.c("Drawable#setProgress");
        this.n.c(this.uj.c(f));
        n.tt("Drawable#setProgress");
    }

    public void uj(int i) {
        this.n.setRepeatMode(i);
    }

    public int rl() {
        return this.n.getRepeatMode();
    }

    public void n(int i) {
        this.n.setRepeatCount(i);
    }

    public int qy() {
        return this.n.getRepeatCount();
    }

    public boolean gu() {
        com.byazt.kk.sp spVar = this.n;
        if (spVar == null) {
            return false;
        }
        return spVar.isRunning();
    }

    public boolean gr() {
        if (isVisible()) {
            return this.n.isRunning();
        }
        return this.i == tt.PLAY || this.i == tt.RESUME;
    }

    public void c(Boolean bool) {
        this.f2244a = bool.booleanValue();
    }

    public void x(boolean z) {
        this.n.ve(z);
    }

    public void c(uj ujVar) {
        this.yp = ujVar;
        com.byazt.pn.tt ttVar = this.t;
        if (ttVar != null) {
            ttVar.c(ujVar);
        }
    }

    public void c(ve veVar) {
        this.tt = veVar;
        com.byazt.pn.c cVar = this.z;
        if (cVar != null) {
            cVar.c(veVar);
        }
    }

    public void c(Map<String, Typeface> map) {
        if (map == this.m) {
            return;
        }
        this.m = map;
        invalidateSelf();
    }

    public boolean yv() {
        return this.m == null && this.ve == null && this.uj.z().size() > 0;
    }

    public void md() {
        this.da.clear();
        this.n.cancel();
        if (isVisible()) {
            return;
        }
        this.i = tt.NONE;
    }

    public void h() {
        this.da.clear();
        this.n.u();
        if (isVisible()) {
            return;
        }
        this.i = tt.NONE;
    }

    public float d() {
        return this.n.a();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        a aVar = this.uj;
        if (aVar == null) {
            return -1;
        }
        return aVar.uj().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        a aVar = this.uj;
        if (aVar == null) {
            return -1;
        }
        return aVar.uj().height();
    }

    public Bitmap c(String str, Bitmap bitmap) {
        com.byazt.pn.tt ttVarCu = cu();
        if (ttVarCu == null) {
            com.byazt.kk.a.tt("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap bitmapC = ttVarCu.c(str, bitmap);
        invalidateSelf();
        return bitmapC;
    }

    public Bitmap n(String str) {
        com.byazt.pn.tt ttVarCu = cu();
        if (ttVarCu != null) {
            return ttVarCu.c(str);
        }
        return null;
    }

    public i a(String str) {
        a aVar = this.uj;
        if (aVar == null) {
            return null;
        }
        return aVar.nu().get(str);
    }

    private com.byazt.pn.tt cu() {
        com.byazt.pn.tt ttVar = this.t;
        if (ttVar != null && !ttVar.c(getContext())) {
            this.t = null;
        }
        if (this.t == null) {
            this.t = new com.byazt.pn.tt(getCallback(), this.u, this.yp, this.uj.nu());
        }
        return this.t;
    }

    public Typeface c(com.byazt.nb.ve veVar) {
        Map<String, Typeface> map = this.m;
        if (map != null) {
            String strC = veVar.c();
            if (map.containsKey(strC)) {
                return map.get(strC);
            }
            String strTt = veVar.tt();
            if (map.containsKey(strTt)) {
                return map.get(strTt);
            }
            String str = veVar.c() + com.huawei.openalliance.ad.constant.x.A + veVar.ve();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        com.byazt.pn.c cVarQp = qp();
        if (cVarQp != null) {
            return cVarQp.c(veVar);
        }
        return null;
    }

    private com.byazt.pn.c qp() {
        if (getCallback() == null) {
            return null;
        }
        if (this.z == null) {
            com.byazt.pn.c cVar = new com.byazt.pn.c(getCallback(), this.tt);
            this.z = cVar;
            String str = this.c;
            if (str != null) {
                cVar.c(str);
            }
        }
        return this.z;
    }

    public void sp(String str) {
        this.c = str;
        com.byazt.pn.c cVarQp = qp();
        if (cVarQp != null) {
            cVarQp.c(str);
        }
    }

    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean z3 = !isVisible();
        boolean visible = super.setVisible(z, z2);
        if (z) {
            if (this.i == tt.PLAY) {
                t();
            } else if (this.i == tt.RESUME) {
                yp();
            }
        } else if (this.n.isRunning()) {
            h();
            this.i = tt.RESUME;
        } else if (!z3) {
            this.i = tt.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    private void c(Canvas canvas) {
        com.byazt.zk.uj ujVar = this.gt;
        a aVar = this.uj;
        if (ujVar == null || aVar == null) {
            return;
        }
        this.p.reset();
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            this.p.preScale(bounds.width() / aVar.uj().width(), bounds.height() / aVar.uj().height());
            this.p.preTranslate(bounds.left, bounds.top);
        }
        ujVar.c(canvas, this.p, this.rl);
    }

    private void c(Canvas canvas, com.byazt.zk.uj ujVar) {
        if (this.uj == null || ujVar == null) {
            return;
        }
        nb();
        canvas.getMatrix(this.pf);
        canvas.getClipBounds(this.d);
        c(this.d, this.eo);
        this.pf.mapRect(this.eo);
        c(this.eo, this.d);
        if (this.my) {
            this.nb.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            ujVar.c(this.nb, (Matrix) null, false);
        }
        this.pf.mapRect(this.nb);
        Rect bounds = getBounds();
        float fWidth = bounds.width() / getIntrinsicWidth();
        float fHeight = bounds.height() / getIntrinsicHeight();
        c(this.nb, fWidth, fHeight);
        if (!pf()) {
            this.nb.intersect(this.d.left, this.d.top, this.d.right, this.d.bottom);
        }
        int iCeil = (int) Math.ceil(this.nb.width());
        int iCeil2 = (int) Math.ceil(this.nb.height());
        if (iCeil == 0 || iCeil2 == 0) {
            return;
        }
        tt(iCeil, iCeil2);
        if (this.ic) {
            this.p.set(this.pf);
            this.p.preScale(fWidth, fHeight);
            this.p.postTranslate(-this.nb.left, -this.nb.top);
            this.md.eraseColor(0);
            ujVar.c(this.h, this.p, this.rl);
            this.pf.invert(this.bx);
            this.bx.mapRect(this.qp, this.nb);
            c(this.qp, this.cu);
        }
        this.or.set(0, 0, iCeil, iCeil2);
        canvas.drawBitmap(this.md, this.or, this.cu, this.zb);
    }

    private void nb() {
        if (this.h != null) {
            return;
        }
        this.h = new Canvas();
        this.nb = new RectF();
        this.pf = new Matrix();
        this.bx = new Matrix();
        this.d = new Rect();
        this.eo = new RectF();
        this.zb = new com.byazt.xg.c();
        this.or = new Rect();
        this.cu = new Rect();
        this.qp = new RectF();
    }

    private void tt(int i, int i2) {
        Bitmap bitmap = this.md;
        if (bitmap == null || bitmap.getWidth() < i || this.md.getHeight() < i2) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.md = bitmapCreateBitmap;
            this.h.setBitmap(bitmapCreateBitmap);
            this.ic = true;
            return;
        }
        if (this.md.getWidth() > i || this.md.getHeight() > i2) {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(this.md, 0, 0, i, i2);
            this.md = bitmapCreateBitmap2;
            this.h.setBitmap(bitmapCreateBitmap2);
            this.ic = true;
        }
    }

    private void c(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void c(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void c(RectF rectF, float f, float f2) {
        rectF.set(rectF.left * f, rectF.top * f2, rectF.right * f, rectF.bottom * f2);
    }

    private boolean pf() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View)) {
            return false;
        }
        ViewParent parent = ((View) callback).getParent();
        return (parent instanceof ViewGroup) && !((ViewGroup) parent).getClipChildren();
    }
}
