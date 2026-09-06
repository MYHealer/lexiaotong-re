package com.fancy;

import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _gb implements View.OnClickListener {
    public final /* synthetic */ _gc _a;

    public _gb(_do _doVar) {
        this._a = _doVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2;
        _gc _gcVar = this._a;
        if (!_gcVar._w.get() && _gcVar._n && _io._a(_gcVar._e)) {
            this._a._w.set(true);
            List<View> advertViews = this._a.getAdvertViews();
            if (advertViews == null || advertViews.isEmpty() || (view2 = advertViews.get(0)) == null || !view2.hasWindowFocus()) {
                return;
            }
            _p5._a(view2, 4);
        }
    }
}
