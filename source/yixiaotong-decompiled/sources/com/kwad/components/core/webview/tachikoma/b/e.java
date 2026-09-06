package com.kwad.components.core.webview.tachikoma.b;

import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class e extends w {
    private final b atJ;

    public interface b {
        int ky();
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getBottomLimitHeight";
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public e(b bVar) {
        this.atJ = bVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = new a((byte) 0);
        b bVar = this.atJ;
        if (bVar != null) {
            aVar.height = bVar.ky();
            cVar.b(aVar);
        }
    }

    static class a implements com.kwad.sdk.core.b {
        public int height;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, "height", this.height);
            return jSONObject;
        }
    }
}
