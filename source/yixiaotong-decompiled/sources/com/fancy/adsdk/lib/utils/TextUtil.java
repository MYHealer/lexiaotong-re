package com.fancy.adsdk.lib.utils;

import android.graphics.Typeface;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.fancy._ie;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class TextUtil {
    private static final String CHINESE_PATTERN = "[^\\u4e00-\\u9fa5]";
    private static final String NUMBER_PATTERN = "^[0-9]*$";

    public static String appendStrings(String... strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr.length > 0) {
            for (String str : strArr) {
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString().trim();
    }

    public static String base64Encode(String str) {
        return isEmpty(str) ? "" : Base64.encodeToString(str.getBytes(StandardCharsets.UTF_8), 8);
    }

    public static String formatNumber(String str) {
        if (isEmpty(str)) {
            return str;
        }
        try {
            long j = Long.parseLong(str);
            if (j < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                return str;
            }
            return j == ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT ? "1万" : String.format("%s万", Float.valueOf(Math.round((j / 10000.0f) * 10.0f) / 10.0f));
        } catch (NumberFormatException unused) {
            return str;
        }
    }

    public static Spanned fromHtml(String str) {
        try {
            return Html.fromHtml(str);
        } catch (Throwable unused) {
            return new SpannableString("");
        }
    }

    public static boolean generateJudgment(String str) {
        return Pattern.compile("[一-龥]").matcher(str).find();
    }

    private static String getHexString(String str) {
        int length = str.length();
        String str2 = "";
        while (length < 4) {
            str2 = length == str.length() ? "0" : str2 + "0";
            length++;
        }
        return str2 + str;
    }

    public static String getString(String str, Object... objArr) {
        for (int i = 0; i < objArr.length; i++) {
            str = str.replace("#p" + i + "#", String.valueOf(objArr[i]));
        }
        return str;
    }

    public static String hexToUnicode(String str) {
        String strValueOf = null;
        String strValueOf2 = null;
        for (int i = 0; i < str.length(); i++) {
            strValueOf2 = strValueOf2 == null ? String.valueOf(str.charAt(i)) : _ie._a(strValueOf2).append(str.charAt(i)).toString();
            if (i % 4 == 3) {
                if (strValueOf2 != null) {
                    strValueOf = strValueOf == null ? String.valueOf((char) Integer.valueOf(strValueOf2, 16).intValue()) : _ie._a(strValueOf).append(String.valueOf((char) Integer.valueOf(strValueOf2, 16).intValue())).toString();
                }
                strValueOf2 = null;
            }
        }
        return strValueOf;
    }

    public static boolean isBigThanZero(String str) {
        if (isEmpty(str)) {
            return false;
        }
        try {
            return Double.valueOf(str).doubleValue() > 0.0d;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isChinese(String str) {
        if (isEmpty(str)) {
            return false;
        }
        return Pattern.compile(CHINESE_PATTERN).matcher(str).matches();
    }

    public static boolean isEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() <= 0;
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.size() <= 0;
    }

    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length <= 0;
    }

    public static boolean isEmpty(String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return true;
        }
        for (String str : strArr) {
            if (isEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMobile(String str) {
        return !isEmpty(str) && str.trim().startsWith("1") && str.trim().length() == 11;
    }

    public static boolean isNickNameSpecialChar(String str) {
        return Pattern.compile("[;/?:@&=+$,]").matcher(str).find();
    }

    public static boolean isNotEmpty(CharSequence charSequence) {
        return !isEmpty(charSequence);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isNotEmpty(Collection collection) {
        return collection != null && collection.size() > 0;
    }

    public static boolean isNotEmpty(Map map) {
        return map != null && map.size() > 0;
    }

    public static boolean isNotEmpty(Object[] objArr) {
        return objArr != null && objArr.length > 0;
    }

    public static boolean isNumer(String str) {
        if (isEmpty(str)) {
            return false;
        }
        return Pattern.compile(NUMBER_PATTERN).matcher(str).matches();
    }

    public static boolean isSpecialChar(String str) {
        return Pattern.compile("[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t").matcher(str).find();
    }

    public static SpannableString lightText(String str, String str2, int i) {
        SpannableString spannableString = new SpannableString(str);
        if (isEmpty(str2)) {
            return spannableString;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < str2.length(); i2++) {
            arrayList.add(Character.valueOf(str2.charAt(i2)));
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (arrayList.contains(Character.valueOf(str.charAt(i3)))) {
                spannableString.setSpan(new ForegroundColorSpan(i), i3, i3 + 1, 17);
            }
        }
        return spannableString;
    }

    public static Spanned lightText(String str, String str2, String str3) {
        String str4;
        if (!isEmpty(str)) {
            if (!isEmpty(str2) && str.contains(str2)) {
                int iIndexOf = str.indexOf(str2);
                int length = str2.length() + iIndexOf;
                str4 = str.substring(0, iIndexOf) + "<font color=" + str3 + SimpleComparison.GREATER_THAN_OPERATION + str.substring(iIndexOf, length) + "</font>" + str.substring(length);
            }
            return Html.fromHtml(str);
        }
        str4 = "";
        return Html.fromHtml(str4);
    }

    public static <T> T replaceNullObject(T t, T t2) {
        return t == null ? t2 : t;
    }

    public static String replaceNullString(String str) {
        return replaceNullString(str, "");
    }

    public static String replaceNullString(String str, String str2) {
        return isEmpty(str) ? str2 : str;
    }

    public static void setTextBold(TextView textView, boolean z) {
        if (z) {
            setTextStyleBold(textView);
        } else {
            setTextStyleNormal(textView);
        }
    }

    public static void setTextLine(TextView textView) {
        if (textView == null || textView.getPaint() == null) {
            return;
        }
        textView.getPaint().setFlags(17);
    }

    public static void setTextStyleBold(TextView textView) {
        if (textView != null) {
            textView.setTypeface(Typeface.defaultFromStyle(1));
        }
    }

    public static void setTextStyleNormal(TextView textView) {
        if (textView != null) {
            textView.setTypeface(Typeface.defaultFromStyle(0));
        }
    }

    public static String trimString(String str) {
        if (isEmpty(str)) {
            return "";
        }
        boolean zIsChinese = isChinese(str);
        String strReplace = str.trim().replace(IOUtils.LINE_SEPARATOR_UNIX, "");
        return zIsChinese ? strReplace.replace("\u3000", "").replace(PPSLabelView.Code, "").replaceAll("\\<.*?>", "") : strReplace.replaceAll("\\<.*?>", "");
    }

    public static String trimStringTwo(String str) {
        return isEmpty(str) ? "" : str.trim().replace(IOUtils.LINE_SEPARATOR_WINDOWS, "").replace(IOUtils.LINE_SEPARATOR_UNIX, "").replace("\r", "").replace("\t", "").replace("\u3000", "").replaceAll("\\<.*?>", "");
    }

    public static String unicodeToHe(String str) {
        if (isEmpty(str)) {
            return "";
        }
        String hexString = null;
        int i = 0;
        while (i < str.length()) {
            hexString = i == 0 ? getHexString(Integer.toHexString(str.charAt(i)).toUpperCase()) : _ie._a(hexString).append(getHexString(Integer.toHexString(str.charAt(i)).toUpperCase())).toString();
            i++;
        }
        return hexString;
    }

    public String format(String str) {
        int iLastIndexOf;
        String string = Html.fromHtml(str).toString();
        return (string == null || (iLastIndexOf = string.lastIndexOf("\n\n")) == -1) ? string : string.substring(0, iLastIndexOf) + string.substring(iLastIndexOf + 1);
    }
}
