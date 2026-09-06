package com.fancy;

import android.content.SharedPreferences;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.utils.ot.LruDiskUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _nh implements _hx {
    public final /* synthetic */ boolean _a = true;
    public final /* synthetic */ _hx _b;

    public _nh(_hx _hxVar) {
        this._b = _hxVar;
    }

    @Override // com.fancy._hx
    public final void _a(_cg _cgVar, _ck _ckVar) {
        if (this._a) {
            this._b._a(_cgVar, _ckVar);
        }
    }

    @Override // com.fancy._hx
    public final void _a(String str) {
        if (this._a) {
            this._b._a(str);
        }
    }

    @Override // com.fancy._hx
    public final void _b(String str) {
        ConcurrentHashMap<String, SharedPreferences> concurrentHashMap = _kr._a;
        _kr._a(PtgAdSdk.getContext(), "c_u_t", System.currentTimeMillis());
        LruDiskUtils.get(PtgAdSdk.getContext()).put(LruDiskUtils.CACHE_CONFIG_KEY, str);
        if (this._a) {
            this._b._b(str);
        }
    }

    @Override // com.fancy._hx
    public final void _c(String str) {
        if (this._a) {
            this._b._c(str);
        }
    }
}
