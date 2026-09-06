package com.opos.cmn.module.ui.b.f;

import android.app.Activity;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends a {
    private com.opos.cmn.module.ui.b.g.a c;

    public b(Activity activity, com.opos.cmn.module.ui.b.e.a aVar) {
        super(activity, aVar);
        this.f6211a = activity;
        this.b = aVar;
        this.c = (aVar == null || aVar.f6209a == 0) ? new com.opos.cmn.module.ui.b.g.a(activity, aVar) : new com.opos.cmn.module.ui.b.g.a(activity, aVar.f6209a, aVar);
        com.opos.cmn.module.ui.d.a.a(activity, this.c);
    }

    @Override // com.opos.cmn.module.ui.b.f.c
    public void a(View view) {
        if (view != null) {
            this.c.setContentView(view);
        }
    }

    @Override // com.opos.cmn.module.ui.b.f.c
    public boolean a() {
        return this.c.isShowing();
    }

    @Override // com.opos.cmn.module.ui.b.f.c
    public void b() {
        this.c.show();
    }

    @Override // com.opos.cmn.module.ui.b.f.c
    public void c() {
        this.c.dismiss();
    }
}
