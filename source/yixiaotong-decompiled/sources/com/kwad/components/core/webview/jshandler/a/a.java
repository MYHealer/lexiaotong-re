package com.kwad.components.core.webview.jshandler.a;

import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a extends com.kwad.components.core.webview.jshandler.e {

    /* JADX INFO: renamed from: com.kwad.components.core.webview.jshandler.a.a$a, reason: collision with other inner class name */
    public static class C0696a extends com.kwad.sdk.core.response.a.a {
        public String arX;
    }

    @Override // com.kwad.components.core.webview.jshandler.e, com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "checkAppInstalled";
    }

    @Override // com.kwad.components.core.webview.jshandler.e
    public final String bC(String str) {
        try {
            C0696a c0696a = new C0696a();
            c0696a.parseJson(new JSONObject(str));
            return c0696a.arX;
        } catch (Throwable unused) {
            return null;
        }
    }
}
