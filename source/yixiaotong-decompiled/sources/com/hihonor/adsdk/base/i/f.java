package com.hihonor.adsdk.base.i;

import android.content.Intent;
import android.text.TextUtils;
import com.hihonor.adsdk.base.HnAds;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class f extends a {
    private static final String hnadsc = "StartAppImpl";
    private String hnadsb;

    public f(d dVar) {
        super(dVar);
    }

    @Override // com.hihonor.adsdk.base.i.a
    protected String hnadsa() {
        return hnadsc;
    }

    @Override // com.hihonor.adsdk.base.i.a, com.hihonor.adsdk.base.i.b
    public void hnadsa(c cVar) {
        this.hnadsb = this.hnadsa.hnadsl();
        super.hnadsa(cVar);
    }

    @Override // com.hihonor.adsdk.base.i.a
    protected com.hihonor.adsdk.base.i.i.b hnadsb() {
        if (!TextUtils.isEmpty(this.hnadsb)) {
            return com.hihonor.adsdk.base.i.i.c.hnadsa(this.hnadsb);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "startActivityForRemote#pkg is empty.", new Object[0]);
        return new com.hihonor.adsdk.base.i.i.b.a().hnadsb(1002).hnadsa(1007).hnadsc(1).hnadsa("start activity pkg is null.").hnadsa();
    }

    @Override // com.hihonor.adsdk.base.i.a
    protected com.hihonor.adsdk.base.i.i.b hnadsa(boolean z) {
        Intent launchIntentForPackage;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "startActivityForDefault#StartApp call default.", new Object[0]);
        try {
            launchIntentForPackage = HnAds.get().getContext().getPackageManager().getLaunchIntentForPackage(this.hnadsb);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "startActivityForDefault error msg = " + e.getMessage(), new Object[0]);
            launchIntentForPackage = null;
        }
        return hnadsa(launchIntentForPackage, z, 1005);
    }
}
