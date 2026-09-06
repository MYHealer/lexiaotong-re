package com.adprof.sdk;

import android.view.View;
import android.widget.FrameLayout;
import com.adprof.sdk.api.BannerAdListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class v4 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g5 f1471a;

    public v4(g5 g5Var) {
        this.f1471a = g5Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        n4 n4Var;
        y4 y4Var = this.f1471a.f305a;
        if (y4Var == null || (n4Var = (n4) ((l4) y4Var).f1277a.get()) == null) {
            return;
        }
        pk.a("BannerAdManager onBannerClose");
        n4Var.h();
        n4Var.g();
        n4Var.m691a();
        FrameLayout frameLayout = n4Var.f498a;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        n4Var.f500a = null;
        try {
            n4Var.mo698a().b(((p5) n4Var).f546a);
        } catch (Throwable unused) {
        }
        BannerAdListener bannerAdListener = n4Var.f499a;
        if (bannerAdListener != null) {
            bannerAdListener.onBannerAdClosed();
        }
    }
}
