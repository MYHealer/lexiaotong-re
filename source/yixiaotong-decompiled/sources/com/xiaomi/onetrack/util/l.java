package com.xiaomi.onetrack.util;

import android.text.TextUtils;
import android.util.LruCache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public final class l extends LruCache<String, k.a> {
    public l(int i) {
        super(i);
    }

    @Override // android.util.LruCache
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int sizeOf(String str, k.a aVar) {
        if (aVar == null || TextUtils.isEmpty(aVar.f9517a)) {
            return 0;
        }
        return aVar.f9517a.length();
    }
}
