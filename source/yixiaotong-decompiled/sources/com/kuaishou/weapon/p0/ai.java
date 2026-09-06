package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ai {
    public static JSONObject a(Context context) {
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            int i = Integer.parseInt(property2);
            if (TextUtils.isEmpty(property) || i == -1) {
                return null;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, property);
            jSONObject.put("p", i);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
