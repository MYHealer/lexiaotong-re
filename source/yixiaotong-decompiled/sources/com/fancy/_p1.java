package com.fancy;

import android.text.TextUtils;
import com.fancy.adsdk.lib.PtgAdSdk;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _p1 implements Runnable {
    public final /* synthetic */ Set _a;
    public final /* synthetic */ boolean _b;

    public _p1(CopyOnWriteArraySet copyOnWriteArraySet, boolean z) {
        this._a = copyOnWriteArraySet;
        this._b = z;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0023  */
    @Override // java.lang.Runnable
    public final void run() {
        Map.Entry<String, String> next;
        try {
            ConcurrentHashMap<String, String> concurrentHashMap = _p2._g;
            if (concurrentHashMap.isEmpty()) {
                next = null;
            } else {
                Set<Map.Entry<String, String>> setEntrySet = concurrentHashMap.entrySet();
                if (setEntrySet.isEmpty()) {
                    next = null;
                } else {
                    Iterator<Map.Entry<String, String>> it = setEntrySet.iterator();
                    if (it.hasNext()) {
                        next = it.next();
                    } else {
                        next = null;
                    }
                }
            }
            if (next == null) {
                ScheduledFuture<?> scheduledFuture = _p2._d;
                if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                    return;
                }
                _p2._d.cancel(false);
                if (this._b) {
                    CopyOnWriteArraySet copyOnWriteArraySet = _p2._f;
                    copyOnWriteArraySet.clear();
                    copyOnWriteArraySet.addAll(this._a);
                    _p2._a();
                }
                this._a.clear();
                return;
            }
            String key = next.getKey();
            String value = next.getValue();
            concurrentHashMap.remove(key);
            boolean z_a = _c9._a(PtgAdSdk.getContext(), key);
            CopyOnWriteArraySet<String> copyOnWriteArraySet2 = _p2._e;
            copyOnWriteArraySet2.add(value);
            if (z_a) {
                _p2._f.add(value);
                this._a.add(value);
            }
            _p2._a();
            StringBuilder sb = new StringBuilder();
            for (String str : copyOnWriteArraySet2) {
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str).append("@");
                }
            }
            _kr._a(PtgAdSdk.getContext(), "ru_hi_de_to", sb.toString());
        } catch (Exception unused) {
        }
    }
}
