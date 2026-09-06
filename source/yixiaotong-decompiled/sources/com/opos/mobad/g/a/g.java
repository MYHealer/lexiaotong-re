package com.opos.mobad.g.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.opos.mobad.ad.d.s;
import com.opos.mobad.g.a.a.q;
import com.opos.mobad.g.a.a.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class g extends com.opos.mobad.q.g {
    private String b;
    private String c;
    private q<com.opos.mobad.ad.d.n, com.opos.mobad.ad.d.p> d;
    private List<String> e;

    public class a extends r<com.opos.mobad.ad.d.p> implements com.opos.mobad.ad.d.o, com.opos.mobad.ad.f {
        private int c;
        private final com.opos.mobad.ad.d.o d;

        public a(int i, com.opos.mobad.g.a.a.p pVar, com.opos.mobad.ad.d.o oVar) {
            super(i, pVar);
            this.c = i;
            this.d = oVar;
        }

        @Override // com.opos.mobad.ad.d.o
        public void a(com.opos.mobad.ad.d.q qVar, com.opos.mobad.ad.d.p pVar) {
            if (this.c == g.this.d.i()) {
                g.this.a(qVar, pVar);
            }
        }

        @Override // com.opos.mobad.ad.f
        public void a(Map<String, String> map) {
            com.opos.mobad.ad.d.o oVar = this.d;
            if (oVar instanceof com.opos.mobad.ad.f) {
                ((com.opos.mobad.ad.f) oVar).a(map);
            }
        }

        @Override // com.opos.mobad.ad.d.o
        public void b(com.opos.mobad.ad.d.p pVar) {
            if (this.c == g.this.d.i()) {
                com.opos.mobad.c.b.g().b(g.this.b);
                g.this.a(pVar);
            }
        }

        @Override // com.opos.mobad.ad.d.o
        public void c(com.opos.mobad.ad.d.p pVar) {
            if (this.c == g.this.d.i()) {
                com.opos.mobad.c.b.g().a(g.this.b);
                g.this.b(pVar);
            }
        }

        @Override // com.opos.mobad.ad.d.o
        public void d(com.opos.mobad.ad.d.p pVar) {
            if (this.c == g.this.d.i()) {
                g.this.c(pVar);
            }
        }

        @Override // com.opos.mobad.ad.d.o
        public void e(com.opos.mobad.ad.d.p pVar) {
            if (this.c == g.this.d.i()) {
                g.this.d(pVar);
            }
        }
    }

    private static class b implements com.opos.mobad.ad.d.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f6988a;
        private String b;
        private int c;
        private boolean d = false;
        private com.opos.mobad.ad.d.p e;
        private int f;
        private List<String> g;

        public b(com.opos.mobad.ad.d.p pVar, String str, String str2, int i, int i2, List<String> list) {
            this.e = pVar;
            this.f6988a = str;
            this.b = str2;
            this.c = i;
            this.f = i2;
            this.g = list;
        }

        @Override // com.opos.mobad.ad.d.p
        public View a() {
            return this.e.a();
        }

        @Override // com.opos.mobad.ad.i
        public void a(int i, String str, int i2) {
            if (!com.opos.mobad.c.b.a().b(this.f6988a) || this.d) {
                return;
            }
            this.d = true;
            com.opos.mobad.c.b.f().a(this.f6988a, this.b, i, str, this.c, this.f, i2);
        }

        @Override // com.opos.mobad.ad.d.p
        public void a(Object obj) {
            this.e.a(obj);
        }

        @Override // com.opos.mobad.ad.d.p
        public void b() {
            this.e.b();
        }

        @Override // com.opos.mobad.ad.i
        public void b(int i) {
            if (!com.opos.mobad.c.b.a().b(this.f6988a) || this.d) {
                return;
            }
            this.d = true;
            com.opos.mobad.c.b.f().a(this.f6988a, this.b, this.c, this.f, i);
        }

        @Override // com.opos.mobad.ad.d.p
        public void c() {
            this.e.c();
        }

        @Override // com.opos.mobad.ad.i
        public void c(int i) {
            if ((com.opos.mobad.c.b.a().b(this.f6988a) || this.g != null) && !this.d) {
                this.e.c(i);
            }
        }

        @Override // com.opos.mobad.ad.d.p
        public Object d() {
            return this.e.d();
        }

        @Override // com.opos.mobad.ad.i
        public int e() {
            return 0;
        }

        @Override // com.opos.mobad.ad.i
        public int f() {
            if (com.opos.mobad.c.b.a().b(this.f6988a)) {
                return this.f;
            }
            return 0;
        }

        @Override // com.opos.mobad.ad.d.p
        public String g() {
            return this.e.g();
        }
    }

    public g(final Context context, final s sVar, final String str, com.opos.mobad.g.a.e.a aVar, final com.opos.mobad.ad.d.o oVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, final com.opos.mobad.g.b bVar) {
        super(oVar);
        this.b = str;
        this.d = a(str, aVar, list, aVar2, j, new com.opos.mobad.g.a.b.c<com.opos.mobad.ad.d.n>() { // from class: com.opos.mobad.g.a.g.1
            @Override // com.opos.mobad.g.a.b.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public com.opos.mobad.ad.d.n b(com.opos.mobad.c.a.d.a aVar3, com.opos.mobad.g.a.a.p pVar) {
                com.opos.mobad.ad.c cVarB = bVar.b(aVar3.m);
                if (cVarB == null) {
                    return null;
                }
                return cVarB.a(context, new s.a().a(sVar.f6650a).b(sVar.b).a(), str, aVar3.n, g.this.new a(aVar3.m, pVar, oVar));
            }
        }, new com.opos.mobad.g.a.c.a(context));
    }

    private q<com.opos.mobad.ad.d.n, com.opos.mobad.ad.d.p> a(String str, com.opos.mobad.g.a.e.a aVar, List<com.opos.mobad.c.a.d.a> list, com.opos.mobad.c.a.d.a aVar2, long j, com.opos.mobad.g.a.b.c<com.opos.mobad.ad.d.n> cVar, com.opos.mobad.g.a.c.a aVar3) {
        return com.opos.mobad.g.a.a.k.a(str, aVar, list, aVar2, j, cVar, aVar3, new com.opos.mobad.ad.b.a() { // from class: com.opos.mobad.g.a.g.2
            @Override // com.opos.mobad.ad.b.a
            public void a() {
                List listG = g.this.d.g();
                g gVar = g.this;
                gVar.b(gVar.a((List<com.opos.mobad.ad.d.p>) listG, gVar.d.i()));
            }

            @Override // com.opos.mobad.ad.b.a
            public void a(int i, String str2) {
                int iA = com.opos.mobad.g.a.a.l.a(i);
                com.opos.cmn.an.f.a.b("NativeTemplateAdDelegator", "onAdFailed code=" + i + ",msg =" + str2 + "ErrorCodeTranslate: " + iA);
                g.this.c(iA, str2);
            }

            @Override // com.opos.mobad.ad.b.a
            public void b() {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.opos.mobad.ad.d.p> a(List<com.opos.mobad.ad.d.p> list, int i) {
        if (list == null || list.size() <= 0) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (com.opos.mobad.ad.d.p pVar : list) {
            if (pVar != null) {
                arrayList.add(new b(pVar, this.b, this.c, i, h.a(pVar, this.d.j()), this.e));
            }
        }
        return arrayList;
    }

    private int h() {
        return com.opos.mobad.c.b.a().u();
    }

    @Override // com.opos.mobad.q.f, com.opos.mobad.ad.b
    public void a() {
        a(h());
    }

    @Override // com.opos.mobad.q.f, com.opos.mobad.ad.k
    public void a(int i, List<String> list) {
        i.a aVarA = i.a(list);
        if (aVarA.f6989a != 0) {
            com.opos.mobad.c.b.g().c(this.b);
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
        this.d.b();
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
            com.opos.cmn.an.f.a.b("NativeTemplateAdDelegator", "error request Id:" + str);
            c(10701, "show error, please reload");
            return true;
        }
        this.c = str;
        this.e = list;
        this.d.a(str, i, list, str2);
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
