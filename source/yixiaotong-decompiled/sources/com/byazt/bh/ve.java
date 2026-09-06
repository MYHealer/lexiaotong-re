package com.byazt.bh;

import android.text.TextUtils;
import com.alipay.sdk.util.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 892, 54})
public class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f2003a;
    public String c;
    public c n;
    public String tt;
    public final Map<String, c> uj = new HashMap();
    public boolean ve;

    public Map<String, c> c() {
        return this.uj;
    }

    public String ve() {
        return this.tt;
    }

    public ve(JSONObject jSONObject) {
        this.ve = false;
        String next = jSONObject.keys().next();
        this.tt = next;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
        this.c = jSONObjectOptJSONObject.optString("version");
        boolean zOptBoolean = jSONObjectOptJSONObject.optBoolean("lazyLoad");
        this.ve = zOptBoolean;
        if (zOptBoolean) {
            this.f2003a = jSONObjectOptJSONObject;
        } else {
            c(jSONObjectOptJSONObject);
        }
    }

    private void c(JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("events");
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            c cVar = new c(jSONArrayOptJSONArray.optJSONObject(i));
            this.uj.put(cVar.c(), cVar);
            if (cVar.c().equals(jSONObject.optString("main"))) {
                this.n = cVar;
            }
        }
    }

    public c c(String str) {
        if (this.ve) {
            c(this.f2003a);
        }
        return this.uj.get(str);
    }

    public c tt() {
        if (this.ve) {
            c(this.f2003a);
        }
        return this.n;
    }

    public List<c> c(c cVar, JSONObject jSONObject, Map<String, Object> map) {
        return c(jSONObject, map, cVar.x());
    }

    public List<c> tt(c cVar, JSONObject jSONObject, Map<String, Object> map) {
        return c(jSONObject, map, cVar.i());
    }

    private List<c> c(JSONObject jSONObject, Map<String, Object> map, List<c.C0099c> list) {
        c cVarC;
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (c.C0099c c0099c : list) {
            if (c0099c != null && (cVarC = c(c0099c.c())) != null && c(c0099c.tt(), jSONObject, map)) {
                arrayList.add(cVarC);
            }
        }
        return arrayList;
    }

    public static boolean c(String str, JSONObject jSONObject, Map<String, Object> map) {
        if (TextUtils.isEmpty(str) || map == null) {
            return true;
        }
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    jSONObject.put(key, entry.getValue());
                }
            }
            if (str.startsWith("${") && str.endsWith(i.d)) {
                return Boolean.parseBoolean(com.byazt.kx.c.c(str.substring(2, str.length() - 1)).c(jSONObject).toString());
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public List<c> ve(c cVar, JSONObject jSONObject, Map<String, Object> map) {
        List<c.C0099c> listSp = cVar.sp();
        ArrayList arrayList = new ArrayList();
        for (c.C0099c c0099c : listSp) {
            if (c0099c != null && c(c0099c.tt(), jSONObject, map)) {
                arrayList.add(c(c0099c.c()));
            }
        }
        return arrayList;
    }
}
