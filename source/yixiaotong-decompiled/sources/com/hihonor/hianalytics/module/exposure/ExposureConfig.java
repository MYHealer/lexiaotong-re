package com.hihonor.hianalytics.module.exposure;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class ExposureConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f3706a;
    private boolean b;
    private long c;
    private long d;

    public ExposureConfig(float f, boolean z, long j) {
        this(f, z, j, 500L);
    }

    public ExposureConfig(float f, boolean z, long j, long j2) {
        this.f3706a = f;
        this.b = z;
        this.c = j;
        this.d = j2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ExposureConfig)) {
            return false;
        }
        ExposureConfig exposureConfig = (ExposureConfig) obj;
        return this.f3706a == exposureConfig.f3706a && this.b == exposureConfig.b && this.c == exposureConfig.c && this.d == exposureConfig.d;
    }

    public long getDelayCheckMillis() {
        return this.d;
    }

    public float getRatio() {
        return this.f3706a;
    }

    public long getStayMillis() {
        return this.c;
    }

    public int hashCode() {
        int iFloatToIntBits = (((Float.floatToIntBits(this.f3706a) + 527) * 31) + (this.b ? 1231 : 1237)) * 31;
        long j = this.c;
        int i = (iFloatToIntBits + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.d;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    public boolean isRepeat() {
        return this.b;
    }

    public void setDelayCheckMillis(long j) {
        this.d = j;
    }

    public void setRatio(float f) {
        this.f3706a = f;
    }

    public void setRepeat(boolean z) {
        this.b = z;
    }

    public void setStayMillis(long j) {
        this.c = j;
    }

    public String toString() {
        return "ExposureConfig#" + hashCode() + "{ratio=" + this.f3706a + ",isRepeat=" + this.b + ",stayMillis=" + this.c + ",delayCheckMillis=" + this.d + '}';
    }
}
