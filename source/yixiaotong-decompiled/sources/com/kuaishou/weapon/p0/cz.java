package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class cz {
    private static volatile cz b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4696a;

    private cz(Context context) {
        this.f4696a = context;
    }

    public static cz a(Context context) {
        if (b == null) {
            synchronized (cz.class) {
                if (b == null) {
                    b = new cz(context);
                }
            }
        }
        return b;
    }

    public void a(final int i, final int i2) {
        n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cz.1
            @Override // java.lang.Runnable
            public void run() {
                long j;
                int i3;
                try {
                    h hVarA = h.a(cz.this.f4696a, "re_po_rt");
                    if (hVarA.b(dd.P, 1) == 1) {
                        long jA = dd.a(cz.this.f4696a).a(dd.bj);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        long jB = ((long) hVarA.b(dd.R, 1)) * bg.s;
                        long jB2 = ((long) hVarA.b(dd.S, 5)) * 60000;
                        int iB = hVarA.b(dd.T, 0);
                        if (jA > 0) {
                            j = jA;
                            if (jCurrentTimeMillis - jA < ((long) WeaponHI.ii) * bg.s && WeaponHI.isList != null) {
                                if (WeaponHI.isList.contains(new StringBuilder().append(new Date(jCurrentTimeMillis).getHours()).toString())) {
                                    return;
                                }
                            }
                        } else {
                            j = jA;
                        }
                        long j2 = jCurrentTimeMillis - j;
                        if (j2 >= jB || (((i3 = i) == 100 && iB == 1) || i3 == 106 || (i3 != 100 && i3 > 0 && j2 >= jB2))) {
                            cn.a(cz.this.f4696a, new cj(cz.this.f4696a, i, i2).a(ci.d), ci.d, true, true);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }
}
