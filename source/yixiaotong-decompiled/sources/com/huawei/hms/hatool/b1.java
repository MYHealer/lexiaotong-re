package com.huawei.hms.hatool;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b1 implements o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4075a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.f4075a);
        jSONObject.put("eventtime", this.d);
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.b);
        jSONObject.put("event_session_name", this.e);
        jSONObject.put("first_session_event", this.f);
        if (TextUtils.isEmpty(this.c)) {
            return null;
        }
        jSONObject.put("properties", new JSONObject(this.c));
        return jSONObject;
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.b = jSONObject.optString(NotificationCompat.CATEGORY_EVENT);
        this.c = jSONObject.optString("properties");
        this.c = n.a(this.c, o0.d().a());
        this.f4075a = jSONObject.optString("type");
        this.d = jSONObject.optString("eventtime");
        this.e = jSONObject.optString("event_session_name");
        this.f = jSONObject.optString("first_session_event");
    }

    public String b() {
        return this.d;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.f4075a;
    }

    public void c(String str) {
        this.d = str;
    }

    public JSONObject d() throws JSONException {
        JSONObject jSONObjectA = a();
        jSONObjectA.put("properties", n.b(this.c, o0.d().a()));
        return jSONObjectA;
    }

    public void d(String str) {
        this.f4075a = str;
    }

    public void e(String str) {
        this.f = str;
    }

    public void f(String str) {
        this.e = str;
    }
}
