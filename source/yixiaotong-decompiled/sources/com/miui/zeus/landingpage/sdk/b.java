package com.miui.zeus.landingpage.sdk;

import com.miui.zeus.mimo.sdk.C1210r;
import com.miui.zeus.mimo.sdk.n;
import com.miui.zeus.mimo.sdk.y8;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Set<DownloadListener> f5274a;
    public final C1210r b;
    public final C0857b c;

    public static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.miui.zeus.landingpage.sdk.b$b, reason: collision with other inner class name */
    public static class C0857b implements n {
        @Override // com.miui.zeus.mimo.sdk.n
        public void onCancelDownload(String str) {
            Iterator it = b.a().f5274a.iterator();
            while (it.hasNext()) {
                ((DownloadListener) it.next()).onCancelDownload(str);
            }
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onDownloadFailed(String str, int i) {
            Iterator it = b.a().f5274a.iterator();
            while (it.hasNext()) {
                ((DownloadListener) it.next()).onDownloadFailed(str, i);
            }
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onDownloadFinished(String str) {
            Iterator it = b.a().f5274a.iterator();
            while (it.hasNext()) {
                ((DownloadListener) it.next()).onDownloadFinished(str);
            }
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onDownloadPaused(String str) {
            Iterator it = b.a().f5274a.iterator();
            while (it.hasNext()) {
                ((DownloadListener) it.next()).onDownloadPaused(str);
            }
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onDownloadProgressUpdated(String str, int i) {
            Iterator it = b.a().f5274a.iterator();
            while (it.hasNext()) {
                ((DownloadListener) it.next()).onDownloadProgressUpdated(str, i);
            }
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onDownloadStarted(String str) {
            Iterator it = b.a().f5274a.iterator();
            while (it.hasNext()) {
                ((DownloadListener) it.next()).onDownloadStarted(str);
            }
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onExistDownload(String str) {
            Iterator it = b.a().f5274a.iterator();
            while (it.hasNext()) {
                ((DownloadListener) it.next()).onOtherOperation(str, 0, -2);
            }
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onInstallFailed(String str, int i) {
            Iterator it = b.a().f5274a.iterator();
            while (it.hasNext()) {
                ((DownloadListener) it.next()).onInstallFailed(str, i);
            }
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onInstallStart(String str) {
            Iterator it = b.a().f5274a.iterator();
            while (it.hasNext()) {
                ((DownloadListener) it.next()).onInstallStart(str);
            }
        }

        @Override // com.miui.zeus.mimo.sdk.n
        public void onInstallSuccess(String str) {
            Iterator it = b.a().f5274a.iterator();
            while (it.hasNext()) {
                ((DownloadListener) it.next()).onInstallSuccess(str);
            }
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5275a = new b(null);
    }

    public b() {
        this.f5274a = new CopyOnWriteArraySet();
        this.c = new C0857b();
        this.b = new C1210r(y8.a());
    }

    public /* synthetic */ b(a aVar) {
        this();
    }

    public static b a() {
        return c.f5275a;
    }

    public void a(DownloadListener downloadListener) {
        if (this.f5274a.isEmpty()) {
            this.b.a("", this.c);
        }
        this.f5274a.add(downloadListener);
    }

    public void b(DownloadListener downloadListener) {
        this.f5274a.remove(downloadListener);
        if (this.f5274a.isEmpty()) {
            this.b.a();
        }
    }
}
