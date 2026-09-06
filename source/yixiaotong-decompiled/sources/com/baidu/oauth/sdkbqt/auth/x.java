package com.baidu.oauth.sdkbqt.auth;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class x extends i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f1896a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    x(i iVar) {
        super();
        this.f1896a = iVar;
    }

    @Override // com.baidu.oauth.sdkbqt.auth.i.a
    public String a(i.e eVar) {
        return this.f1896a.d.containsKey(eVar.b().get(0)) ? "1" : "0";
    }
}
