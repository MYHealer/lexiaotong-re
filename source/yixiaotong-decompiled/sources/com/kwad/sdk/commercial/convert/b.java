package com.kwad.sdk.commercial.convert;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends com.kwad.sdk.commercial.c.a {
    public boolean aKo;
    public boolean aKp;
    public String aKq;
    public int adNum;
    public String adSource;
    public String methodName;

    public final b bC(boolean z) {
        this.aKo = z;
        return this;
    }

    public final b dA(int i) {
        this.adNum = i;
        return this;
    }

    public final b dt(String str) {
        this.methodName = str;
        return this;
    }

    public final b du(String str) {
        this.aKq = str;
        return this;
    }

    public final b dv(String str) {
        this.adSource = str;
        return this;
    }

    public static b Iq() {
        return new b();
    }
}
