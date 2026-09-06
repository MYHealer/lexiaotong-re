package com.kwad.components.core.webview.jshandler;

import android.content.Context;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class bk implements com.kwad.sdk.core.webview.c.a {
    private a arW;
    private AdTemplate mAdTemplate;
    protected Context mContext;

    public interface a {
        boolean eT();
    }

    public final void a(a aVar) {
        this.arW = aVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "showPlayable";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public bk(Context context, AdTemplate adTemplate) {
        this.mContext = com.kwad.sdk.wrapper.m.wrapContextIfNeed(context);
        this.mAdTemplate = adTemplate;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        a aVar = this.arW;
        boolean zET = aVar != null ? aVar.eT() : true;
        com.kwad.sdk.core.d.c.d("WebShowPlayableHandler", "handleJsCall launch AdPlayableActivityProxy : " + zET);
        if (zET) {
            com.kwad.components.core.page.a.launch(this.mContext, this.mAdTemplate);
        }
    }
}
