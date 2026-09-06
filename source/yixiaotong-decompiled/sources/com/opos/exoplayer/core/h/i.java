package com.opos.exoplayer.core.h;

import android.net.Uri;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f6483a;
    public final byte[] b;
    public final long c;
    public final long d;
    public final long e;
    public final String f;
    public final int g;

    public i(Uri uri, long j, long j2, long j3, String str, int i) {
        this(uri, null, j, j2, j3, str, i);
    }

    public i(Uri uri, long j, long j2, String str) {
        this(uri, j, j, j2, str, 0);
    }

    public i(Uri uri, byte[] bArr, long j, long j2, long j3, String str, int i) {
        boolean z = true;
        com.opos.exoplayer.core.i.a.a(j >= 0);
        com.opos.exoplayer.core.i.a.a(j2 >= 0);
        if (j3 <= 0 && j3 != -1) {
            z = false;
        }
        com.opos.exoplayer.core.i.a.a(z);
        this.f6483a = uri;
        this.b = bArr;
        this.c = j;
        this.d = j2;
        this.e = j3;
        this.f = str;
        this.g = i;
    }

    public boolean a(int i) {
        return (this.g & i) == i;
    }

    public String toString() {
        return "DataSpec[" + this.f6483a + ", " + Arrays.toString(this.b) + ", " + this.c + ", " + this.d + ", " + this.e + ", " + this.f + ", " + this.g + "]";
    }
}
