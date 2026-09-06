package com.yfanads.android.adx.core.model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.yfanads.android.adx.api.AdVideoPlayConfig;
import com.yfanads.android.adx.core.annotate.AdSdkApi;
import com.yfanads.android.adx.core.annotate.AdSdkDynamicApi;
import com.yfanads.android.adx.service.a;
import com.yfanads.android.model.FeedCom;
import com.yfanads.android.model.TemplateConf;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.utils.YFLog;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface AdxNativeAd extends BaseAd {

    public interface AdEndBitmap {
        void onGetData(Bitmap bitmap);
    }

    @AdSdkApi
    public interface AdInteractionListener {
        boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        @AdSdkApi
        default void onAdClickedSuccess(boolean z, boolean z2, boolean z3) {
            YFLog.high("onAdClickedSuccess " + z + "|" + z2);
        }

        @AdSdkApi
        void onAdHide();

        @AdSdkApi
        default void onAdShakeCancel() {
            YFLog.high("onAdShakeCancel ");
        }

        @AdSdkApi
        default void onAdShakeSuccess(boolean z, boolean z2, boolean z3) {
            YFLog.high("onAdShakeSuccess " + z + "|" + z2);
        }

        @AdSdkApi
        void onAdShow();

        @AdSdkApi
        default void onDownloadTipsDismiss() {
        }

        @AdSdkApi
        default void onDownloadTipsShow() {
        }

        @AdSdkApi
        void onExposure(boolean z);

        @AdSdkApi
        void onHandleClick(boolean z);
    }

    @AdSdkApi
    public interface AdInteractionListener2 extends AdInteractionListener {
        @AdSdkApi
        void onAdClose(AdxNativeAd adxNativeAd);
    }

    @AdSdkApi
    public static class InteractionConf {
        public boolean auto;
        public boolean isActionOne;
        public boolean isLpaa;
        public boolean isd;
        public float istvp;
        public String npd;
        public String npdw;
        public boolean showDeepLinkDialog;
        public int showDownloadDialog;

        public InteractionConf(boolean z, BaseTemplateData baseTemplateData) {
            this.auto = z;
            this.isd = baseTemplateData.isd();
            this.istvp = baseTemplateData.isTvp();
            this.showDeepLinkDialog = baseTemplateData.isShowDialog();
            this.showDownloadDialog = baseTemplateData.getSDDialog();
            this.isActionOne = baseTemplateData.isActionOne();
            this.isLpaa = baseTemplateData.isLandingPageActiveApp();
            this.npd = baseTemplateData.getNPD();
            this.npdw = baseTemplateData.getNPDW();
        }
    }

    @AdSdkApi
    public interface RewardAdInteractionListener extends AdInteractionListener2 {
        @AdSdkApi
        void onRewardVerify(boolean z, String str);
    }

    @AdSdkApi
    public interface VideoPlayListener {
        @AdSdkApi
        void onVideoPlayComplete();

        @AdSdkApi
        void onVideoPlayError(int i, int i2);

        @AdSdkApi
        void onVideoPlayStart();
    }

    @AdSdkApi
    public interface VideoPlayWholeListener extends VideoPlayListener {
        void onVideoProgress(int i);
    }

    @AdSdkApi
    void destroy(a aVar);

    @AdSdkApi
    String getActionDescription();

    @AdSdkApi
    String getAdDescription();

    @AdSdkApi
    String getAdMerchant();

    @AdSdkApi
    String getAdSource();

    @AdSdkApi
    int getAdSourceLogoUrl(int i);

    @AdSdkApi
    String getAppIconUrl();

    @AdSdkApi
    String getAppName();

    @AdSdkApi
    String getAppPackageName();

    @AdSdkApi
    long getAppPackageSize();

    @AdSdkApi
    String getAppPrivacyUrl();

    @AdSdkApi
    float getAppScore();

    @AdSdkApi
    String getAppVersion();

    @AdSdkApi
    String getCorporationName();

    @AdSdkApi
    String getDeepLink();

    @AdSdkApi
    int getECPM();

    void getEndVideoBitmap(AdEndBitmap adEndBitmap, int i, int i2);

    AdxImage getEndVideoCoverImage();

    @AdSdkApi
    List<AdxImage> getImageList();

    @AdSdkApi
    int getInteractionType();

    @AdSdkApi
    String getIntroductionInfo();

    @AdSdkApi
    String getIntroductionInfoUrl();

    @AdSdkApi
    int getMaterialType();

    @AdSdkApi
    String getPermissionInfo();

    @AdSdkApi
    String getPermissionInfoUrl();

    @AdSdkApi
    String getProductName();

    @AdSdkApi
    String getRequestId();

    @AdSdkApi
    String getTitle();

    @AdSdkApi
    AdxImage getVideoCoverImage();

    @AdSdkApi
    int getVideoDuration();

    @AdSdkApi
    int getVideoHeight();

    @AdSdkApi
    int getVideoKeepTime();

    @AdSdkApi
    String getVideoUrl();

    @AdSdkApi
    View getVideoView(Context context, AdVideoPlayConfig adVideoPlayConfig);

    @AdSdkApi
    int getVideoWidth();

    @AdSdkApi
    void reStartInteraction();

    @AdSdkApi
    void registerViewForInteraction(Activity activity, a aVar, ViewGroup viewGroup, Map<View, Integer> map, InteractionConf interactionConf, AdInteractionListener adInteractionListener);

    @AdSdkApi
    void reportAdInfo(int i, String[] strArr);

    @AdSdkApi
    void setAdsListener(a aVar, AdInteractionListener2 adInteractionListener2);

    @AdSdkApi
    void setBidEcpm(long j, long j2);

    @AdSdkApi
    void setVideoPlayListener(VideoPlayListener videoPlayListener);

    @AdSdkDynamicApi
    void showFullScreenVideoAd(Activity activity, AdVideoPlayConfig adVideoPlayConfig, TemplateConf templateConf, FeedCom feedCom);

    @AdSdkDynamicApi
    void showRewardVideoAd(Activity activity, AdVideoPlayConfig adVideoPlayConfig, TemplateConf templateConf, Map<String, Object> map, FeedCom feedCom);

    @AdSdkApi
    void stopInteraction();

    @AdSdkApi
    void traceData(TemplateConf templateConf, FeedCom feedCom, boolean z);

    @AdSdkApi
    void unRegisterViewAction();
}
