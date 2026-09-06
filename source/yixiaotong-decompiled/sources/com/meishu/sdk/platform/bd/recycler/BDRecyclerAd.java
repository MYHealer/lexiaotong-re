package com.meishu.sdk.platform.bd.recycler;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.mobads.sdk.api.FeedNativeView;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.a;
import com.meishu.sdk.core.ad.recycler.DownloadStatusListener;
import com.meishu.sdk.core.ad.recycler.ExpressMediaListener;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.ad.recycler.RecyclerMixAdLoader;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.ad.recycler.d;
import com.meishu.sdk.core.bquery.i;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.utils.z;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.meishu_ad.n0;
import com.meishu.sdk.meishu_ad.nativ.NormalMediaView;
import com.meishu.sdk.meishu_ad.nativ.b;
import com.meishu.sdk.meishu_ad.nativ.e;
import com.meishu.sdk.platform.ms.recycler.MsCustomVideo;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BDRecyclerAd extends a implements RecyclerAdData {
    private static final String TAG = "BDRecyclerAd";
    private FeedNativeView adView;
    private BDRecyclerLoader adWrapper;
    private NativeResponse bdAd;
    private volatile boolean hasExposed;
    private volatile int index;
    private boolean isExposure;
    private volatile boolean isImpl;
    private e nativeAdMediaListener;
    private NormalMediaView normalMediaView;
    private RecyclerAdMediaListener recyclerAdMediaListener;
    private RecylcerAdInteractionListener recylcerAdInteractionListener;

    /* JADX INFO: renamed from: com.meishu.sdk.platform.bd.recycler.BDRecyclerAd$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType;

        static {
            int[] iArr = new int[NativeResponse.MaterialType.values().length];
            $SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType = iArr;
            try {
                iArr[NativeResponse.MaterialType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType[NativeResponse.MaterialType.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public BDRecyclerAd(NativeResponse nativeResponse, FeedNativeView feedNativeView, final BDRecyclerLoader bDRecyclerLoader) {
        super(bDRecyclerLoader, MSAdConfig.PLATFORM_BD);
        this.index = 0;
        this.isImpl = false;
        this.nativeAdMediaListener = new e() { // from class: com.meishu.sdk.platform.bd.recycler.BDRecyclerAd.3
            @Override // com.meishu.sdk.meishu_ad.nativ.e
            public void onProgressUpdate(long j, long j2) {
            }

            @Override // com.meishu.sdk.meishu_ad.nativ.e
            public void onVideoComplete() {
                try {
                    if (BDRecyclerAd.this.recyclerAdMediaListener != null) {
                        BDRecyclerAd.this.recyclerAdMediaListener.onVideoCompleted();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.meishu.sdk.meishu_ad.nativ.e
            public void onVideoError() {
                try {
                    if (BDRecyclerAd.this.adWrapper.getLoaderListener() != null) {
                        BDRecyclerAd.this.adWrapper.getLoaderListener().onAdRenderFail("视频加载失败", -1);
                    }
                    if (BDRecyclerAd.this.recyclerAdMediaListener != null) {
                        BDRecyclerAd.this.recyclerAdMediaListener.onVideoError();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.meishu.sdk.meishu_ad.nativ.e
            public void onVideoLoaded() {
                try {
                    BDRecyclerAd.this.normalMediaView.c();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
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
                try {
                    if (BDRecyclerAd.this.recyclerAdMediaListener != null) {
                        BDRecyclerAd.this.recyclerAdMediaListener.onVideoPause();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            public void onVideoReplay() {
            }

            @Override // com.meishu.sdk.meishu_ad.nativ.e
            public void onVideoResume() {
            }

            @Override // com.meishu.sdk.meishu_ad.nativ.e
            public void onVideoStart() {
                try {
                    if (BDRecyclerAd.this.recyclerAdMediaListener != null) {
                        BDRecyclerAd.this.recyclerAdMediaListener.onVideoStart();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }

            @Override // com.meishu.sdk.meishu_ad.nativ.e
            public void onVideoThreeQuarter() {
            }

            @Override // com.meishu.sdk.meishu_ad.nativ.e
            public void onVideoUnmute() {
            }
        };
        this.bdAd = nativeResponse;
        this.adView = feedNativeView;
        this.adWrapper = bDRecyclerLoader;
        try {
            if ((bDRecyclerLoader.getAdLoader().getClass().equals(RecyclerMixAdLoader.class) || !isNativeExpress()) && isVideo()) {
                NormalMediaView normalMediaView = new NormalMediaView(bDRecyclerLoader.getContext());
                normalMediaView.setAdListener(new com.meishu.sdk.meishu_ad.nativ.a() { // from class: com.meishu.sdk.platform.bd.recycler.BDRecyclerAd.1
                    public void onADError(String str, Integer num) {
                        if (bDRecyclerLoader.getSdkAdInfo().getErr() != null) {
                            z.a(bDRecyclerLoader.getSdkAdInfo().getErr(), num, str);
                        }
                        bDRecyclerLoader.getLoaderListener().onAdError();
                    }

                    @Override // com.meishu.sdk.meishu_ad.m0
                    public void onADExposure() {
                    }

                    @Override // com.meishu.sdk.meishu_ad.m0
                    public void onADLoaded(List<b> list) {
                    }

                    @Override // com.meishu.sdk.meishu_ad.m0
                    public void onAdRenderFail(String str, int i) {
                    }
                });
                normalMediaView.setOnVideoLoadedListener(new n0.c() { // from class: com.meishu.sdk.platform.bd.recycler.BDRecyclerAd.2
                    @Override // com.meishu.sdk.meishu_ad.n0.c
                    public void onLoaded(n0 n0Var) {
                        n0Var.toString();
                    }
                });
                normalMediaView.setNativeAdMediaListener(this.nativeAdMediaListener);
                normalMediaView.setVideoCover(nativeResponse.getImageUrl());
                normalMediaView.setVideoEndCover(nativeResponse.getImageUrl());
                normalMediaView.setVideoPath(nativeResponse.getVideoUrl());
                normalMediaView.b(false);
                normalMediaView.setRecycler(true);
                normalMediaView.setAutoStart(this.adWrapper.getAdLoader().getIsVideoAutoPlay());
                normalMediaView.setInitMute(true);
                normalMediaView.k();
                this.normalMediaView = normalMediaView;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

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
    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, RecylcerAdInteractionListener recylcerAdInteractionListener) {
        try {
            BDRecyclerLoader bDRecyclerLoader = this.adWrapper;
            if (bDRecyclerLoader != null && bDRecyclerLoader.getSdkAdInfo() != null) {
                o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
            }
            this.recylcerAdInteractionListener = recylcerAdInteractionListener;
            View view = d.a(viewGroup, getClass(), TouchAdContainer.class)[1];
            if (view == null) {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                if (viewGroup2 == null) {
                    view = viewGroup;
                } else {
                    int iIndexOfChild = viewGroup2.indexOfChild(viewGroup);
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
                    viewGroup2.removeView(viewGroup);
                    TouchAdContainer touchAdContainer = new TouchAdContainer(viewGroup.getContext());
                    touchAdContainer.setTouchPositionListener(new TouchPositionListener(this));
                    touchAdContainer.addView(viewGroup, layoutParams2);
                    touchAdContainer.setId(viewGroup.getId());
                    if (AdSdk.adConfig().showFeedAdLogo() && this.bdAd.getStyleType() == 0) {
                        try {
                            ImageView imageView = new ImageView(viewGroup.getContext());
                            imageView.setAdjustViewBounds(true);
                            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, (int) ((viewGroup.getContext().getResources().getDisplayMetrics().density * 14.0f) + 0.5f));
                            layoutParams3.gravity = 85;
                            if (!TextUtils.isEmpty(this.bdAd.getAdLogoUrl())) {
                                new i(imageView).a(this.bdAd.getAdLogoUrl(), false);
                            }
                            touchAdContainer.addView(imageView, layoutParams3);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                    o1.a(touchAdContainer, this.adWrapper.getAdLoader().getPosId(), this.adWrapper.getSdkAdInfo().getMsLoadedTime());
                    viewGroup2.addView(touchAdContainer, iIndexOfChild, layoutParams);
                    view = touchAdContainer;
                }
            }
            NativeResponse nativeResponse = this.bdAd;
            if (nativeResponse != null) {
                nativeResponse.registerViewForInteraction(view, list, null, new BDAdInteractionListener(this.adWrapper.getLoaderListener(), this.adWrapper, this));
            }
            NativeResponse nativeResponse2 = this.bdAd;
            if (nativeResponse2 != null && nativeResponse2.getStyleType() != 0 && isNativeExpress() && getAdView() != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(getAdView());
            }
            View viewFindViewWithTag = viewGroup.findViewWithTag("meishu_media_view");
            if (viewFindViewWithTag == null || viewFindViewWithTag.getParent() == null || !(viewFindViewWithTag.getParent() instanceof ViewGroup)) {
                return;
            }
            ((ViewGroup) viewFindViewWithTag.getParent()).removeView(viewFindViewWithTag);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getActionText() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getAdPatternType() {
        try {
            if (isNativeExpress() && isNativeExpress()) {
                return isNativeExpress() ? 100000 : 12;
            }
            int styleType = this.bdAd.getStyleType();
            if (styleType != 0) {
                switch (styleType) {
                    case 33:
                    case 34:
                        return 11;
                    case 35:
                    case 36:
                        return 13;
                    case 37:
                        return 2;
                    default:
                        return 12;
                }
            }
            int i = AnonymousClass6.$SwitchMap$com$baidu$mobads$sdk$api$NativeResponse$MaterialType[this.bdAd.getMaterialType().ordinal()];
            if (i == 1) {
                return 2;
            }
            if (i != 2) {
                return 12;
            }
            if (this.bdAd.getMultiPicUrls() != null) {
                return 13;
            }
            return (this.bdAd.getIconUrl() != null ? this.bdAd.getIconUrl() : "").equals(this.bdAd.getImageUrl()) ? 11 : 12;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppIntroUrl() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppName() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public List<MeishuAdInfo.PermissionBean> getAppPermissionList() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public MsCustomVideo getCustomVideo() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public long getDuration() {
        return 0L;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFrom() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFromId() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getHeight() {
        return 0;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getIconTitle() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public View getMediaView() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPlatform() {
        return MSAdConfig.PLATFORM_BD;
    }

    public RecylcerAdInteractionListener getRecylcerAdInteractionListener() {
        return this.recylcerAdInteractionListener;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getVideoCover() {
        return "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getVideoUrl() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getWidth() {
        return 0;
    }

    public boolean isHasExposed() {
        return this.hasExposed;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public boolean isNativeExpress() {
        try {
            int adPatternType = this.adWrapper.getAdLoader().getAdPatternType();
            if (adPatternType == 200000) {
                return 2 == this.adWrapper.getSdkAdInfo().getDrawing();
            }
            return adPatternType == 100000;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void replay() {
        if (getAdPatternType() == 2) {
            new Handler().postDelayed(new l() { // from class: com.meishu.sdk.platform.bd.recycler.BDRecyclerAd.5
                @Override // com.meishu.sdk.core.safe.l
                public void safeRun() {
                    try {
                        if (BDRecyclerAd.this.normalMediaView != null) {
                            BDRecyclerAd.this.normalMediaView.replay();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }, 300L);
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void setDownloadStatusListener(DownloadStatusListener downloadStatusListener) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void setExpressMediaListener(ExpressMediaListener expressMediaListener) {
    }

    public void setHasExposed(boolean z) {
        this.hasExposed = z;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void startVideo() {
        try {
            if (getAdPatternType() == 2) {
                new Handler().postDelayed(new l() { // from class: com.meishu.sdk.platform.bd.recycler.BDRecyclerAd.4
                    @Override // com.meishu.sdk.core.safe.l
                    public void safeRun() {
                        try {
                            if (BDRecyclerAd.this.normalMediaView != null) {
                                BDRecyclerAd.this.normalMediaView.start();
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }, 300L);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, RecyclerAdMediaListener recyclerAdMediaListener) {
        try {
            this.recyclerAdMediaListener = recyclerAdMediaListener;
            viewGroup.removeAllViews();
            if (isVideo()) {
                NormalMediaView normalMediaView = this.normalMediaView;
                if (normalMediaView != null && normalMediaView.getParent() != null && (this.normalMediaView.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.normalMediaView.getParent()).removeAllViews();
                }
                viewGroup.addView(this.normalMediaView);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void destroy() {
        try {
            FeedNativeView feedNativeView = this.adView;
            if (feedNativeView != null) {
                feedNativeView.removeAllViews();
                this.adView = null;
            }
            if (this.index <= 0) {
                this.bdAd = null;
            }
            this.index--;
            BDRecyclerLoader bDRecyclerLoader = this.adWrapper;
            if (bDRecyclerLoader != null) {
                bDRecyclerLoader.destroy();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public View getAdView() {
        NativeResponse nativeResponse;
        try {
            if (this.adView == null && (nativeResponse = this.bdAd) != null && nativeResponse.getStyleType() != 0) {
                FeedNativeView feedNativeView = new FeedNativeView(this.adWrapper.getContext());
                this.adView = feedNativeView;
                if (feedNativeView.getParent() != null) {
                    ((ViewGroup) this.adView.getParent()).removeView(this.adView);
                }
                this.adView.setAdData((XAdNativeResponse) this.bdAd);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.adView;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppIntro() {
        NativeResponse nativeResponse = this.bdAd;
        if (nativeResponse != null) {
            return nativeResponse.getDesc();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppPremissionUrl() {
        NativeResponse nativeResponse = this.bdAd;
        if (nativeResponse != null) {
            return nativeResponse.getAppPermissionLink();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppSize() {
        try {
            if (this.bdAd != null) {
                return ((this.bdAd.getAppSize() / 1024) * 1024) + "Mb";
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppVersion() {
        NativeResponse nativeResponse = this.bdAd;
        if (nativeResponse != null) {
            return nativeResponse.getAppVersion();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getContent() {
        NativeResponse nativeResponse = this.bdAd;
        return nativeResponse != null ? nativeResponse.getDesc() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDesc() {
        NativeResponse nativeResponse = this.bdAd;
        return nativeResponse != null ? nativeResponse.getDesc() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDeveloper() {
        NativeResponse nativeResponse = this.bdAd;
        if (nativeResponse != null) {
            return nativeResponse.getPublisher();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFromLogo() {
        NativeResponse nativeResponse = this.bdAd;
        return nativeResponse != null ? nativeResponse.getBaiduLogoUrl() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getIconUrl() {
        NativeResponse nativeResponse = this.bdAd;
        return nativeResponse != null ? nativeResponse.getIconUrl() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String[] getImgUrls() {
        try {
            NativeResponse nativeResponse = this.bdAd;
            if (nativeResponse == null) {
                return null;
            }
            List<String> multiPicUrls = nativeResponse.getMultiPicUrls();
            if (multiPicUrls != null && !multiPicUrls.isEmpty()) {
                return (String[]) multiPicUrls.toArray(new String[0]);
            }
            return TextUtils.isEmpty(this.bdAd.getImageUrl()) ? new String[0] : new String[]{this.bdAd.getImageUrl()};
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPackageName() {
        NativeResponse nativeResponse = this.bdAd;
        return nativeResponse != null ? nativeResponse.getAppPackage() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPlatFormEcpm() {
        NativeResponse nativeResponse = this.bdAd;
        if (nativeResponse != null) {
            return nativeResponse.getECPMLevel();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPrivacyAgreement() {
        NativeResponse nativeResponse = this.bdAd;
        if (nativeResponse != null) {
            return nativeResponse.getAppPrivacyLink();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getTitle() {
        NativeResponse nativeResponse = this.bdAd;
        return nativeResponse != null ? nativeResponse.getTitle() : "";
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public boolean isAdValid() {
        NativeResponse nativeResponse = this.bdAd;
        return nativeResponse != null ? nativeResponse.isAdAvailable(this.adWrapper.getContext()) : super.isAdValid();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void mute() {
        NormalMediaView normalMediaView = this.normalMediaView;
        if (normalMediaView != null) {
            normalMediaView.g();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void pauseVideo() {
        NormalMediaView normalMediaView = this.normalMediaView;
        if (normalMediaView != null) {
            normalMediaView.pause();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void resumeVideo() {
        NormalMediaView normalMediaView = this.normalMediaView;
        if (normalMediaView != null) {
            normalMediaView.resume();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void stopVideo() {
        NormalMediaView normalMediaView = this.normalMediaView;
        if (normalMediaView != null) {
            normalMediaView.l();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void unmute() {
        NormalMediaView normalMediaView = this.normalMediaView;
        if (normalMediaView != null) {
            normalMediaView.j();
        }
    }

    private boolean isVideo() {
        NativeResponse nativeResponse = this.bdAd;
        if (nativeResponse == null) {
            return false;
        }
        try {
            return (nativeResponse.getStyleType() == 0 && this.bdAd.getMaterialType().equals(NativeResponse.MaterialType.VIDEO)) || this.bdAd.getStyleType() == 37;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getInteractionType() {
        NativeResponse nativeResponse = this.bdAd;
        if (nativeResponse == null) {
            return 0;
        }
        try {
            return nativeResponse.isNeedDownloadApp() ? 1 : 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, int i2, RecyclerAdMediaListener recyclerAdMediaListener) {
        try {
            this.recyclerAdMediaListener = recyclerAdMediaListener;
            viewGroup.removeAllViews();
            if (isVideo()) {
                NormalMediaView normalMediaView = this.normalMediaView;
                if (normalMediaView != null && normalMediaView.getParent() != null && (this.normalMediaView.getParent() instanceof ViewGroup)) {
                    ((ViewGroup) this.normalMediaView.getParent()).removeAllViews();
                }
                if (layoutParams != null) {
                    viewGroup.addView(this.normalMediaView, layoutParams);
                } else {
                    viewGroup.addView(this.normalMediaView);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
