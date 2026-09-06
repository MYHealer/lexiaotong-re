package com.adprof.sdk;

import android.view.MotionEvent;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class t6 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1434a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ u6 f729a;
    public final /* synthetic */ int b;

    public t6(u6 u6Var, int i, int i2) {
        this.f729a = u6Var;
        this.f1434a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            int i = new Random().nextInt(2) == 0 ? 1 : -1;
            int i2 = new Random().nextInt(2) == 0 ? 1 : -1;
            int iNextInt = (i * new Random().nextInt(Math.max(1, 40))) + this.f1434a;
            int iNextInt2 = (i2 * new Random().nextInt(Math.max(1, 30))) + this.b;
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f729a.f753a.m591a().c(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 1, iNextInt, iNextInt2, 0));
            this.f729a.f754a.a();
        } catch (Throwable th) {
            pk.a(th);
        }
    }
}
