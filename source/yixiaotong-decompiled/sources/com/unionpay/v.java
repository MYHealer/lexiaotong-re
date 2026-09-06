package com.unionpay;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ aa f9366a;
    final /* synthetic */ String b;
    final /* synthetic */ ab c;
    final /* synthetic */ WebViewJavascriptBridge d;

    v(WebViewJavascriptBridge webViewJavascriptBridge, aa aaVar, String str, ab abVar) {
        this.d = webViewJavascriptBridge;
        this.f9366a = aaVar;
        this.b = str;
        this.c = abVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        aa aaVar = this.f9366a;
        if (aaVar != null) {
            aaVar.a(this.b, this.c);
        }
    }
}
