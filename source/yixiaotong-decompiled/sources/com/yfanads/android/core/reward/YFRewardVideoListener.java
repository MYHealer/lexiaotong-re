package com.yfanads.android.core.reward;

import com.yfanads.android.callback.BaseAdListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface YFRewardVideoListener extends BaseAdListener {
    void onRewardServerInf(YFRewardServerCallBackInf yFRewardServerCallBackInf);

    void onVideoCacheFailed();

    void onVideoCached();

    void onVideoComplete();

    void onVideoSkip();
}
