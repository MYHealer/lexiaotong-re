package com.miui.zeus.mimo.sdk.ad.interstitial;

import android.app.Activity;
import com.miui.zeus.mimo.sdk.InterstitialAd;
import com.miui.zeus.mimo.sdk.a7;
import com.miui.zeus.mimo.sdk.base.BaseAdImpl;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.d0;
import com.miui.zeus.mimo.sdk.m4;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class InterstitialAdImpl extends BaseAdImpl implements d0 {
    public static final String q = null;
    public static long r;
    public InterstitialAd.InterstitialAdLoadListener m;
    public InterstitialUIController n;
    public InterstitialAd.InterstitialAdInteractionListener o;
    public long p;

    static {
        NCall.IV(new Object[]{26});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void a(long j) {
        NCall.IV(new Object[]{27, this, Long.valueOf(j)});
    }

    public void a(Activity activity, InterstitialAd.InterstitialAdInteractionListener interstitialAdInteractionListener) {
        NCall.IV(new Object[]{28, this, activity, interstitialAdInteractionListener});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void a(MimoAdInfo mimoAdInfo) {
        NCall.IV(new Object[]{29, this, mimoAdInfo});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void a(boolean z) {
        NCall.IV(new Object[]{30, this, Boolean.valueOf(z)});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void b() {
        NCall.IV(new Object[]{31, this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void b(a7 a7Var) {
        NCall.IV(new Object[]{32, this, a7Var});
    }

    @Override // com.miui.zeus.mimo.sdk.d0
    public void b(MimoAdError mimoAdError, m4 m4Var) {
        NCall.IV(new Object[]{33, this, mimoAdError, m4Var});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public boolean d() {
        return NCall.IZ(new Object[]{34, this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void e() {
        NCall.IV(new Object[]{35, this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void f() {
        NCall.IV(new Object[]{36, this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void g() {
        NCall.IV(new Object[]{37, this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void h() {
        NCall.IV(new Object[]{38, this});
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onAdClick() {
        NCall.IV(new Object[]{39, this});
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onAdClosed() {
        NCall.IV(new Object[]{40, this});
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onAdShow() {
        NCall.IV(new Object[]{41, this});
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onRenderFail(int i, String str) {
        NCall.IV(new Object[]{42, this, Integer.valueOf(i), str});
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onVideoEnd() {
        NCall.IV(new Object[]{43, this});
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onVideoPause() {
        NCall.IV(new Object[]{44, this});
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onVideoResume() {
        NCall.IV(new Object[]{45, this});
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onVideoStart() {
        NCall.IV(new Object[]{46, this});
    }
}
