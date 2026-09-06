package com.byazt.aas;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 47})
public final class eo {
    public static volatile boolean c;

    @com.byazt.zqa.c(c = {0, 1, 131, 1387})
    static class c {
        public static final com.byazt.yy.uj.c c = eo.uj();
    }

    public static void c() {
        c = true;
    }

    public static int tt() {
        return 3;
    }

    private static String tt(String str) {
        return (c || com.byazt.nr.gt.c(com.byazt.omf.gt.getContext())) ? str : str + com.byazt.nr.gt.tt(com.byazt.omf.gt.getContext());
    }

    public static com.byazt.iy.n c(String str) {
        return c.c.c(tt(str)).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.yy.uj.c uj() {
        com.byazt.ogz.sl slVarTt = com.byazt.omf.gt.tt();
        slVarTt.by();
        return new com.byazt.yy.uj.c().c(com.byazt.omf.gt.getContext()).c(1).tt(slVarTt.ck()).c(c);
    }
}
