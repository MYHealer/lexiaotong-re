package com.fancy.adsdk.lib.provider;

import android.content.Context;
import com.alipay.sdk.data.a;
import com.fancy._a9;
import com.fancy._ae;
import com.fancy._ak;
import com.fancy._av;
import com.fancy._bh;
import com.fancy._bi;
import com.fancy._bj;
import com.fancy._bk;
import com.fancy._bl;
import com.fancy._ca;
import com.fancy._cf;
import com.fancy._ch;
import com.fancy._ci;
import com.fancy._d7;
import com.fancy._d8;
import com.fancy._em;
import com.fancy._f3;
import com.fancy._f4;
import com.fancy._ge;
import com.fancy._gf;
import com.fancy._ie;
import com.fancy._jj;
import com.fancy._jt;
import com.fancy._l1;
import com.fancy._ma;
import com.fancy._mb;
import com.fancy._n9;
import com.fancy._na;
import com.fancy._nb;
import com.fancy._nc;
import com.fancy._nd;
import com.fancy._ne;
import com.fancy._no;
import com.fancy._np;
import com.fancy._oi;
import com.fancy._pi;
import com.fancy._pj;
import com.fancy._pk;
import com.fancy._x;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.Error;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.provider.arb.ArbitraryManger;
import com.fancy.adsdk.lib.utils.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _c implements PtgAdNative {
    public static final _l1 _d = new _l1(null);
    public static final Random _e = new Random();
    public HashMap _a = new HashMap();
    public HashMap _b = new HashMap();
    public _cf _c;

    public class _a implements _ca._c {
        public final /* synthetic */ AdSlot _a;
        public final /* synthetic */ PtgAdNative.SplashAdListener _b;
        public final /* synthetic */ Context _c;

        /* JADX INFO: renamed from: com.fancy.adsdk.lib.provider._c$_a$_a, reason: collision with other inner class name */
        public class C0374_a implements _em<AdSlot, _np> {
            public C0374_a() {
            }

            @Override // com.fancy._em
            public final void _a(Object obj, _ch _chVar, Error error) {
                AdSlot adSlot = (AdSlot) obj;
                _np _npVar = (_np) error;
                _a _aVar = _a.this;
                _c _cVar = _c.this;
                Context context = _aVar._c;
                _l1 _l1Var = _c._d;
                _cVar.getClass();
                try {
                    ArrayList<_ci> arrayList = _chVar._c;
                    int i = 6;
                    if (1 == arrayList.size()) {
                        adSlot._b();
                        adSlot._a((_ci) arrayList.get(0));
                        adSlot.setCodeID(adSlot._i()._e());
                        adSlot._a(6);
                        if (adSlot.getTimeoutMs() < 500) {
                            adSlot.setTimeoutMs(a.f1633a);
                        }
                        _cVar._a(adSlot._i()).loadSplashAd(context, adSlot._b(adSlot._i()), new _j(_npVar, _npVar, adSlot));
                        return;
                    }
                    String str = ", weight == 0";
                    String str2 = "abandon splash request, consumer == ";
                    if (!_chVar._d) {
                        _jt _jtVar = new _jt(_chVar._e, _chVar._b);
                        for (_ci _ciVar : arrayList) {
                            AdSlot adSlot_a = _jt._a(context, adSlot, _ciVar);
                            adSlot_a._a(6);
                            if (_jt._a(adSlot_a, _chVar, _ciVar)) {
                                _jtVar._a(new _ne(_jtVar, _ciVar, _cVar._a(_ciVar), context, adSlot_a, adSlot_a._s(), adSlot_a._a(), _npVar._a));
                                str2 = str2;
                                str = str;
                            } else {
                                Logger.d(str2 + _ciVar._c + str);
                            }
                        }
                        _jtVar._b();
                        return;
                    }
                    adSlot._o();
                    _jj _jjVar = new _jj(_chVar, _npVar);
                    AtomicInteger atomicInteger = new AtomicInteger();
                    ArrayList arrayList2 = new ArrayList();
                    for (_ci _ciVar2 : arrayList) {
                        AdSlot adSlot_a2 = _jj._a(context, adSlot, _ciVar2);
                        adSlot_a2._a(i);
                        if (_jj._a(adSlot_a2, _chVar, _ciVar2)) {
                            adSlot_a2._k();
                            _bl _blVar = new _bl(_jjVar._b, adSlot_a2._i(), adSlot._a(), adSlot_a2._a(), atomicInteger, _npVar._a);
                            _jjVar._a.add(_blVar);
                            _blVar._h();
                            _ciVar2.getClass();
                            ArrayList arrayList3 = arrayList2;
                            arrayList3.add(new _k(_cVar, _ciVar2, context, adSlot_a2, _blVar));
                            arrayList2 = arrayList3;
                            i = 6;
                        } else {
                            Logger.d("abandon splash request, consumer == " + _ciVar2._c + ", weight == 0");
                        }
                    }
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    _jjVar._a();
                    _jjVar._b();
                } catch (Exception e) {
                    Logger.e(_ie._a("loadSplashAd 失败，").append(e.getMessage()).toString());
                    _npVar.onError(new AdErrorImpl(10011, _ie._a("loadSplashAd 失败，").append(e.getMessage()).toString(), (Object) null));
                }
            }
        }

        public _a(AdSlot adSlot, PtgAdNative.SplashAdListener splashAdListener, Context context) {
            this._a = adSlot;
            this._b = splashAdListener;
            this._c = context;
        }

        @Override // com.fancy._ca._c
        public final void _a() {
            _pi _piVar = _pi._e;
            if (!_piVar._a(this._a)) {
                _x _xVar_a = _piVar._b(this._a)._a(new _pk())._a(new _pj());
                _xVar_a._p = System.currentTimeMillis();
                _xVar_a._q = _c._e.nextInt(100);
                this._a._a(_ca._c());
                this._a._a(_xVar_a._p);
                this._a._b(_xVar_a._q);
                if (_a9._a()) {
                    this._a._b(System.currentTimeMillis());
                    this._a._a(ArbitraryManger.getId(this._b));
                }
            }
            _no._a(_c.this._c, this._a, this._b, new C0374_a());
        }
    }

    public class _b implements _ca._c {
        public final /* synthetic */ AdSlot _a;
        public final /* synthetic */ PtgAdNative.NativeExpressAdListener _b;
        public final /* synthetic */ Context _c;

        public class _a implements _em<AdSlot, _gf> {
            public _a() {
            }

            @Override // com.fancy._em
            public final void _a(Object obj, _ch _chVar, Error error) {
                AdSlot adSlot = (AdSlot) obj;
                _gf _gfVar = (_gf) error;
                _b _bVar = _b.this;
                _c _cVar = _c.this;
                Context context = _bVar._c;
                _l1 _l1Var = _c._d;
                _cVar.getClass();
                try {
                    ArrayList<_ci> arrayList = _chVar._c;
                    int i = 5;
                    if (1 == arrayList.size()) {
                        adSlot._b();
                        adSlot._a((_ci) arrayList.get(0));
                        adSlot.setCodeID(adSlot._i()._e());
                        adSlot._a(5);
                        if (adSlot.getTimeoutMs() < 500) {
                            adSlot.setTimeoutMs(a.f1633a);
                        }
                        _ci _ciVar_i = adSlot._i();
                        _cVar._a(_ciVar_i).loadBannerExpressAd(context, adSlot._b(_ciVar_i), new com.fancy.adsdk.lib.provider._d(_gfVar, adSlot));
                        return;
                    }
                    String str = ", weight == 0";
                    if (!_chVar._d) {
                        _jt _jtVar = new _jt(_chVar._e, _chVar._b);
                        for (_ci _ciVar : arrayList) {
                            AdSlot adSlot_a = _jt._a(context, adSlot, _ciVar);
                            adSlot_a._a(5);
                            if (_jt._a(adSlot_a, _chVar, _ciVar)) {
                                _jtVar._a(new _n9(_jtVar, _ciVar, _cVar._a(_ciVar), context, adSlot_a, _gfVar._a));
                                str = str;
                            } else {
                                Logger.d("abandon nativeExpressAd request, consumer == " + _ciVar._c + str);
                            }
                        }
                        _jtVar._b();
                        return;
                    }
                    adSlot._o();
                    _jj _jjVar = new _jj(_chVar, _gfVar);
                    AtomicInteger atomicInteger = new AtomicInteger();
                    ArrayList arrayList2 = new ArrayList();
                    for (_ci _ciVar2 : arrayList) {
                        AdSlot adSlot_a2 = _jj._a(context, adSlot, _ciVar2);
                        adSlot_a2._a(i);
                        if (_jj._a(adSlot_a2, _chVar, _ciVar2)) {
                            adSlot_a2._k();
                            _bj _bjVar = new _bj(_jjVar._b, adSlot_a2._i(), atomicInteger, _gfVar._a);
                            _jjVar._a.add(_bjVar);
                            _bjVar._h();
                            ArrayList arrayList3 = arrayList2;
                            arrayList3.add(new com.fancy.adsdk.lib.provider._e(_cVar, _ciVar2, context, adSlot_a2, _bjVar));
                            arrayList2 = arrayList3;
                            i = 5;
                        } else {
                            Logger.d("abandon banner request, consumer == " + _ciVar2._c + ", weight == 0");
                        }
                    }
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    _jjVar._a();
                    _jjVar._b();
                } catch (Exception e) {
                    Logger.e(_ie._a("loadBannerExpressAd 失败，").append(e.getMessage()).toString());
                    _gfVar.onError(new AdErrorImpl(10011, _ie._a("loadBannerExpressAd 失败，").append(e.getMessage()).toString(), (Object) null));
                }
            }
        }

        public _b(AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener, Context context) {
            this._a = adSlot;
            this._b = nativeExpressAdListener;
            this._c = context;
        }

        @Override // com.fancy._ca._c
        public final void _a() {
            _pi _piVar = _pi._e;
            if (!_piVar._a(this._a)) {
                _x _xVar_a = _piVar._b(this._a)._a(new _pk())._a(new _pj());
                _xVar_a._p = System.currentTimeMillis();
                _xVar_a._q = _c._e.nextInt(100);
                this._a._a(_ca._c());
                this._a._a(_xVar_a._p);
                this._a._b(_xVar_a._q);
                if (_a9._a()) {
                    this._a._b(System.currentTimeMillis());
                    this._a._a(ArbitraryManger.getId(this._b));
                }
            }
            _cf _cfVar = _c.this._c;
            AdSlot adSlot = this._a;
            PtgAdNative.NativeExpressAdListener nativeExpressAdListener = this._b;
            _a _aVar = new _a();
            _gf _gfVar = new _gf(new _ae(_cfVar, adSlot, nativeExpressAdListener, _aVar));
            _ch _chVar_a = _ak._a(_cfVar, adSlot, _gfVar);
            if (_chVar_a == null) {
                return;
            }
            Logger.d("LAYER_REQUEST", _ie._a("start req ... layer: ").append(adSlot._e()).toString());
            _aVar._a(adSlot, _chVar_a, _gfVar);
        }
    }

    /* JADX INFO: renamed from: com.fancy.adsdk.lib.provider._c$_c, reason: collision with other inner class name */
    public class C0375_c implements _ca._c {
        public final /* synthetic */ AdSlot _a;
        public final /* synthetic */ PtgAdNative.InteractionExpressAdListener _b;
        public final /* synthetic */ Context _c;

        /* JADX INFO: renamed from: com.fancy.adsdk.lib.provider._c$_c$_a */
        public class _a implements _em<AdSlot, _f4> {
            public _a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r24v5 */
            /* JADX WARN: Type inference failed for: r24v6 */
            /* JADX WARN: Type inference failed for: r24v7 */
            /* JADX WARN: Type inference failed for: r24v8 */
            /* JADX WARN: Type inference failed for: r9v0 */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.fancy._f4] */
            /* JADX WARN: Type inference failed for: r9v10, types: [com.fancy._f4] */
            /* JADX WARN: Type inference failed for: r9v2 */
            /* JADX WARN: Type inference failed for: r9v8 */
            /* JADX WARN: Type inference failed for: r9v9 */
            @Override // com.fancy._em
            public final void _a(Object obj, _ch _chVar, Error error) {
                ?? r9;
                AdSlot adSlot = (AdSlot) obj;
                _f4 _f4Var = (_f4) error;
                C0375_c c0375_c = C0375_c.this;
                _c _cVar = _c.this;
                Context context = c0375_c._c;
                _l1 _l1Var = _c._d;
                _cVar.getClass();
                try {
                    ArrayList<_ci> arrayList = _chVar._c;
                    int i = 7;
                    if (1 == arrayList.size()) {
                        adSlot._b();
                        adSlot._a((_ci) arrayList.get(0));
                        adSlot.setCodeID(adSlot._i()._e());
                        adSlot._a(7);
                        if (adSlot.getTimeoutMs() < 500) {
                            adSlot.setTimeoutMs(a.f1633a);
                        }
                        _ci _ciVar_i = adSlot._i();
                        _cVar._a(_ciVar_i).loadInteractionExpressAd(context, adSlot._b(_ciVar_i), new com.fancy.adsdk.lib.provider._f(_f4Var, adSlot));
                        return;
                    }
                    String str = ", weight == 0";
                    String str2 = "abandon interaction ad request, consumer == ";
                    try {
                        if (!_chVar._d) {
                            ?? r24 = _f4Var;
                            _jt _jtVar = new _jt(_chVar._e, _chVar._b);
                            for (_ci _ciVar : arrayList) {
                                AdSlot adSlot_a = _jt._a(context, adSlot, _ciVar);
                                adSlot_a._a(7);
                                if (_jt._a(adSlot_a, _chVar, _ciVar)) {
                                    r9 = r24;
                                    try {
                                        _jtVar._a(new _nb(_jtVar, _ciVar, _cVar._a(_ciVar), context, adSlot_a, r9._a));
                                        r24 = r9;
                                        str2 = str2;
                                        str = str;
                                    } catch (Exception e) {
                                        e = e;
                                        Logger.e(_ie._a("loadInteractionExpressAd 失败，").append(e.getMessage()).toString());
                                        r9.onError(new AdErrorImpl(10011, _ie._a("loadInteractionExpressAd 失败，").append(e.getMessage()).toString(), (Object) null));
                                    }
                                } else {
                                    Logger.d(str2 + _ciVar._c + str);
                                }
                            }
                            r9 = r24;
                            _jtVar._b();
                            return;
                        }
                        try {
                            adSlot._o();
                            _jj _jjVar = new _jj(_chVar, _f4Var);
                            AtomicInteger atomicInteger = new AtomicInteger();
                            ArrayList arrayList2 = new ArrayList();
                            for (_ci _ciVar2 : arrayList) {
                                AdSlot adSlot_a2 = _jj._a(context, adSlot, _ciVar2);
                                adSlot_a2._a(i);
                                if (_jj._a(adSlot_a2, _chVar, _ciVar2)) {
                                    adSlot_a2._k();
                                    _bi _biVar = new _bi(_jjVar._b, adSlot_a2._i(), atomicInteger, _f4Var._a);
                                    _jjVar._a.add(_biVar);
                                    _biVar._h();
                                    _f4 _f4Var2 = _f4Var;
                                    ArrayList arrayList3 = arrayList2;
                                    AtomicInteger atomicInteger2 = atomicInteger;
                                    arrayList3.add(new _g(_cVar, _ciVar2, context, adSlot_a2, _biVar));
                                    arrayList2 = arrayList3;
                                    atomicInteger = atomicInteger2;
                                    i = 7;
                                    _f4Var = _f4Var2;
                                } else {
                                    Logger.d("abandon interaction ad request, consumer == " + _ciVar2._c + ", weight == 0");
                                }
                            }
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                ((Runnable) it.next()).run();
                            }
                            _jjVar._a();
                            _jjVar._b();
                        } catch (Exception e2) {
                            e = e2;
                            error = _f4Var;
                            r9 = error;
                            Logger.e(_ie._a("loadInteractionExpressAd 失败，").append(e.getMessage()).toString());
                            r9.onError(new AdErrorImpl(10011, _ie._a("loadInteractionExpressAd 失败，").append(e.getMessage()).toString(), (Object) null));
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Exception e4) {
                    e = e4;
                    r9 = _f4Var;
                }
            }
        }

        public C0375_c(AdSlot adSlot, PtgAdNative.InteractionExpressAdListener interactionExpressAdListener, Context context) {
            this._a = adSlot;
            this._b = interactionExpressAdListener;
            this._c = context;
        }

        @Override // com.fancy._ca._c
        public final void _a() {
            _pi _piVar = _pi._e;
            if (!_piVar._a(this._a)) {
                _x _xVar_a = _piVar._b(this._a)._a(new _pk())._a(new _pj());
                _xVar_a._p = System.currentTimeMillis();
                _xVar_a._q = _c._e.nextInt(100);
                this._a._a(_ca._c());
                this._a._a(_xVar_a._p);
                this._a._b(_xVar_a._q);
                if (_a9._a()) {
                    this._a._b(System.currentTimeMillis());
                    this._a._a(ArbitraryManger.getId(this._b));
                }
            }
            _cf _cfVar = _c.this._c;
            AdSlot adSlot = this._a;
            PtgAdNative.InteractionExpressAdListener interactionExpressAdListener = this._b;
            _a _aVar = new _a();
            _f4 _f4Var = new _f4(new _f3(_cfVar, adSlot, interactionExpressAdListener, _aVar));
            _ch _chVar_a = _ak._a(_cfVar, adSlot, _f4Var);
            if (_chVar_a == null) {
                return;
            }
            Logger.d("LAYER_REQUEST", _ie._a("start req ... layer: ").append(adSlot._e()).toString());
            _aVar._a(adSlot, _chVar_a, _f4Var);
        }
    }

    public class _d implements _ca._c {
        public final /* synthetic */ AdSlot _a;
        public final /* synthetic */ PtgAdNative.NativeExpressAdListener _b;
        public final /* synthetic */ Context _c;

        public class _a implements _em<AdSlot, _d8> {
            public _a() {
            }

            @Override // com.fancy._em
            public final void _a(Object obj, _ch _chVar, Error error) {
                AdSlot adSlot = (AdSlot) obj;
                _d8 _d8Var = (_d8) error;
                _d _dVar = _d.this;
                _c _cVar = _c.this;
                Context context = _dVar._c;
                _l1 _l1Var = _c._d;
                _cVar.getClass();
                try {
                    ArrayList<_ci> arrayList = _chVar._c;
                    int i = 101;
                    if (1 == arrayList.size()) {
                        adSlot._b();
                        adSlot._a((_ci) arrayList.get(0));
                        adSlot.setCodeID(adSlot._i()._e());
                        adSlot._a(101);
                        if (adSlot.getTimeoutMs() < 500) {
                            adSlot.setTimeoutMs(a.f1633a);
                        }
                        _ci _ciVar_i = adSlot._i();
                        _cVar._a(_ciVar_i).loadDrawExpressAd(context, adSlot._b(_ciVar_i), new _h(_d8Var, adSlot));
                        return;
                    }
                    String str = ", weight == 0";
                    if (!_chVar._d) {
                        _jt _jtVar = new _jt(_chVar._e, _chVar._b);
                        for (_ci _ciVar : arrayList) {
                            AdSlot adSlot_a = _jt._a(context, adSlot, _ciVar);
                            adSlot_a._a(101);
                            if (_jt._a(adSlot_a, _chVar, _ciVar)) {
                                _jtVar._a(new _na(_jtVar, _ciVar, _cVar._a(_ciVar), context, adSlot_a, _d8Var._a));
                                str = str;
                            } else {
                                Logger.d("abandon drawFeed ad request, consumer == " + _ciVar._c + str);
                            }
                        }
                        _jtVar._b();
                        return;
                    }
                    adSlot._o();
                    _jj _jjVar = new _jj(_chVar, _d8Var);
                    AtomicInteger atomicInteger = new AtomicInteger();
                    ArrayList arrayList2 = new ArrayList();
                    for (_ci _ciVar2 : arrayList) {
                        AdSlot adSlot_a2 = _jj._a(context, adSlot, _ciVar2);
                        adSlot_a2._a(i);
                        if (_jj._a(adSlot_a2, _chVar, _ciVar2)) {
                            adSlot_a2._k();
                            _bh _bhVar = new _bh(_jjVar._b, adSlot_a2._i(), atomicInteger, _d8Var._a);
                            _jjVar._a.add(_bhVar);
                            _bhVar._h();
                            ArrayList arrayList3 = arrayList2;
                            arrayList3.add(new _i(_cVar, _ciVar2, context, adSlot_a2, _bhVar));
                            arrayList2 = arrayList3;
                            i = 101;
                        } else {
                            Logger.d("abandon interaction ad request, consumer == " + _ciVar2._c + ", weight == 0");
                        }
                    }
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((Runnable) it.next()).run();
                    }
                    _jjVar._a();
                    _jjVar._b();
                } catch (Exception e) {
                    Logger.e(_ie._a("loadDrawFeedAd fail，").append(e.getMessage()).toString());
                    _d8Var.onError(new AdErrorImpl(10019, _ie._a("loadDrawFeedAd fail，").append(e.getMessage()).toString(), (Object) null));
                }
            }
        }

        public _d(AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener, Context context) {
            this._a = adSlot;
            this._b = nativeExpressAdListener;
            this._c = context;
        }

        @Override // com.fancy._ca._c
        public final void _a() {
            _pi _piVar = _pi._e;
            if (!_piVar._a(this._a)) {
                _x _xVar_a = _piVar._b(this._a)._a(new _pk())._a(new _pj());
                _xVar_a._p = System.currentTimeMillis();
                _xVar_a._q = _c._e.nextInt(100);
                this._a._a(_ca._c());
                this._a._a(_xVar_a._p);
                this._a._b(_xVar_a._q);
            }
            _cf _cfVar = _c.this._c;
            AdSlot adSlot = this._a;
            PtgAdNative.NativeExpressAdListener nativeExpressAdListener = this._b;
            _a _aVar = new _a();
            _d8 _d8Var = new _d8(new _d7(_cfVar, adSlot, nativeExpressAdListener, _aVar));
            _ch _chVar_a = _ak._a(_cfVar, adSlot, _d8Var);
            if (_chVar_a == null) {
                return;
            }
            Logger.d("LAYER_REQUEST", _ie._a("start req ... layer: ").append(adSlot._e()).toString());
            _aVar._a(adSlot, _chVar_a, _d8Var);
        }
    }

    public class _e implements _ca._c {
        public final /* synthetic */ AdSlot _a;
        public final /* synthetic */ PtgAdNative.NativeExpressAdListener _b;
        public final /* synthetic */ Context _c;

        public class _a implements _em<AdSlot, _gf> {
            public _a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r24v5 */
            /* JADX WARN: Type inference failed for: r24v6 */
            /* JADX WARN: Type inference failed for: r24v7 */
            /* JADX WARN: Type inference failed for: r24v8 */
            /* JADX WARN: Type inference failed for: r9v0 */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.fancy._gf] */
            /* JADX WARN: Type inference failed for: r9v10, types: [com.fancy._gf] */
            /* JADX WARN: Type inference failed for: r9v2 */
            /* JADX WARN: Type inference failed for: r9v8 */
            /* JADX WARN: Type inference failed for: r9v9 */
            @Override // com.fancy._em
            public final void _a(Object obj, _ch _chVar, Error error) {
                ?? r9;
                AdSlot adSlot = (AdSlot) obj;
                _gf _gfVar = (_gf) error;
                _e _eVar = _e.this;
                _c _cVar = _c.this;
                Context context = _eVar._c;
                _l1 _l1Var = _c._d;
                _cVar.getClass();
                try {
                    ArrayList<_ci> arrayList = _chVar._c;
                    int i = 8;
                    if (1 == arrayList.size()) {
                        adSlot._b();
                        adSlot._a((_ci) arrayList.get(0));
                        adSlot.setCodeID(adSlot._i()._e());
                        adSlot._a(8);
                        if (adSlot.getTimeoutMs() < 500) {
                            adSlot.setTimeoutMs(a.f1633a);
                        }
                        _ci _ciVar_i = adSlot._i();
                        _cVar._a(_ciVar_i).loadNativeExpressAd(context, adSlot._b(_ciVar_i), new _l(_gfVar, adSlot));
                        return;
                    }
                    String str = ", weight == 0";
                    String str2 = "abandon nativeExpressAd request, consumer == ";
                    try {
                        if (!_chVar._d) {
                            ?? r24 = _gfVar;
                            _jt _jtVar = new _jt(_chVar._e, _chVar._b);
                            for (_ci _ciVar : arrayList) {
                                AdSlot adSlot_a = _jt._a(context, adSlot, _ciVar);
                                adSlot_a._a(8);
                                if (_jt._a(adSlot_a, _chVar, _ciVar)) {
                                    r9 = r24;
                                    try {
                                        _jtVar._a(new _nc(_jtVar, _ciVar, _cVar._a(_ciVar), context, adSlot_a, r9._a));
                                        r24 = r9;
                                        str2 = str2;
                                        str = str;
                                    } catch (Exception e) {
                                        e = e;
                                        Logger.e(_ie._a("loadNativeExpressAd 失败，").append(e.getMessage()).toString());
                                        r9.onError(new AdErrorImpl(10011, _ie._a("loadNativeExpressAd 失败，").append(e.getMessage()).toString(), (Object) null));
                                    }
                                } else {
                                    Logger.d(str2 + _ciVar._c + str);
                                }
                            }
                            r9 = r24;
                            _jtVar._b();
                            return;
                        }
                        try {
                            adSlot._o();
                            _jj _jjVar = new _jj(_chVar, _gfVar);
                            AtomicInteger atomicInteger = new AtomicInteger();
                            ArrayList arrayList2 = new ArrayList();
                            for (_ci _ciVar2 : arrayList) {
                                AdSlot adSlot_a2 = _jj._a(context, adSlot, _ciVar2);
                                adSlot_a2._a(i);
                                if (_jj._a(adSlot_a2, _chVar, _ciVar2)) {
                                    adSlot_a2._k();
                                    _bj _bjVar = new _bj(_jjVar._b, adSlot_a2._i(), atomicInteger, _gfVar._a);
                                    _jjVar._a.add(_bjVar);
                                    _bjVar._h();
                                    _gf _gfVar2 = _gfVar;
                                    ArrayList arrayList3 = arrayList2;
                                    AtomicInteger atomicInteger2 = atomicInteger;
                                    arrayList3.add(new _m(_cVar, _ciVar2, context, adSlot_a2, _bjVar));
                                    arrayList2 = arrayList3;
                                    atomicInteger = atomicInteger2;
                                    i = 8;
                                    _gfVar = _gfVar2;
                                } else {
                                    Logger.d("abandon nativeExpressAd request, consumer == " + _ciVar2._c + ", weight == 0");
                                }
                            }
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                ((Runnable) it.next()).run();
                            }
                            _jjVar._a();
                            _jjVar._b();
                        } catch (Exception e2) {
                            e = e2;
                            error = _gfVar;
                            r9 = error;
                            Logger.e(_ie._a("loadNativeExpressAd 失败，").append(e.getMessage()).toString());
                            r9.onError(new AdErrorImpl(10011, _ie._a("loadNativeExpressAd 失败，").append(e.getMessage()).toString(), (Object) null));
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Exception e4) {
                    e = e4;
                    r9 = _gfVar;
                }
            }
        }

        public _e(AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener, Context context) {
            this._a = adSlot;
            this._b = nativeExpressAdListener;
            this._c = context;
        }

        @Override // com.fancy._ca._c
        public final void _a() {
            _pi _piVar = _pi._e;
            if (!_piVar._a(this._a)) {
                _x _xVar_a = _piVar._b(this._a)._a(new _pk())._a(new _pj());
                _xVar_a._p = System.currentTimeMillis();
                _xVar_a._q = _c._e.nextInt(100);
                this._a._a(_ca._c());
                this._a._a(_xVar_a._p);
                this._a._b(_xVar_a._q);
                if (_a9._a()) {
                    this._a._b(System.currentTimeMillis());
                    this._a._a(ArbitraryManger.getId(this._b));
                }
            }
            _cf _cfVar = _c.this._c;
            AdSlot adSlot = this._a;
            PtgAdNative.NativeExpressAdListener nativeExpressAdListener = this._b;
            _a _aVar = new _a();
            _gf _gfVar = new _gf(new _ge(_cfVar, adSlot, nativeExpressAdListener, _aVar));
            _ch _chVar_a = _ak._a(_cfVar, adSlot, _gfVar);
            if (_chVar_a == null) {
                return;
            }
            Logger.d("LAYER_REQUEST", _ie._a("start req ... layer: ").append(adSlot._e()).toString());
            _aVar._a(adSlot, _chVar_a, _gfVar);
        }
    }

    public class _f implements _ca._c {
        public final /* synthetic */ AdSlot _a;
        public final /* synthetic */ PtgAdNative.RewardVideoAdListener _b;
        public final /* synthetic */ Context _c;

        public class _a implements _em<AdSlot, _mb> {
            public _a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r24v5 */
            /* JADX WARN: Type inference failed for: r24v6 */
            /* JADX WARN: Type inference failed for: r24v7 */
            /* JADX WARN: Type inference failed for: r24v8 */
            /* JADX WARN: Type inference failed for: r9v0 */
            /* JADX WARN: Type inference failed for: r9v1, types: [com.fancy._mb] */
            /* JADX WARN: Type inference failed for: r9v10, types: [com.fancy._mb] */
            /* JADX WARN: Type inference failed for: r9v2 */
            /* JADX WARN: Type inference failed for: r9v8 */
            /* JADX WARN: Type inference failed for: r9v9 */
            @Override // com.fancy._em
            public final void _a(Object obj, _ch _chVar, Error error) {
                ?? r9;
                AdSlot adSlot = (AdSlot) obj;
                _mb _mbVar = (_mb) error;
                _f _fVar = _f.this;
                _c _cVar = _c.this;
                Context context = _fVar._c;
                _l1 _l1Var = _c._d;
                _cVar.getClass();
                try {
                    ArrayList<_ci> arrayList = _chVar._c;
                    int i = 100;
                    if (1 == arrayList.size()) {
                        adSlot._b();
                        adSlot._a((_ci) arrayList.get(0));
                        adSlot.setCodeID(adSlot._i()._e());
                        adSlot._a(100);
                        if (adSlot.getTimeoutMs() < 500) {
                            adSlot.setTimeoutMs(a.f1633a);
                        }
                        _ci _ciVar_i = adSlot._i();
                        _cVar._a(_ciVar_i).loadRewardVideoAd(context, adSlot._b(_ciVar_i), new _n(_mbVar, adSlot));
                        return;
                    }
                    String str = ", weight == 0";
                    String str2 = "abandon rewardVideoAd request, consumer == ";
                    try {
                        if (!_chVar._d) {
                            ?? r24 = _mbVar;
                            _jt _jtVar = new _jt(_chVar._e, _chVar._b);
                            for (_ci _ciVar : arrayList) {
                                AdSlot adSlot_a = _jt._a(context, adSlot, _ciVar);
                                adSlot_a._a(100);
                                if (_jt._a(adSlot_a, _chVar, _ciVar)) {
                                    r9 = r24;
                                    try {
                                        _jtVar._a(new _nd(_jtVar, _ciVar, _cVar._a(_ciVar), context, adSlot_a, r9._a));
                                        r24 = r9;
                                        str2 = str2;
                                        str = str;
                                    } catch (Exception e) {
                                        e = e;
                                        Logger.e(_ie._a("loadRewardVideoAd 失败，").append(e.getMessage()).toString());
                                        r9.onError(new AdErrorImpl(10011, _ie._a("loadRewardVideoAd 失败，").append(e.getMessage()).toString(), (Object) null));
                                    }
                                } else {
                                    Logger.d(str2 + _ciVar._c + str);
                                }
                            }
                            r9 = r24;
                            _jtVar._b();
                            return;
                        }
                        try {
                            adSlot._o();
                            _jj _jjVar = new _jj(_chVar, _mbVar);
                            AtomicInteger atomicInteger = new AtomicInteger();
                            ArrayList arrayList2 = new ArrayList();
                            for (_ci _ciVar2 : arrayList) {
                                AdSlot adSlot_a2 = _jj._a(context, adSlot, _ciVar2);
                                adSlot_a2._a(i);
                                if (_jj._a(adSlot_a2, _chVar, _ciVar2)) {
                                    adSlot_a2._k();
                                    _bk _bkVar = new _bk(_jjVar._b, adSlot_a2._i(), atomicInteger, _mbVar._a);
                                    _jjVar._a.add(_bkVar);
                                    _bkVar._h();
                                    _mb _mbVar2 = _mbVar;
                                    ArrayList arrayList3 = arrayList2;
                                    AtomicInteger atomicInteger2 = atomicInteger;
                                    arrayList3.add(new _o(_cVar, _ciVar2, context, adSlot_a2, _bkVar));
                                    arrayList2 = arrayList3;
                                    atomicInteger = atomicInteger2;
                                    i = 100;
                                    _mbVar = _mbVar2;
                                } else {
                                    Logger.d("abandon rewardVideoAd request, consumer == " + _ciVar2._c + ", weight == 0");
                                }
                            }
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                ((Runnable) it.next()).run();
                            }
                            _jjVar._a();
                            _jjVar._b();
                        } catch (Exception e2) {
                            e = e2;
                            error = _mbVar;
                            r9 = error;
                            Logger.e(_ie._a("loadRewardVideoAd 失败，").append(e.getMessage()).toString());
                            r9.onError(new AdErrorImpl(10011, _ie._a("loadRewardVideoAd 失败，").append(e.getMessage()).toString(), (Object) null));
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                } catch (Exception e4) {
                    e = e4;
                    r9 = _mbVar;
                }
            }
        }

        public _f(AdSlot adSlot, PtgAdNative.RewardVideoAdListener rewardVideoAdListener, Context context) {
            this._a = adSlot;
            this._b = rewardVideoAdListener;
            this._c = context;
        }

        @Override // com.fancy._ca._c
        public final void _a() {
            _pi _piVar = _pi._e;
            if (!_piVar._a(this._a)) {
                _x _xVar_a = _piVar._b(this._a)._a(new _pk())._a(new _pj());
                _xVar_a._p = System.currentTimeMillis();
                _xVar_a._q = _c._e.nextInt(100);
                this._a._a(_ca._c());
                this._a._a(_xVar_a._p);
                this._a._b(_xVar_a._q);
                if (_a9._a()) {
                    this._a._b(System.currentTimeMillis());
                    this._a._a(ArbitraryManger.getId(this._b));
                }
            }
            _cf _cfVar = _c.this._c;
            AdSlot adSlot = this._a;
            PtgAdNative.RewardVideoAdListener rewardVideoAdListener = this._b;
            _a _aVar = new _a();
            _mb _mbVar = new _mb(new _ma(_cfVar, adSlot, rewardVideoAdListener, _aVar));
            _ch _chVar_a = _ak._a(_cfVar, adSlot, _mbVar);
            if (_chVar_a == null) {
                return;
            }
            Logger.d("LAYER_REQUEST", _ie._a("start req ... layer: ").append(adSlot._e()).toString());
            _aVar._a(adSlot, _chVar_a, _mbVar);
        }
    }

    public final PtgAdNative _a(_ci _ciVar) {
        PtgAdNative ptgAdNative;
        return (_ciVar == null || (ptgAdNative = (PtgAdNative) this._a.get(_ciVar._c)) == null) ? _d : ptgAdNative;
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final String getBiddingToken(AdSlot adSlot, int i) {
        _x _xVar_a = _pi._e._b(adSlot)._a(new _pk())._a(new _pj());
        _xVar_a._p = System.currentTimeMillis();
        int i2 = 100;
        _xVar_a._q = _e.nextInt(100);
        adSlot._a(_ca._c());
        adSlot._a(_xVar_a._p);
        adSlot._b(_xVar_a._q);
        if (i == 1) {
            i2 = 6;
        } else if (i == 2) {
            i2 = 8;
        } else if (i == 3) {
            i2 = 5;
        } else if (i == 4) {
            i2 = 7;
        } else if (i != 5) {
            i2 = -1;
        }
        adSlot._a(i2);
        try {
            LinkedHashMap linkedHashMap_a = _av._a(adSlot);
            if (!linkedHashMap_a.isEmpty()) {
                return com.fancy.adsdk.lib.utils._a._a(new JSONObject(linkedHashMap_a).toString(), _oi._a());
            }
        } catch (Exception e) {
            Logger.e(_ie._a("buildBiddingToken error: ").append(e.getMessage()).toString());
        }
        return "";
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final String getName() {
        return "dispatcher";
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void init(Context context) {
        Iterator it = this._a.entrySet().iterator();
        while (it.hasNext()) {
            ((PtgAdNative) ((Map.Entry) it.next()).getValue()).init(context);
        }
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadBannerExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (_a(nativeExpressAdListener)) {
            return;
        }
        _a9._a(context);
        _ca._a(new _b(adSlot, nativeExpressAdListener, context));
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadDrawExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (_a(nativeExpressAdListener)) {
            return;
        }
        _ca._a(new _d(adSlot, nativeExpressAdListener, context));
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadInteractionExpressAd(Context context, AdSlot adSlot, PtgAdNative.InteractionExpressAdListener interactionExpressAdListener) {
        if (_a(interactionExpressAdListener)) {
            return;
        }
        _a9._a(context);
        _ca._a(new C0375_c(adSlot, interactionExpressAdListener, context));
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadNativeExpressAd(Context context, AdSlot adSlot, PtgAdNative.NativeExpressAdListener nativeExpressAdListener) {
        if (_a(nativeExpressAdListener)) {
            return;
        }
        _a9._a(context);
        _ca._a(new _e(adSlot, nativeExpressAdListener, context));
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadRewardVideoAd(Context context, AdSlot adSlot, PtgAdNative.RewardVideoAdListener rewardVideoAdListener) {
        if (_a(rewardVideoAdListener)) {
            return;
        }
        _a9._a(context);
        _ca._a(new _f(adSlot, rewardVideoAdListener, context));
    }

    @Override // com.fancy.adsdk.lib.provider.PtgAdNative
    public final void loadSplashAd(Context context, AdSlot adSlot, PtgAdNative.SplashAdListener splashAdListener) {
        if (_a(splashAdListener)) {
            return;
        }
        _a9._a(context);
        _ca._a(new _a(adSlot, splashAdListener, context));
    }

    public static boolean _a(Error error) {
        if (!com.fancy.adsdk.lib.utils._a._g()) {
            return false;
        }
        if (error == null) {
            return true;
        }
        error.onError(new AdErrorImpl(10001, "No ad", (Object) null));
        return true;
    }
}
