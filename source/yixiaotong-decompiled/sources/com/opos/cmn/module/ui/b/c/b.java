package com.opos.cmn.module.ui.b.c;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f6202a;
    protected com.opos.cmn.module.ui.b.b.a b;
    protected RelativeLayout c;
    protected ImageView d;

    public b(Context context) {
        this.f6202a = context;
        f();
        b();
        g();
    }

    private void f() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f6202a);
        this.c = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        a();
    }

    private void g() {
        this.b = new com.opos.cmn.module.ui.b.b.b(this.d);
    }

    protected abstract void a();

    protected abstract void b();

    public View c() {
        return this.c;
    }

    public void d() {
        this.b.a();
    }

    public void e() {
        this.b.b();
    }
}
