package com.kwad.components.core.innerEc.live.video.reconnect;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a implements com.kwad.sdk.core.b {
    public String Uu;
    public JSONObject Uv;
    public String XR;

    public final void a(String str, JSONObject jSONObject) {
        this.Uu = str;
        this.Uv = jSONObject;
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        return this.Uv;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.XR = jSONObject.optString("livePlayData");
        }
    }
}
