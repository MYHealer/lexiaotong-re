package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.model.WebCloseStatus;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class oi implements com.kwad.sdk.core.d<WebCloseStatus> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((WebCloseStatus) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((WebCloseStatus) bVar, jSONObject);
    }

    private static void a(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        webCloseStatus.interactSuccess = jSONObject.optBoolean("interactSuccess");
        webCloseStatus.closeType = jSONObject.optInt("closeType");
    }

    private static JSONObject b(WebCloseStatus webCloseStatus, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (webCloseStatus.interactSuccess) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "interactSuccess", webCloseStatus.interactSuccess);
        }
        if (webCloseStatus.closeType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "closeType", webCloseStatus.closeType);
        }
        return jSONObject;
    }
}
