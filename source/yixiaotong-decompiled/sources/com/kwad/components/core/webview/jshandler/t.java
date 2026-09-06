package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class t implements com.kwad.sdk.core.webview.c.a {
    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "removeStorageItem";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (!TextUtils.isEmpty(str)) {
            if (bF(str)) {
                cVar.b(null);
                return;
            } else {
                cVar.onError(-1, "");
                return;
            }
        }
        cVar.onError(-1, "data is empty");
    }

    private static boolean bF(String str) {
        u.a aVar = new u.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException unused) {
        }
        if (TextUtils.isEmpty(aVar.key)) {
            return false;
        }
        com.kwad.sdk.utils.ai.h(ServiceProvider.getContext(), "ksadsdk_js_storage_cache_name", aVar.key);
        return true;
    }
}
