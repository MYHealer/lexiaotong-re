package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class cv implements IOAdEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ cu f1794a;

    cv(cu cuVar) {
        this.f1794a = cuVar;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEventListener
    public void run(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            this.f1794a.c((Map<String, Object>) iOAdEvent.getData());
        }
    }
}
