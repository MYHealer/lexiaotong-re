package com.yfanads.android.adx.newplayer.videocache.file;

import com.kuaishou.weapon.p0.t;
import com.yfanads.android.adx.newplayer.videocache.Cache;
import com.yfanads.android.adx.newplayer.videocache.ProxyCacheException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FileCache implements Cache {
    private static final String TEMP_POSTFIX = ".download";
    private RandomAccessFile dataFile;
    private final DiskUsage diskUsage;
    public File file;

    public FileCache(File file) {
        this(file, new UnlimitedDiskUsage());
    }

    public FileCache(File file, DiskUsage diskUsage) throws ProxyCacheException {
        try {
            if (diskUsage == null) {
                throw new NullPointerException();
            }
            this.diskUsage = diskUsage;
            Files.makeDir(file.getParentFile());
            boolean zExists = file.exists();
            this.file = zExists ? file : new File(file.getParentFile(), file.getName() + TEMP_POSTFIX);
            this.dataFile = new RandomAccessFile(this.file, zExists ? t.k : "rw");
        } catch (IOException e) {
            throw new ProxyCacheException("Error using file " + file + " as disc cache", e);
        }
    }

    private boolean isTempFile(File file) {
        return file.getName().endsWith(TEMP_POSTFIX);
    }

    @Override // com.yfanads.android.adx.newplayer.videocache.Cache
    public synchronized void append(byte[] bArr, int i) {
        try {
            if (isCompleted()) {
                throw new ProxyCacheException("Error append cache: cache file " + this.file + " is completed!");
            }
            this.dataFile.seek(available());
            this.dataFile.write(bArr, 0, i);
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", Integer.valueOf(i), this.dataFile, Integer.valueOf(bArr.length)), e);
        }
    }

    @Override // com.yfanads.android.adx.newplayer.videocache.Cache
    public synchronized long available() {
        try {
        } catch (IOException e) {
            throw new ProxyCacheException("Error reading length of file " + this.file, e);
        }
        return (int) this.dataFile.length();
    }

    @Override // com.yfanads.android.adx.newplayer.videocache.Cache
    public synchronized void close() {
        try {
            this.dataFile.close();
            this.diskUsage.touch(this.file);
        } catch (IOException e) {
            throw new ProxyCacheException("Error closing file " + this.file, e);
        }
    }

    @Override // com.yfanads.android.adx.newplayer.videocache.Cache
    public synchronized void complete() {
        if (isCompleted()) {
            return;
        }
        close();
        File file = new File(this.file.getParentFile(), this.file.getName().substring(0, this.file.getName().length() - 9));
        if (!this.file.renameTo(file)) {
            throw new ProxyCacheException("Error renaming file " + this.file + " to " + file + " for completion!");
        }
        this.file = file;
        try {
            this.dataFile = new RandomAccessFile(this.file, t.k);
            this.diskUsage.touch(this.file);
        } catch (IOException e) {
            throw new ProxyCacheException("Error opening " + this.file + " as disc cache", e);
        }
    }

    public File getFile() {
        return this.file;
    }

    @Override // com.yfanads.android.adx.newplayer.videocache.Cache
    public synchronized boolean isCompleted() {
        return !isTempFile(this.file);
    }

    @Override // com.yfanads.android.adx.newplayer.videocache.Cache
    public synchronized int read(byte[] bArr, long j, int i) {
        try {
            this.dataFile.seek(j);
        } catch (IOException e) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", Integer.valueOf(i), Long.valueOf(j), Long.valueOf(available()), Integer.valueOf(bArr.length)), e);
        }
        return this.dataFile.read(bArr, 0, i);
    }
}
