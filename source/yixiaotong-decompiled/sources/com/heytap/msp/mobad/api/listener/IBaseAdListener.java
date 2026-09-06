package com.heytap.msp.mobad.api.listener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface IBaseAdListener {
    void onAdClick();

    void onAdFailed(int i, String str);

    @Deprecated
    void onAdFailed(String str);

    void onAdShow();
}
