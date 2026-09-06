package com.byazt.ij;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, 1432, 71})
public class x implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f2337a;
    public final com.byazt.nk.x c;
    public float n;
    public float sp;
    public final boolean tt;
    public float uj;
    public final int ve = 10;

    public x(com.byazt.nk.x xVar, boolean z) {
        this.c = xVar;
        this.tt = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.byazt.nk.x xVar;
        com.byazt.nk.x xVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.uj = motionEvent.getX();
            this.n = motionEvent.getY();
            new Object[]{"mStartX: ", Float.valueOf(this.uj), ", mStartY: " + this.n};
        } else if (action == 1) {
            this.f2337a = motionEvent.getX();
            this.sp = motionEvent.getY();
            new Object[]{"mEndX: ", Float.valueOf(this.f2337a), ", mEndY: " + this.sp};
            if (!this.tt && (xVar2 = this.c) != null) {
                xVar2.c();
            } else {
                float f = this.f2337a - this.uj;
                float f2 = this.sp - this.n;
                float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
                new Object[]{"slideDistancePx: ", Float.valueOf(fSqrt)};
                float fTt = com.byazt.or.x.tt(com.byazt.sr.uj.getContext(), Math.abs(fSqrt));
                new Object[]{"slideDistanceDp:", Float.valueOf(fTt), " and ", "mSlideThreshold:", 10};
                if (fTt > 10.0f && (xVar = this.c) != null) {
                    xVar.c();
                }
            }
        }
        return true;
    }
}
