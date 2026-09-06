package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class d extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f8066a;
    protected boolean b;
    protected int c;
    protected int d;
    protected boolean e;
    private boolean f;
    private int[] g;

    public d(Context context) {
        super(context);
        this.f = true;
        this.f8066a = 0;
        this.g = new int[]{2, 4, 7};
        this.c = ColorUtils.setAlphaComponent(-1, 51);
        this.d = Color.parseColor("#247CFF");
    }

    protected int a(int i) {
        return this.g[i];
    }

    protected abstract void a();

    public void a(long j, long j2) {
        int i = ((int) j) / 1000;
        boolean z = (j2 - j > 1500 || this.f8066a == 3 || this.f) ? false : true;
        this.b = z;
        if (z) {
            c();
            this.f8066a = 3;
            return;
        }
        if (i == a(0) && this.f8066a == 0) {
            a();
            this.f8066a = 1;
            return;
        }
        if (i == a(1) && this.f8066a == 1) {
            if (!this.f) {
                b();
                this.f8066a = 2;
                return;
            }
        } else if (i != a(2) || this.f8066a != 2) {
            return;
        }
        c();
        this.f8066a = 3;
    }

    public abstract void a(Bitmap bitmap);

    public abstract void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a);

    public void a(com.opos.mobad.template.cmn.p pVar) {
        com.opos.mobad.template.cmn.p.a(this, pVar);
    }

    public abstract void a(com.opos.mobad.template.cmn.q qVar);

    public abstract void a(com.opos.mobad.template.d.b bVar);

    public void a(boolean z) {
        this.f = z;
    }

    protected abstract void b();

    protected abstract void c();

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        this.e = false;
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.e = true;
        super.onDetachedFromWindow();
    }
}
