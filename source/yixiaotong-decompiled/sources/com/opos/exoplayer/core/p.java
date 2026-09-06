package com.opos.exoplayer.core;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f6545a = new p(1.0f, 1.0f);
    public final float b;
    public final float c;
    private final int d;

    public p(float f, float f2) {
        com.opos.exoplayer.core.i.a.a(f > 0.0f);
        com.opos.exoplayer.core.i.a.a(f2 > 0.0f);
        this.b = f;
        this.c = f2;
        this.d = Math.round(f * 1000.0f);
    }

    public long a(long j) {
        return j * ((long) this.d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        return this.b == pVar.b && this.c == pVar.c;
    }

    public int hashCode() {
        return ((Float.floatToRawIntBits(this.b) + 527) * 31) + Float.floatToRawIntBits(this.c);
    }
}
