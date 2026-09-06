package client.android.yixiaotong.v3.ui.adv;

import android.app.Activity;
import android.widget.FrameLayout;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.util.um.UmConfigUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.yfanads.android.core.splash.YFAdSplashAds;
import com.yfanads.android.core.splash.YFSplashListener;
import com.yfanads.android.model.YFAdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SplashUtil {
    private static final String TAG = "SplashUtil";
    private static final int TIMEOUT_TOMAIN = 6000;
    private YFAdSplashAds fcAdSplash;
    private Activity mActivity;
    private AdvControlUtil.AdvListener mAdvListener;
    private long mDelayedTime;
    private FrameLayout mFrameLayout;
    private boolean mIsEnable = true;
    private boolean mExposure = false;
    private boolean mIsClickAdv = false;
    private boolean mIsHotLaunch = false;
    public boolean canJumpImmediately = false;
    private boolean mIsLoaded = false;

    public void initSplash(Activity activity, AdvControlUtil.AdvListener advListener, int i, boolean z) {
        this.mActivity = activity;
        this.mAdvListener = advListener;
        this.mIsHotLaunch = z;
    }

    public void onCreate() {
    }

    public void onResume() {
        this.mIsEnable = true;
        LogUtil.e(TAG, "onResume:" + this.canJumpImmediately + PPSLabelView.Code + this.mIsLoaded + "  " + this.mIsClickAdv);
        if (this.mIsLoaded && !this.mIsClickAdv) {
            jumpMainActivity();
            return;
        }
        if (this.canJumpImmediately) {
            jumpWhenCanClickCZ();
        }
        this.canJumpImmediately = true;
    }

    public void onPause() {
        LogUtil.e(TAG, "onPause:");
        this.mIsEnable = false;
        this.canJumpImmediately = false;
    }

    public void onDestroy() {
        YFAdSplashAds yFAdSplashAds = this.fcAdSplash;
        if (yFAdSplashAds != null) {
            yFAdSplashAds.destroy();
            this.fcAdSplash = null;
        }
    }

    public void onSplash(FrameLayout frameLayout) {
        this.mFrameLayout = frameLayout;
        this.mExposure = false;
        timeOut();
        loadFeangChuan();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void advLoadResult(Common.AdvName advName, boolean z) {
        if (z) {
            LogUtil.e(TAG, "advLoadResult 加载成功：" + advName);
            showFengChuan();
        } else if (this.mAdvListener != null) {
            LogUtil.e(TAG, "advLoadResult 加载失败：" + advName);
            this.mAdvListener.onAdClosed(Common.AdvType.advsplash);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jumpWhenCanClickCZ() {
        if (this.canJumpImmediately) {
            jumpMainActivity();
        } else {
            this.canJumpImmediately = true;
        }
    }

    private void jumpMainActivity() {
        AdvControlUtil.AdvListener advListener = this.mAdvListener;
        if (advListener != null) {
            advListener.onAdClosed(Common.AdvType.advsplash);
        }
    }

    private void loadFeangChuan() {
        UmConfigUtil.setRequestSplashAdEvent(this.mActivity);
        this.fcAdSplash = new YFAdSplashAds(this.mActivity, new YFSplashListener() { // from class: client.android.yixiaotong.v3.ui.adv.SplashUtil.1
            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdSuccess() {
                LogUtil.e(SplashUtil.TAG, "onAdSuccess:");
                SplashUtil.this.advLoadResult(Common.AdvName.chuangzhi, true);
            }

            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdExposure() {
                LogUtil.e(SplashUtil.TAG, "onAdExposure:");
                SplashUtil.this.mExposure = true;
                UmConfigUtil.setSplashAdSuccessEvent(SplashUtil.this.mActivity);
                if (SplashUtil.this.mAdvListener != null) {
                    SplashUtil.this.mAdvListener.onAdShow(Common.AdvName.chuangzhi + "", Common.AdvType.advsplash);
                }
            }

            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdClicked() {
                LogUtil.e(SplashUtil.TAG, "onAdClicked:");
                SplashUtil.this.mIsClickAdv = true;
            }

            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdClosed() {
                LogUtil.e(SplashUtil.TAG, "onAdClosed:" + SplashUtil.this.canJumpImmediately);
                SplashUtil.this.jumpWhenCanClickCZ();
            }

            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdFailed(YFAdError yFAdError) {
                LogUtil.e(SplashUtil.TAG, "onAdFailed:");
                SplashUtil.this.advLoadResult(Common.AdvName.chuangzhi, false);
            }

            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdRenderFailed() {
                LogUtil.e(SplashUtil.TAG, "onAdRenderFailed:");
                SplashUtil.this.advLoadResult(Common.AdvName.chuangzhi, false);
            }
        });
        int iPx2dip = AppUtils.px2dip(this.mActivity, this.mFrameLayout.getHeight());
        String str = this.mIsHotLaunch ? Common.POS_ID_SplashFengChuanHot : Common.POS_ID_SplashFengChuanCold;
        LogUtil.e(TAG, "expressViewHeight:" + iPx2dip + "  容器高：" + this.mFrameLayout.getHeight() + PPSLabelView.Code + str);
        this.fcAdSplash.setHeight(iPx2dip);
        this.fcAdSplash.loadOnly(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFengChuan() {
        if (this.fcAdSplash != null) {
            this.mFrameLayout.post(new Runnable() { // from class: client.android.yixiaotong.v3.ui.adv.SplashUtil$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m233x89b7b7e3();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$showFengChuan$0$client-android-yixiaotong-v3-ui-adv-SplashUtil, reason: not valid java name */
    /* synthetic */ void m233x89b7b7e3() {
        this.fcAdSplash.showAds(this.mActivity, this.mFrameLayout);
    }

    private void timeOut() {
        this.mDelayedTime = System.currentTimeMillis();
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.adv.SplashUtil.2
            @Override // java.lang.Runnable
            public void run() {
                LogUtil.e(SplashUtil.TAG, "广告倒计时结：" + (System.currentTimeMillis() - SplashUtil.this.mDelayedTime) + PPSLabelView.Code + SplashUtil.this.mExposure + PPSLabelView.Code + SplashUtil.this.mIsEnable + PPSLabelView.Code + SplashUtil.this.mIsClickAdv);
                if (!SplashUtil.this.mIsEnable || SplashUtil.this.mExposure || SplashUtil.this.mAdvListener == null || System.currentTimeMillis() - SplashUtil.this.mDelayedTime < 5900) {
                    if (SplashUtil.this.mIsEnable) {
                        return;
                    }
                    LogUtil.e(SplashUtil.TAG, "广告倒计时结2");
                    SplashUtil.this.mIsLoaded = true;
                    return;
                }
                LogUtil.e(SplashUtil.TAG, "广告倒计时结");
                if (SplashUtil.this.fcAdSplash == null || !SplashUtil.this.fcAdSplash.findReadyAd()) {
                    SplashUtil.this.mAdvListener.onAdClosed(Common.AdvType.advsplash);
                } else {
                    SplashUtil.this.showFengChuan();
                }
            }
        }, 6000L);
    }
}
