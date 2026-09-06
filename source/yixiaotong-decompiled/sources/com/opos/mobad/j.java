package com.opos.mobad;

import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class j implements com.opos.mobad.d.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RandomAccessFile f7042a;
    private FileChannel b;
    private FileLock c;

    public j(String str) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
            this.f7042a = randomAccessFile;
            this.b = randomAccessFile.getChannel();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("FileLockedEngine", "FileLockEngine", (Throwable) e);
        }
    }

    public static j a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = str + File.separator + "lock.lk";
        a(new File(str2));
        return new j(str2);
    }

    public static void a(File file) {
        if (file == null || file.exists()) {
            return;
        }
        try {
            if (!com.opos.cmn.an.e.b.a.b(com.opos.cmn.an.e.b.a.d(file))) {
                com.opos.cmn.an.e.b.a.c(file);
            }
            file.createNewFile();
        } catch (IOException e) {
            com.opos.cmn.an.f.a.a("FileLockedEngine", "", (Throwable) e);
        }
    }

    public static File b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(str + File.separator + "lock.lk");
    }

    @Override // com.opos.mobad.d.a.b
    public boolean a() {
        boolean z;
        FileChannel fileChannel = this.b;
        if (fileChannel != null) {
            try {
                this.c = fileChannel.lock();
                z = true;
            } catch (OverlappingFileLockException unused) {
                com.opos.cmn.an.f.a.a("FileLockedEngine", "acquireFileLock but has acquire by other thread");
                z = false;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("FileLockedEngine", "acquireFileLock", (Throwable) e);
                z = false;
            }
        } else {
            z = false;
        }
        com.opos.cmn.an.f.a.b("FileLockedEngine", "acquireFileLock result=" + z);
        return z;
    }

    @Override // com.opos.mobad.d.a.b
    public void b() {
        try {
            com.opos.cmn.an.f.a.a("FileLockedEngine", "releaseFileLock");
            FileLock fileLock = this.c;
            if (fileLock != null) {
                fileLock.release();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("FileLockedEngine", "releaseFileLock", (Throwable) e);
        }
        try {
            FileChannel fileChannel = this.b;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("FileLockedEngine", "releasemFileChannel", (Throwable) e2);
        }
        try {
            RandomAccessFile randomAccessFile = this.f7042a;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (Exception e3) {
            com.opos.cmn.an.f.a.a("FileLockedEngine", "releaseRandomAccessFile", (Throwable) e3);
        }
    }
}
