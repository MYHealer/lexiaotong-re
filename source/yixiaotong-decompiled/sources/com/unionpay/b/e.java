package com.unionpay.b;

import android.util.Log;
import com.unionpay.UPSEInfoResp;
import com.unionpay.tsmservice.UPTsmAddon;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class e implements UPTsmAddon.UPTsmConnectionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f9312a;

    e(b bVar) {
        this.f9312a = bVar;
    }

    @Override // com.unionpay.tsmservice.UPTsmAddon.UPTsmConnectionListener
    public final void onTsmConnected() {
        com.unionpay.utils.j.c("uppay", "TsmService connected.");
        this.f9312a.b();
    }

    @Override // com.unionpay.tsmservice.UPTsmAddon.UPTsmConnectionListener
    public final void onTsmDisconnected() {
        Log.e("uppay", "TsmService disconnected.");
        b bVar = this.f9312a;
        bVar.a(bVar.d, this.f9312a.e, UPSEInfoResp.ERROR_NONE, "Tsm service disconnect");
    }
}
