package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.tracking.ActionTrackManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _d implements Runnable {
    public final /* synthetic */ ActionTrackManager _a;

    public _d(ActionTrackManager actionTrackManager) {
        this._a = actionTrackManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = _if._f._a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str_a = _hr._a(str.replace("__ACTION__", "launchApp").replace("__DATA__", com.fancy.adsdk.lib.utils._a._b("{}")), ActionTrackManager._a(this._a));
        _ou _ouVar_a = _ou._a();
        _m1 _m1Var = _ouVar_a._b;
        if (_m1Var != null) {
            _m1Var._a(str_a);
            return;
        }
        _m1 _m1Var2 = new _m1();
        _ouVar_a._b = _m1Var2;
        _m1Var2._a(str_a);
    }
}
