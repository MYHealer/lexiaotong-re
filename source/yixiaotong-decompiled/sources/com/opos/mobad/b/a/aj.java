package com.opos.mobad.b.a;

import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class aj extends com.heytap.nearx.a.a.b<aj, a> {
    public static final com.heytap.nearx.a.a.e<aj> c = new b();
    public static final c d = c.NO_TYPE;
    private static final long serialVersionUID = 0;
    public final c e;
    public final List<String> f;

    public static final class a extends com.heytap.nearx.a.a.b.a<aj, a> {
        public c c;
        public List<String> d = com.heytap.nearx.a.a.a.b.a();

        public a a(c cVar) {
            this.c = cVar;
            return this;
        }

        public aj b() {
            return new aj(this.c, this.d, super.a());
        }
    }

    private static final class b extends com.heytap.nearx.a.a.e<aj> {
        b() {
            super(com.heytap.nearx.a.a.a.LENGTH_DELIMITED, aj.class);
        }

        @Override // com.heytap.nearx.a.a.e
        public int a(aj ajVar) {
            return (ajVar.e != null ? c.i.a(1, ajVar.e) : 0) + com.heytap.nearx.a.a.e.p.a().a(2, ajVar.f) + ajVar.a().size();
        }

        @Override // com.heytap.nearx.a.a.e
        public void a(com.heytap.nearx.a.a.g gVar, aj ajVar) throws IOException {
            if (ajVar.e != null) {
                c.i.a(gVar, 1, ajVar.e);
            }
            com.heytap.nearx.a.a.e.p.a().a(gVar, 2, ajVar.f);
            gVar.a(ajVar.a());
        }

        @Override // com.heytap.nearx.a.a.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public aj a(com.heytap.nearx.a.a.f fVar) throws IOException {
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
                        aVar.a(c.i.a(fVar));
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

    public enum c implements com.heytap.nearx.a.a.i {
        NO_TYPE(0),
        VIDEO_START(1),
        VIDEO_PROCESS_25_PERCENT(2),
        VIDEO_PROCESS_50_PERCENT(3),
        VIDEO_PROCESS_75_PERCENT(4),
        VIDEO_COMPLETE(5),
        VIDEO_CLICK(6),
        VIDEO_CLOSE(7);

        public static final com.heytap.nearx.a.a.e<c> i = com.heytap.nearx.a.a.e.a(c.class);
        private final int j;

        c(int i2) {
            this.j = i2;
        }

        public static c fromValue(int i2) {
            switch (i2) {
                case 0:
                    return NO_TYPE;
                case 1:
                    return VIDEO_START;
                case 2:
                    return VIDEO_PROCESS_25_PERCENT;
                case 3:
                    return VIDEO_PROCESS_50_PERCENT;
                case 4:
                    return VIDEO_PROCESS_75_PERCENT;
                case 5:
                    return VIDEO_COMPLETE;
                case 6:
                    return VIDEO_CLICK;
                case 7:
                    return VIDEO_CLOSE;
                default:
                    return null;
            }
        }

        @Override // com.heytap.nearx.a.a.i
        public int getValue() {
            return this.j;
        }
    }

    public aj(c cVar, List<String> list, ByteString byteString) {
        super(c, byteString);
        this.e = cVar;
        this.f = com.heytap.nearx.a.a.a.b.b("trackUrls", list);
    }

    @Override // com.heytap.nearx.a.a.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", videoTrackType=").append(this.e);
        }
        if (!this.f.isEmpty()) {
            sb.append(", trackUrls=").append(this.f);
        }
        return sb.replace(0, 2, "VideoTrackEvent{").append('}').toString();
    }
}
