package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class x {
    public JSONArray a(Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            String strE = bf.e();
            if (!TextUtils.isEmpty(strE) && !strE.startsWith("RISK")) {
                JSONArray jSONArray2 = new JSONArray(strE);
                for (int i = 0; i < jSONArray2.length(); i++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("1", jSONArray2.getJSONObject(i).getString("appName"));
                    jSONObject.put("2", jSONArray2.getJSONObject(i).getString(com.hihonor.adsdk.base.c.r1.hnadse));
                    jSONObject.put("3", jSONArray2.getJSONObject(i).getString("appVersion"));
                    jSONObject.put("5", jSONArray2.getJSONObject(i).getString("system_app"));
                    jSONObject.put("6", jSONArray2.getJSONObject(i).getString("firstInstallTime"));
                    jSONObject.put("7", jSONArray2.getJSONObject(i).getString("lastUpdateTime"));
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
