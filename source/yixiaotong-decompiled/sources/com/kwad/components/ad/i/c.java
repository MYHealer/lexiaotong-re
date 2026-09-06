package com.kwad.components.ad.i;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class c implements Runnable {
    private static final Handler rB = new Handler(Looper.getMainLooper());
    private static volatile boolean rF;
    private final long rC;
    private final AdTemplate rD;
    private boolean rE = false;
    private d rG;

    static /* synthetic */ boolean access$002(boolean z) {
        rF = false;
        return false;
    }

    public c(com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate = aVar.getAdTemplate();
        this.rD = adTemplate;
        long jDi = com.kwad.sdk.core.response.helper.a.di(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
        this.rC = jDi;
        com.kwad.sdk.core.d.c.d("PushAdManager", "PushAdManager create adTemplate: " + adTemplate.hashCode() + ", " + jDi);
    }

    public final void gh() {
        com.kwad.sdk.core.d.c.w("PushAdManager", "startRequestPushAd processingPush: " + rF);
        if (rF || this.rD.mAdScene == null) {
            return;
        }
        rF = true;
        com.kwad.components.core.j.a.b(this.rD.mAdScene, new com.kwad.components.core.j.a.InterfaceC0674a() { // from class: com.kwad.components.ad.i.c.1
            @Override // com.kwad.components.core.j.a.InterfaceC0674a
            public final void onRequestResult(int i) {
            }

            @Override // com.kwad.components.core.j.a.InterfaceC0674a
            public final void onError(int i, String str) {
                com.kwad.sdk.core.d.c.d("PushAdManager", "onError: " + str);
                c.access$002(false);
            }

            @Override // com.kwad.components.core.j.a.InterfaceC0674a
            public final void e(List<com.kwad.components.core.j.c> list) {
                com.kwad.sdk.core.d.c.d("PushAdManager", "onInnerAdLoad: " + list);
                if (list != null && list.size() > 0) {
                    AdTemplate adTemplate = list.get(0).getAdTemplate();
                    if (com.kwad.sdk.core.response.helper.a.dg(com.kwad.sdk.core.response.helper.e.eO(adTemplate))) {
                        com.kwad.sdk.core.d.c.d("PushAdManager", "loadPushTK");
                        c.this.rG = new d(ServiceProvider.getContext(), adTemplate);
                        return;
                    }
                    c.access$002(false);
                    com.kwad.sdk.core.d.c.d("PushAdManager", "pushAdInfo templateId invalid");
                    return;
                }
                c.access$002(false);
            }
        });
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (com.kwad.components.core.e.a.e.pu().isShowing()) {
            com.kwad.components.core.e.a.e.pu().a(new com.kwad.components.core.e.a.c() { // from class: com.kwad.components.ad.i.c.2
                @Override // com.kwad.components.core.e.a.c, com.kwad.components.core.e.a.b
                public final void gk() {
                    com.kwad.components.core.e.a.e.pu().b(this);
                    c.this.gi();
                }
            });
        } else {
            gi();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gi() {
        d dVar;
        if (!b.gd().gf()) {
            com.kwad.sdk.core.d.c.d("PushAdManager", "run preCheckResult false");
            return;
        }
        rF = false;
        if (this.rE || (dVar = this.rG) == null || !dVar.gn()) {
            return;
        }
        this.rE = true;
        this.rG.c(new com.kwad.components.ad.b.a.b() { // from class: com.kwad.components.ad.i.c.3
            @Override // com.kwad.components.ad.b.a.b
            public final void Y() {
                ai.be(System.currentTimeMillis());
                e.gq().gm();
            }

            @Override // com.kwad.components.ad.b.a.b
            public final void Z() {
                com.kwad.sdk.core.d.c.d("PushAdManager", "onAdClose: ");
                e.gq().go();
                b.gd().a(c.this);
            }
        });
    }

    public final void d(com.kwad.components.core.internal.api.a aVar) {
        AdTemplate adTemplate = aVar.getAdTemplate();
        if (!adTemplate.equals(this.rD)) {
            com.kwad.sdk.core.d.c.d("PushAdManager", "onAdExit not current ad");
            return;
        }
        com.kwad.sdk.core.d.c.d("PushAdManager", "onAdExit showPushAdDelayTime: " + this.rC + ", adTemplate: " + adTemplate.hashCode());
        if (aVar.supportPushAd()) {
            a(1000001, this, this.rC);
        }
    }

    public final void gj() {
        com.kwad.sdk.core.d.c.d("PushAdManager", "onOutSDKPage: ");
        if (rB.hasMessages(1000001)) {
            return;
        }
        com.kwad.sdk.core.d.c.d("PushAdManager", "onOutSDKPage: sendMessageDelay MSG_WHAT_PAGE_OUT");
        a(1000002, this, 500L);
    }

    private static void a(int i, Runnable runnable, long j) {
        Handler handler = rB;
        Message messageObtain = Message.obtain(handler, runnable);
        messageObtain.what = i;
        handler.sendMessageDelayed(messageObtain, j);
    }
}
