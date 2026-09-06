package com.kwad.components.ad.reward.model;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public enum EcOrderCardStyle {
    SPIKE_AND_COUPON(1),
    SPIKE(2),
    COUPON(3),
    NO_SPIKE_AND_NO_COUPON(4),
    DEFAULT(5);

    private int value;

    public final int getValue() {
        return this.value;
    }

    EcOrderCardStyle(int i) {
        this.value = i;
    }

    public static EcOrderCardStyle createFromAdInfo(AdInfo adInfo) {
        if (!com.kwad.components.ad.reward.a.b.l(adInfo) && !com.kwad.components.ad.reward.a.b.k(adInfo)) {
            return null;
        }
        AdProductInfo adProductInfoDc = com.kwad.sdk.core.response.helper.a.dc(adInfo);
        boolean zHasSpike = adProductInfoDc.hasSpike();
        boolean zHasCoupon = adProductInfoDc.hasCoupon();
        boolean zHasOriginalPrice = adProductInfoDc.hasOriginalPrice();
        if (zHasSpike && zHasCoupon) {
            return SPIKE_AND_COUPON;
        }
        if (zHasSpike) {
            return SPIKE;
        }
        if (zHasCoupon) {
            return COUPON;
        }
        return zHasOriginalPrice ? NO_SPIKE_AND_NO_COUPON : DEFAULT;
    }
}
