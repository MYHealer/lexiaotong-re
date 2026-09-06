package com.opos.cmn.biz.requeststatistic;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.OapsKey;
import com.kuaishou.weapon.p0.t;
import com.opos.cmn.biz.a.d;
import com.opos.cmn.biz.requeststatistic.cache.c;
import com.stub.StubApp;
import com.ubixnow.ooooo.o0OO000o;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RequestStatisticManager {
    private static RequestStatisticManager c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6002a;
    private InitParams b;

    private RequestStatisticManager() {
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0044  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x003d -> B:19:0x0044). Please report as a decompilation issue!!! */
    private static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        String subtypeName;
        if (context != null) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || TextUtils.isEmpty(activeNetworkInfo.getTypeName())) {
                    subtypeName = "";
                } else if ("WIFI".equalsIgnoreCase(activeNetworkInfo.getTypeName())) {
                    subtypeName = activeNetworkInfo.getTypeName();
                } else if (TextUtils.isEmpty(activeNetworkInfo.getSubtypeName())) {
                    subtypeName = "";
                } else {
                    subtypeName = activeNetworkInfo.getSubtypeName();
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("RequestStatisticManager", "net access fail", e);
            }
        } else {
            subtypeName = "";
        }
        return subtypeName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(StatisticEvent statisticEvent) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("chn", statisticEvent.channel);
        jSONObject2.put("imei", "");
        jSONObject2.put(OapsKey.KEY_PKG, this.f6002a.getPackageName());
        jSONObject2.put("svc", TextUtils.isEmpty(statisticEvent.sdkVersion) ? 2003000 : statisticEvent.sdkVersion);
        jSONObject2.put("evtId", statisticEvent.eventId);
        jSONObject2.put("model", b(this.f6002a));
        jSONObject2.put("net", a(this.f6002a));
        if (b.b(this.f6002a)) {
            jSONObject2.put("gaId", com.opos.cmn.g.a.b.f(this.f6002a));
        }
        jSONObject2.put("bd", com.opos.cmn.biz.a.b.a(this.f6002a));
        jSONObject2.put("rn", d.a(this.f6002a));
        jSONObject2.put("duId", "");
        jSONObject2.put("ouId", com.opos.cmn.g.a.b.a(this.f6002a));
        jSONObject2.put("guId", "");
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("ct", statisticEvent.currentTime);
        jSONObject3.put("url", statisticEvent.url);
        jSONObject3.put("ret", statisticEvent.ret);
        jSONObject3.put("rt", statisticEvent.resolveTime);
        jSONObject3.put("mt", statisticEvent.maxResolveTime);
        jSONObject3.put(o0OO000o.o00O0O0O, statisticEvent.ext);
        jSONObject.put(IAdInterListener.AdReqParam.HEIGHT, jSONObject2);
        jSONObject.put(t.l, jSONObject3);
        return jSONObject;
    }

    private boolean a() {
        return (this.f6002a == null || this.b == null) ? false : true;
    }

    private static String b(Context context) {
        String str = Build.MODEL;
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static RequestStatisticManager getInstance() {
        RequestStatisticManager requestStatisticManager;
        RequestStatisticManager requestStatisticManager2 = c;
        if (requestStatisticManager2 != null) {
            return requestStatisticManager2;
        }
        synchronized (RequestStatisticManager.class) {
            if (c == null) {
                c = new RequestStatisticManager();
            }
            requestStatisticManager = c;
        }
        return requestStatisticManager;
    }

    public void init(Context context, InitParams initParams) {
        this.f6002a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        com.opos.cmn.biz.requeststatistic.cache.d.c().a(context);
        this.b = initParams;
    }

    public void report(final StatisticEvent statisticEvent) {
        if (!a()) {
            throw new IllegalStateException("had not init yet ");
        }
        if (statisticEvent == null) {
            throw new IllegalArgumentException("event can not be null");
        }
        if (com.opos.cmn.an.f.a.a(this.f6002a)) {
            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.requeststatistic.RequestStatisticManager.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObjectA = RequestStatisticManager.this.a(statisticEvent);
                        String string = jSONObjectA.toString();
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.put(jSONObjectA);
                        String string2 = jSONArray.toString();
                        final c cVar = new c(string, System.currentTimeMillis());
                        com.opos.cmn.biz.requeststatistic.cache.d.c().a(cVar);
                        a.a(RequestStatisticManager.this.f6002a, string2, new a.b(this) { // from class: com.opos.cmn.biz.requeststatistic.RequestStatisticManager.1.1
                            @Override // com.opos.cmn.biz.requeststatistic.a.b
                            public void onFail() {
                                com.opos.cmn.an.f.a.b("RequestStatisticManager", "report request fail");
                            }

                            @Override // com.opos.cmn.biz.requeststatistic.a.b
                            public void onSuccess() {
                                com.opos.cmn.biz.requeststatistic.cache.d.c().b(cVar);
                                com.opos.cmn.biz.requeststatistic.cache.d.c().a();
                            }
                        });
                    } catch (JSONException e) {
                        com.opos.cmn.an.f.a.c("RequestStatisticManager", "request parse json fail", e);
                    }
                }
            });
        } else {
            com.opos.cmn.an.f.a.b("RequestStatisticManager", "log buried point switch is closed, cannot upload log buried point");
        }
    }

    public void reportCacheIfNeed() {
        if (!a()) {
            com.opos.cmn.an.f.a.c("RequestStatisticManager", "reportCacheIfNeed, but had not init yet");
        } else if (com.opos.cmn.an.f.a.a(this.f6002a)) {
            com.opos.cmn.biz.requeststatistic.cache.d.c().a();
        } else {
            com.opos.cmn.an.f.a.a("RequestStatisticManager", "log buried point switch is closed, cannot upload log buried point");
        }
    }
}
