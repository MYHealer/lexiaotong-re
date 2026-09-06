package com.huawei.hms.hmsscankit;

import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.x3;

/* JADX INFO: compiled from: OnResultCallbackDelegate.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
class d extends IOnResultCallback.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OnResultCallback f4124a;
    private String b;
    private boolean c;

    d(OnResultCallback onResultCallback, boolean z) {
        this.f4124a = onResultCallback;
        this.c = z;
    }

    @Override // com.huawei.hms.hmsscankit.api.IOnResultCallback
    public void onResult(HmsScan[] hmsScanArr) throws RemoteException {
        HmsScan hmsScan;
        x3.c("OnResultCallbackDelegat", "result callback sdk continueScan" + this.c);
        if (this.c) {
            this.f4124a.onResult(hmsScanArr);
            return;
        }
        if (hmsScanArr == null || hmsScanArr.length <= 0 || (hmsScan = hmsScanArr[0]) == null || TextUtils.equals(this.b, hmsScan.getOriginalValue())) {
            return;
        }
        this.b = hmsScanArr[0].getOriginalValue();
        x3.c("OnResultCallbackDelegat", "result callback sdk continueScan" + this.c);
        this.f4124a.onResult(hmsScanArr);
    }
}
