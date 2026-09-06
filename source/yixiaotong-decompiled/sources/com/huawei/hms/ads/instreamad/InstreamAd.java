package com.huawei.hms.ads.instreamad;

import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.ReportUrlListener;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class InstreamAd {
    public abstract String getAdSign();

    public abstract String getAdSource();

    public abstract List<AdvertiserInfo> getAdvertiserInfo();

    public abstract BiddingInfo getBiddingInfo();

    public abstract String getCallToAction();

    public abstract String getDspLogo();

    public abstract String getDspName();

    public abstract long getDuration();

    public abstract String getTransparencyTplUrl();

    public abstract String getWhyThisAd();

    public abstract boolean hasAdvertiserInfo();

    public abstract boolean isClicked();

    public abstract boolean isExpired();

    public abstract boolean isImageAd();

    public abstract boolean isShown();

    public abstract boolean isTransparencyOpen();

    public abstract boolean isVideoAd();

    public abstract void sendBiddingFailed(Map<String, Object> map, ReportUrlListener reportUrlListener);

    public abstract void sendBiddingSuccess(Map<String, Object> map, ReportUrlListener reportUrlListener);

    public abstract void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig);
}
