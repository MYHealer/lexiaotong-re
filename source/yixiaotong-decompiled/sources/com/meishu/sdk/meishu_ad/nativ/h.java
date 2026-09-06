package com.meishu.sdk.meishu_ad.nativ;

/* JADX INFO: compiled from: NormalMediaView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class h extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NormalMediaView f5050a;

    public h(NormalMediaView normalMediaView) {
        this.f5050a = normalMediaView;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        a aVar;
        NormalMediaView normalMediaView = this.f5050a;
        if (normalMediaView.F || (aVar = normalMediaView.E) == null) {
            return;
        }
        aVar.onADExposure();
    }
}
