package com.masget.base.util;

import android.app.Activity;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import client.android.yixiaotong.util.TimeUtils;
import com.kuaishou.weapon.p0.t;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CommonUtil {
    private static final String TAG = "CommonUtil";

    public static void autoHideKeyboard(final Activity activity, View view) {
        if (!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.masget.base.util.CommonUtil.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    CommonUtil.hideSoftKeyboard(activity);
                    return false;
                }
            });
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            autoHideKeyboard(activity, viewGroup.getChildAt(i));
            i++;
        }
    }

    public static void hideSoftKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isMobileNumber(String str) {
        if (TextUtils.isEmpty(str.trim())) {
            return false;
        }
        return Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$").matcher(str).matches();
    }

    public static boolean isPhoneNumber(String str) {
        if (TextUtils.isEmpty(str.trim())) {
            return false;
        }
        return Pattern.compile("(0\\d{2,3})?(-)?\\d{7,8}(-\\d{3,4})?").matcher(str).matches();
    }

    public static String filterNull(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String formatCardNo(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return str.substring(0, 6) + "********" + str.substring(str.length() - 4, str.length());
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getCurrentTime() {
        return getCurrentTime(TimeUtils.FORMATDATETIME);
    }

    public static String getCurrentTime(String str) {
        if (TextUtils.isEmpty(str)) {
            str = TimeUtils.FORMATDATETIME;
        }
        return new SimpleDateFormat(str, Locale.CHINA).format(Long.valueOf(System.currentTimeMillis()));
    }

    public static String formatTime(String str, Date date) {
        if (TextUtils.isEmpty(str)) {
            str = TimeUtils.FORMATDATETIME;
        }
        return new SimpleDateFormat(str, Locale.CHINA).format(date);
    }

    public static String formatTime(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            str = TimeUtils.FORMATDATETIME;
        }
        return new SimpleDateFormat(str, Locale.CHINA).format(Long.valueOf(j));
    }

    public static String formatTime(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                str = TimeUtils.FORMATDATETIME;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.CHINA);
            return simpleDateFormat.format(simpleDateFormat.parse(str2));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String formatTime(String str) {
        return formatTime((String) null, str);
    }

    public static String formatDouble(double d) {
        return new DecimalFormat("#0.00").format(d);
    }

    public static int compareStringInDecimal(String str, String str2) {
        return new BigDecimal(str).compareTo(new BigDecimal(str2));
    }

    public static String formatYuanToFen(String str) {
        if (TextUtils.isEmpty(str)) {
            return new BigDecimal("0.00").toPlainString();
        }
        return new BigDecimal(str).multiply(new BigDecimal("100")).setScale(0, 1).toPlainString();
    }

    public static String formatFenToYuan(String str) {
        if (TextUtils.isEmpty(str)) {
            return new BigDecimal("0").toPlainString();
        }
        return new BigDecimal(str).setScale(2, 1).divide(new BigDecimal("100.00"), 1).setScale(2, 1).toPlainString();
    }

    public static long formatFenToLongValue(String str) {
        int iIntValueExact;
        if (TextUtils.isEmpty(str)) {
            iIntValueExact = new BigDecimal("0").intValueExact();
        } else {
            iIntValueExact = new BigDecimal(str).setScale(0, 1).intValueExact();
        }
        return iIntValueExact;
    }

    public static String formatFenToString(String str, int i) {
        BigDecimal bigDecimal;
        if (TextUtils.isEmpty(str)) {
            bigDecimal = new BigDecimal("0");
        } else {
            bigDecimal = new BigDecimal(str);
        }
        return String.format("%0" + i + t.t, Long.valueOf(bigDecimal.setScale(0, 1).longValueExact()));
    }
}
