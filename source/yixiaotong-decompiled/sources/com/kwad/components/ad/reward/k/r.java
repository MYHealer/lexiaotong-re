package com.kwad.components.ad.reward.k;

import com.kwad.components.ad.reward.model.RewardFraudVerifyRespInfo;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class r implements com.kwad.sdk.core.webview.c.a {
    private WeakReference<com.kwad.components.ad.reward.g> ua;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public RewardFraudVerifyRespInfo.FraudDataInfo Cg;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "rewardFraudVerify";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public r(WeakReference<com.kwad.components.ad.reward.g> weakReference) {
        this.ua = weakReference;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        WeakReference<com.kwad.components.ad.reward.g> weakReference = this.ua;
        com.kwad.components.ad.reward.g gVar = weakReference != null ? weakReference.get() : null;
        try {
            JSONObject jSONObject = new JSONObject(str);
            a aVar = new a();
            aVar.parseJson(jSONObject);
            gVar.sW = aVar.Cg.isFraud() ? 3 : 2;
            gVar.sX = aVar.Cg.getCode();
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }
}
