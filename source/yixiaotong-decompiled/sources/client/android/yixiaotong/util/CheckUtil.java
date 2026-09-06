package client.android.yixiaotong.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.alipay.sdk.util.i;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class CheckUtil {
    public static boolean isMobile(String str) {
        if (str != null) {
            return Pattern.compile("^((13[0-9])|(14[5|7])|(15[0-9])|(17[0|7|8])|(18[0-9]))\\d{8}$").matcher(str).matches();
        }
        return false;
    }

    public static boolean isCarCode(String str) {
        if (str != null) {
            return Pattern.compile("^[一-龥][A-Za-z]{1}[A-Za-z_0-9]{5}$").matcher(str).matches();
        }
        return false;
    }

    public static boolean isEmail(String str) {
        return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(str).matches();
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isValidTagAndAlias(String str) {
        return Pattern.compile("^[一-龥0-9a-zA-Z_-]{0,}$").matcher(str).matches();
    }

    public static boolean isJson(String str) {
        if (str == null) {
            return false;
        }
        String strTrim = str.trim();
        return "{".equals(strTrim.substring(0, 1)) && i.d.equals(strTrim.substring(strTrim.length() - 1));
    }

    public static boolean isJsonArray(String str) {
        if (str == null) {
            return false;
        }
        String strTrim = str.trim();
        return "[".equals(strTrim.substring(0, 1)) && "]".equals(strTrim.substring(strTrim.length() - 1));
    }

    public static boolean isNullOrNil(String str) {
        return str == null || "".equals(str) || str.length() == 0;
    }
}
