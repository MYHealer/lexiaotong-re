package com.hihonor.updater.installsdk.b;

import com.hihonor.updater.installsdk.api.JSONable;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d implements JSONable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f3729a;

    public void a(boolean z) {
        this.f3729a = z;
    }

    @Override // com.hihonor.updater.installsdk.api.JSONable
    public void readFromJSON(String str) {
        try {
            this.f3729a = com.hihonor.updater.installsdk.c.c.a(new JSONObject(str), "showAgreement");
        } catch (Throwable unused) {
            com.hihonor.updater.installsdk.c.a.b("RequestData", "writeToJSON error");
        }
    }

    @Override // com.hihonor.updater.installsdk.api.JSONable
    public JSONObject writeToJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("showAgreement", this.f3729a);
            return jSONObject;
        } catch (Throwable unused) {
            com.hihonor.updater.installsdk.c.a.b("RequestData", "writeToJSON error");
            return jSONObject;
        }
    }
}
