package com.yfanads.android.model;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.Os;
import android.system.StructStat;
import android.system.StructTimespec;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.adx.BuildConfig;
import com.yfanads.android.core.f;
import com.yfanads.android.libs.utils.DeviceUtils;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.oaid.ifs.a;
import com.yfanads.android.oaid.ifs.b;
import com.yfanads.android.oaid.impl.m;
import com.yfanads.android.oaid.utils.RomUtils;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.ReflectionUtils;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFAdsPhone {
    public static final int NETWORK_TYPE_NR = 5;
    public static final int SDK_VERSION_Q = 29;
    private long activationTime;
    private String androidId;
    public String apiLevel;
    public String bootMark;
    public String brand;
    public String county;
    private int curChannel;
    public float density;
    public int densityDPI;
    public int devHeight;
    public int devWidth;
    private String imei;
    private String imsi;
    public boolean isTablet;
    public String language;
    public String model;
    private boolean needFilterJD;
    public String os;
    private int simStatus;
    public String sysOpenTime;
    public String updateMark;

    public static final class YFAdsPhoneHold {
        private static final YFAdsPhone INSTANCE = new YFAdsPhone();

        private YFAdsPhoneHold() {
        }
    }

    private boolean canSimStatus() {
        try {
            YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
            if (yFAdsConfig != null) {
                Map<String, Object> extDefine = yFAdsConfig.getExtDefine();
                if (!YFListUtils.isMapEmpty(extDefine)) {
                    try {
                        Object obj = extDefine.get("simStatus");
                        if (obj != null && (obj instanceof Boolean)) {
                            return ((Boolean) obj).booleanValue();
                        }
                    } catch (Exception e) {
                        YFLog.error("canSimStatus: " + e.getMessage());
                    }
                }
            }
        } catch (Exception e2) {
            f.a(e2, new StringBuilder("getSimStatus error"));
        }
        return true;
    }

    private String getBootMark() {
        return "";
    }

    public static YFAdsPhone getInstance() {
        return YFAdsPhoneHold.INSTANCE;
    }

    private int getSimCardStatus(Context context) {
        try {
            SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
            return (subscriptionManager.getActiveSubscriptionInfoList() == null || subscriptionManager.getActiveSubscriptionInfoList().isEmpty()) ? 1 : 2;
        } catch (Exception e) {
            f.a(e, new StringBuilder("getSimStatus error"));
            return 0;
        }
    }

    private void initAppInfo(Application application) {
        YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
        PackageManager packageManager = application.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(application.getPackageName(), 0);
            yFAdsConfig.setAppPackage(packageInfo.packageName);
            yFAdsConfig.setAppVer(packageInfo.versionName);
            YFLog.high("packageName " + application.getPackageName() + "|" + yFAdsConfig.getAppPackage() + " , versionName " + yFAdsConfig.getAppVer());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(yFAdsConfig.getAppPackage())) {
            yFAdsConfig.setAppPackage(application.getPackageName());
        }
        try {
            yFAdsConfig.setAppName(packageManager.getApplicationInfo(application.getPackageName(), 0).loadLabel(packageManager).toString());
            YFLog.high("appName " + yFAdsConfig.getAppName());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void initBaseInfo() {
        try {
            String strTrim = Build.BRAND.trim();
            if (!TextUtils.isEmpty(strTrim)) {
                strTrim = strTrim.toLowerCase();
            }
            this.brand = strTrim;
            this.model = Build.MODEL.trim();
            this.apiLevel = String.valueOf(Build.VERSION.SDK_INT);
            this.os = String.valueOf(Build.VERSION.RELEASE);
            this.sysOpenTime = String.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime());
            this.bootMark = getBootMark();
            this.updateMark = getUpdateMark();
            if (RomUtils.isHonor()) {
                this.curChannel = 13;
            } else if (RomUtils.isOHuawei() || RomUtils.isEmui()) {
                this.curChannel = 6;
            } else if (RomUtils.isXiaomi() || RomUtils.isMiui() || RomUtils.isBlackShark()) {
                this.curChannel = 7;
            } else if (RomUtils.isOppo() || RomUtils.isOnePlus()) {
                this.curChannel = 8;
            } else if (RomUtils.isVivo()) {
                this.curChannel = 10;
            } else {
                this.curChannel = -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        YFLog.high("this phone type is " + this.curChannel);
    }

    private void initBusInfo(Context context) {
        readJDInfo(context);
    }

    private void initDeviceId(final Context context, String str) {
        try {
            YFLog.high("devOaid " + str);
            DeviceUtils.getDeviceId(context);
            if (DeviceUtils.hasOaID()) {
                YFLog.high("has oaid, return. " + DeviceUtils.getCacheOAID());
                return;
            }
            if (!m.a(context).a()) {
                YFLog.error("initDeviceId is not support oaid, return. ");
                return;
            }
            a aVar = new a() { // from class: com.yfanads.android.model.YFAdsPhone.1
                @Override // com.yfanads.android.oaid.ifs.a
                public void onOAIDGetFail(Exception exc) {
                    YFLog.error("getOAID error " + (exc != null ? exc.getMessage() : ""));
                }

                @Override // com.yfanads.android.oaid.ifs.a
                public void onOAIDGetSuccess(String str2) {
                    if (DeviceUtils.isRealOAID(str2)) {
                        DeviceUtils.setOaID(context, str2);
                    }
                    YFLog.high("init oaid success " + str2);
                }
            };
            b bVarA = m.a(context);
            YFLog.debug("OAID implements class: ".concat(bVarA.getClass().getName()));
            bVarA.a(aVar);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initLanguage(Resources resources) {
        try {
            Locale locale = resources.getConfiguration().locale;
            this.county = locale != null ? locale.getCountry() : "CN";
            this.language = locale != null ? locale.getLanguage() : "zh";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initSize(Context context, DisplayMetrics displayMetrics) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            this.devWidth = point.x;
            this.devHeight = point.y;
            this.density = displayMetrics.density;
            this.densityDPI = displayMetrics.densityDpi;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initTablet(DisplayMetrics displayMetrics) {
        try {
            this.isTablet = Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 9.0d;
            YFLog.high("initTablet " + this.isTablet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initUA(final Context context) {
        Util.EXECUTOR.submit(new Runnable() { // from class: com.yfanads.android.model.YFAdsPhone$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DeviceUtils.initWua(context, new DeviceUtils.OnUAResult() { // from class: com.yfanads.android.model.YFAdsPhone$$ExternalSyntheticLambda1
                    @Override // com.yfanads.android.libs.utils.DeviceUtils.OnUAResult
                    public final void hasUAResult() {
                        YFLog.debug("initWua success ");
                    }
                });
            }
        });
    }

    private boolean isCanLoadHW(int i) {
        return this.curChannel == 13 && i == 6;
    }

    private boolean isServiceStateFiveGAvailable(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED"));
    }

    private void readJDInfo(Context context) {
        try {
            if (InitUtils.canQueryJdPackage()) {
                this.needFilterJD = context.getPackageManager().getPackageInfo("com.jingdong.app.mall", 0) == null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.needFilterJD = true;
        }
        YFLog.debug("readJDInfo needFilterJD:" + this.needFilterJD);
    }

    public long getActivationTime() {
        return this.activationTime;
    }

    public String getAndroidId(Context context) {
        if (!TextUtils.isEmpty(this.androidId)) {
            return this.androidId;
        }
        String string = Settings.System.getString(context.getContentResolver(), "android_id");
        this.androidId = string;
        return string == null ? "" : string;
    }

    public String getDeviceId() {
        YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
        if (!TextUtils.isEmpty(yFAdsConfig.getDevOaid())) {
            return yFAdsConfig.getDevOaid();
        }
        if (TextUtils.isEmpty(yFAdsConfig.getDevImei())) {
            return TextUtils.isEmpty(DeviceUtils.getCacheOAID()) ? DeviceUtils.getClientId() : DeviceUtils.getCacheOAID();
        }
        return yFAdsConfig.getDevImei();
    }

    public String[] getDeviceIds() {
        YFAdsConfig yFAdsConfig = YFAdsManager.getInstance().getYFAdsConfig();
        if (!TextUtils.isEmpty(yFAdsConfig.getDevOaid())) {
            return new String[]{yFAdsConfig.getDevOaid(), yFAdsConfig.getDevOaid()};
        }
        if (TextUtils.isEmpty(yFAdsConfig.getDevImei())) {
            return TextUtils.isEmpty(DeviceUtils.getCacheOAID()) ? new String[]{DeviceUtils.getClientId(), ""} : new String[]{DeviceUtils.getCacheOAID(), ""};
        }
        return new String[]{yFAdsConfig.getDevImei(), ""};
    }

    public String getImei(Context context) {
        if (!YFUtil.checkSelfPermission(context, "android.permission.READ_PHONE_STATE", 0)) {
            return "";
        }
        if (TextUtils.isEmpty(this.imei)) {
            this.imei = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        }
        String str = this.imei;
        return str == null ? "" : str;
    }

    public String getImsi(Context context) {
        if (!YFUtil.checkSelfPermission(context, "android.permission.READ_PHONE_STATE", 0)) {
            return "";
        }
        if (TextUtils.isEmpty(this.imsi)) {
            this.imsi = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
        }
        String str = this.imsi;
        return str == null ? "" : str;
    }

    public int getPhoneType() {
        return this.curChannel;
    }

    public String getSDKVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public float getTemplateScale(Context context, boolean z, int i) {
        if (isTablet()) {
            return (!isTabSplitScreen(context) || z) ? 2.0f : 1.0f;
        }
        if (isPhoneSplitScreen(context, i) && isScreenPortrait(i) && z) {
            return ScreenUtil.getWindowHeight(context) / ScreenUtil.getScreenWidth(context);
        }
        return 1.0f;
    }

    public void init(Application application, String str) {
        long j;
        YFLog.debug("PhoneService init start");
        try {
            com.yfanads.android.db.f.a(application);
            initDeviceId(application, str);
            initAppInfo(application);
            Resources resources = application.getResources();
            initLanguage(resources);
            if (resources != null) {
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                initSize(application, displayMetrics);
                initTablet(displayMetrics);
            }
            initBaseInfo();
            initBusInfo(application);
            AtomicLong atomicLong = com.yfanads.android.db.f.f9646a;
            if (atomicLong.get() > 0) {
                j = atomicLong.get();
            } else {
                atomicLong.set(application.getSharedPreferences(DeviceUtils.SP_NAME, 0).getLong("init_time_long", 0L));
                j = atomicLong.get();
            }
            this.activationTime = j;
            initUA(application);
        } catch (Exception e) {
            e.printStackTrace();
        }
        YFLog.debug("PhoneService init end");
    }

    public boolean isLandscape(Context context, int i, float f) {
        return ScreenUtil.isLandscape(context, f);
    }

    public boolean isPhoneSplitScreen(Context context, int i) {
        if (isScreenLand(i)) {
            return ScreenUtil.getWindowWidth(context) < (ScreenUtil.getScreenWidth(context) * 9) / 10;
        }
        return ScreenUtil.getWindowHeight(context) < (ScreenUtil.getScreenHeight(context) * 9) / 10;
    }

    public boolean isScreenLand(int i) {
        return i == 2;
    }

    public boolean isScreenLand(Activity activity) {
        return (activity == null || activity.getResources() == null || activity.getResources().getConfiguration().orientation != 2) ? false : true;
    }

    public boolean isScreenPortrait(int i) {
        return i == 1;
    }

    public boolean isTabSplitScreen(Context context) {
        return ScreenUtil.getWindowWidth(context) < (ScreenUtil.getScreenWidth(context) * 9) / 10 || ScreenUtil.getWindowHeight(context) < (ScreenUtil.getScreenHeight(context) * 9) / 10;
    }

    public boolean isTablet() {
        return this.isTablet;
    }

    public boolean needFilterJD(int i) {
        return i == 9 && this.needFilterJD;
    }

    private YFAdsPhone() {
        this.simStatus = 0;
        this.needFilterJD = false;
    }

    private int getSubId() {
        return SubscriptionManager.getDefaultDataSubscriptionId();
    }

    private String getUpdateMark() {
        try {
            int i = Build.VERSION.SDK_INT;
            StructStat structStatStat = Os.stat("/data/data");
            if (i < 27) {
                return structStatStat.st_atime + ".0";
            }
            StructTimespec structTimespec = structStatStat.st_atim;
            return structTimespec.tv_sec + "." + structTimespec.tv_nsec;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private int adjustNetworkType(Context context, int i) {
        ServiceState serviceState;
        ServiceState serviceState2;
        if (Build.VERSION.SDK_INT < 29) {
            return i;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            int subId = getSubId();
            if (subId == -1) {
                serviceState2 = telephonyManager.getServiceState();
            } else {
                Object objInvokeMethod = ReflectionUtils.invokeMethod(telephonyManager, "android.telephony.TelephonyManager", "getServiceStateForSubscriber", new Class[]{Integer.TYPE}, Integer.valueOf(subId));
                serviceState = objInvokeMethod instanceof ServiceState ? (ServiceState) objInvokeMethod : null;
                if (serviceState == null) {
                    serviceState2 = telephonyManager.getServiceState();
                }
                if (serviceState == null && isServiceStateFiveGAvailable(serviceState.toString())) {
                    return 5;
                }
            }
            serviceState = serviceState2;
            return serviceState == null ? i : i;
        } catch (Exception e) {
            e.printStackTrace();
            return i;
        }
    }

    public int getSimStatus() {
        int i = this.simStatus;
        if (i != 0) {
            return i;
        }
        boolean zCanSimStatus = canSimStatus();
        if (zCanSimStatus && YFUtil.checkSelfPermission(YFAdsManager.getInstance().getContext(), "android.permission.READ_PHONE_STATE", 0)) {
            this.simStatus = getSimCardStatus(YFAdsManager.getInstance().getContext());
        }
        YFLog.high("getSimStatus " + zCanSimStatus + "|" + this.simStatus);
        return this.simStatus;
    }

    public boolean isPhoneType(int i) {
        int i2 = this.curChannel;
        if (i2 == -1) {
            return false;
        }
        return i == i2 || isCanLoadHW(i);
    }
}
