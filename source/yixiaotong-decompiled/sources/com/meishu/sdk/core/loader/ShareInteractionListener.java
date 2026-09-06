package com.meishu.sdk.core.loader;

import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface ShareInteractionListener extends InteractionListener, RecylcerAdInteractionListener {
    @Override // com.meishu.sdk.core.loader.InteractionListener
    void onAdClosed();

    void onShareButtonClicked(ShareInfo shareInfo);
}
