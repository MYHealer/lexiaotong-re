package com.hihonor.hianalytics.module.config;

import com.hihonor.hianalytics.hnha.j2;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class HiAnalyticsAutoConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f3704a;
    private final boolean b;
    private final boolean c;
    private final boolean d;
    private final long e;

    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f3705a = -1;
        private boolean b = false;
        private boolean c = false;
        private boolean d = false;
        private long e = 300000;

        public HiAnalyticsAutoConfig builder() {
            int i = this.f3705a;
            a aVar = null;
            if (i >= 0 && i <= 3) {
                return new HiAnalyticsAutoConfig(this, aVar);
            }
            j2.e("HiAnalyticsAutoConfig_Builder", "builder illegal autoTrackType=" + this.f3705a);
            return null;
        }

        public Builder setAutoSessionConfig(boolean z, long j) {
            j2.c("HiAnalyticsAutoConfig_Builder", "setAutoSessionConfig isOpen=" + z + ",time=" + j);
            this.d = z;
            if (j > 0) {
                this.e = j;
            }
            return this;
        }

        public Builder setAutoTrackType(int i) {
            j2.c("HiAnalyticsAutoConfig_Builder", "setAutoTrackType autoTrackType=" + i + ",nowValue=" + this.f3705a);
            if (i >= 0 && i <= 3) {
                this.f3705a = i;
            }
            return this;
        }

        public Builder setClickAutoEvent(boolean z) {
            j2.c("HiAnalyticsAutoConfig_Builder", "setClickAutoEvent isClickAutoEvent=" + z + ",nowValue=" + this.c);
            this.c = z;
            return this;
        }

        public Builder setFragmentAutoEvent(boolean z) {
            j2.c("HiAnalyticsAutoConfig_Builder", "setFragmentAutoEvent isFragmentAutoEvent=" + z + ",nowValue=" + this.b);
            this.b = z;
            return this;
        }
    }

    static /* synthetic */ class a {
    }

    private HiAnalyticsAutoConfig(Builder builder) {
        this.f3704a = builder.f3705a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
    }

    /* synthetic */ HiAnalyticsAutoConfig(Builder builder, a aVar) {
        this(builder);
    }

    public long getAutoSessionHeartTime() {
        return this.e;
    }

    public int getAutoTrackType() {
        return this.f3704a;
    }

    public boolean isAutoSessionOpen() {
        return this.d;
    }

    public boolean isClickAutoEvent() {
        return this.c;
    }

    public boolean isFragmentAutoEvent() {
        return this.b;
    }
}
