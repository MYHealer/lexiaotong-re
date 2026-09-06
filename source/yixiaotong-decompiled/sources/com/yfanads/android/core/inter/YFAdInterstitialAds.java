package com.yfanads.android.core.inter;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import com.byazt.dyf.tt;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.stub.StubApp;
import com.yfanads.android.callback.AdsControlCallback;
import com.yfanads.android.callback.AdsSpotCallback;
import com.yfanads.android.callback.BaseEnsureListener;
import com.yfanads.android.core.f;
import com.yfanads.android.core.i;
import com.yfanads.android.core.toppush.YFAdTopPushAds;
import com.yfanads.android.core.toppush.YFTopPushListener;
import com.yfanads.android.libs.AbsCallback;
import com.yfanads.android.libs.utils.ActivityUtils;
import com.yfanads.android.model.BindInfo;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.model.YFAdType;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFAdInterstitialAds extends i implements YFInterstitialSetting {
    private BindInfo bindInfo;
    private final Context context;
    private boolean hasClose;
    private boolean hasExposure;
    private boolean hasStartLoad;
    private boolean hasTPShow;
    private boolean isTPShow;
    private YFInterstitialListener listener;
    private SoftReference<Activity> mActivity;
    private final String tag;
    private YFAdTopPushAds topPushAds;

    public static final class TPListener extends AbsCallback<YFAdInterstitialAds> implements YFTopPushListener {
        private static final String tag = "YFAds-TP";

        public TPListener(YFAdInterstitialAds yFAdInterstitialAds) {
            super(yFAdInterstitialAds);
        }

        @Override // com.yfanads.android.callback.BaseAdListener
        public void onAdClicked() {
            YFLog.high("YFAds-TP TopPush onAdClicked");
            if (get() != null) {
                get().setStopLooperByClick(true);
            }
        }

        @Override // com.yfanads.android.callback.BaseAdListener
        public void onAdClosed() {
            YFLog.high("YFAds-TP TopPush onAdClosed");
            if (get() != null) {
                get().closeTP();
            }
        }

        @Override // com.yfanads.android.callback.BaseAdListener
        public void onAdExposure() {
            YFLog.high("YFAds-TP TopPush onAdExposure");
        }

        @Override // com.yfanads.android.callback.BaseAdListener
        public void onAdFailed(YFAdError yFAdError) {
            YFLog.high("YFAds-TP TopPush onAdFailed");
            if (get() != null) {
                get().closeTP();
            }
        }

        @Override // com.yfanads.android.callback.BaseAdListener
        public void onAdRenderFailed() {
            YFLog.high("YFAds-TP TopPush onAdRenderFailed");
            if (get() != null) {
                get().closeTP();
            }
        }

        @Override // com.yfanads.android.callback.BaseAdListener
        public void onAdSuccess() {
            YFLog.high("YFAds-TP TopPush onAdSuccess");
            if (get() != null) {
                get().checkTPShow("onAdSuccess");
            }
        }
    }

    public YFAdInterstitialAds(Context context, YFInterstitialListener yFInterstitialListener) {
        super(context, yFInterstitialListener);
        this.tag = "YFAds-TP";
        this.hasStartLoad = false;
        this.isTPShow = false;
        this.hasExposure = false;
        this.hasClose = false;
        this.hasTPShow = false;
        this.context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        if (context instanceof Activity) {
            this.mActivity = new SoftReference<>((Activity) context);
        }
        setAdType(YFAdType.INTR);
        this.listener = yFInterstitialListener;
    }

    private void checkStartTPAds(String str, int i) {
        if (hasTopPush() && this.bindInfo.isReqReady(i) && hasNotStartTP()) {
            YFLog.high("YFAds-TP checkStartTPAds from " + str);
            YFUtil.switchMainThread("YFAds-TP", new BaseEnsureListener() { // from class: com.yfanads.android.core.inter.YFAdInterstitialAds$$ExternalSyntheticLambda3
                @Override // com.yfanads.android.callback.BaseEnsureListener
                public final void ensure() {
                    this.f$0.m1213xa4edeaef();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTPShow(String str) {
        try {
            if (!hasTopPush()) {
                YFLog.high("YFAds-TP checkTPShow has not tp, from " + str);
                return;
            }
            if (this.hasTPShow) {
                return;
            }
            if (!hasTPSuccess()) {
                YFLog.warn("YFAds-TP checkTPShow has not success, from " + str);
                return;
            }
            if (this.isTPShow) {
                showTPAds(str);
                return;
            }
            if (this.bindInfo.isShowReady(1)) {
                showTPAds(str);
                return;
            }
            if (this.bindInfo.isShowReady(2) && this.hasExposure) {
                showTPAds(str);
            } else if (this.bindInfo.isShowReady(3) && this.hasClose) {
                showTPAds(str);
            }
        } catch (Exception e) {
            f.a(e, new StringBuilder("YFAds-TP checkTPShow e: "));
        }
    }

    private static void closeCustomInterstitial(Activity activity, String... strArr) {
        if (strArr == null) {
            return;
        }
        for (String str : strArr) {
            try {
                FragmentManager fragmentManager = activity.getFragmentManager();
                Fragment fragmentFindFragmentByTag = fragmentManager.findFragmentByTag(str);
                if (fragmentFindFragmentByTag != null) {
                    FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
                    fragmentTransactionBeginTransaction.remove(fragmentFindFragmentByTag);
                    fragmentTransactionBeginTransaction.commitAllowingStateLoss();
                }
            } catch (Exception unused) {
            }
        }
    }

    private boolean hasNotStartTP() {
        return !this.hasStartLoad;
    }

    private boolean hasTPSuccess() {
        YFAdTopPushAds yFAdTopPushAds = this.topPushAds;
        return yFAdTopPushAds != null && yFAdTopPushAds.isReady();
    }

    private boolean hasTopPush() {
        BindInfo bindInfo = this.bindInfo;
        return bindInfo != null && bindInfo.hasTopPush();
    }

    public static void removeInterstitial(Activity activity) {
        closeCustomInterstitial(activity, MediationConstant.RIT_TYPE_INTERSTITIAL, "download", tt.AD_TAG_DISLIKE);
    }

    private void startTopPush(String str) {
        SoftReference<Activity> softReference = this.mActivity;
        Activity activity = (softReference == null || softReference.get() == null) ? this.context : this.mActivity.get();
        YFLog.high("YFAds-TP startTopPush tpId:" + str + " ctx: " + activity);
        this.hasStartLoad = true;
        YFAdTopPushAds yFAdTopPushAds = new YFAdTopPushAds(activity, new TPListener(this));
        this.topPushAds = yFAdTopPushAds;
        yFAdTopPushAds.loadOnly(str);
    }

    @Override // com.yfanads.android.core.i, com.yfanads.android.callback.BaseAdapterEvent
    public void adapterDidClosed(SdkSupplier sdkSupplier) {
        super.adapterDidClosed(sdkSupplier);
        this.hasClose = true;
        checkTPShow("adapterDidClosed");
    }

    @Override // com.yfanads.android.core.i, com.yfanads.android.callback.BaseAdapterEvent
    public void adapterDidExposure(SdkSupplier sdkSupplier) {
        super.adapterDidExposure(sdkSupplier);
        this.hasExposure = true;
        YFLog.high("YFAds-TP interAds exposure " + this.bindInfo);
        checkStartTPAds("exposure", 2);
        checkTPShow("adapterDidExposure");
    }

    @Override // com.yfanads.android.core.i, com.yfanads.android.callback.BaseAdapterEvent
    public void adapterRenderFailed(SdkSupplier sdkSupplier) {
        super.adapterRenderFailed(sdkSupplier);
        this.isTPShow = true;
        YFLog.high("YFAds-TP interAds exposure fail" + this.bindInfo);
        checkTPShow("adapterRenderFailed");
    }

    @Override // com.yfanads.android.core.i, com.yfanads.android.callback.AdCoreAction
    public void destroy() {
        super.destroy();
        if (this.listener != null) {
            this.listener = null;
        }
        setAdsSpotCallback(null);
    }

    @Override // com.yfanads.android.core.i
    public int getAType() {
        return 3;
    }

    @Override // com.yfanads.android.callback.BaseAdapterNativeSetting
    @Deprecated
    public int getViewHeight() {
        return 0;
    }

    @Override // com.yfanads.android.callback.BaseAdapterNativeSetting
    @Deprecated
    public int getViewWidth() {
        return 0;
    }

    /* JADX INFO: renamed from: lambda$checkStartTPAds$2$com-yfanads-android-core-inter-YFAdInterstitialAds, reason: not valid java name */
    /* synthetic */ void m1213xa4edeaef() {
        startTopPush(this.bindInfo.getAdId());
    }

    /* JADX INFO: renamed from: lambda$showTPAds$3$com-yfanads-android-core-inter-YFAdInterstitialAds, reason: not valid java name */
    /* synthetic */ void m1214x13b51411(String str) {
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity == null) {
            YFLog.error("YFAds-TP checkTPShow topActivity is null " + str);
            SoftReference<Activity> softReference = this.mActivity;
            topActivity = softReference != null ? softReference.get() : null;
        }
        if (topActivity == null) {
            this.hasTPShow = false;
            YFLog.error("YFAds-TP checkTPShow reqActivity is null, return. " + str);
        } else {
            YFLog.high("YFAds-TP showTPAds from " + str + "|" + topActivity);
            this.topPushAds.showAds(topActivity);
        }
    }

    /* JADX INFO: renamed from: lambda$startLoad$1$com-yfanads-android-core-inter-YFAdInterstitialAds, reason: not valid java name */
    /* synthetic */ void m1216x9417f42(boolean z) {
        YFLog.high("YFAds-TP interAds total " + z);
        if (!z) {
            this.isTPShow = true;
            checkStartTPAds("fail", 1);
        }
        checkTPShow("load fail");
    }

    @Override // com.yfanads.android.core.i
    public void showAds(Activity activity) {
        super.showAds(activity);
        if (activity == null || !hasTopPush()) {
            return;
        }
        this.mActivity = new SoftReference<>(activity);
    }

    @Override // com.yfanads.android.core.i
    /* JADX INFO: renamed from: startLoad */
    public void m1209lambda$loadOnly$4$comyfanadsandroidcorei(String str) {
        setAdsSpotCallback(new AdsSpotCallback() { // from class: com.yfanads.android.core.inter.YFAdInterstitialAds$$ExternalSyntheticLambda1
            @Override // com.yfanads.android.callback.AdsSpotCallback
            public final void loadResult(BindInfo bindInfo) {
                this.f$0.m1215xdb68e4e3(bindInfo);
            }
        });
        setAdsFailCallback(new AdsControlCallback() { // from class: com.yfanads.android.core.inter.YFAdInterstitialAds$$ExternalSyntheticLambda2
            @Override // com.yfanads.android.callback.AdsControlCallback
            public final void loadResult(boolean z) {
                this.f$0.m1216x9417f42(z);
            }
        });
        super.m1209lambda$loadOnly$4$comyfanadsandroidcorei(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeTP() {
        YFAdTopPushAds yFAdTopPushAds = this.topPushAds;
        if (yFAdTopPushAds != null) {
            yFAdTopPushAds.closeAds();
        }
    }

    private void showTPAds(final String str) {
        this.hasTPShow = true;
        YFUtil.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.android.core.inter.YFAdInterstitialAds$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1214x13b51411(str);
            }
        }, this.bindInfo.getShowDelayTime());
    }

    /* JADX INFO: renamed from: lambda$startLoad$0$com-yfanads-android-core-inter-YFAdInterstitialAds, reason: not valid java name */
    /* synthetic */ void m1215xdb68e4e3(BindInfo bindInfo) {
        this.bindInfo = bindInfo;
        YFLog.high("YFAds-TP interAds load " + this.bindInfo);
        checkStartTPAds("load", 1);
    }
}
