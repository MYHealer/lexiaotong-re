package com.byazt.wj;

import android.text.TextUtils;
import com.alipay.sdk.util.i;
import com.byazt.nr.m;
import com.byazt.sa.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1288, 13})
public class tt {
    public static String c(String str, JSONObject jSONObject) {
        c cVarVe;
        c.InterfaceC0314c interfaceC0314cC;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                return (!str.startsWith("${") || !str.endsWith(i.d) || (cVarVe = n.c().ve()) == null || (interfaceC0314cC = cVarVe.c(str.substring(2, str.length() + (-1)))) == null) ? str : (String) interfaceC0314cC.c(jSONObject);
            } catch (Throwable th) {
                m.c(th);
            }
        }
        return str;
    }

    public static Object c(Object obj, JSONObject jSONObject) {
        if (obj == null) {
            return null;
        }
        String strValueOf = String.valueOf(obj);
        if (TextUtils.isEmpty(strValueOf)) {
            return null;
        }
        return (strValueOf.startsWith("${") && strValueOf.endsWith(i.d)) ? c(strValueOf, jSONObject) : obj;
    }
}
