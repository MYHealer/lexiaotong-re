package com.huawei.hms.scankit.p;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.util.SparseArray;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.stub.StubApp;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: HaLog.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
abstract class e3 {
    static String d = "FORMAT_UNKNOWN";
    static String e = "OTHER";
    static SparseArray<String> f = new a();
    static SparseArray<String> g = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f4237a;
    LinkedHashMap<String, String> b = new LinkedHashMap<>();
    volatile long c;

    /* JADX INFO: compiled from: HaLog.java */
    class a extends SparseArray<String> {
        a() {
            put(HmsScanBase.AZTEC_SCAN_TYPE, "AZTEC");
            put(HmsScanBase.CODABAR_SCAN_TYPE, "CODABAR");
            put(HmsScanBase.CODE39_SCAN_TYPE, "CODE39");
            put(HmsScanBase.CODE93_SCAN_TYPE, "CODE93");
            put(HmsScanBase.CODE128_SCAN_TYPE, "CODE128");
            put(HmsScanBase.DATAMATRIX_SCAN_TYPE, "DATAMATRIX");
            put(HmsScanBase.EAN8_SCAN_TYPE, "EAN8");
            put(HmsScanBase.EAN13_SCAN_TYPE, "EAN13");
            put(HmsScanBase.ITF14_SCAN_TYPE, "ITF14");
            put(HmsScanBase.PDF417_SCAN_TYPE, "PDF417");
            put(HmsScanBase.QRCODE_SCAN_TYPE, "QRCODE");
            put(HmsScanBase.UPCCODE_A_SCAN_TYPE, "UPCCODE_A");
            put(HmsScanBase.UPCCODE_E_SCAN_TYPE, "UPCCODE_E");
            put(HmsScanBase.FORMAT_UNKNOWN, e3.d);
        }
    }

    /* JADX INFO: compiled from: HaLog.java */
    class b extends SparseArray<String> {
        b() {
            put(HmsScan.ARTICLE_NUMBER_FORM, "ARTICLE_NUMBER");
            put(HmsScan.EMAIL_CONTENT_FORM, "EMAIL_CONTENT");
            put(HmsScan.TEL_PHONE_NUMBER_FORM, "TEL_PHONE_NUMBER");
            put(HmsScan.PURE_TEXT_FORM, "PURE_TEXT");
            put(HmsScan.SMS_FORM, "SMS");
            put(HmsScan.URL_FORM, "URL");
            put(HmsScan.WIFI_CONNECT_INFO_FORM, "WIFI_CONNECT_INFO");
            put(HmsScan.EVENT_INFO_FORM, "EVENT_INFO");
            put(HmsScan.CONTACT_DETAIL_FORM, "CONTACT_DETAIL");
            put(HmsScan.DRIVER_INFO_FORM, "DRIVER_INFO");
            put(HmsScan.LOCATION_COORDINATE_FORM, "LOCATION_COORDINATE");
            put(HmsScan.ISBN_NUMBER_FORM, "ISBN_NUMBER");
            put(-1, e3.e);
        }
    }

    e3(Bundle bundle, Context context) {
        this.f4237a = context;
        b(bundle);
    }

    private String b() {
        return "full";
    }

    private void b(Bundle bundle) {
        try {
            String packageName = this.f4237a.getPackageName();
            this.b.put("package", packageName);
            if (bundle == null || !bundle.containsKey("appid")) {
                this.b.put("appid", packageName);
            } else {
                this.b.put("appid", bundle.getString("appid"));
            }
            PackageManager packageManager = this.f4237a.getPackageManager();
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName, 128);
            this.b.put("appName", applicationInfo.loadLabel(packageManager).toString());
            this.b.put("version", a(applicationInfo.metaData));
            String strD = d();
            this.b.put("hmscoreVersion", strD);
            this.b.put("isHMSCore", "unknown".equals(strD) ? "0" : "1");
        } catch (PackageManager.NameNotFoundException unused) {
            x3.b("HaLog", "PackageManager.NameNotFoundException");
        } catch (Exception unused2) {
            x3.b("HaLog", "initValue Exception");
        }
        try {
            this.b.put("sdkName", "scankit");
            this.b.put("algopt", b());
            this.b.put("isFullSdk", "FULLSDK");
            this.b.put(WiseOpenHianalyticsData.UNION_APP_VERSION, c());
            if (k3.f4293a) {
                this.b.put("apkVersion", k3.b);
            } else {
                this.b.put("apkVersion", "unknown");
            }
            this.b.put("service", "com.huawei.hms.scankit");
            this.b.put("operator", k3.b(this.f4237a));
            this.b.put("networkType", k3.a(this.f4237a));
            this.b.put("countryCode", k3.a(this.f4237a, false));
            this.b.put("deviceType", k3.c());
            this.b.put("emuiVersion", k3.d());
            this.b.put("androidVersion", k3.a());
            this.b.put("deviceCategory", k3.b());
        } catch (RuntimeException unused3) {
            x3.b("HaLog", "initValue RuntimeException");
        } catch (Exception unused4) {
            x3.b("HaLog", "initValue Exception");
        }
    }

    private String c() {
        try {
            return this.f4237a.getPackageManager().getPackageInfo(this.f4237a.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return "unknown";
        }
    }

    private String d() {
        try {
            return this.f4237a.getPackageManager().getPackageInfo("com.huawei.hwid", 0).versionName;
        } catch (PackageManager.NameNotFoundException | Exception unused) {
            return "unknown";
        }
    }

    private boolean f() {
        return true;
    }

    boolean a() {
        if (y6.b(this.f4237a)) {
            Log.i("HaLog", "allowLog: forbidLog");
            return false;
        }
        try {
            return f() || e() || Settings.Secure.getInt(this.f4237a.getContentResolver(), "hw_app_analytics_state", 0) == 1;
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    void g() {
        String str;
        x3.c("HaLog", "update HiAnalyticsLogUtils.apk_mode " + k3.f4293a + " HiAnalyticsLogUtils.apkVersion " + k3.b);
        if (!k3.f4293a || (str = k3.b) == null) {
            return;
        }
        this.b.put("apkVersion", str);
    }

    private boolean e() {
        try {
            String property = SystemPropUtils.getProperty("get", "ro.hw.country", CountryCodeBean.ANDRIOD_SYSTEMPROP, "UNKNOWN");
            TelephonyManager telephonyManager = (TelephonyManager) StubApp.getOrigApplicationContext(this.f4237a.getApplicationContext()).getSystemService("phone");
            return "CN".equalsIgnoreCase(property) && "CN".equalsIgnoreCase(telephonyManager.getNetworkCountryIso()) && "CN".equalsIgnoreCase(telephonyManager.getSimCountryIso());
        } catch (RuntimeException | Exception unused) {
            return false;
        }
    }

    static String a(int i) {
        return f.get(i, d);
    }

    private String a(Bundle bundle) {
        String[] strArr = {"huawei_module_scankit_sdk_version", "com.huawei.hms.client.service.name:scan", "com.huawei.hms.client.service.name:scanplus", "com.huawei.hms.client.service.name:scankit"};
        if (bundle == null) {
            return "scankit:1.0.2.300";
        }
        for (int i = 0; i < 4; i++) {
            String str = strArr[i];
            if (bundle.getString(str) != null) {
                return bundle.getString(str);
            }
        }
        return "scankit:1.0.2.300";
    }

    static String b(int i) {
        return g.get(i, e);
    }
}
