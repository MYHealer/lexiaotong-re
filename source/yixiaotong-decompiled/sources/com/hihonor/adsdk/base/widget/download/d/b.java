package com.hihonor.adsdk.base.widget.download.d;

import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.widget.download.HnDownloadButton;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends a {
    private static final String hnadsh = "DirectHandler";
    private CharSequence hnadsg;

    public b(HnDownloadButton hnDownloadButton) {
        super(hnDownloadButton);
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadsa(BaseAd baseAd, int i) {
        super.hnadsa(baseAd, i);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsh, "checkAdValidity ad Non-App Promotion (Download)", new Object[0]);
        this.hnadsa.reset(this.hnadsg);
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadsd() {
        hnadsb(0);
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadsd(CharSequence charSequence) {
        if (charSequence == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsh, "setViewText, viewText is null", new Object[0]);
        } else {
            this.hnadsg = charSequence;
        }
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    protected void hnadsa(String str) {
        hnadsd(str);
    }
}
