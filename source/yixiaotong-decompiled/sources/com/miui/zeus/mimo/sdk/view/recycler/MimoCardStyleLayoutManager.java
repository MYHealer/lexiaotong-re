package com.miui.zeus.mimo.sdk.view.recycler;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoCardStyleLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f5716a;
    public int b;
    public boolean c;
    public int d;

    public class a extends LinearSmoothScroller {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
            return (i3 + ((i4 - i3) / 2)) - (i + ((i2 - i) / 2));
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            return super.calculateSpeedPerPixel(displayMetrics);
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int calculateTimeForScrolling(int i) {
            return MimoCardStyleLayoutManager.this.b;
        }
    }

    public MimoCardStyleLayoutManager(RecyclerView recyclerView, int i) {
        super(recyclerView.getContext(), i, false);
        this.b = 200;
        this.c = false;
        this.f5716a = recyclerView;
        this.d = i;
    }

    public final void a() {
        int decoratedBottom;
        int decoratedTop;
        float width = getWidth() / 2.0f;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = this.f5716a.getChildAt(i);
            if (childAt != null) {
                if (getOrientation() == 0) {
                    decoratedBottom = getDecoratedRight(childAt);
                    decoratedTop = getDecoratedLeft(childAt);
                } else {
                    decoratedBottom = getDecoratedBottom(childAt);
                    decoratedTop = getDecoratedTop(childAt);
                }
                float fAbs = Math.abs(width - ((decoratedBottom + decoratedTop) / 2.0f));
                float f = fAbs < width ? 1.0f - ((fAbs / width) * 0.14999998f) : 0.85f;
                childAt.setScaleX(f);
                childAt.setScaleY(f);
            }
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int decoratedBottom;
        int decoratedTop;
        super.onLayoutChildren(recycler, state);
        if (state.isPreLayout() || findFirstVisibleItemPosition() != 0 || this.c) {
            return;
        }
        this.c = true;
        int iMin = Math.min(3, getChildCount());
        float width = getWidth() / 2.0f;
        int i = 0;
        for (int i2 = 0; i2 < iMin; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                measureChildWithMargins(childAt, 0, 0);
                int decoratedMeasuredWidth = getDecoratedMeasuredWidth(childAt);
                int decoratedMeasuredHeight = getDecoratedMeasuredHeight(childAt);
                int width2 = (getWidth() - decoratedMeasuredWidth) / 2;
                int height = (getHeight() - decoratedMeasuredHeight) / 2;
                if (this.d == 0) {
                    layoutDecorated(childAt, i + width2, 0, i + decoratedMeasuredWidth + width2, decoratedMeasuredHeight);
                    decoratedBottom = getDecoratedRight(childAt);
                    decoratedTop = getDecoratedLeft(childAt);
                } else {
                    layoutDecorated(childAt, 0, i + height, decoratedMeasuredWidth, decoratedMeasuredHeight + i + height);
                    decoratedBottom = getDecoratedBottom(childAt);
                    decoratedTop = getDecoratedTop(childAt);
                }
                float fAbs = Math.abs(width - ((decoratedBottom + decoratedTop) / 2.0f));
                float f = fAbs < width ? 1.0f - ((fAbs / width) * 0.14999998f) : 0.85f;
                childAt.setScaleX(f);
                childAt.setScaleY(f);
                i += decoratedMeasuredWidth;
            }
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int iScrollHorizontallyBy = super.scrollHorizontallyBy(i, recycler, state);
        a();
        return iScrollHorizontallyBy;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        super.scrollToPosition(i);
        a();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int iScrollVerticallyBy = super.scrollVerticallyBy(i, recycler, state);
        a();
        return iScrollVerticallyBy;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        a aVar = new a(recyclerView.getContext());
        aVar.setTargetPosition(i);
        startSmoothScroll(aVar);
    }
}
