package com.kwad.components.core.innerEc.live.a;

import com.kwad.sdk.utils.ac;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {

    /* JADX INFO: renamed from: com.kwad.components.core.innerEc.live.a.a$a, reason: collision with other inner class name */
    public static final class C0666a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public String TB;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "getMerchantCookie";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            Map<String, String> mapRj = com.kwad.components.core.innerEc.f.rj();
            C0666a c0666a = new C0666a();
            if (mapRj == null) {
                c0666a.TB = "";
            } else {
                c0666a.TB = ac.parseMap2JSON(mapRj).toString();
            }
            cVar.b(c0666a);
        } catch (Exception e) {
            cVar.onError(-1, e.getMessage());
        }
    }
}
