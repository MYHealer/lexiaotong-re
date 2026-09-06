package com.oplus.instant.router.d;

import com.oplus.instant.router.Instant;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends Instant.FromBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, String> f5774a = new HashMap();

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public String build() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : this.f5774a.keySet()) {
                jSONObject.put(str, this.f5774a.get(str));
            }
        } catch (JSONException e) {
            com.oplus.instant.router.g.d.a("FromBuilderImpl", e);
        }
        return jSONObject.toString();
    }

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public Instant.FromBuilder set(String str, String str2) {
        this.f5774a.put(str, str2);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public Instant.FromBuilder setScene(String str) {
        this.f5774a.put("m", str);
        return this;
    }

    @Override // com.oplus.instant.router.Instant.FromBuilder
    public Instant.FromBuilder setTraceId(String str) {
        this.f5774a.put("t", str);
        return this;
    }
}
