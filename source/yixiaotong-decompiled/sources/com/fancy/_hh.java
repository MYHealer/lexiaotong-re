package com.fancy;

import android.view.Window;
import org.videolan.libvlc.MediaDiscoverer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _hh {
    public static volatile _hh _a;

    public static _hh _a() {
        if (_a == null) {
            synchronized (_hh.class) {
                if (_a == null) {
                    _a = new _hh();
                }
            }
        }
        return _a;
    }

    public static boolean _a(Window window) {
        if (window == null) {
            return false;
        }
        window.clearFlags(201326592);
        window.getDecorView().setSystemUiVisibility(MediaDiscoverer.Event.Started);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
        return true;
    }
}
