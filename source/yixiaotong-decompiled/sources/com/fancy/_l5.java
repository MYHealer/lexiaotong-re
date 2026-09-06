package com.fancy;

import java.util.Comparator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _l5 implements Comparator<String> {
    @Override // java.util.Comparator
    public final int compare(String str, String str2) {
        return Integer.compare(Integer.parseInt(str), Integer.parseInt(str2));
    }
}
