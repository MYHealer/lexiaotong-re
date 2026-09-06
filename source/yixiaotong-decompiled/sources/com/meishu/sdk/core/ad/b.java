package com.meishu.sdk.core.ad;

import android.content.Context;
import com.meishu.sdk.activity.MeishuRewardH5Activity;
import com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.loader.IAdLoadListener;
import com.meishu.sdk.core.loader.c;
import com.meishu.sdk.core.loader.d;
import com.meishu.sdk.meishu_ad.nativ.f;
import com.meishu.sdk.meishu_ad.nativ.f.a;
import java.util.ArrayList;

/* JADX INFO: compiled from: BaseFullScreenVideoAdLoader.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class b<T extends IAdLoadListener> extends c<T> {
    private static final String TAG = "BaseFullScreenVideoAdLoader";
    private boolean isMute;
    private ArrayList<String> mediaViewIdList = new ArrayList<>();

    public void addRewardMediaViewLocalId(String str) {
        this.mediaViewIdList.add(str);
    }

    @Override // com.meishu.sdk.core.loader.c
    public d createMeishuAdDelegate(Context context, MeishuAdInfo meishuAdInfo) {
        f.a aderId = new f().new a().setAppId(com.meishu.sdk.platform.ms.f.a().getAppId()).setWxAppId(meishuAdInfo.getWx_appid()).setScaleType(meishuAdInfo.getScale_type()).setEventUrl(meishuAdInfo.getEventUrl()).setWinUrl(meishuAdInfo.getWinUrl()).setLossUrl(meishuAdInfo.getLossUrl()).setActionDesc(meishuAdInfo.getAction_desc()).setScheme(meishuAdInfo.getScheme()).setDynamicMap(meishuAdInfo.getDynamicMap()).setFieldExport(meishuAdInfo.getFieldExport()).setAdg(meishuAdInfo.getAdg()).setAdp(meishuAdInfo.getAdp()).setDefImage(meishuAdInfo.getDefImage()).setDefaultCoord(meishuAdInfo.getDefault_coord()).setDpSign(meishuAdInfo.getDpsign()).setActExt(meishuAdInfo.getAct_ext()).setUob(meishuAdInfo.getUob()).setRs(meishuAdInfo.getRs()).setDPSIGN(meishuAdInfo.getDPSIGN()).setRewardTmpUrl(meishuAdInfo.getReward_tmp_url()).setRewardTmpType(meishuAdInfo.getReward_tmp_type()).setRewardTmpTime(meishuAdInfo.getReward_tmp_time()).setRewardTmpId(meishuAdInfo.getRewardTmpId()).setLoadedTime(meishuAdInfo.getLoadedTime()).setClickType(meishuAdInfo.getClk_type()).setPowerCount(meishuAdInfo.getPower_count()).setPowerDelay(meishuAdInfo.getPower_delay()).setClkArea(meishuAdInfo.getClk_area()).setPowerIndex(meishuAdInfo.getPower_index()).setPowerIndex2(meishuAdInfo.getPower_index2()).setExpireTimestamp(meishuAdInfo.getExpire_timestamp()).setEcpm(meishuAdInfo.getEcpm()).setDClickData(meishuAdInfo.getDclk()).setActType(meishuAdInfo.getAct_type()).setAdType(meishuAdInfo.getAd_type()).setCBC(meishuAdInfo.getCbc()).setNOP(meishuAdInfo.getNop()).setS_code(meishuAdInfo.getS_code()).setS_ext(meishuAdInfo.getS_ext()).setReqId(meishuAdInfo.getReq_id()).setFromId(meishuAdInfo.getFrom_id()).setDirectMarket(meishuAdInfo.getDirect_market()).setPackageName(meishuAdInfo.getPackage_name()).setPosId(meishuAdInfo.getPid()).setPermissionUrl(meishuAdInfo.getApp_permission_url()).setPermisssList(meishuAdInfo.getApp_permission()).setAppIntroUrl(meishuAdInfo.getApp_intor_url()).setCid(meishuAdInfo.getCid()).setCat(meishuAdInfo.getCat()).setAderId(meishuAdInfo.getAder_id());
        f.this.title = meishuAdInfo.getTitle();
        f.this.desc = meishuAdInfo.getContent();
        f.this.iconUrl = meishuAdInfo.getIcon();
        f.a interactionType = aderId.setInteractionType(meishuAdInfo.getTarget_type());
        f.this.f5047a = meishuAdInfo.getWidth();
        f.this.b = meishuAdInfo.getHeight();
        f.a video_cover = interactionType.setDUrl(meishuAdInfo.getdUrl()).setVideo_cover(meishuAdInfo.getVideo_cover());
        f.this.h = meishuAdInfo.getVideo_endcover();
        f.this.i = meishuAdInfo.getVideo_keep_time();
        f.this.appName = meishuAdInfo.getApp_name();
        f.a dp_succ = video_cover.setIcon(meishuAdInfo.getIcon()).setScore(meishuAdInfo.getScore()).setDeveloper(meishuAdInfo.getDeveloper()).setAppIntro(meishuAdInfo.getApp_intro()).setAppFeature(meishuAdInfo.getApp_feature()).setPaymentTypes(meishuAdInfo.getPayment_types()).setAppSize(meishuAdInfo.getApp_size()).setAppVer(meishuAdInfo.getApp_ver()).setAppPrivacy(meishuAdInfo.getApp_privacy()).setPrivacyAgreement(meishuAdInfo.getPrivacy_agreement()).setDeepLink(meishuAdInfo.getDeep_link()).setWx_username(meishuAdInfo.getWx_username()).setWx_path(meishuAdInfo.getWx_path()).setWxStart(meishuAdInfo.getWx_start()).setWxSuccess(meishuAdInfo.getWx_succ()).setWxFail(meishuAdInfo.getWx_fail()).setMonitorUrl(meishuAdInfo.getMonitorUrl()).setResponUrl(meishuAdInfo.getResponUrl()).setClickUrl(meishuAdInfo.getClickUrl()).setDn_start(meishuAdInfo.getDn_start()).setDn_succ(meishuAdInfo.getDn_succ()).setDn_inst_start(meishuAdInfo.getDn_inst_start()).setDn_inst_succ(meishuAdInfo.getDn_inst_succ()).setDn_active(meishuAdInfo.getDn_active()).setDp_start(meishuAdInfo.getDp_start()).setDp_fail(meishuAdInfo.getDp_fail()).setDp_succ(meishuAdInfo.getDp_succ());
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
        f.a clickid = dp_succ.setImageUrls(meishuAdInfo.getSrcUrls()).setClickid(meishuAdInfo.getClickid());
        f.this.d = meishuAdInfo.getAction_text();
        f.a drawing = clickid.setFromLogo(meishuAdInfo.getFrom_logo()).setDrawing(meishuAdInfo.getDrawing());
        f.this.v = meishuAdInfo.getClickable_range();
        f.this.w = meishuAdInfo.getClose_btn();
        f.this.c = meishuAdInfo.getContent();
        f.a errorUrl = drawing.setErrorUrl(meishuAdInfo.getErrorUrl());
        f.this.title = meishuAdInfo.getTitle();
        f.this.desc = meishuAdInfo.getContent();
        f.this.iconUrl = meishuAdInfo.getIcon();
        f fVar = f.this;
        int creative_type = meishuAdInfo.getCreative_type();
        fVar.adPatternType = creative_type;
        if (creative_type != 2) {
            fVar.setImageUrls(meishuAdInfo.getSrcUrls());
            return createMeishuAdDelegateInternal(fVar);
        }
        if (meishuAdInfo.getSrcUrls() != null && meishuAdInfo.getSrcUrls().length > 0) {
            fVar.g = meishuAdInfo.getSrcUrls()[0];
        }
        return createMeishuAdDelegateInternal(fVar);
    }

    public abstract d createMeishuAdDelegateInternal(f fVar);

    @Override // com.meishu.sdk.core.loader.c, com.meishu.sdk.core.loader.IAdLoader
    public void destroy() {
        MeishuRewardVideoPlayerActivity.clearRewardMediaView();
        MeishuRewardH5Activity.clear();
    }

    public boolean getVideoIsMute() {
        return this.isMute;
    }

    public void setVideoIsMute(boolean z) {
        this.isMute = z;
    }
}
