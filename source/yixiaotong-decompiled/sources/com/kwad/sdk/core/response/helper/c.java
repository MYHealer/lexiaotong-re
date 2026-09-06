package com.kwad.sdk.core.response.helper;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    public static <R extends AdResultData, T extends AdTemplate> T r(R r) {
        if (r == null) {
            return null;
        }
        return (T) r.getFirstAdTemplate();
    }

    public static <R extends AdResultData, T extends AdTemplate> T a(R r, String str) {
        if (r == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            Iterator<AdTemplate> it = r.getAdTemplateList().iterator();
            while (it.hasNext()) {
                T t = (T) it.next();
                if (String.valueOf(e.eO(t).adBaseInfo.creativeId).equals(str)) {
                    return t;
                }
            }
        }
        return (T) r.getFirstAdTemplate();
    }

    public static AdInfo s(AdResultData adResultData) {
        AdTemplate firstAdTemplate = adResultData.getFirstAdTemplate();
        if (firstAdTemplate == null) {
            return null;
        }
        return e.eO(firstAdTemplate);
    }

    public static AdResultData ez(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        return adTemplate.createAdResultData();
    }

    public static AdGlobalConfigInfo.CycleAggregationInfo t(AdResultData adResultData) {
        if (adResultData == null || adResultData.adGlobalConfigInfo == null) {
            return null;
        }
        return adResultData.adGlobalConfigInfo.cycleAggregationInfo;
    }

    public static <T extends AdResultData> AdResultData a(AdResultData adResultData, AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(adTemplate);
        AdResultData adResultDataM986clone = adResultData.m986clone();
        adResultDataM986clone.setAdTemplateList(arrayList);
        return adResultDataM986clone;
    }

    public static boolean u(AdResultData adResultData) {
        AdGlobalConfigInfo.CycleAggregationInfo cycleAggregationInfoT;
        if (adResultData == null || adResultData.getAdTemplateList() == null || adResultData.getAdTemplateList().size() <= 1 || (cycleAggregationInfoT = t(adResultData)) == null) {
            return false;
        }
        return cycleAggregationInfoT.cycleAggregationSwitch;
    }
}
