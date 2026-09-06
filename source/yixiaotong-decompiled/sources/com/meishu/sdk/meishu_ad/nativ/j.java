package com.meishu.sdk.meishu_ad.nativ;

import android.view.View;

/* JADX INFO: compiled from: NormalMediaView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class j extends com.meishu.sdk.core.safe.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NormalMediaView f5052a;

    public j(NormalMediaView normalMediaView) {
        this.f5052a = normalMediaView;
    }

    @Override // com.meishu.sdk.core.safe.o
    public void safeOnClick(View view) {
        if (this.f5052a.b.b()) {
            return;
        }
        this.f5052a.resume();
    }
}
