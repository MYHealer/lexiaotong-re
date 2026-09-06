package com.adprof.sdk;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class a1 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public JSONObject f5a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f1022a = new ArrayList();
    public final List b = new ArrayList();
    public final List c = new ArrayList();

    public a1(JSONObject jSONObject) {
        try {
            try {
                b(jSONObject.optJSONArray("platform"));
            } catch (Throwable th) {
                a(th);
            }
            try {
                c(jSONObject.optJSONArray("slotList"));
            } catch (Throwable th2) {
                a(th2);
            }
            try {
                a(jSONObject.optJSONArray("appList"));
            } catch (Throwable th3) {
                a(th3);
            }
            try {
                this.f5a = jSONObject.optJSONObject("m_ext");
                pk.d("m_ext = " + this.f5a);
            } catch (Exception e) {
                a(e);
            }
        } catch (Throwable th4) {
            a(th4);
        }
    }

    public final void a(Throwable th) {
        oh.b(th);
        pk.b(Log.getStackTraceString(th));
    }

    public final void a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                v0 v0Var = new v0(null, null, 3);
                v0Var.f1468a = jSONObjectOptJSONObject.optString("name");
                v0Var.b = jSONObjectOptJSONObject.optString("package");
                this.c.add(v0Var);
            }
        }
    }

    public final void b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                this.f1022a.add(new r1(jSONObjectOptJSONObject));
            }
        }
    }

    public final void c(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                this.b.add(new e2(jSONObjectOptJSONObject));
            }
        }
    }
}
