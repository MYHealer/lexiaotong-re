package com.hihonor.adsdk.reward.e;

import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class w implements View.OnTouchListener {
    private static final String d = "RewardTouchListener";
    private static final int e = 20;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Point f3578a = new Point();
    protected Point b = new Point();
    protected float c;

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        com.hihonor.adsdk.common.b.b.hnadsc(d, "onTouch: " + action, new Object[0]);
        if (action == 0) {
            this.f3578a.set((int) motionEvent.getX(), (int) motionEvent.getY());
        } else if (action == 1) {
            if (Math.abs(motionEvent.getX() - this.f3578a.x) >= 20.0f || Math.abs(motionEvent.getY() - this.f3578a.y) >= 20.0f) {
                com.hihonor.adsdk.common.b.b.hnadsc(d, "onTouch: Slide Event", new Object[0]);
                return true;
            }
            this.b.set((int) motionEvent.getX(), (int) motionEvent.getY());
            this.c = motionEvent.getPressure();
        } else if (action != 2) {
            com.hihonor.adsdk.common.b.b.hnadsa(d, (Object) "onTouch,other event");
        }
        return false;
    }
}
