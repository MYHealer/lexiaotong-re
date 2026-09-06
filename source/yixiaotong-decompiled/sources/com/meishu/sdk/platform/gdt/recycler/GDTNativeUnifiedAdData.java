package com.meishu.sdk.platform.gdt.recycler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.a;
import com.meishu.sdk.core.ad.recycler.DownloadStatusListener;
import com.meishu.sdk.core.ad.recycler.ExpressMediaListener;
import com.meishu.sdk.core.ad.recycler.RecyclerAdData;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.ad.recycler.d;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.utils.o1;
import com.meishu.sdk.core.view.TouchAdContainer;
import com.meishu.sdk.core.view.TouchPositionListener;
import com.meishu.sdk.platform.ms.recycler.MsCustomVideo;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.ads.nativ.widget.NativeAdContainer;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTNativeUnifiedAdData extends a implements RecyclerAdData {
    private static final String TAG = "GDTNativeUnifiedAdData";
    private GDTRecyclerAdWrapper adWrapper;
    private GDTNativeAdMediaListenerImpl gdtNativeAdMediaListener;
    private volatile boolean hasExposed;
    private NativeUnifiedADData nativeUnifiedADData;

    public GDTNativeUnifiedAdData(GDTRecyclerAdWrapper gDTRecyclerAdWrapper, NativeUnifiedADData nativeUnifiedADData) {
        super(gDTRecyclerAdWrapper, MSAdConfig.PLATFORM_GDT);
        this.adWrapper = gDTRecyclerAdWrapper;
        this.nativeUnifiedADData = nativeUnifiedADData;
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
        FrameLayout.LayoutParams layoutParams;
        try {
            GDTRecyclerAdWrapper gDTRecyclerAdWrapper = this.adWrapper;
            if (gDTRecyclerAdWrapper != null && gDTRecyclerAdWrapper.getSdkAdInfo() != null) {
                o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
            }
            ViewGroup[] viewGroupArrA = d.a(viewGroup, getClass(), NativeAdContainer.class);
            NativeAdContainer nativeAdContainer = (NativeAdContainer) viewGroupArrA[1];
            if (nativeAdContainer == null) {
                ViewGroup viewGroup2 = viewGroupArrA[0];
                nativeAdContainer = new NativeAdContainer(viewGroup2.getContext());
                ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
                if (viewGroup3 != null) {
                    int iIndexOfChild = viewGroup3.indexOfChild(viewGroup2);
                    ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
                    ViewGroup.LayoutParams layoutParams3 = new ViewGroup.LayoutParams(-1, -1);
                    viewGroup3.removeView(viewGroup2);
                    TouchAdContainer touchAdContainer = new TouchAdContainer(viewGroup2.getContext());
                    touchAdContainer.setTouchPositionListener(new TouchPositionListener(this));
                    touchAdContainer.addView(viewGroup2, layoutParams3);
                    nativeAdContainer.setId(viewGroup2.getId());
                    nativeAdContainer.addView(touchAdContainer, layoutParams3);
                    viewGroup3.addView(nativeAdContainer, iIndexOfChild, layoutParams2);
                }
                layoutParams = !AdSdk.adConfig().showFeedAdLogo() ? new FrameLayout.LayoutParams(0, 0) : null;
            } else {
                layoutParams = new FrameLayout.LayoutParams(0, 0);
            }
            GDTRecyclerAdWrapper gDTRecyclerAdWrapper2 = this.adWrapper;
            if (gDTRecyclerAdWrapper2 != null) {
                o1.a(nativeAdContainer, gDTRecyclerAdWrapper2.getAdLoader().getPosId(), this.adWrapper.getSdkAdInfo().getMsLoadedTime());
            }
            NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
            if (nativeUnifiedADData != null) {
                nativeUnifiedADData.sendWinNotification(nativeUnifiedADData.getECPM());
                this.nativeUnifiedADData.bindAdToView(context, nativeAdContainer, layoutParams, list);
                this.nativeUnifiedADData.setNativeAdEventListener(new GDTAdInteractionListener(this, recylcerAdInteractionListener));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, RecyclerAdMediaListener recyclerAdMediaListener) {
        try {
            viewGroup.removeAllViews();
            MediaView mediaView = new MediaView(viewGroup.getContext());
            ViewGroup.LayoutParams layoutParams = mediaView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            }
            layoutParams.width = -1;
            layoutParams.height = -2;
            viewGroup.addView(mediaView, layoutParams);
            VideoOption.Builder builder = new VideoOption.Builder();
            GDTRecyclerAdWrapper gDTRecyclerAdWrapper = this.adWrapper;
            if (gDTRecyclerAdWrapper != null) {
                builder.setAutoPlayPolicy(gDTRecyclerAdWrapper.getAdLoader().getIsVideoAutoPlay() ? 1 : 2);
            }
            builder.setAutoPlayMuted(true);
            builder.setNeedCoverImage(true);
            builder.setNeedProgressBar(true);
            builder.setEnableDetailPage(true);
            builder.setEnableUserControl(false);
            if (this.nativeUnifiedADData != null) {
                destroyGdtNativeAdMediaListener();
                this.gdtNativeAdMediaListener = new GDTNativeAdMediaListenerImpl(recyclerAdMediaListener, this.nativeUnifiedADData);
                this.nativeUnifiedADData.bindMediaView(mediaView, builder.build(), this.gdtNativeAdMediaListener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getActionText() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getAdPatternType() {
        try {
            int adPatternType = this.nativeUnifiedADData.getAdPatternType();
            if (adPatternType != 2) {
                return adPatternType != 3 ? 12 : 13;
            }
            return 2;
        } catch (Throwable th) {
            th.printStackTrace();
            return 12;
        }
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public View getAdView() {
        return null;
    }

    public GDTRecyclerAdWrapper getAdWrapper() {
        return this.adWrapper;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppIntro() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppIntroUrl() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getAppMiitInfo() == null) {
            return null;
        }
        return this.nativeUnifiedADData.getAppMiitInfo().getDescriptionUrl();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppName() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        return (nativeUnifiedADData == null || nativeUnifiedADData.getAppMiitInfo() == null) ? "" : this.nativeUnifiedADData.getAppMiitInfo().getAppName();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public List<MeishuAdInfo.PermissionBean> getAppPermissionList() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppPremissionUrl() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getAppMiitInfo() == null) {
            return null;
        }
        return this.nativeUnifiedADData.getAppMiitInfo().getPermissionsUrl();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppSize() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getAppMiitInfo() == null) {
            return null;
        }
        return ((this.nativeUnifiedADData.getAppMiitInfo().getPackageSizeBytes() / 1024) * 1024) + "MB";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppVersion() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getAppMiitInfo() == null) {
            return null;
        }
        return this.nativeUnifiedADData.getAppMiitInfo().getVersionName();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getContent() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public MsCustomVideo getCustomVideo() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDeveloper() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getAppMiitInfo() == null) {
            return null;
        }
        return this.nativeUnifiedADData.getAppMiitInfo().getAuthorName();
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
    public String getFromLogo() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getIconTitle() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String[] getImgUrls() {
        List<String> imgList;
        String[] strArr = null;
        try {
            int adPatternType = this.nativeUnifiedADData.getAdPatternType();
            if (adPatternType == 1 || adPatternType == 2) {
                strArr = new String[]{this.nativeUnifiedADData.getImgUrl()};
            } else if (adPatternType == 3 && (imgList = this.nativeUnifiedADData.getImgList()) != null) {
                strArr = (String[]) imgList.toArray(new String[0]);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return strArr;
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
        return MSAdConfig.PLATFORM_GDT;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPrivacyAgreement() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        if (nativeUnifiedADData == null || nativeUnifiedADData.getAppMiitInfo() == null) {
            return null;
        }
        return this.nativeUnifiedADData.getAppMiitInfo().getPrivacyAgreement();
    }

    @Override // com.meishu.sdk.core.ad.a
    public Object getSdkAd() {
        return this.nativeUnifiedADData;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getVideoCover() {
        return "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getVideoUrl() {
        return null;
    }

    public boolean isHasExposed() {
        return this.hasExposed;
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

    private void destroyGdtNativeAdMediaListener() {
        try {
            GDTNativeAdMediaListenerImpl gDTNativeAdMediaListenerImpl = this.gdtNativeAdMediaListener;
            if (gDTNativeAdMediaListenerImpl != null) {
                gDTNativeAdMediaListenerImpl.destroy();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void destroy() {
        if (this.nativeUnifiedADData != null) {
            destroyGdtNativeAdMediaListener();
            this.nativeUnifiedADData.destroy();
            this.nativeUnifiedADData = null;
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDesc() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        return nativeUnifiedADData != null ? nativeUnifiedADData.getDesc() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public long getDuration() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        if (nativeUnifiedADData != null) {
            return nativeUnifiedADData.getVideoDuration();
        }
        return 0L;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getHeight() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        if (nativeUnifiedADData == null) {
            return 0;
        }
        nativeUnifiedADData.getPictureHeight();
        return 0;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getIconUrl() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        return nativeUnifiedADData != null ? nativeUnifiedADData.getIconUrl() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getInteractionType() {
        try {
            NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
            if (nativeUnifiedADData != null) {
                return nativeUnifiedADData.isAppAd() ? 1 : 0;
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPlatFormEcpm() {
        if (this.nativeUnifiedADData != null) {
            return this.nativeUnifiedADData.getECPM() + "";
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getTitle() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        return nativeUnifiedADData != null ? nativeUnifiedADData.getTitle() : "";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getWidth() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        if (nativeUnifiedADData == null) {
            return 0;
        }
        nativeUnifiedADData.getPictureWidth();
        return 0;
    }

    @Override // com.meishu.sdk.core.ad.a, com.meishu.sdk.core.ad.IAd
    public boolean isAdValid() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        return nativeUnifiedADData != null ? nativeUnifiedADData.isValid() : super.isAdValid();
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public boolean isNativeExpress() {
        try {
            GDTRecyclerAdWrapper gDTRecyclerAdWrapper = this.adWrapper;
            if (gDTRecyclerAdWrapper != null) {
                int adPatternType = gDTRecyclerAdWrapper.getAdLoader().getAdPatternType();
                if (adPatternType == 200000) {
                    return 2 == this.adWrapper.getSdkAdInfo().getDrawing();
                }
                return adPatternType == 100000;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void mute() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setVideoMute(true);
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void pauseVideo() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.pauseVideo();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void replay() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.startVideo();
        }
    }

    public void resume() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.resume();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void resumeVideo() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.resumeVideo();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void startVideo() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.startVideo();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void stopVideo() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.stopVideo();
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void unmute() {
        NativeUnifiedADData nativeUnifiedADData = this.nativeUnifiedADData;
        if (nativeUnifiedADData != null) {
            nativeUnifiedADData.setVideoMute(false);
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, int i2, RecyclerAdMediaListener recyclerAdMediaListener) {
        try {
            viewGroup.removeAllViews();
            MediaView mediaView = new MediaView(viewGroup.getContext());
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
                layoutParams.width = -1;
                layoutParams.height = -2;
            }
            viewGroup.addView(mediaView, layoutParams);
            VideoOption.Builder builder = new VideoOption.Builder();
            GDTRecyclerAdWrapper gDTRecyclerAdWrapper = this.adWrapper;
            if (gDTRecyclerAdWrapper != null) {
                builder.setAutoPlayPolicy(gDTRecyclerAdWrapper.getAdLoader().getIsVideoAutoPlay() ? 1 : 2);
            }
            builder.setAutoPlayMuted(true);
            builder.setNeedCoverImage(true);
            builder.setNeedProgressBar(true);
            builder.setEnableDetailPage(true);
            builder.setEnableUserControl(false);
            if (this.nativeUnifiedADData != null) {
                destroyGdtNativeAdMediaListener();
                this.gdtNativeAdMediaListener = new GDTNativeAdMediaListenerImpl(recyclerAdMediaListener, this.nativeUnifiedADData);
                this.nativeUnifiedADData.bindMediaView(mediaView, builder.build(), this.gdtNativeAdMediaListener);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
