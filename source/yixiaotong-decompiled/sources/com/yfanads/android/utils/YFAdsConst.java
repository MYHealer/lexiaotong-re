package com.yfanads.android.utils;

import android.text.TextUtils;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.hihonor.adsdk.base.mediation.adn.AdnConfig;
import com.huawei.hms.mlplugin.card.bcr.MLBcrCaptureConfig;
import com.ubix.ssp.open.UBiXWinPlatform;
import com.yfanads.android.adx.BuildConfig;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class YFAdsConst {
    public static final int AD_STATUS_DEFAULT = -1;
    public static final int AD_STATUS_EXPOSURE = 5;
    public static final int AD_STATUS_LOADING = 0;
    public static final int AD_STATUS_LOAD_FAILED = 2;
    public static final int AD_STATUS_LOAD_SUCCESS = 1;
    public static final int AD_STATUS_START_SHOW = 3;
    public static final int AD_STATUS_TIME_OUT = 4;
    public static final int AD_USE_CACHE = 1;
    public static final String CAR = "car";
    public static final int CHANEL_ADX = 12;
    public static final String CHANEL_ADX_PATH = "adx.Adx";
    public static final int CHANEL_AY = 15;
    public static final String CHANEL_AY_PATH = "ay.AY";
    public static final int CHANEL_BD = 3;
    public static final String CHANEL_BD_PATH = "bd.BD";
    public static final int CHANEL_CJ = 18;
    public static final String CHANEL_CJ_PATH = "cj.CJ";
    public static final int CHANEL_CSJ = 1;
    public static final int CHANEL_CSJ_GROMORE = 11;
    public static final String CHANEL_CSJ_GROMORE_PATH = "csj.GroMore";
    public static final String CHANEL_CSJ_PATH = "csj.Csj";
    public static final int CHANEL_GE = 17;
    public static final String CHANEL_GE_PATH = "ge.GE";
    public static final int CHANEL_HW = 6;
    public static final String CHANEL_HW_PATH = "hw.Hw";
    public static final int CHANEL_IN = 19;
    public static final String CHANEL_IN_PATH = "in.IN";
    public static final int CHANEL_JC = 20;
    public static final String CHANEL_JC_PATH = "jc.JC";
    public static final int CHANEL_JD = 9;
    public static final String CHANEL_JD_PATH = "jd.JD";
    public static final int CHANEL_KF = 25;
    public static final String CHANEL_KF_PATH = "kf.KF";
    public static final int CHANEL_KS = 4;
    public static final String CHANEL_KS_PATH = "ks.KS";
    public static final int CHANEL_KY = 24;
    public static final String CHANEL_KY_PATH = "ky.KY";
    public static final int CHANEL_NAL = 21;
    public static final String CHANEL_NAL_PATH = "nal.Nal";
    public static final int CHANEL_NC = 22;
    public static final String CHANEL_NC_PATH = "nc.NC";
    public static final int CHANEL_OPPO = 8;
    public static final String CHANEL_OPPO_PATH = "oppo.Oppo";
    public static final int CHANEL_RY = 13;
    public static final String CHANEL_RY_PAT = "ry.RY";
    public static final int CHANEL_TANX = 14;
    public static final String CHANEL_TANX_PAT = "tanx.TanX";
    public static final int CHANEL_UW = 23;
    public static final String CHANEL_UW_PATH = "uw.UW";
    public static final int CHANEL_VIVO = 10;
    public static final String CHANEL_VIVO_PATH = "vivo.ViVo";
    public static final int CHANEL_XM = 7;
    public static final String CHANEL_XM_PATH = "xm.Xm";
    public static final int CHANEL_XU = 16;
    public static final String CHANEL_XU_PATH = "xu.XU";
    public static final int CHANEL_YLH = 2;
    public static final String CHANEL_YLH_PATH = "ylh.Ylh";
    public static final int CHANEL_ZD = 26;
    public static final String CHANEL_ZD_PATH = "zd.ZD";
    public static final String CUA = "cua";
    public static final String CUAID = "cuaid";
    public static final String CUL = "cul";
    public static final String CUO = "cuo";
    public static final String CUP = "cup";
    public static final String CUW = "cuw";
    public static final String CWE = "cwe";
    public static final String DEFAULT_RT = "112,114,115,116,117,119";
    public static final int HORIZONTAL = 2;
    public static final String LP = "lp";
    public static final String NOT_SUPPORT_CHANEL_TIPS = "未支持的SDK渠道，跳过该渠道加载。请先检查是否引入了该渠道处理依赖，如已引入，检查下发渠道信息，如未在渠道已支持列表中，请请查看文档使用自定义渠道来完成广告加载";
    public static final String REPORT_APPID = "appID";
    public static final String REPORT_APP_VER = "appVer";
    public static final String REPORT_AT = "at";
    public static final String REPORT_BULDLE = "buldle";
    public static final String REPORT_DB = "db";
    public static final String REPORT_DEV_ID = "devID";
    public static final String REPORT_DEV_TYPE = "devtype";
    public static final int REPORT_DEV_TYPE_VALUE = 0;
    public static final String REPORT_DM = "dm";
    public static final String REPORT_DT = "dt";
    public static final String REPORT_EVENTS = "events";
    public static final String REPORT_EX = "ex";
    public static final String REPORT_IDFA = "IDFA";
    public static final String REPORT_SDK_VER = "sdkVer";
    public static final String REPORT_UD = "ud";
    public static final int TYPE_NO_CHANEL = -1;
    public static final String USER_KEY = "ctUserId";
    public static final int VERTICAL = 1;
    private static final List<String> WV_ACTIVITY_LIST = Arrays.asList(BuildConfig.LIBRARY_PACKAGE_NAME, "com.baidu.mobads.sdk.api", "com.qq.e.ads", com.bytedance.sdk.openadsdk.BuildConfig.LIBRARY_PACKAGE_NAME, "com.kwad.sdk.api", "com.jd.ad", "com.octopus.ad", "com.oplusos.securitypermission", "com.fancy.mpsdk", com.ubix.ssp.BuildConfig.LIBRARY_PACKAGE_NAME, com.adprof.sdk.BuildConfig.LIBRARY_PACKAGE_NAME, "com.dtyx.qckj", "com.alliance.ssp", "com.beizi.ad", "com.jiaads.advista", "com.yd.saas", "com.jt.fc", "com.jd.ad.polyunion", "com.meishu.sdk");
    public static final AdSource[] CLASS_VALUES_ADS = {AdSource.ADX, AdSource.CSJ, AdSource.YLH, AdSource.BD, AdSource.KS, AdSource.JD, AdSource.OPPO, AdSource.XM, AdSource.HW, AdSource.GROMORE, AdSource.RY, AdSource.AY, AdSource.XU, AdSource.GE, AdSource.CJ, AdSource.IN, AdSource.JC, AdSource.NAL, AdSource.NC, AdSource.UW, AdSource.KY, AdSource.KF, AdSource.ZD};

    public enum AdSource {
        ADX("com.yfanads.android.adx.AdxSDK", "com.yfanads.android.adx.BuildConfig", "com.yfanads.ads.chanel.adx.utils.AdxSdkUtil", "com.yfanads.android.adx.BuildConfig", 12, "yf", "initAD"),
        CSJ("com.bytedance.sdk.openadsdk.TTAdSdk", "com.yfanads.ads.chanel.csj.utils.CsjUtil", "com.yfanads.ads.chanel.csj.utils.CsjUtil", "com.yfanads.ads.chanel.csj.BuildConfig", 1, AdnConfig.a.hnadsb, "initCsj"),
        YLH("com.qq.e.comm.managers.GDTAdSdk", "com.qq.e.comm.managers.status.SDKStatus", "com.yfanads.ads.chanel.ylh.utils.YlhUtil", "com.yfanads.ads.chanel.ylh.BuildConfig", 2, AdnConfig.a.hnadsc, "initAD"),
        BD("com.baidu.mobads.sdk.api.BDAdConfig", "com.baidu.mobads.sdk.api.AdSettings", "com.yfanads.ads.chanel.bd.utils.BDUtil", "com.yfanads.ads.chanel.bd.BuildConfig", 3, "bd", "initBDAccount"),
        KS("com.kwad.sdk.api.KsAdSDK", "com.kwad.components.offline.api.BuildConfig", "com.yfanads.ads.chanel.ks.utils.KSUtil", "com.yfanads.ads.chanel.ks.BuildConfig", 4, MediationConstant.ADN_KS, "initAD"),
        JD("com.jd.ad.sdk.bl.initsdk.JADYunSdk", "com.jd.ad.sdk.multi.BuildConfig", "com.yfanads.ads.chanel.jd.utls.JDUtil", "com.yfanads.ads.chanel.jd.BuildConfig", 9, "jd", "initJD"),
        OPPO("com.heytap.msp.mobad.api.MobAdManager", "com.heytap.msp.mobad.api.MobAdManager", "com.yfanads.ads.chanel.oppo.utls.OppoUtil", "com.yfanads.ads.chanel.oppo.BuildConfig", 8, "oppo", "initOppo"),
        XM("com.miui.zeus.mimo.sdk.MimoSdk", "com.miui.zeus.mimo.sdk.BuildConfig", "com.yfanads.ads.chanel.xm.utils.XmUtil", "com.yfanads.ads.chanel.xm.BuildConfig", 7, "xm", "initXm"),
        HW("com.huawei.hms.ads.HwAds", "com.huawei.hms.ads.Lang", "com.yfanads.ads.chanel.hw.utls.HwUtil", "com.yfanads.ads.chanel.hw.BuildConfig", 6, "hw", "initHw"),
        GROMORE("com.bytedance.sdk.openadsdk.TTAdSdk", "com.yfanads.ads.chanel.csj.utils.CsjUtil", "com.yfanads.ads.chanel.csj.utils.CsjUtil", "com.yfanads.ads.chanel.csj.BuildConfig", 11, UBiXWinPlatform.PLATFORM_GM, "initGroMore"),
        RY("com.hihonor.adsdk.base.HnAds", "com.hihonor.adsdk.base.BuildConfig", "com.yfanads.ads.chanel.ry.utils.RYUtil", "com.yfanads.ads.chanel.ry.BuildConfig", 13, "ry", "initRY"),
        AY("com.beizi.fusion.BeiZis", "com.beizi.fusion.BeiZis", "com.yfanads.ads.chanel.ay.utils.AYUtil", "com.yfanads.ads.chanel.ay.BuildConfig", 15, "ay", "initAY"),
        XU("com.octopus.ad.Octopus", "com.octopus.ad.Octopus", "com.yfanads.ads.chanel.xu.utils.XUUtil", "com.yfanads.ads.chanel.xu.BuildConfig", 16, "xu", "initXU"),
        GE("com.fancy.adsdk.lib.PtgAdSdk", "com.yfanads.ads.chanel.ge.utils.GEUtil", "com.yfanads.ads.chanel.ge.utils.GEUtil", "com.yfanads.ads.chanel.ge.BuildConfig", 17, "ge", "initGE"),
        CJ("com.dtyx.qckj.yhc.YhcAdInit", "com.yfanads.ads.chanel.cj.utils.CJUtil", "com.yfanads.ads.chanel.cj.utils.CJUtil", "com.yfanads.ads.chanel.cj.BuildConfig", 18, "cj", "initCJ"),
        IN("com.ubixnow.core.api.UMNAdManager", "com.yfanads.ads.chanel.in.utils.INUtil", "com.yfanads.ads.chanel.in.utils.INUtil", "com.yfanads.ads.chanel.in.BuildConfig", 19, "in", "initIN"),
        JC("com.alliance.ssp.ad.api.SAAllianceAdSdk", "com.alliance.ssp.ad.api.SAAllianceAdSdk", "com.yfanads.ads.chanel.jc.utils.JCUtil", "com.yfanads.ads.chanel.jc.BuildConfig", 20, "jc", "initJC"),
        NAL("com.adprof.sdk.AdprofSdk", "com.adprof.sdk.BuildConfig", "com.yfanads.ads.chanel.nal.utils.NalUtil", "com.yfanads.ads.chanel.nal.BuildConfig", 21, "nal", "initNal"),
        NC("com.jiaads.advista.sdk.AdvistaSdk", "com.yfanads.ads.chanel.nc.utils.NCUtil", "com.yfanads.ads.chanel.nc.utils.NCUtil", "com.yfanads.ads.chanel.nc.BuildConfig", 22, "nc", "initNC"),
        UW("com.yd.saas.ydsdk.api.YdSDK", "com.yfanads.ads.chanel.uw.utils.UWUtil", "com.yfanads.ads.chanel.uw.utils.UWUtil", "com.yfanads.ads.chanel.uw.BuildConfig", 23, "uw", "initUW"),
        KY("com.jt.fc.core.JuTuiAdSdk", "com.yfanads.ads.chanel.ky.utils.KYUtil", "com.yfanads.ads.chanel.ky.utils.KYUtil", "com.yfanads.ads.chanel.ky.BuildConfig", 24, "ky", "initKY"),
        KF("com.jd.ad.polyunion.view.AdView", "com.yfanads.ads.chanel.kf.utils.KFUtil", "com.yfanads.ads.chanel.kf.utils.KFUtil", "com.yfanads.ads.chanel.kf.BuildConfig", 25, "kf", "initKF"),
        ZD("com.meishu.sdk.core.AdSdk", "com.yfanads.ads.chanel.zd.utils.ZDUtil", "com.yfanads.ads.chanel.zd.utils.ZDUtil", "com.yfanads.ads.chanel.zd.BuildConfig", 26, "zd", "initZD"),
        VIVO("com.vivo.mobilead.manager.VivoAdManager", "com.vivo.mobad.BuildConfig", "com.yfanads.ads.chanel.vivo.utls.ViVoUtil", "com.yfanads.ads.chanel.vivo.BuildConfig", 10, "vivo", "initVivo"),
        TANX("com.alimm.tanx.ui.TanxSdk", "com.alimm.tanx.core.SdkConstant", "com.yfanads.ads.chanel.tanx.utils.TanXUtil", "com.yfanads.ads.chanel.tanx.BuildConfig", 14, "tanx", "initTanXAccount");

        public final String adapterName;
        public final String adapterVerName;
        public final int channel;
        public final String className;
        public final String initMethodName;
        public final String name;
        public final String verName;

        AdSource(String str, String str2, String str3, String str4, int i, String str5, String str6) {
            this.className = str;
            this.verName = str2;
            this.adapterName = str3;
            this.adapterVerName = str4;
            this.channel = i;
            this.name = str5;
            this.initMethodName = str6;
        }
    }

    public enum ReportAdnIdValue {
        CSJ(1),
        YLH(2),
        BAIDU(3),
        KS(4),
        ADX(12),
        HW(6),
        XM(7),
        OPPO(8),
        JD(9),
        VIVO(10),
        CSJ_GROMORE(11),
        RY(13),
        TANX(14),
        AY(15),
        XU(16),
        GE(17),
        CJ(18),
        IN(19),
        JC(20),
        NAL(21),
        NC(22),
        UW(23),
        KY(24),
        KF(25),
        ZD(26);

        private int value;

        ReportAdnIdValue(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum ReportECodeValue {
        TIME_OUT(300);

        private final int value;

        ReportECodeValue(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }

        public String getValueStr() {
            return String.valueOf(this.value);
        }
    }

    public enum ReportETypeValue {
        APP_OPEN(1),
        SDK_REQ(2),
        SDK_PADDING(3),
        SDK_PADDING_LOW(33),
        SDK_SHOW(4),
        SDK_CLICK(5),
        FLOW_REQ(6),
        FLOW_PADDING(7),
        VIDEO_READY(8),
        FLOW_FAIL(9),
        SDK_AUTO_CLICK(10),
        SDK_REWARD(11),
        FLOW_PADDING_FAIL(109),
        BIDDING_HIGHER(12),
        BIDDING_LOWER(13),
        APP_CRASH(14),
        CUSTOM_CLOSE(15),
        CLOSE(16),
        CHECK_AD_READY(17),
        CHECK_AD_READY_NULL(19),
        SHOW_API(18),
        SHOW_NEXT_INTERSTITIAL(20),
        SDK_SHOW_API(100),
        SDK_SHOW_API_REAL(101),
        APP_PERMISSION(111),
        APP_OPEN_RT(112),
        SDK_SHOW_RT(114),
        SDK_CLICK_RT(115),
        FLOW_REQ_RT(116),
        FLOW_PADDING_RT(AppTypeIdUtil.Drink4GCostControl_1),
        FLOW_PADDING_FAIL_RT(119),
        NEW_EVENT_TYPE(10000),
        APP_CONFIG_START(10001),
        APP_CONFIG_SUCCESS(10002),
        APP_CONFIG_FAIL(10003),
        ADS_SDK_START(MLBcrCaptureConfig.ERROR_CODE_INIT_CAMERA_FAILED),
        ADS_SDK_SUCCESS(10102),
        ADS_SDK_FAIL(10103),
        ADS_CONFIG_START(10201),
        ADS_CONFIG_SUCCESS(10202),
        ADS_CONFIG_FAIL(10203),
        ADS_CONFIG_USE(10204),
        ADS_CACHE_START(10301),
        ADS_CACHE_SUCCESS(10302),
        ADS_CACHE_EMPTY(10303),
        ADS_CACHE_INTERRUPT_START(10401),
        ADS_CACHE_INTERRUPT_END(10402),
        ADS_INIT_START(10501),
        ADS_INIT_SUCCESS(10502),
        ADS_INIT_FAIL(10503),
        ADS_BIDDING_SUCCESS(10504),
        ADS_LOAD_START(10601),
        ADS_BIDDING_INTERRUPT_START(10701),
        ADS_BIDDING_INTERRUPT_END(10702),
        ADS_CACHE_ADD(10801),
        ADS_CACHE_ADD_SUCCESS(10802),
        ADS_CACHE_ADD_FAIL_EXPIRES(10803),
        ADS_CACHE_ADD_FAIL_FULL(10804);

        private final int value;

        ReportETypeValue(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    private YFAdsConst() {
    }

    public static String getSource(int i) {
        switch (i) {
            case 1:
                return AdnConfig.a.hnadsb;
            case 2:
                return AdnConfig.a.hnadsc;
            case 3:
                return "bd";
            case 4:
                return MediationConstant.ADN_KS;
            case 5:
            case 12:
                return "adx";
            case 6:
                return "hw";
            case 7:
                return "xm";
            case 8:
                return "oppo";
            case 9:
                return "jd";
            case 10:
                return "vivo";
            case 11:
                return "groMore";
            case 13:
                return "ry";
            case 14:
                return "tanx";
            case 15:
                return "ay";
            case 16:
                return "xu";
            case 17:
                return "ge";
            case 18:
                return "cj";
            case 19:
                return "in";
            case 20:
                return "jc";
            case 21:
                return "nal";
            case 22:
                return "nc";
            case 23:
                return "uw";
            case 24:
                return "ky";
            case 25:
                return "kf";
            case 26:
                return "zd";
            default:
                return "";
        }
    }

    public static boolean isInWhiteList(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Iterator<String> it = WV_ACTIVITY_LIST.iterator();
        while (it.hasNext()) {
            if (str.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }
}
