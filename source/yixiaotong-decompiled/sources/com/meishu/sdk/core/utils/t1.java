package com.meishu.sdk.core.utils;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.ml.camera.CountryCodeBean;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: VivoDeviceUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class t1 {
    public static String a() {
        try {
            if (x0.n == null && d()) {
                String strC = c();
                x0.n = strC;
                if (TextUtils.isEmpty(strC)) {
                    x0.n = e1.a("romVersionVivo", null);
                } else {
                    e1.b("romVersionVivo", x0.n);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return x0.n;
    }

    public static String b() {
        String str;
        try {
            String strA = a("ro.vivo.internet.name", "unknown");
            if (!TextUtils.isEmpty(strA) && !"unknown".equals(strA)) {
                return !strA.toLowerCase().contains("vivo") ? "vivo " + strA : strA;
            }
            String strA2 = a("ro.vivo.market.name", "unknown");
            if ("unknown".equals(strA2) || TextUtils.isEmpty(strA2)) {
                str = Build.MODEL;
            } else {
                if (strA2.toLowerCase().contains("vivo")) {
                    return strA2;
                }
                str = "vivo " + strA2;
            }
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c() throws Throwable {
        BufferedReader bufferedReader;
        String line;
        String str = "";
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.vivo.os.name").getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                bufferedReader.close();
                try {
                    bufferedReader.close();
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                line = "";
            } catch (Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            bufferedReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
        StringBuilder sbAppend = sb.append(line);
        try {
            BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.vivo.os.version").getInputStream()), 1024);
            try {
                String line2 = bufferedReader3.readLine();
                bufferedReader3.close();
                try {
                    bufferedReader3.close();
                } catch (Exception unused6) {
                }
                str = line2;
            } catch (Exception unused7) {
                bufferedReader2 = bufferedReader3;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused8) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader2 = bufferedReader3;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (Exception unused9) {
                    }
                }
                throw th;
            }
        } catch (Exception unused10) {
        } catch (Throwable th4) {
            th = th4;
        }
        return sbAppend.append(str).toString();
    }

    public static boolean d() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("bbk") || str.toLowerCase().startsWith("vivo");
    }

    public static String a(String str, String str2) {
        String str3;
        try {
            str3 = (String) Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP).getMethod("get", String.class).invoke(null, str);
        } catch (Throwable th) {
            th.printStackTrace();
            str3 = str2;
        }
        return (str3 == null || str3.length() == 0) ? str2 : str3;
    }
}
