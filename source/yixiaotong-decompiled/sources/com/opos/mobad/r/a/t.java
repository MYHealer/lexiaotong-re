package com.opos.mobad.r.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class t extends com.heytap.nearx.a.a.b<t, a> {
    public static final com.heytap.nearx.a.a.e<t> c = new b();
    public static final Integer d = 0;
    public static final Long e = 0L;
    private static final long serialVersionUID = 0;
    public final Integer f;
    public final String g;
    public final u h;
    public final Long i;

    public static final class a extends com.heytap.nearx.a.a.b.a<t, a> {
        public Integer c;
        public String d;
        public u e;
        public Long f;

        public a a(u uVar) {
            this.e = uVar;
            return this;
        }

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public a a(Long l) {
            this.f = l;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public t b() {
            Integer num = this.c;
            if (num == null || this.f == null) {
                throw com.heytap.nearx.a.a.a.b.a(num, "code", this.f, "deadLineTime");
            }
            return new t(this.c, this.d, this.e, this.f, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<t> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, t.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(t tVar) {
            return com.heytap.nearx.a.a.e.d.a(1, tVar.f) + (tVar.g != null ? com.heytap.nearx.a.a.e.p.a(2, tVar.g) : 0) + (tVar.h != null ? u.c.a(3, tVar.h) : 0) + com.heytap.nearx.a.a.e.i.a(4, tVar.i) + tVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, t tVar) throws IOException {
            com.heytap.nearx.a.a.e.d.a(gVar, 1, tVar.f);
            if (tVar.g != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, tVar.g);
            }
            if (tVar.h != null) {
                u.c.a(gVar, 3, tVar.h);
            }
            com.heytap.nearx.a.a.e.i.a(gVar, 4, tVar.i);
            gVar.a(tVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public t a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.d.a(fVar));
                } else if (iB == 2) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB == 3) {
                    aVar.a(u.c.a(fVar));
                } else if (iB != 4) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                }
            }
        }
    }

    public t(Integer num, String str, u uVar, Long l, ByteString byteString) {
        super(c, byteString);
        this.f = num;
        this.g = str;
        this.h = uVar;
        this.i = l;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", code=").append(this.f);
        if (this.g != null) {
            sb.append(", msg=").append(this.g);
        }
        if (this.h != null) {
            sb.append(", responseInfo=").append(this.h);
        }
        sb.append(", deadLineTime=").append(this.i);
        return sb.replace(0, 2, "Response{").append('}').toString();
    }
}
