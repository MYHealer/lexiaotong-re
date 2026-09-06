package com.hihonor.hianalytics.hnha;

import android.util.Pair;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class s2 extends t2 {
    @Override // com.hihonor.hianalytics.hnha.t2
    public synchronized void a(String str) {
        j2.g("EventDirectBootManager", "DirectBoot not allow notifyReportHandleEnd");
    }

    @Override // com.hihonor.hianalytics.hnha.t2
    public synchronized void a(String str, int i, int i2) {
        j2.g("EventDirectBootManager", "DirectBoot not allow onReport");
    }

    @Override // com.hihonor.hianalytics.hnha.t2
    public synchronized void a(List<p0> list, int i) {
        j2.g("EventDirectBootManager", "DirectBoot not allow reportDelayCacheEvent");
    }

    @Override // com.hihonor.hianalytics.hnha.t2
    protected boolean a() {
        return false;
    }

    @Override // com.hihonor.hianalytics.hnha.t2
    public boolean a(String str, int i) {
        j2.g("EventDirectBootManager", "DirectBoot not allow hasCachedData");
        return false;
    }

    @Override // com.hihonor.hianalytics.hnha.t2
    protected boolean b(n0 n0Var) {
        Pair<Integer, Boolean> pairA = a(n0Var);
        j2.c("EventDirectBootManager", "handleStreamEvent nowSize=" + pairA.first + ",isAddTask=" + pairA.second);
        return true;
    }

    @Override // com.hihonor.hianalytics.hnha.t2
    protected r3 e() {
        return new y2();
    }

    @Override // com.hihonor.hianalytics.hnha.t2
    public synchronized Map<p0, Integer> f() {
        j2.g("EventDirectBootManager", "DirectBoot not allow getToHandleReports");
        return new HashMap();
    }
}
