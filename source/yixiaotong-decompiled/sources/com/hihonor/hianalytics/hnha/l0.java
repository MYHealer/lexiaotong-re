package com.hihonor.hianalytics.hnha;

import android.util.Pair;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f3655a;
    public final List<n0> b;
    public final List<Pair<String, Long>> c;

    public l0(boolean z, List<n0> list) {
        this(z, list, null);
    }

    public l0(boolean z, List<n0> list, List<Pair<String, Long>> list2) {
        this.f3655a = z;
        this.b = list;
        this.c = list2;
    }

    public boolean a() {
        List<Pair<String, Long>> list = this.c;
        return (list == null || list.isEmpty()) ? false : true;
    }
}
