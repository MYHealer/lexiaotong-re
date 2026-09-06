package com.kwad.sdk.k.a;

import com.kwad.sdk.utils.ac;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int sensorType = -1;
    public List<Float> bmD = new ArrayList();
    public long timestamp = 0;

    @Override // com.kwad.sdk.core.response.a.a
    public final void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        ac.putValue(jSONObject, "values", this.bmD);
    }

    private void a(e eVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        eVar.sensorType = jSONObject.optInt("sensorType");
        eVar.timestamp = jSONObject.optLong(com.alipay.sdk.tid.b.f);
        super.afterToJson(jSONObject);
    }

    private static JSONObject b(e eVar, JSONObject jSONObject) {
        ac.putValue(jSONObject, "sensorType", eVar.sensorType);
        ac.putValue(jSONObject, com.alipay.sdk.tid.b.f, eVar.timestamp);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObjectB = b(this, new JSONObject());
        afterToJson(jSONObjectB);
        return jSONObjectB;
    }
}
