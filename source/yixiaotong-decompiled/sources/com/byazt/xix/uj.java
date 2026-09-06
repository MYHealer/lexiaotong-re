package com.byazt.xix;

import client.android.yixiaotong.util.TimeUtils;
import com.alipay.sdk.tid.b;
import com.byazt.nr.a;
import com.masget.base.AppConfig;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 664, 15})
public class uj {
    private static String c(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeUtils.FORMATDATETIME1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", "300012449765");
            jSONObject.put("version", "1.0");
            String strC = c(System.currentTimeMillis());
            jSONObject.put(b.f, strC);
            jSONObject.put("appkey", "90E4DEDAD9B1CB57EA1538871ED468A7");
            jSONObject.put("businessType", "3");
            String string = UUID.randomUUID().toString();
            jSONObject.put("traceId", string);
            jSONObject.put("msgId", string);
            jSONObject.put("sign", a.tt("3000124497653" + string + strC + string + "1.090E4DEDAD9B1CB57EA1538871ED468A7"));
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public static String c(String str, String str2) {
        StringBuilder sbAppend = new StringBuilder(str).append("?");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appId", "9386206798");
            jSONObject.put("clientType", "Android-30100");
            jSONObject.put("format", AppConfig.FORMAT);
            jSONObject.put("version", "v1.5");
            String strC = c.c(str2.getBytes(), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC5se07mkN71qsSJHjZ2Z0+Z+4LlLvf2sz7Md38VAa3EmAOvI7vZp3hbAxicL724ylcmisTPtZQhT/9C+25AELqy9PN9JmzKpwoVTUoJvxG4BoyT49+gGVl6s6zo1byNoHUzTfkmRfmC9MC53HvG8GwKP5xtcdptFjAIcgIR7oAWQIDAQAB");
            jSONObject.put("paramKey", strC);
            String strC2 = c.c(true, ("timeStamp=" + System.currentTimeMillis()).getBytes(), str2);
            jSONObject.put("paramStr", strC2);
            String[] strArr = {"9386206798", "Android-30100", AppConfig.FORMAT, strC, strC2, "v1.5"};
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(strArr[i]);
            }
            jSONObject.put("sign", c.c(sb.toString(), "tgIBkg304BUpjGHLSq1wYYb0Xs77pMIm"));
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                sbAppend.append(next).append("=").append(jSONObject.getString(next)).append("&");
            }
            sbAppend.deleteCharAt(sbAppend.length() - 1);
            return sbAppend.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
