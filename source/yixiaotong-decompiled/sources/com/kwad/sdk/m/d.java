package com.kwad.sdk.m;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d extends com.kwad.sdk.core.response.a.a {
    public List<com.kwad.sdk.m.a.a> bmI;
    public List<String> bmQ;
    public List<a> bmR;
    public List<com.kwad.sdk.m.a.b> bmS;
    public long funcSwitch;
    public long byteCount = 1000;
    public double sampleRate = 1.0d;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public String bmT;
        public String bmU;
    }

    public final boolean TK() {
        return (this.funcSwitch & 1) == 0;
    }

    public final boolean TL() {
        return fM(4);
    }

    public final boolean TM() {
        return fM(16);
    }

    public final boolean TN() {
        return fM(32);
    }

    private boolean fM(int i) {
        return (TK() || (this.funcSwitch & ((long) i)) == 0) ? false : true;
    }
}
