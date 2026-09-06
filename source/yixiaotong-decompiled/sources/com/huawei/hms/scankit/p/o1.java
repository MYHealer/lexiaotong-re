package com.huawei.hms.scankit.p;

import java.util.List;

/* JADX INFO: compiled from: DecoderResult.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f4317a;
    private int b;
    private final String c;
    private final List<byte[]> d;
    private final String e;
    private Integer f;
    private Integer g;
    private Object h;
    private final int i;
    private final int j;

    public o1(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public int a() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public void a(Integer num) {
        this.g = num;
    }

    public void a(Object obj) {
        this.h = obj;
    }

    public Object b() {
        return this.h;
    }

    public void b(Integer num) {
        this.f = num;
    }

    public byte[] c() {
        return this.f4317a;
    }

    public String d() {
        return this.c;
    }

    public o1(byte[] bArr, String str, List<byte[]> list, String str2, int i, int i2) {
        this.f4317a = bArr;
        this.b = bArr == null ? 0 : bArr.length * 8;
        this.c = str;
        this.d = list;
        this.e = str2;
        this.i = i2;
        this.j = i;
    }
}
