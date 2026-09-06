package com.byazt.bg;

import android.text.TextUtils;
import com.ubixnow.ooooo.oOOOoo00;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1535, 15})
public class uj {
    public final String c;
    public String[] n;
    public final String tt;
    public final String uj;
    public final Map<String, Float> ve = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, n> f2001a = new ConcurrentHashMap();

    public String c() {
        return this.c;
    }

    public Map<String, n> n() {
        return this.f2001a;
    }

    public Map<String, Float> tt() {
        return this.ve;
    }

    public String uj() {
        return this.uj;
    }

    public String[] ve() {
        return this.n;
    }

    public uj(String str, String str2, JSONObject jSONObject) {
        this.c = str;
        this.tt = str2;
        this.uj = jSONObject.optString("symbol");
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("score_fit_type");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            this.n = new String[jSONArrayOptJSONArray.length()];
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                String strOptString = jSONArrayOptJSONArray.optString(i);
                if (!TextUtils.isEmpty(strOptString)) {
                    this.n[i] = strOptString;
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(strOptString);
                    if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.length() > 0) {
                        JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("range");
                        JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray(oOOOoo00.OooOo0o);
                        if (jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0 && jSONArrayOptJSONArray3 != null && jSONArrayOptJSONArray3.length() > 0) {
                            this.f2001a.put(strOptString, new n(strOptString, jSONArrayOptJSONArray2, jSONArrayOptJSONArray3));
                        }
                    }
                }
            }
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("rule_exc_mode");
        if (jSONObjectOptJSONObject2 == null || jSONObjectOptJSONObject2.length() <= 0) {
            return;
        }
        Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.ve.put(next, Float.valueOf((float) jSONObjectOptJSONObject2.optDouble(next, 0.0d)));
        }
    }
}
