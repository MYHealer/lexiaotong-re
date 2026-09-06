package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ParticleAnimators.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class c5 implements o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<o3> f4226a = new ArrayList();

    @Override // com.huawei.hms.scankit.p.o3
    public void a(b5 b5Var, long j) {
        Iterator<o3> it = this.f4226a.iterator();
        while (it.hasNext()) {
            it.next().a(b5Var, j);
        }
    }

    public void a(o3 o3Var) {
        if (this.f4226a == null) {
            this.f4226a = new ArrayList();
        }
        this.f4226a.add(o3Var);
    }
}
