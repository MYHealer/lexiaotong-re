package com.kwad.components.ad.draw.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public int adNum;
    public int adStyle;
    public int cP;
    public long cQ;
    public long loadTime;
    public int materialType;
    public String materialUrl;
    public String methodName;
    public long renderTime;
    public int renderType;
    public int status;

    public final b D(int i) {
        this.status = i;
        return this;
    }

    public final b E(int i) {
        this.adNum = i;
        return this;
    }

    public final b F(int i) {
        this.materialType = i;
        return this;
    }

    public final b G(int i) {
        this.renderType = i;
        return this;
    }

    public final b H(int i) {
        this.cP = i;
        return this;
    }

    public final b I(int i) {
        this.adStyle = i;
        return this;
    }

    public final b h(long j) {
        this.loadTime = j;
        return this;
    }

    public final b i(long j) {
        this.renderTime = j;
        return this;
    }

    public final b j(long j) {
        this.cQ = j;
        return this;
    }

    public final b q(String str) {
        this.methodName = str;
        return this;
    }

    public final b r(String str) {
        this.materialUrl = str;
        return this;
    }

    public static b aS() {
        return new b();
    }
}
