package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class e2 implements b2 {
    private long b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        try {
            return Long.parseLong(str) * 1000;
        } catch (NumberFormatException unused) {
            j2.g("V1LifeCycleAdapter", "failed to bisdk convertDuration.");
            return -1L;
        }
    }

    private void c(String str, String str2) throws IllegalAccessException, InvocationTargetException {
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length != 3) {
            return;
        }
        String str3 = strArrSplit[0];
        String str4 = strArrSplit[1];
        String str5 = strArrSplit[2];
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4) || TextUtils.isEmpty(str5)) {
            return;
        }
        long jLongValue = f2.a(str4).longValue();
        long jB = b(str5);
        if (jLongValue <= 0 || jB < 0) {
            return;
        }
        a2.b(new g2(str3, jLongValue), str2);
        a2.a(new g2(str3, jLongValue + jB, jB), str2);
    }

    @Override // com.hihonor.hianalytics.hnha.b2
    public void a(String str) {
        a2.b(str);
    }

    @Override // com.hihonor.hianalytics.hnha.b2
    public void a(String str, String str2) throws IllegalAccessException, InvocationTargetException {
        JSONArray jSONArray;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray2 = new JSONObject(str).getJSONArray("termination");
            if (jSONArray2 == null) {
                return;
            }
            int length = jSONArray2.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray2.getJSONObject(i);
                if (jSONObject != null && jSONObject.has(com.kuaishou.weapon.p0.t.l) && (jSONArray = jSONObject.getJSONArray(com.kuaishou.weapon.p0.t.l)) != null) {
                    int length2 = jSONArray.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        c(jSONArray.getString(i2), str2);
                    }
                }
            }
        } catch (JSONException unused) {
            j2.b("V1LifeCycleAdapter", "Exception occurred in parsing file data.");
        }
    }

    @Override // com.hihonor.hianalytics.hnha.b2
    public void b(String str, String str2) throws IllegalAccessException, InvocationTargetException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (String str3 : str.split(";")) {
            c(str3, str2);
        }
    }
}
