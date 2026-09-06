package com.hihonor.adsdk.base.g;

import android.text.TextUtils;
import com.hihonor.adsdk.base.AdSlot;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    private static String hnadsa = "AdParseAdSlot";

    private static String hnadsa(int i) {
        if (2 == i) {
            return com.hihonor.adsdk.base.c.y.hnadsa;
        }
        return 1 == i ? com.hihonor.adsdk.base.c.y.hnadsb : "";
    }

    public static String hnadsa(AdSlot adSlot) {
        if (adSlot == null || TextUtils.isEmpty(adSlot.getAdContext())) {
            return "";
        }
        String strHnadsa = hnadsa(adSlot.getDataType());
        if (TextUtils.isEmpty(strHnadsa)) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject(adSlot.getAdContext());
            return jSONObject.has(strHnadsa) ? String.valueOf(jSONObject.get(strHnadsa)) : "";
        } catch (JSONException e) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "getKeyWords but has JSONException " + e.getMessage(), new Object[0]);
            return "";
        }
    }
}
