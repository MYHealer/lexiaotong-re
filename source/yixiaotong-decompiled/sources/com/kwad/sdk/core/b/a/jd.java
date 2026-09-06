package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class jd implements com.kwad.sdk.core.d<StatusInfo.NativeAdStyleControl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((StatusInfo.NativeAdStyleControl) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((StatusInfo.NativeAdStyleControl) bVar, jSONObject);
    }

    private static void a(StatusInfo.NativeAdStyleControl nativeAdStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeAdStyleControl.enableShake = jSONObject.optBoolean("enableShake");
        nativeAdStyleControl.enableRotate = jSONObject.optBoolean("enableRotate");
    }

    private static JSONObject b(StatusInfo.NativeAdStyleControl nativeAdStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (nativeAdStyleControl.enableShake) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "enableShake", nativeAdStyleControl.enableShake);
        }
        if (nativeAdStyleControl.enableRotate) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "enableRotate", nativeAdStyleControl.enableRotate);
        }
        return jSONObject;
    }
}
