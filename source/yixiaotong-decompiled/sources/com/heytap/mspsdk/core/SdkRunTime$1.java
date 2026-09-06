package com.heytap.mspsdk.core;

import android.os.RemoteException;
import com.heytap.msp.IMspCallback;
import com.heytap.msp.MspResponse;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
class SdkRunTime$1 extends IMspCallback.Stub {
    final /* synthetic */ e this$0;
    final /* synthetic */ com.heytap.mspsdk.listener.a val$listener;

    SdkRunTime$1(e eVar, com.heytap.mspsdk.listener.a aVar) {
        this.this$0 = eVar;
        this.val$listener = aVar;
    }

    @Override // com.heytap.msp.IMspCallback
    public void callback(MspResponse mspResponse) throws RemoteException {
        com.heytap.mspsdk.listener.b bVar = new com.heytap.mspsdk.listener.b();
        bVar.a(mspResponse.a());
        bVar.a(mspResponse.b());
        if (mspResponse.c() != null) {
            bVar.a((HashMap<String, String>) mspResponse.c().getSerializable("result_map"));
        }
        com.heytap.mspsdk.listener.a aVar = this.val$listener;
        if (aVar != null) {
            aVar.a(bVar);
        }
    }
}
