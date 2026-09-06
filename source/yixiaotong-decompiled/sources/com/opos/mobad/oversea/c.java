package com.opos.mobad.oversea;

import com.opos.mobad.ad.d.f;
import com.opos.mobad.ad.d.q;
import com.opos.mobad.ad.d.r;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c implements com.opos.mobad.ad.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f7239a;
    private boolean b = false;

    public c(f fVar) {
        this.f7239a = fVar;
    }

    @Override // com.opos.mobad.ad.d.c
    public void a() {
        this.b = true;
    }

    @Override // com.opos.mobad.ad.d.c
    public void a(r rVar) {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.oversea.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.b || c.this.f7239a == null) {
                    return;
                }
                c.this.f7239a.a(new q(10004, "adItemList is null."));
            }
        });
    }
}
