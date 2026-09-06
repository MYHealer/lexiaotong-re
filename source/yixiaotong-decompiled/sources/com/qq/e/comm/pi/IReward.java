package com.qq.e.comm.pi;

import com.qq.e.ads.rewardvideo.ServerSideVerificationOptions;
import com.qq.e.comm.listeners.ADRewardListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface IReward {
    public static final String AD_VIEW = "adView";
    public static final String DEV_EXT = "devExt";

    void setRewardListener(ADRewardListener aDRewardListener);

    void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);
}
