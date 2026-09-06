package com.byazt.lr;

import com.byazt.hu.u;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.meishu.sdk.activity.MeishuOpenDeepLinkActivity;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 155, 46})
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2463a;
    public boolean c;
    public String da;
    public int i;
    public int n = 15;
    public long sl;
    public String sp;
    public String t;
    public c tt;
    public String u;
    public int uj;
    public int ve;
    public String x;
    public tt yp;
    public String z;

    public void a(String str) {
        this.u = str;
    }

    public int c() {
        return this.i;
    }

    public void c(int i) {
        this.ve = i;
    }

    public void c(long j) {
        this.sl = j;
    }

    public void c(c cVar) {
        this.tt = cVar;
    }

    public void c(tt ttVar) {
        this.yp = ttVar;
    }

    public void c(String str) {
        this.sp = str;
    }

    public void c(boolean z) {
        this.c = z;
    }

    public void n(int i) {
        this.i = i;
    }

    public void n(String str) {
        this.t = str;
    }

    public String tt() {
        return this.u;
    }

    public void tt(int i) {
        this.uj = i;
    }

    public void tt(String str) {
        this.x = str;
    }

    public void uj(int i) {
        this.f2463a = i;
    }

    public void uj(String str) {
        this.z = str;
    }

    public void ve(int i) {
        this.n = i;
    }

    public void ve(String str) {
        this.da = str;
    }

    @com.byazt.zqa.c(c = {0, 1, 155, 151})
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2464a;
        public String c;
        public String da;
        public String i;
        public String n;
        public String sl;
        public List<C0211c> sp;
        public String t;
        public String tt;
        public long uj;
        public long ve;
        public String x;

        public void a(String str) {
            this.i = str;
        }

        public void c(long j) {
            this.ve = j;
        }

        public void c(String str) {
            this.c = str;
        }

        public void c(List<C0211c> list) {
            this.sp = list;
        }

        public void i(String str) {
            this.t = str;
        }

        public void n(String str) {
            this.x = str;
        }

        public void sp(String str) {
            this.da = str;
        }

        public void tt(long j) {
            this.uj = j;
        }

        public void tt(String str) {
            this.tt = str;
        }

        public void uj(String str) {
            this.f2464a = str;
        }

        public void ve(String str) {
            this.n = str;
        }

        public void x(String str) {
            this.sl = str;
        }

        /* JADX INFO: renamed from: com.byazt.lr.n$c$c, reason: collision with other inner class name */
        @com.byazt.zqa.c(c = {0, 1, 155, 156})
        public static class C0211c {
            public String c;
            public String tt;

            public void c(String str) {
                this.c = str;
            }

            public void tt(String str) {
                this.tt = str;
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 155, 934})
    public static class tt {
        public int c;
        public String tt;

        public void c(int i) {
            this.c = i;
        }

        public void c(String str) {
            this.tt = str;
        }
    }

    public String toString() {
        return c(this);
    }

    public static String c(n nVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("show_auth", Integer.valueOf(nVar.c ? 1 : 0));
            jSONObject.putOpt("download_permit", Integer.valueOf(nVar.ve));
            jSONObject.putOpt("appstore_permit", Integer.valueOf(nVar.uj));
            jSONObject.putOpt("market_online_status", Integer.valueOf(nVar.n));
            jSONObject.putOpt("hijack_permit", Integer.valueOf(nVar.f2463a));
            jSONObject.putOpt("package_name", nVar.sp);
            jSONObject.putOpt("hijack_url", nVar.x);
            jSONObject.putOpt("code", Integer.valueOf(nVar.i));
            jSONObject.putOpt(CrashHianalyticsData.MESSAGE, nVar.da);
            jSONObject.putOpt("request_duration", Long.valueOf(nVar.sl));
            jSONObject.putOpt("auth_info", tt(nVar.tt));
            jSONObject.putOpt("status", tt(nVar.yp));
            jSONObject.putOpt("back_web_url", nVar.z);
            jSONObject.putOpt("hw_app_id", nVar.t);
            jSONObject.putOpt(MeishuOpenDeepLinkActivity.KEY_DEEP_LINK, nVar.u);
        } catch (JSONException e) {
            com.byazt.dm.ve.c().c(e, "ComplianceResult toJson");
        }
        return jSONObject.toString();
    }

    public static n sp(String str) {
        n nVar = new n();
        try {
            JSONObject jSONObject = new JSONObject(str);
            c cVarC = c(jSONObject);
            tt ttVarTt = tt(jSONObject);
            nVar.c(cVarC);
            nVar.c(ttVarTt);
            nVar.c(jSONObject.optInt("show_auth", 0) == 1);
            nVar.c(jSONObject.optInt("download_permit"));
            nVar.tt(jSONObject.optInt("appstore_permit"));
            nVar.ve(jSONObject.optInt("market_online_status", 15));
            nVar.uj(jSONObject.optInt("hijack_permit"));
            nVar.c(jSONObject.optString("package_name"));
            nVar.tt(jSONObject.optString("hijack_url"));
            nVar.n(jSONObject.optInt("code"));
            nVar.ve(jSONObject.optString(CrashHianalyticsData.MESSAGE));
            nVar.c(jSONObject.optLong("request_duration", 0L));
            nVar.uj(jSONObject.optString("back_web_url"));
            nVar.n(jSONObject.optString("hw_app_id"));
            nVar.a(jSONObject.optString(MeishuOpenDeepLinkActivity.KEY_DEEP_LINK));
        } catch (Exception e) {
            com.byazt.dm.ve.c().c(e, "ComplianceResult fromJson");
        }
        return nVar;
    }

    private static c c(JSONObject jSONObject) {
        c cVar = new c();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("auth_info");
            if (jSONObjectOptJSONObject != null) {
                cVar.c(jSONObjectOptJSONObject.optString("app_name"));
                cVar.tt(jSONObjectOptJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
                cVar.c(u.c(jSONObjectOptJSONObject, "update_time"));
                cVar.tt(u.c(jSONObjectOptJSONObject, OapsKey.KEY_SIZE));
                cVar.ve(jSONObjectOptJSONObject.optString("developer_name"));
                cVar.uj(jSONObjectOptJSONObject.optString("package_name"));
                JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("permissions");
                if (jSONArrayOptJSONArray != null) {
                    ArrayList arrayList = new ArrayList();
                    c(jSONArrayOptJSONArray, arrayList);
                    cVar.c(arrayList);
                }
                cVar.n(jSONObjectOptJSONObject.optString("permission_classify_url"));
                cVar.a(jSONObjectOptJSONObject.optString("policy_url"));
                cVar.sp(jSONObjectOptJSONObject.optString("icon_url"));
                cVar.x(jSONObjectOptJSONObject.optString("download_url"));
                cVar.i(jSONObjectOptJSONObject.optString("desc_url"));
            }
        } catch (Exception e) {
            com.byazt.dm.ve.c().c(e, "ComplianceResult getAuthInfo");
        }
        return cVar;
    }

    private static JSONObject tt(c cVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (cVar != null) {
            jSONObject.putOpt("app_name", cVar.c);
            jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, cVar.tt);
            jSONObject.putOpt("update_time", Long.valueOf(cVar.ve));
            jSONObject.putOpt(OapsKey.KEY_SIZE, Long.valueOf(cVar.uj));
            jSONObject.putOpt("developer_name", cVar.n);
            jSONObject.putOpt("policy_url", cVar.i);
            jSONObject.putOpt("icon_url", cVar.da);
            jSONObject.putOpt("download_url", cVar.sl);
            jSONObject.putOpt("permissions", ve(cVar));
            jSONObject.putOpt("permission_classify_url", cVar.x);
            jSONObject.putOpt("desc_url", cVar.t);
        }
        return jSONObject;
    }

    private static tt tt(JSONObject jSONObject) {
        tt ttVar = new tt();
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("status");
            if (jSONObjectOptJSONObject != null) {
                ttVar.c(jSONObjectOptJSONObject.optInt("status"));
                ttVar.c(jSONObjectOptJSONObject.optString(CrashHianalyticsData.MESSAGE));
            }
        } catch (Exception e) {
            com.byazt.dm.ve.c().c(e, "ComplianceResult getStatus");
        }
        return ttVar;
    }

    private static JSONObject tt(tt ttVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (ttVar != null) {
            jSONObject.putOpt("status", Integer.valueOf(ttVar.c));
            jSONObject.putOpt(CrashHianalyticsData.MESSAGE, ttVar.tt);
        }
        return jSONObject;
    }

    private static void c(JSONArray jSONArray, List<c.C0211c> list) {
        if (jSONArray == null || list == null) {
            return;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                c.C0211c c0211c = new c.C0211c();
                c0211c.c(jSONObjectOptJSONObject.optString("permission_name"));
                c0211c.tt(jSONObjectOptJSONObject.optString("permission_desc"));
                list.add(c0211c);
            }
        }
    }

    private static JSONArray ve(c cVar) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        List<c.C0211c> list = cVar.sp;
        if (list != null && list.size() > 0) {
            for (c.C0211c c0211c : list) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("permission_name", c0211c.c);
                jSONObject.putOpt("permission_desc", c0211c.tt);
                jSONArray.put(jSONObject);
            }
        }
        return jSONArray;
    }
}
