package com.fancy;

import android.content.Intent;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _lq {
    public com.fancy.adsdk.lib.helper.imp._a _a;
    public String _b;
    public String _c;
    public Map<String, Object> _d;

    public _lq(Intent intent) {
        _s _sVar = (_s) intent.getSerializableExtra("playerInfo");
        if (_sVar != null) {
            this._b = _sVar._a();
            this._c = _sVar._b();
            this._d = _sVar._c();
        }
    }
}
