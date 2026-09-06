package com.meishu.sdk.platform.csj.splash;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CSJAdError;
import com.bytedance.sdk.openadsdk.CSJSplashAd;
import com.bytedance.sdk.openadsdk.ComplianceInfo;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationAdEcpmInfo;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationNativeManager;
import com.bytedance.sdk.openadsdk.mediation.manager.MediationSplashManager;
import com.meishu.sdk.R;
import com.meishu.sdk.activity.MeishuDownloadDetailActivity;
import com.meishu.sdk.activity.MeishuWebviewActivity;
import com.meishu.sdk.activity.a;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.ad.splash.d;
import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.safe.o;
import com.meishu.sdk.core.utils.DownloadDialogBean;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.e0;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i;
import com.meishu.sdk.core.utils.i0;
import com.meishu.sdk.core.utils.m;
import com.meishu.sdk.core.utils.x;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.core.view.gif.GifImageView;
import com.meishu.sdk.meishu_ad.splash.MeishuSplashRootView;
import com.meishu.sdk.meishu_ad.splash.SplashSkipView;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.csj.CSJAdConfig;
import com.meishu.sdk.platform.csj.CSJPlatformError;
import com.meishu.sdk.platform.gdt.GDTPlatformError;
import com.qq.e.comm.util.AdError;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJTTAdNativeWrapper extends BasePlatformLoader<SplashAdLoader, d> {
    private static final String TAG = "CSJTTAdNativeWrapper";
    private MeishuAdInfo meishuAdInfo;
    private boolean showed;
    private TTAdNative ttAdNative;

    public CSJTTAdNativeWrapper(SplashAdLoader splashAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        super(splashAdLoader, sdkAdInfo);
        this.meishuAdInfo = meishuAdInfo;
    }

    private byte[] getImageBytes(Context context, int i) {
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            while (true) {
                int i2 = inputStreamOpenRawResource.read(bArr);
                if (-1 == i2) {
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void handleDownloadView(final MeishuSplashRootView meishuSplashRootView, TTFeedAd tTFeedAd) {
        final ComplianceInfo complianceInfo;
        try {
            if (tTFeedAd.getInteractionType() != 4 || (complianceInfo = tTFeedAd.getComplianceInfo()) == null) {
                return;
            }
            ((RelativeLayout) meishuSplashRootView.findViewById(R.id.ms_download_layer_root_view)).setVisibility(0);
            TextView textView = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_name);
            TextView textView2 = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_version);
            TextView textView3 = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_owner);
            TextView textView4 = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_privacy);
            TextView textView5 = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_permission);
            TextView textView6 = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_introduce);
            textView.setText(complianceInfo.getAppName());
            textView2.setText(complianceInfo.getAppVersion());
            textView3.setText(complianceInfo.getDeveloperName());
            textView4.setOnClickListener(new o() { // from class: com.meishu.sdk.platform.csj.splash.CSJTTAdNativeWrapper.5
                @Override // com.meishu.sdk.core.safe.o
                public void safeOnClick(View view) {
                    try {
                        String privacyUrl = complianceInfo.getPrivacyUrl();
                        Intent intent = new Intent(meishuSplashRootView.getContext(), (Class<?>) MeishuWebviewActivity.class);
                        intent.putExtra(MeishuWebviewActivity.EXTRA_AD_DURL_KEY, new String[]{privacyUrl});
                        meishuSplashRootView.getContext().startActivity(intent);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            textView5.setOnClickListener(new o() { // from class: com.meishu.sdk.platform.csj.splash.CSJTTAdNativeWrapper.6
                @Override // com.meishu.sdk.core.safe.o
                public void safeOnClick(View view) {
                    try {
                        DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                        downloadDialogBean.setApp_name(complianceInfo.getAppName());
                        downloadDialogBean.setApp_privacy(complianceInfo.getPrivacyUrl());
                        downloadDialogBean.setDeveloper(complianceInfo.getDeveloperName());
                        downloadDialogBean.setApp_permission_url(complianceInfo.getPermissionUrl());
                        MeishuDownloadDetailActivity.startActivity(meishuSplashRootView.getContext(), downloadDialogBean);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            textView6.setOnClickListener(new o() { // from class: com.meishu.sdk.platform.csj.splash.CSJTTAdNativeWrapper.7
                @Override // com.meishu.sdk.core.safe.o
                public void safeOnClick(View view) {
                    try {
                        DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                        downloadDialogBean.setApp_name(complianceInfo.getAppName());
                        downloadDialogBean.setApp_privacy(complianceInfo.getPrivacyUrl());
                        downloadDialogBean.setDeveloper(complianceInfo.getDeveloperName());
                        downloadDialogBean.setApp_permission_url(complianceInfo.getPermissionUrl());
                        MeishuDownloadDetailActivity.startActivity(meishuSplashRootView.getContext(), downloadDialogBean);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void loadNativeAd() {
        CSJAdConfig.getTtAdManager().createAdNative(StubApp.getOrigApplicationContext(((SplashAdLoader) this.adLoader).getContext().getApplicationContext())).loadFeedAd(new AdSlot.Builder().setCodeId(getSdkAdInfo().getPid()).setSupportDeepLink(true).setIsAutoPlay(true).setAdCount(1).build(), new TTAdNative.FeedAdListener() { // from class: com.meishu.sdk.platform.csj.splash.CSJTTAdNativeWrapper.2
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener, com.bytedance.sdk.openadsdk.TTAdNative.NativeExpressAdListener
            public void onError(int i, String str) {
                try {
                    new CSJPlatformError(str, Integer.valueOf(i), CSJTTAdNativeWrapper.this.getSdkAdInfo()).post(CSJTTAdNativeWrapper.this.getLoaderListener());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.FeedAdListener
            public void onFeedAdLoad(List<TTFeedAd> list) {
                if (list != null) {
                    try {
                        if (list.size() > 0) {
                            TTFeedAd tTFeedAd = list.get(0);
                            CSJNativeSplashAd cSJNativeSplashAd = new CSJNativeSplashAd(CSJTTAdNativeWrapper.this);
                            CSJTTAdNativeWrapper.this.showNativeAd(tTFeedAd, cSJNativeSplashAd);
                            if (CSJTTAdNativeWrapper.this.loadListener != null) {
                                ((d) CSJTTAdNativeWrapper.this.loadListener).onAdLoaded(cSJNativeSplashAd);
                                ((d) CSJTTAdNativeWrapper.this.loadListener).onAdReady(cSJNativeSplashAd);
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        });
    }

    private void loadNewAd(AdSlot adSlot) {
        this.ttAdNative.loadSplashAd(adSlot, new TTAdNative.CSJSplashAdListener() { // from class: com.meishu.sdk.platform.csj.splash.CSJTTAdNativeWrapper.8
            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadFail(CSJAdError cSJAdError) {
                try {
                    new CSJPlatformError(cSJAdError.getMsg(), Integer.valueOf(cSJAdError.getCode()), CSJTTAdNativeWrapper.this.getSdkAdInfo()).post(CSJTTAdNativeWrapper.this.getLoaderListener());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            public void onSplashLoadSuccess() {
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashLoadSuccess(CSJSplashAd cSJSplashAd) {
                LogUtil.d(CSJTTAdNativeWrapper.TAG, a.a("load csj succ,thread=").append(Thread.currentThread().getName()).toString());
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderFail(CSJSplashAd cSJSplashAd, CSJAdError cSJAdError) {
                try {
                    new CSJPlatformError(cSJAdError.getMsg(), Integer.valueOf(cSJAdError.getCode()), CSJTTAdNativeWrapper.this.getSdkAdInfo()).post(CSJTTAdNativeWrapper.this.getLoaderListener());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAdNative.CSJSplashAdListener
            public void onSplashRenderSuccess(CSJSplashAd cSJSplashAd) {
                try {
                    final CsjNewSplashAd csjNewSplashAd = new CsjNewSplashAd(CSJTTAdNativeWrapper.this, cSJSplashAd);
                    csjNewSplashAd.setAdContainer(CSJTTAdNativeWrapper.this.getAdContainer());
                    csjNewSplashAd.setAdView(cSJSplashAd.getSplashView());
                    cSJSplashAd.setSplashAdListener(new CSJSplashAd.SplashAdListener() { // from class: com.meishu.sdk.platform.csj.splash.CSJTTAdNativeWrapper.8.1
                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdClick(CSJSplashAd cSJSplashAd2) {
                            try {
                                if (CSJTTAdNativeWrapper.this.getSdkAdInfo() != null && !TextUtils.isEmpty(CSJTTAdNativeWrapper.this.getSdkAdInfo().getClk())) {
                                    LogUtil.d(CSJTTAdNativeWrapper.TAG, "send onAdClicked");
                                    z.a(CSJTTAdNativeWrapper.this.getContext(), f.a(CSJTTAdNativeWrapper.this.getSdkAdInfo().getClk(), csjNewSplashAd), new i());
                                    CSJTTAdNativeWrapper.this.getSdkAdInfo().getMsLoadedTime();
                                    CSJTTAdNativeWrapper.this.getAdLoader().getPosId();
                                }
                                if (csjNewSplashAd.getInteractionListener() != null) {
                                    csjNewSplashAd.getInteractionListener().onAdClicked();
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdClose(CSJSplashAd cSJSplashAd2, int i) {
                            try {
                                if (CSJTTAdNativeWrapper.this.getLoaderListener() != null) {
                                    CSJTTAdNativeWrapper.this.getLoaderListener().onAdClosed();
                                }
                                if (csjNewSplashAd.getInteractionListener() != null) {
                                    csjNewSplashAd.getInteractionListener().onAdClosed();
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.CSJSplashAd.SplashAdListener
                        public void onSplashAdShow(CSJSplashAd cSJSplashAd2) {
                            MediationAdEcpmInfo showEcpm;
                            try {
                                MediationSplashManager mediationManager = cSJSplashAd2.getMediationManager();
                                if (mediationManager != null && (showEcpm = mediationManager.getShowEcpm()) != null) {
                                    CSJTTAdNativeWrapper.this.getSdkAdInfo().setGmShowEcpm(showEcpm.getEcpm());
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                            try {
                                h0.a(CSJTTAdNativeWrapper.this.getSdkAdInfo(), cSJSplashAd2.getSplashView());
                                if (CSJTTAdNativeWrapper.this.getLoaderListener() != null) {
                                    CSJTTAdNativeWrapper.this.getLoaderListener().onAdPresent(csjNewSplashAd);
                                }
                                if (CSJTTAdNativeWrapper.this.getLoaderListener() != null) {
                                    CSJTTAdNativeWrapper.this.getLoaderListener().onAdExposure();
                                }
                                if (csjNewSplashAd.getInteractionListener() != null) {
                                    csjNewSplashAd.getInteractionListener().onAdExposure();
                                }
                            } catch (Throwable th2) {
                                th2.printStackTrace();
                            }
                        }
                    });
                    CSJTTAdNativeWrapper.this.getLoaderListener().onAdLoaded(csjNewSplashAd);
                    CSJTTAdNativeWrapper.this.getLoaderListener().onAdReady(csjNewSplashAd);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }, 3000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v14 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [boolean, int] */
    public void showNativeAd(final TTFeedAd tTFeedAd, final CSJNativeSplashAd cSJNativeSplashAd) {
        List<TTImage> imageList;
        String str;
        int i;
        int i2;
        boolean z;
        ?? r12;
        MeishuSplashRootView meishuSplashRootView = (MeishuSplashRootView) View.inflate(this.context, R.layout.ms_layout_native_splash, null);
        cSJNativeSplashAd.setAdView(meishuSplashRootView);
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        final ImageView imageView = (ImageView) meishuSplashRootView.findViewById(R.id.ms_layout_native_splash_bg);
        RelativeLayout relativeLayout = (RelativeLayout) meishuSplashRootView.findViewById(R.id.ms_native_splash_ad_container);
        try {
            handleDownloadView(meishuSplashRootView, tTFeedAd);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        View viewInflate = View.inflate(this.context, R.layout.ms_layout_native_splash_1, null);
        if ((tTFeedAd.getImageMode() == 3 || tTFeedAd.getImageMode() == 2 || tTFeedAd.getImageMode() == 4 || tTFeedAd.getImageMode() == 16) && (imageList = tTFeedAd.getImageList()) != null && imageList.size() > 0) {
            TTImage tTImage = imageList.get(0);
            String imageUrl = tTImage.getImageUrl();
            int width = tTImage.getWidth();
            int height = tTImage.getHeight();
            if ((tTImage.getWidth() * 1.0f) / tTImage.getHeight() < 0.67d) {
                viewInflate = View.inflate(this.context, R.layout.ms_layout_native_splash_2, null);
                str = imageUrl;
                i = width;
                i2 = height;
                z = true;
            } else {
                str = imageUrl;
                i = width;
                i2 = height;
                z = false;
            }
        } else {
            i = 0;
            i2 = 0;
            str = "";
            z = false;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate.findViewById(R.id.activity_sdk_splash_mediaContainer);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ms_layout_native_splash_ll);
        final GifImageView gifImageView = (GifImageView) viewInflate.findViewById(R.id.layout_native_splash_imageview);
        TextView textView = (TextView) viewInflate.findViewById(R.id.layout_native_splash_title);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_icon);
        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_score);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.layout_native_splash_desc);
        String str2 = str;
        ImageView imageView4 = (ImageView) meishuSplashRootView.findViewById(R.id.ms_layout_native_splash_logo);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.ms_jump_btn);
        View view = viewInflate;
        ArrayList arrayList = new ArrayList();
        if ((this.sdkAdInfo.getAct_type() & 1) == 1) {
            arrayList.add(linearLayout);
        } else {
            arrayList.add(textView3);
        }
        tTFeedAd.registerViewForInteraction(linearLayout, arrayList, arrayList, new TTNativeAd.AdInteractionListener() { // from class: com.meishu.sdk.platform.csj.splash.CSJTTAdNativeWrapper.3
            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdClicked(View view2, TTNativeAd tTNativeAd) {
                try {
                    if (CSJTTAdNativeWrapper.this.getSdkAdInfo() != null && cSJNativeSplashAd != null) {
                        LogUtil.d(CSJTTAdNativeWrapper.TAG, "send onADClicked");
                        z.a(StubApp.getOrigApplicationContext(CSJTTAdNativeWrapper.this.context.getApplicationContext()), f.a(CSJTTAdNativeWrapper.this.getSdkAdInfo().getClk(), cSJNativeSplashAd), new i());
                        CSJTTAdNativeWrapper.this.getSdkAdInfo().getMsLoadedTime();
                        CSJTTAdNativeWrapper.this.getAdLoader().getPosId();
                    }
                    CSJNativeSplashAd cSJNativeSplashAd2 = cSJNativeSplashAd;
                    if (cSJNativeSplashAd2 == null || cSJNativeSplashAd2.getInteractionListener() == null) {
                        return;
                    }
                    cSJNativeSplashAd.getInteractionListener().onAdClicked();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdCreativeClick(View view2, TTNativeAd tTNativeAd) {
                onAdClicked(view2, tTNativeAd);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeAd.AdInteractionListener
            public void onAdShow(TTNativeAd tTNativeAd) {
                MediationAdEcpmInfo showEcpm;
                try {
                    MediationNativeManager mediationManager = tTFeedAd.getMediationManager();
                    if (mediationManager != null && (showEcpm = mediationManager.getShowEcpm()) != null) {
                        CSJTTAdNativeWrapper.this.getSdkAdInfo().setGmShowEcpm(showEcpm.getEcpm());
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                try {
                    if (CSJTTAdNativeWrapper.this.getLoaderListener() == null || CSJTTAdNativeWrapper.this.showed) {
                        return;
                    }
                    CSJTTAdNativeWrapper.this.showed = true;
                    CSJTTAdNativeWrapper.this.getLoaderListener().onAdExposure();
                    CSJNativeSplashAd cSJNativeSplashAd2 = cSJNativeSplashAd;
                    if (cSJNativeSplashAd2 == null || cSJNativeSplashAd2.getInteractionListener() == null) {
                        return;
                    }
                    cSJNativeSplashAd.getInteractionListener().onAdExposure();
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
        });
        if (h.c(this.sdkAdInfo.getAct_type())) {
            Drawable drawable = this.context.getResources().getDrawable(R.drawable.ms_shake_angle);
            int i3 = (int) (displayMetrics.density * 30.0f);
            r12 = 0;
            drawable.setBounds(0, 0, i3, i3);
            textView3.setPadding(60, 0, 60, 0);
            textView3.setCompoundDrawables(drawable, null, null, null);
        } else {
            r12 = 0;
        }
        com.meishu.sdk.core.bquery.i iVar = new com.meishu.sdk.core.bquery.i(meishuSplashRootView);
        if (TextUtils.isEmpty(tTFeedAd.getDescription())) {
            textView2.setVisibility(8);
            imageView3.setVisibility(r12);
        } else {
            textView2.setVisibility(r12);
            textView2.setText(tTFeedAd.getDescription());
        }
        if (TextUtils.isEmpty(tTFeedAd.getTitle())) {
            textView.setVisibility(8);
            imageView3.setVisibility(8);
        } else {
            textView.setVisibility(r12);
            textView.setText(tTFeedAd.getTitle());
        }
        if (TextUtils.isEmpty(tTFeedAd.getIcon().getImageUrl())) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(r12);
            iVar.d = imageView2;
            iVar.a(tTFeedAd.getIcon().getImageUrl(), r12);
        }
        if (tTFeedAd.getImageMode() == 3 || tTFeedAd.getImageMode() == 2 || tTFeedAd.getImageMode() == 4 || tTFeedAd.getImageMode() == 16) {
            if (z) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                double d = ((double) displayMetrics.widthPixels) * 0.86d;
                layoutParams.width = (int) d;
                layoutParams.height = (int) ((d * ((double) i2)) / ((double) i));
                int i4 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                layoutParams.topMargin = i4;
                layoutParams.bottomMargin = i4;
                linearLayout.setLayoutParams(layoutParams);
                textView.setVisibility(8);
                textView2.setVisibility(8);
                imageView3.setVisibility(8);
                imageView2.setVisibility(8);
            } else {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams2.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                layoutParams2.height = -2;
                int i5 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                layoutParams2.topMargin = i5;
                layoutParams2.bottomMargin = i5;
                linearLayout.setLayoutParams(layoutParams2);
            }
            com.meishu.sdk.core.cache.a.a(str2, new x() { // from class: com.meishu.sdk.platform.csj.splash.CSJTTAdNativeWrapper.4
                @Override // com.meishu.sdk.core.utils.x
                public void onFailure(IOException iOException) {
                    try {
                        new GDTPlatformError(new AdError(-1, "图片加载失败"), CSJTTAdNativeWrapper.this.sdkAdInfo).post(CSJTTAdNativeWrapper.this.loadListener);
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }

                @Override // com.meishu.sdk.core.utils.x
                public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
                    byte[] responseBody;
                    try {
                        if (!httpResponse.isSuccessful() || (responseBody = httpResponse.getResponseBody()) == null || responseBody.length <= 0) {
                            return;
                        }
                        if (responseBody.length >= i0.a()) {
                            new GDTPlatformError(new AdError(-1, "图片加载失败"), CSJTTAdNativeWrapper.this.sdkAdInfo).post(CSJTTAdNativeWrapper.this.loadListener);
                            return;
                        }
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                        if (bitmapDecodeByteArray != null) {
                            gifImageView.setImageBitmap(bitmapDecodeByteArray);
                        }
                        Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                        if (bitmapDecodeByteArray2 != null) {
                            CSJTTAdNativeWrapper.this.context.getApplicationContext();
                            imageView.setImageBitmap(e0.a(bitmapDecodeByteArray2, 20));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }, true);
        } else {
            if (tTFeedAd.getImageMode() == 15 || tTFeedAd.getImageMode() == 5) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams3.width = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                layoutParams3.height = -2;
                int i6 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                layoutParams3.topMargin = i6;
                layoutParams3.bottomMargin = i6;
                linearLayout.setLayoutParams(layoutParams3);
                relativeLayout2.removeAllViews();
                relativeLayout2.addView(tTFeedAd.getAdView());
            }
            meishuSplashRootView = meishuSplashRootView;
        }
        if (tTFeedAd.getAdLogo() != null) {
            imageView4.setVisibility(0);
            iVar.d = imageView4;
            Bitmap adLogo = tTFeedAd.getAdLogo();
            View view2 = iVar.d;
            if (view2 instanceof ImageView) {
                ((ImageView) view2).setImageBitmap(adLogo);
            }
        } else {
            imageView4.setVisibility(8);
        }
        ViewGroup.LayoutParams layoutParams4 = textView3.getLayoutParams();
        layoutParams4.width = (int) (((double) displayMetrics.widthPixels) * 0.86d * 0.77d);
        textView3.setLayoutParams(layoutParams4);
        if (tTFeedAd.getInteractionType() == 4) {
            textView3.setText("点击/摇一摇下载第三方应用");
        } else {
            textView3.setText("点击或摇一摇跳转详情页");
        }
        relativeLayout.addView(view, -1, -1);
        showSkipView(meishuSplashRootView, cSJNativeSplashAd);
    }

    private void showSkipView(MeishuSplashRootView meishuSplashRootView, final CSJNativeSplashAd cSJNativeSplashAd) {
        try {
            SplashSkipView splashSkipView = (SplashSkipView) meishuSplashRootView.findViewById(R.id.ms_skipView);
            cSJNativeSplashAd.setSkipView(splashSkipView);
            splashSkipView.setOnSkipListener(new SplashSkipView.b() { // from class: com.meishu.sdk.platform.csj.splash.CSJTTAdNativeWrapper.9
                @Override // com.meishu.sdk.meishu_ad.splash.SplashSkipView.b
                public void onSkip() {
                    try {
                        LogUtil.d(CSJTTAdNativeWrapper.TAG, "onSkip: ");
                        if (CSJTTAdNativeWrapper.this.loadListener != null) {
                            ((d) CSJTTAdNativeWrapper.this.loadListener).onAdSkip(cSJNativeSplashAd);
                            ((d) CSJTTAdNativeWrapper.this.loadListener).onAdClosed();
                        }
                        if (cSJNativeSplashAd.getInteractionListener() != null) {
                            cSJNativeSplashAd.getInteractionListener().onAdClosed();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // com.meishu.sdk.meishu_ad.splash.SplashSkipView.b
                public void onTick(long j) {
                    try {
                        if (CSJTTAdNativeWrapper.this.loadListener != null) {
                            ((d) CSJTTAdNativeWrapper.this.loadListener).onAdTick(j);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }

                @Override // com.meishu.sdk.meishu_ad.splash.SplashSkipView.b
                public void onTimeOver() {
                    try {
                        LogUtil.d(CSJTTAdNativeWrapper.TAG, "onTimeOver: ");
                        if (CSJTTAdNativeWrapper.this.loadListener != null) {
                            ((d) CSJTTAdNativeWrapper.this.loadListener).onAdTimeOver(cSJNativeSplashAd);
                            ((d) CSJTTAdNativeWrapper.this.loadListener).onAdClosed();
                        }
                        if (cSJNativeSplashAd.getInteractionListener() != null) {
                            cSJNativeSplashAd.getInteractionListener().onAdClosed();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public ViewGroup getAdContainer() {
        return ((SplashAdLoader) this.adLoader).getAdContainer();
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        int width;
        int height;
        int i;
        try {
            z.a(((SplashAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new i());
            if (!CSJAdConfig.isInitSuccess()) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ((Boolean) this.localParams.get(SplashAdLoader.KEY_AUTO_SHOW)).booleanValue();
            SdkHandler.getInstance().runOnUiThread(new l() { // from class: com.meishu.sdk.platform.csj.splash.CSJTTAdNativeWrapper.1
                @Override // com.meishu.sdk.core.safe.l
                public void safeRun() {
                    Object obj = CSJTTAdNativeWrapper.this.localParams.get(SplashAdLoader.KEY_SKIP_BUTTON);
                    if (obj == null || !(obj instanceof View)) {
                        return;
                    }
                    ((View) obj).setVisibility(4);
                }
            });
            if (this.sdkAdInfo.getAd_type() == AdType.FEED.value()) {
                loadNativeAd();
                return;
            }
            this.ttAdNative = CSJAdConfig.getTtAdManager().createAdNative(((SplashAdLoader) this.adLoader).getContext());
            if (getAdLoader().getAccept_ad_width() != null && getAdLoader().getAccept_ad_width().intValue() > 0 && getAdLoader().getAccept_ad_height() != null && getAdLoader().getAccept_ad_height().intValue() > 0) {
                width = getAdLoader().getAccept_ad_width().intValue();
                height = getAdLoader().getAccept_ad_height().intValue();
            } else if (this.meishuAdInfo.getWidth() == 0 || this.meishuAdInfo.getHeight() == 0 || this.meishuAdInfo.getWidth() <= 0 || this.meishuAdInfo.getHeight() <= 0) {
                try {
                    DisplayMetrics displayMetrics = ((SplashAdLoader) this.adLoader).getContext().getResources().getDisplayMetrics();
                    int i2 = displayMetrics.widthPixels;
                    if (i2 <= 0 || (i = displayMetrics.heightPixels) <= 0) {
                        width = 1080;
                        height = 1920;
                    } else {
                        height = i;
                        width = i2;
                    }
                } catch (Exception unused) {
                }
            } else {
                width = this.meishuAdInfo.getWidth();
                height = this.meishuAdInfo.getHeight();
            }
            LogUtil.d(TAG, "start load csj--------------------");
            loadNewAd(new AdSlot.Builder().setCodeId(getSdkAdInfo().getPid()).setSupportDeepLink(true).setImageAcceptedSize(width, height).setExpressViewAcceptedSize(m.b(((SplashAdLoader) this.adLoader).getContext(), width), m.b(((SplashAdLoader) this.adLoader).getContext(), height)).build());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
