package com.kwad.components.core.innerEc.live.a;

import com.kwad.components.core.webview.tachikoma.b.w;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class d extends w {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerLiveEndListener";
    }

    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean TE;

        public final a aK(boolean z) {
            this.TE = true;
            return this;
        }

        public static a rw() {
            return new a();
        }
    }
}
