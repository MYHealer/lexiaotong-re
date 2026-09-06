package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.nativead.monitor.NativeAdMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class jg implements com.kwad.sdk.core.d<NativeAdMonitor.NativeReportMsg> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((NativeAdMonitor.NativeReportMsg) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((NativeAdMonitor.NativeReportMsg) bVar, jSONObject);
    }

    private static void a(NativeAdMonitor.NativeReportMsg nativeReportMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nativeReportMsg.state = jSONObject.optInt("state");
        nativeReportMsg.containerType = jSONObject.optString("container_type");
        if (JSONObject.NULL.toString().equals(nativeReportMsg.containerType)) {
            nativeReportMsg.containerType = "";
        }
        nativeReportMsg.containerName = jSONObject.optString("container_name");
        if (JSONObject.NULL.toString().equals(nativeReportMsg.containerName)) {
            nativeReportMsg.containerName = "";
        }
        nativeReportMsg.height = jSONObject.optInt("height");
        nativeReportMsg.width = jSONObject.optInt("width");
    }

    private static JSONObject b(NativeAdMonitor.NativeReportMsg nativeReportMsg, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (nativeReportMsg.state != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "state", nativeReportMsg.state);
        }
        if (nativeReportMsg.containerType != null && !nativeReportMsg.containerType.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "container_type", nativeReportMsg.containerType);
        }
        if (nativeReportMsg.containerName != null && !nativeReportMsg.containerName.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "container_name", nativeReportMsg.containerName);
        }
        if (nativeReportMsg.height != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "height", nativeReportMsg.height);
        }
        if (nativeReportMsg.width != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "width", nativeReportMsg.width);
        }
        return jSONObject;
    }
}
