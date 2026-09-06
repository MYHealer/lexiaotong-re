package com.meishu.sdk.platform.bd.splash;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.SplashAd;
import com.baidu.mobads.sdk.api.XNativeView;
import com.huawei.hms.ads.ez;
import com.meishu.sdk.R;
import com.meishu.sdk.activity.MeishuDownloadDetailActivity;
import com.meishu.sdk.activity.MeishuWebviewActivity;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.ad.splash.d;
import com.meishu.sdk.core.bquery.i;
import com.meishu.sdk.core.cache.a;
import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.safe.o;
import com.meishu.sdk.core.utils.DownloadDialogBean;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.e0;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i0;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.core.utils.x;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.core.view.gif.GifImageView;
import com.meishu.sdk.meishu_ad.splash.MeishuSplashRootView;
import com.meishu.sdk.meishu_ad.splash.SplashSkipView;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.bd.BDPlatformError;
import com.stub.StubApp;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BDSplashAdLoader extends BasePlatformLoader<SplashAdLoader, d> {
    private static final String TAG = "BDSplashAdLoader";
    private MeishuAdInfo meishuAdInfo;
    private boolean showed;
    private SplashAd splashAd;

    public BDSplashAdLoader(SplashAdLoader splashAdLoader, SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        super(splashAdLoader, sdkAdInfo);
        this.meishuAdInfo = meishuAdInfo;
    }

    private String getImageUrl(NativeResponse nativeResponse) {
        try {
            String imageUrl = nativeResponse.getImageUrl();
            if (!TextUtils.isEmpty(imageUrl)) {
                return imageUrl;
            }
            List<String> multiPicUrls = nativeResponse.getMultiPicUrls();
            if (multiPicUrls == null || multiPicUrls.size() <= 0) {
                return "";
            }
            String str = multiPicUrls.get(0);
            return !TextUtils.isEmpty(str) ? str : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private void handleDownloadView(final MeishuSplashRootView meishuSplashRootView, final NativeResponse nativeResponse) {
        try {
            if (nativeResponse.getAdActionType() == 2) {
                ((RelativeLayout) meishuSplashRootView.findViewById(R.id.ms_download_layer_root_view)).setVisibility(0);
                TextView textView = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_name);
                TextView textView2 = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_version);
                TextView textView3 = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_size);
                TextView textView4 = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_owner);
                TextView textView5 = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_privacy);
                TextView textView6 = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_permission);
                TextView textView7 = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_introduce);
                textView.setText(nativeResponse.getBrandName());
                textView2.setText(nativeResponse.getAppVersion());
                textView3.setText(((nativeResponse.getAppSize() / 1024) * 1024) + "Mb");
                textView4.setText(nativeResponse.getPublisher());
                textView5.setOnClickListener(new o() { // from class: com.meishu.sdk.platform.bd.splash.BDSplashAdLoader.4
                    @Override // com.meishu.sdk.core.safe.o
                    public void safeOnClick(View view) {
                        try {
                            String appPrivacyLink = nativeResponse.getAppPrivacyLink();
                            Intent intent = new Intent(meishuSplashRootView.getContext(), (Class<?>) MeishuWebviewActivity.class);
                            intent.putExtra(MeishuWebviewActivity.EXTRA_AD_DURL_KEY, new String[]{appPrivacyLink});
                            meishuSplashRootView.getContext().startActivity(intent);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                textView6.setOnClickListener(new o() { // from class: com.meishu.sdk.platform.bd.splash.BDSplashAdLoader.5
                    @Override // com.meishu.sdk.core.safe.o
                    public void safeOnClick(View view) {
                        try {
                            DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                            downloadDialogBean.setApp_name(nativeResponse.getBrandName());
                            downloadDialogBean.setApp_intro(nativeResponse.getDesc());
                            downloadDialogBean.setApp_privacy(nativeResponse.getAppPrivacyLink());
                            downloadDialogBean.setApp_size(((nativeResponse.getAppSize() / 1024) * 1024) + "Mb");
                            downloadDialogBean.setDeveloper(nativeResponse.getPublisher());
                            downloadDialogBean.setApp_permission_url(nativeResponse.getAppPermissionLink());
                            MeishuDownloadDetailActivity.startActivity(meishuSplashRootView.getContext(), downloadDialogBean);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                textView7.setOnClickListener(new o() { // from class: com.meishu.sdk.platform.bd.splash.BDSplashAdLoader.6
                    @Override // com.meishu.sdk.core.safe.o
                    public void safeOnClick(View view) {
                        try {
                            DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                            downloadDialogBean.setApp_name(nativeResponse.getBrandName());
                            downloadDialogBean.setApp_intro(nativeResponse.getDesc());
                            downloadDialogBean.setApp_privacy(nativeResponse.getAppPrivacyLink());
                            downloadDialogBean.setApp_size(((nativeResponse.getAppSize() / 1024) * 1024) + "Mb");
                            downloadDialogBean.setDeveloper(nativeResponse.getPublisher());
                            downloadDialogBean.setApp_permission_url(nativeResponse.getAppPermissionLink());
                            MeishuDownloadDetailActivity.startActivity(meishuSplashRootView.getContext(), downloadDialogBean);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void loadExpressAd() {
        Object obj = getLocalParams().get(SplashAdLoader.KEY_SKIP_BUTTON);
        boolean zBooleanValue = ((Boolean) getLocalParams().get(SplashAdLoader.KEY_AUTO_SHOW)).booleanValue();
        ViewGroup adContainer = getAdLoader().getAdContainer();
        BDSplashAd bDSplashAd = new BDSplashAd(zBooleanValue, adContainer, this);
        BDSplashListener bDSplashListener = new BDSplashListener(this, (d) this.loadListener, bDSplashAd);
        if (zBooleanValue && adContainer == null) {
            bDSplashListener.onAdFailed("未指定广告容器");
            return;
        }
        if (obj != null && (obj instanceof View)) {
            ((View) obj).setVisibility(4);
        }
        String pid = getSdkAdInfo().getPid();
        RequestParameters.Builder builder = new RequestParameters.Builder();
        int iDownloadConfirm = AdSdk.adConfig().downloadConfirm();
        if (iDownloadConfirm == 1) {
            builder.addExtra(SplashAd.KEY_POPDIALOG_DOWNLOAD, ez.Code);
        } else if (iDownloadConfirm == 2) {
            builder.addExtra(SplashAd.KEY_POPDIALOG_DOWNLOAD, ez.V);
        }
        SplashAd splashAd = new SplashAd(StubApp.getOrigApplicationContext(((SplashAdLoader) this.adLoader).getContext().getApplicationContext()), pid, builder.build(), bDSplashListener);
        this.splashAd = splashAd;
        splashAd.setAppSid(this.sdkAdInfo.getApp_id());
        bDSplashAd.setSplashAD(this.splashAd);
        this.splashAd.load();
    }

    private void loadNativeAd() {
        BaiduNativeManager baiduNativeManager = new BaiduNativeManager(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), this.sdkAdInfo.getPid());
        baiduNativeManager.setAppSid(this.sdkAdInfo.getApp_id());
        baiduNativeManager.setCacheVideoOnlyWifi(true);
        baiduNativeManager.loadFeedAd(new RequestParameters.Builder().downloadAppConfirmPolicy(3).build(), new BaiduNativeManager.FeedAdListener() { // from class: com.meishu.sdk.platform.bd.splash.BDSplashAdLoader.1
            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onLpClosed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeFail(int i, String str, NativeResponse nativeResponse) {
                try {
                    new BDPlatformError(str, BDSplashAdLoader.this.getSdkAdInfo()).post(BDSplashAdLoader.this.getLoaderListener());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNativeLoad(List<NativeResponse> list) {
                if (list != null) {
                    try {
                        if (list.size() != 0) {
                            NativeResponse nativeResponse = list.get(0);
                            BDNativeSplashAd bDNativeSplashAd = new BDNativeSplashAd(BDSplashAdLoader.this);
                            if (BDSplashAdLoader.this.getLoaderListener() != null) {
                                try {
                                    BDSplashAdLoader.this.getSdkAdInfo().setEcpm(nativeResponse.getECPMLevel());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                BDSplashAdLoader.this.showNativeSplash(nativeResponse, bDNativeSplashAd);
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        return;
                    }
                }
                new BDPlatformError("list is null", BDSplashAdLoader.this.getSdkAdInfo()).post(BDSplashAdLoader.this.getLoaderListener());
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onNoAd(int i, String str, NativeResponse nativeResponse) {
                try {
                    new BDPlatformError(str, BDSplashAdLoader.this.getSdkAdInfo()).post(BDSplashAdLoader.this.getLoaderListener());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadFailed() {
            }

            @Override // com.baidu.mobads.sdk.api.BaiduNativeManager.FeedAdListener
            public void onVideoDownloadSuccess() {
            }

            public void onNativeFail(int i, String str) {
                try {
                    new BDPlatformError(str, BDSplashAdLoader.this.getSdkAdInfo()).post(BDSplashAdLoader.this.getLoaderListener());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            public void onNoAd(int i, String str) {
                try {
                    new BDPlatformError(str, BDSplashAdLoader.this.getSdkAdInfo()).post(BDSplashAdLoader.this.getLoaderListener());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [android.view.View, com.baidu.mobads.sdk.api.XNativeView] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.baidu.mobads.sdk.api.NativeResponse$MaterialType] */
    /* JADX WARN: Type inference failed for: r13v2, types: [android.widget.TextView] */
    /* JADX WARN: Type inference failed for: r14v2, types: [android.view.View, android.widget.ImageView] */
    /* JADX WARN: Type inference failed for: r1v10, types: [com.baidu.mobads.sdk.api.NativeResponse$MaterialType, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v11, types: [com.meishu.sdk.platform.BasePlatformLoader] */
    /* JADX WARN: Type inference failed for: r1v12, types: [com.meishu.sdk.platform.BasePlatformLoader] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [com.meishu.sdk.platform.bd.splash.BDSplashAdLoader] */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.meishu.sdk.core.bquery.e] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.meishu.sdk.core.bquery.e] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.meishu.sdk.core.bquery.e, com.meishu.sdk.core.bquery.i] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [com.baidu.mobads.sdk.api.NativeResponse] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9, types: [com.baidu.mobads.sdk.api.NativeResponse] */
    /* JADX WARN: Type inference failed for: r8v8, types: [android.widget.RelativeLayout] */
    public void showNativeLayout(NativeResponse nativeResponse, final BDNativeSplashAd bDNativeSplashAd, boolean z, boolean z2, Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        ?? r1;
        ?? r2;
        ?? r3;
        int i3;
        MeishuSplashRootView meishuSplashRootView = (MeishuSplashRootView) LayoutInflater.from(this.context).inflate(R.layout.ms_layout_native_splash, (ViewGroup) null);
        bDNativeSplashAd.setAdView(meishuSplashRootView);
        getLoaderListener().onAdLoaded(bDNativeSplashAd);
        getLoaderListener().onAdReady(bDNativeSplashAd);
        ImageView imageView = (ImageView) meishuSplashRootView.findViewById(R.id.ms_layout_native_splash_bg);
        RelativeLayout relativeLayout = (RelativeLayout) meishuSplashRootView.findViewById(R.id.ms_native_splash_ad_container);
        View viewInflate = View.inflate(this.context, R.layout.ms_layout_native_splash_1, null);
        if (z2) {
            viewInflate = View.inflate(this.context, R.layout.ms_layout_native_splash_2, null);
        }
        relativeLayout.addView(viewInflate, -1, -1);
        ?? r8 = (RelativeLayout) viewInflate.findViewById(R.id.activity_sdk_splash_mediaContainer);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ms_layout_native_splash_ll);
        GifImageView gifImageView = (GifImageView) viewInflate.findViewById(R.id.layout_native_splash_imageview);
        ?? r13 = (TextView) viewInflate.findViewById(R.id.layout_native_splash_title);
        ?? r14 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_icon);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_score);
        TextView textView = (TextView) viewInflate.findViewById(R.id.layout_native_splash_desc);
        TextView textView2 = (TextView) meishuSplashRootView.findViewById(R.id.ms_layout_native_splash_cid);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.ms_jump_btn);
        textView2.setVisibility(8);
        if (nativeResponse.getAdActionType() != 2) {
            textView3.setText("点击或摇动了解详情");
        } else {
            textView3.setText("点击下载");
        }
        handleDownloadView(meishuSplashRootView, nativeResponse);
        ?? iVar = new i(meishuSplashRootView);
        if (!TextUtils.isEmpty(nativeResponse.getAdLogoUrl())) {
            ((i) iVar.b(R.id.ms_layout_native_splash_logo)).a(nativeResponse.getBaiduLogoUrl(), false);
        }
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        if (z2) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            double d = ((double) displayMetrics.widthPixels) * 0.86d;
            layoutParams.width = (int) d;
            layoutParams.height = (int) ((d * ((double) i2)) / ((double) i));
            int i4 = (int) (((double) displayMetrics.heightPixels) * 0.07d);
            layoutParams.topMargin = i4;
            layoutParams.bottomMargin = i4;
            linearLayout.setLayoutParams(layoutParams);
            r13.setVisibility(8);
            textView.setVisibility(8);
            imageView2.setVisibility(8);
            r14.setVisibility(8);
            r2 = iVar;
        } else {
            if (TextUtils.isEmpty(nativeResponse.getDesc())) {
                r1 = 0;
                textView.setVisibility(8);
                imageView2.setVisibility(0);
            } else {
                r1 = 0;
                textView.setVisibility(0);
                textView.setText(nativeResponse.getDesc());
            }
            if (TextUtils.isEmpty(nativeResponse.getTitle())) {
                r13.setVisibility(8);
                imageView2.setVisibility(8);
            } else {
                r13.setVisibility(r1);
                r13.setText(nativeResponse.getTitle());
            }
            if (TextUtils.isEmpty(nativeResponse.getIconUrl())) {
                r2 = iVar;
                r14.setVisibility(8);
            } else {
                r14.setVisibility(r1);
                ?? r4 = iVar;
                r4.d = r14;
                r4.a(nativeResponse.getIconUrl(), r1);
                r2 = r4;
            }
        }
        try {
            ?? materialType = nativeResponse.getMaterialType();
            r3 = NativeResponse.MaterialType.VIDEO;
            try {
                if (materialType.equals(r3)) {
                    r3 = this;
                    try {
                        ?? xNativeView = new XNativeView(r3.context);
                        iVar = nativeResponse;
                        xNativeView.setNativeItem(iVar);
                        xNativeView.setUseDownloadFrame(true);
                        xNativeView.setVideoMute(false);
                        xNativeView.render();
                        r8.removeAllViews();
                        ViewGroup.LayoutParams layoutParams2 = xNativeView.getLayoutParams();
                        if (layoutParams2 == null) {
                            i3 = -1;
                            layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
                        } else {
                            i3 = -1;
                        }
                        layoutParams2.width = i3;
                        layoutParams2.height = i3;
                        r8.addView(xNativeView, layoutParams2);
                    } catch (Exception e) {
                        e = e;
                        r3 = r3;
                        iVar = nativeResponse;
                        e.printStackTrace();
                    }
                } else {
                    r3 = this;
                    iVar = nativeResponse;
                    if (bitmap != null) {
                        gifImageView.setImageBitmap(bitmap);
                    } else {
                        String imageUrl = getImageUrl(nativeResponse);
                        r2.d = gifImageView;
                        r2.a(imageUrl, false);
                    }
                    if (bitmap2 != null) {
                        r3.context.getApplicationContext();
                        imageView.setImageBitmap(e0.a(bitmap2, 20));
                    }
                }
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
            }
        } catch (Exception e3) {
            e = e3;
            r3 = this;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(linearLayout);
        iVar.registerViewForInteraction(linearLayout, arrayList, null, new NativeResponse.AdInteractionListener() { // from class: com.meishu.sdk.platform.bd.splash.BDSplashAdLoader.3
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActReward(int i5) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActRewardSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposed() {
                try {
                    LogUtil.e(BDSplashAdLoader.TAG, "onADExposed");
                    if (BDSplashAdLoader.this.showed) {
                        return;
                    }
                    if (BDSplashAdLoader.this.getLoaderListener() != null) {
                        BDSplashAdLoader.this.getLoaderListener().onAdExposure();
                    }
                    BDNativeSplashAd bDNativeSplashAd2 = bDNativeSplashAd;
                    if (bDNativeSplashAd2 != null && bDNativeSplashAd2.getInteractionListener() != null) {
                        bDNativeSplashAd.getInteractionListener().onAdExposure();
                    }
                    BDSplashAdLoader.this.showed = true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposureFailed(int i5) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADStatusChanged() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdClick() {
                try {
                    LogUtil.d(BDSplashAdLoader.TAG, "send onAdClicked");
                    if (BDSplashAdLoader.this.getSdkAdInfo() != null && bDNativeSplashAd != null) {
                        z.a(StubApp.getOrigApplicationContext(BDSplashAdLoader.this.context.getApplicationContext()), f.a(BDSplashAdLoader.this.getSdkAdInfo().getClk(), bDNativeSplashAd), new com.meishu.sdk.core.utils.i());
                        BDSplashAdLoader.this.getSdkAdInfo().getMsLoadedTime();
                        BDSplashAdLoader.this.getAdLoader().getPosId();
                    }
                    BDNativeSplashAd bDNativeSplashAd2 = bDNativeSplashAd;
                    if (bDNativeSplashAd2 == null || bDNativeSplashAd2.getInteractionListener() == null) {
                        return;
                    }
                    bDNativeSplashAd.getInteractionListener().onAdClicked();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdUnionClick() {
            }
        });
        r3.showSkipView(meishuSplashRootView, bDNativeSplashAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNativeSplash(final NativeResponse nativeResponse, final BDNativeSplashAd bDNativeSplashAd) {
        String imageUrl;
        if (nativeResponse.getMaterialType() != NativeResponse.MaterialType.VIDEO && nativeResponse.getMaterialType() == NativeResponse.MaterialType.NORMAL) {
            if (TextUtils.isEmpty(nativeResponse.getImageUrl())) {
                imageUrl = (nativeResponse.getMultiPicUrls() == null || nativeResponse.getMultiPicUrls().size() <= 0) ? "" : nativeResponse.getMultiPicUrls().get(0);
            } else {
                imageUrl = nativeResponse.getImageUrl();
            }
            a.a(imageUrl, new x() { // from class: com.meishu.sdk.platform.bd.splash.BDSplashAdLoader.2
                @Override // com.meishu.sdk.core.utils.x
                public void onFailure(IOException iOException) {
                    new BDPlatformError("图片加载失败", BDSplashAdLoader.this.getSdkAdInfo()).post(BDSplashAdLoader.this.getLoaderListener());
                }

                @Override // com.meishu.sdk.core.utils.x
                public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
                    byte[] responseBody;
                    boolean z;
                    int i;
                    int i2;
                    try {
                        if (!httpResponse.isSuccessful() || (responseBody = httpResponse.getResponseBody()) == null || responseBody.length <= 0) {
                            return;
                        }
                        if (responseBody.length >= i0.a()) {
                            new BDPlatformError("图片加载失败", BDSplashAdLoader.this.getSdkAdInfo()).post(BDSplashAdLoader.this.getLoaderListener());
                            return;
                        }
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                        if (bitmapDecodeByteArray != null) {
                            int width = bitmapDecodeByteArray.getWidth();
                            int height = bitmapDecodeByteArray.getHeight();
                            if ((width * 1.0f) / height < 0.67d) {
                                i = width;
                                i2 = height;
                                z = true;
                            } else {
                                i = width;
                                z = false;
                                i2 = height;
                            }
                        } else {
                            z = false;
                            i = 0;
                            i2 = 0;
                        }
                        BDSplashAdLoader.this.showNativeLayout(nativeResponse, bDNativeSplashAd, true, z, bitmapDecodeByteArray, BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length), i, i2);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }, true);
        }
    }

    private void showSkipView(MeishuSplashRootView meishuSplashRootView, final BDNativeSplashAd bDNativeSplashAd) {
        SplashSkipView splashSkipView = (SplashSkipView) meishuSplashRootView.findViewById(R.id.ms_skipView);
        bDNativeSplashAd.setSkipView(splashSkipView);
        splashSkipView.setOnSkipListener(new SplashSkipView.b() { // from class: com.meishu.sdk.platform.bd.splash.BDSplashAdLoader.7
            @Override // com.meishu.sdk.meishu_ad.splash.SplashSkipView.b
            public void onSkip() {
                try {
                    LogUtil.d(BDSplashAdLoader.TAG, "onSkip: ");
                    if (BDSplashAdLoader.this.loadListener != null) {
                        ((d) BDSplashAdLoader.this.loadListener).onAdSkip(bDNativeSplashAd);
                        ((d) BDSplashAdLoader.this.loadListener).onAdClosed();
                    }
                    BDNativeSplashAd bDNativeSplashAd2 = bDNativeSplashAd;
                    if (bDNativeSplashAd2 == null || bDNativeSplashAd2.getInteractionListener() == null) {
                        return;
                    }
                    bDNativeSplashAd.getInteractionListener().onAdClosed();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.meishu.sdk.meishu_ad.splash.SplashSkipView.b
            public void onTick(long j) {
                try {
                    if (BDSplashAdLoader.this.loadListener != null) {
                        ((d) BDSplashAdLoader.this.loadListener).onAdTick(j);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.meishu.sdk.meishu_ad.splash.SplashSkipView.b
            public void onTimeOver() {
                try {
                    LogUtil.d(BDSplashAdLoader.TAG, "onTimeOver: ");
                    if (BDSplashAdLoader.this.loadListener != null) {
                        ((d) BDSplashAdLoader.this.loadListener).onAdTimeOver(bDNativeSplashAd);
                        ((d) BDSplashAdLoader.this.loadListener).onAdClosed();
                    }
                    if (bDNativeSplashAd.getInteractionListener() != null) {
                        bDNativeSplashAd.getInteractionListener().onAdClosed();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
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
            LogUtil.e(TAG, "start loadBD");
            z.a(((SplashAdLoader) this.adLoader).getContext(), h0.a(getSdkAdInfo().getReq()), new com.meishu.sdk.core.utils.i());
            if (this.sdkAdInfo.getAd_type() == AdType.FEED.value()) {
                loadNativeAd();
            } else {
                LogUtil.e(TAG, "start loadBD");
                loadExpressAd();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        LogUtil.e(TAG, "isWin=" + z + ",price=" + i);
        int i2 = 1;
        try {
            Class<?> cls = Class.forName("com.baidu.mobads.sdk.api.SplashAd");
            if (z) {
                Method declaredMethod = cls.getDeclaredMethod("biddingSuccess", String.class);
                SplashAd splashAd = this.splashAd;
                declaredMethod.invoke(splashAd, String.valueOf(t0.a(Integer.parseInt(splashAd.getECPMLevel()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
            } else {
                cls.getDeclaredMethod("biddingFail", String.class).invoke(this.splashAd, "203");
            }
        } catch (Throwable unused) {
            try {
                if (z) {
                    LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
                    linkedHashMap.put("ecpm", Integer.valueOf(t0.a(Integer.parseInt(this.splashAd.getECPMLevel()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    linkedHashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    linkedHashMap.put("bid_t", 1);
                    this.splashAd.biddingSuccess(linkedHashMap, new BiddingListener() { // from class: com.meishu.sdk.platform.bd.splash.BDSplashAdLoader.8
                        @Override // com.baidu.mobads.sdk.api.BiddingListener
                        public void onBiddingResult(boolean z2, String str, HashMap<String, Object> map) {
                        }
                    });
                } else {
                    LinkedHashMap<String, Object> linkedHashMap2 = new LinkedHashMap<>();
                    linkedHashMap2.put("ecpm", Integer.valueOf(i));
                    int iNextInt = new Random().nextInt(10);
                    if (iNextInt != 0) {
                        i2 = iNextInt;
                    }
                    linkedHashMap2.put(SplashAd.KEY_BIDFAIL_ADN, Integer.valueOf(i2));
                    linkedHashMap2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    linkedHashMap2.put("bid_t", 3);
                    linkedHashMap2.put("reason", "203");
                    this.splashAd.biddingFail(linkedHashMap2, new BiddingListener() { // from class: com.meishu.sdk.platform.bd.splash.BDSplashAdLoader.9
                        @Override // com.baidu.mobads.sdk.api.BiddingListener
                        public void onBiddingResult(boolean z2, String str, HashMap<String, Object> map) {
                        }
                    });
                }
            } catch (Throwable unused2) {
            }
        }
    }
}
