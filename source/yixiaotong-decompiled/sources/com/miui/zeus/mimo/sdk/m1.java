package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.miui.zeus.mimo.sdk.ad.nativead.NativeAdUIController;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class m1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NativeAdUIController f5525a;

    public m1(NativeAdUIController nativeAdUIController) {
        this.f5525a = nativeAdUIController;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5525a.a(view, ClickAreaType.TYPE_VIDEO);
    }
}
