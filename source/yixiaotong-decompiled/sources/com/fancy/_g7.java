package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _g7 implements _hw {
    public _hw[] _a;

    public static class _b {
        public final _cg _a;
        public final _ck _b;

        public _b(_cg _cgVar, _ck _ckVar) {
            this._a = _cgVar;
            this._b = _ckVar;
        }
    }

    public _g7(_hw... _hwVarArr) {
        this._a = _hwVarArr;
    }

    public static _b _a(_g7 _g7Var, List list) {
        _g7Var.getClass();
        Iterator it = list.iterator();
        _b _bVar = null;
        long j = -1;
        while (it.hasNext()) {
            _b _bVar2 = (_b) it.next();
            String str = _bVar2._b._g;
            if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
                long jLongValue = Long.valueOf(str).longValue();
                if (jLongValue > j) {
                    _bVar = _bVar2;
                    j = jLongValue;
                } else {
                    Logger.d("Scrapped policy version " + str);
                }
            }
        }
        Logger.i("Apply policy version " + j);
        return _bVar;
    }

    @Override // com.fancy._hw
    public final void _a(_hx _hxVar) {
        _b(_hxVar);
    }

    @Override // com.fancy._hw
    public final void _b(_hx _hxVar) {
        AtomicInteger atomicInteger = new AtomicInteger(this._a.length);
        ArrayList arrayList = new ArrayList();
        for (_hw _hwVar : this._a) {
            _hwVar._a(new _a(atomicInteger, arrayList, _hxVar));
        }
    }

    public class _a implements _hx {
        public final /* synthetic */ AtomicInteger _a;
        public final /* synthetic */ List _b;
        public final /* synthetic */ _hx _c;

        public _a(AtomicInteger atomicInteger, ArrayList arrayList, _hx _hxVar) {
            this._a = atomicInteger;
            this._b = arrayList;
            this._c = _hxVar;
        }

        @Override // com.fancy._hx
        public final void _a(String str) {
            _b _bVar_a;
            _ck _ckVar;
            if (this._a.get() != 0 || this._c == null || (_bVar_a = _g7._a(_g7.this, this._b)) == null || (_ckVar = _bVar_a._b) == null || TextUtils.isEmpty(_ckVar._a)) {
                return;
            }
            this._c._a(_bVar_a._b._a);
        }

        @Override // com.fancy._hx
        public final void _b(String str) {
            _b _bVar_a;
            _cg _cgVar;
            if (this._a.get() != 0 || this._c == null || (_bVar_a = _g7._a(_g7.this, this._b)) == null || (_cgVar = _bVar_a._a) == null || TextUtils.isEmpty(_cgVar._f)) {
                return;
            }
            this._c._b(_bVar_a._a._f);
        }

        @Override // com.fancy._hx
        public final void _c(String str) {
            int iDecrementAndGet = this._a.decrementAndGet();
            Logger.e("Policy filtering error " + str);
            if (iDecrementAndGet == 0) {
                _b _bVar_a = _g7._a(_g7.this, this._b);
                if (_bVar_a == null) {
                    Logger.d("Complete policy filtering, not find Policy");
                    _hx _hxVar = this._c;
                    if (_hxVar != null) {
                        _hxVar._c("Complete policy filtering, not find Policy");
                        return;
                    }
                    return;
                }
                _ck _ckVar = _bVar_a._b;
                Logger.d("Complete policy filtering, find policy " + (_ckVar == null ? "null" : _ckVar._g));
                _hx _hxVar2 = this._c;
                if (_hxVar2 != null) {
                    _hxVar2._a(_bVar_a._a, _bVar_a._b);
                }
            }
        }

        @Override // com.fancy._hx
        public final void _a(_cg _cgVar, _ck _ckVar) {
            int iDecrementAndGet = this._a.decrementAndGet();
            if (_ckVar != null) {
                this._b.add(new _b(_cgVar, _ckVar));
            }
            if (iDecrementAndGet == 0) {
                _b _bVar_a = _g7._a(_g7.this, this._b);
                if (_bVar_a == null) {
                    Logger.d("Complete policy filtering, not find Policy");
                    _hx _hxVar = this._c;
                    if (_hxVar != null) {
                        _hxVar._c("MultiplePolicyLoader 未发现合适的 Policy");
                        return;
                    }
                    return;
                }
                _ck _ckVar2 = _bVar_a._b;
                Logger.d("Complete policy filtering, find policy " + (_ckVar2 == null ? "null" : _ckVar2._g));
                _hx _hxVar2 = this._c;
                if (_hxVar2 != null) {
                    _hxVar2._a(_bVar_a._a, _bVar_a._b);
                }
            }
        }
    }
}
