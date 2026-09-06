package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import com.hihonor.hianalytics.HaEventConstants;
import com.hihonor.hianalytics.module.config.HiAnalyticsAutoConfig;
import com.hihonor.hianalytics.util.SystemUtils;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class e3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3635a;
    private final long b;
    private String c;
    private long d;
    private long e;

    public e3(String str, HiAnalyticsAutoConfig hiAnalyticsAutoConfig) {
        this.f3635a = str;
        this.b = hiAnalyticsAutoConfig.getAutoSessionHeartTime();
        a();
    }

    private void a() {
        try {
            String strA = u.a(this.f3635a);
            if (!TextUtils.isEmpty(strA)) {
                JSONObject jSONObject = new JSONObject(strA);
                if (jSONObject.has("sessionId")) {
                    this.c = jSONObject.optString("sessionId");
                }
                if (jSONObject.has("firstTime")) {
                    this.d = jSONObject.optLong("firstTime");
                }
                if (jSONObject.has("lastTime")) {
                    this.e = jSONObject.optLong("lastTime");
                }
            }
            j2.a("AutoSessionDealer", "readSessionData value=" + strA);
        } catch (Throwable th) {
            j2.g("AutoSessionDealer", "readSessionData failE=" + SystemUtils.getDesensitizedException(th));
        }
    }

    private void b() {
        String string;
        try {
            if (TextUtils.isEmpty(this.c)) {
                string = null;
            } else {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("sessionId", this.c);
                jSONObject.put("firstTime", this.d);
                jSONObject.put("lastTime", this.e);
                string = jSONObject.toString();
            }
            j2.a("AutoSessionDealer", "saveSessionData value=" + string + ",isSuccess=" + u.c(this.f3635a, string));
        } catch (Throwable th) {
            j2.g("AutoSessionDealer", "saveSessionData failE=" + SystemUtils.getDesensitizedException(th));
        }
    }

    public void a(int i, String str, long j, JSONObject jSONObject) {
        String str2;
        String str3;
        e3 e3Var;
        long j2 = j;
        if (j2 <= 0) {
            return;
        }
        boolean zEquals = HaEventConstants.EVENT_ID_APP_END.equals(str);
        try {
            if (!TextUtils.isEmpty(this.c)) {
                long j3 = j2 - this.d;
                long j4 = j2 - this.e;
                boolean zEquals2 = HaEventConstants.EVENT_ID_APP_START.equals(str);
                boolean zEquals3 = HaEventConstants.EVENT_ID_VIEW_EXPOSE.equals(str);
                boolean zK = SystemUtils.k();
                if (j3 > 43200000 || j3 < -3600000) {
                    str2 = ",isPageExpose=";
                    str3 = ",isAppStart=";
                } else {
                    str2 = ",isPageExpose=";
                    if (j4 <= this.b || (!zEquals2 && (!zK || zEquals || zEquals3))) {
                        j2.a("AutoSessionDealer", "handleAutoEvent sameSessionWithIsAppEnd=" + zEquals + ",eventId=" + str + ",duration=" + j3 + ",interval=" + j4 + ",isAppStart=" + zEquals2 + str2 + zEquals3 + ",isBackground=" + zK + ",time=" + com.hihonor.hianalytics.util.r.a(j));
                        j2 = j;
                    } else {
                        str3 = ",isAppStart=";
                    }
                }
                j2.c("AutoSessionDealer", "handleAutoEvent newSessionWithIsAppEnd=" + zEquals + ",eventId=" + str + ",duration=" + j3 + ",interval=" + j4 + str3 + zEquals2 + str2 + zEquals3 + ",isBackground=" + zK + ",time=" + com.hihonor.hianalytics.util.r.a(j));
                e3Var = this;
                e3Var.c = UUID.randomUUID().toString().replace(com.huawei.openalliance.ad.constant.x.A, "");
                j2 = j;
                if (!zEquals) {
                    e3Var.d = j2;
                }
                e3Var.e = j2;
                jSONObject.put(HaEventConstants.EVENT_ATTR_AUTO_SESSION_ID, e3Var.c);
                b();
            }
            j2.c("AutoSessionDealer", "handleAutoEvent newSessionByEmptyWithIsAppEnd=" + zEquals + ",eventId=" + str + ",time=" + com.hihonor.hianalytics.util.r.a(j));
            if (zEquals) {
                return;
            }
            this.c = UUID.randomUUID().toString().replace(com.huawei.openalliance.ad.constant.x.A, "");
            this.d = j2;
            jSONObject.put(HaEventConstants.EVENT_ATTR_AUTO_SESSION_ID, e3Var.c);
        } catch (Throwable unused) {
        }
        e3Var = this;
        e3Var.e = j2;
        b();
    }
}
