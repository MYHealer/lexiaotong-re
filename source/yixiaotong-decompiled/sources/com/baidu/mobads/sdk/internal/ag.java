package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class ag implements IOAdEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ae f1716a;

    ag(ae aeVar) {
        this.f1716a = aeVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f1716a.x();
        }
    }
}
