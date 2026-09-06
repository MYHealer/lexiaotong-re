package com.kwad.sdk.core.request.model;

import com.kwad.sdk.core.network.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e implements com.kwad.sdk.core.b {
    private com.kwad.sdk.core.b aXr;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    public static e Nv() {
        e eVar = new e();
        try {
            eVar.aXr = ((k) ServiceProvider.get(k.class)).Fp();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return eVar;
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.a(jSONObject, "modeInfo", this.aXr);
        return jSONObject;
    }
}
