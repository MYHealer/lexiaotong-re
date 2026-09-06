package com.adprof.sdk;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.ml.camera.CountryCodeBean;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class nk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static mk f1327a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f517a = {"EMUI", "huawei"};
    public static final String[] b = {"FuntouchOS", "vivo"};
    public static final String[] c = {"MIUI", MediationConstant.ADN_XIAOMI};
    public static final String[] d = {"ColorOS", "oppo"};
    public static final String[] e = {"EUI", "letv"};
    public static final String[] f = {"360", "qiku"};
    public static final String[] g = {"zte"};
    public static final String[] h = {"oneplus"};
    public static final String[] i = {"NubiaUI", "nubia"};
    public static final String[] j = {"coolpad", "yulong"};
    public static final String[] k = {"lg", "lge"};
    public static final String[] l = {"google"};
    public static final String[] m = {"samsung"};
    public static final String[] n = {"Flyme", "meizu"};
    public static final String[] o = {"lenovo"};
    public static final String[] p = {"SmartisanOS", "deltainno"};
    public static final String[] q = {"Sense", "htc"};
    public static final String[] r = {"sony"};
    public static final String[] s = {"amigo", "gionee"};
    public static final String[] t = {"motorola"};
    public static final String[] u = {"ro.build.version.opporom", "ro.build.version.oplusrom.display"};

    public static mk a() {
        String lowerCase;
        mk mkVar;
        String str;
        mk mkVar2;
        String str2;
        mk mkVar3;
        String str3;
        String lowerCase2 = "unknown";
        mk mkVar4 = f1327a;
        if (mkVar4 != null) {
            return mkVar4;
        }
        f1327a = new mk();
        try {
            String str4 = Build.BRAND;
            lowerCase = !TextUtils.isEmpty(str4) ? str4.toLowerCase() : "unknown";
        } catch (Throwable unused) {
        }
        try {
            String str5 = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str5)) {
                lowerCase2 = str5.toLowerCase();
            }
        } catch (Throwable unused2) {
        }
        if (m697a()) {
            mk mkVar5 = f1327a;
            mkVar5.f1311a = "harmony";
            mkVar5.b = a("hw_sc.build.platform.version");
            mk mkVar6 = f1327a;
            mkVar6.c = com.huawei.openalliance.ad.constant.x.af;
            return mkVar6;
        }
        String[] strArr = f517a;
        if (a(lowerCase, lowerCase2, strArr)) {
            f1327a.f1311a = strArr[0];
            String strA = a("ro.build.version.emui");
            String[] strArrSplit = strA.split("_");
            if (strArrSplit.length > 1) {
                f1327a.b = strArrSplit[1];
            } else {
                f1327a.b = strA;
            }
            mk mkVar7 = f1327a;
            mkVar7.c = com.huawei.openalliance.ad.constant.x.af;
            return mkVar7;
        }
        String[] strArr2 = b;
        if (a(lowerCase, lowerCase2, strArr2)) {
            mk mkVar8 = f1327a;
            mkVar8.f1311a = strArr2[0];
            mkVar8.b = a("ro.vivo.os.build.display.id");
            mk mkVar9 = f1327a;
            mkVar9.c = "com.bbk.appstore";
            return mkVar9;
        }
        String[] strArr3 = c;
        if (a(lowerCase, lowerCase2, strArr3)) {
            mk mkVar10 = f1327a;
            mkVar10.f1311a = strArr3[0];
            mkVar10.b = a("ro.build.version.incremental");
            mk mkVar11 = f1327a;
            mkVar11.c = "com.xiaomi.market";
            return mkVar11;
        }
        String[] strArr4 = d;
        if (a(lowerCase, lowerCase2, strArr4)) {
            f1327a.f1311a = strArr4[0];
            for (String str6 : u) {
                String strA2 = a(str6);
                if (!TextUtils.isEmpty(str6)) {
                    f1327a.b = strA2;
                }
            }
            if (Build.VERSION.SDK_INT < 29) {
                mkVar3 = f1327a;
                str3 = "com.oppo.market";
            } else {
                mkVar3 = f1327a;
                str3 = com.cdo.oaps.ad.af.e;
            }
            mkVar3.c = str3;
            return f1327a;
        }
        String[] strArr5 = e;
        if (a(lowerCase, lowerCase2, strArr5)) {
            mk mkVar12 = f1327a;
            mkVar12.f1311a = strArr5[0];
            mkVar12.b = a("ro.letv.release.version");
            return f1327a;
        }
        String[] strArr6 = f;
        if (a(lowerCase, lowerCase2, strArr6)) {
            mk mkVar13 = f1327a;
            mkVar13.f1311a = strArr6[0];
            mkVar13.b = a("ro.build.uiversion");
            return f1327a;
        }
        String[] strArr7 = g;
        if (a(lowerCase, lowerCase2, strArr7)) {
            mk mkVar14 = f1327a;
            mkVar14.f1311a = strArr7[0];
            mkVar14.b = a("ro.build.MiFavor_version");
            return f1327a;
        }
        String[] strArr8 = h;
        if (a(lowerCase, lowerCase2, strArr8)) {
            mk mkVar15 = f1327a;
            mkVar15.f1311a = strArr8[0];
            mkVar15.b = a("ro.rom.version");
            return f1327a;
        }
        String[] strArr9 = i;
        if (a(lowerCase, lowerCase2, strArr9)) {
            mk mkVar16 = f1327a;
            mkVar16.f1311a = strArr9[0];
            mkVar16.b = a("ro.build.rom.id");
            mk mkVar17 = f1327a;
            mkVar17.c = "cn.nubia.neostore";
            return mkVar17;
        }
        String[] strArr10 = j;
        if (a(lowerCase, lowerCase2, strArr10)) {
            mkVar = f1327a;
            str = strArr10[0];
        } else {
            String[] strArr11 = k;
            if (a(lowerCase, lowerCase2, strArr11)) {
                mkVar = f1327a;
                str = strArr11[0];
            } else {
                String[] strArr12 = l;
                if (a(lowerCase, lowerCase2, strArr12)) {
                    mkVar = f1327a;
                    str = strArr12[0];
                } else {
                    String[] strArr13 = m;
                    if (!a(lowerCase, lowerCase2, strArr13)) {
                        String[] strArr14 = n;
                        if (a(lowerCase, lowerCase2, strArr14)) {
                            mkVar2 = f1327a;
                            mkVar2.f1311a = strArr14[0];
                            str2 = "com.meizu.mstore";
                        } else {
                            String[] strArr15 = o;
                            if (!a(lowerCase, lowerCase2, strArr15)) {
                                String[] strArr16 = p;
                                if (a(lowerCase, lowerCase2, strArr16)) {
                                    mkVar2 = f1327a;
                                    mkVar2.f1311a = strArr16[0];
                                    str2 = "com.smartisanos.appstore";
                                } else {
                                    String[] strArr17 = q;
                                    if (a(lowerCase, lowerCase2, strArr17)) {
                                        mkVar = f1327a;
                                        str = strArr17[0];
                                    } else {
                                        String[] strArr18 = r;
                                        if (a(lowerCase, lowerCase2, strArr18)) {
                                            mkVar = f1327a;
                                            str = strArr18[0];
                                        } else {
                                            String[] strArr19 = s;
                                            if (a(lowerCase, lowerCase2, strArr19)) {
                                                mkVar = f1327a;
                                                str = strArr19[0];
                                            } else {
                                                String[] strArr20 = t;
                                                if (a(lowerCase, lowerCase2, strArr20)) {
                                                    mkVar = f1327a;
                                                    str = strArr20[0];
                                                } else {
                                                    f1327a.f1311a = lowerCase2;
                                                }
                                            }
                                        }
                                    }
                                }
                                f1327a.b = a("");
                                return f1327a;
                            }
                            mkVar = f1327a;
                            str = strArr15[0];
                        }
                        mkVar2.c = str2;
                        f1327a.b = a("");
                        return f1327a;
                    }
                    mkVar = f1327a;
                    str = strArr13[0];
                }
            }
        }
        mkVar.f1311a = str;
        f1327a.b = a("");
        return f1327a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m697a() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Object objInvoke = cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
            if (objInvoke == null) {
                return false;
            }
            return "harmony".equalsIgnoreCase(objInvoke.toString());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(String str, String str2, String... strArr) {
        for (String str3 : strArr) {
            if (str.contains(str3) || str2.contains(str3)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b() {
        return f517a[0].equals(a().f1311a) || m697a();
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0048 A[PHI: r0
  0x0048: PHI (r0v8 java.lang.String) = (r0v1 java.lang.String), (r0v3 java.lang.String), (r0v3 java.lang.String) binds: [B:16:0x0046, B:22:0x006c, B:25:0x0073] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:34:0x00b1 A[Catch: all -> 0x00b5, TRY_LEAVE, TryCatch #2 {all -> 0x00b5, blocks: (B:32:0x00a9, B:34:0x00b1), top: B:48:0x00a9 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00bb A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x00bc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:48:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static String a(String str) {
        BufferedReader bufferedReader;
        String property;
        String str2;
        String lowerCase = "";
        if (!TextUtils.isEmpty(str)) {
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop " + str).getInputStream()), 1024);
                try {
                    property = bufferedReader.readLine();
                    if (property != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused) {
                        }
                    } else {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused2) {
                        }
                        property = "";
                    }
                } catch (Throwable unused3) {
                    if (bufferedReader != null) {
                    }
                    property = "";
                    if (TextUtils.isEmpty(property)) {
                        try {
                            Properties properties = new Properties();
                            properties.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
                            property = properties.getProperty(str, "");
                        } catch (Exception unused4) {
                            property = "";
                        }
                        if (TextUtils.isEmpty(property)) {
                            try {
                                Class<?> cls = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                                lowerCase = (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "");
                            } catch (Exception unused5) {
                            }
                        } else {
                            lowerCase = property;
                        }
                    } else {
                        lowerCase = property;
                    }
                    if (TextUtils.isEmpty(lowerCase)) {
                        str2 = Build.DISPLAY;
                        if (!TextUtils.isEmpty(str2)) {
                            lowerCase = str2.toLowerCase();
                        }
                    } else {
                        try {
                            str2 = Build.DISPLAY;
                            if (!TextUtils.isEmpty(str2)) {
                                lowerCase = str2.toLowerCase();
                            }
                        } catch (Throwable unused6) {
                        }
                    }
                    if (TextUtils.isEmpty(lowerCase)) {
                        return "unknown";
                    }
                    return lowerCase;
                }
            } catch (Throwable unused7) {
                bufferedReader = null;
            }
            if (TextUtils.isEmpty(property)) {
                lowerCase = property;
            } else {
                Properties properties2 = new Properties();
                properties2.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
                property = properties2.getProperty(str, "");
                if (TextUtils.isEmpty(property) && Build.VERSION.SDK_INT < 28) {
                    Class<?> cls2 = Class.forName(CountryCodeBean.ANDRIOD_SYSTEMPROP);
                    lowerCase = (String) cls2.getMethod("get", String.class, String.class).invoke(cls2, str, "");
                } else {
                    lowerCase = property;
                }
            }
        }
        if (TextUtils.isEmpty(lowerCase) || lowerCase.equals("unknown")) {
            str2 = Build.DISPLAY;
            if (!TextUtils.isEmpty(str2)) {
                lowerCase = str2.toLowerCase();
            }
        }
        if (TextUtils.isEmpty(lowerCase)) {
            return "unknown";
        }
        return lowerCase;
    }
}
