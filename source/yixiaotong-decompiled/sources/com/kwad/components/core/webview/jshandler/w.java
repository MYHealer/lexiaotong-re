package com.kwad.components.core.webview.jshandler;

import android.os.Vibrator;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class w implements com.kwad.sdk.core.webview.c.a {
    private Vibrator hw;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "startVibrate";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        this.hw = (Vibrator) ServiceProvider.getContext().getSystemService("vibrator");
        by.a(ServiceProvider.getContext(), this.hw);
        cVar.b(null);
    }
}
