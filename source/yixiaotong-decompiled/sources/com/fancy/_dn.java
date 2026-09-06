package com.fancy;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _dn implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ _do _a;

    public _dn(_do _doVar) {
        this._a = _doVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        if (this._a.getParent() != null) {
            if (this._a.getViewTreeObserver().isAlive()) {
                this._a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
            _do _doVar = this._a;
            _aq _aqVar = _doVar._J;
            if (_aqVar != null) {
                int width = _doVar.getWidth();
                this._a.getHeight();
                _aqVar._a(width);
            }
        }
    }
}
