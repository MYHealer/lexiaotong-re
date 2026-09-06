package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.online.monitor.block.BlockEvent;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class nk implements com.kwad.sdk.core.d<BlockEvent.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((BlockEvent.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((BlockEvent.a) bVar, jSONObject);
    }

    private static void a(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.beX = jSONObject.optLong("endTimestamp");
        aVar.repeatCount = jSONObject.optInt("repeatCount", new Integer("1").intValue());
        aVar.beY = jSONObject.optBoolean("runIdle");
        aVar.beZ = jSONObject.optString("stackTraceDetail");
        if (JSONObject.NULL.toString().equals(aVar.beZ)) {
            aVar.beZ = "";
        }
        aVar.bfa = jSONObject.optLong("startTimestamp");
    }

    private static JSONObject b(BlockEvent.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (aVar.beX != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "endTimestamp", aVar.beX);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "repeatCount", aVar.repeatCount);
        if (aVar.beY) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "runIdle", aVar.beY);
        }
        if (aVar.beZ != null && !aVar.beZ.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "stackTraceDetail", aVar.beZ);
        }
        if (aVar.bfa != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "startTimestamp", aVar.bfa);
        }
        return jSONObject;
    }
}
