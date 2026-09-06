package com.kwad.components.offline.api.core.adInnerEc.pay;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IHostPayResultListener {
    void onPayCancel();

    void onPayFailure(String str);

    void onPaySuccess();

    void onPayUnknown();
}
