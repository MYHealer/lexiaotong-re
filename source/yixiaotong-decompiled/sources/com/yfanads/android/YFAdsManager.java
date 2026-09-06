package com.yfanads.android;

import android.app.Application;
import android.content.Context;
import com.stub.StubApp;
import com.yfanads.android.callback.BaseEnsureListener;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.lifecycle.DialogManager;
import com.yfanads.android.lifecycle.LifecycleObserver;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ReflectionUtils;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class YFAdsManager {
    private Application application;
    private YFAdsConfig fcAdsConfig;
    boolean isInit;

    public static /* synthetic */ class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final YFAdsManager f9561a = new YFAdsManager(null);
    }

    public /* synthetic */ YFAdsManager(a aVar) {
        this();
    }

    public static YFAdsManager getInstance() {
        return b.f9561a;
    }

    private void setParams(Application application, YFAdsConfig yFAdsConfig) {
        this.application = application;
        this.fcAdsConfig = yFAdsConfig;
    }

    public boolean clearCache() {
        if (!isInitSuc()) {
            YFLog.error("sdk has not init, return false");
            return false;
        }
        YFAdsConst.AdSource adSource = YFAdsConst.AdSource.KS;
        if (!InitUtils.hasImpSDK(adSource.channel)) {
            return false;
        }
        YFLog.high("has sdk. start clear");
        return ReflectionUtils.clearCache(adSource.className, "deleteCache");
    }

    public Application getApplication() {
        return this.application;
    }

    public YFAdsConfig getYFAdsConfig() {
        return this.fcAdsConfig;
    }

    public void init(final Application application, final YFAdsConfig yFAdsConfig) {
        YFLog.info("init start ");
        if (application == null || yFAdsConfig == null) {
            YFLog.error("init start application == null || fcAdsConfig == null");
            throw new RuntimeException("this FCAdsConfig class is not null");
        }
        YFLog.info("init start appId:" + yFAdsConfig.getAppId());
        if (!isInitSuc()) {
            YFUtil.switchMainThread("initSdk", new BaseEnsureListener() { // from class: com.yfanads.android.YFAdsManager$$ExternalSyntheticLambda0
                @Override // com.yfanads.android.callback.BaseEnsureListener
                public final void ensure() {
                    this.f$0.m1177lambda$init$0$comyfanadsandroidYFAdsManager(application, yFAdsConfig);
                }
            });
            return;
        }
        if (getYFAdsConfig() != null) {
            getYFAdsConfig().setAppId(yFAdsConfig.getAppId());
        } else {
            setParams(application, yFAdsConfig);
        }
        YFLog.info("it's init success, return.");
    }

    public boolean isInitSuc() {
        return this.isInit;
    }

    /* JADX INFO: renamed from: lambda$init$0$com-yfanads-android-YFAdsManager, reason: not valid java name */
    void m1177lambda$init$0$comyfanadsandroidYFAdsManager(Application application, YFAdsConfig yFAdsConfig) {
        setParams(application, yFAdsConfig);
        com.yfanads.android.b bVar = com.yfanads.android.b.a.f9633a;
        bVar.getClass();
        long jCurrentTimeMillis = System.currentTimeMillis();
        bVar.c = Util.getRandomUuid();
        synchronized (bVar) {
            bVar.b = 2;
        }
        InitUtils.initCache();
        YFLog.traceDebug("sdk start " + bVar.c);
        LifecycleObserver.getInstance().init(application);
        DialogManager.init(application);
        UrlConst.init(getInstance().getContext().getSharedPreferences("adsConfig", 0).getString("api", ""), getInstance().getContext().getSharedPreferences("adsConfig", 0).getString(UrlConst.TRACKER, ""));
        boolean z = com.yfanads.android.upload.b.e;
        com.yfanads.android.upload.b bVar2 = com.yfanads.android.upload.b.a.f9685a;
        String str = bVar.c;
        bVar2.getClass();
        try {
            bVar2.b = InitUtils.getElun();
            com.yfanads.android.upload.b.e = InitUtils.isEventOpen();
            YFLog.traceDebug("init report " + bVar2.b + " start req:" + str);
            bVar2.b();
            YFLog.traceDebug("init report success req:" + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ViewUtils.init(application);
        getInstance().isInit = true;
        bVar.b(application, bVar.c, yFAdsConfig.getDevOaid(), jCurrentTimeMillis);
    }

    private YFAdsManager() {
        this.isInit = false;
    }

    public Context getContext() {
        Application application = this.application;
        if (application != null) {
            return StubApp.getOrigApplicationContext(application.getApplicationContext());
        }
        YFLog.info("[init] Application is null, attempting to recover context");
        Application applicationRecoverApplication = YFUtil.recoverApplication();
        if (applicationRecoverApplication != null) {
            this.application = applicationRecoverApplication;
            return StubApp.getOrigApplicationContext(applicationRecoverApplication.getApplicationContext());
        }
        YFLog.info("[init] All context recovery attempts failed. SDK must be properly initialized.");
        return null;
    }
}
