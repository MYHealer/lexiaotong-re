package com.meishu.sdk.core.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.res.Configuration;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebSettings;
import client.android.yixiaotong.util.TimeUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.af;
import com.fancy.adsdk.lib.constants.PtgRewardConstant;
import com.google.gson.Gson;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.AdType;
import com.meishu.sdk.core.loader.serverbidding.S2SBManager;
import com.meishu.sdk.core.loader.serverbidding.S2SBUtil;
import com.stub.StubApp;
import com.ubixnow.ooooo.o0OO000o;
import com.umeng.analytics.pro.am;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;
import java.lang.reflect.Constructor;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: RequestUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class x0 {
    public static String A;
    public static s0 B;
    public static String C;
    public static ConcurrentHashMap<String, String> D;
    public static Integer E;
    public static String F;
    public static volatile boolean G;
    public static String H;
    public static int I;
    public static Boolean J;
    public static String[] K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4955a;
    public static String b;
    public static String c;
    public static String d;
    public static String e;
    public static DisplayMetrics f;
    public static String g;
    public static String h;
    public static String i;
    public static String j;
    public static String k;
    public static String l;
    public static String m;
    public static String n;
    public static String o;
    public static String p;
    public static String q;
    public static String r;
    public static String s;
    public static String t;
    public static String u;
    public static String v;
    public static String w;
    public static String x;
    public static String y;
    public static String z;

    static {
        new HashMap();
        B = new s0();
        C = null;
        D = new ConcurrentHashMap<>();
        I = -1;
        J = null;
        K = new String[]{"/dev/socket/qemud", "/dev/qemu_pipe"};
    }

    public static Map<String, String> a(Context context, String str, AdType adType, long j2, long j3) {
        ConcurrentHashMap<String, String> concurrentHashMap;
        String s2SBJson;
        String str2;
        String str3;
        String str4;
        BufferedReader bufferedReader;
        String strTrim;
        List<Integer> disableSensorTypes;
        int i2;
        int i3;
        int i4;
        int i5;
        long j4;
        RecordBean recordBean;
        PckIdBean pckIdBean;
        AdSdk.adConfig();
        HashMap map = new HashMap();
        try {
            String strA = q.a().a("cache_params", "");
            if (TextUtils.isEmpty(strA)) {
                concurrentHashMap = null;
            } else {
                JSONObject jSONObject = new JSONObject(strA);
                concurrentHashMap = new ConcurrentHashMap<>();
                try {
                    if (jSONObject != JSONObject.NULL) {
                        ConcurrentHashMap<String, String> concurrentHashMap2 = new ConcurrentHashMap<>();
                        Iterator<String> itKeys = jSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            concurrentHashMap2.put(next, (String) jSONObject.get(next));
                        }
                        concurrentHashMap = concurrentHashMap2;
                    }
                } catch (Throwable th) {
                    th = th;
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            concurrentHashMap = null;
        }
        D = concurrentHashMap;
        if (concurrentHashMap != null) {
            if (!concurrentHashMap.contains("app_y") && (pckIdBean = q0.b) != null) {
                String app_y = pckIdBean.getApp_y();
                String app_n = pckIdBean.getApp_n();
                if (!TextUtils.isEmpty(app_y)) {
                    if (app_y.startsWith(".")) {
                        app_y = app_y.substring(1);
                    }
                    map.put("app_y", app_y);
                }
                if (!TextUtils.isEmpty(app_n)) {
                    if (app_n.startsWith(".")) {
                        app_n = app_n.substring(1);
                    }
                    map.put("app_n", app_n);
                }
            }
            map.putAll(D);
            ExecutorService executorService = g0.f4905a;
            g0.b.f4906a.a(new w0(context, adType));
        } else {
            a(context, adType);
            ConcurrentHashMap<String, String> concurrentHashMap3 = D;
            if (concurrentHashMap3 != null) {
                map.putAll(concurrentHashMap3);
            }
        }
        MSAdConfig mSAdConfigAdConfig = AdSdk.adConfig();
        map.put("version", "20251125");
        if (!TextUtils.isEmpty(str)) {
            map.put("pid", str);
        }
        map.put("is_mobile", "1");
        map.put("init_uuid", MSAdConfig.initUUID());
        map.put("hidp", "1");
        map.put("iflag_ant", String.valueOf(268435456));
        map.put("iflag_aefr", String.valueOf(8388608));
        map.put("iflag_ast", String.valueOf(536870912));
        map.put("iflag_act", String.valueOf(32768));
        map.put(com.baidu.mobads.sdk.internal.d.f1799a, Long.toString(AdSdk.getInitTime()));
        map.put("init_succ", Long.toString(AdSdk.getInitSuccTime()));
        map.put("all_times", Long.toString(j2));
        map.put("type_times", Long.toString(j3));
        if (AdSdk.adConfig().isUseMediation()) {
            try {
                s2SBJson = S2SBUtil.getS2SBJson(context, S2SBManager.getAdByPid(context, str));
            } catch (Exception e2) {
                e2.printStackTrace();
                s2SBJson = null;
            }
            if (!TextUtils.isEmpty(s2SBJson)) {
                map.put("s2sb", s2SBJson);
            }
        }
        map.put(ClientCookie.SECURE_ATTR, String.valueOf(mSAdConfigAdConfig.secure()));
        String str5 = "0";
        map.put("dtc_net_http", l() ? "1" : "0");
        if (!TextUtils.isEmpty(mSAdConfigAdConfig.userKeywords())) {
            map.put(com.hihonor.adsdk.base.c.y.hnadsa, mSAdConfigAdConfig.userKeywords());
        }
        if (!TextUtils.isEmpty(mSAdConfigAdConfig.userExt())) {
            map.put(o0OO000o.o00O0O0O, mSAdConfigAdConfig.userExt());
        }
        if (mSAdConfigAdConfig.userType() != null) {
            map.put("user_type", mSAdConfigAdConfig.userType().toString());
        }
        map.put("app_id", AdSdk.adConfig().appId());
        if (!TextUtils.isEmpty(mSAdConfigAdConfig.userDenyCats())) {
            map.put("deny_cats", mSAdConfigAdConfig.userDenyCats());
        }
        if (!TextUtils.isEmpty(mSAdConfigAdConfig.userDenyCids())) {
            map.put("deny_cids", mSAdConfigAdConfig.userDenyCids());
        }
        if (!TextUtils.isEmpty(mSAdConfigAdConfig.userDenyAderIds())) {
            map.put("deny_ader_ids", mSAdConfigAdConfig.userDenyAderIds());
        }
        if (AdSdk.adConfig().customController() == null || AdSdk.adConfig().customController().isCanUseLocation()) {
            a(map, context);
        } else if (AdSdk.adConfig().customController().getLocation() != null) {
            Location location = AdSdk.adConfig().customController().getLocation();
            map.put("device_geo_lat", Double.valueOf(location.getLatitude()).toString());
            map.put("device_geo_lon", Double.valueOf(location.getLongitude()).toString());
        }
        if (!TextUtils.isEmpty(AdSdk.getLocalOaid()) && !"unknown".equals(AdSdk.getLocalOaid())) {
            if (TextUtils.isEmpty(B.s)) {
                B.s = AdSdk.getLocalOaid();
            }
            map.put("device_oaid", AdSdk.getLocalOaid());
        }
        String str6 = Build.MANUFACTURER;
        if (str6.equalsIgnoreCase("honor") && AdSdk.adConfig() != null && AdSdk.adConfig().enableOaid()) {
            String strA2 = q.a().a("honor_oaid", (String) null);
            if (!TextUtils.isEmpty(strA2)) {
                map.put("honor_oaid", strA2);
            }
        }
        if (!TextUtils.isEmpty(AdSdk.getLocalOaid()) && AdSdk.adConfig() != null && AdSdk.adConfig().enableOaid()) {
            map.put("m_oaid", AdSdk.getLocalOaid());
        }
        if (!TextUtils.isEmpty(AdSdk.adConfig().userId())) {
            map.put(PtgRewardConstant.REWARD_PARAMS.USER_ID, AdSdk.adConfig().userId());
        }
        String str7 = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str7)) {
            map.put("device_type_os", str7);
        }
        map.put("device_apiLevel", String.valueOf(Build.VERSION.SDK_INT));
        Integer numE = e(context);
        String str8 = "device_battery_level";
        if (numE != null) {
            B.getClass();
            map.put("device_battery_level", String.valueOf(numE));
        }
        if (!TextUtils.isEmpty(str6)) {
            map.put(am.H, str6);
        }
        String str9 = Build.BRAND;
        if (!TextUtils.isEmpty(str9)) {
            map.put(am.F, str9);
        }
        String str10 = Build.MODEL;
        if (!TextUtils.isEmpty(str10)) {
            map.put("device_model", str10);
        }
        try {
            if (m == null && t1.d()) {
                String strB = t1.b();
                m = strB;
                if (TextUtils.isEmpty(strB)) {
                    m = e1.a("deviceModelVivo", null);
                } else {
                    e1.b("deviceModelVivo", m);
                }
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        if (!TextUtils.isEmpty(m)) {
            map.put("device_model_vivo", m);
        }
        map.put("device_os", "Android");
        if (TextUtils.isEmpty(i)) {
            int i6 = context.getResources().getConfiguration().orientation;
            if (i6 == 1) {
                i = "0";
            } else if (i6 != 2) {
                i = "-1";
            } else {
                i = "1";
            }
        }
        if (!TextUtils.isEmpty(i)) {
            map.put("device_orientation", i);
        }
        Locale locale = context.getResources().getConfiguration().locale;
        if (locale != null) {
            map.put(am.O, locale.getCountry());
            map.put("language", locale.getLanguage());
        }
        if (!TextUtils.isEmpty("2.5.13.3")) {
            map.put("sdk_version", "2.5.13.3");
            map.put(com.hihonor.adsdk.base.g.j.e.a.hnadsy, Long.toString(2051303L));
        }
        if (adType != null) {
            map.put("accept_ad_type", String.valueOf(adType.value()));
        }
        if (q0.d != null) {
            map.put("dclk_s", q0.d.getStatus() + "");
        }
        HashMap<String, u0.a> map2 = u0.f4949a;
        try {
            HashMap<String, RecordBean> mapA = u0.a();
            if (mapA == null || (recordBean = mapA.get(str)) == null) {
                str2 = null;
            } else {
                str2 = recordBean.getLoadNum() + "." + recordBean.getLoadSucc() + "." + recordBean.getExposureNum() + "." + recordBean.getClickNum() + "." + recordBean.getDynamicClickNum() + "." + recordBean.getLastDynamicLoadedTime() + "." + recordBean.getLastDynamicClickTime() + "." + recordBean.getLastClickTime();
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        if (str2 != null) {
            map.put("dclk_p", str2);
        }
        try {
            HashMap<String, RecordBean> mapA2 = u0.a();
            long jA = q.a().a("last_dynamic_time", 0L);
            long jA2 = q.a().a("last_click_time", 0L);
            int i7 = 0;
            if (mapA2 != null) {
                ArrayList arrayList = new ArrayList(mapA2.values());
                int loadNum = 0;
                int loadSucc = 0;
                int exposureNum = 0;
                int clickNum = 0;
                int dynamicClickNum = 0;
                long lastDynamicLoadedTime = 0;
                while (i7 < arrayList.size()) {
                    RecordBean recordBean2 = (RecordBean) arrayList.get(i7);
                    if (recordBean2 != null) {
                        loadNum += recordBean2.getLoadNum();
                        loadSucc += recordBean2.getLoadSucc();
                        exposureNum += recordBean2.getExposureNum();
                        clickNum += recordBean2.getClickNum();
                        dynamicClickNum += recordBean2.getDynamicClickNum();
                        if (recordBean2.getLastDynamicLoadedTime() > lastDynamicLoadedTime) {
                            lastDynamicLoadedTime = recordBean2.getLastDynamicLoadedTime();
                        } else {
                            continue;
                        }
                    }
                    i7++;
                }
                i7 = loadNum;
                i2 = loadSucc;
                i3 = exposureNum;
                i4 = clickNum;
                i5 = dynamicClickNum;
                j4 = lastDynamicLoadedTime;
            } else {
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                j4 = 0;
            }
            if (i7 == 0 && i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0 && j4 == 0 && jA == 0) {
                str3 = "";
                str4 = null;
            } else {
                str3 = "";
                try {
                    str4 = i7 + "." + i2 + "." + i3 + "." + i4 + "." + i5 + "." + j4 + "." + jA + "." + jA2;
                } catch (Exception e4) {
                    e = e4;
                    e.printStackTrace();
                    str4 = null;
                }
            }
        } catch (Exception e5) {
            e = e5;
            str3 = "";
            str5 = "0";
            str8 = "device_battery_level";
        }
        if (str4 != null) {
            map.put("dclk_a", str4);
        }
        if (TextUtils.isEmpty(B.c)) {
            B.c = String.valueOf(j.c);
        }
        try {
            if (j.c != 675 || ((disableSensorTypes = AdSdk.adConfig().getDisableSensorTypes()) != null && disableSensorTypes.contains(4) && disableSensorTypes.contains(1) && disableSensorTypes.contains(9))) {
                map.put("accept_act_type", String.valueOf(j.c));
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
        if (com.meishu.sdk.core.oaid.c.a() && Build.VERSION.SDK_INT >= 31) {
            if (TextUtils.isEmpty(H)) {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/self/cgroup"), "UTF-8"));
                    try {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            }
                            sb.append(line).append(IOUtils.LINE_SEPARATOR_UNIX);
                        }
                        strTrim = sb.toString().trim();
                        try {
                            bufferedReader2.close();
                        } catch (Exception unused) {
                        }
                    } catch (Throwable unused2) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused3) {
                            }
                        }
                        strTrim = str3;
                    }
                } catch (Throwable unused4) {
                    bufferedReader = null;
                }
                if (TextUtils.isEmpty(strTrim) || !strTrim.contains("isulad")) {
                    H = str5;
                } else {
                    H = "1";
                }
            }
            if (!TextUtils.isEmpty(H) && "1".equals(H)) {
                map.put("isulad", H);
            }
        }
        if (AdSdk.adConfig() != null && AdSdk.adConfig().isSplashClickToClosed()) {
            map.put("close_on_click", "1");
        }
        SoftReference softReference = new SoftReference(context);
        ExecutorService executorService2 = g0.f4905a;
        g0.b.f4906a.a(new v0(softReference));
        DisplayMetrics displayMetrics = f;
        if (displayMetrics != null) {
            map.put("device_x_width", String.valueOf(displayMetrics.widthPixels));
            map.put("device_x_height", String.valueOf(f.heightPixels));
        }
        if (E != null) {
            B.getClass();
            map.put(str8, String.valueOf(E));
        }
        if (!TextUtils.isEmpty(F)) {
            B.getClass();
            map.put("device_network", F);
        }
        if (!TextUtils.isEmpty(t)) {
            if (TextUtils.isEmpty(B.n)) {
                B.n = t;
            }
            map.put("device_disk_free", t);
        }
        if (!TextUtils.isEmpty(u)) {
            if (TextUtils.isEmpty(B.r)) {
                B.r = u;
            }
            map.put("device_font_size", u);
        }
        return map;
    }

    public static Map<String, String> b(Context context, String str, AdType adType, long j2, long j3) {
        String strAppId = AdSdk.adConfig().appId();
        if (TextUtils.isEmpty(strAppId) || TextUtils.isEmpty(str) || adType == null) {
            LogUtil.e("RequestUtil", String.format(Locale.US, "wrapParams pid or appId or ad Type is empty: %s %s %s", strAppId, str, String.valueOf(adType)));
        }
        return a(context, str, adType, j2, j3);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0062  */
    public static String c(Context context) {
        String str = "com.oppo.market";
        String str2 = null;
        try {
            switch (Build.MANUFACTURER.toLowerCase()) {
                case "honor":
                    str = "com.hihonor.appmarket";
                    return str;
                case "huawei":
                    str = com.huawei.openalliance.ad.constant.x.af;
                    return str;
                case "xiaomi":
                    str = "com.xiaomi.market";
                    return str;
                case "vivo":
                    str = "com.bbk.appstore";
                    return str;
                case "oppo":
                    str2 = af.e;
                    try {
                        if (context.getPackageManager().getPackageInfo(af.e, 0) != null) {
                            return af.e;
                        }
                    } catch (Exception unused) {
                    }
                    return str;
                case "meizu":
                    str = "com.meizu.mstore";
                    return str;
                case "oneplus":
                    str = "com.oneplus.market";
                    return str;
                case "samsung":
                    str = "com.sec.android.app.samsungapps";
                    return str;
                default:
                    return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }

    public static String h(Context context) {
        PackageInfo packageInfo;
        try {
            if (TextUtils.isEmpty(r)) {
                try {
                    packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 16384);
                } catch (Throwable unused) {
                    packageInfo = null;
                }
                if (packageInfo != null) {
                    if (packageInfo.versionCode >= 0) {
                        r = packageInfo.versionCode + "";
                    } else {
                        r = null;
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return r;
    }

    public static String i() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(AdSdk.getBDVersionName())) {
            sb.append("BAIDU=");
            sb.append(AdSdk.getBDVersionName());
        }
        if (!TextUtils.isEmpty(AdSdk.getCSJVersionName())) {
            sb.append("&CSJ=");
            sb.append(AdSdk.getCSJVersionName());
        }
        if (!TextUtils.isEmpty(AdSdk.getGDTVersionName())) {
            sb.append("&GDT=");
            sb.append(AdSdk.getGDTVersionName());
        }
        if (!TextUtils.isEmpty(AdSdk.getJDVersionName())) {
            sb.append("&JD=");
            sb.append(AdSdk.getJDVersionName());
        }
        if (!TextUtils.isEmpty(AdSdk.getKSVersionName())) {
            sb.append("&KS=");
            sb.append(AdSdk.getKSVersionName());
        }
        if (!TextUtils.isEmpty(AdSdk.getSGMVersionName())) {
            sb.append("&SGM=");
            sb.append(AdSdk.getSGMVersionName());
        }
        if (!TextUtils.isEmpty(AdSdk.getHWVersionName())) {
            sb.append("&HW=");
            sb.append(AdSdk.getHWVersionName());
        }
        return sb.toString();
    }

    public static String j(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "-1";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "1";
            }
            if (activeNetworkInfo.getType() != 0) {
                return activeNetworkInfo.getType() == 9 ? "7" : "-1";
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    return "4";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    return "3";
                case 13:
                case 19:
                    return "2";
                case 18:
                default:
                    return (activeNetworkInfo.getSubtypeName().equalsIgnoreCase("WCDMA") || activeNetworkInfo.getSubtypeName().equalsIgnoreCase("CDMA2000")) ? "3" : "-1";
                case 20:
                    return "6";
            }
        } catch (Throwable th) {
            th.printStackTrace();
            return "-1";
        }
    }

    public static DisplayMetrics l(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return displayMetrics;
    }

    public static boolean m() {
        try {
            if (n() || a()) {
                return true;
            }
            int i2 = 0;
            while (true) {
                try {
                    String[] strArr = K;
                    if (i2 >= strArr.length) {
                        break;
                    }
                    if (new File(strArr[i2]).exists()) {
                        return true;
                    }
                    i2++;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return false;
    }

    public static String n(Context context) {
        try {
            String string = AdSdk.getSharedPreferences().getString(com.alipay.sdk.cons.b.b, null);
            h = string;
            if (string == null) {
                String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                h = defaultUserAgent;
                if (defaultUserAgent != null) {
                    AdSdk.getSharedPreferences().edit().putString(com.alipay.sdk.cons.b.b, h).apply();
                }
            }
        } catch (Throwable unused) {
        }
        return h;
    }

    public static int o(Context context) {
        try {
            String wxAppid = AdSdk.adConfig().getWxAppid();
            if (TextUtils.isEmpty(wxAppid)) {
                return -1;
            }
            Class<?> cls = Class.forName("com.tencent.mm.opensdk.openapi.BaseWXApiImplV10");
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(Context.class, String.class, Boolean.TYPE, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((Integer) cls.getDeclaredMethod("getWXAppSupportAPI", new Class[0]).invoke(declaredConstructor.newInstance(context, wxAppid, Boolean.TRUE, 2), new Object[0])).intValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static String f(Context context) {
        Boolean boolA;
        try {
            if (g == null && (boolA = com.meishu.sdk.platform.ms.splash.k.a(context)) != null) {
                g = boolA.booleanValue() ? "1" : "0";
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return g;
    }

    public static String k(Context context) {
        String lowerCase;
        if (j == null) {
            try {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
                if (signatureArr.length > 0) {
                    try {
                        lowerCase = l1.a(MessageDigest.getInstance("SHA1").digest(((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getEncoded())).toLowerCase();
                    } catch (NoSuchAlgorithmException e2) {
                        e2.printStackTrace();
                        lowerCase = null;
                    }
                    j = lowerCase;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return j;
    }

    public static Integer e(Context context) {
        try {
            return Integer.valueOf(((BatteryManager) context.getSystemService("batterymanager")).getIntProperty(4));
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String g(Context context) {
        if (p == null) {
            try {
                if (Intent.parseUri("hap://app/", 0).resolveActivity(context.getPackageManager()) != null) {
                    p = "1";
                } else {
                    p = "";
                }
            } catch (Throwable unused) {
            }
        }
        return p;
    }

    /* JADX INFO: compiled from: RequestUtil.java */
    public class a extends com.meishu.sdk.core.safe.l {
        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (line.contains("Hardware")) {
                        String str = line.split(com.huawei.openalliance.ad.constant.x.bQ)[1];
                        x0.v = str;
                        if (!TextUtils.isEmpty(str)) {
                            x0.v = x0.v.trim();
                        }
                    }
                }
                bufferedReader.close();
                if (TextUtils.isEmpty(x0.v)) {
                    return;
                }
                q.a().b("device_cpuname", x0.v);
            } catch (Throwable unused) {
            }
        }
    }

    public static String d(Context context) {
        if (q == null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(c(context), 0);
                if (packageInfo != null) {
                    q = String.valueOf(packageInfo.versionCode);
                }
            } catch (Throwable unused) {
                q = null;
            }
        }
        return q;
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(b)) {
            try {
                b = ((Object) context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).loadLabel(context.getPackageManager())) + "";
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return b;
    }

    public static void e() {
        if (TextUtils.isEmpty(u)) {
            try {
                Configuration configuration = new Configuration();
                Class<?> cls = Class.forName("android.app.ActivityManagerNative");
                Object objInvoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
                configuration.updateFrom((Configuration) objInvoke.getClass().getMethod("getConfiguration", new Class[0]).invoke(objInvoke, new Object[0]));
                u = configuration.fontScale + "";
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:33:0x007e A[Catch: all -> 0x00f4, Exception -> 0x00fc, TRY_LEAVE, TryCatch #14 {Exception -> 0x00fc, all -> 0x00f4, blocks: (B:31:0x0074, B:33:0x007e), top: B:102:0x0074 }] */
    /* JADX WARN: Code duplicated, block: B:36:0x0085  */
    /* JADX WARN: Code duplicated, block: B:39:0x008c A[Catch: Exception -> 0x00c7, all -> 0x00ea, TryCatch #3 {all -> 0x00ea, blocks: (B:37:0x0086, B:39:0x008c, B:40:0x008e, B:42:0x0094, B:43:0x0096, B:45:0x009c, B:46:0x009e, B:48:0x00a4, B:49:0x00a6, B:51:0x00ac, B:52:0x00ae, B:54:0x00b4, B:55:0x00b6, B:57:0x00bc, B:58:0x00be, B:63:0x00ca), top: B:88:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0094 A[Catch: Exception -> 0x00c7, all -> 0x00ea, TryCatch #3 {all -> 0x00ea, blocks: (B:37:0x0086, B:39:0x008c, B:40:0x008e, B:42:0x0094, B:43:0x0096, B:45:0x009c, B:46:0x009e, B:48:0x00a4, B:49:0x00a6, B:51:0x00ac, B:52:0x00ae, B:54:0x00b4, B:55:0x00b6, B:57:0x00bc, B:58:0x00be, B:63:0x00ca), top: B:88:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x009c A[Catch: Exception -> 0x00c7, all -> 0x00ea, TryCatch #3 {all -> 0x00ea, blocks: (B:37:0x0086, B:39:0x008c, B:40:0x008e, B:42:0x0094, B:43:0x0096, B:45:0x009c, B:46:0x009e, B:48:0x00a4, B:49:0x00a6, B:51:0x00ac, B:52:0x00ae, B:54:0x00b4, B:55:0x00b6, B:57:0x00bc, B:58:0x00be, B:63:0x00ca), top: B:88:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00a4 A[Catch: Exception -> 0x00c7, all -> 0x00ea, TryCatch #3 {all -> 0x00ea, blocks: (B:37:0x0086, B:39:0x008c, B:40:0x008e, B:42:0x0094, B:43:0x0096, B:45:0x009c, B:46:0x009e, B:48:0x00a4, B:49:0x00a6, B:51:0x00ac, B:52:0x00ae, B:54:0x00b4, B:55:0x00b6, B:57:0x00bc, B:58:0x00be, B:63:0x00ca), top: B:88:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x00ac A[Catch: Exception -> 0x00c7, all -> 0x00ea, TryCatch #3 {all -> 0x00ea, blocks: (B:37:0x0086, B:39:0x008c, B:40:0x008e, B:42:0x0094, B:43:0x0096, B:45:0x009c, B:46:0x009e, B:48:0x00a4, B:49:0x00a6, B:51:0x00ac, B:52:0x00ae, B:54:0x00b4, B:55:0x00b6, B:57:0x00bc, B:58:0x00be, B:63:0x00ca), top: B:88:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00b4 A[Catch: Exception -> 0x00c7, all -> 0x00ea, TryCatch #3 {all -> 0x00ea, blocks: (B:37:0x0086, B:39:0x008c, B:40:0x008e, B:42:0x0094, B:43:0x0096, B:45:0x009c, B:46:0x009e, B:48:0x00a4, B:49:0x00a6, B:51:0x00ac, B:52:0x00ae, B:54:0x00b4, B:55:0x00b6, B:57:0x00bc, B:58:0x00be, B:63:0x00ca), top: B:88:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00bc A[Catch: Exception -> 0x00c7, all -> 0x00ea, TryCatch #3 {all -> 0x00ea, blocks: (B:37:0x0086, B:39:0x008c, B:40:0x008e, B:42:0x0094, B:43:0x0096, B:45:0x009c, B:46:0x009e, B:48:0x00a4, B:49:0x00a6, B:51:0x00ac, B:52:0x00ae, B:54:0x00b4, B:55:0x00b6, B:57:0x00bc, B:58:0x00be, B:63:0x00ca), top: B:88:0x0086 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c9  */
    public static String f() throws Throwable {
        FileReader fileReader;
        BufferedReader bufferedReader;
        int iIntValue;
        if (k == null) {
            String[] strArr = {"-1", "-1", "-1"};
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    fileReader = new FileReader("/proc/meminfo");
                    try {
                        bufferedReader = new BufferedReader(fileReader, 8192);
                        try {
                            strArr[1] = Integer.toString(Math.round(Integer.valueOf(bufferedReader.readLine().split("\\s+")[1]).intValue() / 1024));
                            if (TextUtils.isEmpty(B.j)) {
                                B.j = strArr[1];
                            }
                            try {
                                bufferedReader.close();
                            } catch (IOException unused) {
                            }
                            fileReader.close();
                        } catch (IOException unused2) {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            int i2 = 0;
                            if (AdSdk.adConfig().isUseMediation()) {
                                iIntValue = AdSdk.getBDVersionName() == null ? 0 : 1;
                                try {
                                    try {
                                        if (AdSdk.getCSJVersionName() != null) {
                                            iIntValue += 2;
                                        }
                                        if (AdSdk.getGDTVersionName() != null) {
                                            iIntValue += 4;
                                        }
                                        if (AdSdk.getKSVersionName() != null) {
                                            iIntValue += 16;
                                        }
                                        if (AdSdk.getOPPOVersionName() != null) {
                                            iIntValue += 32;
                                        }
                                        if (AdSdk.getMimoVersionName() != null) {
                                            iIntValue += 64;
                                        }
                                        if (AdSdk.getJDVersionName() != null) {
                                            iIntValue += 128;
                                        }
                                        if (AdSdk.getSGMVersionName() != null) {
                                            iIntValue += 1024;
                                        }
                                        if (AdSdk.getHWVersionName() != null) {
                                            iIntValue += 4096;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        i2 = iIntValue;
                                        strArr[2] = Integer.toString(i2);
                                        throw th;
                                    }
                                } catch (Exception unused4) {
                                    i2 = iIntValue;
                                    strArr[2] = Integer.toString(i2);
                                }
                            } else {
                                iIntValue = 0;
                            }
                            try {
                                iIntValue += (((Integer) Class.forName("com.meishu.sdk.core.LiveAdSdk").getMethod("getLoadedPlatforms", new Class[0]).invoke(null, new Object[0])).intValue() & 255) << 16;
                            } catch (Exception unused5) {
                            }
                            strArr[2] = Integer.toString(iIntValue);
                            k = TextUtils.join("|", strArr);
                            return k;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            if (bufferedReader2 != null) {
                                try {
                                    bufferedReader2.close();
                                } catch (IOException unused6) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                    throw th;
                                } catch (IOException unused7) {
                                    throw th;
                                }
                            }
                            throw th;
                        }
                    } catch (IOException unused8) {
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } catch (IOException unused9) {
                }
            } catch (IOException unused10) {
                fileReader = null;
                bufferedReader = null;
            } catch (Throwable th4) {
                th = th4;
                fileReader = null;
            }
            int i3 = 0;
            try {
                if (AdSdk.adConfig().isUseMediation()) {
                    if (AdSdk.getBDVersionName() == null) {
                    }
                    if (AdSdk.getCSJVersionName() != null) {
                        iIntValue += 2;
                    }
                    if (AdSdk.getGDTVersionName() != null) {
                        iIntValue += 4;
                    }
                    if (AdSdk.getKSVersionName() != null) {
                        iIntValue += 16;
                    }
                    if (AdSdk.getOPPOVersionName() != null) {
                        iIntValue += 32;
                    }
                    if (AdSdk.getMimoVersionName() != null) {
                        iIntValue += 64;
                    }
                    if (AdSdk.getJDVersionName() != null) {
                        iIntValue += 128;
                    }
                    if (AdSdk.getSGMVersionName() != null) {
                        iIntValue += 1024;
                    }
                    if (AdSdk.getHWVersionName() != null) {
                        iIntValue += 4096;
                    }
                } else {
                    iIntValue = 0;
                }
                iIntValue += (((Integer) Class.forName("com.meishu.sdk.core.LiveAdSdk").getMethod("getLoadedPlatforms", new Class[0]).invoke(null, new Object[0])).intValue() & 255) << 16;
                strArr[2] = Integer.toString(iIntValue);
            } catch (Exception unused11) {
            } catch (Throwable th5) {
                th = th5;
            }
            k = TextUtils.join("|", strArr);
        }
        return k;
    }

    public static boolean n() {
        String str = Build.FINGERPRINT;
        if (!str.startsWith("generic") && !str.toLowerCase().contains("vbox") && !str.toLowerCase().contains("test-keys")) {
            String str2 = Build.MODEL;
            if (!str2.contains("google_sdk") && !str2.contains("Emulator") && !str2.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && ((!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) && !"google_sdk".equals(Build.PRODUCT))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0058  */
    public static String g() {
        try {
            if (l == null) {
                switch (Build.MANUFACTURER.toLowerCase()) {
                    case "smartisan":
                        l = a("getprop ro.smartisan.version");
                        break;
                    case "huawei":
                    case "xiaomi":
                        l = a("getprop ro.build.version.incremental");
                        break;
                    case "lemobile":
                        l = a("getprop ro.letv.release.version");
                        break;
                    case "vivo":
                        l = a("getprop ro.vivo.product.version");
                        break;
                    case "oppo":
                        l = a("getprop ro.build.version.ota");
                        break;
                    case "meizu":
                        l = a("getprop ro.build.display.id");
                        break;
                    default:
                        l = a("getprop ro.build.version.release");
                        break;
                }
                if (TextUtils.isEmpty(l)) {
                    l = AdSdk.getSharedPreferences().getString("romVersion", null);
                } else {
                    AdSdk.getSharedPreferences().edit().putString("romVersion", l).apply();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return l;
    }

    public static void d() {
        if (TextUtils.isEmpty(v)) {
            String strA = q.a().a("device_cpuname", (String) null);
            v = strA;
            if (TextUtils.isEmpty(strA)) {
                ExecutorService executorService = g0.f4905a;
                g0.b.f4906a.a(new a());
            }
        }
    }

    public static boolean o() {
        try {
            return (AdSdk.adConfig() == null || AdSdk.adConfig().customController() == null || AdSdk.adConfig().customController().isStorageCollectEnable()) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String b() {
        if (AdSdk.adConfig().isEnableBootId() && TextUtils.isEmpty(y)) {
            try {
                char[] cArr = new char[36];
                if (36 == new FileReader("/proc/sys/kernel/random/boot_id").read(cArr)) {
                    y = String.valueOf(cArr);
                }
            } catch (Exception unused) {
            }
        }
        return y;
    }

    public static int m(Context context) {
        int i2 = I;
        if (i2 >= 0) {
            return i2;
        }
        if (context == null) {
            try {
                context = AdSdk.getContext();
            } catch (Throwable unused) {
                return I;
            }
        }
        int identifier = StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            I = StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDimensionPixelSize(identifier);
        }
        return I;
    }

    public static String h() {
        if (o == null) {
            o = a("getprop ro.vendor.build.date.utc");
        }
        return o;
    }

    public static boolean l() {
        Boolean bool = J;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean boolValueOf = Boolean.valueOf(NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted());
            J = boolValueOf;
            return boolValueOf.booleanValue();
        } catch (Throwable th) {
            th.printStackTrace();
            Boolean bool2 = Boolean.TRUE;
            J = bool2;
            return bool2.booleanValue();
        }
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00b2  */
    public static String k() {
        BufferedReader bufferedReader;
        String strTrim;
        if (TextUtils.isEmpty(w)) {
            try {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat /data/data").getInputStream()));
                    while (true) {
                        try {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                strTrim = null;
                                break;
                            }
                            if (line.startsWith("Modify:")) {
                                strTrim = line.substring(8).trim();
                                break;
                            }
                        } catch (Throwable th) {
                            th = th;
                            try {
                                th.printStackTrace();
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                } else {
                                    if (w == null) {
                                        w = AdSdk.getSharedPreferences().getString("update_time", null);
                                    }
                                    if (!TextUtils.isEmpty(w)) {
                                        x = w.substring(0, 17);
                                    }
                                }
                                return w;
                            } catch (Throwable th2) {
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Throwable th3) {
                                        th3.printStackTrace();
                                    }
                                }
                                throw th2;
                            }
                        }
                    }
                    if (strTrim != null) {
                        String[] strArrSplit = strTrim.split("\\.");
                        w = (new SimpleDateFormat(TimeUtils.FORMATDATETIME, Locale.getDefault()).parse(strArrSplit[0]).getTime() / 1000) + "." + (strArrSplit.length > 1 ? strArrSplit[1].split(PPSLabelView.Code)[0] : "0");
                        AdSdk.getSharedPreferences().edit().putString("update_time", w).apply();
                    }
                    bufferedReader.close();
                } catch (Throwable th4) {
                    th4.printStackTrace();
                }
            } catch (Throwable th5) {
                th = th5;
                bufferedReader = null;
            }
            if (w == null) {
                w = AdSdk.getSharedPreferences().getString("update_time", null);
            }
            try {
                if (!TextUtils.isEmpty(w) && w.length() >= 17) {
                    x = w.substring(0, 17);
                }
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
        }
        return w;
    }

    public static String i(Context context) {
        if (TextUtils.isEmpty(d)) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                try {
                    String simOperator = telephonyManager.getSimOperator();
                    d = simOperator;
                    if (TextUtils.isEmpty(simOperator)) {
                        try {
                            String networkOperator = telephonyManager.getNetworkOperator();
                            d = networkOperator;
                            if (TextUtils.isEmpty(networkOperator)) {
                                d = "";
                            }
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception unused2) {
                }
                if (!TextUtils.isEmpty(d)) {
                    return d.length() > 5 ? d.substring(0, 5) : d;
                }
            } catch (Exception unused3) {
            }
        }
        return d;
    }

    public static void j() {
        try {
            if (!TextUtils.isEmpty(s) || o()) {
                return;
            }
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            File externalFilesDir = AdSdk.getContext().getExternalFilesDir(null);
            if (externalFilesDir != null) {
                s = decimalFormat.format(externalFilesDir.getTotalSpace() / 1048576);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String c() {
        try {
            return String.valueOf((System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void a(Context context, AdType adType) {
        long j2;
        try {
            ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
            try {
                PackageManager packageManager = StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager();
                if (TextUtils.isEmpty(f4955a)) {
                    f4955a = context.getPackageName();
                }
                j2 = packageManager.getPackageInfo(f4955a, 0).lastUpdateTime;
            } catch (Throwable th) {
                th.printStackTrace();
                j2 = 0;
            }
            if (j2 > 0) {
                concurrentHashMap.put("dtc_app_cvit", String.valueOf(j2));
            }
            try {
                if (AdSdk.adConfig().enableDebug()) {
                    concurrentHashMap.put("dtc_sdk_debug", "1");
                } else {
                    concurrentHashMap.put("dtc_sdk_debug", "0");
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            try {
                try {
                    String property = System.getProperty("http.proxyHost");
                    String property2 = System.getProperty("http.proxyPort");
                    if (property2 == null) {
                        property2 = "-1";
                    }
                    int i2 = Integer.parseInt(property2);
                    if (!TextUtils.isEmpty(property) && i2 != -1) {
                        concurrentHashMap.put("dtc_net_proxy", "1");
                    } else {
                        concurrentHashMap.put("dtc_net_proxy", "0");
                    }
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            } catch (Throwable th4) {
                th4.printStackTrace();
            }
            try {
                if (Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) == 1) {
                    concurrentHashMap.put("dtc_console", "1");
                } else {
                    concurrentHashMap.put("dtc_console", "0");
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
            try {
                concurrentHashMap.put("dtc_app_debug", "0");
            } catch (Throwable th6) {
                th6.printStackTrace();
            }
            try {
                if (m()) {
                    concurrentHashMap.put("dtc_emulator", "1");
                } else {
                    concurrentHashMap.put("dtc_emulator", "0");
                }
            } catch (Throwable th7) {
                th7.printStackTrace();
            }
            if (adType == AdType.FEED_MIX || adType == AdType.FEED_PRE_RENDER) {
                c cVar = c.a.f4888a;
                if (cVar.a(context) != null) {
                    concurrentHashMap.put("fel_mtime", cVar.a(context).getMtime() + "");
                }
            }
            if (TextUtils.isEmpty(z)) {
                String string = AdSdk.getSharedPreferences().getString("install_time", "");
                z = string;
                if (!TextUtils.isEmpty(string)) {
                    B.getClass();
                }
            }
            int iO = o(context);
            if (iO != -1) {
                if (TextUtils.isEmpty(B.f4944a)) {
                    B.f4944a = String.valueOf(iO);
                }
                concurrentHashMap.put("wxapi", String.valueOf(iO));
            }
            concurrentHashMap.put("install_time", z);
            if (AdSdk.adConfig().isUseMediation()) {
                String strI = i();
                if (!TextUtils.isEmpty(strI)) {
                    concurrentHashMap.put("third_party_sdk", strI);
                }
            }
            if (TextUtils.isEmpty(f4955a)) {
                f4955a = context.getPackageName();
            }
            if (!TextUtils.isEmpty(f4955a)) {
                concurrentHashMap.put(com.hihonor.adsdk.base.g.j.e.a.hnadsn, f4955a);
            }
            g(context);
            if (!TextUtils.isEmpty(p)) {
                if (TextUtils.isEmpty(B.b)) {
                    B.b = p;
                }
                concurrentHashMap.put("h5_app_type", p);
            }
            b(context);
            if (!TextUtils.isEmpty(b)) {
                concurrentHashMap.put("app_name", b);
            }
            String wxVersionName = AdSdk.getWxVersionName();
            C = wxVersionName;
            if (!TextUtils.isEmpty(wxVersionName)) {
                concurrentHashMap.put("wx_sdk_name", C);
            }
            if (c == null) {
                try {
                    c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                } catch (Throwable th8) {
                    th8.printStackTrace();
                }
            }
            if (!TextUtils.isEmpty(c)) {
                concurrentHashMap.put("app_ver", c);
            }
            d(context);
            if (!TextUtils.isEmpty(q)) {
                if (TextUtils.isEmpty(B.d)) {
                    B.d = q;
                }
                concurrentHashMap.put("device_appstore_ver", q);
            }
            if (AdSdk.adConfig().customController() != null) {
                if (AdSdk.adConfig().customController().getAndroidId() != null) {
                    e = AdSdk.adConfig().customController().getAndroidId();
                } else if (AdSdk.adConfig().customController().isCanUseAndroidId()) {
                    a(context);
                }
            } else {
                a(context);
            }
            if (!TextUtils.isEmpty(e)) {
                if (TextUtils.isEmpty(B.e)) {
                    B.e = e;
                }
                concurrentHashMap.put("device_adid", e);
            }
            if (!TextUtils.isEmpty(AdSdk.adConfig().userId())) {
                concurrentHashMap.put(PtgRewardConstant.REWARD_PARAMS.USER_ID, AdSdk.adConfig().userId());
            }
            if (AdSdk.adConfig().customController() == null || AdSdk.adConfig().customController().isCanUseImsi()) {
                d = i(context);
            }
            if (!TextUtils.isEmpty(d)) {
                if (TextUtils.isEmpty(B.f)) {
                    B.f = d;
                }
                concurrentHashMap.put("device_imsi", d);
            }
            h(context);
            if (!TextUtils.isEmpty(r)) {
                if (TextUtils.isEmpty(B.g)) {
                    B.g = r;
                }
                concurrentHashMap.put("device_hmscore", r);
            }
            if (f == null) {
                try {
                    f = context.getResources().getDisplayMetrics();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            DisplayMetrics displayMetrics = f;
            if (displayMetrics != null) {
                concurrentHashMap.put("device_x_width", String.valueOf(displayMetrics.widthPixels));
                concurrentHashMap.put("device_x_height", String.valueOf(f.heightPixels));
            }
            DisplayMetrics displayMetricsL = l(context);
            concurrentHashMap.put("device_ppi", String.valueOf(displayMetricsL.densityDpi));
            concurrentHashMap.put("device_width", String.valueOf(displayMetricsL.widthPixels));
            concurrentHashMap.put("device_height", String.valueOf(displayMetricsL.heightPixels));
            concurrentHashMap.put("device_density", String.valueOf(displayMetricsL.density));
            f(context);
            if (!TextUtils.isEmpty(g)) {
                concurrentHashMap.put(am.ai, g);
            }
            if (TextUtils.isEmpty(h)) {
                n(context);
            }
            if (!TextUtils.isEmpty(h)) {
                if (TextUtils.isEmpty(B.h)) {
                    B.h = h;
                }
                concurrentHashMap.put("device_ua", h);
            }
            k(context);
            if (!TextUtils.isEmpty(j)) {
                if (TextUtils.isEmpty(B.i)) {
                    B.i = j;
                }
                concurrentHashMap.put(am.p, j);
            }
            f();
            if (!TextUtils.isEmpty(k)) {
                concurrentHashMap.put("device_performance", k);
            }
            g();
            if (!TextUtils.isEmpty(l)) {
                if (TextUtils.isEmpty(B.k)) {
                    B.k = l;
                }
                concurrentHashMap.put("device_rom_version", l);
            }
            t1.a();
            if (!TextUtils.isEmpty(n)) {
                concurrentHashMap.put("device_rom_version_vivo", n);
            }
            h();
            if (!TextUtils.isEmpty(o)) {
                if (TextUtils.isEmpty(B.l)) {
                    B.l = o;
                }
                concurrentHashMap.put("device_syscmp_time", o);
            }
            j();
            if (!TextUtils.isEmpty(s)) {
                if (TextUtils.isEmpty(B.m)) {
                    B.m = s;
                }
                concurrentHashMap.put("device_disk_total", s);
            }
            d();
            if (!TextUtils.isEmpty(v)) {
                if (TextUtils.isEmpty(B.o)) {
                    B.o = v;
                }
                concurrentHashMap.put("device_cpu_model", v);
            }
            k();
            if (!TextUtils.isEmpty(w)) {
                if (TextUtils.isEmpty(B.p)) {
                    B.p = w;
                }
                concurrentHashMap.put("device_update_mark", w);
            }
            if (!Build.MANUFACTURER.equalsIgnoreCase(MediationConstant.ADN_XIAOMI)) {
                b();
                if (!TextUtils.isEmpty(y)) {
                    if (TextUtils.isEmpty(B.q)) {
                        B.q = y;
                    }
                    concurrentHashMap.put("device_boot_mark", y);
                }
            }
            String strC = c();
            if (!TextUtils.isEmpty(strC)) {
                concurrentHashMap.put("device_boot_time", strC);
            }
            if (!TextUtils.isEmpty(x)) {
                concurrentHashMap.put("device_sys_update", x);
            }
            PckIdBean pckIdBean = q0.b;
            if (pckIdBean != null) {
                String app_y = pckIdBean.getApp_y();
                String app_n = pckIdBean.getApp_n();
                if (!TextUtils.isEmpty(app_y)) {
                    if (app_y.startsWith(".")) {
                        app_y = app_y.substring(1);
                    }
                    concurrentHashMap.put("app_y", app_y);
                }
                if (!TextUtils.isEmpty(app_n)) {
                    if (app_n.startsWith(".")) {
                        app_n = app_n.substring(1);
                    }
                    concurrentHashMap.put("app_n", app_n);
                }
            }
            D = concurrentHashMap;
            q.a().b("cache_params", new Gson().toJson(concurrentHashMap));
        } catch (Throwable th9) {
            th9.printStackTrace();
        }
    }

    public static void a(Map<String, String> map, Context context) {
        try {
            Constructor declaredConstructor = GPSUtils.class.getDeclaredConstructor(Context.class);
            declaredConstructor.setAccessible(true);
            double[] dArr = (double[]) GPSUtils.class.getMethod("getL", new Class[0]).invoke(declaredConstructor.newInstance(context), new Object[0]);
            if (dArr != null) {
                double d2 = dArr[0];
                double d3 = dArr[1];
                if (d2 <= 0.0d || d3 <= 0.0d) {
                    return;
                }
                map.put("device_geo_lat", String.valueOf(d2));
                map.put("device_geo_lon", String.valueOf(d3));
            }
        } catch (Throwable unused) {
        }
    }

    public static synchronized String a(Context context) {
        if (TextUtils.isEmpty(e) && !G) {
            G = true;
            e = Settings.System.getString(context.getContentResolver(), "android_id");
        }
        return e;
    }

    public static String a(String str) {
        try {
            byte[] bArr = new byte[1024];
            return new String(bArr, 0, Runtime.getRuntime().exec(str).getInputStream().read(bArr), "utf-8").trim();
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean a() {
        String str;
        if (TextUtils.isEmpty(A)) {
            String strA = q.a().a("cpuInfo", (String) null);
            A = strA;
            if (TextUtils.isEmpty(strA)) {
                ExecutorService executorService = g0.f4905a;
                g0.b.f4906a.a(new y0());
                str = A;
            } else {
                str = A;
            }
        } else {
            str = A;
        }
        return str == null || TextUtils.isEmpty(str) || str.contains("intel") || str.contains("amd");
    }
}
