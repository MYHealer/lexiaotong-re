package com.unionpay.b;

import android.util.Log;
import com.unionpay.UPSEInfoResp;
import com.unionpay.tsmservice.mi.UPTsmAddon;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class i implements UPTsmAddon.UPTsmConnectionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g f9316a;

    i(g gVar) {
        this.f9316a = gVar;
    }

    @Override // com.unionpay.tsmservice.mi.UPTsmAddon.UPTsmConnectionListener
    public final void onTsmConnected() {
        com.unionpay.utils.j.c("uppay", "mi TsmService connected.");
        this.f9316a.b();
    }

    @Override // com.unionpay.tsmservice.mi.UPTsmAddon.UPTsmConnectionListener
    public final void onTsmDisconnected() {
        Log.e("uppay", "mi TsmService disconnected.");
        g gVar = this.f9316a;
        gVar.a(gVar.d, this.f9316a.e, UPSEInfoResp.ERROR_NONE, "Tsm service disconnect");
    }
}
