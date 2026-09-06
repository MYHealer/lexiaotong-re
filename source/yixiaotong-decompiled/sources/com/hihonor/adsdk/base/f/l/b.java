package com.hihonor.adsdk.base.f.l;

import android.text.TextUtils;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends e {
    private static final String hnadsf = "BaiduMiniAppHandler";

    public b(BaseAd baseAd) {
        super(baseAd);
    }

    @Override // com.hihonor.adsdk.base.f.f
    public String hnadsa() {
        return hnadsf;
    }

    @Override // com.hihonor.adsdk.base.f.l.c
    protected String hnadsf() {
        return HnAds.get().getContext().getString(R.string.ads_app_name_bai_du);
    }

    @Override // com.hihonor.adsdk.base.f.l.c
    protected String hnadsg() {
        return (hnadsc() && !TextUtils.isEmpty(this.hnadsa.getAppPackage())) ? this.hnadsa.getAppPackage() : com.hihonor.adsdk.base.c.q.hnadsa;
    }

    @Override // com.hihonor.adsdk.base.f.l.c
    protected int hnadsh() {
        return 108;
    }
}
