package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f4663a;

    public ca(Context context) {
        if (Engine.loadSuccess) {
            Engine.getInstance(context);
            String strBcd = Engine.bcd();
            if (TextUtils.isEmpty(strBcd) || strBcd.length() <= 2) {
                return;
            }
            try {
                this.f4663a = new JSONObject(strBcd);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f4663a;
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getString(str);
        } catch (Exception unused) {
            return null;
        }
    }
}
