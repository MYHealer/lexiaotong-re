package com.opos.videocache.a;

import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements com.opos.videocache.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public File f8426a;
    private final a b;
    private RandomAccessFile c;

    public b(File file, a aVar) throws com.opos.videocache.g {
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.b = aVar;
            h.a(file.getParentFile());
            boolean zExists = file.exists();
            this.f8426a = zExists ? file : new File(file.getParentFile(), file.getName() + ".download");
            this.c = new RandomAccessFile(this.f8426a, zExists ? t.k : "rw");
        } catch (IOException e) {
            throw new com.opos.videocache.g("Error using file " + file + " as disc cache", e);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.opos.videocache.a
    public synchronized int a(byte[] bArr, long j, int i) {
        try {
            this.c.seek(j);
        } catch (IOException e) {
            throw new com.opos.videocache.g(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(a()), Integer.valueOf(bArr.length)), e);
        }
        return this.c.read(bArr, 0, i);
    }

    @Override // com.opos.videocache.a
    public synchronized long a() {
        try {
        } catch (IOException e) {
            throw new com.opos.videocache.g("Error reading length of file " + this.f8426a, e);
        }
        return (int) this.c.length();
    }

    @Override // com.opos.videocache.a
    public synchronized void a(byte[] bArr, int i) {
        try {
            if (d()) {
                throw new com.opos.videocache.g("Error append cache: cache file " + this.f8426a + " is completed!");
            }
            this.c.seek(a());
            this.c.write(bArr, 0, i);
        } catch (IOException e) {
            throw new com.opos.videocache.g(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.c, Integer.valueOf(bArr.length)), e);
        }
    }

    @Override // com.opos.videocache.a
    public synchronized void b() {
        try {
            this.c.close();
            this.b.a(this.f8426a);
        } catch (IOException e) {
            throw new com.opos.videocache.g("Error closing file " + this.f8426a, e);
        }
    }

    @Override // com.opos.videocache.a
    public synchronized void c() {
        if (d()) {
            return;
        }
        b();
        File file = new File(this.f8426a.getParentFile(), this.f8426a.getName().substring(0, this.f8426a.getName().length() - 9));
        if (!this.f8426a.renameTo(file)) {
            com.opos.cmn.an.f.a.a("FileCache", "Error renaming file " + this.f8426a + " to " + file + " for completion!");
            throw new com.opos.videocache.g("Error renaming file " + this.f8426a + " to " + file + " for completion!");
        }
        if (!this.f8426a.delete()) {
            com.opos.cmn.an.f.a.a("FileCache", "delete .download cache file fail!");
        }
        this.f8426a = file;
        try {
            this.c = new RandomAccessFile(this.f8426a, t.k);
            this.b.a(this.f8426a);
        } catch (IOException e) {
            com.opos.cmn.an.f.a.a("FileCache", "Error opening " + this.f8426a + " as disc cache", (Throwable) e);
            throw new com.opos.videocache.g("Error opening " + this.f8426a + " as disc cache", e);
        }
    }

    @Override // com.opos.videocache.a
    public synchronized boolean d() {
        return !a(this.f8426a);
    }
}
