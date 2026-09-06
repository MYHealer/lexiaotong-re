package com.byazt.w;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1017, 46})
public class n {
    public c c;
    public c tt;
    public int uj = 10;
    public int ve;

    /* JADX INFO: renamed from: com.byazt.w.n$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 1017, 219})
    static /* synthetic */ class AnonymousClass1 {
    }

    public boolean c(long j, long j2) {
        synchronized (this) {
            c cVar = this.c;
            if (cVar != null) {
                if (j >= cVar.c && j2 >= cVar.tt) {
                    c cVar2 = cVar.ve;
                    if (cVar2 != null && j2 - cVar2.tt < 1000) {
                        cVar.c = j;
                        cVar.tt = j2;
                        return true;
                    }
                }
                return false;
            }
            c cVarC = c();
            cVarC.c = j;
            cVarC.tt = j2;
            if (cVar != null) {
                cVarC.ve = cVar;
                cVar.uj = cVarC;
            }
            this.c = cVarC;
            return true;
        }
    }

    public long tt(long j, long j2) {
        synchronized (this) {
            c cVar = this.c;
            if (cVar == null) {
                return -1L;
            }
            c cVarC = c(j);
            if (cVarC == null) {
                return -1L;
            }
            long j3 = cVar.c - cVarC.c;
            long j4 = j2 - cVarC.tt;
            if (j3 < 0 || j4 <= 0) {
                return -1L;
            }
            return j3 / j4;
        }
    }

    private c c() {
        c cVar;
        int i = this.ve;
        AnonymousClass1 anonymousClass1 = null;
        if (i >= this.uj && (cVar = this.tt) != null) {
            c cVar2 = cVar.uj;
            cVar.uj = null;
            this.tt = cVar2;
            if (cVar2 != null) {
                cVar2.ve = null;
            }
            return cVar;
        }
        this.ve = i + 1;
        return new c(anonymousClass1);
    }

    private c c(long j) {
        c cVar = this.c;
        c cVar2 = null;
        while (cVar != null && cVar.tt > j) {
            cVar2 = cVar;
            cVar = cVar.ve;
        }
        return (cVar == null || cVar2 == null || cVar == cVar2 || j - cVar.tt >= cVar2.tt - j) ? cVar2 : cVar;
    }

    @com.byazt.zqa.c(c = {0, 1, 1017, 151})
    private static class c {
        public long c;
        public long tt;
        public c uj;
        public c ve;

        private c() {
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }
    }
}
