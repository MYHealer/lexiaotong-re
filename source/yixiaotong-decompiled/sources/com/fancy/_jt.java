package com.fancy;

import android.content.Context;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.utils.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _jt {
    public final ArrayList _a = new ArrayList();
    public int _b;
    public int _c;

    public _jt(int i, int i2) {
        this._b = i;
        if (i == 0) {
            this._b = 1;
        }
        this._c = i2;
    }

    public static void _a(int i, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Random random = new Random();
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    synchronized (arrayList) {
                        Collections.sort(arrayList, new _jr());
                    }
                    return;
                } else {
                    if (i != 4) {
                        return;
                    }
                    synchronized (arrayList) {
                        Collections.sort(arrayList, new _js());
                    }
                    return;
                }
            }
            synchronized (arrayList) {
                arrayList2.addAll(arrayList);
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                arrayList3.add((_n8) arrayList2.remove(random.nextInt(arrayList2.size())));
            }
            synchronized (arrayList) {
                arrayList.clear();
                arrayList.addAll(arrayList3);
            }
            return;
        }
        synchronized (arrayList) {
            Collections.sort(arrayList, new _jq());
        }
        synchronized (arrayList) {
            arrayList2.addAll(arrayList);
        }
        Iterator it = arrayList2.iterator();
        int i_f = 0;
        while (it.hasNext()) {
            i_f += ((_n8) it.next())._f();
        }
        int i_f2 = i_f > 0 ? i_f : 1;
        int size = arrayList2.size();
        for (int i3 = 0; i3 < size; i3++) {
            int iNextInt = random.nextInt(i_f2);
            Iterator it2 = arrayList2.iterator();
            int i_f3 = 0;
            while (it2.hasNext()) {
                _n8 _n8Var = (_n8) it2.next();
                i_f3 += _n8Var._f();
                if (iNextInt <= i_f3) {
                    i_f2 -= _n8Var._f();
                    arrayList3.add(_n8Var);
                    it2.remove();
                    break;
                }
            }
        }
        synchronized (arrayList) {
            arrayList.clear();
            arrayList.addAll(arrayList3);
        }
    }

    public static boolean _a(AdSlot adSlot, _ch _chVar, _ci _ciVar) {
        if (_chVar == null || _ciVar == null) {
            return true;
        }
        int i = _ciVar._e;
        int i2 = _chVar._e;
        return ((i2 == 2 || i2 == 1) && i == 0) ? false : true;
    }

    public final void _a(_n8 _n8Var) {
        synchronized (this._a) {
            this._a.add(_n8Var);
            Logger.d("PtgDispatchProviderSerialHolder", "add serial request : " + _n8Var._c());
        }
    }

    public final boolean _a() {
        boolean z;
        synchronized (this._a) {
            z = !this._a.isEmpty();
        }
        return z;
    }

    public final void _b(_n8 _n8Var) {
        Logger.d("PtgDispatchProviderSerialHolder", _ie._a("doOnLoad : ").append(_n8Var._c()).toString());
        if (_n8Var._g()) {
            _n8Var._a();
        } else {
            _a(_n8Var, new AdErrorImpl(10001, "request no ad", (Object) null));
        }
    }

    public final _n8 _c() {
        _n8 _n8Var = null;
        if (_a()) {
            synchronized (this._a) {
                _n8Var = this._a.size() > 0 ? (_n8) this._a.remove(0) : null;
            }
            if (_n8Var != null) {
                _n8Var._b();
                Logger.d("PtgDispatchProviderSerialHolder", "doRequest : " + _n8Var._c());
            }
        }
        return _n8Var;
    }

    public static AdSlot _a(Context context, AdSlot adSlot, _ci _ciVar) {
        AdSlot adSlot_b = adSlot._b(_ciVar);
        ViewGroup viewGroup_a = adSlot_b._a();
        if (viewGroup_a != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup_a.getLayoutParams();
            FrameLayout frameLayout = new FrameLayout(context);
            frameLayout.setLayoutParams(new ViewGroup.LayoutParams(layoutParams));
            adSlot_b._a(frameLayout);
        }
        return adSlot_b;
    }

    public final void _a(_n8 _n8Var, AdError adError) {
        Logger.e("PtgDispatchProviderSerialHolder", _ie._a("doOnError : ").append(_n8Var._c()).append(" code: ").append(adError.getErrorCode()).append(" msg: ").append(adError.getMessage()).toString());
        if (_c() == null) {
            _n8Var._a(new AdErrorImpl(10001, adError.getMessage(), (Object) null));
        }
    }

    public final void _b() {
        int i = this._c;
        if (i != 0) {
            int i2 = this._b;
            ArrayList<_n8> arrayList = this._a;
            synchronized (arrayList) {
                ArrayList<Pair> arrayList2 = new ArrayList();
                if (i == 2) {
                    for (_n8 _n8Var : arrayList) {
                        _n8Var._e();
                        arrayList2.add(new Pair(0, _n8Var));
                    }
                } else if (i == 3) {
                    for (_n8 _n8Var2 : arrayList) {
                        _n8Var2._e();
                        arrayList2.add(new Pair(0, _n8Var2));
                    }
                }
                if (arrayList2.isEmpty()) {
                    _a(this._b, this._a);
                } else {
                    Collections.sort(arrayList2, new _jp());
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    int iIntValue = -1;
                    for (Pair pair : arrayList2) {
                        if (iIntValue < 0) {
                            iIntValue = ((Integer) pair.first).intValue();
                        } else if (iIntValue != ((Integer) pair.first).intValue()) {
                            _a(i2, arrayList3);
                            arrayList4.addAll(arrayList3);
                            arrayList3.clear();
                            iIntValue = ((Integer) pair.first).intValue();
                        }
                        arrayList3.add((_n8) pair.second);
                    }
                    if (!arrayList3.isEmpty()) {
                        _a(i2, arrayList3);
                        arrayList4.addAll(arrayList3);
                        arrayList3.clear();
                    }
                    arrayList.clear();
                    arrayList.addAll(arrayList4);
                }
            }
        } else {
            _a(this._b, this._a);
        }
        _c();
    }
}
