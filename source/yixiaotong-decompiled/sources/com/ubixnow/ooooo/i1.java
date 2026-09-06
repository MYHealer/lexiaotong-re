package com.ubixnow.ooooo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.huawei.hms.ml.camera.CountryCodeBean;
import com.stub.StubApp;
import com.ubixnow.core.api.UbixDefaultConstants;
import com.ubixnow.utils.BaseUtils;
import com.unionpay.tsmservice.data.Constant;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class i1 {
    public static String OooO = "";
    private static String OooO00o = "----ParamsUtils";
    private static Context OooO0O0 = null;
    public static i1 OooO0OO = null;
    public static final String OooO0Oo = "";
    public static String OooO0o = "";
    public static final String OooO0o0 = "UNKNOWN";
    public static String OooO0oO = "";
    public static int OooO0oo = 0;
    public static float OooOO0 = 0.0f;
    public static String OooOO0O = null;
    public static int OooOO0o = 0;
    public static int OooOOO = 0;
    public static String OooOOO0 = "";
    public static int OooOOOO = 0;
    public static int OooOOOo = 0;
    public static long OooOOo = 0;
    public static long OooOOo0 = 0;
    public static boolean OooOOoo = false;
    private static final String OooOo = "device_info";
    public static boolean OooOo0 = false;
    public static boolean OooOo00 = false;
    public static String OooOo0O = "";
    public static String OooOo0o = "";
    private static String OooOoO = "";
    public static boolean OooOoO0;

    public class OooO00o implements i {
        @Override // com.ubixnow.ooooo.i
        public void OooO00o(String str) {
            if (TextUtils.isEmpty(str) || str.startsWith(Constant.DEFAULT_CVN2)) {
                return;
            }
            oOo00o00.OooO00o("oaid", str);
            oOo00o00.OooO00o(oOo00o00.OooO0Oo, System.currentTimeMillis());
            i1.OooO0o = str;
            if (ooooO000.OooO00o) {
                ooooO000.OooO0O0(i1.OooO00o, "oaid:" + str);
            }
        }

        @Override // com.ubixnow.ooooo.i
        public void OooO00o(Throwable th) {
            i1.OooO0o = "";
            if (ooooO000.OooO00o) {
                ooooO000.OooO0O0(i1.OooO00o, "--------oaid get oaid error: " + th.toString());
            }
        }
    }

    public static int OooO() {
        try {
            DisplayMetrics displayMetrics = StubApp.getOrigApplicationContext(OooO0O0.getApplicationContext()).getResources().getDisplayMetrics();
            return displayMetrics.widthPixels > displayMetrics.heightPixels ? 2 : 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static String OooO00o(String str, String str2) {
        try {
            Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
            String str3 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            return !TextUtils.isEmpty(str3) ? str3 : str2;
        } catch (Throwable unused) {
        }
    }

    public static String OooO00o(boolean z) {
        try {
            if (!TextUtils.isEmpty(OooO0oO)) {
                return OooO0oO;
            }
            String str = TextUtils.isEmpty(j1.OooOOO) ? "" : j1.OooOOO;
            OooO0oO = str;
            if (TextUtils.isEmpty(str) && !OooOoO0) {
                String strOooO0o0 = oOo00o00.OooO0o0("aid");
                if (TextUtils.isEmpty(strOooO0o0)) {
                    if (z && j1.OooO0OO) {
                        synchronized (i1.class) {
                            ooooO000.OooO0O0(OooO00o, "获取Android Id");
                            String string = Settings.Secure.getString(OooO0O0.getContentResolver(), "android_id");
                            OooO0oO = string;
                            oOo00o00.OooO00o("aid", string);
                            oOo00o00.OooO00o(oOo00o00.OooO0o0, System.currentTimeMillis());
                        }
                    }
                    return OooO0oO;
                }
                if (System.currentTimeMillis() - oOo00o00.OooO0Oo(oOo00o00.OooO0o0) < 604800000) {
                    OooO0oO = strOooO0o0;
                    return strOooO0o0;
                }
                if (!z) {
                    return strOooO0o0;
                }
                if (!j1.OooO0OO) {
                    OooO0oO = strOooO0o0;
                    return strOooO0o0;
                }
                synchronized (i1.class) {
                    ooooO000.OooO0O0(OooO00o, "获取Android Id");
                    String string2 = Settings.Secure.getString(OooO0O0.getContentResolver(), "android_id");
                    OooO0oO = string2;
                    oOo00o00.OooO00o("aid", string2);
                    oOo00o00.OooO00o(oOo00o00.OooO0o0, System.currentTimeMillis());
                }
                if (TextUtils.isEmpty(OooO0oO)) {
                    OooO0oO = "";
                    OooOoO0 = true;
                }
            }
            return OooO0oO;
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            OooOoO0 = true;
        }
        return OooO0oO;
    }

    public static void OooO00o(Context context) {
        OooO0O0 = context;
        oOo0o0oO.OooO00o();
        OooOo0O = o0O0ooO.OooO00o;
        OooOo0o = o00O0000.OooO0O0;
        OooOOo();
        OooO0o0();
        OooOOO0();
        OooO0Oo();
        OooO0OO();
        OooOO0o();
    }

    private static void OooO00o(String str) {
        try {
            String str2 = OooOOO0;
            if (str2 != "0") {
                if (str2 == "0" || str2 == "") {
                    Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                    String str3 = (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
                    if (!TextUtils.isEmpty(str3)) {
                        OooOOO0 = str3;
                    } else {
                        OooOOO0 = "0";
                        OooOOO0 = "0";
                    }
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String OooO0O0() {
        try {
            PackageManager packageManager = OooO0O0.getPackageManager();
            return packageManager.getApplicationInfo(OooO0O0.getPackageName(), 128).loadLabel(packageManager).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String OooO0O0(boolean z) {
        try {
            if (!TextUtils.isEmpty(OooO0o)) {
                return OooO0o;
            }
            String str = TextUtils.isEmpty(j1.OooOOOO) ? "" : j1.OooOOOO;
            OooO0o = str;
            if (!TextUtils.isEmpty(str)) {
                return OooO0o;
            }
            String strOooO0o0 = oOo00o00.OooO0o0("oaid");
            if (TextUtils.isEmpty(strOooO0o0)) {
                if (z && j1.OooO0Oo && System.currentTimeMillis() - OooOOo0 >= UbixDefaultConstants.adParamsReloadTime) {
                    OooOOo0 = System.currentTimeMillis();
                    synchronized (i1.class) {
                        OooO0O0(OooO0o);
                    }
                }
                return OooO0o;
            }
            if (System.currentTimeMillis() - oOo00o00.OooO0Oo(oOo00o00.OooO0Oo) < 604800000) {
                OooO0o = strOooO0o0;
                return strOooO0o0;
            }
            if (!z) {
                return strOooO0o0;
            }
            if (!j1.OooO0Oo) {
                OooO0o = strOooO0o0;
                return strOooO0o0;
            }
            if (System.currentTimeMillis() - OooOOo0 < UbixDefaultConstants.adParamsReloadTime) {
                OooO0o = strOooO0o0;
                return strOooO0o0;
            }
            OooOOo0 = System.currentTimeMillis();
            synchronized (i1.class) {
                OooO0O0(strOooO0o0);
            }
            if (TextUtils.isEmpty(OooO0o) || OooO0o.startsWith(Constant.DEFAULT_CVN2)) {
                OooO0o = "";
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
        return OooO0o;
    }

    public static void OooO0O0(String str) {
        if ("".equals(OooO0o)) {
            ooooO000.OooO0O0("---调用系统方法获取：", "oaid");
            if (OooO0o.length() == 0) {
                OooO0o = str;
                h.OooO00o(OooO0O0, new OooO00o());
            }
        }
    }

    public static String OooO0OO() {
        try {
            SharedPreferences sharedPreferences = OooO0O0.getSharedPreferences(OooOo, 0);
            String string = sharedPreferences.getString(oOo00o00.OooO0o, null);
            OooOO0O = string;
            if (!TextUtils.isEmpty(string)) {
                return OooOO0O;
            }
            String strOooO0o0 = oOo00o00.OooO0o0(oOo00o00.OooO0o);
            OooOO0O = strOooO0o0;
            if (!TextUtils.isEmpty(strOooO0o0)) {
                return OooOO0O;
            }
            String str = "o." + OooO0O0(false);
            OooOO0O = str;
            if (str.length() < 3) {
                OooOO0O = "a." + OooO00o(false);
            }
            if (OooOO0O.length() < 7) {
                OooOO0O = "u." + UUID.randomUUID().toString().replace(com.huawei.openalliance.ad.constant.x.A, "");
            }
            sharedPreferences.edit().putString(oOo00o00.OooO0o, OooOO0O).apply();
            oOo00o00.OooO00o(oOo00o00.OooO0o, OooOO0O);
            return OooOO0O;
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public static float OooO0Oo() {
        try {
            if (OooOo0) {
                return OooOO0;
            }
            OooOo0 = true;
            WindowManager windowManager = (WindowManager) OooO0O0.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
            float f = displayMetrics.densityDpi;
            OooOO0 = f;
            return f;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static String OooO0o() {
        try {
            if (TextUtils.isEmpty(OooOoO)) {
                OooOoO = BaseUtils.getExternalDir().getParentFile().lastModified() + "";
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return OooOoO;
    }

    public static String OooO0o0() {
        OooO00o("hw_sc.build.platform.version");
        return (OooOOo() != 3 || TextUtils.isEmpty(OooOOO0) || OooOOO0.equals("0")) ? "" : OooOOO0;
    }

    public static i1 OooO0oO() {
        if (OooO0OO == null) {
            synchronized (i1.class) {
                if (OooO0OO == null) {
                    OooO0OO = new i1();
                }
            }
        }
        return OooO0OO;
    }

    public static int OooO0oo() {
        try {
            if (System.currentTimeMillis() - OooOOo < 5000) {
                return OooOOOo;
            }
            OooOOo = System.currentTimeMillis();
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) OooO0O0.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type != 1) {
                        OooOOOo = 0;
                        return 0;
                    }
                    OooOOOo = 1;
                    return 1;
                }
                int subtype = activeNetworkInfo.getSubtype();
                String subtypeName = activeNetworkInfo.getSubtypeName();
                if (subtype == 20) {
                    OooOOOo = 5;
                    return 5;
                }
                switch (subtype) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        OooOOOo = 2;
                        return 2;
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
                        OooOOOo = 3;
                        return 3;
                    case 13:
                        OooOOOo = 4;
                        return 4;
                    default:
                        if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                            return OooOOOo;
                        }
                        OooOOOo = 3;
                        return 3;
                }
            }
            OooOOOo = 0;
            return 0;
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return 0;
        }
    }

    public static PackageInfo OooOO0() {
        Context context = OooO0O0;
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageManager().getPackageInfo(OooO0O0.getPackageName(), 0);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static int OooOO0O() {
        try {
            if (OooOOoo) {
                return OooO0oo;
            }
            OooOOoo = true;
            if ((OooO0O0.getResources().getConfiguration().screenLayout & 15) >= 3) {
                OooO0oo = 2;
            } else {
                OooO0oo = 1;
            }
            return OooO0oo;
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            OooO0oo = 0;
        }
    }

    public static void OooOO0o() {
        if (OooOOO != 0) {
            return;
        }
        try {
            WindowManager windowManager = (WindowManager) BaseUtils.getContext().getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            OooOOO = displayMetrics.widthPixels;
            OooOOOO = displayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int OooOOO() {
        try {
            WindowManager windowManager = (WindowManager) BaseUtils.getContext().getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            OooOOO = displayMetrics.heightPixels;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return OooOOO;
    }

    public static String OooOOO0() {
        try {
            if (OooOo00) {
                return OooO;
            }
            OooOo00 = true;
            DisplayMetrics displayMetrics = OooO0O0.getResources().getDisplayMetrics();
            int[] iArr = {displayMetrics.widthPixels, displayMetrics.heightPixels};
            String str = iArr[0] + "x" + iArr[1];
            OooO = str;
            return str;
        } catch (Exception unused) {
            return "0x0";
        }
    }

    public static int OooOOOO() {
        try {
            String strOooO00o = OooO00o("gsm.sim.state", "");
            if (TextUtils.isEmpty(strOooO00o)) {
                return 0;
            }
            return strOooO00o.toUpperCase().contains("LOADED") ? 2 : 1;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int OooOOOo() {
        try {
            String strOooO00o = OooO00o("sys.usb.config", "");
            if (TextUtils.isEmpty(strOooO00o)) {
                return 0;
            }
            return strOooO00o.contains("adb") ? 2 : 1;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static int OooOOo() {
        try {
            int i = OooOO0o;
            if (i != 0) {
                return i;
            }
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            if ("harmony".equalsIgnoreCase(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString())) {
                OooOO0o = 3;
                return 3;
            }
        } catch (Throwable unused) {
        }
        OooOO0o = 1;
        return 1;
    }

    public static String OooOOo0() {
        return OooOO0() == null ? "" : OooOO0().versionName;
    }

    public static void OooOOoo() {
        OooO00o(true);
        OooO0O0(true);
    }
}
