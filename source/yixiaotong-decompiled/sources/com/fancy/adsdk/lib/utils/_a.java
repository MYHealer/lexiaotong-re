package com.fancy.adsdk.lib.utils;

import android.content.ContentResolver;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.fancy._c7;
import com.fancy._ca;
import com.fancy._f;
import com.fancy._ie;
import com.fancy._n4;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.utils.dev.ScreenUtils;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _a {
    public static volatile String[] _b;
    public static volatile Integer _c;
    public static String _f;
    public static String _g;
    public static Random _a = new Random();
    public static final Random _d = new Random();
    public static long _e = 0;

    public static String _a(String str) {
        return new String(Base64.decode(str, 2));
    }

    public static String _a(String str, String str2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        byte[] bytes = str2.getBytes(HTTP.ASCII);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(bytes));
        return Base64.encodeToString(cipher.doFinal(str.getBytes("UTF-8")), 2);
    }

    public static String _a(String str, byte[] bArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException {
        byte[] bytes = str.getBytes(HTTP.ASCII);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(bytes));
        return new String(cipher.doFinal(bArr), "UTF-8");
    }

    public static boolean _a(_f _fVar, AtomicBoolean atomicBoolean) {
        if (_fVar == null || atomicBoolean == null || atomicBoolean.get()) {
            return false;
        }
        if (_fVar._T == 1) {
            atomicBoolean.set(true);
            return true;
        }
        atomicBoolean.set(false);
        return false;
    }

    public static int _b() {
        if (ScreenUtils.GUBED) {
            return 11;
        }
        _ca._f();
        if (_ca._g) {
            return 12;
        }
        _ca._f();
        if (_ca._h) {
            return 13;
        }
        _ca._f();
        return _ca._i ? 14 : 10;
    }

    public static String _b(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    public static int _c() {
        try {
            String str = Build.BRAND;
            String str2 = Build.MANUFACTURER;
            if ((str == null || !str.equalsIgnoreCase("HONOR")) && (str2 == null || !str2.equalsIgnoreCase("HONOR"))) {
                return -1;
            }
            if (PtgAdSdk.getContext() == null) {
                return -1;
            }
            return ((Integer) Class.forName(new String(Base64.decode("YW5kcm9pZC5wcm92aWRlci5TZXR0aW5ncyRTeXN0ZW0=", 2))).getMethod("getInt", ContentResolver.class, String.class, Integer.TYPE).invoke(null, PtgAdSdk.getContext().getContentResolver(), new String(Base64.decode("YXBwbGljYXRpb25fYXV0b19qdW1wX3N3aXRjaA==", 2)), -1)).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    public static String _c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(str.getBytes());
                str = new BigInteger(1, messageDigest.digest()).toString(16);
                while (str.length() < 32) {
                    str = "0" + str;
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0020  */
    public static int _d() {
        int i;
        Integer num = _c;
        if (num != null) {
            return num.intValue();
        }
        try {
            if (Process.is64Bit()) {
                i = 64;
            } else {
                i = 32;
            }
        } catch (Throwable unused) {
            String property = System.getProperty("os.arch");
            if (property != null && property.contains("64")) {
                i = 64;
            }
        }
        _c = Integer.valueOf(i);
        return i;
    }

    public static String _d(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            Logger.e(_ie._a("urlEncode error: ").append(e.getMessage()).toString());
            return str;
        }
    }

    public static boolean _e() {
        try {
            try {
                return WebView.getCurrentWebViewPackage() != null;
            } catch (Throwable unused) {
                PackageManager packageManager = PtgAdSdk.getContext().getPackageManager();
                if (packageManager == null) {
                    return false;
                }
                String[] strArr = {"com.google.android.webview", "com.android.webview", "com.android.chrome", "com.huawei.webview"};
                for (int i = 0; i < 4; i++) {
                    try {
                        ApplicationInfo applicationInfo = packageManager.getApplicationInfo(strArr[i], 0);
                        if (applicationInfo != null && applicationInfo.enabled) {
                            return true;
                        }
                    } catch (Throwable unused2) {
                    }
                }
                return false;
            }
        } catch (Throwable unused3) {
            return false;
        }
    }

    public static boolean _f() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z = jCurrentTimeMillis - _e <= 600;
        _e = jCurrentTimeMillis;
        return z;
    }

    public static boolean _g() {
        return Build.VERSION.SDK_INT < PtgAdSdk.getConfig().getLessThanVc();
    }

    public static boolean _h() {
        return true;
    }

    public static String _a() {
        JSONArray jSONArray = new JSONArray();
        String[] strArr = _b;
        if (strArr == null) {
            ArrayList arrayList = new ArrayList();
            String[] strArr2 = Build.SUPPORTED_ABIS;
            if (strArr2 != null) {
                for (String str : strArr2) {
                    if (!TextUtils.isEmpty(str)) {
                        arrayList.add(str);
                    }
                }
            }
            _b = (String[]) arrayList.toArray(new String[0]);
            strArr = _b;
        }
        for (String str2 : strArr) {
            jSONArray.put(str2);
        }
        return jSONArray.toString();
    }

    public static boolean _a(List<String> list) {
        _c7 _c7Var;
        if (ScreenUtils.GUBED) {
            return true;
        }
        if (list != null && !list.isEmpty() && (_c7Var = _n4._a) != null && (list.contains(_c7Var._a) || list.contains(_n4._a._d))) {
            return true;
        }
        _ca._f();
        if (!_ca._g) {
            _ca._f();
            if (!_ca._h) {
                _ca._f();
                if (!_ca._i) {
                    return true;
                }
            }
        }
        return false;
    }
}
