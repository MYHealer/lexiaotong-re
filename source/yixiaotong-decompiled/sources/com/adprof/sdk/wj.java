package com.adprof.sdk;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class wj implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MotionEvent f1504a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ yj f807a;

    public wj(yj yjVar) {
        this.f807a = yjVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (((x0) this.f807a).f821a == null) {
            return false;
        }
        if (motionEvent.getAction() == 0) {
            this.f1504a = MotionEvent.obtain(motionEvent);
        } else if (motionEvent.getAction() == 1) {
            if (this.f1504a == null) {
                this.f1504a = motionEvent;
            }
            try {
                ((x0) this.f807a).f821a.m591a().a(this.f1504a, motionEvent);
            } catch (Throwable th) {
                pk.b("rewardBase privacy click macro set ", th);
            }
            yj yjVar = this.f807a;
            yjVar.getClass();
            try {
                yjVar.f863a.m695a();
            } catch (Throwable th2) {
                pk.b("RewardBase showDialog error: ", th2);
            }
        }
        return true;
    }
}
