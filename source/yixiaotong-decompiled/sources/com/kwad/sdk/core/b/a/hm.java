package com.kwad.sdk.core.b.a;

import com.kwad.sdk.kgeo.KGeoInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class hm implements com.kwad.sdk.core.d<KGeoInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((KGeoInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((KGeoInfo) bVar, jSONObject);
    }

    private static void a(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kGeoInfo.latitude = jSONObject.optDouble("latitude");
        kGeoInfo.longitude = jSONObject.optDouble("longitude");
        kGeoInfo.range = jSONObject.optInt("range");
        kGeoInfo.rate = jSONObject.optInt("rate");
    }

    private static JSONObject b(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (kGeoInfo.latitude != 0.0d) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "latitude", kGeoInfo.latitude);
        }
        if (kGeoInfo.longitude != 0.0d) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "longitude", kGeoInfo.longitude);
        }
        if (kGeoInfo.range != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "range", kGeoInfo.range);
        }
        if (kGeoInfo.rate != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "rate", kGeoInfo.rate);
        }
        return jSONObject;
    }
}
