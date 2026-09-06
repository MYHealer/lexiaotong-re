package com.adprof.sdk;

import android.view.MotionEvent;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class m4 implements z4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference f1300a;
    public final WeakReference b;

    public m4(d dVar, n4 n4Var) {
        this.f1300a = new WeakReference(dVar);
        this.b = new WeakReference(n4Var);
    }

    public final void a(d dVar, MotionEvent motionEvent) {
        try {
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            if (motionEvent.getAction() == 0) {
                dVar.m591a().a(motionEventObtain);
            } else if (motionEvent.getAction() == 1) {
                dVar.m591a().c(motionEventObtain);
            }
        } catch (Throwable th) {
            pk.a(th);
            oh.b(th);
        }
    }

    public boolean a(MotionEvent motionEvent) {
        d dVar = (d) this.f1300a.get();
        n4 n4Var = (n4) this.b.get();
        if (dVar == null) {
            return false;
        }
        dVar.f206h = "2";
        a(dVar, motionEvent);
        if (n4Var != null) {
            if (((p5) n4Var).f546a != null) {
                n4Var.mo698a().a(((p5) n4Var).f546a, "click", new HashMap());
            }
            n4Var.b();
        }
        r4.a(dVar);
        return true;
    }
}
