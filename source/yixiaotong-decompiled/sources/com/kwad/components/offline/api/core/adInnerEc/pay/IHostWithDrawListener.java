package com.kwad.components.offline.api.core.adInnerEc.pay;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IHostWithDrawListener {
    void onWithdrawCancel(String str);

    void onWithdrawFailure(int i, String str);

    void onWithdrawSuccess(String str);
}
