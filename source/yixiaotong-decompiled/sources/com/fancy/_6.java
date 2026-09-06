package com.fancy;

import android.content.DialogInterface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _6 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ DialogInterface.OnClickListener _a;

    public _6(_cw _cwVar) {
        this._a = _cwVar;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        _9._a = null;
        DialogInterface.OnClickListener onClickListener = this._a;
        if (onClickListener != null) {
            onClickListener.onClick(null, -2);
        }
    }
}
