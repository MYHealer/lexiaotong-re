package com.opos.videocache;

import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f8438a;
    public final com.opos.videocache.a.c b;
    public final com.opos.videocache.a.a c;
    public final com.opos.videocache.c.b d;
    public final com.opos.videocache.b.b e;

    l(File file, com.opos.videocache.a.c cVar, com.opos.videocache.a.a aVar, com.opos.videocache.c.b bVar, com.opos.videocache.b.b bVar2) {
        this.f8438a = file;
        this.b = cVar;
        this.c = aVar;
        this.d = bVar;
        this.e = bVar2;
    }

    File a(String str) {
        return new File(this.f8438a, this.b.a(str));
    }
}
