package com.opos.mobad.oversea;

import android.app.Activity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends com.opos.mobad.q.d {
    public b(com.opos.mobad.ad.c.d dVar) {
        super(dVar);
    }

    @Override // com.opos.mobad.q.k
    protected boolean b(Activity activity) {
        return false;
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.oversea.b.1
            @Override // java.lang.Runnable
            public void run() {
                b.this.d(10004, "adItemList is null.");
            }
        });
        return true;
    }
}
