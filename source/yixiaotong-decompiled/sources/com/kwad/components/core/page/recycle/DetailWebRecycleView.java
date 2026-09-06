package com.kwad.components.core.page.recycle;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.kwad.components.core.t.y;
import com.kwad.sdk.utils.ab;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DetailWebRecycleView extends b {
    private int aeY;
    private boolean aeZ;
    private boolean afa;
    private int afb;
    private int afc;
    private boolean afd;
    a afe;
    private Runnable aff;
    private y afg;
    private int ph;

    public interface a {
        boolean uK();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void setInterceptRequestFocusForWeb(boolean z) {
        this.aeZ = z;
    }

    public void setInterceptRequestFocusForWebFiredOnce(boolean z) {
        this.afa = z;
    }

    public void setInterceptTouchListener(a aVar) {
        this.afe = aVar;
    }

    public void setTopViewHeight(int i) {
        this.afb = i;
    }

    public DetailWebRecycleView(Context context) {
        this(context, null);
    }

    public DetailWebRecycleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DetailWebRecycleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aeY = 1000;
        this.aeZ = false;
        this.afa = false;
        this.aff = new Runnable() { // from class: com.kwad.components.core.page.recycle.DetailWebRecycleView.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    Object field = ab.getField(DetailWebRecycleView.this, "mGapWorker");
                    if (field != null) {
                        ab.callMethod(field, "postFromTraversal", DetailWebRecycleView.this, 0, Integer.valueOf(DetailWebRecycleView.this.aeY));
                    }
                } catch (RuntimeException e) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                }
            }
        };
        this.afg = new y(this.aff);
        if (context instanceof Activity) {
            this.ph = com.kwad.sdk.c.a.a.k((Activity) context);
        } else {
            this.ph = com.kwad.sdk.c.a.a.getScreenHeight(context);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this.afg, 50L);
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.afg);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.afa) {
            this.afa = false;
        } else {
            if (this.aeZ) {
                return;
            }
            super.requestChildFocus(view, view2);
        }
    }

    @Override // com.kwad.components.core.page.recycle.b, androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar = this.afe;
        if (aVar != null && aVar.uK()) {
            return true;
        }
        this.afc = computeVerticalScrollOffset();
        if (motionEvent.getY() <= this.afb - this.afc) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        int iComputeVerticalScrollOffset = computeVerticalScrollOffset();
        this.afc = iComputeVerticalScrollOffset;
        if (i2 > 0 && iComputeVerticalScrollOffset < this.afb && !this.afd && iComputeVerticalScrollOffset < this.ph) {
            scrollBy(0, i2);
            iArr[1] = i2;
        }
        if (i2 >= 0 || this.afc <= 0 || ViewCompat.canScrollVertically(view, -1)) {
            return;
        }
        scrollBy(0, i2);
        iArr[1] = i2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        int iComputeVerticalScrollOffset = computeVerticalScrollOffset();
        this.afc = iComputeVerticalScrollOffset;
        if (iComputeVerticalScrollOffset >= this.afb) {
            return false;
        }
        fling((int) f, (int) f2);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        if (i == 0) {
            View childAt = getLayoutManager().getChildAt(getLayoutManager().getChildCount() - 1);
            if (childAt != null) {
                int bottom = childAt.getBottom();
                int bottom2 = getBottom() - getPaddingBottom();
                int position = getLayoutManager().getPosition(childAt);
                if (bottom == bottom2 && position == getLayoutManager().getItemCount() - 1) {
                    this.afd = true;
                    return;
                }
            }
            this.afd = false;
        }
    }
}
