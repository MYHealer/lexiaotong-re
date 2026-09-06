package com.oplus.instant.router.d;

import com.oplus.instant.router.Instant;
import com.oplus.instant.router.callback.Callback;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class a extends Instant.Req {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<String, String> f5772a;
    Map<String, String> b;
    Map<String, String> c;
    Map<String, String> d;
    Callback e;
    String f;

    a(b bVar) {
        this.f5772a = bVar.f5773a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
    }
}
