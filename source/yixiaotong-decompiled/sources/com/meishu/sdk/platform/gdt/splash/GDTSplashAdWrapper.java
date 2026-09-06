package com.meishu.sdk.platform.gdt.splash;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gson.Gson;
import com.meishu.sdk.R;
import com.meishu.sdk.activity.MeishuDownloadDetailActivity;
import com.meishu.sdk.activity.MeishuWebviewActivity;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.splash.SplashAdLoader;
import com.meishu.sdk.core.ad.splash.d;
import com.meishu.sdk.core.bquery.i;
import com.meishu.sdk.core.cache.a;
import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.serverbidding.S2sbResultBean;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.safe.o;
import com.meishu.sdk.core.utils.DownloadDialogBean;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.e0;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.h;
import com.meishu.sdk.core.utils.h0;
import com.meishu.sdk.core.utils.i0;
import com.meishu.sdk.core.utils.t0;
import com.meishu.sdk.core.utils.x;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.core.view.gif.GifImageView;
import com.meishu.sdk.meishu_ad.splash.MeishuSplashRootView;
import com.meishu.sdk.meishu_ad.splash.SplashSkipView;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.gdt.GDTPlatformError;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.comm.util.AdError;
import com.stub.StubApp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTSplashAdWrapper extends BasePlatformLoader<SplashAdLoader, d> {
    private static final String TAG = "GDTSplashAdWrapper";
    private Bitmap bitmapBlur;
    private GDTSplashAd gdtSplashAd;
    private int height;
    private Bitmap imgBitmap;
    private boolean isVertical;
    private boolean showed;
    private SplashAD splashAD;
    private int width;

    public GDTSplashAdWrapper(SplashAdLoader splashAdLoader, SdkAdInfo sdkAdInfo) {
        super(splashAdLoader, sdkAdInfo);
        this.width = 0;
        this.height = 0;
        this.imgBitmap = null;
        this.isVertical = false;
    }

    private String getImageUrl(NativeUnifiedADData nativeUnifiedADData) {
        if (TextUtils.isEmpty(nativeUnifiedADData.getImgUrl())) {
            return (nativeUnifiedADData.getImgList() == null || nativeUnifiedADData.getImgList().size() <= 0) ? "" : nativeUnifiedADData.getImgList().get(0);
        }
        return nativeUnifiedADData.getImgUrl();
    }

    private void handleDownloadView(final MeishuSplashRootView meishuSplashRootView, NativeUnifiedADData nativeUnifiedADData) {
        if (nativeUnifiedADData.isAppAd()) {
            ((RelativeLayout) meishuSplashRootView.findViewById(R.id.ms_download_layer_root_view)).setVisibility(0);
            TextView textView = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_name);
            TextView textView2 = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_version);
            TextView textView3 = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_size);
            TextView textView4 = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_owner);
            TextView textView5 = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_privacy);
            TextView textView6 = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_permission);
            TextView textView7 = (TextView) meishuSplashRootView.findViewById(R.id.ms_download_layer_app_introduce);
            final NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
            textView.setText(appMiitInfo.getAppName());
            textView2.setText(appMiitInfo.getVersionName());
            textView3.setText(((appMiitInfo.getPackageSizeBytes() / 1024) * 1024) + "Mb");
            textView4.setText(appMiitInfo.getAuthorName());
            textView5.setOnClickListener(new o() { // from class: com.meishu.sdk.platform.gdt.splash.GDTSplashAdWrapper.8
                @Override // com.meishu.sdk.core.safe.o
                public void safeOnClick(View view) {
                    try {
                        String privacyAgreement = appMiitInfo.getPrivacyAgreement();
                        Intent intent = new Intent(meishuSplashRootView.getContext(), (Class<?>) MeishuWebviewActivity.class);
                        intent.putExtra(MeishuWebviewActivity.EXTRA_AD_DURL_KEY, new String[]{privacyAgreement});
                        meishuSplashRootView.getContext().startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            textView6.setOnClickListener(new o() { // from class: com.meishu.sdk.platform.gdt.splash.GDTSplashAdWrapper.9
                @Override // com.meishu.sdk.core.safe.o
                public void safeOnClick(View view) {
                    try {
                        DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                        downloadDialogBean.setApp_name(appMiitInfo.getAppName());
                        downloadDialogBean.setApp_intro(appMiitInfo.getDescriptionUrl());
                        downloadDialogBean.setApp_privacy(appMiitInfo.getPrivacyAgreement());
                        downloadDialogBean.setApp_size(((appMiitInfo.getPackageSizeBytes() / 1024) * 1024) + "Mb");
                        downloadDialogBean.setDeveloper(appMiitInfo.getAuthorName());
                        downloadDialogBean.setApp_intor_url(appMiitInfo.getDescriptionUrl());
                        MeishuDownloadDetailActivity.startActivity(meishuSplashRootView.getContext(), downloadDialogBean);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            textView7.setOnClickListener(new o() { // from class: com.meishu.sdk.platform.gdt.splash.GDTSplashAdWrapper.10
                @Override // com.meishu.sdk.core.safe.o
                public void safeOnClick(View view) {
                    try {
                        DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
                        downloadDialogBean.setApp_name(appMiitInfo.getAppName());
                        downloadDialogBean.setApp_intro(appMiitInfo.getDescriptionUrl());
                        downloadDialogBean.setApp_privacy(appMiitInfo.getPrivacyAgreement());
                        downloadDialogBean.setApp_size(((appMiitInfo.getPackageSizeBytes() / 1024) * 1024) + "Mb");
                        downloadDialogBean.setDeveloper(appMiitInfo.getAuthorName());
                        downloadDialogBean.setApp_intor_url(appMiitInfo.getDescriptionUrl());
                        MeishuDownloadDetailActivity.startActivity(meishuSplashRootView.getContext(), downloadDialogBean);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNativeSplash() {
        NativeUnifiedAD nativeUnifiedAD;
        final GDTNativeSplashAd gDTNativeSplashAd = new GDTNativeSplashAd(this);
        if (TextUtils.isEmpty(this.sdkAdInfo.getS2sb())) {
            nativeUnifiedAD = null;
        } else {
            try {
                nativeUnifiedAD = new NativeUnifiedAD(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), this.sdkAdInfo.getPid(), new NativeADUnifiedListener() { // from class: com.meishu.sdk.platform.gdt.splash.GDTSplashAdWrapper.2
                    @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
                    public void onADLoaded(List<NativeUnifiedADData> list) {
                        if (list != null) {
                            try {
                                if (list.size() != 0) {
                                    GDTSplashAdWrapper.this.showNativeSplash(list.get(0), gDTNativeSplashAd);
                                    return;
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                                return;
                            }
                        }
                        new GDTPlatformError(new AdError(-1, "返回数据为空"), GDTSplashAdWrapper.this.sdkAdInfo).post(GDTSplashAdWrapper.this.loadListener);
                    }

                    @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
                    public void onNoAD(AdError adError) {
                        try {
                            new GDTPlatformError(adError, GDTSplashAdWrapper.this.sdkAdInfo).post(GDTSplashAdWrapper.this.loadListener);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }, ((S2sbResultBean) new Gson().fromJson(this.sdkAdInfo.getS2sb(), S2sbResultBean.class)).getToken());
            } catch (Exception e) {
                e.printStackTrace();
                nativeUnifiedAD = null;
            }
        }
        if (nativeUnifiedAD == null) {
            nativeUnifiedAD = new NativeUnifiedAD(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), this.sdkAdInfo.getPid(), new NativeADUnifiedListener() { // from class: com.meishu.sdk.platform.gdt.splash.GDTSplashAdWrapper.3
                @Override // com.qq.e.ads.nativ.NativeADUnifiedListener
                public void onADLoaded(List<NativeUnifiedADData> list) {
                    if (list != null) {
                        try {
                            if (list.size() != 0) {
                                GDTSplashAdWrapper.this.showNativeSplash(list.get(0), gDTNativeSplashAd);
                                return;
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                            return;
                        }
                    }
                    new GDTPlatformError(new AdError(-1, "返回数据为空"), GDTSplashAdWrapper.this.sdkAdInfo).post(GDTSplashAdWrapper.this.loadListener);
                }

                @Override // com.qq.e.ads.NativeAbstractAD.BasicADListener
                public void onNoAD(AdError adError) {
                    try {
                        new GDTPlatformError(adError, GDTSplashAdWrapper.this.sdkAdInfo).post(GDTSplashAdWrapper.this.loadListener);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
        nativeUnifiedAD.loadData(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SplashAD reflectNewSplashAD(Context context, String str, Object obj, int i, String str2) {
        if (obj == null) {
            return null;
        }
        try {
            Class<?> cls = obj.getClass().getInterfaces()[0];
            if (!TextUtils.isEmpty(str2)) {
                try {
                    return (SplashAD) SplashAD.class.getConstructor(Context.class, String.class, cls, Integer.TYPE, String.class).newInstance(context, str, obj, Integer.valueOf(i), str2);
                } catch (NoSuchMethodException unused) {
                }
            }
            return (SplashAD) SplashAD.class.getConstructor(Context.class, String.class, cls, Integer.TYPE).newInstance(context, str, obj, Integer.valueOf(i));
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v16 */
    public void showNativeLayout(NativeUnifiedADData nativeUnifiedADData, final GDTNativeSplashAd gDTNativeSplashAd) {
        ?? r3;
        int i;
        int i2;
        MeishuSplashRootView meishuSplashRootView = (MeishuSplashRootView) LayoutInflater.from(this.context).inflate(R.layout.ms_layout_native_splash, (ViewGroup) null);
        gDTNativeSplashAd.setAdView(meishuSplashRootView);
        showSkipView(meishuSplashRootView, gDTNativeSplashAd);
        if (this.loadListener != 0) {
            if (getSdkAdInfo() != null) {
                getSdkAdInfo().setEcpm(String.valueOf(nativeUnifiedADData.getECPM()));
            }
            ((d) this.loadListener).onAdLoaded(gDTNativeSplashAd);
            ((d) this.loadListener).onAdReady(gDTNativeSplashAd);
        }
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        final ImageView imageView = (ImageView) meishuSplashRootView.findViewById(R.id.ms_layout_native_splash_bg);
        RelativeLayout relativeLayout = (RelativeLayout) meishuSplashRootView.findViewById(R.id.ms_native_splash_ad_container);
        View viewInflate = View.inflate(this.context, R.layout.ms_layout_native_splash_1, null);
        if (this.isVertical) {
            viewInflate = View.inflate(this.context, R.layout.ms_layout_native_splash_2, null);
        }
        relativeLayout.addView(viewInflate, -1, -1);
        RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate.findViewById(R.id.activity_sdk_splash_mediaContainer);
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ms_layout_native_splash_ll);
        final GifImageView gifImageView = (GifImageView) viewInflate.findViewById(R.id.layout_native_splash_imageview);
        TextView textView = (TextView) viewInflate.findViewById(R.id.layout_native_splash_title);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_icon);
        ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.layout_native_splash_score);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.layout_native_splash_desc);
        ImageView imageView4 = (ImageView) meishuSplashRootView.findViewById(R.id.ms_layout_native_splash_logo);
        TextView textView3 = (TextView) meishuSplashRootView.findViewById(R.id.ms_layout_native_splash_cid);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.ms_jump_btn);
        imageView4.setImageDrawable(this.context.getResources().getDrawable(R.drawable.ms_gdt_logo));
        textView3.setVisibility(8);
        i iVar = new i(meishuSplashRootView);
        handleDownloadView(meishuSplashRootView, nativeUnifiedADData);
        if (nativeUnifiedADData.isAppAd()) {
            textView4.setText("点击下载第三方应用");
        } else {
            textView4.setText("点击跳转到详情页");
        }
        if (h.c(this.sdkAdInfo.getAct_type())) {
            Drawable drawable = this.context.getResources().getDrawable(R.drawable.ms_shake_angle);
            int i3 = (int) (displayMetrics.density * 30.0f);
            drawable.setBounds(0, 0, i3, i3);
            textView4.setPadding(60, 0, 60, 0);
            textView4.setCompoundDrawables(drawable, null, null, null);
            if (nativeUnifiedADData.isAppAd()) {
                textView4.setText("点击/摇一摇下载第三方应用");
            } else {
                textView4.setText("点击或摇一摇跳转详情页");
            }
        }
        if (this.isVertical) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) linearLayout.getLayoutParams();
            double d = ((double) displayMetrics.widthPixels) * 0.86d;
            layoutParams.width = (int) d;
            layoutParams.height = (int) ((d * ((double) this.height)) / ((double) this.width));
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
            if (TextUtils.isEmpty(nativeUnifiedADData.getDesc())) {
                r3 = 0;
                i = 8;
                textView2.setVisibility(8);
                imageView3.setVisibility(0);
            } else {
                r3 = 0;
                textView2.setVisibility(0);
                textView2.setText(nativeUnifiedADData.getDesc());
                i = 8;
            }
            if (TextUtils.isEmpty(nativeUnifiedADData.getTitle())) {
                textView.setVisibility(i);
                imageView3.setVisibility(i);
            } else {
                textView.setVisibility(r3);
                textView.setText(nativeUnifiedADData.getTitle());
            }
            if (TextUtils.isEmpty(nativeUnifiedADData.getIconUrl())) {
                imageView2.setVisibility(i);
            } else {
                imageView2.setVisibility(r3);
                iVar.d = imageView2;
                iVar.a(nativeUnifiedADData.getIconUrl(), r3);
            }
        }
        NativeAdContainer nativeAdContainer = new NativeAdContainer(this.context);
        ViewGroup viewGroup = (ViewGroup) linearLayout.getParent();
        if (viewGroup != null) {
            ViewGroup.LayoutParams layoutParams3 = linearLayout.getLayoutParams();
            viewGroup.removeView(linearLayout);
            nativeAdContainer.addView(linearLayout, new ViewGroup.LayoutParams(-1, -2));
            viewGroup.addView(nativeAdContainer, layoutParams3);
        }
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(0, 0);
        ArrayList arrayList = new ArrayList();
        if ((this.sdkAdInfo.getAct_type() & 1) == 1) {
            arrayList.add(linearLayout);
        } else {
            arrayList.add(textView4);
        }
        nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListener() { // from class: com.meishu.sdk.platform.gdt.splash.GDTSplashAdWrapper.5
            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADClicked() {
                try {
                    if (GDTSplashAdWrapper.this.getSdkAdInfo() != null && gDTNativeSplashAd != null) {
                        LogUtil.d(GDTSplashAdWrapper.TAG, "send onADClicked");
                        z.a(StubApp.getOrigApplicationContext(GDTSplashAdWrapper.this.context.getApplicationContext()), f.a(GDTSplashAdWrapper.this.getSdkAdInfo().getClk(), gDTNativeSplashAd), new com.meishu.sdk.core.utils.i());
                        GDTSplashAdWrapper.this.getSdkAdInfo().getMsLoadedTime();
                        GDTSplashAdWrapper.this.getAdLoader().getPosId();
                    }
                    GDTNativeSplashAd gDTNativeSplashAd2 = gDTNativeSplashAd;
                    if (gDTNativeSplashAd2 == null || gDTNativeSplashAd2.getInteractionListener() == null) {
                        return;
                    }
                    gDTNativeSplashAd.getInteractionListener().onAdClicked();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError adError) {
                if (GDTSplashAdWrapper.this.loadListener != null) {
                    ((d) GDTSplashAdWrapper.this.loadListener).onAdRenderFail(adError.getErrorMsg(), adError.getErrorCode());
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                try {
                    if (GDTSplashAdWrapper.this.getLoaderListener() == null || GDTSplashAdWrapper.this.showed) {
                        return;
                    }
                    GDTSplashAdWrapper.this.showed = true;
                    GDTSplashAdWrapper.this.getLoaderListener().onAdExposure();
                    GDTNativeSplashAd gDTNativeSplashAd2 = gDTNativeSplashAd;
                    if (gDTNativeSplashAd2 == null || gDTNativeSplashAd2.getInteractionListener() == null) {
                        return;
                    }
                    gDTNativeSplashAd.getInteractionListener().onAdExposure();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
            }
        });
        nativeUnifiedADData.bindAdToView(this.context, nativeAdContainer, layoutParams4, arrayList);
        if (nativeUnifiedADData.getAdPatternType() != 2) {
            Bitmap bitmap = this.imgBitmap;
            if (bitmap == null || this.bitmapBlur == null) {
                a.a(getImageUrl(nativeUnifiedADData), new x() { // from class: com.meishu.sdk.platform.gdt.splash.GDTSplashAdWrapper.7
                    @Override // com.meishu.sdk.core.utils.x
                    public void onFailure(IOException iOException) {
                        try {
                            new GDTPlatformError(new AdError(-1, "图片加载失败"), GDTSplashAdWrapper.this.sdkAdInfo).post(GDTSplashAdWrapper.this.loadListener);
                        } catch (Throwable unused) {
                            iOException.printStackTrace();
                        }
                    }

                    @Override // com.meishu.sdk.core.utils.x
                    public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
                        try {
                            if (!httpResponse.isSuccessful()) {
                                new GDTPlatformError(new AdError(-1, "图片加载失败"), GDTSplashAdWrapper.this.sdkAdInfo).post(GDTSplashAdWrapper.this.loadListener);
                                return;
                            }
                            byte[] responseBody = httpResponse.getResponseBody();
                            if (responseBody == null || responseBody.length <= 0) {
                                new GDTPlatformError(new AdError(-1, "图片加载失败"), GDTSplashAdWrapper.this.sdkAdInfo).post(GDTSplashAdWrapper.this.loadListener);
                                return;
                            }
                            if (responseBody.length >= i0.a()) {
                                new GDTPlatformError(new AdError(-1, "图片加载失败"), GDTSplashAdWrapper.this.sdkAdInfo).post(GDTSplashAdWrapper.this.loadListener);
                                return;
                            }
                            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                            if (bitmapDecodeByteArray != null) {
                                gifImageView.setImageBitmap(bitmapDecodeByteArray);
                            }
                            Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                            if (bitmapDecodeByteArray2 != null) {
                                GDTSplashAdWrapper.this.context.getApplicationContext();
                                imageView.setImageBitmap(e0.a(bitmapDecodeByteArray2, 20));
                            }
                        } catch (Throwable th) {
                            new GDTPlatformError(new AdError(-1, "图片加载失败"), GDTSplashAdWrapper.this.sdkAdInfo).post(GDTSplashAdWrapper.this.loadListener);
                            th.printStackTrace();
                        }
                    }
                }, true);
                return;
            }
            gifImageView.setImageBitmap(bitmap);
            this.context.getApplicationContext();
            imageView.setImageBitmap(e0.a(this.bitmapBlur, 20));
            return;
        }
        relativeLayout2.removeAllViews();
        MediaView mediaView = new MediaView(this.context);
        ViewGroup.LayoutParams layoutParams5 = mediaView.getLayoutParams();
        if (layoutParams5 == null) {
            i2 = -1;
            layoutParams5 = new ViewGroup.LayoutParams(-1, -2);
        } else {
            i2 = -1;
        }
        layoutParams5.width = i2;
        layoutParams5.height = i2;
        relativeLayout2.addView(mediaView, layoutParams5);
        VideoOption.Builder builder = new VideoOption.Builder();
        builder.setAutoPlayPolicy(1);
        builder.setAutoPlayMuted(true);
        builder.setNeedCoverImage(true);
        builder.setNeedProgressBar(true);
        builder.setEnableDetailPage(true);
        builder.setEnableUserControl(false);
        nativeUnifiedADData.bindMediaView(mediaView, builder.build(), new NativeADMediaListener() { // from class: com.meishu.sdk.platform.gdt.splash.GDTSplashAdWrapper.6
            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoClicked() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoCompleted() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoError(AdError adError) {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoInit() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoaded(int i6) {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoLoading() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoPause() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoReady() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoResume() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStart() {
            }

            @Override // com.qq.e.ads.nativ.NativeADMediaListener
            public void onVideoStop() {
            }
        });
    }

    private void showSkipView(MeishuSplashRootView meishuSplashRootView, final GDTNativeSplashAd gDTNativeSplashAd) {
        SplashSkipView splashSkipView = (SplashSkipView) meishuSplashRootView.findViewById(R.id.ms_skipView);
        gDTNativeSplashAd.setSkipView(splashSkipView);
        splashSkipView.setOnSkipListener(new SplashSkipView.b() { // from class: com.meishu.sdk.platform.gdt.splash.GDTSplashAdWrapper.11
            @Override // com.meishu.sdk.meishu_ad.splash.SplashSkipView.b
            public void onSkip() {
                LogUtil.d(GDTSplashAdWrapper.TAG, "onSkip: ");
                if (GDTSplashAdWrapper.this.loadListener != null) {
                    ((d) GDTSplashAdWrapper.this.loadListener).onAdSkip(gDTNativeSplashAd);
                    ((d) GDTSplashAdWrapper.this.loadListener).onAdClosed();
                }
                if (gDTNativeSplashAd.getInteractionListener() != null) {
                    gDTNativeSplashAd.getInteractionListener().onAdClosed();
                }
            }

            @Override // com.meishu.sdk.meishu_ad.splash.SplashSkipView.b
            public void onTick(long j) {
                if (GDTSplashAdWrapper.this.loadListener != null) {
                    ((d) GDTSplashAdWrapper.this.loadListener).onAdTick(j);
                }
            }

            @Override // com.meishu.sdk.meishu_ad.splash.SplashSkipView.b
            public void onTimeOver() {
                LogUtil.d(GDTSplashAdWrapper.TAG, "onTimeOver: ");
                if (GDTSplashAdWrapper.this.loadListener != null) {
                    ((d) GDTSplashAdWrapper.this.loadListener).onAdTimeOver(gDTNativeSplashAd);
                    ((d) GDTSplashAdWrapper.this.loadListener).onAdClosed();
                }
                if (gDTNativeSplashAd.getInteractionListener() != null) {
                    gDTNativeSplashAd.getInteractionListener().onAdClosed();
                }
            }
        });
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
    }

    @Override // com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        SdkHandler.getInstance().runOnUiThread(new l() { // from class: com.meishu.sdk.platform.gdt.splash.GDTSplashAdWrapper.1
            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                try {
                    z.a(((SplashAdLoader) GDTSplashAdWrapper.this.adLoader).getContext(), h0.a(GDTSplashAdWrapper.this.getSdkAdInfo().getReq()), new com.meishu.sdk.core.utils.i());
                    LogUtil.d(GDTSplashAdWrapper.TAG, "load GDT------------------------");
                    if (GDTSplashAdWrapper.this.sdkAdInfo.getAd_type() == AdType.FEED.value()) {
                        GDTSplashAdWrapper.this.loadNativeSplash();
                        return;
                    }
                    boolean zBooleanValue = ((Boolean) GDTSplashAdWrapper.this.localParams.get(SplashAdLoader.KEY_AUTO_SHOW)).booleanValue();
                    GDTSplashAdWrapper gDTSplashAdWrapper = GDTSplashAdWrapper.this;
                    gDTSplashAdWrapper.gdtSplashAd = new GDTSplashAd(gDTSplashAdWrapper, zBooleanValue);
                    LogUtil.d(GDTSplashAdWrapper.TAG, "广告对象=" + GDTSplashAdWrapper.this.gdtSplashAd);
                    GDTSplashAdWrapper gDTSplashAdWrapper2 = GDTSplashAdWrapper.this;
                    Object objCreateListenerProxy = new GDTSplashADListenerImpl(gDTSplashAdWrapper2, (d) gDTSplashAdWrapper2.loadListener, GDTSplashAdWrapper.this.gdtSplashAd).createListenerProxy();
                    Object obj = GDTSplashAdWrapper.this.localParams.get(SplashAdLoader.KEY_SKIP_BUTTON);
                    if (obj != null && (obj instanceof View)) {
                        ((View) obj).setVisibility(4);
                    }
                    if (!TextUtils.isEmpty(GDTSplashAdWrapper.this.sdkAdInfo.getS2sb())) {
                        try {
                            S2sbResultBean s2sbResultBean = (S2sbResultBean) new Gson().fromJson(GDTSplashAdWrapper.this.sdkAdInfo.getS2sb(), S2sbResultBean.class);
                            GDTSplashAdWrapper gDTSplashAdWrapper3 = GDTSplashAdWrapper.this;
                            gDTSplashAdWrapper3.splashAD = gDTSplashAdWrapper3.reflectNewSplashAD(((SplashAdLoader) gDTSplashAdWrapper3.adLoader).getContext(), GDTSplashAdWrapper.this.sdkAdInfo.getPid(), objCreateListenerProxy, 3000, s2sbResultBean.getToken());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (GDTSplashAdWrapper.this.splashAD == null) {
                        GDTSplashAdWrapper gDTSplashAdWrapper4 = GDTSplashAdWrapper.this;
                        gDTSplashAdWrapper4.splashAD = gDTSplashAdWrapper4.reflectNewSplashAD(((SplashAdLoader) gDTSplashAdWrapper4.adLoader).getContext(), GDTSplashAdWrapper.this.sdkAdInfo.getPid(), objCreateListenerProxy, 3000, null);
                    }
                    GDTSplashAdWrapper.this.gdtSplashAd.setSplashAD(GDTSplashAdWrapper.this.splashAD);
                    GDTSplashAdWrapper.this.gdtSplashAd.setAdContainer(((SplashAdLoader) GDTSplashAdWrapper.this.adLoader).getAdContainer());
                    if (((SplashAdLoader) GDTSplashAdWrapper.this.adLoader).isSplashFullScreen()) {
                        GDTSplashAdWrapper.this.splashAD.fetchFullScreenAdOnly();
                    } else {
                        GDTSplashAdWrapper.this.splashAD.fetchAdOnly();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    @Override // com.meishu.sdk.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.splashAD != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put("expectCostPrice", Integer.valueOf(this.splashAD.getECPM()));
                    map.put("highestLossPrice", Integer.valueOf(t0.a(this.splashAD.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    this.splashAD.sendWinNotification(map);
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("winPrice", Integer.valueOf(i));
                    map2.put("lossReason", 1);
                    map2.put("adnId", "2");
                    this.splashAD.sendLossNotification(map2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNativeSplash(final NativeUnifiedADData nativeUnifiedADData, final GDTNativeSplashAd gDTNativeSplashAd) {
        String imgUrl;
        if (nativeUnifiedADData.getAdPatternType() != 4 && nativeUnifiedADData.getAdPatternType() != 1 && nativeUnifiedADData.getAdPatternType() != 3) {
            try {
                showNativeLayout(nativeUnifiedADData, gDTNativeSplashAd);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        if (!TextUtils.isEmpty(nativeUnifiedADData.getImgUrl())) {
            imgUrl = nativeUnifiedADData.getImgUrl();
        } else {
            imgUrl = (nativeUnifiedADData.getImgList() == null || nativeUnifiedADData.getImgList().size() <= 0) ? "" : nativeUnifiedADData.getImgList().get(0);
        }
        a.a(imgUrl, new x() { // from class: com.meishu.sdk.platform.gdt.splash.GDTSplashAdWrapper.4
            @Override // com.meishu.sdk.core.utils.x
            public void onFailure(IOException iOException) {
                try {
                    new GDTPlatformError(new AdError(-1, "图片加载失败"), GDTSplashAdWrapper.this.sdkAdInfo).post(GDTSplashAdWrapper.this.loadListener);
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
                        new GDTPlatformError(new AdError(-1, "图片加载失败"), GDTSplashAdWrapper.this.sdkAdInfo).post(GDTSplashAdWrapper.this.loadListener);
                        return;
                    }
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                    if (bitmapDecodeByteArray != null) {
                        GDTSplashAdWrapper.this.width = bitmapDecodeByteArray.getWidth();
                        GDTSplashAdWrapper.this.height = bitmapDecodeByteArray.getHeight();
                        GDTSplashAdWrapper.this.imgBitmap = bitmapDecodeByteArray;
                        if ((GDTSplashAdWrapper.this.width * 1.0f) / GDTSplashAdWrapper.this.height < 0.67d) {
                            GDTSplashAdWrapper.this.isVertical = true;
                        }
                    }
                    GDTSplashAdWrapper.this.bitmapBlur = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                    GDTSplashAdWrapper.this.showNativeLayout(nativeUnifiedADData, gDTNativeSplashAd);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }, true);
    }
}
