package com.miui.zeus.mimo.sdk;

import android.util.Log;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class u9 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5638a;
    public String b;

    public u9(String str, String str2) {
        this(str, str2, false);
    }

    public u9(String str, String str2, boolean z) {
        this.f5638a = str == null ? "" : str;
        this.b = str2 == null ? "" : str2;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        try {
            a();
        } catch (Throwable th) {
            Log.e(q9.a(this.f5638a), String.format(ijiami_1011.s.s.s.d(new byte[]{116, 117, Ascii.DC4, 100, 90, Ascii.DC4, 14, 19, 7, 0, 93, 0, 118, 80, 76, 87, 90, Ascii.DC2, 51, 17, 8, 12, 80, 7, 89, 84, Ascii.EM, 93, 87, Ascii.NAK, Ascii.DC2, 5, 1, 7, 11, 69, 16, 66}, "51902f"), this.b), th);
        }
    }
}
