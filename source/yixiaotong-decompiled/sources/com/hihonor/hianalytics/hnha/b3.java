package com.hihonor.hianalytics.hnha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class b3 implements r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3626a;
    private Map<p0, Integer> b = new HashMap();
    private List<p0> c = Collections.emptyList();

    public b3(String str) {
        this.f3626a = str;
    }

    private String a() {
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.b.size()).append(",").append(this.c.size());
        if (!this.b.isEmpty()) {
            sb.append(",tagTypeValue=(");
            for (Map.Entry<p0, Integer> entry : this.b.entrySet()) {
                sb.append(entry.getKey().c()).append(com.huawei.openalliance.ad.constant.x.A).append(entry.getValue()).append(",");
            }
            sb.append(")");
        }
        return sb.append(")").toString();
    }

    @Override // java.lang.Runnable
    public void run() {
        int iA;
        long jA = com.hihonor.hianalytics.util.r.a();
        this.b = p2.c().f();
        long jA2 = com.hihonor.hianalytics.util.r.a() - jA;
        p2.d().a(this.b);
        if (this.b.isEmpty()) {
            j2.c("NewEventReportTask", "report haNoTagTypeTime=(" + com.hihonor.hianalytics.util.r.b(jA2) + "),taskId=" + this.f3626a);
            p2.c().a(this.f3626a);
            return;
        }
        int iA2 = p2.d().a((String) null);
        if ((iA2 >= 4) && (iA2 <= 6)) {
            j2.c("NewEventReportTask", "report haForbidReport=(" + com.hihonor.hianalytics.util.r.b(jA2) + "),taskId=" + this.f3626a + ",reportableState=" + iA2);
            p2.c().a(this.f3626a);
            return;
        }
        LinkedList linkedList = new LinkedList();
        int iIntValue = -1;
        boolean z = true;
        boolean z2 = false;
        for (Map.Entry<p0, Integer> entry : this.b.entrySet()) {
            p0 key = entry.getKey();
            if (key.e()) {
                iIntValue = entry.getValue().intValue();
                z2 = true;
            } else if (!key.d()) {
                z = false;
            }
            linkedList.add(key);
        }
        this.c = linkedList;
        List<p0> listD = k.a().d();
        j.b(listD);
        int i = k.a().i();
        if (z2) {
            this.c = listD;
            iA = k.a().a();
        } else {
            if (!z) {
                this.c = new ArrayList();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    int iIndexOf = listD.indexOf((p0) it.next());
                    if (iIndexOf >= 0) {
                        this.c.add(listD.get(iIndexOf));
                    }
                }
            }
            Iterator<p0> it2 = listD.iterator();
            while (it2.hasNext()) {
                p0 next = it2.next();
                if (!this.c.contains(next)) {
                    int size = this.c.size() - 1;
                    while (size >= 0) {
                        p0 p0Var = this.c.get(size);
                        if (next.a(p0Var)) {
                            this.c.add(next);
                            Map<p0, Integer> map = this.b;
                            map.put(next, map.get(p0Var));
                        }
                        size--;
                        it2 = it2;
                    }
                }
            }
            iA = 0;
        }
        j2.c("NewEventReportTask", "report haEventTime=(" + com.hihonor.hianalytics.util.r.b(jA2) + "," + com.hihonor.hianalytics.util.r.b((com.hihonor.hianalytics.util.r.a() - jA) - jA2) + "),tagTypeDesc=" + a() + ",isAllOK=" + z + ",updateNum=" + i + ",autoRemoveNum=" + iA + ",isReportAll=" + z2 + ",reportAllType=" + iIntValue + ",taskId=" + this.f3626a + ",reportableState=" + iA2);
        new z2(this.f3626a, this.b, this.c, z2, iIntValue).run();
    }
}
