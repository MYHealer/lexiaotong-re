package com.kwad.sdk.kgeo;

import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.service.ServiceProvider;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private static String bhx;
    private static KGeoInfo bhy;
    private static final AtomicBoolean bhz = new AtomicBoolean();

    public static String Fy() {
        return bhx;
    }

    public static KGeoInfo RB() {
        return bhy;
    }

    public static void fc(int i) {
        if (i == 0) {
            return;
        }
        if (i == 1) {
            RC();
        } else if (i == 2) {
            com.kwad.components.core.request.b.vQ().a(new com.kwad.components.core.request.b.a() { // from class: com.kwad.sdk.kgeo.a.1
                @Override // com.kwad.components.core.request.b.a
                public final void vS() {
                    com.kwad.components.core.request.b.vQ().b(this);
                    a.RC();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void RC() {
        try {
            if (bhz.getAndSet(true)) {
                return;
            }
            c.a(ServiceProvider.Ud(), new c.a() { // from class: com.kwad.sdk.kgeo.a.2
                @Override // com.kwad.sdk.kgeo.c.a
                public final void onSuccess(String str) {
                    String unused = a.bhx = str;
                    a.RD();
                }

                @Override // com.kwad.sdk.kgeo.c.a
                public final void rc() {
                    a.RD();
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void RD() {
        try {
            new l<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.3
                @Override // com.kwad.sdk.core.network.l
                public final /* synthetic */ BaseResultData parseData(String str) {
                    return gO(str);
                }

                private static KGeoResultData gO(String str) {
                    KGeoResultData kGeoResultData = new KGeoResultData();
                    kGeoResultData.parseJson(new JSONObject(str));
                    return kGeoResultData;
                }

                @Override // com.kwad.sdk.core.network.a
                public final f createRequest() {
                    return new b();
                }
            }.request(new o<f, KGeoResultData>() { // from class: com.kwad.sdk.kgeo.a.4
                @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
                public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                    a((KGeoResultData) baseResultData);
                }

                private static void a(KGeoResultData kGeoResultData) {
                    KGeoInfo unused = a.bhy = kGeoResultData.kGeoInfo;
                }
            });
        } catch (Throwable unused) {
        }
    }
}
