package com.opos.exoplayer.core.f;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.i.m;
import com.opos.exoplayer.core.i.y;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class k extends com.opos.exoplayer.core.a implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f6463a;
    private final j b;
    private final g c;
    private final com.opos.exoplayer.core.l d;
    private boolean e;
    private boolean f;
    private int g;
    private Format h;
    private e i;
    private h j;
    private i k;
    private i l;
    private int m;

    public k(j jVar, Looper looper) {
        this(jVar, looper, g.f6448a);
    }

    public k(j jVar, Looper looper, g gVar) {
        super(3);
        this.b = (j) com.opos.exoplayer.core.i.a.a(jVar);
        this.f6463a = looper == null ? null : new Handler(looper, this);
        this.c = gVar;
        this.d = new com.opos.exoplayer.core.l();
    }

    private void a(List<b> list) {
        Handler handler = this.f6463a;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            b(list);
        }
    }

    private void b(List<b> list) {
        this.b.a(list);
    }

    private void v() {
        this.j = null;
        this.m = -1;
        i iVar = this.k;
        if (iVar != null) {
            iVar.e();
            this.k = null;
        }
        i iVar2 = this.l;
        if (iVar2 != null) {
            iVar2.e();
            this.l = null;
        }
    }

    private void w() {
        v();
        this.i.d();
        this.i = null;
        this.g = 0;
    }

    private void x() {
        w();
        this.i = this.c.b(this.h);
    }

    private long y() {
        int i = this.m;
        if (i == -1 || i >= this.k.b()) {
            return Long.MAX_VALUE;
        }
        return this.k.a(this.m);
    }

    private void z() {
        a(Collections.emptyList());
    }

    @Override // com.opos.exoplayer.core.u
    public int a(Format format) {
        if (this.c.a(format)) {
            return com.opos.exoplayer.core.a.a((com.opos.exoplayer.core.drm.b<?>) null, format.i) ? 4 : 2;
        }
        return m.c(format.f) ? 1 : 0;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0093  */
    @Override // com.opos.exoplayer.core.t
    public void a(long j, long j2) throws com.opos.exoplayer.core.h {
        boolean z;
        if (this.f) {
            return;
        }
        if (this.l == null) {
            this.i.a(j);
            try {
                this.l = this.i.b();
            } catch (f e) {
                String strA = y.a(e);
                com.opos.exoplayer.core.h hVarA = com.opos.exoplayer.core.h.a(e, r());
                hVarA.a(strA);
                throw hVarA;
            }
        }
        if (a_() != 2) {
            return;
        }
        if (this.k != null) {
            long jY = y();
            z = false;
            while (jY <= j) {
                this.m++;
                jY = y();
                z = true;
            }
        } else {
            z = false;
        }
        i iVar = this.l;
        if (iVar != null) {
            if (!iVar.c()) {
                if (((com.opos.exoplayer.core.b.f) this.l).f6276a <= j) {
                    i iVar2 = this.k;
                    if (iVar2 != null) {
                        iVar2.e();
                    }
                    i iVar3 = this.l;
                    this.k = iVar3;
                    this.l = null;
                    this.m = iVar3.a(j);
                }
                a(this.k.b(j));
            } else if (!z && y() == Long.MAX_VALUE) {
                if (this.g == 2) {
                    x();
                } else {
                    v();
                    this.f = true;
                }
            }
            if (z) {
                a(this.k.b(j));
            }
        } else if (z) {
            a(this.k.b(j));
        }
        if (this.g == 2) {
            return;
        }
        while (!this.e) {
            try {
                if (this.j == null) {
                    h hVarA2 = this.i.a();
                    this.j = hVarA2;
                    if (hVarA2 == null) {
                        return;
                    }
                }
                if (this.g == 1) {
                    this.j.a_(4);
                    this.i.a(this.j);
                    this.j = null;
                    this.g = 2;
                    return;
                }
                int iA = a(this.d, (com.opos.exoplayer.core.b.e) this.j, false);
                if (iA == -4) {
                    if (this.j.c()) {
                        this.e = true;
                    } else {
                        this.j.d = this.d.f6520a.w;
                        this.j.h();
                    }
                    this.i.a(this.j);
                    this.j = null;
                } else if (iA == -3) {
                    return;
                }
            } catch (f e2) {
                String strA2 = y.a(e2);
                com.opos.exoplayer.core.h hVarA3 = com.opos.exoplayer.core.h.a(e2, r());
                hVarA3.a(strA2);
                throw hVarA3;
            }
        }
    }

    @Override // com.opos.exoplayer.core.a
    protected void a(long j, boolean z) {
        z();
        this.e = false;
        this.f = false;
        if (this.g != 0) {
            x();
        } else {
            v();
            this.i.c();
        }
    }

    @Override // com.opos.exoplayer.core.a
    protected void a(Format[] formatArr, long j) {
        Format format = formatArr[0];
        this.h = format;
        if (this.i != null) {
            this.g = 1;
        } else {
            this.i = this.c.b(format);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        b((List<b>) message.obj);
        return true;
    }

    @Override // com.opos.exoplayer.core.a
    protected void p() {
        this.h = null;
        z();
        w();
    }

    @Override // com.opos.exoplayer.core.t
    public boolean t() {
        return true;
    }

    @Override // com.opos.exoplayer.core.t
    public boolean u() {
        return this.f;
    }
}
