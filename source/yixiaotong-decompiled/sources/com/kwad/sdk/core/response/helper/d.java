package com.kwad.sdk.core.response.helper;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {
    public static long eA(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return eE(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    public static String eB(AdTemplate adTemplate) {
        return adTemplate == null ? "" : eE(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    public static String eC(AdTemplate adTemplate) {
        return adTemplate == null ? "" : eE(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    public static boolean eD(AdTemplate adTemplate) {
        if (adTemplate != null && e.eG(adTemplate)) {
            return eE(adTemplate).slideClick;
        }
        return false;
    }

    private static AdStyleInfo eE(AdTemplate adTemplate) {
        return e.eO(adTemplate).adStyleInfo;
    }

    public static List<String> eF(AdTemplate adTemplate) {
        AdStyleInfo adStyleInfoEE = eE(adTemplate);
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<AdStyleInfo.ExposeTagInfo> it = adStyleInfoEE.extraDisplayInfo.exposeTagInfoList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().text);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
