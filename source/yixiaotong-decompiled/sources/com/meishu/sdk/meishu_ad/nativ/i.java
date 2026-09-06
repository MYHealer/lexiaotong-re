package com.meishu.sdk.meishu_ad.nativ;

import android.view.View;

/* JADX INFO: compiled from: NormalMediaView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class i extends com.meishu.sdk.core.safe.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NormalMediaView f5051a;

    public i(NormalMediaView normalMediaView) {
        this.f5051a = normalMediaView;
    }

    @Override // com.meishu.sdk.core.safe.o
    public void safeOnClick(View view) {
        NormalMediaView normalMediaView = this.f5051a;
        if (normalMediaView.p == 2) {
            normalMediaView.resume();
        } else {
            normalMediaView.replay();
        }
    }
}
