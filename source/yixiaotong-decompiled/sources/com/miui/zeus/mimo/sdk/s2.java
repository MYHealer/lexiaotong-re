package com.miui.zeus.mimo.sdk;

import android.animation.ValueAnimator;
import android.graphics.Point;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import com.miui.zeus.mimo.sdk.view.card.CardLayoutManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class s2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f5592a;
    public final /* synthetic */ v2 b;

    public s2(v2 v2Var, RecyclerView recyclerView) {
        this.b = v2Var;
        this.f5592a = recyclerView;
    }

    @Override // java.lang.Runnable
    public void run() {
        Point point;
        ValueAnimator valueAnimatorOfInt;
        v2 v2Var = this.b;
        RecyclerView recyclerView = this.f5592a;
        if (v2Var.x == null) {
            return;
        }
        int i = recyclerView.getLayoutManager() instanceof CardLayoutManager ? ((CardLayoutManager) recyclerView.getLayoutManager()).c.c : 0;
        int width = v2Var.x.getWidth();
        int height = v2Var.x.getHeight();
        if (i == 0) {
            point = new Point(width / 2, height / 2);
            valueAnimatorOfInt = ValueAnimator.ofInt(point.y, -height);
        } else {
            point = new Point(width / 2, height / 2);
            valueAnimatorOfInt = ValueAnimator.ofInt(point.x, -width);
        }
        v2Var.w = valueAnimatorOfInt;
        MotionEvent motionEventObtain = MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, point.x, point.y, 0);
        recyclerView.dispatchTouchEvent(motionEventObtain);
        v2Var.w.addUpdateListener(new t2(v2Var, i, motionEventObtain, point, recyclerView));
        v2Var.w.addListener(new u2(v2Var, motionEventObtain, recyclerView));
        v2Var.w.setDuration(1500L);
        v2Var.w.setInterpolator(new AccelerateInterpolator());
        v2Var.w.start();
    }
}
