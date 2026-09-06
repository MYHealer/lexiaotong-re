package com.icbc.paysdk;

import com.icbc.paysdk.model.PayResp;
import com.icbc.paysdk.model.ReqErr;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface IPayEventHandler {
    void onErr(ReqErr reqErr);

    void onResp(PayResp payResp);
}
