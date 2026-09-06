package com.fancy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _l6 {
    public final HashMap _a = new HashMap();

    /* JADX WARN: Code duplicated, block: B:25:0x0082  */
    public final void _a(_f _fVar, long j) {
        Map<String, List<String>> map;
        Boolean bool;
        List<String> list;
        Map<String, List<String>> map2;
        if (j != -1) {
            String strValueOf = String.valueOf(Integer.parseInt(String.valueOf(j / 1000)));
            if (_fVar == null || (map = _fVar._h) == null || map.isEmpty() || ((bool = (Boolean) this._a.get(strValueOf)) != null && bool.booleanValue())) {
                list = null;
            } else {
                this._a.put(strValueOf, Boolean.TRUE);
                list = map.get(strValueOf);
            }
        } else if (_fVar == null || (map2 = _fVar._h) == null || map2.isEmpty()) {
            list = null;
        } else {
            String str = (String) Collections.max(new ArrayList(map2.keySet()), new _l5());
            Boolean bool2 = (Boolean) this._a.get(str);
            if (bool2 == null || !bool2.booleanValue()) {
                this._a.put(String.valueOf(str), Boolean.TRUE);
                list = map2.get(str);
            } else {
                list = null;
            }
        }
        _l0._a(_fVar, list);
    }
}
