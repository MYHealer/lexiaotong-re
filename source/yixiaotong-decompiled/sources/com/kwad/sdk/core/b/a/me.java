package com.kwad.sdk.core.b.a;

import com.kwad.sdk.internal.api.SplashExtraDataImpl;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class me implements com.kwad.sdk.core.d<SplashExtraDataImpl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((SplashExtraDataImpl) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((SplashExtraDataImpl) bVar, jSONObject);
    }

    private static void a(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashExtraDataImpl.disableShake = jSONObject.optBoolean("disableShake");
        splashExtraDataImpl.disableRotate = jSONObject.optBoolean("disableRotate");
        splashExtraDataImpl.disableSlide = jSONObject.optBoolean("disableSlide");
    }

    private static JSONObject b(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (splashExtraDataImpl.disableShake) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "disableShake", splashExtraDataImpl.disableShake);
        }
        if (splashExtraDataImpl.disableRotate) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "disableRotate", splashExtraDataImpl.disableRotate);
        }
        if (splashExtraDataImpl.disableSlide) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "disableSlide", splashExtraDataImpl.disableSlide);
        }
        return jSONObject;
    }
}
