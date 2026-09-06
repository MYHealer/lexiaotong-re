package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface TTClientBidding {
    void loss(Double d, String str, String str2);

    void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener);

    void setPrice(Double d);

    void win(Double d);
}
