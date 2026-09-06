package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.core.model.AdErrorImpl;
import com.fancy.adsdk.lib.interf.Error;
import com.fancy.adsdk.lib.model.AdSlot;
import com.fancy.adsdk.lib.utils.Logger;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class _ak {
    public static _ch _a(_cf _cfVar, AdSlot adSlot, Error error) {
        if (TextUtils.isEmpty(adSlot.getPtgSlotID())) {
            Logger.e("ptgSlotId 为空, 请确认AdSlot参数");
            error.onError(new AdErrorImpl(10008, "ptgSlotId 为空, 请确认AdSlot参数", (Object) null));
            return null;
        }
        _ch _chVar_a = _a(_cfVar, adSlot);
        if (_chVar_a != null && !_chVar_a._c.isEmpty()) {
            return _chVar_a;
        }
        error.onError(new AdErrorImpl(10013, "No provider", (Object) null));
        return null;
    }

    public static int _b(_cf _cfVar, AdSlot adSlot) {
        int i;
        String ptgSlotID = adSlot.getPtgSlotID();
        synchronized (_cfVar._e) {
            _cg _cgVar = _cfVar._c;
            i = 0;
            if (_cgVar != null) {
                Map map = (Map) _cgVar._b.get(ptgSlotID);
                if (map != null && !map.isEmpty()) {
                    for (int i_e = adSlot._e() + 1; i_e <= 10; i_e++) {
                        List list = (List) map.get(Integer.valueOf(i_e));
                        if (list != null && !list.isEmpty()) {
                            i = i_e;
                            break;
                        }
                    }
                }
            }
        }
        return i;
    }

    public static _ch _a(_cf _cfVar, AdSlot adSlot) {
        List<_ci> list;
        _ch _chVar_a;
        if (adSlot._e() > 10) {
            return null;
        }
        String ptgSlotID = adSlot.getPtgSlotID();
        int i_e = adSlot._e();
        synchronized (_cfVar._e) {
            _cg _cgVar = _cfVar._c;
            if (_cgVar == null) {
                _chVar_a = _cf._a();
            } else {
                if (i_e != 0 && i_e != 1) {
                    Map map = (Map) _cgVar._b.get(ptgSlotID);
                    list = map != null ? (List) map.get(Integer.valueOf(i_e)) : null;
                } else {
                    list = (List) _cgVar._a.get(ptgSlotID);
                }
                if (list == null) {
                    _chVar_a = _cf._a();
                } else {
                    _cj _cjVar = (_cj) _cfVar._c._e.get(ptgSlotID);
                    if (_cjVar == null) {
                        _chVar_a = null;
                    } else {
                        int i = _cjVar._e;
                        boolean z = ((_cg._a) _cfVar._c._c.get(ptgSlotID))._a;
                        Integer num = (Integer) _cfVar._c._d.get(ptgSlotID);
                        _ch _chVar = new _ch(i, z, num == null ? 0 : num.intValue(), ((_cg._a) _cfVar._c._c.get(ptgSlotID))._b);
                        for (_ci _ciVar : list) {
                            if (_cfVar._b._a(_ciVar)) {
                                int i2 = _ciVar._e;
                                _chVar._c.add(_ciVar);
                            }
                        }
                        _chVar_a = _chVar;
                    }
                }
            }
        }
        if (_chVar_a != null && !_chVar_a._c.isEmpty()) {
            return _chVar_a;
        }
        int i_b = _b(_cfVar, adSlot);
        if (i_b <= 0) {
            return null;
        }
        adSlot._d(i_b);
        return _a(_cfVar, adSlot);
    }
}
