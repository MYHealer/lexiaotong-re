package com.opos.mobad.c.a;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.alipay.sdk.widget.j;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.opos.mobad.provider.strategy.PosInfo;
import com.opos.mobad.r.a.aa;
import com.opos.mobad.r.a.g;
import com.opos.mobad.r.a.h;
import com.opos.mobad.r.a.i;
import com.opos.mobad.r.a.k;
import com.opos.mobad.r.a.l;
import com.opos.mobad.r.a.m;
import com.opos.mobad.r.a.n;
import com.opos.mobad.r.a.o;
import com.opos.mobad.r.a.p;
import com.opos.mobad.r.a.q;
import com.opos.mobad.r.a.r;
import com.opos.mobad.r.a.s;
import com.opos.mobad.r.a.t;
import com.opos.mobad.r.a.u;
import com.opos.mobad.r.a.v;
import com.opos.mobad.r.a.w;
import com.opos.mobad.r.a.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f6698a = q.HORIZONTAL.getValue();
    public static final int b = q.VERTICAL.getValue();
    private Context c;
    private int d;
    private String e;
    private String f;
    private int g;
    private com.opos.mobad.c.a.c h;
    private com.opos.cmn.i.a i;
    private InterfaceC0943d m;
    private com.opos.mobad.c.d t;
    private Bundle v;
    private Integer j = null;
    private volatile c k = new c();
    private AtomicReference<Map<String, e>> l = new AtomicReference<>(null);
    private AtomicBoolean n = new AtomicBoolean(false);
    private long o = 0;
    private Map<String, String> p = new ConcurrentHashMap();
    private Map<String, String> q = new ConcurrentHashMap();
    private Map<String, String> r = new ConcurrentHashMap();
    private Map<String, String> s = new ConcurrentHashMap();
    private long u = -1;

    /* JADX INFO: renamed from: com.opos.mobad.c.a.d$5, reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6703a;

        static {
            int[] iArr = new int[l.values().length];
            f6703a = iArr;
            try {
                iArr[l.BIDDING_MODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6703a[l.PERCENTAGE_MODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6703a[l.UNKNOWN_MODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6703a[l.RANKER_MODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f6704a = com.opos.mobad.r.a.e.UNION.getValue();
        public static final int b = com.opos.mobad.r.a.e.TT.getValue();
        public static final int c = com.opos.mobad.r.a.e.BD.getValue();
        public static final int d = com.opos.mobad.r.a.e.GDT.getValue();
        public static final int e = com.opos.mobad.r.a.e.MIX.getValue();
        public static final int f = com.opos.mobad.r.a.e.GG.getValue();
        public static final int g = com.opos.mobad.r.a.e.FB.getValue();
        public static final int h = com.opos.mobad.r.a.e.JD.getValue();
        public static final int i = com.opos.mobad.r.a.e.MTG.getValue();
        public static final int j = com.opos.mobad.r.a.e.PANGLE.getValue();
        public static final int k = com.opos.mobad.r.a.e.KS.getValue();
        public static final int l = com.opos.mobad.r.a.e.TOPON.getValue();
        public final int m;
        public final String n;
        public final long o;
        public final int p;
        public final int q;
        public final int r;
        public final int s;
        public final long t;
        private final float u;

        public a(int i2, String str, int i3, long j2, int i4, int i5) {
            this(i2, str, i3, j2, i4, i5, 0, 1.0f, 0L);
        }

        public a(int i2, String str, int i3, long j2, int i4, int i5, int i6, float f2, long j3) {
            this.m = i2;
            this.n = str;
            this.o = j2;
            this.p = i4;
            this.q = i5;
            this.r = i3;
            this.s = i6;
            this.u = f2;
            this.t = j3;
        }

        public float a() {
            float f2 = this.u;
            if (f2 < 0.0f || f2 > 1.0f) {
                return 0.8f;
            }
            return f2;
        }

        public String toString() {
            return "channel:" + this.m + ",posId:" + this.n + ",percnet:" + this.r + ",timeout:" + this.o + ",factor:" + this.u + ",ecpmFilterThreshold:" + this.t;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<a> f6705a;
        public final a b;
        public final long c;
        public final long d;
        public final int e;

        public b(List<a> list, int i, a aVar, long j, long j2) {
            this.f6705a = list;
            this.b = aVar;
            this.c = j;
            this.d = j2;
            this.e = i;
        }

        public b(List<a> list, a aVar, long j, long j2) {
            this(list, 2, aVar, j, j2);
        }

        public String toString() {
            return "DispatchChannelStrategy{channelList=" + this.f6705a + ", baseChannel=" + this.b + ", unionTimeout=" + this.c + ", strategyVersion=" + this.d + ", dispatch=" + this.e + '}';
        }
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<Integer, g> f6706a;
        private final com.opos.mobad.r.a.c b;
        private final long c;
        private final long d;
        private final long e;
        private final String f;
        private final Map<Integer, String> g;
        private final String h;
        private final String i;
        private final m j;

        public c() {
            this(null, null, Long.MIN_VALUE, Long.MIN_VALUE, 0L, "", null, "", "", null);
        }

        public c(List<g> list, com.opos.mobad.r.a.c cVar, long j, long j2, long j3, String str, List<r> list2, String str2, String str3, m mVar) {
            this.f6706a = new HashMap();
            if (list != null && list.size() > 0) {
                for (g gVar : list) {
                    if (d.b(gVar.e)) {
                        this.f6706a.put(Integer.valueOf(gVar.e.getValue()), gVar);
                    }
                }
            }
            this.b = cVar;
            this.c = j;
            this.d = j2;
            this.e = j3;
            this.f = str;
            this.g = a(list2);
            this.h = str2;
            this.i = str3;
            this.j = mVar;
        }

        private Map<Integer, String> a(List<r> list) {
            HashMap map = new HashMap();
            if (list != null && list.size() > 0) {
                for (r rVar : list) {
                    if (rVar != null && !TextUtils.isEmpty(rVar.f) && rVar.e != null) {
                        map.put(rVar.e, rVar.f);
                    }
                }
            }
            return map;
        }

        public boolean a() {
            com.opos.cmn.an.f.a.b("DispatchController", "current:" + System.currentTimeMillis() + ", exp:" + this.c);
            return System.currentTimeMillis() >= this.c;
        }

        public boolean b() {
            com.opos.cmn.an.f.a.b("DispatchController", "current:" + System.currentTimeMillis() + ", enable:" + this.d);
            return System.currentTimeMillis() >= this.d;
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.c.a.d$d, reason: collision with other inner class name */
    public interface InterfaceC0943d {
        void a(boolean z);
    }

    public d(com.opos.mobad.c.d dVar) {
        this.t = dVar;
    }

    private void F() {
        com.opos.cmn.an.f.a.b("DispatchController", "readStrategyFromLocal");
        this.h.a(new com.opos.mobad.c.a.c.b() { // from class: com.opos.mobad.c.a.d.2
            @Override // com.opos.mobad.c.a.c.b
            public void a() {
                com.opos.cmn.an.f.a.a("DispatchController", "read strategy local fail");
            }

            @Override // com.opos.mobad.c.a.c.b
            public void a(Bundle bundle) {
                d.this.a(bundle);
            }
        });
    }

    private void G() {
        this.i = new com.opos.cmn.i.a(new com.opos.cmn.i.a.b() { // from class: com.opos.mobad.c.a.d.3
            @Override // com.opos.cmn.i.a.b
            public void a(com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
                if (d.this.n.get() || !d.this.n.compareAndSet(false, true)) {
                    d.this.b(interfaceC0895a);
                } else {
                    d.this.a(interfaceC0895a);
                }
            }
        }, KSImageLoader.InnerImageLoadingListener.MAX_DURATION, com.alipay.security.mobile.module.http.constant.a.f1701a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String H() {
        return "https://uapi.ads.heytapmobi.com/union/strategy/v3/select";
    }

    private void I() {
        if (this.c == null || !this.k.a() || this.i == null) {
            return;
        }
        com.opos.cmn.an.f.a.b("DispatchController", j.l);
        this.i.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Bundle bundle) {
        com.opos.cmn.an.f.a.a("DispatchController", "read local strategy size:" + bundle.size());
        this.v = bundle;
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            PosInfo posInfo = (PosInfo) bundle.getParcelable(str);
            try {
                map.put(str, new e(posInfo.b, v.c.a(posInfo.f7278a)));
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("DispatchController", "decode local fail", e);
            }
        }
        com.opos.cmn.an.f.a.b("DispatchController", "decode local strategy size:" + map.size());
        if (LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.l, null, map)) {
            com.opos.cmn.an.f.a.b("DispatchController", "local strategy size:" + map.size());
            InterfaceC0943d interfaceC0943d = this.m;
            if (interfaceC0943d != null) {
                interfaceC0943d.a(true);
            }
        }
        this.v = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
        com.opos.cmn.an.f.a.a("DispatchController", "init from local");
        this.h.a(new com.opos.mobad.c.a.c.a() { // from class: com.opos.mobad.c.a.d.1
            @Override // com.opos.mobad.c.a.c.a
            public void a() {
                com.opos.cmn.an.f.a.a("DispatchController", "read app info local fail");
                interfaceC0895a.b();
                d.this.a();
            }

            @Override // com.opos.mobad.c.a.c.a
            public void a(u uVar, long j) {
                com.opos.cmn.an.f.a.a("DispatchController", "read app info local succ:", uVar);
                d.this.a(uVar.f, uVar.i, j, uVar.h.longValue(), uVar.j != null ? uVar.j.longValue() : 0L, uVar.k, uVar.l, uVar.m, uVar.n, uVar.o);
                com.opos.mobad.service.b.b.a().a(d.this.x(), true);
                com.opos.mobad.service.e.a(d.this.C());
                if (d.this.k != null && d.this.k.a()) {
                    d.this.b(interfaceC0895a);
                } else {
                    com.opos.cmn.an.f.a.a("DispatchController", "do not need to refresh");
                    interfaceC0895a.b();
                }
            }
        });
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar) throws JSONException {
        if (tVar.f.intValue() != 0) {
            com.opos.cmn.an.f.a.b("DispatchController", "response fail ret:" + tVar.f + ",msg:" + tVar.g);
            return;
        }
        u uVar = tVar.h;
        if (uVar == null) {
            com.opos.cmn.an.f.a.b("DispatchController", "response data null");
            return;
        }
        long jLongValue = uVar.j != null ? uVar.j.longValue() : 0L;
        HashMap map = new HashMap();
        for (v vVar : uVar.g) {
            map.put(vVar.q, new e(jLongValue, vVar));
        }
        this.h.a(uVar, tVar.i.longValue());
        this.k = new c(uVar.f, uVar.i, tVar.i.longValue(), uVar.h.longValue(), jLongValue, uVar.k, uVar.l, uVar.m, uVar.n, uVar.o);
        a(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<g> list, com.opos.mobad.r.a.c cVar, long j, long j2, long j3, String str, List<r> list2, String str2, String str3, m mVar) {
        this.k = new c(list, cVar, j, j2, j3, str, list2, str2, str3, mVar);
        InterfaceC0943d interfaceC0943d = this.m;
        if (interfaceC0943d != null) {
            interfaceC0943d.a(true);
        }
    }

    private void a(Map<String, e> map) {
        com.opos.cmn.an.f.a.b("DispatchController", "refresh strategy size:" + map.size());
        this.l.set(map);
        InterfaceC0943d interfaceC0943d = this.m;
        if (interfaceC0943d != null) {
            interfaceC0943d.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.mobad.c.a.d.4
            @Override // java.lang.Runnable
            public void run() throws IOException {
                w wVarB;
                z zVar;
                s.a aVarC = new s.a().a(d.this.e).b(d.this.f).a(Integer.valueOf(d.this.d)).b(Integer.valueOf(d.this.g)).a(Long.valueOf(d.this.o)).c(d.this.c.getPackageName());
                try {
                    i.a aVarG = new i.a().b(com.opos.mobad.service.e.b.n().f()).c(com.opos.cmn.f.c.b()).d(com.opos.mobad.service.d.a.a().g()).e(com.opos.mobad.service.d.a.a().h()).f(com.opos.mobad.service.d.a.a().i()).a(Boolean.valueOf(com.opos.mobad.service.d.a.a().k())).b(Boolean.valueOf(com.opos.mobad.service.d.a.a().e())).g(com.opos.mobad.service.d.a.a().m());
                    com.opos.mobad.service.d.a.C0991a c0991aL = com.opos.mobad.service.d.a.a().l();
                    if (c0991aL != null) {
                        i.a aVarA = aVarG.a(c0991aL.f7355a);
                        c0991aL.getClass();
                        aVarA.a((Integer) 1);
                    } else {
                        aVarG.a("");
                    }
                    com.opos.mobad.r.a.j jVarB = new com.opos.mobad.r.a.j.a().a(aVarG.b()).a(new k.a().c(com.opos.cmn.an.c.c.c()).a(com.opos.cmn.an.c.d.b()).b(com.opos.cmn.an.c.d.a()).b()).b(com.opos.cmn.an.c.a.a(d.this.c)).a(com.opos.cmn.an.c.c.a()).b();
                    n nVarB = new n.a().a(Boolean.valueOf(com.opos.mobad.service.e.d.a().c())).b(com.opos.mobad.service.e.d.a().b()).a(com.opos.mobad.service.e.d.a().d()).b();
                    aa aaVarB = new aa.a().a(Boolean.valueOf(com.opos.mobad.service.e.d.a().e())).b(com.opos.mobad.service.e.d.a().g()).a(com.opos.mobad.service.e.d.a().f()).b();
                    p pVarB = new p.a().a(Integer.valueOf(com.opos.cmn.i.i.a(d.this.c))).a(com.opos.cmn.i.i.b(d.this.c)).b();
                    String strB = d.this.t.b().b();
                    int i = -1;
                    t tVarA = null;
                    if (TextUtils.isEmpty(strB)) {
                        wVarB = null;
                    } else {
                        w.a aVarA2 = new w.a().a(strB);
                        int iC = d.this.t.b().c();
                        if (iC == -1) {
                            zVar = z.UNKNOWN_STATUS;
                        } else if (iC != 0) {
                            zVar = iC != 1 ? z.UNKNOWN_STATUS : z.VIP;
                        } else {
                            zVar = z.NORMAL;
                        }
                        aVarA2.a(zVar);
                        wVarB = aVarA2.b();
                        i = iC;
                    }
                    o.a aVarA3 = new o.a().a(com.opos.cmn.a.a.b());
                    com.opos.mobad.service.e.d.b bVarL = com.opos.mobad.service.e.d.a().l();
                    if (bVarL != null) {
                        aVarC.a(new com.opos.mobad.r.a.b.a().a(bVarL.b).a(Integer.valueOf(bVarL.f7370a)).b());
                    }
                    try {
                        aVarA3.b(com.opos.cmn.an.c.b.a());
                        aVarA3.c(com.opos.cmn.an.c.b.b());
                    } catch (Exception unused) {
                        com.opos.cmn.an.f.a.b("DispatchController", "local fail");
                    }
                    s sVarB = aVarC.a(jVarB).a(nVarB).a(aaVarB).a(pVarB).a(aVarA3.b()).b(Long.valueOf(d.this.g())).a(wVarB).c(Long.valueOf(com.opos.mobad.s.c.a(d.this.c, "adCacheTime", 0L))).b();
                    com.opos.cmn.an.f.a.a("DispatchController", "refresh request", sVarB);
                    HashMap map = new HashMap();
                    map.put("Content-Type", "application/x-protobuf");
                    map.put("Route-Data", com.opos.cmn.biz.a.e.a(d.this.c));
                    com.opos.cmn.func.a.a.d.a aVarB = new com.opos.cmn.func.a.a.d.a().a(s.c.b(sVarB)).a(map).b(d.this.H());
                    aVarB.a("POST");
                    com.opos.cmn.func.a.a.e eVarA = com.opos.cmn.func.a.a.b.a().a(d.this.c, aVarB.a());
                    if (eVarA != null) {
                        try {
                            if (200 == eVarA.f6077a) {
                                try {
                                    tVarA = t.c.a(eVarA.c);
                                } catch (Throwable th) {
                                    com.opos.cmn.an.f.a.a("DispatchController", "decode fail", th);
                                    d.this.t.e().b(th);
                                }
                                if (tVarA == null) {
                                    com.opos.cmn.an.f.a.a("DispatchController", "get dispatch parse fail");
                                    interfaceC0895a.b();
                                    if (eVarA != null) {
                                        eVarA.a();
                                        return;
                                    }
                                    return;
                                }
                                com.opos.cmn.an.f.a.a("DispatchController", "response dispatch strategy:", tVarA);
                                d.this.a(tVarA);
                                d.this.j = Integer.valueOf(i);
                                com.opos.mobad.service.b.b.a().a(d.this.x(), false);
                                com.opos.mobad.service.e.a(d.this.C());
                                interfaceC0895a.a();
                                if (eVarA != null) {
                                    eVarA.a();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th2) {
                            if (eVarA != null) {
                                eVarA.a();
                            }
                            throw th2;
                        }
                    }
                    com.opos.cmn.an.f.a.a("DispatchController", "get dispatch fail code:", eVarA);
                    if (eVarA != null) {
                        eVarA.a();
                    }
                } catch (Throwable th3) {
                    com.opos.cmn.an.f.a.a("", "", th3);
                }
                interfaceC0895a.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(com.opos.mobad.r.a.e eVar) {
        return eVar == com.opos.mobad.r.a.e.TT || eVar == com.opos.mobad.r.a.e.GDT || eVar == com.opos.mobad.r.a.e.UNION || eVar == com.opos.mobad.r.a.e.MIX || eVar == com.opos.mobad.r.a.e.FB || eVar == com.opos.mobad.r.a.e.GG || eVar == com.opos.mobad.r.a.e.JD || eVar == com.opos.mobad.r.a.e.MTG || eVar == com.opos.mobad.r.a.e.PANGLE || eVar == com.opos.mobad.r.a.e.KS || eVar == com.opos.mobad.r.a.e.TOPON;
    }

    private e g(String str) {
        Bundle bundle = this.v;
        if (bundle != null) {
            com.opos.cmn.an.f.a.b("DispatchController", "getCacheStrategy");
            PosInfo posInfo = (PosInfo) bundle.getParcelable(str);
            if (!TextUtils.isEmpty(str) && posInfo != null) {
                try {
                    return new e(posInfo.b, v.c.a(posInfo.f7278a));
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("DispatchController", "decode pos fail" + str, e);
                }
            }
        }
        return null;
    }

    public boolean A() {
        return (z() & 1) == 1;
    }

    public boolean B() {
        return (z() & 2) == 2;
    }

    public boolean C() {
        return (z() & 64) == 64;
    }

    public boolean D() {
        return (z() & 128) == 128;
    }

    public String E() {
        return this.k == null ? "" : this.k.i;
    }

    public int a(String str) {
        e eVarG;
        Map<String, e> map = this.l.get();
        return ((map != null ? (eVarG = map.get(str)) == null || eVarG.f6707a.t == null : (eVarG = g(str)) == null || eVarG.f6707a.t == null) ? q.HORIZONTAL : eVarG.f6707a.t).getValue();
    }

    /* JADX WARN: Code duplicated, block: B:83:0x015d  */
    /* JADX WARN: Code duplicated, block: B:84:0x015f  */
    public b a(String str, boolean z) {
        e eVarG;
        int i;
        I();
        ArrayList arrayList = new ArrayList();
        Map<String, e> map = this.l.get();
        a aVar = null;
        if (map == null) {
            com.opos.cmn.an.f.a.b("DispatchController", "strategyInfo map null");
            eVarG = z ? g(str) : null;
        } else {
            eVarG = map.get(str);
        }
        if (eVarG == null) {
            return null;
        }
        if (eVarG.b != g()) {
            com.opos.cmn.an.f.a.b("DispatchController", "stg ver fail");
            return null;
        }
        v vVar = eVarG.f6707a;
        List<h> list = vVar != null ? vVar.r : null;
        long jLongValue = (vVar.v != null ? vVar.v : v.g).longValue();
        if (list == null || list.size() <= 0) {
            return new b(null, null, jLongValue, g());
        }
        for (h hVar : list) {
            if (b(hVar.o)) {
                a aVar2 = new a(hVar.o.getValue(), hVar.l, hVar.m.intValue(), hVar.n.longValue(), hVar.p != null ? hVar.p.intValue() : 0, hVar.q != null ? hVar.q.intValue() : 0, hVar.r != null ? hVar.r.intValue() : 0, hVar.s != null ? hVar.s.floatValue() : 0.8f, hVar.t != null ? hVar.t.longValue() : -1L);
                this.u = hVar.t != null ? hVar.t.longValue() : -1L;
                if (aVar2.m == a.d) {
                    this.q.put(aVar2.n, aVar2.n);
                }
                if (aVar2.m == a.b) {
                    this.p.put(aVar2.n, aVar2.n);
                }
                if (aVar2.m == a.h) {
                    this.r.put(aVar2.n, aVar2.n);
                }
                if (aVar2.m == a.k) {
                    this.s.put(aVar2.n, aVar2.n);
                }
                arrayList.add(aVar2);
                if (vVar.u != null && vVar.u == hVar.o) {
                    aVar = aVar2;
                }
            }
        }
        if (vVar.y != null) {
            int i2 = AnonymousClass5.f6703a[vVar.y.ordinal()];
            if (i2 == 1) {
                i = 3;
            } else if (i2 != 2) {
                i = 2;
            } else {
                i = 1;
            }
        } else if (vVar.s.booleanValue()) {
            i = 2;
        } else {
            i = 1;
        }
        com.opos.cmn.an.f.a.b("DispatchController", "getChannelStrategy(), dispatch=", Integer.valueOf(i), ", posId=", str, ", sync=", Boolean.valueOf(z));
        return new b(arrayList, i, aVar, jLongValue, eVarG.b);
    }

    public void a() {
        com.opos.cmn.i.a aVar;
        if (this.c == null || (aVar = this.i) == null) {
            return;
        }
        aVar.a();
    }

    public void a(Context context, String str, String str2, int i, int i2, long j) {
        this.c = context;
        this.e = str;
        this.f = str2;
        this.d = i;
        this.g = i2;
        this.o = j;
        this.h = new com.opos.mobad.c.a.c(context, str, str2);
        G();
        this.i.a();
    }

    public void a(InterfaceC0943d interfaceC0943d) {
        this.m = interfaceC0943d;
    }

    public boolean a(int i) {
        boolean zK;
        if (i == a.b) {
            zK = this.t.c().a();
        } else if (i == a.d) {
            zK = this.t.c().b();
        } else if (i == a.f) {
            zK = this.t.c().d();
        } else if (i == a.g) {
            zK = this.t.c().e();
        } else if (i == a.i) {
            zK = this.t.c().f();
        } else if (i == a.h) {
            zK = this.t.c().g();
        } else if (i == a.j) {
            zK = this.t.c().h();
        } else if (i == 1001) {
            zK = this.t.c().i();
        } else if (i == a.k) {
            zK = this.t.c().j();
        } else {
            zK = i == a.l ? this.t.c().k() : true;
        }
        com.opos.cmn.an.f.a.b("DispatchController", "check enable:" + i + "," + zK);
        return zK;
    }

    public String b(int i) {
        if (a.f6704a == i) {
            return this.e;
        }
        g gVar = (g) this.k.f6706a.get(Integer.valueOf(i));
        if (gVar == null) {
            return null;
        }
        return gVar.f;
    }

    public boolean b() {
        return this.k.b();
    }

    public boolean b(String str) {
        Map<String, e> map = this.l.get();
        e eVarG = map == null ? g(str) : map.get(str);
        return ((eVarG == null || eVarG.f6707a.z == null) ? v.k : eVarG.f6707a.z).booleanValue();
    }

    public String c(int i) {
        g gVar = (g) this.k.f6706a.get(Integer.valueOf(i));
        if (gVar == null) {
            return null;
        }
        return gVar.g;
    }

    public boolean c() {
        if (this.k.b == null || this.k.b.p == null) {
            return false;
        }
        return this.k.b.p.booleanValue();
    }

    public boolean c(String str) {
        Map<String, e> map = this.l.get();
        e eVarG = map == null ? g(str) : map.get(str);
        return ((eVarG == null || eVarG.f6707a.A == null) ? v.l : eVarG.f6707a.A).booleanValue();
    }

    public int d() {
        return ((this.k.b == null || this.k.b.q == null) ? com.opos.mobad.r.a.c.e : this.k.b.q).intValue();
    }

    public Point d(String str) {
        Map<String, e> map = this.l.get();
        e eVarG = map == null ? g(str) : map.get(str);
        if (eVarG == null || eVarG.f6707a == null || eVarG.f6707a.C == null || eVarG.f6707a.B == null) {
            return null;
        }
        return new Point(eVarG.f6707a.C.intValue(), eVarG.f6707a.B.intValue());
    }

    public String d(int i) {
        if (a.i != i && a.l != i) {
            return "";
        }
        g gVar = (g) this.k.f6706a.get(Integer.valueOf(i));
        if (gVar == null) {
            return null;
        }
        return gVar.o;
    }

    public boolean e() {
        if (this.k.b == null || this.k.b.r == null) {
            return true;
        }
        return this.k.b.r.booleanValue();
    }

    public boolean e(String str) {
        Map<String, e> map = this.l.get();
        e eVarG = map == null ? g(str) : map.get(str);
        if (eVarG == null || eVarG.f6707a == null || eVarG.f6707a.D == null) {
            return false;
        }
        return eVarG.f6707a.D.booleanValue();
    }

    public boolean f() {
        if (this.k.b == null || this.k.b.s == null) {
            return true;
        }
        return this.k.b.s.booleanValue();
    }

    public boolean f(String str) {
        Map<String, e> map = this.l.get();
        e eVarG = map == null ? g(str) : map.get(str);
        boolean zBooleanValue = v.p.booleanValue();
        return (eVarG == null || eVarG.f6707a == null || eVarG.f6707a.E == null) ? zBooleanValue : eVarG.f6707a.E.booleanValue();
    }

    public long g() {
        if (this.k != null) {
            return this.k.e;
        }
        return 0L;
    }

    public String h() {
        return this.k != null ? this.k.f : "";
    }

    public int i() {
        return (this.k.b == null || this.k.b.n == null) ? KSImageLoader.InnerImageLoadingListener.MAX_DURATION : this.k.b.n.h.intValue();
    }

    public int j() {
        return ((this.k.b == null || this.k.b.n == null || this.k.b.n.i == null) ? com.opos.mobad.r.a.a.e : this.k.b.n.i).intValue();
    }

    public int k() {
        return (this.k.b == null || this.k.b.o == null) ? KSImageLoader.InnerImageLoadingListener.MAX_DURATION : this.k.b.o.h.intValue();
    }

    public int l() {
        return ((this.k.b == null || this.k.b.o == null || this.k.b.o.i == null) ? com.opos.mobad.r.a.a.e : this.k.b.o.i).intValue();
    }

    public com.opos.mobad.c.a.a m() {
        return (this.k.b == null || this.k.b.u == null) ? new com.opos.mobad.c.a.a() : new com.opos.mobad.c.a.a(this.k.b.u);
    }

    public int n() {
        return (this.k.b == null || this.k.b.i == null) ? KSImageLoader.InnerImageLoadingListener.MAX_DURATION : this.k.b.i.h.intValue();
    }

    public int o() {
        return ((this.k.b == null || this.k.b.i == null || this.k.b.i.i == null) ? com.opos.mobad.r.a.a.e : this.k.b.i.i).intValue();
    }

    public int p() {
        return (this.k.b == null || this.k.b.j == null) ? KSImageLoader.InnerImageLoadingListener.MAX_DURATION : this.k.b.j.h.intValue();
    }

    public int q() {
        return (this.k.b == null || this.k.b.k == null) ? KSImageLoader.InnerImageLoadingListener.MAX_DURATION : this.k.b.k.h.intValue();
    }

    public int r() {
        return ((this.k.b == null || this.k.b.k == null || this.k.b.k.i == null) ? com.opos.mobad.r.a.a.e : this.k.b.k.i).intValue();
    }

    public int s() {
        return (this.k.b == null || this.k.b.l == null) ? KSImageLoader.InnerImageLoadingListener.MAX_DURATION : this.k.b.l.h.intValue();
    }

    public int t() {
        return ((this.k.b == null || this.k.b.l == null || this.k.b.l.i == null) ? com.opos.mobad.r.a.a.e : this.k.b.l.i).intValue();
    }

    public int u() {
        return (this.k.b == null || this.k.b.m == null) ? KSImageLoader.InnerImageLoadingListener.MAX_DURATION : this.k.b.m.h.intValue();
    }

    public int v() {
        if (this.k.j != null) {
            return this.k.j.g.intValue();
        }
        return 0;
    }

    public int w() {
        if (this.k.j != null) {
            return this.k.j.f.intValue();
        }
        return 0;
    }

    public Map<Integer, String> x() {
        if (this.k == null) {
            return null;
        }
        return this.k.g;
    }

    public String y() {
        return this.k == null ? "" : this.k.h;
    }

    public int z() {
        if (this.k == null || this.k.b == null || this.k.b.t == null) {
            return 1;
        }
        return this.k.b.t.intValue();
    }
}
