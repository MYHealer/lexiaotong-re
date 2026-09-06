package com.byazt.dbo;

import com.alipay.sdk.tid.b;
import com.ubixnow.ooooo.o0OO000o;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 961, 15})
public class uj {
    public static JSONObject c(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            StringBuilder sb = new StringBuilder("id=");
            sb.append(str).append("&timestamp=");
            sb.append(iCurrentTimeMillis).append("&ext=");
            sb.append(str2);
            String upperCase = com.byazt.nr.a.tt(sb.toString()).toUpperCase();
            jSONObject.put("id", str);
            jSONObject.put(b.f, iCurrentTimeMillis);
            jSONObject.put("sign", upperCase);
            jSONObject.put(o0OO000o.o00O0O0O, str2);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
