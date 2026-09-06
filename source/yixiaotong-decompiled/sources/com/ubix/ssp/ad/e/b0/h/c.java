package com.ubix.ssp.ad.e.b0.h;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f8780a;
    public final com.ubix.ssp.ad.e.b0.h.s.c b;
    public final com.ubix.ssp.ad.e.b0.h.s.a c;
    public final com.ubix.ssp.ad.e.b0.h.u.c d;
    public final com.ubix.ssp.ad.e.b0.h.t.b e;

    c(File file, com.ubix.ssp.ad.e.b0.h.s.c cVar, com.ubix.ssp.ad.e.b0.h.s.a aVar, com.ubix.ssp.ad.e.b0.h.u.c cVar2, com.ubix.ssp.ad.e.b0.h.t.b bVar) {
        this.f8780a = file;
        this.b = cVar;
        this.c = aVar;
        this.d = cVar2;
        this.e = bVar;
    }

    File a(String str) {
        return new File(this.f8780a, this.b.a(str));
    }
}
