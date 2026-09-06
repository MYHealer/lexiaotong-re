package com.opos.mobad.template.cmn;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ah extends Scroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7485a;

    public ah(Context context, Interpolator interpolator) {
        super(context, interpolator);
        this.f7485a = 1000;
    }

    public void a(int i) {
        this.f7485a = i;
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4) {
        super.startScroll(i, i2, i3, i4, this.f7485a);
    }

    @Override // android.widget.Scroller
    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, this.f7485a);
    }
}
