package com.hihonor.dlinstall.ipc;

import android.os.Handler;
import android.os.Looper;
import com.hihonor.dlinstall.DownloadInstallBtnListener;
import com.hihonor.dlinstall.DownloadInstallListener;
import com.hihonor.dlinstall.DownloadInstallV2Listener;
import com.hihonor.dlinstall.DownloadInstallV3Listener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class b implements DownloadInstallV3Listener, DownloadInstallBtnListener {
    public static volatile b d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<DownloadInstallListener> f3593a = new ArrayList();
    public final List<DownloadInstallBtnListener> b = new ArrayList();
    public final Handler c = new Handler(Looper.getMainLooper());

    public static b a() {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b();
                }
            }
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, String str) {
        for (DownloadInstallListener downloadInstallListener : (ArrayList) b()) {
            try {
                if (downloadInstallListener instanceof DownloadInstallV2Listener) {
                    downloadInstallListener = (DownloadInstallV2Listener) downloadInstallListener;
                }
                downloadInstallListener.onInstallStart(i, str);
            } catch (Error e) {
                com.hihonor.dlinstall.page.a.b("DlInstallCallbackManager", "onInstallStart: e is " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, String str, int i2) {
        for (DownloadInstallListener downloadInstallListener : (ArrayList) b()) {
            try {
                if (downloadInstallListener instanceof DownloadInstallV2Listener) {
                    ((DownloadInstallV2Listener) downloadInstallListener).onDownloadSuccess(i, str, i2);
                } else {
                    downloadInstallListener.onDownloadSuccess(i, str);
                }
            } catch (Error e) {
                com.hihonor.dlinstall.page.a.b("DlInstallCallbackManager", "onDownloadSuccess: e is " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, String str, int i2, String str2) {
        for (DownloadInstallListener downloadInstallListener : (ArrayList) b()) {
            try {
                if (downloadInstallListener instanceof DownloadInstallV3Listener) {
                    ((DownloadInstallV3Listener) downloadInstallListener).onFailResult(i, str, i2, str2);
                } else {
                    com.hihonor.dlinstall.page.a.d("DlInstallCallbackManager", "onFailResult:not current interface method");
                }
            } catch (Error e) {
                com.hihonor.dlinstall.page.a.b("DlInstallCallbackManager", "onFailResult: e is " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, String str, int i2, String str2, int i3) {
        for (DownloadInstallListener downloadInstallListener : (ArrayList) b()) {
            try {
                if (downloadInstallListener instanceof DownloadInstallV2Listener) {
                    ((DownloadInstallV2Listener) downloadInstallListener).onDownloadFail(i, str, i2, str2, i3);
                } else {
                    downloadInstallListener.onDownloadFail(i, str, i2, str2);
                }
            } catch (Error e) {
                com.hihonor.dlinstall.page.a.b("DlInstallCallbackManager", "onDownloadFail: e is " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, String str, long j, long j2, float f, int i2) {
        for (DownloadInstallListener downloadInstallListener : (ArrayList) b()) {
            try {
                if (downloadInstallListener instanceof DownloadInstallV2Listener) {
                    ((DownloadInstallV2Listener) downloadInstallListener).onDownloadProgress(i, str, j, j2, f, i2);
                } else {
                    downloadInstallListener.onDownloadProgress(i, str, j, j2, f);
                }
            } catch (Exception e) {
                com.hihonor.dlinstall.page.a.b("DlInstallCallbackManager", "onDownloadProgress: e is " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, String str, long j, long j2, int i2) {
        for (DownloadInstallListener downloadInstallListener : (ArrayList) b()) {
            try {
                if (downloadInstallListener instanceof DownloadInstallV2Listener) {
                    ((DownloadInstallV2Listener) downloadInstallListener).onDownloadPause(i, str, j, j2, i2);
                } else {
                    try {
                        downloadInstallListener.onDownloadPause(i, str);
                    } catch (Error e) {
                        e = e;
                        com.hihonor.dlinstall.page.a.b("DlInstallCallbackManager", "onDownloadPause: e is " + e.getMessage());
                    }
                }
            } catch (Error e2) {
                e = e2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i, String str, long j, long j2, int i2, int i3) {
        for (DownloadInstallListener downloadInstallListener : (ArrayList) b()) {
            try {
                if (downloadInstallListener instanceof DownloadInstallV2Listener) {
                    ((DownloadInstallV2Listener) downloadInstallListener).onDownloadWaiting(i, str, j, j2, i2, i3);
                } else {
                    try {
                        downloadInstallListener.onDownloadWaiting(i, str);
                    } catch (Error e) {
                        e = e;
                        com.hihonor.dlinstall.page.a.b("DlInstallCallbackManager", "onDownloadWaiting: e is " + e.getMessage());
                    }
                }
            } catch (Error e2) {
                e = e2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, int i2) {
        ArrayList arrayList;
        synchronized (b.class) {
            arrayList = new ArrayList(this.b);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ((DownloadInstallBtnListener) it.next()).onClickDownloadInstallBtn(str, i, i2);
            } catch (Error e) {
                com.hihonor.dlinstall.page.a.b("DlInstallCallbackManager", "onClickDownloadInstallBtn: e is " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i, String str) {
        for (DownloadInstallListener downloadInstallListener : (ArrayList) b()) {
            try {
                if (downloadInstallListener instanceof DownloadInstallV2Listener) {
                    downloadInstallListener = (DownloadInstallV2Listener) downloadInstallListener;
                }
                downloadInstallListener.onInstallSuccess(i, str);
            } catch (Error e) {
                com.hihonor.dlinstall.page.a.b("DlInstallCallbackManager", "onInstallSuccess: e is " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i, String str, int i2, String str2) {
        for (DownloadInstallListener downloadInstallListener : (ArrayList) b()) {
            try {
                if (downloadInstallListener instanceof DownloadInstallV2Listener) {
                    downloadInstallListener = (DownloadInstallV2Listener) downloadInstallListener;
                }
                downloadInstallListener.onInstallFail(i, str, i2, str2);
            } catch (Error e) {
                com.hihonor.dlinstall.page.a.b("DlInstallCallbackManager", "onInstallFail: e is " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(int i, String str, long j, long j2, int i2) {
        for (DownloadInstallListener downloadInstallListener : (ArrayList) b()) {
            try {
                if (downloadInstallListener instanceof DownloadInstallV2Listener) {
                    ((DownloadInstallV2Listener) downloadInstallListener).onDownloadStart(i, str, j, j2, i2);
                } else {
                    try {
                        downloadInstallListener.onDownloadStart(i, str);
                    } catch (Error e) {
                        e = e;
                        com.hihonor.dlinstall.page.a.b("DlInstallCallbackManager", "onDownloadStart: e is " + e.getMessage());
                    }
                }
            } catch (Error e2) {
                e = e2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        for (DownloadInstallListener downloadInstallListener : (ArrayList) b()) {
            try {
                if (downloadInstallListener instanceof DownloadInstallV2Listener) {
                    downloadInstallListener = (DownloadInstallV2Listener) downloadInstallListener;
                }
                downloadInstallListener.onServiceShutdown();
            } catch (Error e) {
                com.hihonor.dlinstall.page.a.b("DlInstallCallbackManager", "onServiceShutdown: e is " + e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(int i, String str) {
        for (DownloadInstallListener downloadInstallListener : (ArrayList) b()) {
            try {
                if (downloadInstallListener instanceof DownloadInstallV2Listener) {
                    ((DownloadInstallV2Listener) downloadInstallListener).onTrafficDownload(i, str);
                } else {
                    com.hihonor.dlinstall.page.a.d("DlInstallCallbackManager", "onTrafficDownload:not current interface method");
                }
            } catch (Error e) {
                com.hihonor.dlinstall.page.a.b("DlInstallCallbackManager", "onTrafficDownload: e is " + e.getMessage());
            }
        }
    }

    public final List<DownloadInstallListener> b() {
        ArrayList arrayList;
        synchronized (b.class) {
            arrayList = new ArrayList(this.f3593a);
        }
        return arrayList;
    }

    @Override // com.hihonor.dlinstall.DownloadInstallBtnListener
    public void onClickDownloadInstallBtn(final String str, final int i, final int i2) {
        this.c.post(new Runnable() { // from class: com.hihonor.dlinstall.ipc.b$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(str, i, i2);
            }
        });
    }

    @Override // com.hihonor.dlinstall.DownloadInstallListener
    public void onDownloadFail(int i, String str, int i2, String str2) {
        onDownloadFail(i, str, i2, str2, 0);
    }

    @Override // com.hihonor.dlinstall.DownloadInstallV2Listener
    public void onDownloadFail(final int i, final String str, final int i2, final String str2, final int i3) {
        this.c.post(new Runnable() { // from class: com.hihonor.dlinstall.ipc.b$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(i, str, i2, str2, i3);
            }
        });
    }

    @Override // com.hihonor.dlinstall.DownloadInstallListener
    public void onDownloadPause(int i, String str) {
        onDownloadPause(i, str, -1L, -1L, 0);
    }

    @Override // com.hihonor.dlinstall.DownloadInstallV2Listener
    public void onDownloadPause(final int i, final String str, final long j, final long j2, final int i2) {
        this.c.post(new Runnable() { // from class: com.hihonor.dlinstall.ipc.b$$ExternalSyntheticLambda13
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(i, str, j, j2, i2);
            }
        });
    }

    @Override // com.hihonor.dlinstall.DownloadInstallListener
    public void onDownloadProgress(int i, String str, long j, long j2, float f) {
        onDownloadProgress(i, str, j, j2, f, 0);
    }

    @Override // com.hihonor.dlinstall.DownloadInstallV2Listener
    public void onDownloadProgress(final int i, final String str, final long j, final long j2, final float f, final int i2) {
        this.c.post(new Runnable() { // from class: com.hihonor.dlinstall.ipc.b$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(i, str, j, j2, f, i2);
            }
        });
    }

    @Override // com.hihonor.dlinstall.DownloadInstallListener
    public void onDownloadStart(int i, String str) {
        onDownloadStart(i, str, -1L, -1L, 0);
    }

    @Override // com.hihonor.dlinstall.DownloadInstallV2Listener
    public void onDownloadStart(final int i, final String str, final long j, final long j2, final int i2) {
        this.c.post(new Runnable() { // from class: com.hihonor.dlinstall.ipc.b$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(i, str, j, j2, i2);
            }
        });
    }

    @Override // com.hihonor.dlinstall.DownloadInstallListener
    public void onDownloadSuccess(int i, String str) {
        onDownloadSuccess(i, str, 0);
    }

    @Override // com.hihonor.dlinstall.DownloadInstallV2Listener
    public void onDownloadSuccess(final int i, final String str, final int i2) {
        this.c.post(new Runnable() { // from class: com.hihonor.dlinstall.ipc.b$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(i, str, i2);
            }
        });
    }

    @Override // com.hihonor.dlinstall.DownloadInstallListener
    public void onDownloadWaiting(int i, String str) {
        onDownloadWaiting(i, str, -1L, -1L, 0, 0);
    }

    @Override // com.hihonor.dlinstall.DownloadInstallV2Listener
    public void onDownloadWaiting(final int i, final String str, final long j, final long j2, final int i2, final int i3) {
        this.c.post(new Runnable() { // from class: com.hihonor.dlinstall.ipc.b$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(i, str, j, j2, i2, i3);
            }
        });
    }

    @Override // com.hihonor.dlinstall.DownloadInstallV3Listener
    public void onFailResult(final int i, final String str, final int i2, final String str2) {
        this.c.post(new Runnable() { // from class: com.hihonor.dlinstall.ipc.b$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(i, str, i2, str2);
            }
        });
    }

    @Override // com.hihonor.dlinstall.DownloadInstallListener
    public void onInstallFail(final int i, final String str, final int i2, final String str2) {
        this.c.post(new Runnable() { // from class: com.hihonor.dlinstall.ipc.b$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(i, str, i2, str2);
            }
        });
    }

    @Override // com.hihonor.dlinstall.DownloadInstallListener
    public void onInstallStart(final int i, final String str) {
        this.c.post(new Runnable() { // from class: com.hihonor.dlinstall.ipc.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(i, str);
            }
        });
    }

    @Override // com.hihonor.dlinstall.DownloadInstallListener
    public void onInstallSuccess(final int i, final String str) {
        this.c.post(new Runnable() { // from class: com.hihonor.dlinstall.ipc.b$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(i, str);
            }
        });
    }

    @Override // com.hihonor.dlinstall.DownloadInstallBtnListener
    public void onOpenApp(final String str, final int i, final boolean z) {
        this.c.post(new Runnable() { // from class: com.hihonor.dlinstall.ipc.b$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(str, i, z);
            }
        });
    }

    @Override // com.hihonor.dlinstall.DownloadInstallListener
    public void onServiceShutdown() {
        this.c.post(new Runnable() { // from class: com.hihonor.dlinstall.ipc.b$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c();
            }
        });
    }

    @Override // com.hihonor.dlinstall.DownloadInstallV2Listener
    public void onTrafficDownload(final int i, final String str) {
        this.c.post(new Runnable() { // from class: com.hihonor.dlinstall.ipc.b$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, boolean z) {
        ArrayList arrayList;
        synchronized (b.class) {
            arrayList = new ArrayList(this.b);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ((DownloadInstallBtnListener) it.next()).onOpenApp(str, i, z);
            } catch (Error e) {
                com.hihonor.dlinstall.page.a.b("DlInstallCallbackManager", "onOpenApp: e is " + e.getMessage());
            }
        }
    }
}
