package com.opos.cmn.func.dl;

import android.content.Context;
import com.opos.cmn.func.dl.base.DownloadConfig;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.c;
import com.opos.cmn.func.dl.base.d;
import com.opos.cmn.func.dl.base.e;
import com.opos.cmn.func.dl.service.DownloadRemoteManager;
import com.opos.cmn.func.dl.service.DownloadService;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f6096a;

    public a(Context context) {
        this(context, null);
    }

    public a(Context context, Class cls) {
        if (context == null) {
            com.opos.cmn.an.f.a.d("DownloadManager", "Context should not be null!");
            return;
        }
        try {
            if (cls != null) {
                try {
                    if (DownloadService.class.isAssignableFrom(cls)) {
                        this.f6096a = new DownloadRemoteManager(StubApp.getOrigApplicationContext(context.getApplicationContext()), cls);
                    }
                } catch (NoClassDefFoundError unused) {
                    com.opos.cmn.an.f.a.d("DownloadManager", "library service not include!");
                    if (this.f6096a == null) {
                        this.f6096a = new e(context);
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    com.opos.cmn.an.f.a.d("DownloadManager", "create DownloadRemoteManager error", th);
                    if (this.f6096a == null) {
                        this.f6096a = new e(context);
                        return;
                    }
                    return;
                }
            }
            if (this.f6096a == null) {
                this.f6096a = new e(context);
            }
        } catch (Throwable th2) {
            if (this.f6096a == null) {
                this.f6096a = new e(context);
            }
            throw th2;
        }
    }

    @Override // com.opos.cmn.func.dl.base.d
    public final void a(DownloadConfig downloadConfig) {
        this.f6096a.a(downloadConfig);
    }

    @Override // com.opos.cmn.func.dl.base.d
    public final void a(DownloadRequest downloadRequest) {
        this.f6096a.a(downloadRequest);
    }

    @Override // com.opos.cmn.func.dl.base.d
    public final void a(c cVar) {
        this.f6096a.a(cVar);
    }

    @Override // com.opos.cmn.func.dl.base.d
    public final void b(DownloadRequest downloadRequest) {
        this.f6096a.b(downloadRequest);
    }

    @Override // com.opos.cmn.func.dl.base.d
    public final void b(c cVar) {
        this.f6096a.b(cVar);
    }

    @Override // com.opos.cmn.func.dl.base.d
    public final void c(DownloadRequest downloadRequest) {
        this.f6096a.c(downloadRequest);
    }

    @Override // com.opos.cmn.func.dl.base.d
    public final void d(DownloadRequest downloadRequest) {
        this.f6096a.d(downloadRequest);
    }
}
