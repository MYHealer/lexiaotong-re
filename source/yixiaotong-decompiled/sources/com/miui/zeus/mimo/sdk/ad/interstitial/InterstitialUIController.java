package com.miui.zeus.mimo.sdk.ad.interstitial;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.common.ViewMeasureHelper;
import com.miui.zeus.mimo.sdk.d0;
import com.miui.zeus.mimo.sdk.e0;
import com.miui.zeus.mimo.sdk.h0;
import com.miui.zeus.mimo.sdk.m4;
import com.miui.zeus.mimo.sdk.r3;
import com.miui.zeus.mimo.sdk.u8;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class InterstitialUIController implements h0, d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MimoAdInfo f5298a;
    public u8 b;
    public d0 c;
    public View d;
    public Activity e;
    public String f;
    public String g;
    public r3 h;
    public ViewMeasureHelper i;
    public e0 j;
    public boolean k = false;
    public Bitmap l;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{49, this});
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5300a;

        public b(View view) {
            this.f5300a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{47, this});
        }
    }

    public void a() {
        NCall.IV(new Object[]{15, this});
    }

    public final void b() {
        NCall.IV(new Object[]{16, this});
    }

    @Override // com.miui.zeus.mimo.sdk.d0
    public void b(MimoAdError mimoAdError, m4 m4Var) {
        NCall.IV(new Object[]{17, this, mimoAdError, m4Var});
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onAdClick() {
        NCall.IV(new Object[]{18, this});
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onAdClosed() {
        NCall.IV(new Object[]{19, this});
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onAdShow() {
        NCall.IV(new Object[]{20, this});
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onRenderFail(int i, String str) {
        NCall.IV(new Object[]{21, this, Integer.valueOf(i), str});
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onVideoEnd() {
        NCall.IV(new Object[]{22, this});
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onVideoPause() {
        NCall.IV(new Object[]{23, this});
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onVideoResume() {
        NCall.IV(new Object[]{24, this});
    }

    @Override // com.miui.zeus.mimo.sdk.InterstitialAd.InterstitialAdInteractionListener
    public void onVideoStart() {
        NCall.IV(new Object[]{25, this});
    }
}
