package com.hihonor.hianalytics.hnha;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class i1 {
    private String c;
    private String e;
    private String f;
    private String g;
    private String h;
    private JSONObject i;
    private String j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3646a = "1";
    private String b = "1";
    private String d = "";

    public JSONObject a() {
        JSONObject jSONObject = this.i;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("protocol_version", this.f3646a);
            jSONObject.put("compress_mode", this.b);
            jSONObject.put("serviceid", this.f);
            jSONObject.put("appid", this.c);
            jSONObject.put("servicetag", this.g);
            jSONObject.put("hmac", this.d);
            jSONObject.put("chifer", this.j);
            jSONObject.put(com.alipay.sdk.tid.b.f, this.e);
            jSONObject.put("requestid", this.h);
        } catch (JSONException unused) {
            j2.g("HeadData", "headData - toJsonObj():JSON structure Exception!");
        }
        return jSONObject;
    }

    public void a(String str) {
        this.j = str;
    }

    public void a(JSONObject jSONObject) {
        this.i = jSONObject;
    }

    public void b(String str) {
        this.c = str;
    }

    public void c(String str) {
        this.h = str;
    }

    public void d(String str) {
        this.f = str;
    }

    public void e(String str) {
        this.g = str;
    }
}
