package com.opos.exoplayer.a;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.C;
import com.opos.exoplayer.core.k;
import com.opos.exoplayer.core.q;
import com.opos.exoplayer.core.z;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f6224a;
    private final StringBuilder b;
    private final Formatter c;
    private final z.a d;
    private final z.b e;
    private q f;
    private com.opos.exoplayer.core.c g;
    private a h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private long[] r;
    private boolean[] s;
    private long[] t;
    private boolean[] u;
    private final Runnable v;
    private final Runnable w;

    public interface a {
        void a(int i);
    }

    /* JADX INFO: renamed from: com.opos.exoplayer.a.b$b, reason: collision with other inner class name */
    class RunnableC0899b implements Runnable {
        RunnableC0899b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.l();
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.c();
        }
    }

    private final class d extends q.a implements View.OnClickListener {
        private d() {
        }

        /* synthetic */ d(b bVar, RunnableC0899b runnableC0899b) {
            this();
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void a(int i) {
            b.this.i();
            b.this.h();
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void a(z zVar, Object obj, int i) {
            b.this.h();
            b.this.k();
            b.this.l();
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void a(boolean z, int i) {
            b.this.g();
            b.this.l();
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void b(int i) {
            b.this.h();
            b.this.l();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            q unused = b.this.f;
            b.this.e();
        }
    }

    static {
        k.a("goog.exo.ui");
    }

    public b(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        this.v = new RunnableC0899b();
        this.w = new c();
        this.l = 5000;
        this.m = 15000;
        this.n = 5000;
        this.o = 0;
        this.q = -9223372036854775807L;
        this.p = false;
        this.d = new z.a();
        this.e = new z.b();
        StringBuilder sb = new StringBuilder();
        this.b = sb;
        this.c = new Formatter(sb, Locale.getDefault());
        this.r = new long[0];
        this.s = new boolean[0];
        this.t = new long[0];
        this.u = new boolean[0];
        this.f6224a = new d(this, null);
        this.g = new com.opos.exoplayer.core.d();
        setDescendantFocusability(262144);
    }

    private void a(int i, long j) {
        if (this.g.a(this.f, i, j)) {
            return;
        }
        l();
    }

    private void a(long j) {
        a(this.f.i(), j);
    }

    private static boolean a(z zVar, z.b bVar) {
        if (zVar.b() > 100) {
            return false;
        }
        int iB = zVar.b();
        for (int i = 0; i < iB; i++) {
            if (zVar.a(i, bVar).i == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    private static boolean b(int i) {
        return i == 90 || i == 89 || i == 85 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        removeCallbacks(this.w);
        if (this.n <= 0) {
            this.q = -9223372036854775807L;
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = this.n;
        this.q = jUptimeMillis + j;
        if (this.i) {
            postDelayed(this.w, j);
        }
    }

    private void f() {
        g();
        h();
        i();
        j();
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (d() && this.i) {
            r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (d() && this.i) {
            q qVar = this.f;
            z zVarH = qVar != null ? qVar.h() : null;
            if (zVarH == null || zVarH.a() || this.f.o()) {
                return;
            }
            zVarH.a(this.f.i(), this.e);
            z.b bVar = this.e;
            if (!bVar.d && bVar.e) {
                this.f.k();
            }
            if (this.e.e) {
                return;
            }
            this.f.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
    }

    private void j() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        q qVar = this.f;
        if (qVar == null) {
            return;
        }
        this.k = this.j && a(qVar.h(), this.e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:83:0x0172  */
    public void l() {
        long j;
        long j2;
        long j3;
        int iB;
        z.b bVar;
        int i;
        if (d() && this.i) {
            q qVar = this.f;
            long jM = 0;
            boolean z = true;
            if (qVar != null) {
                z zVarH = qVar.h();
                if (zVarH.a()) {
                    j2 = 0;
                } else {
                    int i2 = this.f.i();
                    boolean z2 = this.k;
                    int i3 = z2 ? 0 : i2;
                    if (z2) {
                        iB = zVarH.b() - 1;
                        j2 = 0;
                        j3 = 0;
                    } else {
                        j2 = 0;
                        j3 = 0;
                        iB = i2;
                    }
                    int i4 = 0;
                    while (i3 <= iB) {
                        if (i3 == i2) {
                            j3 = j2;
                        }
                        zVarH.a(i3, this.e);
                        z.b bVar2 = this.e;
                        int i5 = i3;
                        if (bVar2.i == -9223372036854775807L) {
                            com.opos.exoplayer.core.i.a.b(this.k ^ z);
                            break;
                        }
                        int i6 = bVar2.f;
                        while (true) {
                            bVar = this.e;
                            if (i6 <= bVar.g) {
                                zVarH.a(i6, this.d);
                                int iD = this.d.d();
                                int i7 = 0;
                                while (i7 < iD) {
                                    long jA = this.d.a(i7);
                                    if (jA == Long.MIN_VALUE) {
                                        i = i2;
                                        long j4 = this.d.d;
                                        if (j4 != -9223372036854775807L) {
                                            jA = j4;
                                        }
                                        i7++;
                                        i2 = i;
                                    } else {
                                        i = i2;
                                    }
                                    long jC = jA + this.d.c();
                                    if (jC >= 0 && jC <= this.e.i) {
                                        long[] jArr = this.r;
                                        if (i4 == jArr.length) {
                                            int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                            this.r = Arrays.copyOf(jArr, length);
                                            this.s = Arrays.copyOf(this.s, length);
                                        }
                                        this.r[i4] = com.opos.exoplayer.core.b.a(j2 + jC);
                                        this.s[i4] = this.d.c(i7);
                                        i4++;
                                    }
                                    i7++;
                                    i2 = i;
                                }
                                i6++;
                            }
                        }
                        j2 += bVar.i;
                        i3 = i5 + 1;
                        i2 = i2;
                        z = true;
                    }
                    jM = j3;
                }
                com.opos.exoplayer.core.b.a(j2);
                long jA2 = com.opos.exoplayer.core.b.a(jM);
                if (this.f.o()) {
                    jM = jA2 + this.f.p();
                } else {
                    jM = jA2 + this.f.m();
                    this.f.n();
                }
            }
            removeCallbacks(this.v);
            q qVar2 = this.f;
            int iC = qVar2 == null ? 1 : qVar2.c();
            if (iC == 1 || iC == 4) {
                return;
            }
            if (this.f.d() && iC == 3) {
                float f = this.f.e().b;
                if (f <= 0.1f) {
                    j = 1000;
                } else if (f <= 5.0f) {
                    long jMax = 1000 / Math.max(1, Math.round(1.0f / f));
                    j = jMax - (jM % jMax);
                    if (j < jMax / 5) {
                        j += jMax;
                    }
                    if (f != 1.0f) {
                        j = (long) (j / f);
                    }
                } else {
                    j = 200;
                }
            } else {
                j = 1000;
            }
            postDelayed(this.v, j);
        }
    }

    private void m() {
        r();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
    
        if (r1.d == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void n() {
        z zVarH = this.f.h();
        if (zVarH.a()) {
            return;
        }
        zVarH.a(this.f.i(), this.e);
        int iK = this.f.k();
        if (iK != -1) {
            if (this.f.m() > C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
                z.b bVar = this.e;
                if (bVar.e) {
                }
            }
            a(iK, -9223372036854775807L);
            return;
        }
        a(0L);
    }

    private void o() {
        z zVarH = this.f.h();
        if (zVarH.a()) {
            return;
        }
        int i = this.f.i();
        int iJ = this.f.j();
        if (iJ != -1) {
            a(iJ, -9223372036854775807L);
        } else if (zVarH.a(i, this.e, false).e) {
            a(i, -9223372036854775807L);
        }
    }

    private void p() {
        if (this.l <= 0) {
            return;
        }
        a(Math.max(this.f.m() - ((long) this.l), 0L));
    }

    private void q() {
        if (this.m <= 0) {
            return;
        }
        long jL = this.f.l();
        long jM = this.f.m() + ((long) this.m);
        if (jL != -9223372036854775807L) {
            jM = Math.min(jM, jL);
        }
        a(jM);
    }

    private boolean r() {
        q qVar = this.f;
        return (qVar == null || qVar.c() == 4 || this.f.c() == 1 || !this.f.d()) ? false : true;
    }

    public int a() {
        return this.n;
    }

    public void a(int i) {
        this.n = i;
        if (d()) {
            e();
        }
    }

    public void a(q qVar) {
        q qVar2 = this.f;
        if (qVar2 == qVar) {
            return;
        }
        if (qVar2 != null) {
            qVar2.b(this.f6224a);
        }
        this.f = qVar;
        if (qVar != null) {
            qVar.a(this.f6224a);
        }
        f();
    }

    public boolean a(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.f == null || !b(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() == 0) {
            if (keyCode == 90) {
                q();
            } else if (keyCode == 89) {
                p();
            } else if (keyEvent.getRepeatCount() == 0) {
                if (keyCode == 85) {
                    com.opos.exoplayer.core.c cVar = this.g;
                    q qVar = this.f;
                    cVar.a(qVar, !qVar.d());
                } else if (keyCode == 87) {
                    o();
                } else if (keyCode == 88) {
                    n();
                } else if (keyCode == 126) {
                    this.g.a(this.f, true);
                } else if (keyCode == 127) {
                    this.g.a(this.f, false);
                }
            }
        }
        return true;
    }

    public void b() {
        if (!d()) {
            setVisibility(0);
            a aVar = this.h;
            if (aVar != null) {
                aVar.a(getVisibility());
            }
            f();
            m();
        }
        e();
    }

    public void c() {
        if (d()) {
            setVisibility(8);
            a aVar = this.h;
            if (aVar != null) {
                aVar.a(getVisibility());
            }
            removeCallbacks(this.v);
            removeCallbacks(this.w);
            this.q = -9223372036854775807L;
        }
    }

    public boolean d() {
        return getVisibility() == 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.i = true;
        long j = this.q;
        if (j != -9223372036854775807L) {
            long jUptimeMillis = j - SystemClock.uptimeMillis();
            if (jUptimeMillis <= 0) {
                c();
            } else {
                postDelayed(this.w, jUptimeMillis);
            }
        } else if (d()) {
            e();
        }
        f();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = false;
        removeCallbacks(this.v);
        removeCallbacks(this.w);
    }
}
