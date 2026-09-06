package com.adprof.sdk;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class tc implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MotionEvent f1438a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ vc f742a;

    public tc(vc vcVar) {
        this.f742a = vcVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (((x0) this.f742a).f821a == null) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.f1438a = MotionEvent.obtain(motionEvent);
        } else if (motionEvent.getAction() == 1) {
            if (this.f1438a == null) {
                this.f1438a = motionEvent;
            }
            try {
                ((x0) this.f742a).f821a.m591a().a(this.f1438a, motionEvent);
            } catch (Throwable th) {
                pk.b("InterstitialBase privacy click macro set ", th);
            }
            vc vcVar = this.f742a;
            vcVar.getClass();
            try {
                vcVar.f769a.m695a();
            } catch (Throwable th2) {
                pk.b("InterstitialBase showDialog error: ", th2);
            }
        }
        return true;
    }
}
