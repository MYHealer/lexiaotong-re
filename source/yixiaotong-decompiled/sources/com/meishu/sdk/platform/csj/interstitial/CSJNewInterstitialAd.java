package com.meishu.sdk.platform.csj.interstitial;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.byazt.nys.PluginConstants;
import com.bytedance.sdk.openadsdk.TTFullScreenVideoAd;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.interstitial.InterstitialAd;
import com.meishu.sdk.core.ad.interstitial.b;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.meishu_ad.lifecycle.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJNewInterstitialAd extends InterstitialAd {
    private static final String TAG = "CSJNewInterstitialAd";
    private TTFullScreenVideoAd ad;
    private b adListener;
    private CSJInterstitialAdWrapper adWrapper;
    private boolean isClick;
    private Application.ActivityLifecycleCallbacks lifecycleCallbacks;
    private c lifecycleHelper;

    public CSJNewInterstitialAd(CSJInterstitialAdWrapper cSJInterstitialAdWrapper, b bVar, TTFullScreenVideoAd tTFullScreenVideoAd) {
        super(cSJInterstitialAdWrapper, MSAdConfig.PLATFORM_CSJ);
        this.lifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.meishu.sdk.platform.csj.interstitial.CSJNewInterstitialAd.1
            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                try {
                    LogUtil.e(CSJNewInterstitialAd.TAG, "onActivityPaused,className=" + activity.getComponentName().getClassName() + ",isClick=" + CSJNewInterstitialAd.this.isClick);
                    if (!activity.getComponentName().getClassName().equals(PluginConstants.STUB_STANDARD_PORTRAIT_ACTIVITY_T) || CSJNewInterstitialAd.this.isClick) {
                        CSJNewInterstitialAd.this.isClick = false;
                    } else {
                        activity.finish();
                        activity.getApplication().unregisterActivityLifecycleCallbacks(CSJNewInterstitialAd.this.lifecycleCallbacks);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
            }
        };
        this.adWrapper = cSJInterstitialAdWrapper;
        this.adListener = bVar;
        this.ad = tTFullScreenVideoAd;
    }

    public void setClick() {
        this.isClick = true;
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd() {
        CSJInterstitialAdWrapper cSJInterstitialAdWrapper;
        try {
            if (this.adWrapper.getContext() != null) {
                if (AdSdk.adConfig().getEnableInterstitialAutoClose()) {
                    ((Activity) this.adWrapper.getContext()).getApplication().registerActivityLifecycleCallbacks(this.lifecycleCallbacks);
                }
                TTFullScreenVideoAd tTFullScreenVideoAd = this.ad;
                if (tTFullScreenVideoAd != null && (cSJInterstitialAdWrapper = this.adWrapper) != null) {
                    tTFullScreenVideoAd.showFullScreenVideoAd((Activity) cSJInterstitialAdWrapper.getContext());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        super.showAd();
    }

    @Override // com.meishu.sdk.core.ad.interstitial.InterstitialAd
    public void showAd(Activity activity) {
        if (activity != null) {
            try {
                if (AdSdk.adConfig().getEnableInterstitialAutoClose()) {
                    activity.getApplication().registerActivityLifecycleCallbacks(this.lifecycleCallbacks);
                }
                TTFullScreenVideoAd tTFullScreenVideoAd = this.ad;
                if (tTFullScreenVideoAd != null && this.adWrapper != null) {
                    tTFullScreenVideoAd.showFullScreenVideoAd(activity);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        super.showAd(activity);
    }
}
