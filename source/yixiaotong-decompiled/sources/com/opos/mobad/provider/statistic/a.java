package com.opos.mobad.provider.statistic;

import android.content.Context;
import android.os.Bundle;
import com.opos.process.bridge.client.BaseProviderClient;
import com.opos.process.bridge.dispatch.StatisticModel$Dispatcher;
import com.opos.process.bridge.provider.BridgeDispatchException;
import com.opos.process.bridge.provider.BridgeExecuteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a extends BaseProviderClient {
    public a(Context context, StatisticModelIdentify statisticModelIdentify) {
        this(context, statisticModelIdentify, null);
    }

    public a(Context context, StatisticModelIdentify statisticModelIdentify, Bundle bundle) {
        super(context, statisticModelIdentify, bundle);
        this.defaultAuthorities = new String[]{"${applicationId}.MobAdGlobalProvider"};
    }

    public final void a(String str) throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        call(this.mContext, StatisticModel$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 2, str);
    }

    public final void a(String str, String str2) throws BridgeExecuteException, BridgeDispatchException {
        checkMainThread();
        call(this.mContext, StatisticModel$Dispatcher.TARGET_CLASS, this.mTargetIdentify, 1, str, str2);
    }

    @Override // com.opos.process.bridge.client.BaseProviderClient
    protected String getTargetClass() {
        return "com.opos.mobad.provider.MobAdGlobalProvider";
    }
}
