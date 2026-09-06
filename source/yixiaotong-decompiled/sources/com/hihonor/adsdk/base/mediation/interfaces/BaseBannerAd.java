package com.hihonor.adsdk.base.mediation.interfaces;

import android.app.Activity;
import android.view.View;
import com.hihonor.adsdk.base.mediation.comm.adevent.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class BaseBannerAd implements IBaseAd {
    public BaseBannerAd(Activity activity, String str, String str2, String str3) {
    }

    public abstract void destroy();

    public abstract View getAdView();

    public abstract boolean isValid();

    public abstract void loadAD();

    public void sendLossNotification(int i, int i2, String str) {
    }

    public void sendWinNotification(int i) {
    }

    public abstract void setAdListener(a aVar);

    public abstract void setAdSize(int i, int i2);

    @Override // com.hihonor.adsdk.base.mediation.interfaces.IBaseAd
    public void setBidECPM(int i) {
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.IBaseAd
    public void setPayload(String str) {
    }
}
