package com.oplus.log.core;

import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.openalliance.ad.constant.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class h extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    i f5808a;
    private boolean f;
    private File g;
    private boolean h;
    private long i;
    private f j;
    private ConcurrentLinkedQueue<e> k;
    private String l;
    private String m;
    private String n;
    private long o;
    private long p;
    private long q;
    private String r;
    private String s;
    private int t;
    private ExecutorService v;
    private final Object b = new Object();
    private final Object c = new Object();
    private volatile boolean e = true;
    private ConcurrentLinkedQueue<e> u = new ConcurrentLinkedQueue<>();
    private final a d = new a();
    private final com.oplus.log.c.a w = new com.oplus.log.c.a();

    h(ConcurrentLinkedQueue<e> concurrentLinkedQueue, String str, String str2, long j, long j2, long j3, String str3, String str4, String str5) {
        this.k = concurrentLinkedQueue;
        this.l = str;
        this.m = str2;
        this.n = str5;
        this.o = j;
        this.p = j2;
        this.q = j3;
        this.r = str3;
        this.s = str4;
    }

    private void a(long j) {
        File[] fileArrListFiles;
        File file = new File(this.m);
        if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : fileArrListFiles) {
            if (file2 != null) {
                try {
                    if (file2.lastModified() <= j) {
                        file2.delete();
                    }
                } catch (Exception e) {
                    if (com.oplus.log.b.c()) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v6, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.io.FileOutputStream] */
    private static boolean a(String str, String str2) throws Throwable {
        ?? r4;
        ?? r5;
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File((String) str));
                try {
                    str = new FileOutputStream(new File(str2));
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int i = fileInputStream2.read(bArr);
                            if (i >= 0) {
                                str.write(bArr, 0, i);
                                str.flush();
                            } else {
                                try {
                                    break;
                                } catch (Exception e) {
                                    if (com.oplus.log.b.c()) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                        fileInputStream2.close();
                        try {
                            str.close();
                        } catch (Exception e2) {
                            if (com.oplus.log.b.c()) {
                                e2.printStackTrace();
                            }
                        }
                        return true;
                    } catch (FileNotFoundException e3) {
                        e = e3;
                        fileInputStream = fileInputStream2;
                        r5 = str;
                        if (com.oplus.log.b.c()) {
                            e.printStackTrace();
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e4) {
                                if (com.oplus.log.b.c()) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                        if (r5 == 0) {
                            return false;
                        }
                        try {
                            r5.close();
                            return false;
                        } catch (Exception e5) {
                            e = e5;
                            if (!com.oplus.log.b.c()) {
                                return false;
                            }
                            e.printStackTrace();
                            return false;
                        }
                    } catch (IOException e6) {
                        e = e6;
                        fileInputStream = fileInputStream2;
                        r4 = str;
                        if (com.oplus.log.b.c()) {
                            e.printStackTrace();
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e7) {
                                if (com.oplus.log.b.c()) {
                                    e7.printStackTrace();
                                }
                            }
                        }
                        if (r4 == 0) {
                            return false;
                        }
                        try {
                            r4.close();
                            return false;
                        } catch (Exception e8) {
                            e = e8;
                            if (!com.oplus.log.b.c()) {
                                return false;
                            }
                            e.printStackTrace();
                            return false;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception e9) {
                                if (com.oplus.log.b.c()) {
                                    e9.printStackTrace();
                                }
                            }
                        }
                        if (str != 0) {
                            try {
                                str.close();
                            } catch (Exception e10) {
                                if (com.oplus.log.b.c()) {
                                    e10.printStackTrace();
                                }
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e11) {
                    e = e11;
                    str = 0;
                } catch (IOException e12) {
                    e = e12;
                    str = 0;
                } catch (Throwable th2) {
                    th = th2;
                    str = 0;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException e13) {
            e = e13;
            r5 = 0;
        } catch (IOException e14) {
            e = e14;
            r4 = 0;
        } catch (Throwable th4) {
            th = th4;
            str = 0;
        }
    }

    private boolean c() {
        try {
            StatFs statFs = new StatFs(this.m);
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > this.q;
        } catch (IllegalArgumentException e) {
            if (!com.oplus.log.b.c()) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public final void a() {
        if (this.f) {
            return;
        }
        synchronized (this.b) {
            this.b.notify();
        }
    }

    public final void b() {
        if (b.b) {
            Log.d("LoganThread", "Logan flush start");
        }
        f fVar = this.j;
        if (fVar != null) {
            fVar.logan_flush();
        }
    }

    /* JADX WARN: Code duplicated, block: B:111:0x028f A[Catch: all -> 0x0298, TryCatch #0 {all -> 0x0298, blocks: (B:76:0x019a, B:78:0x01a0, B:112:0x0296, B:79:0x01a7, B:81:0x01ad, B:82:0x01b4, B:85:0x01be, B:88:0x01c6, B:90:0x01ca, B:91:0x01d1, B:108:0x0287, B:109:0x028b, B:111:0x028f, B:94:0x01dd, B:96:0x0201, B:98:0x0207, B:100:0x0232, B:102:0x025c, B:104:0x0261, B:106:0x0274, B:107:0x027f, B:103:0x025f), top: B:134:0x019a }] */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        super.run();
        while (this.e) {
            synchronized (this.b) {
                this.f = true;
                try {
                    e eVarPoll = this.k.poll();
                    if (eVarPoll == null) {
                        this.f = false;
                        this.b.wait();
                        this.f = true;
                    } else if (eVarPoll != null && eVarPoll.f5805a != 0 && ((eVarPoll.f5805a == e.a.b && eVarPoll.d != null && eVarPoll.d.a()) || ((eVarPoll.f5805a == e.a.f5806a && eVarPoll.c != null && (!TextUtils.isEmpty(eVarPoll.c.c))) || eVarPoll.f5805a == e.a.c))) {
                        if (this.j == null) {
                            f fVar = new f();
                            this.j = fVar;
                            fVar.setOnLoganProtocolStatus(new i() { // from class: com.oplus.log.core.h.1
                                @Override // com.oplus.log.core.i
                                public final void a(String str, int i) {
                                    if (h.this.f5808a != null) {
                                        h.this.f5808a.a(str, i);
                                    }
                                }
                            });
                            this.j.logan_init(this.l, this.m, (int) this.p, this.r, this.s);
                            this.j.logan_debug(b.b);
                        }
                        if (eVarPoll.f5805a == e.a.f5806a) {
                            m mVar = eVarPoll.c;
                            if (b.b) {
                                Log.d("LoganThread", "Logan write start");
                            }
                            if (this.g == null) {
                                this.g = new File(this.m);
                            }
                            a aVar = this.d;
                            Calendar calendar = Calendar.getInstance();
                            calendar.setTimeInMillis(System.currentTimeMillis());
                            if (aVar.f5800a == null || calendar.get(1) != aVar.f5800a.get(1) || calendar.get(6) != aVar.f5800a.get(6) || calendar.get(11) != aVar.f5800a.get(11)) {
                                aVar.f5800a = calendar;
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                a(jCurrentTimeMillis - this.o);
                                f fVar2 = this.j;
                                a aVar2 = this.d;
                                String str = this.n;
                                StringBuilder sb = new StringBuilder();
                                if (!TextUtils.isEmpty(str)) {
                                    sb.append(str);
                                    if (!str.endsWith("_")) {
                                        sb.append("_");
                                    }
                                }
                                String strE = com.oplus.log.d.b.e(com.oplus.log.d.b.a());
                                if (!TextUtils.isEmpty(strE)) {
                                    sb.append(strE.replace(".", "_").replace(x.bQ, "_")).append("_");
                                }
                                sb.append(aVar2.b.format(new Date(jCurrentTimeMillis))).append(".dog3");
                                fVar2.logan_open(sb.toString());
                            }
                            if (System.currentTimeMillis() - this.i > 60000) {
                                this.h = c();
                                this.i = System.currentTimeMillis();
                            }
                            if (this.h) {
                                com.oplus.log.c.a aVar3 = this.w;
                                if (aVar3 != null) {
                                    mVar.c = aVar3.a(mVar.f5815a, mVar.c, mVar.b);
                                }
                                this.j.logan_write(mVar.g, mVar.c, mVar.f, mVar.e, mVar.d);
                            }
                        } else if (eVarPoll.f5805a == e.a.b) {
                            if (eVarPoll.d.d != null) {
                                synchronized (this.c) {
                                    try {
                                        if (this.t == 10001) {
                                            this.u.add(eVarPoll);
                                        } else {
                                            j jVar = eVarPoll.d;
                                            if (b.b) {
                                                Log.d("LoganThread", "Logan send start");
                                            }
                                            if (!TextUtils.isEmpty(this.m) && jVar != null && jVar.a()) {
                                                if (b.b) {
                                                    Log.d("LoganThread", "prepare log file");
                                                }
                                                String str2 = jVar.b;
                                                if (!TextUtils.isEmpty(this.m)) {
                                                    File file = new File(this.m + File.separator + str2);
                                                    if (file.exists() && file.isFile()) {
                                                        String str3 = this.m + File.separator + jVar.b;
                                                        if (jVar.b.equals(String.valueOf(l.a()))) {
                                                            b();
                                                            String str4 = this.m + File.separator + jVar.b + ".copy";
                                                            if (a(str3, str4)) {
                                                                jVar.c = str4;
                                                            }
                                                        } else {
                                                            jVar.c = str3;
                                                        }
                                                        jVar.d.f5813a = jVar;
                                                        jVar.d.b = new k.a() { // from class: com.oplus.log.core.h.2
                                                        };
                                                        this.t = 10001;
                                                        if (this.v == null) {
                                                            this.v = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.oplus.log.core.h.3
                                                                @Override // java.util.concurrent.ThreadFactory
                                                                public final Thread newThread(Runnable runnable) {
                                                                    Thread thread = new Thread(Thread.currentThread().getThreadGroup(), runnable, "logan-thread-send-log", 0L);
                                                                    if (thread.isDaemon()) {
                                                                        thread.setDaemon(false);
                                                                    }
                                                                    if (thread.getPriority() != 5) {
                                                                        thread.setPriority(5);
                                                                    }
                                                                    return thread;
                                                                }
                                                            });
                                                        }
                                                        this.v.execute(jVar.d);
                                                    }
                                                    if (b.b) {
                                                        Log.d("LoganThread", "Logan prepare log file failed, can't find log file");
                                                    }
                                                }
                                                jVar.c = "";
                                                if (b.b) {
                                                    Log.d("LoganThread", "Logan prepare log file failed, can't find log file");
                                                }
                                            }
                                        }
                                    } catch (Throwable th) {
                                        throw th;
                                    }
                                }
                            }
                        } else if (eVarPoll.f5805a == e.a.c) {
                            b();
                            if (eVarPoll.b != null) {
                                eVarPoll.b.a();
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    if (com.oplus.log.b.c()) {
                        e.printStackTrace();
                    }
                    this.f = false;
                }
            }
        }
    }
}
