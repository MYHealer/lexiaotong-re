package com.kwad.sdk.core.b.a;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.components.core.request.InnerEcLocalLoginInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class gq implements com.kwad.sdk.core.d<InnerEcLocalLoginInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((InnerEcLocalLoginInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((InnerEcLocalLoginInfo) bVar, jSONObject);
    }

    private static void a(InnerEcLocalLoginInfo innerEcLocalLoginInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        innerEcLocalLoginInfo.userId = jSONObject.optLong(com.huawei.openalliance.ad.constant.ba.r);
        innerEcLocalLoginInfo.serviceToken = jSONObject.optString("serviceToken");
        if (JSONObject.NULL.toString().equals(innerEcLocalLoginInfo.serviceToken)) {
            innerEcLocalLoginInfo.serviceToken = "";
        }
        innerEcLocalLoginInfo.expire = jSONObject.optLong("expire");
        innerEcLocalLoginInfo.sid = jSONObject.optString(OapsKey.KEY_SUB_ID);
        if (JSONObject.NULL.toString().equals(innerEcLocalLoginInfo.sid)) {
            innerEcLocalLoginInfo.sid = "";
        }
    }

    private static JSONObject b(InnerEcLocalLoginInfo innerEcLocalLoginInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (innerEcLocalLoginInfo.userId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.huawei.openalliance.ad.constant.ba.r, innerEcLocalLoginInfo.userId);
        }
        if (innerEcLocalLoginInfo.serviceToken != null && !innerEcLocalLoginInfo.serviceToken.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "serviceToken", innerEcLocalLoginInfo.serviceToken);
        }
        if (innerEcLocalLoginInfo.expire != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "expire", innerEcLocalLoginInfo.expire);
        }
        if (innerEcLocalLoginInfo.sid != null && !innerEcLocalLoginInfo.sid.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, OapsKey.KEY_SUB_ID, innerEcLocalLoginInfo.sid);
        }
        return jSONObject;
    }
}
