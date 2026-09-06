package com.baidu.oauth.sdkbqt.a;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.view.inputmethod.InputMethodManager;
import com.baidu.passbqt.common.SecurityUtil;
import com.ubixnow.ooooo.oOo00o00;
import java.security.MessageDigest;
import java.util.HashMap;
import okio.Utf8;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class h {
    public static String a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            return packageInfo.signatures.length > 0 ? SecurityUtil.a(packageInfo.signatures[0].toByteArray(), false) : "";
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public static String a(byte[] bArr, boolean z) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_1).digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return z ? sb.toString() : sb.toString().toUpperCase();
        } catch (Exception e) {
            d.a(e);
            return "";
        }
    }

    public static String b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            return packageInfo.signatures.length > 0 ? a(packageInfo.signatures[0].toByteArray(), false) : "";
        } catch (Throwable th) {
            d.a(th);
            return "";
        }
    }

    public static void a(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (!inputMethodManager.isActive() || activity.getCurrentFocus() == null || activity.getCurrentFocus().getWindowToken() == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null;
        } catch (Throwable th) {
            d.a(th);
            return false;
        }
    }

    public static String a(HashMap<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            String str2 = map.get(str);
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (sb.length() != 0) {
                    sb.append("&");
                }
                sb.append(str).append("=").append(str2);
            }
        }
        return sb.toString();
    }

    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static boolean a(String str, Context context) {
        try {
            return context.checkSelfPermission(str) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static HashMap<String, String> a(String str) {
        HashMap<String, String> map = new HashMap<>();
        if (TextUtils.isEmpty(str)) {
            return map;
        }
        if (str.contains("?")) {
            try {
                str = str.substring(str.indexOf("?") + 1, str.length());
            } catch (Exception e) {
                d.a(e);
            }
        }
        for (String str2 : str.split("&")) {
            String[] strArrSplit = str2.split("=");
            if (strArrSplit.length == 2) {
                map.put(strArrSplit[0], strArrSplit[1]);
            }
        }
        return map;
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            d.a(th);
            return "0";
        }
    }

    public static String c(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(String str) {
        return new String(Base64.decode(str, 0));
    }

    public static String a(byte[] bArr) {
        int i;
        StringBuilder sb = new StringBuilder();
        int length = bArr.length * 8;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        byte b = 0;
        int i5 = 6;
        while (true) {
            if (i2 > 0 && i5 > 0) {
                int i6 = (bArr[i3] & 255) << i5;
                int i7 = 8 - i5;
                b = (byte) (((byte) (i6 | ((bArr[i3 + 1] & 255) >> i7))) & Utf8.REPLACEMENT_BYTE);
                i5 = 6 - i7;
                i2 = i7;
            } else if (i2 == 0) {
                b = (byte) ((bArr[i3] & 255) >> (8 - i5));
                i2 = 2;
                i5 = 4;
            } else if (i5 == 0) {
                b = (byte) (bArr[i3] & Utf8.REPLACEMENT_BYTE);
                i2 = 0;
                i5 = 6;
            }
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(b));
            i4 += 6;
            int i8 = i4 / 8;
            i = length - i4;
            if (i < 6) {
                break;
            }
            i3 = i8;
        }
        if (i > 0) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((byte) ((bArr[bArr.length - 1] << (6 - i)) & 63)));
        }
        int i9 = length % 3;
        for (int i10 = 0; i10 < i9; i10++) {
            sb.append("=");
        }
        return sb.toString();
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri uri = Uri.parse(str);
        uri.getHost();
        String[] strArr = {Uri.decode(uri.getQueryParameter("sign")), Uri.decode(uri.getQueryParameter(oOo00o00.OooO0o)), Uri.decode(uri.getQueryParameter("cmd")), Uri.decode(uri.getQueryParameter("tpl"))};
        for (int i = 0; i < 4; i++) {
            if (TextUtils.isEmpty(strArr[i])) {
                return false;
            }
        }
        uri.getScheme();
        return c.b().equals(new StringBuilder().append(uri.getScheme()).append("://").append(uri.getHost()).toString());
    }

    public static boolean a() {
        try {
            Class.forName("com.baidu.sapi2.SapiAccountManager");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
