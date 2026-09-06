package com.miui.zeus.mimo.sdk;

import java.util.TimerTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class r5 extends TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q5 f5583a;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q5.a(r5.this.f5583a);
        }
    }

    public r5(q5 q5Var) {
        this.f5583a = q5Var;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (this.f5583a.c()) {
            x8.e(new a());
        }
    }
}
