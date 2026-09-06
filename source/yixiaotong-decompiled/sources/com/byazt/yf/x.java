package com.byazt.yf;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, TypedValues.PositionType.TYPE_CURVE_FIT, 71})
public class x {
    public boolean c;
    public String tt;
    public boolean uj;
    public boolean ve;

    /* JADX INFO: renamed from: com.byazt.yf.x$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, TypedValues.PositionType.TYPE_CURVE_FIT, 30})
    static /* synthetic */ class AnonymousClass1 {
    }

    public String c() {
        return this.tt;
    }

    public boolean tt() {
        return this.c;
    }

    public boolean uj() {
        return this.uj;
    }

    public boolean ve() {
        return this.ve;
    }

    public /* synthetic */ x(c cVar, AnonymousClass1 anonymousClass1) {
        this(cVar);
    }

    private x(c cVar) {
        this.c = cVar.c;
        this.tt = cVar.tt;
        this.ve = cVar.ve;
        this.uj = cVar.uj;
    }

    @com.byazt.zqa.c(c = {0, 1, TypedValues.PositionType.TYPE_CURVE_FIT, 62})
    public static class c {
        public boolean c = false;
        public String tt = null;
        public boolean ve = false;
        public boolean uj = false;

        public c c(String str) {
            this.tt = str;
            return this;
        }

        public c c(boolean z) {
            this.c = z;
            return this;
        }

        public c tt(boolean z) {
            this.ve = z;
            return this;
        }

        public c ve(boolean z) {
            this.uj = z;
            return this;
        }

        public x c() {
            return new x(this, null);
        }
    }
}
