package com.huawei.hms.ads;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ez {
    public static final String Code = "true";
    private static final String I = "LinkedAdConfiguration";
    public static final String V = "false";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3848a;
    private String b;
    private String c;
    private VideoConfiguration d;
    private int Z = 0;
    private String B = null;
    private int C = 0;
    private String S = Boolean.FALSE.toString();
    private String F = "n";
    private boolean D = false;
    private boolean L = false;
    private String e = "y";
    private String f = "n";

    public void B(String str) {
        this.b = str;
    }

    public boolean B() {
        return this.L;
    }

    public int C() {
        return this.Z;
    }

    public void C(String str) {
        this.c = str;
    }

    public int Code() {
        return this.C;
    }

    public void Code(int i) {
        this.C = i;
    }

    public void Code(VideoConfiguration videoConfiguration) {
        this.d = videoConfiguration;
    }

    public void Code(String str) {
        this.S = str;
    }

    public void Code(boolean z) {
        this.D = z;
    }

    public String D() {
        return this.b;
    }

    public String F() {
        return this.f3848a;
    }

    public void F(String str) {
        this.f = str;
    }

    public String I() {
        return this.F;
    }

    public void I(String str) {
        this.B = str;
    }

    public String L() {
        return this.c;
    }

    public String S() {
        return this.B;
    }

    public void S(String str) {
        this.e = str;
    }

    public String V() {
        return this.S;
    }

    public void V(int i) {
        fh.Code(I, "setLinkedVideoMode %s", Integer.valueOf(i));
        this.Z = i;
    }

    public void V(String str) {
        this.F = str;
    }

    public void V(boolean z) {
        this.L = z;
    }

    public void Z(String str) {
        this.f3848a = str;
    }

    public boolean Z() {
        return this.D;
    }

    public VideoConfiguration a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }
}
