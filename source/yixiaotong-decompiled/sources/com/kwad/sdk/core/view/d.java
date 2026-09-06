package com.kwad.sdk.core.view;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {
    private List<c> bbT = new CopyOnWriteArrayList();

    public final void j(View view, boolean z) {
        Iterator<c> it = this.bbT.iterator();
        while (it.hasNext()) {
            it.next().i(view, z);
        }
    }

    public final void a(c cVar) {
        if (c(cVar)) {
            return;
        }
        this.bbT.add(cVar);
    }

    public final void b(c cVar) {
        this.bbT.remove(cVar);
    }

    private boolean c(c cVar) {
        if (cVar != null) {
            return this.bbT.contains(cVar);
        }
        return false;
    }
}
