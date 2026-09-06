package com.hihonor.adsdk.base.h;

import com.hihonor.adsdk.base.bean.BaseAdInfoResp;
import com.hihonor.adsdk.base.net.m;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g extends b {
    public g(int i) {
        super(i);
    }

    @Override // com.hihonor.adsdk.base.h.b
    protected String hnadsa() {
        return com.hihonor.adsdk.base.c.h2.hnadsc;
    }

    @Override // com.hihonor.adsdk.base.h.b
    protected void hnadsa(com.hihonor.adsdk.base.net.e eVar, RequestBody requestBody, com.hihonor.adsdk.base.net.f<BaseAdInfoResp> fVar) {
        m.hnadsb().hnadsc().hnadsc(eVar.hnadsb(), requestBody).hnadsa(fVar);
    }

    @Override // com.hihonor.adsdk.base.h.b
    protected boolean hnadsb() {
        return true;
    }
}
