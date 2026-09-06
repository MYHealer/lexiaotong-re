package com.kwad.sdk.core.b.a;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class kp implements com.kwad.sdk.core.d<AdGlobalConfigInfo.RefreshToken> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdGlobalConfigInfo.RefreshToken) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdGlobalConfigInfo.RefreshToken) bVar, jSONObject);
    }

    private static void a(AdGlobalConfigInfo.RefreshToken refreshToken, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        refreshToken.userId = jSONObject.optLong(com.huawei.openalliance.ad.constant.ba.r);
        refreshToken.serviceToken = jSONObject.optString("serviceToken");
        if (JSONObject.NULL.toString().equals(refreshToken.serviceToken)) {
            refreshToken.serviceToken = "";
        }
        refreshToken.userName = jSONObject.optString("userName");
        if (JSONObject.NULL.toString().equals(refreshToken.userName)) {
            refreshToken.userName = "";
        }
        refreshToken.expire = jSONObject.optLong("expire");
        refreshToken.sid = jSONObject.optString(OapsKey.KEY_SUB_ID);
        if (JSONObject.NULL.toString().equals(refreshToken.sid)) {
            refreshToken.sid = "";
        }
    }

    private static JSONObject b(AdGlobalConfigInfo.RefreshToken refreshToken, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (refreshToken.userId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.huawei.openalliance.ad.constant.ba.r, refreshToken.userId);
        }
        if (refreshToken.serviceToken != null && !refreshToken.serviceToken.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "serviceToken", refreshToken.serviceToken);
        }
        if (refreshToken.userName != null && !refreshToken.userName.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "userName", refreshToken.userName);
        }
        if (refreshToken.expire != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "expire", refreshToken.expire);
        }
        if (refreshToken.sid != null && !refreshToken.sid.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, OapsKey.KEY_SUB_ID, refreshToken.sid);
        }
        return jSONObject;
    }
}
