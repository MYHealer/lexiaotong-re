package com.hihonor.hianalytics.hnha;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3674a;

    public q1(Context context) {
        this.f3674a = context;
    }

    public void a() throws IllegalAccessException, InvocationTargetException {
        String str;
        JSONArray jSONArrayOptJSONArray;
        if (g.n()) {
            List<String> listA = v1.a(this.f3674a);
            o3.a().a("pre_report_url_tag", y1.a(listA, "{url}/getServerInfoWithBackup"));
            String strA = com.hihonor.hianalytics.util.j.a("ro.product.CustCVersion", "");
            j2.c("ServerAddrGetTask", "cust version: %s", strA);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("isoCode", strA);
                byte[] bytes = jSONObject.toString().getBytes("UTF-8");
                m3 m3VarA = o3.a().a(bytes, null, "pre_report_url_tag");
                if (m3VarA.b() == 404) {
                    j2.c("ServerAddrGetTask", "second time to get the pro address");
                    o3.a().a("pre_report_backup_url_tag", y1.a(listA, "{url}/getServerInfo"));
                    m3VarA = o3.a().a(bytes, null, "pre_report_backup_url_tag");
                }
                JSONObject jSONObject2 = new JSONObject(m3VarA.a());
                j2.c("ServerAddrGetTask", "get server add response err code: %s", jSONObject2.optString("resultcode", "-100"));
                ArrayList arrayList = new ArrayList();
                if (jSONObject2.has("serverUrls")) {
                    jSONArrayOptJSONArray = jSONObject2.optJSONArray("serverUrls");
                    if (jSONArrayOptJSONArray != null) {
                        int length = jSONArrayOptJSONArray.length();
                        for (int i = 0; i < length; i++) {
                            String strOptString = jSONArrayOptJSONArray.optString(i, "");
                            if (com.hihonor.hianalytics.util.s.b(strOptString)) {
                                arrayList.add("{url}/common/hioperbatch".replace("{url}", strOptString));
                            }
                        }
                    }
                } else {
                    String strOptString2 = jSONObject2.optString("serverUrl", "");
                    if (com.hihonor.hianalytics.util.s.b(strOptString2)) {
                        arrayList.add("{url}/common/hioperbatch".replace("{url}", strOptString2));
                    }
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(strOptString2);
                    jSONArrayOptJSONArray = jSONArray;
                }
                String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                if (strArr.length <= 0 || jSONArrayOptJSONArray == null) {
                    j2.g("ServerAddrGetTask", "ServerAddrGetTask() No access to preloaded URL");
                    return;
                }
                g.a(strArr);
                g.c(false);
                o3.a().a("preload_url_tag", strArr);
                com.hihonor.hianalytics.util.p.b("global_v2", "upload_url", jSONArrayOptJSONArray.toString());
                com.hihonor.hianalytics.util.p.b("global_v2", "upload_url_time", System.currentTimeMillis());
                return;
            } catch (UnsupportedEncodingException unused) {
                str = "get server address Unsupported Encoding: UTF-8!";
            } catch (JSONException unused2) {
                str = "getUploadServerAddr(): JSON structure Exception!";
            }
        } else {
            str = "ServerAddrGetTask() Not need RetrieveUploadUrl,URL is empty, But the switch is closed !";
        }
        j2.g("ServerAddrGetTask", str);
    }
}
