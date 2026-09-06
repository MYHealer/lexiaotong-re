package com.ubix.ssp.ad.e.y.c;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final Charset f8937a = Charset.forName("UTF-8");
    protected static final Charset b = Charset.forName("ISO-8859-1");
    public static final Object c = new Object();

    private c() {
    }

    public static <K, V> int a(Map<K, V> map, int i, int i2, int i3) {
        int iG = b.g(i);
        int iD = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (key == null || value == null) {
                throw new IllegalStateException("keys and values in maps cannot be null");
            }
            int iA = b.a(1, i2, key) + b.a(2, i3, value);
            iD += iG + iA + b.d(iA);
        }
        return iD;
    }

    private static Object a(int i) {
        switch (i) {
            case 1:
                return Double.valueOf(0.0d);
            case 2:
                return Float.valueOf(0.0f);
            case 3:
            case 4:
            case 6:
            case 16:
            case 18:
                return 0L;
            case 5:
            case 7:
            case 13:
            case 14:
            case 15:
            case 17:
                return 0;
            case 8:
                return Boolean.FALSE;
            case 9:
                return "";
            case 10:
            case 11:
            default:
                throw new IllegalArgumentException("Type: " + i + " is not a primitive type.");
            case 12:
                return h.h;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <K, V> Map<K, V> a(a aVar, Map<K, V> map, e.c cVar, int i, int i2, V v, int i3, int i4) throws d {
        Map<K, V> mapA = cVar.a(map);
        int iD = aVar.d(aVar.p());
        Object objA = null;
        while (true) {
            int iW = aVar.w();
            if (iW == 0) {
                break;
            }
            if (iW == i3) {
                objA = aVar.e(i);
            } else if (iW == i4) {
                if (i2 == 11) {
                    aVar.a((f) v);
                } else {
                    v = (V) aVar.e(i2);
                }
            } else if (!aVar.h(iW)) {
                break;
            }
        }
        aVar.a(0);
        aVar.c(iD);
        if (objA == null) {
            objA = a(i);
        }
        if (v == 0) {
            v = a(i2);
        }
        mapA.put(objA, v);
        return mapA;
    }

    public static <K, V> void a(b bVar, Map<K, V> map, int i, int i2, int i3) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (key == null || value == null) {
                throw new IllegalStateException("keys and values in maps cannot be null");
            }
            int iA = b.a(1, i2, key) + b.a(2, i3, value);
            bVar.l(i, 2);
            bVar.o(iA);
            bVar.b(1, i2, key);
            bVar.b(2, i3, value);
        }
    }
}
