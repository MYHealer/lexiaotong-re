package com.kwad.sdk.core.imageloader;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GlobalImageListener implements OnRenderResultListener<AdTemplate> {
    @Override // com.kwad.sdk.core.imageloader.OnRenderResultListener
    public void onRenderResult(boolean z, AdTemplate adTemplate, String str, String str2) {
        if (!z) {
            ((b) ServiceProvider.get(b.class)).K(str, str2);
        }
        if (z) {
            return;
        }
        ((b) ServiceProvider.get(b.class)).bm(adTemplate);
    }
}
