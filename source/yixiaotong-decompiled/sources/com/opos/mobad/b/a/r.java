package com.opos.mobad.b.a;

import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class r extends com.heytap.nearx.a.a.b<r, a> {
    public static final com.heytap.nearx.a.a.e<r> c = new c();
    public static final b d = b.NO_TYPE;
    private static final long serialVersionUID = 0;
    public final b e;
    public final List<String> f;

    public static final class a extends com.heytap.nearx.a.a.b.a<r, a> {
        public b c;
        public List<String> d = com.heytap.nearx.a.a.a.b.a();

        public a a(b bVar) {
            this.c = bVar;
            return this;
        }

        public r b() {
            return new r(this.c, this.d, super.a());
        }
    }

    public enum b implements com.heytap.nearx.a.a.i {
        NO_TYPE(0),
        DOWNLOAD_START(1),
        DOWNLOAD_COMPLETE(2),
        INSTALL_COMPLETE(3);

        public static final com.heytap.nearx.a.a.e<b> e = com.heytap.nearx.a.a.e.a(b.class);
        private final int f;

        b(int i) {
            this.f = i;
        }

        public static b fromValue(int i) {
            if (i == 0) {
                return NO_TYPE;
            }
            if (i == 1) {
                return DOWNLOAD_START;
            }
            if (i == 2) {
                return DOWNLOAD_COMPLETE;
            }
            if (i != 3) {
                return null;
            }
            return INSTALL_COMPLETE;
        }

        @Override // com.heytap.nearx.a.a.i
        public int getValue() {
            return this.f;
        }
    }

    private static final class c extends com.heytap.nearx.a.a.e<r> {
        c() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, r.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(r rVar) {
            return (rVar.e != null ? b.e.a(1, rVar.e) : 0) + com.heytap.nearx.a.a.e.p.a().a(2, rVar.f) + rVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, r rVar) throws IOException {
            if (rVar.e != null) {
                b.e.a(gVar, 1, rVar.e);
            }
            com.heytap.nearx.a.a.e.p.a().a(gVar, 2, rVar.f);
            gVar.a(rVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public r a(com.heytap.nearx.a.a.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    try {
                        aVar.a(b.e.a(fVar));
                    } catch (com.heytap.nearx.a.a.e.a e) {
                        aVar.a(iB, com.heytap.nearx.a.a.a.VARINT, Long.valueOf(e.f3488a));
                    }
                } else if (iB != 2) {
                    com.heytap.nearx.a.a.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.d.add(com.heytap.nearx.a.a.e.p.a(fVar));
                }
            }
        }
    }

    public r(b bVar, List<String> list, ByteString byteString) {
        super(c, byteString);
        this.e = bVar;
        this.f = com.heytap.nearx.a.a.a.b.b("trackUrls", list);
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", downLoadTrackType=").append(this.e);
        }
        if (!this.f.isEmpty()) {
            sb.append(", trackUrls=").append(this.f);
        }
        return sb.replace(0, 2, "DownLoadTrackEvent{").append('}').toString();
    }
}
