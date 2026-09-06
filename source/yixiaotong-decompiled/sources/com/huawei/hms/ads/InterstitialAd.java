package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.ads.reward.OnMetadataChangedListener;
import com.huawei.hms.ads.reward.RewardAdListener;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class InterstitialAd {
    private final ab Code;

    public InterstitialAd(Context context) {
        this.Code = new ab(context);
    }

    private AdContentData Code() {
        if (this.Code.Z() != null) {
            return this.Code.Z().q();
        }
        return null;
    }

    public final String getAdId() {
        return this.Code.V();
    }

    public final AdListener getAdListener() {
        return this.Code.Code();
    }

    public final Bundle getAdMetadata() {
        return this.Code.F();
    }

    public final BiddingInfo getBiddingInfo() {
        return this.Code.L();
    }

    public final boolean isLoaded() {
        return this.Code.I();
    }

    public final boolean isLoading() {
        return this.Code.B();
    }

    public final void loadAd(AdParam adParam) {
        this.Code.Code(adParam);
    }

    public void sendBiddingFailed(Map<String, Object> map, ReportUrlListener reportUrlListener) {
        if (getBiddingInfo() == null || HiAd.Code() == null) {
            return;
        }
        HiAd.Code().setReportUrlListener(reportUrlListener);
        HiAd.Code().sendBiddingInfo(map, Code(), getBiddingInfo().getLurl(), false);
        fh.V("InterstitialAd", "sendBiddingFailed result");
    }

    public void sendBiddingSuccess(Map<String, Object> map, ReportUrlListener reportUrlListener) {
        if (getBiddingInfo() == null || HiAd.Code() == null) {
            return;
        }
        HiAd.Code().setReportUrlListener(reportUrlListener);
        HiAd.Code().sendBiddingInfo(map, Code(), getBiddingInfo().getNurl(), true);
        fh.V("InterstitialAd", "sendBiddingSuccess result");
    }

    public final void setAdId(String str) {
        this.Code.Code(str);
    }

    public final void setAdListener(AdListener adListener) {
        this.Code.Code(adListener);
    }

    public final void setAdMetadataListener(OnMetadataChangedListener onMetadataChangedListener) {
        this.Code.Code(onMetadataChangedListener);
    }

    public final void setRewardAdListener(RewardAdListener rewardAdListener) {
        this.Code.Code(rewardAdListener);
    }

    public final void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.Code.Code(rewardVerifyConfig);
    }

    public final void setVideoConfiguration(VideoConfiguration videoConfiguration) {
        this.Code.Code(videoConfiguration);
    }

    @Deprecated
    public final void show() {
        this.Code.D();
    }

    public final void show(Activity activity) {
        this.Code.Code(activity);
    }
}
