package com.byazt.eg;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 482})
public final class zm implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2151a;
    public final gu c;
    public m n;
    public final com.byazt.yx.da tt;
    public final boolean uj;
    public final yv ve;

    @Override // com.byazt.eg.n
    public yv c() {
        return this.ve;
    }

    private zm(gu guVar, yv yvVar, boolean z) {
        this.c = guVar;
        this.ve = yvVar;
        this.uj = z;
        this.tt = new com.byazt.yx.da(guVar, z);
    }

    public static zm c(gu guVar, yv yvVar, boolean z) {
        zm zmVar = new zm(guVar, yvVar, z);
        zmVar.n = guVar.gr().c(zmVar);
        return zmVar;
    }

    @Override // com.byazt.eg.n
    public h tt() throws IOException {
        synchronized (this) {
            if (this.f2151a) {
                throw new IllegalStateException("Already Executed");
            }
            this.f2151a = true;
        }
        da();
        try {
            try {
                if (this.ve.f2148a != null) {
                    this.ve.f2148a.c();
                }
                this.c.my().c(this);
                h hVarI = i();
                if (hVarI == null) {
                    throw new IOException("Canceled");
                }
                if (hVarI.ve == 0) {
                    throw new IOException(hVarI.uj);
                }
                this.c.my().tt(this);
                return hVarI;
            } catch (IOException e) {
                this.n.c(this, e);
                this.c.my().tt(this);
                return null;
            } catch (Exception e2) {
                this.n.c(this, new IOException(e2));
                this.c.my().tt(this);
                return null;
            }
        } catch (Throwable th) {
            this.c.my().tt(this);
            throw th;
        }
    }

    private void da() {
        this.tt.c(com.byazt.xb.n.tt().c("response.body().close()"));
    }

    @Override // com.byazt.eg.n
    public void c(a aVar) {
        try {
            synchronized (this) {
                if (this.f2151a) {
                    throw new IllegalStateException("Already Executed");
                }
                this.f2151a = true;
            }
            da();
            this.c.my().c(new c(aVar));
        } catch (Throwable th) {
            if (aVar != null) {
                aVar.c(this, new IOException(th.getMessage()));
            }
        }
    }

    @Override // com.byazt.eg.n
    public void ve() {
        this.tt.c();
    }

    @Override // com.byazt.eg.n
    public boolean uj() {
        return this.tt.tt();
    }

    @Override // com.byazt.eg.n
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public zm n() {
        return c(this.c, this.ve, this.uj);
    }

    @com.byazt.zqa.c(c = {0, 1, 16, 21})
    final class c extends com.byazt.kh.tt {
        public final a ve;

        public c(a aVar) {
            super("OkHttp %s", zm.this.x());
            this.ve = aVar;
        }

        public String c() {
            return zm.this.ve.c().sp();
        }

        public void tt() {
            if (zm.this.ve == null || zm.this.ve.f2148a == null) {
                return;
            }
            zm.this.ve.f2148a.sl();
        }

        @Override // com.byazt.kh.tt
        public void ve() {
            boolean z = false;
            try {
                try {
                    try {
                        if (zm.this.ve != null && zm.this.ve.f2148a != null) {
                            zm.this.ve.f2148a.c();
                        }
                        h hVarI = zm.this.i();
                        try {
                            if (zm.this.tt.tt()) {
                                this.ve.c(zm.this, new IOException("Canceled"));
                            } else {
                                this.ve.c(zm.this, hVarI);
                            }
                            if (hVarI.ve == 0) {
                                throw new IOException(hVarI.uj);
                            }
                        } catch (IOException e) {
                            e = e;
                            z = true;
                            if (!z) {
                                zm.this.n.c(zm.this, e);
                                this.ve.c(zm.this, e);
                            } else {
                                com.byazt.xb.n.tt().c(4, "Callback failure for " + zm.this.sp(), e);
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (Exception e3) {
                    zm.this.n.c(zm.this, new IOException(e3));
                    this.ve.c(zm.this, new IOException(e3));
                }
                zm.this.c.my().tt(this);
            } catch (Throwable th) {
                zm.this.c.my().tt(this);
                throw th;
            }
        }
    }

    public String sp() {
        return (uj() ? "canceled " : "") + (this.uj ? "web socket" : NotificationCompat.CATEGORY_CALL) + " to " + x();
    }

    public String x() {
        return this.ve.c().u();
    }

    public h i() throws IOException {
        ArrayList arrayList = new ArrayList(this.c.qy());
        arrayList.add(this.tt);
        arrayList.add(new com.byazt.yx.c(this.c.a()));
        arrayList.add(new com.byazt.umr.c(this.c.sp()));
        arrayList.add(new com.byazt.iq.c(this.c));
        if (!this.uj) {
            arrayList.addAll(this.c.gu());
        }
        arrayList.add(new com.byazt.yx.tt(this.uj));
        return new com.byazt.yx.sp(arrayList, null, null, null, 0, this.ve, this, this.n, this.c.c(), this.c.tt(), this.c.ve()).c(this.ve);
    }
}
