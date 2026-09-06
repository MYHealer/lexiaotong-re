package com.opos.exoplayer.core.h;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class c implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AssetManager f6479a;
    private final t<? super c> b;
    private Uri c;
    private InputStream d;
    private long e;
    private boolean f;

    public static final class a extends com.opos.exoplayer.core.i.c {
        public a(IOException iOException) {
            super(iOException);
        }

        @Override // com.opos.exoplayer.core.i.c
        public String a() {
            return "AssetDataSourceException";
        }
    }

    public c(Context context, t<? super c> tVar) {
        this.f6479a = context.getAssets();
        this.b = tVar;
    }

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i, int i2) throws a {
        if (i2 == 0) {
            return 0;
        }
        long j = this.e;
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
        int i3 = this.d.read(bArr, i, i2);
        if (i3 == -1) {
            if (this.e == -1) {
                return -1;
            }
            throw new a(new EOFException());
        }
        long j2 = this.e;
        if (j2 != -1) {
            this.e = j2 - ((long) i3);
        }
        t<? super c> tVar = this.b;
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
            String path = uri.getPath();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith("/")) {
                path = path.substring(1);
            }
            InputStream inputStreamOpen = this.f6479a.open(path, 1);
            this.d = inputStreamOpen;
            if (inputStreamOpen.skip(iVar.d) < iVar.d) {
                throw new EOFException();
            }
            if (iVar.e != -1) {
                this.e = iVar.e;
            } else {
                long jAvailable = this.d.available();
                this.e = jAvailable;
                if (jAvailable == 2147483647L) {
                    this.e = -1L;
                }
            }
            this.f = true;
            t<? super c> tVar = this.b;
            if (tVar != null) {
                tVar.a(this, iVar);
            }
            return this.e;
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
                InputStream inputStream = this.d;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.d = null;
                if (this.f) {
                    this.f = false;
                    t<? super c> tVar = this.b;
                    if (tVar != null) {
                        tVar.a(this);
                    }
                }
            } catch (IOException e) {
                throw new a(e);
            }
        } catch (Throwable th) {
            this.d = null;
            if (this.f) {
                this.f = false;
                t<? super c> tVar2 = this.b;
                if (tVar2 != null) {
                    tVar2.a(this);
                }
            }
            throw th;
        }
    }
}
