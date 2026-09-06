package com.huawei.openalliance.ad.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hms.ads.cp;
import com.huawei.hms.ads.fh;
import com.stub.StubApp;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class n {
    private static final String B = "ro.product.locale.region";
    private static final String C = "ro.product.locale";
    public static final String Code = "ro.hw.country";
    private static final String D = "la";
    private static final String F = "eu";
    public static final String I = "CN";
    private static final String L = "uk";
    private static final String S = "UNKNOWN";
    public static final String V = "msc.sys.country";
    private static final String Z = "CountryCodeBean";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4478a = "gb";
    private static final String b = "cn";
    private static final int c = 2;
    private String d;

    public n(Context context) {
        this.d = "UNKNOWN";
        Code(context);
        this.d = this.d.toUpperCase(Locale.ENGLISH);
    }

    private void B(Context context) {
        int iLastIndexOf;
        String strCode = bg.Code("ro.product.locale.region");
        this.d = strCode;
        if (TextUtils.isEmpty(strCode)) {
            String strCode2 = bg.Code(C);
            if (!TextUtils.isEmpty(strCode2) && (iLastIndexOf = strCode2.lastIndexOf(com.huawei.openalliance.ad.constant.x.A)) != -1) {
                this.d = strCode2.substring(iLastIndexOf + 1);
            }
        }
        if ("cn".equalsIgnoreCase(this.d)) {
            return;
        }
        this.d = "UNKNOWN";
    }

    private void Code(Context context) {
        if (context == null) {
            return;
        }
        try {
            V(context);
            if (V()) {
                fh.V(Z, "get issue_country code from VENDOR_COUNTRY");
                return;
            }
            I(context);
            if (V()) {
                fh.V(Z, "get issue_country code from SIM_COUNTRY");
                return;
            }
            if (q.B(context)) {
                fh.V(Z, "pad skip locale get issue_country code from grs ip");
                return;
            }
            Z(context);
            if (V()) {
                fh.V(Z, "get issue_country code from LOCALE_INFO");
            }
        } catch (Throwable unused) {
            fh.I(Z, "get CountryCode error");
        }
    }

    private void Code(Context context, boolean z) {
        TelephonyManager telephonyManager = (TelephonyManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("phone");
        if (telephonyManager != null) {
            this.d = (!z || telephonyManager.getPhoneType() == 2) ? telephonyManager.getSimCountryIso() : telephonyManager.getNetworkCountryIso();
        }
        I();
    }

    private void I() {
        String str = this.d;
        if (str == null || str.length() != 2) {
            this.d = "UNKNOWN";
        }
    }

    private void I(Context context) {
        Code(context, false);
    }

    private void V(Context context) {
        String str;
        this.d = bg.Code(cp.Z(context) ? "msc.sys.country" : "ro.hw.country");
        if ("eu".equalsIgnoreCase(this.d) || "la".equalsIgnoreCase(this.d)) {
            str = "UNKNOWN";
        } else {
            if (!L.equalsIgnoreCase(this.d)) {
                I();
                return;
            }
            str = "gb";
        }
        this.d = str;
    }

    private boolean V() {
        return !"UNKNOWN".equals(this.d);
    }

    private void Z() {
        String country = Locale.getDefault().getCountry();
        this.d = country;
        if (TextUtils.isEmpty(country)) {
            this.d = "UNKNOWN";
        }
    }

    private void Z(Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            Z();
        } else {
            B(context);
        }
    }

    public String Code() {
        if (fh.Code()) {
            fh.Code(Z, "countryCode: %s", this.d);
        }
        return this.d;
    }
}
