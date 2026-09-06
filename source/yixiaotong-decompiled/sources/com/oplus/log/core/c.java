package com.oplus.log.core;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f5802a;
    public String b;
    String c;
    long d;
    long e;
    long f;
    long g;
    byte[] h;
    byte[] i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5803a;
        public String b;
        public byte[] e;
        public byte[] f;
        long c = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        long d = 604800000;
        long g = com.hihonor.adsdk.common.video.g.a.hnadsb;
        public String h = "";

        public final a a(long j) {
            this.d = j * 86400000;
            return this;
        }

        public final c a() {
            c cVar = new c((byte) 0);
            cVar.f5802a = this.f5803a;
            cVar.b = this.b;
            cVar.d = this.c;
            cVar.g = this.g;
            cVar.e = this.d;
            cVar.h = this.e;
            cVar.i = this.f;
            cVar.c = this.h;
            return cVar;
        }
    }

    private c() {
        this.c = "";
        this.d = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        this.e = 604800000L;
        this.f = 500L;
        this.g = com.hihonor.adsdk.common.video.g.a.hnadsb;
    }

    /* synthetic */ c(byte b) {
        this();
    }
}
