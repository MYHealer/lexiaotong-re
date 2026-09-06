package com.hihonor.adsdk.base.api.feed;

import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.NegativeFeedback;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.g.j.d.g;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.g.k.c.c;
import com.hihonor.adsdk.common.b.b;
import com.huawei.openalliance.ad.views.PPSLabelView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a implements AdDislike {
    private static final String hnadsb = "DefaultAdDislikeImpl";
    private BaseAd hnadsa;

    public a(BaseAd baseAd) {
        this.hnadsa = baseAd;
    }

    private void hnadsa(NegativeFeedback negativeFeedback) {
        if (hnadsa() == null || negativeFeedback == null) {
            return;
        }
        new g(this.hnadsa.getAdUnitId(), hnadsa(), negativeFeedback.getDesc()).hnadsa("type", String.valueOf(negativeFeedback.getReason())).hnadse();
        c cVar = new c(negativeFeedback.getDesc());
        BaseAd baseAd = this.hnadsa;
        cVar.hnadsa(baseAd, baseAd.getTrackUrl().getCommons());
    }

    private void hnadsb() {
        if (hnadsa() == null) {
            b.hnadse(hnadsb, "reportByShow but ad is null. ", new Object[0]);
        } else {
            new x(this.hnadsa.getAdUnitId(), hnadsa(), ErrorCode.AD_DISLIKE_SHOW, ErrorCode.STR_AD_DISLIKE_SHOW).hnadse();
        }
    }

    @Override // com.hihonor.adsdk.base.api.feed.AdDislike
    public void onCancel() {
        b.hnadsc(hnadsb, "AdDislike onCancel", new Object[0]);
        hnadsa(NegativeFeedback.POOR_CANCEL);
    }

    @Override // com.hihonor.adsdk.base.api.feed.AdDislike
    public void onSelected(int i, NegativeFeedback negativeFeedback, boolean z) {
        b.hnadsc(hnadsb, "AdDislike onSelected position:" + i + PPSLabelView.Code + negativeFeedback.toString() + " enforce:" + z, new Object[0]);
        hnadsa(negativeFeedback);
    }

    @Override // com.hihonor.adsdk.base.api.feed.AdDislike
    public void onShow() {
        b.hnadsc(hnadsb, "AdDislike onShow", new Object[0]);
        hnadsb();
    }

    private com.hihonor.adsdk.base.g.j.d.h1.a hnadsa() {
        BaseAd baseAd = this.hnadsa;
        if (baseAd == null) {
            b.hnadse(hnadsb, "getAdBean but ad is null. ", new Object[0]);
            return null;
        }
        return com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd);
    }
}
