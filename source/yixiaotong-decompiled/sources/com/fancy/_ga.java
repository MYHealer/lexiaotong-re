package com.fancy;

import android.graphics.Rect;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ga implements ViewTreeObserver.OnScrollChangedListener {
    public long _a = 0;
    public final /* synthetic */ _gc _b;

    public _ga(_gc _gcVar) {
        this._b = _gcVar;
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        if (System.currentTimeMillis() - this._a < 200) {
            return;
        }
        this._a = System.currentTimeMillis();
        Rect rect = new Rect();
        boolean globalVisibleRect = this._b.getGlobalVisibleRect(rect);
        _gc _gcVar = this._b;
        if (_gcVar._u != globalVisibleRect) {
            _gcVar._u = _gcVar.getGlobalVisibleRect(rect);
            _gc _gcVar2 = this._b;
            this._b._a(_gcVar2._u ? _gcVar2.getWindowVisibility() : 8);
        }
    }
}
