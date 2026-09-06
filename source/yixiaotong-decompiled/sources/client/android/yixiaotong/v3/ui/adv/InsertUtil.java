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
public class InsertUtil {
    private static final String TAG = "InsertUtil";
    private YFAdInterstitialAds easyInterstitial;
    private Activity mActivity;
    private AdvControlUtil.AdvListener mAdvListener;
    private boolean mIsNewPlantion;
    private String mSchoolId;
    private boolean mIsEnable = true;
    private int mPageIndex = 0;
    private boolean mIsShowing = false;
    private boolean mIsLoaded = false;

    private String getPOSID() {
        int i = this.mPageIndex;
        if (i == 1) {
            return Common.POS_ID_InterstitialFendChuanShouYe;
        }
        return i == 2 ? Common.POS_ID_InterstitialFendChuanRECHARGE : Common.POS_ID_InterstitialFendChuanBath;
    }

    public void initInsert(Activity activity, AdvControlUtil.AdvListener advListener, boolean z, String str, int i) {
        this.mActivity = activity;
        this.mAdvListener = advListener;
        this.mIsNewPlantion = z;
        this.mSchoolId = str;
        this.mPageIndex = i;
    }

    public void initInsert(Activity activity, AdvControlUtil.AdvListener advListener, boolean z, String str, boolean z2) {
        this.mActivity = activity;
        this.mAdvListener = advListener;
        this.mIsNewPlantion = z;
        this.mSchoolId = str;
    }

    public void onCreate(Activity activity) {
        this.mIsEnable = true;
    }

    public void onPause() {
        this.mIsEnable = false;
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
        this.mIsShowing = false;
        loadFengChuan();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void advLoadResult(Common.AdvName advName, boolean z) {
        if (this.mIsEnable) {
            if (z) {
                LogUtil.e(TAG, "advLoadResult 加载成功：" + advName);
                if (this.mIsShowing) {
                    return;
                }
                showFengChuan();
                return;
            }
            LogUtil.e(TAG, "advLoadResult 加载失败：" + advName);
        }
    }

    private void onShowResult(final Common.AdvName advName) {
        if (this.mIsEnable) {
            if (this.mAdvListener != null) {
                MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.adv.InsertUtil.1
                    @Override // java.lang.Runnable
                    public void run() {
                        InsertUtil.this.mAdvListener.onAdShow(advName + "", Common.AdvType.advinsert);
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
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.adv.InsertUtil.2
                @Override // java.lang.Runnable
                public void run() {
                    InsertUtil.this.mAdvListener.onAdClosed(Common.AdvType.advinsert);
                }
            });
        }
    }

    private void loadFengChuan() {
        String str = TAG;
        LogUtil.e(str, "load");
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
        this.easyInterstitial = new YFAdInterstitialAds(this.mActivity, new YFInterstitialListener() { // from class: client.android.yixiaotong.v3.ui.adv.InsertUtil.3
            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdSuccess() {
                LogUtil.e(InsertUtil.TAG, "onAdSuccess");
                if (!InsertUtil.this.mIsLoaded) {
                    InsertUtil.this.advLoadResult(Common.AdvName.chuangzhi, true);
                }
                InsertUtil.this.mIsLoaded = true;
            }

            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdExposure() {
                LogUtil.e(InsertUtil.TAG, "onAdExposure 广告展示");
                UmConfigUtil.setInterstitialAdSuccessEvent(InsertUtil.this.mActivity);
            }

            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdClicked() {
                LogUtil.e(InsertUtil.TAG, "onAdClicked");
            }

            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdClosed() {
                LogUtil.e(InsertUtil.TAG, "onAdClosed");
                InsertUtil.this.onCloseResult();
            }

            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdFailed(YFAdError yFAdError) {
                LogUtil.e(InsertUtil.TAG, "onAdFailed");
                InsertUtil.this.advLoadResult(Common.AdvName.chuangzhi, false);
            }

            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdRenderFailed() {
                LogUtil.e(InsertUtil.TAG, "onAdRenderFailed");
                InsertUtil.this.advLoadResult(Common.AdvName.chuangzhi, false);
            }
        });
        String posid = getPOSID();
        LogUtil.e(str, "插屏广告位：" + posid);
        this.easyInterstitial.loadOnly(posid);
    }

    private void showFengChuan() {
        LogUtil.e(TAG, "showFengChuan");
        YFAdInterstitialAds yFAdInterstitialAds = this.easyInterstitial;
        if (yFAdInterstitialAds != null) {
            yFAdInterstitialAds.showAds(this.mActivity);
        }
        this.mIsShowing = true;
        onShowResult(Common.AdvName.chuangzhi);
    }
}
