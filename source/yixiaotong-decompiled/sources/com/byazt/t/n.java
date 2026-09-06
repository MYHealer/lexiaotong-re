package com.byazt.t;

import com.byazt.m.BaseException;
import com.byazt.w.a;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 66, 46})
public class n implements Closeable {
    public BufferedOutputStream c;
    public FileDescriptor tt;
    public RandomAccessFile ve;

    public n(File file, int i) throws BaseException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.ve = randomAccessFile;
            this.tt = randomAccessFile.getFD();
            if (i > 0) {
                int i2 = 8192;
                if (i >= 8192) {
                    i2 = 131072;
                    i = i > 131072 ? i2 : i;
                }
                this.c = new BufferedOutputStream(new FileOutputStream(this.ve.getFD()), i);
                return;
            }
            this.c = new BufferedOutputStream(new FileOutputStream(this.ve.getFD()));
        } catch (IOException e) {
            throw new BaseException(1039, e);
        }
    }

    public void c(byte[] bArr, int i, int i2) throws IOException {
        this.c.write(bArr, i, i2);
    }

    public void c() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.c;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
        FileDescriptor fileDescriptor = this.tt;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    public void tt() throws IOException {
        BufferedOutputStream bufferedOutputStream = this.c;
        if (bufferedOutputStream != null) {
            bufferedOutputStream.flush();
        }
    }

    public void ve() throws IOException {
        FileDescriptor fileDescriptor = this.tt;
        if (fileDescriptor != null) {
            fileDescriptor.sync();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a.c(this.ve, this.c);
    }

    public void c(long j) throws IOException {
        this.ve.seek(j);
    }

    public void tt(long j) throws IOException {
        this.ve.setLength(j);
    }
}
