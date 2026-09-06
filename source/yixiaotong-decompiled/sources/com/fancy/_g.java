package com.fancy;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _g implements _a5 {
    public final CopyOnWriteArraySet _a = new CopyOnWriteArraySet();

    @Override // com.fancy._a5
    public final void _a() {
        Iterator it = this._a.iterator();
        while (it.hasNext()) {
            ((_a5) it.next())._a();
        }
    }

    @Override // com.fancy._a5
    public final void _b() {
        Iterator it = this._a.iterator();
        while (it.hasNext()) {
            ((_a5) it.next())._b();
        }
    }
}
