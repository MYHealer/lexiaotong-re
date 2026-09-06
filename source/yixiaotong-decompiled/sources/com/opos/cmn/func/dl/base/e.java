package com.opos.cmn.func.dl.base;

import android.content.Context;
import com.opos.cmn.func.dl.base.a.c;
import com.stub.StubApp;
import com.unionpay.tsmservice.data.Constant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f6129a = false;
    private int b;
    private int c;
    private boolean d;
    private float e;
    private int f;
    private int g;
    private Context h;
    private com.opos.cmn.func.dl.base.b.d i;
    private com.opos.cmn.func.dl.base.g.b j;
    private com.opos.cmn.func.dl.base.f.a k;
    private com.opos.cmn.func.dl.base.c.d.a l;

    public e(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context should not be null");
        }
        this.h = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    private void b(DownloadConfig downloadConfig) {
        try {
            synchronized (this) {
                if (this.f6129a) {
                    return;
                }
                com.opos.cmn.an.f.a.a("InnerManager", "---init!");
                if (downloadConfig == null) {
                    downloadConfig = new DownloadConfig();
                }
                this.b = downloadConfig.a();
                this.c = downloadConfig.b();
                this.d = downloadConfig.c();
                this.e = downloadConfig.d();
                this.f = downloadConfig.e();
                this.g = downloadConfig.f();
                if (this.l == null) {
                    this.l = new com.opos.cmn.func.dl.base.c.c.a();
                }
                com.opos.cmn.func.dl.base.b.a aVar = new com.opos.cmn.func.dl.base.b.a();
                aVar.f6113a = this.c;
                this.i = new com.opos.cmn.func.dl.base.b.c(aVar);
                com.opos.cmn.func.dl.base.g.b bVarG = g();
                boolean z = this.d;
                com.opos.cmn.func.dl.base.b.d dVar = this.i;
                bVarG.f6142a = z ? dVar.a() : dVar.d();
                this.k = new com.opos.cmn.func.dl.base.f.a(this);
                this.f6129a = true;
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("InnerManager", "tryInit", th);
        }
    }

    public int a() {
        return this.b;
    }

    @Override // com.opos.cmn.func.dl.base.d
    public void a(DownloadConfig downloadConfig) {
        b(downloadConfig);
    }

    @Override // com.opos.cmn.func.dl.base.d
    public void a(DownloadRequest downloadRequest) {
        try {
            com.opos.cmn.an.f.a.a("InnerManager", "---start!");
            if (this.f6129a) {
                this.k.a(downloadRequest, false);
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("InnerManager", "start", th);
        }
    }

    @Override // com.opos.cmn.func.dl.base.d
    public void a(c cVar) {
        try {
            g().b.add(cVar);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("InnerManager", "registerObserver", th);
        }
    }

    public float b() {
        return this.e;
    }

    @Override // com.opos.cmn.func.dl.base.d
    public void b(DownloadRequest downloadRequest) {
        try {
            com.opos.cmn.an.f.a.a("InnerManager", "---forceContinue!");
            if (this.f6129a) {
                this.k.a(downloadRequest, true);
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("InnerManager", "forceContinue", th);
        }
    }

    @Override // com.opos.cmn.func.dl.base.d
    public void b(c cVar) {
        try {
            g().b.remove(cVar);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("InnerManager", "unregisterObserver", th);
        }
    }

    public int c() {
        return this.f;
    }

    @Override // com.opos.cmn.func.dl.base.d
    public void c(final DownloadRequest downloadRequest) {
        try {
            com.opos.cmn.an.f.a.a("InnerManager", "---pause!");
            if (this.f6129a) {
                final com.opos.cmn.func.dl.base.f.a aVar = this.k;
                if (downloadRequest == null) {
                    com.opos.cmn.an.f.a.d("RequestManager", "Request is null,do nothing");
                } else {
                    b.a().execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.f.a.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            c cVar = a.this.b.get(Integer.valueOf(downloadRequest.f));
                            if (cVar != null) {
                                cVar.a();
                            }
                        }
                    });
                }
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("InnerManager", "pause", th);
        }
    }

    public int d() {
        return this.g;
    }

    @Override // com.opos.cmn.func.dl.base.d
    public void d(final DownloadRequest downloadRequest) {
        try {
            com.opos.cmn.an.f.a.a("InnerManager", "---cancel!");
            if (this.f6129a) {
                final com.opos.cmn.func.dl.base.f.a aVar = this.k;
                if (downloadRequest == null) {
                    com.opos.cmn.an.f.a.d("RequestManager", "Request is null,do nothing");
                } else {
                    b.a().execute(new Runnable() { // from class: com.opos.cmn.func.dl.base.f.a.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            c cVar = a.this.b.get(Integer.valueOf(downloadRequest.f));
                            if (cVar != null) {
                                cVar.b();
                            }
                        }
                    });
                }
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("InnerManager", Constant.CASH_LOAD_CANCEL, th);
        }
    }

    public Context e() {
        return this.h;
    }

    public com.opos.cmn.func.dl.base.b.d f() {
        return this.i;
    }

    public synchronized com.opos.cmn.func.dl.base.g.b g() {
        if (this.j == null) {
            this.j = new com.opos.cmn.func.dl.base.g.b();
        }
        return this.j;
    }

    public com.opos.cmn.func.dl.base.c.d.a h() {
        return this.l;
    }

    public String toString() {
        return "InnerManager{isInited=" + this.f6129a + ", writeThreadCount=" + this.b + ", maxDownloadNum=" + this.c + ", listenOnUi=" + this.d + ", notifyRatio=" + this.e + ", notifyInterval=" + this.f + ", notifyIntervalSize=" + this.g + '}';
    }
}
