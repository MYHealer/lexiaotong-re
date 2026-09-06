package com.kwad.components.ad.adbit;

import android.text.TextUtils;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class e {
    private static <T extends com.kwad.components.core.request.a> T a(com.kwad.sdk.g.c<T> cVar) {
        return cVar.get();
    }

    public static String a(SceneImpl sceneImpl) {
        final com.kwad.components.core.request.model.a aVarWd = new com.kwad.components.core.request.model.a.C0690a().e(new ImpInfo(SceneImpl.covert(sceneImpl))).a(new com.kwad.components.core.request.d()).wd();
        b bVar = (b) a(new com.kwad.sdk.g.c<b>() { // from class: com.kwad.components.ad.adbit.e.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.c
            /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
            public b get() {
                return new b(aVarWd);
            }
        });
        return new a(bVar.getBody(), bVar.getHeader()).Q();
    }

    public static String getBidRequestTokenV2(KsScene ksScene) {
        final com.kwad.components.core.request.model.a aVarWd = new com.kwad.components.core.request.model.a.C0690a().e(new ImpInfo(SceneImpl.covert(ksScene))).a(new com.kwad.components.core.request.d()).wd();
        com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) a(new com.kwad.sdk.g.c<com.kwad.components.ad.a.a>() { // from class: com.kwad.components.ad.adbit.e.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.c
            /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ad.a.a get() {
                return new com.kwad.components.ad.a.a(aVarWd);
            }
        });
        return new a(aVar.getBody(), aVar.getHeader()).Q();
    }

    public static boolean c(final com.kwad.components.core.request.model.a aVar) {
        String bidResponseV2 = aVar.abn.adScene.getBidResponseV2();
        if (!TextUtils.isEmpty(bidResponseV2)) {
            a(bidResponseV2, aVar);
            return true;
        }
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        final String bidResponse = aVar.abn.adScene.getBidResponse();
        if (TextUtils.isEmpty(bidResponse)) {
            return false;
        }
        GlobalThreadPools.Od().submit(new bi() { // from class: com.kwad.components.ad.adbit.e.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                try {
                    aVar.bi("server_bid_one");
                    com.kwad.sdk.commercial.convert.e.c(aVar.abn.adScene, aVar.wc());
                    JSONObject jSONObject = new JSONObject(bidResponse);
                    AdBitResultData adBitResultData = new AdBitResultData(aVar.abn.adScene);
                    adBitResultData.parseJson(jSONObject);
                    adBitResultData.setAdTemplateList(e.b(adBitResultData));
                    adBitResultData.setAdSource("server_bid_one");
                    if (adBitResultData.isAdResultDataEmpty()) {
                        com.kwad.components.core.request.model.a.a(aVar, adBitResultData, true);
                        return;
                    }
                    AdTemplate adTemplate = adBitResultData.getAdTemplateList().get(0);
                    int adStyle = aVar.abn.adScene.getAdStyle();
                    if (adStyle != 10000 && adStyle != com.kwad.sdk.core.response.helper.e.eI(adTemplate)) {
                        com.kwad.components.core.request.model.a.a(aVar, com.kwad.sdk.core.network.e.aTi.errorCode, com.kwad.sdk.core.network.e.aTi.msg, true);
                    } else {
                        com.kwad.components.core.request.model.a.a(aVar, adBitResultData, true);
                    }
                } catch (Exception e) {
                    com.kwad.components.core.request.model.a.a(aVar, com.kwad.sdk.core.network.e.aTd.errorCode, com.kwad.sdk.core.network.e.aTd.msg, true);
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                }
            }
        });
        return true;
    }

    private static void a(String str, com.kwad.components.core.request.model.a aVar) {
        try {
            aVar.bi("server_bid_two");
            com.kwad.sdk.commercial.convert.e.c(aVar.abn.adScene, aVar.wc());
            JSONObject jSONObject = new JSONObject(str);
            AdBitResultData adBitResultData = new AdBitResultData(aVar.abn.adScene);
            adBitResultData.parseJson(jSONObject);
            List<String> listA = a(adBitResultData);
            if (listA.isEmpty()) {
                com.kwad.components.core.request.model.a.a(aVar, com.kwad.sdk.core.network.e.aTe.errorCode, TextUtils.isEmpty(adBitResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aTe.msg : adBitResultData.testErrorMsg, false);
            } else {
                a(listA, adBitResultData, aVar);
            }
        } catch (Exception e) {
            com.kwad.components.core.request.model.a.a(aVar, com.kwad.sdk.core.network.e.aTd.errorCode, com.kwad.sdk.core.network.e.aTd.msg, false);
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    private static void a(final List<String> list, final AdBitResultData adBitResultData, final com.kwad.components.core.request.model.a aVar) {
        new l<com.kwad.components.ad.a.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.e.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public AdBitResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdBitResultData adBitResultData2 = new AdBitResultData(aVar.abn.adScene);
                adBitResultData2.parseJson(jSONObject);
                return adBitResultData2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ad.a.b createRequest() {
                return new com.kwad.components.ad.a.b(adBitResultData.adxId, list);
            }
        }.request(new o<com.kwad.components.ad.a.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.e.5
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(f fVar, int i, String str) {
                b(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                c((AdBitResultData) baseResultData);
            }

            private void c(AdBitResultData adBitResultData2) {
                adBitResultData2.setAdTemplateList(e.a(adBitResultData, adBitResultData2));
                adBitResultData2.setAdSource("server_bid_two");
                if (adBitResultData2.isAdResultDataEmpty()) {
                    com.kwad.components.core.request.model.a.a(aVar, adBitResultData2, false);
                    return;
                }
                AdTemplate adTemplate = adBitResultData2.getAdTemplateList().get(0);
                int i = aVar.abn.adScene.adStyle;
                if (i != 10000 && i != com.kwad.sdk.core.response.helper.e.eI(adTemplate)) {
                    com.kwad.components.core.request.model.a.a(aVar, com.kwad.sdk.core.network.e.aTi.errorCode, com.kwad.sdk.core.network.e.aTi.msg, false);
                } else {
                    com.kwad.components.core.request.model.a.a(aVar, adBitResultData2, false);
                }
            }

            private void b(int i, String str) {
                com.kwad.components.core.request.model.a.a(aVar, i, str, false);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<AdTemplate> a(AdBitResultData adBitResultData, AdBitResultData adBitResultData2) {
        AdTemplate adTemplateA;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0 && adBid.creativeId > 0 && (adTemplateA = a(adBitResultData2, adBid.creativeId)) != null) {
                adTemplateA.mBidEcpm = adBid.bidEcpm;
                arrayList.add(adTemplateA);
            }
        }
        return arrayList;
    }

    private static List<String> a(AdBitResultData adBitResultData) {
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0 && adBid.creativeId > 0) {
                arrayList.add(adBid.materialId);
            }
        }
        return arrayList;
    }

    public static List<AdTemplate> b(AdBitResultData adBitResultData) {
        AdTemplate adTemplateA;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0 && adBid.creativeId > 0 && (adTemplateA = a(adBitResultData, adBid.creativeId)) != null) {
                adTemplateA.mBidEcpm = adBid.bidEcpm;
                arrayList.add(adTemplateA);
            }
        }
        return arrayList;
    }

    private static AdTemplate a(AdBitResultData adBitResultData, long j) {
        for (AdTemplate adTemplate : adBitResultData.getAdTemplateList()) {
            if (adTemplate != null && j == com.kwad.sdk.core.response.helper.e.eY(adTemplate)) {
                return adTemplate;
            }
        }
        return null;
    }
}
