package com.fancy;

import com.fancy.adsdk.lib.utils.Logger;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _ho implements _hu {
    public String _a;

    public _ho(String str) {
        this._a = str;
    }

    @Override // com.fancy._hu
    public final boolean _a(_ci _ciVar) {
        HashSet hashSet = _ciVar._l;
        if (hashSet == null || hashSet.size() == 0) {
            return true;
        }
        Logger.d("OsVersionFilter", String.format("matchPolicyItem: %s", this._a));
        Iterator it = _ciVar._l.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(this._a)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.fancy._hu
    public final boolean start() {
        return true;
    }
}
