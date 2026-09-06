package com.miui.zeus.mimo.sdk;

import com.miui.zeus.mimo.sdk.ad.nativead.NativeAdUIController;
import com.miui.zeus.mimo.sdk.view.AdImpressMonitor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class q1 implements AdImpressMonitor.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NativeAdUIController f5568a;

    public q1(NativeAdUIController nativeAdUIController) {
        this.f5568a = nativeAdUIController;
    }

    @Override // com.miui.zeus.mimo.sdk.view.AdImpressMonitor.a
    public void onAdShow() {
        NativeAdUIController.a(this.f5568a);
    }
}
