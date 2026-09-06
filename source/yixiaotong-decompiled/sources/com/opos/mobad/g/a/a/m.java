package com.opos.mobad.g.a.a;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6940a;
    public final int b;
    public final int c;
    public final int d;
    public final String e;

    public m(int i, int i2, int i3, String str) {
        this.f6940a = i;
        this.b = i2;
        this.d = i3;
        this.c = a(i2, i3);
        this.e = str;
    }

    private static int a(int i, int i2) {
        if (i != 1001 || i2 < 101000) {
            return i2;
        }
        return -1;
    }

    public static m a(int i, int i2, int i3, String str) {
        return new m(i, i2, i3, str);
    }

    public String toString() {
        return "ErrorObject{channel=" + this.f6940a + ", oriChannel=" + this.b + ", code=" + this.c + ", oriCode=" + this.d + ", msg='" + this.e + "'}";
    }
}
