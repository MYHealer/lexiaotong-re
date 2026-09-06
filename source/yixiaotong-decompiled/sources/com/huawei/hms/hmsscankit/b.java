package com.huawei.hms.hmsscankit;

import android.os.RemoteException;
import android.util.Log;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;

/* JADX INFO: compiled from: OnErrorCallbackDelegate.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
class b extends IOnErrorCallback.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OnErrorCallback f4122a;

    b(OnErrorCallback onErrorCallback) {
        this.f4122a = onErrorCallback;
    }

    @Override // com.huawei.hms.hmsscankit.api.IOnErrorCallback
    public void onError(int i) throws RemoteException {
        if (this.f4122a != null) {
            Log.i("OnErrorCallbackDelegate", "onError: ErrorCode：" + i);
            this.f4122a.onError(i);
        }
    }
}
