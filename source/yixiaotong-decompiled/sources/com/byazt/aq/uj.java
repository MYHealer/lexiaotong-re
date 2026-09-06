package com.byazt.aq;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.byazt.nr.m;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1950, 15})
public class uj {
    public List<c> c;
    public String tt;
    public String uj;
    public String ve;

    @com.byazt.zqa.c(c = {0, 1, 1950, AppTypeIdUtil.NewDevice4GBathOTA})
    public static class c {
        public int c;
        public JSONObject tt;
    }

    public static uj c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        uj ujVar = new uj();
        String strOptString = jSONObject.optString("custom_components");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(strOptString);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    c cVar = new c();
                    cVar.c = jSONObjectOptJSONObject.optInt("id");
                    cVar.tt = new JSONObject(jSONObjectOptJSONObject.optString("componentLayout"));
                    arrayList.add(cVar);
                }
            }
        } catch (JSONException e) {
            m.c(e);
        }
        ujVar.c = arrayList;
        ujVar.tt = jSONObject.optString("diff_data");
        ujVar.ve = jSONObject.optString("style_diff");
        ujVar.uj = jSONObject.optString("tag_diff");
        return ujVar;
    }
}
