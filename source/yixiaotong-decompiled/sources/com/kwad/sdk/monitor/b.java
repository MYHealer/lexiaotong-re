package com.kwad.sdk.monitor;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static class a extends com.kwad.sdk.commercial.c.a {
        public String bdL;
        public int bjg;
        public String sdkVersion;
    }

    /* JADX INFO: renamed from: com.kwad.sdk.monitor.b$b, reason: collision with other inner class name */
    public static class C0765b extends com.kwad.sdk.commercial.c.a {
        public int bjh;
        public String bji;
        public String bjj;
        public String bjk;
        public String bjl;
        public String bjm;
    }

    public static void Sx() {
        i.execute(new bi() { // from class: com.kwad.sdk.monitor.b.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                b.Sy();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Sy() {
        a aVarA;
        JSONObject jSONObject = (JSONObject) e.JS().getAppConfigData(null, new com.kwad.sdk.g.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.monitor.b.2
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ JSONObject apply(JSONObject jSONObject2) {
                return p(jSONObject2);
            }

            private static JSONObject p(JSONObject jSONObject2) {
                return jSONObject2.optJSONObject("sdkTTPerfMonitor");
            }
        });
        if (jSONObject == null) {
            return;
        }
        C0765b c0765b = new C0765b();
        try {
            c0765b.parseJson(jSONObject);
            if (c0765b.bjh == 1 && (aVarA = a(ServiceProvider.getContext().getClassLoader(), c0765b)) != null) {
                c.d(d.In().m983do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_sdk_tt_sdk_info", com.alipay.sdk.sys.a.h).A(aVarA).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
            }
        } catch (Throwable unused) {
        }
    }

    private static a a(ClassLoader classLoader, C0765b c0765b) {
        Class<?> clsA = ab.a(c0765b.bji, classLoader);
        if (clsA == null) {
            return null;
        }
        a aVar = new a();
        aVar.bjg = ab.classExists(c0765b.bjj) ? 1 : 0;
        Object objCallStaticMethod = ab.callStaticMethod(clsA, c0765b.bjk, new Object[0]);
        aVar.sdkVersion = (String) ab.callMethod(objCallStaticMethod, c0765b.bjl, new Object[0]);
        aVar.bdL = (String) ab.callMethod(objCallStaticMethod, c0765b.bjm, new Object[0]);
        return aVar;
    }
}
