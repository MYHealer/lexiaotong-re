package com.fancy;

import java.util.Comparator;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _jm implements Comparator<_bg> {
    @Override // java.util.Comparator
    public final int compare(_bg _bgVar, _bg _bgVar2) {
        _bg _bgVar3 = _bgVar;
        _ci _ciVar = _bgVar2._c;
        long j = _ciVar != null ? _ciVar._h : 0L;
        _ci _ciVar2 = _bgVar3._c;
        return Long.compare(j, _ciVar2 != null ? _ciVar2._h : 0L);
    }
}
