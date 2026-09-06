package com.kwad.sdk.core.track;

import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.h;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.by;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private static boolean eK(int i) {
        return i >= 200 && i < 300;
    }

    public static void e(com.kwad.sdk.core.adlog.c.a aVar) {
        AdTemplate adTemplate = aVar.adTemplate;
        AdInfo adInfoEO = e.eO(adTemplate);
        int i = aVar.aKI;
        List<String> listA = a(adTemplate, i, aVar);
        if (ar.R(listA)) {
            return;
        }
        boolean zDE = com.kwad.sdk.core.response.helper.a.dE(adInfoEO);
        boolean zDF = com.kwad.sdk.core.response.helper.a.dF(adInfoEO);
        for (String str : listA) {
            com.kwad.sdk.commercial.i.a.p(adTemplate, i, str);
            if (adTemplate.isCheatingFlow()) {
                com.kwad.sdk.commercial.i.a.o(adTemplate, i, str);
                return;
            }
            if (by.ir(str)) {
                com.kwad.sdk.commercial.i.a.a(adTemplate, i, str, "", 100001, "", 0);
                return;
            }
            HashMap map = null;
            String strA = ak.a(ServiceProvider.getContext(), str, i == 2 ? aVar.no : null, com.kwad.sdk.core.response.helper.a.aH(e.eO(adTemplate)));
            ak.f(adTemplate, str, strA);
            AdHttpProxy adHttpProxyEG = h.EG();
            int i2 = adHttpProxyEG instanceof com.kwad.sdk.core.network.c.a ? 2 : 1;
            c.d("AdTrackUtil", "handleTrackUrl useKwaiUA: " + zDE);
            if (zDE) {
                com.kwad.sdk.core.i.c cVarK = com.kwad.sdk.core.i.a.k(zDE, zDF);
                c.d("AdTrackUtil", "handleTrackUrl uaGetter: " + cVarK);
                if (cVarK != null) {
                    map = new HashMap();
                    map.put("User-Agent", cVarK.OC());
                }
            }
            com.kwad.sdk.core.network.c cVarDoGetWithoutResponse = adHttpProxyEG.doGetWithoutResponse(strA, map, !zDE);
            if (eK(cVarDoGetWithoutResponse.code)) {
                c.d("AdTrackUtil", "trackUrl request success actionType: " + i);
                com.kwad.sdk.commercial.i.a.a(adTemplate, i, str, cVarDoGetWithoutResponse.code, i2);
            } else {
                com.kwad.sdk.commercial.i.a.a(adTemplate, i, str, strA, com.kwad.sdk.commercial.e.dt(cVarDoGetWithoutResponse.code), cVarDoGetWithoutResponse.aSY, i2);
            }
        }
    }

    private static List<String> a(AdTemplate adTemplate, int i, com.kwad.sdk.core.adlog.c.a aVar) {
        ArrayList arrayList = new ArrayList();
        AdInfo adInfoEO = e.eO(adTemplate);
        List<AdInfo.AdTrackInfo> list = adInfoEO.adTrackInfoList;
        if (ar.R(list)) {
            return arrayList;
        }
        List<String> listA = a(i, aVar, arrayList, adInfoEO, list);
        if (listA != null) {
            return listA;
        }
        for (AdInfo.AdTrackInfo adTrackInfo : list) {
            if (adTrackInfo.type == i && adTrackInfo.urls != null) {
                arrayList.addAll(adTrackInfo.urls);
                break;
            }
        }
        return arrayList;
    }

    private static List<String> a(int i, com.kwad.sdk.core.adlog.c.a aVar, List<String> list, AdInfo adInfo, List<AdInfo.AdTrackInfo> list2) {
        int iOptInt;
        if (i != 402 || !com.kwad.sdk.core.response.helper.a.bu(adInfo)) {
            return null;
        }
        try {
            if (!TextUtils.isEmpty(aVar.QY)) {
                iOptInt = new JSONObject(aVar.QY).optInt("photoPlaySecond");
            } else {
                iOptInt = aVar.aMf;
            }
            JSONObject jSONObject = new JSONObject(adInfo.adBaseInfo.videoPlayedNSConfig);
            for (AdInfo.AdTrackInfo adTrackInfo : list2) {
                if (adTrackInfo.type == jSONObject.optInt(String.valueOf(iOptInt)) && adTrackInfo.urls != null) {
                    list.addAll(adTrackInfo.urls);
                    break;
                }
            }
        } catch (Throwable unused) {
        }
        return list;
    }
}
