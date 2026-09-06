package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.miui.zeus.mimo.sdk.ad.nativead.NativeAdUIController;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class p1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NativeAdUIController f5559a;

    public p1(NativeAdUIController nativeAdUIController) {
        this.f5559a = nativeAdUIController;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5559a.a(view, ClickAreaType.TYPE_NATIVE_OTHER);
    }
}
