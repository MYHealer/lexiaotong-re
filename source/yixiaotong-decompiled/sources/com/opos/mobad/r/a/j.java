package com.opos.mobad.r.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class j extends com.heytap.nearx.a.a.b<j, a> {
    public static final com.heytap.nearx.a.a.e<j> c = new b();
    private static final long serialVersionUID = 0;
    public final i d;
    public final k e;
    public final String f;
    public final String g;

    public static final class a extends com.heytap.nearx.a.a.b.a<j, a> {
        public i c;
        public k d;
        public String e;
        public String f;

        public a a(i iVar) {
            this.c = iVar;
            return this;
        }

        public a a(k kVar) {
            this.d = kVar;
            return this;
        }

        public a a(String str) {
            this.e = str;
            return this;
        }

        public a b(String str) {
            this.f = str;
            return this;
        }

        public j b() {
            i iVar = this.c;
            if (iVar == null || this.d == null) {
                throw com.heytap.nearx.a.a.a.b.a(iVar, "devId", this.d, "devOs");
            }
            return new j(this.c, this.d, this.e, this.f, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<j> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, j.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(j jVar) {
            return i.c.a(1, jVar.d) + k.c.a(2, jVar.e) + (jVar.f != null ? com.heytap.nearx.a.a.e.p.a(3, jVar.f) : 0) + (jVar.g != null ? com.heytap.nearx.a.a.e.p.a(4, jVar.g) : 0) + jVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, j jVar) throws IOException {
            i.c.a(gVar, 1, jVar.d);
            k.c.a(gVar, 2, jVar.e);
            if (jVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, jVar.f);
            }
            if (jVar.g != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 4, jVar.g);
            }
            gVar.a(jVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public j a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(i.c.a(fVar));
                } else if (iB == 2) {
                    aVar.a(k.c.a(fVar));
                } else if (iB == 3) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB != 4) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public j(i iVar, k kVar, String str, String str2, ByteString byteString) {
        super(c, byteString);
        this.d = iVar;
        this.e = kVar;
        this.f = str;
        this.g = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", devId=").append(this.d);
        sb.append(", devOs=").append(this.e);
        if (this.f != null) {
            sb.append(", model=").append(this.f);
        }
        if (this.g != null) {
            sb.append(", brand=").append(this.g);
        }
        return sb.replace(0, 2, "DevInfo{").append('}').toString();
    }
}
