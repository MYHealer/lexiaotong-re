package com.fancy.adsdk.lib;

import android.content.Context;
import android.os.Looper;
import com.fancy._be;
import com.fancy._cf;
import com.fancy._cg;
import com.fancy._ck;
import com.fancy._g3;
import com.fancy._g4;
import com.fancy._hx;
import com.fancy._if;
import com.fancy._m1;
import com.fancy._ob;
import com.fancy._oc;
import com.fancy._ou;
import com.fancy._oz;
import com.fancy._p0;
import com.fancy._p2;
import com.fancy.adsdk.lib.interf.PtgCustomController;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.tracking.ActionTrackManager;
import com.fancy.adsdk.lib.utils.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _e implements _hx {
    public final AtomicBoolean _a = new AtomicBoolean(false);
    public final /* synthetic */ Context _b;
    public final /* synthetic */ _cf _c;
    public final /* synthetic */ com.fancy.adsdk.lib.provider._c _d;
    public final /* synthetic */ PtgAdNative _e;
    public final /* synthetic */ PtgSDKConfig _f;

    public _e(Context context, _cf _cfVar, com.fancy.adsdk.lib.provider._c _cVar, com.fancy.adsdk.lib.provider._b _bVar, PtgSDKConfig ptgSDKConfig) {
        this._b = context;
        this._c = _cfVar;
        this._d = _cVar;
        this._e = _bVar;
        this._f = ptgSDKConfig;
    }

    @Override // com.fancy._hx
    public final void _a(_cg _cgVar, _ck _ckVar) {
        PtgAdSdk.mergeCustomController();
        _a._a(this._b, this._c);
        _a._a(this._c);
        AtomicBoolean atomicBoolean = _p2._a;
        PtgCustomController ptgCustomController = PtgAdSdk.getConfig().getPtgCustomController();
        int fdRule = PtgAdSdk.getConfig().getFdRule();
        boolean z = ptgCustomController != null && ptgCustomController.isAllowSDKInstallList();
        if (fdRule <= 0 && !z) {
            com.fancy.adsdk.lib.utils._d._b(new _oz());
        } else if (Looper.getMainLooper() == Looper.myLooper()) {
            com.fancy.adsdk.lib.utils._d._b(new _p0(true));
        } else {
            _p2._b(_p2._a(true));
        }
        _if _ifVar = _if._f;
        HashMap map = this._d._a;
        Set setEmptySet = map == null ? Collections.emptySet() : map.keySet();
        _ifVar._c.clear();
        if (setEmptySet != null) {
            _ifVar._c.addAll(setEmptySet);
        }
        com.fancy.adsdk.lib.provider._c _cVar = this._d;
        _cVar.getClass();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(_cVar._b.values());
        _ifVar._d.clear();
        _ifVar._d.addAll(arrayList);
        if (this._a.compareAndSet(false, true)) {
            this._e.init(this._b);
            this._f.setInitEndTime();
            _ou _ouVar_a = _ou._a();
            long initTime = this._f.getInitTime();
            _m1 _m1Var = _ouVar_a._b;
            if (_m1Var != null) {
                _m1Var._a(initTime);
            } else {
                _m1 _m1Var2 = new _m1();
                _ouVar_a._b = _m1Var2;
                _m1Var2._a(initTime);
            }
            CopyOnWriteArraySet<String> copyOnWriteArraySet = _g4._h;
            _g4 _g4Var = _g4._b._a;
            _g4Var.getClass();
            int lin = PtgAdSdk.getConfig().getLin();
            _g4Var._a = PtgAdSdk.getConfig().getBlin() == 1;
            int delayLin = PtgAdSdk.config.getDelayLin();
            if (lin != 0 && !_g4Var._f) {
                _g4Var._g.removeCallbacksAndMessages(null);
                _g4Var._g.postDelayed(new _g3(_g4Var), ((long) delayLin) * 1000);
            }
            Context context = PtgAdSdk.getContext();
            if (PtgAdSdk.getConfig().getSlin() == 1) {
                com.fancy.adsdk.lib.utils._d._b.postDelayed(new com.fancy.adsdk.lib.utils._d._c(new _be(context)), ((long) PtgAdSdk.config.getDelayLin()) * 1000);
            }
            ActionTrackManager._a()._b();
            Context context2 = this._b;
            ArrayList arrayList2 = _oc._a;
            com.fancy.adsdk.lib.utils._d._b(new _ob(context2, _ckVar));
        }
    }

    @Override // com.fancy._hx
    public final void _a(String str) {
    }

    @Override // com.fancy._hx
    public final void _b(String str) {
    }

    @Override // com.fancy._hx
    public final void _c(String str) {
        Logger.e(str);
        _if _ifVar = _if._f;
        HashMap map = this._d._a;
        Set setEmptySet = map == null ? Collections.emptySet() : map.keySet();
        _ifVar._c.clear();
        if (setEmptySet != null) {
            _ifVar._c.addAll(setEmptySet);
        }
        com.fancy.adsdk.lib.provider._c _cVar = this._d;
        _cVar.getClass();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(_cVar._b.values());
        _ifVar._d.clear();
        _ifVar._d.addAll(arrayList);
    }
}
