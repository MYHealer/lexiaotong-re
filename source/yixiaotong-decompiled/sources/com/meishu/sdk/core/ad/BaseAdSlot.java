package com.meishu.sdk.core.ad;

import android.text.TextUtils;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.platform.ms.splash.ShakeResult;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BaseAdSlot implements AdSlot {
    private String act_ext;
    private String action_desc;
    public int adPatternType;
    private int ad_type;
    private String ader_id;
    private int adg;
    private int adp;
    public String appId;
    public String appName;
    private String app_feature;
    private String app_intor_url;
    private String app_intro;
    private List<MeishuAdInfo.PermissionBean> app_permission;
    private String app_permission_url;
    private String app_privacy;
    private String app_size;
    private String app_ver;
    private String cat;
    private int cbc;
    private String cid;
    public String[] clickUrl;
    public String clickid;
    private int clkActType;
    private int clkPower;
    private String clk_area;
    private String[] closeUrl;
    public int comments;
    public String[] dUrl;
    private MeishuAdInfo.DClickData dclk;
    public String deep_link;
    private String defImage;
    private String default_coord;
    public String desc;
    private String developer;
    private int direct_market;
    public String[] dn_active;
    public String[] dn_inst_start;
    public String[] dn_inst_succ;
    public String[] dn_start;
    public String[] dn_succ;
    public int downNum;
    private String dpSign;
    public String[] dp_fail;
    public String[] dp_start;
    public String[] dp_succ;
    private String dpsign;
    private HashMap<String, String> dynamicMap;
    private int ecpm;
    private String[] errorUrl;
    private String[] eventUrl;
    private int expire_timestamp;
    private int extend_down;
    private int extend_interval;
    private int extend_left;
    private int extend_max_count;
    private int extend_right;
    private int extend_up;
    private Integer fieldExport;
    public String fromLogo;
    public String from_id;
    private String h5_ext;
    private String h5_url;
    private String icon;
    public String iconUrl;
    public String[] imageUrls;
    public int interactionType;
    private boolean isAdClosed;
    private boolean isClkDynamic;
    private boolean isRewardBrowserOpenLandingPage;
    private long loadedTime;
    private String[] lossUrl;
    private int material_timeout;
    public String[] monitorUrl;
    private int nativeSE;
    private int nop;
    public String packageName;
    private String payment_types;
    public String posId;
    private int power_count;
    private int power_delay;
    private int power_index;
    private int power_index2;
    private String privacy_agreement;
    private String req_id;
    public String[] responUrl;
    private int reward_tmp_id;
    private int reward_tmp_time;
    private int reward_tmp_type;
    private String reward_tmp_url;
    private Integer rs;
    private String s_code;
    private String s_ext;
    private String scheme;
    public float score;
    private ShakeResult shakeResult;
    private int skipBtnLocation;
    public String title;
    private Integer uob;
    public String video_cover;
    private int webTempId;
    private String webTempUrl;
    private String[] winUrl;
    private String wx_appid;
    private String[] wx_fail;
    private String wx_path;
    private String[] wx_start;
    private String[] wx_succ;
    private String wx_username;
    private int clk_type = 3;
    private int drawing = 2;
    private int act_type = 2;
    private int scale_type = -1;
    private AppendInfo appendInfo = new AppendInfo();

    public static class AppendInfo implements Serializable {
        private static final long serialVersionUID = 1;
        private volatile boolean hasClickedSkip;
        private volatile boolean hasExposed;
        private volatile boolean hasTimeOver;
        private volatile boolean hasVideoStart;
        private final com.meishu.sdk.core.utils.b hasClicked = new com.meishu.sdk.core.utils.b();
        private final com.meishu.sdk.core.utils.b resLoadSuccess = new com.meishu.sdk.core.utils.b();
        private final ClickExtInfo clickExtInfo = new ClickExtInfo();

        public ClickExtInfo getClickExtInfo() {
            return this.clickExtInfo;
        }

        public com.meishu.sdk.core.utils.b getHasClicked() {
            return this.hasClicked;
        }

        public com.meishu.sdk.core.utils.b getResLoadSuccess() {
            return this.resLoadSuccess;
        }

        public boolean isHasClickedSkip() {
            return this.hasClickedSkip;
        }

        public boolean isHasExposed() {
            return this.hasExposed;
        }

        public boolean isHasTimeOver() {
            return this.hasTimeOver;
        }

        public boolean isHasVideoStart() {
            return this.hasVideoStart;
        }

        public void setHasClicked(boolean z) {
            this.hasClicked.a(z);
        }

        public void setHasClickedSkip(boolean z) {
            this.hasClickedSkip = z;
        }

        public void setHasExposed(boolean z) {
            this.hasExposed = z;
        }

        public void setHasTimeOver(boolean z) {
            this.hasTimeOver = z;
        }

        public void setHasVideoStart(boolean z) {
            this.hasVideoStart = z;
        }
    }

    public abstract class Builder<T extends Builder, K extends BaseAdSlot> {
        public Builder() {
        }

        public abstract K build();

        public abstract T returnThis();

        public T setActExt(String str) {
            BaseAdSlot.this.act_ext = str;
            return (T) returnThis();
        }

        public T setActType(int i) {
            BaseAdSlot.this.act_type = i;
            return (T) returnThis();
        }

        public T setActionDesc(String str) {
            BaseAdSlot.this.action_desc = str;
            return (T) returnThis();
        }

        public T setAdPatternType(int i) {
            BaseAdSlot.this.adPatternType = i;
            return (T) returnThis();
        }

        public T setAdType(int i) {
            BaseAdSlot.this.ad_type = i;
            return (T) returnThis();
        }

        public T setAderId(String str) {
            BaseAdSlot.this.ader_id = str;
            return (T) returnThis();
        }

        public T setAdg(int i) {
            BaseAdSlot.this.adg = i;
            return (T) returnThis();
        }

        public T setAdp(int i) {
            BaseAdSlot.this.adp = i;
            return (T) returnThis();
        }

        public T setAppFeature(String str) {
            BaseAdSlot.this.app_feature = str;
            return (T) returnThis();
        }

        public T setAppId(String str) {
            BaseAdSlot.this.appId = str;
            return (T) returnThis();
        }

        public T setAppIntro(String str) {
            BaseAdSlot.this.app_intro = str;
            return (T) returnThis();
        }

        public T setAppIntroUrl(String str) {
            BaseAdSlot.this.app_intor_url = str;
            return (T) returnThis();
        }

        public T setAppName(String str) {
            BaseAdSlot.this.appName = str;
            return (T) returnThis();
        }

        public T setAppPrivacy(String str) {
            BaseAdSlot.this.app_privacy = str;
            return (T) returnThis();
        }

        public T setAppSize(String str) {
            BaseAdSlot.this.app_size = str;
            return (T) returnThis();
        }

        public T setAppVer(String str) {
            BaseAdSlot.this.app_ver = str;
            return (T) returnThis();
        }

        public T setCBC(int i) {
            BaseAdSlot.this.cbc = i;
            return (T) returnThis();
        }

        public T setCat(String str) {
            BaseAdSlot.this.cat = str;
            return (T) returnThis();
        }

        public T setCid(String str) {
            BaseAdSlot.this.cid = str;
            return (T) returnThis();
        }

        public T setClickType(int i) {
            BaseAdSlot.this.clk_type = i;
            return (T) returnThis();
        }

        public T setClickUrl(String[] strArr) {
            BaseAdSlot.this.clickUrl = strArr;
            return (T) returnThis();
        }

        public T setClickid(String str) {
            BaseAdSlot.this.clickid = str;
            return (T) returnThis();
        }

        public T setClkArea(String str) {
            BaseAdSlot.this.clk_area = str;
            return (T) returnThis();
        }

        public T setCloseUrl(String[] strArr) {
            BaseAdSlot.this.closeUrl = strArr;
            return (T) returnThis();
        }

        public T setComments(int i) {
            BaseAdSlot.this.comments = i;
            return (T) returnThis();
        }

        public T setDClickData(MeishuAdInfo.DClickData dClickData) {
            BaseAdSlot.this.dclk = dClickData;
            return (T) returnThis();
        }

        public T setDPSIGN(String str) {
            BaseAdSlot.this.dpSign = str;
            return (T) returnThis();
        }

        public T setDUrl(String[] strArr) {
            BaseAdSlot.this.dUrl = strArr;
            return (T) returnThis();
        }

        public T setDeepLink(String str) {
            BaseAdSlot.this.deep_link = str;
            return (T) returnThis();
        }

        public T setDefImage(String str) {
            BaseAdSlot.this.defImage = str;
            return (T) returnThis();
        }

        public T setDefaultCoord(String str) {
            BaseAdSlot.this.default_coord = str;
            return (T) returnThis();
        }

        public T setDesc(String str) {
            BaseAdSlot.this.desc = str;
            return (T) returnThis();
        }

        public T setDeveloper(String str) {
            BaseAdSlot.this.developer = str;
            return (T) returnThis();
        }

        public T setDirectMarket(int i) {
            BaseAdSlot.this.direct_market = i;
            return (T) returnThis();
        }

        public T setDn_active(String[] strArr) {
            BaseAdSlot.this.dn_active = strArr;
            return (T) returnThis();
        }

        public T setDn_inst_start(String[] strArr) {
            BaseAdSlot.this.dn_inst_start = strArr;
            return (T) returnThis();
        }

        public T setDn_inst_succ(String[] strArr) {
            BaseAdSlot.this.dn_inst_succ = strArr;
            return (T) returnThis();
        }

        public T setDn_start(String[] strArr) {
            BaseAdSlot.this.dn_start = strArr;
            return (T) returnThis();
        }

        public T setDn_succ(String[] strArr) {
            BaseAdSlot.this.dn_succ = strArr;
            return (T) returnThis();
        }

        public T setDownNum(int i) {
            BaseAdSlot.this.downNum = i;
            return (T) returnThis();
        }

        public T setDpSign(String str) {
            BaseAdSlot.this.dpsign = str;
            return (T) returnThis();
        }

        public T setDp_fail(String[] strArr) {
            BaseAdSlot.this.dp_fail = strArr;
            return (T) returnThis();
        }

        public T setDp_start(String[] strArr) {
            BaseAdSlot.this.dp_start = strArr;
            return (T) returnThis();
        }

        public T setDp_succ(String[] strArr) {
            BaseAdSlot.this.dp_succ = strArr;
            return (T) returnThis();
        }

        public T setDrawing(int i) {
            BaseAdSlot.this.drawing = i;
            return (T) returnThis();
        }

        public T setDynamicMap(HashMap<String, String> map) {
            BaseAdSlot.this.dynamicMap = map;
            return (T) returnThis();
        }

        public T setEcpm(int i) {
            BaseAdSlot.this.ecpm = i;
            return (T) returnThis();
        }

        public T setErrorUrl(String[] strArr) {
            BaseAdSlot.this.errorUrl = strArr;
            return (T) returnThis();
        }

        public T setEventUrl(String[] strArr) {
            BaseAdSlot.this.eventUrl = strArr;
            return (T) returnThis();
        }

        public T setExpireTimestamp(int i) {
            BaseAdSlot.this.expire_timestamp = i;
            return (T) returnThis();
        }

        public T setExtend_down(int i) {
            BaseAdSlot.this.extend_down = i;
            return (T) returnThis();
        }

        public T setExtend_interval(int i) {
            BaseAdSlot.this.extend_interval = i;
            return (T) returnThis();
        }

        public T setExtend_left(int i) {
            BaseAdSlot.this.extend_left = i;
            return (T) returnThis();
        }

        public T setExtend_max_count(int i) {
            BaseAdSlot.this.extend_max_count = i;
            return (T) returnThis();
        }

        public T setExtend_right(int i) {
            BaseAdSlot.this.extend_right = i;
            return (T) returnThis();
        }

        public T setExtend_up(int i) {
            BaseAdSlot.this.extend_up = i;
            return (T) returnThis();
        }

        public T setFieldExport(Integer num) {
            BaseAdSlot.this.fieldExport = num;
            return (T) returnThis();
        }

        public T setFromId(String str) {
            BaseAdSlot.this.from_id = str;
            return (T) returnThis();
        }

        public T setFromLogo(String str) {
            BaseAdSlot.this.fromLogo = str;
            return (T) returnThis();
        }

        public T setH5Ext(String str) {
            BaseAdSlot.this.h5_ext = str;
            return (T) returnThis();
        }

        public T setH5Url(String str) {
            BaseAdSlot.this.h5_url = str;
            return (T) returnThis();
        }

        public T setIcon(String str) {
            BaseAdSlot.this.icon = str;
            return (T) returnThis();
        }

        public T setIconUrl(String str) {
            BaseAdSlot.this.iconUrl = str;
            return (T) returnThis();
        }

        public T setImageUrls(String[] strArr) {
            BaseAdSlot.this.imageUrls = strArr;
            return (T) returnThis();
        }

        public T setInteractionType(int i) {
            BaseAdSlot.this.interactionType = i;
            return (T) returnThis();
        }

        public T setLoadedTime(long j) {
            BaseAdSlot.this.loadedTime = j;
            return (T) returnThis();
        }

        public T setLossUrl(String[] strArr) {
            BaseAdSlot.this.lossUrl = strArr;
            return (T) returnThis();
        }

        public T setMaterialTimeout(int i) {
            BaseAdSlot.this.material_timeout = i;
            return (T) returnThis();
        }

        public T setMonitorUrl(String[] strArr) {
            BaseAdSlot.this.monitorUrl = strArr;
            return (T) returnThis();
        }

        public T setNOP(int i) {
            BaseAdSlot.this.nop = i;
            return (T) returnThis();
        }

        public T setNativeSE(int i) {
            BaseAdSlot.this.nativeSE = i;
            return (T) returnThis();
        }

        public T setPackageName(String str) {
            BaseAdSlot.this.packageName = str;
            return (T) returnThis();
        }

        public T setPaymentTypes(String str) {
            BaseAdSlot.this.payment_types = str;
            return (T) returnThis();
        }

        public T setPermissionUrl(String str) {
            BaseAdSlot.this.app_permission_url = str;
            return (T) returnThis();
        }

        public T setPermisssList(List<MeishuAdInfo.PermissionBean> list) {
            BaseAdSlot.this.app_permission = list;
            return (T) returnThis();
        }

        public T setPosId(String str) {
            BaseAdSlot.this.posId = str;
            return (T) returnThis();
        }

        public T setPowerCount(int i) {
            BaseAdSlot.this.power_count = i;
            return (T) returnThis();
        }

        public T setPowerDelay(int i) {
            BaseAdSlot.this.power_delay = i;
            return (T) returnThis();
        }

        public T setPowerIndex(int i) {
            BaseAdSlot.this.power_index = i;
            return (T) returnThis();
        }

        public T setPowerIndex2(int i) {
            BaseAdSlot.this.power_index2 = i;
            return (T) returnThis();
        }

        public T setPrivacyAgreement(String str) {
            BaseAdSlot.this.privacy_agreement = str;
            return (T) returnThis();
        }

        public T setReqId(String str) {
            BaseAdSlot.this.req_id = str;
            return (T) returnThis();
        }

        public T setResponUrl(String[] strArr) {
            BaseAdSlot.this.responUrl = strArr;
            return (T) returnThis();
        }

        public T setRewardTmpId(int i) {
            BaseAdSlot.this.reward_tmp_id = i;
            return (T) returnThis();
        }

        public T setRewardTmpTime(int i) {
            BaseAdSlot.this.reward_tmp_time = i;
            return (T) returnThis();
        }

        public T setRewardTmpType(int i) {
            BaseAdSlot.this.reward_tmp_type = i;
            return (T) returnThis();
        }

        public T setRewardTmpUrl(String str) {
            BaseAdSlot.this.reward_tmp_url = str;
            return (T) returnThis();
        }

        public T setRs(Integer num) {
            BaseAdSlot.this.rs = num;
            return (T) returnThis();
        }

        public T setS_code(String str) {
            BaseAdSlot.this.s_code = str;
            return (T) returnThis();
        }

        public T setS_ext(String str) {
            BaseAdSlot.this.s_ext = str;
            return (T) returnThis();
        }

        public T setScaleType(int i) {
            BaseAdSlot.this.scale_type = i;
            return (T) returnThis();
        }

        public T setScheme(String str) {
            BaseAdSlot.this.scheme = str;
            return (T) returnThis();
        }

        public T setScore(float f) {
            BaseAdSlot.this.score = f;
            return (T) returnThis();
        }

        public T setSkipBtnLocation(int i) {
            BaseAdSlot.this.skipBtnLocation = i;
            return (T) returnThis();
        }

        public T setTitle(String str) {
            BaseAdSlot.this.title = str;
            return (T) returnThis();
        }

        public T setUob(Integer num) {
            BaseAdSlot.this.uob = num;
            return (T) returnThis();
        }

        public T setVideo_cover(String str) {
            BaseAdSlot.this.video_cover = str;
            return (T) returnThis();
        }

        public T setWebTempId(int i) {
            BaseAdSlot.this.webTempId = i;
            return (T) returnThis();
        }

        public T setWebTempUrl(String str) {
            BaseAdSlot.this.webTempUrl = str;
            return (T) returnThis();
        }

        public T setWinUrl(String[] strArr) {
            BaseAdSlot.this.winUrl = strArr;
            return (T) returnThis();
        }

        public T setWxAppId(String str) {
            BaseAdSlot.this.wx_appid = str;
            return (T) returnThis();
        }

        public T setWxFail(String[] strArr) {
            BaseAdSlot.this.wx_fail = strArr;
            return (T) returnThis();
        }

        public T setWxStart(String[] strArr) {
            BaseAdSlot.this.wx_start = strArr;
            return (T) returnThis();
        }

        public T setWxSuccess(String[] strArr) {
            BaseAdSlot.this.wx_succ = strArr;
            return (T) returnThis();
        }

        public T setWx_path(String str) {
            BaseAdSlot.this.wx_path = str;
            return (T) returnThis();
        }

        public T setWx_username(String str) {
            BaseAdSlot.this.wx_username = str;
            return (T) returnThis();
        }
    }

    private void clearClickExtInfo() {
        try {
            getAppendInfo().getClickExtInfo().clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAct_ext() {
        return this.act_ext;
    }

    public int getAct_type() {
        return this.act_type;
    }

    public String getAction_desc() {
        return this.action_desc;
    }

    public int getAdPatternType() {
        return this.adPatternType;
    }

    public int getAd_type() {
        return this.ad_type;
    }

    public String getAder_id() {
        return this.ader_id;
    }

    public int getAdg() {
        return this.adg;
    }

    public int getAdp() {
        return this.adp;
    }

    public String getAppId() {
        return this.appId;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String getAppName() {
        return this.appName;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String getApp_feature() {
        return this.app_feature;
    }

    public String getApp_intor_url() {
        return this.app_intor_url;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String getApp_intro() {
        return this.app_intro;
    }

    public List<MeishuAdInfo.PermissionBean> getApp_permission() {
        return this.app_permission;
    }

    public String getApp_permission_url() {
        return this.app_permission_url;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String getApp_privacy() {
        return this.app_privacy;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String getApp_size() {
        return this.app_size;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String getApp_ver() {
        return this.app_ver;
    }

    public AppendInfo getAppendInfo() {
        return this.appendInfo;
    }

    public String getCat() {
        return this.cat;
    }

    public int getCbc() {
        return this.cbc;
    }

    public String getCid() {
        return this.cid;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String[] getClickUrl() {
        return this.clickUrl;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String getClickid() {
        return this.clickid;
    }

    public int getClkActType() {
        return this.clkActType;
    }

    public int getClkPower() {
        return this.clkPower;
    }

    public String getClk_area() {
        return this.clk_area;
    }

    public int getClk_type() {
        return this.clk_type;
    }

    public String[] getCloseUrl() {
        return this.closeUrl;
    }

    public int getComments() {
        return this.comments;
    }

    public String getDPSIGN() {
        return this.dpSign;
    }

    public MeishuAdInfo.DClickData getDclk() {
        return this.dclk;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String getDeep_link() {
        return this.deep_link;
    }

    public String getDefImage() {
        return this.defImage;
    }

    public String getDefault_coord() {
        return this.default_coord;
    }

    public String getDesc() {
        return this.desc;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String getDeveloper() {
        return this.developer;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public int getDirect_market() {
        return this.direct_market;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String[] getDn_active() {
        return new String[0];
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String[] getDn_inst_start() {
        return this.dn_inst_start;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String[] getDn_inst_succ() {
        return this.dn_inst_succ;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String[] getDn_start() {
        return this.dn_start;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String[] getDn_succ() {
        return this.dn_succ;
    }

    public int getDownNum() {
        return this.downNum;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String getDpSign() {
        return this.dpsign;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String[] getDp_fail() {
        return this.dp_fail;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String[] getDp_start() {
        return this.dp_start;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String[] getDp_succ() {
        return this.dp_succ;
    }

    public String getDpsign() {
        return this.dpsign;
    }

    public int getDrawing() {
        return this.drawing;
    }

    public HashMap<String, String> getDynamicMap() {
        return this.dynamicMap;
    }

    public int getEcpm() {
        return this.ecpm;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String[] getErrorUrl() {
        return this.errorUrl;
    }

    public String[] getEventUrl() {
        return this.eventUrl;
    }

    public int getExpire_timestamp() {
        return this.expire_timestamp;
    }

    public int getExtend_down() {
        return this.extend_down;
    }

    public int getExtend_interval() {
        return this.extend_interval;
    }

    public int getExtend_left() {
        return this.extend_left;
    }

    public int getExtend_max_count() {
        return this.extend_max_count;
    }

    public int getExtend_right() {
        return this.extend_right;
    }

    public int getExtend_up() {
        return this.extend_up;
    }

    public Integer getFieldExport() {
        return this.fieldExport;
    }

    public String getFromId() {
        return this.from_id;
    }

    public String getFromLogo() {
        return this.fromLogo;
    }

    public String getH5Ext() {
        return this.h5_ext;
    }

    public String getH5Url() {
        return this.h5_url;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String getIcon() {
        return this.icon;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String[] getImageUrls() {
        return this.imageUrls;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public int getInteractionType() {
        return this.interactionType;
    }

    public boolean getIsAdClosed() {
        return this.isAdClosed;
    }

    public boolean getIsRewardUseBrowser() {
        return this.isRewardBrowserOpenLandingPage;
    }

    public long getLoadedTime() {
        return this.loadedTime;
    }

    public String[] getLossUrl() {
        return this.lossUrl;
    }

    public int getMaterialTimeout(int i) {
        int i2 = this.material_timeout;
        return i2 > 0 ? i2 : i;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String[] getMonitorUrl() {
        return this.monitorUrl;
    }

    public int getNativeSE() {
        return this.nativeSE;
    }

    public int getNop() {
        return this.nop;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String getPackageName() {
        return TextUtils.isEmpty(this.packageName) ? "" : this.packageName;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String getPayment_types() {
        return this.payment_types;
    }

    public String getPosId() {
        return this.posId;
    }

    public int getPower_count() {
        return this.power_count;
    }

    public int getPower_delay() {
        return this.power_delay;
    }

    public int getPower_index() {
        return this.power_index;
    }

    public int getPower_index2() {
        int i = this.power_index2;
        return i == 0 ? this.power_index : i;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String getPrivacy_agreement() {
        return this.privacy_agreement;
    }

    public String getReq_id() {
        return this.req_id;
    }

    public String[] getResponUrl() {
        return this.responUrl;
    }

    public int getRewardTmpId() {
        return this.reward_tmp_id;
    }

    public int getReward_tmp_time() {
        return this.reward_tmp_time;
    }

    public int getReward_tmp_type() {
        return this.reward_tmp_type;
    }

    public String getReward_tmp_url() {
        return this.reward_tmp_url;
    }

    public Integer getRs() {
        return this.rs;
    }

    public String getS_code() {
        return this.s_code;
    }

    public String getS_ext() {
        return this.s_ext;
    }

    public int getScale_type() {
        return this.scale_type;
    }

    public String getScheme() {
        return this.scheme;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public float getScore() {
        return this.score;
    }

    public ShakeResult getShakeResult() {
        return this.shakeResult;
    }

    public int getSkipBtnLocation() {
        return this.skipBtnLocation;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getUob() {
        return this.uob;
    }

    public String getVideo_cover() {
        return this.video_cover;
    }

    public int getWebTempId() {
        return this.webTempId;
    }

    public String getWebTempUrl() {
        return this.webTempUrl;
    }

    public String[] getWinUrl() {
        return this.winUrl;
    }

    public String getWx_appid() {
        return this.wx_appid;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String[] getWx_fail() {
        return this.wx_fail;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String getWx_path() {
        return this.wx_path;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String[] getWx_start() {
        return this.wx_start;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String[] getWx_succ() {
        return this.wx_succ;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String getWx_username() {
        return this.wx_username;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public String[] getdUrl() {
        return this.dUrl;
    }

    public boolean isDynamic() {
        return this.isClkDynamic;
    }

    public void setAct_type(int i) {
        this.act_type = i;
    }

    public void setAdClosed(boolean z) {
        this.isAdClosed = z;
    }

    public void setAdPatternType(int i) {
        this.adPatternType = i;
    }

    public void setAppendInfo(AppendInfo appendInfo) {
        if (appendInfo == null) {
            return;
        }
        this.appendInfo = appendInfo;
    }

    public void setClickUrl(String[] strArr) {
        this.clickUrl = strArr;
    }

    public void setClkPower(int i) {
        this.clkPower = i;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public void setDp_start(String[] strArr) {
        this.dp_start = strArr;
    }

    public void setDynamic(boolean z) {
        this.isClkDynamic = z;
    }

    public void setHasExposed(boolean z) {
        this.appendInfo.setHasExposed(z);
    }

    public void setHasVideoStart(boolean z) {
        this.appendInfo.setHasVideoStart(z);
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public void setImageUrls(String[] strArr) {
        this.imageUrls = strArr;
    }

    public void setMonitorUrl(String[] strArr) {
        this.monitorUrl = strArr;
    }

    public void setRewardBrowserOpenLandingPage(boolean z) {
        this.isRewardBrowserOpenLandingPage = z;
    }

    public void setShakeResult(ShakeResult shakeResult) {
        this.shakeResult = shakeResult;
    }

    @Override // com.meishu.sdk.core.ad.AdSlot
    public void setdUrl(String[] strArr) {
        this.dUrl = strArr;
    }

    public static class ClickExtInfo implements Serializable {
        private static final long serialVersionUID = 1;
        private ClickExtInfo lockClickExtInfo;
        private int rewardTempId;
        private int webTempId;

        public int getRewardTempId() {
            return this.rewardTempId;
        }

        public int getWebTempId() {
            return this.webTempId;
        }

        public ClickExtInfo setRewardTempId(int i) {
            this.rewardTempId = i;
            return this;
        }

        public ClickExtInfo clear() {
            this.rewardTempId = 0;
            this.webTempId = 0;
            ClickExtInfo clickExtInfo = this.lockClickExtInfo;
            if (clickExtInfo != null) {
                this.rewardTempId = clickExtInfo.rewardTempId;
                this.webTempId = clickExtInfo.webTempId;
            }
            return this;
        }

        public ClickExtInfo setWebTempId(int i, boolean z) {
            this.webTempId = i;
            if (z) {
                if (this.lockClickExtInfo == null) {
                    this.lockClickExtInfo = new ClickExtInfo();
                }
                this.lockClickExtInfo.webTempId = i;
            } else {
                ClickExtInfo clickExtInfo = this.lockClickExtInfo;
                if (clickExtInfo != null) {
                    clickExtInfo.webTempId = 0;
                }
            }
            return this;
        }
    }

    public void setClkActType(int i) {
        this.clkActType = i;
        clearClickExtInfo();
    }
}
