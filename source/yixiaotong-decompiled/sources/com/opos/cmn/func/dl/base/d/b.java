package com.opos.cmn.func.dl.base.d;

import android.content.Context;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.DownloadResponse;
import com.opos.cmn.func.dl.base.exception.DlException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b {
    public Context b;
    com.opos.cmn.func.dl.base.f.a c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    List<DownloadRequest> f6126a = new CopyOnWriteArrayList();
    public C0892b d = new C0892b();

    class a extends com.opos.cmn.func.dl.base.a {
        a() {
        }

        @Override // com.opos.cmn.func.dl.base.a, com.opos.cmn.func.dl.base.c
        public final void a(DownloadRequest downloadRequest, DownloadResponse downloadResponse, DlException dlException) {
            if (downloadRequest.g) {
                int iA = dlException.a();
                if (iA == 1003 || iA == 1013) {
                    com.opos.cmn.an.f.a.a("RetryManager", "add retry request:" + downloadRequest.toString());
                    for (int i = 0; i < b.this.f6126a.size(); i++) {
                        try {
                            if (downloadRequest.d > b.this.f6126a.get(i).d) {
                                b.this.f6126a.add(i, downloadRequest);
                                return;
                            }
                        } catch (Throwable unused) {
                            return;
                        }
                    }
                    b.this.f6126a.add(downloadRequest);
                }
            }
        }

        @Override // com.opos.cmn.func.dl.base.a, com.opos.cmn.func.dl.base.c
        public final void d(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            b.this.a(downloadRequest);
        }
    }

    /* JADX INFO: renamed from: com.opos.cmn.func.dl.base.d.b$b, reason: collision with other inner class name */
    class C0892b implements com.opos.cmn.func.dl.base.d.a.c {
        C0892b() {
        }

        @Override // com.opos.cmn.func.dl.base.d.a.c
        public final synchronized void a() {
            com.opos.cmn.an.f.a.a("RetryManager", "-----onMoblieAvailable !");
            try {
                Iterator it = new ArrayList(b.this.f6126a).iterator();
                while (it.hasNext()) {
                    b.this.c.a((DownloadRequest) it.next(), false);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // com.opos.cmn.func.dl.base.d.a.c
        public final synchronized void b() {
            com.opos.cmn.an.f.a.a("RetryManager", "-----onWifiAvailable!");
            try {
                Iterator it = new ArrayList(b.this.f6126a).iterator();
                while (it.hasNext()) {
                    b.this.c.a((DownloadRequest) it.next(), false);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // com.opos.cmn.func.dl.base.d.a.c
        public final synchronized void c() {
            com.opos.cmn.an.f.a.a("RetryManager", "-----onUnavailable");
        }
    }

    public b(Context context, com.opos.cmn.func.dl.base.f.a aVar) {
        this.b = context;
        this.c = aVar;
        aVar.c.a(new a());
        com.opos.cmn.func.dl.base.d.a.a(context).a(this.d);
    }

    public final void a(DownloadRequest downloadRequest) {
        try {
            this.f6126a.remove(downloadRequest);
        } catch (Throwable unused) {
        }
    }
}
