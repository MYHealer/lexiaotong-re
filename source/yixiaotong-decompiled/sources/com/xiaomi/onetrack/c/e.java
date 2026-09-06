package com.xiaomi.onetrack.c;

import android.content.Intent;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f9466a;
    public final /* synthetic */ d b;

    public e(d dVar, Intent intent) {
        this.b = dVar;
        this.f9466a = intent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String action = this.f9466a.getAction();
        if (action.equals(ijiami_1011.s.s.s.d(new byte[]{2, 15, 0, 70, 14, 81, 5, 74, 15, 12, 69, 0, 13, Ascii.NAK, 74, 85, 2, 76, 8, 11, 8, 76, 98, 38, 49, 36, 33, 122, 62, 119, 39, 34}, "cad4a8")) || action.equals(ijiami_1011.s.s.s.d(new byte[]{4, 93, 86, 74, 89, 11, 5, 74, 15, 12, 69, 0, 11, 71, Ascii.FS, 89, 85, Ascii.SYN, 8, 11, 8, 76, 98, 38, 55, 118, 119, 118, 105, 45, 47}, "e3286b"))) {
            com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{114, Ascii.ETB, 93, 94, 67, 46, 0, 10, 7, 5, 84, Ascii.ETB}, "7a807c"), ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 81, 16, 80, 84, 89, 65, 11, 8, 77, 94, 3, 2}, "d2b517"));
            s.a().a(action.equals(ijiami_1011.s.s.s.d(new byte[]{0, 88, 5, 71, 87, 11, 5, 74, 15, 12, 69, 0, 15, 66, 79, 84, 91, Ascii.SYN, 8, 11, 8, 76, 98, 38, 51, 115, 36, 123, 103, 45, 47}, "a6a58b")) ? 0 : 2, false);
            com.xiaomi.onetrack.a.c.b.a().b();
        }
    }
}
