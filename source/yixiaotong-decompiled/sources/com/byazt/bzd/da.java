package com.byazt.bzd;

import com.ubixnow.ooooo.oOOOoo00;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 724, 72})
public class da {
    public static JSONObject c(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    jSONObject.put(jSONObjectOptJSONObject.optString("name"), jSONObjectOptJSONObject.opt(oOOOoo00.OooOo0o));
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
