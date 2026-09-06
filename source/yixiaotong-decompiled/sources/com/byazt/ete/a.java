package com.byazt.ete;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 34})
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2164a;
    public String c;
    public String da;
    public JSONArray i;
    public String n;
    public String sl;
    public String sp;
    public float t;
    public String tt;
    public JSONArray u;
    public String uj;
    public String ve;
    public String x;
    public HashMap<String, String> yp = new HashMap<>();

    public String a() {
        return this.tt;
    }

    public void a(String str) {
        this.f2164a = str;
    }

    public HashMap<String, String> c() {
        return this.yp;
    }

    public void c(float f) {
        this.t = f;
    }

    public void c(String str) {
        this.n = str;
    }

    public void c(JSONArray jSONArray) {
        this.u = jSONArray;
    }

    public String da() {
        return this.sp;
    }

    public void da(String str) {
        this.sl = str;
    }

    public String i() {
        return this.f2164a;
    }

    public void i(String str) {
        this.da = str;
    }

    public String n() {
        return this.c;
    }

    public void n(String str) {
        this.uj = str;
    }

    public String sl() {
        return this.x;
    }

    public String sp() {
        return this.ve;
    }

    public void sp(String str) {
        this.sp = str;
    }

    public JSONArray t() {
        return this.i;
    }

    public String tt() {
        return this.n;
    }

    public void tt(String str) {
        this.c = str;
    }

    public void tt(JSONArray jSONArray) {
        this.i = jSONArray;
    }

    public String u() {
        return this.da;
    }

    public JSONArray uj() {
        return this.u;
    }

    public void uj(String str) {
        this.ve = str;
    }

    public float ve() {
        return this.t;
    }

    public void ve(String str) {
        this.tt = str;
    }

    public String x() {
        return this.uj;
    }

    public void x(String str) {
        this.x = str;
    }

    public String yp() {
        return this.sl;
    }

    public a() {
    }

    public a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        uj(jSONObject.optString("developer_name"));
        tt(jSONObject.optString("app_version"));
        tt(jSONObject.optJSONArray("permissions"));
        n(jSONObject.optString("privacy_policy_url"));
        i(jSONObject.optString("package_name"));
        da(jSONObject.optString("app_name"));
        c((float) jSONObject.optDouble("score", 0.0d));
        c(jSONObject.optJSONArray("creative_tags"));
        c(jSONObject.optString("permissions_url"));
        a(jSONObject.optString("desc_url"));
        sp(jSONObject.optString("reg_number"));
        x(jSONObject.optString("reg_url"));
    }

    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.yp.put(str, str2);
    }
}
