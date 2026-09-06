package com.meishu.sdk.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.renderscript.RenderScript;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.sdk.api.AdSettings;
import com.byazt.bv.BaseConstants;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.heytap.msp.mobad.api.MobAdManager;
import com.huawei.hms.ads.HwAds;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.kwad.sdk.api.KsAdSDK;
import com.meishu.sdk.core.domain.SdkAdInfo;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.PackageBean;
import com.meishu.sdk.core.utils.e0;
import com.meishu.sdk.core.utils.j;
import com.meishu.sdk.core.utils.j0;
import com.meishu.sdk.core.utils.q;
import com.meishu.sdk.core.utils.q0;
import com.meishu.sdk.core.utils.r;
import com.meishu.sdk.core.utils.t;
import com.meishu.sdk.core.utils.x0;
import com.meishu.sdk.core.utils.z;
import com.qq.e.comm.managers.status.SDKStatus;
import com.sigmob.windad.WindAds;
import com.stub.StubApp;
import com.unionpay.tsmservice.mi.data.Constant;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class AdSdk {
    private static final String TAG = "AdSdk";
    private static MSAdConfig adConfig = null;
    private static Context context = null;
    private static long initSuccTime = 0;
    private static long initTime = 0;
    public static boolean isTestMode = false;
    private static String local_oaid = null;
    private static String oaid = null;
    private static int oaid_errno = -1;

    public class a extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MSAdConfig f4754a;

        public a(MSAdConfig mSAdConfig) {
            this.f4754a = mSAdConfig;
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            z.a("");
            r.a(AdSdk.context, this.f4754a.getAuthority());
            AdSdk.checkCleartextTrafficConfig(this.f4754a.secure());
            try {
                List<InetAddress> listAsList = Arrays.asList(InetAddress.getAllByName("sdk.1rtb.net"));
                synchronized (t.class) {
                    t.f4947a = listAsList;
                }
            } catch (Throwable unused) {
            }
        }
    }

    public class b extends l {

        public class a extends TypeToken<List<PackageBean.DpFlagBean>> {
            public a(b bVar) {
            }
        }

        /* JADX INFO: renamed from: com.meishu.sdk.core.AdSdk$b$b, reason: collision with other inner class name */
        public class C0789b extends TypeToken<List<String>> {
            public C0789b(b bVar) {
            }
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            PackageBean.HappyBean happyBean;
            q.a().a("", "");
            try {
                if (TextUtils.isEmpty(AdSdk.getSharedPreferences().getString("install_time", ""))) {
                    AdSdk.getSharedPreferences().edit().putString("install_time", String.valueOf(System.currentTimeMillis())).apply();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Gson gson = new Gson();
            try {
                q0.e = q.a().a("splshsty", 1);
                String strA = q.a().a("dpflag", "");
                if (!TextUtils.isEmpty(strA)) {
                    q0.f = (List) gson.fromJson(strA, new a(this).getType());
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                String strA2 = q.a().a("black_scheme", "");
                if (!TextUtils.isEmpty(strA2)) {
                    q0.h = AdSdk.getStringIntegerHashMap(strA2);
                }
            } catch (Throwable unused) {
            }
            try {
                String strA3 = q.a().a("happybean", "");
                if (!TextUtils.isEmpty(strA3) && (happyBean = (PackageBean.HappyBean) gson.fromJson(strA3, PackageBean.HappyBean.class)) != null) {
                    q0.j = happyBean;
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            q0.k = q.a().a("dpstay", 2);
            q0.n = Integer.valueOf(q.a().a("field_export", 0));
            q0.o = q.a().a("use_browser", 0);
            q0.q = q.a().a("olp", 0);
            q0.r = q.a().a("syncSave", 0);
            q0.s = q.a().a("due", 0);
            q0.t = q.a().a("noldp", 0);
            q0.g = q.a().a("shakeTimeout", 0L);
            q0.i = q.a().a("verbosity", 0);
            try {
                String strA4 = q.a().a("jbUrlPrefixes", "");
                if (!TextUtils.isEmpty(strA4)) {
                    q0.p = (List) gson.fromJson(strA4, new C0789b(this).getType());
                }
            } catch (Exception e2) {
                LogUtil.dev(AdSdk.TAG, e2);
            }
            RenderScript renderScript = e0.f4899a;
            try {
                e0.f4899a = RenderScript.create(AdSdk.getContext());
            } catch (Throwable th3) {
                th3.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkCleartextTrafficConfig(int i) {
        if (x0.l()) {
            return;
        }
        if (i == 0) {
            String str = TAG;
            LogUtil.e(str, "==================================================");
            LogUtil.e(str, "配置冲突：SDK secure 配置为 SECURE_HTTP，但当前 App 不允许 HTTP 明文流量！");
            LogUtil.e(str, "请在 AndroidManifest.xml 中添加 android:usesCleartextTraffic=\"true\"");
            LogUtil.e(str, "或在 res/xml/network_security_config.xml 中配置允许明文流量");
            LogUtil.e(str, "==================================================");
            return;
        }
        if (i == 2) {
            String str2 = TAG;
            LogUtil.w(str2, "==================================================");
            LogUtil.w(str2, "配置提示：SDK secure 配置为 SECURE_ALL，但当前 App 不允许 HTTP 明文流量！");
            LogUtil.w(str2, "请在 AndroidManifest.xml 中添加 android:usesCleartextTraffic=\"true\"");
            LogUtil.w(str2, "或在 res/xml/network_security_config.xml 中配置允许明文流量");
            LogUtil.w(str2, "==================================================");
        }
    }

    public static IAdManager getAdManager() {
        return new MAdManager();
    }

    public static String getAdmobVersionName() {
        if (adConfig() != null && !adConfig().isUseMediation()) {
            return null;
        }
        try {
            Class.forName("com.google.android.gms.ads.MobileAds").getDeclaredMethod("getVersionString", new Class[0]).setAccessible(true);
            return "21.0.0";
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getBDVersionName() {
        if (adConfig() != null && !adConfig().isUseMediation()) {
            return null;
        }
        try {
            Class.forName("com.baidu.mobads.sdk.api.SplashInteractionListener");
            return AdSettings.getSDKVersion();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getCSJVersionName() {
        if (adConfig() != null && !adConfig().isUseMediation()) {
            return null;
        }
        try {
            Class.forName("com.bytedance.sdk.openadsdk.TTAdConstant");
            return TTAdSdk.getAdManager().getSDKVersion();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Context getContext() {
        return context;
    }

    public static String getDuoMengVersionName() {
        if (adConfig() != null && !adConfig().isUseMediation()) {
            return null;
        }
        try {
            Method declaredMethod = Class.forName("com.domob.sdk.l.b").getDeclaredMethod("getSdkVersion", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke(null, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getGDTVersionName() {
        if (adConfig() != null && !adConfig().isUseMediation()) {
            return null;
        }
        try {
            Class.forName("com.qq.e.comm.managers.GDTAdSdk");
            return SDKStatus.getIntegrationSDKVersion();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getHWVersionName() {
        if (adConfig() != null && !adConfig().isUseMediation()) {
            return null;
        }
        try {
            if ("huawei".equalsIgnoreCase(Build.MANUFACTURER)) {
                Class.forName("com.huawei.hms.ads.HwAds");
                return HwAds.getSDKVersion();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static long getInitSuccTime() {
        return initSuccTime;
    }

    public static long getInitTime() {
        return initTime;
    }

    public static String getJDVersionName() {
        if (adConfig() != null && !adConfig().isUseMediation()) {
            return null;
        }
        try {
            return JADYunSdk.getSDKVersion();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getKSVersionName() {
        if (adConfig() != null && !adConfig().isUseMediation()) {
            return null;
        }
        try {
            Class.forName("com.kwad.sdk.api.KsAdSDK");
            return KsAdSDK.getSDKVersion();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String getLocalOaid() {
        String str = j.f4912a;
        local_oaid = str;
        if ((TextUtils.isEmpty(str) || "unknown".equals(local_oaid)) && adConfig() != null && adConfig().customController() != null) {
            local_oaid = adConfig().customController().getOaid();
        }
        String str2 = local_oaid;
        if (TextUtils.isEmpty(str2) || str2.toLowerCase().startsWith("support:")) {
            return null;
        }
        return local_oaid;
    }

    public static String getMimoVersionName() {
        if (adConfig() != null && !adConfig().isUseMediation()) {
            return null;
        }
        try {
            if (Constant.DEVICE_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER)) {
                Class.forName("com.miui.zeus.mimo.sdk.BuildConfig");
                return "5.1.7";
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String getOPPOVersionName() {
        if (adConfig() != null && !adConfig().isUseMediation()) {
            return null;
        }
        try {
            if (BaseConstants.ROM_OPPO_UPPER_CONSTANT.equalsIgnoreCase(Build.MANUFACTURER)) {
                Class.forName("com.heytap.msp.mobad.api.MobAdManager");
                return MobAdManager.getInstance().getSdkVerName();
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String getOaid() {
        String str = j.f4912a;
        oaid = str;
        if (TextUtils.isEmpty(str) && adConfig() != null && adConfig().customController() != null) {
            oaid = adConfig().customController().getOaid();
        }
        String str2 = oaid;
        if (TextUtils.isEmpty(str2) || str2.toLowerCase().startsWith("support:")) {
            return null;
        }
        return oaid;
    }

    public static int getOaid_errno() {
        return oaid_errno;
    }

    public static String getPangleVersionName() {
        if (adConfig() != null && !adConfig().isUseMediation()) {
            return null;
        }
        try {
            Class.forName("com.bytedance.sdk.openadsdk.api.init.PAGSdk");
            return PAGSdk.getSDKVersion();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getSGMVersionName() {
        if (adConfig() != null && !adConfig().isUseMediation()) {
            return null;
        }
        try {
            Class.forName("com.sigmob.windad.WindAds");
            return WindAds.getVersion();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static SharedPreferences getSharedPreferences() {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getSharedPreferences(LogUtil.TAG, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashMap<String, Integer> getStringIntegerHashMap(String str) throws JSONException {
        HashMap<String, Integer> map = new HashMap<>();
        JSONObject jSONObject = new JSONObject(str.toString());
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, (Integer) jSONObject.get(next));
        }
        return map;
    }

    public static String getVersionName() {
        return "2.5.13.3";
    }

    public static String getWxVersionName() {
        try {
            return "" + getContext().getPackageManager().getApplicationInfo("com.tencent.mm", 128).metaData.getInt("com.tencent.mm.BuildInfo.OPEN_SDK_VERSION", 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void initOtherSdks() {
        if (adConfig() == null || !adConfig().isUseMediation() || adConfig().getInitSdkMap() == null) {
            return;
        }
        for (Map.Entry<String, Object> entry : adConfig().getInitSdkMap().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof String) {
                String str = (String) value;
                if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(str)) {
                    key.getClass();
                    key.hashCode();
                    switch (key) {
                        case "KS":
                            com.meishu.sdk.core.a.a("KS").config().init(context, str, "");
                            break;
                        case "CSJ":
                            com.meishu.sdk.core.a.a(MSAdConfig.PLATFORM_CSJ).config().init(context, str, "");
                            break;
                        case "GDT":
                            com.meishu.sdk.core.a.a(MSAdConfig.PLATFORM_GDT).config().init(context, str, "");
                            break;
                        case "BAIDU":
                            com.meishu.sdk.core.a.a(MSAdConfig.PLATFORM_BD).config().init(context, str, "");
                            break;
                    }
                }
            } else if (value instanceof Map) {
                try {
                    if (((Boolean) ((Map) value).get("isUseMediation")).booleanValue()) {
                        j0.b = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void initSdkIfNot(Context context2, SdkAdInfo sdkAdInfo) {
        e eVarA = com.meishu.sdk.core.a.a(sdkAdInfo.getSdk());
        if (eVarA != null) {
            eVarA.config().init(context2, sdkAdInfo.getApp_id(), sdkAdInfo.getApp_key());
        }
    }

    private static void setInstallTime() {
        new Thread(new b()).start();
    }

    public static void setOaid_errno(int i) {
        oaid_errno = i;
    }

    public static MSAdConfig adConfig() {
        if (adConfig == null) {
            Log.e(LogUtil.TAG, "adConfig is null ,check sdk init");
        }
        return adConfig;
    }

    public static void init(Context context2, MSAdConfig mSAdConfig) {
        try {
            if (adConfig != null) {
                return;
            }
            if (mSAdConfig != null) {
                initTime = System.currentTimeMillis();
                context = StubApp.getOrigApplicationContext(context2.getApplicationContext());
                new Thread(new a(mSAdConfig)).start();
                adConfig = mSAdConfig;
                setInstallTime();
                initSuccTime = System.currentTimeMillis();
                return;
            }
            throw new IllegalArgumentException("config is null");
        } catch (Exception e) {
            adConfig = null;
            e.printStackTrace();
            LogUtil.e(TAG, "SDK INIT ERROR");
        }
    }
}
