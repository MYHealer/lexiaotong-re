package com.fancy;

import java.util.Calendar;
import java.util.HashSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _e6 implements _hu {
    @Override // com.fancy._hu
    public final boolean _a(_ci _ciVar) {
        HashSet hashSet = _ciVar._k;
        if (hashSet == null || hashSet.size() == 0) {
            return true;
        }
        return _ciVar._k.contains(Long.valueOf(Calendar.getInstance().get(11)));
    }

    @Override // com.fancy._hu
    public final boolean start() {
        return true;
    }
}
