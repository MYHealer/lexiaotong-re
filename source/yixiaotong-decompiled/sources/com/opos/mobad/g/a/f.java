package com.opos.mobad.g.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.heytap.msp.mobad.api.ad.IBidding;
import com.opos.mobad.ad.d.t;
import com.opos.mobad.g.a.a.q;
import com.opos.mobad.g.a.a.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f extends com.opos.mobad.q.e {
    private q<com.opos.mobad.ad.d.g, com.opos.mobad.ad.d.h> b;
    private String c;
    private String d;
    private List<String> e;

    public class a extends r<com.opos.mobad.ad.d.h> implements com.opos.mobad.ad.d.j, com.opos.mobad.ad.f {
        private final com.opos.mobad.ad.d.j b;

        public a(int i, com.opos.mobad.g.a.a.p pVar, com.opos.mobad.ad.d.j jVar) {
            super(i, pVar);
            this.b = jVar;
        }

        @Override // com.opos.mobad.ad.f
        public void a(Map<String, String> map) {
            com.opos.mobad.ad.d.j jVar = this.b;
            if (jVar instanceof com.opos.mobad.ad.f) {
                ((com.opos.mobad.ad.f) jVar).a(map);
            }
        }
    }

    private static class b implements com.opos.mobad.ad.d.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.opos.mobad.ad.d.h f6985a;
        private String b;
        private String c;
        private boolean d = false;
        private int e;
        private int f;
        private List<String> g;

        public b(com.opos.mobad.ad.d.h hVar, String str, String str2, int i, int i2, List<String> list) {
            this.f6985a = hVar;
            this.b = str;
            this.c = str2;
            this.e = i;
            this.f = i2;
            this.g = list;
        }

        @Override // com.opos.mobad.ad.d.h
        public String a() {
            return this.f6985a.a();
        }

        @Override // com.opos.mobad.ad.i
        public void a(int i, String str, int i2) {
            if (!com.opos.mobad.c.b.a().b(this.b) || this.d) {
                return;
            }
            this.d = true;
            com.opos.mobad.c.b.f().a(this.b, this.c, i, str, this.e, this.f, i2);
        }

        @Override // com.opos.mobad.ad.d.h
        public void a(Context context, FrameLayout frameLayout, com.opos.mobad.ad.d.k kVar) {
            this.f6985a.a(context, frameLayout, kVar);
        }

        @Override // com.opos.mobad.ad.d.h
        public void a(Context context, FrameLayout frameLayout, t tVar, List<View> list, List<View> list2) {
            this.f6985a.a(context, frameLayout, tVar, list, list2);
        }

        @Override // com.opos.mobad.ad.d.h
        public void a(Context context, List<View> list, com.opos.mobad.ad.d.h.a aVar, List<View> list2, com.opos.mobad.ad.d.h.a aVar2) {
            this.f6985a.a(context, list, aVar, list2, aVar2);
        }

        @Override // com.opos.mobad.ad.d.h
        public void a(Context context, List<View> list, com.opos.mobad.ad.d.h.a aVar, List<View> list2, com.opos.mobad.ad.d.h.a aVar2, List<View> list3, com.opos.mobad.ad.d.h.a aVar3) {
            this.f6985a.a(context, list, aVar, list2, aVar2, list3, aVar3);
        }

        @Override // com.opos.mobad.ad.d.h
        public void a(com.opos.mobad.ad.d.i iVar) {
            this.f6985a.a(iVar);
        }

        @Override // com.opos.mobad.ad.d.h
        public boolean a(String str) {
            return this.f6985a.a(str);
        }

        @Override // com.opos.mobad.ad.d.h
        public String b() {
            return this.f6985a.b();
        }

        @Override // com.opos.mobad.ad.i
        public void b(int i) {
            if (!com.opos.mobad.c.b.a().b(this.b) || this.d) {
                return;
            }
            this.d = true;
            com.opos.mobad.c.b.f().a(this.b, this.c, this.e, this.f, i);
        }

        @Override // com.opos.mobad.ad.d.h
        public List<com.opos.mobad.ad.d.e> c() {
            return this.f6985a.c();
        }

        @Override // com.opos.mobad.ad.i
        public void c(int i) {
            if ((com.opos.mobad.c.b.a().b(this.b) || this.g != null) && !this.d) {
                this.f6985a.c(i);
            }
        }

        @Override // com.opos.mobad.ad.d.h
        public List<com.opos.mobad.ad.d.e> d() {
            return this.f6985a.d();
        }

        @Override // com.opos.mobad.ad.i
        public int e() {
            return 0;
        }

        @Override // com.opos.mobad.ad.i
        public int f() {
            int i;
            if (com.opos.mobad.c.b.a().b(this.b)) {
                i = this.f;
            } else {
                com.opos.cmn.an.f.a.b("NativeAdvanceAdDelegator", "isBiddingOutEnable: false");
                i = IBidding.ECPM_PRICE_STATUS_BIDDING_OUT_DISABLE;
            }
            com.opos.mobad.c.b.f().a(this.b, this.c, i, this.e);
            return i;
        }

        @Override // com.opos.mobad.ad.d.h
        public int g() {
            return this.f6985a.g();
        }

        @Override // com.opos.mobad.ad.d.h
        public int h() {
            return this.f6985a.h();
        }

        @Override // com.opos.mobad.ad.d.h
        public com.opos.mobad.ad.d.e i() {
            return this.f6985a.i();
        }

        @Override // com.opos.mobad.ad.d.h
        public boolean j() {
            return this.f6985a.j();
        }

        @Override // com.opos.mobad.ad.d.h
        public String k() {
            return this.f6985a.k();
        }

        @Override // com.opos.mobad.ad.d.h
        public String l() {
            return this.f6985a.l();
        }

        @Override // com.opos.mobad.ad.d.h
        public void m() {
            this.f6985a.m();
        }

        @Override // com.opos.mobad.ad.d.h
        public com.opos.mobad.ad.d.b n() {
            return this.f6985a.n();
        }

        @Override // com.opos.mobad.ad.d.h
        public String o() {
            return this.f6985a.o();
        }

        @Override // com.opos.mobad.ad.d.h
        public int p() {
            return this.f6985a.p();
        }
    }

    public f(final Context context, final String str, com.opos.mobad.g.a.e.a aVar, final com.opos.mobad.ad.d.j jVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, final com.opos.mobad.g.b bVar, final com.opos.mobad.ad.privacy.a aVar3) {
        super(jVar);
        this.d = str;
        this.b = a(str, aVar, list, aVar2, j, new com.opos.mobad.g.a.b.c<com.opos.mobad.ad.d.g>() { // from class: com.opos.mobad.g.a.f.1
            @Override // com.opos.mobad.g.a.b.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.opos.mobad.ad.d.g b(com.opos.mobad.c.a.d.a aVar4, com.opos.mobad.g.a.a.p pVar) {
                com.opos.mobad.ad.c cVarB = bVar.b(aVar4.m);
                if (cVarB == null) {
                    return null;
                }
                return cVarB.a(context, str, aVar4.n, aVar4.q, aVar4.p, f.this.new a(aVar4.m, pVar, jVar), aVar3);
            }
        }, new com.opos.mobad.g.a.c.a(context));
    }

    private q<com.opos.mobad.ad.d.g, com.opos.mobad.ad.d.h> a(String str, com.opos.mobad.g.a.e.a aVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, com.opos.mobad.g.a.b.c<com.opos.mobad.ad.d.g> cVar, com.opos.mobad.g.a.c.a aVar3) {
        return com.opos.mobad.g.a.a.k.a(str, aVar, list, aVar2, j, cVar, aVar3, new com.opos.mobad.ad.b.a() { // from class: com.opos.mobad.g.a.f.2
            @Override // com.opos.mobad.ad.b.a
            public void a() {
                List listG = f.this.b.g();
                f fVar = f.this;
                fVar.b(fVar.a((List<com.opos.mobad.ad.d.h>) listG, fVar.b.i()));
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i, String str2) {
                int iA = com.opos.mobad.g.a.a.l.a(i);
                com.opos.cmn.an.f.a.b("NativeAdvanceAdDelegator", "onAdFailed code=" + i + ",msg =" + str2 + "ErrorCodeTranslate: " + iA);
                f.this.c(iA, str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.opos.mobad.ad.d.h> a(List<com.opos.mobad.ad.d.h> list, int i) {
        if (list == null || list.size() <= 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (com.opos.mobad.ad.d.h hVar : list) {
            if (hVar != null) {
                arrayList.add(new b(hVar, this.d, this.c, i, h.a(this.b.i(), hVar, this.b.j()), this.e));
            }
        }
        return arrayList;
    }

    private int h() {
        return com.opos.mobad.c.b.a().s();
    }

    @Override // com.opos.mobad.q.f, com.opos.mobad.ad.b
    public void a() {
        a(h());
    }

    @Override // com.opos.mobad.q.f, com.opos.mobad.ad.k
    public void a(int i, List<String> list) {
        i.a aVarA = i.a(list);
        if (aVarA.f6989a != 0) {
            com.opos.mobad.c.b.g().c(this.d);
        }
        a(aVarA.b, i, list);
    }

    @Override // com.opos.mobad.q.f, com.opos.mobad.ad.k
    public void a(List<String> list) {
        a(h(), list);
    }

    @Override // com.opos.mobad.q.f, com.opos.mobad.ad.b
    public void b() {
        super.b();
        this.b.b();
    }

    @Override // com.opos.mobad.q.f
    protected boolean b(String str, int i) {
        return b(str, i, null);
    }

    @Override // com.opos.mobad.q.f
    protected boolean b(String str, int i, List<String> list) {
        return b(str, i, list, "");
    }

    @Override // com.opos.mobad.q.f
    protected boolean b(String str, int i, List<String> list, String str2) {
        if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("NativeAdvanceAdDelegator", "error request Id:" + str);
            c(10701, "show error, please reload");
            return true;
        }
        this.c = str;
        this.e = list;
        this.b.a(str, i, list, str2);
        return true;
    }

    @Override // com.opos.mobad.q.f
    protected boolean c(String str) {
        return false;
    }

    @Override // com.opos.mobad.q.f, com.opos.mobad.ad.b
    public boolean d() {
        return false;
    }
}
