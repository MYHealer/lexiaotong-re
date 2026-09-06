package com.opos.mobad.b.a;

import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class w extends com.heytap.nearx.a.a.b<w, a> {
    public static final com.heytap.nearx.a.a.e<w> c = new b();
    public static final Boolean d = false;
    public static final Long e = 0L;
    public static final Long f = 0L;
    private static final long serialVersionUID = 0;
    public final Boolean g;
    public final String h;
    public final String i;
    public final Long j;
    public final Long k;

    public static final class a extends com.heytap.nearx.a.a.b.a<w, a> {
        public Boolean c;
        public String d;
        public String e;
        public Long f;
        public Long g;

        public a a(Boolean bool) {
            this.c = bool;
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

        public a b(Long l) {
            this.g = l;
            return this;
        }

        public a b(String str) {
            this.e = str;
            return this;
        }

        public w b() {
            return new w(this.c, this.d, this.e, this.f, this.g, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<w> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, w.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(w wVar) {
            return (wVar.g != null ? com.heytap.nearx.a.a.e.c.a(1, wVar.g) : 0) + (wVar.h != null ? com.heytap.nearx.a.a.e.p.a(2, wVar.h) : 0) + (wVar.i != null ? com.heytap.nearx.a.a.e.p.a(3, wVar.i) : 0) + (wVar.j != null ? com.heytap.nearx.a.a.e.i.a(4, wVar.j) : 0) + (wVar.k != null ? com.heytap.nearx.a.a.e.i.a(5, wVar.k) : 0) + wVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, w wVar) throws IOException {
            if (wVar.g != null) {
                com.heytap.nearx.a.a.e.c.a(gVar, 1, wVar.g);
            }
            if (wVar.h != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 2, wVar.h);
            }
            if (wVar.i != null) {
                com.heytap.nearx.a.a.e.p.a(gVar, 3, wVar.i);
            }
            if (wVar.j != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 4, wVar.j);
            }
            if (wVar.k != null) {
                com.heytap.nearx.a.a.e.i.a(gVar, 5, wVar.k);
            }
            gVar.a(wVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public w a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                } else if (iB == 3) {
                    aVar.b(com.heytap.nearx.a.a.e.p.a(fVar));
                } else if (iB == 4) {
                    aVar.a(com.heytap.nearx.a.a.e.i.a(fVar));
                } else if (iB != 5) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.a.a.e.i.a(fVar));
                }
            }
        }
    }

    public w(Boolean bool, String str, String str2, Long l, Long l2, ByteString byteString) {
        super(c, byteString);
        this.g = bool;
        this.h = str;
        this.i = str2;
        this.j = l;
        this.k = l2;
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", installed=").append(this.g);
        }
        if (this.h != null) {
            sb.append(", version=").append(this.h);
        }
        if (this.i != null) {
            sb.append(", sdkVersion=").append(this.i);
        }
        if (this.j != null) {
            sb.append(", firstActiveTime=").append(this.j);
        }
        if (this.k != null) {
            sb.append(", dayFirstActiveTime=").append(this.k);
        }
        return sb.replace(0, 2, "InstantInfo{").append('}').toString();
    }
}
