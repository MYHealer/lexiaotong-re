package com.kwad.components.ad.reward.c;

import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class f implements com.kwad.sdk.core.webview.c.a {
    private d tZ;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "updateExtraReward";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.tZ = null;
    }

    public f(d dVar) {
        this.tZ = dVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            final b bVar = new b();
            bVar.parseJson(new JSONObject(str));
            by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.c.f.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    if (f.this.tZ != null) {
                        f.this.tZ.a(bVar);
                    }
                }
            });
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }
}
