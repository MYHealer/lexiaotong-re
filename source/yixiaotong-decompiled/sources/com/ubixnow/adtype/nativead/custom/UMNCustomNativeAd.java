package com.ubixnow.adtype.nativead.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ubixnow.adtype.nativead.api.UMNCustomVideoCallBack;
import com.ubixnow.adtype.nativead.api.UMNNativeMaterial;
import com.ubixnow.core.R;
import com.ubixnow.core.api.UMNImageInfo;
import com.ubixnow.core.bean.UMNNativeExtraInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00OOO0;
import com.ubixnow.ooooo.o00Ooo;
import com.ubixnow.ooooo.o00oO0o;
import com.ubixnow.ooooo.o0O0o0;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo000o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNCustomNativeAd extends o00Ooo {
    public static final int INTERACTION_UNKNOWN = 0;
    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);
    private View adLogoView;
    private String adSource;
    public oo000o configInfo;
    public UMNNativeMaterial.DownloadAppinfo downloadAppinfo;
    public o00OOO0 feedbackMaterialBean;
    public o00O00o0 loadListener;
    private View.OnClickListener mCloseViewListener;
    private Map<String, Object> mNetworkInfoMap;
    private int mVideoHeight;
    private int mVideoWidth;
    private int mainImgHeight;
    private int mainImgWidth;
    private UMNNativeMaterial material;
    private ViewGroup rootVg;
    private int videoDuration;
    public final String TAG = "----UMNCustomNativeAd";
    private String mMainImageUrl = "";
    private String mIconImageUrl = "";
    private String mTitle = "";
    private String userName = "";
    private String mText = "";
    private String buttonText = "";
    private String mVideoUrl = "";
    private String mAdFrom = "";
    private String videoCoverUrl = "";
    private String creativeId = "";
    private String deeplinkUrl = "";
    private String downloadUrl = "";
    private String landingPageUrl = "";
    private String appPackageName = "";
    public String materialType = "2";
    public List<UMNImageInfo> mImageUrlList = new ArrayList();
    private int mInteractionType = 0;
    private int eventType = 0;

    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i;
        int i2;
        do {
            try {
                atomicInteger = sNextGeneratedId;
                i = atomicInteger.get();
                i2 = i + 1;
                if (i2 > 16777215) {
                    i2 = 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShakeAd() {
        return this.configInfo.getBaseAdConfig().OooO00o.OooOOoo != null && this.configInfo.getBaseAdConfig().OooO00o.OooOOoo.OooO0OO;
    }

    @Override // com.ubixnow.ooooo.o00Ooo
    public final void bindDislikeListener(View.OnClickListener onClickListener) {
    }

    public final boolean checkHasCloseViewListener() {
        return this.mCloseViewListener != null;
    }

    @Override // com.ubixnow.ooooo.o00Ooo
    public void clear(View view) {
    }

    @Override // com.ubixnow.ooooo.o00oOoo
    public void destroy() {
    }

    public String getAdFrom() {
        return this.mAdFrom;
    }

    @Override // com.ubixnow.ooooo.o00Ooo
    public View getAdIconView() {
        return null;
    }

    public Bitmap getAdLogo() {
        return null;
    }

    public final View getAdLogoView() {
        return this.adLogoView;
    }

    @Override // com.ubixnow.ooooo.o00Ooo
    public View getAdMediaView(Object... objArr) {
        return null;
    }

    public String getAdSource() {
        String str = this.adSource;
        return str == null ? "" : str;
    }

    public String getAppPackageName() {
        return this.appPackageName;
    }

    public String getButtonText() {
        return this.buttonText;
    }

    public String getCreativeId() {
        return this.creativeId;
    }

    @Override // com.ubixnow.ooooo.o00Ooo
    public ViewGroup getCustomAdContainer() {
        return null;
    }

    public String getDeeplinkUrl() {
        return this.deeplinkUrl;
    }

    public String getDescriptionText() {
        return this.mText;
    }

    public int getDownloadAppStatus() {
        return 0;
    }

    public UMNNativeMaterial.DownloadAppinfo getDownloadAppinfo() {
        return this.downloadAppinfo;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public int getEventType() {
        return this.eventType;
    }

    public String getIconImageUrl() {
        return this.mIconImageUrl;
    }

    public final List<UMNImageInfo> getImageUrlList() {
        return this.mImageUrlList;
    }

    public ViewGroup getItemRootView() {
        return this.rootVg;
    }

    public String getLandingPageUrl() {
        return this.landingPageUrl;
    }

    public String getMainImageUrl() {
        return this.mMainImageUrl;
    }

    public int getMainImgHeight() {
        return this.mainImgHeight;
    }

    public int getMainImgWidth() {
        return this.mainImgWidth;
    }

    public UMNNativeMaterial getMaterial() {
        if (this.material == null) {
            this.material = new UMNNativeMaterial() { // from class: com.ubixnow.adtype.nativead.custom.UMNCustomNativeAd.1
                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public UMNNativeMaterial.DownloadAppinfo downloadAppinfo() {
                    return UMNCustomNativeAd.this.downloadAppinfo;
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public String getActionDescription() {
                    return UMNCustomNativeAd.this.getButtonText();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public String getAdFrom() {
                    return UMNCustomNativeAd.this.getAdFrom();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public View getAdMediaView(Object... objArr) {
                    return UMNCustomNativeAd.this.getAdMediaView(objArr);
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public String getAdSource() {
                    return UMNCustomNativeAd.this.getAdSource();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public String getAdType() {
                    return UMNCustomNativeAd.this.getAdType();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public UMNCustomVideoCallBack getCustomVideo() {
                    return null;
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public String getDescriptionText() {
                    return UMNCustomNativeAd.this.getDescriptionText();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public UMNNativeMaterial.DownloadAppinfo getDownloadAppinfo() {
                    return UMNCustomNativeAd.this.downloadAppinfo;
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public String getIconImageUrl() {
                    return UMNCustomNativeAd.this.getIconImageUrl();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public List<String> getImageUrlList() {
                    List<UMNImageInfo> imageUrlList = UMNCustomNativeAd.this.getImageUrlList();
                    ArrayList arrayList = new ArrayList();
                    if (imageUrlList != null) {
                        Iterator<UMNImageInfo> it = imageUrlList.iterator();
                        while (it.hasNext()) {
                            arrayList.add(it.next().url);
                        }
                    }
                    return arrayList;
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public int getMainImageHeight() {
                    return UMNCustomNativeAd.this.getMainImgHeight();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public String getMainImageUrl() {
                    return UMNCustomNativeAd.this.getMainImageUrl();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public int getMainImageWidth() {
                    return UMNCustomNativeAd.this.getMainImgWidth();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public int getNativeAdInteractionType() {
                    return UMNCustomNativeAd.this.getNativeAdInteractionType();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public Map<String, Object> getNetworkInfoMap() {
                    return null;
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public String getTitle() {
                    return UMNCustomNativeAd.this.getTitle();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public int getVideoDuration() {
                    return UMNCustomNativeAd.this.getVideoDuration();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public int getVideoHeight() {
                    return UMNCustomNativeAd.this.getVideoHeight();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public String getVideoUrl() {
                    return UMNCustomNativeAd.this.getVideoUrl();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public int getVideoWidth() {
                    return UMNCustomNativeAd.this.getVideoWidth();
                }

                @Override // com.ubixnow.adtype.nativead.api.UMNNativeMaterial
                public boolean isShakeAd() {
                    return UMNCustomNativeAd.this.isShakeAd();
                }
            };
        }
        return this.material;
    }

    public int getNativeAdInteractionType() {
        return this.mInteractionType;
    }

    public String getNativeExpressType() {
        return "0";
    }

    public View getNativeShakeView(Context context) {
        return (ViewGroup) LayoutInflater.from(context).inflate(R.layout.ubixnow_native_shake, (ViewGroup) null);
    }

    public final Map<String, Object> getNetworkInfoMap() {
        return this.mNetworkInfoMap;
    }

    public String getRewardTaskAction() {
        return "0";
    }

    public View getShakeView(View view) {
        return null;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public final String getUserName() {
        return this.userName;
    }

    public String getVideoCoverUrl() {
        return this.videoCoverUrl;
    }

    public int getVideoDuration() {
        return this.videoDuration;
    }

    public int getVideoHeight() {
        return this.mVideoHeight;
    }

    public final String getVideoUrl() {
        return this.mVideoUrl;
    }

    public int getVideoWidth() {
        return this.mVideoWidth;
    }

    public void impressionTrack(View view) {
    }

    @Override // com.ubixnow.ooooo.o00Ooo
    public boolean isNativeExpress() {
        return false;
    }

    public boolean isValid() {
        return true;
    }

    public void onADRenderFail(String str, String str2, oo000o oo000oVar) {
        try {
            showLog(this.TAG, "onRenderFail code=" + str + " msg=" + str2);
            o00O00o0 o00o00o0 = this.loadListener;
            if (o00o00o0 != null) {
                o00o00o0.onAdRenderFail(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, str + "", str2).setInfo((Object) oo000oVar));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onAdCacheSuccess(oo000o oo000oVar) {
        try {
            showLog(this.TAG, "onAdCacheSuccess");
            if (this.loadListener != null) {
                if (oo000oVar.material == null) {
                    oo000oVar.material = o00oO0o.OooO00o(new o0O0o0(), this);
                }
                this.loadListener.onAdCacheSuccess(oo000oVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onAdDataLoaded(oo000o oo000oVar) {
        try {
            showLog(this.TAG, "onAdDataLoaded");
            o00O00o0 o00o00o0 = this.loadListener;
            if (o00o00o0 != null) {
                o00o00o0.onAdDataLoaded(oo000oVar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.ubixnow.ooooo.o00Ooo
    public void onPause() {
    }

    @Override // com.ubixnow.ooooo.o00Ooo
    public void onResume() {
    }

    @Override // com.ubixnow.ooooo.o00Ooo
    public void pauseVideo() {
    }

    @Override // com.ubixnow.ooooo.o00Ooo
    public void regist(ViewGroup viewGroup, UMNNativeExtraInfo uMNNativeExtraInfo) {
    }

    public void registerDownloadConfirmListener() {
    }

    @Override // com.ubixnow.ooooo.o00Ooo
    public void resumeVideo() {
    }

    public final void setAdFrom(String str) {
        this.mAdFrom = str;
    }

    public final void setAdLogoView(View view) {
        this.adLogoView = view;
    }

    public void setAdSource(String str) {
        this.adSource = str;
    }

    public void setAppPackageName(String str) {
        this.appPackageName = str;
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.buttonText = str;
        }
    }

    public void setCreativeId(String str) {
        this.creativeId = str;
    }

    public void setDeeplinkUrl(String str) {
        this.deeplinkUrl = str;
    }

    public final void setDescriptionText(String str) {
        if (str != null) {
            this.mText = str;
        }
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public final void setEventType(int i) {
        this.eventType = i;
    }

    public final void setIconImageUrl(String str) {
        this.mIconImageUrl = str;
    }

    public final void setImageInfoList(List<UMNImageInfo> list) {
        if (list != null) {
            this.mImageUrlList = list;
        }
    }

    public final void setImageList4Url(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mImageUrlList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            this.mImageUrlList.add(new UMNImageInfo(it.next()));
        }
    }

    public void setLandingPageUrl(String str) {
        this.landingPageUrl = str;
    }

    public final void setMainImageUrl(String str) {
        this.mMainImageUrl = str;
    }

    public void setMainImgHeight(int i) {
        this.mainImgHeight = i;
    }

    public void setMainImgWidth(int i) {
        this.mainImgWidth = i;
    }

    public final void setNativeInteractionType(int i) {
        this.mInteractionType = i;
    }

    public final void setNetworkInfoMap(Map<String, Object> map) {
        this.mNetworkInfoMap = map;
    }

    public void setRootView(ViewGroup viewGroup) {
        this.rootVg = viewGroup;
    }

    public final void setTitle(String str) {
        if (str != null) {
            this.mTitle = str;
        }
    }

    public final void setUserName(String str) {
        if (str != null) {
            this.userName = str;
        }
    }

    public void setVideoCoverUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.videoCoverUrl = str;
    }

    public void setVideoDuration(int i) {
        this.videoDuration = i;
    }

    public void setVideoHeight(int i) {
        this.mVideoHeight = i;
    }

    @Override // com.ubixnow.ooooo.o00Ooo
    public void setVideoMute(boolean z) {
    }

    public final void setVideoUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mVideoUrl = str;
    }

    public void setVideoWidth(int i) {
        this.mVideoWidth = i;
    }

    @Override // com.ubixnow.ooooo.o00Ooo
    public void startVideo() {
    }

    @Override // com.ubixnow.ooooo.o00Ooo
    public void stopVideo() {
    }

    public void transferContainer(ViewGroup viewGroup) {
    }

    public void unregeisterDownloadConfirmListener() {
    }
}
