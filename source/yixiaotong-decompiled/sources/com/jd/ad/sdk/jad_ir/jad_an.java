package com.jd.ad.sdk.jad_ir;

import com.kuaishou.weapon.p0.t;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class jad_an {
    public static final AtomicReference<byte[]> jad_an = new AtomicReference<>();

    /* JADX INFO: renamed from: com.jd.ad.sdk.jad_ir.jad_an$jad_an, reason: collision with other inner class name */
    public static class C0554jad_an extends InputStream {
        public final ByteBuffer jad_an;
        public int jad_bo = -1;

        public C0554jad_an(ByteBuffer byteBuffer) {
            this.jad_an = byteBuffer;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.jad_an.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.jad_bo = this.jad_an.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.jad_an.hasRemaining()) {
                return this.jad_an.get() & 255;
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (!this.jad_an.hasRemaining()) {
                return -1;
            }
            int iMin = Math.min(i2, this.jad_an.remaining());
            this.jad_an.get(bArr, i, iMin);
            return iMin;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            int i = this.jad_bo;
            if (i == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.jad_an.position(i);
        }

        @Override // java.io.InputStream
        public long skip(long j) {
            if (!this.jad_an.hasRemaining()) {
                return -1L;
            }
            long jMin = Math.min(j, this.jad_an.remaining());
            ByteBuffer byteBuffer = this.jad_an;
            byteBuffer.position((int) (((long) byteBuffer.position()) + jMin));
            return jMin;
        }
    }

    public static final class jad_bo {
        public final int jad_an;
        public final int jad_bo;
        public final byte[] jad_cp;

        public jad_bo(byte[] bArr, int i, int i2) {
            this.jad_cp = bArr;
            this.jad_an = i;
            this.jad_bo = i2;
        }
    }

    public static ByteBuffer jad_an(File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        Throwable th;
        FileChannel channel;
        FileChannel fileChannel = null;
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new IOException("File too large to map into memory");
            }
            if (length == 0) {
                throw new IOException("File unsuitable for memory mapping");
            }
            randomAccessFile = new RandomAccessFile(file, t.k);
            try {
                channel = randomAccessFile.getChannel();
                try {
                    MappedByteBuffer mappedByteBufferLoad = channel.map(FileChannel.MapMode.READ_ONLY, 0L, length).load();
                    try {
                        channel.close();
                    } catch (IOException unused) {
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                    return mappedByteBufferLoad;
                } catch (Throwable th2) {
                    th = th2;
                    Throwable th3 = th;
                    fileChannel = channel;
                    th = th3;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (randomAccessFile == null) {
                        throw th;
                    }
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                channel = null;
            }
        } catch (Throwable th5) {
            th = th5;
            randomAccessFile = null;
        }
    }

    public static ByteBuffer jad_an(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        byte[] andSet = jad_an.getAndSet(null);
        if (andSet == null) {
            andSet = new byte[16384];
        }
        while (true) {
            int i = inputStream.read(andSet);
            if (i < 0) {
                jad_an.set(andSet);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return jad_an(ByteBuffer.allocateDirect(byteArray.length).put(byteArray));
            }
            byteArrayOutputStream.write(andSet, 0, i);
        }
    }

    public static ByteBuffer jad_an(ByteBuffer byteBuffer) {
        return (ByteBuffer) byteBuffer.position(0);
    }

    public static void jad_an(ByteBuffer byteBuffer, File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                FileChannel channel = randomAccessFile.getChannel();
                try {
                    channel.write(byteBuffer);
                    channel.force(false);
                    channel.close();
                    randomAccessFile.close();
                    try {
                        channel.close();
                    } catch (IOException unused) {
                    }
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused2) {
                    }
                } catch (Throwable th) {
                    th = th;
                    fileChannel = channel;
                    if (fileChannel != null) {
                        try {
                            fileChannel.close();
                        } catch (IOException unused3) {
                        }
                    }
                    if (randomAccessFile == null) {
                        throw th;
                    }
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }
}
