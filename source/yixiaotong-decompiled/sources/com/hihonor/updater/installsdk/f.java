package com.hihonor.updater.installsdk;

import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class f extends com.hihonor.updater.installsdk.a.b.AbstractBinderC0480b {
    @Override // com.hihonor.updater.installsdk.a.b
    public void a(int i, String str) throws RemoteException {
        try {
            b(i, str);
        } catch (Throwable th) {
            com.hihonor.updater.installsdk.c.a.b("RemoteCallback", "onResponse error " + th);
        }
    }

    public abstract void b(int i, String str);
}
