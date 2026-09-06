package com.kwad.components.ad.interstitial.b;

import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b {
    public static boolean dO() {
        return a.mw.getValue().booleanValue();
    }

    public static boolean dP() {
        return a.mq.getValue().intValue() == 1;
    }

    public static int dQ() {
        return a.mr.getValue().intValue();
    }

    public static boolean dR() {
        return a.f4751ms.getValue().intValue() == 1;
    }

    public static boolean dS() {
        return a.mt.getValue().intValue() == 1;
    }

    public static int b(AdInfo adInfo) {
        int iN;
        int iIntValue = a.mu.getValue().intValue();
        if (com.kwad.sdk.core.response.helper.a.bi(adInfo)) {
            iN = com.kwad.sdk.core.response.helper.a.N(adInfo);
            if (iIntValue != 0) {
                return Math.min(iIntValue, iN);
            }
        } else {
            iN = 60;
            if (iIntValue <= 60 && iIntValue > 0) {
                return iIntValue;
            }
        }
        return iN;
    }

    public static boolean dT() {
        return a.mv.getValue().intValue() == 1;
    }

    public static boolean dU() {
        return a.mx.getValue().intValue() == 1;
    }
}
