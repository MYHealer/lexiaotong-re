package com.opos.exoplayer.core.h;

import android.net.Uri;
import android.util.Base64;
import java.net.URLDecoder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private i f6481a;
    private int b;
    private byte[] c;

    @Override // com.opos.exoplayer.core.h.g
    public int a(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int length = this.c.length - this.b;
        if (length == 0) {
            return -1;
        }
        int iMin = Math.min(i2, length);
        System.arraycopy(this.c, this.b, bArr, i, iMin);
        this.b += iMin;
        return iMin;
    }

    @Override // com.opos.exoplayer.core.h.g
    public long a(i iVar) throws com.opos.exoplayer.core.o {
        this.f6481a = iVar;
        Uri uri = iVar.f6483a;
        String scheme = uri.getScheme();
        if (!"data".equals(scheme)) {
            throw new com.opos.exoplayer.core.o("Unsupported scheme: " + scheme);
        }
        String[] strArrSplit = uri.getSchemeSpecificPart().split(",");
        if (strArrSplit.length > 2) {
            throw new com.opos.exoplayer.core.o("Unexpected URI format: " + uri);
        }
        String str = strArrSplit[1];
        if (strArrSplit[0].contains(";base64")) {
            try {
                this.c = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                throw new com.opos.exoplayer.core.o("Error while parsing Base64 encoded string: " + str, e);
            }
        } else {
            this.c = URLDecoder.decode(str, "US-ASCII").getBytes();
        }
        return this.c.length;
    }

    @Override // com.opos.exoplayer.core.h.g
    public Uri a() {
        i iVar = this.f6481a;
        if (iVar != null) {
            return iVar.f6483a;
        }
        return null;
    }

    @Override // com.opos.exoplayer.core.h.g
    public void b() {
        this.f6481a = null;
        this.c = null;
    }
}
