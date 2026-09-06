package com.byazt.nbs;

import com.byazt.nr.m;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1871, 15})
public class uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2500a;
    public double c;
    public int n;
    public JSONObject sp;
    public double tt;
    public String uj;
    public int ve;

    public double c() {
        return this.c;
    }

    public int getType() {
        return this.ve;
    }

    public boolean n() {
        return this.c <= 0.0d && this.tt <= 0.0d;
    }

    public double tt() {
        return this.tt;
    }

    public String uj() {
        return this.f2500a;
    }

    public int ve() {
        return this.n;
    }

    private uj(double d, double d2, int i, String str, int i2, String str2, JSONObject jSONObject) {
        this.c = d;
        this.tt = d2;
        this.ve = i;
        this.uj = str;
        this.n = i2;
        this.f2500a = str2;
        this.sp = jSONObject;
    }

    public static void c(JSONObject jSONObject, Map<String, uj> map) {
        JSONArray jSONArrayOptJSONArray;
        if (jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray("prime_rits")) == null) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            try {
                String strOptString = jSONArrayOptJSONArray.optString(i);
                try {
                    map.put(strOptString, new uj(jSONObject.optDouble("upper", 0.0d), jSONObject.optDouble("lower", 0.0d), jSONObject.optInt("type"), strOptString, jSONObject.optInt("js_mode"), jSONObject.optString("rule_id"), jSONObject.optJSONObject("refresh_time")));
                } catch (Exception e) {
                    e = e;
                    m.c(e);
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
    }

    public int c(String str) {
        JSONObject jSONObject = this.sp;
        if (jSONObject != null) {
            return jSONObject.optInt(str);
        }
        return 0;
    }
}
