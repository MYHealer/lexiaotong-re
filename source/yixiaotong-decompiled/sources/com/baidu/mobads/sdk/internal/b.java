package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1737a = 0;
    private List<a> b = new ArrayList();

    public List<a> a() {
        return this.b;
    }

    public static b a(String str) {
        b bVar = new b();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f1737a = jSONObject.optInt("n", 0);
            int iOptInt = jSONObject.optInt("enc", 0);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("ad");
            if (iOptInt == 1) {
                String strOptString = jSONObject.optString("ad");
                if (!TextUtils.isEmpty(strOptString)) {
                    String strB = i.b(strOptString);
                    if (!TextUtils.isEmpty(strB)) {
                        jSONArrayOptJSONArray = new JSONArray(strB);
                    }
                }
            }
            bVar.b = a.a(jSONArrayOptJSONArray);
            return bVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return bVar;
        }
    }
}
