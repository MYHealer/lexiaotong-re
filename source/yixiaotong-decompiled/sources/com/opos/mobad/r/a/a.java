package com.opos.mobad.r.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a extends com.heytap.nearx.a.a.b<a, C0983a> {
    public static final com.heytap.nearx.a.a.e<a> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    public static final Integer f = 0;
    public static final Integer g = 0;
    private static final long serialVersionUID = 0;
    public final Integer h;
    public final Integer i;
    public final Integer j;
    public final Integer k;

    /* JADX INFO: renamed from: com.opos.mobad.r.a.a$a, reason: collision with other inner class name */
    public static final class C0983a extends com.heytap.nearx.a.a.b.a<a, C0983a> {
        public Integer c;
        public Integer d;
        public Integer e;
        public Integer f;

        public C0983a a(Integer num) {
            this.c = num;
            return this;
        }

        public C0983a b(Integer num) {
            this.d = num;
            return this;
        }

        public a b() {
            Integer num = this.c;
            if (num != null) {
                return new a(this.c, this.d, this.e, this.f, super.a());
            }
            throw com.heytap.nearx.a.a.a.b.a(num, "concurrentTimeout");
        }

        public C0983a c(Integer num) {
            this.e = num;
            return this;
        }

        public C0983a d(Integer num) {
            this.f = num;
            return this;
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<a> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, a.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(a aVar) {
            return com.heytap.nearx.a.a.e.d.a(1, aVar.h) + (aVar.i != null ? com.heytap.nearx.a.a.e.d.a(2, aVar.i) : 0) + (aVar.j != null ? com.heytap.nearx.a.a.e.d.a(3, aVar.j) : 0) + (aVar.k != null ? com.heytap.nearx.a.a.e.d.a(4, aVar.k) : 0) + aVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, a aVar) throws IOException {
            com.heytap.nearx.a.a.e.d.a(gVar, 1, aVar.h);
            if (aVar.i != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 2, aVar.i);
            }
            if (aVar.j != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 3, aVar.j);
            }
            if (aVar.k != null) {
                com.heytap.nearx.a.a.e.d.a(gVar, 4, aVar.k);
            }
            gVar.a(aVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(com.heytap.nearx.a.a.f fVar) throws IOException {
            C0983a c0983a = new C0983a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return c0983a.b();
                }
                if (iB == 1) {
                    c0983a.a(com.heytap.nearx.a.a.e.d.a(fVar));
                } else if (iB == 2) {
                    c0983a.b(com.heytap.nearx.a.a.e.d.a(fVar));
                } else if (iB == 3) {
                    c0983a.c(com.heytap.nearx.a.a.e.d.a(fVar));
                } else if (iB != 4) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    c0983a.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    c0983a.d(com.heytap.nearx.a.a.e.d.a(fVar));
                }
            }
        }
    }

    public a(Integer num, Integer num2, Integer num3, Integer num4, ByteString byteString) {
        super(c, byteString);
        this.h = num;
        this.i = num2;
        this.j = num3;
        this.k = num4;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", concurrentTimeout=").append(this.h);
        if (this.i != null) {
            sb.append(", syncPriorityTimeout=").append(this.i);
        }
        if (this.j != null) {
            sb.append(", shakeSensorTime=").append(this.j);
        }
        if (this.k != null) {
            sb.append(", shakeSensorDiff=").append(this.k);
        }
        return sb.replace(0, 2, "AdConfig{").append('}').toString();
    }
}
