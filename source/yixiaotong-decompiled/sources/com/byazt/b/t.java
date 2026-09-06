package com.byazt.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 223, 66})
public class t {
    public static volatile com.byazt.zz.u c;
    public static volatile com.byazt.zz.u tt;

    public static com.byazt.zz.u c(boolean z) {
        if (z && com.byazt.zz.ve.lo()) {
            if (tt == null) {
                synchronized (t.class) {
                    if (tt == null) {
                        tt = com.byazt.zz.ve.pu().tt();
                    }
                }
            }
            return tt;
        }
        if (c == null) {
            synchronized (t.class) {
                if (c == null) {
                    c = new m();
                }
            }
        }
        return c;
    }
}
