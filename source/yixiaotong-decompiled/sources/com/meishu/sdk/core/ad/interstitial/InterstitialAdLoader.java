package com.meishu.sdk.core.ad.interstitial;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.loader.d;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.meishu_ad.interstitial.b.a;
import com.meishu.sdk.platform.ms.f;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class InterstitialAdLoader extends com.meishu.sdk.core.loader.c<b> {
    public static final String KEY_HEIGHT = "KEY_HEIGHT";
    public static final String KEY_WIDTH = "KEY_WIDTH";
    private static final String TAG = "InterstitialAdLoader";
    private a insterstitialAdListenerAdapter;
    private boolean isClickToClose;
    private boolean isVideoAutoPlay;

    public InterstitialAdLoader(Activity activity, MsAdSlot msAdSlot, InterstitialAdEventListener interstitialAdEventListener) {
        if (msAdSlot == null) {
            LogUtil.e(TAG, "MsAdSlot is null");
            return;
        }
        this.accept_ad_width = Integer.valueOf(msAdSlot.getWidth());
        this.accept_ad_height = Integer.valueOf(msAdSlot.getHeight());
        this.isClickToClose = msAdSlot.getIsClickToClose();
        this.isVideoAutoPlay = msAdSlot.getIsVideoAutoPlay();
        this.channel = msAdSlot.getChannel();
        this.insterstitialAdListenerAdapter = new a(this, interstitialAdEventListener);
        init(activity, msAdSlot.getPid(), this.insterstitialAdListenerAdapter);
    }

    @Override // com.meishu.sdk.core.loader.c
    public d createDelegate(SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        if (sdkAdInfo != null) {
            return !TextUtils.isEmpty(sdkAdInfo.getCls()) ? com.meishu.sdk.core.a.a("CUSTOM").interstitialLoader(this, sdkAdInfo, meishuAdInfo) : com.meishu.sdk.core.a.a(sdkAdInfo.getSdk()).interstitialLoader(this, sdkAdInfo, meishuAdInfo);
        }
        return null;
    }

    @Override // com.meishu.sdk.core.loader.c
    public d createMeishuAdDelegate(Context context, MeishuAdInfo meishuAdInfo) {
        com.meishu.sdk.meishu_ad.interstitial.b.a interactionType = new com.meishu.sdk.meishu_ad.interstitial.b().new a().setAppId(f.a().getAppId()).setWxAppId(meishuAdInfo.getWx_appid()).setScaleType(meishuAdInfo.getScale_type()).setEventUrl(meishuAdInfo.getEventUrl()).setWinUrl(meishuAdInfo.getWinUrl()).setLossUrl(meishuAdInfo.getLossUrl()).setActionDesc(meishuAdInfo.getAction_desc()).setScheme(meishuAdInfo.getScheme()).setVideo_cover(meishuAdInfo.getVideo_cover()).setDynamicMap(meishuAdInfo.getDynamicMap()).setFieldExport(meishuAdInfo.getFieldExport()).setAdg(meishuAdInfo.getAdg()).setAdp(meishuAdInfo.getAdp()).setDefImage(meishuAdInfo.getDefImage()).setDefaultCoord(meishuAdInfo.getDefault_coord()).setDpSign(meishuAdInfo.getDpsign()).setActExt(meishuAdInfo.getAct_ext()).setUob(meishuAdInfo.getUob()).setRs(meishuAdInfo.getRs()).setDPSIGN(meishuAdInfo.getDPSIGN()).setLoadedTime(meishuAdInfo.getLoadedTime()).setClickType(meishuAdInfo.getClk_type()).setClkArea(meishuAdInfo.getClk_area()).setPowerIndex(meishuAdInfo.getPower_index()).setPowerIndex2(meishuAdInfo.getPower_index2()).setPowerDelay(meishuAdInfo.getPower_delay()).setPowerCount(meishuAdInfo.getPower_count()).setExpireTimestamp(meishuAdInfo.getExpire_timestamp()).setEcpm(meishuAdInfo.getEcpm()).setDClickData(meishuAdInfo.getDclk()).setActType(meishuAdInfo.getAct_type()).setAdType(meishuAdInfo.getAd_type()).setCBC(meishuAdInfo.getCbc()).setNOP(meishuAdInfo.getNop()).setS_code(meishuAdInfo.getS_code()).setS_ext(meishuAdInfo.getS_ext()).setReqId(meishuAdInfo.getReq_id()).setFromId(meishuAdInfo.getFrom_id()).setDirectMarket(meishuAdInfo.getDirect_market()).setPackageName(meishuAdInfo.getPackage_name()).setPosId(meishuAdInfo.getPid()).setPermissionUrl(meishuAdInfo.getApp_permission_url()).setPermisssList(meishuAdInfo.getApp_permission()).setAppIntroUrl(meishuAdInfo.getApp_intor_url()).setCid(meishuAdInfo.getCid()).setCat(meishuAdInfo.getCat()).setAderId(meishuAdInfo.getAder_id()).setImageUrls(meishuAdInfo.getSrcUrls()).setInteractionType(meishuAdInfo.getTarget_type());
        meishuAdInfo.getWidth();
        com.meishu.sdk.meishu_ad.interstitial.b.this.getClass();
        meishuAdInfo.getHeight();
        com.meishu.sdk.meishu_ad.interstitial.b.this.getClass();
        meishuAdInfo.getInsert_style();
        com.meishu.sdk.meishu_ad.interstitial.b.this.getClass();
        com.meishu.sdk.meishu_ad.interstitial.b.a errorUrl = interactionType.setDUrl(meishuAdInfo.getdUrl()).setAppName(meishuAdInfo.getApp_name()).setIcon(meishuAdInfo.getIcon()).setScore(meishuAdInfo.getScore()).setDeveloper(meishuAdInfo.getDeveloper()).setAppIntro(meishuAdInfo.getApp_intro()).setAppFeature(meishuAdInfo.getApp_feature()).setPaymentTypes(meishuAdInfo.getPayment_types()).setAppSize(meishuAdInfo.getApp_size()).setAppVer(meishuAdInfo.getApp_ver()).setAppPrivacy(meishuAdInfo.getApp_privacy()).setPrivacyAgreement(meishuAdInfo.getPrivacy_agreement()).setDeepLink(meishuAdInfo.getDeep_link()).setWx_username(meishuAdInfo.getWx_username()).setWx_path(meishuAdInfo.getWx_path()).setWxStart(meishuAdInfo.getWx_start()).setWxSuccess(meishuAdInfo.getWx_succ()).setWxFail(meishuAdInfo.getWx_fail()).setMonitorUrl(meishuAdInfo.getMonitorUrl()).setResponUrl(meishuAdInfo.getResponUrl()).setClickUrl(meishuAdInfo.getClickUrl()).setDn_start(meishuAdInfo.getDn_start()).setDn_succ(meishuAdInfo.getDn_succ()).setDn_inst_start(meishuAdInfo.getDn_inst_start()).setDn_inst_succ(meishuAdInfo.getDn_inst_succ()).setDn_active(meishuAdInfo.getDn_active()).setDp_start(meishuAdInfo.getDp_start()).setDp_fail(meishuAdInfo.getDp_fail()).setDp_succ(meishuAdInfo.getDp_succ()).setClickid(meishuAdInfo.getClickid()).setFromLogo(meishuAdInfo.getFrom_logo()).setDrawing(meishuAdInfo.getDrawing()).setAdPatternType(meishuAdInfo.getCreative_type()).setErrorUrl(meishuAdInfo.getErrorUrl());
        meishuAdInfo.getAction_text();
        com.meishu.sdk.meishu_ad.interstitial.b.this.getClass();
        com.meishu.sdk.meishu_ad.interstitial.b.this.f5021a = meishuAdInfo.getTitle();
        return new com.meishu.sdk.platform.ms.interstitial.b(this, com.meishu.sdk.meishu_ad.interstitial.b.this);
    }

    public boolean getIsClickToClose() {
        return this.isClickToClose;
    }

    public boolean getIsVideoAutoPlay() {
        return this.isVideoAutoPlay;
    }

    public void loadAd(float f, float f2) {
        HashMap map = new HashMap();
        map.put("KEY_WIDTH", Float.valueOf(f));
        map.put("KEY_HEIGHT", Float.valueOf(f2));
        loadAd(map);
    }

    @Override // com.meishu.sdk.core.loader.c
    public void clearErrorState() {
        a aVar = this.insterstitialAdListenerAdapter;
        if (aVar != null) {
            aVar.b = false;
            aVar.c = false;
        }
    }

    public void loadAd(String str) {
        HashMap map = new HashMap();
        map.put(com.meishu.sdk.core.loader.c.KEY_TOKEN, str);
        super.loadAd(map);
    }
}
