package com.kwad.sdk.core.webview.c;

import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e implements com.kwad.sdk.core.b {
    private final String aIt;
    private final int result;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
    }

    public e(int i, String str) {
        this.result = i;
        this.aIt = str;
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "result", this.result);
        ac.putValue(jSONObject, com.hihonor.adsdk.base.g.j.e.a.hnadst, this.aIt);
        return jSONObject;
    }
}
