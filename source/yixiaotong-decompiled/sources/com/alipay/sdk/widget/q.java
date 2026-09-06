package com.alipay.sdk.widget;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
class q implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebViewWindow f1684a;

    q(WebViewWindow webViewWindow) {
        this.f1684a = webViewWindow;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        WebViewWindow.c cVar = this.f1684a.i;
        if (cVar != null) {
            view.setEnabled(false);
            WebViewWindow.f.postDelayed(new r(this, view), 256L);
            if (view != this.f1684a.f1669a) {
                if (view == this.f1684a.c) {
                    cVar.b(this.f1684a);
                    return;
                }
                return;
            }
            cVar.a(this.f1684a);
        }
    }
}
