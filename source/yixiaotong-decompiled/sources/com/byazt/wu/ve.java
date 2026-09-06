package com.byazt.wu;

import android.text.TextUtils;
import com.ubixnow.ooooo.oOOOoo00;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1128, 54})
public class ve {
    public static int c(Map<String, Object> map) {
        try {
            return ((Integer) map.get("live_saas_param_interaction_type")).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean c(String str) {
        try {
            return (TextUtils.isEmpty(str) || new JSONObject(str).optJSONObject("enter_request") == null || tt(str)) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean tt(String str) {
        JSONObject jSONObjectOptJSONObject;
        try {
            if (TextUtils.isEmpty(str) || (jSONObjectOptJSONObject = new JSONObject(str).optJSONObject("enter_request")) == null) {
                return false;
            }
            int iOptInt = jSONObjectOptJSONObject.optInt("activity_type");
            JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("incr_coupon");
            if (iOptInt == 1 && jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject2.optInt("interaction_type") == 1 && jSONObjectOptJSONObject2.optInt("task_time") > 0 && jSONObjectOptJSONObject2.optLong(oOOOoo00.OooOo0o) > 0) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
