package ms.bz.bd.c.Pgl;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class u1 {
    private static volatile u1 c;
    private Throwable tt = null;

    private u1() {
    }

    public static u1 c() {
        if (c == null) {
            synchronized (u1.class) {
                if (c == null) {
                    c = new u1();
                }
            }
        }
        return c;
    }

    public final synchronized Throwable tt() {
        return this.tt;
    }
}
