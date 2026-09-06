package com.ubixnow.ooooo;

import com.ubixnow.core.api.UMNAdManager;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class o0O {
    public static oO0O000o[] OooO00o;
    public static final ReadWriteLock OooO0O0 = new ReentrantReadWriteLock();

    public class OooO00o implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            ReadWriteLock readWriteLock;
            try {
                try {
                    readWriteLock = o0O.OooO0O0;
                    readWriteLock.writeLock().lock();
                    byte[] bArrOooO0o = oOo00o00.OooO0o(UMNAdManager.getInstance().getAppId() + oO00000o.o00000O0.Oooo0O0);
                    if (bArrOooO0o != null && bArrOooO0o.length > 0) {
                        o0O.OooO00o = oO0O00.OooO00o(bArrOooO0o).OooO0Oo;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    readWriteLock = o0O.OooO0O0;
                }
                Lock lockWriteLock = readWriteLock.writeLock();
            } finally {
                o0O.OooO0O0.writeLock().unlock();
            }
        }
    }

    public static void OooO00o() {
        g1.OooO0Oo().OooO0OO(new OooO00o());
    }
}
