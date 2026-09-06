package com.opos.exoplayer.core.c.d;

import com.google.android.exoplayer2.C;
import com.opos.exoplayer.core.c.n;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f6304a;
    public final String b;
    public final n.a c;
    public final int d;
    public final byte[] e;

    public f(boolean z, String str, int i, byte[] bArr, int i2, int i3, byte[] bArr2) {
        com.opos.exoplayer.core.i.a.a((bArr2 == null) ^ (i == 0));
        this.f6304a = z;
        this.b = str;
        this.d = i;
        this.e = bArr2;
        this.c = new n.a(a(str), bArr, i2, i3);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static int a(String str) {
        if (str == null) {
            return 1;
        }
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals(C.CENC_TYPE_cbc1)) {
                    b = 0;
                }
                break;
            case 3046671:
                if (str.equals(C.CENC_TYPE_cbcs)) {
                    b = 1;
                }
                break;
            case 3049879:
                if (str.equals(C.CENC_TYPE_cenc)) {
                    b = 2;
                }
                break;
            case 3049895:
                if (str.equals(C.CENC_TYPE_cens)) {
                    b = 3;
                }
                break;
        }
        switch (b) {
            case 0:
            case 1:
                return 2;
            default:
                com.opos.cmn.an.f.a.c("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
            case 2:
            case 3:
                return 1;
        }
    }
}
