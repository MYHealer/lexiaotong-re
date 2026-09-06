package com.hihonor.adsdk.base.f;

import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.common.f.b0;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e extends a {
    public e(BaseAd baseAd) {
        super(baseAd);
    }

    @Override // com.hihonor.adsdk.base.f.f
    public String hnadsa() {
        return "DefaultHandler";
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected void hnadsa(a.b bVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "call startInternal", new Object[0]);
        b0.hnadsc(R.string.ads_page_unsupport);
        hnadsa(true, 0, 0, "Success", bVar);
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected int hnadsb() {
        return -1;
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected boolean hnadsd() {
        return false;
    }
}
