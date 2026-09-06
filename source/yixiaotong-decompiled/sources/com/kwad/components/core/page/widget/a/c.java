package com.kwad.components.core.page.widget.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c<V extends View> extends KSCoordinatorLayout.Behavior<V> {
    private float agL;
    private int agM;
    private boolean agN;
    private int agO;
    protected int agP;
    private int agQ;
    private int agR;
    protected int agS;
    private float agT;
    private boolean agU;
    private boolean agV;
    protected i agW;
    private boolean agX;
    private boolean agY;
    private int agZ;
    private boolean aha;
    private int ahb;
    private WeakReference<V> ahc;
    protected WeakReference<View> ahd;
    private a ahe;
    protected int ahf;
    private boolean ahg;
    private Map<View, Integer> ahh;
    protected boolean ahm;
    private c<V>.RunnableC0686c ahn;
    private int mActivePointerId;
    private VelocityTracker mVelocityTracker;
    private boolean agK = true;
    private int mState = 4;
    protected float ahi = 1.0f;
    protected float ahj = 1.0f;
    protected float ahk = 0.5f;
    protected float ahl = 0.5f;
    private final i.a aho = new i.a() { // from class: com.kwad.components.core.page.widget.a.c.2
        @Override // com.kwad.components.core.page.widget.a.i.a
        public final boolean tryCaptureView(View view, int i) {
            View view2;
            if (c.this.mState == 1 || c.this.ahg) {
                return false;
            }
            return ((c.this.mState == 3 && c.this.mActivePointerId == i && (view2 = c.this.ahd.get()) != null && view2.canScrollVertically(-1)) || c.this.ahc == null || c.this.ahc.get() != view) ? false : true;
        }

        @Override // com.kwad.components.core.page.widget.a.i.a
        public final void bH(int i) {
            c.this.bG(i);
        }

        @Override // com.kwad.components.core.page.widget.a.i.a
        public final void onViewDragStateChanged(int i) {
            if (i == 1) {
                c.this.bE(1);
            }
        }

        @Override // com.kwad.components.core.page.widget.a.i.a
        public final void onViewReleased(View view, float f, float f2) {
            int iVl = 0;
            int i = 6;
            if (f2 < 0.0f) {
                if (!c.this.agK) {
                    if (view.getTop() > c.this.agR) {
                        iVl = c.this.agR;
                    }
                } else if (c.this.e(view, f2)) {
                    iVl = c.this.agQ;
                } else {
                    iVl = c.this.agS;
                    i = 4;
                }
                i = 3;
            } else if (c.this.agU && c.this.d(view, f2) && (view.getTop() > c.this.agS || Math.abs(f) < Math.abs(f2))) {
                iVl = c.this.ahb;
                i = 5;
            } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                int top = view.getTop();
                if (!c.this.agK) {
                    if (top < c.this.agR) {
                        if (top < Math.abs(top - c.this.agS)) {
                            i = 3;
                        } else {
                            iVl = c.this.agR;
                        }
                    } else if (Math.abs(top - c.this.agR) < Math.abs(top - c.this.agS)) {
                        iVl = c.this.agR;
                    } else {
                        iVl = c.this.agS;
                        i = 4;
                    }
                } else if (c.this.e(view, f2)) {
                    iVl = c.this.agQ;
                    i = 3;
                } else {
                    iVl = c.this.agS;
                    i = 4;
                }
            } else if (c.this.e(view, f2)) {
                iVl = c.this.vl();
                i = 3;
            } else {
                iVl = c.this.agS;
                i = 4;
            }
            if (c.this.agW.settleCapturedViewAt(view.getLeft(), iVl)) {
                c.this.bE(2);
                c.this.ahn = new RunnableC0686c(view, i);
                ViewCompat.postOnAnimation(view, c.this.ahn);
                return;
            }
            c.this.bE(i);
        }

        @Override // com.kwad.components.core.page.widget.a.i.a
        public final int bI(int i) {
            return MathUtils.clamp(i, c.this.vl(), c.this.agU ? c.this.ahb : c.this.agS);
        }

        @Override // com.kwad.components.core.page.widget.a.i.a
        public final int E(View view) {
            return view.getLeft();
        }

        @Override // com.kwad.components.core.page.widget.a.i.a
        public final int vm() {
            if (c.this.agU) {
                return c.this.ahb;
            }
            return c.this.agS;
        }
    };

    public interface a {
        void bA(int i);

        void i(float f);
    }

    private void bF(int i) {
        if (i == 3) {
            this.ahm = true;
        } else if (i == 4 || i == 5 || i == 6) {
            this.ahm = false;
        }
    }

    public final void a(a aVar) {
        this.ahe = aVar;
    }

    public final void aW(boolean z) {
        this.agU = true;
    }

    public final void k(float f) {
        this.ahl = 0.8f;
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
    public final boolean onStartNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.agZ = 0;
        this.aha = false;
        return (i & 2) != 0;
    }

    public final int vl() {
        if (this.agK) {
            return this.agQ;
        }
        return 0;
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
    public final Parcelable onSaveInstanceState(KSCoordinatorLayout kSCoordinatorLayout, V v) {
        return new b(super.onSaveInstanceState(kSCoordinatorLayout, v), this.mState);
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
    public final void onRestoreInstanceState(KSCoordinatorLayout kSCoordinatorLayout, V v, Parcelable parcelable) {
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(kSCoordinatorLayout, v, bVar.getSuperState());
        if (bVar.mState == 1 || bVar.mState == 2) {
            this.mState = 4;
        } else {
            this.mState = bVar.mState;
        }
        bF(this.mState);
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
    public final boolean onLayoutChild(KSCoordinatorLayout kSCoordinatorLayout, V v, int i) {
        if (ViewCompat.getFitsSystemWindows(kSCoordinatorLayout) && !ViewCompat.getFitsSystemWindows(v)) {
            v.setFitsSystemWindows(true);
        }
        int top = v.getTop();
        kSCoordinatorLayout.onLayoutChild(v, i);
        int height = kSCoordinatorLayout.getHeight();
        this.ahb = height;
        if (this.agN) {
            if (this.agO == 0) {
                this.agO = 64;
            }
            this.agP = Math.max(this.agO, height - ((kSCoordinatorLayout.getWidth() * 9) / 16));
        } else {
            this.agP = this.agM;
        }
        this.agQ = Math.max(0, this.ahb - v.getHeight());
        this.agR = this.ahb / 2;
        vk();
        v.getTop();
        int i2 = this.mState;
        if (i2 == 3) {
            ViewCompat.offsetTopAndBottom(v, vl());
        } else if (i2 == 6) {
            ViewCompat.offsetTopAndBottom(v, this.agR);
        } else if (this.agU && i2 == 5) {
            ViewCompat.offsetTopAndBottom(v, this.ahb);
        } else if (i2 == 4) {
            ViewCompat.offsetTopAndBottom(v, this.agS);
        } else if (i2 == 1 || i2 == 2) {
            ViewCompat.offsetTopAndBottom(v, top - v.getTop());
        }
        if (this.agW == null) {
            this.agW = i.a(kSCoordinatorLayout, this.aho);
        }
        this.ahc = new WeakReference<>(v);
        this.ahd = new WeakReference<>(D(v));
        return true;
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
        i iVar;
        if (!v.isShown()) {
            this.agX = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.ahf = (int) motionEvent.getY();
            WeakReference<View> weakReference = this.ahd;
            View view = weakReference != null ? weakReference.get() : null;
            if (view != null && kSCoordinatorLayout.isPointInChildBounds(view, x, this.ahf)) {
                this.mActivePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.ahg = true;
            }
            this.agX = (this.agY || this.mActivePointerId != -1 || kSCoordinatorLayout.isPointInChildBounds(v, x, this.ahf)) ? false : true;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.ahg = false;
            this.mActivePointerId = -1;
            if (this.agX) {
                this.agX = false;
                return false;
            }
        }
        if (!this.agX && (iVar = this.agW) != null && iVar.shouldInterceptTouchEvent(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.ahd;
        View view2 = weakReference2 != null ? weakReference2.get() : null;
        return (actionMasked != 2 || view2 == null || this.agX || this.mState == 1 || kSCoordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.agW == null || Math.abs(((float) this.ahf) - motionEvent.getY()) <= ((float) this.agW.getTouchSlop())) ? false : true;
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
    public final boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.mState == 1 && actionMasked == 0) {
            return true;
        }
        i iVar = this.agW;
        if (iVar != null) {
            iVar.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (actionMasked == 2 && !this.agX && this.agW != null && Math.abs(this.ahf - motionEvent.getY()) > this.agW.getTouchSlop()) {
            this.agW.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.agX;
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
    public final void onNestedPreScroll(KSCoordinatorLayout kSCoordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 != 1 && view == this.ahd.get()) {
            int top = v.getTop();
            int i4 = top - i2;
            if (i2 > 0) {
                if (i4 < vl()) {
                    int iVl = top - vl();
                    iArr[1] = iVl;
                    ViewCompat.offsetTopAndBottom(v, -iVl);
                    bE(3);
                } else {
                    iArr[1] = i2;
                    ViewCompat.offsetTopAndBottom(v, -i2);
                    bE(1);
                }
            } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                int i5 = this.agS;
                if (i4 <= i5 || this.agU) {
                    iArr[1] = i2;
                    ViewCompat.offsetTopAndBottom(v, -i2);
                    bE(1);
                } else {
                    int i6 = top - i5;
                    iArr[1] = i6;
                    ViewCompat.offsetTopAndBottom(v, -i6);
                    bE(4);
                }
            }
            bG(v.getTop());
            this.agZ = i2;
            this.aha = true;
        }
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
    public final void onStopNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, V v, View view, int i) {
        int iVl;
        int i2 = 3;
        if (v.getTop() == vl()) {
            bE(3);
            return;
        }
        if (this.ahe != null) {
            this.ahd.get();
        }
        if (view == this.ahd.get() && this.aha) {
            if (this.agZ > 0) {
                if (e(v, getYVelocity())) {
                    iVl = vl();
                } else {
                    iVl = this.agS;
                    i2 = 4;
                }
            } else if (this.agU && d(v, getYVelocity())) {
                iVl = this.ahb;
                i2 = 5;
            } else if (this.agZ == 0) {
                int top = v.getTop();
                if (!this.agK) {
                    int i3 = this.agR;
                    if (top < i3) {
                        if (top < Math.abs(top - this.agS)) {
                            iVl = 0;
                        } else {
                            iVl = this.agR;
                        }
                    } else if (Math.abs(top - i3) < Math.abs(top - this.agS)) {
                        iVl = this.agR;
                    } else {
                        iVl = this.agS;
                        i2 = 4;
                    }
                    i2 = 6;
                } else if (e(v, getYVelocity())) {
                    iVl = this.agQ;
                } else {
                    iVl = this.agS;
                    i2 = 4;
                }
            } else if (e(v, getYVelocity())) {
                iVl = vl();
            } else {
                iVl = this.agS;
                i2 = 4;
            }
            if (this.agW.smoothSlideViewTo(v, v.getLeft(), iVl)) {
                bE(2);
                ViewCompat.postOnAnimation(v, new RunnableC0686c(v, i2));
            } else {
                bE(i2);
            }
            this.aha = false;
        }
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
    public final boolean onNestedPreFling(KSCoordinatorLayout kSCoordinatorLayout, V v, View view, float f, float f2) {
        if (view == this.ahd.get()) {
            return this.mState != 3 || super.onNestedPreFling(kSCoordinatorLayout, v, view, f, f2);
        }
        return false;
    }

    public final void bD(int i) {
        WeakReference<V> weakReference;
        V v;
        if (i == -1) {
            if (this.agN) {
                return;
            } else {
                this.agN = true;
            }
        } else {
            if (!this.agN && this.agM == i) {
                return;
            }
            this.agN = false;
            this.agM = Math.max(0, i);
            this.agS = this.ahb - i;
        }
        if (this.mState != 4 || (weakReference = this.ahc) == null || (v = weakReference.get()) == null) {
            return;
        }
        v.requestLayout();
    }

    public final void setState(final int i) {
        if (i == this.mState) {
            return;
        }
        WeakReference<V> weakReference = this.ahc;
        if (weakReference == null) {
            if (i == 4 || i == 3 || i == 6 || (this.agU && i == 5)) {
                this.mState = i;
                bF(i);
                return;
            }
            return;
        }
        final V v = weakReference.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v)) {
            v.post(new Runnable() { // from class: com.kwad.components.core.page.widget.a.c.1
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.l(v, i);
                }
            });
        } else {
            l(v, i);
        }
    }

    final void bE(int i) {
        a aVar;
        if (this.mState == i) {
            return;
        }
        this.mState = i;
        bF(i);
        if (i == 6 || i == 3) {
            aX(true);
        } else if (i == 5 || i == 4) {
            aX(false);
        }
        if (this.ahc.get() == null || (aVar = this.ahe) == null) {
            return;
        }
        aVar.bA(i);
    }

    private void vk() {
        if (this.agK) {
            this.agS = Math.max(this.ahb - this.agP, this.agQ);
        } else {
            this.agS = this.ahb - this.agP;
        }
    }

    private void reset() {
        this.mActivePointerId = -1;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    protected final boolean d(View view, float f) {
        if (this.agV) {
            return true;
        }
        return view.getTop() >= this.agS && Math.abs((((float) view.getTop()) + (f * 0.1f)) - ((float) this.agS)) / ((float) this.agM) > this.ahl;
    }

    protected final boolean e(View view, float f) {
        if (view.getTop() > this.agS) {
            return false;
        }
        int iVl = vl();
        float f2 = iVl;
        float fMax = Math.max(f2, view.getTop() + (f * (this.ahm ? this.ahj : this.ahi)));
        if (fMax == f2) {
            return true;
        }
        int i = this.agS;
        int i2 = i - iVl;
        if (!this.ahm) {
            f2 = i;
        }
        float fAbs = Math.abs(fMax - f2) / i2;
        if (this.ahm) {
            return fAbs <= this.ahl;
        }
        return fAbs >= this.ahk;
    }

    private View D(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            if (view.getVisibility() == 0) {
                return view;
            }
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View viewD = D(viewGroup.getChildAt(i));
                if (viewD != null) {
                    return viewD;
                }
            }
        }
        return null;
    }

    private float getYVelocity() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.agL);
        return this.mVelocityTracker.getYVelocity(this.mActivePointerId);
    }

    final void l(View view, int i) {
        int iVl;
        int i2;
        if (i == 4) {
            iVl = this.agS;
        } else if (i == 6) {
            iVl = this.agR;
            if (this.agK && iVl <= (i2 = this.agQ)) {
                i = 3;
                iVl = i2;
            }
        } else if (i == 3) {
            iVl = vl();
        } else {
            if (!this.agU || i != 5) {
                throw new IllegalArgumentException("Illegal mState argument: " + i);
            }
            iVl = this.ahb;
        }
        if (this.agW.smoothSlideViewTo(view, view.getLeft(), iVl)) {
            bE(2);
            ViewCompat.postOnAnimation(view, new RunnableC0686c(view, i));
        } else {
            bE(i);
        }
    }

    final void bG(int i) {
        if (this.ahc.get() == null || this.ahe == null) {
            return;
        }
        int i2 = this.agS;
        int iVl = i > i2 ? this.ahb - i2 : i2 - vl();
        if (iVl != 0) {
            this.agT = (this.agS - i) / iVl;
        }
        this.ahe.i(this.agT);
    }

    /* JADX INFO: renamed from: com.kwad.components.core.page.widget.a.c$c, reason: collision with other inner class name */
    class RunnableC0686c implements Runnable {
        private final int ahs;
        private final View mView;

        RunnableC0686c(View view, int i) {
            this.mView = view;
            this.ahs = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (c.this.agW != null && c.this.agW.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.mView, this);
                return;
            }
            c.this.bE(this.ahs);
            if (c.this.ahn == this) {
                c.this.ahn = null;
            }
        }
    }

    protected static class b extends AbsSavedState {
        public static final Parcelable.Creator<b> CREATOR = new Parcelable.ClassLoaderCreator<b>() { // from class: com.kwad.components.core.page.widget.a.c.b.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return a(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final /* synthetic */ b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return a(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object[] newArray(int i) {
                return bJ(i);
            }

            private static b a(Parcel parcel, ClassLoader classLoader) {
                return new b(parcel, classLoader);
            }

            private static b a(Parcel parcel) {
                return new b(parcel, (ClassLoader) null);
            }

            private static b[] bJ(int i) {
                return new b[i];
            }
        };
        final int mState;

        public b(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.mState = parcel.readInt();
        }

        public b(Parcelable parcelable, int i) {
            super(parcelable);
            this.mState = i;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mState);
        }
    }

    private void aX(boolean z) {
        WeakReference<V> weakReference = this.ahc;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof KSCoordinatorLayout) {
            KSCoordinatorLayout kSCoordinatorLayout = (KSCoordinatorLayout) parent;
            int childCount = kSCoordinatorLayout.getChildCount();
            if (z) {
                if (this.ahh != null) {
                    return;
                } else {
                    this.ahh = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = kSCoordinatorLayout.getChildAt(i);
                if (childAt != this.ahc.get()) {
                    if (!z) {
                        Map<View, Integer> map = this.ahh;
                        if (map != null && map.containsKey(childAt)) {
                            ViewCompat.setImportantForAccessibility(childAt, this.ahh.get(childAt).intValue());
                        }
                    } else {
                        this.ahh.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        ViewCompat.setImportantForAccessibility(childAt, 4);
                    }
                }
            }
            if (z) {
                return;
            }
            this.ahh = null;
        }
    }
}
