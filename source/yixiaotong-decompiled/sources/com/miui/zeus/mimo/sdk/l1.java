package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.miui.zeus.mimo.sdk.ad.nativead.NativeAdUIController;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class l1 implements i8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NativeAdUIController f5515a;

    public l1(NativeAdUIController nativeAdUIController) {
        this.f5515a = nativeAdUIController;
    }

    @Override // com.miui.zeus.mimo.sdk.i8
    public void onClick(View view, ClickAreaType clickAreaType) {
        this.f5515a.a(view, clickAreaType);
    }
}
