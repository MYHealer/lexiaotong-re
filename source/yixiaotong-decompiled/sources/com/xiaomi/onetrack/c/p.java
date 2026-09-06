package com.xiaomi.onetrack.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class p extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9477a = ijiami_1011.s.s.s.d(new byte[]{100, 72, 89, 95, 88, 85, 53, 13, 11, 7, 67}, "185091");
    private static final int b = 5000;
    private static final int c = 15000;
    private static final int d = 1200000;
    private final int e;
    private final int f;
    private final int g;
    private int h;
    private AtomicBoolean i;

    public p(Looper looper) {
        super(looper);
        this.e = 1000;
        this.f = 10000;
        this.g = d;
        this.h = 10000;
        this.i = new AtomicBoolean(false);
    }

    private void a(int i, long j) {
        removeMessages(i);
        com.xiaomi.onetrack.util.p.a(f9477a, ijiami_1011.s.s.s.d(new byte[]{71, 15, 8, 91, 17, 73, 14, Ascii.ETB, Ascii.DC2, 66, 92, Ascii.SYN, 87, 74, 68, 71, 67, 80, 14, 89}, "0fd719") + i + ijiami_1011.s.s.s.d(new byte[]{Ascii.GS, 16, 83, 1, 94, 5, Ascii.CAN, 89}, "107d2d") + j);
        sendEmptyMessageDelayed(i, j);
    }

    private void b() {
        if (s.a().a(2)) {
            this.h = 10000;
            com.xiaomi.onetrack.util.p.a(f9477a, ijiami_1011.s.s.s.d(new byte[]{74, 80, 76, 68, 72, 19, Ascii.DC2, 17, 5, 1, 84, Ascii.SYN, 75}, "858613"));
            return;
        }
        removeMessages(1000);
        int i = this.h * 2;
        this.h = i;
        if (i > d) {
            this.h = d;
        }
        com.xiaomi.onetrack.util.p.a(f9477a, ijiami_1011.s.s.s.d(new byte[]{19, 81, 93, 8, 67, SignedBytes.MAX_POWER_OF_TWO, 4, Ascii.ETB, Ascii.DC2, 3, 67, 17, 68, 74, 84, 16, 17, 75, 65, 9, Ascii.NAK, 5, 17, 4, 2, 76, 84, Ascii.SYN, 67}, "d81dc2") + this.h);
        sendEmptyMessageDelayed(1000, this.h);
    }

    public void a() {
        com.xiaomi.onetrack.util.i.a(new r(this));
    }

    public void a(int i, boolean z) {
        if (hasMessages(1000)) {
            com.xiaomi.onetrack.util.p.a(f9477a, ijiami_1011.s.s.s.d(new byte[]{11, 86, 19, 74, 6, 68, 19, Ascii.GS, 70, 15, 94, 1, 7, Ascii.DC4, 19, 74, 6, 68, Ascii.DC4, Ascii.SYN, 8, 78, 17, Ascii.NAK, 16, 81, 92, 5}, "b838c0") + i);
            return;
        }
        if (z) {
            removeMessages(i);
        }
        if (hasMessages(i)) {
            return;
        }
        long jA = z ? 0L : com.xiaomi.onetrack.b.n.a(i);
        com.xiaomi.onetrack.util.p.a(f9477a, ijiami_1011.s.s.s.d(new byte[]{78, 89, 8, 9, 67, 6, 9, 1, 5, 9, 17, Ascii.NAK, 75, 89, 11, 88}, "90dece") + i + ijiami_1011.s.s.s.d(new byte[]{Ascii.US, 69, 5, 84, 85, 82, Ascii.CAN, 89}, "3ea193") + jA);
        a(i, jA);
    }

    public void a(boolean z) {
        a.a(new q(this, z));
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Throwable {
        super.handleMessage(message);
        if (!com.xiaomi.onetrack.b.n.a() || !com.xiaomi.onetrack.g.c.a() || com.xiaomi.onetrack.b.n.b()) {
            com.xiaomi.onetrack.util.p.a(f9477a, ijiami_1011.s.s.s.d(new byte[]{-44, -115, -66, -122, -9, -99, -124, -64, -30, -123, -95, -29, -42, -125, -69, -121, -30, -102, 77, 68, 7, Ascii.DC4, 80, 12, 92, 84, 81, 13, 6, 8}, "053ac5") + com.xiaomi.onetrack.b.n.a() + ijiami_1011.s.s.s.d(new byte[]{Ascii.RS, Ascii.CAN, -47, -6, -100, -47, -15, -62, -128, -2, -72, -126, -113, -87, 10}, "287b34") + com.xiaomi.onetrack.g.c.a() + ijiami_1011.s.s.s.d(new byte[]{Ascii.CAN, Ascii.DC2, -45, -92, -121, -125, -20, -54, -125, -40, -94, -125, -84, -99, -48, -95, -111, -127, -39, -34, -127, -53, -117, 88}, "42517e") + com.xiaomi.onetrack.b.n.b());
            return;
        }
        int i = message.what;
        if (i == 1000) {
            b();
            return;
        }
        boolean zA = s.a().a(i);
        String str = ijiami_1011.s.s.s.d(new byte[]{91, 3, 92, 85, 10, 82, 34, 12, 3, 1, 90, 48, 67, 14, 93, 80, 2, Ascii.ETB, 19, 1, Ascii.DC2, 95}, "3b21f7") + zA + ijiami_1011.s.s.s.d(new byte[]{79, 17, 66, 17, 93, 93, 92}, "c12c42") + i;
        String str2 = f9477a;
        com.xiaomi.onetrack.util.p.a(str2, str);
        if (zA) {
            return;
        }
        com.xiaomi.onetrack.util.p.a(str2, ijiami_1011.s.s.s.d(new byte[]{90, 83, 87, 83, 15, 83, 34, 12, 3, 1, 90, 48, 66, 94, 86, 86, 7, Ascii.SYN, 7, 5, 15, 14, 84, 1, Ascii.RS, Ascii.DC2, 78, 94, 15, 90, 65, 7, 14, 7, 82, 14, Ascii.DC2, 91, 95, Ascii.ETB, 13, 83, 4, 0, 70, Ascii.SYN, 94, 69, 65, 87, 87, 83, 67, 68, 4, 16, Ascii.DC4, Ascii.ESC, 17, 8, 65, 85}, "2297c6"));
        if (hasMessages(1000)) {
            return;
        }
        sendEmptyMessageDelayed(1000, this.h);
        com.xiaomi.onetrack.util.p.a(str2, ijiami_1011.s.s.s.d(new byte[]{7, 12, 70, 87, Ascii.DC4, 65, 4, 16, Ascii.DC4, Ascii.ESC, 17, 17, 8, 8, 81, SignedBytes.MAX_POWER_OF_TWO, Ascii.DC4, 82, 7, 16, 3, 16, 17}, "ae4243") + this.h);
    }
}
