package com.opos.mobad.l.a;

import android.content.Context;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7117a;
    private com.opos.mobad.l.a b;
    private long c;
    private long d;
    private CountDownLatch e;
    private boolean f = false;
    private long g;
    private int h;

    protected class a {
        private RandomAccessFile b;

        public a(File file, long j) {
            if (file == null || -1 == j) {
                return;
            }
            com.opos.cmn.an.f.a.b("DownloadThread", "seekPos=" + j);
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                if (!file.exists()) {
                    file.createNewFile();
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                this.b = randomAccessFile;
                randomAccessFile.seek(j);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("DownloadThread", "", (Throwable) e);
            }
        }

        public synchronized int a(byte[] bArr, int i, int i2) {
            RandomAccessFile randomAccessFile = this.b;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.write(bArr, i, i2);
                } catch (IOException e) {
                    com.opos.cmn.an.f.a.a("DownloadThread", "", (Throwable) e);
                    i2 = -1;
                    return i2;
                }
            } else {
                i2 = -1;
            }
            return i2;
        }

        public synchronized void a() {
            RandomAccessFile randomAccessFile = this.b;
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    com.opos.cmn.an.f.a.a("DownloadThread", "", (Throwable) e);
                }
            }
        }
    }

    public c(Context context, com.opos.mobad.l.a aVar, long j, long j2, long j3, CountDownLatch countDownLatch) {
        this.h = -1;
        this.f7117a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.b = aVar;
        this.g = j;
        this.c = j2;
        this.d = j3;
        this.e = countDownLatch;
        this.h = hashCode();
    }

    public long a() {
        return this.c;
    }

    public long b() {
        return this.d;
    }

    public boolean c() {
        return this.f;
    }

    /* JADX WARN: Code duplicated, block: B:41:0x0183 A[Catch: all -> 0x01eb, Exception -> 0x01ed, PHI: r5
  0x0183: PHI (r5v15 com.opos.cmn.func.a.a.e) = (r5v14 com.opos.cmn.func.a.a.e), (r5v16 com.opos.cmn.func.a.a.e) binds: [B:47:0x018d, B:40:0x0181] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x01ed, blocks: (B:3:0x003a, B:5:0x0045, B:7:0x0052, B:8:0x005b, B:41:0x0183, B:50:0x0192, B:51:0x0195, B:52:0x0196, B:54:0x01cd, B:55:0x01d2, B:56:0x01d5, B:60:0x01df, B:61:0x01e5), top: B:73:0x003a, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x01cd A[Catch: all -> 0x01eb, Exception -> 0x01ed, TryCatch #1 {Exception -> 0x01ed, blocks: (B:3:0x003a, B:5:0x0045, B:7:0x0052, B:8:0x005b, B:41:0x0183, B:50:0x0192, B:51:0x0195, B:52:0x0196, B:54:0x01cd, B:55:0x01d2, B:56:0x01d5, B:60:0x01df, B:61:0x01e5), top: B:73:0x003a, outer: #4 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x01d5 A[Catch: all -> 0x01eb, Exception -> 0x01ed, TryCatch #1 {Exception -> 0x01ed, blocks: (B:3:0x003a, B:5:0x0045, B:7:0x0052, B:8:0x005b, B:41:0x0183, B:50:0x0192, B:51:0x0195, B:52:0x0196, B:54:0x01cd, B:55:0x01d2, B:56:0x01d5, B:60:0x01df, B:61:0x01e5), top: B:73:0x003a, outer: #4 }] */
    @Override // java.lang.Runnable
    public void run() {
        long j;
        long j2;
        long j3;
        String str;
        com.opos.cmn.an.f.a.b("DownloadThread", "start. threadId=" + this.h + " ,startPos=" + this.c + ",endPos=" + this.d);
        try {
            try {
                if (this.d + 1 > this.c) {
                    HashMap map = new HashMap();
                    if (this.b.f7114a.c != null) {
                        map.putAll(this.b.f7114a.c);
                    }
                    String str2 = "bytes=" + this.c + x.A + this.d;
                    com.opos.cmn.an.f.a.b("DownloadThread", "rangeProperty=" + str2);
                    map.put("Range", str2);
                    com.opos.cmn.func.a.a.e eVarA = null;
                    try {
                        try {
                            eVarA = com.opos.cmn.func.a.a.b.a().a(this.f7117a, new com.opos.cmn.func.a.a.d.a().b(this.b.f7114a.b).a(map).a(this.b.f7114a.f6075a).a(this.b.f7114a.d).a());
                            if (eVarA != null) {
                                com.opos.cmn.an.f.a.b("DownloadThread", "httpResponseEntity.getResponseCode()=" + eVarA.f6077a);
                                if (206 == eVarA.f6077a || 200 == eVarA.f6077a) {
                                    InputStream inputStream = eVarA.c;
                                    if (inputStream != null) {
                                        a aVar = new a(d.b(this.f7117a, this.b), this.c);
                                        byte[] bArr = new byte[4096];
                                        while (true) {
                                            try {
                                                int i = inputStream.read(bArr);
                                                if (-1 == i || this.c >= this.d) {
                                                    break;
                                                }
                                                int iA = aVar.a(bArr, 0, i);
                                                com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.h + ", pro=" + iA);
                                                this.c += (long) iA;
                                                com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.h + " ,startPos=" + this.c);
                                            } catch (Throwable th) {
                                                try {
                                                    com.opos.cmn.an.f.a.a("DownloadThread", "", th);
                                                } catch (Throwable th2) {
                                                    aVar.a();
                                                    throw th2;
                                                }
                                            }
                                        }
                                        aVar.a();
                                    } else {
                                        str = "InputStream is null.";
                                    }
                                    if (eVarA != null) {
                                        eVarA.a();
                                    }
                                } else {
                                    str = "httpResponseEntity.getResponseCode()=" + eVarA.f6077a;
                                }
                            } else {
                                str = "httpResponseEntity is null.";
                            }
                            com.opos.cmn.an.f.a.b("DownloadThread", str);
                            if (eVarA != null) {
                                eVarA.a();
                            }
                        } catch (Exception e) {
                            com.opos.cmn.an.f.a.a("DownloadThread", "", (Throwable) e);
                            if (0 != 0) {
                            }
                            com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.h + " ,startPos=" + this.c + ",endPos=" + this.d);
                            j = this.d;
                            j2 = j + 1;
                            j3 = this.c;
                            if (j2 != j3) {
                                com.opos.cmn.an.f.a.b("DownloadThread", "start=endPos+1,download success.");
                            } else {
                                if (this.g == j) {
                                }
                                com.opos.cmn.an.f.a.b("DownloadThread", "start!=endPos,download fail.");
                            }
                            this.f = true;
                        }
                    } catch (Throwable th3) {
                        if (0 != 0) {
                            eVarA.a();
                        }
                        throw th3;
                    }
                }
                com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.h + " ,startPos=" + this.c + ",endPos=" + this.d);
                j = this.d;
                j2 = j + 1;
                j3 = this.c;
                if (j2 != j3) {
                    if (this.g == j || j != j3) {
                        com.opos.cmn.an.f.a.b("DownloadThread", "start!=endPos,download fail.");
                    } else {
                        com.opos.cmn.an.f.a.b("DownloadThread", "start=endPos=contentLength,download success.");
                    }
                    this.e.countDown();
                    com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.h + " end.");
                }
                com.opos.cmn.an.f.a.b("DownloadThread", "start=endPos+1,download success.");
                this.f = true;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("DownloadThread", "DownloadThread run", (Throwable) e2);
            }
            this.e.countDown();
            com.opos.cmn.an.f.a.b("DownloadThread", "threadId=" + this.h + " end.");
        } catch (Throwable th4) {
            this.e.countDown();
            throw th4;
        }
    }
}
