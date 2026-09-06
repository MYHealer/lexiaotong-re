package client.android.yixiaotong.v3.ui.adv;

import android.app.Activity;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.util.um.UmConfigUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.yfanads.android.core.inter.YFAdInterstitialAds;
import com.yfanads.android.core.inter.YFInterstitialListener;
import com.yfanads.android.model.YFAdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ShouYeInsertUtil {
    private static final String TAG = "ShouYeInsertUtil";
    private YFAdInterstitialAds easyInterstitial;
    private Activity mActivity;
    private AdvControlUtil.AdvListener mAdvListener;
    private boolean mIsEnable;
    private boolean mIsLoaded;
    private boolean mIsNewPlantion;
    private boolean mIsPreLoad;
    private boolean mIsShouYeAdv;
    private String mSchoolId;

    public void initInsert(Activity activity, AdvControlUtil.AdvListener advListener, boolean z, String str, boolean z2) {
        this.mActivity = activity;
        this.mAdvListener = advListener;
        this.mIsNewPlantion = z;
        this.mSchoolId = str;
        this.mIsShouYeAdv = z2;
    }

    public void onCreate(Activity activity, boolean z) {
        this.mIsEnable = true;
        this.mIsPreLoad = z;
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    private ShouYeInsertUtil() {
        this.mIsEnable = true;
        this.mIsShouYeAdv = false;
        this.mIsLoaded = false;
    }

    private static final class SingleHolder {
        private static final ShouYeInsertUtil INSTANCE = new ShouYeInsertUtil();

        private SingleHolder() {
        }
    }

    public static ShouYeInsertUtil getInstance() {
        return SingleHolder.INSTANCE;
    }

    public void onDestroy(Activity activity) {
        String str = TAG;
        LogUtil.e(str, "onDestroy:" + (this.mActivity != null) + PPSLabelView.Code + (activity != null));
        if (this.mActivity == null || activity == null || !activity.getLocalClassName().equals(this.mActivity.getLocalClassName())) {
            return;
        }
        LogUtil.e(str, "onDestroy:" + this.mActivity.getLocalClassName());
        YFAdInterstitialAds yFAdInterstitialAds = this.easyInterstitial;
        if (yFAdInterstitialAds != null) {
            yFAdInterstitialAds.destroy();
            this.easyInterstitial = null;
        }
    }

    public void onInsert() {
        loadFengChuan();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void advLoadResult(Common.AdvName advName, boolean z) {
        if (this.mIsEnable) {
            if (z) {
                LogUtil.e(TAG, "advLoadResult 加载成功：" + advName);
                showFengChuan();
            } else {
                LogUtil.e(TAG, "advLoadResult 加载失败：" + advName);
            }
        }
    }

    private void onShowResult(final Common.AdvName advName) {
        if (this.mIsEnable) {
            if (this.mAdvListener != null) {
                MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.adv.ShouYeInsertUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ShouYeInsertUtil.this.mAdvListener.onAdShow(advName + "", Common.AdvType.advinsert);
                    }
                });
            }
            if (this.mIsNewPlantion) {
                LocalDataUtil.saveAdvlaunchCount(this.mActivity, 3);
            } else {
                LocalBusinessStore.saveAdvlaunchCount(this.mActivity, this.mSchoolId, 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCloseResult() {
        if (this.mAdvListener != null) {
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.adv.ShouYeInsertUtil.2
                @Override // java.lang.Runnable
                public void run() {
                    ShouYeInsertUtil.this.mAdvListener.onAdClosed(Common.AdvType.advinsert);
                }
            });
        }
    }

    private void loadFengChuan() {
        String str = TAG;
        LogUtil.e(str, "load:" + this.mIsLoaded + "  " + (this.easyInterstitial != null));
        YFAdInterstitialAds yFAdInterstitialAds = this.easyInterstitial;
        if (yFAdInterstitialAds != null && this.mIsLoaded) {
            showFengChuan();
            return;
        }
        if (yFAdInterstitialAds != null) {
            yFAdInterstitialAds.destroy();
            this.easyInterstitial = null;
        }
        this.mIsLoaded = false;
        UmConfigUtil.setRequestInterstitialAdEvent(this.mActivity);
        this.easyInterstitial = new YFAdInterstitialAds(this.mActivity, new YFInterstitialListener() { // from class: client.android.yixiaotong.v3.ui.adv.ShouYeInsertUtil.3
            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdSuccess() {
                LogUtil.e(ShouYeInsertUtil.TAG, "onAdSuccess:加载插屏成功" + ShouYeInsertUtil.this.mIsPreLoad);
                if (!ShouYeInsertUtil.this.mIsLoaded && !ShouYeInsertUtil.this.mIsPreLoad) {
                    ShouYeInsertUtil.this.advLoadResult(Common.AdvName.chuangzhi, true);
                }
                ShouYeInsertUtil.this.mIsLoaded = true;
            }

            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdExposure() {
                LogUtil.e(ShouYeInsertUtil.TAG, "onAdExposure 广告展示");
                UmConfigUtil.setInterstitialAdSuccessEvent(ShouYeInsertUtil.this.mActivity);
            }

            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdClicked() {
                LogUtil.e(ShouYeInsertUtil.TAG, "onAdClicked");
            }

            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdClosed() {
                LogUtil.e(ShouYeInsertUtil.TAG, "onAdClosed");
                ShouYeInsertUtil.this.onCloseResult();
            }

            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdFailed(YFAdError yFAdError) {
                LogUtil.e(ShouYeInsertUtil.TAG, "onAdFailed");
                ShouYeInsertUtil.this.advLoadResult(Common.AdvName.chuangzhi, false);
            }

            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdRenderFailed() {
                LogUtil.e(ShouYeInsertUtil.TAG, "onAdRenderFailed");
                ShouYeInsertUtil.this.advLoadResult(Common.AdvName.chuangzhi, false);
            }
        });
        String str2 = this.mIsShouYeAdv ? Common.POS_ID_InterstitialFendChuanShouYe : Common.POS_ID_InterstitialFendChuanBath;
        LogUtil.e(str, "插屏广告位：".concat(str2));
        this.easyInterstitial.loadOnly(str2);
    }

    private void showFengChuan() {
        YFAdInterstitialAds yFAdInterstitialAds = this.easyInterstitial;
        if (yFAdInterstitialAds != null) {
            yFAdInterstitialAds.showAds(this.mActivity);
        }
        onShowResult(Common.AdvName.chuangzhi);
    }
}
