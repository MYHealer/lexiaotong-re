package com.adprof.sdk;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class t4 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g5 f1433a;

    public t4(g5 g5Var) {
        this.f1433a = g5Var;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            z4 z4Var = this.f1433a.f306a;
            if (z4Var != null) {
                return ((m4) z4Var).a(motionEvent);
            }
            return false;
        }
        if (motionEvent.getAction() != 0) {
            return false;
        }
        z4 z4Var2 = this.f1433a.f306a;
        if (z4Var2 != null) {
            m4 m4Var = (m4) z4Var2;
            d dVar = (d) m4Var.f1300a.get();
            if (dVar != null) {
                m4Var.a(dVar, motionEvent);
            }
        }
        return true;
    }
}
