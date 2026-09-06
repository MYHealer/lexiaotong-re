package com.baidu.oauth.sdkbqt.auth;

import android.app.Activity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f1889a;

    q(i iVar) {
        this.f1889a = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f1889a.p != null) {
            com.baidu.oauth.sdkbqt.a.h.a((Activity) this.f1889a.getContext());
            this.f1889a.p.a();
        }
    }
}
