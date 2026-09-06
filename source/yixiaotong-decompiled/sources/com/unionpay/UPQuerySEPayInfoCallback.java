package com.unionpay;

import android.os.Bundle;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public interface UPQuerySEPayInfoCallback {
    void onError(String str, String str2, String str3, String str4);

    void onResult(String str, String str2, int i, Bundle bundle);
}
