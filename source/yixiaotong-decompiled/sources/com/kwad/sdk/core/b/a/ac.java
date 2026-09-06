package com.kwad.sdk.core.b.a;

import com.kwad.sdk.commercial.convert.AdLinkMonitorMsg;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ac implements com.kwad.sdk.core.d<AdLinkMonitorMsg> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdLinkMonitorMsg) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdLinkMonitorMsg) bVar, jSONObject);
    }

    private static void a(AdLinkMonitorMsg adLinkMonitorMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adLinkMonitorMsg.status = jSONObject.optInt("status");
        adLinkMonitorMsg.durationTime = jSONObject.optLong("duration_time");
        adLinkMonitorMsg.renderType = jSONObject.optInt(com.hihonor.adsdk.base.g.j.e.a.S0);
        adLinkMonitorMsg.adStyle = jSONObject.optInt("ad_style");
        adLinkMonitorMsg.materialLoadType = jSONObject.optInt("material_load_type");
    }

    private static JSONObject b(AdLinkMonitorMsg adLinkMonitorMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adLinkMonitorMsg.status != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "status", adLinkMonitorMsg.status);
        }
        if (adLinkMonitorMsg.durationTime != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "duration_time", adLinkMonitorMsg.durationTime);
        }
        if (adLinkMonitorMsg.renderType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.hihonor.adsdk.base.g.j.e.a.S0, adLinkMonitorMsg.renderType);
        }
        if (adLinkMonitorMsg.adStyle != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "ad_style", adLinkMonitorMsg.adStyle);
        }
        if (adLinkMonitorMsg.materialLoadType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "material_load_type", adLinkMonitorMsg.materialLoadType);
        }
        return jSONObject;
    }
}
