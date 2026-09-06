package com.byazt.xe;

import com.byazt.uq.sp;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1093, 34})
public class a implements Closeable {
    public final FileInputStream c;
    public final Map<String, ve> n = new HashMap();
    public c tt;
    public ve[] uj;
    public tt[] ve;

    /* JADX INFO: renamed from: com.byazt.xe.a$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 1093, 255})
    static /* synthetic */ class AnonymousClass1 {
    }

    public static boolean c(File file) {
        try {
            sp.c(new a(file));
            return true;
        } catch (IOException unused) {
            sp.c((Closeable) null);
            return false;
        } catch (Throwable th) {
            sp.c((Closeable) null);
            throw th;
        }
    }

    private a(File file) throws IOException {
        AnonymousClass1 anonymousClass1 = null;
        this.tt = null;
        this.ve = null;
        this.uj = null;
        FileInputStream fileInputStream = new FileInputStream(file);
        this.c = fileInputStream;
        FileChannel channel = fileInputStream.getChannel();
        this.tt = new c(channel, anonymousClass1);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(128);
        byteBufferAllocate.limit(this.tt.da);
        byteBufferAllocate.order(this.tt.c[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
        channel.position(this.tt.f2859a);
        this.ve = new tt[this.tt.sl];
        for (int i = 0; i < this.ve.length; i++) {
            tt(channel, byteBufferAllocate, "failed to read phdr.");
            this.ve[i] = new tt(byteBufferAllocate, this.tt.c[4], anonymousClass1);
        }
        channel.position(this.tt.sp);
        byteBufferAllocate.limit(this.tt.t);
        this.uj = new ve[this.tt.u];
        for (int i2 = 0; i2 < this.uj.length; i2++) {
            tt(channel, byteBufferAllocate, "failed to read shdr.");
            this.uj[i2] = new ve(byteBufferAllocate, this.tt.c[4], anonymousClass1);
        }
        if (this.tt.yp > 0) {
            ByteBuffer byteBufferC = c(this.uj[this.tt.yp]);
            for (ve veVar : this.uj) {
                byteBufferC.position(veVar.c);
                veVar.sl = c(byteBufferC);
                this.n.put(veVar.sl, veVar);
            }
        }
    }

    private static String c(ByteBuffer byteBuffer) {
        byte[] bArrArray = byteBuffer.array();
        int iPosition = byteBuffer.position();
        while (byteBuffer.hasRemaining() && bArrArray[byteBuffer.position()] != 0) {
            byteBuffer.position(byteBuffer.position() + 1);
        }
        byteBuffer.position(byteBuffer.position() + 1);
        return new String(bArrArray, iPosition, (byteBuffer.position() - iPosition) - 1, Charset.forName(HTTP.ASCII));
    }

    private ByteBuffer c(ve veVar) throws IOException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) veVar.f2861a);
        this.c.getChannel().position(veVar.n);
        tt(this.c.getChannel(), byteBufferAllocate, "failed to read section: " + veVar.sl);
        return byteBufferAllocate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(FileChannel fileChannel, ByteBuffer byteBuffer, String str) throws IOException {
        byteBuffer.rewind();
        int i = fileChannel.read(byteBuffer);
        if (i != byteBuffer.limit()) {
            throw new IOException(str + " Rest bytes insufficient, expect to read " + byteBuffer.limit() + " bytes but only " + i + " bytes were read.");
        }
        byteBuffer.flip();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void tt(int i, int i2, int i3, String str) throws IOException {
        if (i < i2 || i > i3) {
            throw new IOException(str);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.c.close();
        this.n.clear();
        this.ve = null;
        this.uj = null;
    }

    @com.byazt.zqa.c(c = {0, 1, 1093, 464})
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f2859a;
        public final byte[] c;
        public final short da;
        public final short i;
        public final long n;
        public final short sl;
        public final long sp;
        public final short t;
        public final short tt;
        public final short u;
        public final int uj;
        public final short ve;
        public final int x;
        public final short yp;

        public /* synthetic */ c(FileChannel fileChannel, AnonymousClass1 anonymousClass1) throws IOException {
            this(fileChannel);
        }

        private c(FileChannel fileChannel) throws IOException {
            byte[] bArr = new byte[16];
            this.c = bArr;
            fileChannel.position(0L);
            fileChannel.read(ByteBuffer.wrap(bArr));
            if (bArr[0] == 127 && bArr[1] == 69 && bArr[2] == 76 && bArr[3] == 70) {
                a.tt(bArr[4], 1, 2, "bad elf class: " + ((int) bArr[4]));
                a.tt(bArr[5], 1, 2, "bad elf data encoding: " + ((int) bArr[5]));
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr[4] == 1 ? 36 : 48);
                byteBufferAllocate.order(bArr[5] == 1 ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN);
                a.tt(fileChannel, byteBufferAllocate, "failed to read rest part of ehdr.");
                this.tt = byteBufferAllocate.getShort();
                this.ve = byteBufferAllocate.getShort();
                int i = byteBufferAllocate.getInt();
                this.uj = i;
                a.tt(i, 1, 1, "bad elf version: " + i);
                byte b = bArr[4];
                if (b == 1) {
                    this.n = byteBufferAllocate.getInt();
                    this.f2859a = byteBufferAllocate.getInt();
                    this.sp = byteBufferAllocate.getInt();
                } else if (b == 2) {
                    this.n = byteBufferAllocate.getLong();
                    this.f2859a = byteBufferAllocate.getLong();
                    this.sp = byteBufferAllocate.getLong();
                } else {
                    throw new IOException("Unexpected elf class: " + ((int) bArr[4]));
                }
                this.x = byteBufferAllocate.getInt();
                this.i = byteBufferAllocate.getShort();
                this.da = byteBufferAllocate.getShort();
                this.sl = byteBufferAllocate.getShort();
                this.t = byteBufferAllocate.getShort();
                this.u = byteBufferAllocate.getShort();
                this.yp = byteBufferAllocate.getShort();
                return;
            }
            throw new IOException(String.format("bad elf magic: %x %x %x %x.", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3])));
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 1093, 480})
    private static class tt {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f2860a;
        public final int c;
        public final long n;
        public final long sp;
        public final int tt;
        public final long uj;
        public final long ve;
        public final long x;

        public /* synthetic */ tt(ByteBuffer byteBuffer, int i, AnonymousClass1 anonymousClass1) throws IOException {
            this(byteBuffer, i);
        }

        private tt(ByteBuffer byteBuffer, int i) throws IOException {
            if (i == 1) {
                this.c = byteBuffer.getInt();
                this.ve = byteBuffer.getInt();
                this.uj = byteBuffer.getInt();
                this.n = byteBuffer.getInt();
                this.f2860a = byteBuffer.getInt();
                this.sp = byteBuffer.getInt();
                this.tt = byteBuffer.getInt();
                this.x = byteBuffer.getInt();
                return;
            }
            if (i == 2) {
                this.c = byteBuffer.getInt();
                this.tt = byteBuffer.getInt();
                this.ve = byteBuffer.getLong();
                this.uj = byteBuffer.getLong();
                this.n = byteBuffer.getLong();
                this.f2860a = byteBuffer.getLong();
                this.sp = byteBuffer.getLong();
                this.x = byteBuffer.getLong();
                return;
            }
            throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 1093, 471})
    private static class ve {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f2861a;
        public final int c;
        public final long da;
        public final long i;
        public final long n;
        public String sl;
        public final int sp;
        public final int tt;
        public final long uj;
        public final long ve;
        public final int x;

        public /* synthetic */ ve(ByteBuffer byteBuffer, int i, AnonymousClass1 anonymousClass1) throws IOException {
            this(byteBuffer, i);
        }

        private ve(ByteBuffer byteBuffer, int i) throws IOException {
            if (i == 1) {
                this.c = byteBuffer.getInt();
                this.tt = byteBuffer.getInt();
                this.ve = byteBuffer.getInt();
                this.uj = byteBuffer.getInt();
                this.n = byteBuffer.getInt();
                this.f2861a = byteBuffer.getInt();
                this.sp = byteBuffer.getInt();
                this.x = byteBuffer.getInt();
                this.i = byteBuffer.getInt();
                this.da = byteBuffer.getInt();
            } else if (i == 2) {
                this.c = byteBuffer.getInt();
                this.tt = byteBuffer.getInt();
                this.ve = byteBuffer.getLong();
                this.uj = byteBuffer.getLong();
                this.n = byteBuffer.getLong();
                this.f2861a = byteBuffer.getLong();
                this.sp = byteBuffer.getInt();
                this.x = byteBuffer.getInt();
                this.i = byteBuffer.getLong();
                this.da = byteBuffer.getLong();
            } else {
                throw new IOException("Unexpected elf class: ".concat(String.valueOf(i)));
            }
            this.sl = null;
        }
    }
}
