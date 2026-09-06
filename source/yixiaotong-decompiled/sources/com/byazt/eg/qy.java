package com.byazt.eg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.text.Typography;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 16, 110})
public final class qy extends p {
    public final rl da;
    public final com.byazt.mk.a i;
    public final rl sl;
    public final List<tt> t;
    public long u = -1;
    public static final rl c = rl.c("multipart/mixed");
    public static final rl tt = rl.c("multipart/alternative");
    public static final rl ve = rl.c("multipart/digest");
    public static final rl uj = rl.c("multipart/parallel");
    public static final rl n = rl.c("multipart/form-data");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f2139a = {58, 32};
    public static final byte[] sp = {13, 10};
    public static final byte[] x = {45, 45};

    @Override // com.byazt.eg.p
    public rl c() {
        return this.sl;
    }

    public qy(com.byazt.mk.a aVar, rl rlVar, List<tt> list) {
        this.i = aVar;
        this.da = rlVar;
        this.sl = rl.c(rlVar + "; boundary=" + aVar.c());
        this.t = com.byazt.kh.ve.c(list);
    }

    @Override // com.byazt.eg.p
    public long tt() throws IOException {
        long j = this.u;
        if (j != -1) {
            return j;
        }
        long jC = c((com.byazt.mk.uj) null, true);
        this.u = jC;
        return jC;
    }

    @Override // com.byazt.eg.p
    public void c(com.byazt.mk.uj ujVar) throws IOException {
        c(ujVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private long c(com.byazt.mk.uj ujVar, boolean z) throws IOException {
        com.byazt.mk.ve veVar;
        if (z) {
            ujVar = new com.byazt.mk.ve();
            veVar = ujVar;
        } else {
            veVar = 0;
        }
        int size = this.t.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            tt ttVar = this.t.get(i);
            rh rhVar = ttVar.c;
            p pVar = ttVar.tt;
            ujVar.ve(x);
            ujVar.tt(this.i);
            ujVar.ve(sp);
            if (rhVar != null) {
                int iC = rhVar.c();
                for (int i2 = 0; i2 < iC; i2++) {
                    ujVar.tt(rhVar.c(i2)).ve(f2139a).tt(rhVar.tt(i2)).ve(sp);
                }
            }
            rl rlVarC = pVar.c();
            if (rlVarC != null) {
                ujVar.tt("Content-Type: ").tt(rlVarC.toString()).ve(sp);
            }
            long jTt = pVar.tt();
            if (jTt != -1) {
                ujVar.tt("Content-Length: ").t(jTt).ve(sp);
            } else if (z) {
                veVar.rh();
                return -1L;
            }
            byte[] bArr = sp;
            ujVar.ve(bArr);
            if (z) {
                j += jTt;
            } else {
                pVar.c(ujVar);
            }
            ujVar.ve(bArr);
        }
        byte[] bArr2 = x;
        ujVar.ve(bArr2);
        ujVar.tt(this.i);
        ujVar.ve(bArr2);
        ujVar.ve(sp);
        if (!z) {
            return j;
        }
        long jTt2 = j + veVar.tt();
        veVar.rh();
        return jTt2;
    }

    public static StringBuilder c(StringBuilder sb, String str) {
        sb.append(Typography.quote);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\n') {
                sb.append("%0A");
            } else if (cCharAt == '\r') {
                sb.append("%0D");
            } else if (cCharAt == '\"') {
                sb.append("%22");
            } else {
                sb.append(cCharAt);
            }
        }
        sb.append(Typography.quote);
        return sb;
    }

    @com.byazt.zqa.c(c = {0, 1, 16, 1239})
    public static final class tt {
        public final rh c;
        public final p tt;

        public static tt c(rh rhVar, p pVar) {
            if (pVar == null) {
                throw new NullPointerException("body == null");
            }
            if (rhVar != null && rhVar.c("Content-Type") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (rhVar != null && rhVar.c("Content-Length") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            return new tt(rhVar, pVar);
        }

        public static tt c(String str, String str2, p pVar) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder sb = new StringBuilder("form-data; name=");
            qy.c(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                qy.c(sb, str2);
            }
            return c(rh.c("Content-Disposition", sb.toString()), pVar);
        }

        private tt(rh rhVar, p pVar) {
            this.c = rhVar;
            this.tt = pVar;
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 16, 1539})
    public static final class c {
        public final com.byazt.mk.a c;
        public rl tt;
        public final List<tt> ve;

        public c() {
            this(UUID.randomUUID().toString());
        }

        public c(String str) {
            this.tt = qy.c;
            this.ve = new ArrayList();
            this.c = com.byazt.mk.a.c(str);
        }

        public c c(rl rlVar) {
            if (rlVar == null) {
                throw new NullPointerException("type == null");
            }
            if (!rlVar.c().equals("multipart")) {
                throw new IllegalArgumentException("multipart != ".concat(String.valueOf(rlVar)));
            }
            this.tt = rlVar;
            return this;
        }

        public c c(String str, String str2, p pVar) {
            return c(tt.c(str, str2, pVar));
        }

        public c c(tt ttVar) {
            if (ttVar == null) {
                throw new NullPointerException("part == null");
            }
            this.ve.add(ttVar);
            return this;
        }

        public qy c() {
            if (this.ve.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new qy(this.c, this.tt, this.ve);
        }
    }
}
