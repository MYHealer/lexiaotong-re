package com.byazt.ao;

import com.byazt.th.n;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 1532, 20})
public class c {
    public Throwable c;
    public final CountDownLatch tt;

    /* JADX INFO: renamed from: com.byazt.ao.c$c, reason: collision with other inner class name */
    public interface InterfaceC0094c {
        void c() throws Throwable;
    }

    private c(boolean z, InterfaceC0094c[] interfaceC0094cArr) {
        this.tt = new CountDownLatch(interfaceC0094cArr.length);
        for (final InterfaceC0094c interfaceC0094c : interfaceC0094cArr) {
            n.c(new Runnable() { // from class: com.byazt.ao.c.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        interfaceC0094c.c();
                    } catch (Throwable th) {
                        c.this.c = th;
                    }
                    c.this.tt.countDown();
                }
            }, z);
        }
    }

    public static void c(boolean z, InterfaceC0094c... interfaceC0094cArr) throws Throwable {
        new c(z, interfaceC0094cArr).c();
    }

    private void c() throws Throwable {
        try {
            this.tt.await();
            Throwable th = this.c;
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
