package com.opos.mobad.oversea;

import com.opos.mobad.q.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends h {
    public d(com.opos.mobad.ad.e.b bVar) {
        super(bVar);
    }

    @Override // com.opos.mobad.q.h
    protected boolean b(boolean z) {
        return false;
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.oversea.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.d(10004, "adItemList is null.");
            }
        });
        return true;
    }
}
