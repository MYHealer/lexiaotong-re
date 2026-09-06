package com.kuaishou.weapon.p0;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class da {
    private static volatile da b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4699a;

    private da(Context context) {
        this.f4699a = context;
    }

    public static da a(Context context) {
        if (b == null) {
            synchronized (da.class) {
                if (b == null) {
                    b = new da(context);
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.da.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    h hVarA = h.a(da.this.f4699a, "re_po_rt");
                    if (hVarA.b(dd.ap, 1) == 1) {
                        long jA = dd.a(da.this.f4699a).a(dd.bl);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        int iB = hVarA.b(dd.as, 0);
                        long j = jCurrentTimeMillis - jA;
                        if (j >= ((long) hVarA.b(dd.ar, 6)) * bg.s || (i == 100 && iB == 1 && j >= 14400000)) {
                            ce.a(da.this.f4699a, new bu(da.this.f4699a, i, false).a(ci.f), ci.f, true);
                            dd.a(da.this.f4699a).a(dd.bl, jCurrentTimeMillis);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
