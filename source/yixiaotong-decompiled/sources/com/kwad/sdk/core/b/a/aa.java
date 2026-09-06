package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class aa implements com.kwad.sdk.core.d<AdMatrixInfo.AdInteractionInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdMatrixInfo.AdInteractionInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdMatrixInfo.AdInteractionInfo) bVar, jSONObject);
    }

    private static void a(AdMatrixInfo.AdInteractionInfo adInteractionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adInteractionInfo.interactiveStyle = jSONObject.optInt("interactiveStyle");
        adInteractionInfo.interactivityDefaultStyle = jSONObject.optInt("interactivityDefaultStyle", new Integer("4").intValue());
        adInteractionInfo.isMediaDisable = jSONObject.optBoolean("isMediaDisable");
        adInteractionInfo.switchDefaultTime = jSONObject.optLong("switchDefaultTime", new Long("1500").longValue());
        adInteractionInfo.shakeInfo = new AdMatrixInfo.ShakeInfo();
        adInteractionInfo.shakeInfo.parseJson(jSONObject.optJSONObject("shakeInfo"));
        adInteractionInfo.rotateInfo = new AdMatrixInfo.RotateInfo();
        adInteractionInfo.rotateInfo.parseJson(jSONObject.optJSONObject("rotateInfo"));
        adInteractionInfo.slideInfo = new AdMatrixInfo.SplashSlideInfo();
        adInteractionInfo.slideInfo.parseJson(jSONObject.optJSONObject("slideInfo"));
        adInteractionInfo.splashActionBarInfo = new AdMatrixInfo.SplashActionBarInfo();
        adInteractionInfo.splashActionBarInfo.parseJson(jSONObject.optJSONObject("actionBarInfo"));
        adInteractionInfo.tkDefaultTimeout = jSONObject.optLong("tkDefaultTimeout", new Long("1500").longValue());
    }

    private static JSONObject b(AdMatrixInfo.AdInteractionInfo adInteractionInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adInteractionInfo.interactiveStyle != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "interactiveStyle", adInteractionInfo.interactiveStyle);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "interactivityDefaultStyle", adInteractionInfo.interactivityDefaultStyle);
        if (adInteractionInfo.isMediaDisable) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isMediaDisable", adInteractionInfo.isMediaDisable);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "switchDefaultTime", adInteractionInfo.switchDefaultTime);
        com.kwad.sdk.utils.ac.a(jSONObject, "shakeInfo", adInteractionInfo.shakeInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "rotateInfo", adInteractionInfo.rotateInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "slideInfo", adInteractionInfo.slideInfo);
        com.kwad.sdk.utils.ac.a(jSONObject, "actionBarInfo", adInteractionInfo.splashActionBarInfo);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "tkDefaultTimeout", adInteractionInfo.tkDefaultTimeout);
        return jSONObject;
    }
}
