package com.fancy;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ih {
    public final ConcurrentHashMap _a = new ConcurrentHashMap();

    public interface _a {
        void _a();

        void _b();
    }

    public static class _b {
        public static final _ih _a = new _ih();
    }

    public final void _a(String str, _a _aVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this._a) {
            String str_c = com.fancy.adsdk.lib.utils._a._c(str);
            if (!this._a.containsKey(str_c)) {
                this._a.put(str_c, Boolean.TRUE);
                try {
                    _ev._a(str, new _ig(_aVar));
                } catch (Exception unused) {
                    if (_aVar != null) {
                        _aVar._a();
                    }
                }
            } else if (_aVar != null) {
                _aVar._b();
            }
        }
    }
}
