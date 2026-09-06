package com.adprof.sdk;

import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class j2 implements Serializable {
    public j2(JSONObject jSONObject) {
        jSONObject.optInt("slot_id");
        jSONObject.optString("name");
        jSONObject.optInt("platform");
        jSONObject.optString("third_slot_id");
        jSONObject.optInt("slot_type");
        jSONObject.optString(com.hihonor.adsdk.base.g.j.e.a.Q);
        jSONObject.optString("media_slot_sey");
        jSONObject.optBoolean("head_bidding");
        jSONObject.optBoolean("is_bottom");
        jSONObject.optInt("sort_price");
        jSONObject.optInt("imp_freq_by_day");
        jSONObject.optInt("imp_freq_by_hour");
        jSONObject.optInt("min_imp_interval");
    }
}
