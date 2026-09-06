package com.byazt.ek;

import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 2014, 13})
public class tt {
    public static JSONObject c(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            String strDecode = URLDecoder.decode(str, "UTF-8");
            int iIndexOf = strDecode.indexOf(63);
            if (iIndexOf == -1) {
                return jSONObject;
            }
            Matcher matcher = Pattern.compile("([^&=]+)=((?:\\$\\{[^}]+\\})|[^&]+)").matcher(strDecode.substring(iIndexOf + 1));
            while (matcher.find()) {
                jSONObject.put(matcher.group(1), matcher.group(2));
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
