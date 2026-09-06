package com.kwad.sdk.k.a;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bj;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int bmt;
    public int bmu;
    public int bmv;

    public b(int i, int i2, int i3) {
        this.bmt = i;
        this.bmu = i2;
        this.bmv = i3;
    }

    public static synchronized b TB() {
        if (!((h) ServiceProvider.get(h.class)).FH()) {
            return null;
        }
        return bj.TB();
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(JSONObject jSONObject) {
        a(this, jSONObject);
        super.afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        return b(this, new JSONObject());
    }

    private static void a(b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.bmt = jSONObject.optInt("cellId", -1);
        bVar.bmu = jSONObject.optInt("lac", -1);
        bVar.bmv = jSONObject.optInt("bsss", -1);
    }

    private static JSONObject b(b bVar, JSONObject jSONObject) {
        ac.putValue(jSONObject, "cellId", bVar.bmt);
        ac.putValue(jSONObject, "lac", bVar.bmu);
        ac.putValue(jSONObject, "bsss", bVar.bmv);
        return jSONObject;
    }
}
