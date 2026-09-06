package com.yfanads.android.oaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.yfanads.android.oaid.repackage.com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* JADX INFO: compiled from: AsusImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class a implements com.yfanads.android.oaid.ifs.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9655a;

    public a(Context context) {
        this.f9655a = context;
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final boolean a() {
        Context context = this.f9655a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception e) {
            com.yfanads.android.core.f.a(e, new StringBuilder("not support asus "));
            return false;
        }
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public final void a(com.yfanads.android.oaid.ifs.a aVar) {
        if (this.f9655a != null) {
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
            n.a(this.f9655a, intent, aVar, new n.a() { // from class: com.yfanads.android.oaid.impl.a$$ExternalSyntheticLambda0
                @Override // com.yfanads.android.oaid.impl.n.a
                public final String a(IBinder iBinder) {
                    return a.a(iBinder);
                }
            });
        }
    }

    public static /* synthetic */ String a(IBinder iBinder) throws com.yfanads.android.oaid.a, RemoteException {
        IDidAidlInterface iDidAidlInterfaceAsInterface = IDidAidlInterface.Stub.asInterface(iBinder);
        if (iDidAidlInterfaceAsInterface != null) {
            if (iDidAidlInterfaceAsInterface.isSupport()) {
                return iDidAidlInterfaceAsInterface.getOAID();
            }
            throw new com.yfanads.android.oaid.a("IDidAidlInterface#isSupport return false");
        }
        throw new com.yfanads.android.oaid.a("IDidAidlInterface is null");
    }
}
