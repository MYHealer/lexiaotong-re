package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class al extends com.heytap.nearx.a.a.b<al, a> {
    public static final com.heytap.nearx.a.a.e<al> c = new b();
    public static final Boolean d = false;
    private static final long serialVersionUID = 0;
    public final Boolean e;
    public final String f;
    public final String g;

    public static final class a extends com.heytap.nearx.a.a.b.a<al, a> {
        public Boolean c;
        public String d;
        public String e;

        public a a(Boolean bool) {
            this.c = bool;
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

        public al b() {
            return new al(this.c, this.d, this.e, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<al> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, al.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(al alVar) {
            return (alVar.e != null ? com.heytap.nearx.a.a.e.c.a(1, alVar.e) : 0) + (alVar.f != null ? com.heytap.nearx.a.a.e.p.a(2, alVar.f) : 0) + (alVar.g != null ? com.heytap.nearx.a.a.e.p.a(3, alVar.g) : 0) + alVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, al alVar) throws IOException {
            if (alVar.e != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 1, alVar.e);
            }
            if (alVar.f != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, alVar.f);
            }
            if (alVar.g != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, alVar.g);
            }
            gVar.a(alVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public al a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(com.heytap.nearx.a.a.e.c.a(fVar));
                } else if (iB == 2) {
                    aVar.a(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB != 3) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public al(Boolean bool, String str, String str2, ByteString byteString) {
        super(c, byteString);
        this.e = bool;
        this.f = str;
        this.g = str2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", installed=").append(this.e);
        }
        if (this.f != null) {
            sb.append(", version=").append(this.f);
        }
        if (this.g != null) {
            sb.append(", sdkVersion=").append(this.g);
        }
        return sb.replace(0, 2, "XgameInfo{").append('}').toString();
    }
}
