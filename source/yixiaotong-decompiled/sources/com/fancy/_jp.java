package com.fancy;

import android.util.Pair;
import java.util.Comparator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _jp implements Comparator<Pair<Integer, _n8>> {
    @Override // java.util.Comparator
    public final int compare(Pair<Integer, _n8> pair, Pair<Integer, _n8> pair2) {
        return ((Integer) pair.first).intValue() - ((Integer) pair2.first).intValue();
    }
}
