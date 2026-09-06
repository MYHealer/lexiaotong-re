package com.opos.mobad.q;

import android.app.Activity;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class k extends j implements com.opos.mobad.ad.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.ad.l.a f7302a;

    public k(com.opos.mobad.ad.l.a aVar) {
        super(aVar);
        this.f7302a = aVar;
    }

    @Override // com.opos.mobad.ad.l
    public void a(final Activity activity) {
        d(new Callable<Boolean>() { // from class: com.opos.mobad.q.k.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(k.this.b(activity));
            }
        });
    }

    protected abstract boolean b(Activity activity);

    final void d(Callable<Boolean> callable) {
        int iA = this.f.a(3, callable);
        com.opos.cmn.an.f.a.b("SyncStateController", "showAd state=" + iA + ",Ad =" + this);
        switch (iA) {
            case 0:
            case 1:
            case 6:
                b(10006, "ad data is null");
                break;
            case 2:
            case 3:
                break;
            case 4:
                b(10008, "ad had showed, please reload");
                break;
            case 5:
                b(11001, "ad has destroyed.");
                break;
            default:
                b(-1, "show with illegal state:" + iA);
                break;
        }
    }

    protected final void e(final int i, final String str) {
        if (c() == 3) {
            this.e.post(new Runnable() { // from class: com.opos.mobad.q.k.2
                @Override // java.lang.Runnable
                public void run() {
                    int iA = k.this.f.a(3, 4);
                    com.opos.cmn.an.f.a.b("SyncStateController", "onShowAdFailed state=" + iA + ",Ad = " + this);
                    if (5 == iA) {
                        return;
                    }
                    if (iA == 4) {
                        k.this.b(i, str);
                    } else {
                        k.this.b(-1, "show fail with illegal state:" + iA);
                    }
                }
            });
        } else {
            super.d(i, str);
        }
    }

    @Override // com.opos.mobad.q.j
    protected void m() {
        com.opos.mobad.ad.l.a aVar;
        if (4 != this.f.a(4) || (aVar = this.f7302a) == null) {
            return;
        }
        aVar.b();
    }

    @Override // com.opos.mobad.q.j
    void n() {
        this.f = l.b();
    }

    protected final void p() {
        com.opos.mobad.ad.l.a aVar;
        if (5 == c() || (aVar = this.f7302a) == null) {
            return;
        }
        aVar.a(0L);
    }

    protected final void q() {
        com.opos.mobad.ad.l.a aVar;
        if (5 == c() || (aVar = this.f7302a) == null) {
            return;
        }
        aVar.a("");
    }
}
