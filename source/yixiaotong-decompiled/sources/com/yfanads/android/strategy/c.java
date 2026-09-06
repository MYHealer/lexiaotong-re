package com.yfanads.android.strategy;

import com.yfanads.android.callback.BaseAdapterEvent;
import com.yfanads.android.core.BaseChanelAdapter;
import com.yfanads.android.core.banner.YFBannerSetting;
import com.yfanads.android.core.draw.YFDrawSetting;
import com.yfanads.android.core.full.YFFullScreenVideoSetting;
import com.yfanads.android.core.inter.YFInterstitialSetting;
import com.yfanads.android.core.nat.YFNativeExpressSetting;
import com.yfanads.android.core.render.YFNativeSetting;
import com.yfanads.android.core.reward.YFRewardVideoSetting;
import com.yfanads.android.core.roll.YFRollAdsSetting;
import com.yfanads.android.core.shop.YFShopMallSetting;
import com.yfanads.android.core.splash.YFSplashSetting;
import com.yfanads.android.core.textlink.YFTextLinkSetting;
import com.yfanads.android.core.toppush.YFTopPushSetting;
import com.yfanads.android.model.YFAdType;
import com.yfanads.android.utils.ReflectionUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.util.HashMap;

/* JADX INFO: compiled from: AdapterLoader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f9679a;
    public static final HashMap b;

    /* JADX INFO: compiled from: AdapterLoader.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9680a;
        public final Class<?> b;

        public a(String str, Class<?> cls) {
            this.f9680a = str;
            this.b = cls;
        }
    }

    static {
        HashMap map = new HashMap();
        f9679a = map;
        HashMap map2 = new HashMap();
        b = map2;
        map.put(1, YFAdsConst.CHANEL_CSJ_PATH);
        map.put(2, YFAdsConst.CHANEL_YLH_PATH);
        map.put(3, YFAdsConst.CHANEL_BD_PATH);
        map.put(4, YFAdsConst.CHANEL_KS_PATH);
        map.put(12, YFAdsConst.CHANEL_ADX_PATH);
        map.put(6, YFAdsConst.CHANEL_HW_PATH);
        map.put(7, YFAdsConst.CHANEL_XM_PATH);
        map.put(8, YFAdsConst.CHANEL_OPPO_PATH);
        map.put(9, YFAdsConst.CHANEL_JD_PATH);
        map.put(10, YFAdsConst.CHANEL_VIVO_PATH);
        map.put(11, YFAdsConst.CHANEL_CSJ_GROMORE_PATH);
        map.put(13, YFAdsConst.CHANEL_RY_PAT);
        map.put(14, YFAdsConst.CHANEL_TANX_PAT);
        map.put(15, YFAdsConst.CHANEL_AY_PATH);
        map.put(16, YFAdsConst.CHANEL_XU_PATH);
        map.put(17, YFAdsConst.CHANEL_GE_PATH);
        map.put(18, YFAdsConst.CHANEL_CJ_PATH);
        map.put(19, YFAdsConst.CHANEL_IN_PATH);
        map.put(20, YFAdsConst.CHANEL_JC_PATH);
        map.put(21, YFAdsConst.CHANEL_NAL_PATH);
        map.put(22, YFAdsConst.CHANEL_NC_PATH);
        map.put(23, YFAdsConst.CHANEL_UW_PATH);
        map.put(24, YFAdsConst.CHANEL_KY_PATH);
        map.put(25, YFAdsConst.CHANEL_KF_PATH);
        map.put(26, YFAdsConst.CHANEL_ZD_PATH);
        map2.put(YFAdType.SPLASH, new a("SplashAdapter", YFSplashSetting.class));
        map2.put(YFAdType.BANNER, new a("BannerAdapter", YFBannerSetting.class));
        map2.put(YFAdType.INTR, new a("InterstitialAdapter", YFInterstitialSetting.class));
        map2.put(YFAdType.DRAW, new a("DrawAdapter", YFDrawSetting.class));
        map2.put(YFAdType.FULL, new a("FullScreenVideoAdapter", YFFullScreenVideoSetting.class));
        map2.put(YFAdType.REWARD, new a("RewardVideoAdapter", YFRewardVideoSetting.class));
        map2.put(YFAdType.NATIV, new a("NativeExpressAdapter", YFNativeExpressSetting.class));
        map2.put(YFAdType.ROLL, new a("RollAdapter", YFRollAdsSetting.class));
        map2.put(YFAdType.CUSTOM, new a("NativeAdapter", YFNativeSetting.class));
        map2.put(YFAdType.MIXBANNER, new a("MixBannerAdapter", YFNativeExpressSetting.class));
        map2.put(YFAdType.TOPPUSH, new a("TopPushAdapter", YFTopPushSetting.class));
        map2.put(YFAdType.SHOPMALL, new a("ShopMallAdapter", YFShopMallSetting.class));
        map2.put(YFAdType.TEXTLINK, new a("TextLinkAdapter", YFTextLinkSetting.class));
    }

    public static BaseChanelAdapter a(Integer num, YFAdType yFAdType, BaseAdapterEvent baseAdapterEvent) {
        try {
            String str = (String) f9679a.get(num);
            a aVar = (a) b.get(yFAdType);
            if (aVar == null) {
                return null;
            }
            return (BaseChanelAdapter) ReflectionUtils.getSDKAdapter(num.intValue(), "com.yfanads.ads.chanel." + (str + aVar.f9680a), aVar.b, baseAdapterEvent);
        } catch (Exception unused) {
            YFLog.error("getSdkAdapter error");
            return null;
        }
    }
}
