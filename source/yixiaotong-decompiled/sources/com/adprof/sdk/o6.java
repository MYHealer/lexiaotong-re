package com.adprof.sdk;

import java.util.Comparator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class o6 implements Comparator {
    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return Integer.compare(((byte[]) obj).length, ((byte[]) obj2).length);
    }
}
