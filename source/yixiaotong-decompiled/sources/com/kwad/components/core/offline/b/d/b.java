package com.kwad.components.core.offline.b.d;

import android.content.Context;
import com.kwad.components.offline.api.core.webview.BaseKsWebView;
import com.kwad.components.offline.api.core.webview.IWebView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b implements IWebView {
    @Override // com.kwad.components.offline.api.core.webview.IWebView
    public final BaseKsWebView createWebView(Context context) {
        return new a(context);
    }
}
