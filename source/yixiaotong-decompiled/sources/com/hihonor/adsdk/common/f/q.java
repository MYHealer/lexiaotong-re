package com.hihonor.adsdk.common.f;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class q {
    private static final String hnadsa = "^[0-9]*$";
    private static final String hnadsb = "^[0-9]*[.]?[0-9]*$";
    private static final String hnadsc = "NumberUtils";

    private q() {
    }

    public static byte hnadsa(String str, boolean z) {
        return z ? Byte.parseByte(str) : hnadsa(str, (byte) 0);
    }

    public static double hnadsb(String str, boolean z) {
        return z ? Double.parseDouble(str) : hnadsa(str, 0.0d);
    }

    public static byte hnadsc(String str) {
        return hnadsa(str, (byte) 0);
    }

    public static int hnadsd(String str, boolean z) {
        return z ? Integer.parseInt(str) : hnadsa(str, 0);
    }

    public static long hnadse(String str, boolean z) {
        return z ? Long.parseLong(str) : hnadsa(str, 0L);
    }

    public static short hnadsf(String str, boolean z) {
        return z ? Short.parseShort(str) : hnadsa(str, (short) 0);
    }

    public static long hnadsg(String str) {
        return hnadsa(str, 0L);
    }

    public static short hnadsh(String str) {
        return hnadsa(str, (short) 0);
    }

    public static float hnadsc(String str, boolean z) {
        return z ? Float.parseFloat(str) : hnadsa(str, 0.0f);
    }

    public static byte hnadsa(String str, byte b) {
        if (str == null) {
            return b;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "parseByte, " + str + " convert Byte exception  :{" + e.getMessage() + com.alipay.sdk.util.i.d, new Object[0]);
            return b;
        }
    }

    public static boolean hnadsb(String str) {
        return hnadsa(hnadsb, str);
    }

    public static double hnadsd(String str) {
        return hnadsa(str, 0.0d);
    }

    public static float hnadse(String str) {
        return hnadsa(str, 0.0f);
    }

    public static int hnadsf(String str) {
        return hnadsa(str, 0);
    }

    public static short hnadsa(String str, short s) {
        if (str == null) {
            return s;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "parseShort, " + str + " convert Short exception  :{" + e.getMessage() + com.alipay.sdk.util.i.d, new Object[0]);
            return s;
        }
    }

    public static int hnadsa(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "parseInt, " + str + " convert Int exception  :{" + e.getMessage() + com.alipay.sdk.util.i.d, new Object[0]);
            return i;
        }
    }

    public static long hnadsa(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "parseLong, " + str + " convert Long exception  :{" + e.getMessage() + com.alipay.sdk.util.i.d, new Object[0]);
            return j;
        }
    }

    public static float hnadsa(String str, float f) {
        if (str == null) {
            return f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "parseFloat, " + str + " convert Float exception  :{" + e.getMessage() + com.alipay.sdk.util.i.d, new Object[0]);
            return f;
        }
    }

    public static double hnadsa(String str, double d) {
        if (str == null) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "parseDouble, " + str + " convert Double exception  :{" + e.getMessage() + com.alipay.sdk.util.i.d, new Object[0]);
            return d;
        }
    }

    public static boolean hnadsa(String str) {
        return hnadsa(hnadsa, str);
    }

    private static boolean hnadsa(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            try {
                return Pattern.matches(str, str2);
            } catch (Exception e) {
                com.hihonor.adsdk.common.b.b.hnadsb(hnadsc, "match, exception: " + e.getMessage(), new Object[0]);
            }
        }
        return false;
    }
}
