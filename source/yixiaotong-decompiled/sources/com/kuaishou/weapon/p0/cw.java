package com.kuaishou.weapon.p0;

import android.content.Context;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class cw {
    private static volatile cw b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4688a;

    private cw(Context context) {
        this.f4688a = context;
    }

    public static cw a(Context context) {
        if (b == null) {
            synchronized (cw.class) {
                if (b == null) {
                    b = new cw(context);
                }
            }
        }
        return b;
    }

    public void a(final int i) {
        try {
            h hVarA = h.a(this.f4688a, "re_po_rt");
            final boolean zE = hVarA.e("a1_p_s_p_s");
            final boolean zE2 = hVarA.e("a1_p_s_p_s_c_b");
            if ((zE || zE2) && WeaponHI.as) {
                n.a().a(new Runnable() { // from class: com.kuaishou.weapon.p0.cw.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i2;
                        try {
                            h hVarA2 = h.a(cw.this.f4688a, "re_po_rt");
                            if (hVarA2.b(dd.o, 0) == 1) {
                                if (zE || zE2) {
                                    long jA = dd.a(cw.this.f4688a).a(dd.bi);
                                    long jCurrentTimeMillis = System.currentTimeMillis();
                                    long jB = ((long) hVarA2.b(dd.p, 8)) * bg.s;
                                    int iB = hVarA2.b(dd.q, 0);
                                    if (jA > 0 && jCurrentTimeMillis - jA < ((long) WeaponHI.ii) * bg.s && WeaponHI.isList != null) {
                                        if (WeaponHI.isList.contains(new StringBuilder().append(new Date(jCurrentTimeMillis).getHours()).toString())) {
                                            return;
                                        }
                                    }
                                    if (jCurrentTimeMillis - jA >= jB || (((i2 = i) == 100 && iB == 1) || i2 == 106)) {
                                        cn.a(cw.this.f4688a, new cg(cw.this.f4688a, i).a(ci.e), ci.e, true, true);
                                    }
                                }
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }
}
