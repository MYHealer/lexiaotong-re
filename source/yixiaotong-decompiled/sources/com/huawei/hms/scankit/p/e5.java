package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ParticleProperties.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class e5 implements p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<p3> f4239a = new ArrayList();

    @Override // com.huawei.hms.scankit.p.p3
    public void a(b5 b5Var) {
        Iterator<p3> it = this.f4239a.iterator();
        while (it.hasNext()) {
            it.next().a(b5Var);
        }
    }

    public void a(p3 p3Var) {
        if (this.f4239a == null) {
            this.f4239a = new ArrayList();
        }
        this.f4239a.add(p3Var);
    }
}
