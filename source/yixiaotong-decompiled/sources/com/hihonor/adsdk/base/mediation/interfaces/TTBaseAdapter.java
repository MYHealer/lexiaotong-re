package com.hihonor.adsdk.base.mediation.interfaces;

import com.hihonor.adsdk.base.api.BaseExpressAd;
import com.hihonor.adsdk.base.mediation.adn.AdnConfig;
import com.hihonor.adsdk.base.mediation.core.imp.AdapterConstructorBean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class TTBaseAdapter<T extends BaseExpressAd> extends BaseAdapter {
    public TTBaseAdapter(AdapterConstructorBean adapterConstructorBean) {
        super(adapterConstructorBean);
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter
    protected String getAdnType() {
        return "1";
    }

    @Override // com.hihonor.adsdk.base.mediation.interfaces.BaseAdapter
    public String getBrandType() {
        return AdnConfig.a.hnadsb;
    }
}
