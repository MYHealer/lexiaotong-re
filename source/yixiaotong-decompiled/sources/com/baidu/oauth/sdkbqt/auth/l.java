package com.baidu.oauth.sdkbqt.auth;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class l extends com.baidu.oauth.sdkbqt.callback.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f1884a;

    l(k kVar) {
        this.f1884a = kVar;
    }

    @Override // com.baidu.oauth.sdkbqt.callback.OauthCallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(com.baidu.oauth.sdkbqt.result.a aVar) {
        this.f1884a.f1883a.loadUrl(this.f1884a.f1883a.d(aVar.f1902a));
    }
}
