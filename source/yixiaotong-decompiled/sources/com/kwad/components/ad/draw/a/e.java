package com.kwad.components.ad.draw.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class e extends com.kwad.sdk.commercial.c.a {
    public long dP;
    public int materialType;
    public String materialUrl;
    public int status;

    public final e J(int i) {
        this.status = i;
        return this;
    }

    public final e K(int i) {
        this.materialType = i;
        return this;
    }

    public final e k(long j) {
        this.dP = j;
        return this;
    }

    public final e s(String str) {
        this.materialUrl = str;
        return this;
    }

    public static e aT() {
        return new e();
    }
}
