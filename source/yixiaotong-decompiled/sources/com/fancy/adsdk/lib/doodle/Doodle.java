package com.fancy.adsdk.lib.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.fancy._b0;
import com.fancy._b5;
import com.fancy._bn;
import com.fancy._bp;
import com.fancy._bv;
import com.fancy._c1;
import com.fancy._fm;
import com.fancy._fr;
import com.fancy._g1;
import com.fancy._m3;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class Doodle {
    public static void cacheBitmap(String str, Bitmap bitmap, boolean z) {
        _g1._a(new _b0(str), bitmap, z);
    }

    public static int checkConfigApply(Context context) {
        return nativeCheckConfigApply(context);
    }

    public static int checkConfigRevert(Context context) {
        return nativeCheckConfigRevert(context);
    }

    public static int checkImage(Context context, String str, String[] strArr) {
        return nativeCheckImage(context, str, strArr);
    }

    public static int checkLink(Context context, String[] strArr) {
        return nativeCheckLink(context, strArr);
    }

    public static void clear(ImageView imageView) {
        if (imageView != null) {
            _bp._b(imageView);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void clear(_bv _bvVar) {
        if (_bvVar instanceof View) {
            _bp._b((View) _bvVar);
        }
    }

    public static void clearCache(String str) {
        String str2;
        if (str == null || str.isEmpty()) {
            return;
        }
        _b0 _b0Var = new _b0(str);
        _b._a._a(_b0Var);
        _g1._b(_b0Var);
        _b5 _b5Var = _b5.NOT_SET;
        String str3 = _bn._a;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
        } else {
            str2 = str.contains("://") ? str : "file://" + str;
        }
        StringBuilder sb = new StringBuilder(128);
        if (!TextUtils.isEmpty(null)) {
            str2 = null;
        }
        sb.append(str2).append(":s0x0:c").append(_b5Var._a).append(":f").append(_c1._a(1)).append(":u0:d1");
        _b0 _b0Var2 = new _b0(sb.toString());
        _f._m._a(_b0Var2);
        _g1._b(_b0Var2);
        _b5 _b5Var2 = _b5.NOT_SET;
        String str4 = _bn._a;
        if (TextUtils.isEmpty(str)) {
            str = "";
        } else if (!str.contains("://")) {
            str = "file://" + str;
        }
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(TextUtils.isEmpty(null) ? str : null).append(":s0x0:c").append(_b5Var2._a).append(":f").append(_c1._a(1)).append(":u0:d0");
        _b0 _b0Var3 = new _b0(sb2.toString());
        _f._m._a(_b0Var3);
        _g1._b(_b0Var3);
    }

    public static String clearCrashHistory() {
        return nativeClearCrashHistory();
    }

    public static void clearMemory() {
        synchronized (_fr.class) {
            _fr._a(0L);
        }
    }

    public static _bn config() {
        return _bn._e;
    }

    public static File downloadOnly(String str) {
        return _b._a(str);
    }

    public static Bitmap getCacheBitmap(String str) {
        return _g1._a(new _b0(str));
    }

    public static File getCacheFile(String str) {
        String str_c;
        _b0 _b0Var = new _b0(str);
        _a _aVar = _b._a;
        synchronized (_aVar) {
            if (_aVar._a()) {
                _a._b _bVar = (_a._b) _aVar._h.get(_b0Var);
                if (_bVar != null) {
                    int i = _aVar._e;
                    _bVar._c = i;
                    _aVar._g.putInt(_bVar._b, i);
                    _aVar._e++;
                }
                str_c = _bVar != null ? _aVar._c(_b0Var) : null;
            } else {
                str_c = null;
            }
        }
        if (str_c == null || !new File(str_c).exists()) {
            _aVar._a(_b0Var);
            str_c = null;
        }
        if (str_c != null) {
            return new File(str_c);
        }
        return null;
    }

    public static int getCrashCounts(long j) {
        return nativeGetCrashCounts(j);
    }

    public static float getScale(int i, int i2, int i3, int i4, _b5 _b5Var, boolean z) {
        return Decoder.getScale(i, i2, i3, i4, _b5Var, z);
    }

    public static String getVersion() {
        return nativeGetVersion();
    }

    public static int imagePreload(Context context, String str, String str2, String str3) {
        return nativeImagePreload(context, str, str2, str3);
    }

    public static int imageUnload(Context context, String str, String str2) {
        return nativeImageUnload(context, str, str2);
    }

    public static boolean isImageLoaded(String str) {
        return nativeIsImageLoaded(str);
    }

    public static _m3 load(int i) {
        return new _m3(i);
    }

    public static _m3 load(Uri uri) {
        return new _m3(uri);
    }

    public static _m3 load(File file) {
        return new _m3(file != null ? file.getPath() : "");
    }

    public static _m3 load(String str) {
        return new _m3(str);
    }

    private static native int nativeCheckConfigApply(Context context);

    private static native int nativeCheckConfigRevert(Context context);

    private static native int nativeCheckImage(Context context, String str, String[] strArr);

    private static native int nativeCheckLink(Context context, String[] strArr);

    private static native String nativeClearCrashHistory();

    private static native int nativeGetCrashCounts(long j);

    private static native String nativeGetVersion();

    private static native int nativeImagePreload(Context context, String str, String str2, String str3);

    private static native int nativeImageUnload(Context context, String str, String str2);

    private static native boolean nativeIsImageLoaded(String str);

    private static native String nativeSetCrashFilePath(String str);

    public static void notifyDestroy(Object obj) {
        _fm._a(obj, 3);
    }

    public static void notifyPause(Object obj) {
        _fm._a(obj, 1);
    }

    public static void notifyResume(Object obj) {
        _fm._a(obj, 2);
    }

    public static void pauseRequests() {
        _bp._a = true;
    }

    public static void resumeRequests() {
        if (_bp._a) {
            _bp._a = false;
            synchronized (_bp.class) {
                Iterator<_m3> it = _bp._b.values().iterator();
                while (it.hasNext()) {
                    _bp._a(it.next());
                }
                _bp._b.clear();
            }
        }
    }

    public static String setCrashFilePath(String str) {
        return nativeSetCrashFilePath(str);
    }

    public static void trimMemory(int i) {
        synchronized (_fr.class) {
            try {
                if (i >= 60) {
                    _fr._a(0L);
                } else if (i >= 40 || i == 15) {
                    _fr._a(Math.max(_fr._b >> 1, _fr._a));
                } else {
                    LinkedHashMap linkedHashMap = _fr._c;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
