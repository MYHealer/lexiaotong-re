package com.unionpay.b;

import android.os.Bundle;
import android.os.Message;
import com.huawei.nfc.sdk.service.HwOpenPayTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class f implements HwOpenPayTask.IHwPayResultCallBack {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9313a;

    f(b bVar) {
        this.f9313a = bVar;
    }

    @Override // com.huawei.nfc.sdk.service.HwOpenPayTask.IHwPayResultCallBack
    public final void onError(String str, String str2) {
        com.unionpay.utils.j.c("uppay", "queryHwPayStatus onError, errorCode:" + str + " errorMsg:" + str2);
        if (this.f9313a.j != null) {
            Message messageObtainMessage = this.f9313a.j.obtainMessage(4002);
            Bundle bundle = new Bundle();
            bundle.putString("errorCode", str);
            bundle.putString("errorDesc", str2);
            messageObtainMessage.obj = bundle;
            this.f9313a.j.sendMessage(messageObtainMessage);
        }
    }

    @Override // com.huawei.nfc.sdk.service.HwOpenPayTask.IHwPayResultCallBack
    public final void onResult(Bundle bundle) {
        com.unionpay.utils.j.c("uppay", "queryHwPayStatus onResult");
        if (this.f9313a.j != null) {
            Message messageObtainMessage = this.f9313a.j.obtainMessage(4001);
            messageObtainMessage.obj = bundle;
            this.f9313a.j.sendMessage(messageObtainMessage);
        }
    }
}
