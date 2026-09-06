package com.huawei.hms.hmsscankit;

import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;

/* JADX INFO: compiled from: OnLightVisibleCallBackDelegata.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
class c extends IOnLightCallback.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OnLightVisibleCallBack f4123a;

    c(OnLightVisibleCallBack onLightVisibleCallBack) {
        this.f4123a = onLightVisibleCallBack;
    }

    @Override // com.huawei.hms.hmsscankit.api.IOnLightCallback
    public void onVisibleChanged(boolean z) throws RemoteException {
        this.f4123a.onVisibleChanged(z);
    }
}
