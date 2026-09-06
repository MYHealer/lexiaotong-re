package com.hihonor.adsdk.base.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class BaseItemDecoration extends RecyclerView.ItemDecoration {
    private final Paint hnadsa;
    private final int hnadsb;
    private int hnadsc;
    private float hnadsd;

    public BaseItemDecoration(int i) {
        this.hnadsc = 855638016;
        this.hnadsd = 1.0f;
        this.hnadsa = new Paint();
        this.hnadsb = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        rect.set(0, 0, 1, 1);
    }

    public void hnadsa(float f) {
        this.hnadsd = f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        super.onDrawOver(canvas, recyclerView, state);
        int childCount = recyclerView.getChildCount();
        int i = 0;
        while (true) {
            int i2 = 1;
            if (i >= childCount - 1) {
                return;
            }
            View childAt = recyclerView.getChildAt(i);
            childAt.getLocationOnScreen(new int[2]);
            int i3 = (int) this.hnadsd;
            if (i3 > 0) {
                i2 = i3;
            }
            int left = childAt.getLeft() + i2 + this.hnadsb;
            int bottom = childAt.getBottom();
            int right = (childAt.getRight() + i2) - this.hnadsb;
            int bottom2 = childAt.getBottom() + i2;
            this.hnadsa.setStyle(Paint.Style.STROKE);
            this.hnadsa.setStrokeWidth(this.hnadsd);
            this.hnadsa.setColor(this.hnadsc);
            canvas.drawRect(left, bottom, right, bottom2, this.hnadsa);
            i++;
        }
    }

    public BaseItemDecoration(int i, int i2) {
        this.hnadsd = 1.0f;
        this.hnadsb = i;
        this.hnadsc = i2;
        this.hnadsa = new Paint();
    }

    public BaseItemDecoration(int i, float f) {
        this.hnadsc = 855638016;
        this.hnadsd = 1.0f;
        this.hnadsa = new Paint();
        this.hnadsb = i;
        this.hnadsd = f;
    }
}
