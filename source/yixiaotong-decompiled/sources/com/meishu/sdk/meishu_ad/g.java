package com.meishu.sdk.meishu_ad;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.meishu.sdk.meishu_ad.splash.MeishuSplashRootView;

/* JADX INFO: compiled from: AdNative.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MeishuSplashRootView f5014a;
    public final /* synthetic */ LinearLayout b;

    public g(v vVar, MeishuSplashRootView meishuSplashRootView, LinearLayout linearLayout) {
        this.f5014a = meishuSplashRootView;
        this.b = linearLayout;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        int measuredHeight = this.f5014a.getMeasuredHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.b.getLayoutParams();
        layoutParams.bottomMargin = (int) (((double) measuredHeight) * 0.1d);
        this.b.setLayoutParams(layoutParams);
    }
}
