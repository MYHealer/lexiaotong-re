package com.opos.cmn.module.ui.c.c;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f extends b implements e {
    public f(Context context, com.opos.cmn.module.ui.c.a aVar) {
        super(context, aVar);
        if (com.opos.cmn.module.ui.d.a.a()) {
            this.c = new com.opos.cmn.module.ui.c.d.d(this.f6218a, this);
        }
    }

    @Override // com.opos.cmn.module.ui.c.c.e
    public void a() {
        if (!com.opos.cmn.module.ui.d.a.a() || this.c == null) {
            return;
        }
        this.c.a();
    }

    @Override // com.opos.cmn.module.ui.c.c.e
    public void a(View view, String str, Object... objArr) {
        if (this.b != null) {
            this.b.a(view, str, objArr);
        }
    }

    @Override // com.opos.cmn.module.ui.c.c.e
    public void a(View view, int[] iArr, String str, Object... objArr) {
        if (this.b != null) {
            this.b.a(view, iArr, str, objArr);
        }
    }

    @Override // com.opos.cmn.module.ui.c.c.e
    public void a(String str, boolean z, Object... objArr) {
        if (!com.opos.cmn.module.ui.d.a.a() || this.c == null) {
            return;
        }
        this.c.a(str, z, objArr);
    }

    @Override // com.opos.cmn.module.ui.c.c.e
    public void b() {
        if (!com.opos.cmn.module.ui.d.a.a() || this.c == null) {
            return;
        }
        this.c.b();
    }

    @Override // com.opos.cmn.module.ui.c.c.e
    public void b(View view, int[] iArr, String str, Object... objArr) {
        if (this.b != null) {
            this.b.b(view, iArr, str, objArr);
        }
    }
}
