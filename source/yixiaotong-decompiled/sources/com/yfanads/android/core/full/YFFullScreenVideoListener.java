package com.yfanads.android.core.full;

import com.yfanads.android.callback.BaseAdListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface YFFullScreenVideoListener extends BaseAdListener {
    void onVideoCached();

    void onVideoComplete();

    void onVideoSkipped();
}
