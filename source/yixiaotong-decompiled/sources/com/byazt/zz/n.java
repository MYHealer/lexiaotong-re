package com.byazt.zz;

import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 189, 46})
public class n {
    public static String tt = "ResponseHandler";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.byazt.hs.i f2952a;
    public long d;
    public com.byazt.t.n da;
    public final long gr;
    public final com.byazt.k.c gt;
    public final long gu;
    public long h;
    public gt i;
    public long m;
    public long md;
    public final boolean my;
    public final com.byazt.t.tt n;
    public volatile long nu;
    public long p;
    public final boolean qy;
    public volatile long rh;
    public final com.byazt.g.c rl;
    public BaseException sl;
    public da sp;
    public volatile boolean t;
    public volatile boolean u;
    public final String uj;
    public final DownloadInfo ve;
    public com.byazt.b.sl x;
    public final com.byazt.u.a yp;
    public boolean yv;
    public long z;
    public final boolean zm;
    public boolean c = false;
    public volatile long eo = 0;
    public volatile long zb = 0;

    private boolean a() {
        return this.t || this.u;
    }

    private boolean tt(long j, long j2) {
        return j > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH && j2 > 500;
    }

    public long c() {
        return this.z;
    }

    public void c(long j, long j2) {
        this.nu = j;
        this.rh = j2;
    }

    public void c(long j, long j2, long j3) {
        this.z = j;
        this.m = j;
        this.nu = j2;
        this.rh = j3;
    }

    public long n() {
        return this.eo;
    }

    public n(DownloadInfo downloadInfo, String str, com.byazt.hs.i iVar, com.byazt.t.tt ttVar, com.byazt.u.a aVar) {
        this.ve = downloadInfo;
        this.uj = str;
        da daVarZm = ve.zm();
        this.sp = daVarZm;
        if (daVarZm instanceof com.byazt.b.uj) {
            com.byazt.b.uj ujVar = (com.byazt.b.uj) daVarZm;
            this.x = ujVar.c();
            this.i = ujVar.a();
        }
        this.f2952a = iVar;
        this.n = ttVar;
        this.yp = aVar;
        long jYp = ttVar.yp();
        this.z = jYp;
        this.m = jYp;
        if (ttVar.uj()) {
            this.rh = ttVar.nu();
        } else {
            this.rh = ttVar.ve(false);
        }
        this.nu = ttVar.m();
        this.rl = com.byazt.g.c.c();
        com.byazt.k.c cVarC = com.byazt.k.c.c(downloadInfo.getId());
        this.gt = cVarC;
        boolean z = cVarC.c("sync_strategy", 0) == 1;
        this.qy = z;
        if (z) {
            long jC = cVarC.c("sync_interval_ms_fg", 5000);
            long jC2 = cVarC.c("sync_interval_ms_bg", 1000);
            this.gu = Math.max(jC, 500L);
            this.gr = Math.max(jC2, 500L);
        } else {
            this.gu = 0L;
            this.gr = 0L;
        }
        this.zm = cVarC.tt("monitor_rw") == 1;
        this.my = com.byazt.w.c.c(65536);
    }

    public void tt() {
        if (this.t) {
            return;
        }
        this.t = true;
        sp();
    }

    public void ve() {
        if (this.u) {
            return;
        }
        synchronized (this.yp) {
            this.u = true;
        }
        sp();
    }

