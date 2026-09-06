package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.request.model.StatusInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class mn implements com.kwad.sdk.core.d<StatusInfo.SplashStyleControl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((StatusInfo.SplashStyleControl) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((StatusInfo.SplashStyleControl) bVar, jSONObject);
    }

    private static void a(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashStyleControl.disableShake = jSONObject.optBoolean("disableShake");
        splashStyleControl.disableRotate = jSONObject.optBoolean("disableRotate");
        splashStyleControl.disableSlide = jSONObject.optBoolean("disableSlide");
    }

    private static JSONObject b(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (splashStyleControl.disableShake) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "disableShake", splashStyleControl.disableShake);
        }
        if (splashStyleControl.disableRotate) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "disableRotate", splashStyleControl.disableRotate);
        }
        if (splashStyleControl.disableSlide) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "disableSlide", splashStyleControl.disableSlide);
        }
        return jSONObject;
    }
}
