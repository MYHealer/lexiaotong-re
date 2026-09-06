package com.kwad.sdk.core.webview.c;

import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b implements com.kwad.sdk.core.b {
    public String bcX;
    public String bcY;
    public String data;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.bcX = jSONObject.optString("action");
        this.data = jSONObject.optString("data");
        this.bcY = jSONObject.optString("callback");
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "action", this.bcX);
        ac.putValue(jSONObject, "data", this.data);
        ac.putValue(jSONObject, "callback", this.bcY);
        return jSONObject;
    }
}
