package com.miui.zeus.mimo.sdk.ad.interstitial;

import android.app.Activity;
import android.content.Context;
import com.miui.zeus.mimo.sdk.base.BaseAdView;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.d0;
import com.miui.zeus.mimo.sdk.e0;
import com.miui.zeus.mimo.sdk.h0;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class InterstitialAdView extends BaseAdView implements e0 {
    private boolean isMsaRenderFail;
    private Activity mActivity;
    private h0 mInterstitialViewCreateListener;
    private d0 mListener;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f5297a;

        public a(Throwable th) {
            this.f5297a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{48, this});
        }
    }

    public InterstitialAdView(Context context) {
        super(context);
        this.isMsaRenderFail = false;
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdView, com.miui.zeus.mimo.sdk.c0
    public void destroy() {
        NCall.IV(new Object[]{50, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onClickCloseView() {
        NCall.IV(new Object[]{51, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onClicked() {
        NCall.IV(new Object[]{52, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onVideoComplete() {
        NCall.IV(new Object[]{53, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onVideoPause() {
        NCall.IV(new Object[]{54, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onVideoResume() {
        NCall.IV(new Object[]{55, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onVideoStart() {
        NCall.IV(new Object[]{56, this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdView, com.miui.zeus.mimo.sdk.common.CommonEventImpl
    public void onViewCreateFailed(Throwable th) {
        NCall.IV(new Object[]{57, this, th});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl
    public void onViewCreateSuccess() {
        NCall.IV(new Object[]{58, this});
    }

    @Override // com.miui.zeus.mimo.sdk.e0
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo) {
        NCall.IV(new Object[]{59, this, activity, mimoAdInfo});
    }

    @Override // com.miui.zeus.mimo.sdk.e0
    public void setInterstitialViewCreateListener(h0 h0Var) {
        NCall.IV(new Object[]{60, this, h0Var});
    }

    @Override // com.miui.zeus.mimo.sdk.e0
    public void setOnInteractionEventListener(d0 d0Var) {
        NCall.IV(new Object[]{61, this, d0Var});
    }
}
