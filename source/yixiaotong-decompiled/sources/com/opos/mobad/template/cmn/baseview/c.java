package com.opos.mobad.template.cmn.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends RelativeLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f7492a;
    protected f k;

    public c(Context context) {
        super(context);
        this.f7492a = new h(this);
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7492a = new h(this);
    }

    @Override // com.opos.mobad.template.cmn.baseview.e
    public void a(f fVar) {
        this.k = fVar;
    }

    @Override // android.view.View
    public boolean callOnClick() {
        return g.a(this, this.f7492a, this.k) && super.callOnClick();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (g.a(this, this.f7492a, motionEvent, this.k)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        return g.b(this, this.f7492a, this.k) && super.performClick();
    }
}
