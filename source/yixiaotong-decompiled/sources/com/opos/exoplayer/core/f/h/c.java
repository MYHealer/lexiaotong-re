package com.opos.exoplayer.core.f.h;

import android.text.Layout;
import android.text.SpannableStringBuilder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class c extends com.opos.exoplayer.core.f.b {
    public final long m;
    public final long n;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f6453a;
        private long b;
        private SpannableStringBuilder c;
        private Layout.Alignment d;
        private float e;
        private int f;
        private int g;
        private float h;
        private int i;
        private float j;

        public a() {
            a();
        }

        private a c() {
            Layout.Alignment alignment = this.d;
            if (alignment == null) {
                this.i = Integer.MIN_VALUE;
            } else {
                int i = b.f6454a[alignment.ordinal()];
                if (i == 1) {
                    this.i = 0;
                } else if (i == 2) {
                    this.i = 1;
                } else if (i != 3) {
                    com.opos.cmn.an.f.a.c("WebvttCueBuilder", "Unrecognized alignment: " + this.d);
                    this.i = 0;
                } else {
                    this.i = 2;
                }
            }
            return this;
        }

        public a a(float f) {
            this.e = f;
            return this;
        }

        public a a(int i) {
            this.f = i;
            return this;
        }

        public a a(long j) {
            this.f6453a = j;
            return this;
        }

        public a a(Layout.Alignment alignment) {
            this.d = alignment;
            return this;
        }

        public a a(SpannableStringBuilder spannableStringBuilder) {
            this.c = spannableStringBuilder;
            return this;
        }

        public void a() {
            this.f6453a = 0L;
            this.b = 0L;
            this.c = null;
            this.d = null;
            this.e = Float.MIN_VALUE;
            this.f = Integer.MIN_VALUE;
            this.g = Integer.MIN_VALUE;
            this.h = Float.MIN_VALUE;
            this.i = Integer.MIN_VALUE;
            this.j = Float.MIN_VALUE;
        }

        public a b(float f) {
            this.h = f;
            return this;
        }

        public a b(int i) {
            this.g = i;
            return this;
        }

        public a b(long j) {
            this.b = j;
            return this;
        }

        public c b() {
            if (this.h != Float.MIN_VALUE && this.i == Integer.MIN_VALUE) {
                c();
            }
            return new c(this.f6453a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        }

        public a c(float f) {
            this.j = f;
            return this;
        }

        public a c(int i) {
            this.i = i;
            return this;
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6454a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f6454a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6454a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6454a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public c(long j, long j2, CharSequence charSequence) {
        this(j, j2, charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public c(long j, long j2, CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3);
        this.m = j;
        this.n = j2;
    }

    public c(CharSequence charSequence) {
        this(0L, 0L, charSequence);
    }

    public boolean a() {
        return this.d == Float.MIN_VALUE && this.g == Float.MIN_VALUE;
    }
}
