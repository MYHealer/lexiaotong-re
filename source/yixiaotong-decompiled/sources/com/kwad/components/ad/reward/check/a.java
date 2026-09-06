package com.kwad.components.ad.reward.check;

import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a {
    public static void d(AdTemplate adTemplate, int i) {
        c.f(new RewardCheckMonitorInfo().setRequestStatus(1).setCheckType(i).setEnviType(0).setCreativeId(com.kwad.sdk.core.response.helper.a.L(e.eO(adTemplate))).setAdTemplate(adTemplate));
    }

    public static void a(AdTemplate adTemplate, int i, long j, int i2, String str) {
        c.f(new RewardCheckMonitorInfo().setRequestStatus(2).setCheckType(i).setEnviType(0).setDataLoadInterval(j).setCode(i2).setErrorMsg(str).setCreativeId(com.kwad.sdk.core.response.helper.a.L(e.eO(adTemplate))).setAdTemplate(adTemplate));
    }
}
