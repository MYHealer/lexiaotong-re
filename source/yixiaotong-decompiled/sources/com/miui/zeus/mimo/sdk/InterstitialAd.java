package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.ad.interstitial.InterstitialAdImpl;
import com.miui.zeus.mimo.sdk.ad.interstitial.InterstitialUIController;
import com.miui.zeus.mimo.sdk.base.BaseAd;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class InterstitialAd extends BaseAd<InterstitialAdImpl> {

    public interface InterstitialAdInteractionListener {
        void onAdClick();

        void onAdClosed();

        void onAdShow();

        void onRenderFail(int i, String str);

        void onVideoEnd();

        void onVideoPause();

        void onVideoResume();

        void onVideoStart();
    }

    public interface InterstitialAdLoadListener {
        void onAdLoadFailed(int i, String str);

        void onAdLoadSuccess();

        void onAdRequestSuccess();
    }

    public interface InterstitialDownloadListener extends r3 {
        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onDownloadCancel();

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onDownloadFailed(int i);

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onDownloadFinished();

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onDownloadPaused();

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onDownloadProgressUpdated(int i);

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onDownloadStarted();

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onInstallFailed(int i);

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onInstallStart();

        @Override // com.miui.zeus.mimo.sdk.r3
        /* synthetic */ void onInstallSuccess();
    }

    public InterstitialAd() {
        this.mAdImpl = new InterstitialAdImpl();
    }

    public void destroy() {
        ((InterstitialAdImpl) this.mAdImpl).b();
    }

    public void loadAd(ADParams aDParams, InterstitialAdLoadListener interstitialAdLoadListener) {
        InterstitialAdImpl interstitialAdImpl = (InterstitialAdImpl) this.mAdImpl;
        interstitialAdImpl.getClass();
        if (aDParams != null) {
            m.a(InterstitialAdImpl.q, ijiami_1011.s.s.s.d(new byte[]{SignedBytes.MAX_POWER_OF_TWO, Ascii.DC2, 83, 68, 16, Ascii.ETB, 13, 11, 7, 6, 17, 12, 93, Ascii.DC2, 87, 68, Ascii.ETB, 67, 8, 16, 15, 3, 93, 36, 87, 74, Ascii.DC2, 67, Ascii.DC4, 126, 5, 68, 91, 66}, "3f26d7") + aDParams.getUpId());
            interstitialAdImpl.m = interstitialAdLoadListener;
            interstitialAdImpl.a(aDParams, 1);
            return;
        }
        MimoAdError mimoAdError = MimoAdError.ERROR_2011;
        int i = mimoAdError.ERROR_CODE;
        String str = mimoAdError.ERROR_MSG;
        m.b(InterstitialAdImpl.q, ijiami_1011.s.s.s.d(new byte[]{91, 86, 68, 8, 2, 74, 45, 11, 7, 6, 119, 4, 92, 85, 85, 5, 72, 19, 4, Ascii.SYN, Ascii.DC4, 13, 67, 38, 90, 93, 85, 92}, "590ad3") + i + ijiami_1011.s.s.s.d(new byte[]{74, Ascii.SYN, 87, 66, 70, 93, 19, 41, Ascii.NAK, 5, 12}, "f62042") + str);
        InterstitialAdLoadListener interstitialAdLoadListener2 = interstitialAdImpl.m;
        if (interstitialAdLoadListener2 != null) {
            interstitialAdLoadListener2.onAdLoadFailed(i, str);
        }
    }

    @Deprecated
    public void loadAd(String str, InterstitialAdLoadListener interstitialAdLoadListener) {
        loadAd(new ADParams.Builder().setUpId(str).build(), interstitialAdLoadListener);
    }

    public void setDownloadListener(InterstitialDownloadListener interstitialDownloadListener) {
        InterstitialAdImpl interstitialAdImpl = (InterstitialAdImpl) this.mAdImpl;
        interstitialAdImpl.e = interstitialDownloadListener;
        InterstitialUIController interstitialUIController = interstitialAdImpl.n;
        if (interstitialUIController != null) {
            interstitialUIController.h = interstitialDownloadListener;
            e0 e0Var = interstitialUIController.j;
            if (e0Var != null) {
                e0Var.setDownloadListener(interstitialDownloadListener);
            }
        }
    }

    @Deprecated
    public void show(Activity activity, InterstitialAdInteractionListener interstitialAdInteractionListener) {
        ((InterstitialAdImpl) this.mAdImpl).a(activity, interstitialAdInteractionListener);
    }

    public void showAd(Activity activity, InterstitialAdInteractionListener interstitialAdInteractionListener) {
        ((InterstitialAdImpl) this.mAdImpl).a(activity, interstitialAdInteractionListener);
    }
}
