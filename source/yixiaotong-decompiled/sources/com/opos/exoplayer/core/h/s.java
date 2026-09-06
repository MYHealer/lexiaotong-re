package com.opos.exoplayer.core.h;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class s implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Resources f6498a;
    private final t<? super s> b;
    private Uri c;
    private AssetFileDescriptor d;
    private InputStream e;
    private long f;
    private boolean g;

    public static class a extends com.opos.exoplayer.core.i.c {
        public a(IOException iOException) {
            super(iOException);
        }

        public a(String str) {
            super(str);
        }

        @Override // com.opos.exoplayer.core.i.c
        public String a() {
            return "RawResourceDataSourceException";
        }
    }

    public s(Context context, t<? super s> tVar) {
        this.f6498a = context.getResources();
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
        t<? super s> tVar = this.b;
        if (tVar != null) {
            tVar.a(this, i3);
        }
        return i3;
    }

    @Override // com.opos.exoplayer.core.h.g
    public long a(i iVar) throws a {
        try {
            Uri uri = iVar.f6483a;
            this.c = uri;
            if (!TextUtils.equals(RawResourceDataSource.RAW_RESOURCE_SCHEME, uri.getScheme())) {
                throw new a("URI must use scheme rawresource");
            }
            try {
                this.d = this.f6498a.openRawResourceFd(Integer.parseInt(this.c.getLastPathSegment()));
                FileInputStream fileInputStream = new FileInputStream(this.d.getFileDescriptor());
                this.e = fileInputStream;
                fileInputStream.skip(this.d.getStartOffset());
                if (this.e.skip(iVar.d) < iVar.d) {
                    throw new EOFException();
                }
                long j = -1;
                if (iVar.e != -1) {
                    this.f = iVar.e;
                } else {
                    long length = this.d.getLength();
                    if (length != -1) {
                        j = length - iVar.d;
                    }
                    this.f = j;
                }
                this.g = true;
                t<? super s> tVar = this.b;
                if (tVar != null) {
                    tVar.a(this, iVar);
                }
                return this.f;
            } catch (NumberFormatException unused) {
                throw new a("Resource identifier must be an integer.");
            }
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
            InputStream inputStream = this.e;
            if (inputStream != null) {
                inputStream.close();
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
                        t<? super s> tVar = this.b;
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
                    t<? super s> tVar2 = this.b;
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
