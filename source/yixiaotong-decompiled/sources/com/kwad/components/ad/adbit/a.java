package com.kwad.components.ad.adbit;

import com.kwad.sdk.utils.ac;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a {
    public JSONObject bD;
    public Map<String, String> bE;

    public a(JSONObject jSONObject, Map<String, String> map) {
        this.bD = jSONObject;
        this.bE = map;
    }

    public final String Q() {
        for (String str : this.bE.keySet()) {
            ac.putValue(this.bD, str, this.bE.get(str));
        }
        return this.bD.toString();
    }
}
