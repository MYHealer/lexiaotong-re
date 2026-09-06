package com.hihonor.hianalytics.hnha;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.ba;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3633a = b.b().a();
    private String b = b.b().e();
    private String c = b.b().d();

    public e(Context context) {
    }

    private String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ba.r, this.b);
        } catch (JSONException unused) {
            j2.g("ABTest/SyncDataTask", "getBody: json exception");
        }
        return jSONObject.toString();
    }

    private Map<String, String> a(String str) {
        String str2 = this.f3633a;
        String strC = g.c();
        String strValueOf = String.valueOf(System.currentTimeMillis());
        String strReplace = UUID.randomUUID().toString().replace(com.huawei.openalliance.ad.constant.x.A, "");
        StringBuilder sb = new StringBuilder();
        sb.append(strC).append("|");
        sb.append(strValueOf).append("|");
        sb.append(strReplace).append("|");
        int iIndexOf = str2.indexOf("?");
        sb.append(iIndexOf != -1 ? str2.substring(iIndexOf + 1, str2.length()) : "").append("|");
        sb.append(str);
        String strA = com.hihonor.hianalytics.util.i.a(com.hihonor.hianalytics.util.i.a(sb.toString(), this.c));
        HashMap map = new HashMap();
        map.put("appId", strC);
        map.put(com.alipay.sdk.tid.b.f, strValueOf);
        map.put("random", strReplace);
        map.put("sign", strA);
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        j2.c("ABTest/SyncDataTask", "sync data running..");
        String strA = a();
        try {
            m3 m3VarA = l3.a(this.f3633a + "/api/gateway/ab/api/service/shunting/hasdk/api/v1/getuserparameters", strA.getBytes("UTF-8"), a(strA));
            j2.c("ABTest/SyncDataTask", "get experimental data request code : " + m3VarA.b());
            String strA2 = m3VarA.a();
            if (!TextUtils.isEmpty(strA2)) {
                try {
                    b.b().c(strA2);
                    j2.c("ABTest/SyncDataTask", "Start caching data!");
                    SharedPreferences.Editor editorEdit = com.hihonor.hianalytics.util.p.c("abtest").edit();
                    editorEdit.putString("exp_data", (String) s1.b(strA2, r1.c().b()).second);
                    editorEdit.putLong("expdata_refresh_time", System.currentTimeMillis());
                    editorEdit.commit();
                } catch (JSONException unused) {
                    j2.g("ABTest/SyncDataTask", "experiment data error");
                }
            }
        } catch (IOException unused2) {
            j2.g("ABTest/SyncDataTask", "getBody: body to bytes error!");
        }
        b.b().a(true);
        b.b().b(false);
    }
}
