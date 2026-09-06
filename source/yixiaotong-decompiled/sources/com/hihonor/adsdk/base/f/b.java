package com.hihonor.adsdk.base.f;

import android.content.Context;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.common.f.b0;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends d {
    public b(BaseAd baseAd) {
        super(baseAd);
    }

    @Override // com.hihonor.adsdk.base.f.f
    public String hnadsa() {
        return "AppDirectHandler";
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected void hnadsa(Context context) {
        if (hnadsb(context)) {
            b0.hnadsb(context.getString(R.string.ads_page_unsupport));
        } else {
            b0.hnadsb(context.getString(R.string.ads_app_not_installed));
        }
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected int hnadsb() {
        return 2;
    }

    protected boolean hnadsb(Context context) {
        BaseAd baseAd = this.hnadsa;
        String appPackage = baseAd == null ? "" : baseAd.getAppPackage();
        boolean zHnadsa = com.hihonor.adsdk.base.j.b.hnadsa(context, appPackage);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "isAppInstalled#" + appPackage + " is installed? " + zHnadsa, new Object[0]);
        return zHnadsa;
    }

    @Override // com.hihonor.adsdk.base.f.d
    protected boolean hnadsf() {
        return true;
    }
}
