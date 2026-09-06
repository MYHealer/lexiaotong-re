package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;

/* JADX INFO: compiled from: GenericGF.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class y2 {
    public static final y2 h = new y2(TTAdConstant.INIT_FAILED_CREATE_INITIALIZER_FAILED, 4096, 1);
    public static final y2 i = new y2(1033, 1024, 1);
    public static final y2 j;
    public static final y2 k;
    public static final y2 l;
    public static final y2 m;
    public static final y2 n;
    public static final y2 o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f4378a;
    private final int[] b;
    private final z2 c;
    private final z2 d;
    private final int e;
    private final int f;
    private final int g;

    static {
        y2 y2Var = new y2(67, 64, 1);
        j = y2Var;
        k = new y2(19, 16, 1);
        l = new y2(MediaPlayer.MEDIA_PLAYER_OPTION_FRC_LEVEL, 256, 0);
        y2 y2Var2 = new y2(301, 256, 1);
        m = y2Var2;
        n = y2Var2;
        o = y2Var;
    }

    public y2(int i2, int i3, int i4) {
        this.f = i2;
        this.e = i3;
        this.g = i4;
        this.f4378a = new int[i3];
        this.b = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.f4378a[i6] = i5;
            i5 *= 2;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.b[this.f4378a[i7]] = i7;
        }
        this.c = new z2(this, new int[]{0});
        this.d = new z2(this, new int[]{1});
    }

    static int a(int i2, int i3) {
        return i2 ^ i3;
    }

    public int a() {
        return this.g;
    }

    int a(int i2) {
        if (y6.a(this.f4378a, i2)) {
            return this.f4378a[i2];
        }
        return -1;
    }

    z2 b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    int c(int i2) {
        if (i2 != 0) {
            return this.b[i2];
        }
        throw new IllegalArgumentException();
    }

    z2 d() {
        return this.c;
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f) + ',' + this.e + ')';
    }

    z2 b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.c;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new z2(this, iArr);
    }

    int c(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f4378a;
        int[] iArr2 = this.b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.e - 1)];
    }

    int b(int i2) {
        if (i2 != 0) {
            return this.f4378a[(this.e - this.b[i2]) - 1];
        }
        throw new ArithmeticException();
    }
}
