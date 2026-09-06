package com.opos.exoplayer.core.h;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class p implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t<? super p> f6490a;
    private RandomAccessFile b;
    private Uri c;
    private long d;
    private boolean e;

    public static class a extends com.opos.exoplayer.core.i.c {
        public a(IOException iOException) {
            super(iOException);
        }

        @Override // com.opos.exoplayer.core.i.c
        public String a() {
            return "FileDataSourceException";
        }
    }

    public p() {
        this(null);
    }

    public p(t<? super p> tVar) {
        this.f6490a = tVar;
    }

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.d;
        if (j == 0) {
            return -1;
        }
        try {
            int i3 = this.b.read(bArr, i, (int) Math.min(j, i2));
            if (i3 > 0) {
                this.d -= (long) i3;
                t<? super p> tVar = this.f6490a;
                if (tVar != null) {
                    tVar.a(this, i3);
                }
            }
            return i3;
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.opos.exoplayer.core.h.g
    public long a(i iVar) throws a {
        try {
            this.c = iVar.f6483a;
            RandomAccessFile randomAccessFile = new RandomAccessFile(iVar.f6483a.getPath(), com.kuaishou.weapon.p0.t.k);
            this.b = randomAccessFile;
            randomAccessFile.seek(iVar.d);
            long length = iVar.e == -1 ? this.b.length() - iVar.d : iVar.e;
            this.d = length;
            if (length < 0) {
                throw new EOFException();
            }
            this.e = true;
            t<? super p> tVar = this.f6490a;
            if (tVar != null) {
                tVar.a(this, iVar);
            }
            return this.d;
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        return this.c;
    }

    @Override // com.opos.exoplayer.core.h.g
    public void b() {
        this.c = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.b;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                this.b = null;
                if (this.e) {
                    this.e = false;
                    t<? super p> tVar = this.f6490a;
                    if (tVar != null) {
                        tVar.a(this);
                    }
                }
            } catch (IOException e) {
                throw new a(e);
            }
        } catch (Throwable th) {
            this.b = null;
            if (this.e) {
                this.e = false;
                t<? super p> tVar2 = this.f6490a;
                if (tVar2 != null) {
                    tVar2.a(this);
                }
            }
            throw th;
        }
    }
}
