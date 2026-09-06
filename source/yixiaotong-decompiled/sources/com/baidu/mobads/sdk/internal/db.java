package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class db implements IOAdEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ cz f1801a;

    db(cz czVar) {
        this.f1801a = czVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f1801a.z();
        }
    }
}
