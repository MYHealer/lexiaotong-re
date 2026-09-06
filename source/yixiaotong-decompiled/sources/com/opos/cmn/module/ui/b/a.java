package com.opos.cmn.module.ui.b;

import android.R;
import android.app.Activity;
import com.opos.cmn.module.ui.b.c.c;
import com.opos.cmn.module.ui.b.f.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f6194a;
    private com.opos.cmn.module.ui.b.f.c b;

    public a(Activity activity) {
        this.f6194a = new c(activity);
        b bVar = new b(activity, new com.opos.cmn.module.ui.b.e.a.C0898a().a(com.opos.cmn.an.h.f.a.a(activity) ? R.style.Theme.Translucent.NoTitleBar.Fullscreen : R.style.Theme.Translucent.NoTitleBar).a(false).b(false).a());
        this.b = bVar;
        bVar.a(this.f6194a.b());
    }

    public void a() {
        if (this.b.a()) {
            this.b.c();
        }
    }

    public void a(String str, String str2, String str3, com.opos.cmn.module.ui.b.d.a aVar) {
        this.f6194a.a((CharSequence) str);
        this.f6194a.b(str2);
        this.f6194a.a(str3);
        this.f6194a.a(aVar);
        this.b.b();
    }
}
