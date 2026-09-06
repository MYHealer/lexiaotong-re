package com.byazt.vq;

import android.text.TextUtils;
import android.util.SparseArray;
import com.alipay.sdk.util.i;
import com.byazt.nr.m;
import com.byazt.omf.x;
import com.byazt.ukr.yp;
import com.masget.base.AppConfig;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 2289, 20})
public class c {
    public static volatile c c;
    public Function<SparseArray<Object>, Object> n;
    public boolean tt = false;
    public boolean uj = false;
    public tt ve;

    public Function<SparseArray<Object>, Object> a() {
        return this.n;
    }

    public void c(tt ttVar) {
        this.ve = ttVar;
    }

    public void c(Function<SparseArray<Object>, Object> function) {
        this.n = function;
    }

    public void n() {
        this.uj = true;
    }

    public void tt() {
        this.tt = true;
    }

    public boolean ve() {
        return this.tt;
    }

    private c() {
    }

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public boolean c(String str, int i, boolean z) {
        return z || c(str) || com.byazt.bp.tt.tt().c(str, i, 101) != null;
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if ("200000000".equals(str)) {
            return true;
        }
        return str.matches("^1[0-9]{8}$");
    }

    public void uj() {
        tt ttVar = this.ve;
        if (ttVar != null) {
            ttVar.c();
        }
    }

    public void c(int i, String str) {
        tt ttVar = this.ve;
        if (ttVar != null) {
            ttVar.c(i, str);
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0050  */
    /* JADX WARN: Code duplicated, block: B:23:0x0055 A[RETURN] */
    public String tt(String str) {
        JSONObject jSONObject;
        JSONObject jSONObjectC;
        String strQ = x.m().q();
        if (TextUtils.isEmpty(strQ) || TextUtils.isEmpty(strQ.trim())) {
            return str;
        }
        try {
            return c(str, "app_ab_version", strQ);
        } catch (Throwable th) {
            m.c(th);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", "app_ab_version");
                jSONObject2.put(AppConfig.FORMAT, str);
                yp.c().c("gm_add_csj_libra_vids", jSONObject2, th);
            } catch (Throwable th2) {
                m.c(th2);
            }
            if (str != null) {
                try {
                    jSONObject = new JSONObject(str);
                } catch (JSONException unused) {
                    jSONObject = null;
                    jSONObjectC = c(jSONObject);
                    if (jSONObjectC != null) {
                        return jSONObjectC.toString();
                    }
                    return null;
                }
            } else {
                jSONObject = null;
            }
            jSONObjectC = c(jSONObject);
            if (jSONObjectC != null) {
                return jSONObjectC.toString();
            }
            return null;
        }
    }

    public JSONObject c(JSONObject jSONObject) {
        String strQ = x.m().q();
        if (TextUtils.isEmpty(strQ)) {
            return jSONObject;
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("app_ab_version", strQ);
                return jSONObject2;
            } catch (JSONException unused) {
                return null;
            }
        }
        try {
            if (jSONObject.has("app_ab_version")) {
                String strOptString = jSONObject.optString("app_ab_version");
                if (TextUtils.isEmpty(strOptString)) {
                    jSONObject.put("app_ab_version", strQ);
                } else {
                    jSONObject.put("app_ab_version", strOptString + "," + strQ);
                }
            } else {
                jSONObject.put("app_ab_version", strQ);
            }
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0050  */
    /* JADX WARN: Code duplicated, block: B:23:0x0055 A[RETURN] */
    public String ve(String str) {
        JSONObject jSONObject;
        JSONObject jSONObjectTt;
        String strQ = x.m().q();
        if (TextUtils.isEmpty(strQ) || TextUtils.isEmpty(strQ.trim())) {
            return str;
        }
        try {
            return c(str, "waterfall_ab_version", strQ);
        } catch (Throwable th) {
            m.c(th);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("type", "waterfall_ab_version");
                jSONObject2.put(AppConfig.FORMAT, str);
                yp.c().c("gm_add_csj_libra_vids", jSONObject2, th);
            } catch (Throwable th2) {
                m.c(th2);
            }
            if (str != null) {
                try {
                    jSONObject = new JSONObject(str);
                } catch (JSONException unused) {
                    jSONObject = null;
                    jSONObjectTt = tt(jSONObject);
                    if (jSONObjectTt != null) {
                        return jSONObjectTt.toString();
                    }
                    return null;
                }
            } else {
                jSONObject = null;
            }
            jSONObjectTt = tt(jSONObject);
            if (jSONObjectTt != null) {
                return jSONObjectTt.toString();
            }
            return null;
        }
    }

    public JSONObject tt(JSONObject jSONObject) {
        String strQ = x.m().q();
        if (TextUtils.isEmpty(strQ)) {
            return jSONObject;
        }
        if (jSONObject == null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("waterfall_ab_version", strQ);
                return jSONObject2;
            } catch (JSONException unused) {
                return null;
            }
        }
        try {
            if (jSONObject.has("waterfall_ab_version")) {
                String strOptString = jSONObject.optString("waterfall_ab_version");
                if (TextUtils.isEmpty(strOptString)) {
                    jSONObject.put("waterfall_ab_version", strQ);
                } else {
                    jSONObject.put("waterfall_ab_version", strOptString + "," + strQ);
                }
            } else {
                jSONObject.put("waterfall_ab_version", strQ);
            }
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }

    private static String c(String str, String str2, String str3) {
        if (str == null || str.trim().isEmpty()) {
            return "{\"" + str2 + "\":\"" + str3 + "\"}";
        }
        String strTrim = str.trim();
        if (!strTrim.startsWith("{") || !strTrim.endsWith(i.d)) {
            return str;
        }
        int iIndexOf = strTrim.indexOf("\"" + str2 + "\"");
        if (iIndexOf != -1) {
            int iIndexOf2 = strTrim.indexOf(58, iIndexOf) + 1;
            while (iIndexOf2 < strTrim.length() && Character.isWhitespace(strTrim.charAt(iIndexOf2))) {
                iIndexOf2++;
            }
            String strSubstring = strTrim.substring(0, iIndexOf2);
            String strSubstring2 = strTrim.substring(iIndexOf2);
            if (strSubstring2.startsWith("\"")) {
                return strSubstring + "\"" + str3 + "," + strSubstring2.substring(1);
            }
            return strSubstring2.startsWith("'") ? strSubstring + "'" + str3 + "," + strSubstring2.substring(1) : str;
        }
        String strTrim2 = strTrim.substring(0, strTrim.length() - 1).trim();
        if (!strTrim2.endsWith(",")) {
            strTrim2 = strTrim2 + ",";
        }
        return strTrim2 + "\"" + str2 + "\":\"" + str3 + "\"}";
    }
}
