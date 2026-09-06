package com.kwad.components.ad.reward.f;

import com.kwad.components.ad.reward.monitor.LivePlayMonitorType;
import com.kwad.components.ad.reward.monitor.b;
import com.kwad.components.core.video.h;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.components.offline.api.core.adlive.model.LiveShopItemInfo;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a extends com.kwad.components.ad.k.a<h> {
    private IAdLivePlayModule ir;
    private AdInfo mAdInfo;
    private AdLivePlayStateListener vA;
    private List<h> vy;
    private long vz;

    public a(AdTemplate adTemplate, IAdLivePlayModule iAdLivePlayModule, AdInfo adInfo) {
        super(adTemplate);
        this.vy = new CopyOnWriteArrayList();
        this.vz = 30000L;
        this.vA = new AdLivePlayStateListener() { // from class: com.kwad.components.ad.reward.f.a.1
            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePrepared() {
                a.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.1
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }

                    private static void c(h hVar) {
                        hVar.onMediaPrepared();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayProgress(final long j) {
                a.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.2
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public void accept(h hVar) {
                        hVar.onMediaPlayProgress(a.this.vz, j);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayStart() {
                a.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.3
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }

                    private static void c(h hVar) {
                        hVar.onMediaPlayStart();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayResume() {
                a.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.4
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }

                    private static void c(h hVar) {
                        hVar.onLivePlayResume();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayPause() {
                a.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.5
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }

                    private static void c(h hVar) {
                        hVar.onMediaPlayPaused();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayCompleted() {
                a.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.6
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }

                    private static void c(h hVar) {
                        hVar.onMediaPlayCompleted();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLivePlayEnd() {
                a.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.7
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(h hVar) {
                        c(hVar);
                    }

                    private static void c(h hVar) {
                        hVar.onLivePlayEnd();
                    }
                });
            }

            @Override // com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener
            public final void onLiveAudioEnableChange(final boolean z) {
                a.this.b(new com.kwad.sdk.g.a<h>() { // from class: com.kwad.components.ad.reward.f.a.1.8
                    @Override // com.kwad.sdk.g.a
                    public final /* bridge */ /* synthetic */ void accept(h hVar) {
                    }
                });
            }
        };
        this.ir = iAdLivePlayModule;
        this.mAdInfo = adInfo;
        if (e.eI(adTemplate) == 2) {
            this.vz = com.kwad.sdk.core.response.helper.a.ak(e.eO(adTemplate));
        }
        this.ir.registerAdLivePlayStateListener(this.vA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.kwad.sdk.g.a<h> aVar) {
        if (aVar != null) {
            Iterator<h> it = this.vy.iterator();
            while (it.hasNext()) {
                aVar.accept(it.next());
            }
        }
    }

    @Override // com.kwad.components.ad.k.a
    public final void resume() {
        this.ir.resume();
    }

    @Override // com.kwad.components.ad.k.a
    public final void skipToEnd() {
        this.ir.skipToEnd();
    }

    @Override // com.kwad.components.ad.k.a
    public final long getPlayDuration() {
        return this.ir.getPlayDuration();
    }

    public final void registerAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.ir.registerAdLiveCallerContextListener(adLiveCallerContextListener);
    }

    public final void unRegisterAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener) {
        this.ir.unRegisterAdLiveCallerContextListener(adLiveCallerContextListener);
    }

    public final LiveShopItemInfo getCurrentShowShopItemInfo() {
        return this.ir.getCurrentShowShopItemInfo();
    }

    public final void onResume() {
        this.ir.onResume();
    }

    public final void onPause() {
        this.ir.onPause();
    }

    private void iq() {
        try {
            this.vy.clear();
            this.ir.unRegisterAdLivePlayStateListener(this.vA);
            this.ir.onDestroy();
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
            b.a(2, ServiceProvider.getAppId(), String.valueOf(com.kwad.sdk.core.response.helper.a.cw(this.mAdInfo)), Long.valueOf(com.kwad.sdk.core.response.helper.a.cy(this.mAdInfo)), LivePlayMonitorType.LIVE_PLAY_MODULE_RELEASE_INNER_EXCEPTION.getValue(), "LivePlayModule releaseInner error: " + th.getMessage());
        }
    }

    @Override // com.kwad.components.ad.k.a
    public final void pause() {
        this.ir.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ad.k.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(h hVar) {
        if (hVar != null) {
            this.vy.add(hVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.ad.k.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(h hVar) {
        if (hVar != null) {
            this.vy.remove(hVar);
        }
    }

    public final void removeInterceptor(OnAdLiveResumeInterceptor onAdLiveResumeInterceptor) {
        this.ir.removeInterceptor(onAdLiveResumeInterceptor);
    }

    @Override // com.kwad.components.ad.k.a
    public final void setAudioEnabled(boolean z, boolean z2) {
        this.ir.setAudioEnabled(z, z2);
    }

    @Override // com.kwad.components.ad.k.a
    public final void release() {
        super.release();
        iq();
    }
}
