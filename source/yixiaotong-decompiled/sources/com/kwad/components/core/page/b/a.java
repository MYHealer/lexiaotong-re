package com.kwad.components.core.page.b;

import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a extends com.kwad.components.core.page.d.a.a {
    @Override // com.kwad.components.core.page.d.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        c.w("MerchantWebViewPresenter", "onBind mCallerContext.mPageUrl:  " + this.adZ.mPageUrl);
        if (this.adZ.aea != null) {
            try {
                c.w("MerchantWebViewPresenter", "onBind mCallerContext mMerchantWebView classLoader: " + this.adZ.aea.getClass().getClassLoader());
                final String str = this.adZ.mPageUrl;
                c.d("MerchantWebViewPresenter", "onBind delay: 100");
                by.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.core.page.b.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        a.this.adZ.aea.loadUrl(str);
                    }
                }, 100L);
            } catch (Throwable th) {
                c.w("MerchantWebViewPresenter", "onBind loadUrl error: " + th.getMessage());
                c.printStackTraceOnly(th);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }
}
