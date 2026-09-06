package client.android.yixiaotong.v3.ui.adv;

import android.app.Activity;
import android.content.Context;
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
public class ShouYeNativeUtil {
    private static final String TAG = "ShouYeNativeUtil";
    private YFAdMixBannerAd easyNativeExpress;
    private boolean isLoaded;
    private boolean isShow;
    private Activity mActivity;
    private RelativeLayout mAdContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    private int mAdvPage;
    private Context mContext;
    private long mDelayedTime;
    private boolean mIsEnable;
    private boolean mIsPreLoad;

    public void initNative(Activity activity, Context context, AdvControlUtil.AdvListener advListener, int i, boolean z) {
        this.mIsPreLoad = z;
        this.mIsEnable = true;
        this.mActivity = activity;
        this.mContext = context;
        this.mAdvListener = advListener;
        this.mAdvPage = i;
    }

    private ShouYeNativeUtil() {
        this.mIsEnable = true;
        this.mAdvPage = 0;
        this.isShow = false;
        this.isLoaded = false;
    }

    private static final class SingleHolder {
        private static final ShouYeNativeUtil INSTANCE = new ShouYeNativeUtil();

        private SingleHolder() {
        }
    }

    public static ShouYeNativeUtil getInstance() {
        return SingleHolder.INSTANCE;
    }

    public void onResume() {
        this.mIsEnable = true;
        LogUtil.e(TAG, "onResume:");
    }

    public void onPause() {
        LogUtil.e(TAG, "onPause:");
        this.mIsEnable = false;
    }

    public void onDestroy() {
        LogUtil.e(TAG, "onDestroy:");
        destroyFengChuanNative();
    }

    public void onNative(RelativeLayout relativeLayout) {
        this.mAdContainer = relativeLayout;
        this.mDelayedTime = System.currentTimeMillis();
        destroyAllAdvTimeOut();
        loadFengChuanNative();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onShowResult(final Common.AdvName advName) {
        Activity activity = this.mActivity;
        if (activity != null) {
            LocalDataUtil.saveAdvlaunchCount(activity, 6);
        }
        if (this.mAdvListener != null) {
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.adv.ShouYeNativeUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    ShouYeNativeUtil.this.mAdvListener.onAdShow(advName + "", Common.AdvType.advnative);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCloseResult() {
        if (this.mAdvListener != null) {
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.adv.ShouYeNativeUtil.2
                @Override // java.lang.Runnable
                public void run() {
                    ShouYeNativeUtil.this.mAdvListener.onAdClosed(Common.AdvType.advnative);
                }
            });
        }
    }

    private void destroyAllAdvTimeOut() {
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.adv.ShouYeNativeUtil.3
            @Override // java.lang.Runnable
            public void run() {
                LogUtil.e(ShouYeNativeUtil.TAG, "广告倒计时结束" + (System.currentTimeMillis() - ShouYeNativeUtil.this.mDelayedTime) + "  " + ShouYeNativeUtil.this.isShow);
                if (System.currentTimeMillis() - ShouYeNativeUtil.this.mDelayedTime < 4900 || ShouYeNativeUtil.this.isShow || ShouYeNativeUtil.this.isLoaded) {
                    return;
                }
                ShouYeNativeUtil.this.destroyFengChuanNative();
            }
        }, 5000L);
    }

    private void loadFengChuanNative() {
        String str = TAG;
        LogUtil.e(str, "loadFengChuanNative " + this.isLoaded + PPSLabelView.Code + (this.easyNativeExpress != null) + PPSLabelView.Code + this.isShow + this.mIsPreLoad);
        if (this.easyNativeExpress != null && this.isLoaded && !this.isShow) {
            showFengChuanNative();
            return;
        }
        this.isShow = false;
        this.isLoaded = false;
        destroyFengChuanNative();
        UmConfigUtil.setRequestNativeAdEvent(this.mActivity);
        this.easyNativeExpress = new YFAdMixBannerAd(this.mContext, new YFNativeExpressListener() { // from class: client.android.yixiaotong.v3.ui.adv.ShouYeNativeUtil.4
            @Override // com.yfanads.android.callback.BaseAdListener
            public void onAdRenderFailed() {
                LogUtil.e(ShouYeNativeUtil.TAG, "onAdRenderFailed ");
            }

            @Override // com.yfanads.android.core.nat.YFNativeExpressListener
            public void onAdRenderSuccess(List<ExpView> list) {
                LogUtil.e(ShouYeNativeUtil.TAG, "onAdRenderSuccess：" + list.size() + " pos = " + list.get(0));
                ShouYeNativeUtil.this.isShow = true;
                ShouYeNativeUtil.this.onShowResult(Common.AdvName.chuangzhi);
                ShouYeNativeUtil.this.startRenderSuccess(list);
                UmConfigUtil.setNativeAdSuccessEvent(ShouYeNativeUtil.this.mActivity);
            }

            @Override // com.yfanads.android.callback.BaseExpAdListener, com.yfanads.android.callback.BaseAdListener
            public void onAdSuccess() {
                ShouYeNativeUtil.this.isLoaded = true;
                LogUtil.e(ShouYeNativeUtil.TAG, "加载信息流成功:" + ShouYeNativeUtil.this.mIsPreLoad);
                if (ShouYeNativeUtil.this.mIsPreLoad) {
                    return;
                }
                ShouYeNativeUtil.this.showFengChuanNative();
            }

            @Override // com.yfanads.android.callback.BaseExpAdListener, com.yfanads.android.callback.BaseAdListener
            public void onAdFailed(YFAdError yFAdError) {
                LogUtil.e(ShouYeNativeUtil.TAG, "onAdFailed " + yFAdError);
            }

            @Override // com.yfanads.android.callback.BaseExpAdListener
            public void onAdExposure(ExpView expView) {
                LogUtil.e(ShouYeNativeUtil.TAG, "onAdExposure " + expView);
            }

            @Override // com.yfanads.android.callback.BaseExpAdListener
            public void onAdRenderFailed(ExpView expView) {
                LogUtil.e(ShouYeNativeUtil.TAG, "onAdRenderFailed " + expView);
            }

            @Override // com.yfanads.android.callback.BaseExpAdListener
            public void onAdClicked(ExpView expView) {
                LogUtil.e(ShouYeNativeUtil.TAG, "onAdClicked " + expView);
            }

            @Override // com.yfanads.android.callback.BaseExpAdListener
            public void onAdClosed(ExpView expView) {
                Log.i("TEST", "onAdClosed " + expView);
                ShouYeNativeUtil.this.destroyFengChuanNative();
                ShouYeNativeUtil.this.onCloseResult();
            }
        });
        Context context = this.mContext;
        this.easyNativeExpress.setViewAcceptedSize(ScreenUtil.px2dip(context, ScreenUtil.getScreenWidth(context)), 0);
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
        if (this.mAdContainer != null) {
            if (expView.getView() != null) {
                this.mAdContainer.removeAllViews();
                this.mAdContainer.addView(expView.getView());
            } else {
                expView.render(this.mAdContainer);
            }
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
