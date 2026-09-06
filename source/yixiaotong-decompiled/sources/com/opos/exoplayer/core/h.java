package com.opos.exoplayer.core;

import java.io.IOException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class h extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6477a;
    public final int b;
    private String c;

    private h(int i, String str, Throwable th, int i2) {
        super(str, th);
        this.f6477a = i;
        this.b = i2;
    }

    public static h a(IOException iOException) {
        return new h(0, null, iOException, -1);
    }

    public static h a(Exception exc, int i) {
        return new h(1, null, exc, i);
    }

    static h a(RuntimeException runtimeException) {
        return new h(2, null, runtimeException, -1);
    }

    public static h b(Exception exc, int i) {
        return new h(3, null, exc, i);
    }

    public String a() {
        return this.c;
    }

    public void a(String str) {
        this.c = str;
    }
}
