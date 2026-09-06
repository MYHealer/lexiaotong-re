package com.bytedance.sdk.openadsdk;

import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface ILiveAdCustomConfig {
    String convertToEnterFromMerge(int i);

    String convertToEnterMethod(int i, boolean z);

    Object invoke(int i, Bundle bundle);

    void onEventV3(String str, JSONObject jSONObject);

    int openLR(String str);
}
