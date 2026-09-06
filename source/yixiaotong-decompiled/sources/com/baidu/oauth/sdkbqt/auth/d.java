package com.baidu.oauth.sdkbqt.auth;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class d implements b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.baidu.oauth.sdkbqt.callback.a f1872a;
    final /* synthetic */ c b;

    d(c cVar, com.baidu.oauth.sdkbqt.callback.a aVar) {
        this.b = cVar;
        this.f1872a = aVar;
    }

    @Override // com.baidu.oauth.sdkbqt.auth.b.a
    public void a(long j) {
        com.baidu.oauth.sdkbqt.result.a aVar = new com.baidu.oauth.sdkbqt.result.a();
        aVar.f1902a = new h().a(Long.valueOf(j));
        aVar.setResultCode(0);
        this.f1872a.onSuccess(aVar);
    }
}
