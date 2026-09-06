package com.meishu.sdk.meishu_ad.reward;

import android.view.View;
import com.meishu.sdk.core.safe.o;

/* JADX INFO: compiled from: FullScreenMediaView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FullScreenMediaView f5067a;

    public a(FullScreenMediaView fullScreenMediaView) {
        this.f5067a = fullScreenMediaView;
    }

    @Override // com.meishu.sdk.core.safe.o
    public void safeOnClick(View view) {
        if (this.f5067a.f5065a.b()) {
            return;
        }
        this.f5067a.start();
    }
}
