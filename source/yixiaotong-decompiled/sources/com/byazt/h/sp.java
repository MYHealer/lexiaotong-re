package com.byazt.h;

import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import com.byazt.m.BaseException;
import com.byazt.t.DownloadInfo;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY})
public class sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.byazt.u.a f2281a;
    public final boolean m;
    public final com.byazt.k.c n;
    public long nu;
    public final ve sp;
    public final boolean u;
    public final DownloadInfo ve;
    public BaseException x;
    public final long yp;
    public final long z;
    public final List<t> c = new LinkedList();
    public final List<t> tt = new ArrayList();
    public volatile boolean i = false;
    public volatile boolean da = false;
    public volatile boolean sl = false;
    public volatile long rh = 0;
    public volatile long my = 0;
    public final com.byazt.zz.da uj = com.byazt.zz.ve.zm();
    public final com.byazt.g.c t = com.byazt.g.c.c();

    private boolean c(long j, long j2) {
        return j > PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH && j2 > 500;
    }

    public void c() {
        this.sl = true;
        this.i = true;
    }

    public void tt() {
        this.da = true;
        this.i = true;
    }

    public sp(DownloadInfo downloadInfo, com.byazt.u.a aVar, ve veVar) {
        this.ve = downloadInfo;
        this.f2281a = aVar;
        this.sp = veVar;
        com.byazt.k.c cVarC = com.byazt.k.c.c(downloadInfo.getId());
        this.n = cVarC;
        boolean z = cVarC.c("sync_strategy", 0) == 1;
        this.u = z;
        if (z) {
            long jC = cVarC.c("sync_interval_ms_fg", 5000);
            long jC2 = cVarC.c("sync_interval_ms_bg", 1000);
            this.yp = Math.max(jC, 500L);
            this.z = Math.max(jC2, 500L);
        } else {
            this.yp = 0L;
            this.z = 0L;
        }
        this.m = cVarC.tt("monitor_rw") == 1;
    }

    public void c(t tVar) {
        synchronized (this) {
            this.c.add(tVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:120:0x0197 A[Catch: all -> 0x033d, TryCatch #16 {all -> 0x033d, blocks: (B:118:0x0193, B:120:0x0197, B:123:0x019d, B:125:0x01a3, B:126:0x01a6, B:127:0x01b5, B:160:0x022a, B:161:0x022c, B:196:0x02a1, B:198:0x02ab, B:200:0x02af, B:233:0x0322, B:235:0x0328, B:236:0x032b, B:237:0x033c), top: B:302:0x0024, inners: #10 }] */
    /* JADX WARN: Code duplicated, block: B:125:0x01a3 A[Catch: all -> 0x033d, TryCatch #16 {all -> 0x033d, blocks: (B:118:0x0193, B:120:0x0197, B:123:0x019d, B:125:0x01a3, B:126:0x01a6, B:127:0x01b5, B:160:0x022a, B:161:0x022c, B:196:0x02a1, B:198:0x02ab, B:200:0x02af, B:233:0x0322, B:235:0x0328, B:236:0x032b, B:237:0x033c), top: B:302:0x0024, inners: #10 }] */
    /* JADX WARN: Code duplicated, block: B:129:0x01bc  */
    /* JADX WARN: Code duplicated, block: B:143:0x020e  */
    /* JADX WARN: Code duplicated, block: B:155:0x0225 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x0038 A[Catch: all -> 0x017b, BaseException -> 0x0181, m -> 0x0188, TRY_LEAVE, TryCatch #34 {m -> 0x0188, BaseException -> 0x0181, all -> 0x017b, blocks: (B:12:0x002e, B:13:0x0032, B:15:0x0038), top: B:329:0x002e }] */
    /* JADX WARN: Code duplicated, block: B:163:0x022f  */
    /* JADX WARN: Code duplicated, block: B:177:0x0281  */
    /* JADX WARN: Code duplicated, block: B:189:0x0298 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:198:0x02ab A[Catch: all -> 0x033d, TryCatch #16 {all -> 0x033d, blocks: (B:118:0x0193, B:120:0x0197, B:123:0x019d, B:125:0x01a3, B:126:0x01a6, B:127:0x01b5, B:160:0x022a, B:161:0x022c, B:196:0x02a1, B:198:0x02ab, B:200:0x02af, B:233:0x0322, B:235:0x0328, B:236:0x032b, B:237:0x033c), top: B:302:0x0024, inners: #10 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x0054 A[Catch: all -> 0x0164, BaseException -> 0x016b, m -> 0x0173, TryCatch #29 {m -> 0x0173, BaseException -> 0x016b, all -> 0x0164, blocks: (B:18:0x0042, B:20:0x0047, B:22:0x0054, B:23:0x0059, B:25:0x0060), top: B:335:0x0042 }] */
    /* JADX WARN: Code duplicated, block: B:235:0x0328 A[Catch: all -> 0x033d, TryCatch #16 {all -> 0x033d, blocks: (B:118:0x0193, B:120:0x0197, B:123:0x019d, B:125:0x01a3, B:126:0x01a6, B:127:0x01b5, B:160:0x022a, B:161:0x022c, B:196:0x02a1, B:198:0x02ab, B:200:0x02af, B:233:0x0322, B:235:0x0328, B:236:0x032b, B:237:0x033c), top: B:302:0x0024, inners: #10 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0060 A[Catch: all -> 0x0164, BaseException -> 0x016b, m -> 0x0173, TRY_LEAVE, TryCatch #29 {m -> 0x0173, BaseException -> 0x016b, all -> 0x0164, blocks: (B:18:0x0042, B:20:0x0047, B:22:0x0054, B:23:0x0059, B:25:0x0060), top: B:335:0x0042 }] */
    /* JADX WARN: Code duplicated, block: B:286:0x01dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:300:0x0237 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0071 A[Catch: all -> 0x0152, BaseException -> 0x0159, m -> 0x0161, TryCatch #30 {m -> 0x0161, BaseException -> 0x0159, all -> 0x0152, blocks: (B:28:0x006a, B:30:0x0071, B:32:0x0075, B:35:0x007a, B:71:0x00f8, B:73:0x0104), top: B:333:0x006a }] */
    /* JADX WARN: Code duplicated, block: B:315:0x01c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:323:0x024f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:327:0x02d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:344:0x0052 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:346:0x0047 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:71:0x00f8 A[Catch: all -> 0x0152, BaseException -> 0x0159, m -> 0x0161, TRY_ENTER, TryCatch #30 {m -> 0x0161, BaseException -> 0x0159, all -> 0x0152, blocks: (B:28:0x006a, B:30:0x0071, B:32:0x0075, B:35:0x007a, B:71:0x00f8, B:73:0x0104), top: B:333:0x006a }] */
    public void c(uj ujVar) throws BaseException {
        long j;
        long j2;
        long j3;
        long j4;
        long j5;
        Throwable th;
        int i;
        Throwable th2;
        Throwable th3;
        int i2;
        Throwable th4;
        Throwable th5;
        c cVarC;
        int i3;
        long jUptimeMillis;
        Throwable th6;
        if (this.da || this.sl) {
            return;
        }
        com.byazt.hs.tt.n();
        this.x = null;
        DownloadInfo downloadInfo = this.ve;
        com.byazt.u.a aVar = this.f2281a;
        ve veVar = this.sp;
        long curBytes = downloadInfo.getCurBytes();
        long jNanoTime = System.nanoTime();
        boolean z = this.m;
        long jNanoTime2 = 0;
        try {
            try {
                downloadInfo.updateRealStartDownloadTime();
                long jNanoTime3 = 0;
                long jNanoTime4 = 0;
                long j6 = 0;
                loop0: while (true) {
                    i = 0;
                    while (true) {
                        if (z) {
                            try {
                                jNanoTime3 = System.nanoTime();
                                cVarC = ujVar.c();
                                if (z) {
                                    jNanoTime2 += System.nanoTime() - jNanoTime3;
                                }
                                jNanoTime2 = jNanoTime2;
                                try {
                                    i3 = cVarC.ve;
                                    if (i3 == -1) {
                                        c(cVarC.tt);
                                        veVar.c(cVarC);
                                    } else {
                                        if (z) {
                                            jNanoTime3 = System.nanoTime();
                                        }
                                        cVarC.tt.tt(cVarC);
                                        if (z) {
                                            jNanoTime4 += System.nanoTime() - jNanoTime3;
                                        }
                                        j5 = jNanoTime4;
                                        try {
                                            veVar.c(cVarC);
                                            if (!this.i) {
                                                if (!this.da || this.sl) {
                                                    break loop0;
                                                    break loop0;
                                                }
                                                this.i = false;
                                            }
                                            i += i3;
                                            if (i >= 65536) {
                                                jUptimeMillis = SystemClock.uptimeMillis();
                                                if (jUptimeMillis - j6 > 100) {
                                                    break;
                                                }
                                            }
                                            jNanoTime4 = j5;
                                        } catch (m e) {
                                            e = e;
                                            jNanoTime2 = jNanoTime2;
                                            try {
                                                this.x = e;
                                                throw e;
                                            } catch (Throwable th7) {
                                                th = th7;
                                                j = jNanoTime2;
                                                j2 = j5;
                                            }
                                        } catch (BaseException e2) {
                                            e = e2;
                                            i2 = i;
                                            j3 = jNanoTime2;
                                            j4 = j5;
                                            if (this.n.c("ignore_base_ex_on_stop_status")) {
                                            }
                                            if (com.byazt.x.c.c()) {
                                                com.byazt.nr.m.c(e);
                                            }
                                            com.byazt.x.c.uj("MultiSegmentWriter", "loopAndWrite:  BaseException e = ".concat(String.valueOf(e)));
                                            this.x = e;
                                            throw e;
                                        } catch (Throwable th8) {
                                            th = th8;
                                            i = i;
                                            j = jNanoTime2;
                                            j2 = j5;
                                            if (!this.da) {
                                                if (com.byazt.x.c.c()) {
                                                    com.byazt.nr.m.c(th);
                                                }
                                                com.byazt.x.c.uj("MultiSegmentWriter", "loopAndWrite:  e = ".concat(String.valueOf(th)));
                                                try {
                                                    com.byazt.w.a.c(th, "loopAndWrite");
                                                    if (i > 0) {
                                                        try {
                                                            aVar.tt(i);
                                                        } catch (Throwable unused) {
                                                        }
                                                    }
                                                    if (!this.sl) {
                                                        try {
                                                            ve();
                                                        } catch (Throwable th9) {
                                                            th3 = th9;
                                                            com.byazt.x.c.uj("MultiSegmentWriter", "loopAndWrite: finally sync, e = ".concat(String.valueOf(th3)));
                                                            synchronized (this) {
                                                                ve(this.c);
                                                                this.c.clear();
                                                            }
                                                            com.byazt.zl.c.c(this.n, downloadInfo, downloadInfo.getUrl(), null, this.da, this.sl, this.x, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime, z, j, j2, this.nu, null);
                                                            if (th3 != null || this.da || this.sl || this.x != null) {
                                                                return;
                                                            }
                                                            try {
                                                                com.byazt.w.a.c(th3, "loopAndWrite_finally");
                                                                return;
                                                            } catch (BaseException e3) {
                                                                this.x = e3;
                                                                throw e3;
                                                            }
                                                        }
                                                    }
                                                    th3 = null;
                                                    synchronized (this) {
                                                        ve(this.c);
                                                        this.c.clear();
                                                        com.byazt.zl.c.c(this.n, downloadInfo, downloadInfo.getUrl(), null, this.da, this.sl, this.x, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime, z, j, j2, this.nu, null);
                                                        if (th3 != null) {
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                } catch (BaseException e4) {
                                                    this.x = e4;
                                                    throw e4;
                                                }
                                            }
                                            if (i > 0) {
                                                try {
                                                    aVar.tt(i);
                                                } catch (Throwable unused2) {
                                                }
                                            }
                                            if (!this.sl) {
                                                try {
                                                    ve();
                                                } catch (Throwable th10) {
                                                    th2 = th10;
                                                    com.byazt.x.c.uj("MultiSegmentWriter", "loopAndWrite: finally sync, e = ".concat(String.valueOf(th2)));
                                                    synchronized (this) {
                                                        ve(this.c);
                                                        this.c.clear();
                                                    }
                                                    com.byazt.zl.c.c(this.n, downloadInfo, downloadInfo.getUrl(), null, this.da, this.sl, this.x, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime, z, j, j2, this.nu, null);
                                                    if (th2 != null || this.da || this.sl || this.x != null) {
                                                        return;
                                                    }
                                                    try {
                                                        com.byazt.w.a.c(th2, "loopAndWrite_finally");
                                                        return;
                                                    } catch (BaseException e5) {
                                                        this.x = e5;
                                                        throw e5;
                                                    }
                                                }
                                            }
                                            th2 = null;
                                            synchronized (this) {
                                                ve(this.c);
                                                this.c.clear();
                                                com.byazt.zl.c.c(this.n, downloadInfo, downloadInfo.getUrl(), null, this.da, this.sl, this.x, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime, z, j, j2, this.nu, null);
                                                if (th2 != null) {
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                } catch (m e6) {
                                    e = e6;
                                    j5 = jNanoTime4;
                                } catch (BaseException e7) {
                                    e = e7;
                                    i2 = i;
                                    j4 = jNanoTime4;
                                    j3 = jNanoTime2;
                                } catch (Throwable th11) {
                                    th = th11;
                                    i = i;
                                    j2 = jNanoTime4;
                                    j = jNanoTime2;
                                }
                            } catch (m e8) {
                                e = e8;
                                i = i;
                                j5 = jNanoTime4;
                                this.x = e;
                                throw e;
                            } catch (BaseException e9) {
                                e = e9;
                                i2 = i;
                                j4 = jNanoTime4;
                                j3 = jNanoTime2;
                                if (this.n.c("ignore_base_ex_on_stop_status") || !(this.da || this.sl)) {
                                    if (com.byazt.x.c.c()) {
                                        com.byazt.nr.m.c(e);
                                    }
                                    com.byazt.x.c.uj("MultiSegmentWriter", "loopAndWrite:  BaseException e = ".concat(String.valueOf(e)));
                                    this.x = e;
                                    throw e;
                                }
                                if (i2 > 0) {
                                    try {
                                        aVar.tt(i2);
                                    } catch (Throwable unused3) {
                                    }
                                }
                                if (!this.sl) {
                                    try {
                                        ve();
                                    } catch (Throwable th12) {
                                        th4 = th12;
                                        com.byazt.x.c.uj("MultiSegmentWriter", "loopAndWrite: finally sync, e = ".concat(String.valueOf(th4)));
                                        synchronized (this) {
                                            ve(this.c);
                                            this.c.clear();
                                        }
                                        com.byazt.zl.c.c(this.n, downloadInfo, downloadInfo.getUrl(), null, this.da, this.sl, this.x, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime, z, j3, j4, this.nu, null);
                                        if (th4 != null || this.da || this.sl || this.x != null) {
                                            return;
                                        }
                                        try {
                                            com.byazt.w.a.c(th4, "loopAndWrite_finally");
                                            return;
                                        } catch (BaseException e10) {
                                            this.x = e10;
                                            throw e10;
                                        }
                                    }
                                }
                                th4 = null;
                                synchronized (this) {
                                    ve(this.c);
                                    this.c.clear();
                                    com.byazt.zl.c.c(this.n, downloadInfo, downloadInfo.getUrl(), null, this.da, this.sl, this.x, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime, z, j3, j4, this.nu, null);
                                    if (th4 != null) {
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                            } catch (Throwable th13) {
                                th = th13;
                                i = i;
                                j2 = jNanoTime4;
                                j = jNanoTime2;
                                if (!this.da && !this.sl) {
                                    if (com.byazt.x.c.c()) {
                                        com.byazt.nr.m.c(th);
                                    }
                                    com.byazt.x.c.uj("MultiSegmentWriter", "loopAndWrite:  e = ".concat(String.valueOf(th)));
                                    com.byazt.w.a.c(th, "loopAndWrite");
                                    if (i > 0) {
                                        aVar.tt(i);
                                    }
                                    if (!this.sl) {
                                        ve();
                                    }
                                    th3 = null;
                                    synchronized (this) {
                                        ve(this.c);
                                        this.c.clear();
                                        com.byazt.zl.c.c(this.n, downloadInfo, downloadInfo.getUrl(), null, this.da, this.sl, this.x, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime, z, j, j2, this.nu, null);
                                        if (th3 != null) {
                                            return;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                if (i > 0) {
                                    aVar.tt(i);
                                }
                                if (!this.sl) {
                                    ve();
                                }
                                th2 = null;
                                synchronized (this) {
                                    ve(this.c);
                                    this.c.clear();
                                    com.byazt.zl.c.c(this.n, downloadInfo, downloadInfo.getUrl(), null, this.da, this.sl, this.x, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime, z, j, j2, this.nu, null);
                                    if (th2 != null) {
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                            }
                        } else {
                            cVarC = ujVar.c();
                            if (z) {
                                jNanoTime2 += System.nanoTime() - jNanoTime3;
                            }
                            jNanoTime2 = jNanoTime2;
                            i3 = cVarC.ve;
                            if (i3 == -1) {
                                c(cVarC.tt);
                                veVar.c(cVarC);
                            } else {
                                if (z) {
                                    jNanoTime3 = System.nanoTime();
                                }
                                cVarC.tt.tt(cVarC);
                                if (z) {
                                    jNanoTime4 += System.nanoTime() - jNanoTime3;
                                }
                                j5 = jNanoTime4;
                                veVar.c(cVarC);
                                if (!this.i) {
                                    if (!this.da) {
                                        break loop0;
                                    } else {
                                        this.i = false;
                                    }
                                }
                                i += i3;
                                if (i >= 65536) {
                                    jUptimeMillis = SystemClock.uptimeMillis();
                                    if (jUptimeMillis - j6 > 100) {
                                        break;
                                    }
                                }
                                jNanoTime4 = j5;
                            }
                        }
                        if (i > 0) {
                            try {
                                aVar.tt(i);
                            } catch (Throwable unused4) {
                            }
                        }
                        if (!this.sl) {
                            try {
                                ve();
                            } catch (Throwable th14) {
                                com.byazt.x.c.uj("MultiSegmentWriter", "loopAndWrite: finally sync, e = ".concat(String.valueOf(th14)));
                                th5 = th14;
                            }
                        }
                        th5 = null;
                        synchronized (this) {
                            ve(this.c);
                            this.c.clear();
                        }
                        com.byazt.zl.c.c(this.n, downloadInfo, downloadInfo.getUrl(), null, this.da, this.sl, this.x, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime, z, j, j2, this.nu, null);
                        if (th5 == null || this.da || this.sl || this.x != null) {
                            throw th;
                        }
                        try {
                            com.byazt.w.a.c(th5, "loopAndWrite_finally");
                            throw th;
                        } catch (BaseException e11) {
                            this.x = e11;
                            throw e11;
                        }
                    }
                    try {
                        c(jUptimeMillis, aVar.tt(i));
                        if (!com.byazt.hs.tt.c) {
                            if (downloadInfo.isOnlyWifi()) {
                                throw new com.byazt.m.ve();
                            }
                            if (downloadInfo.isDownloadFromReserveWifi() && downloadInfo.isPauseReserveOnWifi()) {
                                throw new com.byazt.m.n();
                            }
                        }
                        j6 = jUptimeMillis;
                        jNanoTime2 = jNanoTime2;
                        jNanoTime4 = j5;
                    } catch (m e12) {
                        e = e12;
                        jNanoTime2 = jNanoTime2;
                        i = 0;
                        this.x = e;
                        throw e;
                    } catch (BaseException e13) {
                        e = e13;
                        j3 = jNanoTime2;
                        j4 = j5;
                        i2 = 0;
                        if (this.n.c("ignore_base_ex_on_stop_status")) {
                        }
                        if (com.byazt.x.c.c()) {
                            com.byazt.nr.m.c(e);
                        }
                        com.byazt.x.c.uj("MultiSegmentWriter", "loopAndWrite:  BaseException e = ".concat(String.valueOf(e)));
                        this.x = e;
                        throw e;
                    } catch (Throwable th15) {
                        th = th15;
                        j = jNanoTime2;
                        j2 = j5;
                        i = 0;
                        if (!this.da) {
                            if (com.byazt.x.c.c()) {
                                com.byazt.nr.m.c(th);
                            }
                            com.byazt.x.c.uj("MultiSegmentWriter", "loopAndWrite:  e = ".concat(String.valueOf(th)));
                            com.byazt.w.a.c(th, "loopAndWrite");
                            if (i > 0) {
                                aVar.tt(i);
                            }
                            if (!this.sl) {
                                ve();
                            }
                            th3 = null;
                            synchronized (this) {
                                ve(this.c);
                                this.c.clear();
                                com.byazt.zl.c.c(this.n, downloadInfo, downloadInfo.getUrl(), null, this.da, this.sl, this.x, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime, z, j, j2, this.nu, null);
                                if (th3 != null) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                        if (i > 0) {
                            aVar.tt(i);
                        }
                        if (!this.sl) {
                            ve();
                        }
                        th2 = null;
                        synchronized (this) {
                            ve(this.c);
                            this.c.clear();
                            com.byazt.zl.c.c(this.n, downloadInfo, downloadInfo.getUrl(), null, this.da, this.sl, this.x, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime, z, j, j2, this.nu, null);
                            if (th2 != null) {
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                }
                if (i > 0) {
                    try {
                        aVar.tt(i);
                    } catch (Throwable unused5) {
                    }
                }
                if (!this.sl) {
                    try {
                        ve();
                    } catch (Throwable th16) {
                        th6 = th16;
                        com.byazt.x.c.uj("MultiSegmentWriter", "loopAndWrite: finally sync, e = ".concat(String.valueOf(th6)));
                    }
                }
                th6 = null;
                synchronized (this) {
                    ve(this.c);
                    this.c.clear();
                }
                com.byazt.zl.c.c(this.n, downloadInfo, downloadInfo.getUrl(), null, this.da, this.sl, this.x, downloadInfo.getCurBytes() - curBytes, System.nanoTime() - jNanoTime, z, jNanoTime2, j5, this.nu, null);
                if (th6 == null || this.da || this.sl || this.x != null) {
                    return;
                }
                try {
                    com.byazt.w.a.c(th6, "loopAndWrite_finally");
                } catch (BaseException e14) {
                    this.x = e14;
                    throw e14;
                }
            } catch (Throwable th17) {
                th = th17;
            }
        } catch (m e15) {
            e = e15;
            j5 = 0;
        } catch (BaseException e16) {
            e = e16;
            j3 = 0;
            j4 = 0;
        } catch (Throwable th18) {
            th = th18;
            j = 0;
            j2 = 0;
        }
    }

    private void c(long j, boolean z) throws IOException {
        long j2 = j - this.my;
        if (this.u) {
            if (j2 <= (this.t.tt() ? this.yp : this.z)) {
                return;
            }
        } else {
            long curBytes = this.ve.getCurBytes() - this.rh;
            if (!z && !c(curBytes, j2)) {
                return;
            }
        }
        ve();
        this.my = j;
    }

    private void c(n nVar) {
        synchronized (this) {
            this.tt.add((t) nVar);
        }
    }

    private void ve() throws IOException {
        boolean z;
        boolean z2 = this.m;
        long jNanoTime = z2 ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.ve;
        com.byazt.zz.da daVar = this.uj;
        List<t> list = this.c;
        List<t> list2 = this.tt;
        Map<Long, i> mapT = daVar.t(downloadInfo.getId());
        if (mapT == null) {
            mapT = new HashMap<>(4);
        }
        synchronized (this) {
            c(list);
            try {
                tt(list);
                z = true;
            } catch (Throwable th) {
                com.byazt.nr.m.c(th);
                z = false;
            }
            c(list, mapT);
            if (list2.size() > 0) {
                ve(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (z) {
            downloadInfo.updateRealDownloadTime(true);
            daVar.c(downloadInfo.getId(), mapT);
            daVar.c(downloadInfo);
            this.rh = downloadInfo.getCurBytes();
        }
        if (z2) {
            this.nu += System.nanoTime() - jNanoTime;
        }
    }

    private void c(List<t> list) throws IOException {
        Iterator<t> it = list.iterator();
        while (it.hasNext()) {
            it.next().tt();
        }
    }

    private void tt(List<t> list) throws IOException {
        Iterator<t> it = list.iterator();
        while (it.hasNext()) {
            it.next().ve();
        }
    }

    private void ve(List<t> list) {
        Iterator<t> it = list.iterator();
        while (it.hasNext()) {
            it.next().uj();
        }
    }

    private void c(List<t> list, Map<Long, i> map) {
        Iterator<t> it = list.iterator();
        while (it.hasNext()) {
            i iVarN = it.next().n();
            i iVar = map.get(Long.valueOf(iVarN.ve()));
            if (iVar == null) {
                map.put(Long.valueOf(iVarN.ve()), new i(iVarN));
            } else {
                iVar.c(iVarN.uj());
                iVar.ve(iVarN.a());
            }
        }
    }
}
