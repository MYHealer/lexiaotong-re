package com.miui.zeus.mimo.sdk.view.card;

import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.miui.zeus.mimo.sdk.v7;
import com.miui.zeus.mimo.sdk.x7;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CardLayoutManager extends RecyclerView.LayoutManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f5685a;
    public ItemTouchHelper b;
    public v7 c;
    public final View.OnTouchListener d = new a();

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            RecyclerView.ViewHolder childViewHolder = CardLayoutManager.this.f5685a.getChildViewHolder(view);
            if (motionEvent.getActionMasked() == 0) {
                int toolType = motionEvent.getToolType(0);
                if (toolType > 0) {
                    x7.a.f5742a.f5741a = true;
                }
                x7.a.f5742a.b = toolType;
                CardLayoutManager.this.b.startSwipe(childViewHolder);
            }
            return false;
        }
    }

    public CardLayoutManager(RecyclerView recyclerView, ItemTouchHelper itemTouchHelper, v7 v7Var) {
        this.f5685a = recyclerView;
        this.b = itemTouchHelper;
        this.c = v7Var;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:33:0x0172  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int width;
        int height;
        int decoratedMeasuredHeight;
        int i;
        int i2;
        detachAndScrapAttachedViews(recycler);
        int itemCount = getItemCount();
        v7 v7Var = this.c;
        int i3 = v7Var.c;
        int i4 = v7Var.f5645a;
        if (itemCount <= i4) {
            for (int i5 = itemCount - 1; i5 >= 0; i5--) {
                View viewForPosition = recycler.getViewForPosition(i5);
                addView(viewForPosition);
                measureChildWithMargins(viewForPosition, 0, 0);
                int width2 = (getWidth() - getDecoratedMeasuredWidth(viewForPosition)) / 2;
                int height2 = (getHeight() - getDecoratedMeasuredHeight(viewForPosition)) / 2;
                layoutDecoratedWithMargins(viewForPosition, width2, height2, width2 + getDecoratedMeasuredWidth(viewForPosition), height2 + getDecoratedMeasuredHeight(viewForPosition));
                if (i3 == 1) {
                    if (i5 > 0) {
                        float f = i5;
                        this.c.getClass();
                        float f2 = 1.0f - (f * 0.13f);
                        viewForPosition.setScaleX(f2);
                        this.c.getClass();
                        viewForPosition.setScaleY(f2);
                        float measuredWidth = f * 1.0f * viewForPosition.getMeasuredWidth();
                        this.c.getClass();
                        viewForPosition.setTranslationX(measuredWidth / 7);
                    } else {
                        viewForPosition.setOnTouchListener(this.d);
                    }
                } else if (i5 > 0) {
                    float f3 = i5;
                    this.c.getClass();
                    float f4 = 1.0f - (f3 * 0.13f);
                    viewForPosition.setScaleX(f4);
                    this.c.getClass();
                    viewForPosition.setScaleY(f4);
                    float measuredHeight = f3 * 1.0f * viewForPosition.getMeasuredHeight();
                    this.c.getClass();
                    viewForPosition.setTranslationY(measuredHeight / 7);
                } else {
                    viewForPosition.setOnTouchListener(this.d);
                }
            }
            return;
        }
        while (i4 >= 0) {
            View viewForPosition2 = recycler.getViewForPosition(i4);
            addView(viewForPosition2);
            measureChildWithMargins(viewForPosition2, 0, 0);
            if (i3 == 1) {
                width = (getWidth() - getDecoratedMeasuredWidth(viewForPosition2)) - this.c.b;
                height = getHeight();
                decoratedMeasuredHeight = getDecoratedMeasuredHeight(viewForPosition2);
            } else {
                width = getWidth() - getDecoratedMeasuredWidth(viewForPosition2);
                height = getHeight() - getDecoratedMeasuredHeight(viewForPosition2);
                decoratedMeasuredHeight = this.c.d;
            }
            int i6 = height - decoratedMeasuredHeight;
            if (i3 == 1) {
                int i7 = width / 2;
                int i8 = i6 / 2;
                layoutDecoratedWithMargins(viewForPosition2, i7, i8, i7 + getDecoratedMeasuredWidth(viewForPosition2), i8 + getDecoratedMeasuredHeight(viewForPosition2));
                v7 v7Var2 = this.c;
                if (i4 == v7Var2.f5645a) {
                    i2 = i4 - 1;
                } else if (i4 > 0) {
                    i2 = i4;
                } else {
                    viewForPosition2.setOnTouchListener(this.d);
                }
                float f5 = i2;
                v7Var2.getClass();
                float f6 = 1.0f - (f5 * 0.13f);
                viewForPosition2.setScaleX(f6);
                this.c.getClass();
                viewForPosition2.setScaleY(f6);
                float measuredHeight2 = f5 * 1.0f * viewForPosition2.getMeasuredHeight();
                this.c.getClass();
                viewForPosition2.setTranslationX(measuredHeight2 / 7);
            } else {
                int i9 = width / 2;
                int i10 = i6 / 2;
                layoutDecoratedWithMargins(viewForPosition2, i9, i10, i9 + getDecoratedMeasuredWidth(viewForPosition2), i10 + getDecoratedMeasuredHeight(viewForPosition2));
                v7 v7Var3 = this.c;
                if (i4 == v7Var3.f5645a) {
                    i = i4 - 1;
                } else if (i4 > 0) {
                    i = i4;
                } else {
                    viewForPosition2.setOnTouchListener(this.d);
                }
                float f7 = i;
                v7Var3.getClass();
                float f8 = 1.0f - (f7 * 0.13f);
                viewForPosition2.setScaleX(f8);
                this.c.getClass();
                viewForPosition2.setScaleY(f8);
                float measuredHeight3 = f7 * 1.0f * viewForPosition2.getMeasuredHeight();
                this.c.getClass();
                viewForPosition2.setTranslationY(measuredHeight3 / 7);
            }
            i4--;
        }
    }
}
