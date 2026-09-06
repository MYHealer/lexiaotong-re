package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class af implements IOAdEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ae f1715a;

    af(ae aeVar) {
        this.f1715a = aeVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f1715a.c((Map<String, Object>) iOAdEvent.getData());
        }
    }
}
