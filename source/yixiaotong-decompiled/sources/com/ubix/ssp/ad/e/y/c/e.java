package com.ubix.ssp.ad.e.y.c;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f8938a = new b(null);

    static /* synthetic */ class a {
    }

    private static class b implements c {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // com.ubix.ssp.ad.e.y.c.e.c
        public <K, V> Map<K, V> a(Map<K, V> map) {
            return map == null ? new HashMap() : map;
        }
    }

    public interface c {
        <K, V> Map<K, V> a(Map<K, V> map);
    }

    private e() {
    }

    public static c a() {
        return f8938a;
    }
}
