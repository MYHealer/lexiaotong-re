package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.CouponInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class dk implements com.kwad.sdk.core.d<CouponInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((CouponInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((CouponInfo) bVar, jSONObject);
    }

    private static void a(CouponInfo couponInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        couponInfo.displayName = jSONObject.optString("displayName");
        if (JSONObject.NULL.toString().equals(couponInfo.displayName)) {
            couponInfo.displayName = "";
        }
        couponInfo.displayTitle = jSONObject.optString("displayTitle");
        if (JSONObject.NULL.toString().equals(couponInfo.displayTitle)) {
            couponInfo.displayTitle = "";
        }
        couponInfo.displayValue = jSONObject.optString("displayValue");
        if (JSONObject.NULL.toString().equals(couponInfo.displayValue)) {
            couponInfo.displayValue = "";
        }
        couponInfo.displayBase = jSONObject.optString("displayBase");
        if (JSONObject.NULL.toString().equals(couponInfo.displayBase)) {
            couponInfo.displayBase = "";
        }
        couponInfo.displayType = jSONObject.optString("displayType");
        if (JSONObject.NULL.toString().equals(couponInfo.displayType)) {
            couponInfo.displayType = "";
        }
        couponInfo.displayActionWords = jSONObject.optString("displayActionWords");
        if (JSONObject.NULL.toString().equals(couponInfo.displayActionWords)) {
            couponInfo.displayActionWords = "";
        }
        couponInfo.displayDiscount = jSONObject.optString("displayDiscount");
        if (JSONObject.NULL.toString().equals(couponInfo.displayDiscount)) {
            couponInfo.displayDiscount = "";
        }
        couponInfo.startFetchTime = jSONObject.optString("startFetchTime");
        if (JSONObject.NULL.toString().equals(couponInfo.startFetchTime)) {
            couponInfo.startFetchTime = "";
        }
        couponInfo.endFetchTime = jSONObject.optString("endFetchTime");
        if (JSONObject.NULL.toString().equals(couponInfo.endFetchTime)) {
            couponInfo.endFetchTime = "";
        }
    }

    private static JSONObject b(CouponInfo couponInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (couponInfo.displayName != null && !couponInfo.displayName.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "displayName", couponInfo.displayName);
        }
        if (couponInfo.displayTitle != null && !couponInfo.displayTitle.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "displayTitle", couponInfo.displayTitle);
        }
        if (couponInfo.displayValue != null && !couponInfo.displayValue.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "displayValue", couponInfo.displayValue);
        }
        if (couponInfo.displayBase != null && !couponInfo.displayBase.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "displayBase", couponInfo.displayBase);
        }
        if (couponInfo.displayType != null && !couponInfo.displayType.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "displayType", couponInfo.displayType);
        }
        if (couponInfo.displayActionWords != null && !couponInfo.displayActionWords.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "displayActionWords", couponInfo.displayActionWords);
        }
        if (couponInfo.displayDiscount != null && !couponInfo.displayDiscount.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "displayDiscount", couponInfo.displayDiscount);
        }
        if (couponInfo.startFetchTime != null && !couponInfo.startFetchTime.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "startFetchTime", couponInfo.startFetchTime);
        }
        if (couponInfo.endFetchTime != null && !couponInfo.endFetchTime.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "endFetchTime", couponInfo.endFetchTime);
        }
        return jSONObject;
    }
}
