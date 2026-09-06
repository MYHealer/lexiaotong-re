package com.baidu.mobads.sdk.internal;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class bk implements aa.a {
    final /* synthetic */ bj c;

    bk(bj bjVar) {
        this.c = bjVar;
    }

    @Override // com.baidu.mobads.sdk.internal.aa.a
    public void onSuccess() {
        this.c.k.a(bj.b, "AbstractProdTemplate,load-dex请求，回调成功");
        this.c.h();
    }

    @Override // com.baidu.mobads.sdk.internal.aa.a
    public void onFailure() {
        this.c.k.a(bj.b, "AbstractProdTemplate,load-dex请求，回调失败");
        this.c.i();
    }
}
