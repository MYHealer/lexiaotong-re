package com.meishu.sdk.core.webview;

import android.webkit.WebView;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: WebViewClient.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class l extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoftReference f4985a;
    public final /* synthetic */ m b;

    public l(m mVar, SoftReference softReference) {
        this.b = mVar;
        this.f4985a = softReference;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        try {
            this.b.a((WebView) this.f4985a.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
