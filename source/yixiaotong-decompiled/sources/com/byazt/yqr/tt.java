package com.byazt.yqr;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.byazt.fk.da;
import com.byazt.fk.u;
import com.byazt.gqp.m;
import com.byazt.gqp.nu;
import com.byazt.gqp.t;
import com.byazt.gqp.yp;
import com.huawei.openalliance.ad.constant.x;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 982, 13})
public class tt {
    public Context c;
    public File n;
    public u tt;
    public File uj;
    public volatile boolean ve = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<da.c> f2895a = new ArrayList();
    public volatile boolean sp = false;

    public u c() {
        return this.tt;
    }

    public void c(boolean z) {
        this.ve = z;
    }

    public tt(Context context, u uVar) {
        this.uj = null;
        this.n = null;
        this.c = context;
        this.tt = uVar;
        this.uj = com.byazt.vv.ve.tt(uVar.getCacheParentDir(), uVar.getFileNameKey());
        this.n = com.byazt.vv.ve.ve(uVar.getCacheParentDir(), uVar.getFileNameKey());
    }

    public void c(da.c cVar) {
        if (this.sp) {
            synchronized (da.c.class) {
                this.f2895a.add(cVar);
            }
            return;
        }
        this.f2895a.add(cVar);
        if (tt()) {
            com.byazt.lt.tt.c("VideoPreload", "Cache file is exist");
            this.tt.setSourceType(1);
            c(this.tt, 200);
            ve.c(this.tt);
            return;
        }
        this.sp = true;
        this.tt.setSourceType(0);
        ve();
    }

    private boolean tt() {
        if (this.n.exists()) {
            return true;
        }
        if (!this.tt.isPreloadAll()) {
            if (this.uj.length() >= this.tt.getPreloadSize()) {
                return true;
            }
            if (this.tt.getPitayaCacheSize() > 0 && this.uj.length() >= this.tt.getPitayaCacheSize()) {
                return true;
            }
        }
        return false;
    }

