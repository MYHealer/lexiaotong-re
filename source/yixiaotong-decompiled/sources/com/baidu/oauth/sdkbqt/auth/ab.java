package com.baidu.oauth.sdkbqt.auth;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class ab extends i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f1867a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ab(i iVar) {
        super();
        this.f1867a = iVar;
    }

    @Override // com.baidu.oauth.sdkbqt.auth.i.a
    public String a(i.e eVar) {
        if (this.f1867a.canGoBack()) {
            this.f1867a.goBack();
            return null;
        }
        this.f1867a.c();
        return null;
    }
}
