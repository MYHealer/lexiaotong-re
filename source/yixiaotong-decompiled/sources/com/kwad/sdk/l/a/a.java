package com.kwad.sdk.l.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    private final List<b> bmG = new ArrayList();

    public final boolean onBackPressed() {
        Iterator<b> it = this.bmG.iterator();
        while (it.hasNext()) {
            if (it.next().onBackPressed()) {
                return true;
            }
        }
        return false;
    }

    public final void addBackPressable(b bVar) {
        if (bVar != null) {
            this.bmG.add(bVar);
        }
    }

    public final void addBackPressable(b bVar, int i) {
        if (bVar != null) {
            this.bmG.add(i, bVar);
        }
    }

    public final void removeBackPressable(b bVar) {
        if (bVar != null) {
            this.bmG.remove(bVar);
        }
    }
}
