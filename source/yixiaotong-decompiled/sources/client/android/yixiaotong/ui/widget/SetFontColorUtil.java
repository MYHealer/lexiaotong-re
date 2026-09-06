package client.android.yixiaotong.ui.widget;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import client.android.yixiaotong.util.StringUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SetFontColorUtil {
    public static SpannableStringBuilder getFont(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ((cCharAt >= '0' && cCharAt <= '9') || cCharAt == '.') {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(str2)), i, i + 1, 33);
            }
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder getFontForContent(String str, String str2, String str3) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (StringUtils.isNotEmpty(str) && StringUtils.isNotEmpty(str2) && str.contains(str2)) {
            int iIndexOf = str.indexOf(str2);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(str3)), iIndexOf, str2.length() + iIndexOf, 33);
        }
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder getFontForContents(String str, String str2, String... strArr) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        for (String str3 : strArr) {
            if (StringUtils.isNotEmpty(str) && StringUtils.isNotEmpty(str3) && str.contains(str3)) {
                int iIndexOf = str.indexOf(str3);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(str2)), iIndexOf, str3.length() + iIndexOf, 33);
            }
        }
        return spannableStringBuilder;
    }
}