    private void sp() {
        ExecutorService executorServiceT;
        if (this.f2952a == null || (executorServiceT = ve.t()) == null) {
            return;
        }
        executorServiceT.execute(new Runnable() { // from class: com.byazt.zz.n.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.f2952a.uj();
                } catch (Throwable unused) {
                }
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:168:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:170:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:172:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:175:0x02c2 A[Catch: all -> 0x0307, TryCatch #18 {all -> 0x0307, blocks: (B:173:0x02be, B:175:0x02c2, B:176:0x02c4, B:186:0x02d9, B:187:0x02da, B:189:0x02e3, B:177:0x02c5, B:179:0x02c9, B:181:0x02d2, B:182:0x02d5), top: B:331:0x02be, inners: #25 }] */
    /* JADX WARN: Code duplicated, block: B:179:0x02c9 A[Catch: all -> 0x02d7, TryCatch #25 {, blocks: (B:177:0x02c5, B:179:0x02c9, B:181:0x02d2, B:182:0x02d5), top: B:339:0x02c5, outer: #18 }] */
    /* JADX WARN: Code duplicated, block: B:181:0x02d2 A[Catch: all -> 0x02d7, TryCatch #25 {, blocks: (B:177:0x02c5, B:179:0x02c9, B:181:0x02d2, B:182:0x02d5), top: B:339:0x02c5, outer: #18 }] */
    /* JADX WARN: Code duplicated, block: B:187:0x02da A[Catch: all -> 0x0307, TryCatch #18 {all -> 0x0307, blocks: (B:173:0x02be, B:175:0x02c2, B:176:0x02c4, B:186:0x02d9, B:187:0x02da, B:189:0x02e3, B:177:0x02c5, B:179:0x02c9, B:181:0x02d2, B:182:0x02d5), top: B:331:0x02be, inners: #25 }] */
    /* JADX WARN: Code duplicated, block: B:189:0x02e3 A[Catch: all -> 0x0307, TRY_LEAVE, TryCatch #18 {all -> 0x0307, blocks: (B:173:0x02be, B:175:0x02c2, B:176:0x02c4, B:186:0x02d9, B:187:0x02da, B:189:0x02e3, B:177:0x02c5, B:179:0x02c9, B:181:0x02d2, B:182:0x02d5), top: B:331:0x02be, inners: #25 }] */
    /* JADX WARN: Code duplicated, block: B:195:0x0314 A[Catch: all -> 0x047d, TRY_ENTER, TryCatch #14 {all -> 0x047d, blocks: (B:166:0x029d, B:195:0x0314, B:197:0x031a, B:198:0x031d, B:239:0x03fc, B:240:0x03fe, B:244:0x0404, B:246:0x041d, B:274:0x0471, B:276:0x0477, B:277:0x047a, B:278:0x047c), top: B:326:0x0028, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:197:0x031a A[Catch: all -> 0x047d, TRY_LEAVE, TryCatch #14 {all -> 0x047d, blocks: (B:166:0x029d, B:195:0x0314, B:197:0x031a, B:198:0x031d, B:239:0x03fc, B:240:0x03fe, B:244:0x0404, B:246:0x041d, B:274:0x0471, B:276:0x0477, B:277:0x047a, B:278:0x047c), top: B:326:0x0028, inners: #3 }] */
    /* JADX WARN: Code duplicated, block: B:201:0x0326  */
    /* JADX WARN: Code duplicated, block: B:203:0x032b  */
    /* JADX WARN: Code duplicated, block: B:206:0x0332 A[Catch: all -> 0x03ee, TryCatch #7 {all -> 0x03ee, blocks: (B:204:0x032e, B:206:0x0332, B:207:0x0334, B:217:0x0349, B:218:0x034a, B:220:0x0353, B:208:0x0335, B:210:0x0339, B:212:0x0342, B:213:0x0345), top: B:317:0x032e, inners: #17 }] */
    /* JADX WARN: Code duplicated, block: B:210:0x0339 A[Catch: all -> 0x0347, TryCatch #17 {, blocks: (B:208:0x0335, B:210:0x0339, B:212:0x0342, B:213:0x0345), top: B:329:0x0335, outer: #7 }] */
    /* JADX WARN: Code duplicated, block: B:212:0x0342 A[Catch: all -> 0x0347, TryCatch #17 {, blocks: (B:208:0x0335, B:210:0x0339, B:212:0x0342, B:213:0x0345), top: B:329:0x0335, outer: #7 }] */
    /* JADX WARN: Code duplicated, block: B:218:0x034a A[Catch: all -> 0x03ee, TryCatch #7 {all -> 0x03ee, blocks: (B:204:0x032e, B:206:0x0332, B:207:0x0334, B:217:0x0349, B:218:0x034a, B:220:0x0353, B:208:0x0335, B:210:0x0339, B:212:0x0342, B:213:0x0345), top: B:317:0x032e, inners: #17 }] */
    /* JADX WARN: Code duplicated, block: B:220:0x0353 A[Catch: all -> 0x03ee, TRY_LEAVE, TryCatch #7 {all -> 0x03ee, blocks: (B:204:0x032e, B:206:0x0332, B:207:0x0334, B:217:0x0349, B:218:0x034a, B:220:0x0353, B:208:0x0335, B:210:0x0339, B:212:0x0342, B:213:0x0345), top: B:317:0x032e, inners: #17 }] */
    /* JADX WARN: Code duplicated, block: B:224:0x039e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:225:0x039f  */
    /* JADX WARN: Code duplicated, block: B:227:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:234:0x03ed A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:324:0x017f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:329:0x0335 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:339:0x02c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:347:0x01f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:348:0x01f0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x0156 A[Catch: all -> 0x01ff, BaseException -> 0x0202, TryCatch #26 {BaseException -> 0x0202, all -> 0x01ff, blocks: (B:59:0x012a, B:61:0x0134, B:63:0x0141, B:69:0x0156, B:70:0x015c, B:72:0x0166, B:73:0x0171, B:74:0x017e, B:81:0x0196, B:83:0x019e, B:85:0x01a6, B:87:0x01ae, B:89:0x01b6, B:91:0x01c1, B:95:0x01c9, B:99:0x01d5, B:103:0x01db, B:104:0x01de, B:106:0x01f0, B:107:0x01f5, B:108:0x01f6, B:109:0x01fb, B:112:0x01fe), top: B:344:0x012a }] */
    /* JADX WARN: Code duplicated, block: B:72:0x0166 A[Catch: all -> 0x01ff, BaseException -> 0x0202, TryCatch #26 {BaseException -> 0x0202, all -> 0x01ff, blocks: (B:59:0x012a, B:61:0x0134, B:63:0x0141, B:69:0x0156, B:70:0x015c, B:72:0x0166, B:73:0x0171, B:74:0x017e, B:81:0x0196, B:83:0x019e, B:85:0x01a6, B:87:0x01ae, B:89:0x01b6, B:91:0x01c1, B:95:0x01c9, B:99:0x01d5, B:103:0x01db, B:104:0x01de, B:106:0x01f0, B:107:0x01f5, B:108:0x01f6, B:109:0x01fb, B:112:0x01fe), top: B:344:0x012a }] */
    /* JADX WARN: Code duplicated, block: B:79:0x0187 A[Catch: all -> 0x01fc, TryCatch #13 {, blocks: (B:75:0x017f, B:77:0x0183, B:80:0x0195, B:79:0x0187), top: B:324:0x017f }] */
    /* JADX WARN: Code duplicated, block: B:83:0x019e A[Catch: all -> 0x01ff, BaseException -> 0x0202, TryCatch #26 {BaseException -> 0x0202, all -> 0x01ff, blocks: (B:59:0x012a, B:61:0x0134, B:63:0x0141, B:69:0x0156, B:70:0x015c, B:72:0x0166, B:73:0x0171, B:74:0x017e, B:81:0x0196, B:83:0x019e, B:85:0x01a6, B:87:0x01ae, B:89:0x01b6, B:91:0x01c1, B:95:0x01c9, B:99:0x01d5, B:103:0x01db, B:104:0x01de, B:106:0x01f0, B:107:0x01f5, B:108:0x01f6, B:109:0x01fb, B:112:0x01fe), top: B:344:0x012a }] */
    /* JADX WARN: Code duplicated, block: B:85:0x01a6 A[Catch: all -> 0x01ff, BaseException -> 0x0202, TryCatch #26 {BaseException -> 0x0202, all -> 0x01ff, blocks: (B:59:0x012a, B:61:0x0134, B:63:0x0141, B:69:0x0156, B:70:0x015c, B:72:0x0166, B:73:0x0171, B:74:0x017e, B:81:0x0196, B:83:0x019e, B:85:0x01a6, B:87:0x01ae, B:89:0x01b6, B:91:0x01c1, B:95:0x01c9, B:99:0x01d5, B:103:0x01db, B:104:0x01de, B:106:0x01f0, B:107:0x01f5, B:108:0x01f6, B:109:0x01fb, B:112:0x01fe), top: B:344:0x012a }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v7 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r21v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r21v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r21v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v18, types: [int] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v23 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    public void uj() throws BaseException {
        long j;
        long j2;
        com.byazt.ty.tt ttVarC;
        com.byazt.hs.i iVar;
        com.byazt.hs.i iVar2;
        boolean z;
        boolean z2;
        com.byazt.hs.i iVar3;
        String str;
        DownloadInfo downloadInfo;
        com.byazt.k.c cVar;
        ?? r4;
        ?? r5;
        ?? r6;
        long j3;
        int i;
        int i2;
        long j4;
        if (a() || this.n == null) {
            return;
        }
        long jC = com.byazt.w.a.c(this.f2952a);
        ?? C = 0;
        if (jC == 0) {
            throw new com.byazt.m.a(1004, "the content-length is 0");
        }
        long jT = this.n.t();
        long jNanoTime = System.nanoTime();
        ?? r15 = this.zm;
        int i3 = 1;
        char c = 0;
        try {
            try {
                DownloadInfo downloadInfo2 = this.ve;
                String tempPath = downloadInfo2.getTempPath();
                String tempName = this.ve.getTempName();
                int i4 = -1;
                C = this.gt.c("flush_buffer_size_byte", -1);
                com.byazt.t.n nVarC = com.byazt.w.a.c(downloadInfo2, tempPath, tempName, (int) C);
                this.da = nVarC;
                try {
                    try {
                        nVarC.c(this.z);
                        InputStream inputStreamC = this.f2952a.c();
                        if (inputStreamC == null) {
                            throw new BaseException(1042, new IOException("inputStream is null"));
                        }
                        this.ve.updateRealStartDownloadTime();
                        ttVarC = c(inputStreamC);
                        try {
                            this.ve.setIsRwConcurrent(this.yv);
                            this.c = this.ve.getOpenLimitSpeed();
                            long j5 = com.byazt.ev.n.uj;
                            long j6 = com.byazt.ev.n.n;
                            long j7 = j5 / (1000 / j6);
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            long jNanoTime2 = 0;
                            long j8 = 0;
                            r15 = r15;
                            while (true) {
                                if (!a()) {
                                    C = r15 == true ? 1 : 0;
                                    if (C != 0) {
                                        try {
                                            try {
                                                jNanoTime2 = System.nanoTime();
                                            } catch (BaseException e) {
                                                e = e;
                                                j2 = jNanoTime;
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            j = jT;
                                            j2 = jNanoTime;
                                            com.byazt.x.c.uj(tt, "handleResponse: e = ".concat(String.valueOf(th)));
                                            if (a()) {
                                                iVar2 = this.f2952a;
                                                if (iVar2 != null) {
                                                    iVar2.uj();
                                                }
                                                if (ttVarC != null) {
                                                    ttVarC.tt();
                                                }
                                                try {
                                                    if (this.my) {
                                                        synchronized (this.yp) {
                                                            if (!this.u) {
                                                                c(this.x);
                                                                if (this.da != null) {
                                                                    x();
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        c(this.x);
                                                        if (this.da != null) {
                                                            x();
                                                        }
                                                    }
                                                    com.byazt.w.a.c(this.da);
                                                    r5 = C;
                                                    this.d = System.nanoTime() - j2;
                                                    cVar = this.gt;
                                                    downloadInfo = this.ve;
                                                    str = this.uj;
                                                    iVar3 = this.f2952a;
                                                    z2 = this.t;
                                                    z = this.u;
                                                    r4 = r5;
                                                    com.byazt.zl.c.c(cVar, downloadInfo, str, iVar3, z2, z, this.sl, this.z - this.m, this.d, r4, this.p, this.md, this.h, null);
                                                } catch (Throwable th2) {
                                                    com.byazt.w.a.c(this.da);
                                                    throw th2;
                                                }
                                            }
                                            if (com.byazt.x.c.c()) {
                                                com.byazt.nr.m.c(th);
                                            }
                                            try {
                                                com.byazt.w.a.c(th, "ResponseHandler");
                                                iVar = this.f2952a;
                                                if (iVar != null) {
                                                    iVar.uj();
                                                }
                                                if (ttVarC != null) {
                                                    ttVarC.tt();
                                                }
                                                try {
                                                    if (this.my) {
                                                        synchronized (this.yp) {
                                                            if (!this.u) {
                                                                c(this.x);
                                                                if (this.da != null) {
                                                                    x();
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        c(this.x);
                                                        if (this.da != null) {
                                                            x();
                                                        }
                                                    }
                                                    com.byazt.w.a.c(this.da);
                                                    r6 = C;
                                                    this.d = System.nanoTime() - j2;
                                                    com.byazt.zl.c.c(this.gt, this.ve, this.uj, this.f2952a, this.t, this.u, this.sl, this.z - this.m, this.d, r6, this.p, this.md, this.h, null);
                                                    if (this.ve.isIgnoreDataVerify()) {
                                                        return;
                                                    }
                                                    j3 = this.z - this.m;
                                                    if (j3 < 0) {
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                } catch (Throwable th3) {
                                                    com.byazt.w.a.c(this.da);
                                                    throw th3;
                                                }
                                            } catch (BaseException e2) {
                                                this.sl = e2;
                                                throw e2;
                                            }
                                        }
                                    }
                                    com.byazt.h.c cVarC = ttVarC.c();
                                    if (C != 0) {
                                        this.p += System.nanoTime() - jNanoTime2;
                                    }
                                    int i5 = cVarC.ve;
                                    if (i5 == i4) {
                                        j = jT;
                                        j2 = jNanoTime;
                                        break;
                                    }
                                    if (this.ve.isIgnoreDataVerify()) {
                                        j = jT;
                                        j2 = jNanoTime;
                                        i = i5;
                                    } else {
                                        j = jT;
                                        try {
                                            j2 = jNanoTime;
                                            try {
                                                i = i5;
                                                if (this.rh > this.z - this.m && this.rh < (this.z - this.m) + ((long) i)) {
                                                    i2 = (int) (this.rh - (this.z - this.m));
                                                }
                                                if (C != 0) {
                                                    jNanoTime2 = System.nanoTime();
                                                }
                                                this.da.c(cVarC.c, 0, i2);
                                                if (C != 0) {
                                                    this.md += System.nanoTime() - jNanoTime2;
                                                }
                                                ttVarC.c(cVarC);
                                                j4 = i2;
                                                this.z += j4;
                                                j8 += j4;
                                                synchronized (this.yp) {
                                                    if (this.my || !this.u) {
                                                        boolean zTt = this.yp.tt(j4);
                                                        c(this.x);
                                                        c(zTt);
                                                    }
                                                }
                                                if (this.ve.isDownloadWithWifiValid()) {
                                                    throw new com.byazt.m.ve();
                                                }
                                                if (this.ve.isPauseReserveWithWifiValid()) {
                                                    throw new com.byazt.m.n();
                                                }
                                                if (this.ve.isIgnoreDataVerify() && this.rh >= 0 && this.rh <= this.z - this.m) {
                                                    break;
                                                }
                                                if (!this.c && j8 > j7) {
                                                    long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
                                                    if (jCurrentTimeMillis2 < j6) {
                                                        try {
                                                            Thread.sleep(j6 - jCurrentTimeMillis2);
                                                        } catch (InterruptedException e3) {
                                                            com.byazt.nr.m.c(e3);
                                                        }
                                                    }
                                                    jCurrentTimeMillis = System.currentTimeMillis();
                                                    j8 = 0;
                                                }
                                                r15 = C;
                                                jNanoTime = j2;
                                                jT = j;
                                                i4 = -1;
                                                i3 = 1;
                                                c = 0;
                                            } catch (BaseException e4) {
                                                e = e4;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                com.byazt.x.c.uj(tt, "handleResponse: e = ".concat(String.valueOf(th)));
                                                if (a()) {
                                                    iVar2 = this.f2952a;
                                                    if (iVar2 != null) {
                                                        iVar2.uj();
                                                    }
                                                    if (ttVarC != null) {
                                                        ttVarC.tt();
                                                    }
                                                    if (this.my) {
                                                        synchronized (this.yp) {
                                                            if (!this.u) {
                                                                c(this.x);
                                                                if (this.da != null) {
                                                                    x();
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        c(this.x);
                                                        if (this.da != null) {
                                                            x();
                                                        }
                                                    }
                                                    com.byazt.w.a.c(this.da);
                                                    r5 = C;
                                                    this.d = System.nanoTime() - j2;
                                                    cVar = this.gt;
                                                    downloadInfo = this.ve;
                                                    str = this.uj;
                                                    iVar3 = this.f2952a;
                                                    z2 = this.t;
                                                    z = this.u;
                                                    r4 = r5;
                                                    com.byazt.zl.c.c(cVar, downloadInfo, str, iVar3, z2, z, this.sl, this.z - this.m, this.d, r4, this.p, this.md, this.h, null);
                                                }
                                                if (com.byazt.x.c.c()) {
                                                    com.byazt.nr.m.c(th);
                                                }
                                                com.byazt.w.a.c(th, "ResponseHandler");
                                                iVar = this.f2952a;
                                                if (iVar != null) {
                                                    iVar.uj();
                                                }
                                                if (ttVarC != null) {
                                                    ttVarC.tt();
                                                }
                                                if (this.my) {
                                                    synchronized (this.yp) {
                                                        if (!this.u) {
                                                            c(this.x);
                                                            if (this.da != null) {
                                                                x();
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    c(this.x);
                                                    if (this.da != null) {
                                                        x();
                                                    }
                                                }
                                                com.byazt.w.a.c(this.da);
                                                r6 = C;
                                            }
                                        } catch (Throwable th5) {
                                            th = th5;
                                            j2 = jNanoTime;
                                            com.byazt.x.c.uj(tt, "handleResponse: e = ".concat(String.valueOf(th)));
                                            if (a()) {
                                                iVar2 = this.f2952a;
                                                if (iVar2 != null) {
                                                    iVar2.uj();
                                                }
                                                if (ttVarC != null) {
                                                    ttVarC.tt();
                                                }
                                                if (this.my) {
                                                    synchronized (this.yp) {
                                                        if (!this.u) {
                                                            c(this.x);
                                                            if (this.da != null) {
                                                                x();
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    c(this.x);
                                                    if (this.da != null) {
                                                        x();
                                                    }
                                                }
                                                com.byazt.w.a.c(this.da);
                                                r5 = C;
                                                this.d = System.nanoTime() - j2;
                                                cVar = this.gt;
                                                downloadInfo = this.ve;
                                                str = this.uj;
                                                iVar3 = this.f2952a;
                                                z2 = this.t;
                                                z = this.u;
                                                r4 = r5;
                                                com.byazt.zl.c.c(cVar, downloadInfo, str, iVar3, z2, z, this.sl, this.z - this.m, this.d, r4, this.p, this.md, this.h, null);
                                            }
                                            if (com.byazt.x.c.c()) {
                                                com.byazt.nr.m.c(th);
                                            }
                                            com.byazt.w.a.c(th, "ResponseHandler");
                                            iVar = this.f2952a;
                                            if (iVar != null) {
                                                iVar.uj();
                                            }
                                            if (ttVarC != null) {
                                                ttVarC.tt();
                                            }
                                            if (this.my) {
                                                synchronized (this.yp) {
                                                    if (!this.u) {
                                                        c(this.x);
                                                        if (this.da != null) {
                                                            x();
                                                        }
                                                    }
                                                }
                                            } else {
                                                c(this.x);
                                                if (this.da != null) {
                                                    x();
                                                }
                                            }
                                            com.byazt.w.a.c(this.da);
                                            r6 = C;
                                            this.d = System.nanoTime() - j2;
                                            com.byazt.zl.c.c(this.gt, this.ve, this.uj, this.f2952a, this.t, this.u, this.sl, this.z - this.m, this.d, r6, this.p, this.md, this.h, null);
                                            if (this.ve.isIgnoreDataVerify()) {
                                                return;
                                            }
                                            j3 = this.z - this.m;
                                            if (j3 < 0) {
                                                return;
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                    i2 = i;
                                    if (C != 0) {
                                        jNanoTime2 = System.nanoTime();
                                    }
                                    this.da.c(cVarC.c, 0, i2);
                                    if (C != 0) {
                                        this.md += System.nanoTime() - jNanoTime2;
                                    }
                                    ttVarC.c(cVarC);
                                    j4 = i2;
                                    this.z += j4;
                                    j8 += j4;
                                    synchronized (this.yp) {
                                        if (this.my) {
                                            boolean zTt2 = this.yp.tt(j4);
                                            c(this.x);
                                            c(zTt2);
                                        } else {
                                            boolean zTt3 = this.yp.tt(j4);
                                            c(this.x);
                                            c(zTt3);
                                        }
                                        if (this.ve.isDownloadWithWifiValid()) {
                                            throw new com.byazt.m.ve();
                                        }
                                        if (this.ve.isPauseReserveWithWifiValid()) {
                                            throw new com.byazt.m.n();
                                        }
                                        if (this.ve.isIgnoreDataVerify()) {
                                        }
                                        if (!this.c) {
                                        }
                                        r15 = C;
                                        jNanoTime = j2;
                                        jT = j;
                                        i4 = -1;
                                        i3 = 1;
                                        c = 0;
                                    }
                                } else {
                                    com.byazt.hs.i iVar4 = this.f2952a;
                                    if (iVar4 != null) {
                                        iVar4.uj();
                                    }
                                    if (ttVarC != null) {
                                        ttVarC.tt();
                                    }
                                    try {
                                        if (this.my) {
                                            synchronized (this.yp) {
                                                if (!this.u) {
                                                    c(this.x);
                                                    if (this.da != null) {
                                                        x();
                                                    }
                                                }
                                            }
                                        } else {
                                            c(this.x);
                                            if (this.da != null) {
                                                x();
                                            }
                                        }
                                        Closeable[] closeableArr = new Closeable[i3];
                                        closeableArr[c] = this.da;
                                        com.byazt.w.a.c(closeableArr);
                                        this.d = System.nanoTime() - jNanoTime;
                                        cVar = this.gt;
                                        downloadInfo = this.ve;
                                        str = this.uj;
                                        iVar3 = this.f2952a;
                                        z2 = this.t;
                                        boolean z3 = this.u;
                                        r4 = r15 == true ? 1 : 0;
                                        z = z3;
                                        com.byazt.zl.c.c(cVar, downloadInfo, str, iVar3, z2, z, this.sl, this.z - this.m, this.d, r4, this.p, this.md, this.h, null);
                                    } catch (Throwable th6) {
                                        Closeable[] closeableArr2 = new Closeable[i3];
                                        closeableArr2[c] = this.da;
                                        com.byazt.w.a.c(closeableArr2);
                                        throw th6;
                                    }
                                }
                            }
                            com.byazt.hs.i iVar5 = this.f2952a;
                            if (iVar5 != null) {
                                iVar5.uj();
                            }
                            if (ttVarC != null) {
                                ttVarC.tt();
                            }
                            try {
                                if (this.my) {
                                    synchronized (this.yp) {
                                        if (!this.u) {
                                            c(this.x);
                                            if (this.da != null) {
                                                x();
                                            }
                                        }
                                    }
                                } else {
                                    c(this.x);
                                    if (this.da != null) {
                                        x();
                                    }
                                }
                                com.byazt.w.a.c(this.da);
                                r6 = C;
                            } catch (Throwable th7) {
                                com.byazt.w.a.c(this.da);
                                throw th7;
                            }
                        } catch (BaseException e5) {
                            e = e5;
                            j2 = jNanoTime;
                            C = r15;
                        } catch (Throwable th8) {
                            th = th8;
                            j = jT;
                            j2 = jNanoTime;
                            C = r15;
                        }
                        this.d = System.nanoTime() - j2;
                        com.byazt.zl.c.c(this.gt, this.ve, this.uj, this.f2952a, this.t, this.u, this.sl, this.z - this.m, this.d, r6, this.p, this.md, this.h, null);
                        if (this.ve.isIgnoreDataVerify()) {
                            return;
                        }
                        j3 = this.z - this.m;
                        if (j3 < 0 && this.rh >= 0 && this.rh != j3) {
                            throw new BaseException(1051, String.format("handle data length[%d] != content length[%d] downloadChunkContentLen[%d], range[%d, %d) , current offset[%d] , handle start from %d", Long.valueOf(j3), Long.valueOf(jC), Long.valueOf(this.rh), Long.valueOf(j), Long.valueOf(this.nu), Long.valueOf(this.z), Long.valueOf(this.m)));
                        }
                        return;
                    } catch (IOException e6) {
                        throw new BaseException(1054, e6);
                    }
                } catch (BaseException e7) {
                    e = e7;
                    ttVarC = null;
                } catch (Throwable th9) {
                    th = th9;
                    ttVarC = null;
                    com.byazt.x.c.uj(tt, "handleResponse: e = ".concat(String.valueOf(th)));
                    if (a()) {
                        iVar2 = this.f2952a;
                        if (iVar2 != null) {
                            iVar2.uj();
                        }
                        if (ttVarC != null) {
                            ttVarC.tt();
                        }
                        if (this.my) {
                            synchronized (this.yp) {
                                if (!this.u) {
                                    c(this.x);
                                    if (this.da != null) {
                                        x();
                                    }
                                }
                            }
                        } else {
                            c(this.x);
                            if (this.da != null) {
                                x();
                            }
                        }
                        com.byazt.w.a.c(this.da);
                        r5 = C;
                        this.d = System.nanoTime() - j2;
                        cVar = this.gt;
                        downloadInfo = this.ve;
                        str = this.uj;
                        iVar3 = this.f2952a;
                        z2 = this.t;
                        z = this.u;
                        r4 = r5;
                        com.byazt.zl.c.c(cVar, downloadInfo, str, iVar3, z2, z, this.sl, this.z - this.m, this.d, r4, this.p, this.md, this.h, null);
                    }
                    if (com.byazt.x.c.c()) {
                        com.byazt.nr.m.c(th);
                    }
                    com.byazt.w.a.c(th, "ResponseHandler");
                    iVar = this.f2952a;
                    if (iVar != null) {
                        iVar.uj();
                    }
                    if (ttVarC != null) {
                        ttVarC.tt();
                    }
                    if (this.my) {
                        synchronized (this.yp) {
                            if (!this.u) {
                                c(this.x);
                                if (this.da != null) {
                                    x();
                                }
                            }
                        }
                    } else {
                        c(this.x);
                        if (this.da != null) {
                            x();
                        }
                    }
                    com.byazt.w.a.c(this.da);
                    r6 = C;
                    this.d = System.nanoTime() - j2;
                    com.byazt.zl.c.c(this.gt, this.ve, this.uj, this.f2952a, this.t, this.u, this.sl, this.z - this.m, this.d, r6, this.p, this.md, this.h, null);
                    if (this.ve.isIgnoreDataVerify()) {
                        return;
                    }
                    j3 = this.z - this.m;
                    if (j3 < 0) {
                        return;
                    } else {
                        return;
                    }
                }
            } catch (Throwable th10) {
                com.byazt.hs.i iVar6 = this.f2952a;
                if (iVar6 != null) {
                    iVar6.uj();
                }
                if (ttVarC != null) {
                    ttVarC.tt();
                }
                try {
                    if (this.my) {
                        synchronized (this.yp) {
                            if (!this.u) {
                                c(this.x);
                                if (this.da != null) {
                                    x();
                                }
                            }
                        }
                    } else {
                        c(this.x);
                        if (this.da != null) {
                            x();
                        }
                    }
                    com.byazt.w.a.c(this.da);
                    this.d = System.nanoTime() - j2;
                    com.byazt.zl.c.c(this.gt, this.ve, this.uj, this.f2952a, this.t, this.u, this.sl, this.z - this.m, this.d, C, this.p, this.md, this.h, null);
                    throw th10;
                } catch (Throwable th11) {
                    com.byazt.w.a.c(this.da);
                    throw th11;
                }
            }
        } catch (BaseException e8) {
            e = e8;
            j2 = jNanoTime;
            C = r15 == true ? 1 : 0;
        } catch (Throwable th12) {
            th = th12;
            j = jT;
            j2 = jNanoTime;
            C = r15 == true ? 1 : 0;
        }
        ttVarC = null;
        com.byazt.x.c.uj(tt, "handleResponse: BaseException e = ".concat(String.valueOf(e)));
        if (!this.gt.c("ignore_base_ex_on_stop_status") || !a()) {
            if (com.byazt.x.c.c()) {
                com.byazt.nr.m.c(e);
            }
            this.sl = e;
            throw e;
        }
        com.byazt.hs.i iVar7 = this.f2952a;
        if (iVar7 != null) {
            iVar7.uj();
        }
        if (ttVarC != null) {
            ttVarC.tt();
        }
        try {
            if (this.my) {
                synchronized (this.yp) {
                    if (!this.u) {
                        c(this.x);
                        if (this.da != null) {
                            x();
                        }
                    }
                }
            } else {
                c(this.x);
                if (this.da != null) {
                    x();
                }
            }
            com.byazt.w.a.c(this.da);
            r5 = C;
            this.d = System.nanoTime() - j2;
            cVar = this.gt;
            downloadInfo = this.ve;
            str = this.uj;
            iVar3 = this.f2952a;
            z2 = this.t;
            z = this.u;
            r4 = r5;
            com.byazt.zl.c.c(cVar, downloadInfo, str, iVar3, z2, z, this.sl, this.z - this.m, this.d, r4, this.p, this.md, this.h, null);
        } catch (Throwable th13) {
            com.byazt.w.a.c(this.da);
            throw th13;
        }
    }

    private com.byazt.ty.tt c(InputStream inputStream) {
        int iQp = ve.qp();
        if (this.gt.c("rw_concurrent", 0) == 1 && this.ve.getChunkCount() == 1 && this.ve.getTotalBytes() > 20971520) {
            try {
                com.byazt.ty.c cVar = new com.byazt.ty.c(inputStream, iQp, this.gt.c("rw_concurrent_max_buffer_count", 4));
                this.yv = true;
                return cVar;
            } catch (Throwable th) {
                com.byazt.nr.m.c(th);
            }
        }
        com.byazt.ty.ve veVar = new com.byazt.ty.ve(inputStream, iQp);
        this.yv = false;
        return veVar;
    }

    private void c(boolean z) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        long j = jUptimeMillis - this.zb;
        if (this.qy) {
            if (j <= (this.rl.tt() ? this.gu : this.gr)) {
                return;
            }
        } else {
            long j2 = this.z - this.eo;
            if (!z && !tt(j2, j)) {
                return;
            }
        }
        x();
        this.zb = jUptimeMillis;
    }

    private void x() {
        long jNanoTime = this.zm ? System.nanoTime() : 0L;
        try {
            this.da.c();
            this.ve.updateRealDownloadTime(true);
            boolean z = this.ve.getChunkCount() > 1;
            u uVarC = com.byazt.b.t.c(com.byazt.w.a.tt());
            if (z) {
                c(this.i);
                if (uVarC != null) {
                    uVarC.ve(this.ve);
                } else {
                    this.i.c(this.ve.getId(), this.ve.getCurBytes());
                }
            } else if (uVarC != null) {
                uVarC.ve(this.ve);
            } else {
                this.i.c(this.n.sl(), this.z);
            }
            this.eo = this.z;
        } catch (Exception unused) {
        }
        if (this.zm) {
            this.h += System.nanoTime() - jNanoTime;
        }
    }

    private void c(da daVar) {
        u uVarC;
        if (daVar == null) {
            return;
        }
        boolean z = daVar instanceof com.byazt.wh.n;
        if (z) {
            uVarC = com.byazt.b.t.c(com.byazt.w.a.tt());
            if (uVarC == null) {
                return;
            }
        } else {
            uVarC = null;
        }
        u uVar = uVarC;
        com.byazt.t.tt ttVarN = this.n.uj() ? this.n.n() : this.n;
        if (ttVarN != null) {
            ttVarN.tt(this.z);
            if (z && uVar != null) {
                uVar.c(ttVarN.sl(), ttVarN.my(), ttVarN.tt(), this.z);
            } else {
                daVar.c(ttVarN.sl(), ttVarN.my(), ttVarN.tt(), this.z);
            }
            if (ttVarN.x()) {
                if (ttVarN.i()) {
                    long jDa = ttVarN.da();
                    if (jDa > this.z) {
                        if (z && uVar != null) {
                            uVar.c(ttVarN.sl(), ttVarN.tt(), jDa);
                            return;
                        } else {
                            daVar.c(ttVarN.sl(), ttVarN.tt(), jDa);
                            return;
                        }
                    }
                }
                if (z && uVar != null) {
                    uVar.c(ttVarN.sl(), ttVarN.tt(), this.z);
                    return;
                } else {
                    daVar.c(ttVarN.sl(), ttVarN.tt(), this.z);
                    return;
                }
            }
            return;
        }
        if (this.n.uj()) {
            if (z && uVar != null) {
                uVar.c(this.n.sl(), this.n.my(), this.z);
            } else {
                daVar.c(this.n.sl(), this.n.my(), this.z);
            }
        }
    }
}
