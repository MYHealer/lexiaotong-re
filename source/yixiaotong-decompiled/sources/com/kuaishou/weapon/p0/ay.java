package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ay {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f4636a;

    public ay(Context context, int i) {
        if (Engine.loadSuccess) {
            try {
                String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(ci.d).intValue(), 2, i < 10 ? 10 : i, "");
                if (TextUtils.isEmpty(strPqr)) {
                    return;
                }
                this.f4636a = new JSONObject(strPqr);
            } catch (Throwable unused) {
            }
        }
    }

    private String b(String str) {
        JSONObject jSONObject = this.f4636a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject a(String str) {
        try {
            String strB = b(str);
            if (TextUtils.isEmpty(strB)) {
                return null;
            }
            return new JSONObject(strB);
        } catch (Exception unused) {
            return null;
        }
    }
}
