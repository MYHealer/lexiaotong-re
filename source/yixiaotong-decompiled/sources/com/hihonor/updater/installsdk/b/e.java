package com.hihonor.updater.installsdk.b;

import com.hihonor.updater.installsdk.api.JSONable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e implements JSONable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f3730a;
    private String b;
    private String c;

    public e() {
    }

    public e(int i, String str, String str2) {
        this.f3730a = i;
        this.b = str;
        this.c = str2;
    }

    public int a() {
        return this.f3730a;
    }

    public void a(int i) {
        this.f3730a = i;
    }

    public void a(String str) {
        this.c = str;
    }

    public String b() {
        return this.c;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.b;
    }

    @Override // com.hihonor.updater.installsdk.api.JSONable
    public void readFromJSON(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f3730a = com.hihonor.updater.installsdk.c.c.b(jSONObject, "code");
            this.b = com.hihonor.updater.installsdk.c.c.d(jSONObject, "msg");
            this.c = com.hihonor.updater.installsdk.c.c.d(jSONObject, "data");
        } catch (JSONException unused) {
        }
    }

    @Override // com.hihonor.updater.installsdk.api.JSONable
    public JSONObject writeToJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("code", this.f3730a);
            String str = this.b;
            String str2 = "";
            if (str == null) {
                str = "";
            }
            jSONObject.put("msg", str);
            String str3 = this.c;
            if (str3 != null) {
                str2 = str3;
            }
            jSONObject.put("data", str2);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
