package com.byazt.vb;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1891, 20})
public class c implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.byazt.rz.c f2808a;
    public int c;
    public com.byazt.rz.c da;
    public com.byazt.rz.c i;
    public int m;
    public Context n;
    public boolean sl;
    public com.byazt.rz.c sp;
    public uj t;
    public a tt;
    public AtomicBoolean u;
    public String uj;
    public sl ve;
    public com.byazt.rz.c x;
    public int yp;
    public int z;

    /* JADX INFO: renamed from: com.byazt.vb.c$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 1891, 26})
    static /* synthetic */ class AnonymousClass1 {
    }

    @Override // com.byazt.vb.n
    public com.byazt.rz.c a() {
        return this.da;
    }

    @Override // com.byazt.vb.n
    public com.byazt.rz.c c() {
        return this.i;
    }

    @Override // com.byazt.vb.n
    public void c(a aVar) {
        this.tt = aVar;
    }

    @Override // com.byazt.vb.n
    public sl da() {
        return this.ve;
    }

    @Override // com.byazt.vb.n
    public Context getContext() {
        return this.n;
    }

    @Override // com.byazt.vb.n
    public com.byazt.rz.c i() {
        return this.x;
    }

    @Override // com.byazt.vb.n
    public String n() {
        return this.uj;
    }

    @Override // com.byazt.vb.n
    public boolean sl() {
        return this.sl;
    }

    @Override // com.byazt.vb.n
    public com.byazt.rz.c sp() {
        return this.f2808a;
    }

    @Override // com.byazt.vb.n
    public int t() {
        return this.m;
    }

    @Override // com.byazt.vb.n
    public a tt() {
        return this.tt;
    }

    @Override // com.byazt.vb.n
    public int u() {
        return this.c;
    }

    @Override // com.byazt.vb.n
    public uj uj() {
        return this.t;
    }

    @Override // com.byazt.vb.n
    public com.byazt.rz.c x() {
        return this.sp;
    }

    public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
        this();
    }

    private c() {
        this.u = new AtomicBoolean(false);
        this.yp = 200;
        this.z = 10;
        this.m = -1;
        this.c = -1;
    }

    @Override // com.byazt.vb.n
    public void c(boolean z) {
        this.u.set(z);
    }

    @Override // com.byazt.vb.n
    public boolean ve() {
        return this.u.get();
    }

    /* JADX INFO: renamed from: com.byazt.vb.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 1891, 44})
    public static class C0302c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2809a;
        public sl c;
        public com.byazt.rz.c n;
        public uj sp;
        public String t;
        public com.byazt.rz.c tt;
        public Context u;
        public com.byazt.rz.c uj;
        public com.byazt.rz.c ve;
        public a x;
        public final AtomicBoolean i = new AtomicBoolean(false);
        public int da = 5000;
        public int sl = 10;
        public int yp = -1;
        public int z = -1;

        public C0302c c(int i) {
            this.yp = i;
            return this;
        }

        public C0302c c(Context context) {
            this.u = context;
            return this;
        }

        public C0302c c(com.byazt.rz.c cVar) {
            this.tt = cVar;
            return this;
        }

        public C0302c c(a aVar) {
            this.x = aVar;
            return this;
        }

        public C0302c c(sl slVar) {
            this.c = slVar;
            return this;
        }

        public C0302c c(uj ujVar) {
            this.sp = ujVar;
            return this;
        }

        public C0302c c(String str) {
            this.t = str;
            return this;
        }

        public C0302c tt(int i) {
            this.z = i;
            return this;
        }

        public C0302c tt(com.byazt.rz.c cVar) {
            this.ve = cVar;
            return this;
        }

        public C0302c tt(boolean z) {
            this.f2809a = z;
            return this;
        }

        public C0302c ve(com.byazt.rz.c cVar) {
            this.uj = cVar;
            return this;
        }

        public C0302c c(boolean z) {
            this.i.set(z);
            return this;
        }

        public c c() {
            c cVar = new c(null);
            cVar.ve = this.c;
            cVar.f2808a = this.tt;
            cVar.sp = this.ve;
            cVar.x = this.uj;
            cVar.i = this.n;
            cVar.sl = this.f2809a;
            cVar.t = this.sp;
            cVar.tt = this.x;
            cVar.u = this.i;
            cVar.uj = this.t;
            cVar.n = this.u;
            cVar.z = this.sl;
            cVar.yp = this.da;
            cVar.m = this.yp;
            cVar.c = this.z;
            return cVar;
        }
    }
}
