package com.kwad.sdk.core.b.a;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class na implements com.kwad.sdk.core.d<com.kwad.sdk.core.h.a.C0745a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.h.a.C0745a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.h.a.C0745a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.h.a.C0745a c0745a, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c0745a.aYX = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("sdk_version");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                c0745a.aYX.add((String) jSONArrayOptJSONArray.opt(i));
            }
        }
        c0745a.aYY = jSONObject.optInt("os_version");
        c0745a.aYZ = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("abi");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                c0745a.aYZ.add((String) jSONArrayOptJSONArray2.opt(i2));
            }
        }
        c0745a.aZa = new ArrayList();
        JSONArray jSONArrayOptJSONArray3 = jSONObject.optJSONArray("brand");
        if (jSONArrayOptJSONArray3 != null) {
            for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                c0745a.aZa.add((String) jSONArrayOptJSONArray3.opt(i3));
            }
        }
    }

    private static JSONObject b(com.kwad.sdk.core.h.a.C0745a c0745a, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "sdk_version", c0745a.aYX);
        if (c0745a.aYY != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "os_version", c0745a.aYY);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "abi", c0745a.aYZ);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "brand", c0745a.aZa);
        return jSONObject;
    }
}
