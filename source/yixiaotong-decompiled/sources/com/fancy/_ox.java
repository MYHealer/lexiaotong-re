package com.fancy;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebSettings;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ox {
    public static final AtomicBoolean _a = new AtomicBoolean(false);
    public static final AtomicInteger _b = new AtomicInteger(0);
    public static volatile String _c = "";

    public interface _a {
    }

    public static String _a(Context context) {
        if (context == null) {
            if (TextUtils.isEmpty(_c)) {
                return "";
            }
        } else {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                try {
                    String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                    return defaultUserAgent != null ? defaultUserAgent : "";
                } catch (Exception unused) {
                    return "";
                }
            }
            if (TextUtils.isEmpty(_c)) {
                return "";
            }
        }
        return _c;
    }

    public static void _a(_a _aVar, String str) {
        if (_aVar != null) {
            if (str == null) {
                str = "";
            }
            try {
                _c7 _c7Var = ((_ov) _aVar)._a;
                if (_c7Var != null) {
                    _c7Var._z = TextUtils.isEmpty(str) ? "" : str;
                }
            } catch (Exception unused) {
            }
        }
    }
}
