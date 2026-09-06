package com.opos.mobad.q;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class j extends com.opos.mobad.ad.i.a implements com.opos.mobad.ad.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.b.a f7293a;
    private int b;
    private long c;
    private p d;
    protected Handler e;
    o f;

    public j(int i, com.opos.mobad.ad.b.a aVar) {
        n();
        this.e = new Handler(Looper.getMainLooper());
        this.d = new p(this.e, new Runnable() { // from class: com.opos.mobad.q.j.1
            @Override // java.lang.Runnable
            public void run() {
                j.this.f_();
            }
        });
        this.f7293a = aVar;
        this.b = i;
    }

    public j(com.opos.mobad.ad.b.a aVar) {
        this(-1, aVar);
    }

    public void a() {
        b(m.a());
    }

    @Override // com.opos.mobad.ad.b
    public void a(int i) {
        a(m.a(), i);
    }

    @Override // com.opos.mobad.ad.b
    public void a(int i, String str) {
        a(m.a(), i, null, str);
    }

    public void a(int i, List<String> list) {
    }

    protected final void a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.e.post(runnable);
        }
    }

    @Override // com.opos.mobad.ad.b
    public void a(String str) {
        a(KSImageLoader.InnerImageLoadingListener.MAX_DURATION, str);
    }

    public void a(final String str, final int i) {
        com.opos.cmn.an.f.a.b("", "loadAd :" + str + ", " + i);
        b(new Callable<Boolean>() { // from class: com.opos.mobad.q.j.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(j.this.b(str, i));
            }
        });
    }

    @Override // com.opos.mobad.ad.k
    public void a(final String str, final int i, final List<String> list) {
        com.opos.cmn.an.f.a.b("", "loadAd :" + str + ", " + i + "," + list);
        b(new Callable<Boolean>() { // from class: com.opos.mobad.q.j.7
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(j.this.b(str, i, list));
            }
        });
    }

    @Override // com.opos.mobad.ad.k
    public void a(final String str, final int i, final List<String> list, final String str2) {
        com.opos.cmn.an.f.a.b("", "loadAd :" + str + ", " + i + ", " + str2);
        Object[] objArr = new Object[2];
        objArr[0] = "bidIds:";
        objArr[1] = list != null ? list.toArray() : "";
        com.opos.cmn.an.f.a.b("", objArr);
        b(new Callable<Boolean>() { // from class: com.opos.mobad.q.j.8
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(j.this.b(str, i, list, str2));
            }
        });
    }

    public void a(List<String> list) {
    }

    protected void a(Callable<Boolean> callable) {
        this.d.a();
        int iA = this.f.a(6, callable);
        com.opos.cmn.an.f.a.b("SyncStateController", "onTimeout state=" + iA + ",Ad = " + this);
        if (6 == iA) {
            b(11009, "network timeout, please check network status and retry");
        }
    }

    protected boolean a(String str, List<String> list) {
        return false;
    }

    protected boolean a(String str, List<String> list, String str2) {
        return false;
    }

    public void b() {
        this.d.b();
        this.f.a(5);
    }

    protected void b(int i, String str) {
        com.opos.mobad.ad.b.a aVar = this.f7293a;
        if (aVar != null) {
            aVar.a(i, str);
        }
    }

    public void b(String str) {
        com.opos.cmn.an.f.a.b("", "loadAd:" + str);
        a(str, KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
    }

    final void b(Callable<Boolean> callable) {
        int iA = this.f.a(1, callable);
        com.opos.cmn.an.f.a.b("SyncStateController", "loadAd state=" + iA + ",Ad =" + this);
        if (1 == iA) {
            return;
        }
        if (5 == iA) {
            b(11001, "ad has destroyed.");
        } else {
            b(-1, "load with illegal state:" + iA);
        }
    }

    protected boolean b(String str, int i) {
        if (i > 0) {
            this.d.a(i);
        } else {
            this.d.a();
        }
        return c(str);
    }

    protected boolean b(String str, int i, List<String> list) {
        if (i > 0) {
            this.d.a(i);
        } else {
            this.d.a();
        }
        return a(str, list);
    }

    protected boolean b(String str, int i, List<String> list, String str2) {
        if (i > 0) {
            this.d.a(i);
        } else {
            this.d.a();
        }
        return a(str, list, str2);
    }

    @Override // com.opos.mobad.ad.b
    public int c() {
        return this.f.a();
    }

    protected final void c(final int i, final String str) {
        this.d.a();
        this.e.post(new Runnable() { // from class: com.opos.mobad.q.j.3
            @Override // java.lang.Runnable
            public void run() {
                if (6 == j.this.f.a()) {
                    com.opos.cmn.an.f.a.b("SyncStateController", "onAdFailed but timeout");
                    return;
                }
                int iA = j.this.f.a(1, 0);
                com.opos.cmn.an.f.a.b("SyncStateController", "onLoadFailed state=" + iA + ",Ad = " + this);
                if (5 == iA) {
                    return;
                }
                j.this.b(i, str);
            }
        });
    }

    protected final void c(Callable<Boolean> callable) {
        this.d.a();
        if (2 == this.f.a(2, callable)) {
            this.c = SystemClock.elapsedRealtime();
            a(new Runnable() { // from class: com.opos.mobad.q.j.6
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f7293a != null) {
                        j.this.f7293a.a();
                    }
                }
            });
        }
    }

    protected abstract boolean c(String str);

    protected final void d(final int i, final String str) {
        this.d.a();
        this.e.post(new Runnable() { // from class: com.opos.mobad.q.j.4
            @Override // java.lang.Runnable
            public void run() {
                int iA = j.this.f.a(0);
                com.opos.cmn.an.f.a.b("SyncStateController", "onAdFailed state=" + iA + ",Ad = " + this);
                if (5 == iA) {
                    return;
                }
                j.this.b(i, str);
            }
        });
    }

    public boolean d() {
        int i;
        return 2 == c() && ((i = this.b) <= 0 || this.c + ((long) i) >= SystemClock.elapsedRealtime());
    }

    protected void f_() {
        this.d.a();
        int iA = this.f.a(6);
        com.opos.cmn.an.f.a.b("SyncStateController", "onTimeout state=" + iA + ",Ad = " + this);
        if (6 == iA) {
            b(11009, "network timeout, please check network status and retry");
        }
    }

    protected void m() {
        com.opos.mobad.ad.b.a aVar = this.f7293a;
        if (aVar != null) {
            aVar.b();
        }
    }

    void n() {
        this.f = l.a();
    }

    protected final void o() {
        this.d.a();
        if (2 == this.f.a(2)) {
            this.c = SystemClock.elapsedRealtime();
            a(new Runnable() { // from class: com.opos.mobad.q.j.5
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f7293a != null) {
                        j.this.f7293a.a();
                    }
                }
            });
        }
    }
}
