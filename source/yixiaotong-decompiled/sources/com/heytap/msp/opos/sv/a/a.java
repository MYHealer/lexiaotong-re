package com.heytap.msp.opos.sv.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.heytap.msp.opos.sv.api.params.ErrorCode;
import com.heytap.msp.opos.sv.interapi.CSCModule;
import com.heytap.msp.opos.sv.interapi.bean.csc.reorder.ReorderRequest;
import com.heytap.msp.opos.sv.interapi.bean.csc.reorder.ReorderResult;
import com.heytap.msp.opos.sv.interapi.bean.csc.reorder.ResultAdEntity;
import com.heytap.mspsdk.MspSdk;
import com.heytap.mspsdk.exception.MspSdkException;
import com.opos.process.bridge.provider.BridgeException;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a implements b {
    private String a(ReorderRequest reorderRequest) {
        String expItemId = reorderRequest.getExpItemId();
        if (expItemId == null || TextUtils.isEmpty(expItemId)) {
            com.opos.cmn.an.f.a.b("CSCManagerImpl", "requestReq is invalid: expItemId invalid");
            return "requestReq is invalid: expItemId invalid";
        }
        int triggerAction = reorderRequest.getTriggerAction();
        if (triggerAction != 1 && triggerAction != 2) {
            com.opos.cmn.an.f.a.b("CSCManagerImpl", "requestReq is invalid: triggerAction is illegal");
            return "trigger action illegal";
        }
        if (reorderRequest.getRecorderReqEntityList() != null && !reorderRequest.getRecorderReqEntityList().isEmpty()) {
            return "";
        }
        com.opos.cmn.an.f.a.b("CSCManagerImpl", "requestReq is invalid: reqAdEntityList is null or empty");
        return "requestReq is invalid: reqAdEntityList is null or empty";
    }

    private boolean a(Context context) {
        return com.heytap.msp.opos.sv.a.b.a.a(context) >= 1000000;
    }

    private boolean a(ReorderResult reorderResult) {
        List<ResultAdEntity> reorderEntityList = reorderResult.getReorderEntityList();
        return (reorderResult.getCode() != 0 || reorderEntityList == null || reorderEntityList.isEmpty()) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:37:0x0100  */
    /* JADX WARN: Code duplicated, block: B:39:0x0108  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v20 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v30 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v34 */
    /* JADX WARN: Type inference failed for: r10v35 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [com.heytap.msp.opos.sv.interapi.bean.csc.reorder.ReorderResult] */
    /* JADX WARN: Type inference failed for: r10v8, types: [com.heytap.msp.opos.sv.interapi.bean.csc.reorder.ReorderResult, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.heytap.msp.opos.sv.a.a] */
    /* JADX WARN: Type inference failed for: r9v16, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v17, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r9v24, types: [com.heytap.msp.opos.sv.interapi.bean.csc.reorder.ReorderResult, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v29 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v40 */
    /* JADX WARN: Type inference failed for: r9v41 */
    /* JADX WARN: Type inference failed for: r9v42 */
    /* JADX WARN: Type inference failed for: r9v43 */
    /* JADX WARN: Type inference failed for: r9v44 */
    @Override // com.heytap.msp.opos.sv.a.b
    public ReorderResult reorder(Context context, ReorderRequest reorderRequest) {
        ?? r10;
        ?? r11;
        ?? r12;
        ?? r0;
        ?? r1;
        ?? r2;
        ?? r3;
        ?? r13;
        ?? r9;
        ?? reorderResult;
        char c;
        String str;
        ?? r4 = "reorder";
        com.opos.cmn.an.f.a.a("CSCManagerImpl", "reorder: request = " + reorderRequest);
        try {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            String strA = a(reorderRequest);
            if (TextUtils.isEmpty(strA)) {
                if (a(origApplicationContext)) {
                    Bundle bundle = new Bundle();
                    com.heytap.msp.opos.sv.a.b.a.a(bundle);
                    ?? Reorder = ((CSCModule.Interface) MspSdk.apiProxy(new CSCModule.Client(origApplicationContext, bundle))).reorder(reorderRequest);
                    try {
                        com.opos.cmn.an.f.a.a("CSCManagerImpl", "server return reorder result:" + Reorder);
                        if (Reorder != 0) {
                            int code = a(Reorder) ? 0 : Reorder.getCode();
                            r13 = Reorder;
                            Reorder = Reorder.getMsg();
                            r4 = code;
                            r1 = r4;
                            r9 = Reorder;
                        } else {
                            r1 = 20001008;
                            r13 = Reorder;
                            r9 = "csc sv error: reorder result is null";
                        }
                    } catch (MspSdkException e) {
                        r12 = Reorder;
                        e = e;
                        r3 = r4;
                        com.opos.cmn.an.f.a.d("CSCManagerImpl", r3, e);
                        r1 = 50001004;
                        r9 = ErrorCode.ERROR_MSG_MSP_ERROR_PREFIX + e.getMessage();
                        r13 = r12;
                    } catch (BridgeException e2) {
                        r11 = Reorder;
                        e = e2;
                        r2 = r4;
                        com.opos.cmn.an.f.a.d("CSCManagerImpl", r2, e);
                        r1 = 10001005;
                        r9 = ErrorCode.ERROR_MSG_CSC_ERROR_PREFIX + e.getMessage();
                        r13 = r11;
                    } catch (Throwable th) {
                        r10 = Reorder;
                        th = th;
                        r0 = r4;
                        com.opos.cmn.an.f.a.d("CSCManagerImpl", r0, th);
                        r1 = 10000000;
                        r9 = ErrorCode.ERROR_MSG_UNKNOWN_ERROR + th.getMessage();
                        r13 = r10;
                    }
                } else {
                    c = 12522;
                    str = "csc sv error: kit version not supported";
                }
                if (r13 == 0) {
                    reorderResult = new ReorderResult(r1, r9);
                } else {
                    r13.setCode(r1);
                    r13.setMsg(r9);
                    if (r1 != 0) {
                        reorderResult = r13;
                        r13.setReorderEntityList(null);
                        reorderResult = r13;
                    }
                }
                reorderResult = r13;
                com.opos.cmn.an.f.a.a("CSCManagerImpl", "reorder result:" + reorderResult);
                return reorderResult;
            }
            c = 39531;
            str = "10000000" + strA;
            r1 = c;
            r13 = 0;
            r9 = str;
        } catch (MspSdkException e3) {
            e = e3;
            r12 = 0;
            r3 = r4;
        } catch (BridgeException e4) {
            e = e4;
            r11 = 0;
            r2 = r4;
        } catch (Throwable th2) {
            th = th2;
            r10 = 0;
            r0 = r4;
        }
        if (r13 == 0) {
            reorderResult = new ReorderResult(r1, r9);
        } else {
            r13.setCode(r1);
            r13.setMsg(r9);
            if (r1 != 0) {
                reorderResult = r13;
                r13.setReorderEntityList(null);
                reorderResult = r13;
            }
        }
        reorderResult = r13;
        com.opos.cmn.an.f.a.a("CSCManagerImpl", "reorder result:" + reorderResult);
        return reorderResult;
    }
}
