package com.baidu.oauth.sdkbqt.auth;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class aa extends i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f1866a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    aa(i iVar) {
        super();
        this.f1866a = iVar;
    }

    @Override // com.baidu.oauth.sdkbqt.auth.i.a
    public String a(i.e eVar) {
        String str = eVar.b().get(0);
        if (this.f1866a.e == null) {
            return null;
        }
        this.f1866a.e.a(str);
        return null;
    }
}
