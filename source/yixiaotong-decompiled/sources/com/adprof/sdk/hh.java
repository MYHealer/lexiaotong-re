package com.adprof.sdk;

import java.util.Map;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class hh extends fh {
    public String A;
    public String B;

    @Override // com.adprof.sdk.fh, com.adprof.sdk.mh
    public String a(Map map) {
        if (m686a(map)) {
            try {
                JSONObject jSONObject = new JSONObject(new JSONTokener(super.a(map)));
                jSONObject.put(com.hihonor.adsdk.base.g.j.e.a.hnadst, this.A);
                jSONObject.put("error_code", this.B);
                return jSONObject.toString();
            } catch (Exception unused) {
            }
        }
        return super.a(map);
    }

    @Override // com.adprof.sdk.mh
    /* JADX INFO: renamed from: a */
    public void mo685a() {
        super.mo685a();
    }
}
