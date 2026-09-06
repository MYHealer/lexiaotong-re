package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ParticleSystem.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class g5 {
    private static final Object r = new Object();
    private int c;
    private long d;
    private boolean e;
    private float f;
    private int[] g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private Path n;
    private PathMeasure o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<b5> f4263a = new ArrayList<>();
    private final ArrayList<b5> b = new ArrayList<>();
    private boolean m = false;
    private c5 p = new c5();
    private e5 q = new e5();

    public g5(int i, long j) {
        a(i, j);
        a((Bitmap) null);
    }

    private void a(int i, long j) {
        this.g = new int[2];
        this.c = i;
        this.d = j;
    }

    public g5 b(float f, float f2) {
        a(new f5(f, f2));
        return this;
    }

    public List<b5> c() {
        List<b5> listUnmodifiableList;
        synchronized (r) {
            listUnmodifiableList = Collections.unmodifiableList(this.b);
        }
        return listUnmodifiableList;
    }

    private void a(p3 p3Var) {
        if (this.q == null) {
            this.q = new e5();
        }
        this.q.a(p3Var);
    }

    public void b(long j) {
        boolean z = this.e;
        float f = this.f * j;
        ArrayList arrayList = new ArrayList();
        synchronized (r) {
            while (z) {
                if (this.f4263a.isEmpty() || this.h >= f) {
                    break;
                } else {
                    a(j);
                }
            }
            Iterator<b5> it = this.b.iterator();
            while (it.hasNext()) {
                b5 next = it.next();
                if (!next.a(j)) {
                    it.remove();
                    arrayList.add(next);
                }
            }
        }
        this.f4263a.addAll(arrayList);
    }

    public g5 a(int i, int i2, long j, long j2, Interpolator interpolator) {
        a(new q4(i, i2, j, j2, interpolator));
        return this;
    }

    private void a(o3 o3Var) {
        if (this.p == null) {
            this.p = new c5();
        }
        this.p.a(o3Var);
    }

    private void a(Bitmap bitmap) {
        for (int i = 0; i < this.c; i++) {
            this.f4263a.add(new b5(bitmap));
        }
    }

    public void a(Rect rect, int i) {
        a(rect);
        a(i);
    }

    private void a(int i) {
        synchronized (r) {
            this.h = 0;
        }
        this.f = i / 1000.0f;
        this.e = true;
    }

    private void b() {
        ArrayList arrayList;
        synchronized (r) {
            arrayList = new ArrayList(this.b);
        }
        this.f4263a.addAll(arrayList);
    }

    private void a(Rect rect) {
        int i = rect.left - this.g[0];
        this.j = i;
        this.i = i + rect.width();
        int i2 = rect.top - this.g[1];
        this.l = i2;
        this.k = i2 + rect.height();
    }

    private void a(long j) {
        PathMeasure pathMeasure;
        b5 b5VarRemove = this.f4263a.remove(0);
        this.q.a(b5VarRemove);
        if (this.m && (pathMeasure = this.o) != null) {
            float[] fArrA = a(0.0f, pathMeasure.getLength());
            b5VarRemove.a(this.d, (int) fArrA[0], (int) fArrA[1], j, this.p);
        } else {
            b5VarRemove.a(this.d, a(this.j, this.i), a(this.l, this.k), j, this.p);
        }
        synchronized (r) {
            this.b.add(b5VarRemove);
            this.h++;
        }
    }

    private int a(int i, int i2) {
        if (i == i2) {
            return i;
        }
        if (i < i2) {
            return r5.a(i2 - i) + i;
        }
        return r5.a(i - i2) + i2;
    }

    private float[] a(float f, float f2) {
        float fA;
        if (Float.compare(f, f2) <= 0) {
            fA = r5.a(f2 - f) + f;
        } else {
            fA = f2 + r5.a(f - f2);
        }
        if (this.o == null) {
            this.o = new PathMeasure(this.n, true);
        }
        float[] fArr = new float[2];
        this.o.getPosTan(fA, fArr, null);
        float f3 = fArr[0];
        int[] iArr = this.g;
        fArr[0] = f3 - iArr[0];
        fArr[1] = fArr[1] - iArr[1];
        return fArr;
    }

    public void a() {
        b();
    }
}
