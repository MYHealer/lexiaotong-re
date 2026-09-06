package com.opos.mobad.l.a;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f7116a;
    private int b;
    private c[] c;
    private volatile boolean d = false;

    public b(File file, int i, c[] cVarArr) {
        setName("download_monitor_" + file.getName());
        setPriority(5);
        this.f7116a = file;
        this.b = i;
        this.c = cVarArr;
    }

    private void a(File file, int i, c[] cVarArr) {
        com.opos.cmn.an.f.a.b("DownloadMonitorThread", "writePosInfoToFile start");
        if (file != null && cVarArr != null && cVarArr.length > 0) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);
                    try {
                        dataOutputStream.writeInt(i);
                        for (int i2 = 0; i2 < cVarArr.length; i2++) {
                            dataOutputStream.writeLong(cVarArr[i2].a());
                            dataOutputStream.writeLong(cVarArr[i2].b());
                        }
                        dataOutputStream.close();
                        fileOutputStream.close();
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            try {
                                dataOutputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    try {
                        throw th4;
                    } catch (Throwable th5) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable th6) {
                            th4.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("DownloadMonitorThread", "writePosInfoToFile", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("DownloadMonitorThread", "writePosInfoToFile end");
    }

    public void a() {
        this.d = true;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        StringBuilder sb;
        com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread start running.");
        e eVar = new e(this.f7116a);
        try {
            try {
                if (eVar.a()) {
                    while (!this.d) {
                        a(this.f7116a, this.b, this.c);
                        try {
                            sleep(500L);
                        } catch (InterruptedException e) {
                            com.opos.cmn.an.f.a.b("DownloadMonitorThread", "", e);
                        }
                    }
                }
                com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread end running.");
                eVar.b();
                sb = new StringBuilder("posInfoFile releaseFileLock success.");
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("DownloadMonitorThread", "DownloadMonitorThread run", (Throwable) e2);
                com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread end running.");
                eVar.b();
                sb = new StringBuilder("posInfoFile releaseFileLock success.");
            }
            StringBuilder sbAppend = sb.append(this.f7116a);
        } finally {
            com.opos.cmn.an.f.a.b("DownloadMonitorThread", "DownloadMonitorThread end running.");
            eVar.b();
            com.opos.cmn.an.f.a.b("DownloadMonitorThread", "posInfoFile releaseFileLock success." + this.f7116a);
        }
    }
}
