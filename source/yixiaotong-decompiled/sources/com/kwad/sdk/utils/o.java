package com.kwad.sdk.utils;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class o {
    public static long boK = -1;

    public static void fp(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = boK;
            adTemplate.mOutClickTimeParam = boK;
        }
    }

    public static void fq(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mOutClickTimeParam = System.currentTimeMillis();
        }
    }

    public static void fr(AdTemplate adTemplate) {
        if (adTemplate != null) {
            adTemplate.mVisibleTimeParam = System.currentTimeMillis();
        }
    }

    public static long fs(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return System.currentTimeMillis();
        }
        return adTemplate.mOutClickTimeParam > 0 ? adTemplate.mOutClickTimeParam : adTemplate.mVisibleTimeParam;
    }
}
