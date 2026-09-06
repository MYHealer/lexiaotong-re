package com.byazt.lf;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 526, 54})
public final class ve {
    public c c;
    public tt tt;

    /* JADX INFO: renamed from: com.byazt.lf.ve$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 526, 79})
    static /* synthetic */ class AnonymousClass1 {
    }

    public enum c {
        DEBUG,
        INFO,
        ERROR,
        OFF
    }

    public interface tt {
        void c(String str, String str2);
    }

    /* JADX INFO: renamed from: com.byazt.lf.ve$ve, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 526, 917})
    private static class C0209ve {
        public static final ve c = new ve(null);
    }

    public /* synthetic */ ve(AnonymousClass1 anonymousClass1) {
        this();
    }

    private ve() {
        this.c = c.OFF;
        this.tt = new com.byazt.lf.tt();
    }

    public static void c(c cVar) {
        synchronized (ve.class) {
            C0209ve.c.c = cVar;
        }
    }

    public static void c(String str, String str2) {
        if (C0209ve.c.c.compareTo(c.ERROR) <= 0) {
            C0209ve.c.tt.c(str, str2);
        }
    }

    public static void tt(String str, String str2) {
        if (C0209ve.c.c.compareTo(c.DEBUG) <= 0) {
            ve unused = C0209ve.c;
        }
    }
}
