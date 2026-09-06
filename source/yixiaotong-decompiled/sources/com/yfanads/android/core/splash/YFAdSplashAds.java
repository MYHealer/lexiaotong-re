package com.yfanads.android.core.splash;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.stub.StubApp;
import com.yfanads.android.callback.AdsSpotCallback;
import com.yfanads.android.callback.BaseEnsureListener;
import com.yfanads.android.core.i;
import com.yfanads.android.core.shop.YFAdShopMallAds;
import com.yfanads.android.core.shop.YFShopMallListener;
import com.yfanads.android.libs.AbsCallback;
import com.yfanads.android.lifecycle.LifecycleListener;
import com.yfanads.android.lifecycle.LifecycleObserver;
import com.yfanads.android.model.BindInfo;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFAdType;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFAdSplashAds extends i implements YFSplashSetting {
    private static final String shopMallTag = "YFAdShopMallAds";
    private static final String tag = "YFAdInterstitialAds";
    private View bottomView;
    private final Context context;
    private boolean isCustom;
    private boolean isShopMallLoadFail;
    private YFAdShopMallAdsLifecycleListener lifecycleListener;
    private YFSplashListener listener;
    private YFAdShopMallAds shopMallAds;
    private String showActivityName;
    private String showShopMallActivityName;
    private int[] wSize;

    public static class YFAdShopMallAdsLifecycleListener extends AbsCallback<YFAdSplashAds> implements LifecycleListener {
        private final String showActivityName;

        public YFAdShopMallAdsLifecycleListener(YFAdSplashAds yFAdSplashAds, String str) {
            super(yFAdSplashAds);
            this.showActivityName = str;
        }

        @Override // com.yfanads.android.lifecycle.LifecycleListener
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // com.yfanads.android.lifecycle.LifecycleListener
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // com.yfanads.android.lifecycle.LifecycleListener
        public void onActivityPaused(Activity activity) {
        }

        @Override // com.yfanads.android.lifecycle.LifecycleListener
        public void onActivityResumed(Activity activity) {
            YFLog.high("YFAdShopMallAds onActivityResumed " + (activity != null ? activity.getLocalClassName() : "") + "|" + this.showActivityName);
            if (get() != null) {
                get().showShopMallAds(activity);
            }
        }

        @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
        public void onBackToBackground() {
        }

        @Override // com.yfanads.android.lifecycle.AbsLifecycleListener
        public void onBackToForeground() {
        }
    }

    public static class YFAdShopMallListener extends AbsCallback<YFAdSplashAds> implements YFShopMallListener {
        public YFAdShopMallListener(YFAdSplashAds yFAdSplashAds) {
            super(yFAdSplashAds);
        }

        @Override // com.yfanads.android.callback.BaseAdListener
        public void onAdClicked() {
            YFLog.high("YFAdShopMallAds onAdClicked ");
        }

        @Override // com.yfanads.android.callback.BaseAdListener
        public void onAdClosed() {
            YFLog.high("YFAdShopMallAds onAdClosed ");
            if (get() != null) {
                get().onShopMallClosed();
            }
        }

        @Override // com.yfanads.android.callback.BaseAdListener
        public void onAdExposure() {
            YFLog.high("YFAdShopMallAds onAdExposure ");
            if (get() != null) {
                get().unRegisterLifecycleListener();
            }
        }

        @Override // com.yfanads.android.callback.BaseAdListener
        public void onAdFailed(YFAdError yFAdError) {
            YFLog.high("YFAdShopMallAds yfAdError " + yFAdError);
            if (get() != null) {
                get().onShopMallFailed();
            }
        }

        @Override // com.yfanads.android.callback.BaseAdListener
        public void onAdRenderFailed() {
            YFLog.high("YFAdShopMallAds onAdRenderFailed ");
            if (get() != null) {
                get().unRegisterLifecycleListener();
            }
        }

        @Override // com.yfanads.android.callback.BaseAdListener
        public void onAdSuccess() {
            Activity currentActivity = LifecycleObserver.getInstance().getCurrentActivity();
            YFLog.high("YFAdShopMallAds onAdSuccess " + (currentActivity != null ? currentActivity.getLocalClassName() : ""));
            if (get() != null) {
                get().showShopMallAds(currentActivity);
            }
        }
    }

    public YFAdSplashAds(Context context, YFSplashListener yFSplashListener) {
        super(context, yFSplashListener);
        this.wSize = new int[]{0, 0};
        this.isShopMallLoadFail = false;
        this.listener = yFSplashListener;
        this.context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        try {
            setAdType(YFAdType.SPLASH);
            this.wSize = ScreenUtil.getScreenSize(context, true);
        } catch (Throwable th) {
            YFLog.error("YFAdSplashAds init error " + th.getMessage());
        }
    }

    private void handleShopMallAds(String str) {
        YFLog.high("YFAdShopMallAds adId:" + str + " aType:" + getAType());
        if (getAType() != YFAdType.SPLASH.getValue()) {
            return;
        }
        Map<String, Object> ads = InitUtils.getAds();
        if (ads == null || !ads.containsKey(str)) {
            YFLog.high("YFAdShopMallAds tpId is null");
            return;
        }
        final String str2 = (String) ads.get(str);
        YFUtil.switchMainThread(tag, new BaseEnsureListener() { // from class: com.yfanads.android.core.splash.YFAdSplashAds$$ExternalSyntheticLambda0
            @Override // com.yfanads.android.callback.BaseEnsureListener
            public final void ensure() {
                this.f$0.m1219xa781a0b(str2);
            }
        });
        YFLog.high("YFAdShopMallAds tpId is " + str2);
    }

    private boolean isShowShopMallAds(String str) {
        if (TextUtils.isEmpty(this.showShopMallActivityName)) {
            return (TextUtils.isEmpty(this.showActivityName) || this.showActivityName.equals(str) || YFAdsConst.isInWhiteList(str)) ? false : true;
        }
        return str.endsWith(this.showShopMallActivityName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showShopMallAds(Activity activity) {
        if (activity == null) {
            YFLog.error("YFAdShopMallAds showShopMallAds activity is null");
            return;
        }
        if (!isShowShopMallAds(activity.getLocalClassName())) {
            YFLog.debug("YFAdShopMallAds showShopMallAds activity is not show");
        } else if (isSupportShopMall() && this.shopMallAds.isReady()) {
            YFLog.debug("YFAdShopMallAds showShopMallAds is " + activity.getLocalClassName());
            this.shopMallAds.showAds(activity);
            unRegisterLifecycleListener();
        }
    }

    private void waitForShopMall(Activity activity) {
        this.showActivityName = activity != null ? activity.getLocalClassName() : "";
        this.lifecycleListener = new YFAdShopMallAdsLifecycleListener(this, this.showActivityName);
        LifecycleObserver.getInstance().registerLifecycleListener(this.lifecycleListener);
    }

    @Override // com.yfanads.android.core.i, com.yfanads.android.callback.AdCoreAction
    public void destroy() {
        super.destroy();
        if (this.listener != null) {
            this.listener = null;
        }
    }

    @Override // com.yfanads.android.core.i
    public int getAType() {
        return 1;
    }

    @Override // com.yfanads.android.core.splash.YFSplashSetting
    public View getBottomView() {
        return this.bottomView;
    }

    @Override // com.yfanads.android.core.splash.YFSplashSetting
    public int[] getSize() {
        return this.wSize;
    }

    @Override // com.yfanads.android.core.splash.YFSplashSetting
    public boolean isCustom() {
        return this.isCustom;
    }

    @Override // com.yfanads.android.core.i
    public boolean isSupportShopMall() {
        return (this.shopMallAds == null || this.isShopMallLoadFail) ? false : true;
    }

    /* JADX INFO: renamed from: lambda$showAds$1$com-yfanads-android-core-splash-YFAdSplashAds, reason: not valid java name */
    /* synthetic */ void m1220lambda$showAds$1$comyfanadsandroidcoresplashYFAdSplashAds(Activity activity, ViewGroup viewGroup) {
        super.showAds(activity, viewGroup);
    }

    /* JADX INFO: renamed from: lambda$startLoad$0$com-yfanads-android-core-splash-YFAdSplashAds, reason: not valid java name */
    /* synthetic */ void m1221lambda$startLoad$0$comyfanadsandroidcoresplashYFAdSplashAds(String str, BindInfo bindInfo) {
        YFLog.debug("loadResult adId:" + str);
        handleShopMallAds(str);
    }

    public void setBottomView(View view) {
        this.bottomView = view;
    }

    public void setHeight(int i) {
        if (i == 0) {
            YFLog.debug("YFAdSplashAds set 0, auto");
            return;
        }
        this.isCustom = true;
        double d = i;
        int i2 = this.wSize[1];
        if (d < ((double) i2) * 0.75d) {
            YFLog.debug("YFAdSplashAds setHeight is low 75%, fix it");
            i = (int) (((double) this.wSize[1]) * 0.75d);
        } else if (i > i2) {
            YFLog.debug("YFAdSplashAds setHeight is high, fix it");
            i = this.wSize[1];
        }
        this.wSize[1] = i;
        YFLog.debug("YFAdSplashAds setHeight -- " + i);
    }

    public void setWidth(int i) {
        if (i == 0) {
            YFLog.high("set 0, auto");
            return;
        }
        this.isCustom = true;
        double d = i;
        int i2 = this.wSize[0];
        if (d < ((double) i2) * 0.75d) {
            YFLog.debug("YFAdSplashAds setWidth is low 75%, fix it");
            i = (int) (((double) this.wSize[0]) * 0.75d);
        } else if (i > i2) {
            YFLog.debug("YFAdSplashAds setWidth is high, fix it");
            i = this.wSize[0];
        }
        this.wSize[0] = i;
        YFLog.debug("YFAdSplashAds setWidth -- " + i);
    }

    @Override // com.yfanads.android.core.i
    public void showAds(final Activity activity, final ViewGroup viewGroup) {
        try {
            YFLog.high("YFAdInterstitialAds showAds ");
            viewGroup.post(new Runnable() { // from class: com.yfanads.android.core.splash.YFAdSplashAds$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1220lambda$showAds$1$comyfanadsandroidcoresplashYFAdSplashAds(activity, viewGroup);
                }
            });
            if (isSupportShopMall()) {
                waitForShopMall(activity);
            }
        } catch (Exception e) {
            YFLog.high("YFAdSplashAds showAds error " + e.getMessage());
        }
    }

    @Override // com.yfanads.android.core.i
    /* JADX INFO: renamed from: startLoad */
    public void m1209lambda$loadOnly$4$comyfanadsandroidcorei(final String str) {
        setAdsSpotCallback(new AdsSpotCallback() { // from class: com.yfanads.android.core.splash.YFAdSplashAds$$ExternalSyntheticLambda1
            @Override // com.yfanads.android.callback.AdsSpotCallback
            public final void loadResult(BindInfo bindInfo) {
                this.f$0.m1221lambda$startLoad$0$comyfanadsandroidcoresplashYFAdSplashAds(str, bindInfo);
            }
        });
        super.m1209lambda$loadOnly$4$comyfanadsandroidcorei(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onShopMallClosed() {
        YFAdShopMallAds yFAdShopMallAds = this.shopMallAds;
        if (yFAdShopMallAds != null) {
            yFAdShopMallAds.destroy();
        }
        unRegisterLifecycleListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onShopMallFailed() {
        this.isShopMallLoadFail = true;
        unRegisterLifecycleListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: startShopMallAds, reason: merged with bridge method [inline-methods] */
    public void m1219xa781a0b(String str) {
        YFAdShopMallAds yFAdShopMallAds = this.shopMallAds;
        if (yFAdShopMallAds != null) {
            yFAdShopMallAds.destroy();
        }
        YFAdShopMallAds yFAdShopMallAds2 = new YFAdShopMallAds(this.context, new YFAdShopMallListener(this));
        this.shopMallAds = yFAdShopMallAds2;
        yFAdShopMallAds2.loadOnly(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegisterLifecycleListener() {
        if (this.lifecycleListener != null) {
            LifecycleObserver.getInstance().unRegisterLifecycleListener(this.lifecycleListener);
        }
    }

    @Override // com.yfanads.android.core.i
    public void onAdFailed(YFAdError yFAdError) {
        YFSplashListener yFSplashListener = this.listener;
        if (yFSplashListener != null) {
            yFSplashListener.onAdFailed(yFAdError);
        }
    }

    public void setShopMallActivityName(String str) {
        this.showShopMallActivityName = str;
        YFLog.high("YFAdInterstitialAds setShopMallActivityName is " + str);
    }
}
