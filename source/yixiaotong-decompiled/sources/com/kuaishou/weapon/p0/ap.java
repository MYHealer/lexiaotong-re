package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f4627a;

    public ap(Context context) {
        if (Engine.loadSuccess) {
            try {
                String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(ci.h).intValue(), 0, 0, "");
                if (TextUtils.isEmpty(strPqr)) {
                    return;
                }
                this.f4627a = new JSONObject(strPqr);
            } catch (Throwable unused) {
            }
        }
    }

    public JSONObject a(String str) {
        JSONObject jSONObject = this.f4627a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            return new JSONObject(string);
        } catch (Exception unused) {
            return null;
        }
    }

    public String b(String str) {
        JSONObject jSONObject = this.f4627a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                if (TextUtils.isEmpty(string) || string.contains("{}")) {
                    return null;
                }
                return string;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
