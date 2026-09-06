package com.fancy;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _j9 {
    public String _a;
    public String _b;
    public boolean _c;

    public static class _a {
        public String _a;
        public String _b;
        public boolean _c;
    }

    public _j9(_a _aVar) {
        this._a = _aVar._a;
        this._b = _aVar._b;
        this._c = _aVar._c;
        if (TextUtils.isEmpty(this._a)) {
            throw new NullPointerException("播放地址为空");
        }
        _a(this._a);
    }

    public final void _a(String str) {
        this._a = str;
    }
}
