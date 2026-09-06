package com.hihonor.adsdk.picturetextad;

import com.hihonor.adsdk.base.api.feed.PictureTextExpressAd;
import com.hihonor.adsdk.base.mediation.adn.AdnAdapter;
import com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
class a extends com.hihonor.adsdk.base.mediation.core.imp.b<PictureTextExpressAd> {
    public a(com.hihonor.adsdk.base.mediation.core.imp.a aVar) {
        super(aVar);
    }

    @Override // com.hihonor.adsdk.base.mediation.core.imp.b
    protected BaseAdapter<PictureTextExpressAd> hnadsa() {
        BaseAdapter<PictureTextExpressAd> nativeAd = AdnAdapter.getNativeAd(hnadsn(), this.hnadsf);
        if (nativeAd != null) {
            nativeAd.setAdEventListener(this);
        }
        return nativeAd;
    }
}
