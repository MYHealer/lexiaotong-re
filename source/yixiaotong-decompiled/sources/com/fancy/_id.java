package com.fancy;

import android.content.Context;
import com.fancy.adsdk.lib.model.AdSlot;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _id {
    public static final _id _c = new _id();
    public final WeakHashMap _a = new WeakHashMap();
    public final Object _b = new Object();

    public final List<_i7> _a(Context context, String str, AdSlot adSlot) {
        List<_i7> listEmptyList;
        synchronized (this._b) {
            Map map = (Map) this._a.get(context);
            if (map == null) {
                map = new HashMap();
                this._a.put(context, map);
            }
            String str2 = str + "_" + adSlot._w() + "_" + adSlot.getCodeId();
            if (str2 != null) {
                listEmptyList = (List) map.get(str2);
                if (listEmptyList == null) {
                    listEmptyList = new ArrayList<>();
                    map.put(str2, listEmptyList);
                }
            } else {
                listEmptyList = null;
            }
            synchronized (this._b) {
                if (listEmptyList != null) {
                    Iterator<_i7> it = listEmptyList.iterator();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    while (it.hasNext()) {
                        _i7 next = it.next();
                        if (next == null || next._c <= jCurrentTimeMillis) {
                            it.remove();
                        }
                    }
                }
            }
            if (listEmptyList == null) {
                listEmptyList = Collections.emptyList();
            }
        }
        return listEmptyList;
    }
}
