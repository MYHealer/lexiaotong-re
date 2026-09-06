package com.opos.mobad.b.a;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a extends com.heytap.nearx.a.a.b<a, C0938a> {
    public static final com.heytap.nearx.a.a.e<a> c = new b();
    public static final Integer d = 0;
    private static final long serialVersionUID = 0;
    public final String e;
    public final String f;
    public final List<f> g;
    public final Integer h;

    /* JADX INFO: renamed from: com.opos.mobad.b.a.a$a, reason: collision with other inner class name */
    public static final class C0938a extends com.heytap.nearx.a.a.b.a<a, C0938a> {
        public String c;
        public String d;
        public List<f> e = com.heytap.nearx.a.a.a.b.a();
        public Integer f;

        public C0938a a(Integer num) {
            this.f = num;
            return this;
        }

        public C0938a a(String str) {
            this.c = str;
            return this;
        }

        public C0938a b(String str) {
            this.d = str;
            return this;
        }

        public a b() {
            String str = this.c;
            if (str == null || this.d == null || this.f == null) {
                throw com.heytap.nearx.a.a.a.b.a(str, com.hihonor.adsdk.base.c.r1.hnadse, this.d, TypedValues.AttributesType.S_TARGET, this.f, "minVerCode");
            }
            return new a(this.c, this.d, this.e, this.f, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<a> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, a.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(a aVar) {
            return com.heytap.nearx.a.a.e.p.a(1, aVar.e) + com.heytap.nearx.a.a.e.p.a(2, aVar.f) + f.c.a().a(3, aVar.g) + com.heytap.nearx.a.a.e.d.a(4, aVar.h) + aVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, a aVar) throws IOException {
            com.heytap.nearx.a.a.e.p.a(gVar, 1, aVar.e);
            com.heytap.nearx.a.a.e.p.a(gVar, 2, aVar.f);
            f.c.a().a(gVar, 3, aVar.g);
            com.heytap.nearx.a.a.e.d.a(gVar, 4, aVar.h);
            gVar.a(aVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(com.heytap.nearx.a.a.f fVar) throws IOException {
            C0938a c0938a = new C0938a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return c0938a.b();
                }
                if (iB == 1) {
                    c0938a.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB == 2) {
                    c0938a.b(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB == 3) {
                    c0938a.e.add(f.c.a(fVar));
                } else if (iB != 4) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    c0938a.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    c0938a.a(com.heytap.nearx.a.a.e.d.a(fVar));
                }
            }
        }
    }

    public a(String str, String str2, List<f> list, Integer num, ByteString byteString) {
        super(c, byteString);
        this.e = str;
        this.f = str2;
        this.g = com.heytap.nearx.a.a.a.b.b("signerList", list);
        this.h = num;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", pkgName=").append(this.e);
        sb.append(", target=").append(this.f);
        if (!this.g.isEmpty()) {
            sb.append(", signerList=").append(this.g);
        }
        sb.append(", minVerCode=").append(this.h);
        return sb.replace(0, 2, "ActivatingInfo{").append('}').toString();
    }
}
