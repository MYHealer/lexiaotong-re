package com.kwad.components.ad.reward.k;

import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class f implements com.kwad.sdk.core.webview.c.a {

    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean BY;
    }

    public void W(boolean z) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "closeVideo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(final String str, com.kwad.sdk.core.webview.c.c cVar) {
        by.postOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.k.f.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                boolean z;
                try {
                    a aVar = new a();
                    aVar.parseJson(new JSONObject(str));
                    z = aVar.BY;
                } catch (Exception unused) {
                    z = false;
                }
                f.this.W(z);
            }
        });
    }
}
