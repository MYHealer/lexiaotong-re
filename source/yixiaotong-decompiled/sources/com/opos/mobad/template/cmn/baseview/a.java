package com.opos.mobad.template.cmn.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends FrameLayout implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f7490a;
    private f b;

    public a(Context context) {
        super(context);
        this.f7490a = new h(this);
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7490a = new h(this);
    }

    public void a(f fVar) {
        this.b = fVar;
    }

    @Override // android.view.View
    public boolean callOnClick() {
        return g.a(this, this.f7490a, this.b) && super.callOnClick();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (g.a(this, this.f7490a, motionEvent, this.b)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        return g.b(this, this.f7490a, this.b) && super.performClick();
    }
}
