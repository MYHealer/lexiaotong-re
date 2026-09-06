package com.byazt.rob;

import com.byazt.aas.nb;
import com.byazt.ete.ic;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1211, 54})
public class ve {
    public static void c(ic icVar, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put("second_page_type", i);
        } catch (JSONException unused) {
        }
        com.byazt.ddx.uj.tt(icVar, "second_page_jsb_invoke", jSONObject);
    }

    public static void c(ic icVar, boolean z, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put("second_page_type", i);
            jSONObject.put("origin_req_id", nb.u(icVar));
            jSONObject.put("error_code", i2);
        } catch (JSONException unused) {
        }
        com.byazt.ddx.uj.tt(icVar, "second_page_request", jSONObject);
    }

    public static void tt(ic icVar, boolean z, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put("second_page_type", i);
            jSONObject.put("origin_req_id", nb.u(icVar));
            jSONObject.put("error_code", i2);
        } catch (JSONException unused) {
        }
        com.byazt.ddx.uj.tt(icVar, "second_page_show", jSONObject);
    }
}
