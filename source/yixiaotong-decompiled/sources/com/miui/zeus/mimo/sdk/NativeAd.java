package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.view.View;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.ad.nativead.NativeAdImpl;
import com.miui.zeus.mimo.sdk.ad.nativead.NativeAdImpl.AnonymousClass1;
import com.miui.zeus.mimo.sdk.ad.nativead.NativeAdUIController;
import com.miui.zeus.mimo.sdk.base.BaseAd;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.common.ViewEventHelper;
import com.miui.zeus.mimo.sdk.feedback.DislikeManagerV2;
import com.miui.zeus.mimo.sdk.utils.MimoSdkInitHolder;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;
import com.miui.zeus.mimo.sdk.view.AdImpressMonitor;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class NativeAd extends BaseAd<NativeAdImpl> {

    public interface NativeAdInteractionListener {
        void onAdClick();

        void onAdClosed();

        void onAdShow();

        void onRenderFail(int i, String str);
    }

    public interface NativeAdLoadListener {
        void onAdLoadFailed(int i, String str);

        void onAdLoadSuccess(NativeAdData nativeAdData);
    }

    public interface NativeDownloadListener extends r3 {
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

    public NativeAd() {
        this.mAdImpl = new NativeAdImpl();
    }

    public void destroy() {
        ((NativeAdImpl) this.mAdImpl).b();
    }

    @Deprecated
    public void load(String str, NativeAdLoadListener nativeAdLoadListener) {
        loadAd(new ADParams.Builder().setUpId(str).build(), nativeAdLoadListener);
    }

    public void loadAd(ADParams aDParams, NativeAdLoadListener nativeAdLoadListener) {
        ((NativeAdImpl) this.mAdImpl).a(aDParams, (y1) new f1(nativeAdLoadListener), false);
    }

    public void registerAdView(View view, NativeAdInteractionListener nativeAdInteractionListener) {
        MimoAdError mimoAdError;
        T t = this.mAdImpl;
        if (t != 0) {
            NativeAdImpl nativeAdImpl = (NativeAdImpl) t;
            nativeAdImpl.o = nativeAdInteractionListener;
            if (!MimoSdkInitHolder.isHasInit()) {
                mimoAdError = MimoAdError.ERROR_1001;
            } else {
                if (MimoSdkInitHolder.isInitSuccess()) {
                    nativeAdImpl.r = b.a(view);
                    nativeAdImpl.i();
                    NativeAdUIController nativeAdUIController = nativeAdImpl.n;
                    nativeAdUIController.f5302a = view;
                    if (view == null) {
                        nativeAdUIController.a(MimoAdError.ERROR_9001);
                    } else {
                        nativeAdUIController.f = nativeAdImpl;
                        nativeAdUIController.l = new ViewEventHelper(view.getContext());
                        if (nativeAdUIController.d == null) {
                            m.b(ijiami_1011.s.s.s.d(new byte[]{43, 85, 16, 12, Ascii.ETB, 93, 32, 0, 51, 43, 114, 10, 11, SignedBytes.MAX_POWER_OF_TWO, Ascii.SYN, 10, 13, 84, 4, Ascii.SYN}, "e4dea8"), ijiami_1011.s.s.s.d(new byte[]{67, 4, 3, 80, SignedBytes.MAX_POWER_OF_TWO, 16, 4, Ascii.SYN, 39, 6, 103, 12, 84, Ascii.SYN, 68, 84, 114, 0, 40, 10, 0, 13, 17, 12, 66, 65, 10, 76, 95, 8}, "1ad93d"));
                        } else if (b.b(view) < nativeAdUIController.d.U0) {
                            nativeAdUIController.a(MimoAdError.ERROR_9003);
                        } else {
                            View view2 = nativeAdUIController.f5302a;
                            if (view2 != null) {
                                view2.requestFocus();
                                nativeAdUIController.f5302a.post(new o1(nativeAdUIController));
                                nativeAdUIController.f5302a.setOnClickListener(new p1(nativeAdUIController));
                            }
                            AdImpressMonitor adImpressMonitor = nativeAdUIController.h;
                            if (adImpressMonitor != null) {
                                nativeAdUIController.g.removeCallbacks(adImpressMonitor);
                            }
                            AdImpressMonitor adImpressMonitor2 = nativeAdUIController.h;
                            if (adImpressMonitor2 != null) {
                                adImpressMonitor2.e = new q1(nativeAdUIController);
                                adImpressMonitor2.f = view;
                                nativeAdUIController.g.post(adImpressMonitor2);
                            }
                        }
                    }
                    nativeAdImpl.a(ijiami_1011.s.s.s.d(new byte[]{94, 2, 66, 10, 16, 83, 62, 5, 2}, "0c6cf6"));
                    return;
                }
                mimoAdError = MimoAdError.ERROR_1002;
            }
            nativeAdImpl.b(mimoAdError, null);
        }
    }

    public void setDownLoadListener(NativeDownloadListener nativeDownloadListener) {
        NativeAdImpl nativeAdImpl = (NativeAdImpl) this.mAdImpl;
        nativeAdImpl.e = nativeDownloadListener;
        NativeAdUIController nativeAdUIController = nativeAdImpl.n;
        if (nativeAdUIController != null) {
            nativeAdUIController.e.setDownloadListener(nativeDownloadListener);
        }
    }

    public void showNegativeFeedbackDialog(NegativeFeedbackCallback negativeFeedbackCallback) {
        NativeAdImpl nativeAdImpl = (NativeAdImpl) this.mAdImpl;
        nativeAdImpl.getClass();
        DislikeManagerV2 dislikeManagerV2 = DislikeManagerV2.getInstance();
        Context context = y8.f5752a;
        NativeAdImpl.AnonymousClass1 anonymousClass1 = nativeAdImpl.new AnonymousClass1(negativeFeedbackCallback);
        MimoAdInfo mimoAdInfo = nativeAdImpl.f5377a;
        dislikeManagerV2.showDislikeWindow(context, anonymousClass1, mimoAdInfo.C, ijiami_1011.s.s.s.d(new byte[]{12, 90, 11, 91, Base64.padSymbol, 2, 14, 9, 11, 13, 95, 4, 5, 86, 16, 81, 12, Ascii.NAK, Ascii.DC2, Ascii.ETB, Ascii.DC2, 3, 86, 12, 15, 84}, "a3f4ba"), mimoAdInfo.c);
    }
}
