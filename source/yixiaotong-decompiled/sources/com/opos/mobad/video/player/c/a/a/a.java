package com.opos.mobad.video.player.c.a.a;

import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.video.player.c.a.b f8344a;
    private volatile JSONObject b;
    private volatile String c;
    private volatile String d;
    private volatile long e = -1;

    public a(com.opos.mobad.video.player.c.a.b bVar) {
        this.f8344a = bVar;
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.video.player.c.a.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a();
                a.this.d();
                a.this.c();
                a.this.b();
            }
        });
    }

    public JSONObject a() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (this.b != null) {
            return this.b;
        }
        JSONObject jSONObject3 = new JSONObject();
        try {
            com.opos.mobad.video.player.c.a.b bVar = this.f8344a;
            if (bVar != null) {
                String strA = bVar.a();
                if (!TextUtils.isEmpty(strA)) {
                    JSONObject jSONObject4 = new JSONObject(strA);
                    try {
                        JSONObject jSONObjectOptJSONObject = jSONObject4.optJSONObject("extension");
                        jSONObject = jSONObject4;
                        if (jSONObjectOptJSONObject == null) {
                            jSONObject3 = new JSONObject();
                            jSONObject3.put("extension", jSONObject4);
                            jSONObject2 = jSONObject3;
                            jSONObject = jSONObject2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        jSONObject3 = jSONObject4;
                        com.opos.cmn.an.f.a.d("TTLightJSData", "getTTDataJson error", th);
                        jSONObject2 = jSONObject3;
                    }
                    this.b = jSONObject;
                    com.opos.cmn.an.f.a.b("TTLightJSData", "getTTDataJson=" + jSONObject);
                    return jSONObject;
                }
                com.opos.cmn.an.f.a.d("TTLightJSData", "getTTDataJson error", th);
                jSONObject2 = jSONObject3;
                jSONObject = jSONObject2;
                this.b = jSONObject;
                com.opos.cmn.an.f.a.b("TTLightJSData", "getTTDataJson=" + jSONObject);
                return jSONObject;
            }
            return jSONObject3;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public String b() {
        if (this.c != null) {
            return this.c;
        }
        try {
            this.c = "";
            JSONObject jSONObjectA = a();
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject("extension");
            }
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject("easy_playable");
            }
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject("components");
            }
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject(jSONObjectA.has("vertical") ? "vertical" : "horizontal");
            }
            if (jSONObjectA != null) {
                this.c = jSONObjectA.optString("entry");
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("TTLightJSData", "getWebUrl error", th);
        }
        com.opos.cmn.an.f.a.b("TTLightJSData", "getWebUrl=" + this.c);
        return this.c;
    }

    public String c() {
        try {
            if (this.d != null) {
                return this.d;
            }
            com.opos.mobad.video.player.c.a.b bVar = this.f8344a;
            this.d = bVar != null ? bVar.b() : "";
            com.opos.cmn.an.f.a.b("TTLightJSData", "getStatisticUrl=" + this.d);
            return this.d;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("TTLightJSData", "getStatisticUrl error", th);
            return "";
        }
    }

    public long d() {
        if (this.e != -1) {
            return this.e;
        }
        long jOptLong = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
        try {
            JSONObject jSONObjectA = a();
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject("extension");
            }
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject("easy_playable");
            }
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject("components");
            }
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject(jSONObjectA.has("vertical") ? "vertical" : "horizontal");
            }
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject("config");
            }
            if (jSONObjectA != null) {
                JSONArray jSONArrayOptJSONArray = jSONObjectA.optJSONArray("videoControls");
                jSONObjectA = (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) ? null : jSONArrayOptJSONArray.getJSONObject(0);
            }
            if (jSONObjectA != null) {
                jSONObjectA = jSONObjectA.optJSONObject(CrashHianalyticsData.TIME);
            }
            if (jSONObjectA != null) {
                jOptLong = jSONObjectA.optLong("activeTime");
            }
            this.e = jOptLong;
            com.opos.cmn.an.f.a.b("TTLightJSData", "getActiveTime=" + jOptLong);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("TTLightJSData", "getActiveTime error", th);
        }
        return jOptLong;
    }
}
