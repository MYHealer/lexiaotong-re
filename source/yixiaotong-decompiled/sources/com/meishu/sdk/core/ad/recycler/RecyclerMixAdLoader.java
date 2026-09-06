package com.meishu.sdk.core.ad.recycler;

import android.content.Context;
import android.text.TextUtils;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.MsAdPatternType;
import com.meishu.sdk.meishu_ad.nativ.f;
import com.meishu.sdk.meishu_ad.nativ.f.a;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RecyclerMixAdLoader extends com.meishu.sdk.core.loader.c<a> {
    private static final String TAG = "RecyclerMixAdLoader";
    private int fetchCount;
    private int fixedHeight;
    private boolean isNativeFeedUseShake;
    private boolean isVideoAutoPlay;
    private b recyclerAdListenerAdapter;
    public boolean showDetail;

    public RecyclerMixAdLoader(Context context, MsAdSlot msAdSlot, RecyclerAdEventListener recyclerAdEventListener) {
        this.fetchCount = 1;
        this.isVideoAutoPlay = true;
        if (msAdSlot == null) {
            LogUtil.e(TAG, "MsAdSlot is null");
            return;
        }
        this.accept_ad_width = Integer.valueOf(msAdSlot.getWidth());
        this.accept_ad_height = Integer.valueOf(msAdSlot.getHeight());
        this.showDetail = msAdSlot.getIsShowDetail();
        this.isVideoAutoPlay = msAdSlot.getIsVideoAutoPlay();
        this.fixedHeight = msAdSlot.getFixedHeight();
        this.fetchCount = msAdSlot.getFetchCount() > 0 ? msAdSlot.getFetchCount() : 1;
        this.channel = msAdSlot.getChannel();
        this.recyclerAdListenerAdapter = new b(this, recyclerAdEventListener);
        init(context, msAdSlot.getPid(), this.recyclerAdListenerAdapter);
    }

    private com.meishu.sdk.platform.ms.recycler.c newMeishuAdNativeWarapper(f fVar, MeishuAdInfo meishuAdInfo) {
        fVar.setImageUrls(meishuAdInfo.getSrcUrls());
        return new com.meishu.sdk.platform.ms.recycler.c(this, fVar);
    }

    @Override // com.meishu.sdk.core.loader.c
    public com.meishu.sdk.core.loader.d createDelegate(SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        if (AdSdk.isTestMode) {
            this.isVideoAutoPlay = meishuAdInfo.isVideoAutoPlay();
        }
        if (sdkAdInfo != null) {
            return !TextUtils.isEmpty(sdkAdInfo.getCls()) ? com.meishu.sdk.core.a.a("CUSTOM").recyclerLoader(this, sdkAdInfo, meishuAdInfo) : com.meishu.sdk.core.a.a(sdkAdInfo.getSdk()).recyclerLoader(this, sdkAdInfo, meishuAdInfo);
        }
        return null;
    }

    @Override // com.meishu.sdk.core.loader.c
    public com.meishu.sdk.core.loader.d createMeishuAdDelegate(Context context, MeishuAdInfo meishuAdInfo) {
        f.a nop = new f().new a().setAppId(com.meishu.sdk.platform.ms.f.a().getAppId()).setWxAppId(meishuAdInfo.getWx_appid()).setScaleType(meishuAdInfo.getScale_type()).setEventUrl(meishuAdInfo.getEventUrl()).setWinUrl(meishuAdInfo.getWinUrl()).setLossUrl(meishuAdInfo.getLossUrl()).setActionDesc(meishuAdInfo.getAction_desc()).setScheme(meishuAdInfo.getScheme()).setDynamicMap(meishuAdInfo.getDynamicMap()).setFieldExport(meishuAdInfo.getFieldExport()).setAdg(meishuAdInfo.getAdg()).setAdp(meishuAdInfo.getAdp()).setDefImage(meishuAdInfo.getDefImage()).setDefaultCoord(meishuAdInfo.getDefault_coord()).setDpSign(meishuAdInfo.getDpsign()).setActExt(meishuAdInfo.getAct_ext()).setUob(meishuAdInfo.getUob()).setRs(meishuAdInfo.getRs()).setDPSIGN(meishuAdInfo.getDPSIGN()).setNativeSE(meishuAdInfo.getNative_s_e()).setLoadedTime(meishuAdInfo.getLoadedTime()).setClickType(meishuAdInfo.getClk_type()).setClkArea(meishuAdInfo.getClk_area()).setPowerIndex(meishuAdInfo.getPower_index()).setPowerIndex2(meishuAdInfo.getPower_index2()).setPowerDelay(meishuAdInfo.getPower_delay()).setPowerCount(meishuAdInfo.getPower_count()).setExpireTimestamp(meishuAdInfo.getExpire_timestamp()).setEcpm(meishuAdInfo.getEcpm()).setDClickData(meishuAdInfo.getDclk()).setActType(meishuAdInfo.getAct_type()).setExtend_up(meishuAdInfo.getExtend_up()).setExtend_down(meishuAdInfo.getExtend_down()).setExtend_left(meishuAdInfo.getExtend_left()).setExtend_right(meishuAdInfo.getExtend_right()).setExtend_interval(meishuAdInfo.getExtend_interval()).setExtend_max_count(meishuAdInfo.getExtend_max_count()).setAdType(meishuAdInfo.getAd_type()).setCBC(meishuAdInfo.getCbc()).setNOP(meishuAdInfo.getNop());
        f.this.y = meishuAdInfo.getVideo_duration();
        f.a appIntroUrl = nop.setS_code(meishuAdInfo.getS_code()).setS_ext(meishuAdInfo.getS_ext()).setReqId(meishuAdInfo.getReq_id()).setFromId(meishuAdInfo.getFrom_id()).setDirectMarket(meishuAdInfo.getDirect_market()).setPackageName(meishuAdInfo.getPackage_name()).setPosId(meishuAdInfo.getPid()).setPermissionUrl(meishuAdInfo.getApp_permission_url()).setPermisssList(meishuAdInfo.getApp_permission()).setAppIntroUrl(meishuAdInfo.getApp_intor_url());
        f.this.x = meishuAdInfo.getStyle_id();
        f.a aderId = appIntroUrl.setCid(meishuAdInfo.getCid()).setCat(meishuAdInfo.getCat()).setAderId(meishuAdInfo.getAder_id());
        f.this.title = meishuAdInfo.getTitle();
        f.this.desc = meishuAdInfo.getContent();
        f.a interactionType = aderId.setInteractionType(meishuAdInfo.getTarget_type());
        f.this.f5047a = meishuAdInfo.getWidth();
        f.this.b = meishuAdInfo.getHeight();
        f.a drawing = interactionType.setDrawing(meishuAdInfo.getDrawing());
        f.this.z = meishuAdInfo.isVideoAutoPlay();
        f.this.A = meishuAdInfo.isVideoMute();
        f.this.getClass();
        f.a dUrl = drawing.setDUrl(meishuAdInfo.getdUrl());
        f.this.appName = meishuAdInfo.getApp_name();
        f.a dp_succ = dUrl.setIcon(meishuAdInfo.getIcon()).setScore(meishuAdInfo.getScore()).setDeveloper(meishuAdInfo.getDeveloper()).setAppIntro(meishuAdInfo.getApp_intro()).setAppFeature(meishuAdInfo.getApp_feature()).setPaymentTypes(meishuAdInfo.getPayment_types()).setAppSize(meishuAdInfo.getApp_size()).setAppVer(meishuAdInfo.getApp_ver()).setAppPrivacy(meishuAdInfo.getApp_privacy()).setPrivacyAgreement(meishuAdInfo.getPrivacy_agreement()).setDeepLink(meishuAdInfo.getDeep_link()).setWx_username(meishuAdInfo.getWx_username()).setWx_path(meishuAdInfo.getWx_path()).setWxStart(meishuAdInfo.getWx_start()).setWxSuccess(meishuAdInfo.getWx_succ()).setWxFail(meishuAdInfo.getWx_fail()).setMonitorUrl(meishuAdInfo.getMonitorUrl()).setResponUrl(meishuAdInfo.getResponUrl()).setClickUrl(meishuAdInfo.getClickUrl()).setDn_start(meishuAdInfo.getDn_start()).setDn_succ(meishuAdInfo.getDn_succ()).setDn_inst_start(meishuAdInfo.getDn_inst_start()).setDn_inst_succ(meishuAdInfo.getDn_inst_succ()).setDn_active(meishuAdInfo.getDn_active()).setDp_start(meishuAdInfo.getDp_start()).setDp_fail(meishuAdInfo.getDp_fail()).setDp_succ(meishuAdInfo.getDp_succ());
        f.this.j = meishuAdInfo.getVideo_start();
        f.this.k = meishuAdInfo.getVideo_one_quarter();
        f.this.l = meishuAdInfo.getVideo_one_half();
        f.this.m = meishuAdInfo.getVideo_three_quarter();
        f.this.n = meishuAdInfo.getVideo_complete();
        f.this.o = meishuAdInfo.getVideo_pause();
        f.this.p = meishuAdInfo.getVideo_resume();
        f.this.q = meishuAdInfo.getVideo_skip();
        f.this.u = meishuAdInfo.getVideo_close();
        f.this.r = meishuAdInfo.getVideo_mute();
        f.this.s = meishuAdInfo.getVideo_unmute();
        f.this.t = meishuAdInfo.getVideo_replay();
        f.a packageName = dp_succ.setImageUrls(meishuAdInfo.getSrcUrls()).setVideo_cover(meishuAdInfo.getVideo_cover()).setClickid(meishuAdInfo.getClickid()).setPackageName(meishuAdInfo.getPackage_name());
        f.this.c = meishuAdInfo.getContent();
        f.this.d = meishuAdInfo.getAction_text();
        f.this.iconUrl = meishuAdInfo.getIcon();
        f.this.e = meishuAdInfo.getIcon_title();
        f.a fromLogo = packageName.setFromLogo(meishuAdInfo.getFrom_logo());
        f.this.f = meishuAdInfo.getFrom();
        f fVar = f.this;
        int creative_type = meishuAdInfo.getCreative_type();
        fVar.adPatternType = creative_type;
        if (creative_type == 1 || creative_type == 11 || creative_type == 12 || creative_type == 13) {
            return newMeishuAdNativeWarapper(fVar, meishuAdInfo);
        }
        if (creative_type != 2) {
            LogUtil.e(TAG, "不支持的创意类型，类型标识为[" + creative_type + "]");
            return newMeishuAdNativeWarapper(fVar, meishuAdInfo);
        }
        if (meishuAdInfo.getSrcUrls() != null && meishuAdInfo.getSrcUrls().length > 0) {
            fVar.g = meishuAdInfo.getSrcUrls()[0];
        }
        return new com.meishu.sdk.platform.ms.recycler.c(this, fVar);
    }

    public int getAdPatternType() {
        return MsAdPatternType.MIX_RENDER;
    }

    public int getFetchCount() {
        return this.fetchCount;
    }

    public int getFixedHeight() {
        return this.fixedHeight;
    }

    public boolean getIsVideoAutoPlay() {
        return this.isVideoAutoPlay;
    }

    public boolean isNativeFeedUseShake() {
        return this.isNativeFeedUseShake;
    }

    public boolean isShowDetail() {
        return this.showDetail;
    }

    public void loadAd(String str) {
        HashMap map = new HashMap();
        map.put(com.meishu.sdk.core.loader.c.KEY_TOKEN, str);
        super.loadAd(map);
    }

    @Override // com.meishu.sdk.core.loader.c
    public void clearErrorState() {
        b bVar = this.recyclerAdListenerAdapter;
        if (bVar != null) {
            bVar.b = false;
            bVar.c = false;
        }
    }
}
