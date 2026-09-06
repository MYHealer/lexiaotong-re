package com.fancy;

import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _fm {
    public static final SparseArray<_a> _a = new SparseArray<>();

    public static class _a {
        public final LinkedList<WeakReference<com.fancy.adsdk.lib.doodle._c>> _a = new LinkedList<>();

        public final void _a(com.fancy.adsdk.lib.doodle._c _cVar) {
            Iterator<WeakReference<com.fancy.adsdk.lib.doodle._c>> itDescendingIterator = this._a.descendingIterator();
            while (itDescendingIterator.hasNext()) {
                com.fancy.adsdk.lib.doodle._c _cVar2 = itDescendingIterator.next().get();
                if (_cVar2 == null || _cVar2 == _cVar) {
                    itDescendingIterator.remove();
                    return;
                }
            }
        }
    }

    public static synchronized void _a(Object obj, int i) {
        com.fancy.adsdk.lib.doodle._d._a _aVar;
        if (obj == null) {
            return;
        }
        int iIdentityHashCode = System.identityHashCode(obj);
        SparseArray<_a> sparseArray = _a;
        int iIndexOfKey = sparseArray.indexOfKey(iIdentityHashCode);
        if (iIndexOfKey >= 0) {
            _a _aVarValueAt = sparseArray.valueAt(iIndexOfKey);
            if (i == 3) {
                sparseArray.removeAt(iIndexOfKey);
            }
            Iterator<WeakReference<com.fancy.adsdk.lib.doodle._c>> it = _aVarValueAt._a.iterator();
            while (it.hasNext()) {
                com.fancy.adsdk.lib.doodle._c _cVar = it.next().get();
                if (_cVar != null && !_cVar._d.get() && _cVar._c != 3) {
                    if (i == 1) {
                        _aVar = _cVar._g ? com.fancy.adsdk.lib.doodle._d._b : com.fancy.adsdk.lib.doodle._d._a;
                        com.fancy.adsdk.lib.doodle._c._a _aVar2 = _cVar._a;
                        synchronized (_aVar) {
                            LinkedList<Runnable> linkedList = _aVar._a;
                            LinkedList<Runnable> linkedList2 = _aVar._b;
                            if (!linkedList.isEmpty()) {
                                Iterator<Runnable> it2 = linkedList.iterator();
                                while (it2.hasNext()) {
                                    Runnable next = it2.next();
                                    if (next == _aVar2 || ((next instanceof com.fancy.adsdk.lib.doodle._d._c) && ((com.fancy.adsdk.lib.doodle._d._c) next)._a == _aVar2)) {
                                        it2.remove();
                                        linkedList2.offer(next);
                                        break;
                                    }
                                }
                            }
                        }
                    } else if (i == 2) {
                        _aVar = _cVar._g ? com.fancy.adsdk.lib.doodle._d._b : com.fancy.adsdk.lib.doodle._d._a;
                        com.fancy.adsdk.lib.doodle._c._a _aVar3 = _cVar._a;
                        synchronized (_aVar) {
                            LinkedList<Runnable> linkedList3 = _aVar._b;
                            LinkedList<Runnable> linkedList4 = _aVar._a;
                            if (!linkedList3.isEmpty()) {
                                Iterator<Runnable> it3 = linkedList3.iterator();
                                while (it3.hasNext()) {
                                    Runnable next2 = it3.next();
                                    if (next2 == _aVar3 || ((next2 instanceof com.fancy.adsdk.lib.doodle._d._c) && ((com.fancy.adsdk.lib.doodle._d._c) next2)._a == _aVar3)) {
                                        it3.remove();
                                        linkedList4.offer(next2);
                                        break;
                                    }
                                }
                            }
                        }
                    } else if (i == 3) {
                        _cVar._f = 0;
                        _cVar._d.set(true);
                        _cVar._a.cancel(true);
                    }
                }
            }
        }
    }
}
