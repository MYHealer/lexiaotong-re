package com.ubix.ssp.ad.e.a0.y.e;

import android.os.SystemClock;
import android.view.View;
import com.ubix.ssp.ad.e.a0.u;
import java.io.Serializable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient WeakReference<View> f8739a;
    private int g;
    private float h;
    private a i;
    private a j;
    private long k;
    private long l;
    private int n;
    private boolean b = false;
    private boolean c = false;
    private boolean d = true;
    private String e = null;
    private boolean f = false;
    private boolean m = false;

    public b(int i, View view, float f, int i2, a aVar, a aVar2) {
        this.n = i;
        this.f8739a = new WeakReference<>(view);
        this.g = i2;
        this.i = aVar;
        this.j = aVar2;
        this.h = f;
    }

    private void c() {
        if (this.m) {
            a aVar = this.j;
            if (aVar != null) {
                aVar.b(this.n);
                return;
            }
            return;
        }
        int i = this.g;
        boolean z = i > 0 && this.l - this.k > ((long) i);
        if (!(this.b || z) || this.j == null) {
            return;
        }
        u.e("onViewAbility per " + this.n);
        if (this.b) {
            this.j.a(this.n);
        } else {
            this.j.b(this.n);
        }
    }

    public a a() {
        return this.i;
    }

    public void b() {
        try {
            synchronized (b.class) {
                try {
                    if (this.k == 0) {
                        this.k = SystemClock.elapsedRealtime();
                    }
                    WeakReference<View> weakReference = this.f8739a;
                    if (weakReference != null && weakReference.get() != null) {
                        if (new d(this.f8739a.get()).a(this.h)) {
                            this.b = true;
                        }
                        this.l = SystemClock.elapsedRealtime();
                    }
                    c();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
