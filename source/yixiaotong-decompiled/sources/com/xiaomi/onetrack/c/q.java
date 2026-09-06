package com.xiaomi.onetrack.c;

import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f9478a;
    public final /* synthetic */ p b;

    public q(p pVar, boolean z) {
        this.b = pVar;
        this.f9478a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a();
        try {
            if (this.f9478a) {
                int[] iArr = {0, 1, 2};
                for (int i = 0; i < 3; i++) {
                    int i2 = iArr[i];
                    int iA = com.xiaomi.onetrack.b.n.a(i2);
                    if (!this.b.hasMessages(i2)) {
                        this.b.sendEmptyMessageDelayed(i2, iA);
                    }
                }
            }
        } catch (Exception e) {
            com.xiaomi.onetrack.util.p.a(ijiami_1011.s.s.s.d(new byte[]{101, Ascii.DC4, 15, 13, 84, 5, 53, 13, 11, 7, 67}, "0dcb5a"), ijiami_1011.s.s.s.d(new byte[]{89, 84, 69, 103, 6, 87, 4, 13, 16, 7, 67, 69, 82, 67, 67, 90, 17, 14, 65}, "7115c4") + e);
        }
    }
}
