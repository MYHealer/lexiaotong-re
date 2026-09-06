package com.hihonor.adsdk.base.widget.web.b;

import com.hihonor.adsdk.base.api.BaseAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e implements d {
    private final d hnadsa;

    public e(int i) {
        if (i == 0) {
            this.hnadsa = new b();
        } else {
            this.hnadsa = new c();
        }
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsa(BaseAd baseAd) {
        this.hnadsa.hnadsa(baseAd);
    }

    public void hnadsb(int i) {
        d dVar = this.hnadsa;
        if (dVar instanceof c) {
            ((c) dVar).hnadsb(i);
        }
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsc(String str) {
        this.hnadsa.hnadsc(str);
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsd(String str) {
        this.hnadsa.hnadsd(str);
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadse(String str) {
        this.hnadsa.hnadse(str);
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsa(int i) {
        this.hnadsa.hnadsa(i);
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsa(String str) {
        this.hnadsa.hnadsa(str);
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsb(String str) {
        this.hnadsa.hnadsb(str);
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsa(String str, Integer num, String str2) {
        this.hnadsa.hnadsa(str, num, str2);
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsa(int i, String str) {
        this.hnadsa.hnadsa(i, str);
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsa(int i, int i2) {
        this.hnadsa.hnadsa(i, i2);
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsa() {
        this.hnadsa.hnadsa();
    }

    @Override // com.hihonor.adsdk.base.widget.web.b.d
    public void hnadsa(String str, int i, int i2) {
        this.hnadsa.hnadsa(str, i, i2);
    }
}
