package com.opos.process.bridge.dispatch;

import android.content.Context;
import android.os.Bundle;
import com.heytap.msp.opos.sv.interapi.CSCModule;
import com.heytap.msp.opos.sv.interapi.bean.csc.reorder.ReorderRequest;
import com.heytap.msp.opos.sv.interapi.bean.csc.reorder.ReorderResult;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.provider.BundleUtil;
import com.opos.process.bridge.server.c;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class CSCModule$Dispatcher implements IDispatcher {
    public static final String TARGET_CLASS = "com.heytap.msp.opos.sv.interapi.CSCModule";

    public static void init() {
        a.a().a("com.heytap.msp.opos.sv.interapi.CSCModule", new CSCModule$Dispatcher());
    }

    @Override // com.opos.process.bridge.dispatch.IDispatcher
    public Bundle dispatch(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i, Object[] objArr) {
        Object obj;
        if (i != 0) {
            return BundleUtil.makeBundle(102002, "methodId:" + i);
        }
        if (1 == objArr.length && ((obj = objArr[0]) == null || (obj instanceof ReorderRequest))) {
            return BundleUtil.packageBundle(((CSCModule) CSCModule.FACTORY.getInstance(context, iBridgeTargetIdentify)).reorder((ReorderRequest) objArr[0]), ReorderResult.class);
        }
        c.a().a("com.heytap.msp.opos.sv.interapi.CSCModule", str, 102003, "received params not match");
        return BundleUtil.makeBundle(102003, "received params not match");
    }
}
