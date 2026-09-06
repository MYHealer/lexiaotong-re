package com.ubix.ssp.ad.e.b0.h.s;

import com.kuaishou.weapon.p0.t;
import com.ubix.ssp.ad.e.b0.h.n;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b implements com.ubix.ssp.ad.e.b0.h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f8797a;
    public File b;
    private RandomAccessFile c;

    public b(File file) {
        this(file, new h());
    }

    public b(File file, a aVar) throws n {
        try {
            if (aVar == null) {
                throw new NullPointerException();
            }
            this.f8797a = aVar;
            d.b(file.getParentFile());
            boolean zExists = file.exists();
            this.b = zExists ? file : new File(file.getParentFile(), file.getName() + ".download");
            this.c = new RandomAccessFile(this.b, zExists ? t.k : "rw");
        } catch (IOException e) {
            throw new n("Error using file " + file + " as disc cache", e);
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }

    @Override // com.ubix.ssp.ad.e.b0.h.a
    public synchronized int a(byte[] bArr, long j, int i) {
        try {
            this.c.seek(j);
        } catch (IOException e) {
            throw new n(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(b()), Integer.valueOf(bArr.length)), e);
        }
        return this.c.read(bArr, 0, i);
    }

    @Override // com.ubix.ssp.ad.e.b0.h.a
    public synchronized void a() {
        if (c()) {
            return;
        }
        close();
        File file = new File(this.b.getParentFile(), this.b.getName().substring(0, this.b.getName().length() - 9));
        if (!this.b.renameTo(file)) {
            throw new n("Error renaming file " + this.b + " to " + file + " for completion!");
        }
        this.b = file;
        try {
            this.c = new RandomAccessFile(this.b, t.k);
            this.f8797a.a(this.b);
        } catch (IOException e) {
            throw new n("Error opening " + this.b + " as disc cache", e);
        }
    }

    @Override // com.ubix.ssp.ad.e.b0.h.a
    public synchronized void a(byte[] bArr, int i) {
        try {
            if (c()) {
                throw new n("Error append cache: cache file " + this.b + " is completed!");
            }
            this.c.seek(b());
            this.c.write(bArr, 0, i);
        } catch (IOException e) {
            throw new n(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.c, Integer.valueOf(bArr.length)), e);
        }
    }

    @Override // com.ubix.ssp.ad.e.b0.h.a
    public synchronized long b() {
        try {
        } catch (IOException e) {
            throw new n("Error reading length of file " + this.b, e);
        }
        return (int) this.c.length();
    }

    @Override // com.ubix.ssp.ad.e.b0.h.a
    public synchronized boolean c() {
        return !a(this.b);
    }

    @Override // com.ubix.ssp.ad.e.b0.h.a
    public synchronized void close() {
        try {
            this.c.close();
            this.f8797a.a(this.b);
        } catch (IOException e) {
            throw new n("Error closing file " + this.b, e);
        }
    }
}
