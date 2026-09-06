package com.fancy;

import android.view.View;
import com.fancy.adsdk.lib.R;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _gr implements _ng._b {
    public final /* synthetic */ _nf _a;
    public final /* synthetic */ boolean _b;
    public final /* synthetic */ _gq _c;

    public class _a implements Runnable {
        public final /* synthetic */ _ok _a;
        public final /* synthetic */ View _b;
        public final /* synthetic */ float _c;
        public final /* synthetic */ float _d;
        public final /* synthetic */ float _e;
        public final /* synthetic */ double _f;
        public final /* synthetic */ float _g;

        public _a(_ok _okVar, View view, float f, float f2, float f3, double d, float f4) {
            this._a = _okVar;
            this._b = view;
            this._c = f;
            this._d = f2;
            this._e = f3;
            this._f = d;
            this._g = f4;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _ok _okVar = this._a;
            if (_okVar == null || _gr.this._a == null) {
                return;
            }
            _okVar._f = System.currentTimeMillis();
            _gr _grVar = _gr.this;
            _gq _gqVar = _grVar._c;
            View view = this._b;
            _nf _nfVar = _grVar._a;
            _gqVar._b(view, _nfVar._c, _oj._a(this._c, this._d, this._e, this._f, this._g, _nfVar._d), _gr.this._c._e);
        }
    }

    public _gr(_gq _gqVar, _nf _nfVar, boolean z) {
        this._c = _gqVar;
        this._a = _nfVar;
        this._b = z;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.fancy._ng._b
    public final void _a(float f, float f2, float f3, double d, float f4) {
        if (this._a == null) {
            _io._b(this._c._d);
            _ng._a(this._c._d);
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        _gq _gqVar = this._c;
        if (jCurrentTimeMillis - _gqVar._q < this._a._e) {
            return;
        }
        List<View> list = _gqVar._h;
        View view = (list == null || list.isEmpty()) ? null : _gqVar._h.get(0);
        if (view == null) {
            return;
        }
        _f _fVar = this._c._c;
        if (_m5._a(view, _fVar != null ? _fVar._U : 0.1f) && view.hasWindowFocus()) {
            if (!this._b) {
                _gq _gqVar2 = this._c;
                _nf _nfVar = this._a;
                _gqVar2._a(view, _nfVar._c, _oj._a(f, f2, f3, d, f4, _nfVar._d), this._c._e);
                this._c._v.set(true);
                return;
            }
            if (this._c._u.get()) {
                return;
            }
            this._c._u.set(true);
            _ok _okVar = new _ok(view);
            _okVar._c = System.currentTimeMillis();
            view.setTag(R.id.fancy_native_view_tag, _okVar);
            _fv._a.post(new _a(_okVar, view, f, f2, f3, d, f4));
        }
    }
}
