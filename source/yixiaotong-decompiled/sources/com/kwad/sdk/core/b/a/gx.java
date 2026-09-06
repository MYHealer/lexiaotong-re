package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class gx implements com.kwad.sdk.core.d<AdMatrixInfo.InstalledActivateInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.InstalledActivateInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.InstalledActivateInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.InstalledActivateInfo installedActivateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        installedActivateInfo.cardSwitch = jSONObject.optBoolean("cardSwitch");
        installedActivateInfo.showTime = jSONObject.optLong("showTime");
    }

    private static JSONObject b(AdMatrixInfo.InstalledActivateInfo installedActivateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (installedActivateInfo.cardSwitch) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cardSwitch", installedActivateInfo.cardSwitch);
        }
        if (installedActivateInfo.showTime != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "showTime", installedActivateInfo.showTime);
        }
        return jSONObject;
    }
}
