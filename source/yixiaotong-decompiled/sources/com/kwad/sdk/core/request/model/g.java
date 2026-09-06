package com.kwad.sdk.core.request.model;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g extends com.kwad.sdk.core.response.a.a {
    public String aXA;
    public String aXB;
    public String aXy;
    public String aXz;
    public String serviceToken;
    public int thirdAge;
    public int thirdGender;
    public String thirdInterest;

    public final g fi(String str) {
        this.aXy = str;
        return this;
    }

    public final g fj(String str) {
        this.aXA = str;
        return this;
    }

    public final g fk(String str) {
        this.serviceToken = str;
        return this;
    }

    public final void fl(String str) {
        this.aXB = str;
    }

    public static g Nw() {
        return new g();
    }
}
