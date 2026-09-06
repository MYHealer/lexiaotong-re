package com.unionpay.b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.unionpay.tsmservice.ITsmCallback;
import com.unionpay.tsmservice.result.VendorPayStatusResult;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a extends ITsmCallback.Stub {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f9308a = 4000;
    private Handler b;

    public a(Handler handler) {
        this.b = handler;
    }

    @Override // com.unionpay.tsmservice.ITsmCallback
    public final void onError(String str, String str2) {
        com.unionpay.utils.j.c("uppay", "errorCode:" + str + ", errorDesc:" + str2);
        Handler handler = this.b;
        handler.sendMessage(Message.obtain(handler, 1, this.f9308a, 0, str + str2));
    }

    @Override // com.unionpay.tsmservice.ITsmCallback
    public final void onResult(Bundle bundle) {
        if (this.f9308a != 4000) {
            return;
        }
        com.unionpay.utils.j.c("uppay-spay", "query vendor pay status callback");
        bundle.setClassLoader(VendorPayStatusResult.class.getClassLoader());
        Bundle vendorPayStatusResult = ((VendorPayStatusResult) bundle.get("result")).getVendorPayStatusResult();
        Handler handler = this.b;
        handler.sendMessage(Message.obtain(handler, 4000, vendorPayStatusResult));
    }
}
