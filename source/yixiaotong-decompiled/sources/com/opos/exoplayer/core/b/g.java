package com.opos.exoplayer.core.b;

import com.opos.exoplayer.core.b.e;
import com.opos.exoplayer.core.b.f;
import java.lang.Exception;
import java.util.LinkedList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class g<I extends e, O extends f, E extends Exception> implements c<I, O, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Thread f6277a;
    private final Object b = new Object();
    private final LinkedList<I> c = new LinkedList<>();
    private final LinkedList<O> d = new LinkedList<>();
    private final I[] e;
    private final O[] f;
    private int g;
    private int h;
    private I i;
    private E j;
    private boolean k;
    private boolean l;
    private int m;

    class a extends Thread {
        a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            g.this.k();
        }
    }

    protected g(I[] iArr, O[] oArr) {
        this.e = iArr;
        this.g = iArr.length;
        for (int i = 0; i < this.g; i++) {
            ((I[]) this.e)[i] = g();
        }
        this.f = oArr;
        this.h = oArr.length;
        for (int i2 = 0; i2 < this.h; i2++) {
            ((O[]) this.f)[i2] = h();
        }
        a aVar = new a();
        this.f6277a = aVar;
        aVar.start();
    }

    private void b(I i) {
        i.a();
        I[] iArr = this.e;
        int i2 = this.g;
        this.g = i2 + 1;
        iArr[i2] = i;
    }

    private void b(O o) {
        o.a();
        O[] oArr = this.f;
        int i = this.h;
        this.h = i + 1;
        oArr[i] = o;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends java.lang.Exception */
    private void i() throws E {
        E e = this.j;
        if (e != null) {
            throw e;
        }
    }

    private void j() {
        if (m()) {
            this.b.notify();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        do {
            try {
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        } while (l());
    }

    private boolean l() {
        synchronized (this.b) {
            while (!this.l && !m()) {
                this.b.wait();
            }
            if (this.l) {
                return false;
            }
            I iRemoveFirst = this.c.removeFirst();
            O[] oArr = this.f;
            int i = this.h - 1;
            this.h = i;
            O o = oArr[i];
            boolean z = this.k;
            this.k = false;
            if (iRemoveFirst.c()) {
                o.b(4);
            } else {
                if (iRemoveFirst.d_()) {
                    o.b(Integer.MIN_VALUE);
                }
                try {
                    this.j = (E) a(iRemoveFirst, o, z);
                } catch (OutOfMemoryError | RuntimeException e) {
                    this.j = (E) a(e);
                }
                if (this.j != null) {
                    synchronized (this.b) {
                    }
                    return false;
                }
            }
            synchronized (this.b) {
                if (this.k) {
                    b(o);
                } else if (o.d_()) {
                    this.m++;
                    b(o);
                } else {
                    o.b = this.m;
                    this.m = 0;
                    this.d.addLast(o);
                }
                b(iRemoveFirst);
            }
            return true;
        }
    }

    private boolean m() {
        return !this.c.isEmpty() && this.h > 0;
    }

    protected abstract E a(I i, O o, boolean z);

    protected abstract E a(Throwable th);

    protected final void a(int i) {
        com.opos.exoplayer.core.i.a.b(this.g == this.e.length);
        for (I i2 : this.e) {
            i2.e(i);
        }
    }

    @Override // com.opos.exoplayer.core.b.c
    public final void a(I i) {
        synchronized (this.b) {
            i();
            com.opos.exoplayer.core.i.a.a(i == this.i);
            this.c.addLast(i);
            j();
            this.i = null;
        }
    }

    protected void a(O o) {
        synchronized (this.b) {
            b(o);
            j();
        }
    }

    @Override // com.opos.exoplayer.core.b.c
    public final void c() {
        synchronized (this.b) {
            this.k = true;
            this.m = 0;
            I i = this.i;
            if (i != null) {
                b(i);
                this.i = null;
            }
            while (!this.c.isEmpty()) {
                b(this.c.removeFirst());
            }
            while (!this.d.isEmpty()) {
                b(this.d.removeFirst());
            }
        }
    }

    @Override // com.opos.exoplayer.core.b.c
    public void d() {
        synchronized (this.b) {
            this.l = true;
            this.b.notify();
        }
        try {
            this.f6277a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // com.opos.exoplayer.core.b.c
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final I a() {
        I i;
        synchronized (this.b) {
            i();
            com.opos.exoplayer.core.i.a.b(this.i == null);
            int i2 = this.g;
            if (i2 == 0) {
                i = null;
            } else {
                I[] iArr = this.e;
                int i3 = i2 - 1;
                this.g = i3;
                i = iArr[i3];
            }
            this.i = i;
        }
        return i;
    }

    @Override // com.opos.exoplayer.core.b.c
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final O b() {
        synchronized (this.b) {
            i();
            if (this.d.isEmpty()) {
                return null;
            }
            return this.d.removeFirst();
        }
    }

    protected abstract I g();

    protected abstract O h();
}
