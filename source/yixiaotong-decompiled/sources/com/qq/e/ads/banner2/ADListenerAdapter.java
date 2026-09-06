package com.qq.e.ads.banner2;

import android.text.TextUtils;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.listeners.ADRewardListener;
import com.qq.e.comm.listeners.NegativeFeedbackListener;
import com.qq.e.comm.pi.IReward;
import com.qq.e.comm.util.AdErrorConvertor;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class ADListenerAdapter implements ADListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UnifiedBannerADListener f8461a;
    private NegativeFeedbackListener b;
    private ADRewardListener c;

    ADListenerAdapter(UnifiedBannerADListener unifiedBannerADListener) {
        this.f8461a = unifiedBannerADListener;
    }

    @Override // com.qq.e.comm.adevent.ADListener
    public void onADEvent(ADEvent aDEvent) {
        if (aDEvent == null) {
        }
        int type = aDEvent.getType();
        if (type == 100) {
            UnifiedBannerADListener unifiedBannerADListener = this.f8461a;
            if (unifiedBannerADListener != null) {
                unifiedBannerADListener.onADReceive();
                return;
            }
            return;
        }
        if (type == 101) {
            UnifiedBannerADListener unifiedBannerADListener2 = this.f8461a;
            if (unifiedBannerADListener2 != null) {
                unifiedBannerADListener2.onNoAD(AdErrorConvertor.getAdError(aDEvent));
                return;
            }
            return;
        }
        if (type == 303) {
            UnifiedBannerADListener unifiedBannerADListener3 = this.f8461a;
            if (unifiedBannerADListener3 != null) {
                unifiedBannerADListener3.onADLeftApplication();
                return;
            }
            return;
        }
        if (type == 304) {
            NegativeFeedbackListener negativeFeedbackListener = this.b;
            if (negativeFeedbackListener != null) {
                negativeFeedbackListener.onComplainSuccess();
                return;
            }
            return;
        }
        switch (type) {
            case 103:
                UnifiedBannerADListener unifiedBannerADListener4 = this.f8461a;
                if (unifiedBannerADListener4 != null) {
                    unifiedBannerADListener4.onADExposure();
                }
                break;
            case 104:
                if (this.c != null) {
                    HashMap map = new HashMap();
                    String str = (String) aDEvent.getParam(String.class);
                    if (str != null) {
                        map.put("transId", str);
                    }
                    String str2 = (String) aDEvent.getParam(1, String.class);
                    if (!TextUtils.isEmpty(str2)) {
                        map.put(IReward.DEV_EXT, str2);
                    }
                    this.c.onReward(map);
                }
                break;
            case 105:
                UnifiedBannerADListener unifiedBannerADListener5 = this.f8461a;
                if (unifiedBannerADListener5 != null) {
                    unifiedBannerADListener5.onADClicked();
                }
                break;
            case 106:
                UnifiedBannerADListener unifiedBannerADListener6 = this.f8461a;
                if (unifiedBannerADListener6 != null) {
                    unifiedBannerADListener6.onADClosed();
                }
                break;
        }
    }

    public void setAdRewardListener(ADRewardListener aDRewardListener) {
        this.c = aDRewardListener;
    }

    public void setNegativeFeedbackListener(NegativeFeedbackListener negativeFeedbackListener) {
        this.b = negativeFeedbackListener;
    }
}
