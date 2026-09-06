package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class by {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f4659a;

    public by(Context context) {
        if (Engine.loadSuccess) {
            String strEfg = Engine.getInstance(context).efg();
            if (TextUtils.isEmpty(strEfg)) {
                return;
            }
            try {
                this.f4659a = new JSONObject(strEfg);
            } catch (Exception unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f4659a;
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
