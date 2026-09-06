package com.kwad.components.core.innerEc;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.webkit.WebView;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.offline.api.adInnerEc.login.IAdInnerEcLoginBindListener;
import com.kwad.components.offline.api.core.adInnerEc.ExternalExitListener;
import com.kwad.components.offline.api.core.adInnerEc.IAdInnerEcExternalModule;
import com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.IHostLivePlayer;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.ILiveBindOwner;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.ILivePluginProvider;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.model.PBHelper;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.au;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.bz;
import com.kwad.sdk.wrapper.m;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class f {
    private static IAdInnerEcExternalModule SZ;
    private static PBHelper Ta;

    public static void init() {
        b(com.kwad.sdk.core.c.b.LW().getApplication());
    }

    public static boolean aK(AdTemplate adTemplate) {
        int iEy = com.kwad.sdk.core.response.helper.b.ey(adTemplate);
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (com.kwad.sdk.core.response.helper.a.cZ(adInfoEO)) {
            if (!com.kwad.sdk.core.response.helper.a.dG(adInfoEO) || !com.kwad.components.core.innerEc.live.b.ru()) {
                return false;
            }
        } else if (!com.kwad.sdk.core.response.helper.a.dG(adInfoEO)) {
            return false;
        }
        return com.kwad.components.core.innerEc.local.a.bo(iEy);
    }

    public static WebView a(Activity activity, YodaWebPageListener yodaWebPageListener, ExternalExitListener externalExitListener) {
        IAdInnerEcExternalModule iAdInnerEcExternalModuleB = b(activity.getApplication());
        if (iAdInnerEcExternalModuleB != null) {
            return iAdInnerEcExternalModuleB.createYodaWebViewAndInit(activity, yodaWebPageListener, externalExitListener);
        }
        return null;
    }

    public static IHostLivePlayer a(Application application, String str) {
        com.kwad.sdk.core.d.c.d("SdkInnerECWrapper", "createFullLivePlayer dataKey: " + str);
        IAdInnerEcExternalModule iAdInnerEcExternalModuleB = b(application);
        if (iAdInnerEcExternalModuleB == null) {
            return null;
        }
        IHostLivePlayer iHostLivePlayerCreateLivePlayer = iAdInnerEcExternalModuleB.createLivePlayer(str);
        com.kwad.sdk.core.d.c.d("SdkInnerECWrapper", "createFullLivePlayer player: " + iHostLivePlayerCreateLivePlayer);
        return iHostLivePlayerCreateLivePlayer;
    }

    public static ILiveBindOwner a(Application application, String str, String str2, ILivePluginProvider iLivePluginProvider) {
        IAdInnerEcExternalModule iAdInnerEcExternalModuleB = b(application);
        if (iAdInnerEcExternalModuleB != null) {
            return iAdInnerEcExternalModuleB.createLiveBindOwner(str, str2, iLivePluginProvider);
        }
        return null;
    }

    public static PBHelper ri() {
        PBHelper pBHelper = Ta;
        if (pBHelper != null) {
            return pBHelper;
        }
        IAdInnerEcExternalModule iAdInnerEcExternalModuleB = b(com.kwad.sdk.core.c.b.LW().getApplication());
        if (iAdInnerEcExternalModuleB != null) {
            Ta = iAdInnerEcExternalModuleB.createPBPaser();
        }
        return Ta;
    }

    public static void b(Application application, String str) {
        IAdInnerEcExternalModule iAdInnerEcExternalModuleB = b(application);
        com.kwad.sdk.core.d.c.d("SdkInnerECWrapper", "initEmotionSdk module: " + iAdInnerEcExternalModuleB);
        if (iAdInnerEcExternalModuleB != null) {
            iAdInnerEcExternalModuleB.initEmotionSdk(str);
            iAdInnerEcExternalModuleB.loadData(true);
        }
    }

    public static int a(Context context, final AdTemplate adTemplate, final com.kwad.components.core.e.d.a.C0661a c0661a) {
        com.kwad.sdk.core.d.c.d("SdkInnerECWrapper", "handleUserAuthCheck call");
        int iAw = aw(context);
        if (iAw != 0) {
            if (adTemplate != null) {
                adTemplate.setHasInnerEcFailed(true);
            }
            com.kwad.components.core.innerEc.logger.a.h(adTemplate, iAw);
            return 3;
        }
        if (e.rf().rg()) {
            com.kwad.sdk.core.d.c.d("SdkInnerECWrapper", "handleUserAuthCheck hasUserLogin");
            com.kwad.components.core.innerEc.logger.a.aQ(adTemplate);
            return 2;
        }
        int iAv = av(context);
        if (iAv != 0) {
            com.kwad.sdk.core.d.c.d("SdkInnerECWrapper", "auth env check failed: " + iAv);
            if (adTemplate != null) {
                adTemplate.setHasInnerEcFailed(true);
            }
            com.kwad.sdk.core.adlog.c.a(adTemplate, iAv == 3001 ? "kwai_app_not_support" : "appid_empty", "app", 0);
            return 3;
        }
        com.kwad.components.core.innerEc.logger.a.aR(adTemplate);
        a(context, adTemplate, c0661a, new com.kwad.components.core.innerEc.a.a() { // from class: com.kwad.components.core.innerEc.f.1
            @Override // com.kwad.components.core.innerEc.a.a
            public final void rn() {
                AdTemplate adTemplate2 = adTemplate;
                if (adTemplate2 != null) {
                    adTemplate2.setHasInnerEcFailed(true);
                }
                by.runOnUiThread(new bi() { // from class: com.kwad.components.core.innerEc.f.1.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        f.G(c0661a);
                    }
                });
            }

            @Override // com.kwad.components.core.innerEc.a.a
            public final void oW() {
                com.kwad.components.core.e.d.a.C0661a c0661a2 = c0661a;
                if (c0661a2 != null) {
                    c0661a2.aC(true);
                }
                by.runOnUiThread(new bi() { // from class: com.kwad.components.core.innerEc.f.1.2
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        f.G(c0661a);
                    }
                });
            }
        });
        return 1;
    }

    private static int av(Context context) {
        String strRl = rl();
        boolean zAx = ax(context);
        boolean z = !TextUtils.isEmpty(strRl);
        if (zAx && z) {
            return 0;
        }
        return z ? 3001 : 3000;
    }

    private static void a(final Context context, final AdTemplate adTemplate, final com.kwad.components.core.e.d.a.C0661a c0661a, final com.kwad.components.core.innerEc.a.a aVar) {
        com.kwad.sdk.core.d.c.d("SdkInnerECWrapper", "startAuthPage call");
        final String strRl = rl();
        com.kwad.sdk.core.d.c.d("SdkInnerECWrapper", "startAuthPage startLoginWithKwaiClient");
        com.kwad.components.core.innerEc.logger.a.i(adTemplate, "app");
        e.rf().a(m.getActivityFromContext(context), new IAdInnerEcLoginBindListener() { // from class: com.kwad.components.core.innerEc.f.2
            @Override // com.kwad.components.offline.api.adInnerEc.login.IAdInnerEcLoginBindListener
            public final void onSuccess(String str, final int i) {
                com.kwad.sdk.core.d.c.d("SdkInnerECWrapper", "startAuthPage startAuthPage onSuccess");
                com.kwad.components.core.innerEc.logger.a.j(adTemplate, "app");
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                e.rf();
                e.b(str, new c() { // from class: com.kwad.components.core.innerEc.f.2.1
                    @Override // com.kwad.components.core.innerEc.c
                    public final void a(InnerEcUserLoginBindInfo innerEcUserLoginBindInfo) {
                        com.kwad.sdk.core.d.c.d("SdkInnerECWrapper", "startAuthPage startCodebind onSuccess");
                        com.kwad.components.core.innerEc.logger.a.k(adTemplate, "app");
                        com.kwad.sdk.core.adlog.c.a(adTemplate, "success", "app", i);
                        com.kwad.components.core.innerEc.local.a.aQ("app");
                        e.rf().b(innerEcUserLoginBindInfo);
                        adTemplate.isDoAuth = true;
                        com.kwad.components.core.innerEc.qcpx.b.h(context, adTemplate);
                        if (com.kwad.sdk.core.response.helper.e.fm(adTemplate)) {
                            com.kwad.components.core.innerEc.live.b.c(com.kwad.sdk.core.c.b.LW().getApplication());
                            com.kwad.components.core.innerEc.live.b.b(context, adTemplate, c0661a);
                        } else {
                            f.g(context, adTemplate);
                        }
                    }

                    @Override // com.kwad.components.core.innerEc.c
                    public final void rc() {
                        com.kwad.sdk.core.d.c.d("SdkInnerECWrapper", "startAuthPage startCode bind onFail");
                        com.kwad.sdk.core.adlog.c.a(adTemplate, "fail", "app", i);
                        aVar.rn();
                        com.kwad.components.core.innerEc.logger.a.f(adTemplate, 2001, "fail");
                        com.kwad.components.core.innerEc.local.a.f(adTemplate, "app");
                    }
                }, strRl);
            }

            @Override // com.kwad.components.offline.api.adInnerEc.login.IAdInnerEcLoginBindListener
            public final void onFailed(int i, String str, int i2) {
                if (i != 10002) {
                    com.kwad.sdk.core.adlog.c.a(adTemplate, "fail", "app", i2);
                    com.kwad.components.core.innerEc.local.a.f(adTemplate, "app");
                    aVar.rn();
                    com.kwad.components.core.innerEc.logger.a.f(adTemplate, 2000, "errorCode=" + i + ",errorMsg=" + str);
                    return;
                }
                onCancel(false, i2);
            }

            @Override // com.kwad.components.offline.api.adInnerEc.login.IAdInnerEcLoginBindListener
            public final void onCancel(boolean z, int i) {
                com.kwad.sdk.core.adlog.c.a(adTemplate, "reject", "app", i);
                com.kwad.components.core.innerEc.local.a.g(adTemplate, "app");
                aVar.oW();
                com.kwad.components.core.innerEc.logger.a.h(adTemplate, "app");
            }
        }, rl());
    }

    public static void g(Context context, AdTemplate adTemplate) {
        AdWebViewActivityProxy.launch(context, new AdWebViewActivityProxy.a.C0680a().aZ(com.kwad.sdk.core.response.helper.b.dm(adTemplate)).aY(adTemplate).bv(2).ua());
    }

    public static boolean a(String str, final c cVar) {
        Uri uri;
        if (TextUtils.isEmpty(com.kwad.sdk.core.config.e.KU()) || !str.contains(com.kwad.sdk.core.config.e.KU()) || (uri = Uri.parse(str)) == null) {
            return false;
        }
        String queryParameter = uri.getQueryParameter("code");
        if (!TextUtils.isEmpty(queryParameter)) {
            e.rf();
            e.b(queryParameter, new c() { // from class: com.kwad.components.core.innerEc.f.3
                @Override // com.kwad.components.core.innerEc.c
                public final void a(InnerEcUserLoginBindInfo innerEcUserLoginBindInfo) {
                    e.rf().b(innerEcUserLoginBindInfo);
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.a(innerEcUserLoginBindInfo);
                    }
                }

                @Override // com.kwad.components.core.innerEc.c
                public final void rc() {
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.rc();
                    }
                }
            }, com.kwad.sdk.core.config.e.KS());
            return true;
        }
        return false;
    }

    public static void a(Activity activity, String str, String str2, ResultReceiver resultReceiver) {
        IAdInnerEcExternalModule iAdInnerEcExternalModuleB = b(activity.getApplication());
        if (iAdInnerEcExternalModuleB != null) {
            iAdInnerEcExternalModuleB.startPay(activity, str, str2, resultReceiver);
        }
    }

    public static CharSequence a(Application application, CharSequence charSequence, float f) {
        IAdInnerEcExternalModule iAdInnerEcExternalModuleB = b(application);
        com.kwad.sdk.core.d.c.d("SdkInnerECWrapper", "generateBasicEmoji module is:" + iAdInnerEcExternalModuleB);
        if (iAdInnerEcExternalModuleB != null) {
            return iAdInnerEcExternalModuleB.generateBasicEmoji(charSequence, f);
        }
        return null;
    }

    public static Map<String, String> rj() {
        if (!e.rf().rg()) {
            com.kwad.sdk.core.d.c.w("SdkInnerECWrapper", "obtainEcModule user not login");
            return null;
        }
        IAdInnerEcExternalModule iAdInnerEcExternalModuleB = b(com.kwad.sdk.core.c.b.LW().getApplication());
        if (iAdInnerEcExternalModuleB == null) {
            com.kwad.sdk.core.d.c.w("SdkInnerECWrapper", "obtainEcModule is null");
            return null;
        }
        return iAdInnerEcExternalModuleB.getCurrentCookieMap();
    }

    private static IAdInnerEcExternalModule b(Application application) {
        IAdInnerEcExternalModule iAdInnerEcExternalModule = SZ;
        if (iAdInnerEcExternalModule != null) {
            return iAdInnerEcExternalModule;
        }
        com.kwad.components.core.offline.a.a.a aVar = (com.kwad.components.core.offline.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.a.a.class);
        com.kwad.sdk.core.d.c.w("SdkInnerECWrapper", "adInnerEcComponents is: " + aVar);
        if (aVar == null && com.kwad.components.core.a.pe.booleanValue()) {
            ae.c((Context) application, "电商闭环离线组件未安装成功", 0);
            return null;
        }
        if (aVar != null) {
            com.kwad.sdk.core.d.c.w("SdkInnerECWrapper", "adInnerEcComponents hasInnerEcCompoReady: " + aVar.tr());
        }
        if (aVar == null) {
            com.kwad.sdk.core.d.c.w("SdkInnerECWrapper", " adInnerEcComponents is return null");
            return null;
        }
        IAdInnerEcExternalModule iAdInnerEcExternalModuleTs = aVar.ts();
        if (iAdInnerEcExternalModuleTs == null) {
            com.kwad.sdk.core.d.c.w("SdkInnerECWrapper", " getExternalComponents is return null");
            return null;
        }
        com.kwad.components.core.offline.b.a.a aVar2 = new com.kwad.components.core.offline.b.a.a();
        iAdInnerEcExternalModuleTs.setDebug(com.kwad.components.core.a.pe.booleanValue());
        try {
            com.kwad.sdk.core.d.c.d("SdkInnerECWrapper", "obtainEcModule setAdInnerEcHostProvider call " + aVar2.getApp());
            iAdInnerEcExternalModuleTs.setAdInnerEcHostProvider(aVar2);
            iAdInnerEcExternalModuleTs.initModule();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.w("SdkInnerECWrapper", "initModule error: " + th.getMessage());
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        SZ = iAdInnerEcExternalModuleTs;
        rk();
        return iAdInnerEcExternalModuleTs;
    }

    private static void rk() {
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.a(new a() { // from class: com.kwad.components.core.innerEc.f.4
            @Override // com.kwad.components.core.innerEc.a, com.kwad.sdk.core.c.c
            /* JADX INFO: renamed from: onActivityPaused */
            public final void c(Activity activity) {
                super.c(activity);
                if (f.SZ != null) {
                    f.SZ.onActivityPaused(activity);
                }
            }

            @Override // com.kwad.components.core.innerEc.a, com.kwad.sdk.core.c.c
            /* JADX INFO: renamed from: onActivityResumed */
            public final void d(Activity activity) {
                super.d(activity);
                if (f.SZ != null) {
                    f.SZ.onActivityResumed(activity);
                }
            }

            @Override // com.kwad.components.core.innerEc.a, com.kwad.sdk.core.c.c
            /* JADX INFO: renamed from: onActivityDestroyed */
            public final void b(Activity activity) {
                super.b(activity);
                if (f.SZ != null) {
                    f.SZ.onActivityDestroyed(activity);
                }
            }

            @Override // com.kwad.components.core.innerEc.a, com.kwad.sdk.core.c.c
            /* JADX INFO: renamed from: onActivityStopped */
            public final void f(Activity activity) {
                super.b(activity);
                if (f.SZ != null) {
                    f.SZ.onActivityStopped(activity);
                }
            }
        });
    }

    private static String rl() {
        return (String) com.kwad.sdk.core.config.e.b(com.kwad.sdk.core.config.c.aQB);
    }

    private static int aw(Context context) {
        try {
            com.kwad.components.core.offline.a.a.a aVar = (com.kwad.components.core.offline.a.a.a) com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.a.a.class);
            if (aVar != null && aVar.tr()) {
                boolean z = true;
                boolean z2 = !TextUtils.isEmpty(rl()) && (au.dG(context) || au.dH(context));
                if (TextUtils.isEmpty(com.kwad.sdk.core.config.e.KR()) || TextUtils.isEmpty(com.kwad.sdk.core.config.e.KS()) || TextUtils.isEmpty(com.kwad.sdk.core.config.e.KU())) {
                    z = false;
                }
                if (!z2 && !z) {
                    return 1001;
                }
                e.rf();
                return !e.isReady() ? 1002 : 0;
            }
            return 1000;
        } catch (Throwable th) {
            com.kwad.sdk.crash.b.u(th);
            return 1003;
        }
    }

    public static int G(com.kwad.components.core.e.d.a.C0661a c0661a) {
        if (c0661a.getAdTemplate().hasInnerEcFailed() || c0661a.qk()) {
            return com.kwad.components.core.e.d.a.a(c0661a);
        }
        return 14;
    }

    private static boolean ax(Context context) {
        int iDI = au.dI(context);
        int iDJ = au.dJ(context);
        boolean zAE = bz.aE(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion(), "4.10.30");
        if (iDI == 0 && iDJ == 0) {
            return false;
        }
        if (iDI == 1 && zAE) {
            return false;
        }
        return (iDI == 0 && iDJ == 1 && zAE) ? false : true;
    }
}
