package com.opos.mobad.model.c;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7176a;
    private String b;
    private int c;
    private int d;
    private int e;
    private String f;
    private int g;
    private String i;
    private String j;
    private String k;
    private List<String> l;
    private boolean m;
    private int h = -1;
    private int n = 0;
    private int o = 0;
    private int p = 0;

    public String a() {
        return this.f;
    }

    public void a(int i) {
        this.g = i;
    }

    public void a(String str) {
        this.f = str;
    }

    public void a(List<String> list) {
        this.l = list;
    }

    public void a(boolean z) {
        this.m = z;
    }

    public int b() {
        return this.g;
    }

    public void b(int i) {
        this.f7176a = i;
    }

    public void b(String str) {
        this.b = str;
    }

    public int c() {
        return this.f7176a;
    }

    public void c(int i) {
        this.c = i;
    }

    public void c(String str) {
        this.i = str;
    }

    public String d() {
        return this.b;
    }

    public void d(int i) {
        this.d = i;
    }

    public void d(String str) {
        this.j = str;
    }

    public int e() {
        return this.c;
    }

    public void e(int i) {
        this.e = i;
    }

    public void e(String str) {
        this.k = str;
    }

    public int f() {
        return this.d;
    }

    public void f(int i) {
        this.h = i;
    }

    public int g() {
        return this.e;
    }

    public void g(int i) {
        this.n = i;
    }

    public int h() {
        return this.h;
    }

    public void h(int i) {
        this.o = i;
    }

    public String i() {
        return this.i;
    }

    public void i(int i) {
        this.p = i;
    }

    public String j() {
        return this.j;
    }

    public String k() {
        return this.k;
    }

    public List<String> l() {
        return this.l;
    }

    public boolean m() {
        return this.m;
    }

    public int n() {
        return this.n;
    }

    public int o() {
        return this.o;
    }

    public int p() {
        return this.p;
    }

    public String toString() {
        return "FetchAdRequest{apiVer=" + this.f7176a + ", posId='" + this.b + "', posType=" + this.c + ", posHeight=" + this.d + ", posWidth=" + this.e + ", reqId='" + this.f + "', renderStyle=" + this.g + ", renderOri=" + this.h + ", ageGrading='" + this.i + "', keyWords='" + this.j + "', adTraceData='" + this.k + "', bidIds=" + this.l + ", isBottomReq=" + this.m + ", minorsMode=" + this.n + ", minorsModeEnable=" + this.o + ", minorsModeAgeMode=" + this.p + '}';
    }
}
