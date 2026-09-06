package com.hihonor.adsdk.base.i;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class h extends a {
    private static final String hnadsd = "StartDeeplinkImpl";
    private String hnadsb;
    private String hnadsc;

    public h(d dVar) {
        super(dVar);
    }

    @Override // com.hihonor.adsdk.base.i.a
    protected String hnadsa() {
        return hnadsd;
    }

    @Override // com.hihonor.adsdk.base.i.a, com.hihonor.adsdk.base.i.b
    public void hnadsa(c cVar) {
        this.hnadsb = this.hnadsa.hnadsg();
        this.hnadsc = this.hnadsa.hnadsl();
        super.hnadsa(cVar);
    }

    @Override // com.hihonor.adsdk.base.i.a
    protected com.hihonor.adsdk.base.i.i.b hnadsb() {
        if (!TextUtils.isEmpty(this.hnadsb)) {
            return com.hihonor.adsdk.base.i.i.c.hnadsa(this.hnadsb, this.hnadsc);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "startActivityForRemote#deeplink is empty.", new Object[0]);
        return new com.hihonor.adsdk.base.i.i.b.a().hnadsb(1001).hnadsa(1006).hnadsc(1).hnadsa("deeplink is null.").hnadsa();
    }

    @Override // com.hihonor.adsdk.base.i.a
    protected com.hihonor.adsdk.base.i.i.b hnadsa(boolean z) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "Start deeplink for Default. isDefault:" + z, new Object[0]);
        if (TextUtils.isEmpty(this.hnadsb)) {
            int i = z ? 1003 : 1004;
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "start activity for default fail,cause by deeplink is null.", new Object[0]);
            return new com.hihonor.adsdk.base.i.i.b.a().hnadsa(i).hnadsa("start activity for default fail,cause by deeplink is null.").hnadsc(0).hnadsa();
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.hnadsb));
        if (!TextUtils.isEmpty(this.hnadsc)) {
            intent.setPackage(this.hnadsc);
        }
        intent.addFlags(268435456);
        com.hihonor.adsdk.base.i.i.b bVarHnadsa = hnadsa(intent, z, 1004);
        com.hihonor.adsdk.common.b.b.hnadsa(hnadsd, (Object) ("startDeeplinkDefault:deeplink = " + this.hnadsb + ", pkg=" + this.hnadsc));
        if (bVarHnadsa.hnadsa() == 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "Start deeplink Success isDefault:" + z, new Object[0]);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsd, "Start deeplink Fail code=" + bVarHnadsa.hnadsa() + ", msg=" + bVarHnadsa.hnadsc() + ", command=" + bVarHnadsa.hnadsb() + " isDefault:" + z, new Object[0]);
        }
        return bVarHnadsa;
    }
}
