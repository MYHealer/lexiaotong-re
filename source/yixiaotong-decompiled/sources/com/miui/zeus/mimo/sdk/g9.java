package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class g9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5443a;
    public String b;

    public g9() {
        this.f5443a = ijiami_1011.s.s.s.d(new byte[]{99, 92, Ascii.ETB, 12, Ascii.DC2, 83, 3, 8, 3, 33, 80, 16, 80, 92, 17, 49, 16, 92, 15, 5, 4, 14, 84}, "74ece2");
    }

    public g9(String str, String str2) {
        this(str, str2, false);
    }

    public g9(String str, String str2, boolean z) {
        this.f5443a = b.a(str);
        this.b = b.a(str2);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Throwable th) {
            m.b(this.f5443a, String.format(ijiami_1011.s.s.s.d(new byte[]{56, 4, Ascii.DC4, 69, 73, 55, 9, Ascii.SYN, 9, Ascii.NAK, 80, 7, 14, 4, 34, 87, 17, 4, 9, 16, 52, Ascii.ETB, 95, 11, 3, 3, 13, 83, 68, 14, 4, Ascii.ETB, Ascii.NAK, 3, 86, 0, 88, 65, 68, 69}, "baa6dc"), this.b), th);
        }
    }
}
