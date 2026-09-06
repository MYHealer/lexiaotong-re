package com.meishu.sdk.core.ad.recycler;

import com.meishu.sdk.core.loader.InteractionListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface RecylcerAdInteractionListener extends InteractionListener {
    @Override // com.meishu.sdk.core.loader.InteractionListener
    void onAdClosed();

    @Override // com.meishu.sdk.core.loader.InteractionListener
    void onAdExposure();

    void onAdRenderFailed();
}
