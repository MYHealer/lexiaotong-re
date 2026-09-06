package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e implements com.kwad.sdk.core.webview.c.a {

    public static class b extends com.kwad.sdk.core.response.a.a {
        public String packageName;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public String getKey() {
        return "isAppInstalled";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        String strBC = bC(str);
        if (TextUtils.isEmpty(strBC)) {
            return;
        }
        a aVar = new a();
        aVar.apA = bD(strBC);
        cVar.b(aVar);
    }

    protected String bC(String str) {
        b bVar = new b();
        try {
            bVar.parseJson(new JSONObject(str));
            return bVar.packageName;
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean bD(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return com.kwad.sdk.utils.au.aw(ServiceProvider.getContext(), str);
    }

    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean apA;

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isInstalled", this.apA);
            return jSONObject;
        }
    }
}
