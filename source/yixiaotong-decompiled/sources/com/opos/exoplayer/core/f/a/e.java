package com.opos.exoplayer.core.f.a;

import com.opos.exoplayer.core.f.h;
import com.opos.exoplayer.core.f.i;
import java.util.LinkedList;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
abstract class e implements com.opos.exoplayer.core.f.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedList<b> f6420a = new LinkedList<>();
    private final LinkedList<i> b;
    private final PriorityQueue<b> c;
    private b d;
    private long e;
    private long f;

    static /* synthetic */ class a {
    }

    private static final class b extends h implements Comparable<b> {
        private long e;

        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (c() != bVar.c()) {
                return c() ? 1 : -1;
            }
            long j = this.c - bVar.c;
            if (j == 0) {
                j = this.e - bVar.e;
                if (j == 0) {
                    return 0;
                }
            }
            return j > 0 ? 1 : -1;
        }
    }

    private final class c extends i {
        private c() {
        }

        /* synthetic */ c(e eVar, a aVar) {
            this();
        }

        @Override // com.opos.exoplayer.core.f.i
        public final void e() {
            e.this.a((i) this);
        }
    }

    public e() {
        a aVar;
        int i = 0;
        while (true) {
            aVar = null;
            if (i >= 10) {
                break;
            }
            this.f6420a.add(new b(aVar));
            i++;
        }
        this.b = new LinkedList<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.b.add(new c(this, aVar));
        }
        this.c = new PriorityQueue<>();
    }

    private void a(b bVar) {
        bVar.a();
        this.f6420a.add(bVar);
    }

    @Override // com.opos.exoplayer.core.f.e
    public void a(long j) {
        this.e = j;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    protected abstract void a(h hVar);

    protected void a(i iVar) {
        iVar.a();
        this.b.add(iVar);
    }

    @Override // com.opos.exoplayer.core.b.c
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(h hVar) {
        com.opos.exoplayer.core.i.a.a(hVar == this.d);
        if (hVar.d_()) {
            a(this.d);
        } else {
            b bVar = this.d;
            long j = this.f;
            this.f = 1 + j;
            bVar.e = j;
            this.c.add(this.d);
        }
        this.d = null;
    }

    @Override // com.opos.exoplayer.core.b.c
    public void c() {
        this.f = 0L;
        this.e = 0L;
        while (!this.c.isEmpty()) {
            a(this.c.poll());
        }
        b bVar = this.d;
        if (bVar != null) {
            a(bVar);
            this.d = null;
        }
    }

    @Override // com.opos.exoplayer.core.b.c
    public void d() {
    }

    protected abstract boolean e();

    protected abstract com.opos.exoplayer.core.f.d f();

    @Override // com.opos.exoplayer.core.b.c
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public i b() {
        i iVarPollFirst;
        if (this.b.isEmpty()) {
            return null;
        }
        while (!this.c.isEmpty() && this.c.peek().c <= this.e) {
            b bVarPoll = this.c.poll();
            if (bVarPoll.c()) {
                iVarPollFirst = this.b.pollFirst();
                iVarPollFirst.b(4);
            } else {
                a((h) bVarPoll);
                if (e()) {
                    com.opos.exoplayer.core.f.d dVarF = f();
                    if (!bVarPoll.d_()) {
                        iVarPollFirst = this.b.pollFirst();
                        iVarPollFirst.a(bVarPoll.c, dVarF, Long.MAX_VALUE);
                    }
                }
                a(bVarPoll);
            }
            a(bVarPoll);
            return iVarPollFirst;
        }
        return null;
    }

    @Override // com.opos.exoplayer.core.b.c
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public h a() {
        com.opos.exoplayer.core.i.a.b(this.d == null);
        if (this.f6420a.isEmpty()) {
            return null;
        }
        b bVarPollFirst = this.f6420a.pollFirst();
        this.d = bVarPollFirst;
        return bVarPollFirst;
    }
}
