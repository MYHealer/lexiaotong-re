package com.oplus.log.a;

import com.oplus.log.core.c;
import com.oplus.log.d;
import com.oplus.log.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d f5786a;

    public b(c cVar) {
        e eVar = new e();
        this.f5786a = eVar;
        eVar.a(cVar);
    }

    @Override // com.oplus.log.a.a
    public final void a() {
        d dVar = this.f5786a;
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // com.oplus.log.a.a
    public final void a(com.oplus.log.core.e.b bVar) {
        d dVar = this.f5786a;
        if (dVar != null) {
            dVar.a(bVar);
        }
    }

    @Override // com.oplus.log.a.a
    public final void a(String str, String str2, byte b, int i) {
        d dVar = this.f5786a;
        if (dVar != null) {
            dVar.a(str, str2, b, i);
        }
    }
}
