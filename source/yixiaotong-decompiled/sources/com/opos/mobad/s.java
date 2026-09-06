package com.opos.mobad;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class s {
    public static boolean a(com.opos.mobad.d.a.b bVar, int i, int i2) {
        boolean z = true;
        if (bVar == null) {
            return true;
        }
        for (int i3 = 0; i3 < i; i3++) {
            if (bVar.a()) {
                com.opos.cmn.an.f.a.b("RetryFileLockTool", "acquireFileLock retry time=" + i + ",interval =" + i2 + ",result =" + z);
                return z;
            }
            com.opos.cmn.an.f.a.a("RetryFileLockTool", "acquireFileLock but thread has acquire " + i3);
            try {
                Thread.sleep(i2);
            } catch (InterruptedException e) {
                com.opos.cmn.an.f.a.a("RetryFileLockTool", "", (Throwable) e);
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("RetryFileLockTool", "acquireFileLock retry time=" + i + ",interval =" + i2 + ",result =" + z);
        return z;
    }
}
