package com.hihonor.adsdk.base.f;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.download.marketdownload.OpenMarketPageActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g extends a {
    private static final String hnadsf = "MarketDetailHandler";

    public g(BaseAd baseAd) {
        super(baseAd);
    }

    @Override // com.hihonor.adsdk.base.f.f
    public String hnadsa() {
        return hnadsf;
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected void hnadsa(a.b bVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "start market detail internal.", new Object[0]);
        if (!hnadsc()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "Unable to start market detail page.Cause by baseAd is null.", new Object[0]);
            return;
        }
        Context contextHnadsb = com.hihonor.adsdk.base.a.hnadsa().hnadsb();
        if (contextHnadsb == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "startInternal getResumeActivity context is null", new Object[0]);
            contextHnadsb = HnAds.get().getContext();
        }
        if (contextHnadsb == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "startInternal getContext context is null", new Object[0]);
            hnadsa(false, ErrorCode.AD_MARKET_DETAIL_START_FAIL, 0, "notify popup window show, but there has exception:", bVar);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "startMarketDetailPage context = " + contextHnadsb, new Object[0]);
        if (contextHnadsb instanceof Activity) {
            boolean zHnadsa = com.hihonor.adsdk.base.download.marketdownload.c.hnadsa().hnadsa(this.hnadsa, (Activity) contextHnadsb, this.hnadsb);
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "context is instanceof Activity isJumpMarketDetailSuccess = " + zHnadsa, new Object[0]);
            if (zHnadsa) {
                hnadsa(true, 0, 0, "success", bVar);
                return;
            } else {
                hnadsa(false, ErrorCode.AD_MARKET_DETAIL_START_FAIL, 0, "call MarketDownLoadManager fail.", bVar);
                return;
            }
        }
        Bundle bundle = new Bundle();
        bundle.putInt(com.hihonor.adsdk.base.download.marketdownload.a.hnadsb, 1);
        bundle.putParcelable(com.hihonor.adsdk.base.download.marketdownload.a.hnadsa, this.hnadsa);
        bundle.putInt(com.hihonor.adsdk.base.download.marketdownload.a.hnadsc, this.hnadsb);
        com.hihonor.adsdk.base.bean.f fVarHnadsa = com.hihonor.adsdk.base.j.h.hnadsa(contextHnadsb, OpenMarketPageActivity.class, bundle);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "start market detail Activity code:" + fVarHnadsa.hnadsa() + ",msg=" + fVarHnadsa.hnadsb(), new Object[0]);
        hnadsa(fVarHnadsa.hnadsa() == 0, fVarHnadsa.hnadsa(), 0, fVarHnadsa.hnadsb(), bVar);
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected int hnadsb() {
        return 0;
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected boolean hnadsd() {
        return false;
    }

    @Override // com.hihonor.adsdk.base.f.a
    public void hnadse() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsf, "start market detail Activity fail. not default.", new Object[0]);
    }
}
