package com.meishu.sdk.core.ad.paster;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.meishu.sdk.core.ad.MsAdSlot;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.meishu_ad.nativ.f;
import com.meishu.sdk.meishu_ad.nativ.f.a;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class PasterAdLoader extends com.meishu.sdk.core.loader.c<b> {
    private static final String TAG = "PasterAdLoader";
    private ViewGroup containerView;
    private c pasterAdListenerAdapter;

    public PasterAdLoader(Context context, ViewGroup viewGroup, MsAdSlot msAdSlot, PasterAdEventListener pasterAdEventListener) {
        if (msAdSlot == null) {
            LogUtil.e(TAG, "MsAdSlot is null");
            return;
        }
        this.accept_ad_width = Integer.valueOf(msAdSlot.getWidth());
        this.accept_ad_height = Integer.valueOf(msAdSlot.getHeight());
        this.channel = msAdSlot.getChannel();
        this.pasterAdListenerAdapter = new c(this, pasterAdEventListener);
        init(context, msAdSlot.getPid(), this.pasterAdListenerAdapter);
        this.containerView = viewGroup;
    }

    @Override // com.meishu.sdk.core.loader.c
    public com.meishu.sdk.core.loader.d createDelegate(SdkAdInfo sdkAdInfo, MeishuAdInfo meishuAdInfo) {
        if (sdkAdInfo != null) {
            return !TextUtils.isEmpty(sdkAdInfo.getCls()) ? com.meishu.sdk.core.a.a("CUSTOM").pasterLoader(this, sdkAdInfo, meishuAdInfo) : com.meishu.sdk.core.a.a(sdkAdInfo.getSdk()).pasterLoader(this, sdkAdInfo, meishuAdInfo);
        }
        return null;
    }

    @Override // com.meishu.sdk.core.loader.c
    public com.meishu.sdk.core.loader.d createMeishuAdDelegate(Context context, MeishuAdInfo meishuAdInfo) {
        f.a nop = new f().new a().setAppId(com.meishu.sdk.platform.ms.f.a().getAppId()).setWxAppId(meishuAdInfo.getWx_appid()).setScaleType(meishuAdInfo.getScale_type()).setEventUrl(meishuAdInfo.getEventUrl()).setWinUrl(meishuAdInfo.getWinUrl()).setLossUrl(meishuAdInfo.getLossUrl()).setActionDesc(meishuAdInfo.getAction_desc()).setScheme(meishuAdInfo.getScheme()).setDynamicMap(meishuAdInfo.getDynamicMap()).setFieldExport(meishuAdInfo.getFieldExport()).setAdg(meishuAdInfo.getAdg()).setAdp(meishuAdInfo.getAdp()).setDefImage(meishuAdInfo.getDefImage()).setDefaultCoord(meishuAdInfo.getDefault_coord()).setDpSign(meishuAdInfo.getDpsign()).setActExt(meishuAdInfo.getAct_ext()).setUob(meishuAdInfo.getUob()).setRs(meishuAdInfo.getRs()).setDPSIGN(meishuAdInfo.getDPSIGN()).setLoadedTime(meishuAdInfo.getLoadedTime()).setClickType(meishuAdInfo.getClk_type()).setClkArea(meishuAdInfo.getClk_area()).setPowerIndex(meishuAdInfo.getPower_index()).setPowerIndex2(meishuAdInfo.getPower_index2()).setExpireTimestamp(meishuAdInfo.getExpire_timestamp()).setEcpm(meishuAdInfo.getEcpm()).setDClickData(meishuAdInfo.getDclk()).setActType(meishuAdInfo.getAct_type()).setAdType(meishuAdInfo.getAd_type()).setCBC(meishuAdInfo.getCbc()).setNOP(meishuAdInfo.getNop());
        f.this.y = meishuAdInfo.getVideo_duration();
        f.a aderId = nop.setS_code(meishuAdInfo.getS_code()).setS_ext(meishuAdInfo.getS_ext()).setReqId(meishuAdInfo.getReq_id()).setFromId(meishuAdInfo.getFrom_id()).setDirectMarket(meishuAdInfo.getDirect_market()).setPackageName(meishuAdInfo.getPackage_name()).setPosId(meishuAdInfo.getPid()).setPermissionUrl(meishuAdInfo.getApp_permission_url()).setPermisssList(meishuAdInfo.getApp_permission()).setAppIntroUrl(meishuAdInfo.getApp_intor_url()).setCid(meishuAdInfo.getCid()).setCat(meishuAdInfo.getCat()).setAderId(meishuAdInfo.getAder_id());
        f.this.title = meishuAdInfo.getTitle();
        f.this.desc = meishuAdInfo.getContent();
        f.a interactionType = aderId.setInteractionType(meishuAdInfo.getTarget_type());
        f.this.f5047a = meishuAdInfo.getWidth();
        f.this.b = meishuAdInfo.getHeight();
        f.a dUrl = interactionType.setDUrl(meishuAdInfo.getdUrl());
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
        f.a adPatternType = dp_succ.setImageUrls(meishuAdInfo.getSrcUrls()).setVideo_cover(meishuAdInfo.getVideo_cover()).setClickid(meishuAdInfo.getClickid()).setAdPatternType(meishuAdInfo.getCreative_type());
        f.this.d = meishuAdInfo.getAction_text();
        f.a fromLogo = adPatternType.setFromLogo(meishuAdInfo.getFrom_logo());
        f.this.c = meishuAdInfo.getContent();
        f fVar = f.this;
        Integer numValueOf = Integer.valueOf(meishuAdInfo.getCreative_type());
        if (numValueOf.intValue() == 2 && meishuAdInfo.getSrcUrls() != null && meishuAdInfo.getSrcUrls().length > 0) {
            fVar.g = meishuAdInfo.getSrcUrls()[0];
        }
        if (numValueOf.intValue() == 1) {
            fVar.setImageUrls(meishuAdInfo.getSrcUrls());
        } else if (numValueOf.intValue() == 2 && meishuAdInfo.getSrcUrls() != null && meishuAdInfo.getSrcUrls().length > 0) {
            fVar.g = meishuAdInfo.getSrcUrls()[0];
        }
        return new com.meishu.sdk.platform.ms.paster.d(this, fVar, this.containerView);
    }

    public ViewGroup getContainerView() {
        return this.containerView;
    }

    public void loadAd(String str) {
        HashMap map = new HashMap();
        map.put(com.meishu.sdk.core.loader.c.KEY_TOKEN, str);
        super.loadAd(map);
    }

    @Override // com.meishu.sdk.core.loader.c
    public void clearErrorState() {
        c cVar = this.pasterAdListenerAdapter;
        if (cVar != null) {
            cVar.b = false;
            cVar.c = false;
        }
    }
}
