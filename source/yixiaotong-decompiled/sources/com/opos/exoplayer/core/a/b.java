package com.opos.exoplayer.core.a;

import android.media.AudioAttributes;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f6236a = new a().a();
    public final int b;
    public final int c;
    public final int d;
    private AudioAttributes e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f6237a = 0;
        private int b = 0;
        private int c = 1;

        public b a() {
            return new b(this.f6237a, this.b, this.c, null);
        }
    }

    /* JADX INFO: renamed from: com.opos.exoplayer.core.a.b$b, reason: collision with other inner class name */
    static /* synthetic */ class C0901b {
    }

    private b(int i, int i2, int i3) {
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    /* synthetic */ b(int i, int i2, int i3, C0901b c0901b) {
        this(i, i2, i3);
    }

    AudioAttributes a() {
        if (this.e == null) {
            this.e = new AudioAttributes.Builder().setContentType(this.b).setFlags(this.c).setUsage(this.d).build();
        }
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.b == bVar.b && this.c == bVar.c && this.d == bVar.d;
    }

    public int hashCode() {
        return ((((this.b + 527) * 31) + this.c) * 31) + this.d;
    }
}
