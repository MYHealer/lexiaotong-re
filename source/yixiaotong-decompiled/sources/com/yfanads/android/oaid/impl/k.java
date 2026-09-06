package com.yfanads.android.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.yfanads.android.oaid.repackage.com.bun.lib.MsaIdInterface;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: MsaImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class k implements com.yfanads.android.oaid.ifs.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9667a;

    public k(Context context) {
        this.f9667a = context;
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final boolean a() {
        Context context = this.f9667a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e) {
            YFLog.debug(e);
            return false;
        }
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final void a(com.yfanads.android.oaid.ifs.a aVar) {
        if (this.f9667a != null) {
            try {
                Intent intent = new Intent("com.bun.msa.action.start.service");
                intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
                intent.putExtra("com.bun.msa.param.pkgname", this.f9667a.getPackageName());
                this.f9667a.startForegroundService(intent);
            } catch (Exception e) {
                YFLog.debug(e);
            }
            Intent intent2 = new Intent("com.bun.msa.action.bindto.service");
            intent2.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent2.putExtra("com.bun.msa.param.pkgname", this.f9667a.getPackageName());
            n.a(this.f9667a, intent2, aVar, new n.a() { // from class: com.yfanads.android.oaid.impl.k$$ExternalSyntheticLambda0
                @Override // com.yfanads.android.oaid.impl.n.a
                public final String a(IBinder iBinder) {
                    return k.a(iBinder);
                }
            });
        }
    }

    public static /* synthetic */ String a(IBinder iBinder) throws com.yfanads.android.oaid.a, RemoteException {
        MsaIdInterface msaIdInterfaceAsInterface = MsaIdInterface.Stub.asInterface(iBinder);
        if (msaIdInterfaceAsInterface != null) {
            if (msaIdInterfaceAsInterface.isSupported()) {
                return msaIdInterfaceAsInterface.getOAID();
            }
            throw new com.yfanads.android.oaid.a("MsaIdInterface#isSupported return false");
        }
        throw new com.yfanads.android.oaid.a("MsaIdInterface is null");
    }
}
