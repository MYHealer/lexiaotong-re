package com.huawei.hms.scankit.p;

/* JADX INFO: compiled from: QRCode.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class m5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private d4 f4310a;
    private r2 b;
    private c7 c;
    private int d = -1;
    private a0 e;

    public static boolean a(int i) {
        return i >= 0 && i < 8;
    }

    public a0 a() {
        return this.e;
    }

    public void a(a0 a0Var) {
        this.e = a0Var;
    }

    public void a(c7 c7Var) {
        this.c = c7Var;
    }

    public void a(d4 d4Var) {
        this.f4310a = d4Var;
    }

    public void a(r2 r2Var) {
        this.b = r2Var;
    }

    public void b(int i) {
        this.d = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n mode: ");
        sb.append(this.f4310a);
        sb.append("\n ecLevel: ");
        sb.append(this.b);
        sb.append("\n version: ");
        sb.append(this.c);
        sb.append("\n maskPattern: ");
        sb.append(this.d);
        sb.append(">>\n");
        return sb.toString();
    }
}
