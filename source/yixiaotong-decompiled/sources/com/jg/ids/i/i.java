package com.jg.ids.i;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.os.IBinder;
import android.text.TextUtils;
import java.security.MessageDigest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\93504.dex */
public final class i extends com.jg.ids.g {
    private String b;
    private String c;

    public i(Context context) {
        super(context);
        this.b = "";
        this.c = "";
    }

    @Override // com.jg.ids.g
    protected final Intent a() {
        switch (this.c) {
            case "openid":
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
                intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
                return intent;
            case "mcsid":
                Intent intent2 = new Intent("action.com.oplus.stdid.ID_SERVICE");
                intent2.setComponent(new ComponentName("com.coloros.mcs", "com.oplus.stdid.IdentifyService"));
                return intent2;
            case "stdid":
                Intent intent3 = new Intent("action.com.oplus.stdid.ID_SERVICE");
                intent3.setComponent(new ComponentName("com.oplus.stdid", "com.oplus.stdid.IdentifyService"));
                return intent3;
            default:
                return null;
        }
    }

    @Override // com.jg.ids.g
    protected final void a(IBinder iBinder) {
        h hVarA = null;
        try {
            switch (this.c) {
                case "openid":
                    hVarA = b.a(iBinder);
                    break;
                case "mcsid":
                    hVarA = e.a(iBinder);
                    break;
                case "stdid":
                    hVarA = e.a(iBinder);
                    break;
            }
            String strA = a(this.f4599a, hVarA, "AUID");
            String strA2 = a(this.f4599a, hVarA, "OUID");
            String strA3 = a(this.f4599a, hVarA, "DUID");
            a(strA);
            b(strA3);
            c(strA2);
            b();
        } catch (Throwable th) {
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final boolean d() {
        if (this.f4599a == null) {
            return false;
        }
        if (g.a(this.f4599a)) {
            this.c = "openid";
        }
        if (com.jg.ids.j.b(this.f4599a)) {
            this.c = "mcsid";
        }
        if (j.d(this.f4599a)) {
            this.c = "stdid";
        }
        return !TextUtils.isEmpty(this.c);
    }

    private String a(Context context, h hVar, String str) {
        Signature[] signatureArr;
        String string = null;
        if (context == null || hVar == null || !d()) {
            return "";
        }
        String packageName = this.f4599a.getPackageName();
        if (TextUtils.isEmpty(this.b)) {
            try {
                signatureArr = this.f4599a.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Throwable th) {
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
                } catch (Throwable th2) {
                }
            }
            this.b = string;
        }
        return hVar.a(context.getPackageName(), this.b, str);
    }
}
