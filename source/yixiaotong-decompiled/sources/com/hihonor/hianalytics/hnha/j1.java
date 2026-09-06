package com.hihonor.hianalytics.hnha;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3649a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_rom_ver", this.h);
            jSONObject.put("_magic_ver", this.f3649a);
            jSONObject.put("_model", Build.MODEL);
            jSONObject.put("_mcc", this.f);
            jSONObject.put("_mnc", this.g);
            jSONObject.put("_package_name", this.b);
            jSONObject.put("_app_ver", this.c);
            jSONObject.put("_lib_ver", "1.0.5.300");
            jSONObject.put("_channel", this.d);
            jSONObject.put("_lib_name", "hianalytics");
            jSONObject.put("_oaid_tracking_flag", this.e);
            jSONObject.put("_brand", this.j);
            jSONObject.put("_app_brand", this.i);
            jSONObject.put("_manufacturer", this.k);
        } catch (JSONException unused) {
            j2.g("RomInfoData", "toJsonObj(): JSON structure Exception: Rom info toJsonObj exception!");
        }
        return jSONObject;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.i = "";
        } else {
            this.i = str;
        }
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.d = str;
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            this.k = "";
        } else {
            this.k = str;
        }
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            this.j = "";
        } else {
            this.j = str;
        }
    }

    public void f(String str) {
        this.e = str;
    }

    public void g(String str) {
        this.f3649a = str;
    }

    public void h(String str) {
        this.f = str;
    }

    public void i(String str) {
        this.g = str;
    }

    public void j(String str) {
        this.b = str;
    }

    public void k(String str) {
        this.h = str;
    }
}
