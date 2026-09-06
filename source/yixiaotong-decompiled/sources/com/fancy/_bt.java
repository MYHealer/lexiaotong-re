package com.fancy;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _bt extends Handler {
    public final /* synthetic */ long _a = 1000;
    public final /* synthetic */ _bu._a _b;
    public final /* synthetic */ _bu _c;

    public _bt(_bu _buVar, _ny _nyVar) {
        this._c = _buVar;
        this._b = _nyVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 1) {
            _bu _buVar = this._c;
            long j = _buVar._b;
            if (j <= 0) {
                _buVar._c = false;
                _bu._a _aVar = this._b;
                if (_aVar != null) {
                    ((_ny) _aVar)._a();
                    return;
                }
                return;
            }
            long j2 = j - this._a;
            _buVar._b = j2;
            _bu._a _aVar2 = this._b;
            if (_aVar2 != null) {
                _nx _nxVar = ((_ny) _aVar2)._a;
                _nxVar._b = j2;
                TextView textView = _nxVar._e;
                if (textView != null) {
                    textView.setText(String.valueOf((j2 / 1000) + 1));
                }
            }
            sendEmptyMessageDelayed(1, this._a);
        }
    }
}
