package com.fancy;

import android.os.Handler;
import android.os.Looper;
import com.byazt.tk.AdBaseConstants;
import com.fancy.adsdk.lib.utils.Logger;
import com.google.android.exoplayer2.C;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _cu {
    public final Pattern _a = Pattern.compile(".*\\.apk(\\?.*)?$", 2);

    public interface _a {
    }

    public _cu(String str, _d2 _d2Var) {
        Logger.d("PTG_QM_TAG cut-0");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Handler handler = new Handler(Looper.getMainLooper());
        _cs _csVar = new _cs(this, atomicBoolean, _d2Var);
        handler.postDelayed(_csVar, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        com.fancy.adsdk.lib.utils._d._b(new _ct(this, str, atomicBoolean, handler, _csVar, _d2Var));
    }

    public static long _a(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getContentLengthLong();
        } catch (Exception unused) {
            return httpURLConnection.getContentLength();
        }
    }

    public static void _a(_cu _cuVar, _a _aVar, int i, int i2, String str) {
        _cuVar.getClass();
        _cr _crVar = new _cr(_aVar, i, i2, str);
        _fv _fvVar = _fv._a;
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            _crVar.run();
        } else {
            _fv._a.post(_crVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001f  */
    public static boolean _a(String str, String str2) {
        if (str == null) {
            if (str2 != null) {
            }
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (!lowerCase.contains("text/html") && !lowerCase.contains("application/xhtml+xml") && !lowerCase.contains("text/xml")) {
            if (str2 != null || str2.toLowerCase().contains("attachment")) {
                return false;
            }
        }
        return true;
    }

    public static boolean _a(String str, String str2, long j) {
        return (AdBaseConstants.MIME_APK.equals(str) || "application/octet-stream".equals(str)) || ((str2 != null && str2.toLowerCase().contains("attachment")) && ((j > 1048576L ? 1 : (j == 1048576L ? 0 : -1)) > 0));
    }
}
