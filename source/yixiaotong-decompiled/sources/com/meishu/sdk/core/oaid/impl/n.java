package com.meishu.sdk.core.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.meishu.sdk.core.oaid.OAIDException;
import com.stub.StubApp;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: OppoImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class n implements com.meishu.sdk.core.oaid.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4839a;
    public String b;

    /* JADX INFO: compiled from: OppoImpl.java */
    public class a implements m.a {
        public a() {
        }

        @Override // com.meishu.sdk.core.oaid.impl.m.a
        public String a(IBinder iBinder) throws OAIDException, RemoteException {
            try {
                return n.this.a(iBinder);
            } catch (RemoteException e) {
                throw e;
            } catch (OAIDException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new OAIDException(e3);
            }
        }
    }

    public n(Context context) {
        if (context instanceof Application) {
            this.f4839a = context;
        } else {
            this.f4839a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    @Override // com.meishu.sdk.core.oaid.b
    public boolean a() {
        Context context = this.f4839a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.meishu.sdk.core.oaid.b
    public void a(com.meishu.sdk.core.oaid.a aVar) {
        if (this.f4839a == null || aVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        m.a(this.f4839a, intent, aVar, new a());
    }

    public final String a(IBinder iBinder) throws OAIDException, PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException {
        String packageName = this.f4839a.getPackageName();
        String str = this.b;
        if (str == null) {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.f4839a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            String string = sb.toString();
            this.b = string;
            return a(iBinder, packageName, string);
        }
        return a(iBinder, packageName, str);
    }

    public final String a(IBinder iBinder, String str, String str2) throws OAIDException, RemoteException {
        com.meishu.sdk.core.oaid.repeackage.com.heytap.openid.a c0811a;
        int i = com.meishu.sdk.core.oaid.repeackage.com.heytap.openid.a.AbstractBinderC0810a.f4854a;
        if (iBinder == null) {
            c0811a = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof com.meishu.sdk.core.oaid.repeackage.com.heytap.openid.a)) {
                c0811a = (com.meishu.sdk.core.oaid.repeackage.com.heytap.openid.a) iInterfaceQueryLocalInterface;
            } else {
                c0811a = new com.meishu.sdk.core.oaid.repeackage.com.heytap.openid.a.AbstractBinderC0810a.C0811a(iBinder);
            }
        }
        if (c0811a != null) {
            return c0811a.a(str, str2, "OUID");
        }
        throw new OAIDException("IOpenID is null");
    }
}
