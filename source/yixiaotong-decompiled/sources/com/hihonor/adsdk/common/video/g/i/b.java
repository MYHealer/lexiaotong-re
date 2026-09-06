package com.hihonor.adsdk.common.video.g.i;

import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b implements com.hihonor.adsdk.common.video.g.j.a {
    private static final String hnadsd = "FileCache";
    private static final String hnadse = ".download";
    public File hnadsa;
    private final a hnadsb;
    private RandomAccessFile hnadsc;

    public b(File file) throws com.hihonor.adsdk.common.video.g.f {
        this(file, new j());
    }

    @Override // com.hihonor.adsdk.common.video.g.j.a
    public synchronized void hnadsa(byte[] bArr, int i) throws com.hihonor.adsdk.common.video.g.f {
        try {
            if (hnadsd()) {
                throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsd, "Error append cache: cache file " + this.hnadsa + " is completed!");
            }
            this.hnadsc.seek(hnadsc());
            this.hnadsc.write(bArr, 0, i);
        } catch (IOException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "append, IOException: " + e.getMessage(), new Object[0]);
            throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.hnadsc, Integer.valueOf(bArr.length)) + e.getMessage());
        }
    }

    @Override // com.hihonor.adsdk.common.video.g.j.a
    public synchronized void hnadsb() throws com.hihonor.adsdk.common.video.g.f {
        if (hnadsd()) {
            return;
        }
        hnadsa();
        File file = new File(this.hnadsa.getParentFile(), this.hnadsa.getName().substring(0, this.hnadsa.getName().length() - 9));
        if (!this.hnadsa.renameTo(file)) {
            throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsd, "Error renaming file " + this.hnadsa + " to " + file + " for completion!");
        }
        this.hnadsa = file;
        try {
            this.hnadsc = new RandomAccessFile(this.hnadsa, t.k);
            this.hnadsb.hnadsa(this.hnadsa);
        } catch (IOException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "complete, IOException: " + e.getMessage(), new Object[0]);
            throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "Error opening " + this.hnadsa + " as disc cache" + e.getMessage());
        }
    }

    @Override // com.hihonor.adsdk.common.video.g.j.a
    public synchronized long hnadsc() throws com.hihonor.adsdk.common.video.g.f {
        try {
        } catch (IOException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "available, IOException: " + e.getMessage(), new Object[0]);
            throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "Error reading length of file " + this.hnadsa + e.getMessage());
        }
        return (int) this.hnadsc.length();
    }

    @Override // com.hihonor.adsdk.common.video.g.j.a
    public synchronized boolean hnadsd() {
        return !hnadsa(this.hnadsa);
    }

    public File hnadse() {
        return this.hnadsa;
    }

    public b(File file, a aVar) throws com.hihonor.adsdk.common.video.g.f {
        this.hnadsb = aVar;
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsb, "Error FileCache directory is null");
        }
        d.hnadsb(parentFile);
        boolean zExists = file.exists();
        this.hnadsa = zExists ? file : new File(file.getParentFile(), file.getName() + hnadse);
        try {
            this.hnadsc = new RandomAccessFile(this.hnadsa, zExists ? t.k : "rw");
        } catch (IOException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "FileCache, IOException: " + e.getMessage(), new Object[0]);
            throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "Error using file " + file + " as disc cache" + e.getMessage());
        }
    }

    @Override // com.hihonor.adsdk.common.video.g.j.a
    public synchronized int hnadsa(byte[] bArr, long j, int i) throws com.hihonor.adsdk.common.video.g.f {
        try {
            this.hnadsc.seek(j);
        } catch (IOException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "read, IOException: " + e.getMessage(), new Object[0]);
            throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(hnadsc()), Integer.valueOf(bArr.length)) + e.getMessage());
        }
        return this.hnadsc.read(bArr, 0, i);
    }

    @Override // com.hihonor.adsdk.common.video.g.j.a
    public synchronized void hnadsa() throws com.hihonor.adsdk.common.video.g.f {
        try {
            this.hnadsc.close();
            this.hnadsb.hnadsa(this.hnadsa);
        } catch (IOException e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsd, "close, IOException: " + e.getMessage(), new Object[0]);
            throw new com.hihonor.adsdk.common.video.g.f(com.hihonor.adsdk.common.video.g.d.hnadsa, "Error closing file " + this.hnadsa + e.getMessage());
        }
    }

    private boolean hnadsa(File file) {
        return file.getName().endsWith(hnadse);
    }
}
