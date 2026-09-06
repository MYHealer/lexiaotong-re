package com.fancy.adsdk.lib.interf;

import android.app.Activity;
import android.os.Bundle;
import com.fancy.adsdk.lib.model.AdError;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface PtgRewardVideoAd extends PtgAd {

    public interface RewardAdInteractionListener {
        void onAdClose();

        void onAdShow();

        void onAdVideoBarClick();

        void onRenderError(AdError adError);

        void onRewardVerify(boolean z, Bundle bundle);

        void onSkippedVideo();

        void onVideoComplete();

        void onVideoError(int i, String str);

        void onVideoPause();

        void onVideoProgressUpdate(long j, long j2);

        void onVideoResume();

        void onVideoStart();
    }

    NativeAdvertData getAdvertData();

    Map<String, Object> getMediaExtraInfo();

    boolean isVideoCached();

    void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener);

    void setRewardAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);

    void showRewardVideoAd(Activity activity);
}
