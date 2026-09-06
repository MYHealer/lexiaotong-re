package com.oplus.log.c;

import android.os.Process;
import com.kuaishou.weapon.p0.t;
import com.oplus.log.d.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    public final String a(String str, String str2, byte b) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("m", str2);
            jSONObject.put("t", str);
            jSONObject.put(t.d, (int) b);
            jSONObject.put("p", b.e(b.a()));
            jSONObject.put("pid", Process.myPid());
            return jSONObject.toString();
        } catch (JSONException e) {
            if (com.oplus.log.b.c()) {
                e.printStackTrace();
            }
            return "format exception:" + e.toString();
        }
    }
}
