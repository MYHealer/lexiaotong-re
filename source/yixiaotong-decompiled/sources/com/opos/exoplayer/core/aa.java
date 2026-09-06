package com.opos.exoplayer.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
final class aa implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t[] f6257a;
    private final com.opos.exoplayer.core.g.h b;
    private final com.opos.exoplayer.core.g.i c;
    private final Handler d;
    private final ab e;
    private final Handler f;
    private final CopyOnWriteArraySet<q.b> g;
    private final z.b h;
    private final z.a i;
    private boolean j;
    private int k;
    private boolean l;
    private int m;
    private boolean n;
    private boolean o;
    private p p;
    private af q;
    private int r;
    private int s;
    private long t;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            aa.this.a(message);
        }
    }

    public aa(t[] tVarArr, com.opos.exoplayer.core.g.h hVar, n nVar, com.opos.exoplayer.core.i.e eVar) {
        com.opos.cmn.an.f.a.a("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.7.3] [" + com.opos.exoplayer.core.i.y.e + "]");
        com.opos.exoplayer.core.i.a.b(tVarArr.length > 0);
        this.f6257a = (t[]) com.opos.exoplayer.core.i.a.a(tVarArr);
        this.b = (com.opos.exoplayer.core.g.h) com.opos.exoplayer.core.i.a.a(hVar);
        this.j = false;
        this.k = 0;
        this.l = false;
        this.g = new CopyOnWriteArraySet<>();
        com.opos.exoplayer.core.g.i iVar = new com.opos.exoplayer.core.g.i(com.opos.exoplayer.core.e.m.f6403a, new boolean[tVarArr.length], new com.opos.exoplayer.core.g.g(new com.opos.exoplayer.core.g.f[tVarArr.length]), null, new v[tVarArr.length]);
        this.c = iVar;
        this.h = new z.b();
        this.i = new z.a();
        this.p = p.f6545a;
        a aVar = new a(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.d = aVar;
        this.q = new af(z.f6569a, 0L, iVar);
        ab abVar = new ab(tVarArr, hVar, iVar, nVar, this.j, this.k, this.l, aVar, this, eVar);
        this.e = abVar;
        this.f = new Handler(abVar.b());
    }

    private af a(boolean z, boolean z2, int i) {
        long jM;
        if (z) {
            this.r = 0;
            this.s = 0;
            jM = 0;
        } else {
            this.r = i();
            this.s = q();
            jM = m();
        }
        this.t = jM;
        z zVar = z2 ? z.f6569a : this.q.f6269a;
        Object obj = z2 ? null : this.q.b;
        af afVar = this.q;
        return new af(zVar, obj, afVar.c, afVar.d, afVar.e, i, false, z2 ? this.c : afVar.h);
    }

    private void a(af afVar, int i, boolean z, int i2) {
        int i3 = this.m - i;
        this.m = i3;
        if (i3 == 0) {
            if (afVar.d == -9223372036854775807L) {
                afVar = afVar.a(afVar.c, 0L, afVar.e);
            }
            af afVar2 = afVar;
            if ((!this.q.f6269a.a() || this.n) && afVar2.f6269a.a()) {
                this.s = 0;
                this.r = 0;
                this.t = 0L;
            }
            int i4 = this.n ? 0 : 2;
            boolean z2 = this.o;
            this.n = false;
            this.o = false;
            a(afVar2, z, i2, i4, z2);
        }
    }

    private void a(af afVar, boolean z, int i, int i2, boolean z2) {
        af afVar2 = this.q;
        boolean z3 = (afVar2.f6269a == afVar.f6269a && afVar2.b == afVar.b) ? false : true;
        boolean z4 = this.q.f != afVar.f;
        boolean z5 = this.q.g != afVar.g;
        boolean z6 = this.q.h != afVar.h;
        this.q = afVar;
        if (z3 || i2 == 0) {
            for (q.b bVar : this.g) {
                af afVar3 = this.q;
                bVar.a(afVar3.f6269a, afVar3.b, i2);
            }
        }
        if (z) {
            Iterator<q.b> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().b(i);
            }
        }
        if (z6) {
            this.b.a(this.q.h.d);
            for (q.b bVar2 : this.g) {
                com.opos.exoplayer.core.g.i iVar = this.q.h;
                bVar2.a(iVar.f6476a, iVar.c);
            }
        }
        if (z5) {
            Iterator<q.b> it2 = this.g.iterator();
            while (it2.hasNext()) {
                it2.next().a(this.q.g);
            }
        }
        if (z4) {
            Iterator<q.b> it3 = this.g.iterator();
            while (it3.hasNext()) {
                it3.next().a(this.j, this.q.f);
            }
        }
        if (z2) {
            Iterator<q.b> it4 = this.g.iterator();
            while (it4.hasNext()) {
                it4.next().e_();
            }
        }
    }

    private long b(long j) {
        long jA = b.a(j);
        if (this.q.c.a()) {
            return jA;
        }
        af afVar = this.q;
        afVar.f6269a.a(afVar.c.f6391a, this.i);
        return jA + this.i.b();
    }

    private boolean r() {
        return this.q.f6269a.a() || this.m > 0;
    }

    @Override // com.opos.exoplayer.core.q
    public q.d a() {
        return null;
    }

    @Override // com.opos.exoplayer.core.i
    public r a(r.b bVar) {
        return new r(this.e, bVar, this.q.f6269a, i(), this.f);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(int i) {
        if (this.k != i) {
            this.k = i;
            this.e.a(i);
            Iterator<q.b> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().a(i);
            }
        }
    }

    @Override // com.opos.exoplayer.core.q
    public void a(int i, long j) {
        z zVar = this.q.f6269a;
        if (i < 0 || (!zVar.a() && i >= zVar.b())) {
            throw new m(zVar, i, j);
        }
        this.o = true;
        this.m++;
        if (o()) {
            com.opos.cmn.an.f.a.c("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            this.d.obtainMessage(0, 1, -1, this.q).sendToTarget();
            return;
        }
        this.r = i;
        if (zVar.a()) {
            this.t = j == -9223372036854775807L ? 0L : j;
            this.s = 0;
        } else {
            long jA = j == -9223372036854775807L ? zVar.a(i, this.h).a() : b.b(j);
            Pair<Integer, Long> pairA = zVar.a(this.h, this.i, i, jA);
            this.t = b.a(jA);
            this.s = ((Integer) pairA.first).intValue();
        }
        this.e.a(zVar, i, b.b(j));
        Iterator<q.b> it = this.g.iterator();
        while (it.hasNext()) {
            it.next().b(1);
        }
    }

    @Override // com.opos.exoplayer.core.q
    public void a(long j) {
        a(i(), j);
    }

    void a(Message message) {
        int i = message.what;
        if (i == 0) {
            a((af) message.obj, message.arg1, message.arg2 != -1, message.arg2);
            return;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException();
            }
            h hVar = (h) message.obj;
            Iterator<q.b> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().a(hVar);
            }
            return;
        }
        p pVar = (p) message.obj;
        if (this.p.equals(pVar)) {
            return;
        }
        this.p = pVar;
        Iterator<q.b> it2 = this.g.iterator();
        while (it2.hasNext()) {
            it2.next().a(pVar);
        }
    }

    @Override // com.opos.exoplayer.core.i
    public void a(com.opos.exoplayer.core.e.e eVar) {
        a(eVar, true, true);
    }

    public void a(com.opos.exoplayer.core.e.e eVar, boolean z, boolean z2) {
        af afVarA = a(z, z2, 2);
        this.n = true;
        this.m++;
        this.e.a(eVar, z, z2);
        a(afVarA, false, 4, 1, false);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(q.b bVar) {
        this.g.add(bVar);
    }

    @Override // com.opos.exoplayer.core.q
    public void a(boolean z) {
        if (this.j != z) {
            this.j = z;
            this.e.a(z);
            Iterator<q.b> it = this.g.iterator();
            while (it.hasNext()) {
                it.next().a(z, this.q.f);
            }
        }
    }

    @Override // com.opos.exoplayer.core.q
    public int b(int i) {
        return this.f6257a[i].a();
    }

    @Override // com.opos.exoplayer.core.q
    public q.c b() {
        return null;
    }

    @Override // com.opos.exoplayer.core.q
    public void b(q.b bVar) {
        this.g.remove(bVar);
    }

    @Override // com.opos.exoplayer.core.q
    public int c() {
        return this.q.f;
    }

    @Override // com.opos.exoplayer.core.q
    public boolean d() {
        return this.j;
    }

    @Override // com.opos.exoplayer.core.q
    public p e() {
        return this.p;
    }

    @Override // com.opos.exoplayer.core.q
    public void f() {
        com.opos.cmn.an.f.a.a("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [ExoPlayerLib/2.7.3] [" + com.opos.exoplayer.core.i.y.e + "] [" + k.a() + "]");
        this.e.a();
        this.d.removeCallbacksAndMessages(null);
    }

    @Override // com.opos.exoplayer.core.q
    public com.opos.exoplayer.core.g.g g() {
        return this.q.h.c;
    }

    @Override // com.opos.exoplayer.core.q
    public z h() {
        return this.q.f6269a;
    }

    @Override // com.opos.exoplayer.core.q
    public int i() {
        if (r()) {
            return this.r;
        }
        af afVar = this.q;
        return afVar.f6269a.a(afVar.c.f6391a, this.i).c;
    }

    @Override // com.opos.exoplayer.core.q
    public int j() {
        z zVar = this.q.f6269a;
        if (zVar.a()) {
            return -1;
        }
        return zVar.a(i(), this.k, this.l);
    }

    @Override // com.opos.exoplayer.core.q
    public int k() {
        z zVar = this.q.f6269a;
        if (zVar.a()) {
            return -1;
        }
        return zVar.b(i(), this.k, this.l);
    }

    @Override // com.opos.exoplayer.core.q
    public long l() {
        z zVar = this.q.f6269a;
        if (zVar.a()) {
            return -9223372036854775807L;
        }
        if (!o()) {
            return zVar.a(i(), this.h).b();
        }
        com.opos.exoplayer.core.e.e.b bVar = this.q.c;
        zVar.a(bVar.f6391a, this.i);
        return b.a(this.i.c(bVar.b, bVar.c));
    }

    @Override // com.opos.exoplayer.core.q
    public long m() {
        return r() ? this.t : b(this.q.i);
    }

    @Override // com.opos.exoplayer.core.q
    public long n() {
        return r() ? this.t : b(this.q.j);
    }

    @Override // com.opos.exoplayer.core.q
    public boolean o() {
        return !r() && this.q.c.a();
    }

    @Override // com.opos.exoplayer.core.q
    public long p() {
        if (!o()) {
            return m();
        }
        af afVar = this.q;
        afVar.f6269a.a(afVar.c.f6391a, this.i);
        return this.i.b() + b.a(this.q.e);
    }

    public int q() {
        return r() ? this.s : this.q.c.f6391a;
    }
}
