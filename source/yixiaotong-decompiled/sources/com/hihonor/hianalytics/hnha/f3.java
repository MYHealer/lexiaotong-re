package com.hihonor.hianalytics.hnha;

import com.hihonor.hianalytics.module.config.HiAnalyticsAutoConfig;
import com.hihonor.hianalytics.util.SystemUtils;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class f3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<String, e3> f3638a = new ConcurrentHashMap<>();

    public void a(String str, int i, String str2, long j, JSONObject jSONObject) {
        e3 e3VarPutIfAbsent;
        try {
            if (!com.hihonor.hianalytics.util.g.d(str2)) {
                j2.a("SessionHandler", "handleEventSession eventId=" + str2);
                return;
            }
            HiAnalyticsAutoConfig hiAnalyticsAutoConfigD = h.d(str);
            if (hiAnalyticsAutoConfigD != null && hiAnalyticsAutoConfigD.isAutoSessionOpen()) {
                ConcurrentHashMap<String, e3> concurrentHashMap = f3638a;
                e3 e3Var = concurrentHashMap.get(str);
                ((e3Var != null || (e3VarPutIfAbsent = concurrentHashMap.putIfAbsent(str, (e3Var = new e3(str, hiAnalyticsAutoConfigD)))) == null) ? e3Var : e3VarPutIfAbsent).a(i, str2, j, jSONObject);
                return;
            }
            j2.a("SessionHandler", "handleEventSession tag=" + str + ",illegal autoConfig=" + hiAnalyticsAutoConfigD);
        } catch (Throwable th) {
            j2.g("SessionHandler", "handleEventSession failE=" + SystemUtils.getDesensitizedException(th));
        }
    }
}
