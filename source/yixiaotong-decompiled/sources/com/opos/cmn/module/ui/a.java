package com.opos.cmn.module.ui;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class a implements View.OnClickListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f6186a = {-999, -999, -999, -999};

    public abstract void a(View view, int[] iArr);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a(view, this.f6186a);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr = this.f6186a;
        if (iArr != null && iArr.length >= 4) {
            if (motionEvent.getAction() == 0) {
                this.f6186a[0] = (int) motionEvent.getX();
                this.f6186a[1] = (int) motionEvent.getY();
            } else if (1 == motionEvent.getAction()) {
                this.f6186a[2] = (int) motionEvent.getX();
                this.f6186a[3] = (int) motionEvent.getY();
            } else if (2 == motionEvent.getAction()) {
                int[] iArr2 = this.f6186a;
                if (iArr2[0] == -999 && iArr2[1] == -999) {
                    iArr2[0] = (int) motionEvent.getX();
                    this.f6186a[1] = (int) motionEvent.getY();
                } else {
                    iArr2[2] = (int) motionEvent.getX();
                    this.f6186a[3] = (int) motionEvent.getY();
                }
            }
        }
        return false;
    }
}
