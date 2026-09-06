package com.opos.mobad.b.a;

import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class h extends com.heytap.nearx.a.a.b<h, a> {
    public static final com.heytap.nearx.a.a.e<h> c = new b();
    private static final long serialVersionUID = 0;
    public final String d;
    public final String e;
    public final String f;
    public final Map<String, Integer> g;

    public static final class a extends com.heytap.nearx.a.a.b.a<h, a> {
        public String c;
        public String d;
        public String e;
        public Map<String, Integer> f = com.heytap.nearx.a.a.a.b.b();

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a a(Map<String, Integer> map) {
            com.heytap.nearx.a.a.a.b.a(map);
            this.f = map;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public h b() {
            return new h(this.c, this.d, this.e, this.f, super.a());
        }

        public a c(String str) {
            this.e = str;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<h> {
        private final com.heytap.nearx.a.a.e<Map<String, Integer>> r;

        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, h.class);
            this.r = com.heytap.nearx.a.a.e.a(com.heytap.nearx.a.a.e.p, com.heytap.nearx.a.a.e.d);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(h hVar) {
            return (hVar.d != null ? com.heytap.nearx.a.a.e.p.a(1, hVar.d) : 0) + (hVar.e != null ? com.heytap.nearx.a.a.e.p.a(2, hVar.e) : 0) + (hVar.f != null ? com.heytap.nearx.a.a.e.p.a(3, hVar.f) : 0) + this.r.a(4, hVar.g) + hVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, h hVar) throws IOException {
            if (hVar.d != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 1, hVar.d);
            }
            if (hVar.e != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, hVar.e);
            }
            if (hVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, hVar.f);
            }
            this.r.a(gVar, 4, hVar.g);
            gVar.a(hVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB == 2) {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB == 3) {
                    aVar.c(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB != 4) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.f.putAll(this.r.a(fVar));
                }
            }
        }
    }

    public h(String str, String str2, String str3, Map<String, Integer> map, ByteString byteString) {
        super(c, byteString);
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = com.heytap.nearx.a.a.a.b.a("permissionMap", map);
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", appId=").append(this.d);
        }
        if (this.e != null) {
            sb.append(", pkgName=").append(this.e);
        }
        if (this.f != null) {
            sb.append(", verName=").append(this.f);
        }
        if (!this.g.isEmpty()) {
            sb.append(", permissionMap=").append(this.g);
        }
        return sb.replace(0, 2, "AppInfo{").append('}').toString();
    }
}
