package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class no implements com.kwad.sdk.core.d<AdInfo.UnDownloadConf> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdInfo.UnDownloadConf) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdInfo.UnDownloadConf) bVar, jSONObject);
    }

    private static void a(AdInfo.UnDownloadConf unDownloadConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        unDownloadConf.unDownloadRegionConf = new AdInfo.UnDownloadRegionConf();
        unDownloadConf.unDownloadRegionConf.parseJson(jSONObject.optJSONObject("unDownloadRegionConf"));
    }

    private static JSONObject b(AdInfo.UnDownloadConf unDownloadConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "unDownloadRegionConf", unDownloadConf.unDownloadRegionConf);
        return jSONObject;
    }
}
