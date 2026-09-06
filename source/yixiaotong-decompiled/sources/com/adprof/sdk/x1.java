package com.adprof.sdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class x1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1512a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f822a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List f823a;

    public x1(si siVar) {
        try {
            Integer num = siVar.f1423a;
            this.f1512a = num != null ? num.intValue() : 0;
            Long l = siVar.f723a;
            if (l != null) {
                l.intValue();
            }
            Long l2 = siVar.b;
            if (l2 != null) {
                l2.intValue();
            }
            Long l3 = siVar.c;
            this.f822a = l3 != null ? l3.longValue() : 0L;
            this.f823a = new ArrayList();
            List list = siVar.f724a;
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    this.f823a.add(new q0((zi) it.next()));
                }
            }
            pk.d("有效期 = " + this.f822a);
        } catch (Exception e) {
            pk.b("adprofsdk", e);
        }
    }
}
