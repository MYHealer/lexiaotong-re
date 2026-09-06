package com.byazt.hm;

import android.content.Context;
import android.os.Bundle;
import com.byazt.gqp.i;
import com.byazt.gqp.t;
import com.byazt.hw.a;
import com.byazt.hw.sp;
import com.byazt.lf.ve;
import com.byazt.nr.gt;
import com.byazt.va.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 679, 20})
public class c {
    public t c;
    public a tt;
    public int ve;

    /* JADX INFO: renamed from: com.byazt.hm.c$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 679, 26})
    static /* synthetic */ class AnonymousClass1 {
    }

    public t a() {
        return this.c;
    }

    public /* synthetic */ c(C0169c c0169c, AnonymousClass1 anonymousClass1) {
        this(c0169c);
    }

    private c(C0169c c0169c) {
        t.c cVarTt = new t.c().c(c0169c.c, TimeUnit.MILLISECONDS).ve(c0169c.ve, TimeUnit.MILLISECONDS).tt(c0169c.tt, TimeUnit.MILLISECONDS);
        if (c0169c.uj) {
            a aVar = new a();
            this.tt = aVar;
            cVarTt.c(aVar);
        }
        if (c0169c.n != null && c0169c.n.size() > 0) {
            Iterator<i> it = c0169c.n.iterator();
            while (it.hasNext()) {
                cVarTt.c(it.next());
            }
        }
        if (c0169c.sp != null) {
            cVarTt.c(c0169c.sp);
        }
        cVarTt.c(c0169c.f2295a);
        if (c0169c.x == null) {
            cVarTt.c(new com.byazt.gu.tt());
        } else {
            cVarTt.c(c0169c.x);
        }
        this.c = cVarTt.c();
    }

    public void c(Context context, boolean z, com.byazt.hw.tt ttVar) {
        if (context == null) {
            throw new IllegalArgumentException("tryInitAdTTNet context is null");
        }
        if (ttVar == null) {
            throw new IllegalArgumentException("tryInitAdTTNet ITTAdNetDepend is null");
        }
        int iC = ttVar.c();
        this.ve = iC;
        a aVar = this.tt;
        if (aVar != null) {
            aVar.c(iC);
        }
        sp.c().c(this.ve).c(z);
        sp.c().c(this.ve).c(ttVar);
        sp.c().c(this.ve).c(context, gt.c(context));
    }

    public void c(Context context, boolean z) {
        com.byazt.hw.c.tt(true);
        if (c(context) || (!gt.c(context) && z)) {
            sp.c().c(this.ve, context).uj();
            sp.c().c(this.ve, context).c();
        }
        if (gt.c(context)) {
            sp.c().c(this.ve, context).uj();
            sp.c().c(this.ve, context).c();
        }
    }

    public static void c() {
        ve.c(ve.c.DEBUG);
    }

    public n tt() {
        return new n(this.c);
    }

    public com.byazt.va.ve ve() {
        return new com.byazt.va.ve(this.c);
    }

    public com.byazt.va.tt uj() {
        return new com.byazt.va.tt(this.c);
    }

    public com.byazt.va.tt c(String str, String str2, String str3) {
        return new com.byazt.va.tt(this.c, str, str2, str3);
    }

    private static boolean c(Context context) {
        String strTt = gt.tt(context);
        if (strTt != null) {
            return strTt.endsWith(":push") || strTt.endsWith(":pushservice");
        }
        return false;
    }

    public com.byazt.va.c n() {
        return new com.byazt.va.c(this.c);
    }

    /* JADX INFO: renamed from: com.byazt.hm.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 679, 44})
    public static final class C0169c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Set<String> f2295a;
        public Bundle sp;
        public com.byazt.gu.c x;
        public boolean uj = true;
        public final List<i> n = new ArrayList();
        public int c = 10000;
        public int tt = 10000;
        public int ve = 10000;

        public C0169c c(Set<String> set) {
            this.f2295a = set;
            return this;
        }

        public C0169c c(boolean z) {
            this.uj = z;
            return this;
        }

        public C0169c c(long j, TimeUnit timeUnit) {
            this.c = c("timeout", j, timeUnit);
            return this;
        }

        public C0169c tt(long j, TimeUnit timeUnit) {
            this.tt = c("timeout", j, timeUnit);
            return this;
        }

        public C0169c ve(long j, TimeUnit timeUnit) {
            this.ve = c("timeout", j, timeUnit);
            return this;
        }

        public C0169c c(i iVar) {
            this.n.add(iVar);
            return this;
        }

        private static int c(String str, long j, TimeUnit timeUnit) {
            if (j < 0) {
                throw new IllegalArgumentException(str + " < 0");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(str + " too large.");
            }
            if (millis != 0 || j <= 0) {
                return (int) millis;
            }
            throw new IllegalArgumentException(str + " too small.");
        }

        public c c() {
            return new c(this, null);
        }
    }
}
