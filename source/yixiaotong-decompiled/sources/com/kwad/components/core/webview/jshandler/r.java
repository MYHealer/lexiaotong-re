package com.kwad.components.core.webview.jshandler;

import android.content.Intent;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class r implements com.kwad.sdk.core.webview.c.a {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "postMessage";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        q.a aVar = new q.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
        if (TextUtils.isEmpty(aVar.message)) {
            return;
        }
        Intent intent = new Intent("ksad_webView_local_broadcast");
        intent.putExtra("data", aVar.message);
        com.kwad.sdk.utils.af.dj(ServiceProvider.getContext()).i(intent);
        cVar.b(null);
    }
}
