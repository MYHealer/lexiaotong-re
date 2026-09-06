package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.ad.nativead.NativeAdViewBinder;
import com.miui.zeus.mimo.sdk.ad.nativead.view.NativeAdView;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface NativeAdData {
    public static final String AD_ASSET_ORIENTATION_HORIZONTAL = ijiami_1011.s.s.s.d(new byte[]{95, 95, 75, 15, 78, 94, 15, 16, 7, 14}, "709f41");
    public static final String AD_ASSET_ORIENTATION_VERTICAL = ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 0, 65, 77, 15, 5, 0, 8}, "ae39ff");
    public static final int AD_MATERIAL_GIF = 2;
    public static final int AD_MATERIAL_PIC = 1;
    public static final int AD_MATERIAL_VIDEO = 3;
    public static final int AD_STYLE_IMAGE_AND_VIDEO = 215;
    public static final int AD_STYLE_IMAGE_BIG = 211;
    public static final int AD_STYLE_IMAGE_GROUP = 213;
    public static final int AD_STYLE_IMAGE_SMALL = 212;
    public static final int AD_STYLE_VIDEO = 214;
    public static final int AD_TYPE_DOWNLOAD = 2;
    public static final int AD_TYPE_LINK = 1;

    void destroy();

    String getAdMark();

    int getAdStyle();

    int getAdType();

    String getAppDeveloper();

    String getAppIntroduction();

    String getAppName();

    String getAppPermission();

    String getAppPrivacy();

    String getAppVersion();

    int getAssetHeight();

    String getAssetOrientation();

    int getAssetWidth();

    String getButtonText();

    String getDesc();

    long getDuration();

    String getIconUrl();

    long getId();

    List<String> getImageList();

    int getMaterialType();

    Map<String, Object> getMediaExtraInfo();

    String getPackageName();

    String getTitle();

    String getVideoUrl();

    void registerAdView(NativeAdView nativeAdView, NativeAdViewBinder nativeAdViewBinder, NativeCustomAd.NativeCustomMultiAdsInteractionListener nativeCustomMultiAdsInteractionListener);
}
