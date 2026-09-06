package com.byazt.aas;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 54})
public final class ve {
    public static long c;
    public static JSONObject tt;
    public static boolean ve;

    public static void c() {
        if (!com.byazt.omf.x.m().sl()) {
            c |= 1;
        }
        if (!com.byazt.omf.x.m().uj()) {
            c |= 2;
        }
        if (com.byazt.omf.x.m().nu().alist()) {
            return;
        }
        c |= 4;
    }

    public static void c(JSONObject jSONObject) {
        tt = jSONObject;
        if (jSONObject.optBoolean("pglam_getwvid_enable", true)) {
            return;
        }
        c |= 8;
    }

    public static JSONObject tt() {
        JSONObject jSONObject = tt;
        if (jSONObject != null) {
            return jSONObject;
        }
        String str = com.byazt.vif.uj.tt(com.byazt.vxy.c.uj(), com.byazt.ogz.sl.n()).get("pglam", "");
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                tt = jSONObject2;
                return jSONObject2;
            } catch (JSONException e) {
                com.byazt.nr.m.c(e);
            }
        }
        return null;
    }

    public static long ve() {
        if (!ve) {
            c();
            ve = true;
        }
        if (tt == null) {
            JSONObject jSONObjectTt = tt();
            tt = jSONObjectTt;
            if (jSONObjectTt != null) {
                c(jSONObjectTt);
            }
        }
        return c;
    }
}
