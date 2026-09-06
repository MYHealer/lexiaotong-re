package com.hihonor.adsdk.base.mediation.interfaces;

import android.content.Context;
import com.hihonor.adsdk.base.mediation.comm.adevent.a;
import com.hihonor.adsdk.base.widget.base.AdSize;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class BaseNativeExpressAd implements IBaseAd {
    public static final int DEFAULT_PRIORITY = -1;

    public BaseNativeExpressAd(Context context, AdSize adSize, String str, String str2, String str3) {
    }

    public int getAdapterPriority() {
        return -1;
    }

    public abstract void loadAD(int i);

    public void sendLossNotification(int i, int i2, String str) {
    }

    public void sendWinNotification(int i) {
    }

    public abstract void setAdListener(a aVar);

    @Override // com.hihonor.adsdk.base.mediation.interfaces.IBaseAd
    public void setBidECPM(int i) {
    }

    public abstract void setECPMLevel(String str);

    @Override // com.hihonor.adsdk.base.mediation.interfaces.IBaseAd
    public void setPayload(String str) {
    }
}
