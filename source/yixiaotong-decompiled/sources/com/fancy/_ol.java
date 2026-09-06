package com.fancy;

import android.os.Handler;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ol implements Runnable {
    public final /* synthetic */ _om _a;

    public _ol(_om _omVar) {
        this._a = _omVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _om _omVar = this._a;
        Handler handler = _omVar._a;
        if (handler != null) {
            handler.removeCallbacks(_omVar);
        }
        _om _omVar2 = this._a;
        _cf _cfVar = _omVar2._c;
        if (_cfVar != null) {
            _cfVar._a._a(new _ce(_cfVar, _cfVar, _omVar2));
        }
    }
}
