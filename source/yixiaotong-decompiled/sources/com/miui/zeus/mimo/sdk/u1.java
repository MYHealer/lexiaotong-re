package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.miui.zeus.mimo.sdk.ad.nativead.NativeAdUIController;
import com.miui.zeus.mimo.sdk.ad.nativead.view.NativeAdView;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.common.ViewEventHelper;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class u1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NativeAdUIController f5625a;

    public u1(NativeAdUIController nativeAdUIController) {
        this.f5625a = nativeAdUIController;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        NativeAdUIController nativeAdUIController = this.f5625a;
        c6 c6Var = new c6(view, nativeAdUIController.f5302a, nativeAdUIController.v, nativeAdUIController.w, new View[]{nativeAdUIController.u}, ((NativeAdView) nativeAdUIController.f5302a).getViewEventInfo(), true, true);
        AdEvent adEvent = AdEvent.CLOSE;
        k6 k6VarA = k6.a(null, c6Var.f5387a, null);
        MimoAdInfo mimoAdInfo = nativeAdUIController.d;
        ViewEventHelper viewEventHelper = nativeAdUIController.l;
        b.a(adEvent, mimoAdInfo, viewEventHelper != null ? viewEventHelper.f5395a : null, k6VarA);
        NativeAdUIController.b bVar = nativeAdUIController.f;
        if (bVar != null) {
            bVar.onAdClosed();
        }
        nativeAdUIController.a();
    }
}
