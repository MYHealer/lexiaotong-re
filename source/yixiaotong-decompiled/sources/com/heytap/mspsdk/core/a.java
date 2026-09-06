package com.heytap.mspsdk.core;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.opos.process.bridge.client.BaseProviderClient;
import com.opos.process.bridge.provider.BridgeDispatchException;
import com.opos.process.bridge.provider.BridgeExecuteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class a extends BaseProviderClient {
    public a(Context context) {
        this(context, null);
    }

    public a(Context context, Bundle bundle) {
        super(context, null, bundle);
        this.defaultAuthorities = new String[]{"com.heytap.htms.MspCoreProvider"};
    }

    public final IBinder a() throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        Object objCallForResult = callForResult(this.mContext, "com.heytap.msp.v2.ipcchannel.provider.MspCoreModule", this.mTargetIdentify, 0, new Object[0]);
        checkNullResultType(objCallForResult, IBinder.class);
        if (objCallForResult == null || (objCallForResult instanceof IBinder)) {
            return (IBinder) objCallForResult;
        }
        throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
    }

    @Override // com.opos.process.bridge.client.BaseProviderClient
    protected String getTargetClass() {
        return "com.heytap.msp.v2.ipcchannel.provider.MspCoreProvider";
    }
}
