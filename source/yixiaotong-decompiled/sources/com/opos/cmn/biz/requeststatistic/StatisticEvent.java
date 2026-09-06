package com.opos.cmn.biz.requeststatistic;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class StatisticEvent {
    public final String channel;
    public final long currentTime;
    public final String eventId;
    public final String ext;
    public final long maxResolveTime;

    /* JADX INFO: renamed from: net, reason: collision with root package name */
    public final String f6005net;
    public final long resolveTime;
    public final long ret;
    public final String sdkVersion;
    public final String url;

    /* JADX INFO: renamed from: com.opos.cmn.biz.requeststatistic.StatisticEvent$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f6006a;
        private String b;
        private long c;
        private String d;
        private long e;
        private long f;
        private long g;
        private String h = "";
        private String i;
        private String j;

        public Builder(String str, String str2, long j, long j2, long j3, String str3) {
            this.b = str;
            this.d = str2;
            this.e = j;
            this.f = j2;
            this.g = j3;
            this.i = str3;
        }

        public StatisticEvent build() {
            return new StatisticEvent(this, null);
        }

        public Builder setCurrentTime(long j) {
            this.c = j;
            return this;
        }

        public Builder setExt(String str) {
            this.h = str;
            return this;
        }

        public Builder setNet(String str) {
            this.f6006a = str;
            return this;
        }

        public Builder setSdkVersion(String str) {
            this.j = str;
            return this;
        }
    }

    private StatisticEvent(Builder builder) {
        this.eventId = builder.b;
        this.url = builder.d;
        this.ret = builder.e;
        this.currentTime = builder.c;
        this.resolveTime = builder.f;
        this.maxResolveTime = builder.g;
        this.f6005net = builder.f6006a;
        this.ext = builder.h;
        this.channel = builder.i;
        this.sdkVersion = builder.j;
    }

    /* synthetic */ StatisticEvent(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }
}
