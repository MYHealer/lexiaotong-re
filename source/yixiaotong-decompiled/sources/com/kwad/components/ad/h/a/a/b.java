package com.kwad.components.ad.h.a.a;

import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b implements com.kwad.sdk.core.webview.c.a {
    public static int rf = 1;
    public static int rg = 2;
    private com.kwad.sdk.core.webview.c.c re;
    private int rh;
    private int ri;
    private InterfaceC0604b rk;
    private c rj = new c(this, 0);
    private Runnable rl = null;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int rn;
        public int ro;
    }

    /* JADX INFO: renamed from: com.kwad.components.ad.h.a.a.b$b, reason: collision with other inner class name */
    public interface InterfaceC0604b {
        void ab(int i);
    }

    public final void a(InterfaceC0604b interfaceC0604b) {
        this.rk = interfaceC0604b;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerTimerListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.re = null;
    }

    private b(int i, int i2) {
        this.rh = i;
        this.ri = i2;
    }

    public static b M(AdTemplate adTemplate) {
        AdInfo adInfoEO = e.eO(adTemplate);
        if (!(!com.kwad.sdk.core.response.helper.a.bi(adInfoEO))) {
            return null;
        }
        if (com.kwad.sdk.core.response.helper.a.bQ(adInfoEO)) {
            return new b(rg, f(adInfoEO));
        }
        if (adInfoEO.adInsertScreenInfo.autoCloseTime > 0) {
            return new b(rf, adInfoEO.adInsertScreenInfo.autoCloseTime);
        }
        return null;
    }

    private static int f(AdInfo adInfo) {
        int iB = com.kwad.components.ad.interstitial.b.b.b(adInfo);
        if (iB <= 0) {
            iB = 60;
        }
        int i = adInfo.adInsertScreenInfo.autoCloseTime;
        return i > 0 ? Math.min(iB, i) : iB;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.re = cVar;
        Runnable runnable = this.rl;
        if (runnable != null) {
            runnable.run();
            this.rl = null;
        }
    }

    public final void az() {
        com.kwad.sdk.core.d.c.d("RegisterTimer", "startTimer: mCallBackFunction: " + this.re);
        if (this.re == null) {
            this.rl = new Runnable() { // from class: com.kwad.components.ad.h.a.a.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.az();
                }
            };
        } else {
            this.rj.ah(this.ri);
            by.runOnUiThread(this.rj);
        }
    }

    public final void gb() {
        this.rj.z(true);
    }

    public final void gc() {
        this.rj.z(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ag(int i) {
        com.kwad.sdk.core.d.c.d("RegisterTimer", "updateTimer: " + i + ", mCallBackFunction: " + this.re);
        if (i >= 0 && this.re != null) {
            InterfaceC0604b interfaceC0604b = this.rk;
            if (interfaceC0604b != null && i == 0) {
                interfaceC0604b.ab(this.rh);
            }
            a aVar = new a();
            aVar.ro = i;
            aVar.rn = this.rh;
            com.kwad.sdk.core.webview.c.c cVar = this.re;
            if (cVar != null) {
                cVar.b(aVar);
            }
        }
    }

    class c implements Runnable {
        private boolean rp;
        private int rq;

        public final void ah(int i) {
            this.rq = i;
        }

        public final void z(boolean z) {
            this.rp = z;
        }

        private c() {
            this.rp = false;
            this.rq = -1;
        }

        /* synthetic */ c(b bVar, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.sdk.core.d.c.d("RegisterTimer", "TimerRunnable run timerPaused:  " + this.rp + ", currentTime: " + this.rq);
            if (this.rp) {
                by.a(this, null, 1000L);
                return;
            }
            int i = this.rq;
            if (i < 0) {
                return;
            }
            b.this.ag(i);
            this.rq--;
            by.a(this, null, 1000L);
        }
    }
}
