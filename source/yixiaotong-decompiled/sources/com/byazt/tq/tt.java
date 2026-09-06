package com.byazt.tq;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.core.app.NotificationCompat;
import com.byazt.dna.z;
import com.byazt.gqp.m;
import com.byazt.gqp.nu;
import com.byazt.gqp.yp;
import com.byazt.jzl.a;
import com.byazt.ut.uj;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.x;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.SocketTimeoutException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1134, 13})
public class tt implements ve {
    public static final HashMap<String, tt> c = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2753a;
    public RandomAccessFile da;
    public File n;
    public final a sl;
    public tt t;
    public volatile long tt;
    public com.byazt.jzl.tt u;
    public File uj;
    public final Object ve = new Object();
    public volatile long sp = -1;
    public volatile boolean x = false;
    public volatile boolean i = false;
    public AtomicBoolean yp = new AtomicBoolean(false);

    public long c() {
        return this.tt;
    }

    public tt(Context context, com.byazt.jzl.tt ttVar, a aVar) {
        this.tt = -2147483648L;
        this.f2753a = 0L;
        this.da = null;
        this.sl = aVar;
        this.u = ttVar;
        try {
            this.uj = com.byazt.vv.ve.tt(aVar.getCacheParentDir(), aVar.getFileNameKey());
            this.n = com.byazt.vv.ve.ve(aVar.getCacheParentDir(), aVar.getFileNameKey());
            if (sp()) {
                this.da = new RandomAccessFile(this.n, t.k);
            } else {
                this.da = new RandomAccessFile(this.uj, "rw");
            }
            if (sp()) {
                return;
            }
            long length = this.uj.length();
            this.f2753a = length;
            if (length == aVar.getVideoSize() && this.f2753a != 0) {
                boolean zC = com.byazt.lt.c.c(com.byazt.lt.c.c(this.uj), aVar.getFileNameKey());
                aVar.getFileNameKey();
                if (zC) {
                    c(this.f2753a);
                    this.tt = this.f2753a;
                    return;
                }
            }
            if (!uj()) {
                com.byazt.lt.tt.tt("CSJ_MediaDLPlay", "no process lock, no download " + n());
                return;
            }
            synchronized (tt.class) {
                if (a()) {
                    x();
                } else {
                    tt ttVar2 = this.t;
                    if (ttVar2 != null) {
                        this.tt = ttVar2.c();
                    }
                }
            }
        } catch (Throwable unused) {
            com.byazt.lt.tt.tt("CSJ_MediaDLPlay", "Error using file ", aVar.getUrl(), " as disc cache");
        }
    }

    private boolean uj() {
        RandomAccessFile randomAccessFile = this.da;
        if (randomAccessFile == null) {
            return false;
        }
        try {
            FileLock fileLockTryLock = randomAccessFile.getChannel().tryLock();
            if (fileLockTryLock == null) {
                if (fileLockTryLock != null) {
                    try {
                        fileLockTryLock.close();
                    } catch (IOException unused) {
                    }
                }
                return false;
            }
            if (fileLockTryLock == null) {
                return true;
            }
            try {
                fileLockTryLock.close();
                return true;
            } catch (IOException unused2) {
                return true;
            }
        } catch (IOException unused3) {
            return false;
        }
    }

    private String n() {
        a aVar = this.sl;
        return aVar == null ? "" : aVar.getFileNameKey();
    }

