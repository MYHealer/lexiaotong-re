package com.fancy.mpsdk;

import android.content.Context;
import com.fancy._1;
import com.fancy._al;
import com.fancy._b4;
import com.fancy._bs;
import com.fancy._f;
import com.fancy._f1;
import com.fancy._gz;
import com.fancy._m1;
import com.fancy._ou;
import com.fancy._r;
import com.fancy._y;
import com.fancy.adsdk.lib.model.AdSlot;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PtgAdProxy {
    private static _bs core;

    public static void getBannerAd(Context context, AdSlot adSlot, _b4<_r> _b4Var) {
        if (core != null) {
            adSlot._a(5);
            _y[] _yVarArr = {new _gz()};
            ArrayList arrayList = new ArrayList();
            _al _alVar = new _al();
            _alVar._a();
            arrayList.add(_yVarArr[0]);
            _1 _1 = new _1(_alVar, arrayList.size(), _b4Var);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((_y) it.next())._a(adSlot, _1);
            }
        }
    }

    public static void getFeedAd(Context context, AdSlot adSlot, _b4<_r> _b4Var) {
        if (core != null) {
            adSlot._a(adSlot._n() == 1 ? 6 : 8);
            _y[] _yVarArr = {new _gz()};
            ArrayList arrayList = new ArrayList();
            _al _alVar = new _al();
            _alVar._a();
            arrayList.add(_yVarArr[0]);
            _1 _1 = new _1(_alVar, arrayList.size(), _b4Var);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((_y) it.next())._a(adSlot, _1);
            }
        }
    }

    public static void getInteractionAd(Context context, AdSlot adSlot, _b4<_r> _b4Var) {
        if (core != null) {
            adSlot._a(7);
            _y[] _yVarArr = {new _gz()};
            ArrayList arrayList = new ArrayList();
            _al _alVar = new _al();
            _alVar._a();
            arrayList.add(_yVarArr[0]);
            _1 _1 = new _1(_alVar, arrayList.size(), _b4Var);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((_y) it.next())._a(adSlot, _1);
            }
        }
    }

    public static void getRewardVideoAd(Context context, AdSlot adSlot, _b4<_r> _b4Var) {
        if (core != null) {
            adSlot._a(100);
            _y[] _yVarArr = {new _gz()};
            ArrayList arrayList = new ArrayList();
            _al _alVar = new _al();
            _alVar._a();
            arrayList.add(_yVarArr[0]);
            _1 _1 = new _1(_alVar, arrayList.size(), _b4Var);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((_y) it.next())._a(adSlot, _1);
            }
        }
    }

    public static void getSplashAd(Context context, AdSlot adSlot, _b4<_r> _b4Var) {
        if (core != null) {
            adSlot._a(6);
            _y[] _yVarArr = {new _gz()};
            ArrayList arrayList = new ArrayList();
            _al _alVar = new _al();
            _alVar._a();
            arrayList.add(_yVarArr[0]);
            _1 _1 = new _1(_alVar, arrayList.size(), _b4Var);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((_y) it.next())._a(adSlot, _1);
            }
        }
    }

    public static void initialize(Context context) {
        if (context == null) {
            throw new IllegalArgumentException();
        }
        core = new _f1();
    }

    public static void onAdClicked(_f _fVar, AdSlot adSlot) {
        if (core == null || _fVar == null) {
            return;
        }
        _ou _ouVar_a = _ou._a();
        _m1 _m1Var = _ouVar_a._b;
        if (_m1Var != null) {
            _m1Var._a(_fVar, adSlot);
            return;
        }
        _m1 _m1Var2 = new _m1();
        _ouVar_a._b = _m1Var2;
        _m1Var2._a(_fVar, adSlot);
    }
}
