package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class bd implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c apx;
    private a arG;
    private final com.kwad.sdk.core.webview.b fi;

    public interface a {
        void g(AdTemplate adTemplate);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerSetAdTemplateListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.apx = null;
    }

    public bd(com.kwad.sdk.core.webview.b bVar, a aVar) {
        this.fi = bVar;
        this.arG = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.webview.d.b.b bVar = new com.kwad.sdk.core.webview.d.b.b();
        try {
            bVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (this.arG != null) {
            if (!TextUtils.isEmpty(bVar.llsid)) {
                bVar.adTemplate.llsid = Long.parseLong(bVar.llsid);
            }
            if (!TextUtils.isEmpty(bVar.extra)) {
                bVar.adTemplate.extra = bVar.extra;
            }
            this.arG.g(bVar.adTemplate);
        }
    }
}
