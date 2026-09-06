package com.fancy;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.fancy.adsdk.lib.interf.PtgVideoAdListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public abstract class _an extends LinearLayout implements _am {
    public View _a;
    public _h _b;
    public _v _c;
    public PtgVideoAdListener _d;
    public _a _e;

    public interface _a {
    }

    public _an(Context context) {
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

    public void _c() {
        this._b = null;
        this._c = null;
        this._e = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        _o8 _o8Var;
        Context context;
        _f _fVar;
        _am _amVar;
        LinearLayout linearLayout;
        _h _hVar;
        String str;
        _i _iVar;
        long j;
        boolean z;
        super.onWindowVisibilityChanged(i);
        _a _aVar = this._e;
        if (_aVar != null) {
            _o5 _o5Var = (_o5) _aVar;
            if (i != 0) {
                _ng._a(_o5Var._g);
                return;
            }
            if (_o5Var._i._a(_o5Var._a)) {
                _o8Var = _o5Var._i;
                z = true;
                if (1 != _o8Var._e) {
                    return;
                }
                context = _o5Var._b;
                _fVar = _o5Var._c;
                _amVar = _o5Var._d;
                linearLayout = _o5Var._e;
                _hVar = _o5Var._f;
                str = _o5Var._g;
                _iVar = _o5Var._a;
                j = _o5Var._h;
            } else {
                _o8Var = _o5Var._i;
                if (!_o8Var._f && !_o8Var._d) {
                    return;
                }
                context = _o5Var._b;
                _fVar = _o5Var._c;
                _amVar = _o5Var._d;
                linearLayout = _o5Var._e;
                _hVar = _o5Var._f;
                str = _o5Var._g;
                _iVar = _o5Var._a;
                j = _o5Var._h;
                z = false;
            }
            LinearLayout linearLayout2 = linearLayout;
            long j2 = j;
            _nf _nfVar_a = _nf._a(str, z, _iVar);
            _ng._a(context, new _o6(_o8Var, linearLayout2, _nfVar_a, j2, _amVar, _fVar, str, _iVar, z, _hVar), _nfVar_a);
        }
    }

    public abstract void setAd(_f _fVar);

    public void setAdClickListener(_h _hVar) {
        this._b = _hVar;
    }

    public void setAdRenderListener(_v _vVar) {
        this._c = _vVar;
    }

    public void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener) {
        this._d = ptgVideoAdListener;
    }

    public void setVisibilityChanged(_a _aVar) {
        this._e = _aVar;
    }
}
