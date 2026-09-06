package com.byazt.lr;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 155, 54})
public class ve extends com.byazt.w.x<Long, com.byazt.nn.tt> {

    /* JADX INFO: renamed from: com.byazt.lr.ve$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 155, 79})
    static /* synthetic */ class AnonymousClass1 {
    }

    @com.byazt.zqa.c(c = {0, 1, 155, 24})
    private static class c {
        public static ve c = new ve(null);
    }

    public /* synthetic */ ve(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static ve c() {
        return c.c;
    }

    private ve() {
        super(16, 16);
    }

    public void c(com.byazt.nn.tt ttVar) {
        if (ttVar == null) {
            return;
        }
        put(Long.valueOf(ttVar.c()), ttVar);
    }

    public com.byazt.nn.tt c(long j, long j2) {
        return (com.byazt.nn.tt) get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }
}
