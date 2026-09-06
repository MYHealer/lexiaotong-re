package com.huawei.hms.ads.nativead;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.ads.AdCloseBtnClickListener;
import com.huawei.hms.ads.AdFeedbackListener;
import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.AppInfo;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.Image;
import com.huawei.hms.ads.ReportUrlListener;
import com.huawei.hms.ads.Video;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.VideoOperator;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.hms.ads.utils.NativeListener;
import com.huawei.openalliance.ad.beans.metadata.PromoteInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class NativeAd {

    public static abstract class ChoicesInfo {
        public abstract String getContent();

        public abstract List<Image> getIcons();
    }

    public interface NativeAdLoadedListener {
        void onNativeAdLoaded(NativeAd nativeAd);
    }

    public abstract void destroy();

    public abstract void dislikeAd(DislikeAdReason dislikeAdReason);

    public abstract String getAbilityDetailInfo();

    public abstract String getAdSign();

    public abstract String getAdSource();

    public abstract List<AdvertiserInfo> getAdvertiserInfo();

    public abstract AppInfo getAppInfo();

    public abstract BiddingInfo getBiddingInfo();

    public abstract String getCallToAction();

    public abstract ChoicesInfo getChoicesInfo();

    public abstract int getCreativeType();

    public abstract String getDescription();

    public abstract List<DislikeAdReason> getDislikeAdReasons();

    public abstract String getDspLogo();

    public abstract String getDspName();

    public abstract Map<String, String> getExt();

    public abstract Bundle getExtraBundle();

    public abstract String getHwChannelId();

    public abstract Image getIcon();

    public abstract List<Image> getImages();

    public abstract int getInteractionType();

    public abstract String getMarket();

    public abstract MediaContent getMediaContent();

    public abstract String getPrice();

    public abstract PromoteInfo getPromoteInfo();

    public abstract Double getRating();

    public abstract String getTitle();

    public abstract String getTransparencyTplUrl();

    public abstract String getUniqueId();

    public abstract Video getVideo();

    public abstract VideoOperator getVideoOperator();

    public abstract String getWhyThisAd();

    public abstract void gotoWhyThisAdPage(Context context);

    public abstract boolean hasAdvertiserInfo();

    public abstract boolean isAutoDownloadApp();

    public abstract boolean isCustomClickAllowed();

    public abstract boolean isCustomDislikeThisAdEnabled();

    public abstract boolean isShowAppElement();

    public abstract boolean isTransparencyOpen();

    public abstract void onAdClose(Context context, List<String> list);

    public abstract void recordClickEvent();

    public abstract boolean recordClickEvent(Bundle bundle);

    public abstract boolean recordImpressionEvent(Bundle bundle);

    public abstract boolean recordShowStartEvent(Bundle bundle);

    public abstract void recordTouchEvent(Bundle bundle);

    public abstract void sendBiddingFailed(Map<String, Object> map, ReportUrlListener reportUrlListener);

    public abstract void sendBiddingSuccess(Map<String, Object> map, ReportUrlListener reportUrlListener);

    public abstract void setAdCloseBtnClickListener(AdCloseBtnClickListener adCloseBtnClickListener);

    public abstract void setAdFeedbackListener(AdFeedbackListener adFeedbackListener);

    public abstract void setAllowCustomClick();

    public abstract void setAutoDownloadApp(boolean z);

    public abstract void setDislikeAdListener(DislikeAdListener dislikeAdListener);

    public abstract void setNativeListener(NativeListener nativeListener);

    public abstract void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig);

    public abstract void setVideoConfiguration(VideoConfiguration videoConfiguration);

    public abstract void showAppDetailPage(Context context);

    public abstract void triggerClick(Bundle bundle);
}
