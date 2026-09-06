package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.hihonor.hianalytics.util.SystemUtils;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class w2 implements r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3694a;
    private final u2[] b = new u2[4];

    public w2(String str) {
        this.f3694a = str;
    }

    private void a(int i) {
        StringBuilder sbAppend;
        String str;
        if (h.f(this.f3694a, i)) {
            this.b[i] = new u2(this.f3694a, i);
            String strA = com.hihonor.hianalytics.util.e.a(this.f3694a, i);
            String strB = com.hihonor.hianalytics.util.e.b(strA);
            if (!TextUtils.isEmpty(strB)) {
                try {
                    LinkedList linkedList = new LinkedList();
                    JSONArray jSONArray = new JSONArray(strB);
                    if (jSONArray.length() == 0) {
                        return;
                    }
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i2);
                        if (jSONObjectOptJSONObject == null) {
                            j2.a("DirectBootDataMigrationTask", "optJSONObject is null");
                        } else {
                            String strOptString = jSONObjectOptJSONObject.optString(NotificationCompat.CATEGORY_EVENT, "");
                            String str2 = (String) k.c().a(jSONObjectOptJSONObject.optString("event_migration_content", ""), true).second;
                            long jOptLong = jSONObjectOptJSONObject.optLong("eventtime", 0L);
                            int iOptInt = jSONObjectOptJSONObject.optInt("type", 0);
                            String strOptString2 = jSONObjectOptJSONObject.optString("event_session_name", "");
                            int iOptInt2 = jSONObjectOptJSONObject.optInt("event_migration_session_state", 0);
                            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("headerEx");
                            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("commonEx");
                            linkedList.add(new n0(this.f3694a, iOptInt, strOptString, (jSONObjectOptJSONObject2 == null && jSONObjectOptJSONObject3 == null) ? 23 : 24, jOptLong, com.hihonor.hianalytics.util.r.e(), str2, strOptString2, iOptInt2, jSONObjectOptJSONObject2, jSONObjectOptJSONObject3));
                        }
                    }
                    com.hihonor.hianalytics.util.e.a(strA);
                    p2.c().b(linkedList);
                    j2.a("DirectBootDataMigrationTask", "checkAndDoMigration done tag=" + this.f3694a + ",type=" + i + " size:" + linkedList.size());
                    return;
                } catch (Exception e) {
                    j2.b("DirectBootDataMigrationTask", SystemUtils.getDesensitizedException(e));
                    return;
                }
            }
            sbAppend = new StringBuilder("checkAndDoMigration tag=").append(this.f3694a).append(",type=").append(i);
            str = " sp already done";
        } else {
            sbAppend = new StringBuilder("checkAndDoMigration tag=").append(this.f3694a).append(",type=").append(i);
            str = " not have config";
        }
        j2.a("DirectBootDataMigrationTask", sbAppend.append(str).toString());
    }

    @Override // java.lang.Runnable
    public void run() {
        com.hihonor.hianalytics.util.r.a();
        if (TextUtils.isEmpty(this.f3694a)) {
            return;
        }
        com.hihonor.hianalytics.util.r.a();
        for (int i = 0; i <= 3; i++) {
            a(i);
        }
        com.hihonor.hianalytics.util.r.a();
    }
}
