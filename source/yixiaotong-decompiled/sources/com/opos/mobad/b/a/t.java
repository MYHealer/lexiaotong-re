package com.opos.mobad.b.a;

import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class t extends com.heytap.nearx.a.a.b<t, a> {
    public static final com.heytap.nearx.a.a.e<t> c = new b();
    private static final long serialVersionUID = 0;
    public final aa d;
    public final String e;
    public final String f;
    public final List<aa> g;
    public final List<aa> h;

    public static final class a extends com.heytap.nearx.a.a.b.a<t, a> {
        public aa c;
        public String d;
        public String e;
        public List<aa> f = com.heytap.nearx.a.a.a.b.a();
        public List<aa> g = com.heytap.nearx.a.a.a.b.a();

        public a a(aa aaVar) {
            this.c = aaVar;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a b(String str) {
            this.e = str;
            return this;
        }

        public t b() {
            return new t(this.c, this.d, this.e, this.f, this.g, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<t> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, t.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(t tVar) {
            return (tVar.d != null ? aa.c.a(1, tVar.d) : 0) + (tVar.e != null ? com.heytap.nearx.a.a.e.p.a(2, tVar.e) : 0) + (tVar.f != null ? com.heytap.nearx.a.a.e.p.a(3, tVar.f) : 0) + aa.c.a().a(4, tVar.g) + aa.c.a().a(5, tVar.h) + tVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, t tVar) throws IOException {
            if (tVar.d != null) {
                aa.c.a(gVar, 1, tVar.d);
            }
            if (tVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, tVar.e);
            }
            if (tVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, tVar.f);
            }
            aa.c.a().a(gVar, 4, tVar.g);
            aa.c.a().a(gVar, 5, tVar.h);
            gVar.a(tVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public t a(com.heytap.nearx.a.a.f fVar) throws IOException {
            List<aa> list;
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(aa.c.a(fVar));
                } else if (iB == 2) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB != 3) {
                    if (iB == 4) {
                        list = aVar.f;
                    } else if (iB != 5) {
                        com.heytap.nearx.a.a.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                    } else {
                        list = aVar.g;
                    }
                    list.add(aa.c.a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public t(aa aaVar, String str, String str2, List<aa> list, List<aa> list2, ByteString byteString) {
        super(c, byteString);
        this.d = aaVar;
        this.e = str;
        this.f = str2;
        this.g = com.heytap.nearx.a.a.a.b.b("imgFileList", list);
        this.h = com.heytap.nearx.a.a.a.b.b("interactiveFileList", list2);
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", iconFileList=").append(this.d);
        }
        if (this.e != null) {
            sb.append(", title=").append(this.e);
        }
        if (this.f != null) {
            sb.append(", desc=").append(this.f);
        }
        if (!this.g.isEmpty()) {
            sb.append(", imgFileList=").append(this.g);
        }
        if (!this.h.isEmpty()) {
            sb.append(", interactiveFileList=").append(this.h);
        }
        return sb.replace(0, 2, "FloatLayerInfo{").append('}').toString();
    }
}
