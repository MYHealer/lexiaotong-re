package com.ubixnow.ooooo;

import android.location.Location;
import com.ubixnow.core.api.UMNPrivacyConfig;
import com.unionpay.tsmservice.data.Constant;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class j1 {
    public static boolean OooO = true;
    public static boolean OooO00o = true;
    public static boolean OooO0O0 = true;
    public static boolean OooO0OO = true;
    public static boolean OooO0Oo = true;
    public static boolean OooO0o = true;
    public static boolean OooO0o0 = true;
    public static boolean OooO0oO = true;
    public static boolean OooO0oo = true;
    public static boolean OooOO0 = true;
    public static Location OooOO0O = null;
    public static String OooOO0o = "";
    public static String OooOOO = "";
    public static String OooOOO0 = "";
    public static String OooOOOO = "";
    public static List<String> OooOOOo;
    public static int OooOOo0;

    public static void OooO00o() {
        OooO00o = !oOo00o00.OooO00o(oO00000o.o00000O0.OooOOo).booleanValue();
        OooO0OO = !oOo00o00.OooO00o(oO00000o.o00000O0.OooOo0).booleanValue();
        OooO0Oo = !oOo00o00.OooO00o(oO00000o.o00000O0.OooOo0O).booleanValue();
        OooO0o0 = !oOo00o00.OooO00o(oO00000o.o00000O0.OooOo).booleanValue();
        OooO0oO = !oOo00o00.OooO00o(oO00000o.o00000O0.OooOo00).booleanValue();
        OooO0o = !oOo00o00.OooO00o(oO00000o.o00000O0.OooOo0o).booleanValue();
        OooO0O0 = !oOo00o00.OooO00o(oO00000o.o00000O0.OooOOoo).booleanValue();
    }

    public static void OooO00o(UMNPrivacyConfig uMNPrivacyConfig, boolean z) {
        ooooO000.OooO0O0("---PrivacyConfig", "---init" + (uMNPrivacyConfig != null));
        if (uMNPrivacyConfig != null) {
            ooooO000.OooO0O0("权限设置提醒:\n     isO：" + uMNPrivacyConfig.isO() + "    强烈建议设置为true\n     getO：" + uMNPrivacyConfig.getO() + "    强烈建议无论is0设置为任何值,都传递oaid,以保障广告效果\n     isA：" + uMNPrivacyConfig.isA() + "    强烈建议设置为true\n     getA：" + uMNPrivacyConfig.getA() + "    若isA为false,强烈建议设置传递android id\n     isLimitPersonalAds：当前设置为:" + uMNPrivacyConfig.isLimitPersonalAds() + "   强烈建议设置为false\n     isProgrammaticRecommend：当前设置为:" + uMNPrivacyConfig.isProgrammaticRecommend() + "   强烈建议设置为true");
            if (!uMNPrivacyConfig.isCanUseLocation()) {
                OooO00o = false;
            }
            if (!uMNPrivacyConfig.isCanUsePhoneState()) {
                OooO0O0 = false;
            }
            if (!uMNPrivacyConfig.isA()) {
                OooO0OO = false;
            }
            if (!uMNPrivacyConfig.isO()) {
                OooO0Oo = false;
            }
            if (!uMNPrivacyConfig.isCanUseMacAddress()) {
                OooO0o0 = false;
            }
            if (!uMNPrivacyConfig.isCanUseWriteExternal()) {
                OooO0o = false;
            }
            if (!uMNPrivacyConfig.isW()) {
                OooO0oO = false;
            }
            if (!uMNPrivacyConfig.appList()) {
                OooO0oo = false;
            }
            if (uMNPrivacyConfig.isLimitPersonalAds()) {
                OooO = false;
            }
            if (!uMNPrivacyConfig.isProgrammaticRecommend()) {
                OooOO0 = false;
            }
            OooOO0O = uMNPrivacyConfig.getLocation();
            OooOO0o = uMNPrivacyConfig.getDevImei();
            OooOOO0 = uMNPrivacyConfig.getMacAddress();
            OooOOO = uMNPrivacyConfig.getA();
            if (uMNPrivacyConfig.getO() != null && !uMNPrivacyConfig.getO().startsWith(Constant.DEFAULT_CVN2)) {
                OooOOOO = uMNPrivacyConfig.getO();
            }
            OooOOOo = uMNPrivacyConfig.getAppList();
            if (z) {
                OooOOo0++;
            }
            if (ooooO000.OooO00o) {
                ooooO000.OooO0O0("---pub_init_parameter：", "isCanUsePhoneState：" + uMNPrivacyConfig.isCanUsePhoneState() + "    此设置项无要求,以开发者为准\n     isCanUseLocation：" + uMNPrivacyConfig.isCanUseLocation() + "    此设置项无要求,以开发者为准\n     getLocation：" + (uMNPrivacyConfig.getLocation() == null ? "" : uMNPrivacyConfig.getLocation().toString()) + "    此设置项无要求,以开发者为准\n     isCanAppList：" + uMNPrivacyConfig.appList() + "    此设置项无要求,以开发者为准\n     getAppList：" + (uMNPrivacyConfig.getAppList() != null ? uMNPrivacyConfig.getAppList().toArray() : "") + "    此设置项无要求,以开发者为准\n     getDevImei：" + uMNPrivacyConfig.getDevImei() + "    此设置项无要求,以开发者为准\n     isCanUseWifiState：" + uMNPrivacyConfig.isW() + "    此设置项无要求,以开发者为准\n     isCanUseWriteExternal：" + uMNPrivacyConfig.isCanUseWriteExternal() + "    此设置项无要求,以开发者为准\n     isO：" + uMNPrivacyConfig.isO() + "    强烈建议设置为true\n     getO：" + uMNPrivacyConfig.getO() + "    强烈建议无论is0设置为任何值,都传递oaid\n     isA：" + uMNPrivacyConfig.isA() + "    强烈建议设置为true\n     getA：" + uMNPrivacyConfig.getA() + "    若isA为false,强烈建议设置为true\n     isW：" + uMNPrivacyConfig.isW() + "\n     isCanUseMacAddress：" + uMNPrivacyConfig.isCanUseMacAddress() + "    此设置项无要求,以开发者为准\n     getMacAddress：" + uMNPrivacyConfig.getMacAddress() + "    此设置项无要求,以开发者为准\n     isLimitPersonalAds：" + uMNPrivacyConfig.isLimitPersonalAds() + "建议设置为false   in_n_v:" + OooO + "\n     isProgrammaticRecommend：" + uMNPrivacyConfig.isProgrammaticRecommend() + "建议设置为true   in_n_v:" + OooOO0);
            }
        }
    }
}
