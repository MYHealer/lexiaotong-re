package com.adprof.sdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.stub.StubApp;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class dh implements jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1130a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f221a;

    public dh(Context context) {
        this.f1130a = context instanceof Application ? context : StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static String a(dh dhVar, IBinder iBinder) throws mg, PackageManager.NameNotFoundException, NoSuchAlgorithmException, RemoteException {
        String packageName = dhVar.f1130a.getPackageName();
        String string = dhVar.f221a;
        if (string == null) {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(dhVar.f1130a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b : bArrDigest) {
                sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
            }
            string = sb.toString();
            dhVar.f221a = string;
        }
        return dhVar.a(iBinder, packageName, string);
    }

    @Override // com.adprof.sdk.jb
    public void a(eb ebVar) {
        if (this.f1130a == null || ebVar == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        qg.a(this.f1130a, intent, ebVar, new ch(this));
    }

    @Override // com.adprof.sdk.jb
    public boolean a() {
        Context context = this.f1130a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    public final String a(IBinder iBinder, String str, String str2) throws mg, RemoteException {
        nb lbVar;
        int i = mb.f1304a;
        if (iBinder == null) {
            lbVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            lbVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof nb)) ? new lb(iBinder) : (nb) iInterfaceQueryLocalInterface;
        }
        if (lbVar != null) {
            return ((lb) lbVar).a(str, str2, "OUID");
        }
        throw new mg("IOpenID is null");
    }
}
