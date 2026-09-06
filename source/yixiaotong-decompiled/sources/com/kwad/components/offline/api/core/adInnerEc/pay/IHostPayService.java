package com.kwad.components.offline.api.core.adInnerEc.pay;

import android.app.Activity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface IHostPayService {
    void startMerchantPay(Activity activity, boolean z, String str, String str2, IHostPayResultListener iHostPayResultListener);

    void startPay(Activity activity, String str, String str2, IHostPayResultListener iHostPayResultListener);

    void withDraw(Activity activity, String str, IHostWithDrawListener iHostWithDrawListener);
}
