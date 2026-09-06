package com.opos.mobad.q;

import android.os.Handler;
import android.os.Looper;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class f<T> extends com.opos.mobad.ad.i.a implements com.opos.mobad.ad.b {
    private com.opos.mobad.ad.d.a<T> b;
    private o c = l.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Handler f7284a = new Handler(Looper.getMainLooper());
    private p d = new p(this.f7284a, new Runnable() { // from class: com.opos.mobad.q.f.1
        @Override // java.lang.Runnable
        public void run() {
            f.this.g();
        }
    });

    public f(com.opos.mobad.ad.d.a<T> aVar) {
        this.b = aVar;
    }

    private final void a(Callable<Boolean> callable) {
        int iA = this.c.a(1, callable);
        com.opos.cmn.an.f.a.b("", "loadAd state=" + iA + ",Ad =" + this);
        if (1 == iA) {
            return;
        }
        if (5 == iA) {
            b(11001, "ad has destroyed.");
        } else {
            b(-1, "load with illegal state:" + iA);
        }
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

    @Override // com.opos.mobad.ad.b
    public void a(String str) {
        a(KSImageLoader.InnerImageLoadingListener.MAX_DURATION, str);
    }

    @Override // com.opos.mobad.ad.b
    public void a(final String str, final int i) {
        com.opos.cmn.an.f.a.b("", "loadAd :" + str + ", " + i);
        a(new Callable<Boolean>() { // from class: com.opos.mobad.q.f.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(f.this.b(str, i));
            }
        });
    }

    @Override // com.opos.mobad.ad.k
    public void a(final String str, final int i, final List<String> list) {
        com.opos.cmn.an.f.a.b("", "loadAd :" + str + ", " + i + "," + list);
        a(new Callable<Boolean>() { // from class: com.opos.mobad.q.f.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(f.this.b(str, i, list));
            }
        });
    }

    @Override // com.opos.mobad.ad.k
    public void a(final String str, final int i, final List<String> list, final String str2) {
        com.opos.cmn.an.f.a.b("", "loadAd :" + str + ", " + i);
        a(new Callable<Boolean>() { // from class: com.opos.mobad.q.f.5
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(f.this.b(str, i, list, str2));
            }
        });
    }

    public void a(List<String> list) {
    }

    protected boolean a(String str, List<String> list) {
        return false;
    }

    protected boolean a(String str, List<String> list, String str2) {
        return false;
    }

    public void b() {
        this.d.b();
        this.c.a(5);
    }

    protected void b(int i, String str) {
        com.opos.mobad.ad.d.a<T> aVar = this.b;
        if (aVar != null) {
            aVar.a(i, str);
        }
    }

    @Override // com.opos.mobad.ad.b
    public void b(String str) {
        com.opos.cmn.an.f.a.b("", "loadAd:" + str);
        a(str, KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
    }

    protected final void b(List<T> list) {
        com.opos.mobad.ad.d.a<T> aVar;
        this.d.a();
        if (2 != this.c.a(2) || (aVar = this.b) == null) {
            return;
        }
        aVar.a(list);
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
        return this.c.a();
    }

    protected final void c(final int i, final String str) {
        this.d.a();
        this.f7284a.post(new Runnable() { // from class: com.opos.mobad.q.f.3
            @Override // java.lang.Runnable
            public void run() {
                int iA = f.this.c.a(1, 0);
                com.opos.cmn.an.f.a.b("SyncStateController", "state=" + iA + ",Ad = " + this);
                if (5 == iA) {
                    return;
                }
                f.this.b(i, str);
            }
        });
    }

    protected abstract boolean c(String str);

    public boolean d() {
        return false;
    }

    protected void g() {
        this.d.a();
        int iA = this.c.a(6);
        com.opos.cmn.an.f.a.b("SyncStateController", "onTimeout state=" + iA + ",Ad = " + this);
        if (6 == iA) {
            b(11009, "network timeout, please check network status and retry");
        }
    }
}
