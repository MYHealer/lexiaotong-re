package com.opos.exoplayer.core.e.a;

import android.net.Uri;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6387a = new a(new long[0]);
    public final int b;
    public final long[] c;
    public final C0918a[] d;
    public final long e;
    public final long f;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.e.a.a$a, reason: collision with other inner class name */
    public static final class C0918a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6388a;
        public final Uri[] b;
        public final int[] c;
        public final long[] d;

        public C0918a() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        private C0918a(int i, int[] iArr, Uri[] uriArr, long[] jArr) {
            com.opos.exoplayer.core.i.a.a(iArr.length == uriArr.length);
            this.f6388a = i;
            this.c = iArr;
            this.b = uriArr;
            this.d = jArr;
        }

        public int a() {
            return a(-1);
        }

        public int a(int i) {
            int i2;
            int i3 = i + 1;
            while (true) {
                int[] iArr = this.c;
                if (i3 >= iArr.length || (i2 = iArr[i3]) == 0 || i2 == 1) {
                    break;
                }
                i3++;
            }
            return i3;
        }

        public boolean b() {
            return this.f6388a == -1 || a() < this.f6388a;
        }
    }

    public a(long... jArr) {
        int length = jArr.length;
        this.b = length;
        this.c = Arrays.copyOf(jArr, length);
        this.d = new C0918a[length];
        for (int i = 0; i < length; i++) {
            this.d[i] = new C0918a();
        }
        this.e = 0L;
        this.f = -9223372036854775807L;
    }

    public int a(long j) {
        int length = this.c.length - 1;
        while (length >= 0) {
            long j2 = this.c[length];
            if (j2 != Long.MIN_VALUE && j2 <= j) {
                break;
            }
            length--;
        }
        if (length < 0 || !this.d[length].b()) {
            return -1;
        }
        return length;
    }

    public int b(long j) {
        int i = 0;
        while (true) {
            long[] jArr = this.c;
            if (i >= jArr.length) {
                break;
            }
            long j2 = jArr[i];
            if (j2 == Long.MIN_VALUE || (j < j2 && this.d[i].b())) {
                break;
            }
            i++;
        }
        if (i < this.c.length) {
            return i;
        }
        return -1;
    }
}
