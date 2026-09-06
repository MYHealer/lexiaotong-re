package com.fancy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _jk implements Runnable {
    public final /* synthetic */ _bg _a;

    public _jk(_bg _bgVar) {
        this._a = _bgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        _bg _bgVar = this._a;
        if (_bgVar != null) {
            _bgVar._a();
        }
    }
}
