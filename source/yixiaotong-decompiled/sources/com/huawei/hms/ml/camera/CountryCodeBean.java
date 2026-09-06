package com.huawei.hms.ml.camera;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.stub.StubApp;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class CountryCodeBean {
    public static final String ANDRIOD_SYSTEMPROP = "android.os.SystemProperties";
    public static final int COUNTRYCODE_SIZE = 2;
    public static final String HONOR_VENDORCOUNTRY_SYSTEMPROP = "msc.sys.country";
    public static final String LOCALE_COUNTRYSYSTEMPROP = "ro.product.locale.region";
    public static final String LOCALE_INFO = "LOCALE_INFO";
    public static final String NETWORK_COUNTRY = "NETWORK_COUNTRY";
    public static final String SIM_COUNTRY = "SIM_COUNTRY";
    public static final String SPECIAL_COUNTRYCODE_CN = "cn";
    public static final String SPECIAL_COUNTRYCODE_EU = "eu";
    public static final String SPECIAL_COUNTRYCODE_LA = "la";
    public static final String TAG = "CountryCodeBean";
    public static final String UNKNOWN = "UNKNOWN";
    public static final String VENDORCOUNTRY_SYSTEMPROP = "ro.hw.country";
    public static final String VENDOR_COUNTRY = "VENDOR_COUNTRY";
    public String countryCode;
    public String countrySource = "UNKNOWN";

    public CountryCodeBean(Context context, boolean z) {
        this.countryCode = "UNKNOWN";
        init(context, z);
        this.countryCode = this.countryCode.toUpperCase(Locale.ENGLISH);
    }

    private void checkCodeLenth() {
        String str = this.countryCode;
        if (str == null || str.length() != 2) {
            this.countryCode = "UNKNOWN";
            this.countrySource = "UNKNOWN";
        }
    }

    private void getLocaleCountryCode() {
        this.countryCode = getProperty("get", LOCALE_COUNTRYSYSTEMPROP, ANDRIOD_SYSTEMPROP, "UNKNOWN");
        this.countrySource = "LOCALE_INFO";
        String str = TAG;
        Log.d(str, "getLocaleCountryCode=" + this.countryCode);
        if (SPECIAL_COUNTRYCODE_CN.equalsIgnoreCase(this.countryCode)) {
            return;
        }
        Log.e(str, "getLocaleCountryCode from system language is not reliable.");
        this.countryCode = "UNKNOWN";
        this.countrySource = "UNKNOWN";
    }

    public static String getProperty(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            Log.w(TAG, "reflect class for method has exception.");
            return str4;
        }
        try {
            Class<?> cls = Class.forName(str3);
            return (String) cls.getMethod(str, String.class, String.class).invoke(cls, str2, str4);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException(e.getMessage());
        } catch (Exception e2) {
            Log.e(TAG, "getProperty catch exception: ", e2);
            return str4;
        }
    }

    private void getSimCountryCode(Context context, boolean z) {
        TelephonyManager telephonyManager = (TelephonyManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("phone");
        if (telephonyManager != null) {
            if (!z || telephonyManager.getPhoneType() == 2) {
                this.countryCode = telephonyManager.getSimCountryIso();
                this.countrySource = "SIM_COUNTRY";
                Log.e(TAG, "getSimCountryCode by not enableNetwork, countryCode=" + this.countryCode);
            } else {
                this.countryCode = telephonyManager.getNetworkCountryIso();
                this.countrySource = "NETWORK_COUNTRY";
                Log.e(TAG, "getSimCountryCode by enableNetwork, countryCode=" + this.countryCode);
            }
        }
        checkCodeLenth();
    }

    private void init(Context context, boolean z) {
        if (context == null) {
            throw new NullPointerException("context must be not null.Please provide app's Context");
        }
        try {
            getVendorCountryCode();
            if (isCodeValidate()) {
                Log.d(TAG, "getCountryCode get country code from {%s}VENDOR_COUNTRY");
                return;
            }
            getSimCountryCode(context, z);
            if (isCodeValidate()) {
                Log.d(TAG, "getCountryCode get country code from {%s}SIM_COUNTRY");
                return;
            }
            getLocaleCountryCode();
            if (isCodeValidate()) {
                Log.d(TAG, "getCountryCode get country code from {%s}LOCALE_INFO");
            }
        } catch (Exception unused) {
            Log.w(TAG, "get CountryCode error");
        }
    }

    private boolean isCodeValidate() {
        return !"UNKNOWN".equals(this.countryCode);
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getCountrySource() {
        return this.countrySource;
    }

    private void getVendorCountryCode() {
        this.countrySource = "VENDOR_COUNTRY";
        if (Build.BRAND.equals("HONOR")) {
            this.countryCode = getProperty("get", "msc.sys.country", ANDRIOD_SYSTEMPROP, "UNKNOWN");
        } else {
            this.countryCode = getProperty("get", "ro.hw.country", ANDRIOD_SYSTEMPROP, "UNKNOWN");
        }
        String str = TAG;
        Log.e(str, "getVendorCountry=" + this.countryCode);
        if (!SPECIAL_COUNTRYCODE_EU.equalsIgnoreCase(this.countryCode) && !SPECIAL_COUNTRYCODE_LA.equalsIgnoreCase(this.countryCode)) {
            checkCodeLenth();
            return;
        }
        Log.e(str, "getVendorCountry equals eu or la ,not reliable");
        this.countryCode = "UNKNOWN";
        this.countrySource = "UNKNOWN";
    }
}
