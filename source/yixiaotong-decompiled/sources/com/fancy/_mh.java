package com.fancy;

import android.content.DialogInterface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _mh implements DialogInterface.OnDismissListener {
    public final /* synthetic */ _me _a;

    public _mh(_me _meVar) {
        this._a = _meVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this._a._ad = null;
    }
}
