package com.heytap.msp.opos.sv.interapi;

import android.content.Context;
import android.os.Bundle;
import com.heytap.msp.opos.sv.interapi.bean.csc.reorder.ReorderRequest;
import com.heytap.msp.opos.sv.interapi.bean.csc.reorder.ReorderResult;
import com.heytap.msp.opos.sv.interapi.utils.CSCModuleConstants;
import com.opos.cmn.an.f.a;
import com.opos.process.bridge.annotation.BridgeMethod;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import com.opos.process.bridge.client.BaseProviderClient;
import com.opos.process.bridge.provider.BridgeDispatchException;
import com.opos.process.bridge.provider.BridgeExecuteException;
import com.opos.process.bridge.provider.IBridgeHandler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class CSCModule implements IBridgeHandler {
    private static final String TAG = "CSCModule";
    private Interface mModuleImpl;
    private static CSCModule singleInstance = new CSCModule();
    public static IBridgeHandler.Factory FACTORY = new IBridgeHandler.Factory() { // from class: com.heytap.msp.opos.sv.interapi.CSCModule.1
        @Override // com.opos.process.bridge.provider.IBridgeHandler.Factory
        public IBridgeHandler getInstance(Context context, IBridgeTargetIdentify iBridgeTargetIdentify) {
            return CSCModule.singleInstance;
        }
    };

    public final class Client extends BaseProviderClient implements Interface {
        public static final String TARGET_CLASS = "com.heytap.msp.opos.sv.interapi.CSCModule";

        public Client(Context context) {
            this(context, null);
        }

        public Client(Context context, Bundle bundle) {
            super(context, null, bundle);
            this.defaultAuthorities = new String[]{"com.heytap.msp.opos.sv.MSP_SV_PROVIDER"};
        }

        @Override // com.opos.process.bridge.client.BaseProviderClient
        protected String getTargetClass() {
            return "com.heytap.msp.opos.sv.interapi.MSPSvProvider";
        }

        @Override // com.heytap.msp.opos.sv.interapi.CSCModule.Interface
        public final ReorderResult reorder(ReorderRequest reorderRequest) throws BridgeExecuteException, BridgeDispatchException {
            checkMainThread();
            Object objCallForResult = callForResult(this.mContext, "com.heytap.msp.opos.sv.interapi.CSCModule", this.mTargetIdentify, 0, reorderRequest);
            checkNullResultType(objCallForResult, ReorderResult.class);
            if (objCallForResult == null || (objCallForResult instanceof ReorderResult)) {
                return (ReorderResult) objCallForResult;
            }
            throw new BridgeExecuteException("return value is not match:" + objCallForResult, 102004);
        }
    }

    public interface Interface {
        ReorderResult reorder(ReorderRequest reorderRequest) throws BridgeExecuteException, BridgeDispatchException;
    }

    public static CSCModule getInstance() {
        return singleInstance;
    }

    @BridgeMethod
    public ReorderResult reorder(ReorderRequest reorderRequest) {
        try {
            return this.mModuleImpl.reorder(reorderRequest);
        } catch (Throwable th) {
            a.c(TAG, "reorder", th);
            return new ReorderResult(CSCModuleConstants.ERROR_CODE_UNKNOWN_ERROR, th.getMessage());
        }
    }

    public void setModuleImpl(Interface r1) {
        this.mModuleImpl = r1;
    }
}
