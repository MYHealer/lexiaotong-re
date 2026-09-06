package com.kwad.components.ad.reward.retryReward;

import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bz;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class e {
    private Object BH;

    static class a {
        private static final e BI = new e(0);
    }

    /* synthetic */ e(byte b) {
        this();
    }

    private e() {
    }

    public static e kI() {
        return a.BI;
    }

    public final void e(Object obj) {
        try {
            if (kJ() && (obj instanceof KsRewardVideoAd.KSAdRewardRetryTaskListener)) {
                this.BH = obj;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void onAdRewardRetryTaskNotify(KSAdInfoData kSAdInfoData) {
        try {
            if (kJ()) {
                Object obj = this.BH;
                if (obj instanceof KsRewardVideoAd.KSAdRewardRetryTaskListener) {
                    ((KsRewardVideoAd.KSAdRewardRetryTaskListener) obj).onAdRewardRetryTaskNotify(kSAdInfoData);
                }
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static boolean kJ() {
        return bz.aE(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getApiVersion(), "4.9.20.1");
    }
}
