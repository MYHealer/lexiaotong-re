package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<p0> f3652a;
    public final long b;
    public final boolean c;
    public final long d = CacheDataSink.DEFAULT_FRAGMENT_SIZE;
    public List<Pair<String, Long>> e;

    public k0(List<p0> list, long j, boolean z, List<Pair<String, Long>> list2) {
        this.f3652a = list;
        this.b = j;
        this.c = z;
        this.e = list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(Pair pair, Pair pair2) {
        if (pair == pair2) {
            return 0;
        }
        if (pair == null) {
            return -1;
        }
        if (pair2 == null) {
            return 1;
        }
        Object obj = pair.second;
        long jLongValue = obj == null ? 0L : ((Long) obj).longValue();
        Object obj2 = pair2.second;
        long jLongValue2 = obj2 != null ? ((Long) obj2).longValue() : 0L;
        if (jLongValue == jLongValue2) {
            return 0;
        }
        return jLongValue < jLongValue2 ? -1 : 1;
    }

    public synchronized List<String> a() {
        List<Pair<String, Long>> list = this.e;
        int size = list == null ? 0 : list.size();
        if (size == 0) {
            return Collections.emptyList();
        }
        Collections.sort(this.e, new Comparator() { // from class: com.hihonor.hianalytics.hnha.k0$$ExternalSyntheticLambda0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return k0.a((Pair) obj, (Pair) obj2);
            }
        });
        LinkedList linkedList = new LinkedList();
        long jLongValue = 0;
        while (size > 0) {
            Pair<String, Long> pair = this.e.get(0);
            Object obj = pair.second;
            jLongValue += obj == null ? 0L : ((Long) obj).longValue();
            if (jLongValue > this.d && !linkedList.isEmpty()) {
                break;
            }
            this.e.remove(0);
            linkedList.add((String) pair.first);
            size--;
            if (linkedList.size() >= 10) {
                break;
            }
        }
        return linkedList;
    }

    public synchronized void a(String str, long j) {
        if (!TextUtils.isEmpty(str) && j >= 0) {
            if (this.e == null) {
                this.e = new LinkedList();
            }
            this.e.add(Pair.create(str, Long.valueOf(j)));
        }
    }

    public synchronized int b() {
        List<Pair<String, Long>> list;
        list = this.e;
        return list == null ? 0 : list.size();
    }

    public boolean c() {
        return this.f3652a.isEmpty();
    }

    public String toString() {
        StringBuilder sbAppend = new StringBuilder("EventSendQueryParam#").append(hashCode()).append("{startId=").append(this.b).append(",isFirstQuery=").append(this.c).append(",tagTypeInfoSize=").append(this.f3652a.size()).append(",reqIdMapSize=");
        List<Pair<String, Long>> list = this.e;
        return sbAppend.append(list == null ? 0 : list.size()).append('}').toString();
    }
}
