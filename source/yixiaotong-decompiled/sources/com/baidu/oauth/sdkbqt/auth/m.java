package com.baidu.oauth.sdkbqt.auth;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class m extends i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f1885a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    m(i iVar) {
        super();
        this.f1885a = iVar;
    }

    @Override // com.baidu.oauth.sdkbqt.auth.i.a
    public String a(i.e eVar) {
        com.baidu.oauth.sdkbqt.a.d.a(i.b, "user has clicked Authorized login");
        if (this.f1885a.t == null) {
            return null;
        }
        this.f1885a.t.f1878a.a(eVar.b().get(0));
        return null;
    }
}
