package com.fancy.adsdk.lib;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.fancy._aw;
import com.fancy._ce;
import com.fancy._cf;
import com.fancy._cg;
import com.fancy._ci;
import com.fancy._ck;
import com.fancy._e0;
import com.fancy._e6;
import com.fancy._e9;
import com.fancy._fp;
import com.fancy._g7;
import com.fancy._ho;
import com.fancy._i1;
import com.fancy._i6;
import com.fancy._if;
import com.fancy._l1;
import com.fancy._ly;
import com.fancy._lz;
import com.fancy._ni;
import com.fancy._oa;
import com.fancy._oc;
import com.fancy._om;
import com.fancy._ou;
import com.fancy.adsdk.lib.interf.Error;
import com.fancy.adsdk.lib.model.AdError;
import com.fancy.adsdk.lib.provider.PtgAdNative;
import com.fancy.adsdk.lib.utils.Logger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _a {
    public static final C0371_a _a = new C0371_a();

    /* JADX INFO: renamed from: com.fancy.adsdk.lib._a$_a, reason: collision with other inner class name */
    public class C0371_a implements Error {
        @Override // com.fancy.adsdk.lib.interf.Error
        public final void onError(AdError adError) {
            Logger.e(adError.getMessage());
        }
    }

    public static com.fancy.adsdk.lib.provider._c _a(_cf _cfVar, PtgAdNative... ptgAdNativeArr) {
        com.fancy.adsdk.lib.provider._c _cVar = new com.fancy.adsdk.lib.provider._c();
        for (PtgAdNative ptgAdNative : ptgAdNativeArr) {
            if (ptgAdNative != null) {
                _cVar._b.put(ptgAdNative.getName(), ptgAdNative);
                _cVar._a.put(ptgAdNative.getName(), new com.fancy.adsdk.lib.provider._b(new _l1(new com.fancy.adsdk.lib.provider._b(new _i6(ptgAdNative.getName(), new com.fancy.adsdk.lib.provider._b(ptgAdNative))))));
            }
        }
        _cVar._c = _cfVar;
        return _cVar;
    }

    public static void _a(Context context, PtgSDKConfig ptgSDKConfig, PtgAdSdk.Callback callback, PtgAdNative[] ptgAdNativeArr) {
        try {
            com.fancy._b _bVar = com.fancy._b._a;
            _ou _ouVar_a = _ou._a();
            synchronized (_ouVar_a._a) {
                _ouVar_a._a.add(_bVar);
            }
            _cf _cfVar = new _cf();
            com.fancy.adsdk.lib.provider._c _cVar_a = _a(_cfVar, ptgAdNativeArr);
            com.fancy.adsdk.lib.provider._b _bVar2 = new com.fancy.adsdk.lib.provider._b(_cVar_a);
            PtgAdSdk.globalProvider = _bVar2;
            _cfVar._a = new _ni(new _g7(new _fp(), new _e9()), new _d(callback));
            _e0 _e0Var = new _e0(new _e6(), new _ho(Build.VERSION.RELEASE), new _i1());
            _e0Var.start();
            _cfVar._b = _e0Var;
            _if._f._b = _cfVar;
            ArrayList arrayList = _oc._a;
            com.fancy.adsdk.lib.utils._d._b(new _oa(context, ptgSDKConfig));
            _cfVar._a._a(new _ce(_cfVar, _cfVar, new _om(_cfVar, new _e(context, _cfVar, _cVar_a, _bVar2, ptgSDKConfig))));
            _a(context, _cfVar);
            _a(_cfVar);
        } catch (Exception e) {
            if (callback != null) {
                callback.fail(10006, e.getMessage());
            }
        }
    }

    public static void _a(Context context, _cf _cfVar) {
        PtgSDKConfig ptgSDKConfig;
        _ck _ckVar = _cfVar._d;
        if (_ckVar == null || (ptgSDKConfig = PtgAdSdk.config) == null) {
            return;
        }
        if (!TextUtils.isEmpty(_ckVar._b)) {
            ptgSDKConfig.setPackageName(_ckVar._b);
        }
        if (!TextUtils.isEmpty(_ckVar._c)) {
            ptgSDKConfig.setVendorId(_ckVar._c);
        }
        ptgSDKConfig.setAppIdMap(_ckVar._r);
        ptgSDKConfig.setAppKeyMap(_ckVar._s);
        if (!TextUtils.isEmpty(_ckVar._e)) {
            ptgSDKConfig.setPtgApiUrl(_ckVar._e);
        }
        if (!TextUtils.isEmpty(_ckVar._w)) {
            ptgSDKConfig.setWechatAppId(_ckVar._w);
        }
        List<String> list = _ckVar._x;
        if (list != null) {
            ptgSDKConfig.setQaList(list);
        }
        ptgSDKConfig.setDetectRule(_ckVar._h);
        ptgSDKConfig.setDetectRuleInterval(_ckVar._i);
        ptgSDKConfig.setFdRule(_ckVar._j);
        if (!TextUtils.isEmpty(_ckVar._f)) {
            ptgSDKConfig.setInitTrackingUrl(_ckVar._f);
        }
        if (!TextUtils.isEmpty(_ckVar._g)) {
            ptgSDKConfig.setPolicyVersion(_ckVar._g);
        }
        ptgSDKConfig.setBaseTrackingUrl(_ckVar._L);
        ptgSDKConfig.setQaNRTime(_ckVar._k);
        ptgSDKConfig.setRtbLogInterval(context, _ckVar._q);
        ptgSDKConfig.setRtbLogUrl(context, _ckVar._p);
        ptgSDKConfig.setPUrl(context, _ckVar._t);
        ptgSDKConfig.setLessThanVc(context, _ckVar._y);
        ptgSDKConfig.setImageUpgrade(_ckVar._m);
        ptgSDKConfig.setBlin(_ckVar._N);
        ptgSDKConfig.setLin(_ckVar._M);
        ptgSDKConfig.setDelayLin(_ckVar._R);
        ptgSDKConfig.setLinc(_ckVar._O);
        ptgSDKConfig.setLind(_ckVar._P);
        ptgSDKConfig.setSlin(_ckVar._Q);
        if (_ckVar._S == null) {
            _ckVar._S = new ArrayList();
        }
        ptgSDKConfig.setDpWhiteList(_ckVar._S);
        ptgSDKConfig.setMediaStatus(_ckVar._d);
        _if _ifVar = _if._f;
        _ifVar._a = _ckVar._u;
        List<String> list2 = _ckVar._v;
        synchronized (_ifVar._e) {
            _ifVar._e.clear();
            if (list2 != null) {
                _ifVar._e.addAll(list2);
            }
        }
    }

    public static void _a(_cf _cfVar) {
        List listEmptyList;
        _cg _cgVar = _cfVar._c;
        if (_cgVar == null) {
            listEmptyList = Collections.emptyList();
        } else {
            Collection<List> collectionValues = _cgVar._a.values();
            ArrayList arrayList = new ArrayList();
            if (collectionValues != null) {
                for (List list : collectionValues) {
                    if (list != null) {
                        arrayList.addAll(list);
                    }
                }
            }
            listEmptyList = arrayList;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (listEmptyList != null) {
            Iterator it = listEmptyList.iterator();
            while (it.hasNext()) {
                for (_aw _awVar : ((_ci) it.next())._L) {
                    if (_awVar != null) {
                        linkedHashMap.put(_awVar._b, _awVar._c);
                    }
                }
            }
        }
        if (linkedHashMap.isEmpty()) {
            return;
        }
        Collection collectionValues2 = linkedHashMap.values();
        ConcurrentHashMap concurrentHashMap = _ly._a;
        if (collectionValues2 == null || collectionValues2.isEmpty()) {
            return;
        }
        _ly._b.execute(new _lz(collectionValues2));
    }
}
