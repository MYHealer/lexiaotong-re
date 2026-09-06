package com.kwad.components.core.innerEc.live.a;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.kwad.components.core.webview.tachikoma.b.w;
import com.kwad.sdk.utils.ac;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class p extends w {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerHorizontalSwipeListener";
    }

    public final void ry() {
        aG(TtmlNode.LEFT);
    }

    public final void rz() {
        aG(TtmlNode.RIGHT);
    }

    private void aG(String str) {
        a aVar = new a();
        aVar.TO = str;
        a(aVar);
    }

    public static final class a implements com.kwad.sdk.core.b {
        private String TO;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.TO = jSONObject.optString("swipeStatus");
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, "swipeStatus", this.TO);
            return jSONObject;
        }
    }
}
