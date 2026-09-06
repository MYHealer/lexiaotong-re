package com.opos.mobad.oversea;

import android.app.Activity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends com.opos.mobad.q.c {
    public a(com.opos.mobad.ad.c.b bVar) {
        super(bVar);
    }

    @Override // com.opos.mobad.q.k
    protected boolean b(Activity activity) {
        return false;
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.oversea.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.d(10004, "adItemList is null.");
            }
        });
        return true;
    }
}
