package com.hihonor.adsdk.base.api.feed;

import com.hihonor.adsdk.base.NegativeFeedback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface AdDislike {
    void onCancel();

    void onSelected(int i, NegativeFeedback negativeFeedback, boolean z);

    void onShow();
}
