package com.bytedance.sdk.openadsdk.mediation;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface IMediationDrawAdTokenCallback {
    void onAdTokenLoaded(String str, IMediationDrawTokenInfo iMediationDrawTokenInfo);

    void onAdTokenLoadedFail(int i, String str);
}
