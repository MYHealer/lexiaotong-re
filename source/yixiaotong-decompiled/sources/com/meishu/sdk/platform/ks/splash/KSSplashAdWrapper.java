package com.meishu.sdk.platform.ks.splash;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.meishu.sdk.R;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.ad.splash.d;
import com.meishu.sdk.core.bquery.i;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.a;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.core.view.gif.GifImageView;
import com.meishu.sdk.meishu_ad.splash.MeishuSplashRootView;
import com.meishu.sdk.meishu_ad.splash.SplashSkipView;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.ks.KSPlatformError;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KSSplashAdWrapper extends BasePlatformLoader<SplashAdLoader, d> {
    private static final String TAG = "KSSplashAdWrapper";
    private KsSplashScreenAd ksSplashScreenAd;
    private boolean showed;
    private KSSplashAd splashAd;

    public KSSplashAdWrapper(SplashAdLoader splashAdLoader, SdkAdInfo sdkAdInfo) {
        super(splashAdLoader, sdkAdInfo);
    }

    private void loadExpressAd() {
        if (getAdLoader().getAdContainer() != null && !(getAdLoader().getAdContainer().getContext() instanceof FragmentActivity)) {
            LogUtil.e(TAG, "onNoAD, Activity is not FragmentActivity");
        } else {
            if (KsAdSDK.getLoadManager() != null) {
                this.splashAd = new KSSplashAd(this);
                KsAdSDK.getLoadManager().loadSplashScreenAd(new KsScene.Builder(Long.parseLong(this.sdkAdInfo.getPid())).build(), new KsLoadManager.SplashScreenAdListener() { // from class: com.meishu.sdk.platform.ks.splash.KSSplashAdWrapper.2
                    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                    public void onError(int i, String str) {
                        LogUtil.e(KSSplashAdWrapper.TAG, "onNoAD, code: " + i + ", msg: " + str);
                        new KSPlatformError(str, Integer.valueOf(i), KSSplashAdWrapper.this.sdkAdInfo).post(KSSplashAdWrapper.this.loadListener);
                    }

                    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                    public void onRequestResult(int i) {
                    }

                    @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
                    public void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd) {
                        KSSplashAdWrapper.this.ksSplashScreenAd = ksSplashScreenAd;
                        if (KSSplashAdWrapper.this.splashAd != null) {
                            KSSplashAdWrapper.this.splashAd.setSplashAD(ksSplashScreenAd);
                            if (KSSplashAdWrapper.this.loadListener != null) {
                                try {
                                    KSSplashAdWrapper.this.sdkAdInfo.setEcpm(String.valueOf(ksSplashScreenAd.getECPM()));
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                ((d) KSSplashAdWrapper.this.loadListener).onAdLoaded(KSSplashAdWrapper.this.splashAd);
                                ((d) KSSplashAdWrapper.this.loadListener).onAdReady(KSSplashAdWrapper.this.splashAd);
                            }
                        }
                    }
                });
                return;
            }
            LogUtil.e(TAG, "onNoAD, LoadManager is null");
        }
        LoaderListener loaderlistener = this.loadListener;
        if (loaderlistener != 0) {
            ((d) loaderlistener).onAdError();
        }
    }

    private void loadNativeAd() {
        try {
            KsAdSDK.getLoadManager().loadNativeAd(new KsScene.Builder(Long.parseLong(getSdkAdInfo().getPid())).adNum(1).build(), new KsLoadManager.NativeAdListener() { // from class: com.meishu.sdk.platform.ks.splash.KSSplashAdWrapper.3
                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public void onError(int i, String str) {
                    LogUtil.e(KSSplashAdWrapper.TAG, str + "" + i);
                    new KSPlatformError(str, Integer.valueOf(i), KSSplashAdWrapper.this.sdkAdInfo).post(KSSplashAdWrapper.this.loadListener);
                }

                @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
                public void onNativeAdLoad(List<KsNativeAd> list) {
                    try {
                        if (list == null) {
                            LogUtil.e(KSSplashAdWrapper.TAG, "onNativeAdLoad ksNativeAdList is null");
                            if (KSSplashAdWrapper.this.getLoaderListener() != null) {
                                new KSPlatformError("onNativeAdLoad ksNativeAdList is null", -1, KSSplashAdWrapper.this.sdkAdInfo).post(KSSplashAdWrapper.this.loadListener);
                                return;
                            }
                            return;
                        }
                        final KsNativeAd ksNativeAd = list.get(0);
                        KSSplashAdWrapper.this.sdkAdInfo.setEcpm(String.valueOf(ksNativeAd.getECPM()));
                        SdkHandler.getInstance().runOnUiThread(new l() { // from class: com.meishu.sdk.platform.ks.splash.KSSplashAdWrapper.3.1
                            @Override // com.meishu.sdk.core.safe.l
                            public void safeRun() {
                                KSNativeSplashAd kSNativeSplashAd = new KSNativeSplashAd(KSSplashAdWrapper.this);
                                if (KSSplashAdWrapper.this.getLoaderListener() != null) {
                                    KSSplashAdWrapper.this.getLoaderListener().onAdLoaded(kSNativeSplashAd);
                                    KSSplashAdWrapper.this.showNativeSplash(ksNativeAd, kSNativeSplashAd);
                                    KSSplashAdWrapper.this.getLoaderListener().onAdReady(kSNativeSplashAd);
                                }
                            }
                        });
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNativeSplash(KsNativeAd ksNativeAd, final KSNativeSplashAd kSNativeSplashAd) {
        MeishuSplashRootView meishuSplashRootView = (MeishuSplashRootView) LayoutInflater.from(this.context).inflate(R.layout.ms_layout_native_splash, (ViewGroup) null);
        LinearLayout linearLayout = (LinearLayout) meishuSplashRootView.findViewById(R.id.ms_layout_native_splash_ll);
        RelativeLayout relativeLayout = (RelativeLayout) meishuSplashRootView.findViewById(R.id.activity_sdk_splash_mediaContainer);
        GifImageView gifImageView = (GifImageView) meishuSplashRootView.findViewById(R.id.layout_native_splash_imageview);
        TextView textView = (TextView) meishuSplashRootView.findViewById(R.id.layout_native_splash_title);
        ImageView imageView = (ImageView) meishuSplashRootView.findViewById(R.id.layout_native_splash_icon);
        ImageView imageView2 = (ImageView) meishuSplashRootView.findViewById(R.id.layout_native_splash_score);
        TextView textView2 = (TextView) meishuSplashRootView.findViewById(R.id.layout_native_splash_desc);
        TextView textView3 = (TextView) meishuSplashRootView.findViewById(R.id.ms_layout_native_splash_cid);
        TextView textView4 = (TextView) meishuSplashRootView.findViewById(R.id.ms_jump_btn);
        Drawable drawable = this.context.getResources().getDrawable(R.drawable.ms_ksad_sdk_logo);
        int i = 0;
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        textView3.setCompoundDrawables(drawable, null, null, null);
        i iVar = new i(meishuSplashRootView);
        if (TextUtils.isEmpty(ksNativeAd.getAdDescription())) {
            textView2.setVisibility(8);
            imageView2.setVisibility(0);
        } else {
            textView2.setVisibility(0);
            textView2.setText(ksNativeAd.getAdDescription());
        }
        if (TextUtils.isEmpty(ksNativeAd.getAppName())) {
            textView.setVisibility(8);
            imageView2.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(ksNativeAd.getAppName());
        }
        if (TextUtils.isEmpty(ksNativeAd.getAppIconUrl())) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            iVar.d = imageView;
            iVar.a(ksNativeAd.getAppIconUrl(), false);
        }
        if (ksNativeAd.getInteractionType() != 1) {
            textView4.setText("点击或摇动了解详情");
        } else {
            textView4.setText("点击下载");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(linearLayout);
        ksNativeAd.registerViewForInteraction(linearLayout, arrayList, new KsNativeAd.AdInteractionListener() { // from class: com.meishu.sdk.platform.ks.splash.KSSplashAdWrapper.4
            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                return false;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdClicked(View view, KsNativeAd ksNativeAd2) {
                LogUtil.d(KSSplashAdWrapper.TAG, "send onAdClicked");
                if (KSSplashAdWrapper.this.getSdkAdInfo() != null && kSNativeSplashAd != null) {
                    a.a(StubApp.getOrigApplicationContext(KSSplashAdWrapper.this.context.getApplicationContext()), f.a(KSSplashAdWrapper.this.getSdkAdInfo().getClk(), kSNativeSplashAd));
                    KSSplashAdWrapper.this.getSdkAdInfo().getMsLoadedTime();
                    KSSplashAdWrapper.this.getAdLoader().getPosId();
                }
                KSNativeSplashAd kSNativeSplashAd2 = kSNativeSplashAd;
                if (kSNativeSplashAd2 == null || kSNativeSplashAd2.getInteractionListener() == null) {
                    return;
                }
                kSNativeSplashAd.getInteractionListener().onAdClicked();
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdShow(KsNativeAd ksNativeAd2) {
                if (KSSplashAdWrapper.this.showed) {
                    return;
                }
                if (KSSplashAdWrapper.this.getLoaderListener() != null) {
                    KSSplashAdWrapper.this.getLoaderListener().onAdExposure();
                }
                KSNativeSplashAd kSNativeSplashAd2 = kSNativeSplashAd;
                if (kSNativeSplashAd2 != null && kSNativeSplashAd2.getInteractionListener() != null) {
                    kSNativeSplashAd.getInteractionListener().onAdExposure();
                }
                KSSplashAdWrapper.this.showed = true;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
            }
        });
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        int i2 = (int) (displayMetrics.widthPixels - (displayMetrics.density * 70.0f));
        if (ksNativeAd.getMaterialType() == 1) {
            View videoView = ksNativeAd.getVideoView(this.context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).build());
            if (videoView != null) {
                relativeLayout.removeAllViews();
                int videoWidth = ksNativeAd.getVideoWidth();
                int videoHeight = ksNativeAd.getVideoHeight();
                if (videoWidth > 0 && videoHeight > 0) {
                    int i3 = (videoHeight * i2) / videoWidth;
                }
                relativeLayout.addView(videoView, -1, -1);
            }
        } else {
            List<KsImage> imageList = ksNativeAd.getImageList();
            if (imageList != null && imageList.size() > 0) {
                KsImage ksImage = imageList.get(0);
                int width = ksImage.getWidth();
                int height = ksImage.getHeight();
                String imageUrl = imageList.get(0).getImageUrl();
                iVar.d = gifImageView;
                iVar.a(imageUrl, false);
                if (width > 0 && height > 0) {
                    i = (height * i2) / width;
                }
                ViewGroup.LayoutParams layoutParams = gifImageView.getLayoutParams();
                layoutParams.height = i;
                layoutParams.width = -1;
                gifImageView.setLayoutParams(layoutParams);
            }
        }
        kSNativeSplashAd.setAdView(meishuSplashRootView);
        showSkipView(meishuSplashRootView, kSNativeSplashAd);
    }

    private void showSkipView(MeishuSplashRootView meishuSplashRootView, final KSNativeSplashAd kSNativeSplashAd) {
        SplashSkipView splashSkipView = (SplashSkipView) meishuSplashRootView.findViewById(R.id.ms_skipView);
        kSNativeSplashAd.setSkipView(splashSkipView);
        splashSkipView.setOnSkipListener(new SplashSkipView.b() { // from class: com.meishu.sdk.platform.ks.splash.KSSplashAdWrapper.5
            @Override // com.meishu.sdk.meishu_ad.splash.SplashSkipView.b
            public void onSkip() {
                LogUtil.d(KSSplashAdWrapper.TAG, "onSkip: ");
                if (KSSplashAdWrapper.this.loadListener != null) {
                    ((d) KSSplashAdWrapper.this.loadListener).onAdSkip(kSNativeSplashAd);
                    ((d) KSSplashAdWrapper.this.loadListener).onAdClosed();
                }
                KSNativeSplashAd kSNativeSplashAd2 = kSNativeSplashAd;
                if (kSNativeSplashAd2 == null || kSNativeSplashAd2.getInteractionListener() == null) {
                    return;
                }
                kSNativeSplashAd.getInteractionListener().onAdClosed();
            }

            @Override // com.meishu.sdk.meishu_ad.splash.SplashSkipView.b
            public void onTick(long j) {
                if (KSSplashAdWrapper.this.loadListener != null) {
                    ((d) KSSplashAdWrapper.this.loadListener).onAdTick(j);
                }
            }

            @Override // com.meishu.sdk.meishu_ad.splash.SplashSkipView.b
            public void onTimeOver() {
                LogUtil.d(KSSplashAdWrapper.TAG, "onTimeOver: ");
                if (KSSplashAdWrapper.this.loadListener != null) {
                    ((d) KSSplashAdWrapper.this.loadListener).onAdTimeOver(kSNativeSplashAd);
                    ((d) KSSplashAdWrapper.this.loadListener).onAdClosed();
                }
                if (kSNativeSplashAd.getInteractionListener() != null) {
                    kSNativeSplashAd.getInteractionListener().onAdClosed();
                }
            }
        });
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        try {
            z.a(((SplashAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new com.meishu.sdk.core.utils.i());
            SdkHandler.getInstance().runOnUiThread(new l() { // from class: com.meishu.sdk.platform.ks.splash.KSSplashAdWrapper.1
                @Override // com.meishu.sdk.core.safe.l
                public void safeRun() {
                    Object obj = KSSplashAdWrapper.this.getLocalParams().get(SplashAdLoader.KEY_SKIP_BUTTON);
                    if (obj == null || !(obj instanceof View)) {
                        return;
                    }
                    ((View) obj).setVisibility(4);
                }
            });
            ((Boolean) this.localParams.get(SplashAdLoader.KEY_AUTO_SHOW)).booleanValue();
            if (this.sdkAdInfo.getAd_type() != AdType.FEED.value()) {
                loadExpressAd();
            } else {
                try {
                    loadNativeAd();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            KsSplashScreenAd ksSplashScreenAd = this.ksSplashScreenAd;
            if (ksSplashScreenAd != null) {
                if (z) {
                    ksSplashScreenAd.setBidEcpm(ksSplashScreenAd.getECPM(), t0.a(this.ksSplashScreenAd.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()));
                } else {
                    AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                    adExposureFailedReason.setAdnType(3);
                    adExposureFailedReason.setWinEcpm(i);
                    this.ksSplashScreenAd.reportAdExposureFailed(2, adExposureFailedReason);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
