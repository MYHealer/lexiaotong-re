package com.opos.cmn.module.ui.a;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f6188a;

    public b(int[] iArr) {
        this.f6188a = iArr;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr = this.f6188a;
        if (iArr != null && iArr.length >= 4) {
            if (motionEvent.getAction() == 0) {
                this.f6188a[0] = (int) motionEvent.getX();
                this.f6188a[1] = (int) motionEvent.getY();
            } else if (1 == motionEvent.getAction()) {
                this.f6188a[2] = (int) motionEvent.getX();
                this.f6188a[3] = (int) motionEvent.getY();
            }
        }
        return false;
    }
}
