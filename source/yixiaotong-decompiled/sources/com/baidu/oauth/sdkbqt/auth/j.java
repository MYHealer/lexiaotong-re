package com.baidu.oauth.sdkbqt.auth;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class j extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i f1882a;

    j(i iVar) {
        this.f1882a = iVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message.what == 1) {
            this.f1882a.h();
        }
    }
}
