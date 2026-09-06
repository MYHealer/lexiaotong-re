package com.meishu.sdk.core.domain;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bn;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.openalliance.ad.constant.ba;
import com.huawei.openalliance.ad.constant.x;
import com.meishu.sdk.activity.MeishuOpenDeepLinkActivity;
import com.meishu.sdk.activity.MeishuRewardVideoPlayerActivity;
import com.meishu.sdk.core.ad.AdType;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MeishuAdInfo {
    private String act_ext;
    private String action_desc;
    private String action_text;
    private int ad_type;
    private String ader_id;
    private int adg;
    private int adp;
    private long all_timeout;
    private String app_feature;
    private String app_intro;
    private String app_intro_url;
    private String app_name;
    private List<PermissionBean> app_permission;
    private String app_permission_url;
    private String app_privacy;
    private String app_size;
    private String app_ver;
    private String[] bakUrls;
    private String big_group;
    private int cache;
    private String cat;
    private int cbc;
    private String cid;
    private String[] clickUrl;
    private int clickable_range;
    private String clickid;
    private String clk_area;
    private String[] closeUrl;
    private int comments;
    private String content;
    private String[] dUrl;
    private DClickData dclk;
    private String deep_link;
    private String defImage;
    private String default_coord;
    private String developer;
    private int direct_market;
    private String[] dn_active;
    private String[] dn_inst_start;
    private String[] dn_inst_succ;
    private String[] dn_start;
    private String[] dn_succ;
    private int down_num;
    private String dpSign;
    private String[] dp_fail;
    private String[] dp_start;
    private String[] dp_succ;
    private String dpsign;
    private HashMap<String, String> dynamicMap;
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
    private String from;
    private String from_id;
    private String from_logo;
    private String h5_ext;
    private String h5_url;
    private boolean hasMeishuAd;
    private int height;
    private String icon;
    private String icon_title;
    private int insert_style;
    private boolean isUsed;
    private int is_eyes;
    private LayoutBean layout;
    private long loadedTime;
    private String[] lossUrl;
    private int material_timeout;
    private String[] monitorUrl;
    private int native_s_e;
    private int nop;
    private long once_timeout;
    private String package_name;
    private String payment_types;
    private String pid;
    private int power_index2;
    private int power_type;
    private int priority;
    private String privacy_agreement;
    private String req_id;
    private String[] responUrl;
    private int reward_tmp_id;
    private int reward_tmp_time;
    private int reward_tmp_type;
    private String reward_tmp_url;
    private Integer rs;
    private String[] rstUrl;
    private String s_code;
    private String s_ext;
    private String scheme;
    private float score;
    private SdkAdInfo[] sdk;
    private SdkMonitor sdk_monitor;
    private int skip_btn_location;
    private String[] sourceEventUrl;
    private String[] srcUrls;
    private int style_id;
    private int target_type;
    private String title;
    private Integer uob;
    public String[] video_close;
    private String[] video_complete;
    private String video_cover;
    private long video_duration;
    private String video_endcover;
    private long video_keep_time;
    private String[] video_mute;
    private String[] video_one_half;
    private String[] video_one_quarter;
    private String[] video_pause;
    private String[] video_replay;
    private String[] video_resume;
    public String[] video_skip;
    private String[] video_start;
    private String[] video_three_quarter;
    private String[] video_unmute;
    private int web_temp_id;
    private String web_temp_url;
    private int width;
    private String[] winUrl;
    private String wx_appid;
    private String[] wx_fail;
    private String wx_path;
    private String[] wx_start;
    private String[] wx_succ;
    private String wx_username;
    private int creative_type = 1;
    private int ecpm = -1;
    private int clk_type = 3;
    private int power_index = 50;
    private int power_count = 1;
    private int power_delay = 500;
    private int drawing = 2;
    private String fpool_id = "";
    private String abt_group_id = "";
    private int close_btn = 1;
    private boolean videoAutoPlay = true;
    private int loadNum = 2;
    private int act_type = 2;
    private int bf_num = 1;
    private int scale_type = -1;
    private boolean videoMute = true;

    public static class DClickData {
        private int power = 1;
        private int ptime;

        public static DClickData fromJson(String str) {
            DClickData dClickData = new DClickData();
            try {
                JSONObject jSONObject = new JSONObject(str);
                dClickData.setPtime(jSONObject.optInt("ptime"));
                dClickData.setPower(jSONObject.optInt("power"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return dClickData;
        }

        public int getPower() {
            return this.power;
        }

        public int getPtime() {
            return this.ptime;
        }

        public void setPower(int i) {
            this.power = i;
        }

        public void setPtime(int i) {
            this.ptime = i;
        }
    }

    public static class PermissionBean implements Serializable {
        private String desc;
        private String title;

        public static PermissionBean fromJson(String str) {
            PermissionBean permissionBean = new PermissionBean();
            try {
                JSONObject jSONObject = new JSONObject(str);
                permissionBean.setTitle(jSONObject.optString("title"));
                permissionBean.setDesc(jSONObject.optString("desc"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return permissionBean;
        }

        public String getDesc() {
            return this.desc;
        }

        public String getTitle() {
            return this.title;
        }

        public void setDesc(String str) {
            this.desc = str;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("title", this.title);
                jSONObject.put("desc", this.desc);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
    }

    public static MeishuAdInfo fromJson(String str, AdType adType) {
        MeishuAdInfo meishuAdInfo = new MeishuAdInfo();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("ader_id")) {
                meishuAdInfo.setAder_id(jSONObject.optString("ader_id"));
            }
            if (jSONObject.has("from")) {
                meishuAdInfo.setFrom(jSONObject.optString("from"));
            }
            if (jSONObject.has("from_id")) {
                meishuAdInfo.setFrom_id(jSONObject.optString("from_id"));
            }
            if (jSONObject.has("app_name")) {
                meishuAdInfo.setApp_name(jSONObject.optString("app_name"));
            }
            if (jSONObject.has(ba.D)) {
                meishuAdInfo.setCid(jSONObject.optString(ba.D));
            }
            if (jSONObject.has("clickUrl")) {
                meishuAdInfo.setClickUrl(jsonArrayToStringArray(jSONObject.optJSONArray("clickUrl")));
            }
            if (jSONObject.has("content")) {
                meishuAdInfo.setContent(jSONObject.optString("content"));
            }
            if (jSONObject.has("creative_type")) {
                meishuAdInfo.setCreative_type(jSONObject.optInt("creative_type"));
            }
            if (jSONObject.has("dUrl")) {
                meishuAdInfo.setdUrl(jsonArrayToStringArray(jSONObject.optJSONArray("dUrl")));
            }
            if (jSONObject.has("dn_active")) {
                meishuAdInfo.setDn_active(jsonArrayToStringArray(jSONObject.optJSONArray("dn_active")));
            }
            if (jSONObject.has("dn_inst_start")) {
                meishuAdInfo.setDn_inst_start(jsonArrayToStringArray(jSONObject.optJSONArray("dn_inst_start")));
            }
            if (jSONObject.has("dn_inst_succ")) {
                meishuAdInfo.setDn_inst_succ(jsonArrayToStringArray(jSONObject.optJSONArray("dn_inst_succ")));
            }
            if (jSONObject.has("dn_start")) {
                meishuAdInfo.setDn_start(jsonArrayToStringArray(jSONObject.optJSONArray("dn_start")));
            }
            if (jSONObject.has("dn_succ")) {
                meishuAdInfo.setDn_succ(jsonArrayToStringArray(jSONObject.optJSONArray("dn_succ")));
            }
            if (jSONObject.has("width")) {
                meishuAdInfo.setWidth(jSONObject.optInt("width"));
            }
            if (jSONObject.has("height")) {
                meishuAdInfo.setHeight(jSONObject.optInt("height"));
            }
            if (jSONObject.has("monitorUrl")) {
                meishuAdInfo.setMonitorUrl(jsonArrayToStringArray(jSONObject.optJSONArray("monitorUrl")));
            }
            if (jSONObject.has("responUrl")) {
                meishuAdInfo.setResponUrl(jsonArrayToStringArray(jSONObject.optJSONArray("responUrl")));
            }
            if (jSONObject.has("errorUrl")) {
                meishuAdInfo.setErrorUrl(jsonArrayToStringArray(jSONObject.optJSONArray("errorUrl")));
            }
            if (jSONObject.has("rstUrl")) {
                meishuAdInfo.setRstUrl(jsonArrayToStringArray(jSONObject.optJSONArray("rstUrl")));
            }
            if (jSONObject.has("package_name")) {
                meishuAdInfo.setPackage_name(jSONObject.optString("package_name"));
            }
            if (jSONObject.has("pid")) {
                meishuAdInfo.setPid(jSONObject.optString("pid"));
            }
            if (jSONObject.has("cat")) {
                meishuAdInfo.setCat(jSONObject.optString("cat"));
            }
            if (jSONObject.has("srcUrls")) {
                meishuAdInfo.setSrcUrls(jsonArrayToStringArray(jSONObject.optJSONArray("srcUrls")));
            }
            if (jSONObject.has("target_type")) {
                meishuAdInfo.setTarget_type(jSONObject.optInt("target_type"));
            }
            if (jSONObject.has("video_endcover")) {
                meishuAdInfo.setVideo_endcover(jSONObject.optString("video_endcover"));
            }
            if (jSONObject.has("video_keep_time")) {
                meishuAdInfo.setVideo_keep_time(jSONObject.optLong("video_keep_time"));
            }
            if (jSONObject.has("title")) {
                meishuAdInfo.setTitle(jSONObject.optString("title"));
            }
            if (jSONObject.has(MeishuOpenDeepLinkActivity.KEY_DEEP_LINK)) {
                meishuAdInfo.setDeep_link(jSONObject.optString(MeishuOpenDeepLinkActivity.KEY_DEEP_LINK));
            }
            if (jSONObject.has(MeishuOpenDeepLinkActivity.KEY_DEEP_START)) {
                meishuAdInfo.setDp_start(jsonArrayToStringArray(jSONObject.optJSONArray(MeishuOpenDeepLinkActivity.KEY_DEEP_START)));
            }
            if (jSONObject.has("dp_fail")) {
                meishuAdInfo.setDp_fail(jsonArrayToStringArray(jSONObject.optJSONArray("dp_fail")));
            }
            if (jSONObject.has("dp_succ")) {
                meishuAdInfo.setDp_succ(jsonArrayToStringArray(jSONObject.optJSONArray("dp_succ")));
            }
            if (jSONObject.has("video_start")) {
                meishuAdInfo.setVideo_start(jsonArrayToStringArray(jSONObject.optJSONArray("video_start")));
            }
            if (jSONObject.has("video_one_quarter")) {
                meishuAdInfo.setVideo_one_quarter(jsonArrayToStringArray(jSONObject.optJSONArray("video_one_quarter")));
            }
            if (jSONObject.has("video_one_half")) {
                meishuAdInfo.setVideo_one_half(jsonArrayToStringArray(jSONObject.optJSONArray("video_one_half")));
            }
            if (jSONObject.has("video_three_quarter")) {
                meishuAdInfo.setVideo_three_quarter(jsonArrayToStringArray(jSONObject.optJSONArray("video_three_quarter")));
            }
            if (jSONObject.has("video_complete")) {
                meishuAdInfo.setVideo_complete(jsonArrayToStringArray(jSONObject.optJSONArray("video_complete")));
            }
            if (jSONObject.has("video_pause")) {
                meishuAdInfo.setVideo_pause(jsonArrayToStringArray(jSONObject.optJSONArray("video_pause")));
            }
            if (jSONObject.has("video_resume")) {
                meishuAdInfo.setVideo_resume(jsonArrayToStringArray(jSONObject.optJSONArray("video_resume")));
            }
            if (jSONObject.has("video_skip")) {
                meishuAdInfo.setVideo_skip(jsonArrayToStringArray(jSONObject.optJSONArray("video_skip")));
            }
            if (jSONObject.has("video_close")) {
                meishuAdInfo.setVideo_close(jsonArrayToStringArray(jSONObject.optJSONArray("video_close")));
            }
            if (jSONObject.has("video_mute")) {
                meishuAdInfo.setVideo_mute(jsonArrayToStringArray(jSONObject.optJSONArray("video_mute")));
            }
            if (jSONObject.has("video_unmute")) {
                meishuAdInfo.setVideo_unmute(jsonArrayToStringArray(jSONObject.optJSONArray("video_unmute")));
            }
            if (jSONObject.has("video_replay")) {
                meishuAdInfo.setVideo_replay(jsonArrayToStringArray(jSONObject.optJSONArray("video_replay")));
            }
            if (jSONObject.has("video_cover")) {
                meishuAdInfo.setVideo_cover(jSONObject.optString("video_cover"));
            }
            if (jSONObject.has("clickid")) {
                meishuAdInfo.setClickid(jSONObject.optString("clickid"));
            }
            if (jSONObject.has("action_text")) {
                meishuAdInfo.setAction_text(jSONObject.optString("action_text"));
            }
            if (jSONObject.has(x.cL)) {
                meishuAdInfo.setIcon(jSONObject.optString(x.cL));
            }
            if (jSONObject.has("icon_title")) {
                meishuAdInfo.setIcon_title(jSONObject.optString("icon_title"));
            }
            if (jSONObject.has("from_logo")) {
                meishuAdInfo.setFrom_logo(jSONObject.optString("from_logo"));
            }
            if (jSONObject.has("down_num")) {
                meishuAdInfo.setDown_num(jSONObject.optInt("down_num"));
            }
            if (jSONObject.has("comments")) {
                meishuAdInfo.setComments(jSONObject.optInt("comments"));
            }
            if (jSONObject.has("clickable_range")) {
                meishuAdInfo.setClickable_range(jSONObject.optInt("clickable_range"));
            }
            if (jSONObject.has("ecpm")) {
                meishuAdInfo.setEcpm(jSONObject.optInt("ecpm", -1));
            }
            if (jSONObject.has("exu")) {
                meishuAdInfo.setExtend_up(jSONObject.optInt("exu"));
            }
            if (jSONObject.has("exd")) {
                meishuAdInfo.setExtend_down(jSONObject.optInt("exd"));
            }
            if (jSONObject.has("exl")) {
                meishuAdInfo.setExtend_left(jSONObject.optInt("exl"));
            }
            if (jSONObject.has("exr")) {
                meishuAdInfo.setExtend_right(jSONObject.optInt("exr"));
            }
            if (jSONObject.has("exint")) {
                meishuAdInfo.setExtend_interval(jSONObject.optInt("exint"));
            }
            if (jSONObject.has("emc")) {
                meishuAdInfo.setExtend_max_count(jSONObject.optInt("emc"));
            }
            if (jSONObject.has("developer")) {
                meishuAdInfo.setDeveloper(jSONObject.optString("developer"));
            }
            if (jSONObject.has("app_intro")) {
                meishuAdInfo.setApp_intro(jSONObject.optString("app_intro"));
            }
            if (jSONObject.has("app_feature")) {
                meishuAdInfo.setApp_feature(jSONObject.optString("app_feature"));
            }
            if (jSONObject.has("payment_types")) {
                meishuAdInfo.setPayment_types(jSONObject.optString("payment_types"));
            }
            if (jSONObject.has("app_size")) {
                meishuAdInfo.setApp_size(jSONObject.optString("app_size"));
            }
            if (jSONObject.has("app_ver")) {
                meishuAdInfo.setApp_ver(jSONObject.optString("app_ver"));
            }
            if (jSONObject.has("app_privacy")) {
                meishuAdInfo.setApp_privacy(jSONObject.optString("app_privacy"));
            }
            if (jSONObject.has(NativeUnifiedADAppInfoImpl.Keys.PRIVACY_AGREEMENT)) {
                meishuAdInfo.setPrivacy_agreement(jSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.PRIVACY_AGREEMENT));
            }
            if (jSONObject.has(MeishuRewardVideoPlayerActivity.Clk_type)) {
                meishuAdInfo.setClk_type(jSONObject.optInt(MeishuRewardVideoPlayerActivity.Clk_type, 3));
            }
            if (jSONObject.has("clk_area")) {
                meishuAdInfo.setClk_area(jSONObject.optString("clk_area"));
            }
            if (jSONObject.has("action_desc")) {
                meishuAdInfo.setAction_desc(jSONObject.optString("action_desc"));
            }
            if (jSONObject.has(MeishuRewardVideoPlayerActivity.Power_index)) {
                meishuAdInfo.setPower_index(jSONObject.optInt(MeishuRewardVideoPlayerActivity.Power_index, 50));
            }
            if (jSONObject.has("power_index2")) {
                meishuAdInfo.setPower_index2(jSONObject.optInt("power_index2", meishuAdInfo.getPower_index()));
            }
            if (jSONObject.has("power_type")) {
                meishuAdInfo.setPower_type(jSONObject.optInt("power_type"));
            }
            if (jSONObject.has(MeishuRewardVideoPlayerActivity.Power_count)) {
                meishuAdInfo.setPower_count(jSONObject.optInt(MeishuRewardVideoPlayerActivity.Power_count, 1));
            }
            if (jSONObject.has(MeishuRewardVideoPlayerActivity.Power_delay)) {
                meishuAdInfo.setPower_delay(jSONObject.optInt(MeishuRewardVideoPlayerActivity.Power_delay, 500));
            }
            if (jSONObject.has("all_timeout")) {
                meishuAdInfo.setAll_timeout(jSONObject.optLong("all_timeout"));
            }
            if (jSONObject.has("once_timeout")) {
                meishuAdInfo.setOnce_timeout(jSONObject.optLong("once_timeout"));
            }
            if (jSONObject.has("style_id")) {
                meishuAdInfo.setStyle_id(jSONObject.optInt("style_id"));
            }
            if (jSONObject.has("drawing")) {
                meishuAdInfo.setDrawing(jSONObject.optInt("drawing", 2));
            }
            if (jSONObject.has("wx_username")) {
                meishuAdInfo.setWx_username(jSONObject.optString("wx_username"));
            }
            if (jSONObject.has("wx_path")) {
                meishuAdInfo.setWx_path(jSONObject.optString("wx_path"));
            }
            if (jSONObject.has("wx_start")) {
                meishuAdInfo.setWx_start(jsonArrayToStringArray(jSONObject.optJSONArray("wx_start")));
            }
            if (jSONObject.has("wx_succ")) {
                meishuAdInfo.setWx_succ(jsonArrayToStringArray(jSONObject.optJSONArray("wx_succ")));
            }
            if (jSONObject.has("wx_fail")) {
                meishuAdInfo.setWx_fail(jsonArrayToStringArray(jSONObject.optJSONArray("wx_fail")));
            }
            if (jSONObject.has("req_id")) {
                meishuAdInfo.setReq_id(jSONObject.optString("req_id"));
            }
            if (jSONObject.has("is_eyes")) {
                meishuAdInfo.setIs_eyes(jSONObject.optInt("is_eyes"));
            }
            if (jSONObject.has("direct_market")) {
                meishuAdInfo.setDirect_market(jSONObject.optInt("direct_market"));
            }
            if (jSONObject.has("insert_style")) {
                meishuAdInfo.setInsert_style(jSONObject.optInt("insert_style"));
            }
            if (jSONObject.has("s_code")) {
                meishuAdInfo.setS_code(jSONObject.optString("s_code"));
            }
            if (jSONObject.has("s_ext")) {
                meishuAdInfo.setS_ext(jSONObject.optString("s_ext"));
            }
            if (jSONObject.has("big_group")) {
                meishuAdInfo.setBig_group(jSONObject.optString("big_group"));
            }
            if (jSONObject.has("video_duration")) {
                meishuAdInfo.setVideo_duration(jSONObject.optLong("video_duration"));
            }
            if (jSONObject.has("cache")) {
                meishuAdInfo.setCache(jSONObject.optInt("cache"));
            }
            if (jSONObject.has("priority")) {
                meishuAdInfo.setPriority(jSONObject.optInt("priority"));
            }
            if (jSONObject.has("isUsed")) {
                meishuAdInfo.setUsed(jSONObject.optBoolean("isUsed"));
            }
            if (jSONObject.has("loadedTime")) {
                meishuAdInfo.setLoadedTime(jSONObject.optLong("loadedTime"));
            }
            if (jSONObject.has("expire_timestamp")) {
                meishuAdInfo.setExpire_timestamp(jSONObject.optInt("expire_timestamp"));
            }
            if (jSONObject.has("hasMeishuAd")) {
                meishuAdInfo.setHasMeishuAd(jSONObject.optBoolean("hasMeishuAd"));
            }
            if (jSONObject.has("close_btn")) {
                meishuAdInfo.setClose_btn(jSONObject.optInt("close_btn", 1));
            }
            if (jSONObject.has("videoAutoPlay")) {
                meishuAdInfo.setVideoAutoPlay(jSONObject.optBoolean("videoAutoPlay", true));
            }
            if (jSONObject.has("loadNum")) {
                meishuAdInfo.setLoadNum(jSONObject.optInt("loadNum", 2));
            }
            if (jSONObject.has("app_permission_url")) {
                meishuAdInfo.setApp_permission_url(jSONObject.optString("app_permission_url"));
            }
            if (jSONObject.has("app_intro_url")) {
                meishuAdInfo.setApp_intor_url(jSONObject.optString("app_intro_url"));
            }
            if (jSONObject.has("fpool_id")) {
                meishuAdInfo.setStrategy_group_id(jSONObject.optString("fpool_id", ""));
            }
            if (jSONObject.has("abt_group_id")) {
                meishuAdInfo.setAbtest_group_id(jSONObject.optString("abt_group_id", ""));
            }
            if (jSONObject.has("act_type")) {
                meishuAdInfo.setAct_type(jSONObject.optInt("act_type", 2));
            }
            if (jSONObject.has("ad_type")) {
                meishuAdInfo.setAd_type(jSONObject.optInt("ad_type"));
            }
            if (jSONObject.has("cbc")) {
                meishuAdInfo.setCbc(jSONObject.optInt("cbc"));
            }
            if (jSONObject.has("nop")) {
                meishuAdInfo.setNop(jSONObject.optInt("nop"));
            }
            if (jSONObject.has("bf_num")) {
                meishuAdInfo.setBf_num(jSONObject.optInt("bf_num", 1));
            }
            if (jSONObject.has("wx_appid")) {
                meishuAdInfo.setWx_appid(jSONObject.optString("wx_appid"));
            }
            if (jSONObject.has("scale_type")) {
                meishuAdInfo.setScale_type(jSONObject.optInt("scale_type", -1));
            }
            if (jSONObject.has("eventUrl")) {
                meishuAdInfo.setSourceEventUrl(jsonArrayToStringArray(jSONObject.optJSONArray("eventUrl")));
            }
            if (jSONObject.has("winUrl")) {
                meishuAdInfo.setWinUrl(jsonArrayToStringArray(jSONObject.optJSONArray("winUrl")));
            }
            if (jSONObject.has("lossUrl")) {
                meishuAdInfo.setLossUrl(jsonArrayToStringArray(jSONObject.optJSONArray("lossUrl")));
            }
            if (jSONObject.has("closeUrl")) {
                meishuAdInfo.setCloseUrl(jsonArrayToStringArray(jSONObject.optJSONArray("closeUrl")));
            }
            if (jSONObject.has("scheme") && jSONObject.opt("scheme") != null) {
                meishuAdInfo.setScheme(jSONObject.optString("scheme"));
            }
            if (jSONObject.has(bn.g)) {
                JSONArray jSONArray = jSONObject.getJSONArray(bn.g);
                SdkAdInfo[] sdkAdInfoArr = new SdkAdInfo[jSONArray.length()];
                for (int i = 0; i < jSONArray.length(); i++) {
                    sdkAdInfoArr[i] = SdkAdInfo.fromJson(jSONArray.getJSONObject(i).toString());
                }
                meishuAdInfo.setSdk(sdkAdInfoArr);
            }
            if (jSONObject.has("sdk_monitor")) {
                meishuAdInfo.setSdk_monitor(SdkMonitor.fromJson(jSONObject.getJSONObject("sdk_monitor").toString()));
            }
            if ((adType == AdType.FEED_MIX || adType == AdType.FEED_PRE_RENDER) && jSONObject.has(TtmlNode.TAG_LAYOUT)) {
                meishuAdInfo.setLayout(LayoutBean.fromJson(jSONObject.getJSONObject(TtmlNode.TAG_LAYOUT).toString()));
            }
            if (jSONObject.has("app_permission")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("app_permission");
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    arrayList.add(PermissionBean.fromJson(jSONArray2.getJSONObject(i2).toString()));
                }
                meishuAdInfo.setApp_permission(arrayList);
            }
            if (jSONObject.has("dclk")) {
                meishuAdInfo.setDclk(DClickData.fromJson(jSONObject.getJSONObject("dclk").toString()));
            }
            if (jSONObject.has("dynamicMap")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("dynamicMap");
                HashMap<String, String> map = new HashMap<>();
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    map.put(next, jSONObject2.optString(next));
                }
                meishuAdInfo.setDynamicMap(map);
            }
            if (jSONObject.has("fieldExport") && !jSONObject.isNull("fieldExport")) {
                meishuAdInfo.setFieldExport(Integer.valueOf(jSONObject.optInt("fieldExport", 0)));
            }
            if (jSONObject.has("adp")) {
                meishuAdInfo.setAdp(jSONObject.optInt("adp", 0));
            }
            if (jSONObject.has("adg")) {
                meishuAdInfo.setAdg(jSONObject.optInt("adg", 0));
            }
            if (jSONObject.has("defImage")) {
                meishuAdInfo.setDefImage(jSONObject.optString("defImage"));
            }
            if (jSONObject.has(ba.Z)) {
                meishuAdInfo.setH5_url(jSONObject.optString(ba.Z));
            }
            if (jSONObject.has("h5_ext")) {
                meishuAdInfo.setH5_ext(jSONObject.optString("h5_ext"));
            }
            if (jSONObject.has("material_timeout")) {
                meishuAdInfo.setMaterialTimeout(jSONObject.optInt("material_timeout", 0));
            }
            if (jSONObject.has("default_coord")) {
                meishuAdInfo.setDefault_coord(jSONObject.optString("default_coord"));
            }
            if (jSONObject.has("dpsign")) {
                meishuAdInfo.setDpsign(jSONObject.optString("dpsign"));
            }
            if (jSONObject.has(MeishuRewardVideoPlayerActivity.Reward_tmp_url)) {
                meishuAdInfo.setReward_tmp_url(jSONObject.optString(MeishuRewardVideoPlayerActivity.Reward_tmp_url));
            }
            if (jSONObject.has(MeishuRewardVideoPlayerActivity.Reward_tmp_type)) {
                meishuAdInfo.setReward_tmp_type(jSONObject.optInt(MeishuRewardVideoPlayerActivity.Reward_tmp_type));
            }
            if (jSONObject.has(MeishuRewardVideoPlayerActivity.Reward_tmp_time)) {
                meishuAdInfo.setReward_tmp_time(jSONObject.optInt(MeishuRewardVideoPlayerActivity.Reward_tmp_time));
            }
            if (jSONObject.has(MeishuRewardVideoPlayerActivity.Reward_tmp_id)) {
                meishuAdInfo.setRewardTmpId(jSONObject.optInt(MeishuRewardVideoPlayerActivity.Reward_tmp_id));
            }
            if (jSONObject.has("act_ext")) {
                meishuAdInfo.setAct_ext(jSONObject.optString("act_ext"));
            }
            if (jSONObject.has("uob")) {
                meishuAdInfo.setUob(Integer.valueOf(jSONObject.optInt("uob")));
            }
            if (jSONObject.has("native_s_e")) {
                meishuAdInfo.setNative_s_e(jSONObject.optInt("native_s_e"));
            }
            if (jSONObject.has("rs")) {
                meishuAdInfo.setRs(Integer.valueOf(jSONObject.optInt("rs")));
            }
            if (jSONObject.has("dpSign")) {
                meishuAdInfo.setDPSIGN(jSONObject.optString("dpSign"));
            }
            if (jSONObject.has(MeishuRewardVideoPlayerActivity.Web_temp_url)) {
                meishuAdInfo.setWebTempUrl(jSONObject.optString(MeishuRewardVideoPlayerActivity.Web_temp_url));
            }
            if (jSONObject.has(MeishuRewardVideoPlayerActivity.Web_temp_id)) {
                meishuAdInfo.setWebTempId(jSONObject.optInt(MeishuRewardVideoPlayerActivity.Web_temp_id));
            }
            if (jSONObject.has("skip_btn_location")) {
                meishuAdInfo.setSkipBtnLocation(jSONObject.optInt("skip_btn_location"));
            }
            if (jSONObject.has("bakUrls")) {
                meishuAdInfo.setBakUrls(jsonArrayToStringArray(jSONObject.optJSONArray("bakUrls")));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return meishuAdInfo;
    }

    private static String[] jsonArrayToStringArray(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        String[] strArr = new String[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            strArr[i] = jSONArray.optString(i);
        }
        return strArr;
    }

    public String getAbtest_group_id() {
        return this.abt_group_id;
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

    public String getAction_text() {
        return this.action_text;
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

    public long getAll_timeout() {
        return this.all_timeout;
    }

    public String getApp_feature() {
        return this.app_feature;
    }

    public String getApp_intor_url() {
        return this.app_intro_url;
    }

    public String getApp_intro() {
        return this.app_intro;
    }

    public String getApp_name() {
        return this.app_name;
    }

    public List<PermissionBean> getApp_permission() {
        return this.app_permission;
    }

    public String getApp_permission_url() {
        return this.app_permission_url;
    }

    public String getApp_privacy() {
        return this.app_privacy;
    }

    public String getApp_size() {
        return this.app_size;
    }

    public String getApp_ver() {
        return this.app_ver;
    }

    public String[] getBakUrls() {
        return this.bakUrls;
    }

    public int getBf_num() {
        return this.bf_num;
    }

    public String getBig_group() {
        return this.big_group;
    }

    public int getCache() {
        return this.cache;
    }

    public String getCacheKey() {
        return this.pid + "_" + this.fpool_id + "_" + this.abt_group_id;
    }

    public int getCacheScore() {
        return ((1000 - this.priority) * 1000000) + this.ecpm;
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

    public String[] getClickUrl() {
        return this.clickUrl;
    }

    public int getClickable_range() {
        return this.clickable_range;
    }

    public String getClickid() {
        return this.clickid;
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

    public int getClose_btn() {
        return this.close_btn;
    }

    public int getComments() {
        return this.comments;
    }

    public String getContent() {
        return this.content;
    }

    public int getCreative_type() {
        return this.creative_type;
    }

    public String getDPSIGN() {
        return this.dpSign;
    }

    public DClickData getDclk() {
        return this.dclk;
    }

    public String getDeep_link() {
        return this.deep_link;
    }

    public String getDefImage() {
        return this.defImage;
    }

    public String getDefault_coord() {
        return this.default_coord;
    }

    public String getDeveloper() {
        return this.developer;
    }

    public int getDirect_market() {
        return this.direct_market;
    }

    public String[] getDn_active() {
        return this.dn_active;
    }

    public String[] getDn_inst_start() {
        return this.dn_inst_start;
    }

    public String[] getDn_inst_succ() {
        return this.dn_inst_succ;
    }

    public String[] getDn_start() {
        return this.dn_start;
    }

    public String[] getDn_succ() {
        return this.dn_succ;
    }

    public int getDown_num() {
        return this.down_num;
    }

    public String[] getDp_fail() {
        return this.dp_fail;
    }

    public String[] getDp_start() {
        return this.dp_start;
    }

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

    public String getFrom() {
        return this.from;
    }

    public String getFrom_id() {
        return this.from_id;
    }

    public String getFrom_logo() {
        return this.from_logo;
    }

    public String getH5_ext() {
        return this.h5_ext;
    }

    public String getH5_url() {
        return this.h5_url;
    }

    public int getHeight() {
        return this.height;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getIcon_title() {
        return this.icon_title;
    }

    public int getInsert_style() {
        return this.insert_style;
    }

    public int getIs_eyes() {
        return this.is_eyes;
    }

    public LayoutBean getLayout() {
        return this.layout;
    }

    public int getLoadNum() {
        return this.loadNum;
    }

    public long getLoadedTime() {
        return this.loadedTime;
    }

    public String[] getLossUrl() {
        return this.lossUrl;
    }

    public int getMaterialTimeout() {
        return this.material_timeout;
    }

    public String[] getMonitorUrl() {
        return this.monitorUrl;
    }

    public int getNative_s_e() {
        return this.native_s_e;
    }

    public int getNop() {
        return this.nop;
    }

    public long getOnce_timeout() {
        return this.once_timeout;
    }

    public String getPackage_name() {
        return this.package_name;
    }

    public String getPayment_types() {
        return this.payment_types;
    }

    public String getPid() {
        return this.pid;
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
        return this.power_index2;
    }

    public int getPower_type() {
        return this.power_type;
    }

    public int getPriority() {
        return this.priority;
    }

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

    public String[] getRstUrl() {
        return this.rstUrl;
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

    public float getScore() {
        return this.score;
    }

    public SdkAdInfo[] getSdk() {
        return this.sdk;
    }

    public SdkMonitor getSdk_monitor() {
        return this.sdk_monitor;
    }

    public int getSkipBtnLocation() {
        return this.skip_btn_location;
    }

    public String[] getSourceEventUrl() {
        return this.sourceEventUrl;
    }

    public String[] getSrcUrls() {
        return this.srcUrls;
    }

    public String getStrategy_group_id() {
        return this.fpool_id;
    }

    public int getStyle_id() {
        return this.style_id;
    }

    public int getTarget_type() {
        return this.target_type;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getUob() {
        return this.uob;
    }

    public String[] getVideo_close() {
        return this.video_close;
    }

    public String[] getVideo_complete() {
        return this.video_complete;
    }

    public String getVideo_cover() {
        return this.video_cover;
    }

    public long getVideo_duration() {
        return this.video_duration;
    }

    public String getVideo_endcover() {
        return this.video_endcover;
    }

    public long getVideo_keep_time() {
        return this.video_keep_time;
    }

    public String[] getVideo_mute() {
        return this.video_mute;
    }

    public String[] getVideo_one_half() {
        return this.video_one_half;
    }

    public String[] getVideo_one_quarter() {
        return this.video_one_quarter;
    }

    public String[] getVideo_pause() {
        return this.video_pause;
    }

    public String[] getVideo_replay() {
        return this.video_replay;
    }

    public String[] getVideo_resume() {
        return this.video_resume;
    }

    public String[] getVideo_skip() {
        return this.video_skip;
    }

    public String[] getVideo_start() {
        return this.video_start;
    }

    public String[] getVideo_three_quarter() {
        return this.video_three_quarter;
    }

    public String[] getVideo_unmute() {
        return this.video_unmute;
    }

    public int getWebTempId() {
        return this.web_temp_id;
    }

    public String getWebTempUrl() {
        return this.web_temp_url;
    }

    public int getWidth() {
        return this.width;
    }

    public String[] getWinUrl() {
        return this.winUrl;
    }

    public String getWx_appid() {
        return this.wx_appid;
    }

    public String[] getWx_fail() {
        return this.wx_fail;
    }

    public String getWx_path() {
        return this.wx_path;
    }

    public String[] getWx_start() {
        return this.wx_start;
    }

    public String[] getWx_succ() {
        return this.wx_succ;
    }

    public String getWx_username() {
        return this.wx_username;
    }

    public String[] getdUrl() {
        return this.dUrl;
    }

    public boolean isHasMeishuAd() {
        return this.hasMeishuAd;
    }

    public boolean isUsed() {
        return this.isUsed;
    }

    public boolean isVideoAutoPlay() {
        return this.videoAutoPlay;
    }

    public boolean isVideoMute() {
        return this.videoMute;
    }

    public void setAbtest_group_id(String str) {
        this.abt_group_id = str;
    }

    public void setAct_ext(String str) {
        this.act_ext = str;
    }

    public void setAct_type(int i) {
        this.act_type = i;
    }

    public void setAction_desc(String str) {
        this.action_desc = str;
    }

    public void setAction_text(String str) {
        this.action_text = str;
    }

    public void setAd_type(int i) {
        this.ad_type = i;
    }

    public void setAder_id(String str) {
        this.ader_id = str;
    }

    public void setAdg(int i) {
        this.adg = i;
    }

    public void setAdp(int i) {
        this.adp = i;
    }

    public void setAll_timeout(long j) {
        this.all_timeout = j;
    }

    public void setApp_feature(String str) {
        this.app_feature = str;
    }

    public void setApp_intor_url(String str) {
        this.app_intro_url = str;
    }

    public void setApp_intro(String str) {
        this.app_intro = str;
    }

    public void setApp_name(String str) {
        this.app_name = str;
    }

    public void setApp_permission(List<PermissionBean> list) {
        this.app_permission = list;
    }

    public void setApp_permission_url(String str) {
        this.app_permission_url = str;
    }

    public void setApp_privacy(String str) {
        this.app_privacy = str;
    }

    public void setApp_size(String str) {
        this.app_size = str;
    }

    public void setApp_ver(String str) {
        this.app_ver = str;
    }

    public void setBakUrls(String[] strArr) {
        this.bakUrls = strArr;
    }

    public void setBf_num(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.bf_num = i;
    }

    public void setBig_group(String str) {
        this.big_group = str;
    }

    public void setCache(int i) {
        this.cache = i;
    }

    public void setCat(String str) {
        this.cat = str;
    }

    public void setCbc(int i) {
        this.cbc = i;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setClickUrl(String[] strArr) {
        this.clickUrl = strArr;
    }

    public void setClickable_range(int i) {
        this.clickable_range = i;
    }

    public void setClickid(String str) {
        this.clickid = str;
    }

    public void setClk_area(String str) {
        this.clk_area = str;
    }

    public void setClk_type(int i) {
        this.clk_type = i;
    }

    public void setCloseUrl(String[] strArr) {
        this.closeUrl = strArr;
    }

    public void setClose_btn(int i) {
        this.close_btn = i;
    }

    public void setComments(int i) {
        this.comments = i;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreative_type(int i) {
        this.creative_type = i;
    }

    public void setDPSIGN(String str) {
        this.dpSign = str;
    }

    public void setDclk(DClickData dClickData) {
        this.dclk = dClickData;
    }

    public void setDeep_link(String str) {
        this.deep_link = str;
    }

    public void setDefImage(String str) {
        this.defImage = str;
    }

    public void setDefault_coord(String str) {
        this.default_coord = str;
    }

    public void setDeveloper(String str) {
        this.developer = str;
    }

    public void setDirect_market(int i) {
        this.direct_market = i;
    }

    public void setDn_active(String[] strArr) {
        this.dn_active = strArr;
    }

    public void setDn_inst_start(String[] strArr) {
        this.dn_inst_start = strArr;
    }

    public void setDn_inst_succ(String[] strArr) {
        this.dn_inst_succ = strArr;
    }

    public void setDn_start(String[] strArr) {
        this.dn_start = strArr;
    }

    public void setDn_succ(String[] strArr) {
        this.dn_succ = strArr;
    }

    public void setDown_num(int i) {
        this.down_num = i;
    }

    public void setDp_fail(String[] strArr) {
        this.dp_fail = strArr;
    }

    public void setDp_start(String[] strArr) {
        this.dp_start = strArr;
    }

    public void setDp_succ(String[] strArr) {
        this.dp_succ = strArr;
    }

    public void setDpsign(String str) {
        this.dpsign = str;
    }

    public void setDrawing(int i) {
        this.drawing = i;
    }

    public void setDynamicMap(HashMap<String, String> map) {
        this.dynamicMap = map;
    }

    public void setECpm(String str) {
        try {
            this.ecpm = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
    }

    public void setEcpm(int i) {
        this.ecpm = i;
    }

    public void setErrorUrl(String[] strArr) {
        this.errorUrl = strArr;
    }

    public void setEventUrl(String[] strArr) {
        this.eventUrl = strArr;
    }

    public void setExpire_timestamp(int i) {
        this.expire_timestamp = i;
    }

    public void setExtend_down(int i) {
        this.extend_down = i;
    }

    public void setExtend_interval(int i) {
        this.extend_interval = i;
    }

    public void setExtend_left(int i) {
        this.extend_left = i;
    }

    public void setExtend_max_count(int i) {
        this.extend_max_count = i;
    }

    public void setExtend_right(int i) {
        this.extend_right = i;
    }

    public void setExtend_up(int i) {
        this.extend_up = i;
    }

    public void setFieldExport(Integer num) {
        this.fieldExport = num;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setFrom_id(String str) {
        this.from_id = str;
    }

    public void setFrom_logo(String str) {
        this.from_logo = str;
    }

    public void setH5_ext(String str) {
        this.h5_ext = str;
    }

    public void setH5_url(String str) {
        this.h5_url = str;
    }

    public void setHasMeishuAd(boolean z) {
        this.hasMeishuAd = z;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setIcon_title(String str) {
        this.icon_title = str;
    }

    public void setInsert_style(int i) {
        this.insert_style = i;
    }

    public void setIs_eyes(int i) {
        this.is_eyes = i;
    }

    public void setLayout(LayoutBean layoutBean) {
        this.layout = layoutBean;
    }

    public void setLoadNum(int i) {
        this.loadNum = i;
    }

    public void setLoadedTime(long j) {
        this.loadedTime = j;
    }

    public void setLossUrl(String[] strArr) {
        this.lossUrl = strArr;
    }

    public void setMaterialTimeout(int i) {
        this.material_timeout = i;
    }

    public void setMonitorUrl(String[] strArr) {
        this.monitorUrl = strArr;
    }

    public void setNative_s_e(int i) {
        this.native_s_e = i;
    }

    public void setNop(int i) {
        this.nop = i;
    }

    public void setOnce_timeout(long j) {
        this.once_timeout = j;
    }

    public void setPackage_name(String str) {
        this.package_name = str;
    }

    public void setPayment_types(String str) {
        this.payment_types = str;
    }

    public void setPid(String str) {
        this.pid = str;
    }

    public void setPower_count(int i) {
        this.power_count = i;
    }

    public void setPower_delay(int i) {
        this.power_delay = i;
    }

    public void setPower_index(int i) {
        this.power_index = i;
    }

    public void setPower_index2(int i) {
        this.power_index2 = i;
    }

    public void setPower_type(int i) {
        this.power_type = i;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setPrivacy_agreement(String str) {
        this.privacy_agreement = str;
    }

    public void setReq_id(String str) {
        this.req_id = str;
    }

    public void setResponUrl(String[] strArr) {
        this.responUrl = strArr;
    }

    public void setRewardTmpId(int i) {
        this.reward_tmp_id = i;
    }

    public void setReward_tmp_time(int i) {
        this.reward_tmp_time = i;
    }

    public void setReward_tmp_type(int i) {
        this.reward_tmp_type = i;
    }

    public void setReward_tmp_url(String str) {
        this.reward_tmp_url = str;
    }

    public void setRs(Integer num) {
        this.rs = num;
    }

    public void setRstUrl(String[] strArr) {
        this.rstUrl = strArr;
    }

    public void setS_code(String str) {
        this.s_code = str;
    }

    public void setS_ext(String str) {
        this.s_ext = str;
    }

    public void setScale_type(int i) {
        this.scale_type = i;
    }

    public void setScheme(String str) {
        this.scheme = str;
    }

    public void setScore(float f) {
        this.score = f;
    }

    public void setSdk(SdkAdInfo[] sdkAdInfoArr) {
        this.sdk = sdkAdInfoArr;
    }

    public void setSdk_monitor(SdkMonitor sdkMonitor) {
        this.sdk_monitor = sdkMonitor;
    }

    public void setSkipBtnLocation(int i) {
        this.skip_btn_location = i;
    }

    public void setSourceEventUrl(String[] strArr) {
        this.sourceEventUrl = strArr;
    }

    public void setSrcUrls(String[] strArr) {
        this.srcUrls = strArr;
    }

    public void setStrategy_group_id(String str) {
        this.fpool_id = str;
    }

    public void setStyle_id(int i) {
        this.style_id = i;
    }

    public void setTarget_type(int i) {
        this.target_type = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUob(Integer num) {
        this.uob = num;
    }

    public void setUsed(boolean z) {
        this.isUsed = z;
    }

    public void setVideoAutoPlay(boolean z) {
        this.videoAutoPlay = z;
    }

    public void setVideoMute(boolean z) {
        this.videoMute = z;
    }

    public void setVideo_close(String[] strArr) {
        this.video_close = strArr;
    }

    public void setVideo_complete(String[] strArr) {
        this.video_complete = strArr;
    }

    public void setVideo_cover(String str) {
        this.video_cover = str;
    }

    public void setVideo_duration(long j) {
        this.video_duration = j;
    }

    public void setVideo_endcover(String str) {
        this.video_endcover = str;
    }

    public void setVideo_keep_time(long j) {
        this.video_keep_time = j;
    }

    public void setVideo_mute(String[] strArr) {
        this.video_mute = strArr;
    }

    public void setVideo_one_half(String[] strArr) {
        this.video_one_half = strArr;
    }

    public void setVideo_one_quarter(String[] strArr) {
        this.video_one_quarter = strArr;
    }

    public void setVideo_pause(String[] strArr) {
        this.video_pause = strArr;
    }

    public void setVideo_replay(String[] strArr) {
        this.video_replay = strArr;
    }

    public void setVideo_resume(String[] strArr) {
        this.video_resume = strArr;
    }

    public void setVideo_skip(String[] strArr) {
        this.video_skip = strArr;
    }

    public void setVideo_start(String[] strArr) {
        this.video_start = strArr;
    }

    public void setVideo_three_quarter(String[] strArr) {
        this.video_three_quarter = strArr;
    }

    public void setVideo_unmute(String[] strArr) {
        this.video_unmute = strArr;
    }

    public void setWebTempId(int i) {
        this.web_temp_id = i;
    }

    public void setWebTempUrl(String str) {
        this.web_temp_url = str;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public void setWinUrl(String[] strArr) {
        this.winUrl = strArr;
    }

    public void setWx_appid(String str) {
        this.wx_appid = str;
    }

    public void setWx_fail(String[] strArr) {
        this.wx_fail = strArr;
    }

    public void setWx_path(String str) {
        this.wx_path = str;
    }

    public void setWx_start(String[] strArr) {
        this.wx_start = strArr;
    }

    public void setWx_succ(String[] strArr) {
        this.wx_succ = strArr;
    }

    public void setWx_username(String str) {
        this.wx_username = str;
    }

    public void setdUrl(String[] strArr) {
        this.dUrl = strArr;
    }

    public void setDrawing(String str) {
        if (TextUtils.isEmpty(str)) {
            this.drawing = 0;
            return;
        }
        try {
            this.drawing = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
