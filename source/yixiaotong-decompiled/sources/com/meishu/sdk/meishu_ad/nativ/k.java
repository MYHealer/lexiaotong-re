package com.meishu.sdk.meishu_ad.nativ;

import android.view.View;

/* JADX INFO: compiled from: NormalMediaView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class k extends com.meishu.sdk.core.safe.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NormalMediaView f5053a;

    public k(NormalMediaView normalMediaView) {
        this.f5053a = normalMediaView;
    }

    @Override // com.meishu.sdk.core.safe.o
    public void safeOnClick(View view) {
        if (this.f5053a.b.b()) {
            this.f5053a.pause();
        }
    }
}
