package org.repackage.a.a.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: OpenIDHelper.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public org.repackage.a.a.a.a f9720a = null;
    public String b = null;
    public String c = null;
    public final Object d = new Object();
    public ServiceConnection e = new b(this);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: OpenIDHelper.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f9721a = new c(null);
    }

    public /* synthetic */ c(b bVar) {
    }

    public boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 0);
            if (Build.VERSION.SDK_INT >= 28) {
                return packageInfo != null && packageInfo.getLongVersionCode() >= 1;
            }
            return packageInfo != null && packageInfo.versionCode >= 1;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final String b(Context context, String str) {
        Signature[] signatureArr;
        if (TextUtils.isEmpty(this.b)) {
            this.b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.c)) {
            String string = null;
            try {
                signatureArr = context.getPackageManager().getPackageInfo(this.b, 64).signatures;
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] bArrDigest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b : bArrDigest) {
                            sb.append(Integer.toHexString((b & 255) | 256).substring(1, 3));
                        }
                        string = sb.toString();
                    }
                } catch (NoSuchAlgorithmException e2) {
                    e2.printStackTrace();
                }
            }
            this.c = string;
        }
        String strA = ((org.repackage.a.a.a.a.AbstractBinderC1185a.C1186a) this.f9720a).a(this.b, this.c, str);
        return TextUtils.isEmpty(strA) ? "" : strA;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Code duplicated, block: B:45:0x004b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public synchronized String a(Context context, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("Cannot run on MainThread");
        }
        if (this.f9720a == null) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (!context.bindService(intent, this.e, 1)) {
                if (this.f9720a == null) {
                    return "";
                }
                return b(context, str);
            }
            synchronized (this.d) {
                try {
                    this.d.wait(C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (this.f9720a == null) {
                return "";
            }
            try {
                return b(context, str);
            } catch (RemoteException e2) {
                e2.printStackTrace();
                return "";
            }
        }
        try {
            return b(context, str);
        } catch (RemoteException e3) {
            e3.printStackTrace();
            return "";
        }
        throw th;
    }
}
