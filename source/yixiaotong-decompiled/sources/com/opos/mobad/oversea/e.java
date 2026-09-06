package com.opos.mobad.oversea;

import android.view.View;
import com.opos.mobad.q.i;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e extends i {
    public e(com.opos.mobad.ad.f.c cVar) {
        super(cVar);
    }

    @Override // com.opos.mobad.q.j
    protected boolean c(String str) {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.oversea.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.d(10004, "adItemList is null.");
            }
        });
        return true;
    }

    @Override // com.opos.mobad.ad.f.b
    public View g() {
        return null;
    }
}
