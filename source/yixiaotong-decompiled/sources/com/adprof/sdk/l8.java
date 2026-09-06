package com.adprof.sdk;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class l8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1281a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CountDownTimer f438a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k8 f439a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f440a = false;
    public long b = 0;

    public l8(long j, long j2) {
        this.f1281a = j;
    }

    public void a() {
        try {
            CountDownTimer countDownTimer = this.f438a;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f440a = false;
            this.b = 0L;
        } catch (Exception e) {
            pk.a(e);
        }
    }

    public void b() {
        try {
            CountDownTimer countDownTimer = this.f438a;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                this.f438a = null;
            }
            this.f440a = false;
            this.b = 0L;
        } catch (Exception e) {
            pk.a(e);
        }
    }

    public void c() {
        this.f438a = new i8(this, this.f1281a, 500L);
    }

    public void d() {
        try {
            CountDownTimer countDownTimer = this.f438a;
            if (countDownTimer == null || this.f440a) {
                return;
            }
            this.f440a = true;
            this.b = this.f1281a;
            countDownTimer.cancel();
        } catch (Exception e) {
            pk.a(e);
        }
    }

    public void e() {
        if (this.f440a) {
            long j = this.b;
            if (j > 0) {
                this.f440a = false;
                this.f1281a = j;
                j8 j8Var = new j8(this, this.f1281a, 500L);
                this.f438a = j8Var;
                j8Var.start();
            }
        }
    }

    public void f() {
        CountDownTimer countDownTimer = this.f438a;
        if (countDownTimer != null) {
            this.f440a = false;
            countDownTimer.start();
        }
    }
}
