package com.miui.zeus.mimo.sdk;

import com.miui.zeus.mimo.sdk.ad.nativead.NativeAdUIController;
import com.miui.zeus.mimo.sdk.view.AdImpressMonitor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class r1 implements AdImpressMonitor.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NativeAdUIController f5580a;

    public r1(NativeAdUIController nativeAdUIController) {
        this.f5580a = nativeAdUIController;
    }

    @Override // com.miui.zeus.mimo.sdk.view.AdImpressMonitor.a
    public void onAdShow() {
        NativeAdUIController.a(this.f5580a);
    }
}
