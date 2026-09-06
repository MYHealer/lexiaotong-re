package com.kwad.components.core.innerEc.live.reconnect;

import com.kwad.sdk.core.b;
import com.kwad.sdk.core.d.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a implements b {
    public int Ut;
    public String Uu;
    public JSONObject Uv;
    public String XH = "";

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
        if (jSONObject == null) {
            return;
        }
        try {
            this.Ut = jSONObject.optInt("liveErrorCode");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("liveData");
            if (jSONObjectOptJSONObject != null) {
                this.XH = jSONObjectOptJSONObject.toString();
            }
        } catch (Throwable th) {
            c.printStackTraceOnly(th);
        }
    }
}
