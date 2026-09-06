package com.kuaishou.weapon.p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.stub.StubApp;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f4722a = 3;
    private static q b = null;
    private static final String g = "1";
    private volatile boolean c = false;
    private dn d;
    private Context e;
    private t f;

    private q(Context context) {
        this.e = context;
        this.d = dn.a(context);
        this.f = t.a(context);
    }

    public static synchronized q a(Context context) {
        try {
            if (b == null) {
                b = new q(context);
            }
        } catch (Exception unused) {
            return null;
        }
        return b;
    }

    public void a() {
        d();
        if (WeaponHI.isLoad) {
            b();
        } else {
            WeaponHI.iD();
        }
    }

    private static void d() {
        try {
            dn dnVarA = dn.a();
            if (dnVarA != null) {
                dnVarA.b("W_S_V", "1");
            }
        } catch (Exception unused) {
        }
    }

    public synchronized void b() {
        String canonicalPath;
        try {
            if (this.c) {
                return;
            }
            this.c = true;
            for (s sVar : this.f.a()) {
                try {
                    canonicalPath = this.e.getFilesDir().getCanonicalPath();
                } catch (Throwable unused) {
                    canonicalPath = null;
                }
                if (canonicalPath != null) {
                    sVar.m = canonicalPath + bg.j + sVar.f4726a;
                    dl.c(sVar.m + "/lib");
                    dl.c(sVar.m);
                    dl.c(canonicalPath + "/.tmp");
                }
            }
            this.f.b();
            if (!this.d.b(dn.d)) {
                this.d.a(dn.d, Boolean.TRUE, true);
            } else {
                this.f.c();
            }
            n.a().a(new u(this.e, 1, false));
        } catch (Throwable unused2) {
        }
    }

    public void c() {
        for (s sVar : this.f.a()) {
            r rVarA = r.a();
            if ((rVarA != null ? rVarA.d(sVar.c) : null) == null) {
                a(sVar.f4726a, sVar.d, (PackageInfo) null);
            }
        }
    }

    public synchronized boolean a(int i, String str, PackageInfo packageInfo) {
        return a(i, str, null, false, packageInfo);
    }

    private synchronized boolean a(int i, String str, String str2, boolean z, PackageInfo packageInfo) {
        if (z) {
            if (this.f.c(i) != 1) {
                return false;
            }
        }
        s sVarA = this.f.a(i);
        if (sVarA == null) {
            this.f.b(i, -1);
            return false;
        }
        if (!dl.a(new File(sVarA.e))) {
            this.f.b(i, -1);
            return false;
        }
        if (packageInfo != null) {
            sVarA.r = packageInfo;
        }
        r rVarA = r.a(StubApp.getOrigApplicationContext(this.e.getApplicationContext()), true);
        if (!rVarA.a(sVarA, false)) {
            this.f.b(i, -1);
            rVarA.a(sVarA.e);
            return false;
        }
        s sVarC = rVarA.c(sVarA.e);
        sVarC.b = 1;
        sVarC.p = 1;
        this.f.a(sVarC);
        return true;
    }

    public void a(String str, String str2) {
        this.f.a(str);
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
    }

    public void a(final String str) {
        try {
            n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.q.1
                @Override // java.lang.Runnable
                public void run() {
                    final r rVarA;
                    try {
                        if (TextUtils.isEmpty(str) || (rVarA = r.a(StubApp.getOrigApplicationContext(q.this.e.getApplicationContext()), true)) == null) {
                            return;
                        }
                        final s sVarD = rVarA.d(str);
                        if (sVarD == null) {
                            s sVarB = q.this.f.b(str);
                            if (sVarB != null) {
                                q.this.a(str, sVarB.e);
                                return;
                            }
                            return;
                        }
                        new Timer().schedule(new TimerTask() { // from class: com.kuaishou.weapon.p0.q.1.1
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                rVarA.b(str);
                                q.this.f.a(str);
                                File file = new File(sVarD.e);
                                if (file.exists()) {
                                    file.delete();
                                }
                            }
                        }, 600000L);
                        rVarA.b(str);
                        q.this.f.a(str);
                        File file = new File(sVarD.e);
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public boolean a(s sVar, String str, String str2) {
        if (sVar == null) {
            return false;
        }
        File file = new File(sVar.e);
        if (!dl.a(file)) {
            return false;
        }
        try {
            if (!this.f.b(sVar.f4726a)) {
                this.f.a(sVar);
            }
            r rVarA = r.a(StubApp.getOrigApplicationContext(this.e.getApplicationContext()), true);
            this.f.a(sVar.f4726a, 1);
            b(sVar.c);
            if (!rVarA.a(sVar, true)) {
                file.delete();
                a(sVar.f4726a, sVar.d, null, true, null);
                this.f.a(sVar.f4726a, 0);
                return false;
            }
            sVar = rVarA.c(sVar.e);
            if (sVar == null) {
                this.f.a(sVar.f4726a, 0);
                return false;
            }
            try {
                s sVarA = this.f.a(sVar.f4726a);
                File file2 = (sVarA == null || sVarA.d.equals(sVar.d)) ? null : new File(sVarA.e);
                sVar.b = 1;
                sVar.p = 1;
                if (this.f.a(sVar) > 0 && file2 != null && file2.exists()) {
                    file2.delete();
                }
                this.f.a(sVar.f4726a, 0);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        } catch (Throwable unused2) {
        }
    }

    public void b(String str) {
        r rVarA;
        try {
            if (TextUtils.isEmpty(str) || (rVarA = r.a()) == null) {
                return;
            }
            rVarA.b(str);
        } catch (Throwable unused) {
        }
    }
}
