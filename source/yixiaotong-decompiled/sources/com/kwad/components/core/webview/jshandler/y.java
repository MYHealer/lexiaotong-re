package com.kwad.components.core.webview.jshandler;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class y implements com.kwad.sdk.core.webview.c.a {
    private List<AdTemplate> apT;
    private com.kwad.sdk.core.webview.b fi;
    private b st;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public long creativeId = -1;
        public int adStyle = -1;
    }

    public interface b {
        void aa(AdTemplate adTemplate);
    }

    public final void a(b bVar) {
        this.st = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "adImpression";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public y(List<AdTemplate> list) {
        this.apT = list;
    }

    public y(com.kwad.sdk.core.webview.b bVar) {
        this.fi = bVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            a aVar = new a();
            aVar.parseJson(new JSONObject(str));
            AdTemplate adTemplateA = com.kwad.sdk.core.response.helper.e.a(yt(), aVar.creativeId, aVar.adStyle);
            b bVar = this.st;
            if (bVar != null) {
                bVar.aa(adTemplateA);
            }
        } catch (JSONException unused) {
        }
    }

    private List<AdTemplate> yt() {
        List<AdTemplate> list = this.apT;
        if (list != null) {
            return list;
        }
        com.kwad.sdk.core.webview.b bVar = this.fi;
        if (bVar != null) {
            return bVar.Pu();
        }
        return null;
    }
}
