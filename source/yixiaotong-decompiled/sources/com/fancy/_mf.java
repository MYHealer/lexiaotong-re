package com.fancy;

import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _mf implements Runnable {
    public final /* synthetic */ _me _a;

    public _mf(_me _meVar) {
        this._a = _meVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageView imageView = this._a._I;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }
}
