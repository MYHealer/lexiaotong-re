package com.byazt.ip;

import com.byazt.ip.tt;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, 1363, 54})
public abstract class ve<T, F extends tt> {
    public final List<a<?>> c = new CopyOnWriteArrayList();
    public T tt;
    public F ve;

    public final F getContext() {
        return this.ve;
    }

    public final void c(a<?> aVar) {
        if (aVar != null) {
            this.c.add(aVar);
        }
    }

    public final void tt(a<?> aVar) {
        if (aVar != null) {
            this.c.remove(aVar);
        }
    }
}
