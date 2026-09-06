package com.meishu.sdk.platform.huawei.recycler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.huawei.hms.ads.Image;
import com.huawei.hms.ads.nativead.MediaView;
import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeView;
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
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class HWNativeAdData extends a implements RecyclerAdData {
    private HWRecyclerAdWrapper adWrapper;
    private NativeAd nativeAd;
    private RecylcerAdInteractionListener recylcerAdInteractionListener;

    public HWNativeAdData(HWRecyclerAdWrapper hWRecyclerAdWrapper, NativeAd nativeAd) {
        super(hWRecyclerAdWrapper, "HW");
        this.adWrapper = hWRecyclerAdWrapper;
        this.nativeAd = nativeAd;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindAdToView(Context context, ViewGroup viewGroup, List<View> list, RecylcerAdInteractionListener recylcerAdInteractionListener) {
        HWRecyclerAdWrapper hWRecyclerAdWrapper = this.adWrapper;
        if (hWRecyclerAdWrapper != null && hWRecyclerAdWrapper.getSdkAdInfo() != null) {
            o1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
        }
        this.recylcerAdInteractionListener = recylcerAdInteractionListener;
        ViewGroup[] viewGroupArrA = d.a(viewGroup, getClass(), NativeView.class);
        NativeView nativeView = (NativeView) viewGroupArrA[1];
        if (nativeView == null) {
            ViewGroup viewGroup2 = viewGroupArrA[0];
            nativeView = new NativeView(viewGroup2.getContext());
            ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
            if (viewGroup3 != null) {
                int iIndexOfChild = viewGroup3.indexOfChild(viewGroup2);
                ViewGroup.LayoutParams layoutParams = viewGroup2.getLayoutParams();
                ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
                viewGroup3.removeView(viewGroup2);
                TouchAdContainer touchAdContainer = new TouchAdContainer(viewGroup2.getContext());
                touchAdContainer.setTouchPositionListener(new TouchPositionListener(this));
                touchAdContainer.addView(viewGroup2, layoutParams2);
                nativeView.setId(viewGroup2.getId());
                nativeView.addView(touchAdContainer, layoutParams2);
                viewGroup3.addView(nativeView, iIndexOfChild, layoutParams);
            }
        }
        if (getAdPatternType() != 2) {
            nativeView.setNativeAd(this.nativeAd);
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, RecyclerAdMediaListener recyclerAdMediaListener) {
        for (ViewGroup viewGroup2 = viewGroup; viewGroup2.getParent() != null; viewGroup2 = (ViewGroup) viewGroup2.getParent()) {
            try {
                if (viewGroup2.getParent() instanceof NativeView) {
                    MediaView mediaView = new MediaView(viewGroup.getContext());
                    mediaView.setMediaContent(this.nativeAd.getMediaContent());
                    viewGroup.addView(mediaView);
                    ((NativeView) viewGroup2.getParent()).setMediaView(mediaView);
                    if (getAdPatternType() == 2) {
                        ((NativeView) viewGroup2.getParent()).setNativeAd(this.nativeAd);
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void destroy() {
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getAdPatternType() {
        int creativeType = this.nativeAd.getCreativeType();
        if (creativeType == 2 || creativeType == 3) {
            return 12;
        }
        if (creativeType != 6 && creativeType != 106) {
            if (creativeType == 108 || creativeType == 8) {
                return 13;
            }
            if (creativeType != 9) {
                return (creativeType == 102 || creativeType == 103) ? 12 : 11;
            }
        }
        return 2;
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
    public String getAppName() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public List<MeishuAdInfo.PermissionBean> getAppPermissionList() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppPremissionUrl() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppSize() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getAppVersion() {
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
    public int getHeight() {
        return 0;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getIconTitle() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public int getInteractionType() {
        return 0;
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
    public String getPlatFormEcpm() {
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPlatform() {
        return "HW";
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getPrivacyAgreement() {
        return null;
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

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public boolean isNativeExpress() {
        int adPatternType = this.adWrapper.getAdLoader().getAdPatternType();
        if (adPatternType == 200000) {
            return 2 == this.adWrapper.getSdkAdInfo().getDrawing();
        }
        return adPatternType == 100000;
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
    public String getActionText() {
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            return nativeAd.getCallToAction();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getContent() {
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            return nativeAd.getDescription();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getDesc() {
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            return nativeAd.getDescription();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getIconUrl() {
        try {
            NativeAd nativeAd = this.nativeAd;
            if (nativeAd != null) {
                return nativeAd.getIcon().getUri().toString();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String[] getImgUrls() {
        List<Image> images;
        try {
            NativeAd nativeAd = this.nativeAd;
            if (nativeAd != null && (images = nativeAd.getImages()) != null && images.size() > 0) {
                String[] strArr = new String[images.size()];
                for (int i = 0; i < images.size(); i++) {
                    strArr[i] = images.get(i).getUri().toString();
                }
                return strArr;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String[0];
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public String getTitle() {
        NativeAd nativeAd = this.nativeAd;
        if (nativeAd != null) {
            return nativeAd.getTitle();
        }
        return null;
    }

    @Override // com.meishu.sdk.core.ad.recycler.RecyclerAdData
    public void bindMediaView(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i, int i2, RecyclerAdMediaListener recyclerAdMediaListener) {
        for (ViewGroup viewGroup2 = viewGroup; viewGroup2.getParent() != null; viewGroup2 = (ViewGroup) viewGroup2.getParent()) {
            try {
                if (viewGroup2.getParent() instanceof NativeView) {
                    MediaView mediaView = new MediaView(viewGroup.getContext());
                    mediaView.setMediaContent(this.nativeAd.getMediaContent());
                    if (layoutParams == null) {
                        viewGroup.addView(mediaView);
                    } else {
                        viewGroup.addView(mediaView, layoutParams);
                    }
                    ((NativeView) viewGroup2.getParent()).setNativeAd(this.nativeAd);
                    if (getAdPatternType() == 2) {
                        ((NativeView) viewGroup2.getParent()).setMediaView(mediaView);
                        return;
                    }
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }
}
