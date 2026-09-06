package com.fancy;

import android.content.Context;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.doodle.Doodle;
import com.fancy.adsdk.lib.provider.arb.ArbitraryManger;
import com.fancy.adsdk.lib.utils.TextUtil;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _a9 {
    public static volatile int _a;
    public static volatile boolean _b;
    public static final _a _c = new _a();

    public class _a extends ThreadLocal<Integer> {
        @Override // java.lang.ThreadLocal
        public final Integer initialValue() {
            return 0;
        }
    }

    public static synchronized void _a(Context context, _u _uVar) {
        int iIntValue;
        if (context == null) {
            return;
        }
        if (_a != 0) {
            return;
        }
        _a = 1;
        try {
            if (_uVar._e) {
                _a = 0;
                Context context2 = PtgAdSdk.getContext();
                try {
                    _cl._b();
                    if (_cl._b) {
                        Doodle.imageUnload(context2, "", "");
                    }
                } catch (Throwable unused) {
                }
            }
            String str = _uVar._a;
            try {
                _cl._b();
                if (_cl._b && Doodle.isImageLoaded(str)) {
                    _a = 2;
                    if (_a == 1) {
                        _a = 0;
                    }
                    return;
                }
            } catch (Throwable unused2) {
            }
            _b(context, _uVar);
            iIntValue = _c.get().intValue();
            if (_a == 1) {
                _a = 0;
            }
        } catch (Throwable unused3) {
            try {
                _a = 3;
                if (_a == 1) {
                    iIntValue = -4;
                } else {
                    iIntValue = -4;
                }
            } catch (Throwable th) {
                if (_a == 1) {
                    _a = 0;
                }
                throw th;
            }
        }
        try {
            _aa._a(_uVar, _a, iIntValue);
        } catch (Throwable unused4) {
        }
    }

    public static boolean _a() {
        return _a == 2 && _b;
    }

    public static synchronized void _b(Context context, _u _uVar) {
        int iImagePreload;
        try {
            if (_uVar == null) {
                _c.set(110);
                _a = 0;
                return;
            }
            _b = _uVar._j;
            if (!_b) {
                _c.set(112);
            }
            File cacheFile = Doodle.getCacheFile(_uVar._b);
            if (cacheFile != null && cacheFile.exists()) {
                String str = _uVar._a;
                String path = cacheFile.getPath();
                String str2 = _uVar._c;
                if (!TextUtil.isEmpty(str) && !TextUtil.isEmpty(path)) {
                    if (_uVar._i > 0 && System.currentTimeMillis() >= _uVar._i) {
                        _c.set(111);
                        try {
                            _cl._b();
                            if (_cl._b) {
                                Doodle.imageUnload(context, str, "");
                            }
                        } catch (Throwable unused) {
                        }
                    } else {
                        ArbitraryManger.identifyPlatform();
                        try {
                            _cl._b();
                            iImagePreload = !_cl._b ? -3 : Doodle.imagePreload(context, str, path, str2);
                        } catch (Throwable unused2) {
                            iImagePreload = -4;
                        }
                        if (iImagePreload == 0) {
                            _c.set(0);
                            _a = 2;
                        } else {
                            _c.set(Integer.valueOf(iImagePreload));
                            _a = 3;
                        }
                    }
                    return;
                }
                _c.set(114);
                _a = 0;
                return;
            }
            _c.set(113);
            _a = 0;
        } catch (Throwable th) {
            throw th;
        }
    }

    public static void _a(Context context) {
        _u _uVar_b;
        if (_a == 0 && (_uVar_b = _ia._b()) != null && _uVar_b._g) {
            _a(context, _uVar_b);
        }
    }
}
