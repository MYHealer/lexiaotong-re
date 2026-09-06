package com.kwad.sdk.core.request.model;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bf;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c implements com.kwad.sdk.core.b {
    private static c aXn;
    private double latitude;
    private double longitude;
    private int type;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "latitude", this.latitude);
        ac.putValue(jSONObject, "longitude", this.longitude);
        ac.putValue(jSONObject, "type", this.type);
        return jSONObject;
    }

    public static c Ns() {
        c cVar = aXn;
        if (cVar != null) {
            return cVar;
        }
        try {
            aXn = new c();
            com.kwad.sdk.utils.d.a aVarDg = bf.dg(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
            if (aVarDg != null && aVarDg.bsT != null) {
                aXn.latitude = aVarDg.bsT.getLatitude();
                aXn.longitude = aVarDg.bsT.getLongitude();
                aXn.type = aVarDg.type;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return aXn;
    }
}
