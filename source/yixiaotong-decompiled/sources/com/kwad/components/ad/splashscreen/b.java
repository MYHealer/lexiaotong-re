package com.kwad.components.ad.splashscreen;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.t.t;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b {
    private static final Handler jk = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: com.kwad.components.ad.splashscreen.b$b, reason: collision with other inner class name */
    static class C0636b {
        private volatile boolean Gy;

        private C0636b() {
            this.Gy = false;
        }

        /* synthetic */ C0636b(byte b) {
            this();
        }

        static /* synthetic */ boolean a(C0636b c0636b, boolean z) {
            c0636b.Gy = true;
            return true;
        }
    }

    static class a {
        private volatile boolean Gx;

        private a() {
            this.Gx = false;
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public static void loadSplashScreenAd(KsScene ksScene, final KsLoadManager.SplashScreenAdListener splashScreenAdListener) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.convert.e.d(sceneImplCovert);
        com.kwad.components.ad.splashscreen.monitor.b.mv();
        com.kwad.components.ad.splashscreen.monitor.b.x(sceneImplCovert.getPosId());
        boolean zB = t.wU().b(sceneImplCovert, "loadSplashScreenAd");
        sceneImplCovert.setAdStyle(4);
        sceneImplCovert.setAdNum(1);
        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenAd ");
        byte b = 0;
        final a aVar = new a(b);
        aVar.Gx = false;
        final long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        final ImpInfo impInfo = new ImpInfo(sceneImplCovert);
        final C0636b c0636b = new C0636b(b);
        com.kwad.components.core.p.a.vL().vN();
        Handler handler = jk;
        handler.postDelayed(new bi() { // from class: com.kwad.components.ad.splashscreen.b.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                b.a(impInfo);
            }
        }, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
        final bi biVar = new bi() { // from class: com.kwad.components.ad.splashscreen.b.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                C0636b.a(c0636b, true);
                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd mTimeOutRunnable timeOut");
                splashScreenAdListener.onError(com.kwad.sdk.core.network.e.aTg.errorCode, com.kwad.sdk.core.network.e.aTg.msg);
                com.kwad.components.ad.splashscreen.monitor.b.mv();
                com.kwad.components.ad.splashscreen.monitor.b.c(false, com.kwad.sdk.core.network.e.aTg.errorCode, com.kwad.sdk.core.network.e.aTg.msg, sceneImplCovert.getPosId());
                com.kwad.components.core.p.a.vL().bQ(4);
            }
        };
        int iA = com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.Hj);
        if (iA < 0) {
            iA = 5000;
        }
        handler.postDelayed(biVar, iA);
        final long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
        com.kwad.components.ad.splashscreen.monitor.b.mv();
        com.kwad.components.ad.splashscreen.monitor.b.f(sceneImplCovert.getPosId(), jElapsedRealtime3);
        SplashPreloadManager.lZ().a(sceneImplCovert.getPosId(), 2);
        List<String> listMa = SplashPreloadManager.lZ().ma();
        List<Integer> listI = SplashPreloadManager.lZ().i(listMa);
        com.kwad.components.ad.splashscreen.monitor.b.mv();
        com.kwad.components.ad.splashscreen.monitor.b.a(sceneImplCovert.getPosId(), listMa, listI);
        KsAdLoadManager.O().a(new com.kwad.components.core.request.model.a.C0690a().e(impInfo).aY(true).aZ(zB).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.3
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(final int i, final String str, boolean z) {
                if (c0636b.Gy) {
                    return;
                }
                b.jk.removeCallbacks(biVar);
                if (!aVar.Gx && i != com.kwad.sdk.core.network.e.aTe.errorCode) {
                    com.kwad.components.ad.splashscreen.monitor.b.mv();
                    com.kwad.components.ad.splashscreen.monitor.b.b(z, i, str, sceneImplCovert.getPosId());
                    com.kwad.components.ad.splashscreen.monitor.b.mv();
                    com.kwad.components.ad.splashscreen.monitor.b.c(z, i, str, sceneImplCovert.getPosId());
                }
                by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.splashscreen.b.3.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        splashScreenAdListener.onError(i, str);
                        if (i == com.kwad.sdk.core.network.e.aTh.errorCode) {
                            com.kwad.components.core.p.a.vL().bQ(0);
                        } else {
                            com.kwad.components.core.p.a.vL().bQ(3);
                        }
                    }
                });
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v10 */
            /* JADX WARN: Type inference failed for: r2v9, types: [com.kwad.components.ad.splashscreen.KsSplashScreenAdControl, com.kwad.sdk.api.KsSplashScreenAd] */
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(final AdResultData adResultData, boolean z) {
                boolean ksSplashScreenAdControl;
                by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.splashscreen.b.3.2
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        try {
                            splashScreenAdListener.onRequestResult(adResultData.getAdTemplateList().size());
                            com.kwad.components.ad.splashscreen.monitor.a.mt().w(sceneImplCovert.getPosId());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        }
                    }
                });
                try {
                    if (b.a(adResultData, aVar, this, z, sceneImplCovert.posId)) {
                        return;
                    }
                    AdTemplate adTemplate = adResultData.getAdTemplateList().get(0);
                    adTemplate.loadDataTime = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                    adTemplate.requestStartTime = jElapsedRealtime;
                    adTemplate.notNetworkRequest = z;
                    com.kwad.components.ad.splashscreen.monitor.b.mv();
                    com.kwad.components.ad.splashscreen.monitor.b.e(adTemplate, jElapsedRealtime3);
                    com.kwad.sdk.commercial.convert.e.b(sceneImplCovert, 1);
                    long jElapsedRealtime4 = SystemClock.elapsedRealtime();
                    ksSplashScreenAdControl = new KsSplashScreenAdControl(sceneImplCovert, adResultData);
                    if (com.kwad.sdk.core.config.e.a(com.kwad.components.ad.splashscreen.b.a.Hn)) {
                        try {
                            SplashPreloadManager.lZ();
                            if (SplashPreloadManager.i(adResultData)) {
                                if (b.a(c0636b, adTemplate, jElapsedRealtime4, jElapsedRealtime3, biVar)) {
                                    return;
                                }
                                b.a(splashScreenAdListener, (KsSplashScreenAd) ksSplashScreenAdControl, adTemplate, jElapsedRealtime, 1);
                                if (SplashPreloadManager.lZ().h(adResultData)) {
                                    com.kwad.components.ad.splashscreen.monitor.b.mv();
                                    com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, jElapsedRealtime4, jElapsedRealtime3);
                                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                                    com.kwad.components.core.p.a.vL().bQ(1);
                                    adTemplate.splashAdLoadType = 2;
                                    return;
                                }
                                if (SplashPreloadManager.lZ().a(adResultData, true, 1) > 0) {
                                    com.kwad.components.ad.splashscreen.monitor.b.mv();
                                    com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, jElapsedRealtime4, jElapsedRealtime3);
                                    com.kwad.components.core.p.a.vL().bQ(2);
                                    adTemplate.splashAdLoadType = 1;
                                    return;
                                }
                                com.kwad.components.ad.splashscreen.monitor.b.mv();
                                com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, jElapsedRealtime4, jElapsedRealtime3);
                                return;
                            }
                        } catch (Throwable th) {
                            th = th;
                            ksSplashScreenAdControl = z;
                        }
                    }
                    SplashPreloadManager.lZ();
                    if (!SplashPreloadManager.i(adResultData)) {
                        SplashPreloadManager.lZ();
                        if (!SplashPreloadManager.j(adResultData)) {
                            if (b.a(c0636b, adTemplate, jElapsedRealtime4, jElapsedRealtime3, biVar)) {
                                return;
                            }
                            b.a(splashScreenAdListener, (KsSplashScreenAd) ksSplashScreenAdControl, adTemplate, jElapsedRealtime, 2);
                            com.kwad.components.ad.splashscreen.monitor.b.mv();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 8, jElapsedRealtime4, jElapsedRealtime3);
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd live no cache returned");
                            com.kwad.components.core.p.a.vL().bQ(5);
                            return;
                        }
                    }
                    boolean zH = SplashPreloadManager.lZ().h(adResultData);
                    com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd onSuccess " + zH);
                    if (zH) {
                        if (b.a(c0636b, adTemplate, jElapsedRealtime4, jElapsedRealtime3, biVar)) {
                            return;
                        }
                        b.a(splashScreenAdListener, (KsSplashScreenAd) ksSplashScreenAdControl, adTemplate, jElapsedRealtime, 2);
                        com.kwad.components.ad.splashscreen.monitor.b.mv();
                        com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 2, jElapsedRealtime4, jElapsedRealtime3);
                        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd cache returned");
                        com.kwad.components.core.p.a.vL().bQ(1);
                        adTemplate.splashAdLoadType = 2;
                        return;
                    }
                    SplashPreloadManager.lZ();
                    try {
                        if (!SplashPreloadManager.i(adResultData)) {
                            if (c0636b.Gy) {
                                com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
                                return;
                            }
                            b.jk.removeCallbacks(biVar);
                            com.kwad.components.ad.splashscreen.monitor.b.mv();
                            com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 5, jElapsedRealtime4, jElapsedRealtime3);
                            aVar.Gx = true;
                            a(com.kwad.sdk.core.network.e.aTf.errorCode, "请求成功，但缓存未命中", z);
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd no cache returned");
                            com.kwad.components.core.p.a.vL().bQ(3);
                            return;
                        }
                        com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd image returned");
                        int iA2 = SplashPreloadManager.lZ().a(adResultData, true, 1);
                        if (b.a(c0636b, adTemplate, jElapsedRealtime4, jElapsedRealtime3, biVar)) {
                            return;
                        }
                        if (iA2 > 0) {
                            b.a(splashScreenAdListener, (KsSplashScreenAd) ksSplashScreenAdControl, adTemplate, jElapsedRealtime, 2);
                            com.kwad.components.ad.splashscreen.monitor.b.mv();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplate, 3, jElapsedRealtime4, jElapsedRealtime3);
                            com.kwad.components.core.p.a.vL().bQ(2);
                            adTemplate.splashAdLoadType = 1;
                            return;
                        }
                        com.kwad.components.ad.splashscreen.monitor.b.mv();
                        com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 4, jElapsedRealtime4, jElapsedRealtime3);
                        aVar.Gx = true;
                        a(com.kwad.sdk.core.network.e.aTh.errorCode, com.kwad.sdk.core.network.e.aTh.msg, z);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    ksSplashScreenAdControl = z;
                }
                ServiceProvider.reportSdkCaughtException(th);
                a(com.kwad.sdk.core.network.e.aTj.errorCode, com.kwad.sdk.core.network.e.aTj.msg, ksSplashScreenAdControl);
            }
        }).wd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(C0636b c0636b, AdTemplate adTemplate, long j, long j2, Runnable runnable) {
        if (c0636b.Gy) {
            com.kwad.components.ad.splashscreen.monitor.b.mv();
            com.kwad.components.ad.splashscreen.monitor.b.b(adTemplate, 7, j, j2);
            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashAd isTimeOut return ");
            return true;
        }
        jk.removeCallbacks(runnable);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final KsLoadManager.SplashScreenAdListener splashScreenAdListener, final KsSplashScreenAd ksSplashScreenAd, final AdTemplate adTemplate, final long j, final int i) {
        by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.splashscreen.b.4
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                try {
                    KsAdLoadManager.O().a(ksSplashScreenAd);
                    try {
                        com.kwad.sdk.commercial.convert.d.a(com.kwad.sdk.core.response.helper.e.eI(adTemplate), SystemClock.elapsedRealtime() - j, i);
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                    splashScreenAdListener.onSplashScreenAdLoad(ksSplashScreenAd);
                    com.kwad.components.ad.splashscreen.monitor.a.mt().am(adTemplate);
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.c.printStackTrace(th2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(AdResultData adResultData, a aVar, com.kwad.components.core.request.d dVar, boolean z, long j) {
        if (adResultData.getAdTemplateList().size() != 0) {
            return false;
        }
        com.kwad.components.ad.splashscreen.monitor.b.mv();
        com.kwad.components.ad.splashscreen.monitor.b.c(z, com.kwad.sdk.core.network.e.aTe.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aTe.msg : adResultData.testErrorMsg, j);
        aVar.Gx = true;
        dVar.a(com.kwad.sdk.core.network.e.aTe.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aTe.msg : adResultData.testErrorMsg, z);
        com.kwad.components.core.p.a.vL().bQ(3);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(ImpInfo impInfo) {
        final SceneImpl sceneImpl = impInfo.adScene;
        if (TextUtils.isEmpty(sceneImpl.getBidResponse()) && TextUtils.isEmpty(sceneImpl.getBidResponseV2())) {
            com.kwad.components.core.p.a.vL().vO();
            final long jElapsedRealtime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.mv();
            com.kwad.components.ad.splashscreen.monitor.b.y(sceneImpl.posId);
            sceneImpl.setAdStyle(4);
            sceneImpl.setAdNum(5);
            ImpInfo impInfo2 = new ImpInfo(sceneImpl);
            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache ");
            KsAdLoadManager.O().a(new com.kwad.components.core.request.model.a.C0690a().e(impInfo2).aZ(false).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.splashscreen.b.5
                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
                public final void onError(int i, String str) {
                    com.kwad.components.ad.splashscreen.monitor.b.mv();
                    com.kwad.components.ad.splashscreen.monitor.b.b(i, str, sceneImpl.getPosId());
                }

                @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
                public final void b(AdResultData adResultData) {
                    try {
                        if (adResultData.getAdTemplateList().size() > 0) {
                            com.kwad.sdk.core.d.c.d("KsAdSplashScreenLoadManager", "loadSplashScreenCache onSuccess:" + adResultData.getAdTemplateList().size() + " saved " + SplashPreloadManager.lZ().a(adResultData, false, 2));
                            com.kwad.components.ad.splashscreen.monitor.b.mv();
                            com.kwad.components.ad.splashscreen.monitor.b.a(adResultData.getAdTemplateList(), SystemClock.elapsedRealtime() - jElapsedRealtime, sceneImpl.getPosId());
                            com.kwad.components.core.p.a.vL().bR(adResultData.getAdTemplateList().size());
                        }
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                }
            }).wd());
        }
    }
}
