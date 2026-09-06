package com.kwad.sdk.core.webview.b.b;

import com.kwad.framework.filedownloader.r;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {

    /* JADX INFO: renamed from: com.kwad.sdk.core.webview.b.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0751a {
        void c(com.kwad.sdk.h.a.b bVar);

        void d(com.kwad.sdk.h.a.b bVar);

        void e(com.kwad.sdk.h.a.b bVar);
    }

    public static void a(final com.kwad.sdk.h.a.b bVar, final InterfaceC0751a interfaceC0751a) {
        c.d("HybridDownloader", "reportHybrid: download+++url " + bVar.packageUrl);
        interfaceC0751a.c(bVar);
        bVar.aV(System.currentTimeMillis());
        com.kwad.sdk.core.webview.b.c.b.a(bVar, 1);
        r.aX(m.Yb());
        r.BG();
        r.bV(bVar.packageUrl).i(bVar).bT(bVar.bgI).bt(true).a(new com.kwad.framework.filedownloader.m() { // from class: com.kwad.sdk.core.webview.b.b.a.1
            @Override // com.kwad.framework.filedownloader.m, com.kwad.framework.filedownloader.i
            public final void b(com.kwad.framework.filedownloader.a aVar) {
                super.b(aVar);
                if (aVar.AH() == -3) {
                    interfaceC0751a.d(bVar);
                } else {
                    interfaceC0751a.e(bVar);
                    com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 1, "task.getStatus()=" + ((int) aVar.AH()));
                }
            }

            @Override // com.kwad.framework.filedownloader.m, com.kwad.framework.filedownloader.i
            public final void a(com.kwad.framework.filedownloader.a aVar, Throwable th) {
                super.a(aVar, th);
                com.kwad.sdk.core.webview.b.c.b.a(bVar, 0, 1, th.getMessage());
                interfaceC0751a.e((com.kwad.sdk.h.a.b) aVar.getTag());
            }
        }).start();
    }
}
