package client.android.yixiaotong.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ScreenUtils {
    public static int getScreenWidth(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getWindowsWidth(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getWindowsHeight(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getDisplayMetrics().heightPixels - getStausBarHeight(context);
    }

    public static int getStausBarHeight(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            int i = Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString());
            if (i < 90) {
                return dp2px(context, i);
            }
        } catch (Exception unused) {
        }
        return dp2px(context, 25.0f);
    }

    public static int px2dp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int dp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int px2sp(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int sp2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static long formatsSize(String str) {
        String strGroup;
        String strTrim;
        try {
            Matcher matcher = Pattern.compile("(KB|Kb|kB|kb|MB|Mb|mB|mb|GB|Gb|gB|gb|b|B)$").matcher(str);
            if (matcher.find()) {
                strGroup = matcher.group(1);
                if (strGroup == null) {
                    throw new NumberFormatException("");
                }
                strTrim = str.replace(matcher.group(1), "").trim();
                if (TextUtils.isEmpty(strTrim)) {
                    throw new NumberFormatException("");
                }
            } else {
                strGroup = null;
                strTrim = null;
            }
            float fFloatValue = Float.valueOf(strTrim).floatValue();
            if (!strGroup.equalsIgnoreCase("GB")) {
                if (!strGroup.equalsIgnoreCase("MB")) {
                    if (!strGroup.equalsIgnoreCase("KB")) {
                        if (strGroup.equalsIgnoreCase("B")) {
                            return (long) fFloatValue;
                        }
                        throw new NumberFormatException("");
                    }
                }
                return (long) (fFloatValue * 1024.0f);
            }
            fFloatValue *= 1024.0f;
            fFloatValue *= 1024.0f;
            return (long) (fFloatValue * 1024.0f);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }
}
