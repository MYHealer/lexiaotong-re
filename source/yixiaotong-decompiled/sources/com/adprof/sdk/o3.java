package com.adprof.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.ubix.ssp.open.comm.AdActivity;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class o3 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1335a = "-----AppInstallReceiver ";

    public final void a(Context context, d dVar, PackageInfo packageInfo) {
        String str;
        qn.a(dVar, "app_install_end");
        oh.a("app_install_end", null, dVar);
        HashMap map = new HashMap();
        map.put("result", "1");
        s5.a(dVar.k(), map, "action.ad.install.end", 0);
        String str2 = packageInfo.packageName;
        in.a().a(new n3(this, dVar));
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(packageInfo.packageName);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
            }
            try {
                qn.a(dVar, "install_open");
                oh.a("app_install_active", null, dVar);
            } catch (Exception e) {
                e = e;
                str = "AppInstallReceiver install_finish error2: ";
                pk.a(str, e);
            }
        } catch (Throwable th) {
            e = th;
            str = "AppInstallReceiver install_finish error1: ";
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x0148  */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        d dVar;
        byte b;
        StringBuilder sbAppend;
        try {
            pk.b(this.f1335a + " enter ----");
            PackageManager packageManager = context.getPackageManager();
            String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            PackageInfo packageInfo = packageManager.getPackageInfo(schemeSpecificPart, 0);
            boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
            String strEncodeToString = Base64.encodeToString(intent.getAction().getBytes(), 2);
            if (strEncodeToString.equals("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlBBQ0tBR0VfUkVNT1ZFRA==") && !booleanExtra) {
                pk.b("AppInstallReceiver return ----");
                return;
            }
            if (TextUtils.isEmpty(schemeSpecificPart)) {
                dVar = null;
            } else {
                File file = new File(k1.m667a(), schemeSpecificPart + ".log");
                Object objA = j9.a(file.getAbsolutePath());
                if (objA instanceof d) {
                    dVar = (d) objA;
                    pk.b(this.f1335a + "adunit=  ----" + dVar);
                    d dVarA = h2.a(dVar.k());
                    if (dVarA != null) {
                        dVar = dVarA;
                    }
                } else {
                    dVar = null;
                }
                j9.m658a(file.getAbsolutePath());
            }
            if (dVar == null) {
                pk.b(this.f1335a + " adunit == null  return");
                return;
            }
            if (TextUtils.isEmpty(dVar.m601c())) {
                try {
                    Context context2 = AdprofSdk.getInstance().getContext();
                    String.valueOf((context2 != null ? context2.getPackageManager() : null).getApplicationLabel(packageInfo.applicationInfo));
                } catch (Throwable unused) {
                }
            }
            pk.a(this.f1335a + " action = " + strEncodeToString);
            int iHashCode = strEncodeToString.hashCode();
            if (iHashCode != -1380358613) {
                if (iHashCode != -248756734) {
                    if (iHashCode != 1293128098) {
                        if (iHashCode == 1931663641 && strEncodeToString.equals("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLklOU1RBTExfRkFJTFVSRQ==")) {
                            b = 3;
                        } else {
                            b = -1;
                        }
                    } else if (strEncodeToString.equals(AdActivity.INSTALL_ACTION)) {
                        b = 0;
                    } else {
                        b = -1;
                    }
                } else if (strEncodeToString.equals("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlBBQ0tBR0VfUkVNT1ZFRA==")) {
                    b = 1;
                } else {
                    b = -1;
                }
            } else if (strEncodeToString.equals("YW5kcm9pZC5pbnRlbnQuYWN0aW9uLlBBQ0tBR0VfUkVQTEFDRUQ=")) {
                b = 2;
            } else {
                b = -1;
            }
            if (b == 0) {
                sbAppend = new StringBuilder().append(this.f1335a).append("---APP_ADD");
            } else {
                if (b != 1 && b != 2) {
                    if (b != 3) {
                        return;
                    }
                    pk.a(this.f1335a + "---APP_INSTALL_FAIL");
                    HashMap map = new HashMap();
                    map.put("result", "0");
                    s5.a(dVar.k(), map, "action.ad.install.end", 0);
                    return;
                }
                sbAppend = new StringBuilder().append(this.f1335a).append("---APP_REPLACE");
            }
            pk.a(sbAppend.toString());
            a(context, dVar, packageInfo);
        } catch (Throwable th) {
            pk.c("AppInstallReceiver error: ", th);
        }
    }
}
