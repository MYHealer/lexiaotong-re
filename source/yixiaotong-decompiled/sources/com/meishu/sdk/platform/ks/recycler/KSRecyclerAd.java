package com.meishu.sdk.platform.ks.recycler;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsNativeAd;
import com.meishu.sdk.core.ad.a;
import com.meishu.sdk.core.ad.recycler.DownloadStatusListener;
import com.meishu.sdk.core.ad.recycler.ExpressMediaListener;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.ad.recycler.d;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.f;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.platform.ms.recycler.MsCustomVideo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KSRecyclerAd extends a implements RecyclerAdData {
    private static final String TAG = "KSRecyclerAd";
    private KSRecyclerAdWrapper adWrapper;
    private KsNativeAd ksNativeAd;
    private RecyclerAdMediaListener nativeRecyclerAdMediaListener;
    private boolean showed;
    private View videoView;

    public KSRecyclerAd(KsNativeAd ksNativeAd, KSRecyclerAdWrapper kSRecyclerAdWrapper) {
        super(kSRecyclerAdWrapper, "KS");
        this.showed = false;
        this.ksNativeAd = ksNativeAd;
        this.adWrapper = kSRecyclerAdWrapper;
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
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, final RecylcerAdInteractionListener recylcerAdInteractionListener) {
        ViewGroup viewGroup2;
        try {
            try {
                list = new ArrayList(list);
            } catch (Exception unused) {
            }
            KSRecyclerAdWrapper kSRecyclerAdWrapper = this.adWrapper;
            if (kSRecyclerAdWrapper != null && kSRecyclerAdWrapper.getSdkAdInfo() != null) {
                o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
            }
            ViewGroup[] viewGroupArrA = d.a(viewGroup, getClass(), TouchAdContainer.class);
            ViewGroup viewGroup3 = viewGroupArrA[1];
            ViewGroup viewGroup4 = viewGroup3;
            if (viewGroup3 == null) {
                ViewGroup viewGroup5 = viewGroupArrA[0];
                ViewGroup viewGroup6 = (ViewGroup) viewGroup5.getParent();
                if (viewGroup6 == null) {
                    viewGroup2 = viewGroup5;
                } else {
                    int iIndexOfChild = viewGroup6.indexOfChild(viewGroup5);
                    ViewGroup.LayoutParams layoutParams = viewGroup5.getLayoutParams();
                    ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
                    viewGroup6.removeView(viewGroup5);
                    TouchAdContainer touchAdContainer = new TouchAdContainer(viewGroup5.getContext());
                    touchAdContainer.setTouchPositionListener(new TouchPositionListener(this));
                    touchAdContainer.addView(viewGroup5, layoutParams2);
                    touchAdContainer.setId(viewGroup5.getId());
                    viewGroup6.addView(touchAdContainer, iIndexOfChild, layoutParams);
                    viewGroup2 = touchAdContainer;
                }
                KSRecyclerAdWrapper kSRecyclerAdWrapper2 = this.adWrapper;
                viewGroup4 = viewGroup2;
                if (kSRecyclerAdWrapper2 != null) {
                    o1.a(viewGroup2, kSRecyclerAdWrapper2.getAdLoader().getPosId(), this.adWrapper.getSdkAdInfo().getMsLoadedTime());
                    viewGroup4 = viewGroup2;
                }
            }
            if (this.ksNativeAd != null) {
                try {
                    if (getAdPatternType() == 2) {
                        this.ksNativeAd.setVideoPlayListener(new KsNativeAd.VideoPlayListener() { // from class: com.meishu.sdk.platform.ks.recycler.KSRecyclerAd.1
                            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                            public void onVideoPlayComplete() {
                                KSRecyclerAd.this.ksNativeAd.reportAdVideoPlayEnd();
                                if (KSRecyclerAd.this.nativeRecyclerAdMediaListener != null) {
                                    KSRecyclerAd.this.nativeRecyclerAdMediaListener.onVideoCompleted();
                                }
                            }

                            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                            public void onVideoPlayError(int i, int i2) {
                                LogUtil.e(KSRecyclerAd.TAG, "onVideoPlayError " + i + PPSLabelView.Code + i2);
                                if (KSRecyclerAd.this.nativeRecyclerAdMediaListener != null) {
                                    KSRecyclerAd.this.nativeRecyclerAdMediaListener.onVideoError();
                                }
                            }

                            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                            public void onVideoPlayPause() {
                                if (KSRecyclerAd.this.nativeRecyclerAdMediaListener != null) {
                                    KSRecyclerAd.this.nativeRecyclerAdMediaListener.onVideoPause();
                                }
                            }

                            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                            public void onVideoPlayReady() {
                                if (KSRecyclerAd.this.nativeRecyclerAdMediaListener != null) {
                                    KSRecyclerAd.this.nativeRecyclerAdMediaListener.onVideoLoaded();
                                }
                            }

                            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                            public void onVideoPlayResume() {
                                if (KSRecyclerAd.this.nativeRecyclerAdMediaListener != null) {
                                    KSRecyclerAd.this.nativeRecyclerAdMediaListener.onVideoResume();
                                }
                            }

                            @Override // com.kwad.sdk.api.KsNativeAd.VideoPlayListener
                            public void onVideoPlayStart() {
                                KSRecyclerAd.this.ksNativeAd.reportAdVideoPlayStart();
                                if (KSRecyclerAd.this.nativeRecyclerAdMediaListener != null) {
                                    KSRecyclerAd.this.nativeRecyclerAdMediaListener.onVideoStart();
                                }
                            }
                        });
                        View videoView = this.ksNativeAd.getVideoView(context, new KsAdVideoPlayConfig.Builder().videoSoundEnable(false).build());
                        this.videoView = videoView;
                        if (videoView != null) {
                            list.add(videoView);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.ksNativeAd.registerViewForInteraction(viewGroup4, list, new KsNativeAd.AdInteractionListener() { // from class: com.meishu.sdk.platform.ks.recycler.KSRecyclerAd.2
                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener) {
                        return false;
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onAdClicked(View view, KsNativeAd ksNativeAd) {
                        LogUtil.d(KSRecyclerAd.TAG, "send onAdClicked");
                        if (KSRecyclerAd.this.adWrapper != null && KSRecyclerAd.this.adWrapper.getSdkAdInfo() != null) {
                            com.meishu.sdk.core.loader.a.a(KSRecyclerAd.this.adWrapper.getContext(), f.a(KSRecyclerAd.this.adWrapper.getSdkAdInfo().getClk(), KSRecyclerAd.this));
                            KSRecyclerAd.this.adWrapper.getSdkAdInfo().getMsLoadedTime();
                            KSRecyclerAd.this.adWrapper.getAdLoader().getPosId();
                        }
                        RecylcerAdInteractionListener recylcerAdInteractionListener2 = recylcerAdInteractionListener;
                        if (recylcerAdInteractionListener2 != null) {
                            recylcerAdInteractionListener2.onAdClicked();
                        }
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onAdShow(KsNativeAd ksNativeAd) {
                        if (KSRecyclerAd.this.showed) {
                            return;
                        }
                        if (KSRecyclerAd.this.adWrapper != null && KSRecyclerAd.this.adWrapper.getLoaderListener() != null) {
                            KSRecyclerAd.this.adWrapper.getLoaderListener().onAdExposure();
                        }
                        RecylcerAdInteractionListener recylcerAdInteractionListener2 = recylcerAdInteractionListener;
                        if (recylcerAdInteractionListener2 != null) {
                            recylcerAdInteractionListener2.onAdExposure();
                        }
                        KSRecyclerAd.this.showed = true;
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onDownloadTipsDialogDismiss() {
                    }

                    @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
                    public void onDownloadTipsDialogShow() {
                    }
                });
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void destroy() {
        this.ksNativeAd = null;
        this.adWrapper = null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getActionText() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppIntro() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppIntroUrl() {
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
    public String getDeveloper() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public long getDuration() {
        return 0L;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFrom() {
        return "KS";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFromId() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getFromLogo() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getHeight() {
        return 0;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getInteractionType() {
        try {
            return this.ksNativeAd.getInteractionType() == 1 ? 1 : 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public View getMediaView() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPackageName() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPlatform() {
        return "KS";
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
    public void mute() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void pauseVideo() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void replay() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void resumeVideo() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void setDownloadStatusListener(DownloadStatusListener downloadStatusListener) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void setExpressMediaListener(ExpressMediaListener expressMediaListener) {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void startVideo() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void stopVideo() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void unmute() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getAdPatternType() {
        KsNativeAd ksNativeAd = this.ksNativeAd;
        if (ksNativeAd == null) {
            return 12;
        }
        int materialType = ksNativeAd.getMaterialType();
        if (materialType != 1) {
            return materialType != 3 ? 12 : 13;
        }
        return 2;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppName() {
        KsNativeAd ksNativeAd = this.ksNativeAd;
        return ksNativeAd != null ? ksNativeAd.getAppName() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppPremissionUrl() {
        KsNativeAd ksNativeAd = this.ksNativeAd;
        if (ksNativeAd != null) {
            return ksNativeAd.getPermissionInfoUrl();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppSize() {
        if (this.ksNativeAd != null) {
            return ((this.ksNativeAd.getAppPackageSize() / 1024) * 1024) + "Mb";
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppVersion() {
        KsNativeAd ksNativeAd = this.ksNativeAd;
        if (ksNativeAd != null) {
            return ksNativeAd.getAppVersion();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getContent() {
        KsNativeAd ksNativeAd = this.ksNativeAd;
        return ksNativeAd != null ? ksNativeAd.getAdDescription() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDesc() {
        KsNativeAd ksNativeAd = this.ksNativeAd;
        return ksNativeAd != null ? ksNativeAd.getAdDescription() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getIconTitle() {
        KsNativeAd ksNativeAd = this.ksNativeAd;
        return ksNativeAd != null ? ksNativeAd.getAppName() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getIconUrl() {
        KsNativeAd ksNativeAd = this.ksNativeAd;
        return ksNativeAd != null ? ksNativeAd.getAppIconUrl() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String[] getImgUrls() {
        KsNativeAd ksNativeAd = this.ksNativeAd;
        if (ksNativeAd == null) {
            return null;
        }
        if (ksNativeAd.getImageList() == null || this.ksNativeAd.getImageList().isEmpty()) {
            return new String[0];
        }
        String[] strArr = new String[this.ksNativeAd.getImageList().size()];
        for (int i = 0; i < this.ksNativeAd.getImageList().size(); i++) {
            strArr[i] = this.ksNativeAd.getImageList().get(i).getImageUrl();
        }
        return strArr;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPlatFormEcpm() {
        if (this.ksNativeAd != null) {
            return this.ksNativeAd.getECPM() + "";
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPrivacyAgreement() {
        KsNativeAd ksNativeAd = this.ksNativeAd;
        if (ksNativeAd != null) {
            return ksNativeAd.getAppPrivacyUrl();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getTitle() {
        KsNativeAd ksNativeAd = this.ksNativeAd;
        return ksNativeAd != null ? ksNativeAd.getAppName() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getWidth() {
        KsNativeAd ksNativeAd = this.ksNativeAd;
        if (ksNativeAd != null) {
            return ksNativeAd.getVideoWidth();
        }
        return 0;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public boolean isNativeExpress() {
        KSRecyclerAdWrapper kSRecyclerAdWrapper = this.adWrapper;
        if (kSRecyclerAdWrapper == null) {
            return false;
        }
        int adPatternType = kSRecyclerAdWrapper.getAdLoader().getAdPatternType();
        if (adPatternType == 200000) {
            return 2 == this.adWrapper.getSdkAdInfo().getDrawing();
        }
        return adPatternType == 100000;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, RecyclerAdMediaListener recyclerAdMediaListener) {
        int iIntValue;
        try {
            if (this.ksNativeAd == null) {
                return;
            }
            this.nativeRecyclerAdMediaListener = recyclerAdMediaListener;
            if (this.videoView != null) {
                viewGroup.removeAllViews();
                float f = viewGroup.getResources().getDisplayMetrics().density;
                int i = viewGroup.getLayoutParams().height;
                KSRecyclerAdWrapper kSRecyclerAdWrapper = this.adWrapper;
                if (kSRecyclerAdWrapper != null) {
                    if (kSRecyclerAdWrapper.getAdLoader().getAccept_ad_height().intValue() == 0) {
                        if (viewGroup.getLayoutParams().height != -2) {
                            iIntValue = viewGroup.getLayoutParams().height;
                        } else {
                            i = (int) (f * 200.0f);
                        }
                    } else {
                        iIntValue = this.adWrapper.getAdLoader().getAccept_ad_height().intValue();
                    }
                    i = iIntValue;
                }
                viewGroup.addView(this.videoView, -1, i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, int i2, RecyclerAdMediaListener recyclerAdMediaListener) {
        int iIntValue;
        try {
            if (this.ksNativeAd == null) {
                return;
            }
            this.nativeRecyclerAdMediaListener = recyclerAdMediaListener;
            if (this.videoView != null) {
                viewGroup.removeAllViews();
                float f = viewGroup.getResources().getDisplayMetrics().density;
                int i3 = viewGroup.getLayoutParams().height;
                KSRecyclerAdWrapper kSRecyclerAdWrapper = this.adWrapper;
                if (kSRecyclerAdWrapper != null) {
                    if (kSRecyclerAdWrapper.getAdLoader().getAccept_ad_height().intValue() == 0) {
                        if (viewGroup.getLayoutParams().height != -2) {
                            iIntValue = viewGroup.getLayoutParams().height;
                        } else {
                            i3 = (int) (f * 200.0f);
                        }
                    } else {
                        iIntValue = this.adWrapper.getAdLoader().getAccept_ad_height().intValue();
                    }
                    i3 = iIntValue;
                }
                if (layoutParams == null) {
                    viewGroup.addView(this.videoView, -1, i3);
                } else {
                    viewGroup.addView(this.videoView, layoutParams);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
