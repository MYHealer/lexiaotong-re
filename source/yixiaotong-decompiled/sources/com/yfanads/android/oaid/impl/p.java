package com.yfanads.android.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.RemoteException;
import com.stub.StubApp;
import com.yfanads.android.oaid.repackage.com.heytap.openid.IOpenID;
import com.yfanads.android.utils.YFLog;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: OppoImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class p implements com.yfanads.android.oaid.ifs.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f9671a;
    public String b;

    public p(Context context) {
        if (context instanceof Application) {
            this.f9671a = context;
        } else {
            this.f9671a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    public final String b(IBinder iBinder) throws com.yfanads.android.oaid.a, PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException {
        String packageName = this.f9671a.getPackageName();
        String str = this.b;
        if (str != null) {
            return a(iBinder, packageName, str);
        }
        byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(this.f9671a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
        StringBuilder sb = new StringBuilder();
        for (byte b : bArrDigest) {
            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
        }
        String string = sb.toString();
        this.b = string;
        return a(iBinder, packageName, string);
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public boolean a() {
        Context context = this.f9671a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e) {
            YFLog.debug(e);
            return false;
        }
    }

    @Override // com.yfanads.android.oaid.ifs.b
    public void a(com.yfanads.android.oaid.ifs.a aVar) {
        if (this.f9671a != null) {
            Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            n.a(this.f9671a, intent, aVar, new n.a() { // from class: com.yfanads.android.oaid.impl.p$$ExternalSyntheticLambda0
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

    public String a(IBinder iBinder, String str, String str2) throws com.yfanads.android.oaid.a, RemoteException {
        IOpenID iOpenIDAsInterface = IOpenID.Stub.asInterface(iBinder);
        if (iOpenIDAsInterface != null) {
            return iOpenIDAsInterface.getSerID(str, str2, "OUID");
        }
        throw new com.yfanads.android.oaid.a("IOpenID is null");
    }
}
