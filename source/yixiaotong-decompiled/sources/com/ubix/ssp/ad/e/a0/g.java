package com.ubix.ssp.ad.e.a0;

import android.os.CountDownTimer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CountDownTimer f8700a;
    private final long b;
    private long c;
    private b d;
    private volatile boolean e = true;

    class a extends CountDownTimer {
        a(long j, long j2) {
            super(j, j2);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            g.this.e = true;
            u.e("onFinish-time-remain " + g.this.c);
            if (g.this.c < 150) {
                try {
                    if (g.this.d != null) {
                        g.this.d.a();
                    }
                    if (g.this.f8700a != null) {
                        g.this.f8700a.cancel();
                    }
                } catch (Throwable unused) {
                }
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            g.this.e = false;
            g.this.c = j;
            if (g.this.d != null) {
                g.this.d.a(j);
            }
        }
    }

    public interface b {
        void a();

        void a(long j);

        void b();
    }

    public g(long j) {
        this.b = j;
        this.c = j;
    }

    private void a(long j) {
        if (this.e && this.f8700a == null) {
            a aVar = new a(j, 50L);
            this.f8700a = aVar;
            aVar.start();
        }
    }

    public void a() {
        CountDownTimer countDownTimer = this.f8700a;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f8700a.onFinish();
            this.f8700a = null;
        }
        b bVar = this.d;
        if (bVar != null) {
            bVar.b();
        }
    }

    public void a(b bVar) {
        this.d = bVar;
    }

    public boolean b() {
        return this.e;
    }

    public void c() {
        if (this.f8700a != null) {
            u.e("onTick=pause inner 1");
            this.f8700a.cancel();
            this.f8700a.onFinish();
            this.f8700a = null;
        }
    }

    public void d() {
        a(this.c);
    }

    public void e() {
        a(this.b);
    }
}