    private void ve() {
        t.c cVar;
        if (com.byazt.oy.tt.ve() != null) {
            cVar = com.byazt.oy.tt.ve().tt();
        } else {
            cVar = new t.c("v_preload");
        }
        cVar.c(this.tt.getConnectTimeOutMills(), TimeUnit.MILLISECONDS).tt(this.tt.getReadTimeOutMills(), TimeUnit.MILLISECONDS).ve(this.tt.getWriteTimeOutMills(), TimeUnit.MILLISECONDS);
        t tVarC = cVar.c();
        yp.c cVar2 = new yp.c();
        final long length = this.uj.length();
        int preloadSize = this.tt.getPreloadSize();
        boolean zIsPreloadAll = this.tt.isPreloadAll();
        int pitayaCacheSize = this.tt.getPitayaCacheSize();
        if (pitayaCacheSize > 0) {
            if (pitayaCacheSize >= this.tt.getVideoSize()) {
                zIsPreloadAll = true;
            } else {
                preloadSize = pitayaCacheSize;
            }
        }
        if (zIsPreloadAll) {
            cVar2.c("RANGE", "bytes=" + length + x.A).c(this.tt.getUrl()).c().tt();
        } else {
            cVar2.c("RANGE", "bytes=" + length + x.A + preloadSize).c(this.tt.getUrl()).c().tt();
        }
        tVarC.c(cVar2.tt()).c(new com.byazt.gqp.ve() { // from class: com.byazt.yqr.tt.1
            @Override // com.byazt.gqp.ve
            public void onFailure(com.byazt.gqp.tt ttVar, IOException iOException) {
                tt ttVar2 = tt.this;
                ttVar2.c(ttVar2.tt, 601, iOException.getMessage());
                ve.c(tt.this.tt);
            }

            /* JADX WARN: Code duplicated, block: B:70:0x01f4 A[Catch: all -> 0x0234, TryCatch #3 {all -> 0x0234, blocks: (B:68:0x01e4, B:70:0x01f4, B:71:0x01f8), top: B:81:0x01e4 }] */
            @Override // com.byazt.gqp.ve
            public void onResponse(com.byazt.gqp.tt ttVar, m mVar) throws IOException {
                int iVe;
                Closeable closeable;
                RandomAccessFile randomAccessFile;
                nu nuVarA;
                InputStream inputStreamVe;
                long jC;
                long j = length;
                nu nuVar = null;
                if (mVar != null) {
                    try {
                        boolean zUj = mVar.uj();
                        if (zUj) {
                            nu nuVarA2 = mVar.a();
                            try {
                                nuVarA = mVar.a();
                                if (!zUj || nuVarA == null) {
                                    inputStreamVe = null;
                                    jC = 0;
                                } else {
                                    try {
                                        jC = length + nuVarA.c();
                                        inputStreamVe = nuVarA.ve();
                                    } catch (Throwable th) {
                                        th = th;
                                        closeable = null;
                                        inputStreamVe = null;
                                        nuVar = nuVarA;
                                        iVe = 601;
                                        com.byazt.nr.m.c(th);
                                        tt.this.uj();
                                        tt ttVar2 = tt.this;
                                        u uVar = ttVar2.tt;
                                        if (mVar != null) {
                                            iVe = mVar.ve();
                                        }
                                        ttVar2.c(uVar, iVe, th.getMessage());
                                        tt.this.c(closeable);
                                        tt.this.c(inputStreamVe);
                                        tt.this.c(nuVar);
                                        tt.this.c(mVar);
                                        com.byazt.lt.tt.c("VideoPreload", "Pre finally ", tt.this.tt.getUrl(), " Preload size=", Integer.valueOf(tt.this.tt.getPreloadSize()));
                                    }
                                }
                                try {
                                    if (inputStreamVe == null) {
                                        tt ttVar3 = tt.this;
                                        ttVar3.c(ttVar3.tt, mVar.ve(), mVar.n());
                                        tt.this.c((Closeable) null);
                                        tt.this.c(inputStreamVe);
                                        tt.this.c(nuVarA);
                                        tt.this.c(mVar);
                                        com.byazt.lt.tt.c("VideoPreload", "Pre finally ", tt.this.tt.getUrl(), " Preload size=", Integer.valueOf(tt.this.tt.getPreloadSize()));
                                    } else {
                                        try {
                                            randomAccessFile = new RandomAccessFile(tt.this.uj, "rw");
                                            byte[] bArr = new byte[8192];
                                            int i = 0;
                                            long j2 = 0;
                                            while (true) {
                                                int i2 = inputStreamVe.read(bArr, i, 8192 - i);
                                                if (i2 == -1) {
                                                    if (tt.this.tt.isPreloadAll() && jC == tt.this.uj.length()) {
                                                        tt.this.n();
                                                    }
                                                    tt ttVar4 = tt.this;
                                                    ttVar4.c(ttVar4.tt, mVar.ve());
                                                    break;
                                                }
                                                if (tt.this.ve) {
                                                    tt ttVar5 = tt.this;
                                                    ttVar5.tt(ttVar5.tt, mVar.ve());
                                                    tt.this.c(randomAccessFile);
                                                    tt.this.c(inputStreamVe);
                                                    tt.this.c(nuVarA);
                                                    tt.this.c(mVar);
                                                    com.byazt.lt.tt.c("VideoPreload", "Pre finally ", tt.this.tt.getUrl(), " Preload size=", Integer.valueOf(tt.this.tt.getPreloadSize()));
                                                } else {
                                                    i += i2;
                                                    j2 += (long) i2;
                                                    if (j2 % PlaybackStateCompat.ACTION_PLAY_FROM_URI == 0 || j2 == jC - length) {
                                                        com.byazt.vv.ve.c(randomAccessFile, bArr, j, i);
                                                        j += (long) i;
                                                        i = 0;
                                                    }
                                                }
                                            }
                                            tt.this.c(randomAccessFile);
                                            tt.this.c(inputStreamVe);
                                            tt.this.c(nuVarA);
                                            tt.this.c(mVar);
                                            com.byazt.lt.tt.c("VideoPreload", "Pre finally ", tt.this.tt.getUrl(), " Preload size=", Integer.valueOf(tt.this.tt.getPreloadSize()));
                                        } catch (Throwable th2) {
                                            th = th2;
                                            nuVar = nuVarA;
                                            closeable = null;
                                            iVe = 601;
                                            com.byazt.nr.m.c(th);
                                            tt.this.uj();
                                            tt ttVar6 = tt.this;
                                            u uVar2 = ttVar6.tt;
                                            if (mVar != null) {
                                                iVe = mVar.ve();
                                            }
                                            ttVar6.c(uVar2, iVe, th.getMessage());
                                            tt.this.c(closeable);
                                            tt.this.c(inputStreamVe);
                                            tt.this.c(nuVar);
                                            tt.this.c(mVar);
                                            com.byazt.lt.tt.c("VideoPreload", "Pre finally ", tt.this.tt.getUrl(), " Preload size=", Integer.valueOf(tt.this.tt.getPreloadSize()));
                                        }
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    closeable = null;
                                    nuVar = nuVarA;
                                    iVe = 601;
                                    com.byazt.nr.m.c(th);
                                    tt.this.uj();
                                    tt ttVar7 = tt.this;
                                    u uVar3 = ttVar7.tt;
                                    if (mVar != null) {
                                        iVe = mVar.ve();
                                    }
                                    ttVar7.c(uVar3, iVe, th.getMessage());
                                    tt.this.c(closeable);
                                    tt.this.c(inputStreamVe);
                                    tt.this.c(nuVar);
                                    tt.this.c(mVar);
                                    com.byazt.lt.tt.c("VideoPreload", "Pre finally ", tt.this.tt.getUrl(), " Preload size=", Integer.valueOf(tt.this.tt.getPreloadSize()));
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                nuVar = nuVarA2;
                                closeable = null;
                                iVe = 601;
                                inputStreamVe = null;
                                com.byazt.nr.m.c(th);
                                tt.this.uj();
                                tt ttVar8 = tt.this;
                                u uVar4 = ttVar8.tt;
                                if (mVar != null) {
                                    iVe = mVar.ve();
                                }
                                ttVar8.c(uVar4, iVe, th.getMessage());
                                tt.this.c(closeable);
                                tt.this.c(inputStreamVe);
                                tt.this.c(nuVar);
                                tt.this.c(mVar);
                                com.byazt.lt.tt.c("VideoPreload", "Pre finally ", tt.this.tt.getUrl(), " Preload size=", Integer.valueOf(tt.this.tt.getPreloadSize()));
                            }
                        } else {
                            try {
                                tt ttVar9 = tt.this;
                                ttVar9.c(ttVar9.tt, mVar.ve(), mVar.n());
                                tt.this.c((Closeable) null);
                                tt.this.c((Closeable) null);
                                tt.this.c((Closeable) null);
                                tt.this.c(mVar);
                                com.byazt.lt.tt.c("VideoPreload", "Pre finally ", tt.this.tt.getUrl(), " Preload size=", Integer.valueOf(tt.this.tt.getPreloadSize()));
                            } catch (Throwable th5) {
                                th = th5;
                                closeable = null;
                                inputStreamVe = null;
                                iVe = 601;
                                try {
                                    com.byazt.nr.m.c(th);
                                    tt.this.uj();
                                    tt ttVar10 = tt.this;
                                    u uVar5 = ttVar10.tt;
                                    if (mVar != null) {
                                        iVe = mVar.ve();
                                    }
                                    ttVar10.c(uVar5, iVe, th.getMessage());
                                    tt.this.c(closeable);
                                    tt.this.c(inputStreamVe);
                                    tt.this.c(nuVar);
                                    tt.this.c(mVar);
                                    com.byazt.lt.tt.c("VideoPreload", "Pre finally ", tt.this.tt.getUrl(), " Preload size=", Integer.valueOf(tt.this.tt.getPreloadSize()));
                                } finally {
                                    tt.this.c(closeable);
                                    tt.this.c(inputStreamVe);
                                    tt.this.c(nuVar);
                                    tt.this.c(mVar);
                                    com.byazt.lt.tt.c("VideoPreload", "Pre finally ", tt.this.tt.getUrl(), " Preload size=", Integer.valueOf(tt.this.tt.getPreloadSize()));
                                    ve.c(tt.this.tt);
                                }
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        closeable = null;
                        iVe = 601;
                        nuVar = null;
                        inputStreamVe = null;
                        com.byazt.nr.m.c(th);
                        tt.this.uj();
                        tt ttVar11 = tt.this;
                        u uVar6 = ttVar11.tt;
                        if (mVar != null) {
                            iVe = mVar.ve();
                        }
                        ttVar11.c(uVar6, iVe, th.getMessage());
                        tt.this.c(closeable);
                        tt.this.c(inputStreamVe);
                        tt.this.c(nuVar);
                        tt.this.c(mVar);
                        com.byazt.lt.tt.c("VideoPreload", "Pre finally ", tt.this.tt.getUrl(), " Preload size=", Integer.valueOf(tt.this.tt.getPreloadSize()));
                    }
                } else {
                    try {
                        tt ttVar12 = tt.this;
                        iVe = 601;
                        try {
                            ttVar12.c(ttVar12.tt, 601, "Network link failed.");
                            randomAccessFile = null;
                            nuVarA = null;
                            inputStreamVe = null;
                            tt.this.c(randomAccessFile);
                            tt.this.c(inputStreamVe);
                            tt.this.c(nuVarA);
                            tt.this.c(mVar);
                            com.byazt.lt.tt.c("VideoPreload", "Pre finally ", tt.this.tt.getUrl(), " Preload size=", Integer.valueOf(tt.this.tt.getPreloadSize()));
                        } catch (Throwable th7) {
                            th = th7;
                            closeable = null;
                            nuVar = null;
                            inputStreamVe = null;
                            com.byazt.nr.m.c(th);
                            tt.this.uj();
                            tt ttVar13 = tt.this;
                            u uVar7 = ttVar13.tt;
                            if (mVar != null) {
                                iVe = mVar.ve();
                            }
                            ttVar13.c(uVar7, iVe, th.getMessage());
                            tt.this.c(closeable);
                            tt.this.c(inputStreamVe);
                            tt.this.c(nuVar);
                            tt.this.c(mVar);
                            com.byazt.lt.tt.c("VideoPreload", "Pre finally ", tt.this.tt.getUrl(), " Preload size=", Integer.valueOf(tt.this.tt.getPreloadSize()));
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        iVe = 601;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(u uVar, int i) {
        synchronized (da.c.class) {
            for (da.c cVar : this.f2895a) {
                if (cVar != null) {
                    cVar.onVideoPreloadSuccess(uVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(u uVar, int i, String str) {
        synchronized (da.c.class) {
            for (da.c cVar : this.f2895a) {
                if (cVar != null) {
                    cVar.onVideoPreloadFail(uVar, i, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(u uVar, int i) {
        synchronized (da.c.class) {
            for (da.c cVar : this.f2895a) {
                if (cVar != null) {
                    cVar.cancel(uVar, i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj() {
        try {
            this.n.delete();
            this.uj.delete();
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            if (this.uj.renameTo(this.n)) {
            } else {
                throw new IOException("Error renaming file " + this.uj + " to " + this.n + " for completion!");
            }
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
            com.byazt.lt.tt.c("VideoPreload", th.getMessage());
        }
    }
}
