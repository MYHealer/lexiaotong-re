package com.opos.cmn.module.ui.c.c;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends a {
    private com.opos.cmn.module.ui.c.d.b c;

    public c(Context context, com.opos.cmn.module.ui.c.b.a aVar) {
        super(context, aVar);
        this.c = new com.opos.cmn.module.ui.c.d.b(this.f6217a, aVar);
    }

    @Override // com.opos.cmn.module.ui.c.c.d
    public WindowManager.LayoutParams a() {
        return this.c.a();
    }

    @Override // com.opos.cmn.module.ui.c.c.d
    public void a(int i) {
        this.c.a(i);
    }

    @Override // com.opos.cmn.module.ui.c.c.d
    public void a(int i, int i2, int i3) {
        this.c.a(i, i2, i3);
    }

    @Override // com.opos.cmn.module.ui.c.c.d
    public void a(View view) {
        this.c.a(view);
    }

    @Override // com.opos.cmn.module.ui.c.c.d
    public void b() {
        this.c.b();
    }

    @Override // com.opos.cmn.module.ui.c.c.d
    public void c() {
        this.c.c();
    }
}
