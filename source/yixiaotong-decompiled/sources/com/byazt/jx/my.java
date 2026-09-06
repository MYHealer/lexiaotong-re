package com.byazt.jx;

import com.byazt.zy.rl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 214, 145})
public class my implements ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2390a;
    public final String c;
    public final com.byazt.kd.tt n;
    public final c tt;
    public final com.byazt.kd.tt uj;
    public final com.byazt.kd.tt ve;

    public String c() {
        return this.c;
    }

    public c getType() {
        return this.tt;
    }

    public boolean n() {
        return this.f2390a;
    }

    public com.byazt.kd.tt tt() {
        return this.uj;
    }

    public com.byazt.kd.tt uj() {
        return this.n;
    }

    public com.byazt.kd.tt ve() {
        return this.ve;
    }

    public enum c {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static c c(int i) {
            if (i == 1) {
                return SIMULTANEOUSLY;
            }
            if (i == 2) {
                return INDIVIDUALLY;
            }
            throw new IllegalArgumentException("Unknown trim path type ".concat(String.valueOf(i)));
        }
    }

    public my(String str, c cVar, com.byazt.kd.tt ttVar, com.byazt.kd.tt ttVar2, com.byazt.kd.tt ttVar3, boolean z) {
        this.c = str;
        this.tt = cVar;
        this.ve = ttVar;
        this.uj = ttVar2;
        this.n = ttVar3;
        this.f2390a = z;
    }

    @Override // com.byazt.jx.ve
    public com.byazt.zy.ve c(com.byazt.ga.x xVar, com.byazt.ga.a aVar, com.byazt.zk.ve veVar) {
        return new rl(veVar, this);
    }

    public String toString() {
        return "Trim Path: {start: " + this.ve + ", end: " + this.uj + ", offset: " + this.n + com.alipay.sdk.util.i.d;
    }
}
