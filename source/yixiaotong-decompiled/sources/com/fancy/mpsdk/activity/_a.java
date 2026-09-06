package com.fancy.mpsdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.fancy._f;
import com.fancy._fg;
import com.fancy._fi;
import com.fancy.adsdk.lib.model.AdSlot;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _a implements PtgInteractionPortraitActivity._c {
    public final /* synthetic */ Activity _a;
    public final /* synthetic */ _f _b;
    public final /* synthetic */ AdSlot _c;

    public _a(Activity activity, _f _fVar, AdSlot adSlot) {
        this._a = activity;
        this._b = _fVar;
        this._c = adSlot;
    }

    public final void _a() {
        _f _fVar;
        if (this._a == null || (_fVar = this._b) == null || this._c == null) {
            return;
        }
        _fi _fiVar = _fVar._F;
        _fg _fgVar_a = _fg._a();
        String strValueOf = String.valueOf(this._b.hashCode());
        _f _fVar2 = this._b;
        AdSlot adSlot = this._c;
        _fgVar_a.getClass();
        if (!TextUtils.isEmpty(strValueOf)) {
            if (_fiVar != null) {
                _fgVar_a._a.putIfAbsent(strValueOf, _fiVar);
            }
            _fgVar_a._b.putIfAbsent(strValueOf, _fVar2);
            _fgVar_a._c.putIfAbsent(strValueOf, adSlot);
        }
        Intent intent = new Intent(this._a, (Class<?>) PtgInteractionPortraitActivity.class);
        if (_fiVar != null && _fiVar._a == 1) {
            intent = new Intent(this._a, (Class<?>) PtgInteractionLandscapeActivity.class);
        }
        intent.setFlags(268435456);
        intent.putExtra("advert_hash_code_key", String.valueOf(this._b.hashCode()));
        this._a.startActivity(intent);
    }
}
