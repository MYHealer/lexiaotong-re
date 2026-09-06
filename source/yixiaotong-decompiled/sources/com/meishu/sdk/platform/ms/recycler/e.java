package com.meishu.sdk.platform.ms.recycler;

import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;

/* JADX INFO: compiled from: MeishuPreRenderAdapter.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e implements RecylcerAdInteractionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f5187a;

    public e(i iVar) {
        this.f5187a = iVar;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
    public void onAdClosed() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener, com.meishu.sdk.core.loader.InteractionListener
    public void onAdExposure() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener
    public void onAdRenderFailed() {
    }

    @Override // com.meishu.sdk.core.loader.InteractionListener
    public void onAdClicked() {
        RecylcerAdInteractionListener recylcerAdInteractionListener;
        if (this.f5187a.f5193a.a().getCbc() != 0 || (recylcerAdInteractionListener = this.f5187a.d) == null) {
            return;
        }
        recylcerAdInteractionListener.onAdClicked();
    }
}
