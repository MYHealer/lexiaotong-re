package com.byazt.lw;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2104, 110})
public class qy implements com.byazt.dr.c {
    public final String c;

    @Override // com.byazt.dr.c
    public String tt() {
        return this.c;
    }

    public qy(String str) {
        this.c = str;
    }

    @Override // com.byazt.dr.c
    public Object c(Map<String, JSONObject> map) {
        Object objC;
        if (map == null || map.size() <= 0 || (objC = c(this.c, map.get("default_key"))) == JSONObject.NULL) {
            return null;
        }
        return objC;
    }

    @Override // com.byazt.dr.c
    public com.byazt.zg.n c() {
        return com.byazt.zg.a.VARIABLE;
    }

    public String toString() {
        return "VariableNode [literals=" + this.c + "]";
    }

    public Object c(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return c(str.split("\\."), 0, jSONObject);
    }

    private Object c(String[] strArr, int i, JSONObject jSONObject) {
        Object objOpt;
        if (strArr != null && strArr.length > 0 && i < strArr.length && jSONObject != null) {
            String str = strArr[i];
            int iIndexOf = str.indexOf("[");
            int iIndexOf2 = str.indexOf("]");
            if (iIndexOf < 0 || iIndexOf2 < 0 || iIndexOf > iIndexOf2) {
                objOpt = jSONObject.opt(str);
            } else {
                String strSubstring = str.substring(0, iIndexOf);
                try {
                    int i2 = Integer.parseInt(str.substring(iIndexOf + 1, iIndexOf2));
                    Object objOpt2 = jSONObject.opt(strSubstring);
                    objOpt = objOpt2 instanceof JSONArray ? ((JSONArray) objOpt2).opt(i2) : null;
                } catch (NumberFormatException e) {
                    com.byazt.nr.m.c(e);
                    return null;
                }
            }
            if (i == strArr.length - 1) {
                return objOpt;
            }
            if (objOpt instanceof String) {
                try {
                    return c(strArr, i + 1, new JSONObject((String) objOpt));
                } catch (JSONException e2) {
                    com.byazt.nr.m.c(e2);
                    return objOpt;
                }
            }
            if (objOpt instanceof JSONObject) {
                return c(strArr, i + 1, (JSONObject) objOpt);
            }
        }
        return null;
    }
}
