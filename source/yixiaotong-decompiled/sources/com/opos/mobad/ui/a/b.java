package com.opos.mobad.ui.a;

import android.content.Context;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Context f8268a;
    protected e b;
    protected RelativeLayout c;
    protected RelativeLayout d;

    public b(Context context, e eVar) {
        this.f8268a = context;
        this.b = eVar;
        d();
    }

    private void d() {
        this.c = new RelativeLayout(this.f8268a);
        a();
        this.d = new RelativeLayout(this.f8268a);
        b();
        c();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.c.addView(this.d, layoutParams);
    }

    protected abstract void a();

    protected abstract void b();

    protected abstract void c();
}
