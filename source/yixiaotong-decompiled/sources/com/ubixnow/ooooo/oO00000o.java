package com.ubixnow.ooooo;

import android.text.TextUtils;
import com.byazt.bv.BaseConstants;
import com.meishu.sdk.core.MSAdConfig;
import com.opos.acs.st.STManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oO00000o {

    public static class OooO {
        public static String OooO = "com.ubixnow.network.baidu.BdBannerAdapter";
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.baidu.BdInitManager";
        public static String OooO0OO = "com.ubixnow.network.baidu.BdSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.baidu.BdSplashInterstitialAdapter";
        public static String OooO0o = "com.ubixnow.network.baidu.BdRewardAdapter";
        public static String OooO0o0 = "com.ubixnow.network.baidu.BdInterstitalAdapter";
        public static String OooO0oO = "com.ubixnow.network.baidu.BdNativeAdapter";
        public static String OooO0oo = "com.ubixnow.network.baidu.BdNativeRenderSplashAdapter";
        public static String OooOO0 = "com.ubixnow.network.baidu.BdNativeRenderInterstitialAdapter";
        public static String OooOO0O = "com.ubixnow.network.baidu.BdNativeRenderBannerAdapter";
        public static String OooOO0o = "com.ubixnow.network.baidu.BdNativeRenderRewardAdapter";
    }

    public static class OooO00o {
        public static String OooO = "https://md-data-u1.ubixioe.com";
        public static String OooO00o = "https://md-cfg-u1.ubixioe.com";
        public static String OooO0O0 = "https://md-cfg-u1.ubixioe.com";
        public static String OooO0OO = "https://md-data-u1.ubixioe.com";
        public static final String OooO0Oo = "https://mdt2-test.ubixioe.com";
        public static String OooO0o = "https://md-data-u1-test.ubixioe.com";
        public static String OooO0o0 = "https://mdt2-test.ubixioe.com";
        public static String OooO0oO = "https://md-cfg-u1.ubixioe.com";
        public static String OooO0oo = "https://md-cfg-u1.ubixioe.com";
        public static final String OooOO0 = "/mob/mediation/v3/conf";
        public static final String OooOO0O = "/mob/mediation/material/chk";
        public static final String OooOO0o = "/md2";

        /* JADX INFO: renamed from: com.ubixnow.ooooo.oO00000o$OooO00o$OooO00o, reason: collision with other inner class name */
        public class RunnableC1139OooO00o implements Runnable {
            @Override // java.lang.Runnable
            public void run() {
                try {
                    String strOooO0o0 = oOo00o00.OooO0o0(o00000O0.OooO0o0);
                    String strOooO0o1 = oOo00o00.OooO0o0(o00000O0.OooO0o);
                    String strOooO0o2 = oOo00o00.OooO0o0(o00000O0.OooO0oO);
                    if (!TextUtils.isEmpty(strOooO0o0)) {
                        ooooO000.OooO0O0("策略域名替换：", strOooO0o0);
                        OooO00o.OooO00o = strOooO0o0;
                    }
                    if (!TextUtils.isEmpty(strOooO0o1)) {
                        ooooO000.OooO0O0("素材域名替换：", strOooO0o1);
                        OooO00o.OooO0O0 = strOooO0o1;
                    }
                    if (TextUtils.isEmpty(strOooO0o2)) {
                        return;
                    }
                    ooooO000.OooO0O0("埋点域名替换：", strOooO0o2);
                    OooO00o.OooO0OO = strOooO0o2;
                    oOO0O000.OooO0o = strOooO0o2 + OooO00o.OooOO0o;
                } catch (Throwable unused) {
                }
            }
        }

        static {
            OooO00o();
            OooO0OO();
            if (o00O0000.OooO0Oo == o00O0000.OooO00o.TEST) {
                OooO0oO = OooO0Oo;
                OooO00o = OooO0Oo;
                String str = OooO0o;
                OooO = str;
                OooO0OO = str;
                String str2 = OooO0o0;
                OooO0oo = str2;
                OooO0O0 = str2;
            }
            OooO0O0();
        }

        private static void OooO00o() {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.TTAdConfig$Builder").getDeclaredMethod("useMediation", Boolean.TYPE);
                ooooO000.OooO0Oo("已接入融合穿山甲");
                Oooo0.OooO0O0 = OooOOOO.OooO0O0;
                Oooo0.OooO0OO = OooOOOO.OooO0OO;
                Oooo0.OooO0oo = OooOOOO.OooO0Oo;
                Oooo0.OooOO0 = OooOOOO.OooO0o0;
                Oooo0.OooO = OooOOOO.OooO0o;
                Oooo0.OooO0Oo = OooOOOO.OooO0oO;
                Oooo0.OooO0o0 = OooOOOO.OooO0oo;
                Oooo0.OooO0o = OooOOOO.OooO;
                Oooo0.OooO0oO = OooOOOO.OooOO0;
                OooOOO.OooO = "com.bytedance.sdk.openadsdk.TTAdSdk";
            } catch (Throwable unused) {
                ooooO000.OooO0Oo("已接入独立穿山甲");
            }
        }

        public static void OooO0O0() {
            g1.OooO00o("ubixnow_sp").OooO0OO(new RunnableC1139OooO00o());
        }

        private static void OooO0OO() {
            try {
                Class.forName("com.jd.ad.sdk.splash.JADSplash").getDeclaredMethod("isMaterialMetaVideo", new Class[0]);
                o00Ooo.OooO0OO = o00Ooo.OooO0Oo;
                ooooO000.OooO0Oo("已接入新京东SDK");
            } catch (Throwable unused) {
                ooooO000.OooO0Oo("已接入京东SDK");
            }
        }
    }

    public static class OooO0O0 {
        public static final String OooO00o = "splash_mapping_type";
    }

    public static class OooO0OO {
        public static final int OooO00o = 1;
        public static final int OooO0O0 = 2;
        public static final int OooO0OO = 5;
        public static final int OooO0Oo = 3;
    }

    public static class OooO0o {
        public static final String OooO = "04";
        public static final String OooO00o = "1";
        public static final String OooO0O0 = "2";
        public static final String OooO0OO = "3";
        public static final String OooO0Oo = "4";
        public static final String OooO0o = "6";
        public static final String OooO0o0 = "5";
        public static final String OooO0oO = "7";
        public static final String OooO0oo = "03";
        public static final String OooOO0 = "8";
        public static final String OooOO0O = "9";
        public static final String OooOO0o = "10";
        public static final String OooOOO = "12";
        public static final String OooOOO0 = "11";
    }

    public static class OooOO0 {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.beizi.BeiziInitManager";
        public static String OooO0OO = "com.ubixnow.network.beizi.BeiziSplashAdapter";
    }

    public static class OooOO0O {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.best.BestInitManager";
        public static String OooO0OO = "com.ubixnow.network.best.BestSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.best.BestNativeAdapter";
    }

    public static class OooOOO {
        public static String OooO = "com.bytedance.msdk.api.v2.GMMediationAdSdk";
        public static String OooO00o = "com.kwad.sdk.api.KsAdSDK";
        public static String OooO0O0 = "com.baidu.mobads.sdk.api.BDAdConfig";
        public static String OooO0OO = "com.beizi.fusion.BeiZis";
        public static String OooO0Oo = "com.qq.e.comm.managers.GDTAdSdk";
        public static String OooO0o = "com.bytedance.sdk.openadsdk.TTAdSdk";
        public static String OooO0o0 = "com.jd.ad.sdk.bl.initsdk.JADYunSdk";
        public static String OooO0oO = "com.sigmob.windad.WindAds";
        public static String OooO0oo = "com.ubix.ssp.open.UBiXInitManger";
        public static String OooOO0 = "com.heytap.msp.mobad.api.MobAdManager";
        public static String OooOO0O = "com.mbridge.msdk.MBridgeSDK";
        public static String OooOO0o = "com.huawei.hms.ads.HwAds";
        public static String OooOOO = "com.heytap.msp.mobad.api.MobAdManager";
        public static String OooOOO0 = "com.heytap.msp.mobad.api.MobAdManager";
        public static String OooOOOO = "com.heytap.msp.mobad.api.MobAdManager";
        public static String OooOOOo = "com.lenovo.sdk.ads.LXAdSdk";
        public static String OooOOo = "com.youdao.sdk.common.YoudaoSDK";
        public static String OooOOo0 = "com.tencent.klevin.KlevinManager";
        public static String OooOOoo = "com.qumeng.advlib.api.AiClkAdManager";
        public static String OooOo = "cn.haorui.sdk.core.AdSdk";
        public static String OooOo0 = "com.my.adpoymer.manager.MyAdEntrance";
        public static String OooOo00 = "com.ptg.adsdk.lib.PtgAdSdk";
        public static String OooOo0O = "com.dydroid.ads.c.ADLoader";
        public static String OooOo0o = "com.octopus.ad.Octopus";
        public static String OooOoO = "com.mwsdk.ad.AdSdk";
        public static String OooOoO0 = "com.anythink.core.api.ATSDK";
        public static String OooOoOO = "com.insightvision.openadsdk.api.FanTiAdSdk";
        public static String OooOoo = "com.ubix.wm.appsdkdex.WMAdSdk";
        public static String OooOoo0 = "com.shu.priory.IFLYAdSDK";
        public static String OooOooO = "com.zm.fissionsdk.api.FissionSdk";
    }

    public static class OooOOO0 {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.buluken.BlkInitManager";
        public static String OooO0OO = "com.ubixnow.network.buluken.BlkSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.buluken.BlkInterstitialAdapter";
        public static String OooO0o0 = "com.ubixnow.network.buluken.BlkNativeAdapter";
    }

    public static class OooOOOO {
        public static String OooO = "com.ubixnow.network.csj.CsjNativeAdapter";
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.csj.CsjInitManager";
        public static String OooO0OO = "com.ubixnow.network.csj.CsjSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.csj.CsjNativeRenderSplashAdapter";
        public static String OooO0o = "com.ubixnow.network.csj.CsjNativeRenderRewardAdapter";
        public static String OooO0o0 = "com.ubixnow.network.csj.CsjNativeRenderInterstitialAdapter";
        public static String OooO0oO = "com.ubixnow.network.csj.CsjInterstitalAdapter";
        public static String OooO0oo = "com.ubixnow.network.csj.CsjRewardAdapter";
        public static String OooOO0 = "com.ubixnow.network.csj.CsjBannerAdapter";
    }

    public static class OooOo {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.fanwei.FwInitManager";
        public static String OooO0OO = "com.ubixnow.network.fanwei.FwSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.fanwei.FwInterstitialAdapter";
        public static String OooO0o = "com.ubixnow.network.fanwei.FwNativeAdapter";
        public static String OooO0o0 = "com.ubixnow.network.fanwei.FwRewardAdapter";
    }

    public static class OooOo00 {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.feisuo.FeiSuoInitManager";
        public static String OooO0OO = "com.ubixnow.network.feisuo.FeiSuoSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.feisuo.FeiSuoRewardAdapter";
        public static String OooO0o = "com.ubixnow.network.feisuo.FeiSuoNativeAdapter";
        public static String OooO0o0 = "com.ubixnow.network.feisuo.FeiSuoInterstitialAdapter";
    }

    public static class Oooo0 {
        public static String OooO = "com.ubixnow.network.csj.CsjNativeRenderRewardAdapter";
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.gromore.GMInitManager";
        public static String OooO0OO = "com.ubixnow.network.gromore.GMSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.gromore.GMInterstitialAdapter";
        public static String OooO0o = "com.ubixnow.network.gromore.GMNativeAdapter";
        public static String OooO0o0 = "com.ubixnow.network.gromore.GMRewardAdapter";
        public static String OooO0oO = "com.ubixnow.network.gromore.GMBannerAdapter";
        public static String OooO0oo = "com.ubixnow.network.gromore.GMNativeRenderSplashAdapter";
        public static String OooOO0 = "com.ubixnow.network.csj.CsjNativeRenderInterstitialAdapter";
    }

    public static class Oooo000 {
        public static String OooO = "com.ubixnow.network.gdt.GdtNativeRenderInterstitialAdapter";
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.gdt.GdtInitManager";
        public static String OooO0OO = "com.ubixnow.network.gdt.GdtSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.gdt.GdtNativeRenderSplashAdapter";
        public static String OooO0o = "com.ubixnow.network.gdt.GdtRewardAdapter";
        public static String OooO0o0 = "com.ubixnow.network.gdt.GdtInterstitalAdapter";
        public static String OooO0oO = "com.ubixnow.network.gdt.GdtNativeAdapter";
        public static String OooO0oo = "com.ubixnow.network.gdt.GdtBannerAdapter";
        public static String OooOO0 = "com.ubixnow.network.gdt.GdtNativeRenderRewardAdapter";
    }

    public static class o0000 {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.oppo.OppoInitManager";
        public static String OooO0OO = "com.ubixnow.network.oppo.OppoSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.oppo.OppoInterstitalAdapter";
        public static String OooO0o = "com.ubixnow.network.oppo.OppoNativeAdapter";
        public static String OooO0o0 = "com.ubixnow.network.oppo.OppoRewardAadpter";
        public static String OooO0oO = "com.ubixnow.network.oppo.OppoBannerAdapter";
        public static String OooO0oo = "com.ubixnow.network.oppo.OppoNativeRenderSplashAdapter";
    }

    public static class o00000 {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.simeng.SimengInitManager";
        public static String OooO0OO = "com.ubixnow.network.simeng.SimengNativeAdapter";
    }

    public static class o000000 {
        public static final int OooO00o = 1;
        public static final int OooO0O0 = 2;
    }

    public static class o000000O {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.sigmob.SigmobInitManager";
        public static String OooO0OO = "com.ubixnow.network.sigmob.SigmobSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.sigmob.SigmobRewardAdapter";
    }

    public static class o00000O {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.topon.TopOnInitManager";
        public static String OooO0OO = "com.ubixnow.network.topon.TopOnSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.topon.TopOnRewardAdapter";
        public static String OooO0o = "com.ubixnow.network.topon.TopOnNativeAdapter";
        public static String OooO0o0 = "com.ubixnow.network.topon.TopOnInterstitalAdapter";
    }

    public static class o00000O0 {
        public static String OooO = "md_install_app";
        public static String OooO00o = "md_init_response&%s";
        public static String OooO0O0 = "md_init_response&";
        public static String OooO0OO = "delete_data";
        public static String OooO0Oo = "md_scan_app_time";
        public static String OooO0o = "md_material_backup_domains";
        public static String OooO0o0 = "md_ubix_backup_domains";
        public static String OooO0oO = "md_tracking_backup_domains";
        public static String OooO0oo = "md_totalTimeout";
        public static String OooOO0 = "md_original_install_app";
        public static String OooOO0O = "md_collect_module_batch_size";
        public static String OooOO0o = "md_collect_module_interval";
        public static String OooOOO = "ad_cache_limit_size_";
        public static String OooOOO0 = "ad_cache_first_";
        public static String OooOOOO = "ad_cache_expire_time_";
        public static String OooOOOo = "need_upload_trackint_code";
        public static String OooOOo = "md_close_location";
        public static String OooOOo0 = "init_md5";
        public static String OooOOoo = "md_close_phone_state";
        public static String OooOo = "md_close_mac_address";
        public static String OooOo0 = "md_close_android_id";
        public static String OooOo00 = "md_close_wifi_state";
        public static String OooOo0O = "md_close_oaid";
        public static String OooOo0o = "md_close_write_external";
        public static String OooOoO = "_strategy_cache_succ_";
        public static String OooOoO0 = "_strategy_";
        public static String OooOoOO = "_strategy_cache_all_size_";
        public static String OooOoo = "_strategy_cache_expire_time";
        public static String OooOoo0 = "_strategy_cache_all_time_";
        public static final String OooOooO = "request_strategy_interval";
        public static final String OooOooo = "s2s_strategy_interval";
        public static final String Oooo0 = "dsst_";
        public static final String Oooo000 = "use_strategy_cache";
        public static final String Oooo00O = "crs3v";
        public static final String Oooo00o = "cfit";
        public static final String Oooo0O0 = "_material_rules";
    }

    public static class o00000OO {
        public static final String OooO00o = "1";
        public static final String OooO0O0 = "2";
        public static final String OooO0OO = "3";
        public static final String OooO0Oo = "4";
        public static final String OooO0o = "6";
        public static final String OooO0o0 = "5";
        public static final String OooO0oO = "7";
    }

    public static class o0000O0 {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.yky.YkyInitManager";
        public static String OooO0OO = "com.ubixnow.network.yky.YkySplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.yky.YkyInterstitalAdapter";
        public static String OooO0o = "com.ubixnow.network.yky.YkyNativeAdapter";
        public static String OooO0o0 = "com.ubixnow.network.yky.YkyRewardAdapter";
        public static String OooO0oO = "com.ubixnow.network.yky.YkyNativeRenderSplashAdapter";
    }

    public static class o0000O00 {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.wangmai.WangMaiInitManager";
        public static String OooO0OO = "com.ubixnow.network.wangmai.WangMaiSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.wangmai.WangMaiRewardAdapter";
        public static String OooO0o = "com.ubixnow.network.wangmai.WangMaiNativeAdapter";
        public static String OooO0o0 = "com.ubixnow.network.wangmai.WangMaiInterstitalAdapter";
        public static String OooO0oO = "com.ubixnow.network.wangmai.WangMaiBannerAdapter";
    }

    public static class o0000O0O {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.youshi.YouShiInitManager";
        public static String OooO0OO = "com.ubixnow.network.youshi.YouShiSplashAdapter";
    }

    public static class o0000Ooo {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.ubix2.Ubix2InitManager";
        public static String OooO0OO = "com.ubixnow.network.ubix2.Ubix2SplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.ubix2.UbixNativeAdapter";
        public static String OooO0o = "com.ubixnow.network.ubix2.UbixRewardAdapter";
        public static String OooO0o0 = "com.ubixnow.network.ubix2.UbixInterstitalAdapter";
        public static String OooO0oO = "com.ubixnow.network.ubix2.UbixBannerAdapter";
    }

    public static class o0000oo {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.oppo.OppoInitManager";
        public static String OooO0OO = "com.ubixnow.network.oppo.OppoSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.oppo.OppoInterstitalAdapter";
        public static String OooO0o = "com.ubixnow.network.oppo.OppoNativeAdapter";
        public static String OooO0o0 = "com.ubixnow.network.oppo.OppoRewardActivity";
        public static String OooO0oO = "com.ubixnow.network.oppo.OppoBannerAdapter";
        public static String OooO0oo = "com.ubixnow.network.oppo.OppoNativeRenderSplashAdapter";
    }

    public static class o000OO {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.youdao.YoudaoSplashAdapter";
        public static String OooO0OO = "com.ubixnow.network.youdao.YoudaoInitManager";
        public static String OooO0Oo = "com.ubixnow.network.youdao.YoudaoNativeRenderSplashAdapter";
        public static String OooO0o = "com.ubixnow.network.youdao.YoudaoRewardAdapter";
        public static String OooO0o0 = "com.ubixnow.network.youdao.YoudaoInterstitalAdapter";
        public static String OooO0oO = "com.ubixnow.network.youdao.YoudaoNativeAdapter";
    }

    public static class o000OOo {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.qumeng.QmInitManager";
        public static String OooO0OO = "com.ubixnow.network.qumeng.QmSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.qumeng.QmInterstitalAdapter";
        public static String OooO0o = "com.ubixnow.network.qumeng.QmNativeAdapter";
        public static String OooO0o0 = "com.ubixnow.network.qumeng.QmRewardAdapter";
        public static String OooO0oO = "com.ubixnow.network.qumeng.QmNativeRenderBannerAdapter";
    }

    public static class o000oOoO {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.huawei.HwInitManager";
        public static String OooO0OO = "com.ubixnow.network.huawei.HwSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.huawei.HwInterstitalAdapter";
        public static String OooO0o = "com.ubixnow.network.huawei.HwNativeAdapter";
        public static String OooO0o0 = "com.ubixnow.network.huawei.HwRewardAdapter";
        public static String OooO0oO = "com.ubixnow.network.huawei.HwBannerAdapter";
        public static String OooO0oo = "com.ubixnow.network.huawei.HwNativeRenderSplashAdapter";
    }

    public static class o00O0O {
        public static int OooO = 86400;
        public static int OooO00o = 0;
        public static int OooO0O0 = 1;
        public static int OooO0OO = 15000;
        public static int OooO0Oo = 5;
        public static boolean OooO0o = true;
        public static String OooO0o0 = "all";
        public static int OooO0oO = 600;
        public static boolean OooO0oo = false;
        public static int OooOO0 = 10;
        public static Map<String, String> OooOO0O = null;
        public static Map<String, String> OooOO0o = null;
        public static int OooOOO0 = 2;
        public static int OooOOo;
        public static int OooOOoo;
        public static String OooOo00;
        public static Set<String> OooOOO = new HashSet();
        public static HashMap<String, String> OooOOOO = new HashMap<>();
        public static boolean OooOOOo = true;
        public static String OooOOo0 = "";
    }

    public static class o00Oo0 {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.oppo.OppoInitManager";
        public static String OooO0OO = "com.ubixnow.network.oppo.OppoSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.oppo.OppoInterstitalAdapter";
        public static String OooO0o = "com.ubixnow.network.oppo.OppoNativeAdapter";
        public static String OooO0o0 = "com.ubixnow.network.oppo.YkyRewardAdapter";
        public static String OooO0oO = "com.ubixnow.network.oppo.OppoBannerAdapter";
        public static String OooO0oo = "com.ubixnow.network.oppo.OppoNativeRenderSplashAdapter";
    }

    public static class o00Ooo {
        public static String OooO = "com.ubixnow.network.jingmei2.Jd2NativeRenderBannerAdapter";
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.jingmei2.Jd2InitManager";
        public static String OooO0OO = "com.ubixnow.network.jingmei2.Jd2SplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.jingmei2.JdSplashNewAdapter";
        public static String OooO0o = "com.ubixnow.network.jingmei2.Jd2NativeAdapter";
        public static String OooO0o0 = "com.ubixnow.network.jingmei2.Jd2InterstitalAdapter";
        public static String OooO0oO = "com.ubixnow.network.jingmei2.Jd2NativeRenderSplashAdapter";
        public static String OooO0oo = "com.ubixnow.network.jingmei2.Jd2BannerAdapter";
    }

    public static class o00oO0o {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.lenovo.LxInitManager";
        public static String OooO0OO = "com.ubixnow.network.lenovo.LxSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.lenovo.LxNativeRenderSplashAdapter";
        public static String OooO0o = "com.ubixnow.network.lenovo.LxRewardAdapter";
        public static String OooO0o0 = "com.ubixnow.network.lenovo.LxInterstitalAdapter";
        public static String OooO0oO = "com.ubixnow.network.lenovo.LxNativeAdapter";
        public static String OooO0oo = "com.ubixnow.network.lenovo.LxBannerAdapter";
    }

    public static class o0O0O00 {
        public static final int OooO = 8;
        public static final int OooO00o = 0;
        public static final int OooO0O0 = 1;
        public static final int OooO0OO = 2;
        public static final int OooO0Oo = 3;
        public static final int OooO0o = 5;
        public static final int OooO0o0 = 4;
        public static final int OooO0oO = 6;
        public static final int OooO0oo = 7;
        public static final int OooOO0 = 10;
        public static final int OooOO0O = 15;
        public static final int OooOO0o = 14;
        public static final int OooOOO = 18;
        public static final int OooOOO0 = 17;
        public static final int OooOOOO = 9;
        public static final int OooOOOo = 19;
        public static final int OooOOo = 21;
        public static final int OooOOo0 = 20;
        public static final int OooOOoo = 22;
        public static final int OooOo = 27;
        public static final int OooOo0 = 24;
        public static final int OooOo00 = 23;
        public static final int OooOo0O = 25;
        public static final int OooOo0o = 26;
        public static final int OooOoO = 29;
        public static final int OooOoO0 = 28;
        public static final int OooOoOO = 30;
        public static final int OooOoo = 33;
        public static final int OooOoo0 = 32;
        public static final int OooOooO = 34;
        public static final int OooOooo = 35;

        public static String OooO00o(int i) {
            switch (i) {
                case -1:
                    return "All";
                case 0:
                case 11:
                case 12:
                case 13:
                case 16:
                case 19:
                case 21:
                case 31:
                default:
                    return "UNKOWN";
                case 1:
                    return "PANGLE";
                case 2:
                    return MSAdConfig.PLATFORM_GDT;
                case 3:
                    return "KUAISHOU";
                case 4:
                    return "JINGMEI";
                case 5:
                    return "UBIX";
                case 6:
                    return MSAdConfig.PLATFORM_BD;
                case 7:
                    return "IQIYI";
                case 8:
                    return "SIGMOB";
                case 9:
                    return "HUAWEI";
                case 10:
                    return "BEIZI";
                case 14:
                    return "LENOVO";
                case 15:
                    return BaseConstants.ROM_OPPO_UPPER_CONSTANT;
                case 17:
                    return "GROMORE";
                case 18:
                    return "MINTEGRAL";
                case 20:
                    return "YKY";
                case 22:
                    return "YOUDAO";
                case 23:
                    return "QUMENG";
                case 24:
                    return "FANWEI";
                case 25:
                    return "OCTOPUS";
                case 26:
                    return STManager.REGION_OF_MY;
                case 27:
                    return "SIMENG";
                case 28:
                    return "MEISHU";
                case 29:
                    return "TOPON";
                case 30:
                    return "BULUKEN";
                case 32:
                    return "YOUSHI";
                case 33:
                    return "IFLY";
                case 34:
                    return "WANGMAI";
                case 35:
                    return "FEISUO";
            }
        }
    }

    public static class o0OO00O {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.octopus.OtpInitManager";
        public static String OooO0OO = "com.ubixnow.network.octopus.OtpSplashAdapter";
    }

    public static class o0OOO0o {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.mtg.MintegralInitManager";
        public static String OooO0OO = "com.ubixnow.network.mtg.MintegralSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.mtg.MtgNativeRenderSplashAdapter";
        public static String OooO0o = "com.ubixnow.network.mtg.MintegralRewardAdapter";
        public static String OooO0o0 = "com.ubixnow.network.mtg.MintegralInterstitalAdapter";
        public static String OooO0oO = "com.ubixnow.network.mtg.MintegralNativeAdapter";
        public static String OooO0oo = "com.ubixnow.network.mtg.MintegralBannerAdapter";
    }

    public static class o0Oo0oo {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.oppo.OppoInitManager";
        public static String OooO0OO = "com.ubixnow.network.oppo.OppoSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.oppo.OppoInterstitalAdapter";
        public static String OooO0o = "com.ubixnow.network.oppo.OppoNativeAdapter";
        public static String OooO0o0 = "com.ubixnow.network.oppo.OppoRewardAdapter";
        public static String OooO0oO = "com.ubixnow.network.oppo.OppoBannerAdapter";
        public static String OooO0oo = "com.ubixnow.network.oppo.OppoNativeRenderSplashAdapter";
    }

    public static class o0OoOo0 {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.ifly.IflyInitManager";
        public static String OooO0OO = "com.ubixnow.network.ifly.IflySplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.ifly.IflyInterstitialAdapter";
        public static String OooO0o = "com.ubixnow.network.ifly.IflyNativeAdapter";
        public static String OooO0o0 = "com.ubixnow.network.ifly.IflyRewardAdapter";
        public static String OooO0oO = "com.ubixnow.network.ifly.IflyBannerAdapter";
    }

    public static class o0ooOOo {
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.meishu.MsInitManager";
        public static String OooO0OO = "com.ubixnow.network.meishu.MsSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.meishu.MsRewardAdapter";
        public static String OooO0o = "com.ubixnow.network.meishu.MsNativeAdapter";
        public static String OooO0o0 = "com.ubixnow.network.meishu.MsInterstitalAdapter";
    }

    public static class oo000o {
        public static String OooO = "com.ubixnow.network.kuaishou.KsBannerAdapter";
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.kuaishou.KsSplashAdapter";
        public static String OooO0OO = "com.ubixnow.network.kuaishou.KsInitManager";
        public static String OooO0Oo = "com.ubixnow.network.kuaishou.KsNativeRenderSplashAdapter";
        public static String OooO0o = "com.ubixnow.network.kuaishou.KsRewardAdapter";
        public static String OooO0o0 = "com.ubixnow.network.kuaishou.KsInterstitalAdapter";
        public static String OooO0oO = "com.ubixnow.network.kuaishou.KsNativeAdapter";
        public static String OooO0oo = "com.ubixnow.network.kuaishou.KsNativeRenderInterstitialAdapter";
        public static String OooOO0 = "com.ubixnow.network.kuaishou.KsNativeRenderRewardAdapter";
    }

    public static class oo0o0Oo {
        public static String OooO = "com.ubixnow.network.pangle.PangleNativeAdapter";
        public static String OooO00o = null;
        public static String OooO0O0 = "com.ubixnow.network.pangle.PangleInitManager";
        public static String OooO0OO = "com.ubixnow.network.pangle.PangleSplashAdapter";
        public static String OooO0Oo = "com.ubixnow.network.pangle.PangleInterstitialAdapter";
        public static String OooO0o = "com.ubixnow.network.pangle.PangleNativeRenderSplashAdapter";
        public static String OooO0o0 = "com.ubixnow.network.pangle.PangleNativeRenderInterstitialAdapter";
        public static String OooO0oO = "com.ubixnow.network.pangle.PangleNativeRenderRewardAdapter";
        public static String OooO0oo = "com.ubixnow.network.pangle.PangleRewardAdapter";
        public static String OooOO0 = "com.ubixnow.network.pangle.PangleBannerAdapter";
    }
}
