package com.fancy;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fancy.adsdk.lib.PtgAdSdk;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.Error;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.utils.Logger;
import com.fancy.mpsdk.provider.PtgApiProvider;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _jj {
    public final SortedSet _b;
    public final _ch _d;
    public final Error _e;
    public final AtomicBoolean _h = new AtomicBoolean();
    public final long _g = 3500;
    public final AtomicBoolean _c = new AtomicBoolean(false);
    public final Timer _f = new Timer();
    public final HashSet _a = new HashSet();

    public class _a extends TimerTask {
        public _a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            try {
                _jj _jjVar = _jj.this;
                Logger.e("ConcurrentHolder", "doCallback:CALL--TIMER_OVER cost(ms):" + _jj.this._g + " execute:" + _jj._a(_jjVar, _jjVar._c, _jjVar._d, _jjVar._b, _jjVar._e));
            } catch (Exception e) {
                e.printStackTrace();
                Logger.e("ConcurrentHolder", e.getMessage());
            }
        }
    }

    public static abstract class _b<E extends _bg> extends TreeSet<E> {
        public _ch _a;
        public ArrayList _b;

        public _b(_c _cVar, _ch _chVar) {
            super(_cVar);
            this._a = _chVar;
            ArrayList arrayList_a = _chVar._a();
            this._b = new ArrayList(arrayList_a.size());
            Iterator it = arrayList_a.iterator();
            while (it.hasNext()) {
                this._b.add(Integer.valueOf(((_ci) it.next())._i()));
            }
            Collections.sort(this._b, new _jo());
        }

        public abstract void _a();

        @Override // java.util.TreeSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* JADX INFO: renamed from: _a, reason: merged with bridge method [inline-methods] */
        public final boolean add(E e) {
            AtomicInteger atomicInteger;
            boolean z = false;
            if (e != null) {
                boolean zAdd = e._g() ? super.add(e) : false;
                if (e._f.compareAndSet(false, true) && (atomicInteger = e._e) != null) {
                    atomicInteger.decrementAndGet();
                }
                z = zAdd;
            }
            if (e._f()) {
                Iterator it = this._b.iterator();
                while (it.hasNext()) {
                    Integer num = (Integer) it.next();
                    if (num.intValue() == e._e()) {
                        it.remove();
                        Logger.e("ConcurrentHolder", "addCallback:ERROR_REMOVE--" + e._d()._b + " weight:" + num);
                        break;
                    }
                }
            }
            Iterator it2 = this._b.iterator();
            if (it2.hasNext()) {
                Integer num2 = (Integer) it2.next();
                int i = this._a._e;
                if (i == 0) {
                    Iterator<E> it3 = iterator();
                    if (it3.hasNext()) {
                        E next = it3.next();
                        Logger.e("ConcurrentHolder", _ie._a("addCallback:TIME_PRIORITY--").append(next._d()._b).append("--targetWeight:").append(num2).append("--isLoaded:").append(next._g()).toString());
                        _a();
                        return z;
                    }
                } else if (i == 1) {
                    Logger.e("ConcurrentHolder", _ie._a("addCallback:WEIGHT_PRIORITY--").append(e._d()._b).append("--targetWeight:").append(num2).append("--runningCounter:").append(e._c()).append("--isLoaded:").append(e._g()).toString());
                    if (e._c() == 0) {
                        _a();
                        return z;
                    }
                } else if (i == 3) {
                    Logger.e("ConcurrentHolder", _ie._a("addCallback:SERIAL_PRIORITY--").append(e._d()._b).append("--targetWeight:").append(num2).append("--runningCounter:").append(e._c()).append("--isLoaded:").append(e._g()).toString());
                    if (e._c() == 0) {
                        _a();
                        return z;
                    }
                } else if (i == 4) {
                    Logger.d("ConcurrentHolder", _ie._a("addCallback: ").append(e.toString()).toString());
                    if (e._c() == 0) {
                        _a();
                        return z;
                    }
                }
            } else {
                _a();
            }
            return z;
        }
    }

    public static class _c implements Comparator<_bg> {
        public _ch _a;

        public _c(_ch _chVar) {
            this._a = _chVar;
        }

        @Override // java.util.Comparator
        public final int compare(_bg _bgVar, _bg _bgVar2) {
            _bg _bgVar3 = _bgVar;
            _bg _bgVar4 = _bgVar2;
            if (this._a._e != 1) {
                if (!_bgVar3.equals(_bgVar4)) {
                    return 1;
                }
            } else if (!_bgVar3.equals(_bgVar4)) {
                int i_e = _bgVar4._e() - _bgVar3._e();
                if (i_e == 0) {
                    return 1;
                }
                return i_e;
            }
            return 0;
        }
    }

    public _jj(_ch _chVar, Error error) {
        this._d = _chVar;
        this._e = error;
        this._b = Collections.synchronizedSortedSet(new _ji(this, new _c(_chVar), _chVar, _chVar, error));
    }

    public static boolean _a(_jj _jjVar, AtomicBoolean atomicBoolean, _ch _chVar, Set set, Error error) {
        _jjVar.getClass();
        if (!atomicBoolean.compareAndSet(false, true)) {
            return false;
        }
        _jjVar._a(new AtomicInteger(), _chVar, set, new ArrayList(), error);
        return true;
    }

    public final void _a() {
        this._h.set(true);
    }

    public final void _b() {
        this._f.schedule(new _a(), this._g);
    }

    public static boolean _a(AdSlot adSlot, _ch _chVar, _ci _ciVar) {
        if (_chVar == null || _ciVar == null) {
            return true;
        }
        int i = _ciVar._e;
        int i2 = _chVar._e;
        return ((i2 == 2 || i2 == 1) && i == 0) ? false : true;
    }

    public static AdSlot _a(Context context, AdSlot adSlot, _ci _ciVar) {
        AdSlot adSlot_b = adSlot._b(_ciVar);
        ViewGroup viewGroup_a = adSlot._a();
        if (viewGroup_a != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup_a.getLayoutParams();
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(layoutParams));
            adSlot_b._a(frameLayout);
        }
        return adSlot_b;
    }

    /* JADX WARN: Code duplicated, block: B:163:0x052d  */
    public final boolean _a(AtomicInteger atomicInteger, _ch _chVar, Collection collection, ArrayList arrayList, Error error) {
        boolean z;
        Object obj;
        StringBuilder sb;
        String str;
        atomicInteger.incrementAndGet();
        int i = _chVar._e;
        ArrayList<_bg> arrayList2 = new ArrayList(collection);
        int i2 = _chVar._b;
        int i3 = _chVar._a;
        int i4 = 3;
        if (i2 != 0 && i3 > 0) {
            Logger.e("ConcurrentHolder", "doCallback:FILTER_START--ACTION:" + i2);
            arrayList2.clear();
            int i5 = 0;
            for (_bg _bgVar : this._a) {
                if (_bgVar != null) {
                    if (i2 == 2 || i2 == 3) {
                        _bgVar._d();
                    }
                    if (i3 <= 0) {
                        Logger.e("ConcurrentHolder", _ie._a("doCallback:UP_TO_MAX(").append(_bgVar._d()._b).append(")--count:").append(0).toString());
                        i5++;
                    }
                }
            }
            for (_bg _bgVar2 : new ArrayList(arrayList2)) {
                if (_bgVar2 != null && _bgVar2._d() != null) {
                    if (i2 == 2) {
                        _bgVar2._d();
                        if (arrayList == null || i3 > 0) {
                            arrayList2.add(_bgVar2);
                            sb = new StringBuilder();
                            str = "doCallback:FILTER--IMP(0)--ADD_FIRST:";
                        } else {
                            arrayList.add(_bgVar2);
                            sb = new StringBuilder();
                            str = "doCallback:FILTER--IMP(0)--ADD_SECOND:";
                        }
                    } else if (i2 != 3) {
                        sb = new StringBuilder().append("doCallback:FILTER--UNKNOWN--").append(i2);
                        str = "--SKIP:";
                    } else {
                        _bgVar2._d();
                        if (arrayList == null || i3 > 0) {
                            arrayList2.add(_bgVar2);
                            sb = new StringBuilder();
                            str = "doCallback:FILTER--CLK(0)--ADD_FIRST:";
                        } else {
                            arrayList.add(_bgVar2);
                            sb = new StringBuilder();
                            str = "doCallback:FILTER--CLK(0)--ADD_SECOND:";
                        }
                    }
                    Logger.e("ConcurrentHolder", sb.append(str).append(_bgVar2._d()._b).toString());
                }
            }
            if (i5 == this._a.size()) {
                Logger.e("ConcurrentHolder", "doCallback:FILTER--RESET_ALL");
                Iterator it = this._a.iterator();
                while (it.hasNext()) {
                    _os _osVar_d = ((_bg) it.next())._d();
                    if (i2 == 2 || i2 == 3) {
                        String str2 = _osVar_d._a;
                    }
                }
            }
            if (arrayList2.isEmpty() && arrayList != null && !arrayList.isEmpty()) {
                Logger.e("ConcurrentHolder", "doCallback:FILTER--RESET_SECOND_TO_FIRST");
                arrayList2.addAll(arrayList);
                arrayList.clear();
            }
        }
        int i_e = Integer.MAX_VALUE;
        int i_e2 = 0;
        _bg _bgVar3 = null;
        for (_bg _bgVar4 : arrayList2) {
            i_e2 = _bgVar4._e() + i_e2;
            if (i == 0) {
                _bgVar4._a();
                _bgVar4._i();
                Logger.e("ConcurrentHolder", "doCallback:TIME_PRIORITY--" + _bgVar4._d()._b);
                Logger.e("ConcurrentHolder", "doCallback:END--selected(" + _bgVar4._d()._b + "):" + _bgVar4._b());
                return true;
            }
            if (i == 1) {
                Logger.e("ConcurrentHolder", _ie._a("doCallback:COUNT_ALL_WEIGHT(").append(_bgVar4._d()._b).append(")--WEIGHT--").append(_bgVar4._e()).toString());
            } else if (i != 3) {
                if (i != 4) {
                    Logger.e("ConcurrentHolder", _ie._a("doCallback:END--UNKNOWN--").append(_bgVar4._d()._b).append("--TYPE:").append(i).toString());
                    _bgVar4._a(new AdErrorImpl(10001, "priorityPolicy is not supported", (Object) null));
                    return true;
                }
                Logger.d("ConcurrentHolder", _ie._a("doCallback: ").append(_bgVar4.toString()).toString());
            } else {
                if (_bgVar4._g() && _bgVar4._e() < i_e) {
                    i_e = _bgVar4._e();
                    _bgVar3 = _bgVar4;
                }
                Logger.e("ConcurrentHolder", _ie._a("doCallback:").append(i2 == 0 ? "LEVEL_PRIORITY--" : "SMART_PRIORITY--").append(_bgVar4._d()._b).append("（").append(_bgVar4._e()).append("）").toString());
            }
        }
        if (i == 1) {
            z = false;
            if (i_e2 > 0) {
                int iNextInt = new Random().nextInt(i_e2);
                Logger.e("ConcurrentHolder", _ie._a("doCallback:SELECTING--COUNT_SIZE: ").append(arrayList2.size()).append("--TOTAL:").append(i_e2).append("--RAND:").append(iNextInt).toString());
                int i_e3 = 0;
                for (_bg _bgVar5 : arrayList2) {
                    i_e3 += _bgVar5._e();
                    Logger.e("ConcurrentHolder", _ie._a("doCallback:SELECTING(").append(_bgVar5._d()._b).append(")--SUM:").append(i_e3).append("--RAND:").append(iNextInt).toString());
                    if (i_e3 > iNextInt) {
                        com.fancy.adsdk.lib.utils._d._c(new _jl(_bgVar5));
                        _bgVar5._i();
                        Logger.e("ConcurrentHolder", "doCallback:END--selected(" + _bgVar5._d()._b + "):" + _bgVar5._b());
                        return true;
                    }
                }
            }
        } else if (i != 3) {
            if (i == 4) {
                Collections.sort(arrayList2, new _jm());
                if (!arrayList2.isEmpty()) {
                    ArrayList arrayList3 = new ArrayList();
                    _ci _ciVar = ((_bg) arrayList2.get(0))._c;
                    long j = _ciVar != null ? _ciVar._h : 0L;
                    for (_bg _bgVar6 : arrayList2) {
                        _ci _ciVar2 = _bgVar6._c;
                        if ((_ciVar2 != null ? _ciVar2._h : 0L) != j) {
                            break;
                        }
                        arrayList3.add(_bgVar6);
                    }
                    _bg _bgVar7 = (_bg) arrayList3.get(new Random().nextInt(arrayList3.size()));
                    Logger.d("ConcurrentHolder", _ie._a("bingo: ").append(_bgVar7.toString()).toString());
                    com.fancy.adsdk.lib.utils._d._c(new _jn(_bgVar7));
                    _bgVar7._i();
                    return true;
                }
            }
            z = false;
        } else {
            z = false;
            if (_bgVar3 != null && _bgVar3._g()) {
                com.fancy.adsdk.lib.utils._d._c(new _jk(_bgVar3));
                _bgVar3._i();
                Logger.e("ConcurrentHolder", "doCallback:END--selected(" + _bgVar3._d()._b + "):" + _bgVar3._b());
                return true;
            }
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            return _a(atomicInteger, _chVar, arrayList, (ArrayList) null, error);
        }
        Logger.e("ConcurrentHolder", "doCallback:END--No ad");
        HashSet hashSet = this._a;
        if (hashSet == null || hashSet.isEmpty()) {
            obj = null;
        } else {
            _bg _bgVar8 = (_bg) this._a.iterator().next();
            HashSet<_bg> hashSet2 = this._a;
            _os _osVar = _bgVar8._d;
            AdSlot adSlot = _bgVar8._b;
            if (_osVar == null || adSlot == null || adSlot._i() == null) {
                obj = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                try {
                    for (_bg _bgVar9 : hashSet2) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", _bgVar9._d()._f);
                        jSONObject.put(CrashHianalyticsData.MESSAGE, _bgVar9._d()._g);
                        jSONObject.put(ClientCookie.DOMAIN_ATTR, _bgVar9._b());
                        jSONArray.put(jSONObject);
                    }
                } catch (Exception unused) {
                }
                adSlot._a(_osVar._o);
                adSlot._b(_osVar._q);
                _os _osVar2 = new _os("", _osVar._b, adSlot);
                _osVar2._h = _osVar2._h;
                _or _orVar = _osVar2._t;
                boolean z2 = true;
                boolean z3 = true;
                boolean z4 = true;
                for (_bg _bgVar10 : hashSet2) {
                    int i6 = _bgVar10._d()._f;
                    if (i6 != 10001) {
                        z3 = z;
                    }
                    if (i6 != 10001) {
                        z2 = z;
                    }
                    if (PtgApiProvider.providerName.equals(_bgVar10._b()) && i6 != 10001) {
                        z4 = z;
                    }
                }
                if (z2) {
                    i4 = 1;
                } else if (z3) {
                    i4 = 2;
                } else if (z4) {
                    i4 = 4;
                }
                _orVar._f(i4);
                _osVar2._t._e(10001);
                _osVar2._t._g(jSONArray.toString());
                _osVar2._t._m(adSlot.getPtgSlotID());
                _osVar2._t._a(adSlot._j());
                _osVar2._t._c(PtgAdSdk.getConfig().getAppVersionName());
                _osVar2._t._b(PtgAdSdk.getConfig().getAppVersionCode());
                _osVar2._t._l(PtgAdSdk.getConfig().getSdkVersionName());
                _osVar2._t._k(PtgAdSdk.getConfig().getSdkVersionCode());
                _osVar2._t._i(PtgAdSdk.getConfig().getMediaId());
                _osVar2._t._j(PtgAdSdk.getConfig().getPolicyVersion());
                _osVar2._t._c(adSlot._i()._S);
                obj = null;
                _ou._a()._a(adSlot._i()._g(), "inAppErr", _osVar2, null);
            }
        }
        error.onError(new AdErrorImpl(10001, "No ad", obj));
        return true;
    }
}
