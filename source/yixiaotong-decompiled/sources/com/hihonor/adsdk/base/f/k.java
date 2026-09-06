package com.hihonor.adsdk.base.f;

import android.text.TextUtils;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.widget.web.WebCommonActivity;
import com.hihonor.adsdk.base.widget.web.WebVideoActivity;
import com.hihonor.adsdk.common.f.b0;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class k extends a {
    public k(BaseAd baseAd) {
        super(baseAd);
    }

    @Override // com.hihonor.adsdk.base.f.f
    public String hnadsa() {
        return "WebPageHandler";
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected void hnadsa(a.b bVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "start web detail internal.", new Object[0]);
        if (!hnadsc()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "Unable to start web page.Cause by baseAd is null.", new Object[0]);
            return;
        }
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsa);
        new com.hihonor.adsdk.base.g.j.d.b(this.hnadsa.getSequence(), this.hnadsa.getAdUnitId(), aVarHnadsa).hnadsb(1).hnadsa(-2).hnadsa(this.hnadsa.getLandingPageUrl()).hnadse();
        if (TextUtils.isEmpty(this.hnadsa.getLandingPageUrl())) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "webUrl is empty", new Object[0]);
            com.hihonor.adsdk.base.g.j.d.h1.b bVar2 = new com.hihonor.adsdk.base.g.j.d.h1.b();
            bVar2.hnadsb(String.valueOf(com.hihonor.adsdk.base.j.f.hnadsa(this.hnadsa.getPromotionPurpose())));
            bVar2.hnadsc(String.valueOf(this.hnadsa.getSequence()));
            new com.hihonor.adsdk.base.g.j.d.i(this.hnadsa.getAdUnitId(), aVarHnadsa, bVar2, ErrorCode.d.hnadsk, ErrorCode.d.hnadsl).hnadsa(-2).hnadsa(com.hihonor.adsdk.base.g.j.e.a.L0, String.valueOf(this.hnadsa.getItemPosition())).hnadsa(com.hihonor.adsdk.base.g.j.e.a.w0, String.valueOf(this.hnadsb)).hnadse();
            hnadsa(false, ErrorCode.d.hnadsk, 0, ErrorCode.d.hnadsl, bVar);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "call startWebActivity adType=" + this.hnadsa.getAdType() + ", subType=" + this.hnadsa.getSubType(), new Object[0]);
        if (3 == this.hnadsa.getAdType() || this.hnadsa.getSubType() == 14 || this.hnadsa.getSubType() == 15) {
            WebCommonActivity.hnadsa(this.hnadsa, this.hnadsb);
        } else if (this.hnadsa.getSubType() == 11 || this.hnadsa.getSubType() == 12 || this.hnadsa.getSubType() == 13) {
            WebVideoActivity.hnadsa(this.hnadsa, this.hnadsb);
        } else {
            WebCommonActivity.hnadsa(this.hnadsa, this.hnadsb);
        }
        hnadsa(true, 0, 0, "Success", bVar);
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected int hnadsb() {
        return 1;
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected boolean hnadsd() {
        return false;
    }

    @Override // com.hihonor.adsdk.base.f.a
    public void hnadse() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "start web fail,start default.", new Object[0]);
        b0.hnadsb(HnAds.get().getContext().getString(R.string.ads_page_unsupport));
    }
}
