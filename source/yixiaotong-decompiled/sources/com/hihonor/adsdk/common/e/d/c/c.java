package com.hihonor.adsdk.common.e.d.c;

import android.os.Build;
import android.provider.Settings;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {
    private static final String A = "haptic.slide.type2";
    private static final String B = "haptic.slide.type3";
    private static final String C = "haptic.slide.type4";
    private static final String D = "haptic.slide.type5";
    private static final String E = "haptic.slide.type6";
    private static final String F = "haptic.slide.type1_ltor";
    private static final String G = "haptic.slide.type2_ltor";
    private static final String H = "haptic.slide.type3_ltor";
    private static final String I = "haptic.slide.type4_ltor";
    private static final String J = "haptic.slide.type5_ltor";
    private static final String K = "haptic.slide.type6_ltor";
    private static final String L = "haptic.slide.type1_rtol";
    private static final String M = "haptic.slide.type2_rtol";
    private static final String N = "haptic.slide.type3_rtol";
    private static final String O = "haptic.slide.type4_rtol";
    private static final String P = "haptic.slide.type5_rtol";
    private static final String Q = "haptic.slide.type6_rtol";
    private static final String R = "watchhaptic.crown.strength1";
    private static final String S = "watchhaptic.crown.strength2";
    private static final String T = "watchhaptic.crown.strength3";
    private static final String U = "haptic.common.click_light";
    private static final String V = "haptic.common.click_medium";
    private static final String W = "haptic.common.slider_continue";
    private static final String X = "haptic.common.slider_discrete_dense";
    private static final String Y = "haptic.common.slider_discrete_medium";
    private static final String Z = "haptic.common.slider_discrete_few";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f3516a = 10;
    private static final String a0 = "class com.hihonor.android.os.VibratorEx";
    public static final int b = 11;
    private static final String b0 = "haptic.common.subtab";
    public static final int c = 12;
    private static final String c0 = "haptic.common.long_press_context_menu";
    public static final int d = 13;
    private static final String d0 = "haptic.common.picker_light";
    public static final int e = 14;
    private static final String e0 = "haptic.common.picker_medium";
    public static final int f = 15;
    private static final String f0 = "haptic.common.picker_strong";
    public static final int g = 16;
    private static final String g0 = "haptic.common.fail";
    public static final int h = 17;
    private static final String h0 = "haptic.common.long_press_select";
    private static final String hnadsa = "HwVibrateUtil";
    public static final int hnadsb = 0;
    public static final int hnadsc = 0;
    public static final int hnadsd = 1;
    public static final int hnadse = 2;
    public static final int hnadsf = 3;
    public static final int hnadsg = 4;
    public static final int hnadsh = 5;
    public static final int hnadsi = 6;
    public static final int hnadsj = 7;
    public static final int hnadsk = 102;
    public static final int hnadsl = 103;
    public static final int hnadsm = 104;
    public static final int hnadsn = 105;
    public static final int hnadso = 106;
    public static final int hnadsp = 107;
    public static final int hnadsq = 202;
    public static final int hnadsr = 203;
    public static final int hnadss = 204;
    public static final int hnadst = 205;
    public static final int hnadsu = 206;
    public static final int hnadsv = 207;
    public static final int hnadsw = 100;
    public static final int hnadsx = 200;
    public static final int hnadsy = 8;
    public static final int hnadsz = 9;
    public static final int i = 18;
    private static final String i0 = "haptic.common.indexbar";
    public static final int j = 19;
    private static final String j0 = "haptic.common.long_press_notice_mode";
    public static final int k = 20;
    private static final int k0 = 0;
    public static final int l = 21;
    private static String l0 = "com.hihonor.android.os.VibratorEx";
    public static final int m = 22;
    private static String m0 = "com.hihonor.android.view.ViewEx";
    public static final int n = 23;
    private static String n0 = "com.hihonor.android.view.HapticFeedbackConstantsEx";
    public static final int o = 24;
    private static Object o0 = null;
    public static final int p = 25;
    private static Method p0 = null;
    public static final int q = 26;
    private static Method q0 = null;
    public static final int r = 27;
    private static Method r0 = null;
    public static final int s = 28;
    private static Method s0 = null;
    public static final String t = "haptic.control.time_scroll";
    private static Class<?> t0 = null;
    public static final String u = "haptic.common.slide_pull_refresh";
    private static Class<?> u0 = null;
    public static final String v = "haptic.common.threshold";
    private static Class<?> v0 = null;
    private static final String w = "haptic.common.long_press";
    private static boolean w0 = false;
    private static final String x = "haptic.common.long_press1";
    private static String x0 = null;
    private static final String y = "haptic.common.long_press2";
    private static final String z = "haptic.slide.type1";
    private static Map<Integer, String> y0 = new HashMap();
    private static Map<Integer, String> z0 = new HashMap();
    private static List<Integer> A0 = new ArrayList(10);

    static {
        if (Build.VERSION.SDK_INT < 31) {
            Object objHnadsa = b.hnadsa((Object) null, "CLASS_NAME_VIBRATOREX", b.hnadsb);
            if (objHnadsa instanceof String) {
                l0 = (String) objHnadsa;
            }
            Object objHnadsa2 = b.hnadsa((Object) null, "CLASS_NAME_VIEWEX", b.hnadsb);
            if (objHnadsa2 instanceof String) {
                m0 = (String) objHnadsa2;
            }
            Object objHnadsa3 = b.hnadsa((Object) null, "CLASS_NAME_FEEDBACKCONSTANTSEX", b.hnadsb);
            if (objHnadsa3 instanceof String) {
                n0 = (String) objHnadsa3;
            }
        }
        y0.put(0, w);
        y0.put(1, v);
        y0.put(2, z);
        y0.put(3, A);
        y0.put(4, B);
        y0.put(5, C);
        y0.put(6, D);
        y0.put(7, E);
        y0.put(102, F);
        y0.put(103, G);
        y0.put(104, H);
        y0.put(105, I);
        y0.put(106, J);
        y0.put(107, K);
        y0.put(202, L);
        y0.put(203, M);
        y0.put(204, N);
        y0.put(205, O);
        y0.put(206, P);
        y0.put(207, Q);
        y0.put(8, x);
        y0.put(9, y);
        y0.put(10, R);
        y0.put(11, S);
        y0.put(12, T);
        y0.put(13, U);
        y0.put(14, V);
        y0.put(15, u);
        y0.put(16, W);
        y0.put(17, X);
        y0.put(18, Y);
        y0.put(19, Z);
        y0.put(20, b0);
        y0.put(21, c0);
        y0.put(22, d0);
        y0.put(23, e0);
        y0.put(24, f0);
        y0.put(25, g0);
        y0.put(26, h0);
        y0.put(27, i0);
        y0.put(28, j0);
        z0.put(0, w);
        z0.put(1, v);
        z0.put(2, t);
        z0.put(3, t);
        z0.put(4, t);
        z0.put(5, t);
        z0.put(6, t);
        z0.put(7, E);
        z0.put(102, F);
        z0.put(103, G);
        z0.put(104, H);
        z0.put(105, I);
        z0.put(106, J);
        z0.put(107, K);
        z0.put(202, L);
        z0.put(203, M);
        z0.put(204, N);
        z0.put(205, O);
        z0.put(206, P);
        z0.put(207, Q);
        z0.put(8, x);
        z0.put(9, y);
        z0.put(10, R);
        z0.put(11, S);
        z0.put(12, T);
        z0.put(13, U);
        z0.put(14, V);
        z0.put(15, u);
        z0.put(16, W);
        z0.put(17, X);
        z0.put(18, Y);
        z0.put(19, Z);
        z0.put(20, b0);
        z0.put(21, c0);
        z0.put(22, d0);
        z0.put(23, e0);
        z0.put(24, f0);
        z0.put(25, g0);
        z0.put(26, h0);
        z0.put(27, i0);
        z0.put(28, j0);
        try {
            try {
                Class<?> cls = Class.forName(l0);
                t0 = cls;
                if (a0.equals(cls.toString())) {
                    o0 = t0.newInstance();
                    p0 = t0.getMethod("isSupportHwVibrator", String.class);
                    q0 = t0.getMethod("setHwVibrator", String.class);
                    r0 = t0.getMethod("stopHwVibrator", String.class);
                    u0 = Class.forName(m0);
                    v0 = Class.forName(n0);
                    Class<?> cls2 = u0;
                    Class<?> cls3 = Integer.TYPE;
                    s0 = cls2.getMethod("performHwHapticFeedback", View.class, cls3, cls3);
                    A0.add(0, Integer.valueOf(hnadsa("HW_LONG_PRESS")));
                    A0.add(1, Integer.valueOf(hnadsa("HW_THRESHOLD")));
                    A0.add(2, Integer.valueOf(hnadsa("HW_SLIDE_1")));
                    A0.add(3, Integer.valueOf(hnadsa("HW_SLIDE_2")));
                    A0.add(4, Integer.valueOf(hnadsa("HW_SLIDE_3")));
                    A0.add(5, Integer.valueOf(hnadsa("HW_SLIDE_4")));
                    A0.add(6, Integer.valueOf(hnadsa("HW_SLIDE_5")));
                    A0.add(7, Integer.valueOf(hnadsa("HW_SLIDE_6")));
                    A0.add(8, Integer.valueOf(hnadsa("HW_LONG_PRESS1")));
                    A0.add(9, Integer.valueOf(hnadsa("HW_LONG_PRESS2")));
                } else {
                    w0 = true;
                    com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "fail to reflect, class is proguard.", new Object[0]);
                }
            } catch (Exception unused) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "Another exception failed.", new Object[0]);
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException unused2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "class init failed.", new Object[0]);
        }
    }

    private c() {
    }

    private static int hnadsb(String str) {
        try {
            Object obj = v0.getField(str).get(null);
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "get field failed.", new Object[0]);
        }
        return 0;
    }

    public static boolean hnadsc(View view, int i2, int i3) {
        if (A0.size() != 0 && hnadsa(view, i2, i3)) {
            return true;
        }
        if (Settings.System.getInt(view.getContext().getContentResolver(), "haptic_feedback_enabled", 0) == 0) {
            return false;
        }
        return hnadse(z0.get(Integer.valueOf(i2)));
    }

    private static int hnadsa(String str) {
        if (w0 || v0 == null) {
            return 0;
        }
        return hnadsb(str);
    }

    public static boolean hnadsb(View view, int i2, int i3) {
        if (A0.size() == 0 || !hnadsa(view, i2, i3)) {
            return hnadse(z0.get(Integer.valueOf(i2)));
        }
        return true;
    }

    public static boolean hnadsd(String str) {
        if (w0 || o0 == null || r0 == null || !hnadsc(str)) {
            return false;
        }
        try {
            r0.invoke(o0, str);
            return true;
        } catch (IllegalAccessException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "Call stopVibrateEx IllegalAccessException Exception.", new Object[0]);
            return false;
        } catch (InvocationTargetException unused2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "Call stopVibrateEx InvocationTargetException Exception.", new Object[0]);
            return false;
        }
    }

    public static boolean hnadse(String str) {
        if (w0 || str == null || o0 == null || q0 == null || !hnadsc(str)) {
            return false;
        }
        try {
            q0.invoke(o0, str);
            return true;
        } catch (IllegalAccessException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "Call doVibrateEx IllegalAccessException Exception.", new Object[0]);
            return false;
        } catch (InvocationTargetException unused2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "Call doVibrateEx InvocationTargetException Exception.", new Object[0]);
            return false;
        }
    }

    public static String hnadsa() {
        Class<?> cls;
        String str = x0;
        if (str == null) {
            if (o0 == null || (cls = t0) == null) {
                return str;
            }
            try {
                x0 = (String) cls.getMethod("getHwParameter", String.class).invoke(o0, "subVibratorInfoOnChip");
            } catch (IllegalAccessException unused) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "Call getVibratorNum IllegalAccessException Exception.", new Object[0]);
            } catch (NoSuchMethodException unused2) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "Call getVibratorNum NoSuchMethodException Exception.", new Object[0]);
            } catch (InvocationTargetException unused3) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "Call getVibratorNum InvocationTargetException Exception.", new Object[0]);
            }
        }
        return x0;
    }

    public static boolean hnadsc(String str) {
        Object obj;
        Method method = p0;
        if (method == null || (obj = o0) == null) {
            return false;
        }
        try {
            Object objInvoke = method.invoke(obj, str);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
            return false;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "Call isSupportHwVibrator exception.", new Object[0]);
            return false;
        }
    }

    private static boolean hnadsa(View view, int i2, int i3) {
        if (s0 == null || i2 >= A0.size() || i2 < 0 || !hnadsc(y0.get(Integer.valueOf(i2)))) {
            return false;
        }
        try {
            s0.invoke(null, view, A0.get(i2), Integer.valueOf(i3));
            return true;
        } catch (IllegalAccessException unused) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "Call doViewEx IllegalAccessException Exception.", new Object[0]);
            return false;
        } catch (InvocationTargetException unused2) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa, "Call doViewEx InvocationTargetException Exception.", new Object[0]);
            return false;
        }
    }

    public static String hnadsa(int i2) {
        if (z0.size() == 0) {
            return null;
        }
        return z0.get(Integer.valueOf(i2));
    }
}
