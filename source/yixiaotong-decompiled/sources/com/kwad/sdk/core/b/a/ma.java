package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdProductInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ma implements com.kwad.sdk.core.d<AdProductInfo.SpikeInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdProductInfo.SpikeInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdProductInfo.SpikeInfo) bVar, jSONObject);
    }

    private static void a(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        spikeInfo.endTime = jSONObject.optLong(com.huawei.openalliance.ad.constant.br.f.h);
        spikeInfo.soldStock = jSONObject.optInt("soldStock");
        spikeInfo.originalStock = jSONObject.optInt("originalStock");
    }

    private static JSONObject b(AdProductInfo.SpikeInfo spikeInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (spikeInfo.endTime != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.huawei.openalliance.ad.constant.br.f.h, spikeInfo.endTime);
        }
        if (spikeInfo.soldStock != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "soldStock", spikeInfo.soldStock);
        }
        if (spikeInfo.originalStock != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "originalStock", spikeInfo.originalStock);
        }
        return jSONObject;
    }
}
