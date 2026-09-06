package client.android.yixiaotong.v3.ui.adv;

import android.app.Activity;
import android.util.Log;
import android.widget.RelativeLayout;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.util.um.UmConfigUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.yfanads.android.core.mixbanner.YFAdMixBannerAd;
import com.yfanads.android.core.nat.YFNativeExpressListener;
import com.yfanads.android.model.ExpView;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.utils.ScreenUtil;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class NativeUtil {
    private static final String TAG = "NativeUtil";
    private YFAdMixBannerAd easyNativeExpress;
    private Activity mActivity;
    private RelativeLayout mAdContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    private long mDelayedTime;
    private int mAdvPage = 0;
    private boolean isShow = false;
    private boolean isLoaded = false;
    private boolean mIsEnable = true;

    public void initNative(Activity activity, AdvControlUtil.AdvListener advListener, int i) {
        this.mIsEnable = true;
        this.mActivity = activity;
        this.mAdvListener = advListener;
        this.mAdvPage = i;
    }

    public void onResume() {
        this.mIsEnable = true;
        LogUtil.e(TAG, "onResume:");
    }

    public void onPause() {
        LogUtil.e(TAG, "onPause:");
    }

    public void onDestroy() {
        LogUtil.e(TAG, "onDestroy:");
        this.mIsEnable = false;
        destroyFengChuanNative();
    }

    public void onNative(RelativeLayout relativeLayout) {
        this.mAdContainer = relativeLayout;
        this.mDelayedTime = System.currentTimeMillis();
        loadFengChuanNative();
        destroyAllAdv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onShowResult(final Common.AdvName advName) {
        Activity activity = this.mActivity;
        if (activity != null) {
            LocalDataUtil.saveAdvlaunchCount(activity, 6);
        }
        if (this.mAdvListener != null) {
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.adv.NativeUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    NativeUtil.this.mAdvListener.onAdShow(advName + "", Common.AdvType.advnative);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCloseResult() {
        if (this.mAdvListener != null) {
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.adv.NativeUtil.2
                @Override // java.lang.Runnable
                public void run() {
                    NativeUtil.this.mAdvListener.onAdClosed(Common.AdvType.advnative);
                }
            });
        }
    }

    private void destroyAllAdv() {
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.adv.NativeUtil.3
            @Override // java.lang.Runnable
            public void run() {
                LogUtil.e(NativeUtil.TAG, "广告倒计时结束" + (System.currentTimeMillis() - NativeUtil.this.mDelayedTime) + "  " + NativeUtil.this.isShow);
                if (System.currentTimeMillis() - NativeUtil.this.mDelayedTime < 4900 || NativeUtil.this.isShow || NativeUtil.this.isLoaded) {
                    return;
                }
                NativeUtil.this.destroyFengChuanNative();
            }
        }, 5000L);
    }

    private void loadFengChuanNative() {
        String str = TAG;
        LogUtil.e(str, "loadFengChuanNative " + this.isLoaded + PPSLabelView.Code + (this.easyNativeExpress != null) + PPSLabelView.Code + this.isShow);
        if (this.easyNativeExpress != null && this.isLoaded && !this.isShow) {
            showFengChuanNative();
            return;
        }
        this.isShow = false;
        this.isLoaded = false;
        destroyFengChuanNative();
        UmConfigUtil.setRequestNativeAdEvent(this.mActivity);
        this.easyNativeExpress = new YFAdMixBannerAd(this.mActivity, new YFNativeExpressListener() { // from class: client.android.yixiaotong.v3.ui.adv.NativeUtil.4
            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdRenderFailed() {
                LogUtil.e(NativeUtil.TAG, "onAdRenderFailed ");
            }

            @Override // com.yfanads.android.core.nat.YFNativeExpressListener
            public void onAdRenderSuccess(List<ExpView> list) {
                LogUtil.e(NativeUtil.TAG, "onAdRenderSuccess：" + list.size() + " pos = " + list.get(0));
                NativeUtil.this.isShow = true;
                NativeUtil.this.onShowResult(Common.AdvName.chuangzhi);
                NativeUtil.this.startRenderSuccess(list);
                UmConfigUtil.setNativeAdSuccessEvent(NativeUtil.this.mActivity);
            }

            @Override // com.yfanads.android.callback.BaseExpAdListener, com.yfanads.android.callback.BaseAdListener
            public void onAdSuccess() {
                NativeUtil.this.isLoaded = true;
                LogUtil.e(NativeUtil.TAG, "加载信息流成功:" + NativeUtil.this.mIsEnable);
                NativeUtil.this.showFengChuanNative();
            }

            @Override // com.yfanads.android.callback.BaseExpAdListener, com.yfanads.android.callback.BaseAdListener
            public void onAdFailed(YFAdError yFAdError) {
                LogUtil.e(NativeUtil.TAG, "onAdFailed " + yFAdError);
            }

            @Override // com.yfanads.android.callback.BaseExpAdListener
            public void onAdExposure(ExpView expView) {
                LogUtil.e(NativeUtil.TAG, "onAdExposure " + expView);
            }

            @Override // com.yfanads.android.callback.BaseExpAdListener
            public void onAdRenderFailed(ExpView expView) {
                LogUtil.e(NativeUtil.TAG, "onAdRenderFailed " + expView);
            }

            @Override // com.yfanads.android.callback.BaseExpAdListener
            public void onAdClicked(ExpView expView) {
                LogUtil.e(NativeUtil.TAG, "onAdClicked " + expView);
            }

            @Override // com.yfanads.android.callback.BaseExpAdListener
            public void onAdClosed(ExpView expView) {
                Log.i("TEST", "onAdClosed " + expView);
                NativeUtil.this.destroyFengChuanNative();
                NativeUtil.this.onCloseResult();
            }
        });
        Activity activity = this.mActivity;
        int iPx2dip = ScreenUtil.px2dip(activity, ScreenUtil.getScreenWidth(activity));
        this.easyNativeExpress.setViewAcceptedSize(iPx2dip, 0);
        LogUtil.e(str, "广告位width：" + iPx2dip);
        this.easyNativeExpress.setAdsNumbers(1);
        String str2 = this.mAdvPage == 0 ? Common.POS_ID_NativeFendChuanShouYe : Common.POS_ID_NativeFendChuanBath;
        LogUtil.e(str, "广告位：".concat(str2));
        this.easyNativeExpress.loadOnly(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startRenderSuccess(List<ExpView> list) {
        LogUtil.e(TAG, "startRenderSuccess");
        if (list == null || list.size() == 0) {
            return;
        }
        ExpView expView = list.get(0);
        if (expView.getView() != null) {
            this.mAdContainer.removeAllViews();
            this.mAdContainer.addView(expView.getView());
        } else {
            expView.render(this.mAdContainer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showFengChuanNative() {
        LogUtil.e(TAG, "showFengChuanNative");
        YFAdMixBannerAd yFAdMixBannerAd = this.easyNativeExpress;
        if (yFAdMixBannerAd != null) {
            yFAdMixBannerAd.showAds(this.mActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyFengChuanNative() {
        LogUtil.e(TAG, "destroyFengChuanNative");
        YFAdMixBannerAd yFAdMixBannerAd = this.easyNativeExpress;
        if (yFAdMixBannerAd != null) {
            yFAdMixBannerAd.destroy();
            this.easyNativeExpress = null;
        }
        RelativeLayout relativeLayout = this.mAdContainer;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }
}
