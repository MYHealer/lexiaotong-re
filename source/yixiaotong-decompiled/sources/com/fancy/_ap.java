package com.fancy;

import android.content.Context;
import android.widget.LinearLayout;
import com.fancy.adsdk.lib.model.AdSlot;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class _ap extends LinearLayout implements _am {
    public _v _a;
    public AdSlot _b;

    public _ap(Context context) {
        super(context);
        _a(context);
    }

    public abstract void _a(Context context);

    @Override // com.fancy._am
    public final boolean _a() {
        return !hasWindowFocus();
    }

    @Override // com.fancy._am
    public final boolean _b() {
        return _fl._a(getContext());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public abstract void setAd(_f _fVar);

    public void setAdClickListener(_h _hVar) {
    }

    public void setAdRenderListener(_v _vVar) {
        this._a = _vVar;
    }

    public void setAdvertSlot(AdSlot adSlot) {
        this._b = adSlot;
    }

    public abstract /* synthetic */ void setVisibilityChanged(_an._a _aVar);
}
