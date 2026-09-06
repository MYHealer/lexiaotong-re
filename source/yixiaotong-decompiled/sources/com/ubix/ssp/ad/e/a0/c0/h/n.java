package com.ubix.ssp.ad.e.a0.c0.h;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.stub.StubApp;
import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class n implements com.ubix.ssp.ad.e.a0.c0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f8660a;
    private String b;

    class a implements m.a {
        a() {
        }

        @Override // com.ubix.ssp.ad.e.a0.c0.h.m.a
        public String a(IBinder iBinder) throws RemoteException {
            try {
                return n.this.a(iBinder);
            } catch (RemoteException e) {
                throw e;
            } catch (com.ubix.ssp.ad.e.a0.c0.e e2) {
                throw e2;
            } catch (Exception e3) {
                throw new com.ubix.ssp.ad.e.a0.c0.e(e3);
            }
        }
    }

    public n(Context context) {
        this.f8660a = context instanceof Application ? context : StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(IBinder iBinder) {
        String packageName = this.f8660a.getPackageName();
        String str = this.b;
        if (str != null) {
            return a(iBinder, packageName, str);
        }
        byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.f8660a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
        }
        String string = sb.toString();
        this.b = string;
        return a(iBinder, packageName, string);
    }

    private String a(IBinder iBinder, String str, String str2) {
        com.ubix.ssp.ad.e.a0.c0.i.g.a aVarA = com.ubix.ssp.ad.e.a0.c0.i.g.a.AbstractBinderC1082a.a(iBinder);
        if (aVarA != null) {
            return aVarA.a(str, str2, "OUID");
        }
        throw new com.ubix.ssp.ad.e.a0.c0.e("IOpenID is null");
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public void a(com.ubix.ssp.ad.e.a0.c0.c cVar) {
        if (this.f8660a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        m.a(this.f8660a, intent, cVar, new a());
    }

    @Override // com.ubix.ssp.ad.e.a0.c0.d
    public boolean a() {
        Context context = this.f8660a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e) {
            com.ubix.ssp.ad.e.a0.c0.f.a(e);
            return false;
        }
    }
}
