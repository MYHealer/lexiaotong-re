package com.fancy;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.doodle.Doodle;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ia {
    public static long _a;

    public class _a implements Runnable {
        public final /* synthetic */ _u _a;

        public _a(_u _uVar) {
            this._a = _uVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _u _uVar = this._a;
            if (_uVar == null) {
                return;
            }
            try {
                String str = _uVar._b;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                File cacheFile = null;
                try {
                    try {
                        cacheFile = Doodle.getCacheFile(str);
                        if (cacheFile == null || !cacheFile.exists()) {
                            cacheFile = Doodle.downloadOnly(str);
                        } else {
                            cacheFile.getPath();
                        }
                        if (cacheFile != null && cacheFile.exists()) {
                            cacheFile.getPath();
                            _a9._b(PtgAdSdk.getContext(), this._a);
                        }
                        if (this._a._h) {
                            return;
                        }
                        try {
                            Doodle.clearCache(str);
                        } catch (Exception unused) {
                        }
                        if (cacheFile == null) {
                            return;
                        }
                        cacheFile.delete();
                    } catch (Throwable th) {
                        if (!this._a._h) {
                            try {
                                Doodle.clearCache(str);
                            } catch (Exception unused2) {
                            }
                            if (cacheFile != null) {
                                try {
                                    cacheFile.delete();
                                } catch (Exception unused3) {
                                }
                            }
                        }
                        throw th;
                    }
                } catch (Exception e) {
                    e.getMessage();
                    if (this._a._h) {
                        return;
                    }
                    try {
                        Doodle.clearCache(str);
                    } catch (Exception unused4) {
                    }
                    if (cacheFile == null) {
                    }
                }
            } catch (Exception unused5) {
            }
        }
    }

    public static void _a() {
        try {
            Context context = PtgAdSdk.getContext();
            ConcurrentHashMap<String, SharedPreferences> concurrentHashMap = _kr._a;
            if (context != null) {
                ConcurrentHashMap concurrentHashMap2 = _kr._b;
                if (concurrentHashMap2.containsKey("fancy_sdk_config")) {
                    ((Map) concurrentHashMap2.get("fancy_sdk_config")).remove("ptg_pre_img");
                }
                SharedPreferences sharedPreferences_c = _kr._c(context, "fancy_sdk_config");
                if (sharedPreferences_c == null) {
                    return;
                }
                try {
                    sharedPreferences_c.edit().remove("ptg_pre_img").commit();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        } catch (Exception e2) {
            e2.getMessage();
        }
    }

    public static _u _b() {
        String str_d = _kr._d(PtgAdSdk.getContext(), "ptg_pre_img");
        if (str_d != null && !str_d.isEmpty()) {
            try {
                String str_a = _n5._a(str_d);
                if (str_a.isEmpty()) {
                    return null;
                }
                return _u._a(new JSONObject(str_a));
            } catch (Exception e) {
                e.getMessage();
                _a();
            }
        }
        return null;
    }

    public static void _a(_u _uVar) {
        if (_uVar == null) {
            _a();
            return;
        }
        if (_uVar._h) {
            try {
                _kr._a(PtgAdSdk.getContext(), "ptg_pre_img", _n5._b(_uVar._m));
            } catch (Exception e) {
                e.getMessage();
            }
        } else {
            _a();
        }
        if (_uVar._e) {
            Context context = PtgAdSdk.getContext();
            try {
                _cl._b();
                if (_cl._b) {
                    Doodle.imageUnload(context, "", "");
                }
            } catch (Throwable unused) {
            }
        }
        boolean z = _uVar._j;
        synchronized (_a9.class) {
            _a9._b = z;
        }
        String str = _uVar._a;
        try {
            _cl._b();
            if (_cl._b && Doodle.isImageLoaded(str)) {
                return;
            }
        } catch (Throwable unused2) {
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jMax = Math.max(_uVar._d, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        long j = _a;
        if (j <= 0 || jCurrentTimeMillis - j >= jMax) {
            _a = jCurrentTimeMillis;
            com.fancy.adsdk.lib.utils._d._b(new _a(_uVar));
        }
    }
}
