package com.kwad.sdk.core.b.a;

import com.kwad.components.core.innerEc.qcpx.ReceiveQcpxBody;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ko implements com.kwad.sdk.core.d<ReceiveQcpxBody> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((ReceiveQcpxBody) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((ReceiveQcpxBody) bVar, jSONObject);
    }

    private static void a(ReceiveQcpxBody receiveQcpxBody, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        receiveQcpxBody.flowTag = jSONObject.optString("flowTag");
        if (JSONObject.NULL.toString().equals(receiveQcpxBody.flowTag)) {
            receiveQcpxBody.flowTag = "";
        }
        receiveQcpxBody.llsid = jSONObject.optLong(KSUtil.REQUEST_ID);
        receiveQcpxBody.creativeId = jSONObject.optLong("creativeId");
    }

    private static JSONObject b(ReceiveQcpxBody receiveQcpxBody, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (receiveQcpxBody.flowTag != null && !receiveQcpxBody.flowTag.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "flowTag", receiveQcpxBody.flowTag);
        }
        if (receiveQcpxBody.llsid != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, KSUtil.REQUEST_ID, receiveQcpxBody.llsid);
        }
        if (receiveQcpxBody.creativeId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creativeId", receiveQcpxBody.creativeId);
        }
        return jSONObject;
    }
}
