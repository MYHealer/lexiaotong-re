package com.meishu.sdk.core.ad.splash;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.meishu_ad.splash.d.a;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SplashAdLoader extends com.meishu.sdk.core.loader.c<d> {
    public static final String KEY_AUTO_SHOW = "KEY_AUTO_SHOW";
    public static final String KEY_SKIP_BUTTON = "KEY_SKIP_BUTTON";
    private static final String TAG = "SplashAdLoader";
    private ViewGroup adContainer;
    private int fetchDelay;
    private boolean hideSkipButton;
    private boolean isMute;
    private boolean isSplashFullScreen;
    private e splashAdListenerAdapter;

    public SplashAdLoader(Context context, MsAdSlot msAdSlot, SplashAdEventListener splashAdEventListener, int i) {
        this.isMute = true;
        if (msAdSlot == null) {
            LogUtil.e(TAG, "MsAdSlot is null");
            return;
        }
        this.accept_ad_width = Integer.valueOf(msAdSlot.getWidth());
        this.accept_ad_height = Integer.valueOf(msAdSlot.getHeight());
        this.isMute = msAdSlot.getIsMute();
        this.fetchDelay = i;
        this.hideSkipButton = msAdSlot.getIsHideSkipButton();
        this.channel = msAdSlot.getChannel();
        this.splashAdListenerAdapter = new e(this, splashAdEventListener);
        init(context, msAdSlot.getPid(), this.splashAdListenerAdapter);
    }

    @Override // com.meishu.sdk.core.loader.c
    public com.meishu.sdk.core.loader.d createDelegate(SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        if (sdkAdInfo != null) {
            return !TextUtils.isEmpty(sdkAdInfo.getCls()) ? com.meishu.sdk.core.a.a("CUSTOM").splashLoader(this, sdkAdInfo, meishuAdInfo) : com.meishu.sdk.core.a.a(sdkAdInfo.getSdk()).splashLoader(this, sdkAdInfo, meishuAdInfo);
        }
        return null;
    }

    @Override // com.meishu.sdk.core.loader.c
    public com.meishu.sdk.core.loader.d createMeishuAdDelegate(Context context, MeishuAdInfo meishuAdInfo) {
        com.meishu.sdk.meishu_ad.splash.d.a packageName = new com.meishu.sdk.meishu_ad.splash.d().new a().setAppId(AdSdk.adConfig().appId()).setWxAppId(meishuAdInfo.getWx_appid()).setScaleType(meishuAdInfo.getScale_type()).setEventUrl(meishuAdInfo.getEventUrl()).setWinUrl(meishuAdInfo.getWinUrl()).setLossUrl(meishuAdInfo.getLossUrl()).setCloseUrl(meishuAdInfo.getCloseUrl()).setActionDesc(meishuAdInfo.getAction_desc()).setScheme(meishuAdInfo.getScheme()).setDynamicMap(meishuAdInfo.getDynamicMap()).setFieldExport(meishuAdInfo.getFieldExport()).setAdg(meishuAdInfo.getAdg()).setAdp(meishuAdInfo.getAdp()).setDefImage(meishuAdInfo.getDefImage()).setDefaultCoord(meishuAdInfo.getDefault_coord()).setDpSign(meishuAdInfo.getDpsign()).setActExt(meishuAdInfo.getAct_ext()).setUob(meishuAdInfo.getUob()).setRs(meishuAdInfo.getRs()).setDPSIGN(meishuAdInfo.getDPSIGN()).setLoadedTime(meishuAdInfo.getLoadedTime()).setExpireTimestamp(meishuAdInfo.getExpire_timestamp()).setEcpm(meishuAdInfo.getEcpm()).setDClickData(meishuAdInfo.getDclk()).setActType(meishuAdInfo.getAct_type()).setAdType(meishuAdInfo.getAd_type()).setCBC(meishuAdInfo.getCbc()).setNOP(meishuAdInfo.getNop()).setS_code(meishuAdInfo.getS_code()).setS_ext(meishuAdInfo.getS_ext()).setReqId(meishuAdInfo.getReq_id()).setFromId(meishuAdInfo.getFrom_id()).setDirectMarket(meishuAdInfo.getDirect_market()).setPackageName(meishuAdInfo.getPackage_name());
        com.meishu.sdk.meishu_ad.splash.d.this.H = meishuAdInfo.getIs_eyes();
        com.meishu.sdk.meishu_ad.splash.d.a appIntroUrl = packageName.setPosId(meishuAdInfo.getPid()).setPermissionUrl(meishuAdInfo.getApp_permission_url()).setPermisssList(meishuAdInfo.getApp_permission()).setAppIntroUrl(meishuAdInfo.getApp_intor_url());
        com.meishu.sdk.meishu_ad.splash.d.this.E = meishuAdInfo.getClk_type();
        com.meishu.sdk.meishu_ad.splash.d.a clickType = appIntroUrl.setClkArea(meishuAdInfo.getClk_area()).setClickType(meishuAdInfo.getClk_type());
        com.meishu.sdk.meishu_ad.splash.d.this.F = meishuAdInfo.getPower_index();
        com.meishu.sdk.meishu_ad.splash.d.a powerIndex2 = clickType.setPowerIndex2(meishuAdInfo.getPower_index2());
        com.meishu.sdk.meishu_ad.splash.d.this.G = meishuAdInfo.getPower_type();
        com.meishu.sdk.meishu_ad.splash.d.a interactionType = powerIndex2.setPowerCount(meishuAdInfo.getPower_count()).setPowerDelay(meishuAdInfo.getPower_delay()).setCid(meishuAdInfo.getCid()).setCat(meishuAdInfo.getCat()).setAderId(meishuAdInfo.getAder_id()).setImageUrls(meishuAdInfo.getSrcUrls()).setInteractionType(meishuAdInfo.getTarget_type());
        com.meishu.sdk.meishu_ad.splash.d.this.getClass();
        com.meishu.sdk.meishu_ad.splash.d.a dp_succ = interactionType.setDUrl(meishuAdInfo.getdUrl()).setAppName(meishuAdInfo.getApp_name()).setIcon(meishuAdInfo.getIcon()).setScore(meishuAdInfo.getScore()).setDeveloper(meishuAdInfo.getDeveloper()).setAppIntro(meishuAdInfo.getApp_intro()).setAppFeature(meishuAdInfo.getApp_feature()).setPaymentTypes(meishuAdInfo.getPayment_types()).setAppSize(meishuAdInfo.getApp_size()).setAppVer(meishuAdInfo.getApp_ver()).setAppPrivacy(meishuAdInfo.getApp_privacy()).setPrivacyAgreement(meishuAdInfo.getPrivacy_agreement()).setDeepLink(meishuAdInfo.getDeep_link()).setWx_username(meishuAdInfo.getWx_username()).setWx_path(meishuAdInfo.getWx_path()).setWxStart(meishuAdInfo.getWx_start()).setWxSuccess(meishuAdInfo.getWx_succ()).setWxFail(meishuAdInfo.getWx_fail()).setMonitorUrl(meishuAdInfo.getMonitorUrl()).setResponUrl(meishuAdInfo.getResponUrl()).setClickUrl(meishuAdInfo.getClickUrl()).setDn_start(meishuAdInfo.getDn_start()).setDn_succ(meishuAdInfo.getDn_succ()).setDn_inst_start(meishuAdInfo.getDn_inst_start()).setDn_inst_succ(meishuAdInfo.getDn_inst_succ()).setDn_active(meishuAdInfo.getDn_active()).setDp_start(meishuAdInfo.getDp_start()).setDp_fail(meishuAdInfo.getDp_fail()).setDp_succ(meishuAdInfo.getDp_succ());
        com.meishu.sdk.meishu_ad.splash.d.this.j = meishuAdInfo.getVideo_start();
        com.meishu.sdk.meishu_ad.splash.d.this.k = meishuAdInfo.getVideo_one_quarter();
        com.meishu.sdk.meishu_ad.splash.d.this.l = meishuAdInfo.getVideo_one_half();
        com.meishu.sdk.meishu_ad.splash.d.this.m = meishuAdInfo.getVideo_three_quarter();
        com.meishu.sdk.meishu_ad.splash.d.this.n = meishuAdInfo.getVideo_complete();
        com.meishu.sdk.meishu_ad.splash.d.this.o = meishuAdInfo.getVideo_pause();
        com.meishu.sdk.meishu_ad.splash.d.this.p = meishuAdInfo.getVideo_resume();
        com.meishu.sdk.meishu_ad.splash.d.this.r = meishuAdInfo.getVideo_mute();
        com.meishu.sdk.meishu_ad.splash.d.this.s = meishuAdInfo.getVideo_unmute();
        com.meishu.sdk.meishu_ad.splash.d.this.t = meishuAdInfo.getVideo_replay();
        com.meishu.sdk.meishu_ad.splash.d.a video_cover = dp_succ.setVideo_cover(meishuAdInfo.getVideo_cover());
        com.meishu.sdk.meishu_ad.splash.d.this.h = meishuAdInfo.getVideo_endcover();
        Long lValueOf = Long.valueOf(meishuAdInfo.getVideo_keep_time());
        com.meishu.sdk.meishu_ad.splash.d.this.i = lValueOf.longValue();
        com.meishu.sdk.meishu_ad.splash.d dVar = com.meishu.sdk.meishu_ad.splash.d.this;
        if (meishuAdInfo.getCreative_type() == 2 && meishuAdInfo.getSrcUrls() != null && meishuAdInfo.getSrcUrls().length > 0) {
            dVar.g = meishuAdInfo.getSrcUrls()[0];
        }
        return new com.meishu.sdk.platform.ms.splash.a(this, dVar);
    }

    public ViewGroup getAdContainer() {
        return this.adContainer;
    }

    @Override // com.meishu.sdk.core.loader.c
    public int getFetchDelay() {
        return this.fetchDelay;
    }

    public boolean getIsHideSkipBtn() {
        return this.hideSkipButton;
    }

    public boolean getVideoIsMute() {
        return this.isMute;
    }

    public boolean isSplashFullScreen() {
        return this.isSplashFullScreen;
    }

    @Override // com.meishu.sdk.core.loader.c, com.meishu.sdk.core.loader.IAdLoader
    public void loadAd() {
        loadAd((View) null);
    }

    public void loadAndShow() {
        loadAndShow((View) null);
    }

    @Override // com.meishu.sdk.core.loader.c
    public void clearErrorState() {
        e eVar = this.splashAdListenerAdapter;
        if (eVar != null) {
            eVar.b = false;
            eVar.c = false;
        }
    }

    public void loadAd(String str) {
        loadAd((View) null, str);
    }

    public void loadAndShow(String str) {
        loadAndShow(null, str);
    }

    public void loadAd(View view, String str) {
        HashMap map = new HashMap();
        map.put(KEY_SKIP_BUTTON, view);
        map.put(KEY_AUTO_SHOW, Boolean.FALSE);
        map.put(com.meishu.sdk.core.loader.c.KEY_TOKEN, str);
        super.loadAd(map);
    }

    public void loadAndShow(View view, String str) {
        if (this.adContainer != null) {
            HashMap map = new HashMap();
            map.put(com.meishu.sdk.core.loader.c.KEY_TOKEN, str);
            map.put(KEY_SKIP_BUTTON, view);
            map.put(KEY_AUTO_SHOW, Boolean.TRUE);
            super.loadAd(map);
            return;
        }
        throw new RuntimeException("无 adContainer 不支持自动展示");
    }

    public void loadAd(View view) {
        HashMap map = new HashMap();
        map.put(KEY_SKIP_BUTTON, view);
        map.put(KEY_AUTO_SHOW, Boolean.FALSE);
        super.loadAd(map);
    }

    public void loadAndShow(View view) {
        if (this.adContainer != null) {
            HashMap map = new HashMap();
            map.put(KEY_SKIP_BUTTON, view);
            map.put(KEY_AUTO_SHOW, Boolean.TRUE);
            super.loadAd(map);
            return;
        }
        throw new RuntimeException("无 adContainer 不支持自动展示");
    }

    public SplashAdLoader(Context context, ViewGroup viewGroup, MsAdSlot msAdSlot, SplashAdEventListener splashAdEventListener, int i) {
        this.isMute = true;
        if (msAdSlot == null) {
            LogUtil.e(TAG, "MsAdSlot is null");
            return;
        }
        this.accept_ad_width = Integer.valueOf(msAdSlot.getWidth());
        this.accept_ad_height = Integer.valueOf(msAdSlot.getHeight());
        this.isMute = msAdSlot.getIsMute();
        this.hideSkipButton = msAdSlot.getIsHideSkipButton();
        this.adContainer = viewGroup;
        this.fetchDelay = i;
        this.isSplashFullScreen = msAdSlot.isSplashFullScreen();
        this.channel = msAdSlot.getChannel();
        this.splashAdListenerAdapter = new e(this, splashAdEventListener);
        init(context, msAdSlot.getPid(), this.splashAdListenerAdapter);
    }
}
