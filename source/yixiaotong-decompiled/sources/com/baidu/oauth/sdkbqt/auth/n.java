package com.baidu.oauth.sdkbqt.auth;

import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class n extends com.baidu.oauth.sdkbqt.callback.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f1886a;
    final /* synthetic */ String b;
    final /* synthetic */ i c;

    n(i iVar, Map map, String str) {
        this.c = iVar;
        this.f1886a = map;
        this.b = str;
    }

    @Override // com.baidu.oauth.sdkbqt.callback.OauthCallback
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onSuccess(com.baidu.oauth.sdkbqt.result.a aVar) {
        com.baidu.oauth.sdkbqt.a.d.a(i.b, "generate sso_hash success, which is " + aVar.f1902a);
        this.f1886a.put("oauth_sso_hash", aVar.f1902a);
        this.c.loadUrl(this.b + i.a((Map<String, String>) this.f1886a, true));
    }
}
