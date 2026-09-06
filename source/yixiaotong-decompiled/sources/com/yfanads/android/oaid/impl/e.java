package com.yfanads.android.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.yfanads.android.oaid.repackage.com.android.creator.IdsSupplier;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: FreemeImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class e implements com.yfanads.android.oaid.ifs.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9658a;

    public e(Context context) {
        this.f9658a = context;
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final boolean a() {
        Context context = this.f9658a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e) {
            YFLog.debug(e.getMessage());
            return false;
        }
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final void a(com.yfanads.android.oaid.ifs.a aVar) {
        if (this.f9658a != null) {
            Intent intent = new Intent("android.service.action.msa");
            intent.setPackage("com.android.creator");
            n.a(this.f9658a, intent, aVar, new n.a() { // from class: com.yfanads.android.oaid.impl.e$$ExternalSyntheticLambda0
                @Override // com.yfanads.android.oaid.impl.n.a
                public final String a(IBinder iBinder) {
                    return e.a(iBinder);
                }
            });
        }
    }

    public static /* synthetic */ String a(IBinder iBinder) throws com.yfanads.android.oaid.a, RemoteException {
        IdsSupplier idsSupplierAsInterface = IdsSupplier.Stub.asInterface(iBinder);
        if (idsSupplierAsInterface != null) {
            return idsSupplierAsInterface.getOAID();
        }
        throw new com.yfanads.android.oaid.a("IdsSupplier is null");
    }
}
