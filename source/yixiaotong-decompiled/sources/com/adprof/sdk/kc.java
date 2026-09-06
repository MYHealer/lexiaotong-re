package com.adprof.sdk;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class kc {
    public static List a() {
        return new ve(Collections.emptyList());
    }

    public static List a(String str, List list) {
        if (list == null) {
            throw new NullPointerException(str + " == null");
        }
        if (list instanceof ve) {
            list = ((ve) list).b;
        }
        if (list == Collections.emptyList() || (list instanceof ac)) {
            return list;
        }
        ac acVar = new ac(list);
        if (acVar.contains(null)) {
            throw new IllegalArgumentException(str + ".contains(null)");
        }
        return acVar;
    }

    public static void a(List list) {
        if (list == null) {
            throw new NullPointerException("list == null");
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == null) {
                throw new NullPointerException("Element at index " + i + " is null");
            }
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }
}
