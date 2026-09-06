package com.hihonor.adsdk.base.mediation.interfaces;

import android.app.Activity;
import android.content.Context;
import com.hihonor.adsdk.base.mediation.ServerSideVerificationOptions;
import com.hihonor.adsdk.base.mediation.comm.adevent.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class BaseRewardAd implements IBaseAd {
    public BaseRewardAd(Context context, String str, String str2, String str3) {
    }

    public int getAdapterPriority() {
        return -1;
    }

    public abstract String getECPMLevel();

    @Deprecated
    public abstract long getExpireTimestamp();

    public int getRewardAdType() {
        return 0;
    }

    public abstract int getVideoDuration();

    public abstract boolean hasShown();

    public abstract boolean isValid();

    public abstract void loadAD();

    public void sendLossNotification(int i, int i2, String str) {
    }

    public void sendWinNotification(int i) {
    }

    public abstract void setAdListener(a aVar);

    @Override // com.hihonor.adsdk.base.mediation.interfaces.IBaseAd
    public void setBidECPM(int i) {
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.IBaseAd
    public void setPayload(String str) {
    }

    public abstract void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions);

    public abstract void setVolumeOn(boolean z);

    public abstract void showAD();

    public void showAD(Activity activity) {
        showAD();
    }
}
