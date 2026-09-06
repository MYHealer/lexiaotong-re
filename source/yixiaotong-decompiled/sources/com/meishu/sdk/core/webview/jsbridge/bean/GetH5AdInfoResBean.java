package com.meishu.sdk.core.webview.jsbridge.bean;

import android.text.TextUtils;
import com.meishu.sdk.R;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.ad.AdSlot;
import com.meishu.sdk.core.ad.BaseAdSlot;
import com.meishu.sdk.core.domain.MeishuAdInfo;
import com.meishu.sdk.core.webview.q;
import com.meishu.sdk.meishu_ad.nativ.f;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GetH5AdInfoResBean implements Serializable {
    private static final long serialVersionUID = 1;
    private int act_type;
    private String action_desc;
    private AppInfoBean app_info;
    private String app_name;
    private String clk_area;
    private String content;
    private int creative_type;
    private String[] dUrl;
    private int direct_market;
    private String from_logo;
    private String h5_ext;
    private String icon;
    private int power_index;
    private int power_index2;
    private int reward_tmp_time;
    private String[] srcUrls;
    private int target_type;
    private int temp_id;
    private String title;
    private String uuid;
    private String video_cover;
    private long video_keep_time;

    public static class AppInfoBean implements Serializable {
        private static final long serialVersionUID = 1;
        private String app_intro;
        private String app_intro_url;
        private String app_name;
        private List<MeishuAdInfo.PermissionBean> app_permission;
        private String app_permission_url;
        private String app_size;
        private String app_ver;
        private String developer;
        private String package_name;
        private String privacy_agreement;
    }

    public static GetH5AdInfoResBean make(AdSlot adSlot, String str, boolean z) {
        GetH5AdInfoResBean getH5AdInfoResBean = new GetH5AdInfoResBean();
        if (adSlot instanceof BaseAdSlot) {
            BaseAdSlot baseAdSlot = (BaseAdSlot) adSlot;
            getH5AdInfoResBean.srcUrls = baseAdSlot.getImageUrls();
            getH5AdInfoResBean.video_cover = baseAdSlot.getVideo_cover();
            getH5AdInfoResBean.creative_type = baseAdSlot.getAdPatternType();
            getH5AdInfoResBean.target_type = baseAdSlot.getInteractionType();
            getH5AdInfoResBean.h5_ext = baseAdSlot.getH5Ext();
            getH5AdInfoResBean.uuid = baseAdSlot.getReq_id();
            getH5AdInfoResBean.app_name = str;
            getH5AdInfoResBean.title = baseAdSlot.getTitle();
            getH5AdInfoResBean.content = baseAdSlot.getDesc();
            getH5AdInfoResBean.icon = baseAdSlot.getIconUrl();
            if (adSlot instanceof f) {
                getH5AdInfoResBean.video_keep_time = ((f) adSlot).i;
            }
            getH5AdInfoResBean.direct_market = adSlot.getDirect_market();
            getH5AdInfoResBean.dUrl = adSlot.getdUrl();
            getH5AdInfoResBean.app_info = makeAppInfoBean(baseAdSlot);
            getH5AdInfoResBean.reward_tmp_time = baseAdSlot.getReward_tmp_time();
            String fromLogo = baseAdSlot.getFromLogo();
            if (TextUtils.isEmpty(fromLogo)) {
                getH5AdInfoResBean.from_logo = com.meishu.sdk.activity.a.a("data:image/png;base64,").append(q.a(AdSdk.getContext(), R.drawable.ms_ad)).toString();
            } else {
                getH5AdInfoResBean.from_logo = fromLogo;
            }
            getH5AdInfoResBean.act_type = baseAdSlot.getAct_type();
            getH5AdInfoResBean.action_desc = baseAdSlot.getAction_desc();
            getH5AdInfoResBean.clk_area = baseAdSlot.getClk_area();
            getH5AdInfoResBean.power_index = baseAdSlot.getPower_index();
            getH5AdInfoResBean.power_index2 = baseAdSlot.getPower_index2();
            int webTempId = baseAdSlot.getWebTempId();
            getH5AdInfoResBean.temp_id = webTempId;
            if (z && webTempId <= 0) {
                getH5AdInfoResBean.temp_id = baseAdSlot.getRewardTmpId();
            }
        }
        return getH5AdInfoResBean;
    }

    private static AppInfoBean makeAppInfoBean(BaseAdSlot baseAdSlot) {
        AppInfoBean appInfoBean = new AppInfoBean();
        appInfoBean.app_name = baseAdSlot.getAppName();
        appInfoBean.app_intro = baseAdSlot.getApp_intro();
        appInfoBean.app_intro_url = baseAdSlot.getApp_intor_url();
        appInfoBean.app_ver = baseAdSlot.getApp_ver();
        appInfoBean.app_size = baseAdSlot.getApp_size();
        appInfoBean.app_permission = baseAdSlot.getApp_permission();
        appInfoBean.app_permission_url = baseAdSlot.getApp_permission_url();
        appInfoBean.privacy_agreement = baseAdSlot.getPrivacy_agreement();
        appInfoBean.developer = baseAdSlot.getDeveloper();
        appInfoBean.package_name = baseAdSlot.getPackageName();
        return appInfoBean;
    }
}
