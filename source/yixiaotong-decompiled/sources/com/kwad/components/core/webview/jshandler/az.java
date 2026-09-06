package com.kwad.components.core.webview.jshandler;

import com.huawei.openalliance.ad.inter.data.AdEventType;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class az extends com.kwad.components.core.webview.tachikoma.b.w {
    private boolean arv;

    public final void bm(boolean z) {
        this.arv = true;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerLifecycleListener";
    }

    public az() {
        this(false);
    }

    private az(boolean z) {
        this.arv = false;
    }

    public final void yx() {
        aG(AdEventType.SHOW_START);
    }

    public final void yy() {
        aG("showEnd");
    }

    public final void yz() {
        aG("hideStart");
    }

    public final void yA() {
        aG("hideEnd");
    }

    public final void yB() {
        aG("pageVisiable");
    }

    public final void yC() {
        aG("pageInvisiable");
    }

    private void aG(String str) {
        a aVar = new a();
        aVar.arw = str;
        a(aVar);
    }

    @Override // com.kwad.components.core.webview.tachikoma.b.w
    public final void a(com.kwad.sdk.core.b bVar) {
        if (this.arv) {
            if (this.atX != null) {
                this.atX.b(bVar);
                return;
            } else {
                this.atY.add(bVar);
                return;
            }
        }
        super.a(bVar);
    }

    public static final class a implements com.kwad.sdk.core.b {
        private String arw;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.ac.putValue(jSONObject, "lifeStatus", this.arw);
            return jSONObject;
        }
    }
}
