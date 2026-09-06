package com.baidu.oauth.sdkbqt.auth;

import android.content.DialogInterface;
import android.webkit.JsResult;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class v implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ JsResult f1894a;
    final /* synthetic */ u b;

    v(u uVar, JsResult jsResult) {
        this.b = uVar;
        this.f1894a = jsResult;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1894a.confirm();
    }
}
