package com.huawei.hms.scankit.p;

import org.apache.commons.io.FilenameUtils;

/* JADX INFO: compiled from: LuminanceSource.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4379a;
    private final int b;

    protected y3(int i, int i2) {
        this.f4379a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public abstract y3 a(int i, int i2, int i3, int i4);

    public abstract byte[] a(int i, byte[] bArr);

    public abstract y3 b(int i, int i2, int i3, int i4);

    public abstract byte[] b();

    public final int c() {
        return this.f4379a;
    }

    public final String toString() {
        char c;
        int i = this.f4379a;
        byte[] bArrA = new byte[i];
        StringBuilder sb = new StringBuilder(this.b * (i + 1));
        for (int i2 = 0; i2 < this.b; i2++) {
            bArrA = a(i2, bArrA);
            for (int i3 = 0; i3 < this.f4379a; i3++) {
                int i4 = bArrA[i3] & 255;
                if (i4 < 64) {
                    c = '#';
                } else if (i4 < 128) {
                    c = '+';
                } else {
                    c = i4 < 192 ? FilenameUtils.EXTENSION_SEPARATOR : ' ';
                }
                sb.append(c);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
