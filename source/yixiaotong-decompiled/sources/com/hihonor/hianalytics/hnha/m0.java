package com.hihonor.hianalytics.hnha;

import android.util.Pair;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f3659a = -1;
    private int b = -1;
    private final Map<p0, Pair<Long, Integer>> c = new HashMap();

    public int a(p0 p0Var) {
        Pair<Long, Integer> pair = this.c.get(p0Var);
        return Math.max(0, pair == null ? 0 : ((Integer) pair.second).intValue());
    }

    public long a() {
        return this.f3659a;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(long j) {
        this.f3659a = j;
    }

    public void a(p0 p0Var, long j, int i) {
        this.c.put(p0Var, Pair.create(Long.valueOf(j), Integer.valueOf(i)));
    }

    public long b(p0 p0Var) {
        Pair<Long, Integer> pair = this.c.get(p0Var);
        return Math.max(0L, pair == null ? 0L : ((Long) pair.first).longValue());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("EventStoreState#");
        sb.append(hashCode()).append("{totalSize=").append(this.f3659a).append(",totalNum=").append(this.b).append(",info=(").append(this.c.size()).append(",");
        for (Map.Entry<p0, Pair<Long, Integer>> entry : this.c.entrySet()) {
            sb.append(entry.getKey().c()).append(com.huawei.openalliance.ad.constant.x.bQ).append(entry.getValue());
            sb.append(",");
        }
        return sb.append(")").toString();
    }
}
