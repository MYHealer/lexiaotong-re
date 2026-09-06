package com.kwad.sdk.core.b.a;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ap implements com.kwad.sdk.core.d<AdProductInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AdProductInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AdProductInfo) bVar, jSONObject);
    }

    private static void a(AdProductInfo adProductInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adProductInfo.itemId = jSONObject.optLong("itemId");
        adProductInfo.icon = jSONObject.optString(com.huawei.openalliance.ad.constant.x.cL);
        if (JSONObject.NULL.toString().equals(adProductInfo.icon)) {
            adProductInfo.icon = "";
        }
        adProductInfo.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(adProductInfo.name)) {
            adProductInfo.name = "";
        }
        adProductInfo.price = jSONObject.optString(OapsKey.KEY_PRICE);
        if (JSONObject.NULL.toString().equals(adProductInfo.price)) {
            adProductInfo.price = "";
        }
        adProductInfo.originPrice = jSONObject.optString("originPrice");
        if (JSONObject.NULL.toString().equals(adProductInfo.originPrice)) {
            adProductInfo.originPrice = "";
        }
        adProductInfo.couponList = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("couponList");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                CouponInfo couponInfo = new CouponInfo();
                couponInfo.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                adProductInfo.couponList.add(couponInfo);
            }
        }
        adProductInfo.volume = jSONObject.optString("volume");
        if (JSONObject.NULL.toString().equals(adProductInfo.volume)) {
            adProductInfo.volume = "";
        }
        adProductInfo.rating = jSONObject.optString("rating");
        if (JSONObject.NULL.toString().equals(adProductInfo.rating)) {
            adProductInfo.rating = "";
        }
        adProductInfo.seckillInfo = new AdProductInfo.SpikeInfo();
        adProductInfo.seckillInfo.parseJson(jSONObject.optJSONObject("seckillInfo"));
    }

    private static JSONObject b(AdProductInfo adProductInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (adProductInfo.itemId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "itemId", adProductInfo.itemId);
        }
        if (adProductInfo.icon != null && !adProductInfo.icon.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.huawei.openalliance.ad.constant.x.cL, adProductInfo.icon);
        }
        if (adProductInfo.name != null && !adProductInfo.name.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "name", adProductInfo.name);
        }
        if (adProductInfo.price != null && !adProductInfo.price.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, OapsKey.KEY_PRICE, adProductInfo.price);
        }
        if (adProductInfo.originPrice != null && !adProductInfo.originPrice.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "originPrice", adProductInfo.originPrice);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "couponList", adProductInfo.couponList);
        if (adProductInfo.volume != null && !adProductInfo.volume.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "volume", adProductInfo.volume);
        }
        if (adProductInfo.rating != null && !adProductInfo.rating.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "rating", adProductInfo.rating);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "seckillInfo", adProductInfo.seckillInfo);
        return jSONObject;
    }
}
