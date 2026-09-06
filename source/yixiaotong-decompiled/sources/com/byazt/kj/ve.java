package com.byazt.kj;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.byazt.gqp.da;
import com.byazt.nr.m;
import com.byazt.ukr.yp;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 159, 54})
public class ve extends c {
    public String x;

    @Override // com.byazt.kj.c
    public void c(Context context, String str, com.byazt.tjs.tt ttVar, WebResourceResponse webResourceResponse, da daVar, Map<String, Object> map) {
    }

    @Override // com.byazt.kj.c
    public void c(String str, String str2) {
    }

    @Override // com.byazt.kj.c
    public void c(JSONObject jSONObject, String str, da daVar, String str2, String str3, Map<String, String> map, Map<String, Object> map2) {
    }

    @Override // com.byazt.kj.c
    public boolean c(WebView webView) {
        return true;
    }

    @Override // com.byazt.kj.c
    public boolean c(da daVar) {
        return true;
    }

    @Override // com.byazt.kj.c
    public void tt(Context context, String str, com.byazt.tjs.tt ttVar, WebResourceResponse webResourceResponse, da daVar, Map<String, Object> map) {
    }

    @Override // com.byazt.kj.c
    public void c() {
        try {
            this.f2415a.putOpt("req_id", this.ve);
            this.f2415a.put(this.x, new JSONArray());
        } catch (Exception e) {
            m.c(e);
        }
    }

    public ve(com.byazt.tjs.c cVar, String str, String str2, JSONObject jSONObject, String str3, String str4) {
        super(cVar, str, str2, jSONObject, str3, str4);
        this.x = "inspect_data";
    }

    @Override // com.byazt.kj.c
    public void ve() {
        this.c.c(new Runnable() { // from class: com.byazt.kj.ve.1
            @Override // java.lang.Runnable
            public void run() {
                ve.this.uj();
            }
        });
    }

    public void uj() {
        if (this.f2415a == null) {
            return;
        }
        yp.c().uj(this.f2415a.toString(), this.f2415a.optString("req_id"));
    }

    @Override // com.byazt.kj.c
    public void c(String str) {
        int i = this.c.tt().get();
        JSONArray jSONArrayOptJSONArray = this.f2415a.optJSONArray(this.x);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("jump_number", i);
            jSONObject.put("jump_url", str);
            jSONArrayOptJSONArray.put(jSONObject);
            this.f2415a.put("inspect_data", jSONArrayOptJSONArray);
        } catch (Exception e) {
            m.c(e);
        }
    }

    @Override // com.byazt.kj.c
    public void c(com.byazt.tjs.tt ttVar, WebResourceResponse webResourceResponse, da daVar, c.InterfaceC0202c interfaceC0202c) {
        Uri uriC = ttVar.c();
        if (uriC != null) {
            try {
                String string = uriC.toString();
                String lowerCase = "unknown";
                if (daVar != null && daVar.tt() != null) {
                    lowerCase = daVar.tt().trim().toLowerCase();
                }
                JSONObject jSONObjectN = n();
                if (jSONObjectN != null) {
                    JSONArray jSONArrayOptJSONArray = jSONObjectN.optJSONArray(lowerCase);
                    if (jSONArrayOptJSONArray == null) {
                        jSONArrayOptJSONArray = new JSONArray();
                    }
                    jSONArrayOptJSONArray.put(string);
                    jSONObjectN.putOpt(lowerCase, jSONArrayOptJSONArray);
                } else {
                    m.uj("weblp", "error pageCountJson is null");
                }
            } catch (Exception e) {
                m.c(e);
                m.ve("weblp", "error", e);
            }
        }
        interfaceC0202c.c(false, null);
    }

    public JSONObject n() {
        try {
            int i = this.c.tt().get();
            JSONArray jSONArrayOptJSONArray = this.f2415a.optJSONArray(this.x);
            if (jSONArrayOptJSONArray == null) {
                return null;
            }
            int length = jSONArrayOptJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i2);
                int iOptInt = jSONObject.optInt("jump_number", -1);
                if (iOptInt != -1 && iOptInt == i) {
                    return jSONObject;
                }
            }
        } catch (Exception e) {
            m.c(e);
        }
        return null;
    }
}
