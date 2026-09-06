package com.opos.cmn.func.dl.base.a.a;

import android.content.Context;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.opos.cmn.func.dl.base.f.a f6106a;
    public e[] b;
    Context c;

    public d(Context context, com.opos.cmn.func.dl.base.f.a aVar, int i) {
        this.f6106a = aVar;
        this.c = context;
        this.b = new e[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.b[i2] = new e(this);
            aVar.c.f().c().execute(this.b[i2]);
        }
    }

    public final com.opos.cmn.func.dl.base.a.c a(int i) {
        return this.f6106a.b.get(Integer.valueOf(i));
    }

    public final synchronized void a(a aVar) {
        for (e eVar : this.b) {
            if (eVar.b.containsKey(Integer.valueOf(aVar.b))) {
                eVar.a(aVar);
                return;
            }
        }
        e eVar2 = null;
        for (e eVar3 : this.b) {
            if (eVar2 == null || eVar2.a() > eVar3.a()) {
                eVar2 = eVar3;
            }
        }
        if (eVar2 != null) {
            eVar2.a(aVar);
        }
    }

    public final void b(int i) {
        for (e eVar : this.b) {
            if (eVar.b.containsKey(Integer.valueOf(i))) {
                ArrayList arrayList = new ArrayList();
                for (a aVar : eVar.c) {
                    if (aVar.b == i) {
                        arrayList.add(aVar);
                    }
                }
                eVar.c.removeAll(arrayList);
                eVar.a(i);
            }
        }
    }
}
