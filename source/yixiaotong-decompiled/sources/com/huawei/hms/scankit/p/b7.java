package com.huawei.hms.scankit.p;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: compiled from: Version.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b7 {
    private static final int[][] h = {new int[]{1, 10, 10, 8, 8, 5, 1, 3}, new int[]{2, 12, 12, 10, 10, 7, 1, 5}, new int[]{3, 14, 14, 12, 12, 10, 1, 8}, new int[]{4, 16, 16, 14, 14, 12, 1, 12}, new int[]{5, 18, 18, 16, 16, 14, 1, 18}, new int[]{6, 20, 20, 18, 18, 18, 1, 22}, new int[]{7, 22, 22, 20, 20, 20, 1, 30}, new int[]{8, 24, 24, 22, 22, 24, 1, 36}, new int[]{9, 26, 26, 24, 24, 28, 1, 44}, new int[]{10, 32, 32, 14, 14, 36, 1, 62}, new int[]{11, 36, 36, 16, 16, 42, 1, 86}, new int[]{12, 40, 40, 18, 18, 48, 1, 114}, new int[]{13, 44, 44, 20, 20, 56, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE}, new int[]{14, 48, 48, 22, 22, 68, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE}, new int[]{15, 52, 52, 24, 24, 42, 2, 102}, new int[]{16, 64, 64, 14, 14, 56, 2, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID}, new int[]{17, 72, 72, 16, 16, 36, 4, 92}, new int[]{18, 80, 80, 18, 18, 48, 4, 114}, new int[]{19, 88, 88, 20, 20, 56, 4, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE}, new int[]{20, 96, 96, 22, 22, 68, 4, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE}, new int[]{21, 104, 104, 24, 24, 56, 6, MediaPlayer.MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH}, new int[]{22, 120, 120, 18, 18, 68, 6, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED}, new int[]{23, 132, 132, 20, 20, 62, 8, 163}, new int[]{24, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, MediaPlayer.MEDIA_PLAYER_OPTION_SPADE, 22, 22, 62, 8, 156, 2, 155}, new int[]{25, 8, 18, 6, 16, 7, 1, 5}, new int[]{26, 8, 32, 6, 14, 11, 1, 10}, new int[]{27, 12, 26, 10, 24, 14, 1, 16}, new int[]{28, 12, 36, 10, 16, 18, 1, 22}, new int[]{29, 16, 36, 14, 16, 24, 1, 32}, new int[]{30, 16, 48, 14, 22, 28, 1, 49}};
    private static final b7[] i = a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4218a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final c f;
    private final int g;

    /* JADX INFO: compiled from: Version.java */
    static /* synthetic */ class a {
    }

    /* JADX INFO: compiled from: Version.java */
    static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f4219a;
        private final int b;

        /* synthetic */ b(int i, int i2, a aVar) {
            this(i, i2);
        }

        int a() {
            return this.f4219a;
        }

        int b() {
            return this.b;
        }

        private b(int i, int i2) {
            this.f4219a = i;
            this.b = i2;
        }
    }

    /* JADX INFO: compiled from: Version.java */
    static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f4220a;
        private final b[] b;

        /* synthetic */ c(int i, b bVar, a aVar) {
            this(i, bVar);
        }

        b[] a() {
            return this.b;
        }

        int b() {
            return this.f4220a;
        }

        /* synthetic */ c(int i, b bVar, b bVar2, a aVar) {
            this(i, bVar, bVar2);
        }

        private c(int i, b bVar) {
            this.f4220a = i;
            this.b = new b[]{bVar};
        }

        private c(int i, b bVar, b bVar2) {
            this.f4220a = i;
            this.b = new b[]{bVar, bVar2};
        }
    }

    private b7(int i2, int i3, int i4, int i5, int i6, c cVar) {
        this.f4218a = i2;
        this.b = i3;
        this.c = i4;
        this.d = i5;
        this.e = i6;
        this.f = cVar;
        int iB = cVar.b();
        int iA = 0;
        for (b bVar : cVar.a()) {
            iA += bVar.a() * (bVar.b() + iB);
        }
        this.g = iA;
    }

    public static b7 a(int i2, int i3) throws com.huawei.hms.scankit.p.a {
        if ((i2 & 1) != 0 || (i3 & 1) != 0) {
            throw com.huawei.hms.scankit.p.a.a();
        }
        for (b7 b7Var : i) {
            if (b7Var.b == i2 && b7Var.c == i3) {
                return b7Var;
            }
        }
        throw com.huawei.hms.scankit.p.a.a();
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.d;
    }

    c d() {
        return this.f;
    }

    public int e() {
        return this.c;
    }

    public int f() {
        return this.b;
    }

    public int g() {
        return this.g;
    }

    public int h() {
        return this.f4218a;
    }

    public String toString() {
        return String.valueOf(this.f4218a);
    }

    private static b7[] a() {
        b7[] b7VarArr = new b7[h.length];
        int i2 = 0;
        while (true) {
            int[][] iArr = h;
            if (i2 >= iArr.length) {
                return b7VarArr;
            }
            int[] iArr2 = iArr[i2];
            a aVar = null;
            if (i2 == 23) {
                b7VarArr[i2] = new b7(iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[4], new c(iArr2[5], new b(iArr2[6], iArr2[7], aVar), new b(iArr2[8], iArr2[9], aVar), aVar));
            } else {
                b7VarArr[i2] = new b7(iArr2[0], iArr2[1], iArr2[2], iArr2[3], iArr2[4], new c(iArr2[5], new b(iArr2[6], iArr2[7], aVar), aVar));
            }
            i2++;
        }
    }
}
