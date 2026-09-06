package com.oplus.instant.router.d;

import android.content.Context;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class e extends a {
    e(b bVar) {
        super(bVar);
    }

    @Override // com.oplus.instant.router.Instant.Req
    public void preload(Context context) {
        com.oplus.instant.router.g.e.b(StubApp.getOrigApplicationContext(context.getApplicationContext()), this.f, this.f5772a, this.b, this.c, this.d, this.e);
    }

    @Override // com.oplus.instant.router.Instant.Req
    public void request(Context context) {
        com.oplus.instant.router.g.e.a(context, this.f, this.f5772a, this.b, this.c, this.d, this.e);
    }
}
