package com.yfanads.android.oaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.yfanads.android.oaid.repackage.com.oplus.stdid.IStdID;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: compiled from: OppoExtImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class o extends p {
    public final Context c;

    public o(Context context) {
        super(context);
        this.c = context;
    }

    @Override // com.yfanads.android.oaid.impl.p, com.yfanads.android.oaid.ifs.b
    public final boolean a() {
        Context context = this.c;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coloros.mcs", 0) != null;
        } catch (Exception e) {
            YFLog.debug(e);
            return false;
        }
    }

    @Override // com.yfanads.android.oaid.impl.p, com.yfanads.android.oaid.ifs.b
    public final void a(com.yfanads.android.oaid.ifs.a aVar) {
        if (this.c != null) {
            Intent intent = new Intent("action.com.oplus.stdid.ID_SERVICE");
            intent.setComponent(new ComponentName("com.coloros.mcs", "com.oplus.stdid.IdentifyService"));
            n.a(this.c, intent, aVar, new n.a() { // from class: com.yfanads.android.oaid.impl.o$$ExternalSyntheticLambda0
                @Override // com.yfanads.android.oaid.impl.n.a
                public final String a(IBinder iBinder) {
                    return this.f$0.a(iBinder);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String a(IBinder iBinder) throws com.yfanads.android.oaid.a, RemoteException {
        try {
            return b(iBinder);
        } catch (RemoteException e) {
            throw e;
        } catch (com.yfanads.android.oaid.a e2) {
            throw e2;
        } catch (Exception e3) {
            throw new com.yfanads.android.oaid.a(e3);
        }
    }

    @Override // com.yfanads.android.oaid.impl.p
    public final String a(IBinder iBinder, String str, String str2) throws com.yfanads.android.oaid.a, RemoteException {
        IStdID iStdIDAsInterface = IStdID.Stub.asInterface(iBinder);
        if (iStdIDAsInterface != null) {
            return iStdIDAsInterface.getSerID(str, str2, "OUID");
        }
        throw new com.yfanads.android.oaid.a("IStdID is null");
    }
}
