package com.opos.mobad.template.cmn;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class p implements View.OnClickListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f7522a = {-999, -999, -999, -999};

    public static void a(View view, p pVar) {
        if (view != null) {
            view.setOnClickListener(pVar);
            view.setOnTouchListener(pVar);
        }
    }

    public abstract void b(View view, int[] iArr);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b(view, this.f7522a);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int[] iArr = this.f7522a;
        if (iArr != null && iArr.length >= 4) {
            if (motionEvent.getAction() == 0) {
                this.f7522a[0] = (int) motionEvent.getX();
                this.f7522a[1] = (int) motionEvent.getY();
            } else if (1 == motionEvent.getAction()) {
                this.f7522a[2] = (int) motionEvent.getX();
                this.f7522a[3] = (int) motionEvent.getY();
            }
        }
        return false;
    }
}
