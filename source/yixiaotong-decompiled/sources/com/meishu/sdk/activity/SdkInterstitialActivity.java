package com.meishu.sdk.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.google.android.exoplayer2.ExoPlayer;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsImage;
import com.kwad.sdk.api.KsNativeAd;
import com.meishu.sdk.R;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.ad.IAd;
import com.meishu.sdk.core.bquery.d;
import com.meishu.sdk.core.bquery.i;
import com.meishu.sdk.core.bquery.j;
import com.meishu.sdk.core.domain.HttpResponse;
import com.meishu.sdk.core.exception.ErrorCodeUtil;
import com.meishu.sdk.core.safe.SafeActivity;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.safe.o;
import com.meishu.sdk.core.utils.DownloadDialogBean;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.SdkHandler;
import com.meishu.sdk.core.utils.e0;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.g0;
import com.meishu.sdk.core.utils.h;
import com.meishu.sdk.core.utils.i0;
import com.meishu.sdk.core.utils.x;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.core.view.DownloadView;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.core.view.gif.GifImageView;
import com.meishu.sdk.meishu_ad.interstitial.b;
import com.meishu.sdk.meishu_ad.interstitial.c;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.meishu.sdk.meishu_ad.nativ.e;
import com.meishu.sdk.platform.BasePlatformLoader;
import com.meishu.sdk.platform.ms.splash.ShakeResult;
import com.meishu.sdk.platform.ms.splash.ShakeUtil;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADAppMiitInfo;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import com.qq.e.comm.util.AdError;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SdkInterstitialActivity extends SafeActivity {
    private static final String TAG = "SdkInterstitialActivity";
    private static com.meishu.sdk.meishu_ad.interstitial.a adListener;
    private static BasePlatformLoader adWrapper;
    private static IAd msAd;
    private static Object sdkAd;
    private int act_type = 2;
    private ImageView adLogo;
    private LinearLayout adLogoLL;
    private TextView btn;
    private TextView cid;
    private ImageView closeImage;
    private TextView desc;
    private DownloadDialogBean downloadBean;
    private ImageView imageBg;
    private GifImageView imageView;
    private boolean isClickToClose;
    private boolean isDownloadType;
    private boolean isShake;
    private boolean isVideoAutoPlay;
    private int layout_height;
    private int layout_type;
    private int layout_width;
    private ImageView logo;
    private RelativeLayout mediaContainer;
    private RelativeLayout rl_container;
    private RelativeLayout rootView;
    private int shakeId;
    private boolean showed;
    private GifImageView startActionShakeImage;
    private TextView title;
    private TouchAdContainer touchAdContainer;
    private View view;

    /* JADX INFO: renamed from: com.meishu.sdk.activity.SdkInterstitialActivity$7, reason: invalid class name */
    public class AnonymousClass7 implements j<File> {
        public final /* synthetic */ b val$adSlot;
        public final /* synthetic */ c val$sdkAd;

        public AnonymousClass7(c cVar, b bVar) {
            this.val$sdkAd = cVar;
            this.val$adSlot = bVar;
        }

        @Override // com.meishu.sdk.core.bquery.j
        public void onFail(int i, String str) {
        }

        @Override // com.meishu.sdk.core.bquery.j
        public void onSuccess(String str, File file) {
            try {
                if (file.length() >= i0.a()) {
                    return;
                }
                this.val$sdkAd.i = System.currentTimeMillis();
                DisplayMetrics displayMetrics = SdkInterstitialActivity.this.getResources().getDisplayMetrics();
                float f = displayMetrics.widthPixels;
                float f2 = displayMetrics.density;
                int i = (int) (f - (70.0f * f2));
                int i2 = (int) (f2 * 200.0f);
                try {
                    if (SdkInterstitialActivity.this.layout_type == 2) {
                        i2 = (int) (((((double) displayMetrics.widthPixels) * 0.86d) * ((double) SdkInterstitialActivity.this.layout_height)) / ((double) SdkInterstitialActivity.this.layout_width));
                        i = (int) (((double) displayMetrics.widthPixels) * 0.86d);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                final NormalMediaView normalMediaView = new NormalMediaView(SdkInterstitialActivity.this);
                normalMediaView.setContainerWidth(i);
                normalMediaView.setContainerHeight(i2);
                normalMediaView.setPlayOnce(true);
                normalMediaView.g();
                normalMediaView.setUseTransform(false);
                normalMediaView.setFromLogoVisibility(8);
                normalMediaView.setFromLogo(null);
                normalMediaView.setNativeAdMediaListener(new e() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.7.1
                    @Override // com.meishu.sdk.meishu_ad.nativ.e
                    public void onProgressUpdate(long j, long j2) {
                    }

                    @Override // com.meishu.sdk.meishu_ad.nativ.e
                    public void onVideoComplete() {
                    }

                    @Override // com.meishu.sdk.meishu_ad.nativ.e
                    public void onVideoError() {
                        LogUtil.d(SdkInterstitialActivity.TAG, "onVideoError");
                    }

                    @Override // com.meishu.sdk.meishu_ad.nativ.e
                    public void onVideoLoaded() {
                        LogUtil.e(SdkInterstitialActivity.TAG, "onADLoaded");
                        AnonymousClass7.this.val$sdkAd.i = System.currentTimeMillis();
                        normalMediaView.post(new l() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.7.1.1
                            @Override // com.meishu.sdk.core.safe.l
                            public void safeRun() {
                                SdkInterstitialActivity.this.showed = true;
                                AnonymousClass7.this.val$sdkAd.c();
                                AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                                SdkInterstitialActivity.this.startShake(anonymousClass7.val$adSlot);
                            }
                        });
                    }

                    @Override // com.meishu.sdk.meishu_ad.nativ.e
                    public void onVideoMute() {
                    }

                    @Override // com.meishu.sdk.meishu_ad.nativ.e
                    public void onVideoOneHalf() {
                    }

                    @Override // com.meishu.sdk.meishu_ad.nativ.e
                    public void onVideoOneQuarter() {
                    }

                    @Override // com.meishu.sdk.meishu_ad.nativ.e
                    public void onVideoPause() {
                    }

                    public void onVideoReplay() {
                    }

                    @Override // com.meishu.sdk.meishu_ad.nativ.e
                    public void onVideoResume() {
                    }

                    @Override // com.meishu.sdk.meishu_ad.nativ.e
                    public void onVideoStart() {
                    }

                    @Override // com.meishu.sdk.meishu_ad.nativ.e
                    public void onVideoThreeQuarter() {
                    }

                    @Override // com.meishu.sdk.meishu_ad.nativ.e
                    public void onVideoUnmute() {
                    }
                });
                SdkInterstitialActivity.this.mediaContainer.removeAllViews();
                normalMediaView.setVideoPath(file.getAbsolutePath());
                if (this.val$adSlot.getScale_type() == 9) {
                    normalMediaView.setDisplayMode(2);
                    SdkInterstitialActivity.this.mediaContainer.addView(normalMediaView, -1, -1);
                } else {
                    normalMediaView.setDisplayMode(1);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    layoutParams.addRule(13, -1);
                    SdkInterstitialActivity.this.mediaContainer.addView(normalMediaView, layoutParams);
                }
                SdkInterstitialActivity.this.imageBg.setVisibility(0);
                ExecutorService executorService = g0.f4905a;
                g0.b.f4906a.a(new l() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.7.2
                    @Override // com.meishu.sdk.core.safe.l
                    public void safeRun() {
                        try {
                            final Bitmap videoThumb = normalMediaView.getVideoThumb();
                            if (videoThumb != null) {
                                SdkHandler.getInstance().runOnUiThread(new l() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.7.2.1
                                    @Override // com.meishu.sdk.core.safe.l
                                    public void safeRun() {
                                        try {
                                            Bitmap bitmap = videoThumb;
                                            if (bitmap != null) {
                                                Bitmap.Config config = bitmap.getConfig();
                                                Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
                                                Bitmap bitmapCopy = config == config2 ? videoThumb : videoThumb.copy(config2, true);
                                                if (bitmapCopy != null) {
                                                    SdkInterstitialActivity.this.getApplicationContext();
                                                    Bitmap bitmapA = e0.a(bitmapCopy, 25);
                                                    if (bitmapA != null) {
                                                        SdkInterstitialActivity.this.imageBg.setImageBitmap(bitmapA);
                                                    }
                                                }
                                            }
                                        } catch (Throwable th) {
                                            th.printStackTrace();
                                        }
                                    }
                                });
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
                normalMediaView.start();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void fullHeightImage(Bitmap bitmap, ImageView imageView, int i, int i2, int i3) {
        int i4;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = (i2 * 1.0f) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        bitmapCreateBitmap.getHeight();
        int width2 = bitmapCreateBitmap.getWidth();
        if (width2 < i) {
            imageView.setScaleType(ImageView.ScaleType.CENTER);
        } else {
            if (i3 == 6 || i3 == 2 || i3 == 1) {
                i4 = (width2 - i) / 2;
            } else {
                i4 = (i3 != 7 && i3 == 8) ? width2 - i : 0;
            }
            imageView.setScaleType(ImageView.ScaleType.MATRIX);
            bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, i4, 0, i, i2, (Matrix) null, false);
        }
        imageView.setImageBitmap(bitmapCreateBitmap);
    }

    private void fullWidthImage(Bitmap bitmap, GifImageView gifImageView, int i, int i2, int i3) {
        int i4;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f = (i * 1.0f) / width;
        gifImageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        matrix.postScale(f, f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        int height2 = bitmapCreateBitmap.getHeight();
        bitmapCreateBitmap.getWidth();
        if (height2 < i2) {
            gifImageView.setScaleType(ImageView.ScaleType.CENTER);
        } else {
            if (i3 == 3 || i3 == 2 || i3 == 1) {
                i4 = (height2 - i2) / 2;
            } else {
                i4 = (i3 != 4 && i3 == 5) ? height2 - i2 : 0;
            }
            gifImageView.setScaleType(ImageView.ScaleType.MATRIX);
            bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateBitmap, 0, i4, i, i2, (Matrix) null, false);
        }
        gifImageView.setImageBitmap(bitmapCreateBitmap);
    }

    private String getBDImageUrl(NativeResponse nativeResponse) {
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getImageUrl(NativeUnifiedADData nativeUnifiedADData) {
        try {
            if (TextUtils.isEmpty(nativeUnifiedADData.getImgUrl())) {
                return (nativeUnifiedADData.getImgList() == null || nativeUnifiedADData.getImgList().size() <= 0) ? "" : nativeUnifiedADData.getImgList().get(0);
            }
            return nativeUnifiedADData.getImgUrl();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private void handleBdAd() {
        final NativeResponse nativeResponse = (NativeResponse) sdkAd;
        if (nativeResponse.getAdActionType() == 2) {
            this.isDownloadType = true;
        }
        DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
        this.downloadBean = downloadDialogBean;
        downloadDialogBean.setApp_name(nativeResponse.getBrandName());
        this.downloadBean.setApp_ver(nativeResponse.getAppVersion());
        this.downloadBean.setApp_size(((nativeResponse.getAppSize() / 1024) * 1024) + "MB");
        this.downloadBean.setDeveloper(nativeResponse.getPublisher());
        this.downloadBean.setApp_permission_url(nativeResponse.getAppPermissionLink());
        this.downloadBean.setApp_private_agreement(nativeResponse.getAppPrivacyLink());
        this.downloadBean.setApp_intro(nativeResponse.getDesc());
        this.title.setText(nativeResponse.getTitle());
        this.desc.setText(nativeResponse.getDesc());
        i iVar = new i((Activity) this);
        if (!TextUtils.isEmpty(nativeResponse.getBaiduLogoUrl())) {
            iVar.d = this.adLogo;
            iVar.a(nativeResponse.getBaiduLogoUrl(), false);
        }
        if (!TextUtils.isEmpty(nativeResponse.getIconUrl())) {
            iVar.d = this.logo;
            iVar.a(nativeResponse.getIconUrl(), false);
        }
        if (nativeResponse.getAdActionType() != 2) {
            this.btn.setText("点击查看详情");
        } else {
            this.btn.setText("点击下载");
        }
        try {
            if (nativeResponse.getMaterialType().equals(NativeResponse.MaterialType.VIDEO)) {
                ExecutorService executorService = g0.f4905a;
                g0.b.f4906a.a(new l() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.12
                    @Override // com.meishu.sdk.core.safe.l
                    public void safeRun() {
                        try {
                            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                            mediaMetadataRetriever.setDataSource(nativeResponse.getVideoUrl());
                            final Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime();
                            if (frameAtTime != null) {
                                SdkHandler.getInstance().runOnUiThread(new l() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.12.1
                                    @Override // com.meishu.sdk.core.safe.l
                                    public void safeRun() {
                                        SdkInterstitialActivity.this.imageView.setImageBitmap(frameAtTime);
                                    }
                                });
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                });
            } else {
                String bDImageUrl = getBDImageUrl(nativeResponse);
                iVar.d = this.imageView;
                iVar.a(bDImageUrl, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.rl_container);
        nativeResponse.registerViewForInteraction(this.rl_container, arrayList, null, new NativeResponse.AdInteractionListener() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.13
            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActReward(int i) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void adActRewardSuccess() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposed() {
                try {
                    if (SdkInterstitialActivity.this.showed) {
                        return;
                    }
                    if (SdkInterstitialActivity.adWrapper.getLoaderListener() != null) {
                        SdkInterstitialActivity.adWrapper.getLoaderListener().onAdExposure();
                    }
                    if (SdkInterstitialActivity.msAd != null && SdkInterstitialActivity.msAd.getInteractionListener() != null) {
                        SdkInterstitialActivity.msAd.getInteractionListener().onAdExposure();
                    }
                    SdkInterstitialActivity.this.showed = true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADExposureFailed(int i) {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onADStatusChanged() {
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdClick() {
                try {
                    LogUtil.d(SdkInterstitialActivity.TAG, "send onAdClicked");
                    if (SdkInterstitialActivity.adWrapper != null && SdkInterstitialActivity.adWrapper.getSdkAdInfo() != null && SdkInterstitialActivity.msAd != null) {
                        z.a(SdkInterstitialActivity.adWrapper.getContext(), f.a(SdkInterstitialActivity.adWrapper.getSdkAdInfo().getClk(), SdkInterstitialActivity.msAd), new com.meishu.sdk.core.utils.i());
                        SdkInterstitialActivity.adWrapper.getSdkAdInfo().getMsLoadedTime();
                        SdkInterstitialActivity.adWrapper.getAdLoader().getPosId();
                    }
                    if (SdkInterstitialActivity.msAd == null || SdkInterstitialActivity.msAd.getInteractionListener() == null) {
                        return;
                    }
                    SdkInterstitialActivity.msAd.getInteractionListener().onAdClicked();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
            public void onAdUnionClick() {
            }
        });
    }

    private void handleGDTAd() {
        NativeUnifiedADData nativeUnifiedADData = (NativeUnifiedADData) sdkAd;
        NativeUnifiedADAppMiitInfo appMiitInfo = nativeUnifiedADData.getAppMiitInfo();
        if (nativeUnifiedADData.isAppAd()) {
            this.isDownloadType = true;
        }
        if (appMiitInfo != null) {
            DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
            this.downloadBean = downloadDialogBean;
            downloadDialogBean.setApp_name(appMiitInfo.getAppName());
            this.downloadBean.setApp_ver(appMiitInfo.getVersionName());
            this.downloadBean.setApp_size(((appMiitInfo.getPackageSizeBytes() / 1024) * 1024) + "MB");
            this.downloadBean.setDeveloper(appMiitInfo.getAuthorName());
            this.downloadBean.setApp_permission_url(appMiitInfo.getPermissionsUrl());
            this.downloadBean.setApp_private_agreement(appMiitInfo.getPrivacyAgreement());
        }
        nativeUnifiedADData.getPictureWidth();
        nativeUnifiedADData.getPictureHeight();
        this.title.setText(nativeUnifiedADData.getTitle());
        this.desc.setText(nativeUnifiedADData.getDesc());
        float f = getResources().getDisplayMetrics().density;
        new ArrayList().add(this.mediaContainer);
        i iVar = new i((Activity) this);
        if (!TextUtils.isEmpty(nativeUnifiedADData.getIconUrl())) {
            iVar.d = this.logo;
            iVar.a(nativeUnifiedADData.getIconUrl(), false);
        }
        if (nativeUnifiedADData.isAppAd()) {
            this.btn.setText("点击下载");
        } else {
            this.btn.setText("点击查看详情");
        }
        this.adLogo.setImageResource(R.drawable.ms_gdt_logo);
        NativeAdContainer nativeAdContainer = new NativeAdContainer(this);
        ViewGroup viewGroup = (ViewGroup) this.rl_container.getParent();
        if (viewGroup != null) {
            ViewGroup.LayoutParams layoutParams = this.rl_container.getLayoutParams();
            viewGroup.removeView(this.rl_container);
            nativeAdContainer.addView(this.rl_container, new ViewGroup.LayoutParams(-1, -2));
            viewGroup.addView(nativeAdContainer, layoutParams);
        }
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(0, 0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.rl_container);
        arrayList.add(this.btn);
        nativeUnifiedADData.setNativeAdEventListener(new NativeADEventListener() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.9
            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADClicked() {
                try {
                    if (SdkInterstitialActivity.adWrapper != null && SdkInterstitialActivity.adWrapper.getSdkAdInfo() != null && SdkInterstitialActivity.msAd != null) {
                        LogUtil.d(SdkInterstitialActivity.TAG, "send onADClicked");
                        z.a(StubApp.getOrigApplicationContext(SdkInterstitialActivity.this.getApplicationContext()), f.a(SdkInterstitialActivity.adWrapper.getSdkAdInfo().getClk(), SdkInterstitialActivity.msAd), new com.meishu.sdk.core.utils.i());
                        SdkInterstitialActivity.adWrapper.getSdkAdInfo().getMsLoadedTime();
                        SdkInterstitialActivity.adWrapper.getAdLoader().getPosId();
                    }
                    if (SdkInterstitialActivity.msAd == null || SdkInterstitialActivity.msAd.getInteractionListener() == null) {
                        return;
                    }
                    SdkInterstitialActivity.msAd.getInteractionListener().onAdClicked();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADError(AdError adError) {
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADExposed() {
                try {
                    if (SdkInterstitialActivity.adWrapper == null || SdkInterstitialActivity.adWrapper.getLoaderListener() == null || SdkInterstitialActivity.this.showed) {
                        return;
                    }
                    SdkInterstitialActivity.this.showed = true;
                    SdkInterstitialActivity.adWrapper.getLoaderListener().onAdExposure();
                    if (SdkInterstitialActivity.msAd == null || SdkInterstitialActivity.msAd.getInteractionListener() == null) {
                        return;
                    }
                    SdkInterstitialActivity.msAd.getInteractionListener().onAdExposure();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.qq.e.ads.nativ.NativeADEventListener
            public void onADStatusChanged() {
            }
        });
        nativeUnifiedADData.bindAdToView(this, nativeAdContainer, layoutParams2, arrayList);
        if (nativeUnifiedADData.getAdPatternType() != 2) {
            String imageUrl = getImageUrl(nativeUnifiedADData);
            if (TextUtils.isEmpty(imageUrl)) {
                return;
            }
            iVar.d = this.imageView;
            iVar.a(imageUrl, false);
            return;
        }
        this.mediaContainer.removeAllViews();
        MediaView mediaView = new MediaView(this);
        ViewGroup.LayoutParams layoutParams3 = mediaView.getLayoutParams();
        if (layoutParams3 == null) {
            layoutParams3 = new ViewGroup.LayoutParams(-1, -2);
        }
        layoutParams3.width = -1;
        layoutParams3.height = -2;
        this.mediaContainer.addView(mediaView, layoutParams3);
        VideoOption.Builder builder = new VideoOption.Builder();
        builder.setAutoPlayPolicy(this.isVideoAutoPlay ? 1 : 2);
        builder.setAutoPlayMuted(true);
        builder.setNeedCoverImage(true);
        builder.setNeedProgressBar(true);
        builder.setEnableDetailPage(true);
        builder.setEnableUserControl(false);
        nativeUnifiedADData.bindMediaView(mediaView, builder.build(), new NativeADMediaListener() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.10
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
            public void onVideoLoaded(int i) {
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

    private void handleKsAd() {
        KsNativeAd ksNativeAd = (KsNativeAd) sdkAd;
        if (ksNativeAd.getInteractionType() == 1) {
            this.isDownloadType = true;
        }
        DownloadDialogBean downloadDialogBean = new DownloadDialogBean();
        this.downloadBean = downloadDialogBean;
        downloadDialogBean.setApp_name(ksNativeAd.getAppName());
        this.downloadBean.setApp_ver(ksNativeAd.getAppVersion());
        this.downloadBean.setApp_size(((ksNativeAd.getAppPackageSize() / 1024) * 1024) + "MB");
        this.downloadBean.setDeveloper(ksNativeAd.getCorporationName());
        this.downloadBean.setApp_permission_url(ksNativeAd.getPermissionInfoUrl());
        this.downloadBean.setApp_private_agreement(ksNativeAd.getAppPrivacyUrl());
        this.downloadBean.setApp_intro(ksNativeAd.getAdDescription());
        this.title.setVisibility(8);
        this.desc.setText(ksNativeAd.getAdDescription());
        i iVar = new i((Activity) this);
        iVar.d = this.logo;
        int i = 0;
        iVar.a(ksNativeAd.getAppIconUrl(), false);
        iVar.d = this.adLogo;
        iVar.c(R.drawable.ms_ksad_sdk_logo);
        if (ksNativeAd.getInteractionType() == 1) {
            this.btn.setText("点击下载");
        } else {
            this.btn.setText("点击查看详情");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.rl_container);
        arrayList.add(this.btn);
        ksNativeAd.registerViewForInteraction(this.rl_container, arrayList, new KsNativeAd.AdInteractionListener() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.11
            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                return false;
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdClicked(View view, KsNativeAd ksNativeAd2) {
                try {
                    LogUtil.d(SdkInterstitialActivity.TAG, "send onAdClicked");
                    if (SdkInterstitialActivity.adWrapper != null && SdkInterstitialActivity.adWrapper.getSdkAdInfo() != null && SdkInterstitialActivity.msAd != null) {
                        z.a(SdkInterstitialActivity.adWrapper.getContext(), f.a(SdkInterstitialActivity.adWrapper.getSdkAdInfo().getClk(), SdkInterstitialActivity.msAd), new com.meishu.sdk.core.utils.i());
                        SdkInterstitialActivity.adWrapper.getSdkAdInfo().getMsLoadedTime();
                        SdkInterstitialActivity.adWrapper.getAdLoader().getPosId();
                    }
                    if (SdkInterstitialActivity.msAd == null || SdkInterstitialActivity.msAd.getInteractionListener() == null) {
                        return;
                    }
                    SdkInterstitialActivity.msAd.getInteractionListener().onAdClicked();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onAdShow(KsNativeAd ksNativeAd2) {
                try {
                    if (SdkInterstitialActivity.this.showed) {
                        return;
                    }
                    if (SdkInterstitialActivity.adWrapper.getLoaderListener() != null) {
                        SdkInterstitialActivity.adWrapper.getLoaderListener().onAdExposure();
                    }
                    if (SdkInterstitialActivity.msAd != null && SdkInterstitialActivity.msAd.getInteractionListener() != null) {
                        SdkInterstitialActivity.msAd.getInteractionListener().onAdExposure();
                    }
                    SdkInterstitialActivity.this.showed = true;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogDismiss() {
            }

            @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
            public void onDownloadTipsDialogShow() {
            }
        });
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        float f2 = displayMetrics.widthPixels;
        int i2 = (int) (f2 - (70.0f * f));
        if (this.layout_type == 2) {
            i2 = (int) (f2 - (f * 84.0f));
        }
        if (ksNativeAd.getMaterialType() == 1) {
            View videoView = ksNativeAd.getVideoView(this, new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).build());
            if (videoView != null) {
                this.mediaContainer.removeAllViews();
                int videoWidth = ksNativeAd.getVideoWidth();
                int videoHeight = ksNativeAd.getVideoHeight();
                if (videoWidth > 0 && videoHeight > 0) {
                    i = (videoHeight * i2) / videoWidth;
                }
                this.mediaContainer.addView(videoView, -1, i);
                return;
            }
            return;
        }
        List<KsImage> imageList = ksNativeAd.getImageList();
        if (imageList == null || imageList.size() <= 0) {
            return;
        }
        KsImage ksImage = imageList.get(0);
        int width = ksImage.getWidth();
        int height = ksImage.getHeight();
        String imageUrl = imageList.get(0).getImageUrl();
        iVar.d = this.imageView;
        iVar.a(imageUrl, false);
        if (width > 0 && height > 0) {
            i = (height * i2) / width;
        }
        ViewGroup.LayoutParams layoutParams = this.imageView.getLayoutParams();
        layoutParams.height = i;
        layoutParams.width = -1;
        this.imageView.setLayoutParams(layoutParams);
    }

    private void handleMsAd() {
        ShakeUtil.getInstance().e();
        final c cVar = (c) sdkAd;
        final b bVarB = cVar.a();
        int act_type = bVarB.getAct_type();
        if ((act_type & 1) != 1 && (act_type & 2) != 2) {
            bVarB.setAct_type(act_type | 1);
        }
        AdType adType = AdType.INTERSTITIAL;
        adType.value();
        h.a();
        int iA = h.a(bVarB.getAct_type(), adType.value());
        bVarB.setAct_type(iA);
        this.act_type = iA;
        if (cVar.getInteractionType() == 1) {
            this.isDownloadType = true;
        }
        this.downloadBean = DownloadView.toBean(bVarB);
        i iVar = new i((Activity) this);
        if (this.layout_type == 1) {
            if (TextUtils.isEmpty(bVarB.f5021a)) {
                this.title.setText("");
                this.title.setVisibility(8);
            } else {
                this.title.setVisibility(0);
                this.title.setText(bVarB.f5021a);
            }
            if (TextUtils.isEmpty(bVarB.getDesc())) {
                this.desc.setVisibility(8);
                this.desc.setText("");
            } else {
                this.desc.setVisibility(0);
                this.desc.setText(bVarB.getDesc());
            }
        }
        if (this.logo != null) {
            if (TextUtils.isEmpty(bVarB.getIconUrl())) {
                iVar.d = this.logo;
                iVar.d(8);
            } else {
                iVar.d = this.logo;
                iVar.d(0);
                iVar.d = this.logo;
                iVar.a(bVarB.getIconUrl(), false);
            }
        }
        this.adLogoLL.setBackground(getResources().getDrawable(R.drawable.ms_black_oval_gray));
        if (TextUtils.isEmpty(bVarB.getFromLogo())) {
            iVar.d = this.adLogo;
            Drawable drawable = getResources().getDrawable(R.drawable.ms_ad);
            View view = iVar.d;
            if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(drawable);
            }
        } else {
            iVar.d = this.adLogo;
            iVar.a(bVarB.getFromLogo(), false);
        }
        if (!TextUtils.isEmpty(bVarB.getCid())) {
            this.cid.setText(bVarB.getCid());
        }
        LogUtil.d(TAG, a.a("adSlot.getAdPatternType()=").append(bVarB.getAdPatternType()).toString());
        if (cVar.g == 0) {
            cVar.g = System.currentTimeMillis();
        }
        if (bVarB.getAdPatternType() == 2) {
            loadNativeVideo(iVar, bVarB, cVar);
        } else {
            com.meishu.sdk.core.cache.a.a(bVarB.getImageUrls()[0], new x() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.3
                @Override // com.meishu.sdk.core.utils.x
                public void onFailure(IOException iOException) {
                    if (SdkInterstitialActivity.adListener != null) {
                        ((com.meishu.sdk.platform.ms.interstitial.a) SdkInterstitialActivity.adListener).onAdRenderFail("图片加载失败", -1);
                    }
                }

                @Override // com.meishu.sdk.core.utils.x
                public void onResponse(HttpResponse<byte[]> httpResponse) throws IOException {
                    byte[] responseBody;
                    try {
                        if (!httpResponse.isSuccessful() || (responseBody = httpResponse.getResponseBody()) == null || responseBody.length <= 0) {
                            return;
                        }
                        if (!SdkInterstitialActivity.this.isGif(responseBody)) {
                            Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                            if (bitmapDecodeByteArray != null) {
                                SdkInterstitialActivity.this.setImageShowType(bVarB.getScale_type(), bitmapDecodeByteArray, SdkInterstitialActivity.this.imageView);
                            } else if (SdkInterstitialActivity.adListener != null) {
                                ((com.meishu.sdk.platform.ms.interstitial.a) SdkInterstitialActivity.adListener).onAdRenderFail("bitmap加载失败", ErrorCodeUtil.RES_LOAD_ERROR.intValue());
                            }
                            try {
                                Bitmap bitmapDecodeByteArray2 = BitmapFactory.decodeByteArray(responseBody, 0, responseBody.length);
                                if (bitmapDecodeByteArray2 != null) {
                                    SdkInterstitialActivity.this.getApplicationContext();
                                    SdkInterstitialActivity.this.imageBg.setImageBitmap(e0.a(bitmapDecodeByteArray2, 25));
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        } else if (SdkInterstitialActivity.this.imageView != null) {
                            SdkInterstitialActivity.this.imageView.setBytes(responseBody);
                            SdkInterstitialActivity.this.imageView.startAnimation();
                        }
                        cVar.i = System.currentTimeMillis();
                        SdkInterstitialActivity.this.view.post(new l() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.3.1
                            @Override // com.meishu.sdk.core.safe.l
                            public void safeRun() {
                                SdkInterstitialActivity.this.showed = true;
                                cVar.c();
                                AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                SdkInterstitialActivity.this.startShake(bVarB);
                            }
                        });
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
            }, true);
        }
        cVar.setAdView(this.rootView);
        if ((bVarB.getAct_type() & 1) == 1) {
            this.rl_container.setOnClickListener(new o() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.4
                @Override // com.meishu.sdk.core.safe.o
                public void safeOnClick(View view2) {
                    if (SdkInterstitialActivity.this.showed) {
                        if (SdkInterstitialActivity.msAd != null && SdkInterstitialActivity.msAd.getInteractionListener() != null && bVarB.getCbc() == 0) {
                            SdkInterstitialActivity.msAd.getInteractionListener().onAdClicked();
                        }
                        bVarB.setClkActType(1);
                        try {
                            if (SdkInterstitialActivity.this.isClickToClose) {
                                cVar.a().setAdClosed(true);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        f.a((com.meishu.sdk.platform.ms.c) cVar, true);
                        if (SdkInterstitialActivity.this.isClickToClose) {
                            SdkInterstitialActivity.this.finish();
                            if (SdkInterstitialActivity.msAd == null || SdkInterstitialActivity.msAd.getInteractionListener() == null) {
                                return;
                            }
                            SdkInterstitialActivity.msAd.getInteractionListener().onAdClosed();
                        }
                    }
                }
            });
        } else if ((bVarB.getAct_type() & 2) == 2) {
            this.btn.setOnClickListener(new o() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.5
                @Override // com.meishu.sdk.core.safe.o
                public void safeOnClick(View view2) {
                    if (SdkInterstitialActivity.this.showed) {
                        if (SdkInterstitialActivity.msAd != null && SdkInterstitialActivity.msAd.getInteractionListener() != null && bVarB.getCbc() == 0) {
                            SdkInterstitialActivity.msAd.getInteractionListener().onAdClicked();
                        }
                        bVarB.setClkActType(2);
                        f.a((com.meishu.sdk.platform.ms.c) cVar, true);
                        if (SdkInterstitialActivity.this.isClickToClose) {
                            SdkInterstitialActivity.this.finish();
                            if (SdkInterstitialActivity.msAd == null || SdkInterstitialActivity.msAd.getInteractionListener() == null) {
                                return;
                            }
                            SdkInterstitialActivity.msAd.getInteractionListener().onAdClosed();
                        }
                    }
                }
            });
        }
    }

    private void initView() {
        TouchAdContainer touchAdContainer;
        try {
            this.touchAdContainer = (TouchAdContainer) findViewById(R.id.ms_activity_sdk_interstitial_touchAdContainer);
            this.startActionShakeImage = (GifImageView) findViewById(R.id.ms_action_shakeImage);
            this.mediaContainer = (RelativeLayout) findViewById(R.id.ms_activity_sdk_interstitial_mediaContainer);
            this.imageView = (GifImageView) findViewById(R.id.ms_activity_sdk_interstitial_imageview);
            this.imageBg = (ImageView) findViewById(R.id.ms_activity_sdk_interstitial_imageBg);
            this.closeImage = (ImageView) findViewById(R.id.ms_activity_sdk_interstitial_cacel);
            this.adLogo = (ImageView) findViewById(R.id.ms_activity_sdk_interstitial_adLogo);
            this.cid = (TextView) findViewById(R.id.ms_layout_native_interstitial_cid);
            this.rl_container = (RelativeLayout) findViewById(R.id.ms_activity_sdk_interstitial_rl_container);
            this.adLogoLL = (LinearLayout) findViewById(R.id.ms_activity_sdk_interstitial_adLogoLL);
            this.logo = (ImageView) findViewById(R.id.ms_activity_sdk_interstitial_logo);
            this.title = (TextView) findViewById(R.id.ms_activity_sdk_interstitial_title);
            this.desc = (TextView) findViewById(R.id.ms_activity_sdk_interstitial_desc);
            this.btn = (TextView) findViewById(R.id.ms_activity_sdk_interstitial_btn);
            IAd iAd = msAd;
            if (iAd != null && (touchAdContainer = this.touchAdContainer) != null) {
                touchAdContainer.setTouchPositionListener(new TouchPositionListener(iAd));
            }
            this.closeImage.setOnClickListener(new o() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.1
                @Override // com.meishu.sdk.core.safe.o
                public void safeOnClick(View view) {
                    SdkInterstitialActivity.this.finish();
                    if (SdkInterstitialActivity.msAd == null || SdkInterstitialActivity.msAd.getInteractionListener() == null) {
                        return;
                    }
                    SdkInterstitialActivity.msAd.getInteractionListener().onAdClosed();
                }
            });
            this.adLogoLL.post(new Runnable() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.2
                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        SdkInterstitialActivity sdkInterstitialActivity = SdkInterstitialActivity.this;
                        int navigationBarHeight = sdkInterstitialActivity.getNavigationBarHeight(sdkInterstitialActivity);
                        if (navigationBarHeight > 0) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SdkInterstitialActivity.this.adLogoLL.getLayoutParams();
                            int i = navigationBarHeight + 15;
                            layoutParams.bottomMargin = i;
                            SdkInterstitialActivity.this.adLogoLL.setLayoutParams(layoutParams);
                            RelativeLayout relativeLayout = (RelativeLayout) SdkInterstitialActivity.this.findViewById(R.id.ms_activity_sdk_interstitial_download_info_l);
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) relativeLayout.getLayoutParams();
                            layoutParams2.bottomMargin = i;
                            relativeLayout.setLayoutParams(layoutParams2);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (this.layout_type == 2) {
                DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                if (this.layout_width > 0 && this.layout_height > 0) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.touchAdContainer.getLayoutParams();
                    double d = ((double) displayMetrics.widthPixels) * 0.86d;
                    layoutParams.width = (int) d;
                    layoutParams.height = (int) ((d * ((double) this.layout_height)) / ((double) this.layout_width));
                    int i = (int) (((double) displayMetrics.heightPixels) * 0.07d);
                    layoutParams.topMargin = i;
                    layoutParams.bottomMargin = i;
                    this.touchAdContainer.setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            handleSdk();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void loadNativeVideo(i iVar, b bVar, c cVar) {
        String str = bVar.getImageUrls()[0];
        AnonymousClass7 anonymousClass7 = new AnonymousClass7(cVar, bVar);
        iVar.getClass();
        iVar.a(str, 86400000, true, new d(iVar, anonymousClass7));
    }

    public static void setAdWrapper(BasePlatformLoader basePlatformLoader) {
        adWrapper = basePlatformLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageShowType(int i, Bitmap bitmap, GifImageView gifImageView) {
        int i2;
        int i3;
        int i4;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i5 = displayMetrics.widthPixels;
        float f = displayMetrics.density;
        int i6 = (int) (i5 - (70.0f * f));
        int i7 = (int) (f * 200.0f);
        try {
            if (this.layout_type == 2) {
                double d = ((double) i5) * 0.86d;
                i2 = (int) ((((double) this.layout_height) * d) / ((double) this.layout_width));
                i6 = (int) d;
                try {
                    i7 = (int) (((double) displayMetrics.heightPixels) * 0.86d);
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                }
                i4 = i6;
                i3 = i7;
                i7 = i2;
            } else {
                i4 = i6;
                i3 = i7;
            }
        } catch (Exception e2) {
            e = e2;
            i2 = i7;
        }
        if (i7 < i3) {
            gifImageView.setImageBitmap(bitmap);
            return;
        }
        try {
            switch (i) {
                case 1:
                    if ((bitmap.getHeight() * 1.0f) / i3 <= (bitmap.getWidth() * 1.0f) / i4) {
                        fullHeightImage(bitmap, gifImageView, i4, i3, i);
                    } else {
                        fullWidthImage(bitmap, gifImageView, i4, i3, i);
                    }
                    break;
                case 2:
                default:
                    if ((bitmap.getWidth() * 1.0f) / i4 <= (bitmap.getHeight() * 1.0f) / i3) {
                        fullHeightImage(bitmap, gifImageView, i4, i3, i);
                    } else {
                        fullWidthImage(bitmap, gifImageView, i4, i3, i);
                    }
                    break;
                case 3:
                case 4:
                case 5:
                    fullWidthImage(bitmap, gifImageView, i4, i3, i);
                    break;
                case 6:
                case 7:
                case 8:
                    fullHeightImage(bitmap, gifImageView, i4, i3, i);
                    break;
                case 9:
                    gifImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    gifImageView.setImageBitmap(bitmap);
                    break;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            gifImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            gifImageView.setImageBitmap(bitmap);
        }
    }

    public static void setMsAd(IAd iAd) {
        msAd = iAd;
    }

    public static void setSdkAd(Object obj) {
        sdkAd = obj;
    }

    private void showShakeInButton() {
        Drawable drawable = getResources().getDrawable(R.drawable.ms_shake_angle);
        drawable.setBounds(0, 0, 100, 100);
        this.btn.setPadding(20, 0, 60, 0);
        this.btn.setCompoundDrawables(drawable, null, null, null);
    }

    private void showStartShakeImage() {
        this.startActionShakeImage.setVisibility(0);
        byte[] imageBytes = getImageBytes(this, R.raw.ms_new_shake);
        if (imageBytes != null && imageBytes.length > 0) {
            this.startActionShakeImage.setBytes(imageBytes, 1);
            this.startActionShakeImage.startAnimation();
        }
        new Handler().postDelayed(new l() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.6
            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                SdkInterstitialActivity.this.startActionShakeImage.clear();
                SdkInterstitialActivity.this.startActionShakeImage.setVisibility(8);
            }
        }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startShake(final b bVar) {
        this.rootView.post(new l() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.8
            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                try {
                    if (h.c(bVar.getAct_type())) {
                        SdkInterstitialActivity.this.isShake = true;
                        int power_index = bVar.getPower_index();
                        int power_index2 = bVar.getPower_index2();
                        SdkInterstitialActivity.this.shakeId = ShakeUtil.getInstance().b();
                        int iB = h.b(bVar.getAct_type());
                        final long jCurrentTimeMillis = System.currentTimeMillis();
                        ShakeUtil.getInstance().a(bVar.getPosId(), bVar.getLoadedTime(), bVar.getDclk());
                        ShakeUtil.getInstance().a(power_index2, power_index, iB, bVar.getPower_delay(), bVar.getPower_count(), SdkInterstitialActivity.this.shakeId, bVar.getEcpm(), new ShakeUtil.c() { // from class: com.meishu.sdk.activity.SdkInterstitialActivity.8.1
                            @Override // com.meishu.sdk.platform.ms.splash.ShakeUtil.c
                            public void onShake(int i, boolean z, int i2, ShakeResult shakeResult) {
                                ShakeUtil.getInstance().a(SdkInterstitialActivity.this.shakeId);
                                if (SdkInterstitialActivity.msAd != null && SdkInterstitialActivity.msAd.getInteractionListener() != null && bVar.getCbc() == 0) {
                                    SdkInterstitialActivity.msAd.getInteractionListener().onAdClicked();
                                }
                                if (shakeResult != null) {
                                    shakeResult.setTotalTurnTime(System.currentTimeMillis() - jCurrentTimeMillis);
                                }
                                c cVar = (c) SdkInterstitialActivity.sdkAd;
                                b bVarB = cVar.a();
                                bVarB.setClkActType(i);
                                bVarB.setClkPower(i2);
                                bVarB.setShakeResult(shakeResult);
                                try {
                                    if (SdkInterstitialActivity.this.isClickToClose) {
                                        cVar.a().setAdClosed(true);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                f.a(cVar, i2 >= 50);
                                if (SdkInterstitialActivity.this.isClickToClose) {
                                    SdkInterstitialActivity.this.finish();
                                    if (SdkInterstitialActivity.msAd == null || SdkInterstitialActivity.msAd.getInteractionListener() == null) {
                                        return;
                                    }
                                    SdkInterstitialActivity.msAd.getInteractionListener().onAdClosed();
                                }
                            }
                        });
                        ShakeUtil.getInstance().a(true);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public int getNavigationBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void handleDownloadView() {
        try {
            LogUtil.d(TAG, "handleDownloadView: interactionType=" + this.isDownloadType);
            if (this.isDownloadType) {
                TextView textView = (TextView) findViewById(R.id.ms_download_layer_textview);
                textView.setVisibility(0);
                DownloadView.bindClickableDownloadInfo(textView, this.downloadBean);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        initView();
        super.onConfigurationChanged(configuration);
    }

    @Override // com.meishu.sdk.core.safe.SafeActivity
    public void safeOnCreate(Bundle bundle) {
        super.safeOnCreate(bundle);
        setContentView(R.layout.ms_activity_sdk_interstitial);
        try {
            getWindow().getDecorView().setSystemUiVisibility(1792);
            getWindow().setNavigationBarColor(0);
            getWindow().setStatusBarColor(0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Intent intent = getIntent();
        this.isVideoAutoPlay = intent.getBooleanExtra("isVideoAutoPlay", true);
        this.isClickToClose = intent.getBooleanExtra("isClickToClose", false);
        this.act_type = intent.getIntExtra("act_type", 2);
        this.layout_type = intent.getIntExtra("layout_type", 1);
        this.layout_width = intent.getIntExtra("layout_width", 0);
        this.layout_height = intent.getIntExtra("layout_height", 0);
        this.rootView = (RelativeLayout) findViewById(R.id.ms_activity_sdk_interstitial_rootView);
        this.view = View.inflate(this, R.layout.ms_layout_sdk_interstitial_1, null);
        if (this.layout_type == 2) {
            this.view = View.inflate(this, R.layout.ms_layout_sdk_interstitial_2, null);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.rootView.addView(this.view, layoutParams);
        initView();
    }

    @Override // com.meishu.sdk.core.safe.SafeActivity
    public void safeOnDestroy() {
        super.safeOnDestroy();
        sdkAd = null;
        adWrapper = null;
        msAd = null;
        adListener = null;
        ShakeUtil.getInstance().a(this.shakeId);
    }

    @Override // com.meishu.sdk.core.safe.SafeActivity
    public void safeOnPause() {
        super.safeOnPause();
        if (this.isShake) {
            ShakeUtil.getInstance().e();
        }
    }

    @Override // com.meishu.sdk.core.safe.SafeActivity
    public void safeOnResume() {
        super.safeOnResume();
        if (this.isShake) {
            ShakeUtil.getInstance().f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isGif(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        System.arraycopy(bArr, 0, bArr2, 0, 4);
        return new BigInteger(1, bArr2).toString(16).startsWith(com.huawei.openalliance.ad.constant.x.aw);
    }

    private void handleSdk() {
        Object obj = sdkAd;
        if (obj != null) {
            try {
                if (obj instanceof NativeUnifiedADData) {
                    handleGDTAd();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                if (sdkAd instanceof KsNativeAd) {
                    handleKsAd();
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                if (sdkAd instanceof c) {
                    handleMsAd();
                }
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
            try {
                if (sdkAd instanceof NativeResponse) {
                    handleBdAd();
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            handleButton();
            handleDownloadView();
        }
    }

    public static void setAdListener(com.meishu.sdk.meishu_ad.interstitial.a aVar) {
        try {
            adListener = aVar;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleButton() {
        try {
            int i = this.act_type;
            if ((i & 4) != 4 && (i & 64) != 64) {
                if (h.e(i)) {
                    showShakeInButton();
                    if (this.isDownloadType) {
                        this.btn.setText("扭一扭或点击下载三方应用");
                    } else {
                        this.btn.setText("扭一扭或点击查看详情");
                    }
                } else if (this.isDownloadType) {
                    this.btn.setText("点击下载三方应用");
                } else {
                    this.btn.setText("点击查看详情");
                }
            } else {
                showShakeInButton();
                if (this.isDownloadType) {
                    this.btn.setText("摇一摇或点击下载三方应用");
                } else {
                    this.btn.setText("摇一摇或点击查看详情");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
