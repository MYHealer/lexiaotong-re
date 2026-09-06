package com.opos.cmn.i;

import android.util.LruCache;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d<K, V> extends LruCache<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f6169a;

    public interface a<K, V> {
        void a(K k, V v);
    }

    public d(int i, a<K, V> aVar) {
        super(i);
        this.f6169a = aVar;
    }

    @Override // android.util.LruCache
    protected void entryRemoved(boolean z, K k, V v, V v2) {
        a aVar;
        if (!z || (aVar = this.f6169a) == null) {
            return;
        }
        aVar.a(k, v);
    }
}
