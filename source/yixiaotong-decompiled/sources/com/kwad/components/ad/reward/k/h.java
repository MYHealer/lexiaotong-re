package com.kwad.components.ad.reward.k;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class h implements com.kwad.sdk.core.webview.c.a {
    private a Ca;

    public interface a {
        void ap(int i);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "hasReward";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.Ca = null;
    }

    public h(a aVar) {
        this.Ca = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        int iOptInt;
        if (this.Ca != null) {
            try {
                iOptInt = new JSONObject(str).optInt("severCheckResult");
            } catch (JSONException e) {
                e.printStackTrace();
                iOptInt = 0;
            }
            this.Ca.ap(iOptInt);
        }
    }
}
