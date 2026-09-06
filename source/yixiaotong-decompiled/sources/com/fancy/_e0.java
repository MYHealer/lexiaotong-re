package com.fancy;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _e0 implements _hu {
    public ArrayList _a = new ArrayList();

    public _e0(_hu... _huVarArr) {
        for (_hu _huVar : _huVarArr) {
            this._a.add(_huVar);
        }
    }

    @Override // com.fancy._hu
    public final boolean _a(_ci _ciVar) {
        Iterator it = this._a.iterator();
        while (it.hasNext()) {
            if (!((_hu) it.next())._a(_ciVar)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.fancy._hu
    public final boolean start() {
        Iterator it = this._a.iterator();
        while (it.hasNext()) {
            if (!((_hu) it.next()).start()) {
                return false;
            }
        }
        return true;
    }
}
