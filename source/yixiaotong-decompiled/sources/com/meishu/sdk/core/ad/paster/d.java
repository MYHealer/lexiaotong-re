package com.meishu.sdk.core.ad.paster;

/* JADX INFO: compiled from: PasterAdListenerProxy.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d extends com.meishu.sdk.core.loader.b<PasterAd, b> implements b {
    public d(com.meishu.sdk.core.loader.d dVar, b bVar) {
        super(dVar, bVar);
    }

    @Override // com.meishu.sdk.core.ad.paster.b
    public void onVideoComplete() {
        ((b) this.b).onVideoComplete();
    }

    @Override // com.meishu.sdk.core.ad.paster.b
    public void onVideoError() {
        ((b) this.b).onVideoError();
    }

    @Override // com.meishu.sdk.core.ad.paster.b
    public void onVideoLoaded() {
        ((b) this.b).onVideoLoaded();
    }
}
