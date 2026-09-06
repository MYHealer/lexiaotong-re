package com.opos.mobad.template.cmn.baseview;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends View implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private h f7493a;
    private f b;

    public d(Context context) {
        super(context);
        this.f7493a = new h(this);
    }

    @Override // com.opos.mobad.template.cmn.baseview.e
    public void a(f fVar) {
        this.b = fVar;
    }

    @Override // android.view.View
    public boolean callOnClick() {
        return g.a(this, this.f7493a, this.b) && super.callOnClick();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (g.a(this, this.f7493a, motionEvent, this.b)) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        return g.b(this, this.f7493a, this.b) && super.performClick();
    }
}
