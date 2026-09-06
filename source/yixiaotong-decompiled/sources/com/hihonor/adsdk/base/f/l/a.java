package com.hihonor.adsdk.base.f.l;

import android.text.TextUtils;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a extends e {
    private static final String hnadsf = "AliPayMiniAppHandler";

    public a(BaseAd baseAd) {
        super(baseAd);
    }

    @Override // com.hihonor.adsdk.base.f.f
    public String hnadsa() {
        return hnadsf;
    }

    @Override // com.hihonor.adsdk.base.f.l.c
    protected String hnadsf() {
        return HnAds.get().getContext().getString(R.string.ads_app_name_zhi_fu_bao);
    }

    @Override // com.hihonor.adsdk.base.f.l.c
    protected String hnadsg() {
        return (hnadsc() && !TextUtils.isEmpty(this.hnadsa.getAppPackage())) ? this.hnadsa.getAppPackage() : com.hihonor.adsdk.base.c.q.hnadsb;
    }

    @Override // com.hihonor.adsdk.base.f.l.c
    protected int hnadsh() {
        return 109;
    }
}
