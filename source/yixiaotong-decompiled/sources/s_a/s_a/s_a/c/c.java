package s_a.s_a.s_a.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class c extends s_a.s_a.s_a.a.c {

    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            String str;
            h.a("2014");
            c.this.f9742a = s_a.s_a.s_a.a.AbstractBinderC1187a.a(iBinder);
            try {
                iBinder.linkToDeath(c.this.m, 0);
            } catch (RemoteException e) {
                e = e;
                str = "1028";
                h.a(str, e);
            } catch (Exception e2) {
                e = e2;
                str = "1067";
                h.a(str, e);
            }
            synchronized (c.this.d) {
                h.a("2015");
                c.this.d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            h.a("2016");
            c.this.f9742a = null;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f9752a = new c();
    }

    public c() {
        this.e = new a();
    }

    @Override // s_a.s_a.s_a.a.c
    public Intent a() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(s_a.s_a.s_a.c.a.a("Y29tLmhleXRhcC5vcGVuaWQ="), s_a.s_a.s_a.c.a.a("Y29tLmhleXRhcC5vcGVuaWQuSWRlbnRpZnlTZXJ2aWNl")));
        intent.setAction(s_a.s_a.s_a.c.a.a("YWN0aW9uLmNvbS5oZXl0YXAub3BlbmlkLk9QRU5fSURfU0VSVklDRQ=="));
        h.a("2012");
        return intent;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0024 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0027 A[ORIG_RETURN, RETURN] */
    @Override // s_a.s_a.s_a.a.c
    public String a(String str) {
        String str2;
        try {
            return this.i ? d(str) : ((s_a.s_a.s_a.a) this.f9742a).a(this.b, this.c, str);
        } catch (NullPointerException e) {
            e = e;
            str2 = "1027";
            h.a(str2, e);
            if (str == "OUID_STATUS") {
                return "FALSE";
            }
            return "";
        } catch (Exception e2) {
            e = e2;
            str2 = "1070";
            h.a(str2, e);
            if (str == "OUID_STATUS") {
                return "FALSE";
            }
            return "";
        }
    }

    @Override // s_a.s_a.s_a.a.c
    public void a(Context context, String str, String str2) {
        s_a.s_a.s_a.c.b.C1191b.f9750a.a(context, str, str2);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0048  */
    public boolean a(Context context) {
        String str;
        boolean z;
        this.h = context;
        String strA = s_a.s_a.s_a.c.a.a("Y29tLmhleXRhcC5vcGVuaWQ=");
        h.a("2008:" + strA);
        try {
            PackageInfo packageInfo = this.h.getPackageManager().getPackageInfo(strA, 8);
            if (packageInfo == null || packageInfo.versionCode < 1) {
                z = false;
            } else {
                Context context2 = this.h;
                if (Build.VERSION.SDK_INT >= 29 || s_a.s_a.s_a.c.a.b(context2, "android").equals(s_a.s_a.s_a.c.a.b(context2, strA))) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (providerInfoArr == null || providerInfoArr.length == 0) {
                    Log.e("IDHelper", "1089");
                } else {
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        if (providerInfo.authority.equals("com.oplus.omes.oaid_status_provider")) {
                            this.k = true;
                            h.a("2053");
                            break;
                        }
                    }
                }
                if ((Build.VERSION.SDK_INT == 27 || Build.VERSION.SDK_INT == 26) && packageInfo.versionCode >= 7) {
                    this.j = true;
                }
            }
            return z;
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            str = "1068";
            h.a(str, e);
            return false;
        } catch (Exception e2) {
            e = e2;
            str = "1069";
            h.a(str, e);
            return false;
        }
    }

    @Override // s_a.s_a.s_a.a.c
    public boolean b(String str) {
        return s_a.s_a.s_a.c.b.C1191b.f9750a.b(str);
    }

    @Override // s_a.s_a.s_a.a.c
    public boolean c(String str) {
        return s_a.s_a.s_a.c.b.C1191b.f9750a.a(str);
    }
}
