package com.byazt.pct;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.NewDevice4GDrinkOTA_1, 71})
public final class x {
    public t c;

    public static x c(t tVar) {
        return new x(tVar);
    }

    private x(t tVar) {
        this.c = tVar;
    }

    public <T> T c(String str, Type type) throws JSONException {
        c(str);
        if (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) {
            return (T) new JSONObject(str);
        }
        return (T) this.c.c(str, type);
    }

    public <T> String c(T t) {
        String string;
        if (t == null) {
            return "{}";
        }
        if ((t instanceof JSONObject) || (t instanceof JSONArray)) {
            string = t.toString();
        } else {
            string = this.c.c(t);
        }
        c(string);
        return string;
    }

    private static void c(String str) {
        if (str.startsWith("{") && str.endsWith(com.alipay.sdk.util.i.d)) {
            return;
        }
        i.c(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n ".concat(String.valueOf(str))));
    }
}
