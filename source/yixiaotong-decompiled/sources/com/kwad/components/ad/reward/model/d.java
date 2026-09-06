package com.kwad.components.ad.reward.model;

import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class d {
    public static String n(AdInfo adInfo) {
        if (com.kwad.sdk.core.response.helper.a.cY(adInfo)) {
            return "live";
        }
        if (com.kwad.sdk.core.response.helper.a.bj(adInfo)) {
            return "image";
        }
        return com.kwad.sdk.core.response.helper.a.cm(adInfo) ? "reward_preview" : "video";
    }
}
