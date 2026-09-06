package com.opos.mobad.l.a;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RandomAccessFile f7119a;
    private FileChannel b;
    private FileLock c;

    public e(File file) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f7119a = randomAccessFile;
            this.b = randomAccessFile.getChannel();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("FileLockEngine", "FileLockEngine", (Throwable) e);
        }
    }

    public e(String str) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
            this.f7119a = randomAccessFile;
            this.b = randomAccessFile.getChannel();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("FileLockEngine", "FileLockEngine", (Throwable) e);
        }
    }

    @Override // com.opos.mobad.l.a.f
    public boolean a() {
        boolean z;
        FileChannel fileChannel = this.b;
        if (fileChannel != null) {
            try {
                this.c = fileChannel.lock();
                z = true;
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("FileLockEngine", "acquireFileLock", (Throwable) e);
                z = false;
            }
        } else {
            z = false;
        }
        com.opos.cmn.an.f.a.b("FileLockEngine", "acquireFileLock result=" + z);
        return z;
    }

    @Override // com.opos.mobad.l.a.f
    public void b() {
        try {
            FileLock fileLock = this.c;
            if (fileLock != null) {
                fileLock.release();
            }
            FileChannel fileChannel = this.b;
            if (fileChannel != null) {
                fileChannel.close();
            }
            RandomAccessFile randomAccessFile = this.f7119a;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("FileLockEngine", "releaseFileLock", (Throwable) e);
        }
    }
}
