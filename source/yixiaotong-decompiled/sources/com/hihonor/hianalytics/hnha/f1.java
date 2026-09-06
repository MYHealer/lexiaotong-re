package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import com.huawei.hms.ads.jsb.constant.Constant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3637a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f = "";
    private String g;
    private String h;
    private String i;
    private String j;
    private JSONObject k;
    private String l;

    public JSONObject a() {
        JSONObject jSONObject = this.k;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("androidid", this.f3637a);
            jSONObject.put("imei", this.b);
            jSONObject.put(Constant.MAP_KEY_UUID, this.c);
            jSONObject.put("udid", this.f);
            jSONObject.put("oaid", this.d);
            jSONObject.put("honor_oaid", this.e);
            jSONObject.put("upid", this.g);
            jSONObject.put("sn", this.h);
            jSONObject.put("upid_brand", this.l);
            jSONObject.put("statInfo", this.i);
            jSONObject.put("processName", this.j);
        } catch (JSONException unused) {
            j2.g("AppInfoData", " When toJsonObj() executed has JSON Exception happened");
        }
        return jSONObject;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.l = "";
        } else {
            this.l = str;
        }
    }

    public void a(JSONObject jSONObject) {
        this.k = jSONObject;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f3637a = "";
        } else {
            this.f3637a = str;
        }
    }

    public void c(String str) {
        this.e = str;
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            this.b = "";
        } else {
            this.b = str;
        }
    }

    public void e(String str) {
        this.d = str;
    }

    public void f(String str) {
        this.j = str;
    }

    public void g(String str) {
        this.h = str;
    }

    public void h(String str) {
        if (str != null) {
            this.f = str;
        }
    }

    public void i(String str) {
        this.g = str;
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            this.c = "";
        } else {
            this.c = str;
        }
    }
}
