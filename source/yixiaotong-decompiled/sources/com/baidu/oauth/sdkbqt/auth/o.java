package com.baidu.oauth.sdkbqt.auth;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class o extends com.baidu.oauth.sdkbqt.callback.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f1887a;

    o(i iVar) {
        this.f1887a = iVar;
    }

    @Override // com.baidu.oauth.sdkbqt.callback.OauthCallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(com.baidu.oauth.sdkbqt.result.a aVar) {
        i iVar = this.f1887a;
        iVar.loadUrl(iVar.d(aVar.f1902a));
    }
}
