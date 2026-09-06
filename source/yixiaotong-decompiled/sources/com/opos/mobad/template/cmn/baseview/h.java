package com.opos.mobad.template.cmn.baseview;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class h {
    private View b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f7494a = false;
    private Runnable c = new Runnable() { // from class: com.opos.mobad.template.cmn.baseview.h.1
        @Override // java.lang.Runnable
        public void run() {
            h.this.b();
        }
    };

    public h(View view) {
        this.b = null;
        this.b = view;
    }

    private void c() {
        this.b.removeCallbacks(this.c);
        this.b.postDelayed(this.c, 200L);
    }

    public boolean a() {
        com.opos.cmn.an.f.a.b("InterceptViewTool", "checkClickEnable mIsPhysicalClick:" + this.f7494a);
        Boolean boolValueOf = Boolean.valueOf(this.f7494a);
        this.b.removeCallbacks(this.c);
        b();
        return boolValueOf.booleanValue();
    }

    public boolean a(MotionEvent motionEvent) {
        com.opos.cmn.an.f.a.b("InterceptViewTool", "checkTouchEvent:" + (motionEvent != null ? Integer.valueOf(motionEvent.getSource()) : "null") + ";");
        this.f7494a = com.opos.mobad.template.k.a.a(motionEvent);
        c();
        com.opos.cmn.an.f.a.b("InterceptViewTool", "checkTouchEvent isPhysicalClick:" + this.f7494a);
        return this.f7494a;
    }

    public void b() {
        this.f7494a = false;
    }
}