    private boolean a() {
        String strN = n();
        synchronized (tt.class) {
            HashMap<String, tt> map = c;
            tt ttVar = map.get(strN);
            this.t = ttVar;
            if (ttVar != null) {
                return false;
            }
            map.put(strN, this);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        String strN = n();
        synchronized (tt.class) {
            try {
                if (z) {
                    c.remove(strN);
                } else {
                    HashMap<String, tt> map = c;
                    if (map.get(strN) == this) {
                        map.remove(strN);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean sp() {
        return this.n.exists() && this.n.length() > 0;
    }

    private void x() {
        com.byazt.gqp.t.c cVar;
        if (com.byazt.oy.tt.ve() != null) {
            cVar = com.byazt.oy.tt.ve().tt();
        } else {
            cVar = new com.byazt.gqp.t.c("v_cache");
        }
        cVar.c(this.sl.getConnectTimeOutMills(), TimeUnit.MILLISECONDS).tt(this.sl.getReadTimeOutMills(), TimeUnit.MILLISECONDS).ve(this.sl.getWriteTimeOutMills(), TimeUnit.MILLISECONDS);
        com.byazt.gqp.t tVarC = cVar.c();
        new Object[]{"RANGE, bytes=", Long.valueOf(this.f2753a), " file hash=", this.sl.getFileNameKey()};
        tVarC.c(new yp.c().c("RANGE", "bytes=" + this.f2753a + x.A).c(this.sl.getUrl()).c().tt()).c(new com.byazt.gqp.ve() { // from class: com.byazt.tq.tt.1
            @Override // com.byazt.gqp.ve
            public void onFailure(com.byazt.gqp.tt ttVar, IOException iOException) {
                tt.this.i = false;
                tt.this.tt = -1L;
                tt.this.c(true);
            }

            /* JADX WARN: Code restructure failed: missing block: B:118:0x025b, code lost:
            
                if (r16 == null) goto L122;
             */
            /* JADX WARN: Code restructure failed: missing block: B:119:0x025d, code lost:
            
                r16.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:120:0x0261, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:122:0x0263, code lost:
            
                if (r7 == null) goto L124;
             */
            /* JADX WARN: Code restructure failed: missing block: B:123:0x0265, code lost:
            
                r7.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:124:0x0268, code lost:
            
                if (r21 == null) goto L126;
             */
            /* JADX WARN: Code restructure failed: missing block: B:125:0x026a, code lost:
            
                r21.close();
             */
            /* JADX WARN: Code restructure failed: missing block: B:126:0x026d, code lost:
            
                r2 = r19.c.uj.length();
             */
            /* JADX WARN: Code restructure failed: missing block: B:127:0x027d, code lost:
            
                if (r19.c.i == false) goto L247;
             */
            /* JADX WARN: Code restructure failed: missing block: B:129:0x0287, code lost:
            
                if (r2 != r19.c.tt) goto L248;
             */
            /* JADX WARN: Code restructure failed: missing block: B:131:0x028d, code lost:
            
                if (r2 <= 0) goto L249;
             */
            /* JADX WARN: Code restructure failed: missing block: B:132:0x028f, code lost:
            
                r0 = r19.c;
                r0.c(r0.tt);
             */
            /* JADX WARN: Code restructure failed: missing block: B:133:0x0298, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:134:0x0299, code lost:
            
                com.byazt.lt.tt.tt("CSJ_MediaDLPlay", "close stream error", r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:135:0x02a0, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:247:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:248:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:249:?, code lost:
            
                return;
             */
            @Override // com.byazt.gqp.ve
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onResponse(com.byazt.gqp.tt ttVar, m mVar) throws IOException {
                nu nuVarA;
                InputStream inputStream;
                if (mVar != null) {
                    InputStream inputStreamVe = null;
                    long j = 0;
                    try {
                        try {
                            tt.this.i = mVar.uj();
                            if (tt.this.i) {
                                nuVarA = mVar.a();
                                if (tt.this.i && nuVarA != null) {
                                    tt.this.tt = nuVarA.c() + tt.this.f2753a;
                                    inputStreamVe = nuVarA.ve();
                                }
                                if (inputStreamVe == null) {
                                    if (inputStreamVe != null) {
                                        try {
                                            inputStreamVe.close();
                                        } catch (Throwable th) {
                                            com.byazt.lt.tt.tt("CSJ_MediaDLPlay", "close stream error", th);
                                            return;
                                        }
                                    }
                                    if (nuVarA != null) {
                                        nuVarA.close();
                                    }
                                    if (mVar != null) {
                                        mVar.close();
                                    }
                                    long length = tt.this.uj.length();
                                    if (tt.this.i && length == tt.this.tt && length > 0) {
                                        tt ttVar2 = tt.this;
                                        ttVar2.c(ttVar2.tt);
                                        return;
                                    }
                                    return;
                                }
                                try {
                                    byte[] bArr = new byte[8192];
                                    long j2 = tt.this.f2753a;
                                    FileChannel channel = tt.this.da.getChannel();
                                    FileDescriptor fd = tt.this.da.getFD();
                                    if (!fd.valid()) {
                                        com.byazt.lt.tt.tt("CSJ_MediaDLPlay", "fd not valid" + tt.this.sl.getFileNameKey());
                                        if (inputStreamVe != null) {
                                            try {
                                                inputStreamVe.close();
                                            } catch (Throwable th2) {
                                                com.byazt.lt.tt.tt("CSJ_MediaDLPlay", "close stream error", th2);
                                                return;
                                            }
                                        }
                                        if (nuVarA != null) {
                                            nuVarA.close();
                                        }
                                        if (mVar != null) {
                                            mVar.close();
                                        }
                                        long length2 = tt.this.uj.length();
                                        if (tt.this.i && length2 == tt.this.tt && length2 > 0) {
                                            tt ttVar3 = tt.this;
                                            ttVar3.c(ttVar3.tt);
                                            return;
                                        }
                                        return;
                                    }
                                    if (!channel.isOpen()) {
                                        com.byazt.lt.tt.tt("CSJ_MediaDLPlay", "channel is closed");
                                        if (inputStreamVe != null) {
                                            try {
                                                inputStreamVe.close();
                                            } catch (Throwable th3) {
                                                com.byazt.lt.tt.tt("CSJ_MediaDLPlay", "close stream error", th3);
                                                return;
                                            }
                                        }
                                        if (nuVarA != null) {
                                            nuVarA.close();
                                        }
                                        if (mVar != null) {
                                            mVar.close();
                                        }
                                        long length3 = tt.this.uj.length();
                                        if (tt.this.i && length3 == tt.this.tt && length3 > 0) {
                                            tt ttVar4 = tt.this;
                                            ttVar4.c(ttVar4.tt);
                                            return;
                                        }
                                        return;
                                    }
                                    long j3 = 0;
                                    loop0: while (true) {
                                        int i = 0;
                                        while (true) {
                                            int i2 = inputStreamVe.read(bArr, i, 8192 - i);
                                            if (i2 == -1) {
                                                InputStream inputStream2 = inputStreamVe;
                                                Object[] objArr = new Object[10];
                                                Long.valueOf(tt.this.f2753a);
                                                Long.valueOf(tt.this.tt);
                                                Long.valueOf(j3);
                                                Boolean.valueOf(j3 == tt.this.tt - tt.this.f2753a);
                                                tt.this.sl.getUrl();
                                                inputStreamVe = inputStream2;
                                                break loop0;
                                            }
                                            i += i2;
                                            inputStream = inputStreamVe;
                                            j3 += (long) i2;
                                            try {
                                                if (j3 % PlaybackStateCompat.ACTION_PLAY_FROM_URI == j || j3 == tt.this.tt - tt.this.f2753a) {
                                                    break;
                                                    break;
                                                }
                                                inputStreamVe = inputStream;
                                            } catch (Throwable th4) {
                                                th = th4;
                                                inputStreamVe = inputStream;
                                            }
                                        }
                                        synchronized (tt.this.ve) {
                                            if (tt.this.x) {
                                                com.byazt.lt.tt.tt("CSJ_MediaDLPlay", "close stream " + tt.this.sl.getFileNameKey());
                                            } else if (com.byazt.vv.ve.c(tt.this.da, bArr, j2, i)) {
                                                j2 += (long) i;
                                            } else {
                                                com.byazt.nr.m.tt("CSJ_MediaDLPlay", "append error, try again：" + j2 + "  offset = " + i + " key= " + tt.this.sl.getFileNameKey() + " fb: " + fd.valid() + " channel " + channel.isOpen());
                                            }
                                        }
                                        if (inputStream != null) {
                                            try {
                                                inputStream.close();
                                            } catch (Throwable th5) {
                                                com.byazt.lt.tt.tt("CSJ_MediaDLPlay", "close stream error", th5);
                                                return;
                                            }
                                        }
                                        if (nuVarA != null) {
                                            nuVarA.close();
                                        }
                                        if (mVar != null) {
                                            mVar.close();
                                        }
                                        long length4 = tt.this.uj.length();
                                        if (tt.this.i && length4 == tt.this.tt && length4 > j) {
                                            tt ttVar5 = tt.this;
                                            ttVar5.c(ttVar5.tt);
                                            return;
                                        }
                                        return;
                                        inputStreamVe = inputStream;
                                        j = 0;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                                try {
                                    tt.this.i = false;
                                    tt ttVar6 = tt.this;
                                    ttVar6.tt = ttVar6.sp;
                                    com.byazt.lt.tt.tt("CSJ_MediaDLPlay", "io error", th);
                                    if (inputStreamVe != null) {
                                        inputStreamVe.close();
                                    }
                                    if (nuVarA != null) {
                                        nuVarA.close();
                                    }
                                    if (mVar != null) {
                                        mVar.close();
                                    }
                                    long length5 = tt.this.uj.length();
                                    if (tt.this.i && length5 == tt.this.tt && length5 > 0) {
                                        tt ttVar7 = tt.this;
                                        ttVar7.c(ttVar7.tt);
                                    }
                                } catch (Throwable th7) {
                                    if (inputStreamVe != null) {
                                        try {
                                            inputStreamVe.close();
                                        } catch (Throwable th8) {
                                            com.byazt.lt.tt.tt("CSJ_MediaDLPlay", "close stream error", th8);
                                            throw th7;
                                        }
                                    }
                                    if (nuVarA != null) {
                                        nuVarA.close();
                                    }
                                    if (mVar != null) {
                                        mVar.close();
                                    }
                                    long length6 = tt.this.uj.length();
                                    if (!tt.this.i || length6 != tt.this.tt || length6 <= 0) {
                                        throw th7;
                                    }
                                    tt ttVar8 = tt.this;
                                    ttVar8.c(ttVar8.tt);
                                    throw th7;
                                }
                            } else {
                                tt.this.i = false;
                                tt ttVar9 = tt.this;
                                ttVar9.tt = ttVar9.sp;
                                nuVarA = null;
                            }
                            if (inputStreamVe != null) {
                                inputStreamVe.close();
                            }
                            if (nuVarA != null) {
                                nuVarA.close();
                            }
                            if (mVar != null) {
                                mVar.close();
                            }
                            long length7 = tt.this.uj.length();
                            if (tt.this.i && length7 == tt.this.tt && length7 > 0) {
                                tt ttVar10 = tt.this;
                                ttVar10.c(ttVar10.tt);
                            }
                        } catch (Throwable th9) {
                            com.byazt.lt.tt.tt("CSJ_MediaDLPlay", "close stream error", th9);
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        nuVarA = null;
                    }
                } else {
                    tt.this.i = false;
                    tt ttVar11 = tt.this;
                    ttVar11.tt = ttVar11.sp;
                }
                tt.this.c(true);
            }
        });
    }

    private void c(long j, long j2, long j3, long j4, boolean z, long j5) {
        z zVar;
        if ((z || this.yp.compareAndSet(false, true)) && (zVar = (z) uj.getService(NotificationCompat.CATEGORY_EVENT)) != null) {
            JSONObject jSONObject = new JSONObject();
            com.byazt.jzl.tt ttVar = this.u;
            if (ttVar != null) {
                jSONObject = ttVar.c();
            }
            try {
                jSONObject.put("totalLength", j);
                jSONObject.put("position", j2);
                jSONObject.put("cacheLength", j3);
                jSONObject.put(HiAnalyticsConstant.HaKey.BI_KEY_WAITTIME, j4);
                a aVar = this.sl;
                if (aVar != null) {
                    jSONObject.put("videoUrl", aVar.getUrl());
                }
                jSONObject.put("startSaveLength", j5);
            } catch (Exception unused) {
            }
            zVar.onExceptionEvent("video_wait", jSONObject, null);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:? -> B:36:0x009b). Please report as a decompilation issue!!! */
    @Override // com.byazt.tq.ve
    public int c(long j, byte[] bArr, int i, int i2) throws IOException {
        long j2;
        try {
            if (j == this.tt) {
                return -1;
            }
            int i3 = 0;
            int i4 = 0;
            long j3 = -1;
            while (!this.x) {
                Object obj = this.ve;
                synchronized (obj) {
                    try {
                        long jI = i();
                        j2 = j3 == -1 ? jI : j3;
                        try {
                            if (j < jI) {
                                this.da.seek(j);
                                i4 = this.da.read(bArr, i, i2);
                            } else {
                                Object[] objArr = new Object[4];
                                Long.valueOf(j);
                                Long.valueOf(jI);
                                i3 += 33;
                                this.ve.wait(33L);
                                if (i3 >= 4000) {
                                    c(this.tt, j, jI, i3, false, j2);
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        obj = obj;
                        throw th;
                    }
                }
                if (i4 > 0) {
                    return i4;
                }
                if (i3 >= 10000) {
                    c(this.tt, j, i(), i3, true, j2);
                    throw new SocketTimeoutException();
                }
                j3 = j2;
            }
            return -1;
        } catch (Throwable th3) {
            if (th3 instanceof IOException) {
                throw th3;
            }
            throw new IOException();
        }
    }

    @Override // com.byazt.tq.ve
    public void tt() {
        try {
            if (!this.x) {
                this.da.close();
            }
            File file = this.uj;
            if (file != null) {
                file.setLastModified(System.currentTimeMillis());
            }
            File file2 = this.n;
            if (file2 != null) {
                file2.setLastModified(System.currentTimeMillis());
            }
        } catch (Throwable th) {
            try {
                com.byazt.lt.tt.tt("CSJ_MediaDLPlay", "close error", th);
            } catch (Throwable th2) {
                c(false);
                throw th2;
            }
        }
        c(false);
        synchronized (this.ve) {
            this.x = true;
        }
    }

    private long i() {
        if (sp()) {
            return this.n.length();
        }
        return this.uj.length();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j) throws IOException {
        synchronized (this.ve) {
            if (this.n.exists() && this.n.length() >= j) {
                Object[] objArr = new Object[3];
                this.sl.getUrl();
                this.sl.getFileNameKey();
                return;
            }
            try {
                if (!this.uj.renameTo(this.n)) {
                    throw new IOException("Error renaming file " + this.uj + " to " + this.n + " for completion!");
                }
                RandomAccessFile randomAccessFile = this.da;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                if (!this.x) {
                    this.da = new RandomAccessFile(this.n, "rw");
                }
                Object[] objArr2 = new Object[3];
                this.sl.getFileNameKey();
                this.sl.getUrl();
            } catch (Throwable th) {
                com.byazt.lt.tt.tt("CSJ_MediaDLPlay", "complete error", th);
            }
        }
    }

    @Override // com.byazt.tq.ve
    public long ve() throws IOException {
        if (sp()) {
            this.tt = this.n.length();
        } else {
            synchronized (this.ve) {
                int i = 0;
                do {
                    if (this.tt == -2147483648L) {
                        try {
                            tt ttVar = this.t;
                            if (ttVar != null) {
                                this.tt = ttVar.c();
                            }
                            i += 15;
                            this.ve.wait(5L);
                        } catch (InterruptedException e) {
                            com.byazt.nr.m.c(e);
                            throw new IOException("total length InterruptException");
                        }
                    }
                } while (i <= 10000);
                return -1L;
            }
        }
        com.byazt.lt.tt.c("CSJ_MediaDLPlay", "totalLength= ", Long.valueOf(this.tt));
        return this.tt;
    }
}
