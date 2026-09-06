package com.baidu.mobads.sdk.internal;

import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class ar implements Comparator<Map.Entry<String, Long>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ aq f1728a;

    ar(aq aqVar) {
        this.f1728a = aqVar;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Map.Entry<String, Long> entry, Map.Entry<String, Long> entry2) {
        return entry2.getValue().compareTo(entry.getValue());
    }
}
