package com.opos.mobad.f;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.opos.cmn.func.dl.base.DownloadConfig;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.DownloadResponse;
import com.opos.cmn.func.dl.base.exception.DlException;
import com.stub.StubApp;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {
    private static volatile a b;
    private static final byte[] c = new byte[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6883a;
    private com.opos.cmn.func.dl.a d;
    private b e;
    private InterfaceC0959a f;
    private ConcurrentHashMap<String, DownloadRequest> g = new ConcurrentHashMap<>();
    private boolean h = false;
    private AtomicBoolean i = new AtomicBoolean(false);
    private h j;
    private h k;

    /* JADX INFO: renamed from: com.opos.mobad.f.a$a, reason: collision with other inner class name */
    public interface InterfaceC0959a {
        void a(String str);

        void a(String str, int i, long j, long j2);

        void a(String str, long j, long j2);

        void a(String str, String str2);

        void b(String str);

        void b(String str, long j, long j2);

        void c(String str, long j, long j2);

        void d(String str, long j, long j2);
    }

    private class b implements com.opos.cmn.func.dl.base.c {
        private b() {
        }

        private boolean a(DownloadRequest downloadRequest) {
            return (downloadRequest == null || TextUtils.isEmpty(downloadRequest.f6098a) || !a.this.g.containsKey(downloadRequest.f6098a)) ? false : true;
        }

        @Override // com.opos.cmn.func.dl.base.c
        public void a(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || a.this.f == null || downloadResponse == null) {
                return;
            }
            a.this.f.a(downloadRequest.f6098a, downloadResponse.c, downloadResponse.d);
        }

        @Override // com.opos.cmn.func.dl.base.c
        public void a(DownloadRequest downloadRequest, DownloadResponse downloadResponse, DlException dlException) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "fail exception:" + dlException);
            if (!a(downloadRequest) || a.this.f == null || downloadResponse == null || dlException == null) {
                return;
            }
            if (dlException.a() == 1013) {
                a.this.f.b(downloadRequest.f6098a);
            } else {
                a.this.f.a(downloadRequest.f6098a, dlException.a(), downloadResponse.c, downloadResponse.d);
            }
        }

        @Override // com.opos.cmn.func.dl.base.c
        public void b(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || a.this.f == null || downloadResponse == null) {
                return;
            }
            a.this.f.b(downloadRequest.f6098a, downloadResponse.c, downloadResponse.d);
        }

        @Override // com.opos.cmn.func.dl.base.c
        public void c(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || a.this.f == null || downloadResponse == null) {
                return;
            }
            a.this.f.b(downloadRequest.f6098a, downloadResponse.c, downloadResponse.d);
        }

        @Override // com.opos.cmn.func.dl.base.c
        public void d(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || a.this.f == null || downloadResponse == null) {
                return;
            }
            a.this.f.c(downloadRequest.f6098a, downloadResponse.c, downloadResponse.d);
        }

        @Override // com.opos.cmn.func.dl.base.c
        public void e(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            if (!a(downloadRequest) || a.this.f == null || downloadResponse == null) {
                return;
            }
            a.this.f.d(downloadRequest.f6098a, downloadResponse.c, downloadResponse.d);
            a.this.f(downloadRequest.f6098a);
        }

        @Override // com.opos.cmn.func.dl.base.c
        public void f(DownloadRequest downloadRequest, DownloadResponse downloadResponse) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "complete ");
            if (!a(downloadRequest) || a.this.f == null) {
                return;
            }
            a.this.f.a(downloadRequest.f6098a, (downloadRequest == null || TextUtils.isEmpty(downloadRequest.b) || TextUtils.isEmpty(downloadRequest.c)) ? null : downloadRequest.b + File.separator + downloadRequest.c);
            a.this.f(downloadRequest.f6098a);
        }
    }

    private a(Context context) {
        if (context == null) {
            return;
        }
        this.f6883a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.j = new com.opos.mobad.f.b();
        this.d = new com.opos.cmn.func.dl.a(this.f6883a);
        this.e = new b();
    }

    public static a a(Context context) {
        if (b == null) {
            synchronized (c) {
                if (b == null) {
                    b = new a(context);
                }
            }
        }
        return b;
    }

    private void c() {
        if (this.i.get()) {
            return;
        }
        a(3, null, null);
    }

    private void e(String str) {
        if (com.opos.cmn.an.d.a.a(str) || com.opos.cmn.an.e.b.a.b(str)) {
            return;
        }
        com.opos.cmn.an.e.b.a.f(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.g.remove(str);
    }

    public int a(final String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "add to download but url is empty");
            return -1;
        }
        try {
            c();
            com.opos.cmn.an.f.a.b("DownloadApkTool", "add download request:" + str);
            if (!this.h && !"WIFI".equalsIgnoreCase(com.opos.cmn.an.h.c.a.f(this.f6883a))) {
                this.h = true;
            }
            DownloadRequest.a aVarC = new DownloadRequest.a(str).a(this.h).b(a().a(this.f6883a)).c(a().a(str)).b(false).c(true);
            if (!TextUtils.isEmpty(str2)) {
                aVarC.a(str2);
            }
            DownloadRequest downloadRequestA = aVarC.a(this.f6883a);
            this.g.put(str, downloadRequestA);
            this.d.a(downloadRequestA);
            if (this.f != null) {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.opos.mobad.f.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.f != null) {
                            a.this.f.a(str);
                        }
                    }
                });
            }
            return downloadRequestA.f;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("DownloadApkTool", "", (Throwable) e);
            return -1;
        }
    }

    public h a() {
        h hVar = this.k;
        return hVar != null ? hVar : this.j;
    }

    public void a(int i, h hVar, InterfaceC0959a interfaceC0959a) {
        if (this.i.compareAndSet(false, true)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "init download apk manager");
            this.k = hVar;
            this.f = interfaceC0959a;
            e(a().a(this.f6883a));
            DownloadConfig downloadConfig = new DownloadConfig();
            downloadConfig.a(i).a(true).a(0.005f, 1000, 524288);
            this.d.a(downloadConfig);
            this.d.a(this.e);
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "addMobileTask but url is empty");
            return;
        }
        c();
        this.h = true;
        com.opos.cmn.an.f.a.b("DownloadApkTool", "pause download request:" + str);
        DownloadRequest downloadRequest = this.g.get(str);
        if (downloadRequest != null) {
            this.d.b(downloadRequest);
        }
    }

    public void b() {
        try {
            this.d.b(this.e);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("DownloadApkTool", "", (Throwable) e);
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "pause download but url is empty");
            return;
        }
        c();
        com.opos.cmn.an.f.a.b("DownloadApkTool", "pause download request:" + str);
        DownloadRequest downloadRequest = this.g.get(str);
        if (downloadRequest != null) {
            this.d.c(downloadRequest);
        }
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "cancel download but url is empty");
            return;
        }
        c();
        com.opos.cmn.an.f.a.b("DownloadApkTool", "cancel download request:" + str);
        DownloadRequest downloadRequest = this.g.get(str);
        if (downloadRequest != null) {
            this.d.d(downloadRequest);
        }
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("DownloadApkTool", "resume download but url is empty");
            return;
        }
        c();
        com.opos.cmn.an.f.a.b("DownloadApkTool", "resume download request:" + str);
        DownloadRequest downloadRequest = this.g.get(str);
        if (downloadRequest != null) {
            this.d.a(downloadRequest);
        }
    }
}
