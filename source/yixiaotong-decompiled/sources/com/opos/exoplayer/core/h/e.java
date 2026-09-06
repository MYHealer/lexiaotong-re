package com.opos.exoplayer.core.h;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class e implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ContentResolver f6480a;
    private final t<? super e> b;
    private Uri c;
    private AssetFileDescriptor d;
    private FileInputStream e;
    private long f;
    private boolean g;

    public static class a extends com.opos.exoplayer.core.i.c {
        public a(IOException iOException) {
            super(iOException);
        }

        @Override // com.opos.exoplayer.core.i.c
        public String a() {
            return "ContentDataSourceException";
        }
    }

    public e(Context context, t<? super e> tVar) {
        this.f6480a = context.getContentResolver();
        this.b = tVar;
    }

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.f;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, i2);
            } catch (IOException e) {
                throw new a(e);
            }
        }
        int i3 = this.e.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.f == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j2 = this.f;
        if (j2 != -1) {
            this.f = j2 - ((long) i3);
        }
        t<? super e> tVar = this.b;
        if (tVar != null) {
            tVar.a(this, i3);
        }
        return i3;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x006f  */
    @Override // com.opos.exoplayer.core.h.g
    public long a(i iVar) throws a {
        long j;
        t<? super e> tVar;
        try {
            Uri uri = iVar.f6483a;
            this.c = uri;
            AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = this.f6480a.openAssetFileDescriptor(uri, com.kuaishou.weapon.p0.t.k);
            this.d = assetFileDescriptorOpenAssetFileDescriptor;
            if (assetFileDescriptorOpenAssetFileDescriptor == null) {
                throw new FileNotFoundException("Could not open file descriptor for: " + this.c);
            }
            this.e = new FileInputStream(this.d.getFileDescriptor());
            long startOffset = this.d.getStartOffset();
            long jSkip = this.e.skip(iVar.d + startOffset) - startOffset;
            if (jSkip != iVar.d) {
                throw new EOFException();
            }
            long jPosition = -1;
            if (iVar.e == -1) {
                long length = this.d.getLength();
                if (length == -1) {
                    FileChannel channel = this.e.getChannel();
                    long size = channel.size();
                    if (size != 0) {
                        jPosition = size - channel.position();
                    }
                    this.f = jPosition;
                } else {
                    j = length - jSkip;
                }
                this.g = true;
                tVar = this.b;
                if (tVar != null) {
                    tVar.a(this, iVar);
                }
                return this.f;
            }
            j = iVar.e;
            this.f = j;
            this.g = true;
            tVar = this.b;
            if (tVar != null) {
                tVar.a(this, iVar);
            }
            return this.f;
        } catch (IOException e) {
            throw new a(e);
        }
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        return this.c;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x003d */
    /* JADX WARN: Bottom block not found for handler: all -> 0x005f */
    @Override // com.opos.exoplayer.core.h.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b() {
        this.c = null;
        try {
            FileInputStream fileInputStream = this.e;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.e = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor = this.d;
                    if (assetFileDescriptor != null) {
                        assetFileDescriptor.close();
                    }
                    this.d = null;
                    if (this.g) {
                        this.g = false;
                        t<? super e> tVar = this.b;
                        if (tVar != null) {
                            tVar.a(this);
                        }
                    }
                } catch (IOException e) {
                    throw new a(e);
                }
            } catch (Throwable th) {
                this.d = null;
                if (this.g) {
                    this.g = false;
                    t<? super e> tVar2 = this.b;
                    if (tVar2 != null) {
                        tVar2.a(this);
                    }
                }
                throw th;
            }
        } catch (IOException e2) {
            throw new a(e2);
        }
    }
}
