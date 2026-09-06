package com.opos.mobad.service.h;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.cdo.oaps.ad.OapsKey;
import com.opos.acs.st.STManager;
import com.opos.cmn.i.o;
import com.opos.mobad.provider.statistic.StatisticModelIdentify;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.net.URLEncoder;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7381a;
    private String b;
    private int c;
    private int d;
    private String e;
    private com.opos.mobad.provider.statistic.a f;
    private com.opos.mobad.provider.record.a g;
    private long h = 0;

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    public static JSONObject a(JSONObject jSONObject, Map<String, String> map) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (map == null) {
            return jSONObject;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e);
        }
        return jSONObject;
    }

    private void a(String str, String str2, String str3, int i, long j, String str4, long j2, String str5) {
        try {
            JSONObject jSONObjectE = e();
            jSONObjectE.put("dataType", "lm-show");
            jSONObjectE.put(STManager.KEY_AD_POS_ID, str);
            jSONObjectE.put("rt", j);
            jSONObjectE.put("adSource", str2);
            jSONObjectE.put("uSdkVC", this.c + "");
            if (str3 == null) {
                str3 = "";
            }
            jSONObjectE.put("sdkReqId", str3);
            jSONObjectE.put("ret", "2");
            jSONObjectE.put("rsCode", "" + i);
            if (str4 == null) {
                str4 = "";
            }
            jSONObjectE.put(UMModuleRegister.PROCESS, a(str4));
            jSONObjectE.put("stgVC", j2);
            jSONObjectE.put("cTransport", b(str5));
            a(jSONObjectE);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "error:", e);
        }
    }

    private static String b(String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(o.a(str));
        }
        String string = sb.toString();
        return TextUtils.isEmpty(string) ? "" : o.a(string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                jSONObject.put("uSdkVC", this.c + "");
                jSONObject.put("bizSdkVer", this.c + "");
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                jSONObject.put("sdkReqId", str != null ? str : "");
                if (str == null) {
                    str = "";
                }
                jSONObject.put("reqId", str);
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                jSONObject.put(STManager.KEY_AD_POS_ID, str);
                jSONObject.put("newPosId", str);
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject e() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appId", this.b);
        jSONObject.put("phBrand", com.opos.cmn.an.c.a.a(this.f7381a));
        jSONObject.put("phMaker", com.opos.cmn.an.c.c.e());
        jSONObject.put("aid", com.opos.mobad.service.e.b.n().f());
        jSONObject.put("ua", com.opos.cmn.i.e.a());
        jSONObject.put("coverVc", this.d);
        jSONObject.put("extInfo", !TextUtils.isEmpty(this.e) ? this.e : "");
        jSONObject.put("classifyByAge", b());
        jSONObject.put("ouId", com.opos.mobad.service.d.a.a().g());
        jSONObject.put("duId", com.opos.mobad.service.d.a.a().h());
        jSONObject.put("ouidStatus", com.opos.mobad.service.d.a.a().k() ? "1" : "0");
        jSONObject.put("appOuidStatus", com.opos.mobad.service.d.a.a().e() ? "1" : "0");
        com.opos.mobad.service.d.a.C0991a c0991aL = com.opos.mobad.service.d.a.a().l();
        if (c0991aL != null) {
            jSONObject.put("imei", c0991aL.f7355a);
            c0991aL.getClass();
            jSONObject.put("imeiType", String.valueOf(1));
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                jSONObject.put("dataType", str);
                jSONObject.put("oriDatatype", str);
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e);
            }
        }
    }

    public abstract String a();

    public void a(Context context, String str, int i, int i2) {
        this.f7381a = context;
        this.b = str;
        this.c = i;
        this.d = i2;
        this.f = new com.opos.mobad.provider.statistic.a(this.f7381a, new StatisticModelIdentify(i + "", com.opos.cmn.a.a.a(), com.opos.cmn.a.a.b()));
        this.g = new com.opos.mobad.provider.record.a(context);
    }

    public void a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("StatisticManager", "report null");
            return;
        }
        try {
            JSONObject jSONObjectE = e();
            jSONObjectE.put("dataType", "lm-count");
            jSONObjectE.put(STManager.KEY_AD_POS_ID, str);
            jSONObjectE.put(NotificationCompat.CATEGORY_EVENT, "1:1");
            jSONObjectE.put("uCount", String.valueOf(i));
            jSONObjectE.put("uSdkVC", this.c + "");
            a(jSONObjectE);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "error:", e);
        }
    }

    public void a(String str, String str2) {
        try {
            JSONObject jSONObjectE = e();
            e(jSONObjectE, "lm-reward");
            jSONObjectE.put("uSdkVC", this.c + "");
            jSONObjectE.put(STManager.KEY_AD_POS_ID, str);
            jSONObjectE.put("sdkReqId", str2);
            jSONObjectE.put("rewardSource", 2);
            a(jSONObjectE);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "", e);
        }
    }

    public void a(String str, String str2, int i, int i2) {
        try {
            JSONObject jSONObjectE = e();
            e(jSONObjectE, "lm-bid-call");
            jSONObjectE.put(STManager.KEY_AD_POS_ID, str);
            jSONObjectE.put("appId", this.b);
            jSONObjectE.put("uSdkVC", this.c + "");
            jSONObjectE.put("accType", 1);
            jSONObjectE.put("sdkReqId", str2);
            jSONObjectE.put("bidResult", -1);
            jSONObjectE.put("returnPrice", i);
            jSONObjectE.put("adSource", i2);
            a(jSONObjectE);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "", e);
        }
    }

    public void a(String str, String str2, int i, int i2, int i3) {
        try {
            JSONObject jSONObjectE = e();
            e(jSONObjectE, "lm-bid-call");
            jSONObjectE.put(STManager.KEY_AD_POS_ID, str);
            jSONObjectE.put("appId", this.b);
            jSONObjectE.put("uSdkVC", this.c + "");
            jSONObjectE.put("accType", 1);
            jSONObjectE.put("sdkReqId", str2);
            jSONObjectE.put("bidResult", 0);
            jSONObjectE.put("returnPrice", i2);
            jSONObjectE.put("sspWinPrice", i3);
            jSONObjectE.put("adSource", i);
            a(jSONObjectE);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "", e);
        }
    }

    public void a(String str, String str2, int i, long j, String str3, long j2, String str4) {
        try {
            JSONObject jSONObjectE = e();
            jSONObjectE.put("dataType", "lm-show");
            jSONObjectE.put(STManager.KEY_AD_POS_ID, str);
            jSONObjectE.put("rt", j);
            jSONObjectE.put("adSource", "sdk_serial");
            jSONObjectE.put("uSdkVC", this.c + "");
            jSONObjectE.put("hitSource", i);
            if (str3 == null) {
                str3 = "";
            }
            jSONObjectE.put(UMModuleRegister.PROCESS, a(str3));
            if (str2 == null) {
                str2 = "";
            }
            jSONObjectE.put("sdkReqId", str2);
            jSONObjectE.put("ret", "1");
            jSONObjectE.put("stgVC", j2);
            jSONObjectE.put("cTransport", b(str4));
            a(jSONObjectE);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "error:", e);
        }
    }

    public void a(String str, String str2, int i, long j, String str3, String str4, long j2, String str5) {
        try {
            JSONObject jSONObjectE = e();
            jSONObjectE.put("dataType", "lm-show");
            jSONObjectE.put(STManager.KEY_AD_POS_ID, str);
            jSONObjectE.put("rt", j);
            jSONObjectE.put("adSource", str4);
            jSONObjectE.put("hitSource", i);
            jSONObjectE.put("uSdkVC", this.c + "");
            if (str3 == null) {
                str3 = "";
            }
            jSONObjectE.put(UMModuleRegister.PROCESS, a(str3));
            if (str2 == null) {
                str2 = "";
            }
            jSONObjectE.put("sdkReqId", str2);
            jSONObjectE.put("ret", "1");
            jSONObjectE.put("stgVC", j2);
            jSONObjectE.put("cTransport", b(str5));
            a(jSONObjectE);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "error:", e);
        }
    }

    public void a(String str, String str2, int i, String str3, int i2, int i3, int i4) {
        try {
            JSONObject jSONObjectE = e();
            e(jSONObjectE, "lm-bid-call");
            jSONObjectE.put(STManager.KEY_AD_POS_ID, str);
            jSONObjectE.put("appId", this.b);
            jSONObjectE.put("uSdkVC", this.c + "");
            jSONObjectE.put("accType", 1);
            jSONObjectE.put("sdkReqId", str2);
            jSONObjectE.put("bidResult", i);
            jSONObjectE.put("returnPrice", i3);
            jSONObjectE.put("adSource", i2);
            a(jSONObjectE);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "", e);
        }
    }

    public void a(final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.h.a.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObjectE = a.this.e();
                    a.this.e(jSONObjectE, "lm-vip-callback");
                    a.d(jSONObjectE, str);
                    jSONObjectE.put("adSource", str3);
                    jSONObjectE.put("adId", str2);
                    jSONObjectE.put("pTraceId", str4);
                    jSONObjectE.put("platformPkg", a.this.f7381a.getPackageName());
                    a.c(jSONObjectE, str5);
                    a.this.b(jSONObjectE);
                    jSONObjectE.put(OapsKey.KEY_TOKEN, str7);
                    com.opos.cmn.an.f.a.b("StatisticManager", "recordVIP map=", jSONObjectE);
                    a.this.f.a(str6, jSONObjectE.toString());
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.a("StatisticManager", "", (Throwable) e);
                }
            }
        });
    }

    public void a(String str, Map<String, String> map) {
        try {
            JSONObject jSONObjectE = e();
            jSONObjectE.put("dataType", str);
            b(jSONObjectE);
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null) {
                        jSONObjectE.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            a(jSONObjectE);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "report fail", e);
        }
    }

    public void a(final Map<String, String> map) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.h.a.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    JSONObject jSONObjectE = a.this.e();
                    a.this.e(jSONObjectE, "lm-show");
                    a.this.b(jSONObjectE);
                    jSONObjectE.put("ret", "6");
                    a.a(jSONObjectE, (Map<String, String>) map);
                    a.this.a(jSONObjectE);
                    com.opos.cmn.an.f.a.b("StatisticManager", "reportAdShow() json=", jSONObjectE);
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.d("StatisticManager", "reportAdShow() fail", e);
                }
            }
        });
    }

    void a(final JSONObject jSONObject) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.h.a.1
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f == null) {
                    com.opos.cmn.an.f.a.b("StatisticManager", "do but client null");
                    return;
                }
                try {
                    a.this.f.a(a.this.a(), jSONObject.toString());
                } catch (Exception unused) {
                    com.opos.cmn.an.f.a.b("StatisticManager", "do fail");
                }
            }
        });
    }

    public void a(boolean z, long j, String str) {
        try {
            JSONObject jSONObjectE = e();
            e(jSONObjectE, "lm-fetch");
            jSONObjectE.put("uSdkVC", this.c + "");
            jSONObjectE.put("type", "3");
            jSONObjectE.put("rsCode", z ? "1" : "0");
            jSONObjectE.put("rt", String.valueOf(j));
            if (str == null) {
                str = "";
            }
            jSONObjectE.put("st", str);
            a(jSONObjectE);
            com.opos.cmn.an.f.a.b("StatisticManager", "reportInitSdkResult json=", jSONObjectE);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.d("StatisticManager", "reportInitSdkResult", e);
        }
    }

    protected abstract String b();

    public void b(String str, String str2, int i, long j, String str3, long j2, String str4) {
        a(str, "sdk_serial", str2, i, j, str3, j2, str4);
    }

    public void b(String str, String str2, int i, long j, String str3, String str4, long j2, String str5) {
        a(str, str4, str2, i, j, str3, j2, str5);
    }

    public void c() {
        if (this.h + 86400000 > System.currentTimeMillis()) {
            return;
        }
        try {
            final JSONObject jSONObjectE = e();
            jSONObjectE.put("dataType", "lm-c-ps");
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.h.a.2
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.g == null) {
                        com.opos.cmn.an.f.a.b("StatisticManager", "do but client null");
                        return;
                    }
                    try {
                        if (a.this.h <= 0) {
                            a aVar = a.this;
                            aVar.h = aVar.g.e();
                        }
                        if (a.this.h + 86400000 > System.currentTimeMillis()) {
                            return;
                        }
                        if (a.this.f == null) {
                            com.opos.cmn.an.f.a.b("StatisticManager", "do but client null");
                            return;
                        }
                        a.this.f.a(jSONObjectE.toString());
                        a.this.h = System.currentTimeMillis();
                    } catch (Exception unused) {
                        com.opos.cmn.an.f.a.b("StatisticManager", "do fail");
                    }
                }
            });
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("StatisticManager", "error:", e);
        }
    }

    public f.a d() {
        JSONObject jSONObjectE;
        try {
            jSONObjectE = e();
            try {
                jSONObjectE.put("uSdkVC", this.c + "");
                jSONObjectE.put(com.hihonor.adsdk.base.c.r1.hnadse, this.f7381a.getPackageName());
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            jSONObjectE = null;
        }
        return new f.a(this, jSONObjectE);
    }
}
