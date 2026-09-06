package com.adprof.sdk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class e2 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1140a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final y0 f230a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List f231a;

    public e2(JSONObject jSONObject) {
        this.f1140a = jSONObject.optInt("id");
        jSONObject.optString("name");
        jSONObject.optInt(com.hihonor.adsdk.base.g.j.e.a.hnadsu);
        jSONObject.optInt("slot_type");
        jSONObject.optString("media_slot_key");
        int iOptInt = jSONObject.optInt("timeout");
        if (iOptInt > 0) {
            y6.a().a(iOptInt * 1000);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sdk_config");
        if (jSONObjectOptJSONObject != null) {
            this.f230a = new y0(jSONObjectOptJSONObject);
        } else {
            this.f230a = new y0();
        }
        this.f231a = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("third_sdk_configs");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject2 != null) {
                this.f231a.add(new j2(jSONObjectOptJSONObject2));
            }
        }
    }
}
