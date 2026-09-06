package com.fancy;

import android.content.DialogInterface;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _co implements View.OnClickListener {
    public final /* synthetic */ _cp _a;

    public _co(_cp _cpVar) {
        this._a = _cpVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        DialogInterface.OnClickListener onClickListener;
        this._a.dismiss();
        _cp._a _aVar = this._a._g;
        if (_aVar == null || (onClickListener = ((_7) _aVar)._a) == null) {
            return;
        }
        onClickListener.onClick(null, -1);
    }
}
