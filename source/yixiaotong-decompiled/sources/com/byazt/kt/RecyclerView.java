package com.byazt.kt;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 166, 1394})
public class RecyclerView extends ViewGroup implements com.byazt.fq.ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.kt.c f2420a;
    public int b;
    public final Rect bm;
    public final int[] cu;
    public boolean d;
    public final Runnable da;
    public int dz;
    public boolean eo;
    public final int f;
    public float g;
    public boolean gr;
    public boolean gt;
    public boolean gu;
    public uj gx;
    public final int[] gy;
    public final gt h;
    public final rh hd;
    public float hj;
    public yp hq;
    public boolean i;
    public final int ir;
    public int iu;
    public int j;
    public EdgeEffect kk;
    public int kp;
    public final com.byazt.kt.yp.tt kz;
    public u l;
    public int lo;
    public final ArrayList<u> lr;
    public int lt;
    public final ArrayList<x> m;
    public int ma;
    public com.byazt.kt.uj.c md;
    public com.byazt.fq.uj mm;
    public boolean my;
    public final m n;
    public a.c nt;
    public boolean nu;
    public List<yp> ny;
    public final int[] or;
    public EdgeEffect os;
    public int oz;
    public com.byazt.kt.uj p;
    public final int[] pn;
    public boolean pu;
    public n q;
    public final List<gu> qp;
    public boolean qy;
    public int r;
    public boolean rh;
    public boolean rl;
    public VelocityTracker s;
    public final Rect sl;
    public com.byazt.kt.tt sp;
    public final RectF t;
    public List<sl> tk;
    public final AccessibilityManager to;
    public EdgeEffect tx;
    public c u;
    public EdgeEffect v;
    public Runnable vp;
    public final com.byazt.kt.yp x;
    public boolean xd;
    public int y;
    public t yf;
    public final int[] yo;
    public i yp;
    public final qy yv;
    public nu z;
    public boolean zb;
    public a zm;
    public static final int[] pf = {R.attr.nestedScrollingEnabled};
    public static final int[] bx = {R.attr.clipToPadding};
    public static final boolean c = false;
    public static final boolean tt = true;
    public static final boolean ve = true;
    public static final boolean uj = true;
    public static final boolean sv = false;
    public static final boolean aw = false;
    public static final Class<?>[] ic = {Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};
    public static final Interpolator nb = new Interpolator() { // from class: com.byazt.kt.RecyclerView.6
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    public interface nu {
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 2489})
    public static abstract class rl {
        public abstract View c(m mVar, int i, int i2);
    }

    public interface sl {
        void c(View view);

        void tt(View view);
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 1030})
    public static abstract class t {
        public abstract boolean c(int i, int i2);
    }

    public interface u {
        boolean c(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public interface uj {
        int c(int i, int i2);
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 2499})
    public static abstract class ve {
        public void c() {
        }

        public void c(int i, int i2, Object obj) {
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 2514})
    public static abstract class yp {
        public void c(RecyclerView recyclerView, int i) {
        }

        public void c(RecyclerView recyclerView, int i, int i2) {
        }
    }

    private void eo() {
        this.lt = 0;
    }

    public c getAdapter() {
        return this.u;
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.i;
    }

    public n getEdgeEffectFactory() {
        return this.q;
    }

    public a getItemAnimator() {
        return this.zm;
    }

    public i getLayoutManager() {
        return this.yp;
    }

    public int getMaxFlingVelocity() {
        return this.ir;
    }

    public int getMinFlingVelocity() {
        return this.f;
    }

    public t getOnFlingListener() {
        return this.yf;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.xd;
    }

    public int getScrollState() {
        return this.oz;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.nu;
    }

    public void n() {
        int i2 = this.lo + 1;
        this.lo = i2;
        if (i2 != 1 || this.rl) {
            return;
        }
        this.gt = false;
    }

    public void setHasFixedSize(boolean z2) {
        this.rh = z2;
    }

    public void setOnFlingListener(t tVar) {
        this.yf = tVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.xd = z2;
    }

    public void setRecyclerListener(nu nuVar) {
        this.z = nuVar;
    }

    public void sl() {
        this.os = null;
        this.tx = null;
        this.v = null;
        this.kk = null;
    }

    public void t() {
        this.kp++;
    }

    public boolean yp() {
        return this.kp > 0;
    }

    public RecyclerView(Context context) {
        this(context, null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.hd = new rh();
        this.n = new m();
        this.x = new com.byazt.kt.yp();
        this.da = new Runnable() { // from class: com.byazt.kt.RecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                if (!RecyclerView.this.my || RecyclerView.this.isLayoutRequested()) {
                    return;
                }
                if (!RecyclerView.this.nu) {
                    RecyclerView.this.requestLayout();
                } else if (RecyclerView.this.rl) {
                    RecyclerView.this.gt = true;
                } else {
                    RecyclerView.this.uj();
                }
            }
        };
        this.sl = new Rect();
        this.bm = new Rect();
        this.t = new RectF();
        this.m = new ArrayList<>();
        this.lr = new ArrayList<>();
        this.lo = 0;
        this.gu = false;
        this.gr = false;
        this.kp = 0;
        this.b = 0;
        this.q = new n();
        this.zm = new com.byazt.kt.ve();
        this.oz = 0;
        this.r = -1;
        this.g = Float.MIN_VALUE;
        this.hj = Float.MIN_VALUE;
        this.xd = true;
        this.yv = new qy();
        this.md = uj ? new com.byazt.kt.uj.c() : null;
        this.h = new gt();
        this.d = false;
        this.eo = false;
        this.nt = new sp();
        this.zb = false;
        this.gy = new int[2];
        this.pn = new int[2];
        this.or = new int[2];
        this.yo = new int[2];
        this.cu = new int[2];
        this.qp = new ArrayList();
        this.vp = new Runnable() { // from class: com.byazt.kt.RecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                if (RecyclerView.this.zm != null) {
                    RecyclerView.this.zm.c();
                }
                RecyclerView.this.zb = false;
            }
        };
        this.kz = new com.byazt.kt.yp.tt() { // from class: com.byazt.kt.RecyclerView.3
            @Override // com.byazt.kt.yp.tt
            public void c(gu guVar, a.tt ttVar, a.tt ttVar2) {
                RecyclerView.this.n.ve(guVar);
                RecyclerView.this.tt(guVar, ttVar, ttVar2);
            }

            @Override // com.byazt.kt.yp.tt
            public void tt(gu guVar, a.tt ttVar, a.tt ttVar2) {
                RecyclerView.this.c(guVar, ttVar, ttVar2);
            }

            @Override // com.byazt.kt.yp.tt
            public void ve(gu guVar, a.tt ttVar, a.tt ttVar2) {
                guVar.c(false);
                if (RecyclerView.this.gu) {
                    if (RecyclerView.this.zm.c(guVar, guVar, ttVar, ttVar2)) {
                        RecyclerView.this.z();
                    }
                } else if (RecyclerView.this.zm.ve(guVar, ttVar, ttVar2)) {
                    RecyclerView.this.z();
                }
            }

            @Override // com.byazt.kt.yp.tt
            public void c(gu guVar) {
                RecyclerView.this.yp.c(guVar.c, RecyclerView.this.n);
            }
        };
        if (attributeSet != null) {
            try {
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, bx, i2, 0);
                this.i = typedArrayObtainStyledAttributes.getBoolean(0, true);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Exception e) {
                com.byazt.nr.m.c(e);
            }
        } else {
            this.i = true;
        }
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.ma = viewConfiguration.getScaledTouchSlop();
        this.g = com.byazt.fq.sp.c(viewConfiguration, context);
        this.hj = com.byazt.fq.sp.tt(viewConfiguration, context);
        this.f = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ir = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.zm.c(this.nt);
        tt();
        zm();
        gr();
        if (com.byazt.fq.sp.tt(this) == 0) {
            com.byazt.fq.sp.c(this, 1);
        }
        this.to = (AccessibilityManager) getContext().getSystemService("accessibility");
        try {
            if (attributeSet != null) {
                setDescendantFocusability(262144);
            } else {
                setDescendantFocusability(262144);
            }
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
        setNestedScrollingEnabled(true);
    }

    public String c() {
        return PPSLabelView.Code + super.toString() + ", adapter:" + this.u + ", layout:" + this.yp + ", context:" + getContext();
    }

    private void gr() {
        if (com.byazt.fq.sp.i(this) == 0) {
            com.byazt.fq.sp.tt(this, 8);
        }
    }

    private void zm() {
        this.sp = new com.byazt.kt.tt(new com.byazt.kt.tt.InterfaceC0204tt() { // from class: com.byazt.kt.RecyclerView.4
            @Override // com.byazt.kt.tt.InterfaceC0204tt
            public int c() {
                return RecyclerView.this.getChildCount();
            }

            @Override // com.byazt.kt.tt.InterfaceC0204tt
            public void c(View view, int i2) {
                RecyclerView.this.addView(view, i2);
                RecyclerView.this.t(view);
            }

            @Override // com.byazt.kt.tt.InterfaceC0204tt
            public int c(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            @Override // com.byazt.kt.tt.InterfaceC0204tt
            public void c(int i2) {
                View childAt = RecyclerView.this.getChildAt(i2);
                if (childAt != null) {
                    RecyclerView.this.sl(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i2);
            }

            @Override // com.byazt.kt.tt.InterfaceC0204tt
            public View tt(int i2) {
                return RecyclerView.this.getChildAt(i2);
            }

            @Override // com.byazt.kt.tt.InterfaceC0204tt
            public void tt() {
                int iC = c();
                for (int i2 = 0; i2 < iC; i2++) {
                    View viewTt = tt(i2);
                    RecyclerView.this.sl(viewTt);
                    viewTt.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            @Override // com.byazt.kt.tt.InterfaceC0204tt
            public gu tt(View view) {
                return RecyclerView.n(view);
            }

            @Override // com.byazt.kt.tt.InterfaceC0204tt
            public void c(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                gu guVarN = RecyclerView.n(view);
                if (guVarN != null) {
                    if (!guVarN.rh() && !guVarN.R_()) {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + guVarN + RecyclerView.this.c());
                    }
                    guVarN.u();
                }
                RecyclerView.this.attachViewToParent(view, i2, layoutParams);
            }

            @Override // com.byazt.kt.tt.InterfaceC0204tt
            public void ve(int i2) {
                gu guVarN;
                View viewTt = tt(i2);
                if (viewTt != null && (guVarN = RecyclerView.n(viewTt)) != null) {
                    if (guVarN.rh() && !guVarN.R_()) {
                        throw new IllegalArgumentException("called detach on an already detached child " + guVarN + RecyclerView.this.c());
                    }
                    guVarN.tt(256);
                }
                RecyclerView.this.detachViewFromParent(i2);
            }

            @Override // com.byazt.kt.tt.InterfaceC0204tt
            public void ve(View view) {
                gu guVarN = RecyclerView.n(view);
                if (guVarN != null) {
                    guVarN.c(RecyclerView.this);
                }
            }

            @Override // com.byazt.kt.tt.InterfaceC0204tt
            public void uj(View view) {
                gu guVarN = RecyclerView.n(view);
                if (guVarN != null) {
                    guVarN.tt(RecyclerView.this);
                }
            }
        });
    }

    public void tt() {
        this.f2420a = new com.byazt.kt.c(new com.byazt.kt.c.InterfaceC0203c() { // from class: com.byazt.kt.RecyclerView.5
            @Override // com.byazt.kt.c.InterfaceC0203c
            public gu c(int i2) {
                gu guVarC = RecyclerView.this.c(i2, true);
                if (guVarC == null || RecyclerView.this.sp.ve(guVarC.c)) {
                    return null;
                }
                return guVarC;
            }

            @Override // com.byazt.kt.c.InterfaceC0203c
            public void c(int i2, int i3) {
                RecyclerView.this.c(i2, i3, true);
                RecyclerView.this.d = true;
                RecyclerView.this.h.ve += i3;
            }

            @Override // com.byazt.kt.c.InterfaceC0203c
            public void tt(int i2, int i3) {
                RecyclerView.this.c(i2, i3, false);
                RecyclerView.this.d = true;
            }

            @Override // com.byazt.kt.c.InterfaceC0203c
            public void c(int i2, int i3, Object obj) {
                RecyclerView.this.c(i2, i3, obj);
                RecyclerView.this.eo = true;
            }

            @Override // com.byazt.kt.c.InterfaceC0203c
            public void ve(int i2, int i3) {
                RecyclerView.this.sp(i2, i3);
                RecyclerView.this.d = true;
            }

            @Override // com.byazt.kt.c.InterfaceC0203c
            public void uj(int i2, int i3) {
                RecyclerView.this.a(i2, i3);
                RecyclerView.this.d = true;
            }
        });
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.i) {
            sl();
        }
        this.i = z2;
        super.setClipToPadding(z2);
        if (this.my) {
            requestLayout();
        }
    }

    public void setAdapter(c cVar) {
        setLayoutFrozen(false);
        c(cVar, false, true);
        ve(false);
        requestLayout();
    }

    public void ve() {
        a aVar = this.zm;
        if (aVar != null) {
            aVar.uj();
        }
        i iVar = this.yp;
        if (iVar != null) {
            iVar.ve(this.n);
            this.yp.tt(this.n);
        }
        this.n.c();
    }

    private void c(c cVar, boolean z2, boolean z3) {
        c cVar2 = this.u;
        if (cVar2 != null) {
            cVar2.tt(this.hd);
        }
        if (!z2 || z3) {
            ve();
        }
        this.f2420a.c();
        c cVar3 = this.u;
        this.u = cVar;
        if (cVar != null) {
            cVar.c(this.hd);
        }
        this.n.c(cVar3, this.u, z2);
        this.h.f2422a = true;
    }

    @Override // android.view.View
    public int getBaseline() {
        i iVar = this.yp;
        return iVar != null ? iVar.rh() : super.getBaseline();
    }

    public void c(sl slVar) {
        if (this.tk == null) {
            this.tk = new ArrayList();
        }
        this.tk.add(slVar);
    }

    public void setLayoutManager(i iVar) {
        if (iVar != this.yp) {
            a();
            if (this.yp != null) {
                a aVar = this.zm;
                if (aVar != null) {
                    aVar.uj();
                }
                this.yp.ve(this.n);
                this.yp.tt(this.n);
                this.n.c();
                if (this.nu) {
                    this.yp.tt(this, this.n);
                }
                this.yp.c((RecyclerView) null);
                this.yp = null;
            } else {
                this.n.c();
            }
            this.sp.c();
            this.yp = iVar;
            if (iVar != null) {
                if (iVar.i != null) {
                    throw new IllegalArgumentException("LayoutManager " + iVar + " is already attached to a RecyclerView:" + iVar.i.c());
                }
                this.yp.c(this);
                if (this.nu) {
                    this.yp.tt(this);
                }
            }
            this.n.tt();
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    private void n(gu guVar) {
        View view = guVar.c;
        boolean z2 = view.getParent() == this;
        this.n.ve(tt(view));
        if (guVar.rh()) {
            this.sp.c(view, -1, view.getLayoutParams(), true);
        } else if (!z2) {
            this.sp.c(view, true);
        } else {
            this.sp.uj(view);
        }
    }

    public boolean c(View view) {
        n();
        boolean zA = this.sp.a(view);
        if (zA) {
            gu guVarN = n(view);
            this.n.ve(guVarN);
            this.n.tt(guVarN);
        }
        c(!zA);
        return zA;
    }

    public z getRecycledViewPool() {
        return this.n.sp();
    }

    public void setRecycledViewPool(z zVar) {
        this.n.c(zVar);
    }

    public void setViewCacheExtension(rl rlVar) {
        this.n.c(rlVar);
    }

    public void setItemViewCacheSize(int i2) {
        this.n.c(i2);
    }

    public void setScrollState(int i2) {
        if (i2 != this.oz) {
            this.oz = i2;
            if (i2 != 2) {
                p();
            }
            sp(i2);
        }
    }

    public void c(x xVar, int i2) {
        i iVar = this.yp;
        if (iVar != null) {
            iVar.c("Cannot add item decoration during a scroll  or layout");
        }
        if (this.m.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.m.add(xVar);
        } else {
            this.m.add(i2, xVar);
        }
        nu();
        requestLayout();
    }

    public void c(x xVar) {
        c(xVar, -1);
    }

    public int getItemDecorationCount() {
        return this.m.size();
    }

    public void setChildDrawingOrderCallback(uj ujVar) {
        if (ujVar != this.gx) {
            this.gx = ujVar;
            setChildrenDrawingOrderEnabled(ujVar != null);
        }
    }

    public void c(yp ypVar) {
        if (this.ny == null) {
            this.ny = new ArrayList();
        }
        this.ny.add(ypVar);
    }

    public void tt(yp ypVar) {
        List<yp> list = this.ny;
        if (list != null) {
            list.remove(ypVar);
        }
    }

    public void c(int i2) {
        i iVar = this.yp;
        if (iVar != null) {
            iVar.uj(i2);
            awakenScrollBars();
        }
    }

    public void tt(int i2) {
        if (this.rl) {
            return;
        }
        i iVar = this.yp;
        if (iVar == null) {
            com.byazt.nr.m.uj("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            iVar.c(this, this.h, i2);
        }
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        i iVar = this.yp;
        if (iVar == null) {
            com.byazt.nr.m.uj("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.rl) {
            return;
        }
        boolean zVe = iVar.ve();
        boolean zUj = this.yp.uj();
        if (zVe || zUj) {
            if (!zVe) {
                i2 = 0;
            }
            if (!zUj) {
                i3 = 0;
            }
            c(i2, i3, (MotionEvent) null);
        }
    }

    public void c(int i2, int i3, int[] iArr) {
        n();
        t();
        com.byazt.km.c.c("RV Scroll");
        c(this.h);
        int iC = i2 != 0 ? this.yp.c(i2, this.n, this.h) : 0;
        int iTt = i3 != 0 ? this.yp.tt(i3, this.n, this.h) : 0;
        com.byazt.km.c.c();
        qy();
        u();
        c(false);
        if (iArr != null) {
            iArr[0] = iC;
            iArr[1] = iTt;
        }
    }

    public void uj() {
        if (this.my && !this.gu) {
            if (!this.f2420a.uj()) {
                return;
            }
            if (this.f2420a.c(4) && !this.f2420a.c(11)) {
                com.byazt.km.c.c("RV PartialInvalidate");
                n();
                t();
                this.f2420a.tt();
                if (!this.gt) {
                    if (yv()) {
                        m();
                    } else {
                        this.f2420a.ve();
                    }
                }
                c(true);
                u();
                com.byazt.km.c.c();
                return;
            }
            if (!this.f2420a.uj()) {
                return;
            }
        }
        com.byazt.km.c.c("RV FullInvalidate");
        m();
        com.byazt.km.c.c();
    }

    private boolean yv() {
        int iTt = this.sp.tt();
        for (int i2 = 0; i2 < iTt; i2++) {
            gu guVarN = n(this.sp.tt(i2));
            if (guVarN != null && !guVarN.R_() && guVarN.yv()) {
                return true;
            }
        }
        return false;
    }

    public boolean c(int i2, int i3, MotionEvent motionEvent) {
        int i4;
        int i5;
        int i6;
        int i7;
        uj();
        if (this.u != null) {
            c(i2, i3, this.cu);
            int[] iArr = this.cu;
            int i8 = iArr[0];
            int i9 = iArr[1];
            i5 = i9;
            i6 = i8;
            i7 = i2 - i8;
            i4 = i3 - i9;
        } else {
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
        }
        if (!this.m.isEmpty()) {
            invalidate();
        }
        int i10 = i4;
        if (c(i6, i5, i7, i4, this.pn, 0)) {
            int i11 = this.j;
            int[] iArr2 = this.pn;
            int i12 = iArr2[0];
            this.j = i11 - i12;
            int i13 = this.dz;
            int i14 = iArr2[1];
            this.dz = i13 - i14;
            if (motionEvent != null) {
                motionEvent.offsetLocation(i12, i14);
            }
            int[] iArr3 = this.yo;
            int i15 = iArr3[0];
            int[] iArr4 = this.pn;
            iArr3[0] = i15 + iArr4[0];
            iArr3[1] = iArr3[1] + iArr4[1];
        } else if (getOverScrollMode() != 2) {
            if (motionEvent != null && !com.byazt.fq.sp.c(motionEvent, 8194)) {
                c(motionEvent.getX(), i7, motionEvent.getY(), i10);
            }
            ve(i2, i3);
        }
        if (i6 != 0 || i5 != 0) {
            x(i6, i5);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (i6 == 0 && i5 == 0) ? false : true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        i iVar = this.yp;
        if (iVar != null && iVar.ve()) {
            return this.yp.ve(this.h);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        i iVar = this.yp;
        if (iVar != null && iVar.ve()) {
            return this.yp.n(this.h);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        i iVar = this.yp;
        if (iVar != null && iVar.ve()) {
            return this.yp.sp(this.h);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        i iVar = this.yp;
        if (iVar != null && iVar.uj()) {
            return this.yp.uj(this.h);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        i iVar = this.yp;
        if (iVar != null && iVar.uj()) {
            return this.yp.a(this.h);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        i iVar = this.yp;
        if (iVar != null && iVar.uj()) {
            return this.yp.x(this.h);
        }
        return 0;
    }

    public void c(boolean z2) {
        if (this.lo <= 0) {
            this.lo = 1;
        }
        if (!z2 && !this.rl) {
            this.gt = false;
        }
        if (this.lo == 1) {
            if (z2 && this.gt && !this.rl && this.yp != null && this.u != null) {
                m();
            }
            if (!this.rl) {
                this.gt = false;
            }
        }
        this.lo--;
    }

    public void setLayoutFrozen(boolean z2) {
        if (z2 != this.rl) {
            c("Do not setLayoutFrozen in layout or scroll");
            if (z2) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.rl = true;
                this.pu = true;
                a();
                return;
            }
            this.rl = false;
            if (this.gt && this.yp != null && this.u != null) {
                requestLayout();
            }
            this.gt = false;
        }
    }

    public void c(int i2, int i3) {
        c(i2, i3, (Interpolator) null);
    }

    public void c(int i2, int i3, Interpolator interpolator) {
        i iVar = this.yp;
        if (iVar == null) {
            com.byazt.nr.m.uj("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.rl) {
            return;
        }
        if (!iVar.ve()) {
            i2 = 0;
        }
        if (!this.yp.uj()) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        this.yv.c(i2, i3, interpolator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v6 */
    public boolean tt(int i2, int i3) {
        i iVar = this.yp;
        if (iVar == null) {
            com.byazt.nr.m.uj("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        }
        if (this.rl) {
            return false;
        }
        int iVe = iVar.ve();
        boolean zUj = this.yp.uj();
        if (iVe == 0 || Math.abs(i2) < this.f) {
            i2 = 0;
        }
        if (!zUj || Math.abs(i3) < this.f) {
            i3 = 0;
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        float f = i2;
        float f2 = i3;
        if (!dispatchNestedPreFling(f, f2)) {
            boolean z2 = iVe != 0 || zUj;
            dispatchNestedFling(f, f2, z2);
            t tVar = this.yf;
            if (tVar != null && tVar.c(i2, i3)) {
                return true;
            }
            if (z2) {
                if (zUj) {
                    iVe = (iVe == true ? 1 : 0) | 2;
                }
                i(iVe, 1);
                int i4 = this.ir;
                int iMax = Math.max(-i4, Math.min(i2, i4));
                int i5 = this.ir;
                this.yv.c(iMax, Math.max(-i5, Math.min(i3, i5)));
                return true;
            }
        }
        return false;
    }

    public void a() {
        setScrollState(0);
        p();
    }

    private void p() {
        this.yv.tt();
        i iVar = this.yp;
        if (iVar != null) {
            iVar.zb();
        }
    }

    private void c(float f, float f2, float f3, float f4) {
        boolean z2 = true;
        if (f2 < 0.0f) {
            sp();
            com.byazt.fq.c.c(this.kk, (-f2) / getWidth(), 1.0f - (f3 / getHeight()));
        } else if (f2 > 0.0f) {
            x();
            com.byazt.fq.c.c(this.v, f2 / getWidth(), f3 / getHeight());
        } else {
            z2 = false;
        }
        if (f4 < 0.0f) {
            i();
            com.byazt.fq.c.c(this.tx, (-f4) / getHeight(), f / getWidth());
        } else if (f4 > 0.0f) {
            da();
            com.byazt.fq.c.c(this.os, f4 / getHeight(), 1.0f - (f / getWidth()));
        } else if (!z2 && f2 == 0.0f && f4 == 0.0f) {
            return;
        }
        com.byazt.fq.sp.ve(this);
    }

    private void md() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.kk;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.kk.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.tx;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.tx.isFinished();
        }
        EdgeEffect edgeEffect3 = this.v;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.v.isFinished();
        }
        EdgeEffect edgeEffect4 = this.os;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.os.isFinished();
        }
        if (zIsFinished) {
            com.byazt.fq.sp.ve(this);
        }
    }

    public void ve(int i2, int i3) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.kk;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            zIsFinished = false;
        } else {
            this.kk.onRelease();
            zIsFinished = this.kk.isFinished();
        }
        EdgeEffect edgeEffect2 = this.v;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.v.onRelease();
            zIsFinished |= this.v.isFinished();
        }
        EdgeEffect edgeEffect3 = this.tx;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.tx.onRelease();
            zIsFinished |= this.tx.isFinished();
        }
        EdgeEffect edgeEffect4 = this.os;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.os.onRelease();
            zIsFinished |= this.os.isFinished();
        }
        if (zIsFinished) {
            com.byazt.fq.sp.ve(this);
        }
    }

    public void uj(int i2, int i3) {
        if (i2 < 0) {
            sp();
            this.kk.onAbsorb(-i2);
        } else if (i2 > 0) {
            x();
            this.v.onAbsorb(i2);
        }
        if (i3 < 0) {
            i();
            this.tx.onAbsorb(-i3);
        } else if (i3 > 0) {
            da();
            this.os.onAbsorb(i3);
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        com.byazt.fq.sp.ve(this);
    }

    public void sp() {
        if (this.kk == null) {
            EdgeEffect edgeEffectC = this.q.c(this, 0);
            this.kk = edgeEffectC;
            if (this.i) {
                edgeEffectC.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffectC.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void x() {
        if (this.v == null) {
            EdgeEffect edgeEffectC = this.q.c(this, 2);
            this.v = edgeEffectC;
            if (this.i) {
                edgeEffectC.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                edgeEffectC.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void i() {
        if (this.tx == null) {
            EdgeEffect edgeEffectC = this.q.c(this, 1);
            this.tx = edgeEffectC;
            if (this.i) {
                edgeEffectC.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffectC.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void da() {
        if (this.os == null) {
            EdgeEffect edgeEffectC = this.q.c(this, 3);
            this.os = edgeEffectC;
            if (this.i) {
                edgeEffectC.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                edgeEffectC.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public static <T> T c(T t2) {
        t2.getClass();
        return t2;
    }

    public void setEdgeEffectFactory(n nVar) {
        c(nVar);
        this.q = nVar;
        sl();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public View focusSearch(View view, int i2) {
        View viewC;
        boolean z2;
        View viewUj = this.yp.uj(view, i2);
        if (viewUj != null) {
            return viewUj;
        }
        boolean z3 = (this.u == null || this.yp == null || yp() || this.rl) ? false : true;
        FocusFinder focusFinder = FocusFinder.getInstance();
        if (z3 && (i2 == 2 || i2 == 1)) {
            if (this.yp.uj()) {
                int i3 = i2 == 2 ? 130 : 33;
                z2 = focusFinder.findNextFocus(this, view, i3) == null;
                if (sv) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.yp.ve()) {
                int i4 = (this.yp.nu() == 1) ^ (i2 == 2) ? 66 : 17;
                boolean z4 = focusFinder.findNextFocus(this, view, i4) == null;
                if (sv) {
                    i2 = i4;
                }
                z2 = z4;
            }
            if (z2) {
                uj();
                if (ve(view) == null) {
                    return null;
                }
                n();
                this.yp.c(view, i2, this.n, this.h);
                c(false);
            }
            viewC = focusFinder.findNextFocus(this, view, i2);
        } else {
            View viewFindNextFocus = focusFinder.findNextFocus(this, view, i2);
            if (viewFindNextFocus == null && z3) {
                uj();
                if (ve(view) == null) {
                    return null;
                }
                n();
                viewC = this.yp.c(view, i2, this.n, this.h);
                c(false);
            } else {
                viewC = viewFindNextFocus;
            }
        }
        if (viewC == null || viewC.hasFocusable()) {
            return c(view, viewC, i2) ? viewC : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        c(viewC, (View) null);
        return view;
    }

    private boolean c(View view, View view2, int i2) {
        int i3;
        if (view2 == null || view2 == this || ve(view2) == null) {
            return false;
        }
        if (view == null || ve(view) == null) {
            return true;
        }
        this.sl.set(0, 0, view.getWidth(), view.getHeight());
        this.bm.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.sl);
        offsetDescendantRectToMyCoords(view2, this.bm);
        byte b = -1;
        int i4 = this.yp.nu() == 1 ? -1 : 1;
        if ((this.sl.left < this.bm.left || this.sl.right <= this.bm.left) && this.sl.right < this.bm.right) {
            i3 = 1;
        } else {
            i3 = ((this.sl.right > this.bm.right || this.sl.left >= this.bm.right) && this.sl.left > this.bm.left) ? -1 : 0;
        }
        if ((this.sl.top < this.bm.top || this.sl.bottom <= this.bm.top) && this.sl.bottom < this.bm.bottom) {
            b = 1;
        } else if ((this.sl.bottom <= this.bm.bottom && this.sl.top < this.bm.bottom) || this.sl.top <= this.bm.top) {
            b = 0;
        }
        if (i2 == 1) {
            return b < 0 || (b == 0 && i3 * i4 <= 0);
        }
        if (i2 == 2) {
            return b > 0 || (b == 0 && i3 * i4 >= 0);
        }
        if (i2 == 17) {
            return i3 < 0;
        }
        if (i2 == 33) {
            return b < 0;
        }
        if (i2 == 66) {
            return i3 > 0;
        }
        if (i2 == 130) {
            return b > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i2 + c());
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.yp.c(this, this.h, view, view2) && view2 != null) {
            c(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    private void c(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.sl.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof da) {
            da daVar = (da) layoutParams;
            if (!daVar.ve) {
                Rect rect = daVar.tt;
                this.sl.left -= rect.left;
                this.sl.right += rect.right;
                this.sl.top -= rect.top;
                this.sl.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.sl);
            offsetRectIntoDescendantCoords(view, this.sl);
        }
        this.yp.c(this, view, this.sl, !this.my, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.yp.c(this, view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        i iVar = this.yp;
        if (iVar == null || !iVar.c(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (yp()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x004e  */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        float refreshRate;
        super.onAttachedToWindow();
        this.kp = 0;
        this.nu = true;
        this.my = this.my && !isLayoutRequested();
        i iVar = this.yp;
        if (iVar != null) {
            iVar.tt(this);
        }
        this.zb = false;
        if (uj) {
            com.byazt.kt.uj ujVar = com.byazt.kt.uj.c.get();
            this.p = ujVar;
            if (ujVar == null) {
                this.p = new com.byazt.kt.uj();
                Display displaySp = com.byazt.fq.sp.sp(this);
                if (isInEditMode() || displaySp == null) {
                    refreshRate = 60.0f;
                } else {
                    refreshRate = displaySp.getRefreshRate();
                    if (refreshRate < 30.0f) {
                        refreshRate = 60.0f;
                    }
                }
                this.p.uj = (long) (1.0E9f / refreshRate);
                com.byazt.kt.uj.c.set(this.p);
            }
            this.p.c(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        com.byazt.kt.uj ujVar;
        super.onDetachedFromWindow();
        a aVar = this.zm;
        if (aVar != null) {
            aVar.uj();
        }
        a();
        this.nu = false;
        i iVar = this.yp;
        if (iVar != null) {
            iVar.tt(this, this.n);
        }
        this.qp.clear();
        removeCallbacks(this.vp);
        this.x.tt();
        if (!uj || (ujVar = this.p) == null) {
            return;
        }
        ujVar.tt(this);
        this.p = null;
    }

    public void c(String str) {
        if (yp()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + c());
            }
            throw new IllegalStateException(str);
        }
        if (this.b > 0) {
            com.byazt.nr.m.tt("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(c()));
        }
    }

    private boolean c(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 3 || action == 0) {
            this.l = null;
        }
        int size = this.lr.size();
        for (int i2 = 0; i2 < size; i2++) {
            u uVar = this.lr.get(i2);
            if (uVar.c(this, motionEvent) && action != 3) {
                this.l = uVar;
                return true;
            }
        }
        return false;
    }

    private boolean tt(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (this.l != null) {
            if (action != 0) {
                if (action == 3 || action == 1) {
                    this.l = null;
                }
                return true;
            }
            this.l = null;
        }
        if (action != 0) {
            int size = this.lr.size();
            for (int i2 = 0; i2 < size; i2++) {
                u uVar = this.lr.get(i2);
                if (uVar.c(this, motionEvent)) {
                    this.l = uVar;
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.rl) {
            return false;
        }
        if (c(motionEvent)) {
            d();
            return true;
        }
        i iVar = this.yp;
        if (iVar == null) {
            return false;
        }
        boolean zVe = iVar.ve();
        boolean zUj = this.yp.uj();
        if (this.s == null) {
            this.s = VelocityTracker.obtain();
        }
        this.s.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.pu) {
                this.pu = false;
            }
            this.r = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.j = x2;
            this.y = x2;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.dz = y;
            this.iu = y;
            if (this.oz == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
            int[] iArr = this.yo;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = zVe;
            if (zUj) {
                i2 = (zVe ? 1 : 0) | 2;
            }
            i(i2, 0);
        } else if (actionMasked == 1) {
            this.s.clear();
            x(0);
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.r);
            if (iFindPointerIndex < 0) {
                com.byazt.nr.m.uj("RecyclerView", "Error processing scroll; pointer index for id " + this.r + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
            int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
            if (this.oz != 1) {
                int i3 = x3 - this.y;
                int i4 = y2 - this.iu;
                if (!zVe || Math.abs(i3) <= this.ma) {
                    z2 = false;
                } else {
                    this.j = x3;
                    z2 = true;
                }
                if (zUj && Math.abs(i4) > this.ma) {
                    this.dz = y2;
                } else if (z2) {
                }
                setScrollState(1);
            }
        } else if (actionMasked == 3) {
            d();
        } else if (actionMasked == 5) {
            this.r = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.j = x4;
            this.y = x4;
            int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.dz = y3;
            this.iu = y3;
        } else if (actionMasked == 6) {
            ve(motionEvent);
        }
        return this.oz == 1;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.lr.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.lr.get(i2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0106  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i2;
        boolean z2;
        if (this.rl || this.pu) {
            return false;
        }
        if (tt(motionEvent)) {
            d();
            return true;
        }
        i iVar = this.yp;
        if (iVar == null) {
            return false;
        }
        boolean zVe = iVar.ve();
        boolean zUj = this.yp.uj();
        if (this.s == null) {
            this.s = VelocityTracker.obtain();
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            int[] iArr = this.yo;
            iArr[1] = 0;
            iArr[0] = 0;
        }
        int[] iArr2 = this.yo;
        motionEventObtain.offsetLocation(iArr2[0], iArr2[1]);
        if (actionMasked == 0) {
            this.r = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.j = x2;
            this.y = x2;
            int y = (int) (motionEvent.getY() + 0.5f);
            this.dz = y;
            this.iu = y;
            if (zUj) {
                i2 = zVe;
                i2 = (zVe ? 1 : 0) | 2;
            }
            i2 = zVe;
            i(i2, 0);
        } else {
            if (actionMasked == 1) {
                this.s.addMovement(motionEventObtain);
                this.s.computeCurrentVelocity(1000, this.ir);
                float f = zVe ? -this.s.getXVelocity(this.r) : 0.0f;
                float f2 = zUj ? -this.s.getYVelocity(this.r) : 0.0f;
                if ((f == 0.0f && f2 == 0.0f) || !tt((int) f, (int) f2)) {
                    setScrollState(0);
                }
                h();
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.r);
                if (iFindPointerIndex < 0) {
                    com.byazt.nr.m.uj("RecyclerView", "Error processing scroll; pointer index for id " + this.r + " not found. Did any MotionEvents get skipped?");
                    return false;
                }
                int x3 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                int y2 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                int i3 = this.j - x3;
                int i4 = this.dz - y2;
                if (c(i3, i4, this.or, this.pn, 0)) {
                    int[] iArr3 = this.or;
                    i3 -= iArr3[0];
                    i4 -= iArr3[1];
                    int[] iArr4 = this.pn;
                    motionEventObtain.offsetLocation(iArr4[0], iArr4[1]);
                    int[] iArr5 = this.yo;
                    int i5 = iArr5[0];
                    int[] iArr6 = this.pn;
                    iArr5[0] = i5 + iArr6[0];
                    iArr5[1] = iArr5[1] + iArr6[1];
                }
                if (this.oz != 1) {
                    if (zVe) {
                        int iAbs = Math.abs(i3);
                        int i6 = this.ma;
                        if (iAbs > i6) {
                            i3 = i3 > 0 ? i3 - i6 : i3 + i6;
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    } else {
                        z2 = false;
                    }
                    if (zUj) {
                        int iAbs2 = Math.abs(i4);
                        int i7 = this.ma;
                        if (iAbs2 > i7) {
                            i4 = i4 > 0 ? i4 - i7 : i4 + i7;
                            z2 = true;
                        }
                    }
                    if (z2) {
                        setScrollState(1);
                    }
                }
                if (this.oz == 1) {
                    int[] iArr7 = this.pn;
                    this.j = x3 - iArr7[0];
                    this.dz = y2 - iArr7[1];
                    if (c(zVe ? i3 : 0, zUj ? i4 : 0, motionEventObtain)) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                    com.byazt.kt.uj ujVar = this.p;
                    if (ujVar != null && (i3 != 0 || i4 != 0)) {
                        ujVar.c(this, i3, i4);
                    }
                }
            } else if (actionMasked == 3) {
                d();
            } else if (actionMasked == 5) {
                this.r = motionEvent.getPointerId(actionIndex);
                int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.j = x4;
                this.y = x4;
                int y3 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                this.dz = y3;
                this.iu = y3;
            } else if (actionMasked == 6) {
                ve(motionEvent);
            }
            motionEventObtain.recycle();
            return true;
        }
        this.s.addMovement(motionEventObtain);
        motionEventObtain.recycle();
        return true;
    }

    private void h() {
        VelocityTracker velocityTracker = this.s;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        x(0);
        md();
    }

    private void d() {
        h();
        setScrollState(0);
    }

    private void ve(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.r) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.r = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.j = x2;
            this.y = x2;
            int y = (int) (motionEvent.getY(i2) + 0.5f);
            this.dz = y;
            this.iu = y;
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0060  */
    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        float axisValue;
        if (this.yp != null && !this.rl && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f = this.yp.uj() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.yp.ve() ? motionEvent.getAxisValue(10) : 0.0f;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                axisValue = motionEvent.getAxisValue(26);
                if (this.yp.uj()) {
                    f = -axisValue;
                } else if (this.yp.ve()) {
                    f = 0.0f;
                } else {
                    f = 0.0f;
                    axisValue = 0.0f;
                }
            } else {
                f = 0.0f;
                axisValue = 0.0f;
            }
            if (f != 0.0f || axisValue != 0.0f) {
                c((int) (axisValue * this.g), (int) (f * this.hj), motionEvent);
            }
        }
        return false;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        i iVar = this.yp;
        if (iVar == null) {
            n(i2, i3);
            return;
        }
        if (iVar.c()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.yp.c(this.n, this.h, i2, i3);
            if ((mode == 1073741824 && mode2 == 1073741824) || this.u == null) {
                return;
            }
            if (this.h.uj == 1) {
                bx();
            }
            this.yp.tt(i2, i3);
            this.h.i = true;
            sv();
            this.yp.ve(i2, i3);
            if (this.yp.i()) {
                this.yp.tt(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.h.i = true;
                sv();
                this.yp.ve(i2, i3);
                return;
            }
            return;
        }
        if (this.rh) {
            this.yp.c(this.n, this.h, i2, i3);
            return;
        }
        if (this.qy) {
            n();
            t();
            or();
            u();
            if (this.h.sl) {
                this.h.sp = true;
            } else {
                this.f2420a.n();
                this.h.sp = false;
            }
            this.qy = false;
            c(false);
        } else if (this.h.sl) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        c cVar = this.u;
        if (cVar != null) {
            this.h.n = cVar.c();
        } else {
            this.h.n = 0;
        }
        n();
        this.yp.c(this.n, this.h, i2, i3);
        c(false);
        this.h.sp = false;
    }

    public void n(int i2, int i3) {
        setMeasuredDimension(i.c(i2, getPaddingLeft() + getPaddingRight(), com.byazt.fq.sp.uj(this)), i.c(i3, getPaddingTop() + getPaddingBottom(), com.byazt.fq.sp.n(this)));
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        sl();
    }

    public void setItemAnimator(a aVar) {
        a aVar2 = this.zm;
        if (aVar2 != null) {
            aVar2.uj();
            this.zm.c(null);
        }
        this.zm = aVar;
        if (aVar != null) {
            aVar.c(this.nt);
        }
    }

    public void u() {
        tt(true);
    }

    public void tt(boolean z2) {
        int i2 = this.kp - 1;
        this.kp = i2;
        if (i2 <= 0) {
            this.kp = 0;
            if (z2) {
                eo();
                gu();
            }
        }
    }

    public void z() {
        if (this.zb || !this.nu) {
            return;
        }
        com.byazt.fq.sp.c(this, this.vp);
        this.zb = true;
    }

    private boolean zb() {
        return this.zm != null && this.yp.t();
    }

    private void or() {
        if (this.gu) {
            this.f2420a.c();
        }
        if (zb()) {
            this.f2420a.tt();
        } else {
            this.f2420a.n();
        }
        boolean z2 = false;
        boolean z3 = this.d || this.eo;
        this.h.da = this.my && this.zm != null && (this.gu || z3 || this.yp.u) && (!this.gu || this.u.tt());
        gt gtVar = this.h;
        if (gtVar.da && z3 && !this.gu && zb()) {
            z2 = true;
        }
        gtVar.sl = z2;
    }

    public void m() {
        if (this.u == null) {
            com.byazt.nr.m.uj("RecyclerView", "No adapter attached; skipping layout");
            return;
        }
        if (this.yp == null) {
            com.byazt.nr.m.uj("RecyclerView", "No layout manager attached; skipping layout");
            return;
        }
        this.h.i = false;
        if (this.h.uj == 1) {
            bx();
        } else {
            if (!this.f2420a.a() && this.yp.qy() == getWidth() && this.yp.gu() == getHeight()) {
                this.yp.uj(this);
            }
            aw();
        }
        this.yp.uj(this);
        sv();
        aw();
    }

    private void cu() {
        int iN;
        View focusedChild = (this.xd && hasFocus() && this.u != null) ? getFocusedChild() : null;
        gu guVarUj = focusedChild != null ? uj(focusedChild) : null;
        if (guVarUj == null) {
            qp();
            return;
        }
        this.h.u = this.u.tt() ? guVarUj.sp() : -1L;
        gt gtVar = this.h;
        if (this.gu) {
            iN = -1;
        } else {
            iN = guVarUj.nu() ? guVarUj.uj : guVarUj.n();
        }
        gtVar.t = iN;
        this.h.yp = u(guVarUj.c);
    }

    private void qp() {
        this.h.u = -1L;
        this.h.t = -1;
        this.h.yp = -1;
    }

    private View nb() {
        gu guVarUj;
        int i2 = this.h.t != -1 ? this.h.t : 0;
        int iUj = this.h.uj();
        for (int i3 = i2; i3 < iUj; i3++) {
            gu guVarUj2 = uj(i3);
            if (guVarUj2 == null) {
                break;
            }
            if (guVarUj2.c.hasFocusable()) {
                return guVarUj2.c;
            }
        }
        int iMin = Math.min(iUj, i2);
        do {
            iMin--;
            if (iMin < 0 || (guVarUj = uj(iMin)) == null) {
                return null;
            }
        } while (!guVarUj.c.hasFocusable());
        return guVarUj.c;
    }

    private void pf() {
        View viewFindViewById;
        if (!this.xd || this.u == null || !hasFocus() || getDescendantFocusability() == 393216) {
            return;
        }
        if (getDescendantFocusability() == 131072 && isFocused()) {
            return;
        }
        if (!isFocused()) {
            View focusedChild = getFocusedChild();
            if (aw && (focusedChild.getParent() == null || !focusedChild.hasFocus())) {
                if (this.sp.tt() == 0) {
                    requestFocus();
                    return;
                }
            } else if (!this.sp.ve(focusedChild)) {
                return;
            }
        }
        View viewNb = null;
        gu guVarC = (this.h.u == -1 || !this.u.tt()) ? null : c(this.h.u);
        if (guVarC != null && !this.sp.ve(guVarC.c) && guVarC.c.hasFocusable()) {
            viewNb = guVarC.c;
        } else if (this.sp.tt() > 0) {
            viewNb = nb();
        }
        if (viewNb != null) {
            if (this.h.yp != -1 && (viewFindViewById = viewNb.findViewById(this.h.yp)) != null && viewFindViewById.isFocusable()) {
                viewNb = viewFindViewById;
            }
            viewNb.requestFocus();
        }
    }

    private int u(View view) {
        int id = view.getId();
        while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
            view = ((ViewGroup) view).getFocusedChild();
            if (view.getId() != -1) {
                id = view.getId();
            }
        }
        return id;
    }

    public final void c(gt gtVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.yv.c;
            gtVar.z = overScroller.getFinalX() - overScroller.getCurrX();
            gtVar.m = overScroller.getFinalY() - overScroller.getCurrY();
        } else {
            gtVar.z = 0;
            gtVar.m = 0;
        }
    }

    private void bx() {
        this.h.c(1);
        c(this.h);
        this.h.i = false;
        n();
        this.x.c();
        t();
        or();
        cu();
        gt gtVar = this.h;
        gtVar.x = gtVar.da && this.eo;
        this.eo = false;
        this.d = false;
        gt gtVar2 = this.h;
        gtVar2.sp = gtVar2.sl;
        this.h.n = this.u.c();
        c(this.gy);
        if (this.h.da) {
            int iTt = this.sp.tt();
            for (int i2 = 0; i2 < iTt; i2++) {
                gu guVarN = n(this.sp.tt(i2));
                if (!guVarN.R_() && (!guVarN.yp() || this.u.tt())) {
                    this.x.c(guVarN, this.zm.c(this.h, guVarN, a.n(guVarN), guVarN.rl()));
                    if (this.h.x && guVarN.yv() && !guVarN.nu() && !guVarN.R_() && !guVarN.yp()) {
                        this.x.c(c(guVarN), guVarN);
                    }
                }
            }
        }
        if (this.h.sl) {
            rh();
            boolean z2 = this.h.f2422a;
            this.h.f2422a = false;
            this.yp.c(this.n, this.h);
            this.h.f2422a = z2;
            for (int i3 = 0; i3 < this.sp.tt(); i3++) {
                gu guVarN2 = n(this.sp.tt(i3));
                if (!guVarN2.R_() && !this.x.uj(guVarN2)) {
                    int iN = a.n(guVarN2);
                    boolean zC = guVarN2.c(8192);
                    if (!zC) {
                        iN |= 4096;
                    }
                    a.tt ttVarC = this.zm.c(this.h, guVarN2, iN, guVarN2.rl());
                    if (zC) {
                        c(guVarN2, ttVarC);
                    } else {
                        this.x.tt(guVarN2, ttVarC);
                    }
                }
            }
            my();
        } else {
            my();
        }
        u();
        c(false);
        this.h.uj = 2;
    }

    private void sv() {
        n();
        t();
        this.h.c(6);
        this.f2420a.n();
        this.h.n = this.u.c();
        this.h.ve = 0;
        this.h.sp = false;
        this.yp.c(this.n, this.h);
        this.h.f2422a = false;
        gt gtVar = this.h;
        gtVar.da = gtVar.da && this.zm != null;
        this.h.uj = 4;
        u();
        c(false);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0079  */
    private void aw() {
        this.h.c(4);
        n();
        t();
        this.h.uj = 1;
        if (this.h.da) {
            for (int iTt = this.sp.tt() - 1; iTt >= 0; iTt--) {
                gu guVarN = n(this.sp.tt(iTt));
                if (!guVarN.R_()) {
                    long jC = c(guVarN);
                    a.tt ttVarC = this.zm.c(this.h, guVarN);
                    gu guVarC = this.x.c(jC);
                    if (guVarC != null && !guVarC.R_()) {
                        boolean zC = this.x.c(guVarC);
                        boolean zC2 = this.x.c(guVarN);
                        if (!zC || guVarC != guVarN) {
                            a.tt ttVarTt = this.x.tt(guVarC);
                            this.x.ve(guVarN, ttVarC);
                            a.tt ttVarVe = this.x.ve(guVarN);
                            if (ttVarTt == null) {
                                c(jC, guVarN, guVarC);
                            } else {
                                c(guVarC, guVarN, ttVarTt, ttVarVe, zC, zC2);
                            }
                        } else {
                            this.x.ve(guVarN, ttVarC);
                        }
                    } else {
                        this.x.ve(guVarN, ttVarC);
                    }
                }
            }
            this.x.c(this.kz);
        }
        this.yp.tt(this.n);
        gt gtVar = this.h;
        gtVar.tt = gtVar.n;
        this.gu = false;
        this.gr = false;
        this.h.da = false;
        this.h.sl = false;
        this.yp.u = false;
        if (this.n.tt != null) {
            this.n.tt.clear();
        }
        if (this.yp.nu) {
            this.yp.m = 0;
            this.yp.nu = false;
            this.n.tt();
        }
        this.yp.tt(this.h);
        u();
        c(false);
        this.x.c();
        int[] iArr = this.gy;
        if (da(iArr[0], iArr[1])) {
            x(0, 0);
        }
        pf();
        qp();
    }

    private void c(long j, gu guVar, gu guVar2) {
        int iTt = this.sp.tt();
        for (int i2 = 0; i2 < iTt; i2++) {
            gu guVarN = n(this.sp.tt(i2));
            if (guVarN != guVar && c(guVarN) == j) {
                c cVar = this.u;
                if (cVar != null && cVar.tt()) {
                    throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + guVarN + " \n View Holder 2:" + guVar + c());
                }
                throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + guVarN + " \n View Holder 2:" + guVar + c());
            }
        }
        com.byazt.nr.m.uj("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + guVar2 + " cannot be found but it is necessary for " + guVar + c());
    }

    public void c(gu guVar, a.tt ttVar) {
        guVar.c(0, 8192);
        if (this.h.x && guVar.yv() && !guVar.nu() && !guVar.R_()) {
            this.x.c(c(guVar), guVar);
        }
        this.x.c(guVar, ttVar);
    }

    private void c(int[] iArr) {
        int iTt = this.sp.tt();
        if (iTt == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < iTt; i4++) {
            gu guVarN = n(this.sp.tt(i4));
            if (!guVarN.R_()) {
                int iUj = guVarN.uj();
                if (iUj < i2) {
                    i2 = iUj;
                }
                if (iUj > i3) {
                    i3 = iUj;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    private boolean da(int i2, int i3) {
        c(this.gy);
        int[] iArr = this.gy;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z2) {
        gu guVarN = n(view);
        if (guVarN != null) {
            if (guVarN.rh()) {
                guVarN.u();
            } else if (!guVarN.R_()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + guVarN + c());
            }
        }
        view.clearAnimation();
        sl(view);
        super.removeDetachedView(view, z2);
    }

    public long c(gu guVar) {
        return this.u.tt() ? guVar.sp() : guVar.ve;
    }

    public void c(gu guVar, a.tt ttVar, a.tt ttVar2) {
        guVar.c(false);
        if (this.zm.tt(guVar, ttVar, ttVar2)) {
            z();
        }
    }

    public void tt(gu guVar, a.tt ttVar, a.tt ttVar2) {
        n(guVar);
        guVar.c(false);
        if (this.zm.c(guVar, ttVar, ttVar2)) {
            z();
        }
    }

    private void c(gu guVar, gu guVar2, a.tt ttVar, a.tt ttVar2, boolean z2, boolean z3) {
        guVar.c(false);
        if (z2) {
            n(guVar);
        }
        if (guVar != guVar2) {
            if (z3) {
                n(guVar2);
            }
            guVar.x = guVar2;
            n(guVar);
            this.n.ve(guVar);
            guVar2.c(false);
            guVar2.i = guVar;
        }
        if (this.zm.c(guVar, guVar2, ttVar, ttVar2)) {
            z();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        com.byazt.km.c.c("RV OnLayout");
        m();
        com.byazt.km.c.c();
        this.my = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.lo != 0 || this.rl) {
            this.gt = true;
        } else {
            super.requestLayout();
        }
    }

    public void nu() {
        int iVe = this.sp.ve();
        for (int i2 = 0; i2 < iVe; i2++) {
            ((da) this.sp.uj(i2).getLayoutParams()).ve = true;
        }
        this.n.da();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        super.draw(canvas);
        int size = this.m.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.m.get(i2);
        }
        EdgeEffect edgeEffect = this.kk;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.i ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.kk;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.tx;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.i) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.tx;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.v;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.i ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(-paddingTop, -width);
            EdgeEffect edgeEffect6 = this.v;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.os;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.i) {
                canvas.translate((-getWidth()) + getPaddingRight(), (-getHeight()) + getPaddingBottom());
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.os;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(iSave4);
        }
        if ((z2 || this.zm == null || this.m.size() <= 0 || !this.zm.tt()) && !z2) {
            return;
        }
        com.byazt.fq.sp.ve(this);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.m.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.m.get(i2);
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof da) && this.yp.c((da) layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        i iVar = this.yp;
        if (iVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + c());
        }
        return iVar.tt();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        i iVar = this.yp;
        if (iVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + c());
        }
        return iVar.c(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        i iVar = this.yp;
        if (iVar == null) {
            throw new IllegalStateException("RecyclerView has no LayoutManager" + c());
        }
        return iVar.c(layoutParams);
    }

    public void rh() {
        int iVe = this.sp.ve();
        for (int i2 = 0; i2 < iVe; i2++) {
            gu guVarN = n(this.sp.uj(i2));
            if (!guVarN.R_()) {
                guVarN.tt();
            }
        }
    }

    public void my() {
        int iVe = this.sp.ve();
        for (int i2 = 0; i2 < iVe; i2++) {
            gu guVarN = n(this.sp.uj(i2));
            if (!guVarN.R_()) {
                guVarN.c();
            }
        }
        this.n.i();
    }

    public void a(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int iVe = this.sp.ve();
        if (i2 < i3) {
            i6 = -1;
            i5 = i2;
            i4 = i3;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i7 = 0; i7 < iVe; i7++) {
            gu guVarN = n(this.sp.uj(i7));
            if (guVarN != null && guVarN.ve >= i5 && guVarN.ve <= i4) {
                if (guVarN.ve == i2) {
                    guVarN.c(i3 - i2, false);
                } else {
                    guVarN.c(i6, false);
                }
                this.h.f2422a = true;
            }
        }
        this.n.c(i2, i3);
        requestLayout();
    }

    public void sp(int i2, int i3) {
        int iVe = this.sp.ve();
        for (int i4 = 0; i4 < iVe; i4++) {
            gu guVarN = n(this.sp.uj(i4));
            if (guVarN != null && !guVarN.R_() && guVarN.ve >= i2) {
                guVarN.c(i3, false);
                this.h.f2422a = true;
            }
        }
        this.n.tt(i2, i3);
        requestLayout();
    }

    public void c(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int iVe = this.sp.ve();
        for (int i5 = 0; i5 < iVe; i5++) {
            gu guVarN = n(this.sp.uj(i5));
            if (guVarN != null && !guVarN.R_()) {
                if (guVarN.ve >= i4) {
                    guVarN.c(-i3, z2);
                    this.h.f2422a = true;
                } else if (guVarN.ve >= i2) {
                    guVarN.c(i2 - 1, -i3, z2);
                    this.h.f2422a = true;
                }
            }
        }
        this.n.c(i2, i3, z2);
        requestLayout();
    }

    public void c(int i2, int i3, Object obj) {
        int iVe = this.sp.ve();
        int i4 = i2 + i3;
        for (int i5 = 0; i5 < iVe; i5++) {
            View viewUj = this.sp.uj(i5);
            gu guVarN = n(viewUj);
            if (guVarN != null && !guVarN.R_() && guVarN.ve >= i2 && guVarN.ve < i4) {
                guVarN.tt(2);
                guVarN.c(obj);
                ((da) viewUj.getLayoutParams()).ve = true;
            }
        }
        this.n.ve(i2, i3);
    }

    public boolean tt(gu guVar) {
        a aVar = this.zm;
        return aVar == null || aVar.c(guVar, guVar.rl());
    }

    public void ve(boolean z2) {
        this.gr = z2 | this.gr;
        this.gu = true;
        gt();
    }

    public void gt() {
        int iVe = this.sp.ve();
        for (int i2 = 0; i2 < iVe; i2++) {
            gu guVarN = n(this.sp.uj(i2));
            if (guVarN != null && !guVarN.R_()) {
                guVarN.tt(6);
            }
        }
        nu();
        this.n.x();
    }

    public gu tt(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return n(view);
    }

    public View ve(View view) {
        Object parent;
        while (true) {
            parent = view.getParent();
            if (parent == null || parent == this || !(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public gu uj(View view) {
        View viewVe = ve(view);
        if (viewVe == null) {
            return null;
        }
        return tt(viewVe);
    }

    public static gu n(View view) {
        if (view == null) {
            return null;
        }
        return ((da) view.getLayoutParams()).c;
    }

    @Deprecated
    public int a(View view) {
        return sp(view);
    }

    public int sp(View view) {
        gu guVarN = n(view);
        if (guVarN != null) {
            return guVarN.n();
        }
        return -1;
    }

    public int x(View view) {
        gu guVarN = n(view);
        if (guVarN != null) {
            return guVarN.uj();
        }
        return -1;
    }

    public gu ve(int i2) {
        return c(i2, false);
    }

    public gu uj(int i2) {
        gu guVar = null;
        if (this.gu) {
            return null;
        }
        int iVe = this.sp.ve();
        for (int i3 = 0; i3 < iVe; i3++) {
            gu guVarN = n(this.sp.uj(i3));
            if (guVarN != null && !guVarN.nu() && uj(guVarN) == i2) {
                if (!this.sp.ve(guVarN.c)) {
                    return guVarN;
                }
                guVar = guVarN;
            }
        }
        return guVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0029  */
    /* JADX WARN: Code duplicated, block: B:17:0x0034  */
    /* JADX WARN: Code duplicated, block: B:21:0x0033 A[SYNTHETIC] */
    public gu c(int i2, boolean z2) {
        int iVe = this.sp.ve();
        gu guVar = null;
        for (int i3 = 0; i3 < iVe; i3++) {
            gu guVarN = n(this.sp.uj(i3));
            if (guVarN != null && !guVarN.nu()) {
                if (z2) {
                    if (guVarN.ve != i2) {
                        continue;
                    } else {
                        if (!this.sp.ve(guVarN.c)) {
                            return guVarN;
                        }
                        guVar = guVarN;
                    }
                } else if (guVarN.uj() != i2) {
                    continue;
                } else {
                    if (!this.sp.ve(guVarN.c)) {
                        return guVarN;
                    }
                    guVar = guVarN;
                }
            }
        }
        return guVar;
    }

    public gu c(long j) {
        c cVar = this.u;
        gu guVar = null;
        if (cVar != null && cVar.tt()) {
            int iVe = this.sp.ve();
            for (int i2 = 0; i2 < iVe; i2++) {
                gu guVarN = n(this.sp.uj(i2));
                if (guVarN != null && !guVarN.nu() && guVarN.sp() == j) {
                    if (!this.sp.ve(guVarN.c)) {
                        return guVarN;
                    }
                    guVar = guVarN;
                }
            }
        }
        return guVar;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j) {
        return super.drawChild(canvas, view, j);
    }

    public void n(int i2) {
        int iTt = this.sp.tt();
        for (int i3 = 0; i3 < iTt; i3++) {
            this.sp.tt(i3).offsetTopAndBottom(i2);
        }
    }

    public void a(int i2) {
        int iTt = this.sp.tt();
        for (int i3 = 0; i3 < iTt; i3++) {
            this.sp.tt(i3).offsetLeftAndRight(i2);
        }
    }

    public static void c(View view, Rect rect) {
        da daVar = (da) view.getLayoutParams();
        Rect rect2 = daVar.tt;
        rect.set((view.getLeft() - rect2.left) - daVar.leftMargin, (view.getTop() - rect2.top) - daVar.topMargin, view.getRight() + rect2.right + daVar.rightMargin, view.getBottom() + rect2.bottom + daVar.bottomMargin);
    }

    public Rect i(View view) {
        da daVar = (da) view.getLayoutParams();
        if (!daVar.ve) {
            return daVar.tt;
        }
        if (this.h.c() && (daVar.ve() || daVar.c())) {
            return daVar.tt;
        }
        Rect rect = daVar.tt;
        rect.set(0, 0, 0, 0);
        int size = this.m.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.sl.set(0, 0, 0, 0);
            this.m.get(i2).c(this.sl, view, this, this.h);
            rect.left += this.sl.left;
            rect.top += this.sl.top;
            rect.right += this.sl.right;
            rect.bottom += this.sl.bottom;
        }
        daVar.ve = false;
        return rect;
    }

    public void x(int i2, int i3) {
        this.b++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX, scrollY);
        yp ypVar = this.hq;
        if (ypVar != null) {
            ypVar.c(this, i2, i3);
        }
        List<yp> list = this.ny;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.ny.get(size).c(this, i2, i3);
            }
        }
        this.b--;
    }

    public void sp(int i2) {
        i iVar = this.yp;
        if (iVar != null) {
            iVar.sl(i2);
        }
        yp ypVar = this.hq;
        if (ypVar != null) {
            ypVar.c(this, i2);
        }
        List<yp> list = this.ny;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.ny.get(size).c(this, i2);
            }
        }
    }

    public boolean rl() {
        return !this.my || this.gu || this.f2420a.uj();
    }

    public void qy() {
        int iTt = this.sp.tt();
        for (int i2 = 0; i2 < iTt; i2++) {
            View viewTt = this.sp.tt(i2);
            gu guVarTt = tt(viewTt);
            if (guVarTt != null && guVarTt.i != null) {
                View view = guVarTt.i.c;
                int left = viewTt.getLeft();
                int top = viewTt.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    public static RecyclerView da(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView recyclerViewDa = da(viewGroup.getChildAt(i2));
            if (recyclerViewDa != null) {
                return recyclerViewDa;
            }
        }
        return null;
    }

    public static void ve(gu guVar) {
        if (guVar.tt != null) {
            RecyclerView recyclerView = guVar.tt.get();
            while (recyclerView != null) {
                if (recyclerView == guVar.c) {
                    return;
                }
                Object parent = recyclerView.getParent();
                recyclerView = parent instanceof View ? (View) parent : null;
            }
            guVar.tt = null;
        }
    }

    public long getNanoTime() {
        if (uj) {
            return System.nanoTime();
        }
        return 0L;
    }

    public void sl(View view) {
        n(view);
        List<sl> list = this.tk;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.tk.get(size).tt(view);
            }
        }
    }

    public void t(View view) {
        n(view);
        List<sl> list = this.tk;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.tk.get(size).c(view);
            }
        }
    }

    public boolean c(gu guVar, int i2) {
        if (yp()) {
            guVar.z = i2;
            this.qp.add(guVar);
            return false;
        }
        com.byazt.fq.sp.c(guVar.c, i2);
        return true;
    }

    public void gu() {
        int i2;
        for (int size = this.qp.size() - 1; size >= 0; size--) {
            gu guVar = this.qp.get(size);
            if (guVar.c.getParent() == this && !guVar.R_() && (i2 = guVar.z) != -1) {
                com.byazt.fq.sp.c(guVar.c, i2);
                guVar.z = -1;
            }
        }
        this.qp.clear();
    }

    public int uj(gu guVar) {
        if (guVar.c(524) || !guVar.m()) {
            return -1;
        }
        return this.f2420a.ve(guVar.ve);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().c(z2);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().c();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().tt(i2);
    }

    public boolean i(int i2, int i3) {
        return getScrollingChildHelper().c(i2, i3);
    }

    @Override // android.view.View, com.byazt.fq.tt
    public void stopNestedScroll() {
        getScrollingChildHelper().ve();
    }

    public void x(int i2) {
        getScrollingChildHelper().ve(i2);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().tt();
    }

    public boolean i(int i2) {
        return getScrollingChildHelper().c(i2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().c(i2, i3, i4, i5, iArr);
    }

    public boolean c(int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        return getScrollingChildHelper().c(i2, i3, i4, i5, iArr, i6);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2);
    }

    public boolean c(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2, i4);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z2) {
        return getScrollingChildHelper().c(f, f2, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return getScrollingChildHelper().c(f, f2);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        uj ujVar = this.gx;
        return ujVar == null ? super.getChildDrawingOrder(i2, i3) : ujVar.c(i2, i3);
    }

    private com.byazt.fq.uj getScrollingChildHelper() {
        if (this.mm == null) {
            this.mm = new com.byazt.fq.uj(this);
        }
        return this.mm;
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 1034})
    public static abstract class a {
        public c c = null;
        public ArrayList<Object> tt = new ArrayList<>();
        public long ve = 120;
        public long uj = 120;
        public long n = 250;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f2421a = 250;

        interface c {
            void c(gu guVar);
        }

        public long a() {
            return this.ve;
        }

        public abstract void c();

        public void c(c cVar) {
            this.c = cVar;
        }

        public abstract boolean c(gu guVar, tt ttVar, tt ttVar2);

        public abstract boolean c(gu guVar, gu guVar2, tt ttVar, tt ttVar2);

        public long n() {
            return this.n;
        }

        public long sp() {
            return this.uj;
        }

        public boolean sp(gu guVar) {
            return true;
        }

        public abstract boolean tt();

        public abstract boolean tt(gu guVar, tt ttVar, tt ttVar2);

        public abstract void uj();

        public abstract void uj(gu guVar);

        public abstract boolean ve(gu guVar, tt ttVar, tt ttVar2);

        public long x() {
            return this.f2421a;
        }

        public tt c(gt gtVar, gu guVar, int i, List<Object> list) {
            return da().c(guVar);
        }

        public tt c(gt gtVar, gu guVar) {
            return da().c(guVar);
        }

        public static int n(gu guVar) {
            int i = guVar.da;
            int i2 = i & 14;
            if (guVar.yp()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i2;
            }
            int iA = guVar.a();
            int iN = guVar.n();
            return (iA == -1 || iN == -1 || iA == iN) ? i2 : i2 | 2048;
        }

        public final void a(gu guVar) {
            c cVar = this.c;
            if (cVar != null) {
                cVar.c(guVar);
            }
        }

        public boolean c(gu guVar, List<Object> list) {
            return sp(guVar);
        }

        public final void i() {
            int size = this.tt.size();
            for (int i = 0; i < size; i++) {
                this.tt.get(i);
            }
            this.tt.clear();
        }

        public tt da() {
            return new tt();
        }

        @com.byazt.zqa.c(c = {0, 1, 166, 1672})
        public static class tt {
            public int c;
            public int tt;
            public int uj;
            public int ve;

            public tt c(gu guVar) {
                return c(guVar, 0);
            }

            public tt c(gu guVar, int i) {
                View view = guVar.c;
                this.c = view.getLeft();
                this.tt = view.getTop();
                this.ve = view.getRight();
                this.uj = view.getBottom();
                return this;
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 2496})
    private class sp implements a.c {
        public sp() {
        }

        @Override // com.byazt.kt.RecyclerView.a.c
        public void c(gu guVar) {
            guVar.c(true);
            if (guVar.x != null && guVar.i == null) {
                guVar.x = null;
            }
            guVar.i = null;
            if (guVar.gr() || RecyclerView.this.c(guVar.c) || !guVar.rh()) {
                return;
            }
            RecyclerView.this.removeDetachedView(guVar.c, false);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 2376})
    public static class gt {
        public int m;
        public SparseArray<Object> nu;
        public int t;
        public long u;
        public int yp;
        public int z;
        public int c = -1;
        public int tt = 0;
        public int ve = 0;
        public int uj = 1;
        public int n = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2422a = false;
        public boolean sp = false;
        public boolean x = false;
        public boolean i = false;
        public boolean da = false;
        public boolean sl = false;

        public boolean c() {
            return this.sp;
        }

        public boolean tt() {
            return this.sl;
        }

        public int uj() {
            return this.sp ? this.tt - this.ve : this.n;
        }

        public boolean ve() {
            return this.c != -1;
        }

        public void c(int i) {
            if ((this.uj & i) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i) + " but it is " + Integer.toBinaryString(this.uj));
            }
        }

        public void c(c cVar) {
            this.uj = 1;
            this.n = cVar.c();
            this.sp = false;
            this.x = false;
            this.i = false;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.c + ", mData=" + this.nu + ", mItemCount=" + this.n + ", mIsMeasuring=" + this.i + ", mPreviousLayoutItemCount=" + this.tt + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.ve + ", mStructureChanged=" + this.f2422a + ", mInPreLayout=" + this.sp + ", mRunSimpleAnimations=" + this.da + ", mRunPredictiveAnimations=" + this.sl + '}';
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 2503})
    static class tt extends Observable<ve> {
        public void c() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((ve) this.mObservers.get(size)).c();
            }
        }

        public void c(int i, int i2) {
            c(i, i2, null);
        }

        public void c(int i, int i2, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((ve) this.mObservers.get(size)).c(i, i2, obj);
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 2392})
    public static abstract class my {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public View f2426a;
        public boolean n;
        public RecyclerView tt;
        public boolean uj;
        public i ve;
        public boolean x;
        public int c = -1;
        public final c sp = new c(0, 0);

        public interface tt {
            PointF ve(int i);
        }

        public boolean a() {
            return this.uj;
        }

        public abstract void c();

        public abstract void c(int i, int i2, gt gtVar, c cVar);

        public abstract void c(View view, gt gtVar, c cVar);

        public boolean sp() {
            return this.n;
        }

        public i uj() {
            return this.ve;
        }

        public void ve(int i) {
            this.c = i;
        }

        public int x() {
            return this.c;
        }

        public void c(RecyclerView recyclerView, i iVar) {
            if (this.x) {
                com.byazt.nr.m.tt("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.tt = recyclerView;
            this.ve = iVar;
            if (this.c == -1) {
                throw new IllegalArgumentException("Invalid target position");
            }
            recyclerView.h.c = this.c;
            this.n = true;
            this.uj = true;
            this.f2426a = n(x());
            this.tt.yv.c();
            this.x = true;
        }

        public PointF uj(int i) {
            Object objUj = uj();
            if (objUj instanceof tt) {
                return ((tt) objUj).ve(i);
            }
            com.byazt.nr.m.tt("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + tt.class.getCanonicalName());
            return null;
        }

        public final void n() {
            if (this.n) {
                this.n = false;
                c();
                this.tt.h.c = -1;
                this.f2426a = null;
                this.c = -1;
                this.uj = false;
                this.ve.tt(this);
                this.ve = null;
                this.tt = null;
            }
        }

        public void c(int i, int i2) {
            PointF pointFUj;
            RecyclerView recyclerView = this.tt;
            if (!this.n || this.c == -1 || recyclerView == null) {
                n();
            }
            if (this.uj && this.f2426a == null && this.ve != null && (pointFUj = uj(this.c)) != null && (pointFUj.x != 0.0f || pointFUj.y != 0.0f)) {
                recyclerView.c((int) Math.signum(pointFUj.x), (int) Math.signum(pointFUj.y), (int[]) null);
            }
            this.uj = false;
            View view = this.f2426a;
            if (view != null) {
                if (c(view) == this.c) {
                    c(this.f2426a, recyclerView.h, this.sp);
                    this.sp.c(recyclerView);
                    n();
                } else {
                    com.byazt.nr.m.uj("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f2426a = null;
                }
            }
            if (this.n) {
                c(i, i2, recyclerView.h, this.sp);
                boolean zC = this.sp.c();
                this.sp.c(recyclerView);
                if (zC) {
                    if (this.n) {
                        this.uj = true;
                        recyclerView.yv.c();
                    } else {
                        n();
                    }
                }
            }
        }

        public int c(View view) {
            return this.tt.x(view);
        }

        public int i() {
            return this.tt.yp.my();
        }

        public View n(int i) {
            return this.tt.yp.tt(i);
        }

        public void tt(View view) {
            if (c(view) == x()) {
                this.f2426a = view;
            }
        }

        public void c(PointF pointF) {
            float fSqrt = (float) Math.sqrt((pointF.x * pointF.x) + (pointF.y * pointF.y));
            pointF.x /= fSqrt;
            pointF.y /= fSqrt;
        }

        @com.byazt.zqa.c(c = {0, 1, 166, 959})
        public static class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f2427a;
            public int c;
            public Interpolator n;
            public int sp;
            public int tt;
            public int uj;
            public int ve;

            public void c(int i) {
                this.uj = i;
            }

            public boolean c() {
                return this.uj >= 0;
            }

            public void update(int i, int i2, int i3, Interpolator interpolator) {
                this.c = i;
                this.tt = i2;
                this.ve = i3;
                this.n = interpolator;
                this.f2427a = true;
            }

            public c(int i, int i2) {
                this(i, i2, Integer.MIN_VALUE, null);
            }

            public c(int i, int i2, int i3, Interpolator interpolator) {
                this.uj = -1;
                this.f2427a = false;
                this.sp = 0;
                this.c = i;
                this.tt = i2;
                this.ve = i3;
                this.n = interpolator;
            }

            public void c(RecyclerView recyclerView) {
                int i = this.uj;
                if (i >= 0) {
                    this.uj = -1;
                    recyclerView.c(i);
                    this.f2427a = false;
                } else {
                    if (!this.f2427a) {
                        this.sp = 0;
                        return;
                    }
                    tt();
                    if (this.n != null) {
                        recyclerView.yv.c(this.c, this.tt, this.ve, this.n);
                    } else if (this.ve == Integer.MIN_VALUE) {
                        recyclerView.yv.tt(this.c, this.tt);
                    } else {
                        recyclerView.yv.c(this.c, this.tt, this.ve);
                    }
                    int i2 = this.sp + 1;
                    this.sp = i2;
                    if (i2 > 10) {
                        com.byazt.nr.m.uj("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f2427a = false;
                }
            }

            private void tt() {
                if (this.n != null && this.ve <= 0) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                }
                if (this.ve <= 0) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 2369})
    public static class da extends ViewGroup.MarginLayoutParams {
        public gu c;
        public final Rect tt;
        public boolean uj;
        public boolean ve;

        public da(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.tt = new Rect();
            this.ve = true;
            this.uj = false;
        }

        public da(int i, int i2) {
            super(i, i2);
            this.tt = new Rect();
            this.ve = true;
            this.uj = false;
        }

        public da(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.tt = new Rect();
            this.ve = true;
            this.uj = false;
        }

        public da(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.tt = new Rect();
            this.ve = true;
            this.uj = false;
        }

        public da(da daVar) {
            super((ViewGroup.MarginLayoutParams) daVar);
            this.tt = new Rect();
            this.ve = true;
            this.uj = false;
        }

        public boolean c() {
            return this.c.yp();
        }

        public boolean tt() {
            return this.c.nu();
        }

        public boolean ve() {
            return this.c.yv();
        }

        public int uj() {
            return this.c.uj();
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 2379})
    public static abstract class gu {
        public static final List<Object> nu = Collections.emptyList();
        public final View c;
        public int da;
        public RecyclerView m;
        public WeakReference<RecyclerView> tt;
        public int ve = -1;
        public int uj = -1;
        public long n = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2423a = -1;
        public int sp = -1;
        public gu x = null;
        public gu i = null;
        public List<Object> sl = null;
        public List<Object> t = null;
        public int rh = 0;
        public m u = null;
        public boolean yp = false;
        public int my = 0;
        public int z = -1;

        public boolean R_() {
            return (this.da & 128) != 0;
        }

        public final int a() {
            return this.uj;
        }

        public void c() {
            this.uj = -1;
            this.sp = -1;
        }

        public void c(int i, int i2) {
            this.da = (i & i2) | (this.da & (~i2));
        }

        public void c(m mVar, boolean z) {
            this.u = mVar;
            this.yp = z;
        }

        public boolean c(int i) {
            return (i & this.da) != 0;
        }

        public boolean gr() {
            return (this.da & 16) != 0;
        }

        public boolean i() {
            return this.u != null;
        }

        public boolean m() {
            return (this.da & 1) != 0;
        }

        public boolean nu() {
            return (this.da & 8) != 0;
        }

        public boolean rh() {
            return (this.da & 256) != 0;
        }

        public boolean sl() {
            return (this.da & 32) != 0;
        }

        public final long sp() {
            return this.n;
        }

        public void t() {
            this.da &= -33;
        }

        public void tt() {
            if (this.uj == -1) {
                this.uj = this.ve;
            }
        }

        public void tt(int i) {
            this.da = i | this.da;
        }

        public void u() {
            this.da &= -257;
        }

        public final int uj() {
            int i = this.sp;
            return i == -1 ? this.ve : i;
        }

        public final int x() {
            return this.f2423a;
        }

        public boolean yp() {
            return (this.da & 4) != 0;
        }

        public boolean yv() {
            return (this.da & 2) != 0;
        }

        public boolean z() {
            return (this.da & 2) != 0;
        }

        public gu(View view) {
            if (view == null) {
                throw new IllegalArgumentException("itemView may not be null");
            }
            this.c = view;
        }

        public void c(int i, int i2, boolean z) {
            tt(8);
            c(i2, z);
            this.ve = i;
        }

        public void c(int i, boolean z) {
            if (this.uj == -1) {
                this.uj = this.ve;
            }
            if (this.sp == -1) {
                this.sp = this.ve;
            }
            if (z) {
                this.sp += i;
            }
            this.ve += i;
            if (this.c.getLayoutParams() != null) {
                ((da) this.c.getLayoutParams()).ve = true;
            }
        }

        public final int n() {
            RecyclerView recyclerView = this.m;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.uj(this);
        }

        public void da() {
            this.u.ve(this);
        }

        public boolean my() {
            return (this.da & 512) != 0 || yp();
        }

        public void c(Object obj) {
            if (obj == null) {
                tt(1024);
            } else if ((1024 & this.da) == 0) {
                p();
                this.sl.add(obj);
            }
        }

        private void p() {
            if (this.sl == null) {
                ArrayList arrayList = new ArrayList();
                this.sl = arrayList;
                this.t = Collections.unmodifiableList(arrayList);
            }
        }

        public void gt() {
            List<Object> list = this.sl;
            if (list != null) {
                list.clear();
            }
            this.da &= -1025;
        }

        public List<Object> rl() {
            if ((this.da & 1024) != 0) {
                return nu;
            }
            List<Object> list = this.sl;
            return (list == null || list.size() == 0) ? nu : this.t;
        }

        public void qy() {
            this.da = 0;
            this.ve = -1;
            this.uj = -1;
            this.n = -1L;
            this.sp = -1;
            this.rh = 0;
            this.x = null;
            this.i = null;
            gt();
            this.my = 0;
            this.z = -1;
            RecyclerView.ve(this);
        }

        public void c(RecyclerView recyclerView) {
            int i = this.z;
            if (i != -1) {
                this.my = i;
            } else {
                this.my = com.byazt.fq.sp.tt(this.c);
            }
            recyclerView.c(this, 4);
        }

        public void tt(RecyclerView recyclerView) {
            recyclerView.c(this, this.my);
            this.my = 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.ve + " id=" + this.n + ", oldPos=" + this.uj + ", pLpos:" + this.sp);
            if (i()) {
                sb.append(" scrap ").append(this.yp ? "[changeScrap]" : "[attachedScrap]");
            }
            if (yp()) {
                sb.append(" invalid");
            }
            if (!m()) {
                sb.append(" unbound");
            }
            if (z()) {
                sb.append(" update");
            }
            if (nu()) {
                sb.append(" removed");
            }
            if (R_()) {
                sb.append(" ignored");
            }
            if (rh()) {
                sb.append(" tmpDetached");
            }
            if (!gu()) {
                sb.append(" not recyclable(" + this.rh + ")");
            }
            if (my()) {
                sb.append(" undefined adapter position");
            }
            if (this.c.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append(com.alipay.sdk.util.i.d);
            return sb.toString();
        }

        public final void c(boolean z) {
            int i = this.rh;
            int i2 = z ? i - 1 : i + 1;
            this.rh = i2;
            if (i2 < 0) {
                this.rh = 0;
                com.byazt.nr.m.uj("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.da |= 16;
            } else if (z && i2 == 0) {
                this.da &= -17;
            }
        }

        public final boolean gu() {
            return (this.da & 16) == 0 && !com.byazt.fq.sp.a(this.c);
        }

        public boolean zm() {
            return (this.da & 16) == 0 && com.byazt.fq.sp.a(this.c);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 1031})
    public static abstract class x {
        @Deprecated
        public void c(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void c(Rect rect, View view, RecyclerView recyclerView, gt gtVar) {
            c(rect, ((da) view.getLayoutParams()).uj(), recyclerView);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 166, AnalyticsListener.EVENT_DRM_SESSION_RELEASED})
    public static abstract class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2424a;
        public final com.byazt.kt.u.tt c;
        public com.byazt.kt.u da;
        public RecyclerView i;
        public int m;
        public int n;
        public boolean nu;
        public int rh;
        public com.byazt.kt.u sl;
        public int sp;
        public my t;
        public final com.byazt.kt.u.tt tt;
        public boolean u;
        public boolean uj;
        public boolean ve;
        public com.byazt.kt.tt x;
        public boolean yp;
        public boolean z;

        public interface c {
            void tt(int i, int i2);
        }

        public int a(gt gtVar) {
            return 0;
        }

        public int c(int i, m mVar, gt gtVar) {
            return 0;
        }

        public View c(View view, int i, m mVar, gt gtVar) {
            return null;
        }

        public void c(int i, int i2, gt gtVar, c cVar) {
        }

        public void c(int i, c cVar) {
        }

        public void c(RecyclerView recyclerView, m mVar) {
        }

        public boolean c() {
            return this.z;
        }

        public boolean c(da daVar) {
            return daVar != null;
        }

        public boolean c(RecyclerView recyclerView, ArrayList<View> arrayList, int i, int i2) {
            return false;
        }

        public int gt() {
            return this.n;
        }

        public int gu() {
            return this.rh;
        }

        public boolean i() {
            return false;
        }

        public int n(gt gtVar) {
            return 0;
        }

        public int qy() {
            return this.sp;
        }

        public int rh() {
            return -1;
        }

        public int rl() {
            return this.f2424a;
        }

        public void sl(int i) {
        }

        public int sp(gt gtVar) {
            return 0;
        }

        public boolean t() {
            return false;
        }

        public int tt(int i, m mVar, gt gtVar) {
            return 0;
        }

        public abstract da tt();

        public void tt(gt gtVar) {
        }

        public void tt(my myVar) {
            if (this.t == myVar) {
                this.t = null;
            }
        }

        public int uj(gt gtVar) {
            return 0;
        }

        public View uj(View view, int i) {
            return null;
        }

        public void uj(int i) {
        }

        public boolean uj() {
            return false;
        }

        public int ve(gt gtVar) {
            return 0;
        }

        public void ve(RecyclerView recyclerView) {
        }

        public boolean ve() {
            return false;
        }

        public int x(gt gtVar) {
            return 0;
        }

        public final boolean yp() {
            return this.uj;
        }

        public i() {
            com.byazt.kt.u.tt ttVar = new com.byazt.kt.u.tt() { // from class: com.byazt.kt.RecyclerView.i.1
                @Override // com.byazt.kt.u.tt
                public View c(int i) {
                    return i.this.x(i);
                }

                @Override // com.byazt.kt.u.tt
                public int c() {
                    return i.this.gr();
                }

                @Override // com.byazt.kt.u.tt
                public int tt() {
                    return i.this.qy() - i.this.yv();
                }

                @Override // com.byazt.kt.u.tt
                public int c(View view) {
                    return i.this.sp(view) - ((da) view.getLayoutParams()).leftMargin;
                }

                @Override // com.byazt.kt.u.tt
                public int tt(View view) {
                    return i.this.i(view) + ((da) view.getLayoutParams()).rightMargin;
                }
            };
            this.c = ttVar;
            com.byazt.kt.u.tt ttVar2 = new com.byazt.kt.u.tt() { // from class: com.byazt.kt.RecyclerView.i.2
                @Override // com.byazt.kt.u.tt
                public View c(int i) {
                    return i.this.x(i);
                }

                @Override // com.byazt.kt.u.tt
                public int c() {
                    return i.this.zm();
                }

                @Override // com.byazt.kt.u.tt
                public int tt() {
                    return i.this.gu() - i.this.p();
                }

                @Override // com.byazt.kt.u.tt
                public int c(View view) {
                    return i.this.x(view) - ((da) view.getLayoutParams()).topMargin;
                }

                @Override // com.byazt.kt.u.tt
                public int tt(View view) {
                    return i.this.da(view) + ((da) view.getLayoutParams()).bottomMargin;
                }
            };
            this.tt = ttVar2;
            this.da = new com.byazt.kt.u(ttVar);
            this.sl = new com.byazt.kt.u(ttVar2);
            this.u = false;
            this.yp = false;
            this.z = false;
            this.ve = true;
            this.uj = true;
        }

        public void c(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.i = null;
                this.x = null;
                this.sp = 0;
                this.rh = 0;
            } else {
                this.i = recyclerView;
                this.x = recyclerView.sp;
                this.sp = recyclerView.getWidth();
                this.rh = recyclerView.getHeight();
            }
            this.n = 1073741824;
            this.f2424a = 1073741824;
        }

        public void tt(int i, int i2) {
            this.sp = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            this.n = mode;
            if (mode == 0 && !RecyclerView.tt) {
                this.sp = 0;
            }
            this.rh = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i2);
            this.f2424a = mode2;
            if (mode2 != 0 || RecyclerView.tt) {
                return;
            }
            this.rh = 0;
        }

        public void ve(int i, int i2) {
            int iMy = my();
            if (iMy == 0) {
                this.i.n(i, i2);
                return;
            }
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < iMy; i7++) {
                View viewX = x(i7);
                Rect rect = this.i.sl;
                c(viewX, rect);
                if (rect.left < i6) {
                    i6 = rect.left;
                }
                if (rect.right > i3) {
                    i3 = rect.right;
                }
                if (rect.top < i4) {
                    i4 = rect.top;
                }
                if (rect.bottom > i5) {
                    i5 = rect.bottom;
                }
            }
            this.i.sl.set(i6, i4, i3, i5);
            c(this.i.sl, i, i2);
        }

        public void c(Rect rect, int i, int i2) {
            n(c(i, rect.width() + gr() + yv(), d()), c(i2, rect.height() + zm() + p(), eo()));
        }

        public void u() {
            RecyclerView recyclerView = this.i;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public static int c(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void c(String str) {
            RecyclerView recyclerView = this.i;
            if (recyclerView != null) {
                recyclerView.c(str);
            }
        }

        public void tt(RecyclerView recyclerView) {
            this.yp = true;
            ve(recyclerView);
        }

        public void tt(RecyclerView recyclerView, m mVar) {
            this.yp = false;
            c(recyclerView, mVar);
        }

        public boolean z() {
            RecyclerView recyclerView = this.i;
            return recyclerView != null && recyclerView.i;
        }

        public void c(m mVar, gt gtVar) {
            com.byazt.nr.m.uj("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public da c(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof da) {
                return new da((da) layoutParams);
            }
            return layoutParams instanceof ViewGroup.MarginLayoutParams ? new da((ViewGroup.MarginLayoutParams) layoutParams) : new da(layoutParams);
        }

        public da c(Context context, AttributeSet attributeSet) {
            return new da(context, attributeSet);
        }

        public void c(RecyclerView recyclerView, gt gtVar, int i) {
            com.byazt.nr.m.uj("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void c(my myVar) {
            my myVar2 = this.t;
            if (myVar2 != null && myVar != myVar2 && myVar2.sp()) {
                this.t.n();
            }
            this.t = myVar;
            myVar.c(this.i, this);
        }

        public boolean m() {
            my myVar = this.t;
            return myVar != null && myVar.sp();
        }

        public int nu() {
            return com.byazt.fq.sp.c(this.i);
        }

        public void c(View view) {
            c(view, -1);
        }

        public void c(View view, int i) {
            c(view, i, true);
        }

        public void tt(View view) {
            tt(view, -1);
        }

        public void tt(View view, int i) {
            c(view, i, false);
        }

        private void c(View view, int i, boolean z) {
            gu guVarN = RecyclerView.n(view);
            if (!z && !guVarN.nu()) {
                this.i.x.a(guVarN);
            } else {
                this.i.x.n(guVarN);
            }
            da daVar = (da) view.getLayoutParams();
            if (!guVarN.sl() && !guVarN.i()) {
                if (view.getParent() == this.i) {
                    int iTt = this.x.tt(view);
                    if (i == -1) {
                        i = this.x.tt();
                    }
                    if (iTt == -1) {
                        throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.i.indexOfChild(view) + this.i.c());
                    }
                    if (iTt != i) {
                        this.i.yp.uj(iTt, i);
                    }
                } else {
                    this.x.c(view, i, false);
                    daVar.ve = true;
                    my myVar = this.t;
                    if (myVar != null && myVar.sp()) {
                        this.t.tt(view);
                    }
                }
            } else {
                if (guVarN.i()) {
                    guVarN.da();
                } else {
                    guVarN.t();
                }
                this.x.c(view, i, view.getLayoutParams(), false);
            }
            if (daVar.uj) {
                guVarN.c.invalidate();
                daVar.uj = false;
            }
        }

        public void ve(View view) {
            this.x.c(view);
        }

        public void a(int i) {
            if (x(i) != null) {
                this.x.c(i);
            }
        }

        public int uj(View view) {
            return ((da) view.getLayoutParams()).uj();
        }

        public View tt(int i) {
            int iMy = my();
            for (int i2 = 0; i2 < iMy; i2++) {
                View viewX = x(i2);
                gu guVarN = RecyclerView.n(viewX);
                if (guVarN != null && guVarN.uj() == i && !guVarN.R_() && (this.i.h.c() || !guVarN.nu())) {
                    return viewX;
                }
            }
            return null;
        }

        public void sp(int i) {
            c(i, x(i));
        }

        private void c(int i, View view) {
            this.x.n(i);
        }

        public void c(View view, int i, da daVar) {
            gu guVarN = RecyclerView.n(view);
            if (guVarN.nu()) {
                this.i.x.n(guVarN);
            } else {
                this.i.x.a(guVarN);
            }
            this.x.c(view, i, daVar, guVarN.nu());
        }

        public void ve(View view, int i) {
            c(view, i, (da) view.getLayoutParams());
        }

        public void uj(int i, int i2) {
            View viewX = x(i);
            if (viewX == null) {
                throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.i.toString());
            }
            sp(i);
            ve(viewX, i2);
        }

        public void c(View view, m mVar) {
            ve(view);
            mVar.c(view);
        }

        public void c(int i, m mVar) {
            View viewX = x(i);
            a(i);
            mVar.c(viewX);
        }

        public int my() {
            com.byazt.kt.tt ttVar = this.x;
            if (ttVar != null) {
                return ttVar.tt();
            }
            return 0;
        }

        public View x(int i) {
            com.byazt.kt.tt ttVar = this.x;
            if (ttVar != null) {
                return ttVar.tt(i);
            }
            return null;
        }

        public int gr() {
            RecyclerView recyclerView = this.i;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int zm() {
            RecyclerView recyclerView = this.i;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int yv() {
            RecyclerView recyclerView = this.i;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int p() {
            RecyclerView recyclerView = this.i;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public View md() {
            View focusedChild;
            RecyclerView recyclerView = this.i;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.x.ve(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int h() {
            RecyclerView recyclerView = this.i;
            c adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.c();
            }
            return 0;
        }

        public void i(int i) {
            RecyclerView recyclerView = this.i;
            if (recyclerView != null) {
                recyclerView.a(i);
            }
        }

        public void da(int i) {
            RecyclerView recyclerView = this.i;
            if (recyclerView != null) {
                recyclerView.n(i);
            }
        }

        public void c(m mVar) {
            for (int iMy = my() - 1; iMy >= 0; iMy--) {
                c(mVar, iMy, x(iMy));
            }
        }

        private void c(m mVar, int i, View view) {
            gu guVarN = RecyclerView.n(view);
            if (guVarN.R_()) {
                return;
            }
            if (guVarN.yp() && !guVarN.nu() && !this.i.u.tt()) {
                a(i);
                mVar.tt(guVarN);
            } else {
                sp(i);
                mVar.ve(view);
                this.i.x.x(guVarN);
            }
        }

        public void tt(m mVar) {
            int iN = mVar.n();
            for (int i = iN - 1; i >= 0; i--) {
                View viewUj = mVar.uj(i);
                gu guVarN = RecyclerView.n(viewUj);
                if (!guVarN.R_()) {
                    guVarN.c(false);
                    if (guVarN.rh()) {
                        this.i.removeDetachedView(viewUj, false);
                    }
                    if (this.i.zm != null) {
                        this.i.zm.uj(guVarN);
                    }
                    guVarN.c(true);
                    mVar.tt(viewUj);
                }
            }
            mVar.a();
            if (iN > 0) {
                this.i.invalidate();
            }
        }

        public boolean c(View view, int i, int i2, da daVar) {
            return (!view.isLayoutRequested() && this.ve && tt(view.getWidth(), i, daVar.width) && tt(view.getHeight(), i2, daVar.height)) ? false : true;
        }

        private static boolean tt(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 > 0 && i != i3) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i;
            }
            return true;
        }

        public void c(View view, int i, int i2) {
            da daVar = (da) view.getLayoutParams();
            Rect rectI = this.i.i(view);
            int i3 = i + rectI.left + rectI.right;
            int i4 = i2 + rectI.top + rectI.bottom;
            int iC = c(qy(), gt(), gr() + yv() + daVar.leftMargin + daVar.rightMargin + i3, daVar.width, ve());
            int iC2 = c(gu(), rl(), zm() + p() + daVar.topMargin + daVar.bottomMargin + i4, daVar.height, uj());
            if (c(view, iC, iC2, daVar)) {
                view.measure(iC, iC2);
            }
        }

        /* JADX WARN: Code duplicated, block: B:11:0x001a  */
        /* JADX WARN: Code duplicated, block: B:13:0x001e  */
        /* JADX WARN: Code duplicated, block: B:19:0x002c  */
        public static int c(int i, int i2, int i3, int i4, boolean z) {
            int iMax = Math.max(0, i - i3);
            if (z) {
                if (i4 >= 0) {
                    i2 = 1073741824;
                } else if (i4 == -1 && (i2 == Integer.MIN_VALUE || i2 == 1073741824)) {
                    i4 = iMax;
                } else {
                    i2 = 0;
                    i4 = 0;
                }
            } else if (i4 >= 0) {
                i2 = 1073741824;
            } else if (i4 == -1) {
                i4 = iMax;
            } else if (i4 != -2) {
                i2 = 0;
                i4 = 0;
            } else if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                i4 = iMax;
                i2 = Integer.MIN_VALUE;
            } else {
                i4 = iMax;
                i2 = 0;
            }
            return View.MeasureSpec.makeMeasureSpec(i4, i2);
        }

        public int n(View view) {
            Rect rect = ((da) view.getLayoutParams()).tt;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int a(View view) {
            Rect rect = ((da) view.getLayoutParams()).tt;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void c(View view, int i, int i2, int i3, int i4) {
            da daVar = (da) view.getLayoutParams();
            Rect rect = daVar.tt;
            view.layout(i + rect.left + daVar.leftMargin, i2 + rect.top + daVar.topMargin, (i3 - rect.right) - daVar.rightMargin, (i4 - rect.bottom) - daVar.bottomMargin);
        }

        public void c(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((da) view.getLayoutParams()).tt;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.i != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.i.t;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void c(View view, Rect rect) {
            RecyclerView.c(view, rect);
        }

        public int sp(View view) {
            return view.getLeft() - u(view);
        }

        public int x(View view) {
            return view.getTop() - sl(view);
        }

        public int i(View view) {
            return view.getRight() + yp(view);
        }

        public int da(View view) {
            return view.getBottom() + t(view);
        }

        public int sl(View view) {
            return ((da) view.getLayoutParams()).tt.top;
        }

        public int t(View view) {
            return ((da) view.getLayoutParams()).tt.bottom;
        }

        public int u(View view) {
            return ((da) view.getLayoutParams()).tt.left;
        }

        public int yp(View view) {
            return ((da) view.getLayoutParams()).tt.right;
        }

        private int[] tt(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            int[] iArr = new int[2];
            int iGr = gr();
            int iZm = zm();
            int iQy = qy() - yv();
            int iGu = gu() - p();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int iWidth = rect.width() + left;
            int iHeight = rect.height() + top;
            int i = left - iGr;
            int iMin = Math.min(0, i);
            int i2 = top - iZm;
            int iMin2 = Math.min(0, i2);
            int i3 = iWidth - iQy;
            int iMax = Math.max(0, i3);
            int iMax2 = Math.max(0, iHeight - iGu);
            if (nu() != 1) {
                if (iMin == 0) {
                    iMin = Math.min(i, iMax);
                }
                iMax = iMin;
            } else if (iMax == 0) {
                iMax = Math.max(iMin, i3);
            }
            if (iMin2 == 0) {
                iMin2 = Math.min(i2, iMax2);
            }
            iArr[0] = iMax;
            iArr[1] = iMin2;
            return iArr;
        }

        public boolean c(RecyclerView recyclerView, View view, Rect rect, boolean z) {
            return c(recyclerView, view, rect, z, false);
        }

        public boolean c(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
            int[] iArrTt = tt(recyclerView, view, rect, z);
            int i = iArrTt[0];
            int i2 = iArrTt[1];
            if ((z2 && !c(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
                return false;
            }
            if (z) {
                recyclerView.scrollBy(i, i2);
            } else {
                recyclerView.c(i, i2);
            }
            return true;
        }

        private boolean c(RecyclerView recyclerView, int i, int i2) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int iGr = gr();
            int iZm = zm();
            int iQy = qy() - yv();
            int iGu = gu() - p();
            Rect rect = this.i.sl;
            c(focusedChild, rect);
            return rect.left - i < iQy && rect.right - i > iGr && rect.top - i2 < iGu && rect.bottom - i2 > iZm;
        }

        @Deprecated
        public boolean c(RecyclerView recyclerView, View view, View view2) {
            return m() || recyclerView.yp();
        }

        public boolean c(RecyclerView recyclerView, gt gtVar, View view, View view2) {
            return c(recyclerView, view, view2);
        }

        public void c(m mVar, gt gtVar, int i, int i2) {
            this.i.n(i, i2);
        }

        public void n(int i, int i2) {
            this.i.setMeasuredDimension(i, i2);
        }

        public int d() {
            return com.byazt.fq.sp.uj(this.i);
        }

        public int eo() {
            return com.byazt.fq.sp.n(this.i);
        }

        public void zb() {
            my myVar = this.t;
            if (myVar != null) {
                myVar.n();
            }
        }

        public void ve(m mVar) {
            for (int iMy = my() - 1; iMy >= 0; iMy--) {
                if (!RecyclerView.n(x(iMy)).R_()) {
                    c(iMy, mVar);
                }
            }
        }

        public void uj(RecyclerView recyclerView) {
            tt(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
        }

        public boolean or() {
            int iMy = my();
            for (int i = 0; i < iMy; i++) {
                ViewGroup.LayoutParams layoutParams = x(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 166, AnalyticsListener.EVENT_DRM_KEYS_REMOVED})
    public static abstract class c<VH extends gu> {
        public final tt c = new tt();
        public boolean tt = false;

        public abstract int c();

        public int c(int i) {
            return 0;
        }

        public abstract VH c(ViewGroup viewGroup, int i);

        public void c(VH vh) {
        }

        public abstract void c(VH vh, int i);

        public long tt(int i) {
            return -1L;
        }

        public final boolean tt() {
            return this.tt;
        }

        public boolean tt(VH vh) {
            return false;
        }

        public void c(VH vh, int i, List<Object> list) {
            c(vh, i);
        }

        public final VH tt(ViewGroup viewGroup, int i) {
            try {
                com.byazt.km.c.c("RV CreateView");
                VH vh = (VH) c(viewGroup, i);
                if (vh.c.getParent() != null) {
                    throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
                }
                vh.f2423a = i;
                com.byazt.km.c.c();
                return vh;
            } catch (Throwable th) {
                com.byazt.km.c.c();
                throw th;
            }
        }

        public final void tt(VH vh, int i) {
            vh.ve = i;
            if (tt()) {
                vh.n = tt(i);
            }
            vh.c(1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX);
            com.byazt.km.c.c("RV OnBindView");
            c(vh, i, vh.rl());
            vh.gt();
            ViewGroup.LayoutParams layoutParams = vh.c.getLayoutParams();
            if (layoutParams instanceof da) {
                ((da) layoutParams).ve = true;
            }
            com.byazt.km.c.c();
        }

        public void c(ve veVar) {
            this.c.registerObserver(veVar);
        }

        public void tt(ve veVar) {
            this.c.unregisterObserver(veVar);
        }

        public final void ve() {
            this.c.c();
        }

        public final void c(int i, Object obj) {
            this.c.c(i, 1, obj);
        }

        public final void c(int i, int i2) {
            this.c.c(i, i2);
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 166, AnalyticsListener.EVENT_DRM_KEYS_LOADED})
    public final class m {
        public final ArrayList<gu> c;
        public rl i;
        public z n;
        public final List<gu> sp;
        public ArrayList<gu> tt;
        public int uj;
        public final ArrayList<gu> ve;
        public int x;

        public void c(rl rlVar) {
            this.i = rlVar;
        }

        public List<gu> ve() {
            return this.sp;
        }

        public m() {
            ArrayList<gu> arrayList = new ArrayList<>();
            this.c = arrayList;
            this.tt = null;
            this.ve = new ArrayList<>();
            this.sp = Collections.unmodifiableList(arrayList);
            this.x = 2;
            this.uj = 2;
        }

        public void c() {
            this.c.clear();
            uj();
        }

        public void c(int i) {
            this.x = i;
            tt();
        }

        public void tt() {
            this.uj = this.x + (RecyclerView.this.yp != null ? RecyclerView.this.yp.m : 0);
            for (int size = this.ve.size() - 1; size >= 0 && this.ve.size() > this.uj; size--) {
                ve(size);
            }
        }

        public boolean c(gu guVar) {
            if (guVar.nu()) {
                return RecyclerView.this.h.c();
            }
            if (guVar.ve >= 0 && guVar.ve < RecyclerView.this.u.c()) {
                if (RecyclerView.this.h.c() || RecyclerView.this.u.c(guVar.ve) == guVar.x()) {
                    return !RecyclerView.this.u.tt() || guVar.sp() == RecyclerView.this.u.tt(guVar.ve);
                }
                return false;
            }
            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + guVar + RecyclerView.this.c());
        }

        private boolean c(gu guVar, int i, int i2, long j) {
            guVar.m = RecyclerView.this;
            int iX = guVar.x();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j != Long.MAX_VALUE && !this.n.tt(iX, nanoTime, j)) {
                return false;
            }
            RecyclerView.this.u.tt(guVar, i);
            this.n.tt(guVar.x(), RecyclerView.this.getNanoTime() - nanoTime);
            if (!RecyclerView.this.h.c()) {
                return true;
            }
            guVar.sp = i2;
            return true;
        }

        public View tt(int i) {
            return c(i, false);
        }

        public View c(int i, boolean z) {
            return c(i, z, Long.MAX_VALUE).c;
        }

        /* JADX WARN: Code duplicated, block: B:100:0x020f  */
        /* JADX WARN: Code duplicated, block: B:102:0x0217  */
        /* JADX WARN: Code duplicated, block: B:103:0x0225  */
        /* JADX WARN: Code duplicated, block: B:106:0x022b A[ADDED_TO_REGION] */
        /* JADX WARN: Code duplicated, block: B:108:0x022e  */
        /* JADX WARN: Code duplicated, block: B:18:0x0037 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:19:0x0039  */
        /* JADX WARN: Code duplicated, block: B:21:0x0043  */
        /* JADX WARN: Code duplicated, block: B:22:0x004e  */
        /* JADX WARN: Code duplicated, block: B:24:0x0054  */
        /* JADX WARN: Code duplicated, block: B:27:0x005c  */
        /* JADX WARN: Code duplicated, block: B:29:0x005f  */
        /* JADX WARN: Code duplicated, block: B:73:0x0182 A[PHI: r1 r4
  0x0182: PHI (r1v18 com.byazt.kt.RecyclerView$gu) = (r1v17 com.byazt.kt.RecyclerView$gu), (r1v43 com.byazt.kt.RecyclerView$gu) binds: [B:28:0x005d, B:59:0x00fe] A[DONT_GENERATE, DONT_INLINE]
  0x0182: PHI (r4v3 boolean) = (r4v2 boolean), (r4v7 boolean) binds: [B:28:0x005d, B:59:0x00fe] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Code duplicated, block: B:82:0x01a3  */
        /* JADX WARN: Code duplicated, block: B:88:0x01d1  */
        /* JADX WARN: Code duplicated, block: B:90:0x01d7  */
        /* JADX WARN: Code duplicated, block: B:99:0x0201  */
        public gu c(int i, boolean z, long j) {
            gu guVarTt;
            boolean z2;
            gu guVar;
            boolean z3;
            boolean zC;
            ViewGroup.LayoutParams layoutParams;
            da daVar;
            int iTt;
            RecyclerView recyclerViewDa;
            rl rlVar;
            View viewC;
            if (i >= 0 && i < RecyclerView.this.h.uj()) {
                if (RecyclerView.this.h.c()) {
                    guVarTt = n(i);
                    if (guVarTt != null) {
                        z2 = true;
                    }
                    if (guVarTt == null && (guVarTt = tt(i, z)) != null) {
                        if (c(guVarTt)) {
                            z2 = true;
                        } else {
                            if (!z) {
                                guVarTt.tt(4);
                                if (guVarTt.i()) {
                                    RecyclerView.this.removeDetachedView(guVarTt.c, false);
                                    guVarTt.da();
                                } else if (guVarTt.sl()) {
                                    guVarTt.t();
                                }
                                tt(guVarTt);
                            }
                            guVarTt = null;
                        }
                    }
                    if (guVarTt == null) {
                        guVar = guVarTt;
                    } else {
                        iTt = RecyclerView.this.f2420a.tt(i);
                        if (iTt >= 0 || iTt >= RecyclerView.this.u.c()) {
                            throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + iTt + ").state:" + RecyclerView.this.h.uj() + RecyclerView.this.c());
                        }
                        int iC = RecyclerView.this.u.c(iTt);
                        if (RecyclerView.this.u.tt() && (guVarTt = c(RecyclerView.this.u.tt(iTt), iC, z)) != null) {
                            guVarTt.ve = iTt;
                            z2 = true;
                        }
                        if (guVarTt == null && (rlVar = this.i) != null && (viewC = rlVar.c(this, i, iC)) != null) {
                            guVarTt = RecyclerView.this.tt(viewC);
                            if (guVarTt == null) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder" + RecyclerView.this.c());
                            }
                            if (guVarTt.R_()) {
                                throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view." + RecyclerView.this.c());
                            }
                        }
                        if (guVarTt == null) {
                            gu guVarC = sp().c(iC);
                            if (guVarC != null) {
                                guVarC.qy();
                                if (RecyclerView.c) {
                                    n(guVarC);
                                }
                            }
                            guVarTt = guVarC;
                        }
                        if (guVarTt == null) {
                            long nanoTime = RecyclerView.this.getNanoTime();
                            if (j != Long.MAX_VALUE && !this.n.c(iC, nanoTime, j)) {
                                return null;
                            }
                            gu guVarTt2 = RecyclerView.this.u.tt(RecyclerView.this, iC);
                            if (RecyclerView.uj && (recyclerViewDa = RecyclerView.da(guVarTt2.c)) != null) {
                                guVarTt2.tt = new WeakReference<>(recyclerViewDa);
                            }
                            this.n.c(iC, RecyclerView.this.getNanoTime() - nanoTime);
                            guVar = guVarTt2;
                        } else {
                            guVar = guVarTt;
                        }
                    }
                    z3 = z2;
                    if (z3 && !RecyclerView.this.h.c() && guVar.c(8192)) {
                        guVar.c(0, 8192);
                        if (RecyclerView.this.h.da) {
                            RecyclerView.this.c(guVar, RecyclerView.this.zm.c(RecyclerView.this.h, guVar, a.n(guVar) | 4096, guVar.rl()));
                        }
                    }
                    if (!RecyclerView.this.h.c() && guVar.m()) {
                        guVar.sp = i;
                    } else {
                        if (guVar.m() || guVar.z() || guVar.yp()) {
                            zC = c(guVar, RecyclerView.this.f2420a.tt(i), i, j);
                        }
                        layoutParams = guVar.c.getLayoutParams();
                        if (layoutParams == null) {
                            daVar = (da) RecyclerView.this.generateDefaultLayoutParams();
                            guVar.c.setLayoutParams(daVar);
                        } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                            daVar = (da) RecyclerView.this.generateLayoutParams(layoutParams);
                            guVar.c.setLayoutParams(daVar);
                        } else {
                            daVar = (da) layoutParams;
                        }
                        daVar.c = guVar;
                        daVar.uj = !z3 && zC;
                        return guVar;
                    }
                    zC = false;
                    layoutParams = guVar.c.getLayoutParams();
                    if (layoutParams == null) {
                        daVar = (da) RecyclerView.this.generateDefaultLayoutParams();
                        guVar.c.setLayoutParams(daVar);
                    } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                        daVar = (da) RecyclerView.this.generateLayoutParams(layoutParams);
                        guVar.c.setLayoutParams(daVar);
                    } else {
                        daVar = (da) layoutParams;
                    }
                    daVar.c = guVar;
                    daVar.uj = !z3 && zC;
                    return guVar;
                }
                guVarTt = null;
                z2 = false;
                if (guVarTt == null) {
                    if (c(guVarTt)) {
                        if (!z) {
                            guVarTt.tt(4);
                            if (guVarTt.i()) {
                                RecyclerView.this.removeDetachedView(guVarTt.c, false);
                                guVarTt.da();
                            } else if (guVarTt.sl()) {
                                guVarTt.t();
                            }
                            tt(guVarTt);
                        }
                        guVarTt = null;
                    } else {
                        z2 = true;
                    }
                }
                if (guVarTt == null) {
                    iTt = RecyclerView.this.f2420a.tt(i);
                    if (iTt >= 0) {
                    }
                    throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + i + "(offset:" + iTt + ").state:" + RecyclerView.this.h.uj() + RecyclerView.this.c());
                }
                guVar = guVarTt;
                z3 = z2;
                if (z3) {
                    guVar.c(0, 8192);
                    if (RecyclerView.this.h.da) {
                        RecyclerView.this.c(guVar, RecyclerView.this.zm.c(RecyclerView.this.h, guVar, a.n(guVar) | 4096, guVar.rl()));
                    }
                }
                if (!RecyclerView.this.h.c()) {
                    if (guVar.m()) {
                    }
                    zC = c(guVar, RecyclerView.this.f2420a.tt(i), i, j);
                } else {
                    if (guVar.m()) {
                    }
                    zC = c(guVar, RecyclerView.this.f2420a.tt(i), i, j);
                }
                layoutParams = guVar.c.getLayoutParams();
                if (layoutParams == null) {
                    daVar = (da) RecyclerView.this.generateDefaultLayoutParams();
                    guVar.c.setLayoutParams(daVar);
                } else if (!RecyclerView.this.checkLayoutParams(layoutParams)) {
                    daVar = (da) RecyclerView.this.generateLayoutParams(layoutParams);
                    guVar.c.setLayoutParams(daVar);
                } else {
                    daVar = (da) layoutParams;
                }
                daVar.c = guVar;
                daVar.uj = !z3 && zC;
                return guVar;
            }
            throw new IndexOutOfBoundsException("Invalid item position " + i + "(" + i + "). Item count:" + RecyclerView.this.h.uj() + RecyclerView.this.c());
        }

        private void n(gu guVar) {
            if (guVar.c instanceof ViewGroup) {
                c((ViewGroup) guVar.c, false);
            }
        }

        private void c(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    c((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                } else {
                    int visibility = viewGroup.getVisibility();
                    viewGroup.setVisibility(4);
                    viewGroup.setVisibility(visibility);
                }
            }
        }

        public void c(View view) {
            gu guVarN = RecyclerView.n(view);
            if (guVarN.rh()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (guVarN.i()) {
                guVarN.da();
            } else if (guVarN.sl()) {
                guVarN.t();
            }
            tt(guVarN);
        }

        public void uj() {
            for (int size = this.ve.size() - 1; size >= 0; size--) {
                ve(size);
            }
            this.ve.clear();
            if (RecyclerView.uj) {
                RecyclerView.this.md.c();
            }
        }

        public void ve(int i) {
            c(this.ve.get(i), true);
            this.ve.remove(i);
        }

        public void tt(gu guVar) {
            boolean z;
            boolean z2 = false;
            boolean z3 = true;
            if (!guVar.i() && guVar.c.getParent() == null) {
                if (guVar.rh()) {
                    throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + guVar + RecyclerView.this.c());
                }
                if (guVar.R_()) {
                    throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.c());
                }
                boolean zZm = guVar.zm();
                if ((RecyclerView.this.u != null && zZm && RecyclerView.this.u.tt(guVar)) || guVar.gu()) {
                    if (this.uj <= 0 || guVar.c(526)) {
                        z = false;
                    } else {
                        int size = this.ve.size();
                        if (size >= this.uj && size > 0) {
                            ve(0);
                            size--;
                        }
                        if (RecyclerView.uj && size > 0 && !RecyclerView.this.md.c(guVar.ve)) {
                            int i = size - 1;
                            while (i >= 0) {
                                if (!RecyclerView.this.md.c(this.ve.get(i).ve)) {
                                    break;
                                } else {
                                    i--;
                                }
                            }
                            size = i + 1;
                        }
                        this.ve.add(size, guVar);
                        z = true;
                    }
                    if (z) {
                        z3 = false;
                    } else {
                        c(guVar, true);
                    }
                    z2 = z;
                } else {
                    z3 = false;
                }
                RecyclerView.this.x.sp(guVar);
                if (z2 || z3 || !zZm) {
                    return;
                }
                guVar.m = null;
                return;
            }
            throw new IllegalArgumentException("Scrapped or attached views may not be recycled. isScrap:" + guVar.i() + " isAttached:" + (guVar.c.getParent() != null) + RecyclerView.this.c());
        }

        public void c(gu guVar, boolean z) {
            RecyclerView.ve(guVar);
            if (guVar.c(16384)) {
                guVar.c(0, 16384);
            }
            if (z) {
                uj(guVar);
            }
            guVar.m = null;
            sp().c(guVar);
        }

        public void tt(View view) {
            gu guVarN = RecyclerView.n(view);
            guVarN.u = null;
            guVarN.yp = false;
            guVarN.t();
            tt(guVarN);
        }

        public void ve(View view) {
            gu guVarN = RecyclerView.n(view);
            if (!guVarN.c(12) && guVarN.yv() && !RecyclerView.this.tt(guVarN)) {
                if (this.tt == null) {
                    this.tt = new ArrayList<>();
                }
                guVarN.c(this, true);
                this.tt.add(guVarN);
                return;
            }
            if (guVarN.yp() && !guVarN.nu() && !RecyclerView.this.u.tt()) {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.c());
            }
            guVarN.c(this, false);
            this.c.add(guVarN);
        }

        public void ve(gu guVar) {
            if (guVar.yp) {
                this.tt.remove(guVar);
            } else {
                this.c.remove(guVar);
            }
            guVar.u = null;
            guVar.yp = false;
            guVar.t();
        }

        public int n() {
            return this.c.size();
        }

        public View uj(int i) {
            return this.c.get(i).c;
        }

        public void a() {
            this.c.clear();
            ArrayList<gu> arrayList = this.tt;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        public gu n(int i) {
            int size;
            int iTt;
            ArrayList<gu> arrayList = this.tt;
            if (arrayList != null && (size = arrayList.size()) != 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    gu guVar = this.tt.get(i2);
                    if (!guVar.sl() && guVar.uj() == i) {
                        guVar.tt(32);
                        return guVar;
                    }
                }
                if (RecyclerView.this.u.tt() && (iTt = RecyclerView.this.f2420a.tt(i)) > 0 && iTt < RecyclerView.this.u.c()) {
                    long jTt = RecyclerView.this.u.tt(iTt);
                    for (int i3 = 0; i3 < size; i3++) {
                        gu guVar2 = this.tt.get(i3);
                        if (!guVar2.sl() && guVar2.sp() == jTt) {
                            guVar2.tt(32);
                            return guVar2;
                        }
                    }
                }
            }
            return null;
        }

        public gu tt(int i, boolean z) {
            View viewVe;
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                gu guVar = this.c.get(i2);
                if (!guVar.sl() && guVar.uj() == i && !guVar.yp() && (RecyclerView.this.h.sp || !guVar.nu())) {
                    guVar.tt(32);
                    return guVar;
                }
            }
            if (!z && (viewVe = RecyclerView.this.sp.ve(i)) != null) {
                gu guVarN = RecyclerView.n(viewVe);
                RecyclerView.this.sp.n(viewVe);
                int iTt = RecyclerView.this.sp.tt(viewVe);
                if (iTt == -1) {
                    throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + guVarN + RecyclerView.this.c());
                }
                RecyclerView.this.sp.n(iTt);
                ve(viewVe);
                guVarN.tt(8224);
                return guVarN;
            }
            int size2 = this.ve.size();
            for (int i3 = 0; i3 < size2; i3++) {
                gu guVar2 = this.ve.get(i3);
                if (!guVar2.yp() && guVar2.uj() == i) {
                    if (!z) {
                        this.ve.remove(i3);
                    }
                    return guVar2;
                }
            }
            return null;
        }

        public gu c(long j, int i, boolean z) {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                gu guVar = this.c.get(size);
                if (guVar.sp() == j && !guVar.sl()) {
                    if (i == guVar.x()) {
                        guVar.tt(32);
                        if (guVar.nu() && !RecyclerView.this.h.c()) {
                            guVar.c(2, 14);
                        }
                        return guVar;
                    }
                    if (!z) {
                        this.c.remove(size);
                        RecyclerView.this.removeDetachedView(guVar.c, false);
                        tt(guVar.c);
                    }
                }
            }
            int size2 = this.ve.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                gu guVar2 = this.ve.get(size2);
                if (guVar2.sp() == j) {
                    if (i == guVar2.x()) {
                        if (!z) {
                            this.ve.remove(size2);
                        }
                        return guVar2;
                    }
                    if (!z) {
                        ve(size2);
                        return null;
                    }
                }
            }
        }

        public void uj(gu guVar) {
            if (RecyclerView.this.u != null) {
                RecyclerView.this.u.c(guVar);
            }
            if (RecyclerView.this.h != null) {
                RecyclerView.this.x.sp(guVar);
            }
        }

        public void c(c cVar, c cVar2, boolean z) {
            c();
            sp().c(cVar, cVar2, z);
        }

        public void c(int i, int i2) {
            int i3;
            int i4;
            int i5;
            if (i < i2) {
                i3 = -1;
                i5 = i;
                i4 = i2;
            } else {
                i3 = 1;
                i4 = i;
                i5 = i2;
            }
            int size = this.ve.size();
            for (int i6 = 0; i6 < size; i6++) {
                gu guVar = this.ve.get(i6);
                if (guVar != null && guVar.ve >= i5 && guVar.ve <= i4) {
                    if (guVar.ve == i) {
                        guVar.c(i2 - i, false);
                    } else {
                        guVar.c(i3, false);
                    }
                }
            }
        }

        public void tt(int i, int i2) {
            int size = this.ve.size();
            for (int i3 = 0; i3 < size; i3++) {
                gu guVar = this.ve.get(i3);
                if (guVar != null && guVar.ve >= i) {
                    guVar.c(i2, true);
                }
            }
        }

        public void c(int i, int i2, boolean z) {
            int i3 = i + i2;
            for (int size = this.ve.size() - 1; size >= 0; size--) {
                gu guVar = this.ve.get(size);
                if (guVar != null) {
                    if (guVar.ve >= i3) {
                        guVar.c(-i2, z);
                    } else if (guVar.ve >= i) {
                        guVar.tt(8);
                        ve(size);
                    }
                }
            }
        }

        public void c(z zVar) {
            z zVar2 = this.n;
            if (zVar2 != null) {
                zVar2.ve();
            }
            this.n = zVar;
            if (zVar == null || RecyclerView.this.getAdapter() == null) {
                return;
            }
            this.n.tt();
        }

        public z sp() {
            if (this.n == null) {
                this.n = new z();
            }
            return this.n;
        }

        public void ve(int i, int i2) {
            int i3;
            int i4 = i2 + i;
            for (int size = this.ve.size() - 1; size >= 0; size--) {
                gu guVar = this.ve.get(size);
                if (guVar != null && (i3 = guVar.ve) >= i && i3 < i4) {
                    guVar.tt(2);
                    ve(size);
                }
            }
        }

        public void x() {
            int size = this.ve.size();
            for (int i = 0; i < size; i++) {
                gu guVar = this.ve.get(i);
                if (guVar != null) {
                    guVar.tt(6);
                    guVar.c((Object) null);
                }
            }
            if (RecyclerView.this.u == null || !RecyclerView.this.u.tt()) {
                uj();
            }
        }

        public void i() {
            int size = this.ve.size();
            for (int i = 0; i < size; i++) {
                this.ve.get(i).c();
            }
            int size2 = this.c.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.c.get(i2).c();
            }
            ArrayList<gu> arrayList = this.tt;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    this.tt.get(i3).c();
                }
            }
        }

        public void da() {
            int size = this.ve.size();
            for (int i = 0; i < size; i++) {
                da daVar = (da) this.ve.get(i).c.getLayoutParams();
                if (daVar != null) {
                    daVar.ve = true;
                }
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 166, AnalyticsListener.EVENT_PLAYER_RELEASED})
    public static class z {
        public SparseArray<c> c = new SparseArray<>();
        public int tt = 0;

        @com.byazt.zqa.c(c = {0, 1, 166, 407})
        static class c {
            public final ArrayList<gu> c = new ArrayList<>();
            public int tt = 5;
            public long ve = 0;
            public long uj = 0;
        }

        public void tt() {
            this.tt++;
        }

        public void ve() {
            this.tt--;
        }

        public void c() {
            for (int i = 0; i < this.c.size(); i++) {
                this.c.valueAt(i).c.clear();
            }
        }

        public gu c(int i) {
            c cVar = this.c.get(i);
            if (cVar == null || cVar.c.isEmpty()) {
                return null;
            }
            ArrayList<gu> arrayList = cVar.c;
            return arrayList.remove(arrayList.size() - 1);
        }

        public void c(gu guVar) {
            int iX = guVar.x();
            ArrayList<gu> arrayList = tt(iX).c;
            if (this.c.get(iX).tt > arrayList.size()) {
                guVar.qy();
                arrayList.add(guVar);
            }
        }

        public long c(long j, long j2) {
            return j == 0 ? j2 : ((j / 4) * 3) + (j2 / 4);
        }

        public void c(int i, long j) {
            c cVarTt = tt(i);
            cVarTt.ve = c(cVarTt.ve, j);
        }

        public void tt(int i, long j) {
            c cVarTt = tt(i);
            cVarTt.uj = c(cVarTt.uj, j);
        }

        public boolean c(int i, long j, long j2) {
            long j3 = tt(i).ve;
            return j3 == 0 || j + j3 < j2;
        }

        public boolean tt(int i, long j, long j2) {
            long j3 = tt(i).uj;
            return j3 == 0 || j + j3 < j2;
        }

        public void c(c cVar, c cVar2, boolean z) {
            if (cVar != null) {
                ve();
            }
            if (!z && this.tt == 0) {
                c();
            }
            if (cVar2 != null) {
                tt();
            }
        }

        private c tt(int i) {
            c cVar = this.c.get(i);
            if (cVar != null) {
                return cVar;
            }
            c cVar2 = new c();
            this.c.put(i, cVar2);
            return cVar2;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 1024})
    public static class n {
        public EdgeEffect c(RecyclerView recyclerView, int i) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 2488})
    private class rh extends ve {
        public rh() {
        }

        @Override // com.byazt.kt.RecyclerView.ve
        public void c() {
            RecyclerView.this.c((String) null);
            RecyclerView.this.h.f2422a = true;
            RecyclerView.this.ve(true);
            if (RecyclerView.this.f2420a.uj()) {
                return;
            }
            RecyclerView.this.requestLayout();
        }

        @Override // com.byazt.kt.RecyclerView.ve
        public void c(int i, int i2, Object obj) {
            RecyclerView.this.c((String) null);
            if (RecyclerView.this.f2420a.c(i, i2, obj)) {
                tt();
            }
        }

        public void tt() {
            if (RecyclerView.ve && RecyclerView.this.rh && RecyclerView.this.nu) {
                RecyclerView recyclerView = RecyclerView.this;
                com.byazt.fq.sp.c(recyclerView, recyclerView.da);
            } else {
                RecyclerView.this.qy = true;
                RecyclerView.this.requestLayout();
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 166, 2486})
    class qy implements Runnable {
        public OverScroller c;
        public int n;
        public int uj;
        public Interpolator tt = RecyclerView.nb;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2428a = false;
        public boolean sp = false;

        private void ve() {
            this.sp = false;
            this.f2428a = true;
        }

        public qy() {
            this.c = new OverScroller(RecyclerView.this.getContext(), RecyclerView.nb);
        }

        /* JADX WARN: Code duplicated, block: B:43:0x00e2  */
        /* JADX WARN: Code duplicated, block: B:49:0x00ec  */
        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            if (RecyclerView.this.yp == null) {
                tt();
                return;
            }
            ve();
            RecyclerView.this.uj();
            OverScroller overScroller = this.c;
            my myVar = RecyclerView.this.yp.t;
            if (overScroller.computeScrollOffset()) {
                int[] iArr = RecyclerView.this.or;
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i6 = currX - this.uj;
                int i7 = currY - this.n;
                this.uj = currX;
                this.n = currY;
                if (RecyclerView.this.c(i6, i7, iArr, null, 1)) {
                    i6 -= iArr[0];
                    i7 -= iArr[1];
                }
                if (RecyclerView.this.u != null) {
                    RecyclerView recyclerView = RecyclerView.this;
                    recyclerView.c(i6, i7, recyclerView.cu);
                    i = RecyclerView.this.cu[0];
                    i2 = RecyclerView.this.cu[1];
                    i3 = i6 - i;
                    i4 = i7 - i2;
                    if (myVar != null && !myVar.a() && myVar.sp()) {
                        int iUj = RecyclerView.this.h.uj();
                        if (iUj == 0) {
                            myVar.n();
                        } else {
                            if (myVar.x() >= iUj) {
                                myVar.ve(iUj - 1);
                            }
                            myVar.c(i6 - i3, i7 - i4);
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                }
                if (!RecyclerView.this.m.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.ve(i6, i7);
                }
                if (!RecyclerView.this.c(i, i2, i3, i4, (int[]) null, 1) && (i3 != 0 || i4 != 0)) {
                    int currVelocity = (int) overScroller.getCurrVelocity();
                    if (i3 == currX) {
                        i5 = 0;
                    } else if (i3 < 0) {
                        i5 = -currVelocity;
                    } else if (i3 > 0) {
                        i5 = currVelocity;
                    } else {
                        i5 = 0;
                    }
                    if (i4 == currY) {
                        currVelocity = 0;
                    } else if (i4 < 0) {
                        currVelocity = -currVelocity;
                    } else if (i4 <= 0) {
                        currVelocity = 0;
                    }
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        RecyclerView.this.uj(i5, currVelocity);
                    }
                    if ((i5 != 0 || i3 == currX || overScroller.getFinalX() == 0) && (currVelocity != 0 || i4 == currY || overScroller.getFinalY() == 0)) {
                        overScroller.abortAnimation();
                    }
                }
                if (i != 0 || i2 != 0) {
                    RecyclerView.this.x(i, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = (i6 == 0 && i7 == 0) || (i6 != 0 && RecyclerView.this.yp.ve() && i == i6) || (i7 != 0 && RecyclerView.this.yp.uj() && i2 == i7);
                if (overScroller.isFinished() || (!z && !RecyclerView.this.i(1))) {
                    RecyclerView.this.setScrollState(0);
                    if (RecyclerView.uj) {
                        RecyclerView.this.md.c();
                    }
                    RecyclerView.this.x(1);
                } else {
                    c();
                    if (RecyclerView.this.p != null) {
                        RecyclerView.this.p.c(RecyclerView.this, i6, i7);
                    }
                }
            }
            if (myVar != null) {
                if (myVar.a()) {
                    myVar.c(0, 0);
                }
                if (!this.sp) {
                    myVar.n();
                }
            }
            uj();
        }

        private void uj() {
            this.f2428a = false;
            if (this.sp) {
                c();
            }
        }

        public void c() {
            if (this.f2428a) {
                this.sp = true;
            } else {
                RecyclerView.this.removeCallbacks(this);
                com.byazt.fq.sp.c(RecyclerView.this, this);
            }
        }

        public void c(int i, int i2) {
            RecyclerView.this.setScrollState(2);
            this.n = 0;
            this.uj = 0;
            this.c.fling(0, 0, i, i2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
            c();
        }

        public void tt(int i, int i2) {
            c(i, i2, 0, 0);
        }

        public void c(int i, int i2, int i3, int i4) {
            c(i, i2, tt(i, i2, i3, i4));
        }

        private float c(float f) {
            return (float) Math.sin((f - 0.5f) * 0.47123894f);
        }

        private int tt(int i, int i2, int i3, int i4) {
            int iRound;
            int iAbs = Math.abs(i);
            int iAbs2 = Math.abs(i2);
            boolean z = iAbs > iAbs2;
            int iSqrt = (int) Math.sqrt((i3 * i3) + (i4 * i4));
            int iSqrt2 = (int) Math.sqrt((i * i) + (i2 * i2));
            RecyclerView recyclerView = RecyclerView.this;
            int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
            int i5 = width / 2;
            float f = width;
            float f2 = i5;
            float fC = f2 + (c(Math.min(1.0f, (iSqrt2 * 1.0f) / f)) * f2);
            if (iSqrt > 0) {
                iRound = Math.round(Math.abs(fC / iSqrt) * 1000.0f) * 4;
            } else {
                if (!z) {
                    iAbs = iAbs2;
                }
                iRound = (int) (((iAbs / f) + 1.0f) * 300.0f);
            }
            return Math.min(iRound, 2000);
        }

        public void c(int i, int i2, int i3) {
            c(i, i2, i3, RecyclerView.nb);
        }

        public void c(int i, int i2, Interpolator interpolator) {
            int iTt = tt(i, i2, 0, 0);
            if (interpolator == null) {
                interpolator = RecyclerView.nb;
            }
            c(i, i2, iTt, interpolator);
        }

        public void c(int i, int i2, int i3, Interpolator interpolator) {
            if (this.tt != interpolator) {
                this.tt = interpolator;
                this.c = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            RecyclerView.this.setScrollState(2);
            this.n = 0;
            this.uj = 0;
            this.c.startScroll(0, 0, i, i2, i3);
            c();
        }

        public void tt() {
            RecyclerView.this.removeCallbacks(this);
            this.c.abortAnimation();
        }
    }
}
