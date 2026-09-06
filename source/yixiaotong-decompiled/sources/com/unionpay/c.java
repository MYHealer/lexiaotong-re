package com.unionpay;

import android.os.Bundle;
import android.os.Handler;
import com.huawei.nfc.sdk.service.HwOpenPayTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class c implements HwOpenPayTask.IHwResultCallBack {
    c() {
    }

    @Override // com.huawei.nfc.sdk.service.HwOpenPayTask.IHwResultCallBack
    public final void onResult(int i, Bundle bundle) {
        if (UPPayAssistEx.W == null) {
            Handler unused = UPPayAssistEx.W = new Handler(UPPayAssistEx.ac);
        }
        UPPayAssistEx.W.sendMessage(UPPayAssistEx.W.obtainMessage(1003, Integer.valueOf(i)));
    }
}
