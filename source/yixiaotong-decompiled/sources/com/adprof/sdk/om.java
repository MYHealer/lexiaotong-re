package com.adprof.sdk;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class om implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MotionEvent f1350a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ qm f540a;

    public om(qm qmVar) {
        this.f540a = qmVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (((x0) this.f540a).f821a == null) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.f1350a = MotionEvent.obtain(motionEvent);
        } else if (motionEvent.getAction() == 1) {
            if (this.f1350a == null) {
                this.f1350a = motionEvent;
            }
            try {
                ((x0) this.f540a).f821a.m591a().a(this.f1350a, motionEvent);
            } catch (Throwable th) {
                pk.b("splash privacy click macro set ", th);
            }
            try {
                this.f540a.f685a.m695a();
            } catch (Throwable th2) {
                pk.a(th2);
                oh.b(th2);
            }
        }
        return true;
    }
}
