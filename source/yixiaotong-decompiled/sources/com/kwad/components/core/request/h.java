package com.kwad.components.core.request;

import android.content.Context;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.bi;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class h {
    private static final AtomicBoolean sHasInit = new AtomicBoolean();
    private static volatile boolean ajH = false;
    private static final List<a> ajI = new CopyOnWriteArrayList();

    public interface a {
        void d(SdkConfigData sdkConfigData);

        void vZ();
    }

    public interface b extends a {
        void wa();
    }

    static /* synthetic */ boolean access$102(boolean z) {
        ajH = true;
        return true;
    }

    public static synchronized void a(a aVar) {
        com.kwad.sdk.core.d.c.d("ConfigRequestManager", "init config");
        if (sHasInit.get()) {
            com.kwad.sdk.core.d.c.d("ConfigRequestManager", "config request manager has init");
        } else {
            ajI.add(aVar);
            com.kwad.sdk.utils.i.execute(new bi() { // from class: com.kwad.components.core.request.h.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    Context contextUd = ServiceProvider.Ud();
                    ai.l(contextUd, ai.dq(contextUd) + 1);
                    com.kwad.sdk.core.config.e.bN(contextUd);
                    h.vV();
                    h.vU();
                }
            });
        }
    }

    public static void b(a aVar) {
        try {
            ajI.add(aVar);
            if (com.kwad.sdk.core.config.e.isLoaded()) {
                aVar.vZ();
            }
            if (ajH) {
                aVar.d(com.kwad.sdk.core.config.e.JS());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void vU() {
        com.kwad.sdk.core.d.c.d("ConfigRequestManager", "requestConfig");
        new com.kwad.sdk.core.network.l<g, SdkConfigData>() { // from class: com.kwad.components.core.request.h.2
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return bh(str);
            }

            private static SdkConfigData bh(String str) {
                SdkConfigData sdkConfigData = new SdkConfigData();
                try {
                    ai.as(ServiceProvider.Ud(), str);
                    sdkConfigData.parseJson(new JSONObject(str));
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
                return sdkConfigData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* JADX INFO: renamed from: vY, reason: merged with bridge method [inline-methods] */
            public g createRequest() {
                GlobalThreadPools.Oi().execute(new Runnable() { // from class: com.kwad.components.core.request.h.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            com.kwad.sdk.core.request.model.e.Nv();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return new g();
            }
        }.request(new o<g, SdkConfigData>() { // from class: com.kwad.components.core.request.h.3
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                c((SdkConfigData) baseResultData);
            }

            private static void c(SdkConfigData sdkConfigData) {
                try {
                    com.kwad.sdk.core.d.c.W("ConfigRequestManager", "load config success");
                    com.kwad.sdk.core.config.b.bL(ServiceProvider.Ud());
                    com.kwad.sdk.core.config.e.f(sdkConfigData);
                    h.access$102(true);
                    h.a(sdkConfigData);
                    ah.Va();
                    ah.UU();
                    ai.l(ServiceProvider.Ud(), 0);
                    if (ai.Vh() != com.kwad.sdk.core.config.e.KG()) {
                        ai.f(ServiceProvider.Ud(), com.kwad.sdk.core.config.e.KG());
                    }
                    h.sHasInit.set(true);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(g gVar, int i, String str) {
                super.onError(gVar, i, str);
                com.kwad.sdk.core.d.c.d("ConfigRequestManager", "onError errorCode=" + i + " errorMsg=" + str);
                h.q(i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void vV() {
        Iterator<a> it = ajI.iterator();
        while (it.hasNext()) {
            try {
                it.next().vZ();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(SdkConfigData sdkConfigData) {
        Iterator<a> it = ajI.iterator();
        while (it.hasNext()) {
            try {
                it.next().d(sdkConfigData);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(int i, String str) {
        for (a aVar : ajI) {
            try {
                if (aVar instanceof b) {
                    ((b) aVar).wa();
                }
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }
}
