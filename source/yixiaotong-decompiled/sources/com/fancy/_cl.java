package com.fancy;

import android.os.Handler;
import android.os.Looper;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.doodle.Doodle;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _cl {
    public static final AtomicBoolean _a = new AtomicBoolean(false);
    public static volatile boolean _b = false;
    public static volatile boolean _c = false;
    public static final Object _d = new Object();

    public static void _a() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.fancy._cl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                _cl._c();
            }
        }, 1800L);
    }

    public static void _b() {
        if (!com.fancy.adsdk.lib.utils._a._h() || _c || _b) {
            return;
        }
        synchronized (_d) {
            if (!_c && !_b) {
                _c = true;
                try {
                    System.loadLibrary("fcplayer");
                    _b = true;
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static /* synthetic */ void _c() {
        try {
            _b();
            if (_b && _a.get()) {
                Doodle.checkConfigRevert(PtgAdSdk.getContext());
            }
        } catch (Throwable unused) {
        }
    }
}
