package com.byazt.pp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 1434, 13})
public class tt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2636a;
    public String c;
    public int n;
    public String tt;
    public String uj;
    public String ve;

    public String a() {
        return this.f2636a;
    }

    public tt c(int i) {
        this.n = i;
        return this;
    }

    public tt c(String str) {
        this.uj = str;
        return this;
    }

    public String c() {
        return this.uj;
    }

    public int n() {
        return this.n;
    }

    public tt n(String str) {
        this.f2636a = str;
        return this;
    }

    public tt tt(String str) {
        this.c = str;
        return this;
    }

    public String tt() {
        return this.c;
    }

    public tt uj(String str) {
        this.ve = str;
        return this;
    }

    public String uj() {
        return this.ve;
    }

    public tt ve(String str) {
        this.tt = str;
        return this;
    }

    public String ve() {
        return this.tt;
    }

    public String toString() {
        return "{mediationRit='" + this.c + "', adnName='" + this.tt + "', customAdnName='" + this.ve + "', adType='" + this.uj + "', errCode=" + this.n + ", errMsg=" + this.f2636a + '}';
    }
}
