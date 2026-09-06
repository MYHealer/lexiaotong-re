package com.hihonor.hianalytics.hnha;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class g3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<h3> f3641a = new LinkedList();
    private final List<h3> b = new LinkedList();

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(List list) {
        k.a().c((List<h3>) list);
    }

    private void a(List<h3> list, h3 h3Var) {
        int iIndexOf = list.indexOf(h3Var);
        if (iIndexOf >= 0) {
            list.get(iIndexOf).a(h3Var.c());
        } else {
            list.add(h3Var);
        }
    }

    private void a(List<h3> list, List<h3> list2) {
        if (list.isEmpty()) {
            return;
        }
        Iterator<h3> it = list.iterator();
        while (it.hasNext()) {
            a(list2, it.next());
        }
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(List list) {
        k.a().c((List<h3>) list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(List list) {
        k.a().c((List<h3>) list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(List list) {
        k.a().c((List<h3>) list);
    }

    public synchronized void a(String str, int i, int i2, int i3) {
        if (p2.d().i()) {
            k3 k3Var = new k3(str, i, i2, i3, com.hihonor.hianalytics.util.r.b(), com.hihonor.hianalytics.util.r.e());
            if (i3 == 40001) {
                a(this.b, k3Var);
                return;
            }
            final LinkedList linkedList = new LinkedList();
            linkedList.add(k3Var);
            a(this.b, linkedList);
            if (p2.d().i()) {
                t3.d(new r3() { // from class: com.hihonor.hianalytics.hnha.g3$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        g3.c(linkedList);
                    }
                });
            }
        }
    }

    public synchronized void a(String str, int i, String str2, int i2, int i3, Throwable th) {
        a(str, i, str2, com.hihonor.hianalytics.util.r.b(), com.hihonor.hianalytics.util.r.e(), i2, i3, th);
    }

    public synchronized void a(String str, int i, String str2, long j, String str3, int i2, int i3, Throwable th) {
        if (p2.d().i()) {
            i3 i3Var = new i3(str, i, str2, i2, i3, j, str3);
            if (i3 == 10001) {
                a(this.f3641a, i3Var);
                return;
            }
            final LinkedList linkedList = new LinkedList();
            linkedList.add(i3Var);
            a(this.f3641a, linkedList);
            if (p2.d().i()) {
                t3.d(new r3() { // from class: com.hihonor.hianalytics.hnha.g3$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        g3.a(linkedList);
                    }
                });
            }
        }
    }

    public synchronized void a(String str, String str2, int i, int i2, int i3, long j) {
        if (p2.d().i()) {
            final LinkedList linkedList = new LinkedList();
            j3 j3Var = new j3(i, i2, 50000, i3, str2, com.hihonor.hianalytics.util.r.b(), com.hihonor.hianalytics.util.r.e(), str);
            linkedList.add(j3Var);
            if (j3Var.j() && j >= 800) {
                j2.a("StatManager", "onHttpSend type=" + i + ",sendTime=" + j + ",reportType=" + i2 + ",appId=" + str + ",url=" + str2);
                linkedList.add(new j3(i, i2, 50001, i3, str2, com.hihonor.hianalytics.util.r.b(), com.hihonor.hianalytics.util.r.e(), str));
            }
            if (p2.d().i()) {
                t3.d(new r3() { // from class: com.hihonor.hianalytics.hnha.g3$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        g3.b(linkedList);
                    }
                });
            }
        }
    }

    public synchronized void a(List<n0> list, int i, Throwable th) {
        if (p2.d().i()) {
            if (list != null && !list.isEmpty()) {
                HashMap map = new HashMap();
                map.put(Integer.valueOf(i), list);
                a(map, th);
            }
        }
    }

    public synchronized void a(Map<Integer, List<n0>> map, Throwable th) {
        if (p2.d().i()) {
            if (map != null && !map.isEmpty()) {
                final LinkedList linkedList = new LinkedList();
                for (Map.Entry<Integer, List<n0>> entry : map.entrySet()) {
                    int iIntValue = entry.getKey().intValue();
                    List<n0> value = entry.getValue();
                    if (value != null && !value.isEmpty()) {
                        for (n0 n0Var : value) {
                            a(linkedList, new i3(n0Var.l(), n0Var.o(), n0Var.i(), n0Var.w(), n0Var.d(), iIntValue, n0Var.m(), n0Var.n()));
                        }
                    }
                }
                a(this.f3641a, linkedList);
                if (p2.d().i()) {
                    t3.d(new r3() { // from class: com.hihonor.hianalytics.hnha.g3$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            g3.d(linkedList);
                        }
                    });
                }
            }
        }
    }

    public synchronized void e(List<n0> list) {
        if (p2.d().i()) {
            if (list != null && !list.isEmpty()) {
                HashMap map = new HashMap();
                map.put(10000, list);
                a(map, (Throwable) null);
            }
        }
    }
}
