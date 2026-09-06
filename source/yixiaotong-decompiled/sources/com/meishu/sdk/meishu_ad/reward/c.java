package com.meishu.sdk.meishu_ad.reward;

import android.view.View;
import com.meishu.sdk.core.safe.o;

/* JADX INFO: compiled from: FullScreenMediaView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c extends o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FullScreenMediaView f5069a;

    public c(FullScreenMediaView fullScreenMediaView) {
        this.f5069a = fullScreenMediaView;
    }

    @Override // com.meishu.sdk.core.safe.o
    public void safeOnClick(View view) {
        if (this.f5069a.f5065a.b()) {
            FullScreenMediaView fullScreenMediaView = this.f5069a;
            fullScreenMediaView.f5065a.c();
            fullScreenMediaView.d();
            com.meishu.sdk.meishu_ad.nativ.e eVar = fullScreenMediaView.g;
            if (eVar != null) {
                eVar.onVideoPause();
            }
        }
    }
}
