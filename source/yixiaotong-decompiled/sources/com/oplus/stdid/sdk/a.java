package com.oplus.stdid.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.stub.StubApp;
import java.util.HashMap;
import s_a.s_a.s_a.c.h;
import s_a.s_a.s_a.c.i;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class a {
    public static Context a(Context context) {
        return (context == null || StubApp.getOrigApplicationContext(context.getApplicationContext()) == null) ? context : StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public static boolean a() {
        return d.a();
    }

    public static void b(Context context) {
        String str;
        boolean z;
        String str2;
        s_a.s_a.s_a.c.b bVar;
        String str3;
        Context contextA = a(context);
        d.d = contextA;
        s_a.s_a.s_a.c.a.a(contextA);
        c cVar = c.b.f5843a;
        cVar.h = d.d;
        h.a("2008");
        boolean z2 = false;
        try {
            PackageInfo packageInfo = cVar.h.getPackageManager().getPackageInfo("com.oplus.stdid", 8);
            z = packageInfo != null && packageInfo.versionCode >= 1 && s_a.s_a.s_a.c.a.a(cVar.h, "com.oplus.stdid");
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            str = "1078";
            h.a(str, e);
        } catch (Exception e2) {
            e = e2;
            str = "1079";
            h.a(str, e);
        }
        d.b = z;
        if (z) {
            d.c = true;
        } else {
            d.c = false;
            s_a.s_a.s_a.c.d.d = d.d;
            boolean zA = s_a.s_a.s_a.c.c.b.f9752a.a(s_a.s_a.s_a.c.d.d);
            s_a.s_a.s_a.c.d.b = zA;
            if (zA) {
                bVar = s_a.s_a.s_a.c.b.C1191b.f9750a;
                str3 = "OP_APP";
            } else {
                i iVar = i.b.f9758a;
                iVar.h = s_a.s_a.s_a.c.d.d;
                String strA = s_a.s_a.s_a.c.a.a("Y29tLmNvbG9yb3MubWNz");
                h.a("2008:" + strA);
                try {
                    PackageInfo packageInfo2 = iVar.h.getPackageManager().getPackageInfo(strA, 0);
                    if (packageInfo2 != null) {
                        if (Build.VERSION.SDK_INT > 28) {
                            h.a("2008: > P");
                        } else {
                            long longVersionCode = Build.VERSION.SDK_INT == 28 ? packageInfo2.getLongVersionCode() : packageInfo2.versionCode;
                            h.a("2008: " + longVersionCode);
                            if (longVersionCode >= 11200) {
                                if (longVersionCode >= 11609) {
                                    iVar.j = true;
                                }
                                z2 = true;
                            }
                        }
                    }
                } catch (PackageManager.NameNotFoundException e3) {
                    e = e3;
                    str2 = "1072";
                    h.a(str2, e);
                } catch (Exception e4) {
                    e = e4;
                    str2 = "1073";
                    h.a(str2, e);
                }
                s_a.s_a.s_a.c.d.c = z2;
                bVar = s_a.s_a.s_a.c.b.C1191b.f9750a;
                str3 = "MCS_APP";
            }
            bVar.b = str3;
            s_a.s_a.s_a.c.d.f9753a = true;
        }
        d.f5844a = true;
    }

    @Deprecated
    public static boolean c(Context context) {
        h.a("2002");
        if (!d.f5844a) {
            Log.e("IDHelper", "1001");
            return false;
        }
        if (d.c) {
            return false;
        }
        HashMap<String, String> mapA = s_a.s_a.s_a.c.d.a(32);
        return "TRUE".equalsIgnoreCase(mapA.get("OUID_STATUS") == null ? "FALSE" : mapA.get("OUID_STATUS"));
    }

    @Deprecated
    public static String d(Context context) {
        h.a("2003");
        return d.a(8, "OUID");
    }

    @Deprecated
    public static String e(Context context) {
        h.a("2004");
        return d.a(4, "DUID");
    }
}
