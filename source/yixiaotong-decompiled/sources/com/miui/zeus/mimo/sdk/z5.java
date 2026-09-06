package com.miui.zeus.mimo.sdk;

import android.app.Application;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class z5 implements s5 {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Application f5759a;

        public a(z5 z5Var, Application application) {
            this.f5759a = application;
        }

        @Override // java.lang.Runnable
        public void run() {
            t4.a(this.f5759a);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.s5
    public void a(Application application) {
        x8.j.execute(new a(this, application));
    }
}
