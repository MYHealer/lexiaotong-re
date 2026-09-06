package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.view.View;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.ad.nativead.NativeAdImpl;
import com.miui.zeus.mimo.sdk.ad.nativead.NativeAdImpl.AnonymousClass1;
import com.miui.zeus.mimo.sdk.ad.nativead.NativeAdUIController;
import com.miui.zeus.mimo.sdk.ad.nativead.NativeAdViewBinder;
import com.miui.zeus.mimo.sdk.ad.nativead.view.NativeAdView;
import com.miui.zeus.mimo.sdk.base.BaseAd;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.feedback.DislikeManagerV2;
import com.xiaomi.mediationannotation.HideMethod;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class NativeCustomAd extends BaseAd<NativeAdImpl> {
    public static final int NAVIGATION_SCROLL = 2;
    public static final int NAVIGATION_SHAKE = 1;

    public interface NativeCustomAdInteractionListener extends NativeAd.NativeAdInteractionListener {
    }

    public interface NativeCustomAdLoadListener extends NativeAd.NativeAdLoadListener {
    }

    public interface NativeCustomDownloadListener extends NativeAd.NativeDownloadListener {
    }

    public interface NativeCustomMultiAdsInteractionListener {
        void onAdClick(NativeAdData nativeAdData);

        void onAdClosed(NativeAdData nativeAdData);

        void onAdShow(NativeAdData nativeAdData);

        void onRenderFail(NativeAdData nativeAdData, int i, String str);
    }

    public interface NativeCustomMultiAdsLoadListener {
        void onAdLoadFailed(int i, String str);

        void onAdLoadSuccess(List<NativeAdData> list);
    }

    public NativeCustomAd() {
        this.mAdImpl = new NativeAdImpl();
    }

    public void destroy() {
        ((NativeAdImpl) this.mAdImpl).b();
    }

    @HideMethod(false)
    public void directNavigation(int i, Map<String, String> map) {
        View view;
        ClickAreaType clickAreaType;
        NativeAdUIController nativeAdUIController = ((NativeAdImpl) this.mAdImpl).n;
        if (nativeAdUIController != null) {
            nativeAdUIController.y = map;
            View view2 = nativeAdUIController.f5302a;
            if (view2 != null && view2.getVisibility() == 0 && nativeAdUIController.a(i)) {
                if (i == 1) {
                    view = nativeAdUIController.f5302a;
                    clickAreaType = ClickAreaType.TYPE_NATIVE_SHAKE;
                } else {
                    if (i != 2) {
                        return;
                    }
                    view = nativeAdUIController.f5302a;
                    clickAreaType = ClickAreaType.TYPE_NATIVE_SCROLL;
                }
                nativeAdUIController.a(view, clickAreaType);
            }
        }
    }

    @HideMethod(false)
    public boolean isDirectNavigationAllowed(int i) {
        NativeAdUIController nativeAdUIController = ((NativeAdImpl) this.mAdImpl).n;
        if (nativeAdUIController != null) {
            return nativeAdUIController.a(i);
        }
        return false;
    }

    @Deprecated
    public void load(String str, NativeAd.NativeAdLoadListener nativeAdLoadListener) {
        ADParams aDParamsBuild = new ADParams.Builder().setUpId(str).build();
        ((NativeAdImpl) this.mAdImpl).b();
        ((NativeAdImpl) this.mAdImpl).a(aDParamsBuild, (y1) new f1(nativeAdLoadListener), true);
    }

    public void loadAd(ADParams aDParams, NativeAd.NativeAdLoadListener nativeAdLoadListener) {
        ((NativeAdImpl) this.mAdImpl).b();
        ((NativeAdImpl) this.mAdImpl).a(aDParams, (y1) new f1(nativeAdLoadListener), true);
    }

    public void registerAdView(NativeAdView nativeAdView, NativeAdViewBinder nativeAdViewBinder, NativeCustomAdInteractionListener nativeCustomAdInteractionListener) {
        T t = this.mAdImpl;
        if (t != 0) {
            ((NativeAdImpl) t).a(nativeAdView, nativeAdViewBinder, nativeCustomAdInteractionListener);
        }
    }

    public void setDownLoadListener(NativeAd.NativeDownloadListener nativeDownloadListener) {
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
        dislikeManagerV2.showDislikeWindow(context, anonymousClass1, mimoAdInfo.C, ijiami_1011.s.s.s.d(new byte[]{9, 80, 84, 87, 107, 80, 14, 9, 11, 13, 95, 4, 0, 92, 79, 93, 90, 71, Ascii.DC2, Ascii.ETB, Ascii.DC2, 3, 86, 12, 10, 94}, "d99843"), mimoAdInfo.c);
    }

    public void loadAd(ADParams aDParams, NativeCustomMultiAdsLoadListener nativeCustomMultiAdsLoadListener) {
        ((NativeAdImpl) this.mAdImpl).b();
        ((NativeAdImpl) this.mAdImpl).a(aDParams, (y1) new g1(nativeCustomMultiAdsLoadListener), true);
    }
}
