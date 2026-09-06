package com.oplus.log.core;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {
    public String b;
    public long c;
    public h d;
    private String e;
    private String f;
    private long g;
    private long h;
    private long i;
    private String j;
    private String k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentLinkedQueue<e> f5804a = new ConcurrentLinkedQueue<>();
    private SimpleDateFormat l = new SimpleDateFormat("yyyy-MM-dd");

    d(c cVar) {
        if (TextUtils.isEmpty(cVar.f5802a) || TextUtils.isEmpty(cVar.b) || cVar.h == null || cVar.i == null) {
            throw new NullPointerException("config's param is invalid");
        }
        this.b = cVar.b;
        this.e = cVar.f5802a;
        this.f = cVar.c;
        this.g = cVar.e;
        this.i = cVar.g;
        this.h = cVar.d;
        this.c = cVar.f;
        this.j = new String(cVar.h);
        this.k = new String(cVar.i);
        if (this.d == null) {
            h hVar = new h(this.f5804a, this.e, this.b, this.g, this.h, this.i, this.j, this.k, this.f);
            this.d = hVar;
            hVar.setName("logan-thread");
            this.d.start();
        }
    }

    final void a(e.b bVar) {
        if (TextUtils.isEmpty(this.b)) {
            return;
        }
        e eVar = new e();
        eVar.f5805a = e.a.c;
        eVar.b = bVar;
        this.f5804a.add(eVar);
        h hVar = this.d;
        if (hVar != null) {
            hVar.a();
        }
    }

    public final void a(i iVar) {
        this.d.f5808a = iVar;
    }
}
