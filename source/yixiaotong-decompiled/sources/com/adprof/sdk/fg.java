package com.adprof.sdk;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class fg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1172a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f291a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List f292a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f293a;

    public fg(int i, byte[] bArr, Map map, List list, boolean z, long j) {
        this.f1172a = i;
        this.f292a = list == null ? null : Collections.unmodifiableList(list);
        this.f293a = z;
        this.f291a = j;
    }

    public static Map a(List list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            w9 w9Var = (w9) it.next();
            treeMap.put(w9Var.f1495a, w9Var.b);
        }
        return treeMap;
    }
}
