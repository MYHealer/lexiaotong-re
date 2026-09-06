package com.opos.mobad.c;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.opos.mobad.r.a.i;
import com.opos.mobad.r.a.j;
import com.opos.mobad.r.a.k;
import com.opos.mobad.r.a.w;
import com.opos.mobad.r.a.x;
import com.opos.mobad.r.a.y;
import com.opos.mobad.r.a.z;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.FutureTask;
import okio.BufferedSource;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InterfaceC0942a f6686a;
    private String b;
    private int c = 0;
    private Map<Integer, Long> d = new ConcurrentHashMap();
    private Map<Integer, FutureTask<Integer>> e = new ConcurrentHashMap();
    private d f;

    /* JADX INFO: renamed from: com.opos.mobad.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0942a {
        void a(int i);
    }

    public a(d dVar) {
        this.f = dVar;
    }

    private static final j a(Context context) {
        i.a aVarG = new i.a().b(com.opos.mobad.service.e.b.n().f()).c(com.opos.cmn.f.c.b()).d(com.opos.mobad.service.d.a.a().g()).e(com.opos.mobad.service.d.a.a().h()).f(com.opos.mobad.service.d.a.a().i()).a(Boolean.valueOf(com.opos.mobad.service.d.a.a().k())).b(Boolean.valueOf(com.opos.mobad.service.d.a.a().e())).g(com.opos.mobad.service.d.a.a().m());
        com.opos.mobad.service.d.a.C0991a c0991aL = com.opos.mobad.service.d.a.a().l();
        if (c0991aL != null) {
            i.a aVarA = aVarG.a(c0991aL.f7355a);
            c0991aL.getClass();
            aVarA.a((Integer) 1);
        } else {
            aVarG.a("");
        }
        i iVarB = aVarG.b();
        return new j.a().a(iVarB).a(new k.a().c(com.opos.cmn.an.c.c.c()).a(com.opos.cmn.an.c.d.b()).b(com.opos.cmn.an.c.d.a()).b()).b(com.opos.cmn.an.c.a.a(context)).a(com.opos.cmn.an.c.c.a()).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    public com.opos.mobad.service.g.b.C0996b<y> b(Context context, String str) {
        z zVar;
        w.a aVarA = new w.a().a(this.b);
        int i = this.c;
        if (i == -1) {
            zVar = z.UNKNOWN_STATUS;
        } else if (i == 0) {
            zVar = z.NORMAL;
        } else if (i != 1) {
            zVar = z.UNKNOWN_STATUS;
        } else {
            zVar = z.VIP;
        }
        aVarA.a(zVar);
        com.opos.mobad.service.g.b.C0996b<y> c0996bA = com.opos.mobad.service.g.b.a(context, "https://uapi.ads.heytapmobi.com/union/instant/vip/right", new x.a().a(aVarA.b()).a(a(context)).a(str).b(context.getPackageName()).b().b(), new com.opos.mobad.service.g.b.a<y>() { // from class: com.opos.mobad.c.a.2
            @Override // com.opos.mobad.service.g.b.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public y b(BufferedSource bufferedSource) throws IOException {
                if (bufferedSource == null) {
                    return null;
                }
                return y.c.a(bufferedSource);
            }
        });
        Object[] objArr = new Object[2];
        objArr[0] = "getVIPResponse result=";
        objArr[1] = c0996bA != null ? c0996bA.c : "null";
        com.opos.cmn.an.f.a.b("AccountManager", objArr);
        return c0996bA;
    }

    private FutureTask<Integer> b(final Context context, final String str, final int i) {
        com.opos.cmn.an.f.a.b("AccountManager", "checkVIPAdInter posId=", str, ", adType=", Integer.valueOf(i));
        if (TextUtils.isEmpty(this.b) || this.c == 0) {
            return null;
        }
        Map<Integer, FutureTask<Integer>> map = this.e;
        if (map != null && map.containsKey(Integer.valueOf(i))) {
            return this.e.get(Integer.valueOf(i));
        }
        FutureTask<Integer> futureTask = new FutureTask<>(new Callable<Integer>() { // from class: com.opos.mobad.c.a.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer call() throws Exception {
                int iA;
                com.opos.mobad.service.g.b.C0996b c0996bB = a.this.b(context, str);
                if (a.this.e != null && a.this.e.containsKey(Integer.valueOf(i))) {
                    a.this.e.remove(Integer.valueOf(i));
                }
                if (c0996bB == null || c0996bB.f7380a != 200 || c0996bB.c == 0) {
                    iA = a.this.a(i);
                } else if (((y) c0996bB.c).i.booleanValue()) {
                    a.this.d.put(Integer.valueOf(i), Long.valueOf(SystemClock.elapsedRealtime()));
                    iA = 0;
                } else {
                    iA = 1;
                }
                return Integer.valueOf(iA);
            }
        });
        com.opos.cmn.an.j.b.c(futureTask);
        this.e.put(Integer.valueOf(i), futureTask);
        return futureTask;
    }

    private boolean b(int i) {
        StringBuilder sb;
        Long l = this.d.get(Integer.valueOf(i));
        if (l == null) {
            sb = new StringBuilder("not available last right:");
        } else {
            if (SystemClock.elapsedRealtime() <= l.longValue() + 60000) {
                return true;
            }
            sb = new StringBuilder("over limit time last right:");
        }
        com.opos.cmn.an.f.a.b("AccountManager", sb.append(i).toString());
        return false;
    }

    public int a(int i) {
        return !b(i) ? 1 : 0;
    }

    public FutureTask<Integer> a(Context context, String str) {
        return b(context, str, 5);
    }

    public FutureTask<Integer> a(Context context, String str, int i) {
        return b(context, str, i);
    }

    public void a() {
        this.b = null;
        this.c = 0;
        this.f6686a = null;
        this.d = new ConcurrentHashMap();
    }

    public void a(String str, int i, String str2, String str3, String str4, String str5, String str6) {
        com.opos.cmn.an.f.a.b("AccountManager", "vipExercise");
        this.f.d().a(str, str2, str3, str4, str5, str6, this.b);
        if (TextUtils.isEmpty(this.b) || this.f6686a == null) {
            return;
        }
        try {
            com.opos.cmn.an.f.a.b("AccountManager", "onVipExercise");
            this.f6686a.a(i);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("AccountManager", "onVipExercise fail", th);
        }
    }

    public String b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return a(5);
    }
}
