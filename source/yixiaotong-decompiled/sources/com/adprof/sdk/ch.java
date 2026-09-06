package com.adprof.sdk;

import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ch implements pg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dh f1112a;

    public ch(dh dhVar) {
        this.f1112a = dhVar;
    }

    @Override // com.adprof.sdk.pg
    public String a(IBinder iBinder) throws mg, RemoteException {
        try {
            return dh.a(this.f1112a, iBinder);
        } catch (RemoteException e) {
            throw e;
        } catch (mg e2) {
            throw e2;
        } catch (Exception e3) {
            throw new mg(e3);
        }
    }
}
