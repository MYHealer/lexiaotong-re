package com.unionpay;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
final class x implements ab {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ WebViewJavascriptBridge f9368a;
    private final String b;

    public x(WebViewJavascriptBridge webViewJavascriptBridge, String str) {
        this.f9368a = webViewJavascriptBridge;
        this.b = str;
    }

    @Override // com.unionpay.ab
    public final void a(String str) {
        this.f9368a._callbackJs(this.b, str);
    }
}
